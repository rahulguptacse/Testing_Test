package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class Pages {

    public WebDriver driver ;

    By textbox_FirstName = By.name("first_name");
    By textbox_LastName = By.name("last_name");
    By textbox_Email = By.name("email");
    By textbox_Phone = By.name("phone");
    By textbox_Address = By.name("address");
    By textbox_City = By.name("city");
    By list_State = By.name("state");
    By textbox_zip = By.name("zip");
    By textbox_Website = By.name("website");
    By radio_Hosting = By.name("hosting");
    By textbox_comments = By.name("comment");
    By submit_Button = By.xpath(("//div/button[@type='submit']"));
    By textbox_Search = By.xpath(("//input[@type='search']"));
    By webtable_Rows = By.xpath("//*[@id='example']/tbody/tr");
    By webtable_Header = By.xpath("//*[@id='example']/thead/tr/th");
    By salary_Arrow = By.xpath("//*[@id='example']/thead/tr/th");


    public Pages(WebDriver driver) {
        this.driver =driver;
    }

    public void setFirstNameText(String text){
        driver.findElement(textbox_FirstName).sendKeys(text);
    }
    public void setLastNameText(String text){
        driver.findElement(textbox_LastName).sendKeys(text);
    }
    public void setEmailText(String text){
        driver.findElement(textbox_Email).sendKeys(text);
    }
    public void setZipText(String text){
        driver.findElement(textbox_zip).sendKeys(text);
    }
    public void setPhoneText(String text){
        driver.findElement(textbox_Phone).sendKeys(text);
    }
    public void setWebSiteText(String text){
        driver.findElement(textbox_Website).sendKeys(text);
    }
    public void setCityText(String text){
        driver.findElement(textbox_City).sendKeys(text);
    }


    public void setAddressText(String text){
        driver.findElement(textbox_Address).sendKeys(text);
    }
    public void setProjectDescriptionText(String text){
        driver.findElement(textbox_comments).sendKeys(text);
    }
    public void setState(String text){
        Select se = new Select(driver.findElement(list_State));
        se.selectByVisibleText(text);
    }
    public void setHosting(String text){
        List<WebElement> listOfElements = driver.findElements(radio_Hosting);
        if(text.equalsIgnoreCase("No") )
            listOfElements.get(1).click();
        else
            listOfElements.get(0).click();
    }

    public void submit() {
        driver.findElement(submit_Button).click();
    }

    public void search(String text) {
        driver.findElement(textbox_Search).sendKeys(text);
        driver.findElement(textbox_Search).sendKeys(Keys.RETURN);
    }

    public int getAvgSalary()
    {
        int avg_Age = 0;
        List<WebElement> rows = driver.findElements(webtable_Rows);
        for (int rNum=0;rNum<rows.size();rNum++) {
            WebElement row = rows.get(rNum);
            List<WebElement> cols = row.findElements(By.tagName("td"));
                avg_Age = avg_Age + Integer.parseInt(cols.get(3).getText());
        }
        return (avg_Age/rows.size());
    }

    public String getHighestSalary()
    {
        String highest_Salary = "";
        List<WebElement> header = driver.findElements(webtable_Header);
        WebElement header_arrow = header.get(5);
        do{
            header_arrow.click();
        } while(header_arrow.getAttribute("class").equalsIgnoreCase("sorting_asc"));

        List<WebElement> rows = driver.findElements(webtable_Rows);
        WebElement row = rows.get(0);
        List<WebElement> cols = row.findElements(By.tagName("td"));
        highest_Salary = cols.get(5).getText();
        return (highest_Salary);
    }
}
