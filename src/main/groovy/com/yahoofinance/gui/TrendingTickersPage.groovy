package com.yahoofinance.gui

import io.qameta.allure.Step
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert

class TrendingTickersPage {

    WebDriver driver
    static dashboardTrendingTickersList = []

    By dashboardLocator = By.xpath("//*[@id='Lead-4-YFinListTable-Proxy']")
    WebElement trendingTickersTable = driver.findElement(By.xpath("//section[@id='yfin-list']/div[2]/div/div/table/tbody"))
    By tableRows = By.xpath("//section[@id='yfin-list']/div[2]/div/div/table/tbody/tr")
    By tableColumns = By.xpath("//section[@id='yfin-list']/div[2]/div/div/table/tbody/tr/td")

    TrendingTickersPage(WebDriver driver){
        this.driver = driver
    }

    @Step("check the trending tickers dashboard is displayed for the user")
    void assertTrendingTrackerDashboardAccessibility(){
        Assert.assertTrue(driver.findElement(dashboardLocator).displayed)
    }

    @Step("check the trending tickers dashboard is displayed for the user")
    List getTopTrendingTickerFromDashboard(){
        List<WebElement> rows = driver.findElements(tableRows)
        for (WebElement row : rows){
//            dashboardTrendingTickersList.add(driver.findElement(tableColumns).getText())
            dashboardTrendingTickersList.add(row.findElement(By.tagName("td")).getText())
        }
        return dashboardTrendingTickersList.subList(0,20)
    }

    static void assertMatchApiAndAppData(List fromApi, List fromApp){
        for(int i in 0..(fromApi.size()-1)){
            Assert.assertEquals(fromApi.get(i).toString(),fromApp.get(i).toString())
        }
    }
}
