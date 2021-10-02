package com.github.automation.stepdefinitions;

import com.github.automation.pages.AmazonHomePage;
import com.github.automation.pages.AmazonSearchResultsPage;
import com.github.automation.pages.GoogleSearchHomePage;
import com.github.automation.pages.GoogleSearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {

    GoogleSearchHomePage googleSearchHomePage;
    GoogleSearchResultsPage googleSearchResultsPage;
    AmazonHomePage amazonHomePage;
    AmazonSearchResultsPage amazonSearchResultsPage;

    @Before
    public void setUp() {
        googleSearchHomePage = new GoogleSearchHomePage();
        googleSearchResultsPage = new GoogleSearchResultsPage();
        amazonHomePage = new AmazonHomePage();
        amazonSearchResultsPage = new AmazonSearchResultsPage();
    }

    @After
    public void tearDown() {

    }

    @Given("User navigates to Amazon home page")
    public void userNavigatesToAmazonHomePage() {
        amazonHomePage.launchUrl("https://www.amazon.in/");
    }

    @Given("User navigates to Google home page")
    public void userNavigatesToGoogleHomePage() {
        googleSearchHomePage.launchUrl("https://www.google.com/");
    }

    @When("User searches for {string} in Amazon")
    public void userPerformsAmazonSearch(String productName) {
        amazonHomePage.searchProductsOnAmazon(productName);
    }

    @When("User enters {string} in Google searchbox")
    public void userEntersTextInGoogleSearchBox(String searchText) {
        googleSearchHomePage.entersTextInGoogleSearch(searchText);
    }

    @And("User clicks on search button")
    public void userClicksOnSearchButton() {
        googleSearchHomePage.clickOnGoogleSearchBtn();
    }

    @Then("Retrieve the first Amazon search result")
    public void retrieveTheFirstAmazonSearchResult() {
        amazonSearchResultsPage.getFirstAmazonSearchResult();
    }

    @Then("Retrieve the first Google search result")
    public void retrieveTheFirstGoogleSearchResult() {
        googleSearchResultsPage.getFirstGoogleSearchResult();
    }

}
