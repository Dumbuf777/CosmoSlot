package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.Status;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.ENUM.PlayerEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;

public class LobbyManagement extends BaseClass {
	BaseClass bc = new BaseClass();
	LobbyPage lobypage = new LobbyPage(driver);

	public void StoreValue() {

		Constant.emailArray.add("AT5426-2811");
		Constant.emailArray.add("AT5426-2812");
		Constant.emailArray.add("AT5426-2813");
	}

	public void playerlogin(String pid, String pass) throws InterruptedException, IOException {
		WebsiteLogin( pid, pass);
	}

	public void LobbyRedirect(String Lobbymenu, String Lobbycode) throws IOException, InterruptedException {
		StoreValue();
		gotoTab(driver, 0);
		PageReload();
		test.info("TestCase started lobby redirection from menu ");
		LobbyPage lb = new LobbyPage(driver);
		driver.get(AdminURL + Constant.AdminLobbyList);
		Thread.sleep(2000);

		if (Lobbymenu.equalsIgnoreCase("search")) {
			System.out.println("search");
			lb.SearchItems(Lobbycode);
		} else if (Lobbymenu.equalsIgnoreCase("edit")) {
			System.out.println("edit");
			lobbyEdit();
		} else if (Lobbymenu.equalsIgnoreCase("view")) {
			lb.SearchItems(Lobbycode);
			ViewLobby();
		} else {
			System.out.println("No lobby option selected");
			test.info("No lobby option selected");
		}
		Thread.sleep(1000);
	}

	@Test
	public void A_A_LobbyManagement_NewLobby() throws Exception {
		NewLobby(LobbyEnum.Lcode.getValue(), LobbyEnum.LobbyName.getValue(), "slot", "keno", "fish");
		CommonCosmo cc = new CommonCosmo(driver);
		if (cc.verifyStoreSaved()) {
			test.info("store saves successfully");
		} else {
			NewLobby(LobbyEnum.Lcode.getValue(), LobbyEnum.LobbyName.getValue(), "slot", "keno", "fish");
		}
	}

	@Test
	public void A_Aa_LobbyManagement_WithdrawSettings() throws Exception {
		WithdrawSettings(LobbyEnum.Lcode.getValue());
	}

	@Test
	public void A_Ab_LobbyManagement_WebsiteSetting_TabAccess() throws Exception {
		WebsiteSetting_TabAccess(LobbyEnum.Lcode.getValue());
	}

	@Test
	public void A_Ac_LobbyManagement_StoreSettingPurchaseStoreSetting() throws Exception {
		PurchaseStoreSetting(LobbyEnum.Lcode.getValue(), "other", "cashapp", "paysafe", "zenpayment", "wallet",
				"seamless", "contactUs", "skrill");
	}

	@Test
	public void A_Ad_LobbyManagement_StoreSettingWithdrawStoreSetting() throws Exception {
		WithdrawStoreSetting(LobbyEnum.Lcode.getValue(), "seamless", "skrill", "cashapp", "bank", "wallet", "contactUs",
				"manual", "paysafe");
	}

	@Test
	public void A_Ae_LobbyManagement_StoreSettingWalletDepositOptions() throws Exception {
		WalletDepositOptions(LobbyEnum.Lcode.getValue(), "seamless", "other", "skrill", "cashapp", "paysafe",
				"zenpayment");
	}

	@Test
	public void A_Af_LobbyManagement_StoreSettingWalletWithdrawOptions() throws Exception {
		WalletWithdrawOptions(LobbyEnum.Lcode.getValue(), "skrill", "cashapp", "paysafe", "chex", "bank");
	}

	@Test
	public void A_Ag_LobbyManagement_PlayerSetting_PlayerProfile() throws Exception {
		PlayerSetting_PlayerProfile(LobbyEnum.Lcode.getValue(), "email", "phone");
	}

	@Test
	public void A_Ah_LobbyManagement_PlayerSetting_Signup() throws Exception {
		PlayerSetting_Signup(LobbyEnum.Lcode.getValue(), "email", "phone");
	}

	@Test
	public void A_Ai_LobbyManagement_PlayerSettingGuestToPlayer() throws Exception {
		PlayerSetting_GuestToPlayer(LobbyEnum.Lcode.getValue(), "email", "phone", "kyc1");
	}

	@Test
	public void A_Az_LobbyManagement_StoreFlow() throws Exception {
		UserHierarchy uh = new UserHierarchy();
		Thread.sleep(2000);
		try {
			uh.parentString = " Gameium Admin ";
			for (int i = 0; i < Constant.strAr.length; i++) {
				System.out.println(Constant.strAr[i]);
				uh.CreateNewUsers(Constant.strAr[i], LobbyEnum.Lcode.getValue(), uh.parentString);

				if (Constant.strAr[i].equalsIgnoreCase("POS ")) {
					LobbyEnum.POSnmm.setValue(uh.username);
					System.out.println("POS name =>" + LobbyEnum.POSnmm.getValue());
				}
				if (Constant.strAr[i].equalsIgnoreCase("Store ")) {
					LobbyEnum.storeusername.setValue(uh.map.get("Store ") + " ");
					System.out.println("store name =>" + uh.map.get("Store "));
				}
				System.out.println("invite code->" + uh.codeArray);
				LobbyEnum.invitecode.setValue(uh.codeArray);
			}
		} catch (Exception e) {
			System.out.println("something went wrong - not able to create user " + e);
			test.info("something went wrong - not able to create user " + e);
		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(500);
	}

	public void NewLobby(String lobbycode, String lobbyname, String slotgame, String kenogame, String fishgame)
			throws IOException, InterruptedException {
		test = extentCreateTest("create new lobby");
		test.info("TestCase started create new Lobby");
		LobbyPage lb = new LobbyPage(driver);

		driver.get(AdminURL + Constant.AdminLobbyList);

		if (lb.VerifyStoreManagement_header()) {
			lb.clickToCreate();
			// lb.clickOwnerBased();
			lb.selectStoreType("owner");
			lb.Setlobbycode(lobbycode);
			lb.Setlobbyname(lobbyname);
			lb.Player_Registration_Link(LobbyEnum.Weburl.getValue());
			lb.setCountry();
			lb.Set_Desc(LobbyEnum.LobbyDescription.getValue());

			if (slotgame.equalsIgnoreCase("slot"))
				lb.setGames("Cash War"); // all games selected

			if (kenogame.equalsIgnoreCase("keno"))
				lb.setKenoGames("Snooker");

			if (fishgame.equalsIgnoreCase("fish"))
				lb.setFishGames("Ocean Bombard");

			lb.LobbySave();

		} else {
			test.info("Something wrong! To save data");
		}
		test.info("TestCase- Add Store Ended");
	}

	@Test
	public void A_B_LobbyManagement_Search() throws IOException, InterruptedException {

		test = extentCreateTest("search lobby");
		LobbyPage lb = new LobbyPage(driver);
		test.info("TestCase started lobby Search");
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.verifyDataOnSearch(LobbyEnum.Lcode.getValue());
		test.info("TestCase Search Store Ended");
	}

	public void lobbymaintenance(String lobby) throws IOException, InterruptedException {

		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc = new CommonCosmo(driver);
		LobbyRedirect("search", lobby);
		Thread.sleep(1000);
		if (lb.VerifyStoreAccountMaintenanceMode_label() == true) {
			lb.clickViewMaintenance();
			if (lb.VerifyStoreAccountMaintenanceMode_header() == true) {
				lb.Click_Maintenance_platform();
				// lb.ClickDesc();
				lb.Maintenance_Desc("Lobby under Maintenance mode");
				lb.ClickToSave();
				lb.ClickToYes();
				// cc.Verifylobbymaintenance(cc.maintenancedatasaved, cc.maintenancedataupdate);
				if (driver.findElements(By.xpath("//span[text()=\"Store maintenance data saved successfully\"]"))
						.size() > 0) {
					test.pass("<b><i>Store maintenance data saved successfully</b></i>", extentScreenshot());
				} else if (driver
						.findElements(By.xpath("//span[text()=\"Store maintenance data update successfully\"]"))
						.size() > 0) {
					test.pass("<b><i>Store maintenance data update successfully</b></i>", extentScreenshot());
					// Thread.sleep(1000);
				} else {
					test.fail("<b><i>Store maintenance data update successfully message not displayed</b></i>",
							extentScreenshot());
				}
				Thread.sleep(1000);
			} else {
				test.info("Store Account Maintenance Mode popup not found", extentScreenshot());
			}
		} else {
			test.fail("Store Account Maintenance button not found", extentScreenshot());
		}
		Thread.sleep(1500);
	}

	@Test
	public void A_C_LobbyManagement_Maintenance() throws IOException, InterruptedException {
		test = extentCreateTest("Store Maintenance");
		test.info("TestCase Store Maintenance Start");
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lobbymaintenance(LobbyEnum.Lcode.getValue());
		test.info("TestCase Store Maintenance Ended");
		Thread.sleep(1500);
	}

	@Test
	public void A_D_LobbyManagement_Copy() throws IOException, InterruptedException {
		test = extentCreateTest("copy store link");
		Thread.sleep(2000);
		test.info("TestCase started Copy store link - As an admin user I should be able to Copy  store link ");

		LobbyPage lb = new LobbyPage(driver);
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.VerifyCopyLink();
		test.info("TestCase-copy lobby Ended");
	}

	public void ViewLobby() throws IOException, InterruptedException {
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//tbody//tr//td[contains(@class,'cdk-column-code')]")) != null) {
			test.pass("successfuly view Data on Grid", extentScreenshot());
			lb.clickViewLobby();
		} else {
			test.fail("Something Wrong!To View record", extentScreenshot());
		}
	}

	@Test
	public void A_F_LobbyManagement_View() throws IOException, InterruptedException {
		test = extentCreateTest("Store View");
		test.info("TestCase started view lobby - As an admin user I should be able to view lobby ");
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		test.info("TestCase-view lobby Ended");
	}

	public void lobbyEdit() throws IOException, InterruptedException {

		Thread.sleep(2000);
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		if (cc.check(lb.editElement)) {
			lb.clickToEdit();
			List<WebElement> boxes = driver.findElements(By.className("ri-close-fill"));

			if (boxes.size() != 0) {
				System.out.println(boxes.size() + " Elements found by TagName \n");
				for (WebElement inputElement : boxes) {
					inputElement.click();
				}
			}
			Thread.sleep(1000);
			lb.setCountry();
			lb.setGames("Machu Picchu");
			lb.setKenoGames("Snooker");
			lb.setFishGames("Ocean Bombard");

			// lb.Player_Registration_Link("https://qa-cpweb-admin.cosmoslots.tech");
			lb.Set_Desc("This is just for AutoTesting");
			lb.ClickToSave();
			cc.VerifyStoreUpdated(cc.StoreUpdatedSuccessfully);
		} else {
			test.info("Edit button not found", extentScreenshot());
		}
		Thread.sleep(1000);
	}

