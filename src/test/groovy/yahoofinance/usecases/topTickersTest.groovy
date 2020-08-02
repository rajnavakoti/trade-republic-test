package yahoofinance.usecases

import com.yahoofinance.api.request.v1.market.TrendingTickersGetRequest
import com.yahoofinance.gui.BaseTest
import com.yahoofinance.gui.HomePage
import com.yahoofinance.gui.TrendingTickersPage
import com.yahoofinance.utils.Groups
import io.qameta.allure.Story
import org.openqa.selenium.WebDriver
import org.testng.annotations.Test

class topTickersTest extends BaseTest {
    HomePage homePage
    TrendingTickersPage trendingTickersPage
    WebDriver driver

    @Story("Verify the API response of trending tickers matches with dashboard details displayed on the webpage")
    @Test(groups = Groups.monitoring)
    void verifyTrendingTickersAreDisplayedOnDashboard() {
//        Fetching top trending tickers using API
        List trendingListFromAPI= TrendingTickersGetRequest
                .byRegionGetTopTrending("US")
//        Visit yahoo finance webpage and navigate to trending tickers dashboard
        homePage = new HomePage(super.getDriver())
        homePage.visitHomePage()
        homePage.acceptPopupMessage()
        trendingTickersPage = homePage.clickTrendingTickersLink()
//        Fetch top trending tickers form tickers dashboard
        List trendingListFromAPP = trendingTickersPage.getTopTrendingTickerFromDashboard()
//        Compare API and UI results
        trendingTickersPage.assertMatchApiAndAppData(trendingListFromAPI,trendingListFromAPP)
    }
}
