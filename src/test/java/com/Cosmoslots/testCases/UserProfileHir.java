/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserProfileHir extends BaseClass {
	BaseClass bc = new BaseClass();
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Usernm = Firstnm + Lastnm;
	String Email = Firstnm + Lastnm + "@yopmail.com";
	String mobno = RandomStringUtils.randomNumeric(10);
	String pincode = RandomStringUtils.randomNumeric(6);
	String userroleA = "RoleSS "; // "ADMIN ";
	String userroleM = "MasterS "; // "MASTER_A";
	String userroleD = "DistributorS "; // "DISTRIBUTOR_A";
	String userroleSD = "Sub DistributorS "; // "SUB_DISTRIBUTOR_A";
	String userroleS = "StoreS "; // "STORE_A";
	String userrolePOS = "POSSS "; // "POS_A";
	String store = "CosmoSlot - (CS) ";
	String usertypeA = "Admin ";
	String usertypeAU = "Admin User ";
	String usertypeD = "Dealer ";
	String usertypeDU = "Dealer User ";
	String parentuser = " System AdmiN ";
	String parentuserA = " Role S ";;
	String parentuserm = " Master S ";
	String parentuserd = " Distributor s ";
	String parentusersd = "Subdistributorr S";
	String parentusermpos = "Store S";

	String country = "India";
	String state = "Goa";
	String PTSTL = "10000000";
	String PDTSTL = "10000000";
	String Timezone = "Asia/Colombo";

	String[] Alerts = { "Announcement", "Announcement Listing", "Notification", "Notification Listing" };
	String[] DashboardManagement = { "Most Spent Tokens", "Player Transaction", "Daily Purchase", "Player Location",
			"Most Active Games", "Total Game", "Latest Withdraw Requests", "Most Player Login", "Total Purchase",
			"Total Spins", "Total Player", "Latest Purchase History" };
	String[] PlayerManagement = { "Profile & Dashboard", "Reputations", "State", "Redeemable Tokens", "Gender", "City",
			"Display Name", "Country", "Phone", "Email", "Created By", "Zip Code", "Updated At", "Created At", "Store",
			"Updated By", "Current Tokens", "Manage Tokens", "Player Login Footprints Listing", "Player Ledger",
			"Sweep Tokens", "Game Tokens", "Purchase History Listing", "Manual Reconcile", "Applied Coupons",
			"Withdraw Request", "Token Details", "Transaction History", "Game Transaction", "Player Support Request",
			"Player Listing", "Status", "Invited Players", "Send Email Verification Link", "Copy Link",
			"Withdraw Request Listing", "Description", "Payment Method", "Bank", "Skrill", "Withdraw Request Detail",
			"Blocked List", "By IP", "By User Data", "Token Details", "Guest Player Listing",
			"Guest Player Login Footprints Listing", "Guest Player Profile & Dashboard", "Create New Player",
			"Guest Player Support Request", "Purchase History Listing", "Manual Reconcile",
			"Player Deletion History Listing", "Jackpot Wins Listing" };
	String[] StoreManagement = { "Custom Package", "Store Profile & Dashboard", "Games", "App Settings",
			"Store Settings", "Store Coupon", "Store Bonuses", "Store Package", "Website Settings",
			"Corporation Details", "Store Listing", "Copy Link", "Store Maintenance", "Invited Players" };
	String[] UserManagement = { "Roles", "Users", "Token Details", "User Login Footprints Listing",
			"Player Registration", "Manage Tokens", "Token Ledger", "Redeem Tokens", "Basic Details", "Player Purchase",
			"Access Control", "Dashboard", "Settings", "Player Management", "Store Management", "Alerts",
			"User Management", "Support Management", "Reports", "Net Income", "Tip Reports", };
	String[] SupportManagement = { "Contact Us Listing", "Chat Listing", "Chat Details", "Support Request Listing",
			"Support Request Detail" };

	@Test
	public void A_TC_CreateAccessControl_Admin() throws InterruptedException {
		test = extentCreateTest("creating Access Control-->Admin");
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		String array[] = { "Admin", "Master", "Distributor", "SubDistributor", "Store", "POS" };

		for (int i = 0; i <= array.length - 1; i++) {
			UserPage up1 = new UserPage(driver);
			Thread.sleep(3000);
			up1.clickCreate_AccessControl();
			Thread.sleep(3000);
			up1.SetAC_code(array[i]);
			up1.SetAC_name(array[i]);
			Thread.sleep(3000);
			up1.clickToSave();
			Thread.sleep(10000);

		}

//		test.info("As an super admin creating the Access control of admin");
//		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
//			up.clickCreate_AccessControl();
//			Thread.sleep(1000);
//			up.SetAC_code(userroleA);
//			test.info("Access Control Code = <b>" + userroleA + "</b>");
//			up.SetAC_name(userroleA);
//			Thread.sleep(3000);
//			up.clickToSave();
//			Thread.sleep(2000);
//
//			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userroleA, extentScreenshot());
//			} else {
//				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
//				Assert.assertTrue(false);
//			}
//			Thread.sleep(5000);
//
//		} else {
//			Assert.assertTrue(false);
//			test.fail("Something Wrong!To create Access Control of Admin.");
//		}
	}

	@Test
	public void B_TC_CreateAccessControl_Master() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an super admin creating the Access control of master");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			up.clickCreate_AccessControl();
			Thread.sleep(1000);
			up.SetAC_code(userroleM);
			up.SetAC_name(userroleM);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(2000);

			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userroleM, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create Access Control of Admin.");
		}
	}
	
	@Test
	public void C_TC_CreateAccessControl_Distributor() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an super admin creating the Access control of distributor");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			up.clickCreate_AccessControl();
			Thread.sleep(1000);
			up.SetAC_code(userroleD);
			up.SetAC_name(userroleD);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(2000);

			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userroleD, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create Access Control of Admin.");
		}
	}

	@Test
	public void D_TC_CreateAccessControl_SubDistributor() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an super admin creating the Access control of Subditributor");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			up.clickCreate_AccessControl();
			Thread.sleep(1000);
			up.SetAC_code(userroleSD);
			up.SetAC_name(userroleSD);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(2000);

			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userroleSD, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create Access Control of Admin.");
		}
	}

	@Test
	public void E_TC_CreateAccessControl_Store() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an super admin creating the Access control of store");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			up.clickCreate_AccessControl();
			Thread.sleep(1000);
			up.SetAC_code(userroleS);
			up.SetAC_name(userroleS);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(2000);

			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userroleS, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create Access Control of Admin.");
		}
	}

	@Test
	public void F_TC_CreateAccessControl_Pos() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an super admin creating the Access control of POS");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			up.clickCreate_AccessControl();
			Thread.sleep(1000);
			up.SetAC_code(userrolePOS);
			up.SetAC_name(userrolePOS);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(2000);

			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText() + " of " + userrolePOS, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create Access Control of Admin.");
		}
	}

	@Test
	public void G_TC_CreateRole_Admin() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an user admin creating the User Role of Admin");
		String array[] = { "ADMIN", "Master", "Distributor", "SubDistributor", "Store", "POS" };
		// String array [] = {"7","8","9","10"};

		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			for (int i = 0; i <= array.length - 1; i++) {
				UserPage up1 = new UserPage(driver);
				CommonCosmo cc1 = new CommonCosmo(driver);
				Thread.sleep(3000);
				up1.clickCreate_UserRole();
				Thread.sleep(3000);
				up1.setAssignProfile(array[i]);
				up1.SetAC_code(array[i]);
				up1.SetAC_name(array[i]);
				Thread.sleep(3000);
				up1.clickToSave();
				Thread.sleep(10000);
				if (cc1.Validation_Format_UserRole_Add.isDisplayed() == true) {
					Assert.assertTrue(true);
					test.pass("" + cc1.Validation_Format_UserRole_Add.getText(), extentScreenshot());
				} else {
					test.fail("" + cc1.Validation_Format_UserRole_Exists.getText(), extentScreenshot());
					Assert.assertTrue(false);
				}
				Thread.sleep(5000);

			}

