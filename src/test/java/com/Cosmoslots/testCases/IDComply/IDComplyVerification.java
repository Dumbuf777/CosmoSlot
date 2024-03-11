package com.Cosmoslots.testCases.IDComply;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.Cosmoslots.ENUM.XPathEnum;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.testCases.PlayerReferralScenario;
import com.Cosmoslots.utilities.BaseClass;

public class IDComplyVerification extends BaseClass {

	private void clickAndWait(XPathEnum element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement webElement = driver.findElement(element.getBy());
		wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
		test.info("clicked on Elemet " + webElement.getText(), extentScreenshot());
	}

	private boolean isElementPresent(WebDriver driver, XPathEnum errorMessage) {
		try {
			driver.findElement(errorMessage.getBy());
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public boolean verify(XPathEnum element) throws InterruptedException {
		return driver.findElements(element.getBy()).size() > 0;
	}

	@Test
	public void A_playerLogin() throws InterruptedException {
		test = extentCreateTest("Player - Login");
		test.info("TestCase started - As an player I should be able to login on website");
		PlayerReferralScenario prs = new PlayerReferralScenario();
		gotoTab(driver, 1);
		prs.PlayerLogout();
		WebsiteLogin( "CS-1402", Playerpass);
		test.info("TestCase end - Player login on website");
	}

	@Test
	public void B_playerProfile() throws InterruptedException {
		test = extentCreateTest("Player - Profile");
		test.info("TestCase started - As an player I should be able to redirect on player profile on website");
		gotoTab(driver, 1);
		/// clickAndWait(XPathEnum.USER_DROPDOWN);
		Thread.sleep(02000);
		driver.findElement(XPathEnum.USER_DROPDOWN.getBy()).click();
		Thread.sleep(02000);
		// clickAndWait(XPathEnum.PROFILE_LINK);
		driver.findElement(XPathEnum.PROFILE_LINK.getBy()).click();
		test.info("TestCase end - player profile on website");
	}

	public void verifyKYC() throws InterruptedException, IOException {
		gotoTab(driver, 1);
		PageReload();
//		clickAndWait(XPathEnum.USER_DROPDOWN);
//		clickAndWait(XPathEnum.PROFILE_LINK);
		Thread.sleep(2000);
		driver.findElement(XPathEnum.USER_DROPDOWN.getBy()).click();
		Thread.sleep(2000);
		// clickAndWait(XPathEnum.PROFILE_LINK);
		driver.findElement(XPathEnum.PROFILE_LINK.getBy()).click();
		Thread.sleep(2000);
		// clickAndWait(XPathEnum.KYC_VERIFICATION_BUTTON);
		driver.findElement(XPathEnum.KYC_VERIFICATION_BUTTON.getBy()).click();
		PageScrollToEnd();
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.VERIFICATION.getBy()));

		if (driver.findElements(XPathEnum.VERIFICATION.getBy()).size() > 0) {
			// if (verify(XPathEnum.VERIFICATION)) {
			// clickAndWait(XPathEnum.VERIFICATION);
			Thread.sleep(1000);
			test.info("" + driver.findElement(XPathEnum.VERIFICATION.getBy()).getText());
			driver.findElement(XPathEnum.VERIFICATION.getBy()).click();
			
			if (driver.findElements(XPathEnum.ERROR_MESSAGE_STATE.getBy()).size() > 0
					|| driver.findElements(XPathEnum.ERROR_MESSAGE_COUNTRY.getBy()).size() > 0
					|| driver.findElements(XPathEnum.ERROR_MESSAGE_DOB.getBy()).size() > 0) {
				test.info("State found in website but not able to perform ID Comply due to other field missing",
						extentScreenshot());
			} else {
				test.info("Successfully opened ID comply window", extentScreenshot());
			}
			// } else if (verify(XPathEnum.VERIFICATION)) {
		} else {
			test.info("KYC button not found");
		}
		Thread.sleep(1000);
		

//		
//		if (isElementPresent(driver, XPathEnum.ERROR_MESSAGE_STATE)
//				|| isElementPresent(driver, XPathEnum.ERROR_MESSAGE_COUNTRY)
//				|| isElementPresent(driver, XPathEnum.ERROR_MESSAGE_DOB)) {
//			test.info("State found in website but not able to perform ID Comply due to other field missing",
//					extentScreenshot());
//		} else {
//			test.info("Successfully opened ID comply window", extentScreenshot());
//		}
	}

