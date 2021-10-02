package com.github.automation.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class IEWebDriver {

    WebDriver driver;

    public WebDriver initializeAndGetInternetExplorerDriver() {
        try {
            System.setProperty("webdriver.ie.driver", (new File(System.getProperty("user.dir") + "/src/test/resources/drivers/IEDriverServer.exe").getCanonicalPath()));

            InternetExplorerOptions iopt = new InternetExplorerOptions(); //Added internet options as the capabilities is deprecated ~ Sandeep T 11/5/17
            iopt.setCapability("ignoreProtectedModeSettings", true);
            iopt.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            iopt.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true); //Help to resolve the slowness in entering or sending keys on any text fields
            iopt.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //iopt.requireWindowFocus();
            DesiredCapabilities capab = DesiredCapabilities.internetExplorer();

            //Code for suppressing and updating the registry entry with popup blocker set to false
            String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";
            try {
                Runtime.getRuntime().exec(cmd);
            } catch (Exception e) {
//                log.error("Error ocured!");
            }

            driver = new InternetExplorerDriver(iopt);

//            log.info("Platform for URL: " + capab.getBrowserName());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
