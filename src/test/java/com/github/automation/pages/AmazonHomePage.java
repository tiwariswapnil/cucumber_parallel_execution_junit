package com.github.automation.pages;

import com.github.automation.util.SeleniumUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends SeleniumUtility {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement AmazonSearch;
    @FindBy(xpath = "//input[@value='Go']")
    private WebElement AmazonSearchBtn;

    public void launchUrl(String url) {
        driver.get(url);
    }

    public void searchProductsOnAmazon(String productName) {

        AmazonSearch.sendKeys(productName);
        AmazonSearchBtn.click();
    }


}
