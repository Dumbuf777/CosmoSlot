package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.pageObjects.CommonCosmo;



public class MasterSetting extends BaseClass
{
	//BaseClass b = new BaseClass();
	String Lcode = "Store" + new Random().nextInt(10000);
	String randNum = RandomStringUtils.randomNumeric(4);
	String LobbyName=randNum;
	String Search_package="CUST"+randNum;
	String Search_Promotion="CosmoSlots";
	String Verify_Homepage="sub title";	
	String Search_Lobby="Cosmo";
	String Verify_News="News";	
	String Verify_FAQ="sub title";	
	String Search_Lobby_Expected="Cosmoslots";
	String Search_Game="Fortune Teller";
	String Search_Bonus="Registration";
	String Search_BonusName="Registration";
	String Upload_Icon=UploadImage;  //./Cosmoslots/target/image/2_mb.jpg
	String GameName="FOT";
	WebElement OwnerLobbyType=LobbyPage.OwenerBasedradio;
	WebElement AppLobbyType=LobbyPage.AppBasedradio;
	String Country="India";
	String LobbyDescription= "This is just for AutoTesting";
	String SearchAddPlayerURL="yopmail";
	String metadata_title="Redemption Policy";
	String ReleaseNotes="1.1.1";
	String Releaseurl="www.cosmoslots.com";
	String Promotion_Search="Unlock next level to generate new token "+randNum;
	String Search_HomePage="New Home page";
	String News_Create="title1"+randNum;
	
//	@Test(groups = {"admin"})
//	public void A_TC_MasterSetting_Login() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Login for Master Setting Page");
//		
//		LobbyPage lb = new LobbyPage(driver);
// 		LoginPage lp = new LoginPage(driver);
// 		test.info("Login TestCase started for  Master Setting");	
// 		
//		test.info("URL is opened");
//			
//		Thread.sleep(500);
// 		lp.setUserName(username);
//		test.info("Entered username = <b>"+username+"</b>");
// 		
//		lp.setPassword(password);
//		logger.info("Entered password");
//		test.info("Entered password = <b>"+password+"</b>");
//
//		
//		Thread.sleep(2000);
//		lp.clickSubmit();
//		test.info("Clicked Submit button to login");
//		
//		Thread.sleep(3000);
//				
//		if(driver.findElements(By.xpath("//a[contains(@href,'/setting/master-settings')]")).size() > 0)
//		{
//			Assert.assertTrue(true);
//			test.info("Login test passed for  Master Setting");
//			
//			test.pass("<b><i>Login test passed for lobby Page</b></i>", extentScreenshot());
//			lb.MasterSettings_Click();
//			
//			
//		}else{
//			test.info("Login test failed for  Master Setting");
//			captureScreen(driver,"loginTest");
//			test.fail("<b><i>Login test passed for lobby Page</b></i>", extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		test.info("Login TestCase Ended for  Master Setting");	
//	 
//		Thread.sleep(1000);
//		
//		test.info("TestCase- Master Setting Ended");
//		
//	}
	
	@Test(groups={"admin"})
	public void B_TC_MasterSetting_Version_save() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Lobby Version View");

		Thread.sleep(1000);
		
		test.info("TestCase started view Lobby_Version- As an admin user I should be able to view Lobby_Version");	
		LobbyPage lb = new LobbyPage(driver);		
		CommonCosmo cc=new CommonCosmo(driver);
		
		
		lb.MasterSettings_Click();
		test.info("Click on Master settings");
		lb.clickViewLobby_Version();
		test.info("Click on lobby version");
		Thread.sleep(1000); 
		
