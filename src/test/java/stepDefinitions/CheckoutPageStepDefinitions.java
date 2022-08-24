package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

    public String productName;
    public TestContextSetup testContextSetup;
    public LandingPage landingPage;
    public CheckoutPage checkoutPage;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("proceeds to checkout and validate the {string} items in checkout page")
    public void proceedsToCheckoutAndValidateTheItemsInCheckoutPage(String name) {
        checkoutPage.CheckoutItems();
        //assert to extract name from screen and compare with name
    }

    @And("verify if user has ability to enter promo code and place order")
    public void verifyIfUserHasAbilityToEnterPromoCodeAndPlaceOrder() {
        Assert.assertTrue(checkoutPage.VerifyPromoBtn());
        Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
    }
}
