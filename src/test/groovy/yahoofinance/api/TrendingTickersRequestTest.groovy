package yahoofinance.api

import com.yahoofinance.api.request.v1.market.TrendingTickersGetRequest
import com.yahoofinance.utils.Groups
import io.qameta.allure.Story
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class TrendingTickersRequestTest {
    @BeforeMethod
    before() {

    }

    @Story("Get getAll shipments and validate schema")
    @Test(groups = Groups.monitoring)
    void getShipment() {
        TrendingTickersGetRequest
                .byRegion("US")
                .validateTickerTrendingResponseSchema()
                .assertStatusCode(200)
    }

    @AfterMethod
    after() {

    }
}
