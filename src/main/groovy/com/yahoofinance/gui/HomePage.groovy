package com.yahoofinance.gui

import com.yahoofinance.EndPoints
import io.qameta.allure.Step
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class HomePage {
    WebDriver driver

    By trendingTickersLink = By.xpath("//a[contains(@href,'trending-tickers')]")
    By popupAcceptButton = By.xpath("//button[contains(text(),'Ich stimme zu.')]")

    HomePage(WebDriver driver) {
        this.driver = driver
    }

    @Step("navigate to yahoo finance home page")
    HomePage visitHomePage(){
        println(EndPoints.YAHOO_FINANACE_HOME_PAGE)
        driver.get(EndPoints.YAHOO_FINANACE_HOME_PAGE)
        return new HomePage(driver)
    }

    @Step("accept the popup message displayed on the home page")
    HomePage acceptPopupMessage(){
        driver.findElement(popupAcceptButton).click()
        return new HomePage(driver)
    }

    @Step("navigate to trending tickers page by clicking link on the home page")
    TrendingTickersPage clickTrendingTickersLink(){
        driver.findElement(trendingTickersLink).click()
        return new TrendingTickersPage(driver)
    }



}