		//----save version--------
		if(lb.ViewLobby_LobbyVersion_Android.getText().equalsIgnoreCase("Android")) {
			Assert.assertTrue(true);
			test.info("Successfully verify Android version label.");
			//test.pass("Successfully verify Android version label.",extentScreenshot());
			lb.clickViewLobby_ReviewVersion_Android("1.0");
			lb.clickViewLobby_ProductionVersion_Android("1.0");
		} else {
			test.info("Something Wrong! not verify Android version label.");
			//test.pass("not verify Android version label.",extentScreenshot());
			Assert.assertTrue(false);
		}
		if(lb.ViewLobby_LobbyVersion_ios.getText().equalsIgnoreCase("IOS")) {
			Assert.assertTrue(true);
			test.info("Successfully verify IOS version label.");
			//test.pass("Successfully verify IOS version label.",extentScreenshot());
			lb.clickViewLobby_ReviewVersion_IOS("1.0");
			lb.clickViewLobby_ProductionVersion_IOS("1.0");
		} else {
			test.info("Something Wrong! not verify IOS version label.");
			//test.pass("not verify IOS version label.",extentScreenshot());
			Assert.assertTrue(false);
		}
		lb.ClickToSave();
		test.info("lobby version saved sucessfully");
		Thread.sleep(500);
		
//		//-----delete version-------
//		if(lb.DeleteVersion.isDisplayed()==true) {
//			Assert.assertTrue(true);
//			//test.info("Successfully delete lobby version.");
//			test.pass("Successfully delete lobby version.",extentScreenshot());
//			lb.DeleteVersion();
//		}else {
//			//test.info("Something Wrong! not able to delete lobby version");
//			test.fail("not delete lobby version.",extentScreenshot());
//			Assert.assertTrue(false);
//		}
				 
	}
	
	@Test(groups = {"admin"})
	public void D_TC_MasterSetting_Maintenance() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Maintenance");

		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		
		Thread.sleep(2000);
		
		if(driver.findElements(By.xpath("//div[contains(text(),'Lobby Maintenance')]")).size() > 0)
		{
			Assert.assertTrue(true);
			
			lb.LobbyMaintenance_Click();
			test.info("Redirect on Lobby Maintenance section");
			Thread.sleep(500);
			test.info("Lobby Maintenance displayed",extentScreenshot());
			
			//lb.Click_Maintenance_platform();
			test.info("Clicked on Lobby under Maintenance mode");
			lb.Maintenance_Desc("Lobby under Maintenance mode");
			test.info("Description added successfully");
			lb.ClickToSave();
			test.info("Clicked on saved button");
			Thread.sleep(500);
			lb.ClickToYes();
			test.info("Clicked to lobby Maintenance activated");
			
			Thread.sleep(3000);
			
			if(cc.Validation_Format_Lobby_Maintenance_saved.isDisplayed()==true){
				Assert.assertTrue(true);			
				test.pass("<b><i>Lobby maintenance data saved successfully</b></i>", extentScreenshot());
		 }else{
				test.fail("<b><i>Lobby maintenance data saved successfully message not displayed</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
		  }	
		}
		else
		{
			test.fail("Store Account Maintenance label not found",extentScreenshot());
		}				
		Thread.sleep(1500);
		test.info("TestCase Store Maintenance Ended");
	}
	@Test(groups = {"admin"})
	public void E_TC_MasterSetting_Lobby_Info() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Lobby Version delete"); 
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		
		lb.LobbyInfo_Click();
		test.info("Click on lobby info");
		Thread.sleep(500); 
		
		lb.ClickToSave();
	
		Thread.sleep(3000);
		
		if(cc.Validation_Format_StoreMaintenance_update.isDisplayed()==true){
			Assert.assertTrue(true);			
			test.pass("<b><i>Lobby Info - Store maintenance data update successfully</b></i>", extentScreenshot());

	 }else{
		test.fail("<b><i>Lobby Info - Store maintenance data update successfully message not displayed</b></i>", extentScreenshot());
		Assert.assertTrue(false);	
	 }		
	}
	
	@Test(groups = {"admin","website"})
	public void MasterSetting_GeneralPages_Website(String section,String value) throws InterruptedException 
	{
		
//		Actions actions = new Actions(driver);
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

		driver.findElement(By.xpath("(//a[contains(text(),'"+section+"')])[1]")).sendKeys(Keys.CONTROL, Keys.END);
		Thread.sleep(1000);			
		driver.findElement(By.cssSelector("html")).sendKeys(Keys.CONTROL, Keys.END);
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("window.scrollBy(0,1200000)", "");
//		js.executeScript("window.scrollBy(0,1200000)", "");
//		js.executeScript("window.scrollBy(0,1200000)", "");
		
//		js.executeScript("arguments[0].scrollIntoView();", element);
//		js.executeScript("window.scrollBy(0,1200000)", "");
		
		if(driver.findElements(By.xpath("(//a[text()='"+section+"'])[1]")).size()>0)
		{
			Thread.sleep(1000);			
			driver.findElement(By.xpath("(//a[contains(text(),'"+section+"')])[1]")).click();
			Thread.sleep(2000);
			
//			if you want to verify cms page inner text			
			if(driver.findElements(By.xpath("(//*[contains(text(),'"+value+"')])[1]")).size()>0)
			{
				System.out.println("cms page print-"+section+"---"+value);
				test.pass("<b><i>"+section+" verified with data</b></i> -"+value+ "", extentScreenshot());
			}
			else
			{
				System.out.println("cms page not print-"+section+"---"+value);
				test.fail("<b><i>"+section+" not verified with data</b></i> -"+value+ "", extentScreenshot());
			}
		}
		else
		{
			System.out.println("cms page "+section+" not found-"+"---"+value);
			test.fail("<b><i>cms page -"+section+" not found </b></i> -"+value+ "", extentScreenshot());
		}
		Thread.sleep(1000);			
		
	}
	@Test(groups = {"admin","website"})
	public void MasterSetting_GeneralPages_Website_FooterDescription(String section) 
	{
		if(driver.findElements(By.xpath("//*[contains(text(),'"+section+"')]")).size()>0)
		{	
			System.out.println("Footer text -"+section);			
		}
		else
		{
				System.out.println("Footer page not found-"+section+"---");
		}
	}
	
	@Test(groups = {"admin","website"})
	public void F_TC_MasterSetting_GeneralPages() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Lobby General Pages"); 
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		lb.MasterSettings_Click();
		Thread.sleep(1000);
		lb.GeneralPages_Click();
		test.info("Click on General Pages");
		Thread.sleep(500); 
		
		if(driver.findElements(By.xpath("//h4//span[text()='General Info']")).size() > 0)
		{
			test.info("Store General Info label displayed");			
			
			if(driver.findElements(By.xpath("//mat-label[normalize-space()='Footer Description']")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[1]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[1]")).sendKeys("General Info-Footer");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				Thread.sleep(1000);
				BaseClass.gotoTab(driver,1);
				Thread.sleep(1000);
				MasterSetting_GeneralPages_Website_FooterDescription("General Info-Footer");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>General Info-Footer verified</b></i>", extentScreenshot());
				
			}
			else
			{
				test.fail("Footer Description not displayed</b></i>", extentScreenshot());				
			}
			
			if(driver.findElements(By.xpath("//mat-label[normalize-space()='Responsible Gaming']")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[2]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[2]")).sendKeys("Responsible Gaming1");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				BaseClass.gotoTab(driver,1);
				Thread.sleep(1000);
				MasterSetting_GeneralPages_Website("Responsible Gaming","Responsible Gaming1");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>Responsible Gaming verified</b></i>", extentScreenshot());
				
				
			}else{
				test.fail("<b><i>Responsible Gaming not displayed</b></i>", extentScreenshot());
				
			}
			if(driver.findElements(By.xpath("//mat-label[normalize-space()='Redemption Policy']")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[3]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[3]")).sendKeys("Redemption Policy1");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				BaseClass.gotoTab(driver,1);	Thread.sleep(1000);
				MasterSetting_GeneralPages_Website("Redemption Policy","Redemption Policy1");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>Redemption Policy verified</b></i>", extentScreenshot());
				
				
			}else{
				test.fail("<b><i>Redemption Policy not displayed</b></i>", extentScreenshot());
				
			}
			if(driver.findElements(By.xpath("//mat-label[normalize-space()='Terms & Conditions']")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[4]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[4]")).sendKeys("Terms & Conditions1");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				BaseClass.gotoTab(driver,1);	Thread.sleep(1000);
				MasterSetting_GeneralPages_Website("Terms & Conditions","Terms & Conditions1");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>Terms & Conditions verified</b></i>", extentScreenshot());
				
				
			}else{
				test.fail("<b><i>Terms & Conditions not displayed</b></i>", extentScreenshot());
				
			}
			if(driver.findElements(By.xpath("//mat-label[normalize-space()='Privacy Policy']")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[5]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[5]")).sendKeys("Privacy Policy1");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				BaseClass.gotoTab(driver,1);	Thread.sleep(1000);
				MasterSetting_GeneralPages_Website("Terms & Conditions","Privacy Policy1");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>Privacy Policy verified</b></i>", extentScreenshot());
				
				
			}else{
				test.fail("<b><i>Privacy Policy not displayed</b></i>", extentScreenshot());
				
			}
			if(driver.findElements(By.xpath("//div//mat-label[contains(text(),'Sweep Rules')]")).size() > 0)
			{
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[6]")).clear();
				driver.findElement(By.xpath("(//div[contains(@class,'NgxEditor__Content')])[6]")).sendKeys("Sweep Rules1");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()",lb.Save_Button_GeneralPages);
				BaseClass.gotoTab(driver,1);	Thread.sleep(1000);
				MasterSetting_GeneralPages_Website("Sweep Rules","Sweep Rules1");
				BaseClass.gotoTab(driver,0);
				test.pass("<b><i>Sweep Rules verified</b></i>", extentScreenshot());
				
				
			}else{
				test.fail("<b><i>Sweep Rules not displayed</b></i>", extentScreenshot());
				
			}
			Thread.sleep(300);
			//lb.ClickToSave_GeneralPages();
			
			
		
			Thread.sleep(3000);
			
			if(cc.Validation_Format_Lobby_General_Pages.isDisplayed()==true){
				Assert.assertTrue(true);			
				test.pass("<b><i>General Pages save successfully</b></i>", extentScreenshot());
			}
			else{
					test.fail("<b><i>  General Pages save successfully message not displayed</b></i>", extentScreenshot());
					//Assert.assertTrue(false);	
			}
		}
		else{
				test.fail("<b><i>General info label not displayed</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
		}
	}
	
		
	//this test case execute only with super admin role
	@Test(groups = {"admin"})
	public void G_TC_MasterSetting_Settings() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Lobby Settings"); 
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		
		Thread.sleep(500);
		lb.Settings_Click();
		test.info("Click on Settings");
		Thread.sleep(500); 
		
		if(driver.findElements(By.xpath("//span[contains(.,'Android Download Details')]")).size() > 0)
		{
			lb.Set_androidUrl("https://qa-cpweb-admin.cosmoslots.tech/downloadAndroidApp");
			test.info("Android download url entred");

			Thread.sleep(300); 	
			
			//if login user as superadmin then add description fields
			if(driver.findElements(By.xpath("//mat-label[text()='Description']//preceding::h4//span[normalize-space()='Android Download Details']")).size() > 0)
			{
				System.out.println("Android Download Details found");
				lb.Set_androidDesc("QA APK description.");
			}
			else
			{
				test.info("Not able to find android Description field",extentScreenshot());
			}
			
			Thread.sleep(300); 			
			
		}else{
			test.fail("<b><i>Application Download Link not displayed</b></i>", extentScreenshot());			
		}
		
		if(driver.findElements(By.xpath("//span[contains(.,'iOS Download Details')]")).size() > 0)
		{
			lb.Set_iosurl("https://qa-cpweb-admin.cosmoslots.tech/downloadIOSapp");
			test.info("IOS download url entred");

			Thread.sleep(300); 	
			
			//if login user as superadmin then add description fields
			if(driver.findElements(By.xpath("//mat-label[text()='Description']//preceding::h4//span[normalize-space()='iOS Download Details']")).size() > 0)
			{
				System.out.println("IOS Download Details found");
				lb.Set_iosDesc("QA IOS description.");
			}
			else
			{
				test.info("Not able to find ios Description field",extentScreenshot());
			}
			
			Thread.sleep(300); 			
			
		}else{
			test.fail("<b><i>Application Download Link not displayed</b></i>", extentScreenshot());			
		}
		lb.ClickToSave();
		Thread.sleep(3000); 
		
		if(cc.Validation_Format_Lobby_ApplicationDownloadLink.isDisplayed()==true)
		{
			Assert.assertTrue(true);			
			test.pass("<b><i>Android/IOS Application Download Link save message found</b></i>", extentScreenshot());

		}else{
			test.fail("<b><i>Android/IOS Application Download Link saved messgae not found</b></i>", extentScreenshot());
			Assert.assertTrue(false);	
	 }
	}
	
	@Test(groups = {"admin","website"}) 
	public void H_TC_LobbyTest_Setting_Promotion_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Settings - Promotion Create");
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		lb.MasterSettings_Click();
		Thread.sleep(500); 
		
		lb.clickToPromotion();
		Thread.sleep(500);

		//Create Promotion 
		test.info("Create Promotion test case start" );
		Thread.sleep(2000);
		lb.clickToCreate();
		test.info("Click to create Promotion" );
		
		lb.SetNewsTitle(Promotion_Search);
		LobbyPage.description_news.sendKeys("this is testing to description promotion");
		lb.SetNewsicon(Upload_Icon);
		Thread.sleep(2000);
		
		test.info("Entered title = <b>"+Promotion_Search+"</b>");
		test.info("Entered description promotion = <b>"+"description promotion"+"</b>");
		test.info("<b>Image uploaded sucessfully</b>");

		lb.ClickToSave();
		Thread.sleep(3000);
		
		test.info("saved created Promotion",extentScreenshot() );

		Boolean bool=cc.Validation_Format_AddPromotion.isDisplayed();
		if(bool==true){
			Assert.assertTrue(true);
			test.pass("Promotion - add successfully",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to add Promotion ",extentScreenshot());
			//captureScreen(driver, "CreatePromotion");
			Thread.sleep(1500);
			lb.ClickToCancel();
			//lb.ClickToClose();
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("Create Promotion test case end");
	}
	
	@Test(groups = {"admin","website"}) 
	public void Ha_TC_LobbyTest_Website_VerifyPromotion_LastAdded() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify last added Promotion");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		String PromotionAdmin=Promotion_Search;
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("(//*[text()=\"Promotions\"])[1]")).click();
		Thread.sleep(1500); 
		String PromotionWeb=driver.findElement(By.xpath("//div[contains(@class,\"promo-info\")]//child::h3[.='"+Promotion_Search+"']")).getText();
		
		if(PromotionAdmin.equalsIgnoreCase(PromotionWeb))
		{
			test.pass("last added Promotion found in Website",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("last added Promotion not found in website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
	}
	
	@Test(groups = {"admin","website"}) 
	public void Hb_TC_LobbyTest_Website_VerifyPromotion() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify all Promotion");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		int NoPromotionAdmin=driver.findElements(By.xpath("//mat-slide-toggle[contains(@class,'mat-checked')]")).size();
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("(//*[text()=\"Promotions\"])[1]")).click();
		
		int NoPromotionWeb=driver.findElements(By.xpath("//div[contains(@class,\"promo-info\")]/h3")).size();
		
		if(NoPromotionAdmin==NoPromotionWeb)
		{
			test.pass("Number of Promotion are the same in Admin and Website",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("Number of Promotion are not the same in Admin and Website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		
	}
	
	@Test(groups = {"admin"}) 
	public void Hc_TC_LobbyTest_Setting_Promotion_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("master Settings - Promotion Search");
		//test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	
		//-----------Search news-----------
		test.info("search Promotion test case start");
		lb.SearchItems(Promotion_Search);
		test.info("Search Promotion = <b>" +Promotion_Search+"</b>" ,extentScreenshot());
		Thread.sleep(2000);
		test.info("search Promotion test case end");
	}
	
	@Test(groups = {"admin"}) 
	public void Hb_TC_LobbyTest_Setting_Promotion_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("master Settings - Promotion Edit");
		//test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	
		//------------------Edit Promotion------------
		test.info("Edit Promotion test case start");
		Thread.sleep(1000);
		lb.clickToEdit();  
		lb.SetNewsTitle("Edit "+Promotion_Search);
		//String str="unlock game"+randNum;
		LobbyPage.description_news.clear();
		LobbyPage.description_news.sendKeys("edit promotion"+Promotion_Search);
		lb.SetNewsicon(Upload_Icon);
		
		test.info("Entered title = <b>"+"Edit "+Promotion_Search+"</b>");
		test.info("Entered description = <b>"+"edit promotion"+Promotion_Search+"</b>");
		test.info("<b>Image uploaded sucessfully</b>");
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //driver.findElement(By.xpath("(//a[@id=\"edit\"])[1]")).click();  		
		Thread.sleep(4000);
		if(driver.findElement(By.xpath("//img[@class='imgView ng-star-inserted']")).isDisplayed()==true) {
			lb.ClickToSavePromotion();
			test.info("Promotion update sucessfully",extentScreenshot());
		}
		else {
			test.info("Promotion not updated",extentScreenshot());
		}
			Thread.sleep(3000);
			Boolean bool2=cc.Validation_Format_UpdatePromotion.isDisplayed();
		if(bool2==true){
			Assert.assertTrue(true);
			test.pass("Promotion update validation message displayed",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to update Promotion",extentScreenshot());
			//captureScreen(driver, "EditPromotion");
			Thread.sleep(1500);
			lb.ClickToCancel();
			//lb.ClickToClose();
			Assert.assertTrue(false);	
		}
		test.info("edit Promotion test case end");			
	}
	
	@Test(groups = {"admin"}) 
	public void Hc_TC_LobbyTest_Setting_Promotion_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("master Settings - Promotion Status");
		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	
		//status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
	    {
			            test.info("Successfully Viewed active lobby promotion page");
			            test.info("Now lobby promotion Is InActive");
			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			            Thread.sleep(1000);
			            try
			            {
			                if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion published successfully\"]")).size()>0)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("Lobby promotion Successfully activated and Validation message appeared - Lobby promotion activated  successfully",extentScreenshot());
			                }else{
			                    Assert.assertTrue(false);
			                    test.fail("Failed ! To View Message",extentScreenshot());
			                }
			            }
			            catch(Exception e)
			            {
			                if(driver.findElement(By.xpath("//span[text()=\"Lobby promotion published successfully\"]"))!=null)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("Lobby promotion Successfully activated and Validation message appeared - Lobby promotion activated successfully",extentScreenshot());
			                }
			                System.out.println(e);
			            }Thread.sleep(4000);
	     }else{
			            test.info("Successfully Viewed View Icon of Player on lobby news listing page");
			            test.info("Now promotion Is Active");

			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			            Thread.sleep(1000);
			            try {
			            	if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion unpublished successfully\"]")).size()>0)
			            	{
			            		Assert.assertTrue(true);
			            		test.pass("Lobby promotion Successfully deactivated and Validation message appeared - Lobby promotion deactivated successfully",extentScreenshot());
			            	}else{
			            		Assert.assertTrue(false);
			                	test.fail("Failed ! To View Message",extentScreenshot());
			            	}
			            }
			            catch(Exception e)
			            {
			                if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion unpublished successfully\"]")).size()>0)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("Lobby promotion Successfully deactivated and Validation message appeared - Lobby promotion deactivated successfully",extentScreenshot());
			                }
			                System.out.println(e);
			          }
			    }
		
		test.info("master Settings- promotion test case end");
		
	}

	@Test(groups = {"admin"}) 
	public void Hd_TC_LobbyTest_Setting_Promotion_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("promotion view");
			
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	 //CHECK VIEW AND UNCOMMENT
		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View promotion test case start...");
			lb.View_Click();
