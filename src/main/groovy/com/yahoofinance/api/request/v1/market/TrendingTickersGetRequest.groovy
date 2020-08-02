package com.yahoofinance.api.request.v1.market

import com.yahoofinance.EndPoints
import com.yahoofinance.api.basic.Get
import com.yahoofinance.api.response.market.TrendingTickersResponse
import io.qameta.allure.Step

class TrendingTickersGetRequest {
    @Step("Get trending tickets by region")
    static def byRegion(String region) {
        println(EndPoints.EP_TRENDING_TICKERS)
        new TrendingTickersResponse(Get
                .makeRequestwParam(EndPoints.EP_TRENDING_TICKERS,
                        "region", region)
        )
    }
}
