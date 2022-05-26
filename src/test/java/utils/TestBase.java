package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public WebDriver driver;


    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAURL");

        if(driver == null){
            if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
                driver = new ChromeDriver();
            }
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        }
        return driver;
    }
}
