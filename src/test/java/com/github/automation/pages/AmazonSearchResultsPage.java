package com.github.automation.pages;

import com.github.automation.util.SeleniumUtility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonSearchResultsPage extends SeleniumUtility {

    @FindBy(xpath = "//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']")
    private List<WebElement> AmazonSearchResults_ProductName;

    static AmazonSearchResultsPage instance = null;

    public static AmazonSearchResultsPage getInstance() {

        if (instance == null) {
            instance = new AmazonSearchResultsPage();
        }
        return instance;

    }

    public void getFirstAmazonSearchResult() {
        Assert.assertTrue("Couldn't fetch results", AmazonSearchResults_ProductName.size() > 0);
        System.out.println(AmazonSearchResults_ProductName.get(0).getText());
    }

}
