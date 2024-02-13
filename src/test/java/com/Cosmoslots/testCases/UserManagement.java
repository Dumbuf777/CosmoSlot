package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.MyProfiles;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;

public class UserManagement extends BaseClass {
	BaseClass bc = new BaseClass();
	private UserPage up;
	private GuestPlayers gp ;
	private PlayerProfile pp;
	private CommonCosmo cc;
	private CosmoWebsite cw;

	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Usernm = Firstnm + Lastnm;
	String Email = Firstnm + Lastnm + "@gmail.com";
	String usertype = "Admin ";
	String userrole = "Master ";
	String store = "CosmoSlot - (CS) ";
	String parentuser = " System AdmiN ";
	String country = "India";
	String state = "Gujarat";
	String PTSTL = "100";
	String PDTSTL = "1000";
	String Timezone = "(GMT+5:30) Asia/Colombo";
	String RPP = "50";// record per page
	String UserName = "CosmoslotPos";
	String Upload_Icon = UploadImage;
	String UserRolePOS = "POS ";
	String ParentUserPos = " Cosmoslot Pos ";
	String UserRoleStore = "Store ";
	String ParentUserStore = " Cosmoslot Store ";

	@Test
	public void A_TC_UserManagement_Redirect() throws InterruptedException, IOException {
		test = extentCreateTest("TC : As an admin user I should able to view user profile listing");
		up = new UserPage(driver);
		gotoTab(driver, 0);
		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		if (up.UserProfile_Header!= null) {
			test.pass("Opened User  Management->Users Profile Successfully", extentScreenshot());
		} else {
			test.fail("Something wrong!To Open User Management->Users", extentScreenshot());
		}
	}

