//environment Variables
executionEnvironment = System.getenv("ENV_EXECUTION") ?: "local"
environment = System.getenv("TEST_ENVIRONMENT") ?: "prod"
isdevelopbackend = System.getenv("DEVELOP_BACKEND") ?: false
timeout = System.getenv("TIMEOUT") ?: "30000"
branch = System.getenv("TEST_ENVIRONMENT") ?: environment

//BrowserSetup
browser = System.getenv("BROWSER") ?: "chrome"
headless = System.getenv("HEADLESS") ?: true
browserWidth = System.getenv("browser_width") ?: 1920
browserLength = System.getenv("browser_width") ?: 1080

//Failure Screenshots path
FailScreenShotPath = System.getenv("Fail_Screenshot_Path") ?: "screenshots//"

environments {
    prod {
        YahooFinanaceAppUrl = "https://finance.yahoo.com/trending-tickers"
        YahooFinanaceApiUrl = "https://apidojo-yahoo-finance-v1.p.rapidapi.com"
        YahooFinanaceAPIKey = "51346c5577msh8ac38b35b55c66fp1390c9jsnf499b4c5e970"
        YahooFinanaceAPIHost = "apidojo-yahoo-finance-v1.p.rapidapi.com"
    }
}
