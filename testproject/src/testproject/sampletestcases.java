package testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampletestcases {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhavan.kelam\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/");
		WebElement p=driver.findElement(By.name("q"));
		p.sendKeys("react");
		p.submit();
		driver.findElement(By.linkText("Advanced search")).click();
		driver.findElement(By.id("search_language")).sendKeys("javascript");
		driver.findElement(By.id("search_stars")).sendKeys(">45");
		driver.findElement(By.id("search_license")).sendKeys("Boost Software License 1.0");
		driver.findElement(By.id("search_followers")).sendKeys(">50");
		driver.findElement(By.className("btn")).click();
		driver.findElement(By.linkText("mvoloskov/decider")).click();
		WebElement readmeDriver = driver.findElement(By.xpath("//div[@data-target='readme-toc.content']"));
		String expectedText = readmeDriver.getText();
		System.out.println(expectedText.substring(0, 300));
	}
}

