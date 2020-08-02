package com.yahoofinance.gui

import io.github.bonigarcia.wdm.WebDriverManager
import org.apache.commons.io.FileUtils
import org.openqa.selenium.Dimension
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.testng.ITestResult
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

import java.util.concurrent.TimeUnit

import static com.yahoofinance.utils.configuration.Config.*

class BaseTest {

    WebDriver driver
    @BeforeMethod
    before() {
        if (getBrowser().toLowerCase() == "chrome") {
            if (isJenkins()) {
                println("Tests executed in jenkins")
                WebDriverManager.chromedriver().setup()
                driver = new ChromeDriver()
            }
            else {
                println("Tests executed local")
                ChromeOptions options = new ChromeOptions()
                options.headless = getHeadless().toLowerCase().toBoolean()
                WebDriverManager.chromedriver().setup()
                driver = new ChromeDriver(options)
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
            driver.manage().window().maximize()
            driver.manage().window().setSize(new Dimension(getBrowserWidth().toInteger(), getBrowserLength().toInteger()))
        }
        /*if (getBrowser().toLowerCase() == "firefox" ) {
            similar configuration as for chrome
        }*/
    }

    @AfterMethod
    after(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE){
            takeSnapShot(driver,getFailScreenshotsPath() + testResult.getName() + ".jpg")
        }
        driver.quit()
    }

    WebDriver getDriver() {
        return driver
    }

    static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)webdriver)
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE)
        File DestFile=new File(fileWithPath)
        FileUtils.copyFile(SrcFile, DestFile)
    }
}
