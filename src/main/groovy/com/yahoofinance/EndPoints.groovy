package com.yahoofinance

import com.yahoofinance.utils.configuration.Config

class EndPoints {

    private static String YAHOO_FINANCE_API_URL = Config.getYahooFinanaceApiURL()
    private static String YAHOO_FINANCE_APP_URL = Config.getYahooFinanaceAppURL()

    public static final String EP_TRENDING_TICKERS = YAHOO_FINANCE_API_URL + "/market/get-trending-tickers"
    public static final String YAHOO_FINANACE_HOME_PAGE = YAHOO_FINANCE_APP_URL
    public static final String TRENDING_TICKERS_PAGE = YAHOO_FINANCE_APP_URL + "/trending-tickers"
}