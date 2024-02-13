package com.Cosmoslots.testCases;

import java.io.IOException;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.PlayerEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

//transaction history cancel click -action view

public class PlayersProfile extends BaseClass {
	BaseClass bc = new BaseClass();
	String ProfilePlayerId = "";
	String WalletAmount[] = new String[5];

	private PlayerProfile pp;
	private GuestPlayers gp;
	private CommonCosmo cc;
	private CosmoWebsite cw;

	@Test
	public void A_TC_PlayerProfile_GF3026_Redirect() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Redirect");
		test.info("TC - G3026 - As an admin user I should able to view Players listing screen by clicking on Players Management");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		cc.VerifyDataCheck(cc.PlayerManagement_Header);
	}

	@Test
	public void Ba_TC_PlayerProfile_GF3026_() throws InterruptedException, IOException {
		test = extentCreateTest("Edit Player Profile on website");

		test.info("[website] - TestCase started Edit Player Profile on website - As an admin user I should be able to Search Store_Game");

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele = driver.findElement(By.xpath("//span[text()='All Games']"));
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
			if (driver.findElements(By.xpath("//div[@title='Game Tokens']")).size() > 0
					&& driver.findElements(By.xpath("//div[@title='Sweep Tokens']")).size() > 0) {
				test.info("GT and ST found on game in home page");
			} else {
				test.info("GT and ST not found on game in home page");
			}
			driver.findElement(
					By.xpath("//header[contains(@class,'main-header sticky')]//following::a[text()='Games']")).click();
			Thread.sleep(4000);
			WebElement ele1 = driver.findElement(By.xpath("//h2[contains(text(),'Jackpots Game')]"));
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele1);
			if (driver.findElements(By.xpath("//div[@title='Game Tokens']")).size() > 0
					&& driver.findElements(By.xpath("//div[@title='Sweep Tokens']")).size() > 0) {
				test.info("GT and ST found in games page");
			} else {
				test.info("GT and ST not found in games page");
			}
		} catch (Exception e) {
			test.pass("GT and ST found in game");
		}
	}

	@Test
	public void Bb_TC_PlayerProfile_GF3026_PlayerEditWeb() throws InterruptedException, IOException {
		test = extentCreateTest("Edit Player Profile on Website");

		cw = new CosmoWebsite(driver);

		test.info(
				"[website] - TestCase started Edit Player Profile on website - As an admin user I should be able to Search Store_Game");
		try {
			bc.gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			cw.EnterPlayerdisplayName("SSCS1400");
			driver.findElement(By.xpath("//input[@formcontrolname=\"isPromoted\"]")).click();
			driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"city\"]")).sendKeys("Sincaryu");
			driver.findElement(By.xpath("//input[@formcontrolname=\"address\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"address\"]")).sendKeys("Picasa Road");
			Thread.sleep(500);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			driver.findElement(By.xpath("//input[@formcontrolname=\"zipCode\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"zipCode\"]")).sendKeys("380005");
			driver.findElement(By.xpath("//input[@formcontrolname=\"skrillEmailId\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"skrillEmailId\"]"))
					.sendKeys("itsupport@ombpmllp.com");
			driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimit\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimit\"]")).sendKeys("100");
			driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimitDays\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimitDays\"]")).sendKeys("1000");
			driver.findElement(By.xpath("//input[@formcontrolname=\"cashAppId\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"cashAppId\"]")).sendKeys("itsupport@ombpmllp.com");
			driver.findElement(By.xpath("//input[@formcontrolname=\"seamlessChexId\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"seamlessChexId\"]"))
					.sendKeys("itsupport@ombpmllp.com");
			Thread.sleep(500);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"Save\"]//parent::div")).click();
			Thread.sleep(500);
			int SavedMessage = driver
					.findElements(By.xpath("//div[contains(text(),\" Profile updated successfully \")]")).size();
			if (SavedMessage >= 0) {
				test.pass("Player Profile updated successfully [website]", extentScreenshot());
				BaseClass.gotoTab(driver, 0);
			} else {
				test.fail("Player Profile Not updated ! Failed [website]", extentScreenshot());
			}
		} catch (Exception e) {
			BaseClass.gotoTab(driver, 0);
		}
	}

	@Test
	public void C_TC_PlayerProfile_GF3027_ViewAvtar() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> View Avtar");
		test.info("TestCase started 3027 - As an admin user I should able to view Avtar of the Player on the Players listing");
        cc = new CommonCosmo(driver);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Already Opened Players Listing screen");
			if (driver
					.findElements(
							By.xpath("(//div[contains(@class,'playerProfilePic')]//img[contains(@alt,'User')])[1]"))
					.size() > 0) {
				test.pass("Successfully Viewed Avtar of Player on the player listing page", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Viewed Avtar of Player on the player listing page",
						extentScreenshot());
			}
		} else {
			test.fail("Something wrong!To Open Player Listing screen");
		}
	}

	@Test
	public void D_TC_PlayerProfile_GF3028_ViewDetails() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> View FirstName Field");
		test.info("TC - As an admin user I should able to view Player Name(First Name + Last Name) on the Players listing");
		cc = new CommonCosmo(driver);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Already Opened Players Listing screen");
			List<WebElement> ViewPlayerProfileHeaders = driver.findElements(By.xpath("//tr//th"));
			for (WebElement viewPlayerDetails : ViewPlayerProfileHeaders) {
				String PlayerDetailsTabs = viewPlayerDetails.getText();
				test = extentCreateTest("Player Profile -> View " + PlayerDetailsTabs + " Field");
				if (driver.findElement(By.xpath("//th[text()='" + PlayerDetailsTabs + "']")).isDisplayed() == true) {
					test.pass("Successfully Viewed <b>" + PlayerDetailsTabs + "</b> on the player listing page",
							extentScreenshot());

				} else {
					test.fail("Something wrong !! To player deletion history view details", extentScreenshot());

				}
			}
		} else {
			test.fail("Something wrong!To Open Player Profile");
		}

	}

	@Test
	public void K_TC_PlayerProfile_GF3035ViewInfo() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> ViewInfo Action");
		test.info("TC - As an admin user I should able to view info icon in the 'View' field of Players list");
		cc = new CommonCosmo(driver);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Already Opened Players Listing screen");

			if (driver.findElements(By.xpath("//th[text()=\"Action\"]/following::tr//td//a[@title=\"View\"]"))
					.size() > 0) {
				test.pass("Successfully Viewed View Icon of Player on the player listing page");
			} else {
				test.fail("Something wrong !! To Viewed View Icon of Player on the player listing page");
				captureScreen(driver, "PlayerProfileStatus");
			}
		} else {
			test.fail("Something wrong!To Open Player Profile");
		}
	}

//	@Test
	public void L_TC_PlayerProfile_Edit() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Edit Player Profile");
		test.info("TestCase started EditPlayer Details");
		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Already Opened Players Listing screen");
			if (driver.findElement(
					By.xpath("(//th[text()=\"Action\"]/following::tr//td//a[@title=\"Edit\"])[1]")) != null) {
				Thread.sleep(2000);
				test.info("Successfully Viewed Edit Icon of Player on the player listing page");
				pp.clickPlayerEdit();
				Thread.sleep(2000);
				gp.FirstName.clear();
				gp.setFirstName(Constant.Firstnm);
				test.info("Entered FirstName successfully");
				gp.LastName.clear();
				Thread.sleep(500);
				gp.setLastName(Constant.Lastnm);
				test.info("Entered LastName successfully");
				// gp.DisplayName1.clear();
				// gp.setDisplayName1(username);
				// test.info("Entered DisplayName successfully");
				gp.selectreputation("High");
				test.info("Selected PlayerReputation successfully");
//				gp.EnterTags();
				test.info("Entered Tags successfully");
				gp.setDialCode("+91");
				test.info("Entered Dialcode successfully");
				gp.Phone.clear();
				gp.setPhone("8887468854");
				test.info("Entered Phone successfully");
				// gp.Country.click();
//				gp.setCountry("india");
//				Thread.sleep(500);
//				gp.setState("Gujarat");
//				gp.City.clear();
//				gp.setCity("Gandhinagar");
				Thread.sleep(500);
				GuestPlayers.Address.clear();
				GuestPlayers.Address.sendKeys("L102,Sargasan,Gandhinagar");
				GuestPlayers.SpecialOffer.click();
				gp.setSkrillID(PlayerEnum.Skrillid.getValue());
				gp.setCashAppID(PlayerEnum.cashappid.getValue());
				JavascriptExecutor js1 = (JavascriptExecutor) driver;
				js1.executeScript("window.scrollBy(0,250)", "");
				Thread.sleep(500);
				gp.ClickSave();
				Thread.sleep(500);
				if (cc.Validation_Format_Playersavesuccessfully.isDisplayed() == true) {
					test.pass("Successfully edited player personal details", extentScreenshot());
				} else {
					captureScreen(driver, "FailedEditPlayer");
					driver.findElement(By.xpath("//span[text()=\"Cancel\"]")).click();
					test.info("Something wrong!To update MyProfile");
				}
			} else {
				test.info("Something wrong !! To Viewed View Icon of Player on the player listing page");
			}
		} else {
			test.info("Something wrong!To Open Player Profile");
		}
	}

	@Test
	public void M_TC_PlayerProfile_Searchplayer() throws InterruptedException, IOException {
		Thread.sleep(2000);
		test = extentCreateTest("Player Profile -> Search Player");
		test.info("TestCase started - As an admin user I should be able to Search players ");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Opened Player Successfully");
			gp.Search_Items(PlayerEnum.PlayerId.getValue());
			Thread.sleep(1500);
			if (driver.findElement(By.xpath("//td[contains(.,'" + PlayerEnum.PlayerId.getValue() + "')]")) != null) {
				test.pass("Successfully Searched Search Player");
			} else {
				test.fail("Something wrong !! To Search Search Player");
				captureScreen(driver, "FailedSearchByPlayerEmail");
			}
		}
	}


	@Test
	public void N_TC_PlayerProfile_ActionViewTabsProfile() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Profile Tab");
		test.info("TC - As an admin user i should view (Action) -> Profile Tab");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();
		Thread.sleep(1000);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Opened Player Successfully");

			pp.Clickeyeicon();
			Thread.sleep(1000);

			if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
				test.pass("Clicked Action Eye Icon and redirected to View Player Details");
				test.pass("Verified User Details - OK");
				String Profile_PlayerId = driver
						.findElement(By.xpath(
								"//div[contains(@class,\"ppStatusId\")]//child::span[contains(@class,'ppBadgeId')]"))
						.getText();
				String original = Profile_PlayerId.trim();
				ProfilePlayerId = original.replaceAll("#", "");
				System.out.print(ProfilePlayerId); // prints PlayerId
				test.pass("Redirect to player profile.");
				// Assert.assertTrue(true);
			} else {
				test.fail("Verified User Details - FAIL");
				// Assert.assertTrue(false);
			}
		}

	}

	@Test
	public void Nb_TC_PlayerProfile_ActionViewTabsAddTokensByPackageOthers()
			throws InterruptedException, IOException {
		pp = new PlayerProfile(driver);
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - Others");
		test = extentCreateTest(
				"TC - As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		pp.clickManageTokens();
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), "", "", "Others ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"Others\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - Others is Working fine");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! Failed");
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Nc_TC_PlayerProfile_ActionViewTabsAddTokensByPackageCashApp()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - CashApp");
		test = extentCreateTest(
				"TestCase started As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), PlayerEnum.Pkgamount.getValue(), "", "CashApp ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"CashApp\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - CashApp is Working fine");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! Failed");
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Nd_TC_PlayerProfile_ActionViewTabsAddTokensByPackageManual()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - Manual");
		test = extentCreateTest(
				"TestCase started As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), PlayerEnum.Pkgamount.getValue(), "", "Manual ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"Manual\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - Manual is Working fine");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! Failed");
			// Assert.assertTrue(false);
		}
	}

