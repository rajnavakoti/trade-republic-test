package yahoofinance.usecases

import com.yahoofinance.api.request.v1.market.TrendingTickersGetRequest
import com.yahoofinance.gui.BaseTest
import com.yahoofinance.gui.HomePage
import com.yahoofinance.gui.TrendingTickersPage
import com.yahoofinance.utils.Groups
import io.qameta.allure.Story
import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test

class topTickersTest extends BaseTest {
    HomePage homePage
    TrendingTickersPage trendingTickersPage
    WebDriver driver

    @Story("Get getAll shipments and validate schema")
    @Test(groups = Groups.monitoring)
    void verifyTrendingTickersAreDisplayedOnDashboard() {
        List trendingListFromAPI= TrendingTickersGetRequest
                .byRegionGetTopTrending("US")

        homePage = new HomePage(super.getDriver())
        homePage.visitHomePage()
        homePage.acceptPopupMessage()
        trendingTickersPage = homePage.clickTrendingTickersLink()

        List trendingListFromAPP = trendingTickersPage.getTopTrendingTickerFromDashboard()
        trendingTickersPage.assertMatchApiAndAppData(trendingListFromAPI,trendingListFromAPP)
    }

}
