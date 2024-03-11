package com.Cosmoslots.testCases.storeScenarios;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.Status;

public class StoreDetailsSettings extends BaseClass {

	StoreCreation storecheck = new StoreCreation();

	@Test
	public void N_LobbyManagement_Website_VerifyGames_Web() throws IOException, InterruptedException {
		test = extentCreateTest("Website  - Store Game Search");
		LobbyPage lb = new LobbyPage(driver);
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickToEdit();
		driver.findElement(By.xpath("(//span[normalize-space()='Vintage Reels']//following::i)[1]")).click();
		driver.findElement(By.xpath("(//span[normalize-space()='Nasty Bee']//following::i)[1]")).click();
		driver.findElement(By.xpath("(//span[normalize-space()=\"Beach O' Mania\"]//following::i)[1]")).click();
		lb.clicklobbysave();
		Thread.sleep(1000);
		lb.clickViewLobby();
		lb.clickViewLobby_Game();
		int NoGamesAdmin = driver.findElements(By.xpath("//td[contains(@class,'name')]")).size();
		System.out.println("No. of slot Games Admin-> " + NoGamesAdmin);

		Thread.sleep(1500);
		if (driver.findElements(By.xpath("//button[contains(text(),'Keno')]")).size() > 0) {
			NoGamesAdmin = driver.findElements(By.xpath("//td[contains(@class,'name')]")).size() + NoGamesAdmin;
			System.out.println("No. of  Games Admin-> " + NoGamesAdmin);
		}
		BaseClass.gotoTab(driver, 1);
		driver.findElement(By.xpath("//*[text()=\"Games\"]")).click();

		int NoGamesWeb = driver.findElements(By.xpath("//div[contains(@class,\"ngl-item-block\")]/h5")).size();
		System.out.println("NoGamesAdmin-> " + NoGamesWeb);

		if (NoGamesAdmin == NoGamesWeb) {
			test.pass("Number of games are the same in Admin and Website", extentScreenshot());
		} else {
			test.fail("Number of games are not the same in Admin and Website ! Failed", extentScreenshot());
		}
		Thread.sleep(5000);
		gotoTab(driver, 0);
	}

	@Test
	public void Na_LobbyManagement_Admin_SearchGames() throws IOException, InterruptedException {
		test = extentCreateTest("Admin - Store Game Search");

		test.info("TestCase started Search Store_Game - As an admin user I should be able to Search Store_Game");
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(1000);
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_Game();
		test.info("Search Game test case Start.");
		lb.SearchItems(LobbyEnum.search_Game.getValue());

		if (driver.findElement(
				By.xpath("//tbody//tr//td[contains(text(),'" + LobbyEnum.search_Game.getValue() + "')]")) != null) {
			test.pass("successfuly find record in Game -> " + LobbyEnum.search_Game.getValue(), extentScreenshot());
		} else {
			test.fail("Something Wrong!To View records in Game.", extentScreenshot());
			// lb.clickClearSearch();
		}
		Thread.sleep(500);
		test.info("Search game TestCase End.");
	}

	@Test
	public void Nb_LobbyManagement_Admin_FishGames() throws IOException, InterruptedException {
		Admin_FishGames_Configuration_Add(LobbyEnum.Lcode.getValue(), LobbyEnum.fishgame.getValue());
	}

	public void Admin_FishGames_Configuration_Add(String loby, String fish) throws IOException, InterruptedException {
		if (fish.equalsIgnoreCase("yes")) {
			test = extentCreateTest("Add -> Fish Game Configuration");
			test.info("TestCase started to Add Fish Game Configuration");
			LobbyPage lb = new LobbyPage(driver);
			Thread.sleep(1000);
			storecheck.LobbyRedirect("search", loby);
			lb.clickViewLobby();
			lb.clickViewLobby_Game();
			Thread.sleep(10000);

			if (driver.findElement(By.xpath("//thead//tr//th[contains(text(),'Code')]")) != null) {
				driver.findElement(By.xpath("//button[@id='FISH']")).click();
				Thread.sleep(5000);
				if (driver.findElement(By.xpath("//tbody//tr//td[contains(text(),'Ocean Bombard')]")) != null) {
					test.pass("successfuly find Ocean Bombard Game ", extentScreenshot());
					driver.findElement(By.xpath("//a[contains(@title,'View Game Room Configuration')]")).click();
					Thread.sleep(5000);
					if (driver.findElement(By.xpath("//h3[normalize-space()='Game Room Configuration']")) != null) {

						lb.clickToCreate();
						lb.selectRole(LobbyEnum.storerole.getValue());
						lb.selectUsername(LobbyEnum.storeusername.getValue());
						lb.fishGameConfiguration(LobbyEnum.fishCode.getValue(), LobbyEnum.fishCode.getValue(), "50",
								"11", "0", "This is Edit testing game room configuration");
						lb.ClickToSave();
						Thread.sleep(1000);
						boolean isDisplayed = CommonCosmo.Room_Configuration_save.isDisplayed();
						String message = isDisplayed
								? "<b><i>Game Room Configuration save successfully message return</b></i>"
								: "<b><i>not able show Game Room Configuration save successfully message return</b></i>";
						test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
					} else {
						test.fail("Something Wrong!To View Game Room Configuration in Heading.", extentScreenshot());
					}
				} else {
					test.fail("Something Wrong!To Find Fish Game.", extentScreenshot());
				}
			} else {
				test.fail("Something Wrong!To View records in fish Game.", extentScreenshot());
			}
			Thread.sleep(500);
			test.info("TestCase Ended to Add Fish Game Configuration");
		} else {
			test.info("Not Added Fish game so Not required to set Fish Game Configuration", extentScreenshot());
		}
	}

	@Test
	public void Nc_LobbyManagement_Admin_FishGames() throws IOException, InterruptedException {
		Admin_FishGames_Configuration_Edit(LobbyEnum.Lcode.getValue(), LobbyEnum.fishgame.getValue());
	}

	public void Admin_FishGames_Configuration_Edit(String loby, String fish) throws IOException, InterruptedException {
		if (fish.equalsIgnoreCase("yes")) {
			test = extentCreateTest("Edit -> Fish Game Configuration");
			test.info("TestCase started To Edit Fish Game Configuration");
			LobbyPage lb = new LobbyPage(driver);
			Thread.sleep(1000);
			PageReload();
			lb.clicktoFish();
			if (driver.findElement(By.xpath("//thead//tr//th[contains(text(),'Code')]")) != null) {
				if (driver.findElement(By.xpath("//tbody//tr//td[contains(text(),'Ocean Bombard')]")) != null) {
					test.pass("successfuly find Ocean Bombard Game ", extentScreenshot());
					Thread.sleep(2000);
					driver.findElement(By.xpath("//a[contains(@title,'View Game Room Configuration')]")).click();
					Thread.sleep(3000);
					if (driver.findElement(By.xpath("//h3[normalize-space()='Game Room Configuration']")) != null) {
						lb.SearchItems(LobbyEnum.fishCode.getValue());
						lb.clickToEdit();
						Thread.sleep(4000);
						lb.fishGameConfiguration(LobbyEnum.fishCode.getValue(), LobbyEnum.fishCode.getValue(), "50",
								"11", "0", "This is Edit testing game room configuration");
						lb.ClickToSave();
						Thread.sleep(1000);

						boolean isDisplayed = CommonCosmo.Room_Configuration_save.isDisplayed();
						String message = isDisplayed
								? "<b><i>Game Room Configuration save successfully message return</b></i>"
								: "<b><i>not able show Game Room Configuration save successfully message return</b></i>";
						test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
					} else {
						test.fail("Something Wrong!To View Game Room Configuration in Heading.", extentScreenshot());
					}
				} else {
					test.fail("Something Wrong!To Find Fish Game.", extentScreenshot());
				}
			} else {
				test.fail("Something Wrong!To View records in fish Game.", extentScreenshot());
			}
			Thread.sleep(500);
			test.info("TestCase Ended to Edit Fish Game Configuration");
		} else {
			test.info("Not Added Fish game so Not required to set Fish Game Configuration", extentScreenshot());
		}
	}

