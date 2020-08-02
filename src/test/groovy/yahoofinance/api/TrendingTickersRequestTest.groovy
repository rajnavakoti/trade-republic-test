package yahoofinance.api

import com.yahoofinance.api.request.v1.market.TrendingTickersGetRequest
import com.yahoofinance.utils.Groups
import io.qameta.allure.Story
import org.testng.annotations.Test

class TrendingTickersRequestTest {

    @Story("Get top trending tickers of United states and validate schema")
    @Test(groups = Groups.monitoring)
    void getTrendingTickersOfUnitedStates() {
        TrendingTickersGetRequest
                .byRegion("US")
                .validateTickerTrendingResponseSchema()
                .assertStatusCode(200)
    }

    @Story("Get top trending tickers of France and validate schema")
    @Test(groups = Groups.monitoring)
    void getTrendingTickersOfFrance() {
        TrendingTickersGetRequest
                .byRegion("FR")
                .validateTickerTrendingResponseSchema()
                .assertStatusCode(200)
    }
}
