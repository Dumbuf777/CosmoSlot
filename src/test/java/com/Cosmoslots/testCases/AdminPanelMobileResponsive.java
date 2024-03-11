/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */

public class AdminPanelMobileResponsive extends BaseClass {

	BaseClass bc = new BaseClass();

	String firstnm = bc.Fakefirstname();
	String lastnm = bc.Fakelastname();
	String phonenm = bc.Fakephonenumber();
	String usernm = firstnm + lastnm;
	String Email = bc.FakeEmail();

	@DataProvider(parallel = true)
	public Object[][] mobileEmulations() {
		return new Object[][] { { "iPad Air" },
				// { "Galaxy S8" },
				// { "Samsung Galaxy S20 Ultra" },
				//{ "iPhone 12 Pro" } 
			};
	}

	@Test(dataProvider = "mobileEmulations")
	public void A_TC_AdminPanel_ValidateMobileResponsive(String emulation) throws InterruptedException, IOException {

		test = extentCreateTest("Admin Panel Mobile Responsive " + emulation);

		Map<String, String> deviceMobileEmu = new HashMap<String, String>();
		deviceMobileEmu.put("deviceName", emulation);
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--disable-notifications");
		chromeOpt.setExperimentalOption("mobileEmulation", deviceMobileEmu);
		chromeOpt.setCapability("deviceOrientation", "landscape");
		WebDriver driver = new ChromeDriver(chromeOpt);
		
//		EdgeOptions options = new  EdgeOptions() ;
//		options.setCapability("mobileEmulation", deviceMobileEmu);
//		options.setCapability("deviceOrientation", "landscape");
//		WebDriver driver = new EdgeDriver(options);
		Actions act1 = new Actions(driver);

		// driver.manage().window().maximize();
		driver.get(AdminURL);
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button//span[text()='Login']")).click();
		test.pass("Successfully viewd Logged in admin");
		Thread.sleep(10000);
		captureScreen(driver, "Admin Login");
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file, new File("Screen.jpg"));

		// Player Management
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		test.pass("Successfully viewd Dasboard");
		driver.findElement(By.xpath("//a[@routerlink='/player']")).click();
		Thread.sleep(7000);
			
		if (driver.findElements(By.xpath("//h3[contains(text(),'Player Management')]")).size() > 0) {
			test.pass("Successfully viewd Player Listing");
			captureScreen(driver, "Player Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Player Listing");
			Assert.assertTrue(false);
		}

