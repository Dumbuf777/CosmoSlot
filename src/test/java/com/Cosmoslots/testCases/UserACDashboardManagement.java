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
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserACDashboardManagement extends BaseClass {
	BaseClass bc = new BaseClass();
	
	@Test
	public void A_TC_AdminLogin() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
	
		openNewTab(driver,AdminURL);
		gotoTab(driver, 2);
		lp.clickLogout();
		Thread.sleep(2000);
		Adminlogin("gameiumadmin");
	 		
		gotoTab(driver, 0);
		Thread.sleep(2000);
		bc.PageReload();
		Adminlogin("systemadmin");
	}
	
	@Test
	public void Aa_TC_AccesContolToggle() throws IOException, InterruptedException {

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("TC - Access control --> Dashboard And Player Management");
		
		String[] DashboardManagement = { "Most Spent Tokens","Player Transaction","Daily Purchase","Player Location","Most Active Games","Most Active Slot Games","Most Active Keno Games","Most Active Fish Games", 
				"Total Game","Latest Withdraw Requests","Most Player Login","Total Purchase","Total Bets","Total Player","Latest Purchase History", 
				"Profile & Dashboard","Reputations","State","Redeemable Tokens","Gender","City","Display Name","Country","Created By",
				"Zip Code","Updated At","Created At","Store","Updated By","Player Deletion History Listing","Sweep Tokens","Game Tokens",
				"Purchase History Listing","Token Details","Transaction History","Guest Player Login Footprints Listing","Guest Player Profile & Dashboard",
				"Player Login Footprints Listing","Keno Jackpot Wins Listing","Slot Jackpot Wins Listing","Charge Back Report Listing"};
		

		String[] Alerts = { "Announcement Listing","Notification Listing","Manage Tokens","Applied Coupons","Email","Phone","Withdraw Request","Game Transaction","Player Support Request",
				"Withdraw Request Listing","Description","Blocked List","By IP","By User Data","Guest Player Listing","Guest Player Support Request","Create New Player","Player Ledger","Customized Daily Login Bonus"};

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(5000);
		up.clickToEdit();
		Thread.sleep(500);
		for (int i = 0; i < Alerts.length; i++) {
			// test.info("controlling Access contol of "+Alerts[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(Alerts[i]);
			up1.AccessControlToggleViewFull(Alerts[i]);
			logger.info("Clicking on " + Alerts[i]);
		}
		for (int i = 0; i < DashboardManagement.length; i++) {
			// .info("controlling Access contol of "+DashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(DashboardManagement[i]);
			logger.info("Clicking on " + DashboardManagement[i]);
		}
//		for (int i = 0; i < profile.length; i++) {
//			// test.info("controlling Access contol of "+profile[i]);
//			UserPage up1 = new UserPage(driver);
//			up1.AccessControlToggleViewFull(profile[i]);
//			logger.info("Clicking on " + profile[i]);
//		}
		Thread.sleep(1000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//	//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		
		gotoTab(driver, 2);
		bc.PageReload();
		Thread.sleep(1000);
		test.pass("<b><i>Successfully closed Dashboard</b></i>", extentScreenshot());
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		test.pass("<b><i>Successfully closed Guest Players,Jacpot wins, Player Deletion History,Blocked List tab</b></i>",extentScreenshot());
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(3000);
		pp.Clickeyeicon();
		Thread.sleep(3000);
		test.pass("<b><i>Successfully closed player profile tab</b></i>", extentScreenshot());
		Thread.sleep(1000);
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickAlertsButton();
		Thread.sleep(500);
		test.pass("<b><i>Successfully closed Alerts</b></i>", extentScreenshot());
		bc.PageReload();
	}
	
	@Test
	public void Ab_TC_AccessControlofAlerts_Notifications() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
		
		test = extentCreateTest("TC - Access control Alerts-> Notifications ");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(2000);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		//lb.SearchItems("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		Thread.sleep(3000);
		test.info("controlling Access contol of Notifications");
		up.AccessControlToggleViewFull("Notification Listing");
		logger.info("Clicking on Notifications");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			 test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			 test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickAlertsButton();
		Thread.sleep(500);
		up.ClickNotificationsButton();
		Thread.sleep(500);
		
		if (driver.findElement(By.xpath(" //h3[contains(text(),'Notifications')]")).isDisplayed()) {
			test.pass("<b><i>Successfully viewd Notifiction Tab <b/></i>", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Notifiction Tab", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Ac_TC_AccessControlofAlerts_Announcements() throws InterruptedException {
		
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		
		test = extentCreateTest("TC - Access control Alerts-> Announcements ");
		
		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(3000);
		test.info("controlling Access contol of Announcements");
		up.AccessControlToggleViewFull("Announcement Listing");
		logger.info("Clicking on Announcements");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control",extentScreenshot());
			//Assert.assertTrue(false);
		}
		
		bc.implicitWait(driver, 5);
		
		gotoTab(driver, 2);
		bc.PageReload();
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickAlertsButton();
		Thread.sleep(500);
		up.ClickAnnouncementsButton();
		if (driver.findElement(By.xpath(" //h3[contains(text(),'Announcement')]")).isDisplayed()) {
			test.pass("<b><i>Successfully viewd Announcements Tab </b></i>", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Announcements tab", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void B_TC_AccessControlofDashboardManagement() throws InterruptedException {
		
		String[] DashboardManagement = { "Total Purchase", "Total Player", "Total Game", "Total Bets" };

		test = extentCreateTest("TC - Access control--> Dashboard Management ");
		
		for (int i = 0; i < DashboardManagement.length; i++) {
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			
			gotoTab(driver, 0);
			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickAccessControl();
			Thread.sleep(1000);
			gp.Search_Items("GAMEIUM_ADMIN");
			Thread.sleep(2000);
			up.clickToEdit();
			Thread.sleep(500);
			test.info("Access contol of " + DashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(DashboardManagement[i]);
			logger.info("Clicking on " + DashboardManagement[i]);
			Thread.sleep(1000);
			up.clickToSave();
			Thread.sleep(1000);
			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				////Assert.assertTrue(true);
				 test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
			} else {
				 test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				//Assert.assertTrue(false);
			}
			bc.implicitWait(driver, 15);
			
			gotoTab(driver, 2);
			bc.PageReload();
			up.ClickOnDashboard();
			if (driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")) != null) {
				if (driver.findElement(By.xpath(" //h5[contains(text(),'"+DashboardManagement[i]+"')]")).isDisplayed()) {
					test.pass("<b><i>Successfully viewed on Dashboard is </b></i>" +"<b><i>"+ DashboardManagement[i]+"</b></i>",extentScreenshot());
					//Assert.assertTrue(true);
				}
			} else {
				test.fail("Something wrong!To close the Dashboard tab", extentScreenshot());
				//Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void Ba_TC_AccessControlofDashboardManagement() throws InterruptedException {
		
		String[] ACDashboardManagement = { "Most Spent Tokens", "Player Transaction", "Daily Purchase",
				"Player Location", "Latest Withdraw Requests", "Most Player Login","Latest Purchase History","Most Active Slot Games","Most Active Keno Games","Most Active Fish Games" };
		
		String[] DashboardManagement = { "Daily Bets", "Player Transaction", "Daily Purchases",
				"Player Location","Latest Withdraw Requests", "Most Player Login","Latest Purchase History","Most Active Slot Games","Most Active Keno Games","Most Active Fish Games"  };
		
		test = extentCreateTest("TC - Access control--> Dashboard Management ");
		
		for (int i = 0; i < DashboardManagement.length; i++) {
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			
			gotoTab(driver, 0);
			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickAccessControl();
			Thread.sleep(1000);
			gp.Search_Items("GAMEIUM_ADMIN");
			Thread.sleep(2000);
			up.clickToEdit();
			Thread.sleep(500);
			test.info("controlling Access contol of " + ACDashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(ACDashboardManagement[i]);
			logger.info("Clicking on " + ACDashboardManagement[i]);
			Thread.sleep(1000);
			up.clickToSave();
			Thread.sleep(1000);
			
			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				 //Assert.assertTrue(true);
				 test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
			} else {
				 test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				 //Assert.assertTrue(false);
			}
			bc.implicitWait(driver, 15);

			gotoTab(driver, 2);
			bc.PageReload();
			up.ClickOnDashboard();
			if (driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")) != null) {
				if (driver.findElement(By.xpath(" //h4[contains(text(),'" + DashboardManagement[i] + "')]")).isDisplayed())
				{
					test.pass("<b><i>Successfully viewed on dashboard is </b></i>" + "<b><i>" + DashboardManagement[i]+ "</b></i>", extentScreenshot());
					//Assert.assertTrue(true);
				}

			} else {
				test.fail("Something wrong!To view on Dashboard", extentScreenshot());
				//Assert.assertTrue(false);
			}
		}
	}
			
	@Test
    public void C_TC_AccessControlofPlayerManagement_PlayerProfile() throws InterruptedException
	 {
		String[] PlayerProfile= {"Profile","Manage Tokens","Purchases","Applied Coupons","Withdraw Request",
				                 "Token Details","Transaction History","Game Transactions","Support Request","Footprints","Player Ledger","Customized Login Bonus"};
		
		String[] AC_Player= {"Profile & Dashboard","Manage Tokens","Purchase History Listing","Applied Coupons","Withdraw Request",
				             "Token Details","Transaction History","Game Transaction","Player Support Request","Player Login Footprints Listing","Player Ledger","Customized Daily Login Bonus",};
		
	   for(int i=0;i<AC_Player.length;i++) {
		   
		LobbyPage lp= new LobbyPage(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		
		test= extentCreateTest("TC - Access control ->Player Profile _"+PlayerProfile[i]);
		
		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(3000);
		up.clickToEdit();
		Thread.sleep(1000);
		up.AccessControlToggleViewFull(AC_Player[i]);
		test.info("Successfully ON --> "+AC_Player[i]);
		Thread.sleep(500);
		up.clickToSave();
		Thread.sleep(1000);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
//		} else {
//			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
		//bc.implicitWait(driver, 15);
		Thread.sleep(5000);
		
		gotoTab(driver, 2);
		bc.PageReload();
		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		up.ClickonPlayerProfileButton(PlayerProfile[i]);
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[contains(text(),'View Player Details')]")).isDisplayed() == true) {
			if (driver.findElement(By.xpath("//button[contains(text(),'" + PlayerProfile[i] + "')]")).isDisplayed() == true) {
				test.pass("<b><i>Successfully viewd player  </b></i>" + "<b><i>"+ PlayerProfile[i] +"</b></i>",extentScreenshot());
				//Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To view the Player " + PlayerProfile[i], extentScreenshot());
				//Assert.assertTrue(false);
			}
		} else {
			test.fail("Something wrong!To view the Player Profile", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
  }
	
	@Test
	public void Ca_TC_AccessControlofPlayerManagement_PlayerProfileDetails() throws InterruptedException {
		String[] profile = { "Reputations", "State", "Gender", "City", "Display Name", "Country", "Phone", "Email",
				"Created By", "Zip Code", "Updated At", "Created At", "Store", "Updated By", };
		
		test = extentCreateTest("TC - Access control ->PlayerProfile Details");

		
		for (int i = 0; i < profile.length; i++) {
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			PlayerProfile pp = new PlayerProfile(driver);
			
			gotoTab(driver, 0);
			up.clickUsermanagementButton();
			Thread.sleep(1000);
			up.clickAccessControl();
			Thread.sleep(1000);
			gp.Search_Items("GAMEIUM_ADMIN");
			Thread.sleep(4000);
			up.clickToEdit();
			Thread.sleep(3000);
			logger.info("Clicking on " + profile[i]);
			up.AccessControlToggleViewFull(profile[i]);
			bc.implicitWait(driver, 3);
			up.clickToSave();
			Thread.sleep(500);
//			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//				//Assert.assertTrue(true);
//			    test.pass("" + cc.Validation_Format_AccessControl,extentScreenshot());
//			} else {
//				test.fail("Something Wrong ! not able to Save access control",extentScreenshot());
//				//Assert.assertTrue(false);
//			}
			//bc.implicitWait(driver, 15);
			Thread.sleep(5000);
			
			gotoTab(driver, 2);
			bc.PageReload();
			Thread.sleep(2000);
			pp.clickOnPlayerManagement();
			Thread.sleep(500);
			pp.clickOnPlayerProfile();
			Thread.sleep(3000);
			pp.Clickeyeicon();
			Thread.sleep(4000);
			if (driver.findElements(By.xpath("//span[contains(text(),'"+profile[i]+"')]")).size()>0) {
				test.pass("<b><i>Successfully viewed in Player Profile </b></i>" + profile[i], extentScreenshot());
				//Assert.assertTrue(true);

			} else {
				test.fail("Something wrong!To views the player profile ", extentScreenshot());
				//Assert.assertTrue(false);
			}
		}
	}
	
	@Test
	public void Cb_TC_AccessControlofPlayerManagement_PlayerProfile_RedeemableTokens() throws InterruptedException {
		
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control ->Player Profile Redeemable Tokens");
		
		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		Thread.sleep(3000);
		logger.info("Clicking on Redeemable Tokens ");
		up.AccessControlToggleViewFull("Redeemable Tokens");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl,extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control",extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[contains(text(),'Redeemable Tokens')]")).isDisplayed()) {
			test.pass("Successfully viewed in  Player Profile Redeemable Tokens	", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To views the player profile Redeemable Tokens ", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void D_TC_AccessControlofPlayerManagement_PlayerProfile_PlayerLedgerST() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Player Ledger Sweep Tokens");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Sweep Tokens");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("shrikrushna sonkar");
		Thread.sleep(2000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		pp.clickPlayerLedgerTab();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='Token Type']/following::tr//td[contains(text(),'Sweep Tokens')]")).isDisplayed()) {
			test.pass("Successfully viewed player profile Sweep Tokens", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To views the Profile Manage Tokens tab", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void Da_TC_AccessControlofPlayerManagement_PlayerProfile_PlayerLedgerGT() throws InterruptedException {
		// String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Player Ledger Game Tokens");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Game Tokens");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("shrikrushna sonkar");
		Thread.sleep(2000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		pp.clickPlayerLedgerTab();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='Token Type']/following::tr//td[contains(text(),'Game Tokens')]"))
				.isDisplayed()) {
			test.pass("Successfully viewed player ledger Game Tokens", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the player ledger Game Tokens tab", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void E_TC_AccessControlofPlayerManagement_BlockedList() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Blocked List");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Blocked List");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		up.ClickBlockedListButton();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//button[contains(text(),'Blocked List')]")).isDisplayed()) {
			test.pass("<b><i>Successfully viewed Blocked List</b></i>", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Blocked List", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.PageReload();
	}

	@Test
	public void Ea_TC_AccessControlofPlayerManagement_ByUserData() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> blocked By User Data");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("By User Data");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		up.ClickBlockedListButton();
		Thread.sleep(500);
		up.ClickByUserButton();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Blocked Player Data')]")).isDisplayed()) {
			test.pass("Successfully viewed Blocked IP List", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Blocked IP List", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.PageReload();
	}

	@Test
	public void Eb_TC_AccessControlofPlayerManagement_ByIP() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Blocked IP List");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("By IP");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		up.ClickBlockedListButton();
		Thread.sleep(500);
		up.ClickByIPTabButton();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Blocked IP List')]")).isDisplayed()) {
			test.pass("Successfully viewed Blocked IP List", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Blocked IP List", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void F_TC_AccessControlofPlayerManagement_JackpotWins() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		test = extentCreateTest("TC - Access control Player Management-> Jackpot Wins");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Keno Jackpot Wins Listing");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		up.ClickJackpotWinsButton();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Jackpot Wins')]")).isDisplayed()) {
			test.pass("Successfully viewed Jackpot Wins", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the player Jackpot Wins", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void Fa_TC_AccessControlofPlayerManagement_PlayerDeletionHistory() throws InterruptedException {
		// String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Player Deletion History Listing");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Player Deletion History Listing");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
			//Assert.assertTrue(false);
		}
        bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		ph.clickOnPlayerDeletionHistory();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Player Deletion History')]")).isDisplayed()) {
			test.pass("Successfully viewed Player Deletion History ", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Player Deletion History ", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void G_TC_AccessControlofPlayerManagement_GuestPlayers() throws InterruptedException {
		
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Guest Players");
		
		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Guest Player Listing");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			//Assert.assertTrue(false);
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Guest Players')]")).isDisplayed()) {
			test.pass("Successfully viewed Guest Players ", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Guest Players ", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void Gc_TC_AccessControlofPlayerManagement_GuestPlayerLoginFootprintsListing() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Guest Player Login Footprints Listing");

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Guest Player Login Footprints Listing");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			// test.pass("" + cc.Validation_Format_AccessControl);
		} else {
			// test.fail("Something Wrong ! not able to Save access control");
			//Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		gp.Clickeyeicon();
		Thread.sleep(500);
		gp.ClickOnGuestPlayerLoginFootprints();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Footprints')]")).isDisplayed()) {
			test.pass("Successfully viewed Guest Player Login Footprints Listing ", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Guest Player Login Footprints Listing ", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Ga_TC_AccessControlofPlayerManagement_GuestPlayerProfileDashboard() throws InterruptedException {
		// String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Guest Player Profile & Dashboard");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Guest Player Profile & Dashboard");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		gp.Clickeyeicon();
		Thread.sleep(500);
		gp.ClickOnGuestPlayerProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).isDisplayed()) {
			test.pass("Successfully viewed Guest Player Profile & Dashboard", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To views the Guest Player Profile & Dashboard", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Gb_TC_AccessControlofPlayerManagement_GuestPlayerSupportRequest() throws InterruptedException {
		// String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Guest Player Support Request");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Guest Player Support Request");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control",extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		gp.Clickeyeicon();
		Thread.sleep(500);
		gp.ClickOnSupportRequest();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Support Request')]")).isDisplayed()) {
			test.pass("Successfully viewed Guest Player Support Request", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To views the Guest Player Support Request", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
		
//	@Test
//	public void Gd_TC_AccessControlofPlayerManagement_GuestCreateNewPlayer() throws InterruptedException {
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		PurchaseHistory ph = new PurchaseHistory(driver);
//		
//		test = extentCreateTest("TC - Access control Player Management-> Guest Create New Player");
//
//		gotoTab(driver, 0);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(4000);
//		up.clickToEdit();
//		bc.implicitWait(driver, 5);
//		up.AccessControlToggleFull("Create New Player");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			test.pass("" + cc.Validation_Format_AccessControl,  extentScreenshot());
//		} else {
//			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 15);
//		
//		gotoTab(driver, 2);
//		bc.PageReload();
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		gp.ClickOnGuestPlayers();
//		Thread.sleep(1000);
//		Thread.sleep(500);
//		if (driver.findElement(By.xpath("//h3[contains(text(),'Create Player')]")).isDisplayed()) {
//			test.pass("Successfully viewed Guest Create New Player", extentScreenshot());
//			//Assert.assertTrue(true);
//
//		} else {
//			test.fail("Something wrong!To views the Guest Create New Player", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
	
	@Test
	public void H_TC_AccessControlofPlayerManagement_WithdrawRequest() throws InterruptedException {

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Withdraw Request Listing");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Withdraw Request Listing");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed()==true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Save access control", extentScreenshot());
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
			
		if (driver.findElements(By.xpath("//button[contains(text(),'Withdraw Requests')]")).size()>0) {
			test.pass("<b><i>Successfully viewed Withdraw Requests Tab</b></i>", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Withdraw Requests", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Ha_TC_AccessControlofPlayerManagement_WithdrawRequestDescription() throws InterruptedException {

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		WithdrawRequest wr= new WithdrawRequest(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test = extentCreateTest("TC - Access control Player Management-> Withdraw Request Description");

		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		bc.implicitWait(driver, 5);
		up.AccessControlToggleViewFull("Description");
		bc.implicitWait(driver, 3);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed()==true) {
			//Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl);
		} else {
			test.fail("Something Wrong ! not able to Save access control");
			//Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
		
		gotoTab(driver, 2);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		wr.clickwithdrawrequest();
		Thread.sleep(5000);

		if (driver.findElements(By.xpath("(//button[@title='Description'])[1]")).size()>0) {
			test.pass("<b><i>Successfully viewed Withdraw Requests Description Tab</b></i>", extentScreenshot());
			//Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Withdraw Requests Description", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	
//	@Test
//	public void Z_TC_AdminLogin() throws InterruptedException, IOException {
//		LoginPage lp = new LoginPage(driver);
//		Thread.sleep(4000);
//		lp.clickLogout();
//		Thread.sleep(2000);
//		
//		Adminlogin(username);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	@Test
//	public void D_TC_AccessControlofPlayerManagement_PlayerProfile_ManageTokens() throws InterruptedException {
//		test = extentCreateTest("TC - Access control ->Player Profile Manage Tokens");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Manage Tokens ");
//		up.AccessControlToggleViewFull("Manage Tokens");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickManageTokens();
//		Thread.sleep(500);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Manage Tokens')]")).isDisplayed()) {
//			test.pass("<b><i>Successfully viewed in player profile Manage Tokens </b><i>", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player profile Manage Tokens ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Dc_TC_AccessControlofPlayerManagement_PlayerLoginFootprints() throws InterruptedException {
//		test = extentCreateTest("TC - Access control ->Player Login Footprints Listing");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Player Login Footprints Listing");
//		up.AccessControlToggleViewFull("Player Login Footprints Listing");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		pp.clickOnLoginFootprints();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Login Footprints')]")).isDisplayed()) {
//			test.pass("Successfully viewed in player profile Manage Tokens	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player profile Manage Tokens ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Dd_TC_AccessControlofPlayerManagement_TokenDetails() throws InterruptedException {
//		test = extentCreateTest("TC - Access control ->Token Details");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Token Details");
//		up.AccessControlToggleViewFull("Token Details");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickTokenDetailsTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Token Details')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player profile Token Details	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player profile Token Details ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void De_TC_AccessControlofPlayerManagement_TransactionHistory() throws InterruptedException {
//		test = extentCreateTest("TC - Access control ->Transaction History");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Transaction History");
//		up.AccessControlToggleViewFull("Transaction History");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickTansactionHistoryTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Transaction History')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player profile Transaction History	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player profile Transaction History ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Df_TC_AccessControlofPlayerManagement_PurchaseHistory() throws InterruptedException {
//		test = extentCreateTest("TC - Access control -> Purchase History");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Purchase History Listing");
//		up.AccessControlToggleViewFull("Purchase History Listing");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickPurchaseHistoryTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Purchase History')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player profile Purchase History	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player profile Purchase History ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void De_TC_AccessControlofPlayerManagement_AppliedCoupons() throws InterruptedException {
//		test = extentCreateTest("TC - Access control -> Applied Coupons");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Applied Coupons");
//		up.AccessControlToggleViewFull("Applied Coupons");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickAppliedCouponsTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Applied Coupons')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player Applied Coupons	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player Applied Coupons ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Df_TC_AccessControlofPlayerManagement_WithdrawRequest() throws InterruptedException {
//		test = extentCreateTest("TC - Access control -> Withdraw Request");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Withdraw Request");
//		up.AccessControlToggleViewFull("Withdraw Request");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickWithdrawRequestTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Withdraw Request')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player details Withdraw Request	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player details Withdraw Request", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Dg_TC_AccessControlofPlayerManagement_GameTransaction() throws InterruptedException {
//		test = extentCreateTest("TC - Access control -> Game Transaction");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Game Transaction");
//		up.AccessControlToggleViewFull("Game Transaction");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickGameTransactionsTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Game Transactions')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player details Game Transaction	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player details Game Transaction", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void Dh_TC_AccessControlofPlayerManagement_SupportRequest() throws InterruptedException {
//		test = extentCreateTest("TC - Access control -> Support Request");
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
////		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		logger.info("Clicking on Player Support Request");
//		up.AccessControlToggleViewFull("Player Support Request");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		Thread.sleep(2000);
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		bc.PageReload();
//		pp.clickSupportRequestTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Support Request')]")).isDisplayed()) {
//			test.pass("Successfully viewed in  player details Support Request	", extentScreenshot());
//			//Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To views the player details Support Request", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//
//	@Test
//	public void E_TC_AccessControlofPlayerManagement_PlayerProfile_PlayerLedger() throws InterruptedException {
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		
//		test = extentCreateTest("TC - Access control Player Management-> Player Ledger");
//		
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
//		bc.implicitWait(driver, 5);
//		up.AccessControlToggleViewFull("Player Ledger");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl.getText());
//		} else {
//			// test.fail("Something Wrong ! Not able to save access control");
//			//Assert.assertTrue(false);
//		}
//		bc.implicitWait(driver, 5);
//		bc.PageReload();
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(500);
//		pp.clickPlayerLedgerTab();
//		Thread.sleep(1000);
//		if (driver.findElement(By.xpath("//button[contains(text(),'Player Ledger')]")).isDisplayed()) {
//			test.pass("Successfully viewed player profile Manage Tokens  ", extentScreenshot());
//			//Assert.assertTrue(true);
//
//		} else {
//			test.fail("Something wrong!To views the Profile Manage Tokens tab", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
//	@Test
//	public void C_TC_AccessControlofPlayerManagement_PlayerListing() throws InterruptedException {
//		test = extentCreateTest("TC - Access control Player Management-> Player Profile");
//		// String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
//		UserPage up = new UserPage(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp = new PlayerProfile(driver);
//		PurchaseHistory ph = new PurchaseHistory(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickAccessControl();
//		Thread.sleep(1000);
//		gp.Search_Items("GAMEIUM_ADMIN");
//		Thread.sleep(2000);
//		up.clickToEdit();
//		bc.implicitWait(driver, 5);
//		up.AccessControlToggleViewFull("Player Listing");
//		bc.implicitWait(driver, 3);
//		up.clickToSave();
//		Thread.sleep(500);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			//Assert.assertTrue(true);
//			// test.pass("" + cc.Validation_Format_AccessControl);
//		} else {
//			// test.fail("Something Wrong ! not able to Save access control");
//			//Assert.assertTrue(false);
//		}
//		Thread.sleep(5000);
//		bc.PageReload();
//		pp.clickOnPlayerManagement();
//		Thread.sleep(500);
//		if (driver.findElements(By.xpath("//button[contains(text(),'Player Profile')]")).size()>0) {
//			test.pass("Successfully viewed Player Profile ", extentScreenshot());
//			//Assert.assertTrue(true);
//
//		} else {
//			test.fail("Something wrong!To views the Player Profile ", extentScreenshot());
//			//Assert.assertTrue(false);
//		}
//	}
	
}