	@Test
	public void E_playerProfieVerifyWithDOB() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage_Old lp = new LobbyPage_Old(driver);

		test = extentCreateTest("ID Comply with DOB");
		test.info(
				"TestCase started - As an player I should be able to redirect on player profile on website to verify ID Comply with DOB");
		gotoTab(driver, 0);
		pp.clickOnPlayerManagement();
		pp.clickPlayerProfileLink();
		gp.Search_Items("CS-1402");
		lp.clickToEdit();
		if (driver.findElements(By.xpath("//input[@formcontrolname=\"dob\"]//following::mat-icon[text()='clear']"))
				.size() > 0) {
			driver.findElement(By.xpath("//input[@formcontrolname=\"dob\"]//following::mat-icon[text()='clear']"))
					.click();
			test.info("DOB clear from admin", extentScreenshot());
			PageScrollToEnd();
			lp.ClickToSave();
		}

		gotoTab(driver, 1);
		PageReload();
//		clickAndWait(XPathEnum.USER_DROPDOWN);
//		clickAndWait(XPathEnum.PROFILE_LINK);
//		clickAndWait(XPathEnum.DOB);
//		clickAndWait(XPathEnum.SELECT_DOB);
//		// clickAndWait(XPathEnum.SAVE_BUTTON);
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.SAVE_BUTTON.getBy()));
//		clickAndWait(XPathEnum.KYC_VERIFICATION_BUTTON);
//		Thread.sleep(2000);
//		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.VERIFICATION.getBy()));
//		// clickAndWait(XPathEnum.VERIFICATION);
//
//		if (isElementPresent(driver, XPathEnum.ERROR_MESSAGE_DOB)) {
//			test.info("DOB found in website but not able to perform ID Comply due to other field missing",
//					extentScreenshot());
//		} else {
//			test.info("Successfully opened ID comply window", extentScreenshot());
//		}
//		Thread.sleep(2000);
//		driver.findElement(XPathEnum.USER_DROPDOWN.getBy()).click();
//		Thread.sleep(2000);
//		// clickAndWait(XPathEnum.PROFILE_LINK);
//		driver.findElement(XPathEnum.PROFILE_LINK.getBy()).click();
		Thread.sleep(2000);
		driver.findElement(XPathEnum.KYC_VERIFICATION_BUTTON.getBy()).click();
		PageScrollToEnd();
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.VERIFICATION.getBy()).size() > 0) {
			// if (verify(XPathEnum.VERIFICATION)) {
			// clickAndWait(XPathEnum.VERIFICATION);
			Thread.sleep(1000);
			driver.findElement(XPathEnum.VERIFICATION.getBy()).click();
			test.info("" + driver.findElement(XPathEnum.VERIFICATION.getBy()).getText());
			// } else if (verify(XPathEnum.VERIFICATION)) {
		} else {
			test.info("KYC button not found");
		}
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.ERROR_MESSAGE_DOB.getBy()).size() > 0) {
			test.info("dob found in website but not able to perform ID Comply due to other field missing",
					extentScreenshot());
		} else {
			test.info("Successfully opened ID comply window", extentScreenshot());
		}
	}

	@Test
	public void F_playerProfieVerifyWithCountry() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage_Old lp = new LobbyPage_Old(driver);

		test = extentCreateTest("ID Comply with Country");
		test.info(
				"TestCase started - As an player I should be able to redirect on player profile on website to verify ID Comply with Country");

		gotoTab(driver, 1);
		PageReload();
