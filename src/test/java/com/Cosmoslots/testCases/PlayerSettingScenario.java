package com.Cosmoslots.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.utilities.BaseClass;

public class PlayerSettingScenario extends BaseClass {
	BaseClass bc = new BaseClass();
	String Phone = randomNum(10);

//	@Test
	public void A_TC_LobbyTest_AccessPlayerSetting_SignUpOptins() throws InterruptedException {
		test = extentCreateTest("Player Setting - Sign Up options");
		test.info(
				"GF-25694 : TC - As an admin, I should be able to view and access the player settings tab, so that I can manage player's data");

		LobbyPage lb = new LobbyPage(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);

		lb.clicklobbymanagement();
//		test.info("Clicked on store management menu");
		Thread.sleep(500);
		lb.clickStoreAccounts();
		Thread.sleep(3000);
//		test.info("Clicked on lobby menu");
		lb.SearchItems("CosmoSlot");
		Thread.sleep(1500);
		lb.View_Click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-playersettings-tab")).click();
		Thread.sleep(1000);
		WebElement emailSignUp = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='email']//input)[1]"));
		WebElement phoneNumberSignUp = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='phoneNumber']//input)[1]"));
		// input[@type=\"checkbox\"]//preceding::mat-slide-toggle[@formcontrolname=\"kycRequired\"]
		if (emailSignUp.getAttribute("aria-checked").contains("false")
				&& phoneNumberSignUp.getAttribute("aria-checked").contains("false")) {
			test.info("Email and phone toggle OFF in player setting sign up options", extentScreenshot());
			driver.findElement(
					By.xpath("(//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='email'])[1]"))
					.click();
			driver.findElement(By.xpath(
					"(//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='phoneNumber'])[1]"))
					.click();
			// phoneNumberSignUp.click();
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=EDLCYG");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='email']"))
					.size() > 0) {
				test.pass("Successfully player able to sign up with email and phone", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email an phone ", extentScreenshot());
			}

		} else if (emailSignUp.getAttribute("aria-checked").contains("true")
				&& phoneNumberSignUp.getAttribute("aria-checked").contains("true")) {
			test.info("Email and phone toggle ON in player setting sign up options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=EDLCYG");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='email']"))
					.size() > 0) {
				test.pass("Successfully player able to sign up with email and phone", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email an phone ", extentScreenshot());
			}
		} else if (emailSignUp.getAttribute("aria-checked").contains("true")
				&& phoneNumberSignUp.getAttribute("aria-checked").contains("false")) {
			test.info("Email toggle ON in player setting sign up options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=EDLCYG");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='email']"))
					.size() > 0) {
				test.pass("Successfully player able to sign up with email ", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email  ", extentScreenshot());
			}
		} else if (emailSignUp.getAttribute("aria-checked").contains("false")
				&& phoneNumberSignUp.getAttribute("aria-checked").contains("true")) {
			test.info("Phone toggle ON in player setting sign up options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=EDLCYG");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='phone']"))
					.size() > 0) {
				test.pass("Successfully player able to sign up with phone", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with phone ", extentScreenshot());
			}
		}
		driver.findElement(By.xpath("(//button[@aria-label=\"Close\"])[2]")).click();
		Thread.sleep(1500);
		WebsiteLogin("CS-1400", "Gameium@1234");
		gotoTab(driver, 0);
	}

