package com.github.automation.drivers;

import com.github.automation.util.ApplicationProperties;
import org.openqa.selenium.WebDriver;

public class WebDrivers {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    ChromeWebDriver chromeWebDriver = new ChromeWebDriver();
    FirefoxWebDriver firefoxWebDriver = new FirefoxWebDriver();
    IEWebDriver ieWebDriver = new IEWebDriver();
    ApplicationProperties applicationProperties;

    public WebDriver createAndGetDriver() {

        if(driver.get() != null) {
            return driver.get();
        }

        applicationProperties = ApplicationProperties.getInstance();
        String browserName = applicationProperties.getPropertyValue("BROWSER_NAME");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver.set(chromeWebDriver.initializeAndGetChromeDriver());
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver.set(firefoxWebDriver.initializeAndGetFirefoxDriver());
        } else {
            driver.set(ieWebDriver.initializeAndGetInternetExplorerDriver());
        }
        return driver.get();

    }

    public void quitDriver() {
        driver.get().quit();
    }
}
