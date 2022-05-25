package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

    public String productName;
    public TestContextSetup testContextSetup;
    public LandingPage landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("user is on GreenKart landing page")
    public void user_is_on_green_kart_landing_page() {

    }

    @When("user searches with shortname {string} and extract actual name of product")
    public void user_searches_with_shortname_and_extract_actual_name_of_product(String shortName) throws InterruptedException {

        landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.searchItem(shortName);

        Thread.sleep(1000L);

        productName = landingPage.getProductName();

        testContextSetup.productName = productName;
    }
}
