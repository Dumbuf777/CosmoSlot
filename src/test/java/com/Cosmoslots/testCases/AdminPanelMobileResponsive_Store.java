/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */

public class AdminPanelMobileResponsive_Store extends BaseClass {
	
	
	
	@DataProvider(parallel = true)
	public Object[][] mobileEmulations() {
		return new Object[][] { 
			//{ "iPad Air" },
		//	{ "Galaxy S8" },
			{ "iPhone 12 Pro" }
			};
	}

	@Test(dataProvider = "mobileEmulations")
	public void TC_AdminPanel_ValidateMobileResponsive(String emulation) throws InterruptedException, IOException {
		
		String[] StoreDashboard = {"Profile", "Store Packages", "Custom Packages", "Games", "Store Bonus",
				"Store Coupon", "Withdraw Settings", "App Settings", "Website Setting", "Store Settings","Corporation Details" };


		test = extentCreateTest("Admin Panel Mobile Responsive " + emulation);

		MutableCapabilities capabilities = new MutableCapabilities();
		Map<String, String> deviceMobileEmu = new HashMap<String, String>();
		deviceMobileEmu.put("deviceName", emulation);
		//ChromeOptions chromeOpt = new ChromeOptions();
		EdgeOptions options = new  EdgeOptions() ;
		options.setCapability("mobileEmulation", deviceMobileEmu);
		options.setCapability("deviceOrientation", "landscape");
		WebDriver driver = new EdgeDriver(options);
		Actions ac = new Actions(driver);
		
		//driver.manage().window().maximize();
		driver.get(AdminURL);
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button//span[text()='Login']")).click();
		test.pass("Successfully viewd Logged in admin",extentScreenshot());
		Thread.sleep(10000);
		

		
		//Store Management
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@routerlink='/lobby']")).click();   
		Thread.sleep(4000);
		test.pass("Successfully viewd  store accounts");
		driver.findElement(By.xpath("(//a[@title=\"View\"])[1]")).click();
		Thread.sleep(2000);
//		for (int i = 0; i < StoreDashboard.length; i++) {
//			driver.findElement(By.xpath("//div[contains(text(),'"+StoreDashboard+"')]")).click();
//			Thread.sleep(1000);
//		}

		//driver.findElement(By.xpath("//div[contains(text(),'Profile')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Profile')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Store Packages')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Store Packages')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Custom Packages')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Custom Packages')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Games')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Games')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Store Bonus')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Store Bonus')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Store Coupon')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Store Coupon')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Withdraw Settings')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Withdraw Settings')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'App Settings')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'App Settings')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Website Setting')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Website Setting')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Store Settings')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Store Settings')]"))).click().perform();
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//div[contains(text(),'Corporation Details')]")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Corporation Details')]"))).click().perform();
		Thread.sleep(1000);
		
		
		
		
		driver.close();

	}
	
	
	
}