	@Test
	public void A_G_LobbyManagement_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("Edit store");
		test.info("TestCase started Edit Store - As an admin user I should be able to Edit Store");
		Thread.sleep(2000);
		LobbyRedirect("edit", LobbyEnum.Lcode.getValue());
		test.info("TestCase - Edit Store Ended");
	}

	@Test
	public void A_H_LobbyManagement_Profile() throws IOException, InterruptedException {
		test = extentCreateTest("Store profile");
		Thread.sleep(2000);
		test.info("TestCase started Store profile - As an admin user I should be able to view Store profile");
		LobbyPage lb = new LobbyPage(driver);
		System.out.println(LobbyEnum.Lcode.getValue());
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_Profile();
		lb.verifyLobbyProfile(LobbyEnum.Lcode.getValue());
		test.info("TestCase - profile lobby Ended");
	}

	@Test
	public void A_Ha_LobbyManagement_Coupon_Add() throws IOException, InterruptedException {
		test = extentCreateTest("Add Store Coupon");
		LobbyPage lb_coupon = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		lb_coupon.storeRedirect();
		lb_coupon.SearchItems(LobbyEnum.Lcode.getValue());
		lb_coupon.clickViewLobby();
		lb_coupon.clickViewLobby_coupon();
		lb_coupon.clickToCreate();

		// ----add coupon --------
		if (lb_coupon.VerifyAddCoupon()) {
			test.info("Successfully verify store Add label.");
			Thread.sleep(1000);
			lb_coupon.selectRole(LobbyEnum.storerole.getValue());
			lb_coupon.selectUsername(LobbyEnum.storeusername.getValue());
			lb_coupon.setcouponName(LobbyEnum.storecouponName.getValue());
			lb_coupon.Setlobbycode(LobbyEnum.storecouponName.getValue());
			lb_coupon.Setcoupon_discountedPercentage(LobbyEnum.storecouponamount.getValue());

//			DateFormat dform = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
//			Date obj = new Date();
//			String cdate=dform.format(obj).toString().substring(0, 2);
//			System.out.println(cdate);			

			System.out.println(Constant.DateInt);
			lb_coupon.Setcoupon_startDate(Integer.toString(Constant.DateInt));
			lb_coupon.startsAtTime.sendKeys("0000");
			lb_coupon.Setcoupon_expiryAt(Integer.toString(30));
			lb_coupon.expiryAtTime.sendKeys("2300");

			List<WebElement> boxes = driver.findElements(By.className("couponPurchaseDaysItem"));
			if (!boxes.isEmpty()) {
				for (WebElement inputElement : boxes) {
					System.out.println(inputElement.getText());
					inputElement.click();
				}
			}

			lb_coupon.selectCouponType(LobbyEnum.afterpurchase.getValue());
			// lb_coupon.selectCouponType(LobbyEnum.onpurchase.getValue());
			if (driver.findElements(By.xpath("//input[@formcontrolname=\"usageByPlayer\"]")).size() > 0) {
				lb_coupon.Setcoupon_usageByPlayer("50");
			} else {
				test.info("on Package Purchase selected");
			}
			test.info("select  = <b>" + "coupon purchase days selected" + "</b>");
			lb_coupon.Setcoupon_activationAfterPurchase("1");
			lb_coupon.ClickToSave();
			Thread.sleep(1000);

			cc.VerifyData(cc.couponSave);
		} else {
			test.fail("Something Wrong! not verify add coupon label.", extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("TestCase - add coupon Ended");
	}

	@Test
	public void A_I_LobbyManagement_Bonus_Create() throws IOException, InterruptedException {
		LobbyManagement_BonusCreate(LobbyEnum.Lcode.getValue(), "" + Constant.BonusGL, "" + Constant.BonusSL,
				LobbyEnum.nameBonusLevel.getValue(), Constant.numberOfReferrals, Constant.rechargeAmount);
	}

	public void LobbyManagement_Bonus_Redirect(String code) throws IOException, InterruptedException {
		LobbyPage lb = new LobbyPage(driver);
		PageReload();
		Thread.sleep(2000);
		lb.storeRedirect();
		lb.SearchItems(code);
		lb.clickViewLobby();
		lb.clickViewLobby_Bonus();
		Thread.sleep(1000);
	}

	public void LobbyManagement_BonusCreate(String loby, String BonusGL, String BonusSL, String nameBonusLevel,
			int numberOfReferrals, int rechargeAmount) throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus create");
		test.info("TestCase started Create Store Bonus- As an admin user I should be able to Create Store Bonus");
		LobbyManagement_Bonus_Redirect(loby);

		// String BonusName="Daily Login Bonus";
		test.info("Create Store bonus test case start");
		ArrayList<String> list = new ArrayList<String>();
		list.add("Player Register ");
		list.add("Level Wise Referral Bonus ");
		list.add("Daily Login Bonus ");
		list.add("First Time Recharge ");
		// list.add("Facebook Binding ");
		// list.add("Mobile Verify ");
		// list.add("Profile Verify ");
		// list.add("Weekly Bonus ");

		// ------Create bonus -----------------
		System.out.println(list.size());

		if (!list.isEmpty()) {
			for (String inputElement : list) {
				LobbyPage lb1 = new LobbyPage(driver);
				System.out.println(inputElement);
				lb1.clickTo_CreateBonus();
				lb1.selectRole(LobbyEnum.storerole.getValue());
				lb1.selectUsername(LobbyEnum.storeusername.getValue());
				// lb.setBonusName("Bonus"+randomString);
				lb1.setBonusName(inputElement);
				lb1.setBonusAction(inputElement);
				lb1.gameToken(BonusGL);
				lb1.sweepToken(BonusSL);

				if (inputElement.equalsIgnoreCase("Level Wise Referral Bonus ")) {
					driver.findElement(By.xpath("//input[@formcontrolname='nameBonusLevel']")).sendKeys(nameBonusLevel);
					driver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']"))
							.sendKeys(String.valueOf(numberOfReferrals));
					driver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']"))
							.sendKeys(String.valueOf(rechargeAmount));
					driver.findElement(By.xpath("//textarea[@formcontrolname='levelDescription']"))
							.sendKeys("Add new Bonus level Description");
				}
				lb1.ClickToSave();
			}
			Thread.sleep(2000);
			test.info("Create Store bonus test case end");
		}
	}

	@Test
	public void A_J_LobbyManagement_Bonus_Search() throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus search");
		test.info("TestCase started Search Store Bonus- As an admin user I should be able to Search Store Bonus");
		LobbyPage lb = new LobbyPage(driver);
		LobbyManagement_Bonus_Redirect(LobbyEnum.Lcode.getValue());
		lb.SearchItems("First Time Recharge ");
		if (driver.findElement(By.xpath("//tbody//tr//td[normalize-space()='Facebook Binding']")) != null) {
			test.pass("Successfully Searched Item viewed on Bonus", extentScreenshot());
		} else {
			test.fail("Something wrong !! To Search Item on Bonus", extentScreenshot());
		}
		test.info("TestCase-search  Store Bonus Ended");
	}

	@Test
	public void A_K_LobbyManagement_Bonus_View() throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus view");
		test.info("view Store bonus test case start");
		LobbyPage lb = new LobbyPage(driver);

		// ---View Bonus----
		if (lb.verifyLobbyview()) {
			Thread.sleep(1500);
			lb.View_Click();
			test.info("Successfully verify searched  Bonus in  a List.");
			lb.ClickToClose();
		} else {
			test.info("View Store bonus view not found", extentScreenshot());
		}
		test.info("view Store bonus test case end");
		Thread.sleep(1000);
	}

	@Test
	public void A_L_LobbyManagement_Bonus_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus edit");
		test.info("TestCase started Edit Store Bonus- As an admin user I should be able to Edit Store Bonus");
		LobbyPage lb = new LobbyPage(driver);

		// ------------------Edit bonus------------
		if (driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0) {
			lb.clickToEdit();
			lb.setBonusName("Facebook Bonus");
			// lb.setBonusAction("");
			lb.gameToken("200");
			lb.sweepToken("800");
			lb.ClickToSave();

			boolean isDisplayed = CommonCosmo.Validation_Format_UpdateBonus.isDisplayed();
			String message = isDisplayed ? "<b><i>Bonus update validation message displayed</b></i>"
					: "<b><i>Bonus update validation message not displayed</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());

			Thread.sleep(1000);
			test.info("edit bonus test case end");
		} else {
			test.info("Edit bonus button not found", extentScreenshot());
		}
	}

	@Test
	public void A_T_LobbyManagement_Bonus_Status() throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus status");
		LobbyPage lb = new LobbyPage(driver);

		test.info("TestCase started status Store Bonus- As an admin user I should be able to status StoreBonus");

		// status active/inactive
		if (driver
				.findElement(By.xpath(
						"(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[@title])[1]"))
				.getAttribute("title").equalsIgnoreCase("In Active")) {
			test.info("Successfully Viewed active  bonus page");
			test.info("Now Player Is In Active");
			driver.findElement(By.xpath(
					"(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]"))
					.click();
			Thread.sleep(1000);
			lb.clickToYesButton();
			try {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby bonus activated successfully\"]")).size() > 0) {
					test.pass(
							"Lobby bonus Successfully activated and Validation message appeared - Lobby bonus activated  successfully",
							extentScreenshot());
				} else {

					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElement(By.xpath("//span[text()=\"Lobby bonus activated successfully\"]")) != null) {
					test.pass(
							"Lobby bonus Successfully activated and Validation message appeared - Lobby bonus activated successfully",
							extentScreenshot());
				}
				System.out.println(e);
			}
			Thread.sleep(4000);

		} else {
			test.info("Successfully Viewed View Icon of Player on lobby bonus listing page");
			test.info("Now bonus Is Active");
			Thread.sleep(1000);
			driver.findElement(By.xpath(
					"(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]"))
					.click();
			Thread.sleep(1000);
			lb.clickToYesButton();
			try {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby bonus deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby bonus Successfully deactivated and Validation message appeared - Lobby bonus deactivated successfully",
							extentScreenshot());
				} else {

					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby bonus deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby bonus Successfully deactivated and Validation message appeared - Lobby bonus deactivated successfully",
							extentScreenshot());
				}
				System.out.println(e);
			}
		}
		test.info("TestCase-status Lobby_Bonus Ended");
	}

	@Test
	public void A_U_LobbyManagement_Bonus_delete() throws IOException, InterruptedException {
		test = extentCreateTest("Store bonus delete");
		LobbyPage lb = new LobbyPage(driver);
		test.info("Delete bonus test case start");

		// -----------delete Bonus-----------
		if (driver.findElements(By.xpath("(//span[contains(@class,'deleteActionIcon')])[1]")).size() > 0) {
			lb.DeleteItems_Lobby();
			if (lb.VerifyYesDeleteIt()) {
				lb.ClickYesDeleteIt();
				test.pass("Bonus - delete successfully", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to delete Bonus ", extentScreenshot());
			}
			Thread.sleep(2000);

			boolean isDisplayed = CommonCosmo.Validation_Format_DeleteBonus.isDisplayed();
			String message = isDisplayed ? "<b><i>Bonus  delete message return</b></i>"
					: "<b><i>Bonus delete message not displayed</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());

			Thread.sleep(1000);

		} else {
			test.info("delete store bonus button not found", extentScreenshot());
		}
		test.info("Delete Bonus test case end");
	}

	@Test
	public void A_V_LobbyManagement_LevelWiseBonusListing() throws IOException, InterruptedException {
		test = extentCreateTest("Level Wise Bonus listing");
		test.info("TestCase started Level Wise Bonus listing");
		LobbyPage lb = new LobbyPage(driver);

		// Working
		LobbyManagement_Bonus_Redirect(LobbyEnum.Lcode.getValue());
		Thread.sleep(1000);
		lb.SearchItems("Level Wise Referral Bonus");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//tbody//tr//td[normalize-space()='Level Wise Referral Bonus']"))
				.size() > 0) {
			driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
			Thread.sleep(1000);

			// ------------------listing Level bonus------------
			if (lb.verifyLevelWiseBonus()) {
				lb.verifyRecordOnListing("name");
				Thread.sleep(2000);

			} else {
				test.fail("Level Wise Bonus heading not found", extentScreenshot());
			}
		} else {
			test.fail("Something wrong !! To Search Item on Bonus", extentScreenshot());
		}
		test.info("TestCase Ended Level Wise Bonus listing");
	}

	@Test
	public void A_Va_LobbyManagement_LevelWiseBonusSearch() throws IOException, InterruptedException {
		test = extentCreateTest("Level Wise Bonus listing");
		test.info("TestCase started Level Wise Bonus listing");
		LobbyPage lb = new LobbyPage(driver);

		// ------------------search bonus------------
		if (lb.verifyLevelWiseBonus()) {
			lb.SearchItems(LobbyEnum.nameBonusLevel.getValue());
			if (driver.findElements(By.xpath("(//th[text()='Name']//following::tr//td[contains(text(),'"
					+ LobbyEnum.nameBonusLevel.getValue() + "')])[1]")).size() > 0) {
				test.pass("Successfully Viewed searched record on page", extentScreenshot());
			} else {
				test.fail("Something wrong !! not found search record on page", extentScreenshot());
			}
			driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
			Thread.sleep(2000);
			test.info("TestCase ended Level Wise Bonus search");
		} else {
			test.info("Level Wise Bonus heading not found", extentScreenshot());
		}
	}

	@Test
	public void A_Vb_LobbyManagement_LevelWiseBonusEdit() throws IOException, InterruptedException {
		test = extentCreateTest("Level Wise Bonus Edit");

		test.info("TestCase started Level Wise Bonus Edit");
		LobbyPage lb = new LobbyPage(driver);

		// ------------------Edit level bonus------------
		if (lb.verifyLevelWiseBonus()) {
			lb.SearchItems(LobbyEnum.nameBonusLevel.getValue());
			if (lb.VerifyeditElement()) {
				lb.clickToEdit();

				/// nameBonusLevel_Increase=nameBonusLevel_Increase+1;
				// nameBonusLevel=nameBonusLevel+nameBonusLevel_Increase;

				lb.levelBonus(LobbyEnum.nameBonusLevel.getValue(), Constant.numberOfLevel, Constant.rechargeAmount,
						Constant.BonusGL, Constant.BonusSL, "This is testing entry on Level Wise Bonus");
				lb.ClickToSave();
				Thread.sleep(1000);
				boolean isDisplayed = CommonCosmo.Validation_UpdateLevelBonus.isDisplayed();
				String message = isDisplayed ? "<b><i>Bonus level update validation message displayed</b></i>"
						: "<b><i>Bonus level update validation message not displayed</b></i>";
				test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
			} else {
				test.info("Edit button on Level Wise Bonus not found");
			}
			Thread.sleep(2000);

		} else {
			test.info("Level Wise Bonus heading not found", extentScreenshot());
		}
		test.info("TestCase ended Level Wise Bonus edit");
	}

	@Test
	public void A_Vc_LobbyManagement_LevelWiseBonusView() throws IOException, InterruptedException {
		test = extentCreateTest("Level Wise Bonus View");
		test.info("TestCase started Level Wise Bonus View");
		LobbyPage lb = new LobbyPage(driver);

		// ------------------view bonus------------
		LobbyManagement_Bonus_Redirect(LobbyEnum.Lcode.getValue());

		lb.SearchItems("Level Wise Referral Bonus");
		if (lb.verifyLevelWiseBonus()) {
			lb.SearchItems(LobbyEnum.nameBonusLevel.getValue());
			if (lb.verifyViewButton()) {
				Thread.sleep(2000);
				lb.View_Click();
				lb.verifyRecordOnView(LobbyEnum.nameBonusLevel.getValue());
				lb.ClickToClose();
			} else {
				test.info("view button on Level Wise Bonus not found");
			}
			Thread.sleep(1000);
		} else {
			test.info("Level Wise Bonus heading not found", extentScreenshot());
		}
		test.info("TestCase ended Level Wise Bonus view");
	}

	@Test
	public void A_Vd_LobbyManagement_LevelWiseBonusAddNew() throws IOException, InterruptedException {

//		for(int i=2; i<=numberOfLevel; i++) {
//			Add_LevelWiseBonus("Level"+i, 1, 1, BonusGL*i, BonusSL*i, "This is testing entry on Level Wise Bonus");	
//		}
		test.info("we will add more bonus while we perform invite player scenario");
	}

	public void Add_LevelWiseBonus(String Name, int ref, int amt, int GT, int ST, String Desc)
			throws IOException, InterruptedException {
		test = extentCreateTest("Level Wise Bonus add with ->" + Name);
		test.info("TestCase started Level Wise Bonus add with ->" + Name);
		LobbyPage lb = new LobbyPage(driver);

		// ------------------add level bonus------------
		if (lb.verifyLevelWiseBonus()) {
			Thread.sleep(2000);
			if (lb.verifyCreateNew()) {
				Thread.sleep(1000);
				lb.clickToCreate();
				lb.setBonusName(Name);

				lb.levelBonus(LobbyEnum.nameBonusLevel.getValue(), Constant.numberOfLevel, Constant.rechargeAmount,
						Constant.BonusGL, Constant.BonusSL, "This is testing entry on Level Wise Bonus");
				lb.ClickToSave();
				Thread.sleep(1000);

				boolean isDisplayed = CommonCosmo.Validation_Format_AddBonus.isDisplayed();
				String message = isDisplayed ? "<b><i>Bonus level add validation message displayed</b></i>"
						: "<b><i>Bonus level add validation message not displayed</b></i>";
				test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
				Thread.sleep(2000);
			} else {
				test.info("add button on Level Wise Bonus not found");
			}
			Thread.sleep(2000);
			test.info("TestCase ended Level Wise Bonus add");
		} else {
			test.info("Level Wise Bonus heading not found", extentScreenshot());
		}
	}

	public void LobbyManagement_storePackageCreate(String pcode, String pname, String pamount, String pdiscount,
			String ST, String GT, String ExtraST, String desc) throws IOException, InterruptedException {
		test = extentCreateTest("Add lobby store package");
		Thread.sleep(2000);
		test.info("TestCase started create Lobby store Package ");
		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc = new CommonCosmo(driver);
		// Working
		test.info("Create Lobby store Package test case start");
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickView_LobbyStorePackage();

		// Create Lobby store Package
		lb.clickToCreate();
		lb.selectRole(LobbyEnum.storerole.getValue());
		lb.selectUsername(LobbyEnum.storeusername.getValue());
		// Search_package="T"+randNum;
		lb.LobbyPackage_Code(pcode);
		lb.LobbyPackage_name(pname);
		lb.LobbyPackage_amount(pamount);
		lb.LobbyPackage_discountAmount(pdiscount);
		lb.LobbyPackage_Gametoken(GT);
		lb.LobbyPackage_Sweeptoken(ST);
		lb.LobbyPackage_extraSweeptoken(ExtraST);
		driver.findElement(By.xpath("//input[@formcontrolname=\"fishGameInviteCodeCount\"]")).sendKeys("10");
		lb.SetDesc_StorePackage(desc);
		lb.Setpkg_startsAt(Integer.toString(Constant.DateInt));
		lb.startsAtTime.sendKeys("0000");
		lb.Setpkg_expiryAt("12/12/2040");
		lb.expiryAtTime.sendKeys("0900");
		Thread.sleep(1000);

//		String storePackageAdminn = LobbyEnum.storePackageAdmin.getValue();
//		storePackageAdminn = LobbyEnum.search_StorepackageName.getValue();
		LobbyEnum.storePackageAdmin.setValue(LobbyEnum.search_StorepackageName.getValue());
		Thread.sleep(1000);
		lb.ClickToSave();

		// Boolean bool=cc.Validation_Format_Addpackage.isDisplayed();
		// if(cc.Validation_Format_Addpackage.isDisplayed()==true){
		if (driver.findElements(By.xpath("//span[text()=\"Store package save successfully\"]")).size() > 0) {
			Thread.sleep(1000);
			test.pass("<b><i>Store Package - add successfully</b></i>", extentScreenshot());
		} else if (driver.findElements(By.xpath("//span[text()=\"Package code must be unique\"]")).size() > 0) {
			Thread.sleep(5000);
			test.info("<b><i>Store Package - Package code must be unique</b></i>", extentScreenshot());
			lb.ClickToCancel();
		} else {
			test.fail("<b><i>not able to Add Store Package </b></i>", extentScreenshot());
			Thread.sleep(5000);
			lb.ClickToCancel();
		}
		Thread.sleep(1000);
		test.info("Create Store Package TestCase End");
	}

	@Test
	public void A_Ve_LobbyManagement_PlayerFlow() throws Exception {
		// UserHierarchy uh=new UserHierarchy();
		PlayerRegistration_Website prw = new PlayerRegistration_Website();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LobbyPage lb = new LobbyPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerRegistration_Website pr = new PlayerRegistration_Website();
		try {
			int intValue = LobbyEnum.PlayersRegisration.toInt();

			for (int i = 1; i < intValue; i++) {
				String First = Fakefirstname();
				String Last = Fakelastname();
				String pEmail = First + Last + i + "@yopmail.com";
				String pDisplayname = First + i + Constant.randNum;
				pEmail = pEmail.replaceAll("'", "");
				System.out.println("\n Register player -" + i + " Email->" + pEmail);
				System.out.println("invite code for " + pEmail + " is -> " + LobbyEnum.invitecode.getValue());

				// remove this in 1.2.0
				if (First.length() >= 5) {
					First = First.substring(0, 5);
				}
				PageReload();
				// register new player
				prw.PlayerRegister(First, Last, pDisplayname, password, LobbyEnum.invitecode.getValue()); // uh.codeArray.get(0)

				driver.findElement(
						By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']"))
						.click();
				test.info("click on player profile in Website");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Profile']")).click();
				Thread.sleep(2000);
				js.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("(//span[@class=\"mys-player-id\"])[1]")));
				lb.pageScroll("up");
				// return player id
				String playerusername = driver.findElement(By.xpath("(//span[@class=\"mys-player-id\"])[1]")).getText();
				playerusername = playerusername.substring(11, playerusername.length());
				Constant.emailArray.add(playerusername);
				System.out.println("\n player ID-> " + Constant.emailArray.get(i - 1) + " added successfully");
				// email verification
				Thread.sleep(2000);
				prw.PlayerVarificaitonEmail(pEmail);
				int random_int = (int) Math.floor(
						Math.random() * (PlayerEnum.max.toInt() - PlayerEnum.min.toInt() + i) + PlayerEnum.min.toInt());

				// int random_int = (int) Math.floor(Math.random() * (prw.max - prw.min + i) +
				// prw.min);
				prw.PlayerVarificaitonPhone(random_int);

				driver.findElement(By.xpath("//input[@formcontrolname=\"skrillEmailId\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"skrillEmailId\"]"))
						.sendKeys("itsupport1@ombpmllp.com");
				driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimit\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimit\"]")).sendKeys("100");
				driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimitDays\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"depositLimitDays\"]")).sendKeys("1000");
				driver.findElement(By.xpath("//input[@formcontrolname=\"cashAppId\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"cashAppId\"]"))
						.sendKeys("itsupport1@ombpmllp.com");
				Thread.sleep(1000);
				js.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("//button[text()='Save']")));
				Thread.sleep(1000);
				lb.ClickToSavePlayer();
				Thread.sleep(2000);
				websiteMenu_Verify();
				pr.PlayerLogout();

			}
		} catch (Exception e) {
			System.out.println("something went wrong - not able to create player " + e);
			test.info("something went wrong - not able to create player " + e);
		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(500);
	}

	@Test(groups = { "admin", "Website" })
	public void I_LobbyManagement_StorePackage_Create() throws IOException, InterruptedException {

		LobbyManagement_storePackageCreate(LobbyEnum.search_Storepackage.getValue(),
				LobbyEnum.search_StorepackageName.getValue(), LobbyEnum.storePackageAmount.getValue(),
				LobbyEnum.storePackageDiscountAmount.getValue(), LobbyEnum.storePackageST.getValue(),
				LobbyEnum.storePackageGT.getValue(), LobbyEnum.storePackageExtraST.getValue(),
				"this is testing store package");
	}

	@Test
	public void Ia_LobbyManagement_StorePackage_Status() throws IOException, InterruptedException {
		test = extentCreateTest("StorePackage status");
		LobbyPage lb = new LobbyPage(driver);
		test.info(
				"TestCase started status StorePackage- As an admin user I should be able to change status for StorePackage");

		// status active/inactive
		if (driver
				.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]"))
				.getAttribute("title").equalsIgnoreCase("Un Publish")) {
			test.info("Successfully Viewed active StorePackage page");
			test.info("Now StorePackage Is In Active");
			driver.findElement(By.xpath(
					"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
					.click();
			Thread.sleep(1000);
			lb.clickToYesButton();
			try {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link activated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby StorePackage Successfully activated and Validation message appeared - Lobby StorePackage activated successfully",
							extentScreenshot());
				} else {

					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElement(
						By.xpath("//span[text()=\"Lobby package link activated successfully\"]")) != null) {
					test.pass(
							"Lobby StorePackage Successfully activated and Validation message appeared - Lobby StorePackage activated successfully",
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
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby StorePackage Successfully deactivated and Validation message appeared - Lobby StorePackage deactivated successfully",
							extentScreenshot());
				} else {
					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby StorePackage Successfully deactivated and Validation message appeared - Lobby StorePackage deactivated successfully",
							extentScreenshot());
				}
				System.out.println(e);
			}
		}
		test.info("TestCase-status StorePackage Ended");
	}

	@Test
	public void Ib_LobbyManagement_StorePackage_Delete() throws IOException, InterruptedException {
		test = extentCreateTest("Store package delete");
		test.info("TestCase started delete Store Package - As an admin user I should be able to delete Store Package");
		LobbyPage lb = new LobbyPage(driver);
		lb.SearchItems(LobbyEnum.search_Storepackage.getValue());

		// -----------delete Store Package-----------
		test.info("delete Store Package test case start");
// 		if(driver.findElements(By.xpath("(//span[contains(@class,'deleteActionIcon')])[1]")).size()> 0) {
		if (lb.packageDeletebuttonElement() == true) {
			lb.packageDeleteItems();
			if (lb.VerifyYesDeleteIt() == true) {
				lb.ClickYesDeleteIt();
				test.pass("<b><i>Store Package - delete successfully</b></i>", extentScreenshot());
				Thread.sleep(1000);
				boolean isDisplayed = CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
				String message = isDisplayed ? "<b><i>StorePackage - delete message return</b></i>"
						: "<b><i>StorePackage - not able show delete message</b></i>";
				test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
			} else {
				test.fail("<b><i>not able to delete</b></i>", extentScreenshot());
			}
		} else {
			test.info("delete button not found for Store Package", extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("delete Store Package test case end");
	}

	@Test(groups = { "admin", "Website" })
	public void J_LobbyManagement_StorePackage_Create() throws IOException, InterruptedException {
		LobbyManagement_storePackageCreate(LobbyEnum.search_Storepackage.getValue(),
				LobbyEnum.search_StorepackageName.getValue(), LobbyEnum.storePackageAmount.getValue(),
				LobbyEnum.storePackageDiscountAmount.getValue(), LobbyEnum.storePackageST.getValue(),
				LobbyEnum.storePackageGT.getValue(), LobbyEnum.storePackageExtraST.getValue(),
				"this is testing store package");
		System.out.println("package created with name ->" + LobbyEnum.search_Storepackage.getValue() + "="
				+ LobbyEnum.storePackageAdmin.getValue());
	}

	@Test(groups = { "admin", "Website" })
	public void Ja_LobbyManagement_Website_VerifyStorePackage_LastAdded() throws IOException, InterruptedException {
		test = extentCreateTest("Verify last added Store Package");

		System.out.println("Register Players ->" + Constant.emailArray);
		LobbyEnum.Playerusername.setValue(Constant.emailArray.get(0));
		System.out.println("player name  for store creation -" + LobbyEnum.Playerusername.getValue());
		LobbyPage lb = new LobbyPage(driver);
		gotoTab(driver, 1);
		playerlogin(LobbyEnum.Playerusername.getValue(), Playerpass);
		// websiteMenu_Verify();
		try {
			System.out.println("player name -" + LobbyEnum.Playerusername.getValue());
			Thread.sleep(2000);
			// lb.websitePackage();
			driver.get(WebURL + Constant.WebsitePackages);
			Thread.sleep(1500);

			String StorePackageWeb = driver
					.findElement(By.xpath("//h1[.='" + LobbyEnum.storePackageAdmin.getValue() + "']")).getText();
			String StorePackageWeb_GT = driver.findElement(By.xpath(
					"(//h1[.='" + LobbyEnum.storePackageAdmin.getValue() + "']//following::span[@class='pi-text'])[1]"))
					.getText();
			String StorePackageWeb_ST = driver.findElement(By.xpath(
					"(//h1[.='" + LobbyEnum.storePackageAdmin.getValue() + "']//following::span[@class='pi-text'])[2]"))
					.getText();
			String StorePackageWeb_Amount = "$" + driver
					.findElement(By.xpath("//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
							+ "']//following::span[.='" + "$" + LobbyEnum.storePackageAmount.getValue() + "']"))
					.getText();

			if (LobbyEnum.storePackageAdmin.getValue().equalsIgnoreCase(StorePackageWeb)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("//h1[.='" + LobbyEnum.storePackageAdmin.getValue() + "']")));
				Thread.sleep(1000);
				test.pass("last added StorePackage found in Website", extentScreenshot());

				if (!(StorePackageWeb_GT.equals(LobbyEnum.storePackageGT.getValue())
						&& StorePackageWeb_ST.equals(LobbyEnum.storePackageST.getValue())
						&& StorePackageWeb_Amount.equals(LobbyEnum.storePackageAmount.getValue()))) {
					System.out.println("matched GT ST amount with Website" + StorePackageWeb_GT + "--"
							+ StorePackageWeb_ST + "--" + StorePackageWeb_Amount);
					test.pass(
							"matched GT <b>" + StorePackageWeb_GT + "</b> ST <b>" + StorePackageWeb_ST
									+ "</b> amount <b>" + StorePackageWeb_Amount + "</b> with Website",
							extentScreenshot());

					// comment this code ->for compare transaction only with Admin
					driver.findElement(By.xpath("(//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
							+ "']//following::button[.='Purchase'])[1]")).click();
					Thread.sleep(2000);
					test.info("clicked on purchase button", extentScreenshot());
					test.info("payment method ->" + LobbyEnum.Skrillmethod.getValue());
					System.out.println("payment method ->" + LobbyEnum.Skrillmethod.getValue());
					// apply coupon code
					// lb.ApplyCouponCode(LobbyEnum.storecouponName.getValue());
					driver.findElement(
							By.xpath("//label[contains(text(),'" + LobbyEnum.Skrillmethod.getValue() + "')]")).click();
					System.out.println(driver
							.findElement(
									By.xpath("//label[contains(text(),'" + LobbyEnum.Skrillmethod.getValue() + "')]"))
							.getText());

					Thread.sleep(500);
					if (LobbyEnum.Skrillmethod.getValue().equalsIgnoreCase("skrill")) {

						driver.findElement(By.xpath("(//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
								+ "']//following::div//button[.='Purchase'])[1]")).click();
						Thread.sleep(3000);

						if (driver.findElements(By.xpath("//button[contains(text(),'Confirm')]")).size() > 0) {
							test.info("Exceeded your purchase limit. found in Website", extentScreenshot());
							js.executeScript("arguments[0].click()",
									driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")));
						} else {
							test.info("purchase limit already set according to user", extentScreenshot());
						}

						test.info("Opened Skrill window", extentScreenshot());
						Thread.sleep(5000);
						switchToWindow("Skrill");
						SkrilPayment();

						// this line is for manual add package
						// VerifyPaymentFromAdmin(storePackageAdmin);

						VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(),
								LobbyEnum.Skrillmethod.getValue());
						VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
								LobbyEnum.paymentMethodFromWebsite.getValue(),
								LobbyEnum.WebsiteTransactionid.getValue());
						VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2),
								LobbyEnum.paymentway.getValue(), LobbyEnum.WebsiteTransactionid.getValue());
					} else if (LobbyEnum.Skrillmethod.getValue().equalsIgnoreCase("wallet")) {

						driver.findElement(By.xpath("(//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
								+ "']//following::button[.='Purchase'])[1]")).click();
						Thread.sleep(3000);

						if (driver.findElements(By.xpath("//button[contains(text(),'Confirm')]")).size() > 0) {
							test.info("Exceeded your purchase limit. found in Website", extentScreenshot());
							js.executeScript("arguments[0].click()",
									driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")));
						} else {
							test.info("purchase limit already set according to user", extentScreenshot());
						}
						WebElement exceptedStatus = driver
								.findElement(By.xpath("(//span[contains(text(),\"Success\")])[1]"));
						String es = exceptedStatus.getText();

						if (exceptedStatus.isDisplayed()) {
							test.pass("Successfully purchase package by player" + es);

							// this line is for manual add package
							// VerifyPaymentFromAdmin(storePackageAdmin);

							VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(),
									LobbyEnum.Skrillmethod.getValue());
							VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
									LobbyEnum.paymentMethodFromWebsite.getValue(),
									LobbyEnum.WebsiteTransactionid.getValue());
							VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2),
									LobbyEnum.paymentway.getValue(), LobbyEnum.WebsiteTransactionid.getValue());
						} else {
							WebElement exStatus = driver
									.findElement(By.xpath("(//span[contains(text(),\"insufficient\")])[1]"));
							String ts = exStatus.getText();

							if (exceptedStatus.isDisplayed()) {
								test.pass("Insufficient balance in wallet by player" + ts);
							}
						}
					} else if (LobbyEnum.Skrillmethod.getValue().equalsIgnoreCase("Bank Card")) {

						driver.findElement(By.xpath("(//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
								+ "']//following::button[.='Purchase'])[1]")).click();
						Thread.sleep(3000);

						if (driver.findElements(By.xpath("//button[contains(text(),'Confirm')]")).size() > 0) {
							test.info("Exceeded your purchase limit. found in Website", extentScreenshot());
							js.executeScript("arguments[0].click()",
									driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")));
						} else {
							test.info("purchase limit already set according to user", extentScreenshot());
						}

						test.info("Opened Zen(Card payment) window", extentScreenshot());
						WebDriverWait wait = new WebDriverWait(driver, 30);
						wait.until(
								ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='add_payment']")));
						Thread.sleep(5000);

						if (driver.findElements(By.xpath("//iframe[@id='add_payment']")).size() > 0) {
							WebElement frameElement = driver.findElement(By.id("add_payment"));
							driver.switchTo().frame(frameElement);
							Thread.sleep(5000);

							driver.findElement(By.xpath("//input[@id='cardNum']")).sendKeys("4111111111111111");
							driver.findElement(By.xpath("//input[@id='expiryDate']")).sendKeys("1126");
							driver.findElement(By.xpath("//input[@id='cvv']")).sendKeys("123");
							driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("gamer");
							driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("last");
							driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("123123");
							driver.findElement(By.xpath("//input[@name='address']")).sendKeys("address");
							driver.findElement(By.xpath("//input[@name='city']")).sendKeys("city");
							driver.findElement(By.xpath("//input[@name='state']")).sendKeys("state");
							driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1231231230");
							driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testing@yopmail.com");

							Thread.sleep(500);
							driver.findElement(By.xpath("//button[@id='payBtn']")).click();
							Thread.sleep(2500);
							if (driver.findElements(By.xpath("//div[text()='Payment initiated and is under process!']"))
									.size() > 0) {
								test.pass("Payment initiated and is under process! in Website using zenpayment",
										extentScreenshot());
								driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
								Thread.sleep(500);

								// this line is for manual add package
								// VerifyPaymentFromAdmin(storePackageAdmin);

								VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(),
										LobbyEnum.Skrillmethod.getValue());
								VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
										LobbyEnum.paymentMethodFromWebsite.getValue(),
										LobbyEnum.WebsiteTransactionid.getValue());
								VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2),
										LobbyEnum.paymentway.getValue(), LobbyEnum.WebsiteTransactionid.getValue());

							} else {
								test.fail("zenpayment cancelled in Website", extentScreenshot());
							}
						}

					} else if (LobbyEnum.Skrillmethod.getValue().equalsIgnoreCase("paysafe")) {
						test.info("Opened Paysafe payment window", extentScreenshot());
						Thread.sleep(5000);
						if (driver.findElements(By.xpath("//label[text()='Country']")).size() > 0) {
							driver.findElement(By.xpath("//div[contains(text(),'Select Country')]")).click();
							driver.findElement(By.xpath(
									"//ng-dropdown-panel[@aria-label=\"Options list\"]//following::span[text()='India']"))
									.click();
							driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
							driver.findElement(By.xpath(
									"//ng-dropdown-panel[@aria-label=\"Options list\"]//following::span[text()='Assam']"))
									.click();
							driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Baroda");
							driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Address");
							driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("A1B2C3D4");
							Thread.sleep(1000);
							driver.findElement(By.xpath("(//h1[.='" + LobbyEnum.storePackageAdmin.getValue()
									+ "']//following::button[.='Purchase'])[1]")).click();
							Thread.sleep(3000);

							if (driver.findElements(By.xpath("//button[contains(text(),'Confirm')]")).size() > 0) {
								test.info("Exceeded your purchase limit. found in Website", extentScreenshot());
								js.executeScript("arguments[0].click()",
										driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")));
							} else {
								test.info("purchase limit already set according to user", extentScreenshot());
							}
							PaysafePayment();
						}

						// this line is for manual add package
						// VerifyPaymentFromAdmin(storePackageAdmin);

						VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(),
								LobbyEnum.Skrillmethod.getValue());
						VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
								LobbyEnum.paymentMethodFromWebsite.getValue(),
								LobbyEnum.WebsiteTransactionid.getValue());
						VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2),
								LobbyEnum.paymentway.getValue(), LobbyEnum.WebsiteTransactionid.getValue());
					} else {
						System.out.println("other payment option selected");
					}
				} else {
					test.info("Not matched GT ST amount", extentScreenshot());
				}
				Thread.sleep(1000);
				BaseClass.gotoTab(driver, 1);
			} else {
				test.fail("last added StorePackage not found in Website ! Failed", extentScreenshot());
			}
		} catch (Exception e) {
			System.out.println("something went wrong - not able to match packages " + e);
			test.info("something went wrong - not able to match packages " + e);

			VerifyPaymentFromAdmin(LobbyEnum.storePackageAdmin.getValue(), LobbyEnum.storecouponName.getValue(),
					LobbyEnum.Playerusername.getValue());
			VerifyPaymentFromAdmin(LobbyEnum.storePackageAdmin.getValue(), "", LobbyEnum.Playerusername.getValue());
			VerifyPaymentFromAdmin(LobbyEnum.storePackageAdmin.getValue(), LobbyEnum.storecouponName.getValue(),
					LobbyEnum.Playerusername.getValue());
			VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(), LobbyEnum.Skrillmethod.getValue());
			VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
					LobbyEnum.paymentMethodFromWebsite.getValue(), LobbyEnum.WebsiteTransactionid.getValue());
			VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2), LobbyEnum.paymentway.getValue(),
					LobbyEnum.WebsiteTransactionid.getValue());
		}
		gotoTab(driver, 0);
		Thread.sleep(1500);
	}

	@Test(groups = { "admin", "Website" })
	public void Jc_LobbyManagement_Website_VerifyStorePackage_LastAdded_Purchase()
			throws IOException, InterruptedException {
		test = extentCreateTest("Verify last added Store Package");
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(1500);

		gotoTab(driver, 1);
		Thread.sleep(1000);
//		websiteMenu_Verify();
//		lb.websitePackage();
		driver.get(WebURL + Constant.WebsitePackages);
		System.out.println("last added package is - " + LobbyEnum.storePackageAdmin.getValue());
		String StorePackageWeb = driver
				.findElement(By.xpath("//h1[.='" + LobbyEnum.storePackageAdmin.getValue() + "']")).getText();

		if (LobbyEnum.storePackageAdmin.getValue().equalsIgnoreCase(StorePackageWeb)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(
					"(//h1[text()='" + LobbyEnum.storePackageAdmin.getValue() + "']//following::*[.='Purchase'])[1]")));
			Thread.sleep(2000);
			test.info("clicked last added store package", extentScreenshot());
		} else {
			test.fail("last added StorePackage not found in Website ! Failed", extentScreenshot());
		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
	}

	public void Jd_LobbyManagement_Website_VerifyAllPackages() throws IOException, InterruptedException {
		test = extentCreateTest("Verify all Packages in Website");

		Thread.sleep(1500);
		BaseClass.gotoTab(driver, 1);
		Thread.sleep(1000);
		websiteMenu_Verify();
		List<WebElement> boxesweb = driver.findElements(By.className("plan-title"));
		int StorePackageCountWeb = 0;
		int CustomPackageCountWeb = 0;

		if (!boxesweb.isEmpty()) {
			for (WebElement inputElement1 : boxesweb) {
				System.out.println(inputElement1.getText());
				Constant.shiftweb.add(inputElement1.getText());
				if (Constant.shift.contains(inputElement1.getText())) {
					System.out.println("Store package :===>" + inputElement1.getText());
					StorePackageCountWeb++;
				} else {
					System.out.println("Custom package---" + inputElement1.getText());
					CustomPackageCountWeb++;
				}
			}
		}
		if (StorePackageCountWeb == Constant.TotalStorePackage) {
			test.info("Total StorePackage matched Admin with Website - " + Constant.TotalStorePackage + "--"
					+ StorePackageCountWeb);
		} else {
			test.info("Total StorePackage not matched Admin with Website - " + Constant.TotalStorePackage + "--"
					+ StorePackageCountWeb);
		}
		test.info("Total StorePackage found in Website - " + CustomPackageCountWeb);
		test.info("Total CustomPackage found in Website - " + StorePackageCountWeb);
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
	}

	@Test
	public void Je_LobbyManagement_StorePackage_Search() throws IOException, InterruptedException {
		test = extentCreateTest("lobby Store package search");
		LobbyPage lb = new LobbyPage(driver);
		test.info("TestCase - Search Lobby store Package test case start");
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickView_LobbyStorePackage();

		// -----------Search LobbyPackage-----------
		lb.SearchItems(LobbyEnum.search_Storepackage.getValue());
		if (driver.findElement(By.xpath("//tbody//tr//td[contains(text(),'"
				+ LobbyEnum.search_Storepackage.getValue().toUpperCase() + "')]")) != null) {
			test.pass(
					"successfuly store package in a List. with package  -> " + LobbyEnum.search_Storepackage.getValue(),
					extentScreenshot());
		} else {
			test.fail("Something Wrong!To View store package in a List.", extentScreenshot());
		}
		test.info("Search Store Package TestCase End");
	}

	@Test
	public void Jf_LobbyManagement_StorePackage_PackagePurchaseHistory() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Store Package Purchase History  ");

		test.info(
				"TestCase started view Store Package - As an admin user I should be able to view on Store Package Purchase History");
		LobbyPage lb = new LobbyPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickView_LobbyStorePackage();
		if (!Constant.emailArray.isEmpty()) {
			LobbyEnum.Playerusername.setValue(Constant.emailArray.get(2));// "AT7779-1424";//
			System.out.println("player name -" + LobbyEnum.Playerusername.getValue());
		} else {
			LobbyEnum.Playerusername.setValue(Constant.emailArray.get(0));
		}

		if (driver.findElements(By.xpath("(//a[@title='Package Purchase History'])[1]")).size() > 0) {
			test.info("View Store Package Purchase History start...");
			lb.clickToViewPurchaseHistory();

			if (driver.findElements(By.xpath("//h3[contains(text(),\"Package Purchase History\")]")).size() > 0) {
				if (driver.findElements(By.xpath(
						"(//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"cdk-column-playerInfo-playerId\")])[1]"))
						.size() > 0) {
					if (driver.findElement(By.xpath(
							"(//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"cdk-column-playerInfo-playerId\")])[1]"))
							.getText().equalsIgnoreCase(LobbyEnum.Playerusername.getValue())) {
						Thread.sleep(500);
						test.pass("<b><i>Successfully verify searched player on Package Purchase History",
								extentScreenshot());
					} else {
						Thread.sleep(500);
						test.fail("<b><i>not able to verify searched player on Package Purchase History</b></i>",
								extentScreenshot());
					}

					if (driver.findElement(By.xpath("//button[@title='Export XLSX']")) != null) {
						test.info("Testing XLSX Download in Package Purchase History");
						pp.clickXlsxButton();
						Thread.sleep(3000);

						String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";
						// if(SearchItem.equalsIgnoreCase(SearchItem))
						if (driver.findElement(By.xpath("(//span[contains(text(),'" + msg + "')])[1]")).isDisplayed()) {
							test.pass("Successfully XLSX Downloaded message displayed");

							// this code is for download page comparsion
							String modulename = driver
									.findElement(By.xpath("(//h3[contains(.,'Package Purchase History')])[1]"))
									.getText();
							Thread.sleep(2000);
							driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]"))
									.click();
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
							Thread.sleep(1000);
							driver.navigate().back();
						} else {
							test.fail("Something wrong !! To Download XLSX MESSAGE NOT DISPLAYED");
						}
					} else {
						test.fail("Something wrong !! To Download XLSX");
					}

					Thread.sleep(500);
					test.pass("<b><i>Successfully verify searched Store Package in  a List.</b></i>",
							extentScreenshot());
				} else {
					Thread.sleep(500);
					test.fail("<b><i>not found records a List.</b></i>", extentScreenshot());
				}
			} else {
				test.fail("Something wrong !! To found Package Purchase History label");
			}
			Thread.sleep(2000);
			test.info("View Package Purchase History test case end.");
		} else {
			test.info("Package Purchase History button not found", extentScreenshot());
		}
		// lb.ClickOnBack("Package Purchase History");
		Thread.sleep(2000);
	}

	@Test
	public void K_LobbyManagement_StorePackage_View() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby Store package view");
		test.info("TestCase started view Store Package - As an admin user I should be able to view on Store Package");
		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc=new CommonCosmo(driver);

		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickView_LobbyStorePackage();
		test.info("View Store Package test case start...");

		if (lb.View_Click.isDisplayed() == true) {
			lb.View_Click();
			System.out.println("view - " + driver.findElement(By.xpath(
					"(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]"))
					.getText());
			test.info("Successfully verify searched  LobbyPackage in  a List.");
			Thread.sleep(500);
			lb.ClickToClose();
			Thread.sleep(2000);
		} else {
			test.info("View Store Package button not found", extentScreenshot());
		}
		test.info("View Store Package test case end.");
		Thread.sleep(1000);
	}

	@Test
	public void L_LobbyManagement_StorePackage_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("lobby Store package edit");

		test.info("TestCase started Edit Store Package - As an admin user I should be able to Edit Store Package");
		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc=new CommonCosmo(driver);
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickView_LobbyStorePackage();
		lb.SearchItems(LobbyEnum.search_Storepackage.getValue());

		// ------------------Edit LobbyPackage------------
		if (driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0) {
			lb.clickToEdit();
			Thread.sleep(2000);
			lb.LobbyPackage_name("starpack" + Constant.randomString);
			lb.LobbyPackage_amount("100");
			lb.LobbyPackage_discountAmount("10");
			lb.LobbyPackage_Gametoken("800");
			lb.LobbyPackage_Sweeptoken("800");
			lb.LobbyPackage_extraSweeptoken("150");
			lb.SetDesc_StorePackage("this is edit testing Store package...");
			lb.ClickToSave();
			// Boolean bool2=cc.Validation_Format_UpdateStorepackage.isDisplayed();
			if (driver.findElements(By.xpath("//span[text()=\"Store package updated successfully\"]")).size() > 0) {
				test.pass("<b><i>Store Package update validation message displayed</b></i>", extentScreenshot());
			} else {
				test.fail("<b><i>Store Package update validation message not displayed</b></i>", extentScreenshot());
				Thread.sleep(2500);
				lb.ClickToCancel();
			}
			Thread.sleep(1000);
			test.info("TestCase-Edit Store Package Ended");
		} else {
			test.info("Edit Store Package button not found", extentScreenshot());
		}
	}

	public static void switchToWindow(String windowTitle) throws InterruptedException {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String windowHandle : driver.getWindowHandles()) {
			String title = driver.getTitle();
			driver.switchTo().window(windowHandle);
			if (title.equalsIgnoreCase(windowTitle)) {
				driver.manage().window().maximize();
				break;
			}
		}
		Thread.sleep(1500);
	}

	public void SkrilPayment() throws IOException, InterruptedException {

		String SkrillEmail = "itsupport@ombpmllp.com";
		String SkrillPass = "Dell#mc@123";

		if (driver.getTitle().equalsIgnoreCase("Skrill")) {
			Thread.sleep(3000);
			test.info("<b>Skrill</b> payment window found in Website", extentScreenshot());
			Thread.sleep(2000);
			if (driver.findElements(By.xpath("//button[text()='Accept All Cookies']")).size() > 0) {
				driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
				Thread.sleep(1000);
			}
			driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(SkrillEmail);
			driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(SkrillPass);
			driver.findElement(By.xpath("//button[contains(@class,'digital-wallet-login-form__submit-button')]"))
					.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[contains(@class,'pay-with-balance-button')]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			test.info("<b>Skrill</b> payment details found in Website", extentScreenshot());
			js.executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//button//span[contains(text(),'CONFIRM')]")));
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(@class,'return-button')]")).click();
			test.info("StorePackage <b>Skrill</b> details found in Website", extentScreenshot());

			Thread.sleep(5000);
			if (driver.findElements(By.xpath("//div[@class=\"thank-you-img\"]")).size() > 0) {
				System.out.println("match thank you page");
				Thread.sleep(2000);
			} else {
				System.out.println("not able to find thank you page");
			}
		} else {
			test.info("Skrill payment window not found in Website", extentScreenshot());
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
	}

	public void PaysafePayment() throws IOException, InterruptedException {
		LobbyPage lb = new LobbyPage(driver);

		if (driver.findElements(By.xpath("//h1[contains(text(),'Make Your Payment')]")).size() > 0) {
			Thread.sleep(3000);
			test.info("<b>Paysafe</b> payment window found in Website", extentScreenshot());
			driver.findElement(
					By.xpath("//div[contains(@class,'pay-with-icon')]//preceding::li[@class='payment-methods']"))
					.click();

			if (driver.findElements(By.xpath("//h4[contains(text(),' Add New Card ')]")).size() > 0) {
				driver.findElement(By.xpath("//input[@formcontrolname='cardNumber']")).sendKeys("4111111111111111");
				driver.findElement(By.xpath("//input[@formcontrolname='cardHolderName']")).sendKeys("Smith torent");
				driver.findElement(By.xpath("//input[@id='cardExpiryMonth']")).sendKeys("11");
				driver.findElement(By.xpath("//input[@id='cardExpiryYear']")).sendKeys("2026");
				driver.findElement(By.xpath("//input[@id='cardSecurityCode']")).sendKeys("123");

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("//span[text()='Pay']")));
				// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
				lb.pageScroll("end");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[text()='Pay']")).click();
				Thread.sleep(5000);

				if (driver.findElements(By.xpath("//h2[text()='Payment Successful']")).size() > 0) {
					test.pass("<b>Payment Successful</b>   in Website", extentScreenshot());
				} else {
					test.fail("<b>Payment has not been Successful</b>  in Website", extentScreenshot());
				}
			}
		} else {
			test.info("Skrill payment window not found in Website", extentScreenshot());
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
	}

	public void VerifyPaymentTransactions_Website(String methodtype, String paymentmethods)
			throws IOException, InterruptedException {
		test = extentCreateTest("Verify Payment Transactions Website");
		BaseClass.gotoTab(driver, 1);
		Thread.sleep(1000);
		String Websitetransactionid = "";
		String WebsitetransactionMethod = "";
		// String paymentways;
		driver.get(WebURL + "/profile");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("(//button[contains(.,'Transactions')])[1]")) != null) {
			test.pass("Successfully Opened Website Transactions screen");

			driver.findElement(By.xpath("//button[text()=' Transactions ']")).click();
			if (driver.findElements(By.xpath("(//a[contains(@class,\"action-icon\")])[1]")).size() > 0) {

				WebsitetransactionMethod = driver
						.findElement(By
								.xpath("(//th[text()=\"Payment Method\"]/following::tr//td[contains(text(),\"\")])[4]"))
						.getText();
				driver.findElement(By.xpath("(//a[contains(@class,\"action-icon\")])[1]")).click();
				Thread.sleep(1000);
				if (paymentmethods.equalsIgnoreCase(WebsitetransactionMethod)) {
					// return transaction id
					Websitetransactionid = driver
							.findElement(By.xpath("//div[contains(@class,'transation-id')]//child::span[1]")).getText();
					System.out.println("WebsiteTransactionid ->" + Websitetransactionid);
					LobbyEnum.WebsiteTransactionid.setValue(Websitetransactionid);
					// return transaction status
					System.out.println("get payment status ->" + driver
							.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]"))
							.getText());
					Thread.sleep(500);

					if (driver.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]"))
							.getText().equalsIgnoreCase("Initiate")) {
						Thread.sleep(500);
						test.info("Transaction Details with <b>Initiate</b>", extentScreenshot());
						// method.setValue("Initiate");
						methodtype = "Initiate";
					} else if (driver
							.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]"))
							.getText().equalsIgnoreCase("Pending")) {
						Thread.sleep(500);
						test.info("Transaction Details with <b>Pending</b>", extentScreenshot());
						methodtype = "Pending";
					} else if (driver
							.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]"))
							.getText().equalsIgnoreCase("Cancelled")) {
						Thread.sleep(500);
						test.info("Transaction Details with <b>Cancelled</b>", extentScreenshot());
						methodtype = "Cancelled";
					} else {
						Thread.sleep(500);
						methodtype = "Success";
						test.info("Transaction Details with <b>Success</b>", extentScreenshot());
					}
					driver.findElement(By.xpath(
							"(//h2[text()='Transaction Details'])[1]//following::button[contains(@class,'btn-close')]"))
							.click();
					Thread.sleep(500);
				} else {
					test.info("No Transaction Details available", extentScreenshot());
				}
			} else {
				test.info("No Transaction Details available in website", extentScreenshot());
			}
		} else {
			test.fail("Something wrong!To Open Website Transactions screen", extentScreenshot());
		}
		Thread.sleep(2500);
	}

	public void VerifyPaymentInAdmin_purchaseHistory(String amethod, String wmethod, String tID)
			throws IOException, InterruptedException {
		test = extentCreateTest("Verify Payment In Admin purchase History");

		PurchaseHistory pr = new PurchaseHistory(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage lp = new LobbyPage(driver);

		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
		gp.clickOnPlayerManagement();
		Thread.sleep(500);
		pr.clickPurchaseHistory();
		// ph.PurchaseHistory_WebsiteSearch(WebsiteTransactionid,LobbyEnum.Playerusername.getValue());
		if (driver.findElement(By.xpath("//h3[contains(text(),\"Purchase History\")]")) != null) {
			test.info("Opened Purchase History Successfully on player profile from Admin");

			if (amethod.equalsIgnoreCase("Initiate")) {
				if (wmethod.equalsIgnoreCase("Skrill")) {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]"))
							.click();
				} else if (wmethod.equalsIgnoreCase("Paysafe")) {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Paysafe Initiated\"]"))
							.click();
				} else if (wmethod.equalsIgnoreCase("Payper")) {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Payper Initiated\"]"))
							.click();
				} else {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Bank Card Initiated\")]"))
							.click();
				}
			} else {
				driver.findElement(By.xpath(
						"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Payment\")]"))
						.click();
			}
			Thread.sleep(500);
			gp.Search_Items(tID);
			if (driver.findElements(By.xpath(
					"//th[text()=\"Package Name\"]/following::tr//td[contains(@class,'cdk-column-packageName')]"))
					.size() > 0) {
				lp.View_Click();
				lp.ClickToClose();
				test.info("Successfully Searched Website <b>Transactions ID</b>", extentScreenshot());
				LobbyEnum.PaymentID.setValue(
						driver.findElement(By.xpath("(//td[contains(@class,'cdk-column-paymentId')])[1]")).getText());
				filter(wmethod);
				PageReload();
			} else {
				test.fail("Something wrong !! To Search Website Transactions ID", extentScreenshot());
			}
		} else {
			test.fail("Something wrong !! Player Purchase History not found", extentScreenshot());
		}
	}

	public void VerifyPaymentInAdmin_playerPurchaseHistory(String player, String amethod, String tID)
			throws IOException, InterruptedException {
		test = extentCreateTest("Verify Payment In Admin player Purchase History");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage lp = new LobbyPage(driver);
		BaseClass.gotoTab(driver, 0);
		// String packagename = LobbyEnum.search_StorepackageName.getValue();
		Thread.sleep(500);

		pp.clickOnPlayerManagement();
		pp.clickPlayerProfileLink();
		gp.Search_Items(player);
		Thread.sleep(2000);
		pp.Clickeyeicon();
		pp.clickPurchaseHistoryTab();

		if (driver.findElement(By.xpath("//button[contains(text(),\"Purchases\")]")) != null) {
			test.info("Opened player Purchase History Successfully from Admin");
			if (amethod.equalsIgnoreCase("Initiate")) {
				driver.findElement(By.xpath(
						"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]"))
						.click();
			} else {
				driver.findElement(By.xpath(
						"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Payment\")]"))
						.click();
			}
			Thread.sleep(1500);
			System.out.println("Website TransactionID in player purchase history->" + tID);
			lp.SearchItems(tID);
			Thread.sleep(3500);
			// System.out.println("packagename =" + packagename);
			if (driver.findElements(By.xpath("//th[text()=\"Package Name\"]")).size() > 0) {
				lp.View_Click();
				test.info("Successfully Searched Website <b>Transactions ID</b>", extentScreenshot());
				lp.ClickToClose();
				filter("PayPer");
				PageReload();
			} else {
				test.fail("Something wrong !! To Search Website Transactions ID", extentScreenshot());
			}
		} else {
			test.fail("Something wrong !! Purchase History not found", extentScreenshot());
			Thread.sleep(2000);
		}
		Thread.sleep(2500);
	}

	public void filter(String pmethod) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()=' Filter']")).click();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[contains(text(),\"Search Purchase History\")]")) != null) {
			driver.findElement(By.xpath("//mat-select[@formcontrolname=\"paymentProvider\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-option/span[text()='" + pmethod + "']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button/span[text()=\"Search\"]")).click();
			Thread.sleep(1000);
			if (driver
					.findElements(By.xpath(
							"//th[text()='Package Name']/following::tr//td[contains(@class,'cdk-column-packageName')]"))
					.size() > 0) {
				System.out.println("pass");
				test.pass("Successfully found record", extentScreenshot());
			} else {
				test.fail("Not found record", extentScreenshot());
			}
		} else {
			test.info("not found Search Purchase History page ", extentScreenshot());
		}

	}

	public void VerifyPaymentInAdmin_TransactionHistory(String tid, String pmethod)
			throws IOException, InterruptedException {

		test = extentCreateTest("Verify Payment In Admin Transaction History");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage lp = new LobbyPage(driver);
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[contains(text(),'Transaction History')]")).click();
		gp.Search_Items(tid);
		Thread.sleep(3000);

		// if (driver.findElements(By.xpath("//th[text()=\"Payment
		// Method\"]/following::tr//td[contains(@class,\"cdk-column-paymentProvider\")]")).size()
		// > 0) {
		if (driver
				.findElements(
						By.xpath("//th[text()='Payment Method']/following::tr//td[contains(text(),'" + pmethod + "')]"))
				.size() > 0) {
			lp.View_Click();
			test.info("Successfully displayed Tansaction details  in Grid", extentScreenshot());
			lp.ClickToClose();
			filter(pmethod);
			PageReload();
		} else {
			test.info("Not displayed Tansaction details in Grid");
		}
	}

	public static void websiteMenu_Verify() throws IOException, InterruptedException {
		Thread.sleep(1000);

		driver.get(WebURL + Constant.WebsitePlayerProfile);
		Thread.sleep(1500);
	}

	public void websiteMenu_VerifyDisplayname() throws IOException, InterruptedException {
		GuestPlayers gp = new GuestPlayers(driver);

		websiteMenu_Verify();
		int i = gp.displayNameofRegWeb.getText().length();
		if (i < 21) {
			String result = gp.displayNameofRegWeb.getText().substring(5, 20);
			gp.SenddisplayName(result);
		} else {
			System.out.println("Display name under 20 chars....");
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[text()='Save']")));

	}

	public void CustomPackages_Create(String cpcode, String cpname, String cpamount, String cpdiscount, String cST,
			String cGT, String cExtraST, String selectplayer) throws IOException, InterruptedException {
		test = extentCreateTest("Create Custom Packages");
		LobbyPage lb = new LobbyPage(driver);
		test.info("TestCase started Create Lobby Custom Packages");
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby_LobbyCPackage();
		lb.clickToCreate();
		lb.selectRole(LobbyEnum.storerole.getValue());
		lb.selectUsername(LobbyEnum.storeusername.getValue());
		// Search_package="T"+randNum;
		lb.LobbyPackage_Code(cpcode);
		lb.LobbyPackage_name(cpname);
		lb.LobbyPackage_amount(cpamount);
		lb.LobbyPackage_discountAmount(cpdiscount);
		lb.LobbyPackage_Gametoken(cST);
		lb.LobbyPackage_Sweeptoken(cGT);
		lb.LobbyPackage_extraSweeptoken(cExtraST);
		driver.findElement(By.xpath("//input[@formcontrolname=\"fishGameInviteCodeCount\"]")).sendKeys("10");
		lb.SetDesc_StorePackage("This is testing Custom Packages " + cpname);
		Thread.sleep(1500);
//		if (selectplayer.equalsIgnoreCase("yes")) {
//			// code for select player
//			if (driver.findElements(By.xpath("//button/span[text()='Select Player']")).size() > 0) {
//				Thread.sleep(2000);
//				// search player and sent
//				lb.selectplayer(Constant.emailArray.get(2));
//				if (driver.findElement(
//						By.xpath("//tbody//tr//td[contains(text()," + Constant.emailArray.get(2) + ")]")) != null) {
//					test.pass("successfuly find record in search players  -> " + Constant.emailArray.get(2),
//							extentScreenshot());
//				} else {
//					test.fail("Something Wrong!To View records in players.", extentScreenshot());
//				}
//			} else {
//				test.info("no player selction   <b>" + "" + "</b>", extentScreenshot());
//			}
//		} else {
//			test.info("Not intrested to apply custom packages to players");
//		}
		Thread.sleep(1000);
		lb.ClickToSave();

		// Boolean bool=cc.Validation_Format_Addpackage.isDisplayed();
		if (driver.findElements(By.xpath("//span[text()=\"Custom package save successfully\"]")).size() > 0) {
			test.pass("<b><i>Custom Packages- add successfully</b></i>", extentScreenshot());
			LobbyEnum.search_CustomPackageName.setValue(cpname);
			Constant.customPackageAdmin = LobbyEnum.search_CustomPackageName.getValue();
			System.out.println("last stored custom package is =" + Constant.customPackageAdmin);
		} else {
			test.fail("<b><i>not able to Add Custom Packages </b></i>", extentScreenshot());
			Thread.sleep(3000);
			lb.ClickToCancel();
		}
		Thread.sleep(2000);
		test.info("Create Custom Packages test case end");
	}

	@Test
	public void Ma_LobbyManagement_CustomPackages_Create() throws IOException, InterruptedException {
		CustomPackages_Create(LobbyEnum.search_Custompackage.getValue(), LobbyEnum.search_CustomPackageName.getValue(),
				LobbyEnum.customPackageAmount.getValue(), LobbyEnum.storePackageDiscountAmount.getValue(),
				LobbyEnum.customPackageST.getValue(), LobbyEnum.customPackageGT.getValue(),
				LobbyEnum.customPackageExtraST.getValue(), "yes");
		System.out.println("custom package created with name ->" + LobbyEnum.search_Custompackage.getValue() + "="
				+ LobbyEnum.search_CustomPackageName.getValue());
	}

	@Test
	public void Mb_LobbyManagement_CustomPackages_Status() throws IOException, InterruptedException {
		test = extentCreateTest("CustomPackages status");
		LobbyPage lb = new LobbyPage(driver);
		test.info(
				"TestCase started status CustomPackages- As an admin user I should be able to change status for CustomPackages");
		Thread.sleep(1000);
		PageReload();
		lb.SearchItems(LobbyEnum.search_Custompackage.getValue());

		test.info("successfuly found Custom Package  in a List. with package  -> "
				+ LobbyEnum.search_Custompackage.getValue(), extentScreenshot());

		// status active/inactive
		if (driver
				.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]"))
				.getAttribute("title").equalsIgnoreCase("Un Publish")) {
			test.info("Successfully Viewed active CustomPackages page");
			test.info("Now CustomPackages Is In Active");
			driver.findElement(By.xpath(
					"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
					.click();
			Thread.sleep(1000);
			lb.clickToYesButton();
			Thread.sleep(1000);
			try {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link activated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby CustomPackages Successfully activated and Validation message appeared - Lobby CustomPackages activated successfully",
							extentScreenshot());
				} else {

					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElement(
						By.xpath("//span[text()=\"Lobby package link activated successfully\"]")) != null) {
					test.pass(
							"Lobby CustomPackages Successfully activated and Validation message appeared - Lobby CustomPackages activated successfully",
							extentScreenshot());
				}
				System.out.println(e);
			}
			Thread.sleep(4000);
		} else {
			test.info("Successfully Viewed View Icon of CustomPackages listing page");
			test.info("Now CustomPackages Is Active");
			driver.findElement(By.xpath(
					"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]"))
					.click();
			Thread.sleep(1000);
			lb.clickToYesButton();
			Thread.sleep(1000);
			try {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby CustomPackages Successfully deactivated and Validation message appeared - Lobby CustomPackages deactivated successfully",
							extentScreenshot());
				} else {

					test.fail("Failed ! To View Message", extentScreenshot());
				}
			} catch (Exception e) {
				if (driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]"))
						.size() > 0) {
					test.pass(
							"Lobby CustomPackages Successfully deactivated and Validation message appeared - Lobby CustomPackages deactivated successfully",
							extentScreenshot());
				}
				System.out.println(e);
			}

		}
		test.info("TestCase-status CustomPackages Ended");
	}

	@Test
	public void Mc_LobbyManagement_CustomPackages_Delete() throws IOException, InterruptedException {
		test = extentCreateTest("CustomPackages Delete");
		test.info(
				"TestCase started delete CustomPackages - As an admin user I should be able to delete CustomPackages");
		LobbyPage lb = new LobbyPage(driver);
		lb.SearchItems(LobbyEnum.search_Custompackage.getValue());
		Thread.sleep(2000);

		// -----------delete Lobby CustomPackages-----------
		test.info("delete CustomPackages test case start");
		if (lb.packageDeletebuttonElement()) {
			lb.packageDeleteItems();
			if (lb.VerifyYesDeleteIt()) {
				lb.ClickYesDeleteIt();
				test.pass("<b><i>CustomPackages - delete successfully</b></i>", extentScreenshot());
			} else {
				test.fail("<b><i>not able to delete</b></i>", extentScreenshot());
			}

			Thread.sleep(500);
			boolean isDisplayed = CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
			String message = isDisplayed ? "<b><i>StorePackage - delete message return</b></i>"
					: "<b><i>StorePackage - not able show delete message</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
			Thread.sleep(1000);
		} else {
			test.info("Delete button not found for CustomPackages", extentScreenshot());
		}

		test.info("Delete CustomPackages test case end");
	}

	@Test
	public void Md_LobbyManagement_CustomPackages_Create() throws IOException, InterruptedException {

		CustomPackages_Create(LobbyEnum.search_Custompackage.getValue(), LobbyEnum.search_CustomPackageName.getValue(),
				LobbyEnum.customPackageAmount.getValue(), LobbyEnum.storePackageDiscountAmount.getValue(),
				LobbyEnum.customPackageST.getValue(), LobbyEnum.customPackageGT.getValue(),
				LobbyEnum.customPackageExtraST.getValue(), "no");
		System.out.println("package created with name ->" + LobbyEnum.search_Custompackage.getValue() + "="
				+ LobbyEnum.search_CustomPackageName.getValue());

	}

	@Test
	public void Me_LobbyManagement_CustomPackages_Search() throws IOException, InterruptedException {
		test = extentCreateTest("CustomPackages Search");
		test.info("TestCase started view CustomPackage search ");
		LobbyPage lb = new LobbyPage(driver);

		// -----------Search CustomPackage-----------
		test.info("Search CustomPackage test case start");
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_LobbyCPackage();

		lb.SearchItems(LobbyEnum.search_Custompackage.getValue());

		if (driver
				.findElements(By
						.xpath("//tbody//tr//td[contains(text(),'" + LobbyEnum.search_Custompackage.getValue() + "')]"))
				.size() > 0) {
			test.pass("successfuly find record in Custom Packages -> " + LobbyEnum.search_Custompackage.getValue(),
					extentScreenshot());
			Constant.purchasebool = 1;
		} else {
			test.fail("Something Wrong!To View records in Custom Packages.", extentScreenshot());
			Constant.purchasebool = 0;
		}
		test.info("Search CustomPackage test case end");
	}

	@Test(groups = { "admin", "Website" })
	public void MfLobbyManagement_Website_VerifyCustomPackage_LastAdded() throws IOException, InterruptedException {
		test = extentCreateTest("Verify last added Custom Package");
		test.info("TestCase started Verify last added Custom Package");
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(1500);
		System.out.println("Register Players ->" + Constant.emailArray);
//		if (!Constant.emailArray.isEmpty()) {
//			LobbyEnum.Playerusername.setValue(Constant.emailArray.get(2));// "AT7779-1424";//
//			System.out.println("player name -" + LobbyEnum.Playerusername.getValue());
//		} else {
//			LobbyEnum.Playerusername.setValue(Constant.emailArray.get(0));
//		}
		LobbyEnum.Playerusername.setValue(Constant.emailArray.get(0));
		gotoTab(driver, 1);
		Thread.sleep(1000);
		// websiteMenu_Verify();

		System.out.println("player name -" + LobbyEnum.Playerusername.getValue());
		Thread.sleep(2000);
		/// lb.websitePackage();
		driver.get(WebURL + Constant.WebsitePackages);
		try {
			String CustomPackageWeb = driver.findElement(By.xpath("//h1[text()='" + Constant.customPackageAdmin + "']"))
					.getText();
			String CustomPackageWeb_GT = driver.findElement(By.xpath(
					"(//h1[text()='" + Constant.customPackageAdmin + "']//following::span[@class='pi-text'])[1]"))
					.getText();
			String CustomPackageWeb_ST = driver.findElement(By.xpath(
					"(//h1[text()='" + Constant.customPackageAdmin + "']//following::span[@class='pi-text'])[2]"))
					.getText();
			String CustomPackageWeb_Amount = "$" + driver
					.findElement(By.xpath("//h1[text()='" + LobbyEnum.search_Custompackage.getValue()
							+ "']//following::span[text()='" + "$" + LobbyEnum.storePackageAmount.getValue() + "']"))
					.getText();
			System.out.println("last added custom package is ->" + LobbyEnum.search_Custompackage.getValue() + "="
					+ Constant.customPackageAdmin);

			if (Constant.customPackageAdmin.equalsIgnoreCase(CustomPackageWeb)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();",
						driver.findElement(By.xpath("//h1[.='" + LobbyEnum.search_Custompackage.getValue() + "']")));
				Thread.sleep(1000);
				test.pass("last added custom Package found in Website", extentScreenshot());

				if (!(CustomPackageWeb_GT.equals(LobbyEnum.customPackageGT.getValue())
						&& CustomPackageWeb_ST.equals(LobbyEnum.customPackageST.getValue())
						&& CustomPackageWeb_Amount.equals(LobbyEnum.customPackageAmount.getValue()))) {
					System.out.println("matched GT ST amount with Website" + CustomPackageWeb_GT + "--"
							+ CustomPackageWeb_ST + "--" + CustomPackageWeb_Amount);
					test.pass(
							"matched GT <b>" + CustomPackageWeb_GT + "</b> ST <b>" + CustomPackageWeb_ST
									+ "</b> amount <b>" + CustomPackageWeb_Amount + "</b> with Website",
							extentScreenshot());

//				//comment this code ->for compare transaction only with Admin	
//				driver.findElement(By.xpath("(//h1[.='"+customPackageAdmin+"']//following::button[.='Purchase'])[1]")).click();
//				Thread.sleep(2000);
//				//apply coupon code
//				lb.ApplyCouponCode(LobbyEnum.storecouponName.getValue());
//				driver.findElement(By.xpath("(//h1[.='"+customPackageAdmin+"']//following::button[.='Purchase'])[1]")).click();
//				Thread.sleep(3000);
//				switchToWindow("Skrill");
//				Thread.sleep(500);
//				SkrilPayment(); 
					VerifyPaymentFromAdmin(Constant.customPackageAdmin, LobbyEnum.storecouponName.getValue(),
							LobbyEnum.Playerusername.getValue());
					VerifyPaymentFromAdmin(Constant.customPackageAdmin, "", LobbyEnum.Playerusername.getValue());
					VerifyPaymentFromAdmin(Constant.customPackageAdmin, LobbyEnum.storecouponName.getValue(),
							LobbyEnum.Playerusername.getValue());

					VerifyPaymentTransactions_Website(LobbyEnum.paymentway.getValue(),
							LobbyEnum.Skrillmethod.getValue());
					VerifyPaymentInAdmin_purchaseHistory(LobbyEnum.paymentway.getValue(),
							LobbyEnum.paymentMethodFromWebsite.getValue(), LobbyEnum.WebsiteTransactionid.getValue());
					VerifyPaymentInAdmin_playerPurchaseHistory(Constant.emailArray.get(2),
							LobbyEnum.paymentway.getValue(), LobbyEnum.WebsiteTransactionid.getValue());

				} else {
					test.info("Not matched GT ST amount", extentScreenshot());
				}
				Thread.sleep(1000);
			} else {
				test.fail("last added CustomPackage not found in Website ! Failed", extentScreenshot());
			}
		} catch (Exception e) {
			System.out.println("something went wrong - not able to match packages  " + e);
			test.info("something went wrong - not able to match packages " + e);
		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
	}

	public void VerifyPaymentFromAdmin(String pack, String cpn, String player)
			throws IOException, InterruptedException {
		BaseClass.gotoTab(driver, 0);
		test.info("Redirect to Admin and check payment");
		Thread.sleep(1500);
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PlayersProfile ppt = new PlayersProfile();
		LobbyPage lb = new LobbyPage(driver);
		Thread.sleep(2000);
		gp.clickOnPlayerManagement();
		pp.clickPlayerProfileLink();
		gp.Search_Items(player);
		lb.View_Click();
		// lb.ApplyCouponCode(LobbyEnum.storecouponName.getValue());
		ppt.PlayerProfileTest_ManageTokens(pack, "", cpn, "Manual ", "", "");
		// ppt.PlayerProfileTest_ManageTokens(pack,"",LobbyEnum.storecouponName.getValue()"Others
		// ","","");
		Thread.sleep(2000);
	}

	@Test
	public void Mh_LobbyManagement_CustomPackages_PackagePurchaseHistory() throws IOException, InterruptedException {
		test = extentCreateTest("Lobby CustomPackages Purchase History  ");
		test.info(
				"TestCase started view CustomPackages - As an admin user I should be able to view on CustomPackages Purchase History");
		LobbyPage lb = new LobbyPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_LobbyCPackage();

		if (Constant.purchasebool == 1) {
			if (lb.VerifyCustomPurchaseHistoryTitle()) {
				test.info("View Store Package Purchase History start...");
				lb.clickToViewCustomPurchaseHistory();

				if (lb.VerifyCustomPurchaseHistoryHeader()) {
					if (driver.findElement(By.xpath("//button[@title='Export XLSX']")) != null) {
						if (driver.findElement(By.xpath(
								"(//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"cdk-column-playerInfo-playerId\")])[1]"))
								.getText().equalsIgnoreCase(LobbyEnum.Playerusername.getValue())) {
							Thread.sleep(500);
							test.pass("<b><i>Successfully verify searched player on Custom Package Purchase History",
									extentScreenshot());
						} else {
							Thread.sleep(500);
							test.fail(
									"<b><i>not able to verify searched player on Custom Package Purchase History</b></i>",
									extentScreenshot());
						}
						test.info("Testing XLSX Download in Custom Package Purchase History");
						pp.clickXlsxButton();

						String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";
						if (driver.findElement(By.xpath("(//span[contains(text(),'" + msg + "')])[1]")).isDisplayed()) {
							test.pass("Successfully XLSX Downloaded message displayed");

							// this code is for download page comparsion
							String modulename = "Custom Package History";
							Thread.sleep(2000);
							driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]"))
									.click();
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
							test.fail("Something wrong !! To Download XLSX MESSAGE NOT DISPLAYED", extentScreenshot());
						}
					} else {
						test.fail("Something wrong !! To Download XLSX", extentScreenshot());
					}
				} else {
					Thread.sleep(500);
					test.fail("<b><i>Successfully verify searched Custom Package in  a List.</b></i>",
							extentScreenshot());
				}
				Thread.sleep(2000);

			} else {
				test.info("Custom Package Purchase History button not found", extentScreenshot());
			}
			Thread.sleep(2000);
			Constant.purchasebool = 0;
		} else {
			Thread.sleep(500);
			test.info("<b><i>no record found in custom package grid</b></i>", extentScreenshot());
		}
		test.info("View Custom Package Purchase History test case end.");
	}

	@Test
	public void Mi_LobbyManagement_CustomPackages_View() throws IOException, InterruptedException {
		test = extentCreateTest("CustomPackages View");
		test.info("TestCase started view CustomPackages ");
		LobbyPage lb = new LobbyPage(driver);
		// CommonCosmo cc=new CommonCosmo(driver);

		PageReload();
		if (driver
				.findElements(By
						.xpath("//tbody//tr//td[contains(text(),'" + LobbyEnum.search_Custompackage.getValue() + "')]"))
				.size() > 0) {
			lb.View_Click();
			lb.clickToViewData();
			lb.ClickToClose();
		} else {
			test.fail("Something Wrong!To find records in Custom Packages.", extentScreenshot());
		}
		test.info("View CustomPackages test case end.");
		Thread.sleep(1000);
	}

	@Test
	public void Mj_LobbyManagement_CustomPackages_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("CustomPackages Edit");
		test.info("TestCase started Edit CustomPackages  ");
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lb.clickViewLobby();
		lb.clickViewLobby_LobbyCPackage();
		lb.SearchItems(LobbyEnum.search_Custompackage.getValue());

		// ------------------Edit LobbyPackage------------
		if (lb.EditButton.isDisplayed() == true) {
			lb.clickToEdit();
			lb.LobbyPackage_name("StarpackCP" + Constant.randomString);
			lb.LobbyPackage_amount(LobbyEnum.storePackageAmount.getValue());
			lb.LobbyPackage_discountAmount("");
			lb.LobbyPackage_Gametoken(LobbyEnum.storePackageGT.getValue());
			lb.LobbyPackage_Sweeptoken(LobbyEnum.storePackageST.getValue());
			lb.LobbyPackage_extraSweeptoken(LobbyEnum.storePackageExtraST.getValue());
			lb.SetDesc_StorePackage("This is edit testing Custom Packages...");
			lb.ClickToSave();
			Thread.sleep(1000);
			boolean isDisplayed = cc.Validation_Format_Updatepackage.isDisplayed();
			String message = isDisplayed ? "<b><i>StorePackage - update message return</b></i>"
					: "<b><i>StorePackage - not able show update message</b></i>";
			test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
			Thread.sleep(1000);
			test.info("TestCase-Edit CustomPackages Ended");
		} else {
			test.info("Edit CustomPackages button not found", extentScreenshot());
		}
	}

	@Test
	public void N_LobbyManagement_Website_VerifyGames_Web() throws IOException, InterruptedException {
		test = extentCreateTest("Website  - Store Game Search");
		LobbyPage lb = new LobbyPage(driver);
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
			LobbyRedirect("search", loby);
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
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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

		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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

		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("view", store);
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
		LobbyRedirect("view", loby);
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
		LobbyRedirect("view", loby);
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
		LobbyRedirect("view", loby);
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
//		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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

		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("view", loby);
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

		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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

		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
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

		LobbyRedirect("view", LobbyEnum.Lcode.getValue());
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
		LobbyRedirect("view", LobbyEnum.Lcode.getValue());

		lb.clickViewLobby_Socialmedia();
		if (lb.EditButton.isDisplayed() == true) {
			lb.clickToEdit();

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
		WebsiteSetting_TabAccess(LobbyEnum.Lcode.getValue());
	}

	public void WebsiteSetting_TabAccess(String store) throws Exception {
		test = extentCreateTest("Website Settings - Tab Access");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		Thread.sleep(1500);

		LobbyRedirect("view", store);
		lb.clickViewLobby_WebsiteSetting();
		lb.clickViewLobby_WebsiteSetting_TabAccess();
		// lb.ClickToSave();
		// driver.findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();

		List<String> list = new ArrayList<String>();
		list.add("Verify");
		list.add("Packages");
		list.add("Stats");
		list.add("Profile");
		list.add("Bonuses");
		list.add("Withdraw");
		list.add("Transactions");
		list.add("Support");
		list.add("Game Transactions");
		list.add("Chat");
		list.add("Announcement");
		list.add("Wallet");
		list.add("Withdraw Request");
		// list.add("Fun Zone");
		System.out.println("Tab Access->" + list.size());
		Thread.sleep(500);
		for (String tab : list) {
			Thread.sleep(500); // Consider using WebDriverWait instead of Thread.sleep for better
								// synchronization
			System.out.println("Clicked-> " + tab);
			driver.findElement(By.xpath("//span[contains(text(),'" + tab + "')]")).click();
			Thread.sleep(500); // Consider using WebDriverWait instead of Thread.sleep for better
								// synchronization
		}
//		for (int i = 0; i < list.size(); i++) {
//			Thread.sleep(500);
//			System.out.println("Clicked-> " + list.get(i));
//			driver.findElement(By.xpath("//span[contains(text(),'" + list.get(i) + "')]")).click();
//			Thread.sleep(500);
//		}
		lb.ClickToSave();

		/// uncomment if u want to compare with website
//		if (cc.verifyValidation_Format_Website_TabAccess_update() == true
//				if (cc.verifyValidation_Format_Website_TabAccess() == true) {
//			test.pass("Website setting updated Tab Access message return", extentScreenshot());
//			// compare with website tabs
//			// Website_AccessTab(list.get(i));
//		} else {
//			test.fail("Something Wrong ! not able get add Website  Tab Access message ", extentScreenshot());
//
//		}
		Thread.sleep(2000);
		test.info(" TestCase - Website settings Tab Access End");
	}

	public void Website_AccessTab(String tab) throws Exception {
		BaseClass.gotoTab(driver, 1);
		PageReload();
		websiteMenu_Verify();

		boolean isDisplayed = !driver.findElement(By.xpath("//button[contains(text(),'" + tab + "')]")).isDisplayed();
		String message = isDisplayed ? "Access tab->" + tab + "are not the same in Admin and Website"
				: "Access tab->" + tab + "are the same in Admin and Website";
		test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		Thread.sleep(300);
		BaseClass.gotoTab(driver, 0);
	}

//-----------End version 1.0.2--------------	

}
