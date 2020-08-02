package com.yahoofinance.api.response.market

import com.yahoofinance.api.response.Response
import io.qameta.allure.Step
import io.restassured.response.ValidatableResponse

class TrendingTickersResponse extends Response {
    TrendingTickersResponse(ValidatableResponse validatableResponse) {
        super(ValidatableResponse)
    }

    @Step("Verify ticker trending-Schema")
    def validateTickerTrendingResponseSchema() {
        def pathToResponseSchema =
                "src/main/resources/schemas/v2/shipments/shipment.json" as File
        this.verifySchema(pathToResponseSchema)
        this
    }
}