		Thread.sleep(3000);
		// driver.findElement(By.xpath("(//a[@title='View'])[1]")).click();
		act1.moveToElement(driver.findElement(By.xpath("(//a[@title='View'])[1]"))).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Profile')]")).size() > 0) {
			test.pass("Successfully viewd player Profile tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Player Profile tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Manage Tokens')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Manage Tokens')]")).size() > 0) {
			test.pass("Successfully viewd Manage Tokens tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Manage Tokens tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Token Details')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Token Details')]")).size() > 0) {
			test.pass("Successfully viewd Token Details tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Token Details tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Purchases')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Purchases')]")).size() > 0) {
			test.pass("Successfully viewd Purchases tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Purchases tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Withdraw Request')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Withdraw Request')]")).size() > 0) {
			test.pass("Successfully viewd Withdraw Request tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Withdraw Request tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Transaction History')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Token Details')]")).size() > 0) {
			test.pass("Successfully viewd Transaction History tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Transaction History tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Player Ledger')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Player Ledger')]")).size() > 0) {
			test.pass("Successfully viewd Player Ledger tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Player Ledger tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Support Request')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Support Request')]")).size() > 0) {
			test.pass("Successfully viewd Support Request tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Support Request tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Game Transactions')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Game Transactions')]")).size() > 0) {
			test.pass("Successfully viewd Game Transactions tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Game Transactions tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Applied Coupons')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Applied Coupons')]")).size() > 0) {
			test.pass("Successfully viewd Applied Coupons tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Applied Coupons tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Footprints')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Footprints')]")).size() > 0) {
			test.pass("Successfully viewd Footprints tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Footprints tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),'Customized Login Bonus')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Customized Login Bonus')]")).size() > 0) {
			test.pass("Successfully viewd Customized Login Bonus tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Customized Login Bonus tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//button[contains(text(),' Exclusive Analytics')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//button[contains(text(),'Exclusive Analytics')]")).size() > 0) {
			test.pass("Successfully viewd Exclusive Analytics tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Exclusive Analytics tab");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/guest-player']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Guest Players')]")).size() > 0) {
			test.pass("Successfully viewd Guest Players Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Guest Players Listing");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/payment/withdraw']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Withdraw Requests')]")).size() > 0) {
			test.pass("Successfully viewd Withdraw Requests Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Withdraw Requests Listing");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/payment']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[text()='Purchase History']")).size() > 0) {
			test.pass("Successfully viewd Purchase History Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Purchase History Listing");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/payment/jackpotwins']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Jackpot Wins')]")).size() > 0) {
			test.pass("Successfully viewd Jackpot Wins Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Jackpot Wins Listing");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/player-deletion-history']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Player Deletion History')]")).size() > 0) {
			test.pass("Successfully viewd Jackpot Wins Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Player Deletion History");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/prospective-players']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Prospective Players')]")).size() > 0) {
			test.pass("Successfully viewd Prospective Players Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Prospective Players Listing");
			Assert.assertTrue(false);
		}

		// Player blocked list
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/blocked-list/']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Blocked Player Data')]")).size() > 0) {
			test.pass("Successfully viewd Blocked Player Data page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Blocked Player Data page");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/blocked-list/by-ip']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Blocked IP List')]")).size() > 0) {
			test.pass("Successfully viewd Blocked IP List");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Blocked IP List");
			Assert.assertTrue(false);
		}

		// Store Management
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/lobby']")).click();
		Thread.sleep(7000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Store Management')]")).size() > 0) {
			test.pass("Successfully viewd Store Management Listing");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Store Management Listing");
			Assert.assertTrue(false);
		}

		Thread.sleep(1000);
		// driver.findElement(By.xpath("(//a[@title='View'])[1]")).click();
		act1.moveToElement(driver.findElement(By.xpath("(//a[@title='View'])[1]"))).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Profile')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Profile')]")).size() > 0) {
			test.pass("Successfully viewd store Profile tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Profile tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Packages')]")).click(); // Store Packages--tab name changed
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Packages')]")).size() > 0) {
			test.pass("Successfully viewd store Packages tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Packages tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Custom Packages')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Custom Packages')]")).size() > 0) {
			test.pass("Successfully viewd store Custom Packages tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Custom Packages tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Games')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Games')]")).size() > 0) {
			test.pass("Successfully viewd store Games tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Games tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Bonus')]")).click(); // Store Bonus-- tab name changed
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Bonus')]")).size() > 0) {
			test.pass("Successfully viewd store Bonus tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Bonus tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Lobby Jackpot')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Lobby Jackpot')]")).size() > 0) {
			test.pass("Successfully viewd store Lobby Jackpot tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Lobby Jackpot tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Store Coupon')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Store Coupon')]")).size() > 0) {
			test.pass("Successfully viewd store Store Coupon tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Store Coupon tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Withdraw Settings')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Withdraw Settings')]")).size() > 0) {
			test.pass("Successfully viewd store Withdraw Settings tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Withdraw Settings tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'App Settings')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'App Settings')]")).size() > 0) {
			test.pass("Successfully viewd store App Settings tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store App Settings tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Website Setting')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Website Setting')]")).size() > 0) {
			test.pass("Successfully viewd store Website Setting tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Website Setting tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[text()='Settings']")).click(); // Store Settings--Tab name changed
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[text()='Settings']")).size() > 0) {
			test.pass("Successfully viewd store Settings tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Settings tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Corporation Details')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Corporation Details')]")).size() > 0) {
			test.pass("Successfully viewd store Corporation Details tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Packages tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'App Marketing')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'App Marketing')]")).size() > 0) {
			test.pass("Successfully viewd store App Marketing tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store App Marketing tab");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[contains(text(),'Social Media Settings')]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//div[contains(text(),'Social Media Settings')]")).size() > 0) {
			test.pass("Successfully viewd store Social Media Settings tab ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the store Social Media Settings tab");
			Assert.assertTrue(false);
		}

		// User Management
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/user/access-control']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Access Control')]")).size() > 0) {
			test.pass("Successfully viewd Access Control page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Access Control page");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/user/role']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Role')]")).size() > 0) {
			test.pass("Successfully viewd Role page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Role page");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/user/user-control']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'User Profile')]")).size() > 0) {
			test.pass("Successfully viewd User Profile");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the User Profile");
			Assert.assertTrue(false);
		}

		// Support Management
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/support']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Support Management')]")).size() > 0) {
			test.pass("Successfully viewd Support Management page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Support Management page");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/support/contact-details']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Contact Details')]")).size() > 0) {
			test.pass("Successfully viewd Contact Details page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Contact Details page");
			Assert.assertTrue(false);
		}

		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/chat']")).click();
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Chat Management')]")).size() > 0) {
			test.pass("Successfully viewd Chat Management page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Chat Management page");
			Assert.assertTrue(false);
		}

		// notification
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
		driver.findElement(By.xpath("//a[@routerlink='/notification']")));
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[@routerlink='/notification']")));
		Thread.sleep(4000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Notifications')]")).size() > 0) {
			test.pass("Successfully viewd Notifications page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Notifications page");
			Assert.assertTrue(false);
		}

		// announcement
		driver.findElement(By.xpath("//div[@class='navMobiIcon']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@routerlink='/announcement']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[contains(text(),'Announcements')]")).size() > 0) {
			test.pass("Successfully viewd Announcements page");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Announcements page ");
			Assert.assertTrue(false);
		}

		driver.close();

	}

	@Test(dataProvider = "mobileEmulations")
	public void B_TC_CosmoWebsite_ValidateMobileResponsive(String emulation1) throws InterruptedException, IOException {
		test = extentCreateTest("Website Panel Mobile Responsive " + emulation1);

		Map<String, String> deviceMobileEmu = new HashMap<String, String>();
		deviceMobileEmu.put("deviceName", emulation1);
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("--disable-notifications");
		chromeOpt.setExperimentalOption("mobileEmulation", deviceMobileEmu);
		WebDriver driver = new ChromeDriver(chromeOpt);

		// driver.manage().window().maximize();
		driver.get(WebURL);
		// Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//input[@formcontrolname=\"email\"])[2]")).sendKeys(Playerid);
		driver.findElement(
				By.xpath("//input[@formcontrolname=\"email\"]//following::div//input[@formcontrolname=\"password\"]"))
				.sendKeys(Playerpass);

		driver.findElement(By.xpath("//div[@class='auth-form']//child::button[contains(text(),\"Sign In\")]")).click();
		Thread.sleep(5000);
		test.pass("Successfully Logged in Website");

//		MutableCapabilities capabilities = new MutableCapabilities();
//		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//		browserstackOptions.put("deviceOrientation", "landscape");
//		capabilities.setCapability("bstack:options", browserstackOptions);

		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Games']")).click();
		Thread.sleep(1000);

		List<WebElement> games = driver.findElements(By.xpath("//img[@class='gli-image']"));
		int CountGames = games.size();
		System.out.println("Number of games = " + CountGames);

//		
//		List<WebElement> gamesName = driver.findElements(By.xpath("//div[@class='gameInfo']"));
//		int CountGames1 = gamesName.size();
//		for(WebElement gn:gamesName)
//		{
//			String ListofGame = gn.getText();
//			System.out.println("Name of games is = "+ListofGame);
//		}

//		driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
//		
		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='About Us']")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h4[text()='Welcome to Cosmo Slot']")).size() > 0) {
			test.pass("Successfully viewd About us page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the  About us  page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Promotions']")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h2[text()='Promotions']")).size() > 0) {
			test.pass("Successfully viewd Promotions page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the  Promotions page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Media']")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h2[text()='Media']")).size() > 0) {
			test.pass("Successfully viewd Media page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Media page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h3[text()='Contact Us']")).size() > 0) {
			test.pass("Successfully viewd Contact Us page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the  Contact Us  page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@aria-label='Toggle navigation']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Earn Free Spins']")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h3[text()='Earn Free Spins']")).size() > 0) {
			test.pass("Successfully viewd Earn Free Spins page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Earn Free Spins page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
//      player profile view
		driver.findElement(By.xpath("//a[@id='dropdownUser']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(3000);

		// driver.findElement(By.xpath("//button[text()='Profile']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Profile']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Profile']")).size() > 0) {
			test.pass("Successfully viewd player profile page in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player profile page in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Packages']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Packages']"))).click().perform();
		// Thread.sleep(1000);
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Packages']")).size() > 0) {
			test.pass("Successfully viewd player Packages in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Packages in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Stats']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Stats']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Stats']")).size() > 0) {
			test.pass("Successfully viewd player Stats in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Stats in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Bonuses']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Bonuses']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Bonuses']")).size() > 0) {
			test.pass("Successfully viewd player Bonuses in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Bonuses in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Withdraw']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Withdraw']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Withdraw']")).size() > 0) {
			test.pass("Successfully viewd player Withdraw in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Withdraw in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Transactions']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Transactions']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Transactions']")).size() > 0) {
			test.pass("Successfully viewd player Transactions in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Transactions in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Game Transactions']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='Game Transactions']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Game Transactions']")).size() > 0) {
			test.pass("Successfully viewd player Game Transactions in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Game Transactions in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		// driver.findElement(By.xpath("//button[text()='Announcement']")).click();
		act.moveToElement(driver.findElement(By.xpath("//button[@id='nav-announcement-tab']"))).click().perform();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[text()='Announcement']")).size() > 0) {
			test.pass("Successfully viewd player Announcement in the cosmo website");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the player Announcement in the cosmo website ");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);

		Thread.sleep(4000);
		driver.close();
	}

//	public void TC_AdminPanel_MobileResponsive() throws InterruptedException {
//
//		test = extentCreateTest("Admin Panel Mobile Responsive ");
//
//		System.out.println(driver.manage().window().getSize());
//		// Create object of Dimensions class
//		Dimension d = new Dimension(480, 620);
//		// Resize the current window to the given dimension
//		driver.manage().window().setSize(d);
//		System.out.println(driver.manage().window().getSize());
//		// JavascriptExecutor js = (JavascriptExecutor) driver;
//		// set size with window.resizeTo() method
//		// js.executeScript("window.resizeTo(450,630);");
//		Thread.sleep(10000);
//	}

}