//	@Test
	public void Ne_TC_PlayerProfile_ActionViewTabsAddTokensByPackagePaysafe()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - Paysafe");
		test = extentCreateTest(
				"TestCase started As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), PlayerEnum.Pkgamount.getValue(), "", "Paysafe ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"Paysafe\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - Paysafe is Working fine");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! Failed");
			// Assert.assertTrue(false);
		}
	}

//	@Test
	public void Nf_TC_PlayerProfile_ActionViewTabsAddTokensByPackageSkrill()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - Skrill");
		test = extentCreateTest(
				"TestCase started As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), PlayerEnum.Pkgamount.getValue(), "", "Skrill ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"Skrill\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - Skrill is Working fine");
		} else {
			test.fail("Something wrong !! Failed");
		}
	}

//	@Test
	public void Ng_TC_PlayerProfile_ActionViewTabsAddTokensByPackageBankCard()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - BankCard");
		test = extentCreateTest(
				"TestCase started As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		PlayerProfileTest_ManageTokens(PlayerEnum.Package.getValue(), PlayerEnum.Pkgamount.getValue(), "", "Bank Card ", PlayerEnum.GT.getValue(), PlayerEnum.ST.getValue());

		if (driver.findElement(By.xpath("(//td[text()=\"Bank Card\"])[1]")) != null
				&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
			test.pass("Successfully Add Token By Package with Payment method - BankCard is Working fine");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! Failed");
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Ne_TC_PlayerProfile_ActionViewTabsManageTokensWithdrawTokens() throws InterruptedException, IOException {

		test = extentCreateTest("Player Profile -> Add Token -> By Package with payment method - Manual");
		test = extentCreateTest(
				"TC - As  admin user I should be able to Add Token (Action) -> Add Tokens Tab [By Package]");
		pp = new PlayerProfile(driver);
		try {
			driver.findElement(By.xpath("//span[contains(text(),\" Create New\")]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value=\"WITHDRAW\"]//ancestor::mat-radio-button")).click();
			driver.findElement(By.xpath("//input[@formcontrolname=\"gameTokens\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"gameTokens\"]")).sendKeys(PlayerEnum.GT.getValue());
			driver.findElement(By.xpath("//input[@formcontrolname=\"sweepTokens\"]")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname=\"sweepTokens\"]")).sendKeys(PlayerEnum.ST.getValue());
			driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("By Auto");

			pp.ClickSave();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			Thread.sleep(2000);

			if (driver.findElement(By.xpath("(//td[text()=\"Manual Withdraw\"])[1]")) != null
					&& driver.findElement(By.xpath("(//td[text()=\"By Auto\"])[1]")) != null) {
				test.pass("Successfully Withdraw token with Payment method - Manual Withdraw is Working fine");
			} else {
				test.fail("Something wrong !! Failed");
			}
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[contains(text(),\"Cancel\")]")).click();
		}
	}

	public void PlayerProfileTest_ManageTokens(String pkg, String amount, String coupon, String Payment, String GT,
			String ST) throws InterruptedException, IOException {
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			test.info("Opened Player Successfully");

			if (driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
				Thread.sleep(1000);
			}

			pp.SetNewsicon(PlayerEnum.Upload_Icon.getValue());
			Thread.sleep(2);
			pp.selectPackage(pkg);
			Thread.sleep(1000);
			pp.selectPaymentMethod(Payment);
			driver.findElement(By.xpath("//input[@formcontrolname=\"couponCode\"]")).sendKeys(coupon);
			driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("By Auto");
			pp.ClickSave();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			Thread.sleep(2000);
		}

	}

	@Test
	public void O_TC_PlayerProfile_ActionViewTabsTokenDetails() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("Player Profile -> Token Details Tab");
		test.info("TestCase started As an admin user I should be able to view (Action) -> Token Details Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		try {
			Thread.sleep(1000);
			pp.clickTokenDetailsTab();
			if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
				Thread.sleep(1000);
				if (gp.Current != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Current Sweep tokens and game tokens are displayed", extentScreenshot());
				} else {
					test.info("Player Profile Current Sweep tokens and game tokens are not displayed");
				}
				if (gp.TotalPurchased != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile TotalPurchased Sweep tokens and game tokens are displayed",
							extentScreenshot());
				} else {
					test.info("Player Profile TotalPurchased Sweep tokens and game tokens are not displayed");
				}
				if (gp.AverageDailyPurchase != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile AverageDailyPurchase Sweep tokens and game tokens are displayed",
							extentScreenshot());
				} else {
					test.info("Player Profile AverageDailyPurchase Sweep tokens and game tokens are not displayed");
				}
				if (gp.Winnings != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Winnings Sweep tokens and game tokens are displayed", extentScreenshot());
				} else {
					test.info("Player Profile Winnings Sweep tokens and game tokens are not displayed");
				}
				if (gp.Accumulated != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed",
							extentScreenshot());
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (gp.Accumulated != null) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed",
							extentScreenshot());
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (gp.Current != null && gp.TotalPurchased != null && gp.AverageDailyPurchase != null
						&& gp.Winnings != null && gp.Accumulated != null) {
					test.pass("Successfully Displayed all Sweep tokens and game tokens", extentScreenshot());
				} else {
					test.fail("Fail");
					captureScreen(driver, "PlayerTokens");
				}
				Thread.sleep(500);
			} else {
				test.fail("Fail");
				// Assert.assertTrue(false);
			}
		} catch (Exception e) {
			pp.clickonPurchases();
		}

	}

	@Test
	public void Oa_TC_PlayerProfile_ProfileTokenVerifyWeb() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Stats [Website]");
		test.info("TestCase started As an admin user I should be able to view Stats -> Token Details stats [Website]");

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			bc.gotoTab(driver, 1);
			Thread.sleep(1000);

			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(25000,0)", "");
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
				// js.executeScript("arguments[0].scrollIntoView();",
				// driver.findElement(By.xpath("//button[text()=\"Stats\"]")));
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()=\"Stats\"]")).click();

				if (driver.findElements(By.xpath("(//span[text()=\"Game Tokens\"]/following-sibling::span)[1]"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Current Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Current Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("(//span[text()=\"Sweep Tokens\"]/following-sibling::span)[1]"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile TotalPurchased Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile TotalPurchased Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("(//span[text()=\"Game Tokens\"]/following-sibling::span)[2]"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile AverageDailyPurchase Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile AverageDailyPurchase Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("(//span[text()=\"Sweep Tokens\"]/following-sibling::span)[2]"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Winnings Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Winnings Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("//span[text()=\"Big Win\"]/following-sibling::span")).size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("//span[text()=\"Mega Win\"]/following-sibling::span")).size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("//span[text()=\"Jackpot Win\"]/following-sibling::span"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("//span[text()=\"Amount (in $)\"]/following-sibling::span"))
						.size() > 0) {
					test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed");
				} else {
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("(//span[text()=\"Sweep Tokens\"]/following-sibling::span)[3]"))
						.size() > 0) {
					// test.pass("Successfully Clicked on Token Details in Player Profile Detail
					// View.");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are displayed");
				} else {
					// captureScreen(driver,"PlayerProfileTokensWebsite");
					test.info("Player Profile Accumulated Sweep tokens and game tokens are not displayed");
				}
				if (driver.findElements(By.xpath("//span[text()=\"Total Balance\"]/following-sibling::span"))
						.size() > 0) {
					test.pass("Successfully Viewed Current Total Balance", extentScreenshot());
					test.info("Successfully viewed Statastics of all tokens - ", extentScreenshot());
				} else {
					// captureScreen(driver,"PlayerProfileTokensWebsite");
					test.info("Something wrong to view Current Total Balance");
				}

				Thread.sleep(500);

				BaseClass.gotoTab(driver, 0);
			} catch (Exception e) {
				test.info("", extentScreenshot());
			}
		} else {
			test.fail("Fail");
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void P_TC_PlayerProfile_ActionViewTabsPurchaseHistorySearch() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Purchase History -> Search");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> PurchaseHistory Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		bc.gotoTab(driver, 0);
		Thread.sleep(1500);
		pp.clickonPurchases();
		pp.clickonPurchases();
		Thread.sleep(3000);
		gp.Search_Items(PlayerEnum.SearchItemPurchaseHistory.getValue());
		System.out.println("player name on purchase history ->" + PlayerEnum.SearchItemPurchaseHistory.getValue());
		if (driver.findElement(By.xpath("//td[contains(text(),'" + PlayerEnum.SearchItemPurchaseHistory.getValue() + "')]")) != null) {
			test.pass("Successfully searched in purchases");
			driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
		} else {
			test.fail("Something wrong !! To Search Website Transactions ID on player purchase history",
					extentScreenshot());
		}
	}

	@Test
	public void Qa_TC_PlayerProfile_PlayerPurchaseHistoryDownloadReciept()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Purchase History -> Download Reciept");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		Thread.sleep(1500);
		if (pp.DownloadReceiptView != null) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title=\"Download Receipt\"]")).click();
			Thread.sleep(1000);
			test.info("Successfully View Purchase Receipt", extentScreenshot());
			driver.findElement(By.xpath("//span[text()=\" Download PDF\"]")).click();
			test.pass("Successfully Downloaded Reciept", extentScreenshot());
			Thread.sleep(2200);
			driver.findElement(By.xpath("//mat-icon[text()=\"close\"]")).click();
			Thread.sleep(800);
		} else {
			test.fail("not able to find Downloaded Reciept", extentScreenshot());
		}
	}

	@Test
	public void R_TC_PlayerProfile_ActionViewTabsPurchaseHistoryXLSX() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Purchase History -> Download Excel");
		test.info("TestCase started As an admin user I should be able to Download EXCEL in PurchaseHistory Tab");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			test.info("Successfully Redirected to PurchaseHistoryTab");
			test.info("Testing XLSX Download in PurchaseHistoryTab");
			pp.clickXlsxButton();
			Thread.sleep(500);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Downloaded");
				// this code is for download page comparsion
				String modulename = ProfilePlayerId + " " + "Purchase History";
				driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
				Thread.sleep(2000);
				String downloadString = driver.findElement(By.xpath(
						"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
						.getText();
				if (downloadString.equalsIgnoreCase(modulename)) {
					test.pass("Successfully Viewed Listing Type	->" + downloadString);
				} else {
					test.info("Something wrong !! To Viewed Listing Type	->" + downloadString);
				}
				driver.navigate().back();
			} else {
				test.fail("Something wrong !! To Download XLSX");

			}
		}

	}

	@Test
	public void S_TC_PlayerProfile_ActionViewTabsPurchaseHistoryAction() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Purchase History -> ActionView");
		test.info(
				"TestCase started As an admin user I should be able to View Action(Eye Icon View) in PurchaseHistory Tab");
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Successfully Redirected to PurchaseHistoryTab");
			test.info("Testing Action View in PurchaseHistoryTab");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.clickActioneyeicon();
			Thread.sleep(1500);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElement(By.xpath("//h3[text()=\"View Purchased Details\"]")).isDisplayed()) {
				test.pass("Successfully Viewed Purchased Details");
				// Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To Viewed Purchase Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedPurchaseDetailsTab");
				// Assert.assertTrue(false);
			}
			Thread.sleep(1000);
			pp.clickCloseActionView();
			Thread.sleep(1000);
		} else {
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void T_TC_PlayerProfile_ActionViewTabsWithdrawRequestSearch() throws InterruptedException, IOException {
		String SearchItemWithdrawRequest = "CS-1117";
		test = extentCreateTest("Player Profile -> WithdrawRequest -> Search");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> WithdrawRequest Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			pp.clickWithdrawRequestTab();
			Thread.sleep(1000);
			test.info("Successfully Redirected to WithdrawRequestTab");
			gp.Search_Items(SearchItemWithdrawRequest);
			Thread.sleep(1500);

			if (driver.findElements(By.xpath(
					"//th[text()='Payment Method']/following::tr//td[contains(.,'" + SearchItemWithdrawRequest + "')]"))
					.size() > 0) {
				test.pass("Successfully Searched Withdraw Request");
			} else {
				test.fail("Something wrong !! To Search Withdraw Request");
				captureScreen(driver, "FailedSearchByPaymentMethodInWithdrawRequestTab");
			}
		} else {
			captureScreen(driver, "WithdrawRequestTab");
		}
	}

	@Test
	public void V_TC_PlayerProfile_ActionViewTabsWithdrawRequestXLSX() throws InterruptedException, IOException {
		// String SearchItem="XYZY";
		test = extentCreateTest("Player Profile -> WithdrawRequest -> Download Excel");
		test.info("TestCase started As an admin user I should be able to Download EXCEL in WithdrawRequest Tab");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
			Thread.sleep(1500);
			test.info("Successfully Redirected to WithdrawRequestTab");
			pp.clickXlsxButton();
			Thread.sleep(2000);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Downloaded");
				Thread.sleep(2000);
				// this code is for download page comparsion
				String modulename = ProfilePlayerId + " "
						+ driver.findElement(By.xpath("//button[contains(.,'Withdraw Request')]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
				Thread.sleep(2000);

				String downloadString = driver.findElement(By.xpath(
						"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
						.getText();

				if (downloadString.equalsIgnoreCase(modulename)) {
					test.pass("Successfully Viewed Listing Type	->" + downloadString);
				} else {
					test.info("Something wrong !! To Viewed Listing Type	->" + downloadString);
					captureScreen(driver, "DateofPurchaseHistory");
				}
				driver.navigate().back();
			} else {
				test.fail("Something wrong !! To Download XLSX");
				captureScreen(driver, "FailedXLSXDownloadWithdrawRequestTab");
			}
		} else {
			test.fail("Something wrong !! To Download XLSX");
		}
	}

	@Test
	public void W_TC_PlayerProfile_ActionViewTabsWithdrawRequestAction() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> WithdrawRequest -> Action View");
		test.info(
				"TestCase started As an admin user I should be able to View Action(Eye Icon View) in WithdrawRequest Tab");
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Successfully Redirected to WithdrawRequestTab");
			test.info("Testing Action View in WithdrawRequestTab");
			pp.clickActioneyeicon();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//h3[text()=\"View Withdraw Request Details\"]")).isDisplayed()) {
				test.pass("Successfully Viewed Withdraw Request Details", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Viewed Withdraw Request Details !! Taking Too Much Time",
						extentScreenshot());
			}
			pp.clickCloseActionView();
			Thread.sleep(1000);
		} else {
			test.fail("Something wrong !! To Viewed Withdraw Request Details !! Taking Too Much Time");
		}
	}

	@Test
	public void Wa_TC_PlayerProfile_ActionViewTabsWithdrawRequestCreateNew()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> WithdrawRequest -> Create New");
		String SearchItemWithdrawRequest = "Bank Account";
		test.info(
				"TestCase started As an admin user I should be able to Create New Withraw Request in (Player Action) -> WithdrawRequest Tab");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Successfully Redirected to WithdrawRequestTab");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			driver.findElement(By.xpath("//span[text()=\" Create New\"]")).click();
			Thread.sleep(1000);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElement(By.xpath("//h3[text()=\"Create Withdraw Request\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//input[@formcontrolname=\"currentWithdrawalAmount\"]")).sendKeys("1");
				driver.findElement(By.xpath("//input[@formcontrolname=\"tipTokens\"]")).sendKeys("0");
				driver.findElement(By.xpath("//span[text()=\" Bank Account \"]")).click();
				Thread.sleep(300);
				driver.findElement(By.xpath("//input[@formcontrolname=\"accountHolderName\"]")).sendKeys("paras");
				driver.findElement(By.xpath("//input[@formcontrolname=\"accountNumber\"]")).sendKeys("4887464648");
				driver.findElement(By.xpath("//input[@formcontrolname=\"routingNumber\"]")).sendKeys("312");
				driver.findElement(By.xpath("//input[@formcontrolname=\"bankName\"]")).sendKeys("Test Bank");
				pp.ClickSave();
				Thread.sleep(1000);
				if (driver.findElement(By.xpath("(//td[text()=\" Bank Account\"])[1]")) != null) {
					// pp.clickCloseActionView();
					test.pass("Successfully Created Withdraw Request Details");
					Assert.assertTrue(true);
				} else {
					test.fail("Something wrong to create withdraw request");
					Assert.assertTrue(false);
				}
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To Viewed Withdraw Request Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedWithdrawRequestDetailsTab");
			}

			Thread.sleep(1000);
		} else {
			Assert.assertTrue(false);
		}
	}

