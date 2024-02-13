package com.Cosmoslots.testData;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class softwareTestingMaterial {

	@Test
	public void highlighterElement() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("window-size=1920,1080");
        options.addArguments("-incognito");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//span[text()='Next']"));
		// Call the highlighterMethod and pass webdriver and WebElement which you want
		// to highlight as arguments.
		highLighterMethod(driver, ele);
		ele.click();
		//ele.sendKeys("SoftwareTestingMaterial.com");
	}

	// Creating a custom function
	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}
}
