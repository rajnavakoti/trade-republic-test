package com.yahoofinance.api.basic

import com.yahoofinance.utils.configuration.Config
import io.restassured.response.ValidatableResponse

import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given

class Get {
    static ValidatableResponse makeRequest(String url, String apikey = Config.getApiKey()) {
        println("URL")
        println(url)
        return given()
                .header("API-KEY", apikey)
                .header("Content-Type", "application/json")
                .when()
                .get(url)
                .then()
    }


    static ValidatableResponse makeRequestwParam(String url, String param, String paramValue, String apikey = Config.getApiKey()) {
        return given()
                .header("API-KEY", apikey)
                .header("Content-Type", "application/json")
                .param(param, paramValue)
                .when()
                .get(url)
                .then()
    }
}