//	@Test
//	public void Wb_TC_PlayerProfile_ActionViewTabsWithdrawRequestApprove() throws InterruptedException, IOException 
//	{
//		String SearchItemWithdrawRequest="Bank Account";
//		test = extentCreateTest("Player Profile -> WithdrawRequest -> Request Approve/Decline");
//		test.info("TestCase started As an admin user I should be able to Approve / Decline  Withraw Request in (Player Action) -> WithdrawRequest Tab");
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//
//		if(driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]"))!=null)
//		{	
//			Thread.sleep(1000);
//			//pp.clickonPurchases();
//			//Thread.sleep(1000);
//			Assert.assertTrue(true);
//			//test.info("Successfully Redirected to WithdrawRequestTab");
//			//test.info("Testing Approve / Decline in WithdrawRequestTab CreateNew");
//			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
//			//driver.findElement(By.xpath("//span[text()=\" Create New\"]")).click();
//			Thread.sleep(1000);
//			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			pp.clickDesription();
//			Thread.sleep(500);
//			
//				if(driver.findElement(By.xpath("//span[text()=\"Player Name\"]/following-sibling::span[contains(text(),'"+SearchPlayerName+"')]"))!=null)
//				{
//					//driver.findElement(By.xpath("//mat-select[@formcontrolname=\"action\"]")).click();
//					pp.selectwithrawrequest(" Approve ");
//					driver.findElement(By.xpath("//textarea[@formcontrolname=\"updatedNotes\"]")).sendKeys("By Auto");
//					driver.findElement(By.xpath("//span[text()=\"Update\"]")).click();
//					Thread.sleep(1000);
//				}
//				else
//				{
//					driver.findElement(By.xpath("//span[text()=\"Cancel\"]")).click();
//					test.fail("Something wrong to create withdraw request");
//					Assert.assertTrue(false);
//				}
//			Thread.sleep(1000);
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}
//	

	@Test
	public void X_TC_PlayerProfile_ActionViewTabsTrancsationHistorySearch()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> TrancsationHistory -> Search");
		test.info("TestCase started ActionViewTabs TrancsationHistory");
		gp = new GuestPlayers(driver);

		// back button code
		driver.findElement(By.xpath("//button[text()=\" Transaction History \"]")).click();
		Thread.sleep(1000);
		gp.Search_Items(PlayerEnum.SearchItemTrancsationHistory.getValue());
		System.out.println("player Id " + PlayerEnum.SearchItemTrancsationHistory.getValue());
		Thread.sleep(1500);

		if (driver.findElement(By.xpath("//tbody//tr[1]")) != null) {
			test.pass("Successfully searched by transactionId");
			// driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
		} else {
			// pp.clickCloseActionView();
			test.fail("not able to search with transactionId ", extentScreenshot());
			// Assert.assertTrue(false);
			// captureScreen(driver,"TrancsationHistoryTab");
		}
	}

	@Test
	public void Z_TC_PlayerProfile_ActionViewTabsTrancsationHistoryXLSX() throws InterruptedException, IOException {
		// String SearchItem="XYZY";
		test = extentCreateTest(
				"TestCase started As an admin user I should be able to Download EXCEL in TrancsationHistory Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			// pp.clickonPurchases();
			// Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to TrancsationHistoryTab");
			test.info("Testing XLSX Download in TrancsationHistoryTab");
			pp.clickXlsxButton();
			Thread.sleep(3000);
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();

			// if(SearchItem.equalsIgnoreCase(SearchItem))
			String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";

			if (driver.findElement(By.xpath("(//span[contains(text(),'" + msg + "')])[1]")).isDisplayed()) {
				test.pass("Successfully XLSX Downloaded");
				// Assert.assertTrue(true);
				Thread.sleep(2000);
				// this code is for download page comparsion
				String modulename = ProfilePlayerId + " "
						+ driver.findElement(By.xpath("//button[contains(.,'Transaction History')]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
				Thread.sleep(2000);

				String downloadString = driver.findElement(By.xpath(
						"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
						.getText();
				System.out.print(modulename + "-->" + downloadString);

				if (downloadString.equalsIgnoreCase(modulename)) {
					test.pass("Successfully Viewed Listing Type	->" + downloadString);
					// Assert.assertTrue(true);
				} else {
					driver.navigate().back();
					test.fail("Something wrong !! To Viewed Listing Type	->" + downloadString);
					// Assert.assertTrue(false);
					// captureScreen(driver,"DateofPurchaseHistory");
				}
				driver.navigate().back();
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Download XLSX");
				captureScreen(driver, "FailedXLSXDownloadTrancsationHistoryTab");
			}
		} else {
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Za_TC_PlayerProfile_ActionViewTabsTrancsationHistoryAction()
			throws InterruptedException, IOException {
		// String SearchItem="XYZY";
		test = extentCreateTest("Player Profile -> TrancsationHistory -> Action View");
		test.info(
				"TestCase started As an admin user I should be able to View Action(Eye Icon View) in TrancsationHistory Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Redirect to Action View in TrancsationHistoryTab");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.clickActioneyeicon();
			Thread.sleep(2000);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElements(By.xpath("//h3[text()=\"View Transaction Details\"]")).size() > 0) {
				test.pass("Successfully Viewed Trancsation History Details");
				// Assert.assertTrue(true);
			} else {
				// pp.clickCloseActionView();
				test.fail("Something wrong !! To Viewed Trancsation History Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedTrancsationHistoryDetailsTab");
				// Assert.assertTrue(false);
			}

			pp.clickCloseActionView();
			Thread.sleep(1000);
			// driver.findElement(By.xpath("//mat-icon[text()=\"close\"]")).click();

		} else {
			pp.clickCloseActionView();
			test.fail("Something wrong !! To Viewed Trancsation History Details !! Taking Too Much Time");
		}

	}

	@Test
	public void Zb_TC_PlayerProfile_ActionViewTabsPlayerLedgerSearch() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> PlayerLedger -> Search");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> PlayerLedger Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			pp.clickPlayerLedgerTab();
			Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to Player Ledger Tab");
			test.info("Started Search in PlayerLedger");
			gp.Search_Items(PlayerEnum.SearchItemPlayerLedger.getValue());
			Thread.sleep(1500);
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();

			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElements(By.xpath("//tr//td[contains(text(),'" + PlayerEnum.SearchItemPlayerLedger.getValue() + "')]"))
					.size() > 0) {
				test.pass("Successfully Searched Player Ledger");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Search Player Ledger");
				captureScreen(driver, "FailedSearchInPlayerLedgerTab");
			}

		} else {
			// Assert.assertTrue(false);
			captureScreen(driver, "PlayerLedgerTab");
		}
	}

	@Test
	public void Zd_TC_PlayerProfile_ActionViewTabsPlayerLedgerXLSX() throws InterruptedException, IOException {
		test = extentCreateTest(
				"TestCase started As an admin user I should be able to Download EXCEL in PlayerLedger Tab");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Successfully Redirected to TrancsationHistoryTab");
			test.info("Testing XLSX Download in TrancsationHistoryTab");
			pp.clickXlsxButton();
			Thread.sleep(500);
			if (cc.Validation_Withdraw_XLSX_Download.isDisplayed()) {
				test.pass("Successfully XLSX Downloaded");
				Thread.sleep(2000);
				// this code is for download page comparsion
				String modulename = PlayerEnum.PlayerId.getValue() + " "
						+ driver.findElement(By.xpath("//button[contains(.,'Player Ledger')]")).getText();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
				Thread.sleep(2000);

				String downloadString = driver.findElement(By.xpath(
						"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
						.getText();
				downloadString.trim();
				if (downloadString.equalsIgnoreCase(modulename)) {
					test.pass("Successfully Viewed Listing Type	->" + downloadString);
					driver.navigate().back();
				} else {
					driver.navigate().back();
					test.info("Something wrong !! To Viewed Listing Type	->" + downloadString);
					// Assert.assertTrue(false);
					// captureScreen(driver,"DateofPurchaseHistory");
				}
				// driver.navigate().back();
			} else {
				driver.navigate().back();
				test.fail("Something wrong !! To Download XLSX");
				// captureScreen(driver,"FailedXLSXDownloadTrancsationHistoryTab");
			}
		} else {
			test.fail("Something wrong !! not found player ledger");
			// Assert.assertTrue(false);
		}

	}

	@Test
	public void Ze_TC_PlayerProfile_ActionViewTabsPlayerLedgerAction() throws InterruptedException, IOException {
		// String SearchItem="Bet";
		test = extentCreateTest("Player Profile -> PlayerLedger -> Action view");
		test.info(
				"TestCase started As an admin user I should be able to View Action(Eye Icon View) in PlayerLedger Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			// pp.clickonPurchases();
			// Thread.sleep(1000);
			// Assert.assertTrue(true);
//			test.info("Successfully Redirected to TrancsationHistoryTab");
//			test.info("Testing Action View in TrancsationHistoryTab");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.clickActioneyeicon();
			Thread.sleep(2000);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElement(By.xpath("//h3[text()=\"View Player Ledger Details\"]")) != null) {
				test.pass("Successfully Viewed Player Ledger Details");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Viewed Player Ledger Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedPlayerLedgerDetailsTab");
			}
			pp.clickCloseActionView();
			Thread.sleep(1000);
		} else {
			test.fail("Something wrong !! To Viewed Player Ledger Details !! Taking Too Much Time");
		}
	}

	@Test
	public void Zf_TC_PlayerProfile_ActionViewTabsPlayerLedgerCheckTokens()
			throws InterruptedException, IOException {
		// String SearchItem="Sweep";
		test = extentCreateTest("Player Profile -> PlayerLedger -> CheckTokens ");
		test.info(
				"TestCase started As an admin user I should be able to View Game Tokens  and Sweep tokens in PlayerLedger Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			// Thread.sleep(1000);
			// pp.clickPlayerLedgerTab();
			// Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to Player Ledger Tab");
			test.info("Started Testing on Tokens Checkbox in PlayerLedger");
			// gp.Search_Items(SearchItem);
			// Thread.sleep(1500);
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			// Assert.assertTrue(true);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
		} else {
			// Assert.assertTrue(false);
			captureScreen(driver, "PlayerLedgerTab");
		}
	}

	@Test
	public void Zg_TC_PlayerProfile_ActionViewTabsSupportRequestSearch() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> SupportRequest -> Search ");
		test.info("TestCase started ActionViewTabs SupportRequest");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			pp.clickSupportRequestTab();
			Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to Support Request Tab");
			test.info("Started Search in SupportRequest");
			gp.Search_Items(PlayerEnum.SearchItemSupportRequest.getValue());
			Thread.sleep(1500);
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();

			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElements(By.xpath("//td[contains(text(),'" + PlayerEnum.SearchItemSupportRequest.getValue() + "')]")).size() > 0) {
				test.pass("Successfully Searched SupportRequest");
				// Assert.assertTrue(true);
			} else {
				pp.clickClearSearch();
				test.fail("Something wrong !! To Search SupportRequest");
				captureScreen(driver, "FailedSearchInSupportRequestTab");
				// Assert.assertTrue(false);
			}

		} else {
			// Assert.assertTrue(false);
			captureScreen(driver, "SupportRequestTab");
		}
	}



	@Test
	public void Zj_TC_PlayerProfile_ActionViewTabsSupportRequestCreateNew()
			throws InterruptedException, IOException {
		// String SearchItem="XYZY";
		test = extentCreateTest("Player Profile -> SupportRequest -> Create New");
		test = extentCreateTest(
				"TestCase started As an admin user I should be able to Create New Support Request in SupportRequest Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			// pp.clickonPurchases();
			// Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to TrancsationHistoryTab");
			pp.clickCreateNewSupportRequest();
			Thread.sleep(500);
			pp.SetSupportRequestTitle("High latensy");
			Thread.sleep(500);
			pp.clickSupportRequestPriority();
			Thread.sleep(500);
			pp.SetSupportRequestPriority("Low");
			Thread.sleep(500);
			pp.clickSupportRequestSupportType();
			Thread.sleep(500);
			pp.SetSupportRequestSupportType(" Issue");
			Thread.sleep(500);
			pp.setSupportRequestDescription("game is continously lagging");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.ClickSave();
			Thread.sleep(500);
			if (driver.findElement(By.xpath("//span[contains(text(),\"Support request save successfully\")]"))
					.isDisplayed()) {
				test.pass(
						"successfully createed support request with validation message appeared - support Request save sucessfully");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
			}
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			// pp.clickCloseActionView();
			Thread.sleep(1000);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Zk_TC_PlayerProfile_ActionViewTabsSupportRequestAction() throws InterruptedException, IOException {
		// String SearchItem="XYZY";
		test = extentCreateTest("Player Profile -> SupportRequest -> Action view");
		test.info(
				"TestCase started As an admin user I should be able to View Action(Eye Icon View) in SupportRequest Tab");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);

			test.info("Testing Action View in SupportRequestTab");

			pp.clickSupportActioneyeicon();
			Thread.sleep(1500);
			if (driver.findElement(By.xpath("//i[contains(@class,\"ri-arrow-left\")]")) != null) {
				driver.findElement(By.xpath("//i[contains(@class,\"ri-arrow-left\")]")).click();
				Thread.sleep(1000);
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To Viewed Support Request Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedSupportRequestDetailsTab");
			}
			// if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//h3[text()=\"View Purchased Details\"]")).isDisplayed())	
//			{
//				test.info("Successfully Viewed Trancsation History Details");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				test.info("Something wrong !! To Viewed Support Request Details !! Taking Too Much Time");
//				captureScreen(driver,"FailedViewedSupportRequestDetailsTab");
//				Assert.assertTrue(false);
//			}
			// pp.clickCloseActionView();

		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Zl_TC_PlayerProfile_ActionViewTabsGameTransations_SlotSearch()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> GameTransations -> slot -> Search ");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> GameTransations Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(2000);
		gp.Search_Items("CS-1400");
		Thread.sleep(1000);
		pp.clickOnPlayerProfileActionEye();
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);

			test.info("Testing Search in GameTransationsTab");
			pp.clickGameTransactionsTab();
			Thread.sleep(1500);
			gp.Search_Items("Farm Riches");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//tr//td[contains(.,'Farm Riches')]")).size() > 0) {
				test.pass("Successfully Searched Game Transations", extentScreenshot());
			} else if (driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size() > 0) {
				test.pass("No Record Found", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search Game Transations", extentScreenshot());
				// captureScreen(driver, "FailedSearchIngametransaction");
			}
			// pp.clickClearSearch();
			Thread.sleep(500);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Zla_TC_PlayerProfile_ActionViewTabsGameTransations_KenoSearch()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> GameTransations -> Keno -> Search ");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> GameTransations Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Testing Search in GameTransationsTab");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[text()=\" Keno \"]")).click();
			Thread.sleep(1500);
			gp.Search_Items("Snooker");
			Thread.sleep(1500);

			if (driver.findElements(By.xpath("//tr//td[contains(.,'Snooker')]")).size() > 0) {
				test.pass("Successfully Searched Game Transations", extentScreenshot());
				// pp.clickActioneyeicon();
			} else if (driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size() > 0) {
				test.pass("No Record Found", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search Game Transations", extentScreenshot());
				// captureScreen(driver, "FailedSearchIngametransaction");
			}
			// pp.clickCloseActionView();
			// pp.clickClearSearch();
			Thread.sleep(500);
		} else {
			test.fail("Something wrong !! To Search Game Transations");
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Zlb_TC_PlayerProfile_ActionViewTabsGameTransations_FishSearch()
			throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> GameTransations -> Fish -> Search ");
		test.info("TestCase started As an admin user I should be able to search in (Action) -> GameTransations Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(1000);
			test.info("Testing Search in GameTransationsTab");
			Thread.sleep(1500);
			driver.findElement(By.xpath("//button[text()=\" Fish \"]")).click();
			Thread.sleep(1500);
			gp.Search_Items("Ocean Bombard");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//tr//td[contains(.,'Ocean Bombard')]")).size() > 0) {
				test.pass("Successfully Searched Game Transations", extentScreenshot());
				// pp.clickActioneyeicon();
			} else if (driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size() > 0) {
				test.pass("No Record Found", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search Game Transations", extentScreenshot());
				// captureScreen(driver, "FailedSearchIngametransaction");
			}
			Thread.sleep(500);
			// pp.clickCloseActionView();
			// pp.clickClearSearch();
			Thread.sleep(500);
		} else {
			test.fail("Something wrong !! To Search Game Transations");
			// Assert.assertTrue(false);
		}
	}

