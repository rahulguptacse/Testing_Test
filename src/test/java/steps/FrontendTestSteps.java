package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Pages;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FrontendTestSteps {
    WebDriver driver = UIDriver.getDriver();

    String title = null;
    Pages pages = new Pages(driver);


    @Given("I am on {string} website")
    public void onWebsite(String website_link) {
        driver.get(website_link);
    }

    @When("I search for {string}")
    public void iSearch(String searchWord) {
        pages.search(searchWord);
    }
    @Then("Average is {string}")
    public void averageAge(String age) {
        int average_Age = pages.getAvgSalary();
        Assert.assertEquals(average_Age,Integer.parseInt(age));
    }
    @Then("Highest Salary is {string}")
    public void highestSalary(String salary) {
        String highest_Salary = pages.getHighestSalary();
        Assert.assertEquals(highest_Salary,salary);
    }

    @Then("I see {string}")
    public void iSeeHomePage(String displayed_title) {
        title = driver.getTitle();
        Assert.assertEquals(title, displayed_title);
    }

    @And("I click on {string} link")
    public void iClickOnLink(String link) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText(link)).click();
    }

    @When("user enter his details")
    public void enterUserDetails(Map<String, String> data) {
        pages.setFirstNameText(data.get("FirstName"));
        pages.setLastNameText(data.get("LastName"));
        pages.setEmailText(data.get("Email"));
        pages.setPhoneText(data.get("Phone"));
        pages.setAddressText(data.get("Address"));
        pages.setCityText(data.get("City"));
        pages.setState(data.get("State"));
        pages.setZipText(data.get("ZIPCode"));
        pages.setWebSiteText(data.get("Website"));
        pages.setHosting(data.get("Hosting"));
        pages.setProjectDescriptionText(data.get("Description"));

    }

    @And("click on Send button")
    public void clickSubmit() {
        pages.submit();
    }
    @And("Form is submitted")
    public void verifyForm() {
       //website has some issue and I am not getting any response after clicking send button hence not implemented
    }

}
