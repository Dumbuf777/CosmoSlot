package com.Cosmoslots.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.util.List;

public class extentionDemo {
	public static void main(String[] args) throws InterruptedException {
	//	System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
      WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		// set path of .crx file of extension
		opt.addExtensions(new File("D:\\buster.crx"));
		opt.addArguments("--disable-notifications");
		opt.addArguments("--maximize");
		DesiredCapabilities c = DesiredCapabilities.chrome();

		c.setCapability(ChromeOptions.CAPABILITY, opt);

		@SuppressWarnings("deprecation")
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://cosmoslots.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[normalize-space()='Remember Me']//following::iframe[@title='reCAPTCHA']")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//iframe[@title="recaptcha challenge expires in
		// two minutes"])[last()]")).click();
		// driver.findElement(By.xpath("//*[@id=\"rc-imageselect\"]/div[3]/div[2]/div[1]/div[1]/div[4]")).click();
		if (driver.findElements(By.xpath("//iframe[@title='recaptcha challenge expires in two minutes']")).size() > 0) {
//    	 int size = driver.findElements(By.tagName("iframe")).size();
//    	 System.out.println(size);
//    	 List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
//    	 System.out.println("Total number of iframes are " + iframeElements.size());
//
//    	 By executing a java script
//    	 JavascriptExecutor exe = (JavascriptExecutor) driver;
//    	 Integer noOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
//    	 System.out.println("No. of iframes on the page are " + noOfFrames);
//    	 driver.switchTo().frame(7);
//    	 Thread.sleep(2000);
//    	 driver.findElement(By.xpath("//button[@title=\"Solve the challenge\"]")).click();
//    	 
			WebElement frm = driver.findElement(By.xpath("(//iframe[@title='recaptcha challenge expires in two minutes'])[2]"));
			driver.switchTo().frame(frm)	;		
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).perform();
			WebElement attachedElement2 = driver.findElement(By.xpath("//div[contains(@class,'help-button-holder')]"));
			WebElement shadowRoot2 = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", attachedElement2);
			act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
//    	 Actions action = new Actions(driver);
//    	 WebElement we = driver.findElement(By.cssSelector("#document"));
//    	 action.moveToElement(we).moveToElement(driver.findElement(By.xpath("//button[@title=\"Solve the challenge\"]"))).click().build().perform();
			// driver.findElement(By.xpath("//div[@class='button-holder
			// help-button-holder']")).click();
			Thread.sleep(5000);
			driver.close();
		}

		// click on buster button
//      WebElement buttonHolderElement = driver.findElement(By.xpath("//*[@id=\"rc-imageselect\"]/div[3]/div[2]/div[1]/div[1]/div[4]"));
//      Actions actionProvider = new Actions(driver);
//      actionProvider.moveToElement(buttonHolderElement).click().build().perform();

	}
}