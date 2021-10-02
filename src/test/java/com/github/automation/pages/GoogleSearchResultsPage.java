package com.github.automation.pages;

import com.github.automation.util.SeleniumUtility;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleSearchResultsPage extends SeleniumUtility {

    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> GoogleSearch_Results;

    public void getFirstGoogleSearchResult() {
        Assert.assertTrue("Couldn't fetch results", GoogleSearch_Results.size() > 0);
        System.out.println(GoogleSearch_Results.get(0).getText());
    }

}