//			test.info("Clicked on promotion view button");

			
			Thread.sleep(1000);
//			 System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText());
//			   if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//child::tr//td[@class='column-title'])[1]")).getText().equalsIgnoreCase(Promotion_Search))
//			   {
//					Assert.assertTrue(true);
//					//test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify searched promotion in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
//				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify promotion in list</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
			   Thread.sleep(2000);	
			   test.info("View promotion test case end."); 	
		}
		else
		{
				test.info("View promotion button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
		
		
	}
	
	@Test(groups = {"admin"}) 
	public void Hf_TC_LobbyTest_Setting_Promotion_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("master Settings - Promotion Delete");
		//test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	
			
		//-----------delete Promotion-----------
		test.info("delete Promotion test case start");
		Thread.sleep(1000);
		lb.DeleteClick_websiteSetings();
		test.info("click to delete Promotion");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			Thread.sleep(200);
			test.pass("Promotion - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete Promotion ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_DeletePromotion.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("Promotion - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show Promotion delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("master Settings-delete Promotion test case end");
		
		
		Thread.sleep(1000);	
	}
	@Test(groups = {"admin"}) 
	public void I_TC_LobbyTest_HomePage_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Settings - HomePage Create");
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		
		Thread.sleep(500); 
		
		lb.Set_HomePage_icon();
		Thread.sleep(500);
						
		//Create Promotion 
		test.info("Create HomePage test case start" );
		Thread.sleep(2000);
		lb.clickToCreate();
		test.info("Click to create HomePage" );

		
		if(driver.findElements(By.xpath("//h3[.=\"Add Home Page\"]")).size() > 0) {
			
			Thread.sleep(500);
			//lb.Set_HomePage_photo(Upload_Icon);
			lb.SetNewsicon(Upload_Icon);
			Thread.sleep(1000);
			lb.SetNewsTitle(Search_HomePage+" -"+randNum);
			lb.Set_HomePage_subtitle("new sub title for homepage");
			lb.Set_HomePage_buttonText("this is button text");
			lb.Set_HomePage_buttonUrl("www.comsmoslots.com");
			
			test.info("Home page image upload successfully");
			test.info("Entered Set Title = <b>"+Search_HomePage+"</b>");
			test.info("Entered Set sub Title = <b>"+"new sub title for homepage"+"</b>");
			test.info("Entered Set buttonText = <b>"+"this is button text"+"</b>");
			test.info("Entered Set buttonUrl= <b>"+"www.comsmoslots.com"+"</b>");
			
			Thread.sleep(1000);
			test.info("Add Home Page found",extentScreenshot());
			lb.ClickToSave();
			test.info("Home page data saved successfully");
		}
		else {
			test.fail("Add Home Page title not found",extentScreenshot());
		}
		
		Boolean bool_AddAppSetting=cc.Validation_Format_Settings_Homepage_add.isDisplayed();
		if(bool_AddAppSetting==true){
			test.pass("Homepage - Save message return",extentScreenshot());
			Assert.assertTrue(true);
		}else{
			test.fail("Something Wrong ! not able get save HomePage setting message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
 		Thread.sleep(1000);
		test.info("Create Promotion test case end");
	}
	
	public void Ia_TC_LobbyTest_HomePage_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Settings - HomePage Edit");
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	
		//------------------Edit Promotion------------
		test.info("Edit HomePage test case start");
		 
		Thread.sleep(1000);
		lb.clickToEdit();  
		
		if(driver.findElements(By.xpath("//h3[.=\"Edit Home Page\"]")).size() > 0) {
			
			Thread.sleep(500);
			lb.SetNewsicon(Upload_Icon);
			Thread.sleep(1000);
			lb.SetNewsTitle("Edit New Home page");
			lb.Set_HomePage_subtitle("Edit new sub title for homepage");
			lb.Set_HomePage_buttonText("this is button text for edit check");
			lb.Set_HomePage_buttonUrl("www.comsmoslots.com/");
			
			
			test.info("Home page image upload successfully");
			test.info("Entered Set Title = <b>"+"Edit New Home page"+"</b>");
			test.info("Entered Set sub Title = <b>"+"Edit new sub title for homepage"+"</b>");
			test.info("Entered Set buttonText = <b>"+"this is button text for Edit check"+"</b>");
			test.info("Entered Set buttonUrl= <b>"+"www.comsmoslots.com/"+"</b>");
			
			Thread.sleep(1000);

			test.info("Edit Home Page found",extentScreenshot());
			lb.ClickToSave();
			test.info("Home page data saved successfully");
		}
		else {
			test.fail("Add Home Page title not found",extentScreenshot());
		}

		Boolean bool_AddAppSetting=cc.Validation_Format_Settings_Homepage_edit.isDisplayed();
		if(bool_AddAppSetting==true){
			test.pass("Homepage - Save message return for Edit",extentScreenshot());
			Assert.assertTrue(true);
		}else{
			test.fail("Something Wrong ! not able get save HomePage setting message for edit",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("edit Promotion test case end");			
	}
	
	@Test(groups = {"admin"}) 
	public void Ib_TC_LobbyTest_Homepage_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Homepage view");
			
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);	 
		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			//UNCOMMENT THIS IF XPATH MATCH
		
			test.info("View Homepage test case start...");
			lb.View_Click();
//			test.info("Clicked on Homepage view button");			
			Thread.sleep(1000);
//			 System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText());
//			   if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText().equalsIgnoreCase(Verify_Homepage))
//			   {
//					Assert.assertTrue(true);
//					//test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify  Homepage in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
				    Thread.sleep(500);
//		        	test.pass("<b><i>not able to verify  Homepage in list</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
//			   Thread.sleep(2000);	
			   test.info("View Homepage test case end."); 	
		}
		else
		{
				test.info("View Homepage button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	
	@Test(groups = {"admin"}) 
	public void Ic_TC_LobbyTest_Homepage_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Settings - Homepage Delete");
 
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
				
		//-----------delete Promotion-----------
		test.info("delete Homepage test case start");
		Thread.sleep(1000);
		lb.DeleteClick_websiteSetings();
		test.info("click to delete HomePage");
		Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			Thread.sleep(200);
			test.pass("Homepage - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete Homepage ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_UserDelete.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("Homepage - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show Homepage delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("master Settings-delete Homepage test case end");		
		
		Thread.sleep(1000);	
	}
	
	@Test(groups = {"admin","website"}) 
	public void J_TC_LobbyTest_News_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - News Create");

			
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		Thread.sleep(500); 
		lb.MasterSettings_Click();
 		Thread.sleep(1000); 
		lb.clickToNews();
		Thread.sleep(1000);
		
		//Create news 
		test.info("Create news test case start" );
		lb.clickToCreate();
		test.info("Click to create news" );
		lb.SetNewsTitle(News_Create);
		
		LobbyPage.description_news.sendKeys("this is testing");
		lb.SetNewsicon(Upload_Icon);
		Thread.sleep(3000);
		
		test.info("Entered title = <b>"+News_Create+"</b>");
		test.info("Entered description = <b>"+"this is testing"+"</b>");
		test.info("<b>Image uploaded sucessfully</b>");

		lb.ClickToSave();
		Thread.sleep(2000);
		test.info("Data saved successfuly",extentScreenshot() );

		Boolean bool=cc.Validation_Format_AddNews.isDisplayed();
		if(bool==true){
			Assert.assertTrue(true);
			test.pass("news - add successfully message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to add bonus ",extentScreenshot());
			//captureScreen(driver, "CreateNews");
			Thread.sleep(1500);
			lb.ClickToCancel();
			//lb.ClickToClose();
			Assert.assertTrue(false);
			//lb.ClickToCancel();
		}
		Thread.sleep(1000);
		test.info("Create news test case end");
	}
	
	@Test(groups = {"admin","website"}) 
	public void Ja_TC_LobbyTest_Website_VerifyNews_LastAdded() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify last added News");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		String NewsAdmin=News_Create;
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("(//a[text()=\"Media\"])[1]")).click();
		Thread.sleep(1500); 
		String NewsWeb=driver.findElement(By.xpath("//div[contains(@class,\"news-content-block\")]//child::h3[.='"+News_Create+"']")).getText();
		
		if(NewsAdmin.equalsIgnoreCase(NewsWeb))
		{
			test.pass("last added News found in Website",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("last added News not found in website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
	}
	
	@Test(groups = {"admin","website"}) 
	public void Jb_TC_LobbyTest_Website_VerifyNews() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify all News");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		int NoNewsAdmin=driver.findElements(By.xpath("//mat-slide-toggle[contains(@class,'mat-checked')]")).size();
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("(//a[text()=\"Media\"])[1]")).click();
		
		int NoNewsWeb=driver.findElements(By.xpath("//div[contains(@class,\"news-content-block\")]/h3")).size();
		
		if(NoNewsAdmin==NoNewsWeb)
		{
			test.pass("Number of News are the same in Admin and Website",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("Number of News are not the same in Admin and Website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		
	}
	
	@Test(groups = {"admin"}) 
	public void Jc_TC_LobbyTest_News_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - News Search");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		 
//		lb.clickToNews();
//		Thread.sleep(1000);
//		//-----------Search news-----------
		test.info("search news test case start");
		lb.SearchItems(News_Create);
		test.info("Searched item = <b>"+News_Create+"</b>",extentScreenshot());
		Thread.sleep(2000);
		test.info("search news test case end");
	}
	@Test(groups = {"admin"})
	public void Jd_TC_LobbyTest_News_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - News Status");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		
		//status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
		{
		            test.info("Successfully Viewed active lobby news page");
		            test.info("Now lobby news Is InActive");
		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
		            Thread.sleep(1000);
		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		            Thread.sleep(1000);
		            try
		            {
		                if(driver.findElements(By.xpath("//span[text()=\"News published successfully\"]")).size()>0)
		                {
		                    Assert.assertTrue(true);
		                    test.pass("Lobby news Successfully activated and Validation message appeared - Lobby news activated  successfully",extentScreenshot());
		                }else{
		                     test.fail("Failed ! To View Message",extentScreenshot());
		                     Assert.assertTrue(false);
		                }
		            }
		            catch(Exception e)
		            {
		                if(driver.findElement(By.xpath("//span[text()=\"News published successfully\"]"))!=null)
		                {
		                    Assert.assertTrue(true);
		                    test.pass("Lobby news Successfully activated and Validation message appeared - Lobby news activated successfully",extentScreenshot());
		                }
		                System.out.println(e);
		            }Thread.sleep(4000);
		   }else{
		            test.info("Successfully Viewed View Icon of Player on lobby news listing page");
		            test.info("Now news Is Active");

		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
		            Thread.sleep(1000);
		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		            Thread.sleep(1000);
		            try {
		            	if(driver.findElements(By.xpath("//span[text()=\"News unpublished successfully\"]")).size()>0)
		            	{
		            		Assert.assertTrue(true);
		            		test.pass("Lobby news Successfully deactivated and Validation message appeared - Lobby news deactivated successfully",extentScreenshot());
		            	}else{
		            		Assert.assertTrue(false);
		                	test.fail("Failed ! To View Message",extentScreenshot());
		            	}
		            }
		            catch(Exception e)
		            {
		                if(driver.findElements(By.xpath("//span[text()=\"News unpublished successfully\"]")).size()>0)
		                {
		                    Assert.assertTrue(true);
		                    test.pass("Lobby news Successfully deactivated and Validation message appeared - Lobby news deactivated successfully",extentScreenshot());
		                }
		                System.out.println(e);
		            }
		     }
		test.info("status news test case end");

	}
	@Test(groups = {"admin"})
	public void Je_TC_LobbyTest_News_edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - News Edit");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
 		
		//------------------Edit news------------
		lb.clickToNews();  
		lb.clickToEdit();
		test.info("click to Edit news");

		lb.SetNewsTitle("title1"+randNum);
		String str="title1"+randNum;
		LobbyPage.description_news.clear();
		LobbyPage.description_news.sendKeys("this is testing edit news");
		lb.SetNewsicon(Upload_Icon);
		Thread.sleep(3000);
				
		test.info("Entered title = <b>"+str+"</b>");
		test.info("Entered description = <b>"+"this is testing edit news"+"</b>");
		test.info("<b>Image uploaded sucessfully</b>");
				
		if(lb.ViewLobby_Appsetting_EditNewsLabel.isDisplayed()==true) {
			Assert.assertTrue(true);
			test.pass("edit news label displayed",extentScreenshot());
			  JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("arguments[0].click();",lb.Savenews);  
						
					//lb.ClickToSave();
		}else{
					test.fail("Something Wrong ! not able to edit news label",extentScreenshot());
					Assert.assertTrue(false);	
		}
				
		Thread.sleep(2000);
		Boolean bool2=cc.Validation_Format_UpdateNews.isDisplayed();
		if(bool2==true){
					Assert.assertTrue(true);
					test.pass("News update validation message displayed",extentScreenshot());
		 }else{
					test.fail("Something Wrong ! not able to update news",extentScreenshot());
					//captureScreen(driver, "EditNews");
					Thread.sleep(1500);
					lb.ClickToCancel();
					//lb.ClickToClose();
					Assert.assertTrue(false);	
		}
				test.info("edit news test case end");

	}
	@Test(groups = {"admin"}) 
	public void Jf_TC_LobbyTest_News_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("News view");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	
		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View News test case start...");
			lb.View_Click();
//			test.info("Clicked on News view button");
			Thread.sleep(1500);
//			System.out.println("view news- " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//child::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText());
//			if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//child::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText().equalsIgnoreCase(Verify_News))
//			{
//					Assert.assertTrue(true);
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify news  in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			}
//			else 
//			{
				    Thread.sleep(500);
