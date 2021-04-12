package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UIDriver {

    private static WebDriver driver = null;

    @Before("@FrontendTest")
    public void setup() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectPath+"/Driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After("@FrontendTest")
    public void teardown(Scenario scenario) {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
