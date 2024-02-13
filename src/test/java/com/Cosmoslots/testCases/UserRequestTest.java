package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.pageObjects.CommonCosmo;


public class UserRequestTest extends BaseClass{
	
	UserPage up=new UserPage(driver);
	BaseClass bc = new BaseClass();
	String randNum = RandomStringUtils.randomNumeric(4);
	String AC_Code=randNum;
	
	
	@Test
	public void A_TC_UserRequest_GF001_Login_AccessControl() throws IOException, InterruptedException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		test = extentCreateTest("AccessControl Login");
	//	BaseClass bc = new BaseClass();
	//	bc.Login();
		
		logger.info("Login TestCase started for game configurator - AccessControl");	
		logger.info("URL is opened");
		Thread.sleep(500);

		//lp.ClickDontHaveZzure();
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		Thread.sleep(2000);
		lp.clickSubmit();
		
		Thread.sleep(3000);
 
		if(driver.findElements(By.xpath("//span[contains(text(),\"User Management\")]")).size() > 0)
		{
			Assert.assertTrue(true);
			logger.info("Login test passed for AccessControl Page");
		}
		else
		{
			logger.info("Login test failed for AccessControl Page");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);	
		}
		logger.info("Login TestCase Ended for User Management - AccessControl");	
       
		Thread.sleep(2000);
 	
		logger.info("login TestCase-AccessControl Ended");
 
	}
	
	@Test
	public void B_TC_UserRequest_GF001_AddAccessControl() throws IOException, InterruptedException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	//	BaseClass bc = new BaseClass();
	//	bc.Login();
		
		test = extentCreateTest("Add AccessControl");
		
		//logger.info("URL is opened");
		logger.info("TestCase started   - As an admin user I should be able to click on the 'user Management' link, and can view the access control details.");
		
		Thread.sleep(2000);
 
	    up.clickUsermanagementButton();
	    Thread.sleep(500);
//	    up.clickUserManagement();
//	    Thread.sleep(1500);
	    up.clickAccessControl();
	    Thread.sleep(2000);
 	
	    Thread.sleep(1500);		       
	    up.clickCreate_AccessControl();
		Thread.sleep(1000);

		//Add access control code 	
		up.SetAC_code(AC_Code);
		up.SetAC_name("Test1");
		logger.info("Lobby name = "+ AC_Code);
		
		Thread.sleep(3000);
		//save button clicked 
		up.AC_Save();
			 
		logger.info("TestCase-AC Ended");
		Thread.sleep(1000);
		
		if(cc.Validation_Format_AccessControl.isDisplayed()==true){
				Assert.assertTrue(true);
				logger.info("Access control message");
		}else{
				logger.info("Something Wrong ! not able to fetch add message");
				Assert.assertTrue(false);	
			}
		Thread.sleep(2000);
		
 	}
	@Test
	public void C_TC_UserRequest_GF001_Search() throws IOException, InterruptedException,NullPointerException 
	{
		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
 	
		test = extentCreateTest("Search AccessControl");

		
		//search access control
		logger.info("search Access control test case start");
		//up.SearchItems(AC_Code);
		//up.searchlist(AC_Code, AC_Code, driver);
		up.clickToSearch(AC_Code);
		Thread.sleep(2000);
		logger.info("search Access control test case end");
		
 	}
	@Test
	public void D_TC_UserRequest_GF001_view() throws IOException, InterruptedException,NullPointerException 
	{
		
		UserPage up=new UserPage(driver);
	
		test = extentCreateTest("View AccessControl");

		
		//logger.info("TestCase started view access control - As an admin user I should be able to click on 'view' button to view  access control.");	
	
		//view access control
		Thread.sleep(1500); 
		up.clickToView();
		Thread.sleep(1500);
		if(up.AC_TitleView.isDisplayed()==true) {
			Assert.assertTrue(true);
			logger.info("access control view - title verified");
			up.ClicktoClose();			
			
		}else{
			logger.info("Something Wrong ! not able to verify access control title");
			Assert.assertTrue(false);	
		}
	
		
		logger.info("TestCase-view Access control Ended");
	}
	@Test
	public void E_TC_UserRequest_GF001_edit() throws IOException, InterruptedException,NullPointerException 
	{
 		LobbyPage lb = new LobbyPage(driver);
		UserPage up=new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		
		test = extentCreateTest("Edit AccessControl");

		
		//edit access control
		logger.info("edit Access control test case start");
		up.clickToEdit();
		Thread.sleep(2000);
		up.clickToSave();
		logger.info("edit Access control test case end");
		Thread.sleep(2000);
 	}
	 
}
