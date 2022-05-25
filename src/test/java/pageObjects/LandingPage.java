package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    public WebDriver driver;
    By search = By.xpath("//input[@type = 'search']");
    By productName = By.cssSelector("h4.product-name");
    By topDeals = By.linkText("Top Deals");
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() throws InterruptedException {
        return driver.findElement(productName).getText().split("-")[0].trim();
    }

    public void selectTopDealsPage(){
        driver.findElement(topDeals).click();
    }
}
