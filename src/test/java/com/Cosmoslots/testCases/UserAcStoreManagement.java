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
import com.Cosmoslots.pageObjects.SupportManagement;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserAcStoreManagement extends BaseClass {

	BaseClass bc = new BaseClass();

	
	String[] storemanagement = {"Store Profile & Dashboard","Games","Copy Link","Store Maintenance","Invited Players","Meta Data","Home Page","Lobby Info","FAQ","General Pages",
	                         	 "News","Lobby Maintenance","Promotions","General Settings","User Login Footprints Listing","Store Jackpot","Help Player","Net Income",};
	String[] storemanagement1 = {"Custom Package","App Settings","Store Settings","Store Coupon","Store Bonuses",
			                      "Store Package","Website Settings","Tab Access","Sign Up","Withdraw Settings","Corporation Details",
			                      "Store Listing","Contact Us Listing","Chat Listing","Support Request Listing","Lobby Versions",
			                      "Share Request","Basic Details","Player Registration","Token Ledger","Player Custom Package Purchase"};
	
	
	
//	@Test
//	public void A_TC_AdminLogin() throws InterruptedException, IOException {
//		
//		LoginPage lp = new LoginPage(driver);
//
//		openNewTab(driver,AdminURL);
//		gotoTab(driver, 2);
//		lp.clickLogout();
//		Thread.sleep(2000);
//		Adminlogin("gameiumadmin");
//	 		
//		gotoTab(driver, 0);
//		Thread.sleep(2000);
//		bc.PageReload();
//		Thread.sleep(1000);
//		Adminlogin("systemadmin");
//
//	}
		
	@Test
	public void Aa_TC_AccessControlToggleStoreManagement() throws InterruptedException, IOException 
	{
		LobbyPage_Old lp = new LobbyPage_Old(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("Access Control --> Store Management ");

		gotoTab(driver, 0);		
		up.clickUsermanagementButton();
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(4000);
		up.clickToEdit();
		Thread.sleep(500);

		for (int i = 0; i < storemanagement.length; i++) {
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(storemanagement[i]);
			System.out.println("Clicking on " + storemanagement[i]);
		}
		for (int i = 0; i < storemanagement1.length; i++) {
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(storemanagement1[i]);
			up1.AccessControlToggleViewFull(storemanagement1[i]);
			System.out.println("Clicking on " + storemanagement1[i]);
		}
		Thread.sleep(500);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
		//	Assert.assertTrue(true);
			 test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			 test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
		//	Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		
		gotoTab(driver, 2);
		bc.PageReload();
		Thread.sleep(2000);
		test.pass("Successfully closed Store Management Tab", extentScreenshot());
		lp.clicklobbymanagement();
		Thread.sleep(500);
		lp.clickStoreAccounts();
		if (cc.Validation_Format_DonotAccessControl.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass("Successfully closed Store Accounts Access_"+cc.Validation_Format_DonotAccessControl.getText(), extentScreenshot());
		} else {
			//Assert.assertTrue(false);
			test.pass("Something Wrong! To close the Store Accounts Access ", extentScreenshot());
		}
	//	bc.PageReload();
//		gp.Search_Items("STORE8671");
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		test.pass("Successfully closed Custom Package, App Settings, Store Settings, Store Coupon, Store Bonuses, Store Bonuses, Website Settings, Tab Access, Sign Up, Withdraw Settings, Corporation Details, Store Listing Tab", extentScreenshot());

	}

	@Test
	public void B_TC_AccessControlofStoreManagement_StoreListing() throws InterruptedException {
		LobbyPage_Old lp = new LobbyPage_Old(driver);
	
		test = extentCreateTest("Access Control - Store Management -> Store Listing ");

		AccessControlToggle("Store Listing");
		Thread.sleep(1000);
		
		gotoTab(driver, 2);
		bc.PageReload();
		lp.clicklobbymanagement();
		Thread.sleep(500);
		lp.clickStoreAccounts();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[contains(text(),'Store Management')]")).isDisplayed()) {
			test.pass("<b><i>Successfully viewd Store Listing </b></i>", extentScreenshot());
		//	Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Store Listing ", extentScreenshot());
		//	Assert.assertTrue(false);
		}
	}

	@Test
	public void Ba_TC_AccessControlofStoreManagement_Details() throws InterruptedException {
		String[] StoreDashboard = { "Profile", "Packages", "Custom Packages", "Games", "Bonus","Lobby Jackpot","Store Coupon", "Withdraw Settings", "App Settings", "Website Setting","Settings","Corporation Details","Social Media Settings","App Marketing"};
		String[] AC_Store = { "Store Profile & Dashboard", "Store Package", "Custom Package", "Games", "Store Bonuses","Store Jackpot", "Store Coupon", "Withdraw Settings", "App Settings", "Website Settings","Store Settings", "Corporation Details","Social Media Settings","App Marketing",};
		for (int i = 0; i < AC_Store.length; i++) {

			LobbyPage_Old lp = new LobbyPage_Old(driver);
			UserPage up = new UserPage(driver);
			PlayerProfile pp = new PlayerProfile(driver);

			test = extentCreateTest("Access Control - Store Management -> " + StoreDashboard[i]);


			AccessControlToggle(AC_Store[i]);
			Thread.sleep(2000);
			
			gotoTab(driver, 2);
			bc.PageReload();
			Thread.sleep(1000);
			lp.clicklobbymanagement();
			Thread.sleep(1000);
			lp.clickStoreAccounts();
			Thread.sleep(2000);
//		gp.Search_Items("Cosmo-1508");
//		Thread.sleep(1000);
			pp.Clickeyeicon();
			Thread.sleep(1000);
			up.StoreDashboardButton(StoreDashboard[i]);
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[contains(text(),'Store Dashboard')]")).isDisplayed() == true) {
				if (driver.findElement(By.xpath("//button[contains(text(),'" + StoreDashboard[i] + "')]"))
						.isDisplayed() == true) {
					test.pass("<b><i>Successfully viewd Store </b></i>" + "<b><i>" + StoreDashboard[i] + "</b></i>",
							extentScreenshot());
			//		Assert.assertTrue(true);
				} else {
					test.fail("Something wrong!To view the Store " + StoreDashboard[i], extentScreenshot());
			//		Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong!To view the Store Dashboard", extentScreenshot());
			//	Assert.assertTrue(false);
			}
		}

	}

	@Test
	public void C_TC_AccessControlofStoreManagement_WebsiteSettings() throws InterruptedException {
		String[] AC_Store = { "Tab Access", "Sign Up" };
		for (int i = 0; i < AC_Store.length; i++) {

			LobbyPage_Old lp = new LobbyPage_Old(driver);
			UserPage up = new UserPage(driver);
			PlayerProfile pp = new PlayerProfile(driver);

			test = extentCreateTest("Access Control - Store Management - WebsiteSettings -> " + AC_Store[i]);


			AccessControlToggle(AC_Store[i]);
			Thread.sleep(2000);
			
			gotoTab(driver, 2);
			bc.PageReload();
			Thread.sleep(1000);
			lp.clicklobbymanagement();
			Thread.sleep(500);
			lp.clickStoreAccounts();
			Thread.sleep(2000);
//			gp.Search_Items("Cosmo-1508");
//			Thread.sleep(1000);
			pp.Clickeyeicon();
			Thread.sleep(500);
			up.StoreDashboardButton("Website Settings");
			Thread.sleep(1000);
			up.StoreDashboardButton(AC_Store[i]);
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[contains(text(),'Store Dashboard')]")).isDisplayed() == true) {
				if (driver.findElement(By.xpath("//div[contains(text(),'" + AC_Store[i] + "')]"))
						.isDisplayed() == true) {
					test.pass("<b><i>Successfully viewd Store </b></i>" + "<b><i>" + AC_Store[i] + "</b></i>",
							extentScreenshot());
				//	Assert.assertTrue(true);
				} else {
					test.fail("Something wrong!To view the Store " + AC_Store[i], extentScreenshot());
			//		Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong!To view the Store Dashboard", extentScreenshot());
			//	Assert.assertTrue(false);
			}
		}

	}
	
	@Test
	public void G_TC_AccessControlofSettings() throws InterruptedException {
		String[] AC_Settings = {"Lobby Versions","Meta Data","Home Page","Lobby Info","FAQ","General Pages",
			                	 "News","Lobby Maintenance","Promotions","General Settings","Share Request"};
		String[] Settings = {"Lobby Versions","Meta Data","Home Page","Lobby Info","FAQ","General Pages","News",
				              "Lobby Maintenance","Promotion","Settings","Release Notes" };
		
		for (int i = 0; i < AC_Settings.length; i++) {

			UserPage up = new UserPage(driver);
			LoginPage lp= new LoginPage(driver);

			test = extentCreateTest("Access Control - Store -> Settings -> " + AC_Settings[i]);


			AccessControlToggle(AC_Settings[i]);
			Thread.sleep(1000);
			
			gotoTab(driver, 2);
			Thread.sleep(2000);
			bc.PageReload();
			Thread.sleep(1000);
			lp.ClickonUserAdminProfile();
			Thread.sleep(2000);
			up.ClickonSettings();
			Thread.sleep(2000);
			Thread.sleep(2000);
			up.StoreDashboardButton(Settings[i]);
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[contains(text(),'Settings')]")).isDisplayed() == true) {
				if (driver.findElement(By.xpath("//button[contains(text(),'" + Settings[i] + "')]"))
						.isDisplayed() == true) {
					test.pass("<b><i>Successfully viewd Store </b></i>" + "<b><i>" + Settings[i] + "</b></i>",
							extentScreenshot());
					//Assert.assertTrue(true);
				} else {
					test.fail("Something wrong!To view the Store " + Settings[i], extentScreenshot());
				//	Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong!To view the Store Dashboard", extentScreenshot());
				//Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void D_TC_AccessControlofSupportManagement() throws InterruptedException {
		String[] AC_Support = { "Contact Us Listing", "Chat Listing", "Support Request Listing","Help Player" };
		String[] SupportManagement = { "Contact Details", "Chat", "Support Request","Help Player" };

		for (int i = 0; i < AC_Support.length; i++) {
			UserPage up = new UserPage(driver);
			SupportManagement sp = new SupportManagement(driver);

			test = extentCreateTest("TC - Access control Support Management-> " + SupportManagement[i]);

			AccessControlToggle(AC_Support[i]);
			
			gotoTab(driver, 2);
			bc.PageReload();
			Thread.sleep(1000);
			up.ClickDotButton();
			Thread.sleep(500);
			sp.ClickonSupportManagement();
			Thread.sleep(500);
			if (driver.findElement(By.xpath("//button[contains(text(),'" + SupportManagement[i] + "')]"))
					.isDisplayed()) {
				test.pass("<b><i>Successfully viewd on Support Management </b></i>" + "<b><i>" + SupportManagement[i]
						+ "</b></i>", extentScreenshot());
				//Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To view the Support Management " + SupportManagement[i], extentScreenshot());
				//Assert.assertTrue(false);
			}
			bc.PageReload();
		}
	}
	
	@Test
	public void F_TC_AccessControlofUserManagement_Details() throws InterruptedException
	{
		String[] AC_User= {"Basic Details","Player Registration","User Login Footprints Listing","Token Ledger","Player Custom Package Purchase"};
		String[] UserProfile= {"Basic Details","Player Registration","Footprints","Token Ledger","Player Custom Package Purchase"};
		
		for(int i=0;i<AC_User.length;i++) 
		{
			UserPage up = new UserPage(driver);
			PlayerProfile pp = new PlayerProfile(driver);
			
			test = extentCreateTest("TC - Access control User Management-> " + UserProfile[i]);
	
		    AccessControlToggle(AC_User[i]);
		    
		    gotoTab(driver, 2);
		    bc.PageReload();
			Thread.sleep(1000);
		    up.clickUsermanagementButton();
		    Thread.sleep(500);
		    up.clickUserProfile();
		    Thread.sleep(500);
		    up.ClickOnBack();
		    Thread.sleep(1000);
		    pp.Clickeyeicon();
		    Thread.sleep(1000);
		    up.ClickonUserManagementview(UserProfile[i]);
		    Thread.sleep(1000);
		    if (driver.findElement(By.xpath("//button[contains(text(),'" + UserProfile[i] + "')]")).isDisplayed()) {
				test.pass("<b><i>Successfully viewd on User Management </b></i>" + "<b><i>" + UserProfile[i]+ "</b></i>", extentScreenshot());
				//Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To view the User Management " + UserProfile[i], extentScreenshot());
				//Assert.assertTrue(false);
			}
			bc.PageReload();
		    
		}
	}
	
	@Test
	public void Fa_TC_AccessControlofUserManagement_Reports() throws InterruptedException
	{
		String[] UserProfile= {"Net Income","Tips Report"};
		String[] AC_UserProfile= {"Net Income","Tip Reports"};
		for(int i=0;i<UserProfile.length;i++) 
		{
			UserPage up = new UserPage(driver);
			PlayerProfile pp = new PlayerProfile(driver);
			
			test = extentCreateTest("TC - Access control Support Management-> " + UserProfile[i]);
	
		    AccessControlToggle(AC_UserProfile[i]);
		    
		    gotoTab(driver, 2);
		    bc.PageReload();
			Thread.sleep(1000);
		    up.clickUsermanagementButton();
		    Thread.sleep(500); 
		    up.clickUserProfile();
		    Thread.sleep(500);
	        up.ClickOnBack();
            Thread.sleep(1000);
		    pp.Clickeyeicon();
		    Thread.sleep(1000);
		    up.ClickonReportsButton();
		    Thread.sleep(1000);
		    up.StoreDashboardButton(UserProfile[i]);
		    Thread.sleep(1000);
		    if (driver.findElement(By.xpath("//div[contains(text(),'" + UserProfile[i] + "')]")).isDisplayed()) {
				test.pass("<b><i>Successfully viewd on User Management </b></i>" + "<b><i>" + UserProfile[i]+ "</b></i>", extentScreenshot());
				//Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To view the User Management " + UserProfile[i], extentScreenshot());
				//Assert.assertTrue(false);
			}
			bc.PageReload();
		    
		}
	}

	@Test
	public void Fb_TC_AccessControlofGameConfigrator() throws InterruptedException
	{
		String[] AC_GC= {"Game Tools","Game Settings","Slot Game Settings","Keno Game Settings" };
		String[] GameConfigrator= {"Game Tools","Game Settings","Slot Game Settings","Keno Game Settings" };
		
		for(int i=0;i<AC_GC.length;i++) 
		{
			UserPage up = new UserPage(driver);
			PlayerProfile pp = new PlayerProfile(driver);
			
			test = extentCreateTest("TC - Access control User Management-> " + AC_GC[i]);
	
		    AccessControlToggle(AC_GC[i]);
		    
		    gotoTab(driver, 2);
		    bc.PageReload();
			Thread.sleep(1000);
		    up.ClickonGameConfigrator();
		    Thread.sleep(500);
		    up.ClickonGameconfigrator(GameConfigrator[i]);
		    Thread.sleep(500);		    
		    if (driver.findElement(By.xpath("//button[(text()='" + GameConfigrator[i] + "')]")).isDisplayed()) {
				test.pass("<b><i>Successfully viewd on game configrator </b></i>" + "<b><i>" + GameConfigrator[i]+ "</b></i>", extentScreenshot());
				//Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To view the game configrator" + GameConfigrator[i], extentScreenshot());
				//Assert.assertTrue(false);
			}
			bc.PageReload();
		    
		}
	}
	
	public void AccessControlToggle(String str) throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
      	LobbyPage_Old lp= new LobbyPage_Old(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		
        gotoTab(driver, 0);
		up.clickUsermanagementButton();
		Thread.sleep(1000);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
	//	lp.SearchItems("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(3000);
		test.info("controlling Access contol of " + str);
		up.AccessControlToggleViewFull(str);
		logger.info("Clicking on " + str);
		Thread.sleep(2000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			 //Assert.assertTrue(true);
			 test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			 test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			 //Assert.assertTrue(false);
		}
		bc.implicitWait(driver, 15);
	}
	
//	@Test
//	public void Z_TC_AdminLogin() throws InterruptedException, IOException {
////		test = extentCreateTest("Login in Admin");
////		test.info("URL is opened");
////		LoginPage lp = new LoginPage(driver);
////		
////		lp.clickLogout();
////		Thread.sleep(2000);
////		lp.setUserName(username);
////		test.info("Entered username = <b>" + username + "</b>");
////
////		lp.setPassword(password);
////		test.info("Entered password = <b>" + password + "</b>");
////
////		Thread.sleep(1000);
////		lp.clickSubmit();
////
////		Thread.sleep(3000);
////
////		if (driver.findElements(By.xpath("//span[text()=\"Player Management \"]")).size() > 0) {
////			Assert.assertTrue(true);
////			test.pass("Login test passed");
////		} else {
////			captureScreen(driver, "loginTest");
////			Assert.assertTrue(false);
////			test.fail("Login test failed");
////		}
//
//		LoginPage lp = new LoginPage(driver);
//		Thread.sleep(4000);
//		lp.clickLogout();
//		Thread.sleep(2000);
//		
//		Adminlogin(username);
//	}

	

}