//		clickAndWait(XPathEnum.USER_DROPDOWN);
//		clickAndWait(XPathEnum.PROFILE_LINK);
		Thread.sleep(02000);
		driver.findElement(XPathEnum.USER_DROPDOWN.getBy()).click();
		Thread.sleep(02000);
		// clickAndWait(XPathEnum.PROFILE_LINK);
		driver.findElement(XPathEnum.PROFILE_LINK.getBy()).click();
		// clickAndWait(XPathEnum.COUNTRY_CLEAR);
		// clickAndWait(XPathEnum.SELECT_DOB);
		// if ((driver.findElements(XPathEnum.COUNTRY_CLEAR.getBy()).size()) > 0) {
		// driver.findElement(XPathEnum.COUNTRY_CLEAR.getBy()).click();
//		gotoTab(driver, 0);
//		pp.clickPlayerManagement1Link();
//		pp.clickPlayerProfileLink();
//		gp.Search_Items("CS-1402");
//		lp.clickToEdit();
//		driver.findElement(XPathEnum.COUNTRY.getBy()).click();
//		driver.findElement(XPathEnum.COUNTRY_SElECT.getBy()).sendKeys("India");
//		driver.findElement(XPathEnum.COUNTRY_SElECT.getBy()).sendKeys(Keys.TAB);
//		// }

		Thread.sleep(1000);
		driver.findElement(XPathEnum.COUNTRY_CLEAR.getBy()).click();
		// clickAndWait(XPathEnum.COUNTRY_CLEAR);
		PageScrollToEnd();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//label[text()='Country']//parent::div")).click();
//		driver.findElement(By.xpath("//div[contains(@class,'ng-option')]//parent::span[text()='India']")).click();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.SAVE_BUTTON.getBy()));
//		clickAndWait(XPathEnum.KYC_VERIFICATION_BUTTON);
//		Thread.sleep(2000);
//		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.VERIFICATION.getBy()));

		// clickAndWait(XPathEnum.VERIFICATION);

//		if (verify(XPathEnum.VERIFICATION)) {
//			clickAndWait(XPathEnum.VERIFICATION);
//		} else if (verify(XPathEnum.VERIFICATION)) {
//			clickAndWait(XPathEnum.VERIFICATION);
//		} else {
//			test.info("KYC button not found");
//		}
//		if (isElementPresent(driver, XPathEnum.ERROR_MESSAGE_COUNTRY)) {
//			test.info("Country found in website but not able to perform ID Comply due to other field missing",
//					extentScreenshot());
//		} else {
//			test.info("Successfully opened ID comply window", extentScreenshot());
//		}
		PageReload();
		Thread.sleep(2000);
		driver.findElement(XPathEnum.KYC_VERIFICATION_BUTTON.getBy()).click();
		PageScrollToEnd();
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.VERIFICATION.getBy()).size() > 0) {
			// if (verify(XPathEnum.VERIFICATION)) {
			// clickAndWait(XPathEnum.VERIFICATION);
			Thread.sleep(1000);
			driver.findElement(XPathEnum.VERIFICATION.getBy()).click();
			test.info("" + driver.findElement(XPathEnum.VERIFICATION.getBy()).getText());
			// } else if (verify(XPathEnum.VERIFICATION)) {
		} else {
			test.info("KYC button not found");
		}
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.ERROR_MESSAGE_COUNTRY.getBy()).size() > 0) {
			test.info("country found in website but not able to perform ID Comply due to other field missing",
					extentScreenshot());
		} else {
			test.info("Successfully opened ID comply window", extentScreenshot());
		}
	}

	@Test
	public void G_playerProfieVerifyWithState() throws InterruptedException, IOException {
//		PlayerProfile pp = new PlayerProfile(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		LobbyPage lp = new LobbyPage(driver);

		test = extentCreateTest("ID Comply with State");
		test.info(
				"TestCase started - As an player I should be able to redirect on player profile on website to verify ID Comply with State");

		gotoTab(driver, 1);
		PageReload();
		clickAndWait(XPathEnum.USER_DROPDOWN);
		clickAndWait(XPathEnum.PROFILE_LINK);
		// if ((driver.findElements(XPathEnum.STATE_CLEAR.getBy()).size() > 0)) {
		// driver.findElement(XPathEnum.COUNTRY_CLEAR.getBy()).click();
		// driver.findElement(XPathEnum.STATE.getBy()).click();
		// driver.findElement(XPathEnum.STATE_SElECT.getBy()).sendKeys("Goa");
		// driver.findElement(XPathEnum.STATE_SElECT.getBy()).sendKeys(Keys.TAB);
		// }
		Thread.sleep(1000);
		clickAndWait(XPathEnum.STATE_CLEAR);
		PageScrollToEnd();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.SAVE_BUTTON.getBy()));
