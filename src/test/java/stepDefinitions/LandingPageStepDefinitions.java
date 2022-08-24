package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    public String productName;
    public TestContextSetup testContextSetup;
    public LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
    }

    @When("user searches with shortname {string} and extract actual name of product")
    public void user_searches_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage.searchItem(shortName);

        Thread.sleep(1000L);

        productName = landingPage.getProductName();

        testContextSetup.productName = productName;
    }

    @And("adds {int} items of the selected product to cart")
    public void addsItemsOfTheSelectedProductToCart(int quantity) {
        landingPage.incrementQuantity(quantity);
        landingPage.addToCart();
    }
}
