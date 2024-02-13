package com.Cosmoslots.testCases;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.pageObjects.CommonCosmo;

public class UserRoleTest extends BaseClass{
	
	UserPage up = new UserPage(driver);
	BaseClass bc = new BaseClass();
	String randNum = RandomStringUtils.randomNumeric(4);
	String AC_Code=randNum;
	String AC_role="POS";
	String AC_name="POS";
	
//	@Test(groups = "admin")
//	public void A_TC_UserRole_GF2_Login() throws IOException, InterruptedException 
//	{
//		LobbyPage lb = new LobbyPage(driver);
//		UserPage up=new UserPage(driver);
//		LoginPage lp = new LoginPage(driver);
//	//	BaseClass bc = new BaseClass();
//	//	bc.Login();
//		
//		test = extentCreateTest("Login User Role");
//
//		
//		test.info("Login TestCase started for game configurator - UserRole");	
//		test.info("URL is opened");
//		
//
//		Thread.sleep(1000);
//		
//		lp.setUserName(username);
//		test.info("Entered username");
//		
//		lp.setPassword(password);
//		test.info("Entered password");
//		
//		Thread.sleep(2000);
//		lp.clickSubmit();
//		
//		Thread.sleep(3000);
// 
//		if(driver.findElements(By.xpath("//span[contains(text(),\"User Management\")]")).size() > 0)
//		{
//			Assert.assertTrue(true);
//			test.info("Login test passed for UserRole Page");			 
//		}
//		else
//		{
//			test.info("Login test failed for UserRole Page");
//			captureScreen(driver,"loginTest");
//			Assert.assertTrue(false);	
//			
//		}
//		test.info("Login TestCase Ended for User Management - UserRole");	
//       
//		Thread.sleep(2000);
// 	
//		test.info("login TestCase-UserRole Ended");
//		 
//	}
	
	@Test(groups = "admin")
	public void B_TC_UserRole_GF2_Add() throws IOException, InterruptedException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	//	BaseClass bc = new BaseClass();
	//	bc.Login();
		test = extentCreateTest("Add User Role");
		
		//test.info("URL is opened");
		test.info("TestCase started   - Add user role");
		
		Thread.sleep(1000);
 
	    up.clickUsermanagementButton();
	    Thread.sleep(500);
//	    up.clickUserManagement();
//	    Thread.sleep(1500);
	    up.clickUserRole();
	    Thread.sleep(3000);
	    up.clickCreate_UserRole();
		Thread.sleep(1000);

		//Add User Role code 	
		up.SetAC_code(AC_Code);
		up.SetAC_name(AC_name);
		test.info("Create role = "+ AC_Code);
		up.setAssignProfile(AC_role);	 
		//save button clicked 
		up.AC_Save();
 
		test.info("TestCase-AC Ended");
		Thread.sleep(2000);
		
		if(cc.Validation_Format_UserRole_Add.isDisplayed()==true){
				Assert.assertTrue(true);
				test.pass("UserRole message return",extentScreenshot());
		}else{
				test.fail("Something Wrong ! not able to fetch add message",extentScreenshot());
				Assert.assertTrue(false);	
			}
		Thread.sleep(2000);
		String RoleCreatedDate=driver.findElement(By.xpath("(//th[text()=\"Created At\"]/following::tr//td[contains(@class,\"createdAt\")])[1]")).getText();
		System.out.println(RoleCreatedDate);
		String[] RolecreatedDate=RoleCreatedDate.split(" ");
		System.out.println(RolecreatedDate[0]);

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date Date= new Date();
		String date1= dateFormat.format(Date);
		System.out.println(date1);
 	}
	
	@Test(groups = "admin")
	public void C_TC_UserRole_GF2_Search() throws IOException, InterruptedException,NullPointerException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
	
		test = extentCreateTest("Search User Role");

		
		//search User Role
		test.info("Search UserRole test case start");
		//up.SearchItems(AC_Code);
		//up.searchlist(AC_Code, AC_Code, driver);
		up.clickToSearch(AC_Code);
		