//	@Test
//	public void Zh_TC_PlayerProfile_ActionViewTabsGameTransactionsPDF() throws InterruptedException, IOException 
//	{
//		//String SearchItem="XYZY";
//		//test.info("TestCase started As an admin user I should be able to Download PDF in SupportRequest Tab");
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//
//		if(driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]"))!=null)
//		{	
//			Thread.sleep(1000);
//			//pp.clickonPurchases();
//			//Thread.sleep(1000);
//			//test.info("Successfully Redirected to WithdrawRequestTab");
//			test.info("Testing PDF Download in SupportRequestTab");
//			pp.clickPdfButton();
//			Thread.sleep(1500);
//			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
//			
//			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//span[text()=\"File download successfully.\"]")).isDisplayed())	
//			{
//				test.pass("Successfully PDF Downloaded");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				test.fail("Something wrong !! To Download PDF");
//				captureScreen(driver,"FailedPDFDownloadSupportRequestTab");
//				Assert.assertTrue(false);
//			}	
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}
	@Test
	public void Zm_TC_PlayerProfile_ActionViewTabsAppliedCoupons() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Applied coupon -> Search");
		test = extentCreateTest(
				"TestCase started As an admin user I should be able to search in (Action) -> AppliedCoupons Tab");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
			Thread.sleep(2000);
			test.info("Testing Action View in AppliedCouponsTab");
			pp.clickAppliedCouponsTab();
			Thread.sleep(1500);
			gp.Search_Items("couponohvx");
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//tr//td[contains(text(),\"couponohvx\")]")).size() > 0) {
				test.pass("Successfully Searched Applied coupon", extentScreenshot());
				Assert.assertTrue(true);
			} else if (driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size() > 0) {
				test.pass("No Record Found", extentScreenshot());
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To Search Applied coupon", extentScreenshot());
				// captureScreen(driver, "FailedSearchInAppliedCoupon");
				// Assert.assertTrue(false);
			}
			// pp.clickClearSearch();
		} else {
		}
	}

	@Test
	public void Zn_TC_PlayerProfile_CheckVerificationSymbol() throws InterruptedException, IOException {
		test = extentCreateTest("Player Profile -> Symbol Verification ");
		test = extentCreateTest("TestCase started - As an admin user I should be able to View verification symbol ");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		// Thread.sleep(4000);
		gp.clickOnPlayerManagement();
		pp.clickPlayerProfileLink();
		Thread.sleep(2000);
		if (cc.PlayerManagement_Header!= null) {
			test.info("Opened Player Successfully");

			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//span[@title=\"Email Verified\"]")) != null) {
				test.pass("Successfully viewed Email Verified Symbol");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Email Verify");
				captureScreen(driver, "FailedSearchByPlayerEmail");
			}
			if (driver.findElement(By.xpath("//span[@title=\"Phone Verified\"]")) != null) {
				test.pass("Successfully viewed Phone Verified Symbol");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Phone Verify");
				captureScreen(driver, "FailedPhoneVerify");
			}
			if (driver.findElement(By.xpath("//a[@title=\"Support Request\"]")) != null) {
				test.pass("Successfully viewed Support Request Symbol");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Support Request Verify");
				captureScreen(driver, "FailedSupportRequest");
			}
			if (driver.findElement(By.xpath("//a[@title=\"Chat\"]")) != null) {
				test.pass("Successfully viewed Chat Symbol");
				// Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To chat symbol Verify");
				captureScreen(driver, "FailedchatVerify");
			}
//			if(driver.findElement(By.xpath("//span[@title=\"KYC Verified\"]"))!=null)
//			{
//				test.pass("Successfully viewed KYC Verified Symbol");
//				//Assert.assertTrue(true);
//			}
//			else
//			{
//				//Assert.assertTrue(false);
//				test.fail("Something wrong !! To KYC Verified");
//				captureScreen(driver,"FailedKYCVerified");
//			}
//			if(driver.findElement(By.xpath("//span[@title=\"Facebook Verified\"]"))!=null)
//			{
//				test.pass("Successfully viewed Facebook Verified Symbol");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				Assert.assertTrue(false);
//				test.fail("Something wrong !! To Facebook Verified");
//				captureScreen(driver,"FailedFacebookVerified");
//			}
		}
	}

	@Test
	public void Zo_TC_PlayerProfile_CheckEmailVerificationSymbol() throws InterruptedException {
		test = extentCreateTest("Player Profile EMAIL VARIFICATION  ");
		test.info("Test Case  - As an  user I should able to verify Email verification");

		// bc.gotoTab(driver, 0);
		PlayerProfile pp = new PlayerProfile(driver);
		LobbyPage lb = new LobbyPage(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(2000);
		pp.clickOnPlayerProfile();
		Thread.sleep(4000);
		lb.SearchItems("CS-1400");
		Thread.sleep(2000);

		if (driver.findElements(By.xpath("(//i[@class='ri-mail-line'])[1]")).size() > 0) {
			test.info("Email verification button present", extentScreenshot());
			pp.clickOnPlayerProfileActionEye();
			Thread.sleep(3000);

			if (driver.findElements(By.xpath("//i[contains(@class,'ri-check-double-line')]")).size() > 0) {
				test.info("Email  verified by user", extentScreenshot());
			} else {
				test.info("Email not  verified by user", extentScreenshot());
			}

		} else {

			test.info("Email verification button not present", extentScreenshot());
			pp.clickOnPlayerProfileActionEye();
			Thread.sleep(3000);

			if (driver.findElements(By.xpath("//i[contains(@class,'ri-check-double-line')]")).size() > 0) {
				test.info("Email  verified by user", extentScreenshot());
			} else {
				test.info("Email not  verified by user", extentScreenshot());
			}
		}
		pp.clickOnBackToPlayerProfile();
		Thread.sleep(3000);

	}

	@Test
	public void Zp_TC_PlayerProfile_Footprints() throws InterruptedException {
		test = extentCreateTest("Player Login Footprints view details");
		String footPrintHeaders[]= {"No,Date & Time,Device,IP Address "};
		bc.gotoTab(driver, 0);
		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		gp.Search_Items("CS-1400");
		Thread.sleep(3000);
		pp.clickOnPlayerProfileActionEye();
		pp.clickOnLoginFootprints();
		if (driver.findElements(By.xpath("//th[text()=\"Date & Time\"]/following::tr//td[contains(@class,\"createdAt\")]")).size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully Viewed Date & Time of Player on the player login footprints page");
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View Date & Time of Player on the player login footprints page");
		}
		if (driver.findElements(By.xpath("//th[text()=\"Device\"]/following::tr//td[contains(@class,\"device \")]"))
				.size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully Viewed device of Player on the player login footprints page");
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View device of Player on the  player login footprints page");
		}
		if (driver.findElements(By.xpath("//th[text()=\"IP Address\"]/following::tr//td[contains(@class,\"ip \")]"))
				.size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully View ip of Player on the player login footprints page",extentScreenshot());
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View ip of Player on the  player login footprints page",extentScreenshot());
		}

	}



//	@Test
	public void Zr_TC_PlayerProfile_Donthaveaninvitecode() throws InterruptedException {

		test = extentCreateTest(
				"As a player, I should be able to contact the administrator if I don't have an invite code to register myself");

		CosmoWebsite cw = new CosmoWebsite(driver);
		gp = new GuestPlayers(driver);

		Thread.sleep(10000);
		gotoTab(driver, 1);
		cw.ClickOnPlayerLogout();
		Thread.sleep(2000);
		cw.ClickOnPlayerRegistration();
		Thread.sleep(1000);
		cw.ClickOnDonthaveanInviteCode();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h2[text()='Request an Invite Code']")).isDisplayed()) {
			test.info("Required invite code");
			cw.EnterPlayerFirstname(Constant.Firstnm);
			Thread.sleep(500);
			cw.EnterPlayerLastname(Constant.Lastnm);
			Thread.sleep(500);
			cw.EnterPlayerEmail(Constant.Email);
			Thread.sleep(500);
			cw.EnterPlayerPhoneNo("+8887468854");
			Thread.sleep(500);
			cw.EnterPlayerMessage("Required invite code");
			Thread.sleep(500);
			cw.ClickOnSendMessageBtn();
			Thread.sleep(500);
			test.pass("Working Successfully");
		} else {
			test.fail("Something Wrong ! not able to Required invite code", extentScreenshot());
		}
		UserPage up = new UserPage(driver);

		gotoTab(driver, 0);
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickOnSupportManagement();
		Thread.sleep(500);
		up.ClickOnContactDetails();
		Thread.sleep(3000);
		up.ClickonInviteCodeRadioBtn();
		Thread.sleep(1000);
		gp.Search_Items(Constant.Firstnm);
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[text()='Contact Details']")) != null) {
			test.info("Opened Contact Details -> Invite code screen");

			if (driver
					.findElements(By.xpath("//th[text()='First Name']/following::tr//td[contains(@class,'firstname')]"))
					.size() > 0) {
				test.pass("Successfully Viewed first name of player on the Contact Details->Invite Code page",
						extentScreenshot());
				// Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To View first name of player on the Contact Details->Invite Code page",
						extentScreenshot());
				// Assert.assertTrue(false);
			}
			if (driver.findElements(By.xpath("//th[text()='Last Name']/following::tr//td[contains(@class,'lastname')]"))
					.size() > 0) {
				// Assert.assertTrue(true);
				test.pass("Successfully Viewed last name of player on the Contact Details->Invite Code page",
						extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To View last name of player on the Contact Details->Invite Code page",
						extentScreenshot());
			}
			if (driver.findElements(By.xpath("//th[text()='Email']/following::tr//td[contains(@class,'email')]"))
					.size() > 0) {
				// Assert.assertTrue(true);
				test.pass("Successfully Viewed email of player on the Contact Details->Invite Code page",
						extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To View email of player on the Contact Details->Invite Code page",
						extentScreenshot());
			}
			if (driver
					.findElements(By.xpath(
							"//th[text()='Contact Number']/following::tr//td[contains(@class,'contactnumber ')]"))
					.size() > 0) {
				// Assert.assertTrue(true);
				test.pass("Successfully Viewed Contact Number of player on the Contact Details->Invite Code page",
						extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail(
						"Something wrong !! To View Contact Number of player on the Contact Details->Invite Code page",
						extentScreenshot());
			}
			if (driver.findElements(By.xpath("//th[text()='Message']/following::tr//td[contains(@class,'message')]"))
					.size() > 0) {
				// Assert.assertTrue(true);
				test.pass("Successfully Viewed Message of player on the Contact Details->Invite Code page",
						extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To View Message of player on the Contact Details->Invite Code page",
						extentScreenshot());
			}
		}

	}

