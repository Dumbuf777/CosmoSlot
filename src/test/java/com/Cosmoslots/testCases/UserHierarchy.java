/**
 * 
 */
package com.Cosmoslots.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserHierarchy extends BaseClass {
	BaseClass bc = new BaseClass();
	String r = RandomStringUtils.randomAlphabetic(2);
	String regCode = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
	String randomNum = RandomStringUtils.randomNumeric(4);
	String Firstnm ="";
	String Lastnm = "";
	String Usernm = Firstnm +" "+ Lastnm;
	String Email = Firstnm.toLowerCase() + Lastnm.toLowerCase() + "@yopmail.com";
	String country = "India";
	String Store ="Cosmo-8394";
	String state = "Goa";
	String PTSTL = "1000000";
	String PDTSTL = "1000000";
	String userrole[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };
	String parentRole[] = { "Gameium Admin", "Master", "Distributor", "Sub Distributor", "Store", "POS" };
	String acceslevel[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };
		
//	@Test
	public void A_TC_UserHierarchy_CreateNewAccessControl() throws InterruptedException
	{
		CreateNewAccessControl(acceslevel[0]+r, acceslevel[0]+r);
		CreateNewAccessControl(acceslevel[1]+r, acceslevel[1]+r);
		CreateNewAccessControl(acceslevel[2]+r, acceslevel[2]+r);
		CreateNewAccessControl(acceslevel[3]+r, acceslevel[3]+r);
		CreateNewAccessControl(acceslevel[4]+r, acceslevel[4]+r);	
		CreateNewAccessControl(acceslevel[5]+r, acceslevel[5]+r);	
	}
	
//	@Test
	public void B_TC_UserHierarchy_CreateNewRole() throws InterruptedException
	{
		CreateNewRole(acceslevel[0]+r, acceslevel[0]+r, acceslevel[0]+r, "Gameium Admin");
		CreateNewRole(acceslevel[1]+r, acceslevel[1]+r, acceslevel[1]+r, acceslevel[0]+r);
		CreateNewRole(acceslevel[2]+r, acceslevel[2]+r, acceslevel[2]+r, acceslevel[1]+r);
		CreateNewRole(acceslevel[3]+r, acceslevel[3]+r, acceslevel[3]+r, acceslevel[2]+r);
		CreateNewRole(acceslevel[4]+r, acceslevel[4]+r, acceslevel[4]+r, acceslevel[3]+r);
		CreateNewRole(acceslevel[5]+r, acceslevel[5]+r, acceslevel[5]+r, acceslevel[4]+r);
	}
   
	@Test
	public void C_TC_UserHierarchy_CreateNewUser() throws InterruptedException {
		
		CreateNewUsers("Gameium Admin ",Store, " System AdmiN ");
		CreateNewUsers("Master ",Store, Usernm);
		CreateNewUsers("Distributor ",Store, Usernm);
		CreateNewUsers("Sub Distributor ",Store, Usernm);
		CreateNewUsers("Store ",Store, Usernm);
		CreateNewUsers("POS ",Store, Usernm);
		
		//CreateNewUsers(acceslevel[0]+r,Store, " System AdmiN ");
		//CreateNewUsers(acceslevel[1]+r,Store, Usernm);
		//CreateNewUsers(acceslevel[2]+r,Store, Usernm);
		//CreateNewUsers(acceslevel[3]+r,Store, Usernm);
		//CreateNewUsers(acceslevel[4]+r,Store, Usernm);
		//CreateNewUsers(acceslevel[5]+r,Store, Usernm);
	}
		
	public void CreateNewAccessControl(String accessCode, String accessName) throws InterruptedException {
		test = extentCreateTest("creating New Access Control--> "+accessName);
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickAccessControl();
		Thread.sleep(1000);
		test.info("As an user admin creating the User access control of Access Level Hierarchy");
		if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
			Thread.sleep(2000);
			up.clickCreate_AccessControl();
			Thread.sleep(2000);
			up.SetAC_code(accessCode);
			Thread.sleep(1000);
			up.SetAC_name(accessName);
			Thread.sleep(2000);
			up.clickToSave();
			Thread.sleep(500);
			if (cc.Validation_Format_AccessControl.isDisplayed() == true) {
				Assert.assertTrue(true);
				test.pass("Successfully Added " + cc.Validation_Format_AccessControl.getText() + " for " + accessName);
			} else {
				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(3000);
		}
	}
	
	public void CreateNewRole (String assignACProfile,String roleCode, String roleName,String parentRole ) throws InterruptedException {
		test = extentCreateTest("creating User Role --> "+roleName);
		UserPage up = new UserPage(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		Thread.sleep(500);
		up.clickUserRole();
		Thread.sleep(500);
		test.info("As an admin user creating the User Role of Access Level Hierarchy");
		Thread.sleep(1000);
		up.clickCreate_UserRole();
		Thread.sleep(3000);
		up.setAssignProfile(assignACProfile);
		Thread.sleep(1000);
		up.SetAC_code(roleCode);
		Thread.sleep(1000);
		up.SetAC_name(roleName);
		Thread.sleep(1000);
		up.SelectParentRole(parentRole);
		Thread.sleep(3000);
		up.clickToSave();
		Thread.sleep(500);
		if (cc.Validation_Format_UserRole_Add.isDisplayed() == true) {
			//Assert.assertTrue(true);
			test.pass(cc.Validation_Format_UserRole_Add.getText()+"for"+roleName, extentScreenshot());
		} else {
			test.fail(cc.Validation_Format_UserRole_Exists.getText(), extentScreenshot());
			//Assert.assertTrue(false);
		}
		Thread.sleep(5000);

	}

	public void CreateNewUsers(String roles, String stores, String parentuser) throws InterruptedException {
		test = extentCreateTest("TC - As an super admin I should be able to create new users-> "+roles);
		String Firstnm = bc.Fakefirstname();
		String Lastnm = bc.Fakelastname();
		String Usernm = Firstnm + Lastnm;
		String Email = Firstnm + Lastnm + "@yopmail.com".toLowerCase();
		
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);

		up.ClickOnUserProfile();
		Thread.sleep(2000);
		up.ClickOnBack();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			test.info("Opened User Profile Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
				gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys(roles);
				gp.setEmail(Email);
				gp.setCountry(country);
				gp.setState(state);
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				gp.setdailySweepTokenLimit(PDTSTL);
				gp.selectUserRole(roles);
				if(driver.findElements(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).size()>0) {
					driver.findElement(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).click();
					driver.findElement(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).sendKeys(regCode);
					test.info("Succesfully entered POS registration code",extentScreenshot());
				}
				Thread.sleep(200);
				gp.selectStore(stores);
				Thread.sleep(200);
				gp.selectparentuser(parentuser);
				Thread.sleep(200);
				up.clickToSave();
				Thread.sleep(500);
				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
					//Assert.assertTrue(true);
					test.info("Successfully Added  New User in User Management->Users List.", extentScreenshot());
				} else {
					//Assert.assertTrue(false);
					test.info("Something Wrong!To View Added User Management->Users List.", extentScreenshot());
				}
				Thread.sleep(5000);
			}
		}
	}
	
