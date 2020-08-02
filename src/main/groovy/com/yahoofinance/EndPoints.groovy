package com.yahoofinance

import com.yahoofinance.utils.configuration.Config

class EndPoints {

    private static String YAHOO_FINANCE_API_URL = Config.getYahooFinanaceApiURL()

    public static final String EP_TRENDING_TICKERS = YAHOO_FINANCE_API_URL + "//market/get-trending-tickers"

}