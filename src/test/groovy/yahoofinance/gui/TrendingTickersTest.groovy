package yahoofinance.gui

import com.yahoofinance.gui.BaseTest
import com.yahoofinance.gui.HomePage
import com.yahoofinance.gui.TrendingTickersPage
import com.yahoofinance.utils.Groups
import io.qameta.allure.Story
import org.openqa.selenium.WebDriver
import org.testng.annotations.Test

class TrendingTickersTest extends BaseTest {

    HomePage homePage
    TrendingTickersPage trendingTickersPage
    WebDriver driver

    @Story("check if the top trending tickers dashboard is displayed on yahoo finance page")
    @Test(groups = Groups.gui)
    void trendingTickersDashboardTest() {
        homePage = new HomePage(super.getDriver())
        homePage.visitHomePage()
        homePage.acceptPopupMessage()
        trendingTickersPage = homePage.clickTrendingTickersLink()
        trendingTickersPage.assertTrendingTrackerDashboardAccessibility()
    }
}