//		UserPage up = new UserPage(driver);
//		CommonCosmo cc = new CommonCosmo(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickUserRole();
//		Thread.sleep(500);
//		test.info("As an user admin creating the User Role of Admin");
//		String array [] = {"ADMIN","Master","Distributor","SubDistributor","Store","POS"};
//		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
//		   for(int i=0;i<=array.length-1;i++)
//		   {
//			   UserPage up1 = new UserPage(driver);
//			   CommonCosmo cc1 = new CommonCosmo(driver);
//			   Thread.sleep(3000);
//			   up1.clickCreate_UserRole();
//			   Thread.sleep(3000);
//			   up1.setAssignProfile(array[i]);
//			   up1.SetAC_code(array[i]);
//			   up1.SetAC_name(array[i]);
//			   Thread.sleep(3000);
//			   up1.clickToSave();
//			   Thread.sleep(10000);
//			   if (cc1.Validation_Format_UserRole_Add.isDisplayed() == true) {
//					Assert.assertTrue(true);
//					test.pass("" + cc1.Validation_Format_UserRole_Add.getText(), extentScreenshot());
//				} else {
//					test.fail("" + cc1.Validation_Format_UserRole_Add.getText(), extentScreenshot());
//					Assert.assertTrue(false);
//				}
//				Thread.sleep(5000);
//	
//			}

		}

