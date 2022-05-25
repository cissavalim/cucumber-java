package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinitions {


    public String SecondProductName;
    public TestContextSetup testContextSetup;
    public PageObjectManager pageObjectManager;
    public OffersPage offersPage;
    public LandingPage landingPage;

    public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searches for {string} shortname in offers page to check if the product exists.")
    public void userSearchesForShortnameInOffersPageToCheckIfTheProductExists(String shortName) throws InterruptedException {

        switchToOffersPage();

        offersPage = testContextSetup.pageObjectManager.offersPage();
        offersPage.searchItem(shortName);
        Thread.sleep(2000);
        SecondProductName = offersPage.getProductName();
    }

    public void switchToOffersPage() throws InterruptedException {

        //if(testContextSetup.driver.getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers"))

        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.selectTopDealsPage();
        testContextSetup.genericUtils.SwitchWindowToChild();
        Thread.sleep(1000);
    }

    @And("validate if products match.")
    public void validateIfProductsMatch() throws InterruptedException {
        Assert.assertEquals(SecondProductName, testContextSetup.productName);
    }
}