//					
//		        	test.pass("<b><i>not able to verify  NEWS in a list</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			}
			   Thread.sleep(2000);	
			   test.info("View news test case end."); 	
		}
		else
		{
				test.info("View news view button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	@Test(groups = {"admin"})
	public void Jg_TC_LobbyTest_News_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - News Delete");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		 
	
		//-----------delete news-----------
		test.info("delete news test case start");
		Thread.sleep(1000);
		lb.DeleteClick_websiteSetings();
		test.info("click to delete news delete");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			
			test.pass("news - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete news ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_DeleteNews.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("news - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show news delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("delete news test case end");
		Thread.sleep(1000);
 	   
	}
	
	@Test(groups = {"admin"}) 
	public void K_TC_LobbyTest_FAQ_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - FAQ Create");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		 
		Thread.sleep(500); 
		lb.clickToFAQ();
		Thread.sleep(500);
		
						
		//Create FAQ 
		test.info("Create FAQ test case start" );
		Thread.sleep(2000);
		lb.clickToCreate();
		test.info("Create to create FAQ" );

		lb.SetFAQques("what is your city"+randNum);
		String str="what is your city"+randNum;
		lb.SetFAQanswer("delhi");
		lb.SetCategory();
		Thread.sleep(1000);
		lb.SetOrder("1");
		
		
		test.info("Entered Question = <b>"+str+"</b>");
		test.info("Entered Answer = <b>"+"delhi"+"</b>");
		test.info("Select Category = <b>"+"Account"+"</b>");
		test.info("Select order = <b>"+"1"+"</b>");
		
		Thread.sleep(500);
		lb.ClickToSave();
		Thread.sleep(500);
		test.info("saved FAQ successfully" );

		
		Thread.sleep(2000);
		Boolean bool=cc.Validation_Format_AddFAQ.isDisplayed();
		if(bool==true){
			Assert.assertTrue(true);
			test.pass("FAQ - add successfully message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to add FAQ ",extentScreenshot());
			//captureScreen(driver, "CreateFAQ");
			Thread.sleep(1500);
			lb.ClickToCancel();
			//lb.ClickToClose();
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("Create FAQ test case end");

	}
	@Test(groups = {"admin"}) 
	public void Ka_TC_LobbyTest_FAQ_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - FAQ Edit");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		//Working
		//------------------Edit FAQ------------
		test.info("Edit FAQ test case start");

		lb.clickToFAQ();
		Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lb.clickToEdit_FAQ();   //driver.findElement(By.xpath("(//a[@id=\"edit\"])[1]")).click();  
		test.info("click to edit FAQ ");

		
		Thread.sleep(2000);
		lb.ClickToSaveFAQ();
		test.info("saved edit FAQ ");

		Thread.sleep(2000);
		Boolean bool2=cc.Validation_Format_UpdateFAQ.isDisplayed();
		if(bool2==true){
		Assert.assertTrue(true);
		test.pass("FAQ update validation message displayed",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to update FAQ",extentScreenshot());
			//captureScreen(driver, "EditFAQ");
			Thread.sleep(1500);
			//lb.ClickToCancel();
			lb.ClickToClose();
			Assert.assertTrue(false);	
		}
		test.info("edit FAQ test case end");	
	}
	@Test(groups = {"admin"}) 
	public void Kb_TC_LobbyTest_FAQ_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - FAQ view");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	 
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View Store Package test case start...");
			lb.View_Click();
//			test.info("Clicked on Store Package view button");
			Thread.sleep(1000);
//			System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText());
//			if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText().equalsIgnoreCase(Verify_FAQ))
//			   {
//					Assert.assertTrue(true);
//					//test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>FAQ view - Successfully verify record  in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
//				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify record  in  a List</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
			   Thread.sleep(2000);	
			   test.info("View FAQ view test case end."); 	
		}
		else
		{
				test.info("View FAQ view button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	
	@Test(groups = {"admin"}) 
	public void Kc_TC_LobbyTest_FAQ_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - FAQ Status");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		//Working
		 //status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
	    {
	            test.info("Successfully Viewed active lobby faq page");
	            test.info("Now lobby faq Is InActive");
	            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
	            Thread.sleep(1000);
	            try
	            {
	                if(driver.findElements(By.xpath("//span[text()=\"FAQ activated successfully\"]")).size()>0)
	                {
	                    Assert.assertTrue(true);
	                    test.pass("Lobby faq Successfully activated and Validation message appeared - Lobby faq activated  successfully",extentScreenshot());
	                }else{
	                    Assert.assertTrue(false);
	                    test.fail("Failed ! To View Message",extentScreenshot());
	                }
	            }
	            catch(Exception e)
	            {
	                if(driver.findElement(By.xpath("//span[text()=\"FAQ activated successfully\"]"))!=null)
	                {
	                    Assert.assertTrue(true);
	                    test.pass("Lobby faq Successfully activated and Validation message appeared - Lobby faq activated successfully",extentScreenshot());
	                }
	                System.out.println(e);
	            }Thread.sleep(4000);
	     }else{
	            test.info("Successfully Viewed View Icon of Player on lobby faq listing page");
	            test.info("Now faq Is Active");

	            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
	            Thread.sleep(1000);
	            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
	            Thread.sleep(1000);
	            try {
	            	if(driver.findElements(By.xpath("//span[text()=\"FAQ deactivated successfully\"]")).size()>0)
	            	{
	            		Assert.assertTrue(true);
	            		test.pass("Lobby faq Successfully deactivated and Validation message appeared - Lobby faq deactivated successfully",extentScreenshot());
	            	}else{
	            		Assert.assertTrue(false);
	                	test.fail("Failed ! To View Message",extentScreenshot());
	            	}
	            }
	            catch(Exception e)
	            {
	                if(driver.findElements(By.xpath("//span[text()=\"FAQ deactivated successfully\"]")).size()>0)
	                {
	                    Assert.assertTrue(true);
	                    test.pass("Lobby faq Successfully deactivated and Validation message appeared - Lobby faq deactivated successfully",extentScreenshot());
	                }
	                System.out.println(e);
	          }
	    }			
		Thread.sleep(1000);			
		test.info("Masetr setting FAQ test case end");		
	}
	
	@Test(groups = {"admin"}) 
	public void Kd_TC_LobbyTest_FAQ_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - FAQ Delete");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		//Working
		
		//-----------delete FAQ-----------
		test.info("delete FAQ test case start");
		Thread.sleep(1000);
		lb.DeleteClick_websiteSetings();
		test.info("click to delete FAQ ");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			
			test.pass("FAQ - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete FAQ ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_DeleteFAQ.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("FAQ - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show FAQ delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("delete FAQ test case end");
		
	}
	
	@Test(groups = {"admin"}) 
	public void L_TC_LobbyTest_MetaData_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - Meta Data Create");

			
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		
		Thread.sleep(1000); 
		lb.Set_MetaData();
		Thread.sleep(1000);
		
		//Create MetaData 
		test.info("Create Meta Data test case start" );
		lb.clickToCreate();
		test.info("Click to create Meta Data" );
		
		if(driver.findElements(By.xpath("//h3[text()=\"Add Meta Data\"]")).size() > 0)
			
		{
		lb.SetNewsTitle(metadata_title);		
		lb.Set_MetaData_tags("Redemption Policy1");
		LobbyPage.description.clear();
		LobbyPage.description.sendKeys("this is testing for Redemption Policy");
		Thread.sleep(500);
		lb.Set_MetaData_Page(metadata_title);
		Thread.sleep(200);
		 
				
		test.info("Entered title = <b>"+metadata_title+"</b>");
		test.info("Entered tags = <b>"+"Redemption Policy1"+"</b>");
		test.info("Page selected = <b>" +metadata_title+"</b>");
		test.info("Entered description = <b>"+"this is testing for Redemption Policy"+"</b>");
		
		lb.ClickToSave();
		Thread.sleep(2000);
		test.info("Data saved successfuly",extentScreenshot());

		Boolean bool1=cc.Validation_Format_Settings_Homepage_metadata_save.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("metadata - saved successfully message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able to show save message ",extentScreenshot());
			//captureScreen(driver, "CreateNews");
			Thread.sleep(1500);
			lb.ClickToCancel();
			//lb.ClickToClose();
			Assert.assertTrue(false);
			//lb.ClickToCancel();
		}
		}
		else
		{
			test.fail("not found Add Meta data text ",extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("Create Meta Data test case end");
	}
	@Test(groups = {"admin"}) 
	public void La_TC_LobbyTest_MetaData_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - Meta Data Search");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		
		//-----------Search news-----------
		test.info("search Meta Data test case start");
		lb.SearchItems(metadata_title);
		test.info("Searched item = <b>"+metadata_title+"</b>",extentScreenshot());
		Thread.sleep(2000);
		test.info("search Meta Data test case end");
	}
	
	@Test(groups = {"admin"})
	public void Lb_TC_LobbyTest_MetaData_edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - Meta Data Edit");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	 
	
		//------------------Edit metadata------------
		lb.clickToEdit();
		Thread.sleep(1000);
		test.info("click to Edit Meta Data");
		if(driver.findElements(By.xpath("//h3[text()=\"Edit Meta Data\"]")).size() > 0)
		{	
		
			lb.SetNewsTitle(metadata_title);		
		//	lb.Set_MetaData_tags("Redemption Policy1");
		//	lb.Set_MetaData_Page(metadata_title);
			LobbyPage.description.clear();
			LobbyPage.description.sendKeys("\n"+"this is testing for Redemption Policy");
		
			Thread.sleep(1000);
		
			test.info("edit title = <b>"+metadata_title+"</b>");
			test.info("edit tags = <b>"+"Redemption Policy1"+"</b>");
			test.info("Page selected = <b>" +metadata_title+"</b>");
			test.info("edit description = <b>"+"this is testing for Redemption Policy"+"</b>");
			
			lb.ClickToSave();
			Thread.sleep(2000);
			test.info("Data saved successfuly",extentScreenshot() );
				
		Thread.sleep(2000);
		Boolean bool2=cc.Validation_Format_Settings_Homepage_metadata_update.isDisplayed();
		if(bool2==true){
					Assert.assertTrue(true);
					test.pass("Meta Data update validation message displayed",extentScreenshot());
		 }else{
					test.fail("Something Wrong ! not able to update Meta Data",extentScreenshot());
					//captureScreen(driver, "EditNews");
					Thread.sleep(1500);
					lb.ClickToCancel();
					//lb.ClickToClose();
					Assert.assertTrue(false);	
		}
	}
	else
	{
		test.fail("not found Edit Meta data text ",extentScreenshot());
		
	}
				test.info("edit Meta Data test case end");

	}
	@Test(groups = {"admin"}) 
	public void Lc_TC_LobbyTest_MetaData_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Meta Data view");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	 
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View Meta Data test case start...");
			lb.View_Click();