//		clickAndWait(XPathEnum.KYC_VERIFICATION_BUTTON);
//		Thread.sleep(2000);
//		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.VERIFICATION.getBy()));
//		clickAndWait(XPathEnum.VERIFICATION);
//		if (verify(XPathEnum.VERIFICATION)) {
//			clickAndWait(XPathEnum.VERIFICATION);
//		} else if (verify(XPathEnum.VERIFICATION)) {
//			clickAndWait(XPathEnum.VERIFICATION);
//		} else {
//			test.info("KYC button not found");
//		}
//		if (isElementPresent(driver, XPathEnum.ERROR_MESSAGE_STATE)) {
//			test.info("State found in website but not able to perform ID Comply due to other field missing",
//					extentScreenshot());
//		} else {
//			test.info("Successfully opened ID comply window", extentScreenshot());
//		}
		PageReload();
		Thread.sleep(2000);
		driver.findElement(XPathEnum.KYC_VERIFICATION_BUTTON.getBy()).click();
		PageScrollToEnd();
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.VERIFICATION.getBy()).size() > 0) {
			// if (verify(XPathEnum.VERIFICATION)) {
			// clickAndWait(XPathEnum.VERIFICATION);
			Thread.sleep(1000);
			driver.findElement(XPathEnum.VERIFICATION.getBy()).click();
			test.info("" + driver.findElement(XPathEnum.VERIFICATION.getBy()).getText());
			// } else if (verify(XPathEnum.VERIFICATION)) {
		} else {
			test.info("KYC button not found");
		}
		Thread.sleep(1000);
		if (driver.findElements(XPathEnum.ERROR_MESSAGE_STATE.getBy()).size() > 0) {
			test.info("State found in website but not able to perform ID Comply due to other field missing",
					extentScreenshot());
		} else {
			test.info("Successfully opened ID comply window", extentScreenshot());
		}

	}

	@Test
	public void Y_PlayerProfile_Edit() throws InterruptedException, IOException {
		test = extentCreateTest("Website Player Profile -> Edit Player Profile");
		test.info("TestCase started EditPlayer Details");
//		PlayerProfile pp = new PlayerProfile(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		LobbyPage lp = new LobbyPage(driver);
		gotoTab(driver, 1);
		clickAndWait(XPathEnum.USER_DROPDOWN);
		clickAndWait(XPathEnum.PROFILE_LINK);
		Thread.sleep(1500);
		driver.findElement(By.xpath("//label[text()='Country']//parent::div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ng-option')]//parent::span[text()='India']")).click();
		// driver.findElement(By.xpath("//div[contains(@class,'ng-option')]//parent::span[text()='India']")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[text()='State']//parent::div")).click();
		driver.findElement(By.xpath("//div[contains(@class,'ng-option')]//parent::span[text()='Goa']")).click();
		// driver.findElement(By.xpath("//div[contains(@class,'ng-option')]//parent::span[text()='Goa']")).sendKeys(Keys.ESCAPE);
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).sendKeys("Sincaryu");
		driver.findElement(By.xpath("//input[@formcontrolname=\"address\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"address\"]")).sendKeys("Picasa Road");
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//input[@formcontrolname=\"zipCode\"]")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname=\"zipCode\"]")).sendKeys("380005");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(XPathEnum.SAVE_BUTTON.getBy()));

	}

	@Test
	public void Z_playerProfieVerify() throws InterruptedException, IOException {
//		PlayerProfile pp = new PlayerProfile(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		LobbyPage lp = new LobbyPage(driver);

		test = extentCreateTest("Player - Profile verification for ID Comply");
		test.info(
				"TestCase started - As an player I should be able to redirect on player profile on website to verify ID Comply  ");
		verifyKYC();

	}

}
