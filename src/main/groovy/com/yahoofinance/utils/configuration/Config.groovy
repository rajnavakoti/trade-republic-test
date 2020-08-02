package com.yahoofinance.utils.configuration

import static PropertiesReader.getKey

class Config {

    static getEnvironment() {
        return getKey("environment")
    }

    static String getApiKey() {
        getKey("YahooFinanaceAPIKey", getEnvironment())
    }

    static String getApiHost() {
        getKey("YahooFinanaceAPIHost", getEnvironment())
    }

    static getYahooFinanaceApiURL() {
        if (getEnvironment().equals('prod') || getEnvironment().equals('production'))
            getKey("YahooFinanaceApiUrl", getEnvironment())
    }

    static getBrowser() {
        return getKey("browser")
    }

    static getHeadless() {
        return getKey("headless")
    }

    static getBrowserWidth() {
        return getKey("browserWidth")
    }

    static getBrowserLength() {
        return getKey("browserLength")
    }

    static getFailScreenshotsPath() {
        return getKey("FailScreenShotPath")
    }

    static boolean isJenkins() {
        return getKey("executionEnvironment") == 'jenkins'
    }
}