//			test.info("Clicked on Meta Data view button");
//
			Thread.sleep(1000);
//			 System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText());
//			   if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText().equalsIgnoreCase(Verify_News))
//			   {
//					Assert.assertTrue(true);
//					//test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify searched Store Package in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify searched Store Package</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
//			   Thread.sleep(2000);	
			   test.info("View Store Package test case end."); 	
		}
		else
		{
				test.info("View Store Package button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	@Test(groups = {"admin"})
	public void Ld_TC_LobbyTest_MetaData_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - Meta Data Delete");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		 
	
		//-----------delete news-----------
		test.info("delete Meta Data test case start");
		lb.DeleteClick_websiteSetings();
		test.info("click to delete Meta Data delete");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			
			test.pass("news - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete Meta Data ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_DeleteNews.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("Meta Data - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show Meta Data delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("delete Meta Data test case end");
		Thread.sleep(1000);
 	   
	}
		
	//only super admin can do this
	@Test(groups = {"admin"}) 
	public void M_TC_LobbyTest_ReleaseNotes_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - Meta Data Create");

			
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		
		Thread.sleep(1000); 
		lb.Set_ReleaseNotes();
		Thread.sleep(1000);
		
		//Create MetaData 
		test.info("Create Release Notes test case start" );
		lb.clickToCreate();
		test.info("Click to create Release Notes" );
		
		if(driver.findElements(By.xpath("//h3[text()=\"Add Release Note\"]")).size() > 0)
			
		{
		lb.Set_Release_input(ReleaseNotes);		
		lb.Set_Release_url(Releaseurl); 
		
		Thread.sleep(1000);
		
		test.info("Entered ReleaseNotes = <b>"+ReleaseNotes+"</b>");
		test.info("Entered Releaseurl = <b>"+Releaseurl+"</b>");
		
		lb.ClickToSave();
		Thread.sleep(2000);
		test.info("ReleaseNotes Data saved successfuly",extentScreenshot() );

		Boolean bool=cc.Validation_Format_Settings_Homepage_metadata_releasesaved.isDisplayed();
		
			if(bool==true){
				Assert.assertTrue(true);
				test.pass("ReleaseNotes - saved successfully message return",extentScreenshot());
			}else{
				test.fail("Something Wrong ! not able to show ReleaseNotes save message ",extentScreenshot());
				Thread.sleep(1500);
				lb.ClickToCancel();
				Assert.assertTrue(false);
			}
		}
		else
		{
			test.fail("not found Add Meta data text ",extentScreenshot());
		}
		Thread.sleep(1000);
		test.info("Create Meta Data test case end");
	} 
	
	//only super admin can do this
	@Test(groups = {"admin"})
	public void Mb_TC_LobbyTest_ReleaseNotes_edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - ReleaseNotes Edit");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
	 
	
		//------------------Edit metadata------------
		lb.clickToEdit();
		test.info("click to Edit ReleaseNotes");
		if(driver.findElements(By.xpath("//h3[text()=\"Edit Release Note\"]")).size() > 0)
		{	
		
			lb.Set_Release_input(ReleaseNotes);		
			lb.Set_Release_url(Releaseurl); 
			
			Thread.sleep(1000);
			
			test.info("Entered ReleaseNotes = <b>"+ReleaseNotes+"</b>");
			test.info("Entered Releaseurl = <b>"+Releaseurl+"</b>");
			
			lb.ClickToSave();
			Thread.sleep(2000);
			test.info("Data saved successfuly",extentScreenshot() );
				
		Thread.sleep(1000);
		//Boolean bool2=cc.Validation_Format_Settings_Homepage_metadata_update.isDisplayed();
		if(cc.Validation_Format_Settings_Homepage_metadata_update.isDisplayed()==true){
					Assert.assertTrue(true);
					test.pass("ReleaseNotes update validation message displayed",extentScreenshot());
		 }else{
					test.fail("Something Wrong ! not able to update ReleaseNotes",extentScreenshot());
					//captureScreen(driver, "EditNews");
					Thread.sleep(1500);
					lb.ClickToCancel();
					//lb.ClickToClose();
					Assert.assertTrue(false);	
		}
	}
	else
	{
		test.fail("not found ReleaseNotes data text ",extentScreenshot());
	}
				test.info("edit ReleaseNotes test case end");

	}
	@Test(groups = {"admin"}) 
	public void Mc_TC_LobbyTest_ReleaseNotes_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("ReleaseNotes view");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
	 
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View ReleaseNotes test case start...");
//			lb.View_Click();
//			test.info("Clicked on ReleaseNotes view button");
//
//			Thread.sleep(1000);
//			 System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText());
//			   if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')]//span)[1]")).getText().equalsIgnoreCase(Verify_News))
//			   {
//					Assert.assertTrue(true);
//					//test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify ReleaseNotes in a List.</b></i>", extentScreenshot());
//					lb.ClickToClose();
//			   }
//			   else 
//			   {
//				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify ReleaseNotes in list</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
//			   Thread.sleep(2000);	
			   test.info("View ReleaseNotes test case end."); 	
		}
		else
		{
				test.info("View ReleaseNotes button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	
	//only super admin can do this
	@Test(groups = {"admin"})
	public void Md_TC_LobbyTest_ReleaseNotes_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Master Settings - ReleaseNotes Delete");

 		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver); 
		 
	
		//-----------delete news-----------
		test.info("delete ReleaseNotes test case start");
		lb.DeleteClick_websiteSetings();
		test.info("click to delete ReleaseNotes delete");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			
			test.pass("ReleaseNotes - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete ReleaseNotes",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_UserDelete.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("ReleaseNotes - delete message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able show ReleaseNotes delete message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("delete ReleaseNotes test case end");
		Thread.sleep(1000);
 	   
	}
	
	
}