//		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
//			up.clickCreate_UserRole();
//			Thread.sleep(500);
//			up.SetAC_code(userroleA);
//			up.SetAC_name(userroleA);
//			up.setAssignProfile(userroleA);
//			Thread.sleep(500);
//			up.AC_Save();
//			Thread.sleep(2000);
//			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userroleA, extentScreenshot());
//			} else {
//				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
//				Assert.assertTrue(false);
//			}
//			Thread.sleep(5000);
//
//		} else {
//			Assert.assertTrue(false);
//			test.fail("Something Wrong!To create User role of Admin.");
//		}
//
	}

	@Test
	public void H_TC_CreateRole_Master() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an User creating the User Role of Master");
		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			up.clickCreate_UserRole();
			Thread.sleep(500);
			up.SetAC_code(userroleM);
			up.SetAC_name(userroleM);
			up.setAssignProfile(userroleM);
			Thread.sleep(500);
			up.AC_Save();
			Thread.sleep(2000);
			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userroleM, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create User role of Master.");
		}

	}

	@Test
	public void I_TC_CreateRole_Distributor() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an user creating the User Role of Distributor");
		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			up.clickCreate_UserRole();
			Thread.sleep(500);
			up.SetAC_code(userroleD);
			up.SetAC_name(userroleD);
			up.setAssignProfile(userroleD);
			Thread.sleep(500);
			up.AC_Save();
			Thread.sleep(2000);
			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userroleD, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create User role of Distributor.");
		}

	}

	@Test
	public void J_TC_CreateRole_SubDistributor() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an user creating the User Role of SubDistributor");
		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			up.clickCreate_UserRole();
			Thread.sleep(500);
			up.SetAC_code(userroleSD);
			up.SetAC_name(userroleSD);
			up.setAssignProfile(userroleSD);
			Thread.sleep(500);
			up.AC_Save();
			Thread.sleep(2000);
			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userroleSD, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create User role of SubDistributor.");
		}

	}

	@Test
	public void K_TC_CreateRole_Store() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an super admin creating the User Role of Store");
		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			up.clickCreate_UserRole();
			Thread.sleep(500);
			up.SetAC_code(userroleS);
			up.SetAC_name(userroleS);
			up.setAssignProfile(userroleS);
			Thread.sleep(500);
			up.AC_Save();
			Thread.sleep(2000);
			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userroleS, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create User role of Store.");
		}

	}

	@Test
	public void L_TC_CreateRole_POS() throws InterruptedException {
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an super admin creating the User Role of Admin");
		if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
			up.clickCreate_UserRole();
			Thread.sleep(500);
			up.SetAC_code(userrolePOS);
			up.SetAC_name(userrolePOS);
			up.setAssignProfile(userrolePOS);
			Thread.sleep(500);
			up.AC_Save();
			Thread.sleep(2000);
			if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_UserRole_Add.getText() + " of " + userrolePOS, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to create user role", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong!To create User role of POS.");
		}
	}

	@Test
	public void M_TC_Userprofile_CreateAdmin() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create admin ");
		// GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			String role[] = { "AdminS ", "MasterS ", "Distributor ", "SubDistributor ", "Store ", "POS " };
			String ut[] = { "Admin ", "Admin User ", "Dealer ", "Dealer User ", "Dealer User ", "Dealer User " };
			String pu[] = { " System AdmiN ", " Role S ", " Master S ", " Distributor s ", "Subdistributorr S",
					"Store S" };
			for (int i = 0; i <= role.length - 1; i++) {
				GuestPlayers gp1 = new GuestPlayers(driver);
				BaseClass bc1 = new BaseClass();
				gp1.clickCreateNewButton();
				Thread.sleep(2000);
				if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
					Thread.sleep(2000);
					gp1.setFirstName(bc1.Fakefirstname());
					gp1.setLastName(bc1.Fakelastname());
					// gp.selectgender("Male");
					gp1.setDisplayName(bc1.Fakefirstname());
					gp1.Designation.sendKeys("Admin");
					gp1.selectUserRole(role[i]);
					// logger.info("Entered UserRole = " + userroleA + " successfully");
					Thread.sleep(500);
					gp1.selectUserType(ut[i]);
					// logger.info("Entered Usertype = " + usertypeA + " successfully");
					gp1.selectStore(store);
					// test.info("Selected Store successfully");
					gp1.selectparentuser(pu[i]);
					// test.info("Selected parentuser = " + parentuser + " successfully");
					gp1.setEmail(bc1.FakeEmail());
					gp1.setDialCode("+91");
					gp1.setPhone(mobno);
					gp1.setCountry(country);
					// logger.info("Entered Country Successfully");
					Thread.sleep(1000);
					gp1.setState(state);
					// gp.setUsersState(state);
					// logger.info("Entered State Successfully");
					gp1.setCity("Surat");
					// logger.info("Entered City Successfully");
					gp1.setZipcode(pincode);
					// logger.info("Entered Pincode Successfully");
					gp1.setsingleTransactionSweepTokenLimit(PTSTL);
					// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
					gp1.setdailySweepTokenLimit(PDTSTL);
					// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
					// gp1.Timezone.click();
					// gp1.editTimezone(Timezone);
					Thread.sleep(500);
					// gp1.RPP.click();
					// gp1.editRPP(PPR);
					Thread.sleep(500);
					// logger.info("Selected UserRole successfully");
					gp1.selectgender("Male");
					// logger.info("Selected Gender successfully");
					gp1.ClickSave();
					Thread.sleep(10000);

//				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
//					Assert.assertTrue(true);
//					logger.info("Successfully Added  New User in User Management->Users List.");
//				} else {
//					Assert.assertTrue(false);
//					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
//				}
//			} else {
//				logger.info("Something wrong!To Open Create User Management->Users");
//				Assert.assertTrue(false);
//			}
				}
			}
		}
	}

	@Test
	public void A_AN_TC_Userprofile_CreateAdmin() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create admin ");