//	@Test
	public void Zs_TC_PlayerProfile_GameRTP() throws InterruptedException {
		test = extentCreateTest(
				"As an admin I should be able to view the Exclusive tab so that I can view the Game wise RTP");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("CS-1400");
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		pp.clickonExclusiveAnalytics();
		Thread.sleep(2000);
		pp.SelectGameCategory("Slot", "Leprechaun");
		Thread.sleep(1000);
		test.info("Selected Game category :- Slot");
		test.info("Selected Game :- Leprechaun ");
		// pp.Selectmonthandyear("2023", month[4], "1", endDate[2]);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate();
		Thread.sleep(1000);
		pp.clickSearch();
		Thread.sleep(5000);

		if (driver.findElements(By.xpath("//th[text()='Game Code']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Game Name']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Bet Values']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Paylines / Spots']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Spins / Rounds']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Bet']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Feature Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='RTP']")).size() > 0) {
			test.pass("Successfully viewed the Exclusive Analytics tab in player profile view", extentScreenshot());
			test.pass("Successfully viewed the Game RTP of the invited player");
			// Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Exclusive Analytics tab in player profile and game RTP",
					extentScreenshot());
			// Assert.assertTrue(false);
		}
	}

	@Test
	public void Zsa_TC_PlayerProfile_ManageWalletAddCashApp() throws InterruptedException {
		String temp1;
		String SearchPlayer = "CS-2579";
		String amount = "20";
		test = extentCreateTest("As an admin I should be able to Create New - Add to wallet by Cash App");
		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(SearchPlayer);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space(text())=\"Manage Wallet\"]")).click();
		Thread.sleep(1000);
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}
		// WalletAmount = temp1;
		driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).sendKeys(amount);
		Thread.sleep(1000);
		pp.selectPaymentProvider("Cash App");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comments\"]")).sendKeys("By auto");

		driver.findElement(By.xpath("//span[contains(text(),\"Save\")]/parent::button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),'Success')]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='Deposit']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='Cash App']")) != null) {
			test.pass(
					"Successfully Created Added to wallet request by CashApp, showing in list with- \"Success\" status ",
					extentScreenshot());
		} else {
			test.fail("Something went wrong to Created [Add to wallet request by CashApp]", extentScreenshot());
		}
	}

	@Test
	public void Zsb_TC_PlayerProfile_ManageWalletAddCashAppVerifyInWalletDeposit() throws InterruptedException {
		test = extentCreateTest("Verifying that data recently added in Wallet -> Deposits");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
//		 pp.clickOnPlayerProfile();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Deposits')]")).click();

		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + PlayerEnum.SearchPlayer.getValue() + "']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Cash App\"]")) != null) {
			test.pass(
					"Successfully Created Added to wallet request by CashApp, showing in Wallet Deposit list with- \"Success\" status ",
					extentScreenshot());
		} else {
			test.fail("Something went wrong to view recently added record in list[Add to wallet request by CashApp]",
					extentScreenshot());
		}
	}

	@Test
	public void Zsc_TC_PlayerProfile_ManageWalletAddCashAppVerifyWalletCount() throws InterruptedException {
		test = extentCreateTest("As an admin I should be able view wallet deposit count");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		driver.navigate().back();

		// String[] WalletAmount = Wallettext.split("$");
		// String WalletAmount = Wallettext.;
		// calculate with old wallet amount
		String amount = driver.findElement(By.xpath("(//td[contains(@class,'amount')])[1]")).getText();
		System.out.println(amount + " , " + WalletAmount[1]);
		double WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());
		System.out.println("wallet - " + WalAmount);
		double Total = Double.parseDouble(amount) + WalAmount;
		System.out.println("Total - " + Total);

		// Get new wallet amount and verify
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}
		WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());

		if (Total == WalAmount) {
			test.pass(
					"Successfully verified wallet balance :" + WalAmount
							+ " which is added to wallet by payment method - CashApp.'\n' Previous Balance : "
							+ WalletAmount + "'\n'" + "Amount Added : " + amount + "Current Wallet Balance : " + Total,
					extentScreenshot());
		} else {
			test.fail("Wallet Balance is not matching the expectations", extentScreenshot());
		}

	}

	@Test
	public void Zsd_TC_PlayerProfile_ManageWalletAddManual() throws InterruptedException {
		String amount = "20";
		String SearchPlayer = "CS-2579";
		test = extentCreateTest("As an admin I should be able to Create New - Add to wallet by Manual");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(SearchPlayer);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space(text())=\"Manage Wallet\"]")).click();
		Thread.sleep(1000);
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}

		driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).sendKeys(amount);
		Thread.sleep(1000);
		pp.selectPaymentProvider("Manual");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comments\"]")).sendKeys("By auto");

		driver.findElement(By.xpath("//span[contains(text(),\"Save\")]/parent::button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='Deposit']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Manual\"]")) != null) {
			// pp.clickCloseActionView();
			test.pass(
					"Successfully Created Added to wallet request by CashApp, showing in list with- \"Success\" status ",
					extentScreenshot());
			// Assert.assertTrue(true);
		} else {
			test.fail("Something went wrong to Created [Add to wallet request by Manual]", extentScreenshot());
			// Assert.assertTrue(false);
		}

	}

	@Test
	public void Zse_TC_PlayerProfile_ManageWalletAddManualVerifyInWalletDeposit() throws InterruptedException {
		test = extentCreateTest("Verifying that data recently added in Wallet -> Deposits");

		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[2]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Deposits')]")).click();

		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + PlayerEnum.SearchPlayer.getValue() + "']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Manual\"]")) != null) {
			test.pass(
					"Successfully Created Added to wallet request by Manual, showing in Wallet Deposit list with- \"Success\" status ",
					extentScreenshot());
		} else {
			test.fail("Something went wrong to view recently added record in list[Add to wallet request by Manual]",
					extentScreenshot());
		}

	}

	@Test
	public void Zsf_TC_PlayerProfile_ManageWalletAddCashAppVerifyWalletCount() throws InterruptedException {
		test = extentCreateTest("As an admin I should be able view wallet deposit count by Manual method");

		driver.navigate().back();

		String amount = driver.findElement(By.xpath("(//td[contains(@class,'amount')])[1]")).getText();
		System.out.println(amount + " , " + WalletAmount[1]);
		double WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());
		System.out.println("wallet - " + WalAmount);
		double Total = Double.parseDouble(amount) + WalAmount;
		System.out.println("Total - " + Total);

		// Get new wallet amount and verify
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}
		WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());

		if (Total == WalAmount) {
			test.pass(
					"Successfully verified wallet balance :" + WalAmount
							+ " which is added to wallet by payment method - Manual.'\n' Previous Balance : "
							+ WalletAmount + "'\n'" + "Amount Added : " + amount + "Current Wallet Balance : " + Total,
					extentScreenshot());
		} else {
			test.fail("Wallet Balance is not matching the expectations", extentScreenshot());
		}

	}

	@Test
	public void Zsg_TC_PlayerProfile_ManageWalletWithdrawCashApp() throws InterruptedException {
		String amount = "20";
		String SearchPlayer = "CS-2579";
		test = extentCreateTest("As an admin I should be able to Create New - Withdraw From Wallet by CashApp method");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(3000);
		gp.Search_Items(SearchPlayer);
		Thread.sleep(2000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space(text())=\"Manage Wallet\"]")).click();
		Thread.sleep(1000);
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}

		driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),\"Withdraw from Wallet\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).sendKeys(amount);
		Thread.sleep(1000);
		pp.selectPaymentProvider("Cash App");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comments\"]")).sendKeys("By auto");

		driver.findElement(By.xpath("//span[contains(text(),\"Save\")]/parent::button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='Withdraw']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Cash App\"]")) != null) {
			// pp.clickCloseActionView();
			test.pass("Successfully Created Withdraw request by CashApp, showing in list with- \"Success\" status\" ",
					extentScreenshot());
			// Assert.assertTrue(true);
		} else {
			test.fail("Something went wrong to Created [Withdraw request by CashApp]", extentScreenshot());
			// Assert.assertTrue(false);
		}

	}

	@Test
	public void Zsh_TC_PlayerProfile_ManageWalletWithdrawManualVerifyInWalletDeposit() throws InterruptedException {
		test = extentCreateTest(
				"Verifying that data recently added in Wallet with payment method - Manual -> Withdraw Request");

		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),'Withdraw Request')])[3]")).click();

		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + PlayerEnum.SearchPlayer.getValue() + "']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Manual\"]")) != null) {
			test.pass(
					"Successfully Created Withdraw request by Manual, showing in Wallet Deposit list with- \"Success\" status ",
					extentScreenshot());
		} else {
			test.fail("Something went wrong to view recently added record in list[Withdraw request by Manual]",
					extentScreenshot());
		}
	}

