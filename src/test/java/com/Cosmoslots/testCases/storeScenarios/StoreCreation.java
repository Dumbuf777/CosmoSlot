package com.Cosmoslots.testCases.storeScenarios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.testCases.UserHierarchy;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.Status;

public class StoreCreation extends BaseClass {
	BaseClass bc = new BaseClass();
	LobbyPage lobypage = new LobbyPage(driver);
	
	public void StoreValue() {

		Constant.emailArray.add("AT5426-2811");
		Constant.emailArray.add("AT5426-2812");
		Constant.emailArray.add("AT5426-2813");
	}

	@Test
	public void A_LobbyManagement_NewLobby() throws Exception {
		NewLobby(LobbyEnum.Lcode.getValue(), LobbyEnum.LobbyName.getValue(), "slot", "keno", "fish");
		CommonCosmo cc = new CommonCosmo(driver);
		if (cc.verifyStoreSaved()) {
			test.pass("store saves successfully");
		} else {
			//NewLobby(LobbyEnum.Lcode.getValue(), LobbyEnum.LobbyName.getValue(), "slot", "keno", "fish");
			test.fail("store not saves successfully");
			driver.quit();
		}
	}

	public void LobbyRedirect(String Lobbymenu, String Lobbycode) throws IOException, InterruptedException {
		// StoreValue();
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
	public void Aa_LobbyManagement_WithdrawSettings() throws Exception {
		WithdrawSettings(LobbyEnum.Lcode.getValue());
	}

	@Test
	public void Ab_LobbyManagement_WebsiteSetting_TabAccess() throws Exception {
		WebsiteSetting_TabAccess(LobbyEnum.Lcode.getValue());
	}

	@Test
	public void Ac_LobbyManagement_StoreSettingPurchaseStoreSetting() throws Exception {
		PurchaseStoreSetting(LobbyEnum.Lcode.getValue(), "other", "cashapp", "paysafe", "zenpayment", "wallet",
				"seamless", "contactUs", "skrill");
	}

	@Test
	public void Ad_LobbyManagement_StoreSettingWithdrawStoreSetting() throws Exception {
		WithdrawStoreSetting(LobbyEnum.Lcode.getValue(), "seamless", "skrill", "cashapp", "bank", "wallet", "contactUs",
				"manual", "paysafe");
	}

	@Test
	public void Ae_LobbyManagement_StoreSettingWalletDepositOptions() throws Exception {
		WalletDepositOptions(LobbyEnum.Lcode.getValue(), "seamless", "other", "skrill", "cashapp", "paysafe",
				"zenpayment");
	}

	@Test
	public void Af_LobbyManagement_StoreSettingWalletWithdrawOptions() throws Exception {
		WalletWithdrawOptions(LobbyEnum.Lcode.getValue(), "skrill", "cashapp", "paysafe", "chex", "bank");
	}

	@Test
	public void Ag_LobbyManagement_PlayerSetting_PlayerProfile() throws Exception {
		PlayerSetting_PlayerProfile(LobbyEnum.Lcode.getValue(), "email", "phone");
	}

	@Test
	public void Ah_LobbyManagement_PlayerSetting_Signup() throws Exception {
		PlayerSetting_Signup(LobbyEnum.Lcode.getValue(), "email", "phone");
	}

	@Test
	public void Ai_LobbyManagement_PlayerSettingGuestToPlayer() throws Exception {
		PlayerSetting_GuestToPlayer(LobbyEnum.Lcode.getValue(), "email", "phone", "kyc1");
	}

	@Test
	public void Az_LobbyManagement_StoreFlow() throws Exception {
		 test = extentCreateTest(" Create New Users ");
		UserHierarchy uh = new UserHierarchy();
		Thread.sleep(2000);
//		try {
			uh.parentString = " Gameium Admin ";
			for (int i = 0; i < Constant.strAr.length; i++) {
				UserHierarchy uh1 = new UserHierarchy();

				System.out.println(Constant.strAr[i]);
				uh1.CreateNewUsers1(Constant.strAr[i],"store-99472" , uh.parentString);//LobbyEnum.Lcode.getValue()

				if (Constant.strAr[i].equalsIgnoreCase("POS ")) {
					LobbyEnum.POSnmm.setValue(uh1.username);
					System.out.println("POS name =>" + LobbyEnum.POSnmm.getValue());
				}
				if (Constant.strAr[i].equalsIgnoreCase("Store ")) {
					LobbyEnum.storeusername.setValue(uh1.map.get("Store ") + " ");
					System.out.println("store name =>" + uh1.map.get("Store "));
				}
				System.out.println("invite code->" + uh1.codeArray);
				LobbyEnum.invitecode.setValue(uh1.codeArray);
			}
//		} catch (Exception e) {
//			System.out.println("something went wrong - not able to create user " + e);
//			test.info("something went wrong - not able to create user " + e);
//		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(500);
	}

	
	@Test
	public void B_LobbyManagement_Search() throws IOException, InterruptedException {

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
	public void C_LobbyManagement_Maintenance() throws IOException, InterruptedException {
		test = extentCreateTest("Store Maintenance");
		test.info("TestCase Store Maintenance Start");
		LobbyRedirect("search", LobbyEnum.Lcode.getValue());
		lobbymaintenance(LobbyEnum.Lcode.getValue());
		test.info("TestCase Store Maintenance Ended");
		Thread.sleep(1500);
	}

	@Test
	public void D_LobbyManagement_Copy() throws IOException, InterruptedException {
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
	public void F_LobbyManagement_View() throws IOException, InterruptedException {
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
	public void G_LobbyManagement_Edit() throws IOException, InterruptedException {
		test = extentCreateTest("Edit store");
		test.info("TestCase started Edit Store - As an admin user I should be able to Edit Store");
		Thread.sleep(2000);
		LobbyRedirect("edit", LobbyEnum.Lcode.getValue());
		test.info("TestCase - Edit Store Ended");
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

	public static void websiteMenu_Verify() throws IOException, InterruptedException {
		Thread.sleep(1000);

		driver.get(WebURL + Constant.WebsitePlayerProfile);
		Thread.sleep(1500);
	}
}