//	public void A_TC_CreateAccessControl_AccessLevelHierarchy() throws InterruptedException {
//	test = extentCreateTest("creating Access Control-->Access Level Hierarchy ");
//	UserPage up = new UserPage(driver);
//	up.clickUsermanagementButton();
//	Thread.sleep(500);
//	up.clickAccessControl();
//	Thread.sleep(1000);
//	test.info("As an user admin creating the User access control of Access Level Hierarchy");
//	String acceslevel[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };
//	if (driver.findElement(By.xpath("//h3[text()=\"Access Control\"]")) != null) {
//		for (int i = 0; i <= acceslevel.length - 1; i++) {
//
//			UserPage up1 = new UserPage(driver);
//			CommonCosmo cc1 = new CommonCosmo(driver);
//			Thread.sleep(2000);
//			up1.clickCreate_AccessControl();
//			Thread.sleep(3000);
//			up1.SetAC_code(acceslevel[i]+r);
//			up1.SetAC_name(acceslevel[i]+r);
//			Thread.sleep(3000);
//			up1.clickToSave();
//			Thread.sleep(1000);
//			if (cc1.Validation_Format_AccessControl.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass("" + cc1.Validation_Format_AccessControl.getText() + " for " + acceslevel[i]);
//			} else {
//				test.fail("Something Wrong ! not able to create accress control", extentScreenshot());
//				Assert.assertTrue(false);
//			}
//			Thread.sleep(5000);
//		}
//	}
//}
//
//@Test
//public void B_TC_CreateRole_RoleLevelHierarchy() throws InterruptedException {
//	test = extentCreateTest("creating User Role -->For All Access Level Hierarchy ");
//	UserPage up = new UserPage(driver);
//	CommonCosmo cc = new CommonCosmo(driver);
//	up.clickUsermanagementButton();
//	Thread.sleep(500);
//	up.clickUserRole();
//	Thread.sleep(500);
//	test.info("As an admin user creating the User Role of Access Level Hierarchy");
//	String userrole[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };
//	if (driver.findElement(By.xpath("//h3[text()=\"Role\"]")) != null) {
//		for (int i = 0; i <= userrole.length - 1; i++) {
//
//			UserPage up1 = new UserPage(driver);
//			CommonCosmo cc1 = new CommonCosmo(driver);
//			Thread.sleep(3000);
//			up1.clickCreate_UserRole();
//			Thread.sleep(3000);
//			up1.setAssignProfile(parentRole[i]);
//			up1.SetAC_code(userrole[i]+r);
//			up1.SetAC_name(userrole[i]+r);
//			up1.SelectParentRole(parentRole[i+1]);
//			Thread.sleep(3000);
//			up1.clickToSave();
//			Thread.sleep(1000);
//			if (cc1.Validation_Format_UserRole_Add.isDisplayed() == true) {
//				Assert.assertTrue(true);
//				test.pass("" + cc1.Validation_Format_UserRole_Add.getText() + "for" + userrole[i]);
//			} else {
//				test.fail("" + cc1.Validation_Format_UserRole_Exists.getText(), extentScreenshot());
//				Assert.assertTrue(false);
//			}
//			Thread.sleep(5000);
//
//		}
//	}
//}	


}