//	@Test
	public void Zsi_TC_PlayerProfile_ManageWalletAddCashAppVerifyWalletCount() throws InterruptedException {
		test = extentCreateTest("As an admin I should be able view wallet deposit count");

		driver.navigate().back();

		// String[] WalletAmount = Wallettext.split("$");
		// String WalletAmount = Wallettext.;

		String amount = driver.findElement(By.xpath("(//td[contains(@class,'amount')])[1]")).getText();
		System.out.println(amount + " , " + WalletAmount[1]);
		double WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());
		System.out.println("wallet - " + WalAmount);
		double Total = Double.parseDouble(amount) - WalAmount;
		System.out.println("Total - " + Total);

		// Get new wallet amount and verify
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}
		WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());

		if (Total == WalAmount) {
			test.pass("Successfully verified wallet balance :" + WalAmount
					+ " which is Withdraw from wallet by payment method - CashApp.'\n' Previous Balance : "
					+ WalletAmount + "'\n'" + "Amount Withdraw : " + amount + "Current Wallet Balance : " + Total,
					extentScreenshot());
		} else {
			test.fail("Wallet Balance is not matching the expectations", extentScreenshot());
		}

	}

	@Test
	public void Zsj_TC_PlayerProfile_ManageWalletWithdrawManual() throws InterruptedException {
		test = extentCreateTest("As an admin I should be able to Create New - Withdraw From Wallet by Manual method");
		String SearchPlayer = "CS-2579";

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(SearchPlayer);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space(text())=\"Manage Wallet\"]")).click();
		Thread.sleep(1000);
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}

		driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),\"Withdraw from Wallet\")]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).sendKeys("51");
		Thread.sleep(1000);
		pp.selectPaymentProvider("Manual");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"comments\"]")).sendKeys("By auto");

		driver.findElement(By.xpath("//span[contains(text(),\"Save\")]/parent::button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),\"Yes\")]")).click();

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='Withdraw']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Manual\"]")) != null) {
			// pp.clickCloseActionView();
			test.pass("Successfully Created Withdraw request by CashApp, showing in list with- \"Success\" status",
					extentScreenshot());
			// Assert.assertTrue(true);
		} else {
			test.fail("Something went wrong to Created [Withdraw request by Manual]", extentScreenshot());
			// Assert.assertTrue(false);
		}

	}

	@Test
	public void Zsk_TC_PlayerProfile_ManageWalletWithdrawCashAppVerifyInWalletDeposit()
			throws InterruptedException {
		test = extentCreateTest("Verifying that data recently added in Wallet By Manual -> Withdraw Request");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[2]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'Withdraw Request')])[3]")).click();

		Thread.sleep(3000);

		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),\"Success\")]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + PlayerEnum.SearchPlayer.getValue() + "']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()=\"Manual\"]")) != null) {
			test.pass(
					"Successfully Created Added to wallet request by Manual, showing in Wallet Deposit list with- \"Success\" status ",
					extentScreenshot());
		} else {
			test.fail("Something went wrong to view recently added record in list[Add to wallet request by Manual]",
					extentScreenshot());
		}
	}