//		List<WebElement> cities = driver.findElements(By.xpath("//*[@id='content']/table/tbody//td[2]")); 
//
//		for(WebElement city : cities) 
//		{
//		 System.out.println(city.getText());
//		}
		 
		//WebElement wb=driver.findElement(By.xpath("//p[text()=\"No record found\"]"));
	        if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) 
	        {
	    	     System.out.println("No record found return in Search page");
	    	     test.info(AC_Code + "record found in search",extentScreenshot());
	    	     driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
	    		 Thread.sleep(1500); 
				 Assert.assertTrue(true);
	        }
	        else {
	    		test.fail("record found in search",extentScreenshot());
	    		//captureScreen(driver, "CreateBonus");
				Thread.sleep(1500);
				lb.ClickToClose_Search();
				Assert.assertTrue(false);
	        }
		Thread.sleep(2000);
		test.info("search UserRole test case end");		
 	}
	
	@Test(groups = "admin")
	public void D_TC_UserRole_GF2_view() throws IOException, InterruptedException,NullPointerException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		test = extentCreateTest("View User Role");
		
		test.info("View UserRole test case start");	
		//view User Role
		Thread.sleep(1500); 
		up.clickToView();
		Thread.sleep(1500);
		if(up.UserRole_TitleView.isDisplayed()==true) {
			Assert.assertTrue(true);
			test.info("UserRole view - title verified");
			up.ClicktoClose();			
			
		}else{
			test.info("Something Wrong ! not able to verify UserRole title");
			Assert.assertTrue(false);	
		}		
		test.info("TestCase-view UserRole Ended");
	}
	
	@Test(groups = "website")
	public void E_TC_UserRole_GF2_edit() throws IOException, InterruptedException,NullPointerException 
	{ 	
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		test = extentCreateTest("Edit User Role");
		
		//edit User Role
		test.info("edit UserRole test case start");
		up.clickToEdit();
		Thread.sleep(2000);
		up.SetAC_name(AC_name);
		//up.setAssignProfile("POS");	 
		up.clickToSave();
		test.info("edit UserRole test case end");
		Thread.sleep(2000);
 	}
	
//	@Test(groups = "website")
//	public void F_TC_UserRole_GF2_delete() throws IOException, InterruptedException,NullPointerException 
//	{
//		LobbyPage lb = new LobbyPage(driver);
//		UserPage up=new UserPage(driver);
//		LoginPage lp = new LoginPage(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//		
//		test = extentCreateTest("Delete User Role");
//
//		
//		test.info("delete UserRole test case start");
//		Thread.sleep(1000);
//		up.ClickToDelete();
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
//			Assert.assertTrue(true);
//			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
//			
//			test.info("UserRole - delete successfully");
//		}else {
//			test.info("Something Wrong ! not able to delete UserRole ");
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(2000);
//		Boolean bool1=cc.Validation_Format_DeletePromotion.isDisplayed();
//		if(bool1==true){
//			Assert.assertTrue(true);
//			test.info("UserRole - delete message return");
//		}else{
//			test.info("Something Wrong ! not able show UserRole delete message ");
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("delete UserRole test case end");
//	}
	
	@Test
	public void G_TC_UserRole_CreatedDateVerifivation() throws InterruptedException 
	{ 
		test = extentCreateTest("View User Role created Date  Verification");
		UserPage up=new UserPage(driver);
//		actioninterface act= new actioninterface();
//		System.out.println(act.getCurrentTime());

    	Calendar cal = Calendar.getInstance(); 
        Date Date= new Date();
        Date now = cal.getTime();
        cal.add(Calendar.SECOND, 120);  // check every time when TC is failed due to time error
        Date later = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
        String date1= dateFormat.format(later);
		System.out.println(date1);
		
		test.info("TC- when user role creating date is "+date1);
		Thread.sleep(1000);
	    up.clickUsermanagementButton();
	    Thread.sleep(500);
	    up.clickUserRole();
	    Thread.sleep(3000);
	    up.clickCreate_UserRole();
		Thread.sleep(1000);
	    up.SetAC_code(AC_Code);
		up.SetAC_name(AC_name);
		test.info("Create role = "+ AC_Code);
		up.setAssignProfile(AC_role);	 
		//save button clicked 
		up.AC_Save();
 
		test.info("TestCase-AC Ended");
		Thread.sleep(2000);
		String RoleCreatedDate=driver.findElement(By.xpath("(//th[text()=\"Created At\"]/following::tr//td[contains(@class,\"createdAt\")])[1]")).getText();
		System.out.println(RoleCreatedDate);
		String[] RolecreatedDate=RoleCreatedDate.split(" ");
	    String createdDate = RolecreatedDate[0]+" "+RolecreatedDate[1];
		System.out.println(createdDate);	
		if(createdDate.equalsIgnoreCase(date1)){
			Assert.assertTrue(true);
			test.pass("Successfully User Role Created Date is "+createdDate,extentScreenshot());
	       }else{
			test.fail("Something Wrong ! not able to created view date",extentScreenshot());
			Assert.assertTrue(false);	
		}
	}
	
	 }

				 