	@Test
	public void O_LobbyManagement_Game_View() throws IOException, InterruptedException {
		test = extentCreateTest("Store Game View");

		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(1000);

		PageReload();
		lb.clicktoFish();
		test.info("View game test case start.");
		lb.verifyRecordOnListing("name");
		if (lb.verifyLobbyview()) {
			lb.View_Click();
			lb.verifyRecordOnView("Ocean Bombard");
			lb.ClickToClose();
		} else {
			test.info("View game view not found", extentScreenshot());
		}
		test.info("View game test case end.");
		Thread.sleep(1000);
	}

	@Test(groups = { "admin", "Website" })
	public void P_TC_LobbyJackpot_Slot_Create() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Slot Jackpot - Create");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Create Lobby Jackpot'test case start");

		// Working
		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.ClickOnJackpot();
		lb.clickToCreate();

		lb.selectGTST(LobbyEnum.JackpotST.getValue());
		lb.selectUsername(LobbyEnum.storeusername.getValue());
		lb.LobbyPackage_Code(LobbyEnum.jackpotName.getValue());
		lb.LobbyPackage_name(LobbyEnum.jackpotName.getValue());
		lb.Jackpot_InitialValue(LobbyEnum.jackpot_InitialValue.getValue());
		lb.Jackpot_rewardPercentage(LobbyEnum.jackpot_Percentage.getValue());
		lb.SetDesc_StorePackage("This is testing Jackpot Packages");
		lb.ClickToSave();

		cc.VerifyData(cc.jackpotSaved);
		lb.ClickToCancel();
		test.info("Create Jackpot test case end");
	}

	@Test(groups = { "admin", "Website" })
	public void Pa_TC_LobbyJackpot_Keno_Create() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Keno Jackpot - Create");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Create Lobby Jackpot'test case start");

		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.ClickOnJackpot();
		lb.clicktoKeno();
		lb.clickToCreate();

		lb.selectGTST(LobbyEnum.JackpotST.getValue());
		lb.selectUsername(LobbyEnum.storeusername.getValue());
		lb.LobbyPackage_Code(LobbyEnum.jackpotName.getValue());
		lb.LobbyPackage_name(LobbyEnum.jackpotName.getValue());
		lb.Jackpot_InitialValue(LobbyEnum.jackpot_InitialValue.getValue());
		lb.Jackpot_rewardPercentage(LobbyEnum.jackpot_Percentage.getValue());
		lb.SetDesc_StorePackage("This is testing Jackpot  ");

		lb.ClickToSave();
		cc.VerifyData(cc.jackpotSaved);
		lb.ClickToCancel();
		test.info("Create Jackpot test case end");
	}

	@Test(groups = { "admin" })
	public void Pb_TC_LobbyJackpot_Search() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Jackpot - Search");

		LobbyPage lb = new LobbyPage(driver);
