package com.yahoofinance.api.request.v1.market

import com.yahoofinance.EndPoints
import com.yahoofinance.api.basic.Get
import com.yahoofinance.api.response.market.TrendingTickersResponse
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse

class TrendingTickersGetRequest {
    static ValidatableResponse getResponse
    static int countOfTrendingTickers
    static listOfTrendingSymbols =[]

    @Step("Get trending tickets by region")
    static def byRegion(String region) {
        println(EndPoints.EP_TRENDING_TICKERS)
        new TrendingTickersResponse(Get
                .makeRequestwParam(EndPoints.EP_TRENDING_TICKERS,
                        "region", region)
        )
    }

    @Step("Get top 20 trending tickers")
    static List byRegionGetTopTrending(String region){
        getResponse = Get
                .makeRequestwParam(EndPoints.EP_TRENDING_TICKERS,
                        "region", region)

        countOfTrendingTickers = getResponse.extract().response().path("finance.result[0].count").toString().toInteger()
        for(i in 0..(countOfTrendingTickers-1)){
            listOfTrendingSymbols.add(getResponse.extract().response().path("finance.result[0].quotes["+i+"].symbol").toString())
        }
        return listOfTrendingSymbols
    }
}
