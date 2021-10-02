package com.github.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class FirefoxWebDriver {

    WebDriver driver;

    public WebDriver initializeAndGetFirefoxDriver() {
        try {
            System.setProperty("webdriver.gecko.driver", (new File(System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe").getCanonicalPath()));

            FirefoxOptions fopt = new FirefoxOptions();
            fopt.merge(DesiredCapabilities.firefox());
            FirefoxProfile profile = new FirefoxProfile();
            fopt.setCapability(FirefoxDriver.PROFILE, profile);
            fopt.setCapability("marionette", true);
            driver = new FirefoxDriver(fopt);
//            log.info("Platform for URL: " + fopt.getBrowserName());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