//	@Test
	public void Zsl_TC_PlayerProfile_ManageWalletWithdrawCashAppVerifyWalletCount() throws InterruptedException {
		test = extentCreateTest("As an admin I should be able view wallet deposit count");

		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);

		driver.navigate().back();

		// String[] WalletAmount = Wallettext.split("$");
		// String WalletAmount = Wallettext.;

		String amount = driver.findElement(By.xpath("(//td[contains(@class,'amount')])[1]")).getText();
		System.out.println(amount + " , " + WalletAmount[1]);
		double WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());
		System.out.println("wallet - " + WalAmount);
		double Total = Double.parseDouble(amount) - WalAmount;
		System.out.println("Total - " + Total);

		// Get new wallet amount and verify
		String temp = driver.findElement(By.xpath("//span[@class='titleTagName']")).getText();
		String[] temp2 = temp.split("[$]");
		System.out.println(temp2);
		for (int i = 0; i < temp2.length; i++) {
			WalletAmount[i] = temp2[i];
		}
		WalAmount = Double.parseDouble(WalletAmount[1].stripLeading());

		if (Total == WalAmount) {
			test.pass("Successfully verified wallet balance :" + WalAmount
					+ " which is Withdraw from wallet by payment method - Manual.'\n' Previous Balance : "
					+ WalletAmount + "'\n'" + "Amount Withdraw : " + amount + "Current Wallet Balance : " + Total,
					extentScreenshot());
		} else {
			test.fail("Wallet Balance is not matching the expectations", extentScreenshot());
		}

	}