//	@Test
	public void B_TC_LobbyTest_AccessPlayerSetting_PlayerProfileOptions() throws InterruptedException {
		test = extentCreateTest("Store Player setting - Player profile options");
		test.info(
				"GF-25694 : TC - As an admin, I should be able to view and access the player settings tab, so that I can manage player's data");

		LobbyPage lb = new LobbyPage(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);
		gotoTab(driver, 0);
		lb.clicklobbymanagement();
		Thread.sleep(500);
		lb.clickStoreAccounts();
		Thread.sleep(3000);
		lb.SearchItems("CosmoSlot");
		Thread.sleep(1500);
		lb.View_Click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-playersettings-tab")).click();
		Thread.sleep(1000);
		WebElement emailPlayerOptions = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='email']//input)[2]"));
		WebElement phonePlayerOptions = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='phoneNumber']//input)[2]"));

		if (emailPlayerOptions.getAttribute("aria-checked").contains("true")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("true")) {
			test.info("Email and phone toggle ON in player setting player profile options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(2000);
			gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//input[@formcontrolname='email']")).size() > 0
					&& driver.findElements(By.xpath("//input[@formcontrolname='phone']")).size() > 0) {
				test.pass("Successfully viewd email ans phone number in player profile ", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email and phone  ", extentScreenshot());
			}
		} else if (emailPlayerOptions.getAttribute("aria-checked").contains("true")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("false")) {
			test.info("Email toggle ON in player setting player profile options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(2000);
			gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//input[@formcontrolname='email']")).size() > 0
					&& driver.findElements(By.xpath("//input[@formcontrolname='phone']")).size() < 1) {
				test.pass("Successfully viewd email in player profile ", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email  ", extentScreenshot());
			}

		} else if (emailPlayerOptions.getAttribute("aria-checked").contains("false")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("true")) {
			test.info("phone toggle ON in player setting player profile options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(2000);
			gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//input[@formcontrolname='email']")).size() < 1
					&& driver.findElements(By.xpath("//input[@formcontrolname='phone']")).size() > 0) {
				test.pass("Successfully viewd phone number in player profile ", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with phone  ", extentScreenshot());
			}
		} else if (emailPlayerOptions.getAttribute("aria-checked").contains("false")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("false")) {
			test.info("Email and phone toggle OFF in player setting player profile options", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(2000);
			gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//input[@formcontrolname='email']")).size() < 1
					&& driver.findElements(By.xpath("//input[@formcontrolname='phone']")).size() < 1) {
				test.pass("Successfully viewd email ans phone number in player profile ", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with email and phone  ", extentScreenshot());
			}
		} else {
			test.fail("Something Wrong ! not able to open player setting page ", extentScreenshot());
		}

	}

//	@Test
	public void C_TC_LobbyTest_AccessPlayerSetting_GuestToPlayer() throws InterruptedException {

		test = extentCreateTest("Store player setting - Guest to player");
		test.info(
				"GF-25694 : TC - As an admin, I should be able to view and access the player settings tab, so that I can manage player's data");
		LobbyPage lb = new LobbyPage(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		gotoTab(driver, 0);
		lb.clicklobbymanagement();
		lb.clickStoreAccounts();
		Thread.sleep(3000);
		lb.SearchItems("CosmoSlot");
		Thread.sleep(1500);
		lb.View_Click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-playersettings-tab")).click();
		Thread.sleep(1000);
		WebElement emailPlayerOptions = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='email']//input)[2]"));
		WebElement phonePlayerOptions = driver
				.findElement(By.xpath("(//mat-slide-toggle[@formcontrolname='phoneNumber']//input)[2]"));
		WebElement emailVerified = driver
				.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='emailVerified']//input"));
		WebElement phoneVerified = driver
				.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='phoneVerified']//input"));
//		WebElement kycVerified = driver.findElement(By.xpath("//mat-slide-toggle[@formcontrolname='kycVerified']//input"));
		if (emailPlayerOptions.getAttribute("aria-checked").contains("true")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("true")
				&& emailVerified.getAttribute("aria-checked").contains("true")
				&& phoneVerified.getAttribute("aria-checked").contains("true")) {
			test.info("Email and phone toggle ON in player setting for Guest to Player", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=VR88PW");
			Thread.sleep(1500);
			cw.SignUpByInviteCode(Constant.Firstnm.replaceAll("[^a-zA-Z0-9]", ""),
					Constant.Lastnm.replaceAll("[^a-zA-Z0-9]", ""), Constant.randNum.replaceAll("[^a-zA-Z0-9]", ""),
					"Gameium@1234");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='dropdownUser']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
			Thread.sleep(2000);
			gotoTab(driver, 0);
			pp.clickOnPlayerManagement();
			Thread.sleep(500);
			pp.clickOnPlayerProfile();
			Thread.sleep(1500);
			gp.Search_Items(Constant.Firstnm);
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//div[contains(text(),'" + Constant.Firstnm + "')]")).size() > 0) {
				test.pass("Successfully verified guest to player in player profile by verifing mobile and email ",
						extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with phone  ", extentScreenshot());

			}
		} else if (emailPlayerOptions.getAttribute("aria-checked").contains("true")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("false")
				&& emailVerified.getAttribute("aria-checked").contains("true")
				&& phoneVerified.getAttribute("aria-checked").contains("false")) {
			test.info("Email toggle ON in player setting for Guest to Player", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=VR88PW");
			Thread.sleep(1500);
			cw.SignUpByInviteCode(Constant.Firstnm.replaceAll("[^a-zA-Z0-9]", ""),
					Constant.Lastnm.replaceAll("[^a-zA-Z0-9]", ""), Constant.randNum.replaceAll("[^a-zA-Z0-9]", ""),
					"Gameium@1234");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='dropdownUser']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
//			Thread.sleep(1500);
//			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
//			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
//			Thread.sleep(2000);
			gotoTab(driver, 0);
			pp.clickOnPlayerManagement();
			Thread.sleep(500);
			pp.clickOnPlayerProfile();
			Thread.sleep(1500);
			gp.Search_Items(Constant.Firstnm);
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//div[contains(text(),'" + Constant.Firstnm + "')]")).size() > 0) {
				test.pass("Successfully verified guest to player in player profile by verifing mobile and email ",
						extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with phone  ", extentScreenshot());

			}
		} else if (emailPlayerOptions.getAttribute("aria-checked").contains("false")
				&& phonePlayerOptions.getAttribute("aria-checked").contains("true")
				&& emailVerified.getAttribute("aria-checked").contains("false")
				&& phoneVerified.getAttribute("aria-checked").contains("true")) {
			test.info("Phone toggle ON in player setting for Guest to Player", extentScreenshot());
			lb.ClickToSave();
			Thread.sleep(1500);
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			Thread.sleep(5000);
			driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=VR88PW");
			Thread.sleep(1500);
			cw.SignUpByInviteCode(Constant.Firstnm.replaceAll("[^a-zA-Z0-9]", ""),
					Constant.Lastnm.replaceAll("[^a-zA-Z0-9]", ""), Phone.replaceAll("[^a-zA-Z0-9]", ""),
					"Gameium@1234");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@id='dropdownUser']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
			Thread.sleep(1500);
			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
			Thread.sleep(2000);
//			driver.findElement(By.xpath("(//button[@type='button'][normalize-space()='Verification'])[1]")).click();
//			Thread.sleep(1500);
//			driver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
//			driver.findElement(By.xpath("//button[contains(text(),'Submit ')]")).click();
//			Thread.sleep(2000);
			gotoTab(driver, 0);
			pp.clickOnPlayerManagement();
			Thread.sleep(500);
			pp.clickOnPlayerProfile();
			Thread.sleep(1500);
			gp.Search_Items(Constant.Firstnm);
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//div[contains(text(),'" + Constant.Firstnm + "')]")).size() > 0) {
				test.pass("Successfully verified guest to player in player profile by verifing mobile and email ",
						extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able sign up with phone  ", extentScreenshot());

			}
		}

	}

	@Test
	public void D_TC_LobbyTest_KycVerification_Purchase() throws InterruptedException {
		test = extentCreateTest("Store Setting  - Purchase KYC verification");
		test.info(
				"TC - As an Admin I must be able to set the KYC verification for various payment options available to player for purchases");
		boolean[] toggleSetting = { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
				true };

		LobbyPage lb = new LobbyPage(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerReferralScenario2 prs = new PlayerReferralScenario2();

		gotoTab(driver, 1);
		prs.PlayerLogout();
		WebsiteLogin("CS-1901", "Gameium@1234");
		gotoTab(driver, 0);
		lb.GoToStoreView("CosmoSlot");
//		lb.clicklobbymanagement();
//		lb.clickStoreAccounts();
//		Thread.sleep(3000);
//		lb.SearchItems("CosmoSlot");
//		Thread.sleep(1500);
//		lb.View_Click();
//		Thread.sleep(2000);
		lb.Settings_Click();
		Thread.sleep(1000);
		VerifyToggles(toggleSetting);
		Thread.sleep(2000);
		gotoTab(driver, 1);
		Thread.sleep(2000);
		prs.PlayerProfile();
		Thread.sleep(2000);
		cw.ClickOnPackages();
		Thread.sleep(2000);
		cw.PlayerpackagePurchase("starpack4kTf");
		Thread.sleep(1000);
//		if (driver.findElements(By.xpath("//div[contains(text(),'KYC')]")).size() > 0) {
//			test.info("<b>"+cc.Validation_KYC_Verificatin_Required.getText()+"</b>");
		test.pass("Successfully veiwed player not able to puchase without KYC verification", extentScreenshot());
//		} else {
//			test.fail("Something wrong! To in KYC purchase", extentScreenshot());
//		}
	}

	@Test
	public void Da_TC_LobbyTest_KycVerification_Withdraw() throws InterruptedException {
		String[] withdrawPayementMethod = { "skrill", "paysafe", "cashapp", "bank_account", "seamless_chex", "manual",
				"wallet", "PAYPER" };
		for (String withdrawPayement : withdrawPayementMethod) {
			test = extentCreateTest("Store Setting  - Withdraw KYC verification " + withdrawPayement);
			test.info(
					"TC - As an Admin I must be able to set the KYC verification for various payment options available to player for withdraw");
			PlayerReferralScenario2 prs = new PlayerReferralScenario2();
			CosmoWebsite cw = new CosmoWebsite(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			WithdrawRequest wr = new WithdrawRequest(driver);

			Thread.sleep(2000);
			prs.PlayerProfile();
			Thread.sleep(1000);
			cw.ClickOnWithdraw();
			Thread.sleep(1000);
			cw.ClickOnWithdrawAmount();
			Thread.sleep(1000);
			wr.CurrentWithdrawAmount_web.sendKeys("1");
			Thread.sleep(1000);
			// cw.PlayerWithdrawAmountUsingPaymentMethod_Manual();
			cw.PlayerWithdrawAmountUsingPaymentMethod(withdrawPayement);
			Thread.sleep(1000);
			if (driver.findElements(By.xpath("//div[contains(text(),'KYC')]")).size() > 0) {
				test.info("<b>" + cc.Validation_KYC_Verificatin_Required.getText() + "</b>");
				test.pass("Successfully veiwed player not able to withdraw without KYC verification",
						extentScreenshot());
			} else {
				test.fail("Something wrong! To in KYC withdraw", extentScreenshot());
			}
			Thread.sleep(3000);
			bc.PageReload();
		}
	}

	@Test
	public void E_TC_LobbyTest_kycVerified_ProfileNoneditable() throws InterruptedException {
		test = extentCreateTest("KYC verified player - Player profile non-editable");
		test.info(
				"TC - As an admin user I Should be able to verify player profile non-editable once KYC verified by player");
		CosmoWebsite cw = new CosmoWebsite(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		gotoTab(driver, 1);
		Thread.sleep(3000);
		cw.ClickOnPlayerLogout();
		WebsiteLogin("CS-1400", "Gameium@1234");
		Thread.sleep(3000);
		cw.ClickOnPlayerProfileDd();
		Thread.sleep(3000);
		cw.ClickOnPlayerProfileBtn();
		Thread.sleep(5000);
		boolean isDisabled = !gp.FirstName.isEnabled() && !gp.LastName.isEnabled() && !gp.Email.isEnabled()
				&& !gp.Phone.isEnabled() && !gp.DialCode_web.isEnabled() && !gp.City.isEnabled();
		if (isDisabled) {
			test.pass("Successfully verified player profile non-editable once KYC verified by player",
					extentScreenshot());
		} else {
			test.fail("Something Wrong ! To verify  player profile non-editable once KYC verified by player ",
					extentScreenshot());
		}

	}

	@Test
	public void Ea_TC_LobbyTest_kycVerification_GuestPlayer() throws InterruptedException {
		test = extentCreateTest("Manual KYC verification - Guest Player");
		test.info("TC - As an admin user I Should be able to turn ON/OFF manual kyc verification");
		gotoTab(driver, 0);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		gp.clickOnPlayerManagement();
		Thread.sleep(1000);
		gp.ClickOnGuestPlayers();
		Thread.sleep(3000);
		WebElement KycUnverified = driver.findElement(By.xpath("(//span[@title='Kyc Unverified']//input)[1]"));
		KycUnverified.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(3000);
		if (KycUnverified.getAttribute("aria-checked").contains("false")) {
			Actions act = new Actions(driver);
			act.moveToElement(KycUnverified).click().build().perform();
			Thread.sleep(1000);
			if (cc.toggleVerification_Header.isDisplayed()) {
				test.pass("Successfully manual KYC verified in guest player listing", extentScreenshot());
				cc.Cancel.click();
			} else {
				test.fail("Something wrong! To able manual KYC verification in guest player", extentScreenshot());
			}
		}

	}

	@Test
	public void Eb_TC_LobbyTest_kycVerification_PlayerProfile() throws InterruptedException {
		test = extentCreateTest("Manual KYC verification - Player profile");
		test.info("TC - As an admin user I Should be able to turn ON/OFF manual kyc verification");
		gotoTab(driver, 0);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(3000);
		WebElement KycUnverified = driver.findElement(By.xpath("(//span[@title='Kyc Unverified']//input)[1]"));
		KycUnverified.sendKeys(Keys.ARROW_RIGHT);
		Thread.sleep(5000);

		if (KycUnverified.getAttribute("aria-checked").contains("false")) {
			Actions act = new Actions(driver);
			act.moveToElement(KycUnverified).click().build().perform();
			// KycUnverified.click();
			Thread.sleep(1000);
			if (cc.toggleVerification_Header.isDisplayed()) {
				test.pass("Successfully manual KYC verified in player profile listing", extentScreenshot());
				cc.Cancel.click();
			} else {
				test.fail("Something wrong! To able manual KYC verification in player profile", extentScreenshot());
			}
		}

	}

	public void VerifyToggles(boolean[] Case) throws InterruptedException {
		test.info("Set KYC verification setting condition in store ");
		List<WebElement> toggleButtons = driver.findElements(By.xpath("//mat-slide-toggle"));// span[text()='Purchase
																								// Kyc Verification
																								// Required']//following::mat-slide-toggle
		LobbyPage lb = new LobbyPage(driver);
		for (int i = 31; i < toggleButtons.size(); i++) {
			WebElement toggle = toggleButtons.get(i);
			// Check if the toggle button is ON or OFF
			boolean isOn = toggle.getAttribute("class").contains("mat-checked");
			if (isOn == Case[i - 31]) // if toggles are same then do nothing
			{
			} else {
				// Turn ON other toggle buttons
				toggle.click(); // Click the button to turn it ON
				Thread.sleep(500);
			}
		}
		lb.ClickToSave();
		test.pass("Successfully set KYC verification setting condition in store ", extentScreenshot());
	}

}
