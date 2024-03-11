/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.pageObjects.SupportManagement;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserAcReadOnlyUser extends BaseClass {
	BaseClass bc = new BaseClass();
	
	@Test
	public void A_TC_AdminLogin() throws InterruptedException, IOException {

		LoginPage lp = new LoginPage(driver);
		Thread.sleep(2000);
		lp.clickLogout();
		Thread.sleep(2000);
		Adminlogin("read01");
		}

	@Test
	public void Ab_TC_ReadOnlyUser_Dashboardview() throws InterruptedException {
		String[] Dashboard = { "Total Purchase", "Total Player", "Total Game", "Total Bets" };
		String[] Dashboard1 = { "Daily Bets", "Player Transaction", "Daily Purchases", "Player Location",
				"Latest Withdraw Requests", "Most Player Login", "Latest Purchase History" };
		test = extentCreateTest("TC - As an read only user should be view the --> Dashboard  ");

		UserPage up = new UserPage(driver);

//		gotoTab(driver, 2);
//		bc.PageReload();
		up.ClickOnDashboard();
		for (int i = 0; i < Dashboard.length; i++) {
			if (driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")) != null) {
				if (driver.findElement(By.xpath(" //h5[contains(text(),'" + Dashboard[i] + "')]")).isDisplayed()) {
					test.pass("<b><i>Successfully viewed on Dashboard is </b></i>" + "<b><i>" + Dashboard[i] + "</b></i>",extentScreenshot());
					Assert.assertTrue(true);
				}
			  } else {
				test.fail("Something wrong!To view the Dashboard ", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
		for (int i = 0; i < Dashboard1.length; i++) {
			if (driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")) != null) {
				if (driver.findElement(By.xpath(" //h4[contains(text(),'" + Dashboard1[i] + "')]")).isDisplayed()) {
					test.pass("<b><i>Successfully viewed on dashboard is </b></i>" + "<b><i>" + Dashboard1[i] + "</b></i>", extentScreenshot());
					Assert.assertTrue(true);
				}
			} else {
				test.fail("Something wrong!To view on Dashboard", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void B_TC_ReadOnlyUser_PlayerProfile() throws InterruptedException {
		String[] PlayerProfile = { "Profile", "Manage Tokens", "Player Ledger", "Purchases", "Applied Coupons",
				"Withdraw Request", "Token Details", "Transaction History", "Game Transactions", "Support Request",
				"Footprints", };

		test = extentCreateTest("TC - As a read only user should be able to view the --> Player Profile");
		PlayerProfile pp = new PlayerProfile(driver);

		// gotoTab(driver, 2);
		// bc.PageReload();
		// Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//th[text()='Status']//following::span[contains(@class,'actionDisable')]")).size() > 0 
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1
				&& driver.findElements(By.id("player-invited")).size() < 1
				&& driver.findElements(By.id("edit")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewed player profile status action is disabled</b></i>", extentScreenshot());
		} else {
			test.fail("Something wrong!To view on Dashboard", extentScreenshot());
			Assert.assertTrue(false);
		}
		pp.Clickeyeicon();
		Thread.sleep(500);
		for (int i = 0; i < PlayerProfile.length; i++) {
			UserPage up = new UserPage(driver);
			Thread.sleep(1000);
			up.ClickonPlayerProfileButton(PlayerProfile[i]);
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[contains(text(),'View Player Details')]")).isDisplayed() == true) {
				if (driver.findElement(By.xpath("//button[contains(text(),'" + PlayerProfile[i] + "')]")).isDisplayed() == true) {
					test.pass("<b><i>Successfully viewd player  </b></i>" + "<b><i>" + PlayerProfile[i] + "</b></i>",extentScreenshot());
					Assert.assertTrue(true);
				} else {
					test.fail("Something wrong!To view the Player " + PlayerProfile[i], extentScreenshot());
					Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong!To view the Player Profile", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void C_TC_ReadOnlyUser_GuestPlayer() throws InterruptedException {

		test = extentCreateTest("TC - As a read only user I should be able to view the --> Guest Profile");

		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("(//th[text()='Status']//following::span[contains(@class,'actionDisable')])[3]")).size() > 0
				&& driver.findElements(By.xpath("(//th[text()='Player Verification']//following::span[contains(@class,'actionDisable')])[1]")).size() > 0
				&& driver.findElements(By.xpath("(//th[text()='Review']//following::span[contains(@class,'actionDisable')])[2]")).size() > 0
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass(
					"<b><i>Successfully viewed Guest player profile status, player verification, review action and to download XLSX is disabled</b></i>",extentScreenshot());
		} else {
			test.fail("Something wrong!To view on  Guest player profile status, player verification, review action is disabled",extentScreenshot());
			Assert.assertTrue(false);
		}
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewd Guest player create new btn and to download XLSX is disabled",extentScreenshot());
		} else {
			test.fail("Something wrong!To view on  Guest player profile create new btn and to download XLSX is disabled</b></i>",extentScreenshot());
			Assert.assertTrue(false);
		}
		// pp.Clickeyeicon();
	}

	@Test
	public void D_TC_ReadOnlyUser_BlockedList_ByUserData() throws InterruptedException {
		test = extentCreateTest("TC - As an read only user I should be able to view the --> Blocked List->By User Data");

		UserPage up = new UserPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		up.ClickBlockedListButton();
		Thread.sleep(500);
		up.ClickByUserButton();
		Thread.sleep(500);
		if (driver.findElements(By.xpath("//mat-form-field[contains(@class,'actionDisable')]")).size() > 0) {
			test.pass("<b><i>Successfully viewed Blocked By user data is disabled</b></i>", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To view the Blocked By user data is disabled", extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Da_TC_ReadOnlyUser_BlockedList_ByUserIP() throws InterruptedException {
		test = extentCreateTest("TC - As a read only user I should be able to view the --> Blocked List->By User IP");

		UserPage up = new UserPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		up.ClickBlockedListButton();
		Thread.sleep(500);
		up.ClickByIPTabButton();
		Thread.sleep(500);
		if (driver.findElements(By.xpath("//th[text()='Status']//following::span[contains(@class,'actionDisable')]")).size() < 1
				&& driver.findElements(By.xpath("//th[text()='Action']//following::span[contains(@class,'editActionIcon')]")).size() < 1
				&& driver.findElements(By.xpath("//th[text()='Action']//following::span[contains(@class,'deleteActionIcon')]")).size() < 1) {
			test.pass("<b><i>Successfully viewed Blocked By user IP is disabled</b></i>", extentScreenshot());
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Blocked By user data is disabled", extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void Db_TC_ReadOnlyUser_PurchaseHistory() throws InterruptedException {
		test = extentCreateTest("TC - As a read only user I should be able to view the --> Purchase History");
		PlayerProfile pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickPurchaseHistoryTab();
		Thread.sleep(500);

		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
			test.pass("<i><b>Successfully viewd in purchase history to download Receipt and  XLSX is disabled</i></b>",
					extentScreenshot());
		} else {
			test.fail(
					"<i><b>Something wrong!To view on in purchase history to download Receipt and XLSX is disabled</i></b>",
					extentScreenshot());
		}

	}

	@Test
	public void Dc_TC_ReadOnlyUser_PlayerDeletionHistory() throws InterruptedException {
		test = extentCreateTest("TC - As a read only user I should be able to view the --> Player Deletion History");
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		ph.clickOnPlayerDeletionHistory();
		Thread.sleep(500);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewd in player deletion history to download XLSX is disabled</b></i>",
					extentScreenshot());
		} else {
			test.fail("Something wrong!To view on in purchase history to download XLSX is disabled",
					extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	
	public void De_TC_ReadonlyUser_GameConfigurator() throws InterruptedException {
		test = extentCreateTest("TC - As a read only user I should be able to view the --> Game Configurator->");

		UserPage up = new UserPage(driver);

		up.ClickonGameConfigrator();
		Thread.sleep(500);
//		up.ClickonGameTools();
//		Thread.sleep(500);
//		up.ClickonSlotGameTools();
		up.ClickonSymbolType();
		Thread.sleep(500);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewd in game configurator create new Btn is disabled</b></i>",extentScreenshot());
		} else {
			test.fail("Something wrong!To view on game configurator create new  is disabled", extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void E_TC_ReadOnlyUser_StoreManagement() throws InterruptedException {
		test = extentCreateTest("TC - As a read only user I should be able to view the --> Store Management ->");

		String[] StoreDashboard = {"Packages", "Custom Packages","Bonus","Store Coupon","Withdraw Settings","App Marketing","Player Setting", };
	

		LobbyPage_Old lp = new LobbyPage_Old(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		lp.clicklobbymanagement();
		Thread.sleep(1000);
		lp.clickStoreAccounts();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewd create new store btn is disabled for read only user</b></i>",extentScreenshot());
		} else {
			test.fail("Something wrong!To view on  create new store btn is disabled for read only user",extentScreenshot());
			Assert.assertTrue(false);
		}
		pp.Clickeyeicon();
		Thread.sleep(1000);
		for (int i = 0; i < StoreDashboard.length; i++) {
			UserPage up = new UserPage(driver);

			Thread.sleep(1000);
			up.StoreDashboardButton(StoreDashboard[i]);
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[contains(text(),'Store Dashboard')]")).isDisplayed() == true) {
				if (driver.findElements(By.xpath("//button[contains(text(),'" + StoreDashboard[i] + "')]//following::*[contains(@class,'actionDisable')]")).size() > 0) {
					test.pass("<b><i>Successfully viewd Store </b></i>" + "<b><i>" + StoreDashboard[i] + "</b></i>",extentScreenshot());
					Assert.assertTrue(true);
				} else {
					test.fail("Something wrong!To view the Store " + StoreDashboard[i], extentScreenshot());
					Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong!To view the Store Dashboard", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void F_TC_readOnlyUser_SupportManagement() throws InterruptedException {

		test = extentCreateTest("TC - As a read only user I should be able to view the -->Support Management");
		UserPage up = new UserPage(driver);
		SupportManagement sp = new SupportManagement(driver);

//		gotoTab(driver, 2);
//		bc.PageReload();
//		Thread.sleep(1000);
		up.ClickDotButton();
		Thread.sleep(500);
		//sp.ClickonSupportRequest();
		 sp.ClickonSupportManagement();
		Thread.sleep(500);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[text()='Contact Details']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1
				&& driver.findElements(By.xpath("//th[text()='View']//following::div[contains(@class,'actionDisable')]")).size()<1) {
			Assert.assertTrue(true);
			test.pass("<i><b>Successfully viewd in support request to download XLSX,contact details, create new and view is disabled</i></b>",extentScreenshot());
		} else {
			test.fail("Something wrong!To view on in support request to download XLSX,  create new and view is disabled",extentScreenshot());
			Assert.assertTrue(false);
		}
		
		bc.PageReload();
//		Thread.sleep(1500);
//		up.ClickDotButton();
//		Thread.sleep(500);
//		up.ClickAlertsButton();
//		up.ClickAnnouncementsButton();
//		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
//				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
//			Assert.assertTrue(true);
//			test.pass("Successfully viewd in Announcements create new btn and to download XLSX is disabled",
//					extentScreenshot());
//		} else {
//			test.fail("Something wrong!To view on  Announcements create new btn and to download XLSX is disabled",
//					extentScreenshot());
//			Assert.assertTrue(false);
//		}
//		
//		bc.PageReload();
//		Thread.sleep(1500);
//		up.ClickDotButton();
//		Thread.sleep(500);
//		up.ClickAlertsButton();
//		up.ClickNotificationsButton();
//		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
//				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
//			Assert.assertTrue(true);
//			test.pass("Successfully viewd in Notifications create new btn and to download XLSX is disabled",
//					extentScreenshot());
//		} else {
//			test.fail("Something wrong!To view on  Notifications create new btn and to download XLSX is disabled",
//					extentScreenshot());
//			Assert.assertTrue(false);
//		}
		
	}

	@Test
	public void Fa_TC_readOnlyUser_UserManagement() throws InterruptedException, IOException {

		test = extentCreateTest("TC - As a read only user I should be able to view the -->User Management");
		UserPage up = new UserPage(driver);

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Edit']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass(
					"<b><i>Successfully viewd in access control create new btn and to edit button is disabled</b></i>",
					extentScreenshot());
		} else {
			test.fail("Something wrong!To view on  access control create new btn and to edit button is disabled",
					extentScreenshot());
			Assert.assertTrue(false);
		}

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Edit']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewd in user role create new btn and to edit button is disabled</b></i>",
					extentScreenshot());
		} else {
			test.fail("Something wrong!To view on  user role create new btn and to edit button is disabled",
					extentScreenshot());
			Assert.assertTrue(false);
		}

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		up.ClickOnBack();
		Thread.sleep(1000);

		if (driver.findElements(By.xpath("//button[@title='Create New']")).size() < 1
				&& driver
						.findElements(
								By.xpath("//th[text()='Status']//following::span[contains(@class,'actionDisable')]"))
						.size() > 0
				&& driver.findElements(By.xpath("//button[@title='Edit']")).size() < 1
				&& driver.findElements(By.xpath("//button[@title='Export XLSX']")).size() < 1) {
			Assert.assertTrue(true);
			test.pass(
					"<b><i>Successfully viewd in user profile create new, edit, XLSX and status of user button is disabled</b></i>",
					extentScreenshot());
		} else {
			test.fail(
					"Something wrong!To view on  user profile create new, edit, XLSX and status of user button is disabled",
					extentScreenshot());
			Assert.assertTrue(false);
		}

		LoginPage lp = new LoginPage(driver);

		// openNewTab(driver,AdminURL);
		// gotoTab(driver, 2);
		lp.clickLogout();
		Thread.sleep(2000);
		Adminlogin("systemadmin");
//		bc.CloseCurrentTab();

//		Thread.sleep(15000);	
	}
}
