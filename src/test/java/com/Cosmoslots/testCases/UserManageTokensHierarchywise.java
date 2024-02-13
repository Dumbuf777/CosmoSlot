/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.SupportManagement;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserManageTokensHierarchywise extends BaseClass {
	BaseClass bc = new BaseClass();
	String Upload_Icon = UploadImage;
	String packge = "COSMO50";
	String Username[] = { GameiumUsername, MasterUsername, DistributorUsername, SubdistributorUsername, StoreUsername,POSUsername };
	String Search[] = { "Gameiumadmin", "Master Admin", "Cosmoslot Distributor", "Cosmoslot Subdistributor","Cosmoslot Store", "cosmoslotPos" };
	String[] month = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	String[] endDate = { "31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31" };
	String paymentmethod = "Manual";
	String GT = "1";
	String ST = "1";

	@Test
	public void A_TC_ManageTokensFromUsers_AddTokens() throws InterruptedException, IOException {
		LoginPage lp1 = new LoginPage(driver);

		test = extentCreateTest("Add user tokens hiereachywise");
		test.info("TC - As an admin user I should be able manage tokens from users");
		gotoTab(driver, 0);
		for (int i = 0; i < Username.length; i++) {

			PlayerProfile pp = new PlayerProfile(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			LoginPage lp = new LoginPage(driver);

			test = extentCreateTest("Add Tokens from users-->" + Search[i]);

			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickUserProfile();
			Thread.sleep(500);
			up.ClickOnBack();
			Thread.sleep(1000);
			gp.Search_Items(Search[i]);
			test.info("User Search = <b>" + Search[i] + "</b>", extentScreenshot());
			Thread.sleep(3000);
			up.ClickonManageTokensSymbol();
			Thread.sleep(2000);
			up.ClickonCreateNewBtn();
			Thread.sleep(1000);
			up.ClickonAddTokenRadioBtn();
			test.info("Selected Add Token radio button");
			Thread.sleep(500);
			up.SelectAmount("1");
			test.info("Entered Amount");
			Thread.sleep(500);
			up.SelectGameTokens(GT);
			test.info("Entered Game Tokens");
			Thread.sleep(500);
			up.SelectSweepTokens(ST);
			test.info("Entered Sweep Tokens");
			Thread.sleep(500);
			pp.selectPaymentMethod(paymentmethod);
			test.info("Selected payment Method is " + paymentmethod);
			Thread.sleep(1000);
			up.ClickonNote("Test");
			Thread.sleep(2000);
			up.clickToSave();
			Thread.sleep(500);

			if (cc.Validation_Format_ManageTokens_saved.isDisplayed() == true) {
				//Assert.assertTrue(true);
				test.pass(cc.Validation_Format_ManageTokens_saved.getText() + " for " + "<b><i>" + Search[i] + "</b></i>",extentScreenshot());
			} else {
				test.fail("Something Wrong ! Not able to manage tokens", extentScreenshot());
				//Assert.assertTrue(false);
			}
			Thread.sleep(6000);
			lp.clickLogout();
			Adminlogin(Username[i]);
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
		lp1.clickLogout();
		Adminlogin(username);
	}

//	@Test
	public void Aa_TC_ManageTokensFromUsers_WithdrawTokens() throws InterruptedException, IOException {

		LoginPage lp1 = new LoginPage(driver);
		test = extentCreateTest("Withdraw tokens from user");
		test.info("TC - As an admin user I should be able withdraw tokens from users ->Gameiumadmin to Systemadmin");

		for (int i = 0; i < Username.length; i++) {

			CommonCosmo cc = new CommonCosmo(driver);
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			LoginPage lp = new LoginPage(driver);

			test = extentCreateTest("Manage tokens from user to -->" + Search[i]);

			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickUserProfile();
			Thread.sleep(500);
			up.ClickOnBack();
			Thread.sleep(1000);
			gp.Search_Items(Search[i]);
			Thread.sleep(3000);
			up.ClickonManageTokensSymbol();
			Thread.sleep(2000);
			up.ClickonCreateNewBtn();
			Thread.sleep(1000);
			up.ClickonWithdrawTokensRadioBtn();
			test.info("Selected withdraw Token radio button");
			Thread.sleep(500);
			up.SelectGameTokens("1");
			test.info("Entered Game Tokens");
			Thread.sleep(500);
			up.SelectSweepTokens("1");
			test.info("Entered Sweep Tokens");
			Thread.sleep(500);
			up.ClickonNote("Test");
			Thread.sleep(2000);
			up.clickToSave();
			Thread.sleep(500);
			if (cc.Validation_Format_ManageTokens_saved.isDisplayed() == true) {
				//Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_ManageTokens_saved.getText() + " for " + "<b><i>" + Search[i]
						+ "</b></i>", extentScreenshot());
			} else if (cc.Validation_Format_UnsafficientTokens.isDisplayed() == true) {
				test.fail("" + cc.Validation_Format_UnsafficientTokens.getText() + " for " + "<b><i>" + Search[i]
						+ "</b></i>", extentScreenshot());
				//Assert.assertTrue(true);
				Thread.sleep(2000);
				up.ClicktoClose();
			} else {
				test.fail("Something Wrong ! Not able to manage tokens", extentScreenshot());
				//Assert.assertTrue(false);
			}
			Thread.sleep(6000);
			lp.clickLogout();
			Adminlogin(Username[i]);
			Thread.sleep(3000);
		}
		Thread.sleep(2000);
		lp1.clickLogout();
		Adminlogin(username);

	}
	
	@Test
	public void B_TC_UserProfile_Reports_GenerateNetIncome() throws InterruptedException {

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		test = extentCreateTest("Generate net income report");
		test.info("TC - As an admin user I should be able to generate net income reports in users");

		up.clickUsermanagementButton();
		Thread.sleep(1000);
		up.clickUserProfile();
		Thread.sleep(1000);
		up.ClickOnBack();
		Thread.sleep(1000);
		gp.Search_Items("cosmoslotpos");
		Thread.sleep(2000);
		up.clickToView();
		Thread.sleep(2000);
		up.ClickonReportsButton();
		Thread.sleep(1000);
		up.ClickonNetIncomeButton();
		test.info("Selected Net Income ");
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate();
		test.info("Selected from to date ", extentScreenshot());
		Thread.sleep(500);
		up.ClickonGenerateNetIncomeReports();
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//th[text()='From Date']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viewd from date in generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To view From Date in generate net income reports");
		}
		if (driver.findElement(By.xpath("//th[text()='To Date']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed To Date in generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To view To Date generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Daily Extra (ST)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Total Purchase (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Total Redeem (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed total redeem in generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net income reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Net Income (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed Net income in generated net income reports", extentScreenshot());
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports", extentScreenshot());
		}
		
		

	}
	
	@Test
	public void Ba_TC_UserProfile_Reports_GenerateNetIncome() throws InterruptedException {

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		test = extentCreateTest("TC - As an admin user I should be able to generate net income reports in users");

		up.clickUsermanagementButton();
		Thread.sleep(1000);
		up.clickUserProfile();
		Thread.sleep(1000);
		up.ClickOnBack();
		Thread.sleep(1000);
		gp.Search_Items("cosmoslotpos");
		Thread.sleep(2000);
		up.clickToView();
		Thread.sleep(2000);
		up.ClickonReportsButton();
		Thread.sleep(1000);
		up.ClickonNetIncomeButton();
		test.info("Selected Net Income ");
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate();
		test.info("Selected from to date ", extentScreenshot());
		Thread.sleep(500);
		up.ClickonGenerateNetIncomeReports();
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//th[text()='From Date']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viewd from date in generated net income reports" );
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To view From Date in generate net income reports");
		}
		if (driver.findElement(By.xpath("//th[text()='To Date']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed To Date in generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To view To Date generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Daily Extra (ST)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Total Purchase (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Total Redeem (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed total red generated net income reports");
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net income reports");
		}
		if (driver.findElement(By.xpath("//th[text()='Net Income (in $)']")).isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully viwed Net income in generated net income reports", extentScreenshot());
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate net incone reports", extentScreenshot());
		}
		
		

	}

	@Test
	public void Bb_TC_UserProfile_Reports_DownloadXLSXGeneratedNetIncome() throws InterruptedException {
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("TC - As an admin user I should be able to download XLSX of generated net income reports");

		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='From Date']")) != null) {
			gp.clickXlsxButton();
			Thread.sleep(1000);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX downloaded of generated net income reports", extentScreenshot());
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To XLSX Download of generated net income reports", extentScreenshot());
				Assert.assertTrue(false);
			}
		} else {
			test.fail("Something wrong!To XLSX Download of generated net income reports", extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void C_TC_UserProfile_Reports_GenerateTipsReport() throws InterruptedException {
		// String[] month =
		// {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		// String[] endDate =
		// {"31","28","31","30","31","30","31","31","30","31","30","31"};

		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("TC - As an admin user I should be able to generate tip reports in users");

//		up.clickUsermanagementButton();
//		Thread.sleep(1000);
//		up.clickUserProfile();
//		Thread.sleep(1000);
//		gp.Search_Items("Cosmoslots Store");
//		Thread.sleep(2000);
//		up.clickToView();
//		Thread.sleep(2000);
//		up.ClickonReportsButton();
		Thread.sleep(1000);
		up.ClickonTipsReportButton();
		test.info("Selected tips report ");
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate();
		test.info("Selected from to date ", extentScreenshot());
		Thread.sleep(1000);
		up.ClickonGenerateTipsReports();
		Thread.sleep(1000);

//		if (driver.findElement(By.xpath("//th[text()='From Date']")).isDisplayed()) {
//			Assert.assertTrue(true);
//			test.pass("Successfully generated net income reports", extentScreenshot());
//		} else 
		if (cc.Validation_Format_Tipsarenotfound.isDisplayed()) {
			Assert.assertTrue(true);
			test.pass("Successfully Tips are not found", extentScreenshot());
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong ! To generate Tips reports", extentScreenshot());
		}

	}

//	@Test
	public void Ca_TC_UserProfile_Reports_DownloadXLSXGeneratedTipsReports() throws InterruptedException {
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("TC - As an admin user I should be able to download XLSX of generated tips reports");

		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='From Date']")) != null) {
			gp.clickXlsxButton();
			Thread.sleep(1000);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX downloaded of generated tips reports", extentScreenshot());
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong!To XLSX Download of generated tips reports", extentScreenshot());
				Assert.assertTrue(false);
			}
		} else {
			test.fail("Something wrong!To XLSX Download of generated tips reports", extentScreenshot());
			Assert.assertTrue(false);
		}

	}
	
	@Test
	public void D_TC_UserProfile_GenerateMySkrillBalance() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp= new GuestPlayers(driver);
		
		test = extentCreateTest("TC - As an admin user I should be able to generate my skrill balance in distributor user");
		
		Thread.sleep(1000);
		up.ClickOnBack();
		Thread.sleep(1000);
		gp.Search_Items("Cosmoslot Distributor");
		Thread.sleep(2000);
		up.clickToView();
		Thread.sleep(2000);
		up.ClickonReportsButton();
		Thread.sleep(1000);
		up.ClickonMySkrillBalance();
		test.info("Selected My Skrill Balance ");
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate();
		Thread.sleep(500);
		up.ClickonGenerateMyBalance();
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("//span[text()='Current Skrill Balance']")).size() > 0 &&
				driver.findElements(By.xpath("//span[text()='Deposited Skrill Amount']")).size() > 0 &&
				driver.findElements(By.xpath("//span[text()='Skrill Purchase Amount']")).size() > 0 &&
				driver.findElements(By.xpath("//span[text()='Skrill Withdraw Amount']")).size() > 0 )  {
			test.pass("Successfully  generated my skrill balance in distributor user", extentScreenshot());
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To  generate my skrill balance in distributor user", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}
	
	
	
	
	
	
	
//	@Test
//	public void Cc_TC_UserProfile_Edit() throws InterruptedException {
//		
//		CommonCosmo cc = new CommonCosmo(driver);
//		PlayerProfile pp= new PlayerProfile(driver);
//		GuestPlayers gp = new GuestPlayers(driver);
//		UserPage up = new UserPage(driver);
//		
//		pp.clickOnPlayerManagement();
//		Thread.sleep(1000);
//		pp.clickOnPlayerProfile();
//		Thread.sleep(1000);
//		gp.Search_Items("Rembrandt Parker");
//		Thread.sleep(1000);
//		pp.Clickeyeicon();
//		Thread.sleep(2000);
//		pp.clickTokenDetailsTab();
//		Thread.sleep(1000);
//		String TotalST = driver.findElement(By.xpath("(//div[@class=\"tokenDetailsAmount\"])[1]")).getText();
//		//TotalST.replaceAll(TotalST, ",");
//
//        pp.clickManageTokens();
//        pp.ClickOnCreateNew();
//      //  pp.SetNewsicon(Upload_Icon);
//		Thread.sleep(3000);
//		pp.selectPackage(packge);
//		Thread.sleep(1000);
//		String PkgST = driver.findElement(By.xpath("//input[@formcontrolname=\"gameTokens\"]")).getText();
//		//System.out.println("Package ST = "+PkgST);
//		String pkgGT = driver.findElement(By.xpath("//input[@formcontrolname=\"sweepTokens\"]")).getText();
//		//System.out.println("Package ST = "+pkgGT);
//		String Amt = driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).getText();
//		//System.out.println("Package ST = "+Amt);
//
//		pp.selectPaymentMethod(paymentmethod);
//		Thread.sleep(1000);
//		up.ClickonNote("Test");
//		Thread.sleep(1000);
//		pp.ClickSave();
//		Thread.sleep(1000);
//		if(driver.findElements(By.xpath("//h2[text()=' you want to add the tokens?']")).size() > 0){
//			driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//			Thread.sleep(1000);
//			if (cc.Validation_Format_ManageTokens_saved.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass(cc.Validation_Format_ManageTokens_saved.getText() + " for ",extentScreenshot());
//			} else {
//				test.fail("Something Wrong ! Not able to manage tokens", extentScreenshot());
//				Assert.assertTrue(false);
//			}
//		}else if (driver.findElements(By.xpath("//h2[text()=' you want to withdraw the tokens?']")).size() > 0) {
//			driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//			Thread.sleep(1000);
//			if (cc.Validation_Format_ManageTokens_saved.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass(cc.Validation_Format_ManageTokens_saved.getText() + " for ",extentScreenshot());
//			} else {
//				test.fail("Something Wrong ! Not able to manage tokens", extentScreenshot());
//				Assert.assertTrue(false);
//			}
//		}else {
//			test.fail("Something Wrong ! Not able to add tokens", extentScreenshot());
//			Assert.assertTrue(false);
//		}
//		Thread.sleep(1000);
//		pp.clickPurchaseHistoryTab();
//		String ST = driver.findElement(By.xpath("//th[text()='Sweep Token']//following::td[contains(@class,'sweepTokens')][1]")).getText();
//		System.out.println("Package ST = "+PkgST);
//		String GT = driver.findElement(By.xpath("//th[text()='Game Token']//following::td[contains(@class,'gameTokens')][1]")).getText();
//		System.out.println("Package ST = "+pkgGT);
//		String Amtp = driver.findElement(By.xpath("//th[text()='Amount($)']//following::td[contains(@class,'amount')][1]")).getText();
//		System.out.println("Package ST = "+Amt);
//		pp.clickPlayerLedgerTab();
//		Thread.sleep(1000);
//		List<WebElement> Balance = driver.findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-balance mat-column-balance ng-star-inserted'][1]"));
//		System.out.println(Balance.size());
//		List<WebElement> Deposit = driver.findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-deposit mat-column-deposit ng-star-inserted'][1]"));
//		System.out.println(Deposit.size());
//		List<WebElement> Withdraw = driver.findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-withdraw mat-column-withdraw ng-star-inserted'][1]"));
//		System.out.println(Withdraw.size());
//		List<WebElement> FinalBalance = driver.findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-finalBalance mat-column-finalBalance ng-star-inserted'][1]"));
//		System.out.println(FinalBalance.size());
//
//	
//	
//	
//	
//	
//	
//	
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void TC_CreateAnnouncements() throws InterruptedException {
//
//		test = extentCreateTest("As admin user I should be able to create announcement to players");
//
//		CommonCosmo cc = new CommonCosmo(driver);
//		UserPage up = new UserPage(driver);
//		SupportPage sp = new SupportPage(driver);
//
//		up.ClickDotButton();
//		Thread.sleep(500);
//		up.ClickAlertsButton();
//		Thread.sleep(500);
//		up.ClickAnnouncementsButton();
//		Thread.sleep(1000);
//		up.ClickonCreateNewBtn();
//		test.info("Creating New Announcement to players");
//		Thread.sleep(1000);
//		sp.ClickonTitle("NEW ANNOUNCEMENT OF 2k23");
//		Thread.sleep(1000);
//		sp.SelectStoreAcoount("CosmoSlot");
//		Thread.sleep(1000);
//		sp.SelectAnnouncementCategory("Offers");
//		Thread.sleep(1000);
//		sp.ClickonDescription("Offers");
//		Thread.sleep(500);
//		// up.clickToSave();
//		Thread.sleep(500);
//
////		if (cc.Validation_Format_ManageTokens_saved.isDisplayed() == true) {
////			Assert.assertTrue(true);
////			test.pass("" + cc.Validation_Format_ManageTokens_saved.getText(), extentScreenshot());
////		} else {
////			test.fail("Something Wrong ! Not able to manage tokens", extentScreenshot());
////			Assert.assertTrue(false);
////		}
////		Thread.sleep(5000);
//
//		gotoTab(driver, 1);
//		up.ClickonNotificationIcon();
//		Thread.sleep(1000);
//		if (driver.findElements(By.xpath("//h6[@class=\"notiTitle\"]")).size() > 0) {
//			Assert.assertTrue(true);
//			test.pass("Susscessfully viwed announcement in player player notifications", extentScreenshot());
//		} else {
//			test.fail("Something Wrong !To view player notifictions", extentScreenshot());
//			Assert.assertTrue(false);
//		}
//
//	}
}

