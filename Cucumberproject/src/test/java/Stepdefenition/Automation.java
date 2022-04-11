package Stepdefenition;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



@RunWith(Cucumber.class)
public class Automation {
public static WebDriver driver;
@Given("^GO to the Google search page and open$")
public void go_to_the_google_search_page_and_open() throws Throwable {
System.out.println("step2");
// WebDriver driver=new ChromeDriver();
System.setProperty("webdriver.chrome.driver","C:\\Users\\bhavan.kelam\\chromedriver.exe");
driver=new ChromeDriver();
driver.get("https://www.google.com");
driver.get("https://www.github.com");
}

public static WebElement p;
@When("^Search \"([^\"]*)\" and open$")
public void search_something_and_open(String strArg1) throws Throwable {
p=driver.findElement(By.name("q"));
p.sendKeys("react");
p.submit();
driver.findElement(By.linkText("Advanced search")).click();
WebElement Lan=driver.findElement(By.id("search_language"));

Select dropdown=new Select(Lan);
dropdown.selectByValue("JavaScript");
driver.findElement(By.id("search_stars")).sendKeys(">45");
driver.findElement(By.id("search_followers")).sendKeys(">50");
WebElement lic=driver.findElement(By.id("search_license"));

Select license=new Select(lic);
license.selectByVisibleText("Boost Software License 1.0");
driver.findElement(By.className("btn")).click();
String actualTest=driver.findElement(By.xpath("//div[@class='d-flex flex-column flex-md-row flex-justify-between border-bottom pb-3 position-relative']")).getText();


Assert.assertEquals(actualTest, "1 repository result");
String actualRepository=driver.findElement(By.cssSelector("a[class='v-align-middle']")).getText();
Assert.assertEquals(actualRepository, "mvoloskov/decider");

driver.findElement(By.xpath("//a[@class='v-align-middle']")).click();

WebElement readmeDriver = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
String expectedText = readmeDriver.getText();
//Printing the first 300 characters
System.out.println(expectedText.substring(0, 300));
throw new PendingException();
}


@Then("^start with \"([^\"]*)\"$")
public void start_with_something(String strArg1) throws Throwable {
throw new PendingException();
}



}
