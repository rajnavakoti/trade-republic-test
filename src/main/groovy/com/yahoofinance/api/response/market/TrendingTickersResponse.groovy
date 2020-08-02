package com.yahoofinance.api.response.market


import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse

class TrendingTickersResponse extends Response {
    TrendingTickersResponse(ValidatableResponse validatableResponse) {
        super(validatableResponse)
    }

    @Step("Verify ticker trending-Schema")
    def validateTickerTrendingResponseSchema() {
        def pathToResponseSchema =
                "src/main/resources/schemas/v1/market/trendingTickers.json" as File
        this.verifySchema(pathToResponseSchema)
        this
    }
}