//		CommonCosmo cc = new CommonCosmo(driver);

		// -----------Search Jackpot-----------
		test.info("search Jackpot test case start");
		lb.Searchjackpot(LobbyEnum.jackpotName.getValue());
		if (driver
				.findElements(By.xpath("//th[text()=\"Name\"]/following::tr//td[contains(@class,\"mat-column-name\")]"))
				.size() > 0) {
			test.info("Successfully displayed Name column   in Grid");
		} else {
			test.info("Not displayed Name column  in Grid");
		}
		if (driver
				.findElements(By.xpath("//th[text()=\"Code\"]/following::tr//td[contains(@class,\"mat-column-code\")]"))
				.size() > 0) {
			test.info("Successfully displayed Code column   in Grid");
		} else {
			test.info("Not displayed Code column  in Grid");
		}
		if (driver.findElements(By.xpath(
				"(//th[text()=\"Current Piggy\"]/following::tr//td[contains(@class,\"mat-column-piggyTokens\")])[1]"))
				.size() > 0) {
			test.info("Successfully displayed Current Piggy column   in Grid");
		} else {
			test.info("Not displayed Current Piggy column  in Grid");
		}
		if (driver.findElements(By.xpath(
				"(//th[text()=\"Jackpot Initial Value\"]/following::tr//td[contains(@class,\"mat-column-jackpotInitialValue \")])[1]"))
				.size() > 0) {
			test.info("Successfully displayed Jackpot Initial Value	 column  in Grid");
		} else {
			test.info("Not displayed Jackpot Initial Value column  in Grid");
		}
		if (driver.findElements(By.xpath(
				"(//th[text()=\"Reward Percentage\"]/following::tr//td[contains(@class,\"mat-column-rewardPercentage\")])[1]"))
				.size() > 0) {
			test.info("Successfully displayed Reward Percentage column   in Grid");
		} else {
			test.info("Not displayed Reward Percentage	column  in Grid");
		}
		test.info("search Jackpot test case end");
	}

	@Test(groups = { "admin" })
	public void Pc_TC_LobbyJackpot_Wins() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Jackpot - Wins");

		LobbyPage lb = new LobbyPage(driver);

		test.info("Test case - Lobby Jackpot - Wins Start");
		// Lobby Jackpot - Wins
		if (driver.findElements(By.xpath(
				"//th[text()=\"Jackpot Wins\"]/following::tr//td[contains(@class,\"cdk-column-jackpotwins\")]//i[@class=\"ri-trophy-line\"]"))
				.size() > 0) {
			driver.findElement(By.xpath(
					"//th[text()=\"Jackpot Wins\"]/following::tr//td[contains(@class,\"cdk-column-jackpotwins\")]//i[@class=\"ri-trophy-line\"]"))
					.click();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath("//h3[contains(text(),'Jackpot Wins')]")).size() > 0) {
				test.info("Successfully open Jackpot Wins screen", extentScreenshot());
				Thread.sleep(1000);
				if (driver.findElements(By.xpath(
						"//th[text()=\"Display Name\"]/following::tr//td[contains(@class,\"mat-column-displayName\")]"))
						.size() > 0) {
					test.pass("Successfully displayed Jackpot Wins data", extentScreenshot());
				} else {
					test.fail("Not displayed Jackpot Wins data", extentScreenshot());
					Thread.sleep(2000);
					lb.ClickToCancel();
				}
			} else {
				test.fail("Not find Jackpot Wins screen", extentScreenshot());
			}
		} else {
			test.fail("Not able to find Jackpot Wins button", extentScreenshot());
		}
		test.info("Test case - Lobby Jackpot - Wins END");
	}

	@Test(groups = { "admin" })
	public void Pd_TC_LobbyJackpot_Slot_edit() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby SLot Jackpot - Edit");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Edit Lobby SLOT Jackpot' est case start");

		// ------------------Edit Jackpot------------
		PageReload();
		lb.ClickOnJackpot();
		Thread.sleep(2000);
		lb.clickToEdit();

		// Search_package="T"+randNum;
		// lb.LobbyPackage_Code(LobbyEnum.JackpotName.getValue());
		// lb.LobbyPackage_name(LobbyEnum.JackpotName.getValue());
		String jackpot_InitialValue = LobbyEnum.jackpot_InitialValue.getValue() + 1;
		lb.Jackpot_InitialValue(jackpot_InitialValue);
		lb.Jackpot_rewardPercentage(LobbyEnum.jackpot_Percentage.getValue());
		lb.SetDesc_StorePackage("this is testing edit Jackpot");
		lb.ClickToSave();
		if (driver
				.findElements(
						By.xpath("(//h2[contains(text(),'Jackpot piggy value will get reset if jackpot init')])[1]"))
				.size() > 0) {
			lb.ClickToYes();
			cc.VerifyData(cc.jackpotupdated);
		} else {
			test.fail("<b><i>not able to edit Jackpot </b></i>", extentScreenshot());
			Thread.sleep(5000);
			lb.ClickToCancel();
		}
		test.info("Edit Jackpot test case end");
	}

	@Test(groups = { "admin" })
	public void Pe_TC_LobbyJackpot_Keno_edit() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Keno Jackpot - Edit");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Edit Lobby KENO Jackpot test case start");

		// ------------------Edit Jackpot------------
		PageReload();
		lb.clicktoKeno();
		lb.clickToEdit();
		// Search_package="T"+randNum;
		// lb.LobbyPackage_Code(LobbyEnum.JackpotName.getValue());
		// lb.LobbyPackage_name(LobbyEnum.JackpotName.getValue());

		String jackpot_InitialValue = LobbyEnum.jackpot_InitialValue.getValue() + 1;
		lb.Jackpot_InitialValue(jackpot_InitialValue);
		lb.Jackpot_rewardPercentage(LobbyEnum.jackpot_Percentage.getValue());
		lb.SetDesc_StorePackage("this is testing edit Jackpot");
		lb.ClickToSave();
		if (driver
				.findElements(
						By.xpath("(//h2[contains(text(),'Jackpot piggy value will get reset if jackpot init')])[1]"))
				.size() > 0) {
			lb.ClickToYes();

			cc.VerifyData(cc.jackpotupdated);
		} else {
			test.fail("<b><i>not able to edit Jackpot </b></i>", extentScreenshot());
			Thread.sleep(5000);
			lb.ClickToCancel();
		}
		test.info("Lobby Keno Jackpot - Edit test case end");
	}

	@Test(groups = { "admin" })
	public void Pf_TC_LobbyJackpot_View() throws IOException, InterruptedException {
		test = extentCreateTest("Jackpot view");

		LobbyPage lb = new LobbyPage(driver);
		test.info("View Jackpot test case start...");

		lb.verifyRecordOnListing("name");
		if (lb.verifyLobbyview()) {
			lb.View_Click();
			lb.verifyRecordOnView("Ocean Bombard");
			lb.ClickToClose();
		} else {
			test.info("View jackpot not found", extentScreenshot());
		}
		test.info("View Jackpot test case end.");
		Thread.sleep(1000);
	}

	@Test
	public void Wb_LobbyManagement_Coupon_Search() throws IOException, InterruptedException {
		test = extentCreateTest("Store coupon search");

		test.info("TestCase started Search Store coupon- As an admin user I should be able to Search Store coupon");
		LobbyPage lb = new LobbyPage(driver);

		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_coupon();
		lb.SearchItems(LobbyEnum.storecouponName.getValue());

		if (driver.findElements(By.xpath("//tr//td[contains(text(),'" + LobbyEnum.storecouponName.getValue() + "')]"))
				.size() > 0) {
			test.pass("Successfully Searched Store coupon", extentScreenshot());
		} else {
			test.fail("Something wrong !! To Search Store coupon", extentScreenshot());
		}
		Thread.sleep(1500);
		test.info("TestCase-search Store coupon Ended");
	}

	@Test
	public void Wba_LobbyManagement_CouponAppliedHistory() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Coupon Applied History ");

		test.info(
				"TestCase started view Coupon Applied - As an admin user I should be able to view on Coupon Applied History");
		LobbyPage lb = new LobbyPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
		String cp = LobbyEnum.search_CustomPackageName.getValue();
		test.info("View Coupon Applied History start...");

		// Working
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_coupon();
		lb.SearchItems(LobbyEnum.storecouponName.getValue());

		if (lb.ViewCouponAppliedHistory.isDisplayed() == true) {
			lb.clickToViewCouponAppliedHistory();
			if (lb.verifywCouponAppliedHistory()) {
				if (driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() > 0) {
					if (driver.findElement(By.xpath(
							"(//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"cdk-column-player-playerId\")])[1]"))
							.getText().equalsIgnoreCase(LobbyEnum.Playerusername.getValue())) {
						Thread.sleep(500);
						test.pass("<b><i>Successfully verify searched player and package on Coupon Applied History",
								extentScreenshot());
					} else {
						Thread.sleep(500);
						test.fail(
								"<b><i>not able to verify searched player and package on Coupon Applied History</b></i>",
								extentScreenshot());
					}

					test.info("Testing XLSX Download in Coupon Applied History");
					pp.clickXlsxButton();
					String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";

					if (driver.findElement(By.xpath("(//span[contains(text(),'" + msg + "')])[1]")).isDisplayed()) {
						test.pass("Successfully XLSX Downloaded message displayed");

						// this code is for download page comparsion
//						String modulename = driver
//								.findElement(By.xpath("(//h3[contains(.,'Coupon Applied History')])[1]")).getText();
						String modulename = lb.appliedCouponHistory();
						driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
						Thread.sleep(2000);

						String downloadString = driver.findElement(By.xpath(
								"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
								.getText();

						if (downloadString.equalsIgnoreCase(modulename)) {
							test.pass("Successfully Viewed Listing Type	-><b>" + downloadString
									+ "</b> in Download page");
						} else {
							test.info("Something wrong !! To Viewed Listing Type -><b>" + downloadString
									+ "</b>in Download page");
						}
					} else {
						test.fail("Something wrong !! To Download XLSX MESSAGE NOT DISPLAYED");
					}
				} else {
					test.fail("Something wrong !! To Download XLSX");
				}
			} else {
				Thread.sleep(500);
				test.fail("<b><i>Successfully verify searched Coupon Applied   in  a List.</b></i>",
						extentScreenshot());
			}
		} else {
			test.info("Coupon Applied History button not found", extentScreenshot());
		}
		test.info("View Coupon Applied History test case end.");
		Thread.sleep(2000);
	}

	@Test
	public void Wd_LobbyManagement_Coupon_View() throws IOException, InterruptedException {
		test = extentCreateTest("Store coupon view");

		LobbyPage lb = new LobbyPage(driver);
		test.info("view Store coupon test case start");

		// ---View coupon----
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_coupon();
		lb.SearchItems(LobbyEnum.storecouponName.getValue());

		if (driver.findElements(By.xpath("//tr//td[contains(text(),'" + LobbyEnum.storecouponName.getValue() + "')]"))
				.size() > 0) {
			test.pass("Successfully Searched store coupon");
			lb.verifyViewButton();
			Thread.sleep(1000);
			lb.View_Click();
			Thread.sleep(1000);
			lb.clickToViewData();
			Thread.sleep(1000);
			lb.ClickToClose();
			Thread.sleep(1000);
		} else {
			test.fail("Something wrong !! To Search store coupon");
		}
		test.info("view Store coupon test case end");
		Thread.sleep(1000);
	}

	@Test
	public void We_LobbyManagement_Coupon_Status() throws IOException, InterruptedException {
		test = extentCreateTest("Store coupon Status");

		test.info("TestCase started Status store coupon - As an admin user I should be able to Status store coupon");
		Thread.sleep(1000);
		LobbyPage lb = new LobbyPage(driver);

		// Working
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_coupon();
		lb.SearchItems(LobbyEnum.storecouponName.getValue());

		if (driver.findElement(
				By.xpath("//tbody//tr//td[contains(text(),'" + LobbyEnum.storecouponName.getValue() + "')]")) != null) {
			test.pass("successfuly find record in Coupon -> " + LobbyEnum.storecouponName.getValue(),
					extentScreenshot());

			// Status publish/UnPublish
			if (driver.findElement(By
					.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]"))
					.getAttribute("title").equalsIgnoreCase("Publish")) {
				test.info("Successfully Viewed publish coupon page");
				test.info("Now coupon Is UnPublish");
				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				lb.clickToYesButton();
				try {
					if (driver.findElements(By.xpath("//span[text()=\"Lobby Coupon deactivated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Store coupon Successfully unpublished and Validation message appeared - Store coupon deactivated  successfully",
								extentScreenshot());

					} else {
						test.fail("Failed ! To View Message", extentScreenshot());
					}
				} catch (Exception e) {
					if (driver.findElement(
							By.xpath("//span[text()=\"Lobby Coupon deactivated successfully\"]")) != null) {
						test.pass(
								"Store coupon Successfully unpublished and Validation message appeared - Store coupon deactivated  successfully",
								extentScreenshot());
					}
					System.out.println(e);
				}
				Thread.sleep(4000);
			} else {
				test.info("Successfully Viewed View Icon of Player on lobby coupon listing page");
				test.info("Now coupon Is publish");

				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				lb.clickToYesButton();
				try {
					if (driver.findElements(By.xpath("//span[text()=\"Lobby Coupon activated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Store coupon Successfully published and Validation message appeared - Store coupon activated  successfully",
								extentScreenshot());
					} else {
						test.fail("Failed ! To View Message", extentScreenshot());
					}
				} catch (Exception e) {
					if (driver.findElements(By.xpath("//span[text()=\"Lobby Coupon activated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Store coupon Successfully published and Validation message appeared - Store coupon activated  successfully",
								extentScreenshot());
					}
					System.out.println(e);
				}
			}
		} else {
			test.fail("Something Wrong!To View records in Coupon.", extentScreenshot());
		}
		test.info("coupon Status Test case End");
	}

	public void WithdrawSettings(String store) throws IOException, InterruptedException {
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test = extentCreateTest("Store Withdraw settings");
		test.info("TestCase started - Lobby Withdraw Setting");
		storecheck.LobbyRedirect("view", store);
		lb.clickViewLobby_Withdraw();

		if (lb.ViewLobby_WithdrawSetting_Title.getText().equalsIgnoreCase("Withdraw Amount Details")) {
			test.info("Successfully verify Withdraw settings label.");
			lb.ViewLobby_WithdrawSetting_amount("1");
			lb.ViewLobby_WithdrawSetting_sweepTokens("10");
			lb.ViewLobby_WithdrawSetting_minimumAmountWithdrawal("10");
			lb.ViewLobby_WithdrawSetting_withdrawApprovalRequired("100");
			lb.ViewLobby_WithdrawSetting_PerTransactionLimit("10000");
			lb.ViewLobby_WithdrawSetting_perDayTransactionLimit("20000");
			// driver.findElement(By.xpath("//span[text()='Email Verified']")).click();
			lb.ClickToSave();
			cc.VerifyDataCheck(cc.Validation_Format_WithdrawSettings_saved);
		} else {

			test.fail("Something Wrong! not verify  Withdraw label.", extentScreenshot());
		}
		test.info("TestCase End - Lobby Withdraw Setting");
	}

	public void PlayerSetting_Signup(String loby, String email, String phon) throws Exception {
		test = extentCreateTest("player Settings -> Sign Up Options");
		test.info("Test case started : player Settings -> Sign Up Options");

		LobbyPage lb = new LobbyPage(driver);
		PageReload();
		storecheck.LobbyRedirect("view", loby);
		lb.clickViewLobby_PlayerSetting();

		if (email.equalsIgnoreCase("email")) {
			lb.PlayerSettingsSignupEmail.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked email");
			test.info("Not clicked email");
		}
		if (phon.equalsIgnoreCase("phone")) {
			lb.PlayerSettingsSignupphoneNumber.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked phone");
			test.info("Not clicked phone");
		}
		lb.ClickToSave();
		test.info("Test case end : player Settings -> Sign Up Options");
	}

	public void PlayerSetting_PlayerProfile(String loby, String email, String phon) throws Exception {
		test = extentCreateTest("player Settings -> PlayerProfile");
		test.info("Test case started : player Settings -> PlayerProfile");
		LobbyPage lb = new LobbyPage(driver);
		PageReload();
		storecheck.LobbyRedirect("view", loby);
		lb.clickViewLobby_PlayerSetting();

		if (email.equalsIgnoreCase("email")) {
			lb.PlayerSettingsProfileOptionsEmail.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked email");
			test.info("Not clicked email");
		}
		if (phon.equalsIgnoreCase("phone")) {
			lb.PlayerSettingsProfileOptionsNumber.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked phone");
			test.info("Not clicked phone");
		}
		lb.ClickToSave();
		test.info("Test case end : player Settings ->Player Profile Options");
	}

	public void PlayerSetting_GuestToPlayer(String loby, String email, String phon, String kyc) throws Exception {
		test = extentCreateTest("player Settings -> Guest to Player");
		test.info("Test case started : player Settings -> Guest to Player");
		LobbyPage lb = new LobbyPage(driver);
		PageReload();
		storecheck.LobbyRedirect("view", loby);
		lb.clickViewLobby_PlayerSetting();

		if (email.equalsIgnoreCase("email")) {
			lb.PlayerSettingsGuesttoPlayerEmail.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked email");
			test.info("Not clicked email");
		}
		if (phon.equalsIgnoreCase("phone")) {
			lb.PlayerSettingsGuesttoPlayerphoneNumber.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked phone");
			test.info("Not clicked phone");
		}
		if (kyc.equalsIgnoreCase("kyc")) {
			lb.PlayerSettingsGuesttoPlayerkyc.click();
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked kyc");
			test.info("Not clicked kyc");
		}
		lb.ClickToSave();
		test.info("Test case end : player Settings ->Guest to Player");
	}

	// public void WithdrawSettingsVerification(String email,String phone) throws
	// IOException, InterruptedException
//	{
//		LobbyPage lb = new LobbyPage(driver);
//		
//		test = extentCreateTest("Store Withdraw settings - Email/phone varification"); 		
//		test.info("TestCase started Store Withdraw settings - Email/phone varification");	
//				
//		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
//		lb.clickViewLobby_Withdraw();
//		test.info("click on Withdraw settings");
//
//		Thread.sleep(1000); 
//		
//		WebElement emailverify=driver.findElement(By.xpath("//span[text()='Email Verified']"));
//		if(emailverify.getText().equalsIgnoreCase("Email Verified'")) {
//			emailverify.click();			
//			test.info("Email varify ON");						
//			lb.ClickToSave();
//			Thread.sleep(2000);		
//						
//			if (driver.findElements(By.xpath("//span[text()=\"Withdraw Settings data save successfully\"]")).size()>0) {
//			//	test.info("Successfully saved Withdraw settings",extentScreenshot());
//				test.pass("Withdraw setting - Save message return",extentScreenshot());
//				 BaseClass.gotoTab(driver, 1);
//				 WebsiteLogin(email, phone);
//			}else{
//				test.fail("Something Wrong ! not able get save Withdraw setting message ",extentScreenshot());
//			}			
//		} else {
//			
//			test.fail("Something Wrong! not verify  Withdraw label.",extentScreenshot());
//		} 
//		test.info("TestCase End Store Withdraw settings - Email/phone varification");
//	}
	@Test
	public void Y_LobbyManagement_AppSetting_add() throws IOException, InterruptedException {
		test = extentCreateTest("lobby App settings Save");
		test.info("TestCase started Lobby_AppSetting- As an admin user I should be able to view Lobby_AppSetting");
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(1000);

		// Working
		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		// lb.SearchItems(LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_AppSetting();

		// ----save App Setting --------
		test.info("save app setting test case start");
		if (lb.ViewLobby_AppSetting_title.getText().equalsIgnoreCase("Information")) {
			test.info("Successfully verify app settings label.");
			lb.AppSetting_Company("Gameium");
			lb.AppSetting_website("www.gameium.com");
			lb.AppSetting_TermsCondition("www.gameium.com/contact-us/");
			lb.AppSetting_PrivacyPolicy("www.gameium.com/contact-us/");
			lb.AppSetting_copyRights("www.gameium.com/contact-us/");
			lb.AppSetting_ResponsibleGamingLink("www.gameium.com/contact-us/");
			lb.AppSetting_RedemptionPolicyLink("www.gameium.com/contact-us/");
			lb.AppSetting_SweepRulesLink("www.gameium.com/contact-us/");
			lb.AppSetting_faqUrl("www.gameium.com/contact-us/");
			lb.SetNewsicon(LobbyEnum.Upload_Icon.getValue());
			lb.ClickToSave();
			Thread.sleep(1500);

			boolean isDisplayed = CommonCosmo.Validation_Format_SaveAppSettings.isDisplayed();
			String message = isDisplayed ? "<b><i>app setting - Save message return</b></i>"
					: "<b><i>not able show app setting - Save message return</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		} else {
			test.fail("Not verify save app setting -Information label.", extentScreenshot());
		}
		Thread.sleep(2000);
		test.info("save app setting test case end");
	}

	@Test
	public void Ya_LobbyManagement_AppSetting_delete() throws IOException, InterruptedException {
		test = extentCreateTest("lobby App settings Delete");

		test.info("TestCase started Lobby_AppSetting- As an admin user I should be able to view Lobby_AppSetting");
		LobbyPage lb = new LobbyPage(driver);

		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_AppSetting();

		// -----delete version-------
		test.info("delete app setting test case start");
		Thread.sleep(1000);
		if (lb.Deletebutton.isDisplayed() == true) {
			test.pass("Successfully delete -app settings", extentScreenshot());
			Thread.sleep(1000);
			lb.Deleteappsetings();

			boolean isDisplayed = CommonCosmo.Validation_Format_DeleteAppSettings.isDisplayed();
			String message = isDisplayed ? "<b><i>app setting - delete message return</b></i>"
					: "<b><i>not able show app setting - delete message return</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		} else {
			test.fail("Something Wrong! not able to delete app setting ", extentScreenshot());
		}
		Thread.sleep(3000);
		test.info("Delete app setting test case end");
	}

//	@Test 
//	public void Za_LobbyManagement_WebsiteSetting_SignUp() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Website Settings - Sign Up");
//		
//		LobbyPage lb = new LobbyPage(driver);
//		//CommonCosmo cc=new CommonCosmo(driver);
//		
//		Thread.sleep(1000);
//		lb.clickViewLobby_WebsiteSetting();
//		lb.clickViewLobby_WebsiteSetting_Signup();
//		test.info("clicked SignUp Website settings");
//		driver.findElement(By.xpath("(//input[@type=\"file\"])[1]")).sendKeys(LobbyEnum.Upload_Icon.getValue());
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//input[@type=\"file\"])[2]")).sendKeys(LobbyEnum.Upload_Icon.getValue());
//		Thread.sleep(3000);
//
//		lb.clickViewLobby_WebsiteSetting_Signup_details("SignUp page","welcome to the site,this is signup page");
//		test.info("Entered title successfully");
//		test.info("Entered Description successfully");
//		
//		lb.ClickToSave();
//		Thread.sleep(1000);
//		test.info("clicked to save Website settings Signup",extentScreenshot());
//		Thread.sleep(1000);
//		//Boolean bool_delAppSetting=cc.Validation_Format_Website_Signup.isDisplayed();
//		if(driver.findElement(By.xpath("//span[text()=\"Sign up save successfully\"]")).isDisplayed()==true){
//			test.pass("Website setting add  Signup message return",extentScreenshot());
//		}else if (driver.findElement(By.xpath("//span[text()=\"Sign up updated successfully\"]")).isDisplayed()==true) {
//			test.pass("Website setting update  Tab Access message return",extentScreenshot());
//		}		
//		else{
//			test.fail("Something Wrong ! not able get add Website Signup message ",extentScreenshot());
//		}
//		Thread.sleep(2000);
//		test.info("Website settings Signup TestCase End");
//	}

	public void PurchaseStoreSetting(String loby, String other, String cashapp, String paysafe, String zen,
			String wallet, String seam, String contactus, String skrill) throws IOException, InterruptedException {

		test = extentCreateTest("Store Settings -> Purchase");
		test.info("TestCase staretd - Store Sttings");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		PageReload();
		storecheck.LobbyRedirect("view", loby);
		lb.clickViewLobby_StoreSetting();
		if (other.equalsIgnoreCase("Other")) {
			lb.otherPurchase_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked other");
			test.info("Not clicked other");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (cashapp.equalsIgnoreCase("cashapp")) {
			lb.cashAppPurchase_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("CashApp");
		} else {
			System.out.println("Not clicked cashAppPurchase");
			test.info("Not clicked cashAppPurchase");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (paysafe.equalsIgnoreCase("paysafe")) {
			lb.paySafePurchase_click.click();
			LobbyEnum.Skrillmethod.setValue("Paysafe");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked paySafePurchase");
			test.info("Not clicked paySafePurchase");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
//		Thread.sleep(1000);
//		if (zen.equalsIgnoreCase("zenpayment")) {
//			lb.zenPaymentPurchase_click.click();
//			Thread.sleep(500);
//			LobbyEnum.Skrillmethod.setValue("Bank Card");
//		} else {
//			System.out.println("Not clicked zenPaymentPurchase");
//			test.info("Not clicked zenPaymentPurchase");
//			LobbyEnum.Skrillmethod.setValue("Other");
//		}
		Thread.sleep(1000);
		if (wallet.equalsIgnoreCase("wallet")) {
			lb.walletPurchase_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("Wallet");
		} else {
			System.out.println("Not clicked walletPurchase");
			test.info("Not clicked walletPurchase");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (seam.equalsIgnoreCase("seamless")) {
			lb.seamlessChexPurchase_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("Seamless");
		} else {
			System.out.println("Not clicked seamlessChexPurchase");
			test.info("Not clicked seamlessChexPurchase");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);

		if (contactus.equalsIgnoreCase("contactUs")) {
			lb.contactUsPurchase_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");
			Thread.sleep(500);
		} else {
			test.info("Not clicked contactUsPurchase");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (skrill.equalsIgnoreCase("skrill")) {
			lb.skrillPurchase_click.click();
			LobbyEnum.Skrillmethod.setValue("Skrill");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked skrill");
			test.info("Not clicked skrill");
			LobbyEnum.Skrillmethod.setValue("Other");
		}

		lb.ClickToSave();
		Thread.sleep(1000);
		boolean isDisplayed = cc.Validation_Format_StoreAdd.isDisplayed();
		String message = isDisplayed ? "Store setting add  message return"
				: "not able to show Store setting add  message return";
		test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		Thread.sleep(2000);
		test.info("Purchase Store settings TestCase End");

	}

	public void WithdrawStoreSetting(String loby, String seam, String skrill, String cashapp, String bank,
			String wallet, String contactus, String manual, String paysafe) throws IOException, InterruptedException {
		test = extentCreateTest("Store Settings -> Withdraw");
		test.info("Withdraw Store settings TestCase Start");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PageReload();

		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_StoreSetting();

		if (seam.equalsIgnoreCase("seamless")) {
			lb.seamlessChexWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("seamless");
		} else {
			System.out.println("Not clicked seamlessChexWithdraw");
			test.info("Not clicked seamlessChexWithdraw");
			LobbyEnum.Withdrawmethod.setValue("other");
		}
		Thread.sleep(1000);
		if (skrill.equalsIgnoreCase("skrill")) {
			lb.skrillWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("skrill");
		} else {
			System.out.println("Not clicked skrill");
			test.info("Not clicked skrill");
			LobbyEnum.Withdrawmethod.setValue("other");
		}
		Thread.sleep(1000);
		if (cashapp.equalsIgnoreCase("cashapp")) {
			lb.bankAccountWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("cashapp");
		} else {
			System.out.println("Not clicked cashAppPurchase");
			test.info("Not clicked cashAppPurchase");
			LobbyEnum.Withdrawmethod.setValue("other");
		}
		Thread.sleep(1000);
		if (bank.equalsIgnoreCase("bank")) {
			lb.paySafeWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("bank");
		} else {
			System.out.println("Not clicked zenPaymentPurchase");
			test.info("Not clicked zenPaymentPurchase");
			LobbyEnum.Withdrawmethod.setValue("other");
		}
		Thread.sleep(1000);
		if (wallet.equalsIgnoreCase("wallet")) {
			lb.tokenToWallet_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("wallet");
		} else {
			System.out.println("Not clicked tokenToWallet");
			test.info("Not clicked tokenToWallet");
			LobbyEnum.Withdrawmethod.setValue("other");
		}
		Thread.sleep(1000);
		if (contactus.equalsIgnoreCase("contactUs")) {
			lb.contactUsWithdraw_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");
			Thread.sleep(500);
		} else {
			test.info("Not clicked contactUs ");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (manual.equalsIgnoreCase("manual")) {
			lb.manualWithdraw_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");
			Thread.sleep(500);
		} else {
			test.info("Not clicked manual");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);

		if (paysafe.equalsIgnoreCase("paysafe")) {
			lb.cashAppWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Withdrawmethod.setValue("paysafe");
		} else {
			System.out.println("Not clicked paySafePurchase");
			test.info("Not clicked paySafePurchase");
			LobbyEnum.Withdrawmethod.setValue("other");
		}

		lb.ClickToSave();
		// cc.VerifyDataCheck(cc.Validation_Format_Storeupdate);
		if (driver.findElements(By.xpath("//span[text()=\"Store Settings update successfully\"]")).size() > 0) {
			test.pass("Store setting update message return", extentScreenshot());
			Thread.sleep(2000);
		} else {
			test.fail("Something Wrong ! not able get update Store message ", extentScreenshot());
		}
		Thread.sleep(2000);
		test.info("withdraw Store settings TestCase End");
	}

	public void WalletDepositOptions(String loby, String seamless, String other, String skrill, String cashapp,
			String paysafe, String zen) throws IOException, InterruptedException {
		test = extentCreateTest("Store Settings-> wallet deposit");
		test.info("TestCase - Purchase Store settings Start");
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		PageReload();
		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_StoreSetting();

		if (seamless.equalsIgnoreCase("seamless")) {
			lb.seamlessChexWalletDeposit_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked seamless");
			test.info("Not clicked seamless");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (other.equalsIgnoreCase("other")) {
			lb.otherWalletDeposit_click.click();
			LobbyEnum.Skrillmethod.setValue("Other");

			Thread.sleep(500);
		} else {
			System.out.println("Not clicked other");
			test.info("Not clicked other");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (cashapp.equalsIgnoreCase("cashapp")) {
			lb.walletCashAppDeposit_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("Other");

		} else {
			System.out.println("Not clicked walletCashAppDeposit");
			test.info("Not clicked walletCashAppDeposit");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (paysafe.equalsIgnoreCase("paysafe")) {
			lb.walletPaySafeDeposit_click.click();
			LobbyEnum.Skrillmethod.setValue("Paysafe");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked walletPaySafeDeposit");
			test.info("Not clicked walletPaySafeDeposit");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);

		// removed from system
//		if (zen.equalsIgnoreCase("zenpayment")) {
//			lb.walletZenPaymentDeposit_click.click();
//			Thread.sleep(500);
//			LobbyEnum.Skrillmethod.setValue("Zen");
//		} else {
//			System.out.println("Not clicked walletZenPaymentDeposit");
//			test.info("Not clicked walletZenPaymentDeposit");
//			LobbyEnum.Skrillmethod.setValue("Other");
//		}
		Thread.sleep(1000);
		if (skrill.equalsIgnoreCase("skrill")) {
			lb.walletSkrillDeposit_click.click();
			LobbyEnum.Skrillmethod.setValue("Skrill");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked walletSkrillDeposit");
			test.info("Not clicked walletSkrillDeposit");
			LobbyEnum.Skrillmethod.setValue("Other");
		}

		lb.ClickToSave();
		// cc.VerifyDataCheck(cc.Validation_Format_Storeupdate);
		if (driver.findElements(By.xpath("//span[text()=\"Store Settings update successfully\"]")).size() > 0) {
			test.pass("Store setting update  message return", extentScreenshot());
			Thread.sleep(2000);
		} else {
			test.fail("Something Wrong ! not able get add Store  message ", extentScreenshot());
		}
		Thread.sleep(2000);
		test.info("TestCase - Purchase Store settings End");
	}

	public void WalletWithdrawOptions(String loby, String skrill, String cashapp, String paysafe, String chex,
			String zen) throws IOException, InterruptedException {
		test = extentCreateTest("Store Settings-> wallet withdraw");

		test.info("TestCase - Purchase Store settings Start");
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		PageReload();
		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_StoreSetting();
		Thread.sleep(1000);

		if (cashapp.equalsIgnoreCase("cashapp")) {
			lb.walletCashAppWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("Other");
		} else {
			System.out.println("Not clicked walletCashAppWithdraw");
			test.info("Not clicked walletCashAppWithdraw");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		if (paysafe.equalsIgnoreCase("paysafe")) {
			lb.walletPaySafeWithdraw_click.click();
			LobbyEnum.Skrillmethod.setValue("Paysafe");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked walletPaySafeWithdraw");
			test.info("Not clicked walletPaySafeWithdraw");
			LobbyEnum.Skrillmethod.setValue("Other");
		}
		Thread.sleep(1000);
		// removed from system
//		if (zen.equalsIgnoreCase("bank")) {
//			lb.walletBankAccountWithdraw_click.click();
//			Thread.sleep(500);
//			LobbyEnum.Skrillmethod.setValue("Zen");
//		} else {
//			System.out.println("Not clicked walletBankAccountWithdraw");
//			test.info("Not clicked walletBankAccountWithdraw");
//			LobbyEnum.Skrillmethod.setValue("Other");
//		}
		Thread.sleep(1000);
		if (chex.equalsIgnoreCase("chex")) {
			lb.walletBankAccountWithdraw_click.click();
			Thread.sleep(500);
			LobbyEnum.Skrillmethod.setValue("chex");
		} else {
			System.out.println("Not clicked seamlessChexWalletWithdraw");
			test.info("Not clicked chex seamlessChexWalletWithdraw");
			LobbyEnum.Skrillmethod.setValue("chex");
		}
		Thread.sleep(1000);
		if (skrill.equalsIgnoreCase("skrill")) {
			lb.walletSkrillWithdraw_click.click();
			LobbyEnum.Skrillmethod.setValue("Skrill");
			Thread.sleep(500);
		} else {
			System.out.println("Not clicked walletSkrillWithdraw");
			test.info("Not clicked walletSkrillWithdraw");
			LobbyEnum.Skrillmethod.setValue("Other");
		}

		lb.ClickToSave();
		// cc.VerifyDataCheck(cc.Validation_Format_Storeupdate);
		if (driver.findElements(By.xpath("//span[text()=\"Store Settings update successfully\"]")).size() > 0) {
			test.pass("Store setting update  message return", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able get add Store  message ", extentScreenshot());
		}
		Thread.sleep(2000);
		test.info("Purchase Store settings TestCase End");
	}

	@Test
	public void Zc_LobbyManagement_CorporationDetails() throws IOException, InterruptedException {
		test = extentCreateTest("Corporation Details");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		Thread.sleep(1000);
		lb.clickViewLobby_CorporationDetails();
		lb.clickViewLobby_CorporationDetails_address("15455 North Dallas Parkway, Suite 1250, Addison Texas, 75001");
		lb.clickViewLobby_CorporationDetails_contactNumber("1231231230");
		lb.clickViewLobby_CorporationDetails_email("hello@cosmoslots.com");
		lb.clickViewLobby_CorporationDetails_name("cosmoslots");
		lb.ClickToSave();

		boolean isDisplayed = cc.Validation_Format_Corporationdetails.isDisplayed();
		String message = isDisplayed ? "Corporation Details save  message return"
				: "not able to show Corporation Details save  message return";
		test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		Thread.sleep(2000);
		test.info("Corporation Details TestCase End");
	}

	@Test
	public void Zd_LobbyManagement_AppMarketing_Create() throws IOException, InterruptedException {
		test = extentCreateTest("Create - App Marketing");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("App Marketing TestCase start");

		storecheck.LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_AppMarketing();
		lb.clickToCreate();

		if (cc.check(cc.addMarketingHeader)) {
			Thread.sleep(1000);
			lb.selectRole(LobbyEnum.storerole.getValue());
			lb.selectUsername(LobbyEnum.storeusername.getValue());
			lb.SetNewsTitle("This is bonus template");
			lb.setactionUrl("Bonus");
			driver.findElement(By.xpath("//input[@formcontrolname='sortOrder']")).sendKeys("1");
			lb.Maintenance_Desc("This is bonus description");
			lb.setAddMarketing_photo(LobbyEnum.Upload_Icon.getValue());
			lb.ClickToSave();
			Thread.sleep(2000);
			if (cc.check(cc.Marketingsave)) {
				lb.verifyRecordInAppMarketing("Bonus");
			} else {
				test.fail("Something Wrong -> while Marketing save successfully", extentScreenshot());
				Thread.sleep(5000);
				lb.ClickToCancel();
			}
		} else {
			test.info("Something Wrong -> not found app marketing template heading");
		}
		Thread.sleep(1000);
		test.info("App Marketing TestCase End");
	}

	@Test
	public void Zf_LobbyManagement_AppMarketing_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("Edit - App Marketing");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test.info("Edit - App Marketing TestCase start");
		Thread.sleep(1000);
		lb.clickViewLobby_AppMarketing();
		lb.SearchItems("Bonus");
		if (lb.EditButton.isDisplayed() == true) {
			lb.clickToEdit();
			if (lb.UpdateMarketinglabel.isDisplayed() == true) {
				Thread.sleep(2000);
				// lb.selectRole(LobbyEnum.storerole.getValue());
				// lb.selectUsername(LobbyEnum.storeusername.getValue());
				// lb.Set_HomePage_photo(LobbyEnum.Upload_Icon.getValue());
				lb.SetNewsTitle("This is bonus template");
				// lb.setactionUrl("Bonus");
				driver.findElement(By.xpath("//input[@formcontrolname=\"sortOrder\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"sortOrder\"]")).sendKeys("1");
				lb.Maintenance_Desc("This is edit bonus description for edit");
				lb.ClickToSave();

				if (cc.check(cc.Marketingupdated)) {
					lb.verifyRecordInAppMarketing("Bonus");
				} else {
					test.info("something Wrong->   Marketing save successfully");
					Thread.sleep(5000);
					lb.ClickToCancel();
				}
			} else {
				test.info("something Wrong -> not found update marketing heading");
			}
		} else {
			test.fail("Something Wrong! To View marketing edit button in a List.", extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("Edit - App Marketing TestCase End");
	}

	@Test
	public void Ze_LobbyManagement_AppMarketing_SearchStatus() throws IOException, InterruptedException {
		test = extentCreateTest("AppMarketing status");

		LobbyPage lb = new LobbyPage(driver);
		test.info("TestCase started status AppMarketing ");
		lb.SearchItems("Bonus");
		if (driver.findElement(By.xpath("//tbody//tr[1]//td[contains(text(),'Bonus')]")) != null) {
			test.pass("successfuly add marketing template. with Action  -> " + "Bonus", extentScreenshot());

			// status active/inactive
			if (driver.findElement(By
					.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]"))
					.getAttribute("title").equalsIgnoreCase("Un Publish")) {
				test.info("Successfully Viewed active AppMarketing page");
				test.info("Now StorePackage Is In Active");
				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				lb.clickToYesButton();
				try {
					if (driver.findElements(By.xpath("//span[text()=\"Marketing template activated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Lobby AppMarketing Successfully activated and Validation message appeared - Lobby AppMarketing activated successfully",
								extentScreenshot());
					} else {
						test.fail("Failed ! To View Message", extentScreenshot());
					}
				} catch (Exception e) {
					if (driver.findElement(
							By.xpath("//span[text()=\"Marketing template activated successfully\"]")) != null) {
						test.pass(
								"Lobby AppMarketing Successfully activated and Validation message appeared - Lobby AppMarketing activated successfully",
								extentScreenshot());
					}
					System.out.println(e);
				}
				Thread.sleep(4000);

			} else {
				test.info("Successfully Viewed View Icon of StorePackage listing page");
				test.info("Now StorePackage Is Active");

				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				lb.clickToYesButton();
				try {
					if (driver.findElements(By.xpath("//span[text()=\"Marketing template deactivated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Lobby AppMarketing Successfully deactivated and Validation message appeared - Lobby AppMarketing deactivated successfully",
								extentScreenshot());
					} else {
						test.fail("Failed ! To View Message", extentScreenshot());
					}
				} catch (Exception e) {
					if (driver.findElements(By.xpath("//span[text()=\"Marketing template deactivated successfully\"]"))
							.size() > 0) {
						test.pass(
								"Lobby AppMarketing Successfully deactivated and Validation message appeared - Lobby AppMarketing deactivated successfully",
								extentScreenshot());
					}
					System.out.println(e);
				}
			}
		} else {
			test.fail("Something Wrong!To View marketing template in a List.", extentScreenshot());
		}
		test.info("TestCase-status AppMarketing Ended");
	}

	@Test
	public void Zg_LobbyManagement_AppMarketing_Delete() throws IOException, InterruptedException {
		test = extentCreateTest("AppMarketing delete");

		LobbyPage lb = new LobbyPage(driver);

		// -----------delete AppMarketing-----------
		test.info("delete AppMarketing test case start");

		if (lb.packageDeletebuttonElement()) {
			lb.clickPackageDeletebuttonElement();
			lb.ClickYesDeleteIt();
			test.pass("<b><i>AppMarketing- delete successfully</b></i>", extentScreenshot());
			Thread.sleep(1000);

			boolean isDisplayed = CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
			String message = isDisplayed ? "<b><i>AppMarketing - delete message return</b></i>"
					: "<b><i>AppMarketing - not able to show delete message</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		} else {
			test.fail("<b><i>Delete button not found</b></i>", extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("Delete AppMarketing test case end");
	}

	@Test
	public void Zk_LobbyManagement_SocialMediaSettings_Create() throws IOException, InterruptedException {
		test = extentCreateTest("Create - SocialMediaSettings");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Social Media Settings TestCase start");

		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_Socialmedia();
		lb.clickToCreate();

		if (lb.AddSocialMediaSettingsHeading.isDisplayed() == true) {
			Thread.sleep(1000);
			lb.selectpos(LobbyEnum.POSname.getValue());
			lb.SocialMediaSettings_Create("facebook.com", "instagram.com", "twitter.com", "123123123");
			lb.ClickToSave();

			if (cc.check(cc.SocialMediaSettingssave)) {
				test.info("Social Media save successfully");
				Thread.sleep(2000);
				if (driver.findElement(By.xpath(
						"//tbody//tr[1]//td[contains(text(),'" + LobbyEnum.POSname.getValue() + "')]")) != null) {
					test.pass("successfuly add Social Media template. with Action  -> " + LobbyEnum.POSname.getValue(),
							extentScreenshot());
				} else {
					test.fail("Something Wrong!To View Social Media template in a List.", extentScreenshot());
				}
			} else {
				test.info("something went wrong -> while Social Media save successfully");
				Thread.sleep(5000);
				lb.ClickToCancel();
			}
		} else {
			test.fail("Something Wrong!To View Social Media settings.", extentScreenshot());
		}
	}

	@Test
	public void Zl_LobbyManagement_SocialMediaSettings_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("Edit - SocialMediaSettings");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		test.info("Edit SocialMedia Settings TestCase start");
		storecheck.LobbyRedirect("view", LobbyEnum.Lcode.getValue());

		lb.clickViewLobby_Socialmedia();
		if (lb.EditButton.isDisplayed() == true) {
			lb.clickToEdit();
			Thread.sleep(1000);
			if (lb.updateSocialMediaSettingsHeading.isDisplayed() == true) {
				Thread.sleep(1000);
				lb.SocialMediaSettings_Create("www.facebook.com", "www.instagram.com", "www.twitter.com", "123123123");
				lb.ClickToSave();

				if (cc.check(cc.SocialMediaSettingssave)) {
					test.info("Social Media save successfully");
					Thread.sleep(2000);
					if (driver.findElement(By.xpath(
							"//tbody//tr[1]//td[contains(text(),'" + LobbyEnum.POSname.getValue() + "')]")) != null) {
						test.pass("successfuly add Social Media template. with Action  -> "
								+ LobbyEnum.POSname.getValue(), extentScreenshot());
					} else {
						test.fail("Something Wrong!To View Social Media template in a List.", extentScreenshot());
					}
				} else {
					test.info("something went wrong -> while Social Media update successfully");
					Thread.sleep(5000);
					lb.ClickToCancel();
				}
			} else {
				test.fail("Something Wrong!To View Social Media settings.", extentScreenshot());
			}
		} else {
			test.fail("not found edit button on Social Media settings.", extentScreenshot());
		}
		test.info("Edit Social Media TestCase end");
	}

	@Test
	public void Zm_LobbyManagement_SocialMarketing_Delete() throws IOException, InterruptedException {
		test = extentCreateTest("Social Media delete");
		test.info("TestCase started delete Social Media  ");
		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc=new CommonCosmo(driver);

		Thread.sleep(1000);
		// -----------delete Social Media-----------
		test.info("delete Social Media test case start");
		if (lb.packageDeletebuttonElement()) {
			lb.packageDeleteItems();

			if (lb.VerifyYesDeleteIt()) {
				lb.ClickYesDeleteIt();

				boolean isDisplayed = CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
				String message = isDisplayed ? "Social Media - delete message return"
						: "not able to show Social Media - delete message ";
				test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
			} else {
				test.fail("<b><i>not able to delete</b></i>", extentScreenshot());
			}
		} else {
			test.info("delete button not found for Social Media", extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("delete Social Media test case end");
	}

	@Test
	public void Zz_LobbyManagement_WebsiteSetting_TabAccess() throws Exception {
		storecheck.WebsiteSetting_TabAccess(LobbyEnum.Lcode.getValue());
	}

}