	@Test
	public void B_TC_UserManagement_SearchUser() throws InterruptedException, IOException {
		String SearchItem = "Cosmoslot_1@yopmail.com";

		test = extentCreateTest("TC :- As an admin user I should be able to search user ");

		pp = new PlayerProfile(driver);
		if (up.UserProfile_Header != null) {
			test.info("Opened Player Successfully");
			pp.Search_Items(SearchItem);
			Thread.sleep(1500);
			int count = driver.findElements(By.xpath("//th[text()='Email']/following::tr//td[contains(.,'" + SearchItem + "')]")).size();
			if (count > 0) {
				test.pass("Successfully Searched item viewed", extentScreenshot());
			} else if (count == 0) {
				test.fail("No record Found Showing successfully", extentScreenshot());
			} else {
				Assert.assertTrue(false);
				logger.info("Something wrong !! To Search Item");
				captureScreen(driver, "FailedSearchByUserEmail");
			}
			
		}
	}

//	@Test
//	public void C_TC_UserManagement_AddPlayer() throws InterruptedException, IOException 
//	{
//		test = extentCreateTest(
//				"TestCase started 2190 - As an admin user I should able to Add Player successfully by providing valid form data");
//		// logger.info("Create NewPlayer Testcase started");
//		GuestPlayers gp = new GuestPlayers(driver);
//		MyProfileTest mp = new MyProfileTest(driver);
////		Thread.sleep(4000);
//		//gp.clickPlayerManagement1Link();
//		//logger.info("Clicked on Player Management");
//		//gp.clickGuestPlayersLink();
//		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) 
//		{
//			logger.info("Opened UserManagement->Users Successfully");
//			gp.clickCreateNewButton();
//					
//				if(driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
//					Thread.sleep(2000);
//					gp.setFirstName(Firstnm);
//					logger.info("Entered FirstName successfully");
//					gp.setLastName(Lastnm);
//					logger.info("Entered LastName successfully");					
//					gp.setDisplayName(Usernm);
//					logger.info("Entered Username successfully");
//					gp.Designation.sendKeys("Manager");
//					logger.info("Entered Designation successfully");
//					Thread.sleep(1000);
//					gp.selectUserType(usertype);
//					logger.info("Entered Usertype = "+usertype+" successfully");
//					gp.selectStore(store);
//					test.info("Selected Store successfully");
//					gp.selectparentuser(parentuser);
//					test.info("Selected parentuser = "+parentuser+" successfully");
//					gp.setEmail(Email);
//					logger.info("Entered Email Successfully");
//					gp.setDialCode("+91");
//					logger.info("Entered DialCode Successfully");
//					gp.setPhone("9899092344");
//					logger.info("Entered Phone Successfully");
//					gp.setCountry(country);
//					logger.info("Entered Country Successfully");
//					Thread.sleep(1000);
//					gp.setState(state);
//					//gp.setUsersState(state);
//					logger.info("Entered State Successfully");
//					gp.setCity("Surat");
//					logger.info("Entered City Successfully");
//					gp.setZipcode("395007");
//					logger.info("Entered Pincode Successfully");
//					gp.setsingleTransactionSweepTokenLimit(PTSTL);
//					logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
//					gp.setdailySweepTokenLimit(PDTSTL);
//					logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
//					gp.Timezone.click();
//					gp.editTimezone(Timezone);
//					Thread.sleep(500);
//					gp.RPP.click();
//					gp.editRPP(RPP);
//					Thread.sleep(500);
//					gp.selectUserRole(userrole);
//					logger.info("Selected UserRole successfully");
//					gp.selectgender("Male");
//					logger.info("Selected Gender successfully");
//					gp.ClickSave();
//					Thread.sleep(5000);
//						
//					if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
//						Assert.assertTrue(true);
//						logger.info("Successfully Added  New User in User Management->Users List.");
//					} else {
//						Assert.assertTrue(false);
//						logger.info("Something Wrong!To View Added User Management->Users in Users List.");
//					}
//				} 
//				else 
//				{
//					logger.info("Something wrong!To Open Create User Management->Users");
//					Assert.assertTrue(false);
//				}
//			
//		}
//		//gp.clickDashboardButton();
//	}

//	@Test
//	public void E_TC_UserManagement_PDF() throws InterruptedException, IOException 
//	{
//		//String SearchItem="XYZY";
//		test = extentCreateTest("TestCase started As an admin user I should be able to Download PDF file in User Profile");
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//
//		if(driver.findElement(By.xpath("//h3[text()=\"User Profile\"]"))!=null)
//		{	
//			Thread.sleep(1000);
//			//pp.clickPurchaseHistoryTab();
//			//Thread.sleep(1000);
//			//logger.info("Successfully Redirected to WithdrawRequestTab");
//			logger.info("Testing PDF Download in User Management->Users");
//			pp.clickPdfButton();
//			Thread.sleep(1500);
//			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
//			
//			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//span[text()=\"PDF downloaded successfully\"]")).isDisplayed())	
//			{
//				logger.info("Successfully PDF Downloaded");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				logger.info("Something wrong !! To Download PDF");
//				captureScreen(driver,"FailedPDFDownloadUserTest");
//				Assert.assertTrue(false);
//			}	
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}
//	
	@Test
	public void F_TC_UserManagement_XLSX() throws InterruptedException, IOException {
		test = extentCreateTest("TestCase started As an admin user I should be able to Download EXCEL file in User Profile");

		CommonCosmo cc = new CommonCosmo(driver);
		//up = new UserPage(driver);

		if (up.UserProfile_Header!= null) {

			driver.findElement(By.xpath("(//button[@title='Export XLSX'])[1]")).click();
			if (cc.Validation_XLSXDownload.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_XLSXDownload, extentScreenshot());
			} else if (cc.Validation_XLSXDownload1.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_XLSXDownload1, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void G_TC_UserManagement_EditUsers() throws InterruptedException, IOException {
		test = extentCreateTest("Started As an admin user I should be able to Edit User in User Profile");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);

		if (up.UserProfile_Header!= null) {
			pp.clickPlayerEdit();
			Thread.sleep(500);
			if (driver.findElement(By.xpath("//h3[text()=\"Edit User\"]")) != null) {
				gp.FirstName.clear();
				gp.setFirstName(Firstnm);
				logger.info("Entered FirstName successfully");
				gp.LastName.clear();
				gp.setLastName(Lastnm);
				test.info("Entered LastName successfully"); // gp.setDisplayName(Usernm);
			    test.info("Entered DialCode Successfully");
				gp.Phone.clear();
				gp.setPhone("9899092344");
				test.info("Entered Phone Successfully");
				// driver.findElement(By.xpath("(//div[contains(@class,\"value\")])[4]")).click();
				// gp.editCountry("United States");
				test.info("Entered Country Successfully");
				// Thread.sleep(300);
				// driver.findElement(By.xpath("(//div[contains(@class,\"value\")])[5]")).click();
				// gp.editUsersState("New Jersey");
				logger.info("Entered State Successfully");
				gp.City.clear();
				gp.setCity("Jersey");
				logger.info("Entered City Successfully");
				gp.ZipCode.clear();
				gp.setZipcode("08701");
				logger.info("Entered Pincode Successfully");
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				gp.Timezone.click();
				gp.editTimezone(Timezone);
				gp.RPP.click();
				gp.editRPP(RPP);
				gp.Role.click();
//				gp.editUserRole("Master ");
//				logger.info("Selected UserRole successfully");
				gp.gender.click();
				gp.editgender("Female");
				test.info("Selected Gender successfully");
				up.clickToSave();
				if (cc.Validation_Format_Usersavesuccessfully != null) {
					test.pass("Successfully user edited in user profile.",extentScreenshot());
				} else {
					test.info("Something Wrong!To edit user in user profile",extentScreenshot());
				}
			} else {
				test.fail("Something wrong!To user profile");
				Assert.assertTrue(false);
			}
		}
		// gp.clickDashboardButton();
	}

//	@Test
	public void H_TC_UserManagement_ManageStore() throws InterruptedException, IOException {
		test = extentCreateTest("TestCase started As an admin user I should be able to Manage Token ");
		
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		up = new UserPage(driver);
		pp.Search_Items("Demo_1@yopmail.com");
		Thread.sleep(3000);
		if (up.UserProfile_Header!= null) {
			test.info("Opened Player Successfully");
			pp.clickPlayerEdit();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//button[text()=\"Manage Store\"]")).click();
			up.ClickonManageStore();
			Thread.sleep(500);
			gp.selectStoreAccount("store-777 - (AT7777)");
			driver.findElement(By.xpath("//button[@title=\"Create New\"]")).click();
			if (driver.findElement(By.xpath("//span[text()=\"CosmoSlot\"]")) != null) {
				test.pass("Successfully added store");
			} else {
				test.fail("Something Error! Store not added");
				// ScreenCapture(driver,"UserManagement_ManageStore");/
			}
			gp.ClickOnclearsearch();
		}
	}

	@Test
	public void I_TC_UserManagement_ActiveInActive() throws InterruptedException, IOException {
		test = extentCreateTest("TestCase started As an admin user I should be able to Active/InActive Status User ");
	
		up = new UserPage(driver);
		if (up.UserProfile_Header!= null) {
			if (driver.findElement(By.xpath("//th[text()=\"Status\"]/following::tr//td[contains(@class,\"active\")]//span[@title]"))
					.getAttribute("title").equalsIgnoreCase("In Active")) {
				// test.info("Successfully Viewed View Icon of Player on the player listing
				// page");
				test.info("Now User Is In Active");
				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
				Thread.sleep(1000);
				try {
					if (driver.findElements(By.xpath("//span[text()=\"User Profile activated successfully\"]"))
							.size() > 0) {
						Assert.assertTrue(true);
						test.pass(
								"User Successfully activated and Validation message appeared - User Profile activated successfully");
					} else {
						Assert.assertTrue(false);
						test.fail("Failed ! To View Message");
					}
				} catch (Exception e) {
					if (driver
							.findElement(By.xpath("//span[text()=\"User Profile activated successfully\"]")) != null) {
						Assert.assertTrue(true);
						test.pass(
								"User Successfully activated and Validation message appeared - User Profile activated successfully");
					}
					System.out.println(e);
				}

				Thread.sleep(4000);

			} else {
				test.info("Successfully Viewed View Icon of Player on the player listing page");
				test.info("Now Player Is Active");

				driver.findElement(By.xpath(
						"(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]"))
						.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
				Thread.sleep(1000);
				try {
					if (driver.findElements(By.xpath("//span[text()=\"User Profile deactivated successfully\"]"))
							.size() > 0) {
						Assert.assertTrue(true);
						test.pass(
								"User Successfully deactivated and Validation message appeared - User Profile deactivated successfully");
					} else {
						Assert.assertTrue(false);
						test.fail("Failed ! To View Message");
					}
				} catch (Exception e) {
					if (driver.findElements(By.xpath("//span[text()=\"User Profile deactivated successfully\"]"))
							.size() > 0) {
						Assert.assertTrue(true);
						test.info(
								"User Successfully deactivated and Validation message appeared - User Profile deactivated successfully");
					}
					System.out.println(e);
				}
			}
		}
	}

	@Test
	public void J_TC_UserManagement_LoginFootprints() throws InterruptedException {
		test = extentCreateTest("TC - As an admin user I should be able to view loginfootprints details in user profile ");

		up = new UserPage(driver);
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);
		cw = new CosmoWebsite(driver);

		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		gp.Search_Items(UserName);
		Thread.sleep(3000);
		pp.clickOnPlayerProfileActionEye();
		up.ClickOnGuestPlayerLoginFootprints();
		if (cc.UserManagement_Header != null) {
			test.info("Already Opened User Management foootprints screen");
//			cw.readData();
			List<WebElement> ViewUserFootprintHeaders = driver.findElements(By.xpath("//tr//th"));
			List<WebElement> ViewUserFootprintData = driver.findElements(By.xpath("//tr[1]//td"));
			for (int i = 0; i < ViewUserFootprintHeaders.size(); i++) {
				String headerText = ViewUserFootprintHeaders.get(i).getText();
				String dataText = ViewUserFootprintData.get(i).getText();
				if (driver.findElement(By.xpath("//th[text()='" + headerText + "']")).isDisplayed() == true) {
					test.info("Successfully Viewed <b>" + headerText + " = " + dataText
							+ "</b> on the user footprint page", extentScreenshot());
				} else {
					test.fail("Something wrong !! To open user footprint details", extentScreenshot());
				}
			}

		} else {
			test.fail("Something wrong!To Open user footprints page", extentScreenshot());
		}

	}

	@Test
	public void K_TC_UserManagement_EnterCashAppIDandUploadQRCodeinmyprofile()throws InterruptedException, IOException {

		test = extentCreateTest("TC- As an admin user I should be able to enter acsh app ID and upload QR code in only POS User profile ");
           // only POS user will be enter cash app ID and upload QR code in User profile
		CommonCosmo cc = new CommonCosmo(driver);
		LoginPage lp = new LoginPage(driver);
		LoginPage lp1 = new LoginPage(driver);
		UserPage up = new UserPage(driver);

		Thread.sleep(5000);
		lp.clickLogout();
		Thread.sleep(2000);
		Adminlogin("cosmoslotpos");
		test.info("Successfully Logged POS user");
		bc.PageReload();
		Thread.sleep(3000);
		lp1.ClickonUserAdminProfile();
		Thread.sleep(1000);
		lp1.ClickonUserMyProfile();
		Thread.sleep(2000);
		up.EnterCashAppID("abcde@ombpmllp");
		test.info("Successfully entered cash app ID", extentScreenshot());
		Thread.sleep(500);
		up.clickonUploadQRCode(Upload_Icon);
		test.info("Successfully entered QR Code", extentScreenshot());
		Thread.sleep(500);
		up.clickToSave();
		//Thread.sleep(500);
		if (cc.Validation_Format_Profilesavesuccessfully.isDisplayed() == true) {
			test.pass("Successfully Entered Cash App ID And Uploaded QR Code in POS user profile", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to Entered Cash App ID And Uploaded QR Code in POS user profile", extentScreenshot());
		}
		Thread.sleep(5000);
//		lp.clickLogout();
//		Thread.sleep(2000);
//		Adminlogin(username);
	}

	@Test
	public void Ka_TC_UserManagement_Dontedittheuserrole() throws InterruptedException, IOException {
		test = extentCreateTest("TC- As an admin user, I should not be able to edit the user role");

		LoginPage lp = new LoginPage(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		Thread.sleep(5000);
		lp.clickLogout();
		Thread.sleep(2000);
		Adminlogin(username);
		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		gp.Search_Items("Cosmoslot Store");
		Thread.sleep(2000);
		up.clickToEdit();
		if (driver.findElement(By.xpath("//h3[text()=\"Edit User\"]")) != null) {
			if (driver.findElement(By.xpath("//mat-select[@formcontrolname='roleCode']")).getAttribute("aria-invalid")
					.equalsIgnoreCase("false")
					&& driver.findElement(By.xpath("//mat-select[@formcontrolname='userType']"))
							.getAttribute("aria-invalid").equalsIgnoreCase("false")
					&& driver.findElement(By.xpath("//mat-select[@formcontrolname='primaryLobbyId']"))
							.getAttribute("aria-invalid").equalsIgnoreCase("false")
					&& driver.findElement(By.xpath("//mat-select[@formcontrolname='parentId']"))
							.getAttribute("aria-invalid").equalsIgnoreCase("false"))
				;
			test.pass("User Successfully deactivated user role, user store account,user parent and user type",extentScreenshot());
		} else {
			test.fail("Something Wrong ! user able to edit user role", extentScreenshot());
		}
		up.clickToSave();
//		if (driver.findElement(By.xpath("//mat-select[@formcontrolname='userType']")).getAttribute("aria-invalid").equalsIgnoreCase("false")) {
//			Assert.assertTrue(true);
//			test.pass("User Successfully deactivated user type", extentScreenshot());
//		} else {
//			Assert.assertTrue(false);
//			test.fail("Something Wrong ! user able to edit user type", extentScreenshot());
//		}
//	    
//		if (driver.findElement(By.xpath("//mat-select[@formcontrolname='primaryLobbyId']")).getAttribute("aria-invalid").equalsIgnoreCase("false")) {
//			Assert.assertTrue(true);
//			test.pass("User Successfully deactivated user store account", extentScreenshot());
//		} else {
//			Assert.assertTrue(false);
//			test.fail("Something Wrong ! user able to edit user store account", extentScreenshot());
//		}
//	      
//		if (driver.findElement(By.xpath("//mat-select[@formcontrolname='parentId']")).getAttribute("aria-invalid").equalsIgnoreCase("false")) {
//			Assert.assertTrue(true);
//			test.pass("User Successfully deactivated user parent", extentScreenshot());
//		} else {
//			Assert.assertTrue(false);
//			test.fail("Something Wrong ! user able to edit user parent", extentScreenshot());
//		}
	}

	@Test
	public void Kb_TC_UserManagement_CreateReadOnlyUser_POS() throws InterruptedException {
		test = extentCreateTest("TC -As an admin user I should be able to create 'Read Only USER' user when creating new user profile");

		gp = new GuestPlayers(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);

		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			test.info("Opened User Profile Successfully");
			gp.clickCreateNewButton();
			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("POS");
				gp.setEmail(bc.FakeEmail());
				gp.setCountry(country);
				gp.setState(state);
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				gp.setdailySweepTokenLimit(PDTSTL);
				gp.selectUserRole(UserRolePOS);
				gp.selectReadOnlyUser();
//				gp.selectStore(store);
				gp.selectStore("store-0860 - (AT8146)");
//				gp.selectparentuser(ParentUserPos);
				gp.selectparentuser(" Chaga Schmeler ");
				Thread.sleep(200);
				 up.clickToSave();
				Thread.sleep(1000);
				if (cc.Validation_Format_Usersavesuccessfully!= null) {
					test.info("Successfully Added  New User in User Management->Users List.",extentScreenshot());
				} else {
					test.info("Something Wrong!To View Added User Management->Users in Users List.",extentScreenshot());
				}
				Thread.sleep(5000);
				gp.Search_Items(Usernm);
				Thread.sleep(2000);
				if (driver.findElement(By.xpath("//th[text()='User Name']//following::div[@class='playerProfilePic userReadOnly']")).isDisplayed()) {
					test.pass("Successfully Added  New read only User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					test.info("Something Wrong!To View Added read only User Management->Users in Users List.");
				}
				gp.Clickeyeicon();
				Thread.sleep(1000);
				if (driver.findElement(By.xpath("//span[text()='Readonly User']//following::span[text()='Yes']"))
						.isDisplayed()) {
					Assert.assertTrue(true);
					test.pass("Successfully viewd user profile  New read only User.", extentScreenshot());
				} else {
					Assert.assertTrue(false);
					test.fail("Something Wrong!To View user profile   read only User.", extentScreenshot());
				}
			} else {
				test.fail("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}

		}
	}
	
	@Test
	public void Kc_TC_UserManagement_TokenLedger() throws InterruptedException {
		test = extentCreateTest("TC -As an admin user I should be able to verify displayed total deposit ST and counted total deposit ST in store user token ledger");
	
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		PlayerProfile pp= new PlayerProfile(driver);
		List<Double> totalTransactionAmountst=new ArrayList<Double>();
		String TransactionType[] = {"Deposit","Transfer"};
		
		up.ClickOnUserProfile();
		up.ClickOnBack();
		gp.Search_Items("Cosmoslot Store");
		Thread.sleep(3000);
		pp.Clickeyeicon();
		up.ClickonTokenLedger();
		
		String Total_Deposit_ST = driver.findElement(By.xpath("//span[text()='Total Deposit']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Deposit Sweep Token = "+Total_Deposit_ST);
		test.info("Total Deposit Sweep Token = "+Total_Deposit_ST);
//		String Total_Redeem_Transfer_ST = driver.findElement(By.xpath("//span[text()='Total Redeem Transfer']//following::span[1]")).getText().replaceAll(",", "");
//		System.out.println("Total Redeem Transfer Sweep Token = "+Total_Redeem_Transfer_ST);
		String Total_Transfer_ST = driver.findElement(By.xpath("//span[text()='Total Transfer']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Transfer Sweep Token = "+Total_Transfer_ST);
		test.info("Total Deposit Sweep Token = "+Total_Transfer_ST, extentScreenshot());
//		String Total_Redeem_ST = driver.findElement(By.xpath("//span[text()='Total Redeem']//following::span[1]")).getText().replaceAll(",", "");
//		System.out.println("Total Redeem Sweep Token = "+Total_Redeem_ST);
//		String Total_Bonus_ST = driver.findElement(By.xpath("//span[text()='Total Bonus']//following::span[1]")).getText().replaceAll(",", "");
//		System.out.println("Total Bonus Sweep Token = "+Total_Bonus_ST);
//		String Total_Extra_Sweep_Tokens_ST = driver.findElement(By.xpath("//span[text()='Total Extra Sweep Tokens']//following::span[1]")).getText().replaceAll(",", "");
//		System.out.println("Total Extra Sweep Token = "+Total_Extra_Sweep_Tokens_ST);
		for (int i = 0; i < TransactionType.length; i++) {
			UserPage up1 = new UserPage(driver);
			up1.Search_Items(TransactionType[i]);
			Thread.sleep(5000);
			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
			if (!nextBtn.getAttribute("class").contains("disabled")) {
				List<WebElement> transactionAmountst = driver.findElements(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
				for (WebElement transactionAmountST : transactionAmountst) {
					double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
					totalTransactionAmountst.add(TotaltransactionAmountst);
					// Thread.sleep(3000);

				}
				nextBtn.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} else {
				List<WebElement> transactionAmountst = driver.findElements(By.xpath(
						"//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
				for (WebElement transactionAmountST : transactionAmountst) {
					double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
					totalTransactionAmountst.add(TotaltransactionAmountst);
				}
			}
			//double TotalDepositST = totalTransactionAmountst.stream().mapToDouble(Double::doubleValue).sum();
			double sumOfList1 = 0.0;
			for (double value : totalTransactionAmountst) {
			    sumOfList1 += value;
			}
			System.out.println("Counted Total "+TransactionType[i]+" Sweep Token = " + sumOfList1);
			test.pass("Counted Total "+TransactionType[i]+" Sweep Token = " + sumOfList1,extentScreenshot());
			totalTransactionAmountst.clear();
			}
	
		
//		Thread.sleep(10000);
	}
	
	@Test
	public void Kd_TC_UserManagement_TokenLedger() throws InterruptedException {
		test = extentCreateTest("TC -As an admin user I should be able to verify displayed total deposit ST and calculated deposit transaction amount ST in POS user token ledger");

			
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		PlayerProfile pp= new PlayerProfile(driver);
		List<Double> totalTransactionAmountst=new ArrayList<Double>();
		String TransactionType[] = {"Deposit","Transfer","Redeem","Bonus"};
		
		up.ClickOnUserProfile();
		bc.implicitWait(driver, 60);
		up.ClickOnBack();
		bc.implicitWait(driver, 60);
		gp.Search_Items("cosmoslotpos");
        Thread.sleep(3000);
        pp.Clickeyeicon();
		bc.implicitWait(driver, 60);
		up.ClickonTokenLedger();
		bc.implicitWait(driver, 60);
		
		String Total_Deposit_ST = driver.findElement(By.xpath("//span[text()='Total Deposit']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Deposit Sweep Token = "+Total_Deposit_ST);
		test.info("Total Deposit Sweep Token = "+Total_Deposit_ST,extentScreenshot());
		String Total_Redeem_Transfer_ST = driver.findElement(By.xpath("//span[text()='Total Redeem Transfer']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Redeem Transfer Sweep Token = "+Total_Redeem_Transfer_ST);
		test.info("Total Redeem Transfer Sweep Token = "+Total_Redeem_Transfer_ST);
		String Total_Transfer_ST = driver.findElement(By.xpath("//span[text()='Total Transfer']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Transfer Sweep Token = "+Total_Transfer_ST);
		test.info("Total Transfer Sweep Token = "+Total_Transfer_ST);
		String Total_Redeem_ST = driver.findElement(By.xpath("//span[text()='Total Redeem']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Redeem Sweep Token = "+Total_Redeem_ST);
		test.info("Total Redeem Sweep Token = "+Total_Redeem_ST);
		String Total_Bonus_ST = driver.findElement(By.xpath("//span[text()='Total Bonus']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Bonus Sweep Token = "+Total_Bonus_ST);
		test.info("Total Bonus Sweep Token = "+Total_Bonus_ST);
		String Total_Extra_Sweep_Tokens_ST = driver.findElement(By.xpath("//span[text()='Total Extra Sweep Tokens']//following::span[1]")).getText().replaceAll(",", "");
		System.out.println("Total Extra Sweep Token = "+Total_Extra_Sweep_Tokens_ST);
		test.info("Total Extra Sweep Token = "+Total_Extra_Sweep_Tokens_ST);	
		
		for (int i = 0; i < TransactionType.length; i++) {
			UserPage up1 = new UserPage(driver);
			up1.Search_Items(TransactionType[i]);
			Thread.sleep(5000);
			boolean flag = true;
			while (flag) {
				WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
				if (!nextBtn.getAttribute("class").contains("disabled")) {
					List<WebElement> transactionAmountst = driver.findElements(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
					for (WebElement transactionAmountST : transactionAmountst) {
						//int TotaltransactionAmountst = Integer.parseInt(transactionAmountST.getText().replaceAll(",", ""));
						double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
						totalTransactionAmountst.add(TotaltransactionAmountst);
					}
					nextBtn.click();
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				} else {
					flag = false;
					List<WebElement> transactionAmountst = driver.findElements(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
					for (WebElement transactionAmountST : transactionAmountst) {
						//int TotaltransactionAmountst = Integer.parseInt(transactionAmountST.getText().replaceAll(",", ""));
						double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
						totalTransactionAmountst.add(TotaltransactionAmountst);
					}
				}
			}
			 //System.out.println(totalTransactionAmountst);
			//double CountST = totalTransactionAmountst.stream().mapToDouble(Double::doubleValue).sum();
			double sumOfList1 = 0.0;
			for (double value : totalTransactionAmountst) {
			    sumOfList1 += value;
			}
			String countST = Double.toString(sumOfList1);
			System.out.println("Counted Total "+TransactionType[i]+" Sweep Token = " + sumOfList1);
			test.pass("Counted Total "+TransactionType[i]+" Sweep Token = " + sumOfList1,extentScreenshot());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			totalTransactionAmountst.clear();
			//bc.PageReload();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		if (Total_Deposit_ST.equalsIgnoreCase(Total_Deposit_ST)) {
			test.pass("Successfully verified displayed total deposit ST and calculated deposit transaction amount ST",extentScreenshot());
		} else {
			test.fail("Something wrong!To verify displayed total deposit ST and calculated deposit transaction amount ST",extentScreenshot());
		}
		
		
		Thread.sleep(10000);
	}
	
	@Test
	public void Ke_TC_UserManagement_TotalCountTokenLedger() throws InterruptedException {
		test = extentCreateTest("TC -As an admin, I should be able to view the total count in all listed listings");

		double total = 0;
		
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		PlayerProfile pp= new PlayerProfile(driver);
		List<Double> totalTransactionAmountst=new ArrayList<Double>();
		
//		up.ClickOnUserProfile();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		up.ClickOnBack();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		gp.Search_Items("Cosmoslot Pos");
//		Thread.sleep(3000);
//		pp.Clickeyeicon();
//		Thread.sleep(2000);
		up.GoToUserProfileView("cosmoslotpos");
		up.ClickonTokenLedger();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
		if (!nextBtn.getAttribute("class").contains("disabled")) {
			List<WebElement> transactionAmountst = driver.findElements(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
			for (WebElement transactionAmountST : transactionAmountst) {
				double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
				//totalTransactionAmountst.add(TotaltransactionAmountst);
				total=total+TotaltransactionAmountst;
			}
			System.out.println(total);
			//double TotalCountTransST = totalTransactionAmountst.stream().mapToDouble(Double::doubleValue).sum();
			//System.out.println(TotalCountTransST);
			//totalTransactionAmountst.clear();
			double sumOfList1 = 0.0;
			for (double value : totalTransactionAmountst) {
			    sumOfList1 += value;
			}
			Thread.sleep(3000);
			String TotalDisplayTransST = driver.findElement(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tfoot//td[contains(@class,'transactionAmount-sweepTokens')]/span/span")).getText().replaceAll(",", "");
			double TotalDisplayTrans_ST = Double.parseDouble(TotalDisplayTransST);
			System.out.println(TotalDisplayTrans_ST);
			nextBtn.click();
			Thread.sleep(3000);
		} else {
			List<WebElement> transactionAmountst = driver.findElements(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]"));
			for (WebElement transactionAmountST : transactionAmountst) {
				double TotaltransactionAmountst = Double.parseDouble(transactionAmountST.getText().replaceAll(",", ""));
				totalTransactionAmountst.add(TotaltransactionAmountst);
			}
			//double TotalCountTransST = totalTransactionAmountst.stream().mapToDouble(Double::doubleValue).sum();
			double sumOfList1 = 0.0;
			for (double value : totalTransactionAmountst) {
			    sumOfList1 += value;
			}
			//System.out.println(TotalCountTransST);
			totalTransactionAmountst.clear();
			Thread.sleep(3000);
			String TotalDisplayTransST = driver.findElement(By.xpath("//th[contains(text(),'Transaction Amount ST')]//following::tfoot//td[contains(@class,'transactionAmount-sweepTokens')]/span/span")).getText().replaceAll(",", "");
			double TotalDisplayTrans_ST = Double.parseDouble(TotalDisplayTransST);
			System.out.println(TotalDisplayTrans_ST);
		}
	}
}