//		GuestPlayers gp = new GuestPlayers(driver);
//		UserPage up = new UserPage(driver);
//		up.clickUsermanagementButton();
//		Thread.sleep(500);
//		up.clickUserProfile();
//		Thread.sleep(500);
//		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
//			logger.info("Opened UserManagement->Users Successfully");
//			gp.clickCreateNewButton();
//
//			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
//				Thread.sleep(2000);
//				gp.setFirstName(Firstnm);
//				gp.setLastName(Lastnm);
//				// gp.selectgender("Male");
//				gp.setDisplayName(Usernm);
//				gp.Designation.sendKeys("Admin");
//				gp.selectUserRole(userroleA);
//				// logger.info("Entered UserRole = " + userroleA + " successfully");
//				Thread.sleep(500);
//				gp.selectUserType(usertypeA);
//				// logger.info("Entered Usertype = " + usertypeA + " successfully");
//				gp.selectStore(store);
//				// test.info("Selected Store successfully");
//				gp.selectparentuser(parentuser);
//				// test.info("Selected parentuser = " + parentuser + " successfully");
//				gp.setEmail(Email);
//				gp.setDialCode("+91");
//				gp.setPhone(mobno);
//				gp.setCountry(country);
//				// logger.info("Entered Country Successfully");
//				Thread.sleep(1000);
//				gp.setState(state);
//				// gp.setUsersState(state);
//				// logger.info("Entered State Successfully");
//				gp.setCity("Surat");
//				// logger.info("Entered City Successfully");
//				gp.setZipcode(pincode);
//				// logger.info("Entered Pincode Successfully");
//				gp.setsingleTransactionSweepTokenLimit(PTSTL);
//				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
//				gp.setdailySweepTokenLimit(PDTSTL);
//				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
//				// gp.Timezone.click();
//				// gp.editTimezone(Timezone);
//				Thread.sleep(500);
//				// gp.RPP.click();
//				// gp.editRPP(PPR);
//				Thread.sleep(500);
//				// logger.info("Selected UserRole successfully");
//				gp.selectgender("Male");
//				// logger.info("Selected Gender successfully");
//				// gp.ClickSave();
//				Thread.sleep(5000);
//
//				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
//					Assert.assertTrue(true);
//					logger.info("Successfully Added  New User in User Management->Users List.");
//				} else {
//					Assert.assertTrue(false);
//					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
//				}
//			} else {
//				logger.info("Something wrong!To Open Create User Management->Users");
//				Assert.assertTrue(false);
//			}
//		}
		CreateUserProfile("Distributor ", Usernm, store, parentuser);
	}

	public void CreateUserProfile(String roles,String username,String Store,String parent) throws InterruptedException {
		
		//test = extentCreateTest("TC - As an super admin  I should be able to create admin ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		up.ClickOnBack();
		Thread.sleep(1000);
		
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);		
				gp.setDisplayName(username);
				gp.Designation.sendKeys("website user");
				Thread.sleep(1000);
				gp.selectUserRole(roles);		
				Thread.sleep(01000);
				//gp.selectUserType(usertypeA);
				gp.selectStore(Store);
				gp.selectparentuser(parent);			
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);				
				Thread.sleep(1000);
				gp.setState(state);				
				gp.setCity("Surat");				
				gp.setZipcode(pincode);			
				gp.setsingleTransactionSweepTokenLimit(PTSTL);			
				gp.setdailySweepTokenLimit(PDTSTL);			
				Thread.sleep(500);				
				gp.selectgender("Male");	
				Thread.sleep(5000);
				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User ->"+Email+" in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}
		
	}

	@Test
	public void N_TC_Userprofile_CreateMaster() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create Master ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				// gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("Master");
				gp.selectUserRole(userroleM);
				logger.info("Entered UserRole = " + userroleM + " successfully");
				Thread.sleep(500);
				gp.selectUserType(usertypeAU);
				logger.info("Entered Usertype = " + usertypeAU + " successfully");
				gp.selectStore(store);
				test.info("Selected Store successfully");
				gp.selectparentuser(parentuserA);
				test.info("Selected parentuser = " + parentuserA + " successfully");
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);
				// logger.info("Entered Country Successfully");
				Thread.sleep(1000);
				gp.setState(state);
				// gp.setUsersState(state);
				// logger.info("Entered State Successfully");
				gp.setCity("Surat");
				// logger.info("Entered City Successfully");
				gp.setZipcode(pincode);
				// logger.info("Entered Pincode Successfully");
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				// gp.Timezone.click();
				// gp.editTimezone(Timezone);
				Thread.sleep(500);
				// gp.RPP.click();
				// gp.editRPP(PPR);
				Thread.sleep(500);
				// logger.info("Selected UserRole successfully");
				gp.selectgender("Male");
				// logger.info("Selected Gender successfully");
				// gp.ClickSave();
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void O_TC_Userprofile_CreateDistributor() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create DIstributor ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				// gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("Distributor");
				gp.selectUserRole(userroleD);
				logger.info("Entered UserRole = " + userroleD + " successfully");
				Thread.sleep(500);
				gp.selectUserType(usertypeD);
				logger.info("Entered Usertype = " + usertypeD + " successfully");
				gp.selectStore(store);
				test.info("Selected Store successfully");
				gp.selectparentuser(parentuserm);
				test.info("Selected parentuser = " + parentuserm + " successfully");
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);
				// logger.info("Entered Country Successfully");
				Thread.sleep(1000);
				gp.setState(state);
				// gp.setUsersState(state);
				// logger.info("Entered State Successfully");
				gp.setCity("Surat");
				// logger.info("Entered City Successfully");
				gp.setZipcode(pincode);
				// logger.info("Entered Pincode Successfully");
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				// gp.Timezone.click();
				// gp.editTimezone(Timezone);
				Thread.sleep(500);
				// gp.RPP.click();
				// gp.editRPP(PPR);
				Thread.sleep(500);
				// logger.info("Selected UserRole successfully");
				gp.selectgender("Male");
				// logger.info("Selected Gender successfully");
				// gp.ClickSave();
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void P_TC_Userprofile_CreateSubDistributor() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create Sub Distributor ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				// gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("SubDistributor");
				gp.selectUserRole(userroleSD);
				logger.info("Entered UserRole = " + userroleSD + " successfully");
				Thread.sleep(500);
				gp.selectUserType(usertypeDU);
				logger.info("Entered Usertype = " + usertypeDU + " successfully");
				gp.selectStore(store);
				test.info("Selected Store successfully");
				gp.selectparentuser(parentuserd);
				test.info("Selected parentuser = " + parentuserd + " successfully");
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);
				// logger.info("Entered Country Successfully");
				Thread.sleep(1000);
				gp.setState(state);
				// gp.setUsersState(state);
				// logger.info("Entered State Successfully");
				gp.setCity("Surat");
				// logger.info("Entered City Successfully");
				gp.setZipcode(pincode);
				// logger.info("Entered Pincode Successfully");
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				// gp.Timezone.click();
				// gp.editTimezone(Timezone);
				Thread.sleep(500);
				// gp.RPP.click();
				// gp.editRPP(PPR);
				Thread.sleep(500);
				// logger.info("Selected UserRole successfully");
				gp.selectgender("Male");
				// logger.info("Selected Gender successfully");
				// gp.ClickSave();
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void Q_TC_Userprofile_CreateStore() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create Store ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();
			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				// gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("Store");
				gp.selectUserRole(userrolePOS);
				logger.info("Entered UserRole = " + userrolePOS + " successfully");
				Thread.sleep(500);
				gp.selectUserType(usertypeDU);
				logger.info("Entered Usertype = " + usertypeDU + " successfully");
				gp.selectStore(store);
				test.info("Selected Store successfully");
				gp.selectparentuser(parentusersd);
				test.info("Selected parentuser = " + parentusersd + " successfully");
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);
				// logger.info("Entered Country Successfully");
				Thread.sleep(1000);
				gp.setState(state);
				// gp.setUsersState(state);
				// logger.info("Entered State Successfully");
				gp.setCity("Surat");
				// logger.info("Entered City Successfully");
				gp.setZipcode(pincode);
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				// gp.Timezone.click();
				// gp.editTimezone(Timezone);
				Thread.sleep(500);
				// gp.RPP.click();
				// gp.editRPP(PPR);
				Thread.sleep(500);
				// logger.info("Selected UserRole successfully");
				gp.selectgender("Male");
				// logger.info("Selected Gender successfully");
				// gp.ClickSave();
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}

	}

	@Test
	public void R_TC_Userprofile_CreatePOS() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to create POS ");
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			logger.info("Opened UserManagement->Users Successfully");
			gp.clickCreateNewButton();
			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				// gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys("POS");
				gp.selectUserRole(userrolePOS);
				logger.info("Entered UserRole = " + userrolePOS + " successfully");
				Thread.sleep(500);
				gp.selectUserType(usertypeDU);
				logger.info("Entered Usertype = " + usertypeDU + " successfully");
				gp.selectStore(store);
				test.info("Selected Store successfully");
				gp.selectparentuser(parentusermpos);
				test.info("Selected parentuser = " + parentusermpos + " successfully");
				gp.setEmail(Email);
				gp.setDialCode("+91");
				gp.setPhone(mobno);
				gp.setCountry(country);
				// logger.info("Entered Country Successfully");
				Thread.sleep(1000);
				gp.setState(state);
				// gp.setUsersState(state);
				// logger.info("Entered State Successfully");
				gp.setCity("Surat");
				// logger.info("Entered City Successfully");
				gp.setZipcode(pincode);
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				// logger.info("Entered Per Transaction Sweep Tokens Limit Successfully");
				gp.setdailySweepTokenLimit(PDTSTL);
				// logger.info("Entered Per Day Transaction Sweep Tokens Limit Successfully");
				// gp.Timezone.click();
				// gp.editTimezone(Timezone);
				Thread.sleep(500);
				// gp.RPP.click();
				// gp.editRPP(PPR);
				Thread.sleep(500);
				// logger.info("Selected UserRole successfully");
				gp.selectgender("Male");
				// logger.info("Selected Gender successfully");
				// gp.ClickSave();
				Thread.sleep(5000);

				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					Assert.assertTrue(true);
					logger.info("Successfully Added  New User in User Management->Users List.");
				} else {
					Assert.assertTrue(false);
					logger.info("Something Wrong!To View Added User Management->Users in Users List.");
				}
			} else {
				logger.info("Something wrong!To Open Create User Management->Users");
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void S_TC_AccesContolToggle() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to access control on user profile ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("POSm");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(500);
		for (int i = 0; i < Alerts.length; i++) {
			test.info("controlling Access contol of " + Alerts[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(Alerts[i]);
			logger.info("Clicking on " + Alerts[i]);
		}
		System.out.println(
				"_____________________DashboardManagement______________________________________________________________");

		for (int i = 0; i < DashboardManagement.length; i++) {
			test.info("controlling Access contol of " + DashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(DashboardManagement[i]);
			logger.info("Clicking on " + DashboardManagement[i]);
		}
		System.out.println(
				"______________________________PlayerManagement_____________________________________________________");

		for (int i = 0; i < PlayerManagement.length; i++) {
			test.info("controlling Access contol of " + PlayerManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(PlayerManagement[i]);
			logger.info("Clicking on " + PlayerManagement[i]);

		}
		System.out.println(
				"________________________SupportManagement___________________________________________________________");
		for (int i = 0; i < SupportManagement.length; i++) {
			test.info("controlling Access contol of " + SupportManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(SupportManagement[i]);
			logger.info("Clicking on " + SupportManagement[i]);
		}
		System.out.println(
				"_________________________UserManagement__________________________________________________________");

		for (int i = 0; i < UserManagement.length; i++) {
			test.info("controlling Access contol of " + UserManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(UserManagement[i]);
			logger.info("Clicking on " + UserManagement[i]);
		}

		System.out.println("___________________________________________________________________________________");

//    	up.AccessControlToggle("Profile & Dashboard","true");
//    	up.AccessControlToggle("Reputations","true");
//    	up.AccessControlToggle("State","true");
//    	up.AccessControlToggle("Redeemable Tokens","true");
//		up.clickToSave();
//		Thread.sleep(1000);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			Assert.assertTrue(true);
//			test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
//		} else {
//			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
//			Assert.assertTrue(false);
//		}
//		Thread.sleep(5000);

	}

	@Test
	public void T_TC_AccesContolToggle() throws IOException, InterruptedException {
		test = extentCreateTest("TC - As an super admin  I should be able to access control on user profile ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("POSm");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		System.out.println("_______________________________Alerts____________________________________________________");
		for (int i = 0; i < Alerts.length; i++) {
			test.info("controlling Access contol of " + Alerts[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(Alerts[i]);
			logger.info("Clicking on " + Alerts[i]);
		}
		System.out.println(
				"_______________________________DashboardManagement____________________________________________________");

		for (int i = 0; i < DashboardManagement.length; i++) {
			test.info("controlling Access contol of " + DashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(DashboardManagement[i]);
			logger.info("Clicking on " + DashboardManagement[i]);
		}
		System.out.println(
				"______________________________PlayerManagement_____________________________________________________");

		for (int i = 0; i < PlayerManagement.length; i++) {
			test.info("controlling Access contol of " + PlayerManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(PlayerManagement[i]);
			logger.info("Clicking on " + PlayerManagement[i]);

		}
		System.out.println(
				"________________________________StoreManagement___________________________________________________");
		for (int i = 0; i < StoreManagement.length; i++) {
			test.info("controlling Access contol of " + StoreManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(StoreManagement[i]);
			logger.info("Clicking on " + StoreManagement[i]);

		}
		System.out.println(
				"____________________________________SupportManagement_______________________________________________");
		for (int i = 0; i < SupportManagement.length; i++) {
			test.info("controlling Access contol of " + SupportManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(SupportManagement[i]);
			logger.info("Clicking on " + SupportManagement[i]);

		}
		System.out.println(
				"_______________________________UserManagement____________________________________________________");

		for (int i = 0; i < UserManagement.length; i++) {
			test.info("controlling Access contol of " + UserManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(UserManagement[i]);
			logger.info("Clicking on " + UserManagement[i]);

		}
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);

	}

	@Test
	public void T_AccessControlOfAlerts() throws InterruptedException {
		test = extentCreateTest("TC - Access control Alerts-> Announcement ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		String[] Alerts = { "Announcement Listing", "Notification Listing" };
		for (int i = 0; i < Alerts.length; i++) {
			test.info("controlling Access contol of " + Alerts[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(Alerts[i]);
			logger.info("Clicking on " + Alerts[i]);
		}
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickAlertsButton();
		extentScreenshot();
		
	}
	@Test
	public void Ta_AccessControlOfAlerts() throws InterruptedException {
		test = extentCreateTest("TC - Access control Alerts-> Announcement ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		String[] Alerts = { "Announcement Listing", "Notification Listing" };
		for (int i = 0; i < Alerts.length; i++) {
			test.info("controlling Access contol of " + Alerts[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(Alerts[i]);
			logger.info("Clicking on " + Alerts[i]);
		}
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickAlertsButton();
		if (driver.findElement(By.xpath("//button[contains(text(),'Notifications')]")).isDisplayed()) {
			test.pass("Successfully viewd notifiction tab and announcements tab", extentScreenshot());
			Assert.assertTrue(true);
		} else if (driver.findElement(By.xpath("//button[contains(text(),'Announcement')]")).isDisplayed()) {
			test.pass("Successfully viewd notifiction tab and announcements tab", extentScreenshot());
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To close the alerts tab", extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void Tb_AccessControlOfDashboardManagement() throws InterruptedException {
		test = extentCreateTest(
				"TC - As an admin  I should be able to verify access control Dashboard Management-> Announcement ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		String[] DashboardManagement = { "Player Transaction", "Daily Purchase", "Player Location", "Most Active Games",
				"Total Game", "Latest Withdraw Requests", "Most Player Login", "Total Purchase", "Total Spins",
				"Total Player", "Latest Purchase History" };

		for (int i = 0; i < DashboardManagement.length; i++) {
			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickAccessControl();
			Thread.sleep(1000);
			gp.Search_Items("GAMEIUM_ADMIN");
			Thread.sleep(2000);
			up.clickToEdit();
			Thread.sleep(5000);
			test.info("controlling Access contol of " + DashboardManagement[i]);
			UserPage up1 = new UserPage(driver);
			up1.AccessControlToggleViewFull(DashboardManagement[i]);
			logger.info("Clicking on " + DashboardManagement[i]);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(1000);
			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText());
			} else {
				test.fail("Something Wrong ! not able to create accress control");
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);

			bc.PageReload();
			up.ClickOnDashboard();
			Thread.sleep(3000);
			// up.ClickAlertsButton();
			if (driver.findElement(By.xpath("//h2[contains(text(),'Dashboard')]")) != null) {
				Thread.sleep(3000);
				if (driver.findElements(By.linkText(" //h4[contains(text(),'Player Transaction')]" )).size() > 0  ) {
					test.pass("Successfully viewed on dashboard ", extentScreenshot());
					Assert.assertTrue(true);
				}

			} else {
				test.fail("Something wrong!To close the alerts tab", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_ProfileDashboard() throws InterruptedException {
		test = extentCreateTest(
				"TC - As an admin  I should be able to verify access control Player Management-> Profile & Dashboard ");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		up.AccessControlToggleViewFull("Profile & Dashboard");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(1000);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.clickOnPlayerProfileActionEye();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Profile')]")).isDisplayed() ) {
			test.pass("Successfully viewed Profile & Dashboard tab ", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Profile & Dashboard tab", extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_ManageTokens() throws InterruptedException {
		test = extentCreateTest(
				"TC - As an admin  I should be able to verify access control Player Management-> Manage Tokens");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		up.AccessControlToggleViewFull("Manage Tokens");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Manage Tokens')]")).isDisplayed()) {
			test.pass("Successfully viewed player profile Manage Tokens  ", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Profile Manage Tokens tab", extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_Store() throws InterruptedException {
		test = extentCreateTest("TC - As an admin  I should be able to verify access control Player Management->PlayerProfile Dashboard");
		String[] profile = { "Reputations", "State", "Gender", "City", "Display Name", "Country", "Phone", "Email",
				"Created By", "Zip Code", "Updated At", "Created At", "Store", "Updated By", };
		for (int i = 0; i < profile.length; i++) {
			UserPage up = new UserPage(driver);
			GuestPlayers gp = new GuestPlayers(driver);
			CommonCosmo cc = new CommonCosmo(driver);
			PlayerProfile pp = new PlayerProfile(driver);
			up.clickUsermanagementButton();
			Thread.sleep(500);
			up.clickAccessControl();
			Thread.sleep(1000);
			gp.Search_Items("GAMEIUM_ADMIN");
			Thread.sleep(2000);
			up.clickToEdit();
			Thread.sleep(5000);
			logger.info("Clicking on " + profile[i]);
			up.AccessControlToggleViewFull(profile[i]);
			Thread.sleep(3000);
			up.clickToSave();
			Thread.sleep(500);
			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("" + cc.Validation_Format_AccessControl.getText());
			} else {
				test.fail("Something Wrong ! not able to create accress control");
				Assert.assertTrue(false);
			}
			Thread.sleep(5000);
			bc.PageReload();
			Thread.sleep(2000);
			pp.clickOnPlayerManagement();
			pp.clickOnPlayerProfile();
			Thread.sleep(1000);
			pp.Clickeyeicon();
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//li//span[contains(text(),'" +profile[i]+ "')]")).isDisplayed()) {
				test.pass("Successfully viewed player profile "+profile[i], extentScreenshot());
				Assert.assertTrue(true);

			} else {
				test.fail("Something wrong!To views the player profile Store", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
	}
	
	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_PlayerLedger() throws InterruptedException {
		test = extentCreateTest(
				"TC - As an admin  I should be able to verify access control Player Management-> Player Ledger");
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		up.AccessControlToggleViewFull("Player Ledger");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//button[contains(text(),'Player Ledger')]")).isDisplayed()) {
			test.pass("Successfully viewed player profile Manage Tokens  ", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Profile Manage Tokens tab", extentScreenshot());
			Assert.assertTrue(false);
		}
	}
	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_PlayerLedgerST() throws InterruptedException {
		test = extentCreateTest("TC - As an admin  I should be able to verify access control Player Management-> Player Ledger Sweep Tokens");
		//String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		up.AccessControlToggleViewFull("Sweep Tokens");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		pp.clickPlayerLedgerTab();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='Token Type']/following::tr//td[contains(text(),'Sweep Token')]")).isDisplayed()) {
			test.pass("Successfully viewed player profile Sweep Tokens", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the Profile Manage Tokens tab", extentScreenshot());
			Assert.assertTrue(false);
		}
	}
	@Test
	public void Tb_AccessControlOfPlayerManagement_PlayerProfile_PlayerLedgerGT() throws InterruptedException {
		test = extentCreateTest("TC - As an admin  I should be able to verify access control Player Management-> Player Ledger Sweep Tokens");
		//String[] PLSTGT= {"Sweep Tokens","Game Tokens"};
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		gp.Search_Items("GAMEIUM_ADMIN");
		Thread.sleep(2000);
		up.clickToEdit();
		Thread.sleep(5000);
		up.AccessControlToggleViewFull("Game Tokens");
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_Format_AccessControl.getText());
		} else {
			test.fail("Something Wrong ! not able to create accress control");
			Assert.assertTrue(false);
		}
		Thread.sleep(5000);
		bc.PageReload();
		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(500);
		pp.clickPlayerLedgerTab();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//th[text()='Token Type']/following::tr//td[contains(text(),'Game Token')]")).isDisplayed()) {
			test.pass("Successfully viewed player ledger Game Tokens", extentScreenshot());
			Assert.assertTrue(true);

		} else {
			test.fail("Something wrong!To views the player ledger Game Tokens tab", extentScreenshot());
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void TC_StoreManagement_InactiveStoreUser() throws InterruptedException {
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		test =extentCreateTest("As an admin I should be able to inactive the store user");
		
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserProfile();;
		Thread.sleep(1000);
		gp.Search_Items("Cosmoslots Store");
		Thread.sleep(2000);
		up.ClickonStatusToggle();
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("//h2[contains(text(),'Are you sure, ')]")).size()>0) {
			up.ClickonYesBtn();
			Thread.sleep(1000);
			if(cc.Validation_Format_UserProfiledeactivated.isDisplayed()){
				test.pass("User Profile activated successfully", extentScreenshot());
				Assert.assertTrue(true);
			}else{
				test.fail("Something wrong!To save user profile");
				Assert.assertTrue(false);
			}
		}
		
	}
	
	

//		Thread.sleep(3000);
//		up.clickToSave();
//		Thread.sleep(1000);
//		if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
//			Assert.assertTrue(true);
//			test.pass("" + cc.Validation_Format_AccessControl.getText(), extentScreenshot());
//		} else {
//			test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
//			Assert.assertTrue(false);
//		}
//		Thread.sleep(5000);
//
//		bc.PageReload();
//		up.ClickOnDashboard();
//		 Thread.sleep(3000);
//		// up.ClickAlertsButton();
//		if (driver.findElements(By.linkText("//button[contains(text(),'Dashboard')]")).size() > 0) {
//			test.pass("Successfully viewed dashboard ",extentScreenshot());
//			Assert.assertTrue(true);
//		} else {
//			test.fail("Something wrong!To close the alerts tab", extentScreenshot());
//			Assert.assertTrue(false);
//		}

//    if(driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null)
//    {
//		test.pass("Opened UserManagement->Users Successfully");
//    	gp.clickCreateNewButton();
//		if(driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")).isDisplayed()) 
//    	{
//    		gp.setFirstName(Firstnm);
//			gp.setLastName(Lastnm);
//			gp.setDisplayName(Usernm);
//			gp.selectUserRole(userroleA);
//			gp.Designation.sendKeys("Admin");
//			gp.selectUserType(usertypeA);
//			gp.selectStore(store);
//			gp.selectparentuser(parentuser);
//			gp.setEmail(Email);
//			gp.setCountry(country);
//			gp.setState(state);
//			gp.setsingleTransactionSweepTokenLimit(PTSTL);
//			gp.setdailySweepTokenLimit(PDTSTL);
//			gp.ClickSave();
//			Thread.sleep(5000);
//			
//    	}
//		if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null)
//		 {
//		   Assert.assertTrue(true);
//	    	test.info("Successfully Added  New User in User Management->Users List.");
//	      } else {
//		   Assert.assertTrue(false);
//		   test.info("Something Wrong!To View Added User Management->Users in Users List.");
//	}
//    	
//    }else {
//		Assert.assertTrue(false);
//
//    }
//    gp.Search_Items(Usernm);
//}

//    @Test
//    public void B_TC_Userprofile_CreateMaster() throws IOException, InterruptedException {
//    	test = extentCreateTest("TestCase started As an super admin I should be able to create Master ");
//    	GuestPlayers gp = new GuestPlayers(driver);
//    	LobbyPage lp=new LobbyPage(driver);
//    	
//    	UserPage up=new UserPage(driver);
//        up.clickUsermanagementButton();
//        Thread.sleep(500);
//        up.clickUserProfile();
//        Thread.sleep(500);
//        if(driver.findElement(By.xpath("//h3[text()='User Profile']")) != null)
//        {
//    		test.pass("Opened UserManagement->Users Successfully");
//        	gp.clickCreateNewButton();
//        	if(driver.findElement(By.xpath("//h4[text()='Personal Details'])")).isDisplayed())
//        	{
//        		gp.setFirstName(Firstnm);
//    			gp.setLastName(Lastnm);
//    			gp.setDisplayName(Usernm);
//    			gp.selectUserRole(userroleM);
//    			gp.Designation.sendKeys("master");
//    			gp.selectUserType(usertypeAU);
//    			gp.selectStore(store);
//    			gp.selectparentuser(parentuser);
//    			gp.setEmail(Email);
//    			gp.setCountry(country);
//    			gp.setState(state);
//    			gp.setsingleTransactionSweepTokenLimit(PTSTL);
//    			gp.setdailySweepTokenLimit(PDTSTL);
//    			gp.ClickSave();
//    			Thread.sleep(5000);
//    			
//        	}
//    		if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null)
//    		 {
//    		   Assert.assertTrue(true);
//    	    	test.info("Successfully Added  New User in User Management->Users List.");
//    	      } else {
//    		   Assert.assertTrue(false);
//    		   test.info("Something Wrong!To View Added User Management->Users in Users List.");
//    	}
//        	
//        }else {
//    		Assert.assertTrue(false);
//    		  }
//    
//    }
//    @Test
//    public void C_TC_Userprofile_CreateDistributor() throws IOException, InterruptedException {
//    	test = extentCreateTest("TestCase started As an super admin I should be able to create Master ");
//    	GuestPlayers gp = new GuestPlayers(driver);
//    	LobbyPage lp=new LobbyPage(driver);
//    	
//    	UserPage up=new UserPage(driver);
//        up.clickUsermanagementButton();
//        Thread.sleep(500);
//        up.clickUserProfile();
//        Thread.sleep(500);
//        if(driver.findElement(By.xpath("//h3[text()='User Profile']")) != null)
//        {
//    		test.pass("Opened UserManagement->Users Successfully");
//        	gp.clickCreateNewButton();
//        	if(driver.findElement(By.xpath("//h4[text()='Personal Details'])")).isDisplayed())
//        	{
//        		gp.setFirstName(Firstnm);
//    			gp.setLastName(Lastnm);
//    			gp.setDisplayName(Usernm);
//    			gp.selectUserRole(userroleD);
//    			gp.Designation.sendKeys("Distributor");
//    			gp.selectUserType(usertypeD);
//    			gp.selectStore(store);
//    			gp.selectparentuser(parentuserm);
//    			gp.setEmail(Email);
//    			gp.setCountry(country);
//    			gp.setState(state);
//    			gp.setsingleTransactionSweepTokenLimit(PTSTL);
//    			gp.setdailySweepTokenLimit(PDTSTL);
//    			gp.ClickSave();
//    			Thread.sleep(5000);
//    			
//        	}
//    		if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null)
//    		 {
//    		   Assert.assertTrue(true);
//    	    	test.info("Successfully Added  New User in User Management->Users List.");
//    	      } else {
//    		   Assert.assertTrue(false);
//    		   test.info("Something Wrong!To View Added User Management->Users in Users List.");
//    	}
//        	
//        }else {
//    		Assert.assertTrue(false);
//    		  }
}