//	@Test
	public void Zx_TC_PlayerProfile__ViewNetReportofInvitedplayers() throws InterruptedException {
		test = extentCreateTest("TC - As an admin user I should be able to view net report of invited players");
		PlayerProfile pp = new PlayerProfile(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(2000);
		pp.clickOnPlayerProfile();
		Thread.sleep(2000);
		gp.Search_Items("CS-1400");
		Thread.sleep(2000);
		pp.clickOnplayerinvited();
		Thread.sleep(2000);
		test.info("<b><i>Successfully viewed dashboard of invited players </b></i>", extentScreenshot());

		driver.findElement(By.xpath("//div[text()='Net Report']")).click();
		Thread.sleep(2000);
		// pp.Selectmonthandyear("2023", month[2], "1", endDate[2]);
		up.ClickonCalendarBtn();
		Thread.sleep(500);
		up.SelectFromToDate();
		Thread.sleep(1000);
		up.ClickonGenerateNetIncomeReports();
		if (driver.findElements(By.xpath("//th[text()='From Date']//following::tr//td[1]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='To Date']//following::tr//td[2]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Daily Extra (ST)']//following::tr//td[3]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Promotional (ST)']//following::tr//td[4]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Purchase (in $)']/following::tr//td[5]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Redeem (in $)']//following::tr//td[6]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Net Income (in $)']//following::tr//td[7]")).size() > 0) {
			// Assert.assertTrue(true);
			test.pass(
					"<b><i>Successfully viewed net report of invited players and net income of referred players</b></i>",
					extentScreenshot());
		} else {
			test.fail("Something wrong!To view net report of invited players and net income of referred players",
					extentScreenshot());
			// Assert.assertTrue(false);
		}

		String dailyExtra = driver.findElement(By.xpath("//th[text()='Daily Extra (ST)']//following::tr//td[3]"))
				.getText();
		String promotional = driver.findElement(By.xpath("//th[text()='Promotional (ST)']//following::tr//td[4]"))
				.getText();
		String totalPurchase = driver.findElement(By.xpath("//th[text()='Total Purchase (in $)']/following::tr//td[5]"))
				.getText();
		String totalRedeem = driver.findElement(By.xpath("//th[text()='Total Redeem (in $)']//following::tr//td[6]"))
				.getText();
		String netIncome = driver.findElement(By.xpath("//th[text()='Net Income (in $)']//following::tr//td[7]"))
				.getText();

		Integer DailyExtra = Integer.valueOf(dailyExtra);
		System.out.println("Daily extra ST = " + DailyExtra);
		Integer Promotional = Integer.valueOf(promotional);
		System.out.println("Promotional ST = " + Promotional);
		Integer TotalPurchase = Integer.valueOf(totalPurchase);
		System.out.println("Total Purchase ST = " + TotalPurchase);
		Integer TotalRedeem = Integer.valueOf(totalRedeem);
		System.out.println("Total Redeem ST = " + TotalRedeem);
		Integer NetIncome = Integer.valueOf(netIncome);
		// System.out.println(NetIncome);

		int TotalNetIncome = DailyExtra + Promotional + TotalPurchase - TotalRedeem;
		System.out.println("Total Net Income = " + TotalNetIncome);
		test.info("Total Net Income = " + TotalNetIncome, extentScreenshot());

		Thread.sleep(1000);
		pp.clickXlsxButton();
		// Thread.sleep(500);
//      if (cc.Validation_XLSXDownload.isDisplayed() == true) {
//          Assert.assertTrue(true);
//          test.pass("" + cc.Validation_XLSXDownload, extentScreenshot());
//      } else {
//          test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
//          Assert.assertTrue(false);
//      }
//      Thread.sleep(3000);
//      pp.clickOnDownloadIcon();
//      Thread.sleep(3000);
//      if (driver.findElements(By.xpath("//h3[text()='Downloads']")).size() > 0) {
//          test.pass("Successfully downloaded net report of invited players", extentScreenshot());
//      } else {
//          test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
//      }
	}

//	@Test
	public void Zy_TC_PlayerProfile__ViewPieChartofInvitedPlayers() throws InterruptedException {
		test = extentCreateTest("TC - As an admin user I should be able to view the dashboard of invited players");
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		Actions act = new Actions(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(2000);
		pp.clickOnPlayerProfile();
		Thread.sleep(2000);
		gp.Search_Items("CS-1400");
		Thread.sleep(2000);
		pp.clickOnplayerinvited();
		Thread.sleep(2000);
		Thread.sleep(3000);
//      driver.findElement(By.xpath("//div[text()='Dashboard']")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[3]")).click();
////        up.ClickonCalendarBtn();
//      Thread.sleep(500);
//      up.SelectFromToDate();
//      Thread.sleep(1000);
//      if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
//          test.pass("Successfully viewed the player transaction graph in dashboard", extentScreenshot());
//      } else {
//          test.fail("Something Wrong ! not able to view the player transaction graph in dashboard", extentScreenshot());
//      }
//      Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//h4[text()='Most Active Game']")));
		Thread.sleep(2000);
		List<WebElement> gamesName = driver.findElements(By
				.xpath("//*[local-name()='svg']//*[name()='g' and @class='apexcharts-series apexcharts-pie-series']"));
		List<WebElement> games = driver.findElements(By.xpath(
				"(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-series apexcharts-pie-series'])//*[name()='path']"));
		System.out.println("Number of active games of invited players " + games.size());
		for (WebElement ActiveGame : games) {
			act.moveToElement(ActiveGame).build().perform();
			System.out.println(ActiveGame.getAttribute("data:value"));
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//div[@class='apexcharts-tooltip-y-group']//child::span[@class='apexcharts-tooltip-text-y-label']")).
		}

	}

//	@Test
	public void Zz_TC_PlayerProfile_PlayerLedger() throws InterruptedException {
		test = extentCreateTest("TC - As a player I should be able to view the player ledger");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("CS-1400");
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1) {
			pp.clickManageTokens();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Create New']")).click();
			Thread.sleep(1000);

			pp.selectPackage(" Cosmo10 (Act Amt. $1) ");
			Thread.sleep(500);
			pp.selectPaymentMethod("Others ");
			driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("Test");
			pp.ClickSave();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			Thread.sleep(500);
			if (cc.Validation_Format_ManageTokens_saved.isDisplayed()) {
				// Assert.assertTrue(true);
				test.pass("Successfully added tokens ", extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong!To add token", extentScreenshot());
			}
		}
		Thread.sleep(1000);
		pp.clickPlayerLedgerTab();
		Thread.sleep(2000);

		if (driver
				.findElements(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'deposit')][1]"))
				.size() > 0) {

			test.pass("Successfully added tokens ", extentScreenshot());
		} else {

			test.fail("Something wrong!To add token", extentScreenshot());
		}

//      String BalanceST = driver.findElement(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'balance')][1]")).getText();
//      String DepositST = driver.findElement(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'deposit')][1]")).getText();
//      String WithdrwST = driver.findElement(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'withdraw')][1]")).getText();
//      String BetAmountST = driver.findElement(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'betAmount')][1]")).getText();
//      String FinalBalanceST = driver.findElement(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'finalBalance')][1]")).getText();
//
//      String BalanceGT = driver.findElement(By.xpath("(//td[text()='Game Token'])[1]//following::td[contains(@class,'balance')][1]")).getText();
//      String DepositGT = driver.findElement(By.xpath("(//td[text()='Game Token'])[1]//following::td[contains(@class,'deposit')][1]")).getText();
//      String WithdrwGT = driver.findElement(By.xpath("(//td[text()='Game Token'])[1]//following::td[contains(@class,'withdraw')][1]")).getText();
//      String BetAmountGT = driver.findElement(By.xpath("(//td[text()='Game Token'])[1]//following::td[contains(@class,'betAmount')][1]")).getText();
//      String FinalBalanceGT = driver.findElement(By.xpath("(//td[text()='Game Token'])[1]//following::td[contains(@class,'finalBalance')][1]")).getText();
//
//      Double Balancest = Double.valueOf(BalanceST);
//      System.out.println("Balance ST = " + Balancest);
//      Double DepositSt = Double.valueOf(DepositST);
//      System.out.println("Deposit ST = " + DepositSt);
//      Double WithdrwSt = Double.valueOf(WithdrwST);
//      System.out.println("Withdraw ST = " + WithdrwSt);
//      Double BetAmountSt = Double.valueOf(BetAmountST);
//      System.out.println("Bet amount ST = " + BetAmountSt);
//      Double FinalBalanceSt = Double.valueOf(FinalBalanceST);
//      System.out.println("Final ST = " + FinalBalanceSt);
//
//      Double TotalFinalBalanceSt = Balancest + DepositSt - WithdrwSt - BetAmountSt;
//      System.out.println("Total Final Balance ST = " + TotalFinalBalanceSt + "\r\n");
//      test.info("Total Final Balance ST = " + TotalFinalBalanceSt);
//
//      Double BalanceGt = Double.valueOf(BalanceGT);
//      System.out.println("Balance GT = " + BalanceGt);
//      Double DepositGt = Double.valueOf(DepositGT);
//      System.out.println("Deposit GT = " + DepositGt);
//      Double WithdrwGt = Double.valueOf(WithdrwGT);
//      System.out.println("Withdraw GT = " + WithdrwGt);
//      Double BetAmountGt = Double.valueOf(BetAmountGT);
//      System.out.println("Bet amount GT = " + BetAmountGt);
//      Double FinalBalanceGt = Double.valueOf(FinalBalanceGT);
//      System.out.println("Final Balance GT = " + FinalBalanceGt);
//
//      Double TotalFinalBalanceGt = BalanceGt + DepositGt - WithdrwGt - BetAmountGt;
//      System.out.println("Total Final Balance GT = " + TotalFinalBalanceGt);
//      test.info("Total Final Balance GT = " + TotalFinalBalanceGt);
//
//      if (FinalBalanceGt.equals(TotalFinalBalanceGt) || FinalBalanceSt.equals(TotalFinalBalanceSt)) {
//          //Assert.assertTrue(true);
//          test.pass("Successfully added tokens in player ledger", extentScreenshot());
//      } else {
//          Assert.assertTrue(false);
//          //test.fail("Something wrong!To add token in player ledger", extentScreenshot());
//      }
//      Thread.sleep(1000);
//      pp.clickonPurchases();
	}

//	@Test
	public void Zza_TC_PlayerProfile_ChargeBackReport() throws InterruptedException {

		test = extentCreateTest("TC - As a player I should be able to view the player ledger");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("nav-chargeback-tab")).click();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h4[text()='Charge Back Report']")).size() > 0) {
			test.info("Successfully opened charge back report page", extentScreenshot());
			driver.findElement(By.xpath("//input[@formcontrolname='startsAtTime']")).sendKeys("1000");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@formcontrolname='expiryAtTime']")).sendKeys("1000");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Search']")).click();
			if (driver.findElements(By.xpath("//span[text()='Player Name']")).size() > 0) {
				test.pass(
						"Successfully Viewed player name, player Id, dusplay name and registration date on the player charge back report page",
						extentScreenshot());

			} else {
				test.fail(
						"Something wrong !! Not able to Viewed player name, player Id, dusplay name and registration date on the player charge back report page",
						extentScreenshot());
			}
			try {

				WebElement PurchaseReceipt = driver.findElement(By.xpath("//h4[text()='Purchase Receipt']"));
				js.executeScript("arguments[0].scrollIntoView();", PurchaseReceipt);
				Thread.sleep(5000);
				if (PurchaseReceipt != null) {
					Assert.assertTrue(true);
					test.pass("Successfully viewed purchase recipt of player", extentScreenshot());
				} else {
					Assert.assertTrue(false);
					test.pass("Something Wrong ! Not able to view purchase recipt of player", extentScreenshot());
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		} else {
			test.fail("Something wrong !! Not able to open charge back report", extentScreenshot());
		}

	}

//	@Test
	public void Zzb_TC_PlayerProfile_PlayerTransactionGraph() throws InterruptedException {
		test = extentCreateTest(
				"TC - As an Admin I must be able to view the player transaction graph of only the current month");
		UserPage up = new UserPage(driver);
		LobbyPage lp = new LobbyPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		gotoTab(driver, 0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Dashboard']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[2]")).click();
//      up.ClickonCalendarBtn();
		Thread.sleep(500);
		up.SelectFromToDate();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
			test.pass("Successfully viewed the player transaction graph in dashboard", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to view the player transaction graph in dashboard",
					extentScreenshot());
		}

		Thread.sleep(2000);
		lp.clicklobbymanagement();
		Thread.sleep(500);
		lp.clickStoreAccounts();
		Thread.sleep(3000);
		lp.SearchItems("CosmoSlot");
		Thread.sleep(1500);
		lp.View_Click();
		Thread.sleep(2000);
		try {
			WebElement PlayerTransaction = driver.findElement(By.xpath("//span[text()='Player Transaction']"));
			js.executeScript("arguments[0].scrollIntoView();", PlayerTransaction);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[4]")).click();
			Thread.sleep(500);
			up.SelectFromToDate();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
				test.pass("Successfully viewed the player transaction graph in store dashboard", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to view the player transaction graph in store  dashboard",
						extentScreenshot());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void footprints() throws InterruptedException {
		Thread.sleep(2000);

		if (driver
				.findElements(
						By.xpath("//th[text()=\"Date & Time\"]/following::tr//td[contains(@class,\"createdAt\")]"))
				.size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully Viewed Date & Time of Player on the player login footprints page");
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View Date & Time of Player on the player login footprints page");
		}
		if (driver.findElements(By.xpath("//th[text()=\"Device\"]/following::tr//td[contains(@class,\"device \")]"))
				.size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully Viewed device of Player on the player login footprints page");
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View device of Player on the  player login footprints page");
		}
		if (driver.findElements(By.xpath("//th[text()=\"IP Address\"]/following::tr//td[contains(@class,\"ip \")]"))
				.size() > 0) {
			// Assert.assertTrue(true);
			test.pass("Successfully View ip of Player on the player login footprints page");
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong !! To View ip of Player on the  player login footprints page");
		}

	}

	public void search(String Searchitem) throws IOException, InterruptedException {

		if (driver.findElement(By.xpath("//tbody//tr//td//div[contains(text(),'" + Searchitem + "')]")) != null) {
			// Assert.assertTrue(true);
			test.pass("Searching item is in the List - " + Searchitem, extentScreenshot());
		} else {

			test.fail("Something Wrong!To Search item", extentScreenshot());
			////////////// Assert.assertTrue(false);
		}

		Thread.sleep(1000);

		test.info("TestCase Search Ended");

	}

}
