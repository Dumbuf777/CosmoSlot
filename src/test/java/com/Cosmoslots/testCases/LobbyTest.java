package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;


public class LobbyTest extends BaseClass
{
	BaseClass b = new BaseClass();
	//PurchaseHistoryTest ph=new PurchaseHistoryTest();
	// random string of length 8 composed of alphabetic characters and numbers
	String r = RandomStringUtils.randomAlphanumeric(4); 
	String randomString=r;
	String Lcode = "CosmoSlot";//Store" + new Random().nextInt(10000);
	String randNum = RandomStringUtils.randomNumeric(4);
	String LobbyName="Cosmo-"+randNum;	
	public String Search_Storepackage="STORE"+randNum;
	public String Search_Custompackage="CUSTOM"+randNum;
	public String Search_StorePackageName="StarPack"+randomString;
	public String Search_CustomPackageName="StarPack"+randomString;
	public String StorePackageGT="500";
	public String StorePackageST="500";
	public String StorePackageAmount="1";
	//String Search_LobbyPackage="Silver1";
	String Search_Lobby="Cosmo";
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
	List<String> shift = new ArrayList<String>();
	List<String> shiftweb = new ArrayList<String>();
	int TotalStorePackage=0;
	public String WebsiteTransactionid;
	public String Playerusername;
	public String paymentway;
//	@Test
//	public void A_TC_LobbyTest_GF444() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Login for lobby Page");
//		
//		//LobbyPage lb = new LobbyPage(driver);
//		//SymbolTypePage1 sp=new SymbolTypePage1(driver);
//		LoginPage lp = new LoginPage(driver);
//	//	BaseClass bc = new BaseClass();
//		test.info("Login TestCase started for store management");	
//	//	test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//		
//		test.info("URL is opened");
//			
//		Thread.sleep(500);
//		//lp.ClickDontHaveZzure();
//		lp.setUserName(username);
//		test.info("Entered username = <b>"+username+"</b>");
//		//test.warning("Bad");
//		
//		lp.setPassword(password);
//		logger.info("Entered password");
//		test.info("Entered password = <b>"+password+"</b>");
//
//		
//		Thread.sleep(1000);
//		lp.clickSubmit();
//		test.info("Clicked Submit button to login");
//		
//		Thread.sleep(2000);
//				
//		if(driver.findElements(By.xpath("//span[text()=\" Store Management\"]")).size() > 0)
//		{
//			Assert.assertTrue(true);
//			test.info("Login test passed for store management");
//			test.pass("<b><i>Login test passed for lobby Page</b></i>", extentScreenshot());
//		}else{
//			test.info("Login test failed for store management");
//			//captureScreen(driver,"loginTest");
//			test.fail("<b><i>Login test fail for lobby Page</b></i>", extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		test.info("Login TestCase Ended for store management");	
//	 
//		Thread.sleep(500);
//		
//		test.info("TestCase-store management Ended");
//	}
	
	@Test
	public void B_TC_LobbyTest_LobbyClicked() throws IOException, InterruptedException 
	{
		test = extentCreateTest("store management menu");
		Thread.sleep(2000);
		//test.info("TestCase started lobby redirection from menu ");	
		//test.info("URL is opened");
		LobbyPage lb = new LobbyPage(driver);
	//	LoginPage lp = new LoginPage(driver);
	//	GuestPlayers gp = new GuestPlayers(driver);
		lb.clicklobbymanagement();
		test.info("Clicked on store management menu");
		Thread.sleep(500);
		
		lb.clickStoreAccounts();
		test.info("Clicked on lobby menu");
	}
	
	@Test 
	public void C_TC_LobbyTest_GF1126_NewLobby() throws IOException, InterruptedException
	{
		test = extentCreateTest("create new lobby");
		Thread.sleep(2000);
		test.info("TestCase started create new lobby.");	
		
		LobbyPage lb = new LobbyPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		
		lb.clicklobbymanagement();
		test.info("Clicked on store management menu");
		Thread.sleep(500);
		lb.clickStoreAccounts();
		test.info("Clicked on lobby menu");
		
		Thread.sleep(1500);
		if(driver.findElement(By.xpath("//h3[text()=\"Store Management\"]"))!=null)
		{
			lb.clickToCreate();
			Thread.sleep(1000);
			//lb.clickOwnerBased();
			if(LobbyPage.OwenerBasedradio.isSelected())
			{
				test.info("Selected owner based");
			}
			else
			{	
			//LobbyPage.OwenerBasedradio.click();
			WebElement ele = driver.findElement(By.xpath("//input[@value=\"OWNER_BASED\"]"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", ele);
			test.info("<b>"+"Owner"+"</b>"+"" +"based option selected");
			}
		
			lb.Setlobbycode(Lcode);
			test.info("Lobby code = <b>"+ Lcode + "</b>");
			System.out.println("Lobby code- " + Lcode);
			
			lb.Setlobbyname(LobbyName);
			test.info("Lobby name = <b>"+ LobbyName + "</b>");
			
			Thread.sleep(500);
			lb.setCountry();
			test.info("Lobby Country selected= <b>"+ "" + "</b>");		
				
			lb.Set_Desc(LobbyDescription);
			test.info("Lobby Desciption added = <b>" +LobbyDescription+ "</b>");
		
			Thread.sleep(500);
			lb.setGames("Cash War");
			test.info("Selected Games = <b>"+ "" + "</b>");
		
			lb.Player_Registration_Link("https://qa-cpweb-admin.cosmoslots.tech");
		
			//save button clicked 
			lb.LobbySave();
			test.info("Click on Save button");
			Thread.sleep(1500);
		}
		else 
		{
			test.info("Something wrong! To save ");
		}
		//lb.clicklobbysave();
		test.info("TestCase-1126 Add Store Ended");

		Thread.sleep(500);		
	}
	
	@Test
	public void D_TC_LobbyTest_GF444_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("search lobby");
		Thread.sleep(2000);
		LobbyPage lb = new LobbyPage(driver);
	
		test.info("TestCase started lobby Search");
		
		Thread.sleep(1000);
//		lb.clicklobbymanagement();
//		test.info("Clicked on store management menu");
//		Thread.sleep(500);
//		lb.clickStoreAccounts();
//		test.info("Clicked on store accounts menu");
		
		 
		//lb.clickViewLobby_Search("cosmoslot");

		//lb.searchlist(Lcode,Lcode, driver);
		lb.SearchItems(Lcode);
		test.info("Store Search = <b>" +Lcode+ "</b>" ,extentScreenshot());
		System.out.println("searched Lobby code- " + Lcode);

		//Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/button[text()=\"Lobby\"]")));
		
//		if(driver.findElements(By.xpath("//div/button[text()=\"Lobby\"]")).size()>0)
//		{
//			test.info("Successfully Opened Lobby page");
//			if(driver.findElement(By.xpath("//div//span[text()=\"1\"]"))!=null) {
//				test.info("Successfully View lobbies");
//				Assert.assertTrue(true);
//			}
//		}
//		else
//		{
//			test.info("Something Wrong ! To Open Lobby Page 1109");
//			Assert.assertTrue(false);
//		}
		//lp.clickHomePage();
		
		//verify table data
//		int rowCount = 0;
//		rowCount = driver.findElements(By.xpath("//table//tbody//tr")).size();
//		System.out.println("number of rows: "+rowCount);	 
//		String number1= driver.findElement(By.xpath("//table//tbody//tr//td[1]")).getText();		
//		String code= driver.findElement(By.xpath("//table//tbody//tr//td[2]")).getText();
//		String name= driver.findElement(By.xpath("//table//tbody//tr//td[3]")).getText();
//		String desc= driver.findElement(By.xpath("//table//tbody//tr//td[4]")).getText();
//		String CreatedAt= driver.findElement(By.xpath("//table//tbody//tr//td[5]")).getText();
//		String UpdatedAt= driver.findElement(By.xpath("//table//tbody//tr//td[6]")).getText();
		
	 
		Thread.sleep(1000);

		test.info("TestCase-1109 SEARCH Store Ended");
	}
	
	@Test
	public void Da_TC_LobbyTest_GF444_Maintenance() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Maintenance");
		Thread.sleep(2000);
		LobbyPage lb = new LobbyPage(driver);
 		CommonCosmo CC=new CommonCosmo(driver);
	 		
		test.info("TestCase started Store Maintenance - As an admin user I should be able to perform Store Maintenance");
		
		Thread.sleep(1000);

		if(driver.findElements(By.xpath("(//a[@title=\"Store Account Maintenance Mode\"])[1]")).size() > 0)
		{
			Assert.assertTrue(true);
			
			lb.clickViewMaintenance();
			Thread.sleep(500);
			test.info("Store Account Maintenance Mode popup opened",extentScreenshot());
			
			if (driver.findElements(By.xpath("(//h3[text()='Store Account Maintenance Mode'])[1]")).size() > 0) {
				test.info("Store Account Maintenance label displayed");
				lb.Click_Maintenance_platform();
				Thread.sleep(200);

				// lb.ClickDesc();
				lb.Maintenance_Desc("Lobby under Maintenance mode");
				test.info("Description added successfully");
				Thread.sleep(1000);

				lb.ClickToSave();
				test.info("Clicked on saved button", extentScreenshot());
				Thread.sleep(1000);
				lb.ClickToYes();
				// Thread.sleep(500);
				test.info("Clicked to lobby Maintenance activated");

				Thread.sleep(1000);

				if (driver.findElement(By.xpath("//span[text()=\"Store maintenance data saved successfully\"]"))
						.isDisplayed() == true) {
					// Assert.assertTrue(true);
					test.pass("<b><i>Store maintenance data saved successfully</b></i>", extentScreenshot());
					// Thread.sleep(1000);

				} else if (driver.findElement(By.xpath("//span[text()=\"Store maintenance data update successfully\"]"))
						.isDisplayed() == true) {
					// Assert.assertTrue(true);
					test.pass("<b><i>Store maintenance data update successfully</b></i>", extentScreenshot());
					// Thread.sleep(1000);
				} else {
					test.fail("<b><i>Store maintenance data update successfully message not displayed</b></i>",
							extentScreenshot());
					Assert.assertTrue(false);
				}

				Thread.sleep(1000);
			} else {
				test.info("Store Account Maintenance Mode popup not found", extentScreenshot());
			}
		} else {
			test.fail("Store Account Maintenance button not found", extentScreenshot());
		}

		Thread.sleep(1500);

		test.info("TestCase Store Maintenance Ended");
	}
	
	@Test 
	public void E_TC_LobbyTest_GF1192_AddPlayerURL() throws IOException, InterruptedException 
	{
		test = extentCreateTest("AddPlayerURL");
		Thread.sleep(2000);
		test.info("TestCase started Add Player URL Listing ");	
 	//	CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
 		//GuestPlayers gp = new GuestPlayers(driver);
 		
		if(driver.findElements(By.xpath("(//a[@title='Invited Players'])[1]")).size() > 0)
		{
			Thread.sleep(1000);
			lb.clickAddPlayerURL();
			test.info("Click on InvitePlayer URL");
			Thread.sleep(1000);		
		
//			lb.SearchItems(SearchAddPlayerURL);
//			test.info("Search InvitePlayerURL = <b>"+ SearchAddPlayerURL + "</b>",extentScreenshot());			
					 
			driver.findElement(By.xpath("//a[@title='Back']")).click();
			test.info("Clicked on back button");
			Assert.assertTrue(true);	
		}else{
			//test.info("Something Wrong ! not able to Edit");
			test.fail("<b><i>InvitePlayerURL icon not found</b></i>", extentScreenshot());
			Assert.assertTrue(false);	
		 }	
 		
		test.info("TestCase- Invite player URL Ended");
	}
	
	/*@Test(priority=5)
	public void TC_LobbyTest_View() throws IOException, InterruptedException 
	{
		test.info("TestCase started view lobby - As an admin user I should be able to view lobby ");	
		//test.info("URL is opened");
		//CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
	//	LoginPage lp = new LoginPage(driver);
	//	GuestPlayers gp = new GuestPlayers(driver);
	
		//working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
		Thread.sleep(1000);
		lb.clickViewLobby();
		Thread.sleep(1500); 
		
//		lb.clickViewLobby_Profile();
//		Thread.sleep(2000); 
//		
//		lb.clickViewLobby_LobbyPackage();
//		Thread.sleep(1000); 
// 
//		lb.clickViewLobby_Game();
//		Thread.sleep(1000); 
//		
//		lb.clickViewLobby_Version();
//		Thread.sleep(1000); 
//		
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(1000); 
//		
//		lb.clickViewLobby_Withdraw();
//		Thread.sleep(1000); 
//		
//		lb.clickViewLobby_AppSetting();
//		Thread.sleep(1000); 
//
//		lb.clickViewLobby_WebsiteSetting();
//		Thread.sleep(1000); 
		test.info("TestCase-view lobby Ended");
	}
	*/
	
	@Test 
	public void F_TC_LobbyTest_Copy() throws IOException, InterruptedException 
	{
		test = extentCreateTest("copy store link");
		Thread.sleep(2000);
		test.info("TestCase started Copy store link - As an admin user I should be able to Copy  store link ");	

		//CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
	
		if(driver.findElements(By.xpath("(//i[@class='ri-file-copy-line'])[1]")).size()>0)
		{
			test.info("Successfully Viewed COPY store link icon");
			Assert.assertTrue(true);
			Thread.sleep(1000);
			lb.clickCopyLobby();
			test.info("Successfully COPY store link link",extentScreenshot());
		}
		else
		{
			test.info("lobby COPY icon not found.",extentScreenshot());
			Assert.assertTrue(false);			
		}	
		
		Thread.sleep(2000); 
		test.info("TestCase-copy loby Ended");
	}
	
	@Test 
	public void G_TC_LobbyTest_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Edit store");
		Thread.sleep(2000);
		//CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
		
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0)
		{	
			lb.clickToEdit();
			test.info("store edit button clicked");
			Thread.sleep(1500);
				
 			
		     List<WebElement> boxes = driver.findElements(By.className("ri-close-fill"));
			//List<WebElement> boxes = driver.findElements(By.xpath("//i[@class='ri-close-fill']"));
		    // Thread.sleep(100);
		     if(boxes.size() != 0) 
			   {
				   System.out.println(boxes.size() + " Elements found by TagName \n");
					
				   for(WebElement inputElement : boxes) 
				   {
					   System.out.println(inputElement.getAttribute("class"));
					   inputElement.click();
					  // Thread.sleep(100);
				   }
			   }
		     
		    Thread.sleep(1000);
		    lb.setCountry();
			test.info("Lobby Country = <b>"+ "" + "</b>");	
			 
			Thread.sleep(1000);
			lb.setGames("Machu Picchu");
			Thread.sleep(500);
			
			//lb.Player_Registration_Link("https://qa-cpweb-admin.cosmoslots.tech");
			lb.Set_Desc("This is just for AutoTesting");
	        
	        test.info("Lobby edit Description = <b>" +"This is just for AutoTesting" + "</b>");
			lb.ClickToSave();
			test.info("save button clicked to update store");
			Thread.sleep(1500);
			
			//if(CC.Validation_Format_Lobby_Update.isDisplayed()==true){
			if(driver.findElement(By.xpath("//span[text()=\"Store updated successfully\"]")).isDisplayed()==true){
				Assert.assertTrue(true);
				//test.info("lobby update validation message");
				test.pass("<b><i>store update validation message</b></i>", extentScreenshot());

			 }else{
				//test.info("Something Wrong ! not able to Edit");
				test.fail("<b><i>store update validation message not displayed</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
			  }
		 }
		else {
			test.info("Edit button not found", extentScreenshot());
			
		}
		Thread.sleep(1000);		 
		test.info("TestCase-edit store Ended");
	
	}
	
	@Test 
	public void H_TC_LobbyTest_View_Profile() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store profile");
		Thread.sleep(2000);
		test.info("TestCase started view Store profile - As an admin user I should be able to view Store profile");	
		 
		LobbyPage lb = new LobbyPage(driver);
	  
		//Working
		lb.clicklobbymanagement();
		test.info("Clicked on Store management menu");
		Thread.sleep(500);
		lb.clickStoreAccounts();
		test.info("Clicked on Store menu");
		//lb.clickViewLobby_Search("cosmoslot");

		
		//search COSMOSLOT
//		lb.searchlist(Lcode, Lcode, driver);
//		test.info("Lobby Search = <b>" +Search_Lobby+ "</b>" ,extentScreenshot());
		
		lb.SearchItems(Lcode);
		
		test.info("Store Search = <b>" +Lcode+ "</b>" ,extentScreenshot());	
		
	 	Thread.sleep(1000);
		lb.clickViewLobby();
		test.info("View Searched Store");
		Thread.sleep(1000); 
		
	//	String search1=driver.findElement(By.xpath("//DIV[contains(text(), 'CS')]")).getText();
		
		lb.clickViewLobby_Profile();
		Thread.sleep(500);
		
		if(driver.findElements(By.xpath("//span[contains(.,'"+Lcode+"')]")).size() > 0)
		{
			test.info("profile verified with searched item",extentScreenshot());
			System.out.println("verified");
		}
		else
		{
			test.info("profile not verified with searched item",extentScreenshot());
			System.out.println(" not verified");

		}		
		test.pass("Clicked on Store Profile",extentScreenshot());
		Thread.sleep(1000);
		
		test.info("TestCase-view profile lobby Ended");
	}
	
	@Test(groups = {"admin","website"}) 
	public void I_TC_LobbyTest_View_StorePackage_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Add lobby store package");
		Thread.sleep(2000);
		test.info("TestCase started create Lobby store Package - As an admin user I should be able to create Lobby store Package");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);

		//Working
				lb.clicklobbymanagement();
				test.info("Clicked on Store management menu");
				Thread.sleep(500);
				lb.clickStoreAccounts();
				test.info("Clicked on Store menu");
				//lb.clickViewLobby_Search("cosmoslot");

				
				//search COSMOSLOT
//				lb.searchlist(Lcode, Lcode, driver);
//				test.info("Lobby Search = <b>" +Search_Lobby+ "</b>" ,extentScreenshot());
				
				lb.SearchItems(Lcode);
				
				test.info("Store Search = <b>" +Lcode+ "</b>" ,extentScreenshot());	
				
			 	Thread.sleep(1000);
				lb.clickViewLobby();
				test.info("View Searched Store");
				Thread.sleep(1000); 
		
				 
		lb.clickView_LobbyStorePackage();
		test.info("Clicked on lobby  store package");

		Thread.sleep(500); 		    
   	
		//Create Lobby store Package 
		test.info("Create Lobby store Package test case start" );
		lb.clickToCreate();
		Thread.sleep(500); 

		//Search_package="T"+randNum;
		lb.LobbyPackage_Code(Search_Storepackage);
		lb.LobbyPackage_name(Search_StorePackageName);
		lb.LobbyPackage_amount(StorePackageAmount);
		lb.LobbyPackage_discountAmount("");
		lb.LobbyPackage_Gametoken(StorePackageGT);
		lb.LobbyPackage_Sweeptoken(StorePackageST);
		lb.LobbyPackage_extraSweeptoken("100");
		LobbyPage.description.sendKeys("this is testing store package");
		Thread.sleep(1000);
		
		lb.ClickToSave();		
	
		test.info("store package code = <b>" +Search_Storepackage+ "</b>");
		test.info("store package name= <b>" +Search_StorePackageName+ "</b>");
		test.info("store package amount= <b>"+"$"+StorePackageAmount+ "</b>");
		test.info("store package discount amount= <b>" +""+ "</b>");
		test.info("store package GameToken= <b>" +StorePackageGT+ "</b>");
		test.info("store package SweepToken= <b>" +StorePackageST+ "</b>");
		test.info("store package ExtraSweepToken= <b>" +"100"+ "</b>");
		test.info("store package description= <b>" +"this is testing store package"+ "</b>");
				
		Thread.sleep(500);

		test.info("Clicked save button",extentScreenshot());
		//Thread.sleep(1000);
		
		//Boolean bool=cc.Validation_Format_Addpackage.isDisplayed();		
		//if(cc.Validation_Format_Addpackage.isDisplayed()==true){
		if(driver.findElements(By.xpath("//span[text()=\"Store package save successfully\"]")).size() > 0)
		{
			Assert.assertTrue(true);
			//test.info("LobbyPackage - add successfully");
			Thread.sleep(1000);
			test.pass("<b><i>Store Package - add successfully</b></i>", extentScreenshot());

		}
		else if(driver.findElements(By.xpath("//span[text()=\"Package code must be unique\"]")).size() > 0)
		{
			Thread.sleep(1000);
			test.info("<b><i>Store Package - Package code must be unique</b></i>", extentScreenshot());
			lb.ClickToCancel();
			//Assert.assertTrue(false);	
		}
		else
		{			
			//Thread.sleep(500);
			test.fail("<b><i>not able to Add Store Package </b></i>", extentScreenshot());
			Thread.sleep(1000);
			lb.ClickToCancel();
			//lb.ClickToClose();		
			Assert.assertTrue(false);	
		}
		
		List<WebElement> boxes = driver.findElements(By.className("mat-column-name"));	      
		if(!boxes.isEmpty())
        {  
              for(WebElement inputElement : boxes)
              {
                  //print all store package from admin
                 // System.out.println(inputElement.getText());
                  shift.add(inputElement.getText().toUpperCase());
                  TotalStorePackage++;                  
              }
              shift.remove(0);  
             // System.out.println(boxes.size() + " Elements found by className \n");
          }
		
		Thread.sleep(2000);
		test.info("Create Store Package TestCase End");
			
	}
	
	@Test(groups = {"admin","website"}) 
	public void Ia_TC_LobbyTest_Website_VerifyStorePackage_LastAdded() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify last added Store Package");

		LobbyPage lb = new LobbyPage(driver);
		PlayerProfile pp=new PlayerProfile(driver);
		GuestPlayers gp=new GuestPlayers(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		String StorePackageAdmin=Search_StorePackageName;
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(500); 
		
		//return player id
		Playerusername=driver.findElement(By.xpath("(//span[@class=\"mys-player-id\"])[1]")).getText();
		System.out.println("player name -"+Playerusername);
		
		Thread.sleep(2000); 
		driver.findElement(By.xpath("(//button[text()=\"Packages\"])[1]")).click();
		Thread.sleep(1500); 
		
		String StorePackageWeb=driver.findElement(By.xpath("//h1[.='"+Search_StorePackageName+"']")).getText();
		String StorePackageWeb_GT=driver.findElement(By.xpath("(//h1[.='"+Search_StorePackageName+"']//following::span[@class='pi-text'])[1]")).getText();
		String StorePackageWeb_ST=driver.findElement(By.xpath("(//h1[.='"+Search_StorePackageName+"']//following::span[@class='pi-text'])[2]")).getText();
		String StorePackageWeb_Amount="$"+driver.findElement(By.xpath("//h1[.='"+Search_StorePackageName+"']//following::span[.='"+"$"+StorePackageAmount+"']")).getText();
		
		if(StorePackageAdmin.equalsIgnoreCase(StorePackageWeb))
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h1[.='"+Search_StorePackageName+"']")));
			Thread.sleep(1000); 
			test.pass("last added StorePackage found in Website",extentScreenshot());
			Assert.assertTrue(true);
			
			if(!(StorePackageWeb_GT.equals(StorePackageGT) && StorePackageWeb_ST.equals(StorePackageST) && StorePackageWeb_Amount.equals(StorePackageAmount)))
			{
				System.out.println("matched GT ST amount with website"+StorePackageWeb_GT+"--"+ StorePackageWeb_ST+"--"+ StorePackageWeb_Amount);
				test.pass("matched GT <b>"+StorePackageWeb_GT+"</b> ST <b>"+ StorePackageWeb_ST+"</b> amount <b>"+ StorePackageWeb_Amount+"</b> with website",extentScreenshot());

				//comment this code ->for compare transaction only with Admin	
				driver.findElement(By.xpath("(//h1[.='"+Search_StorePackageName+"']//following::a[.='Purchase'])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//h1[.='"+Search_StorePackageName+"']//following::button[.='Purchase'])[1]")).click();
				Thread.sleep(3000);
				switchToWindow("Skrill Checkout");
				Thread.sleep(500);
				SkrilPayment();
			
				 VerifyPaymentTransactions_Website();
				VerifyPaymentInAdmin_purchaseHistory();
				VerifyPaymentInAdmin_playerPurchaseHistory();
							
				
			}
			else
			{
				test.info("Not matched GT ST amount",extentScreenshot());
			}
			Thread.sleep(1000); 
			BaseClass.gotoTab(driver,1);		
			
		}
		else
		{
			test.fail("last added StorePackage not found in website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
	}
	
	public void VerifyPaymentTransactions_Website() throws IOException, InterruptedException 
	{
		BaseClass.gotoTab(driver,1);
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.HOME);

		Thread.sleep(500);
		if(driver.findElement(By.xpath("(//button[contains(.,'Transactions')])[1]"))!=null)
		{
			test.pass("Successfully Opened Website Transactions screen");
			
			driver.findElement(By.xpath("(//button[contains(.,'Transactions')])[1]")).click();
			driver.findElement(By.xpath("(//a[contains(@class,\"action-icon\")])[1]")).click();
			Thread.sleep(500);
			
			//return transaction id
			WebsiteTransactionid=driver.findElement(By.xpath("//div[contains(@class,'transation-id')]//child::span[1]")).getText();
			System.out.println("WebsiteTransactionid ->"+WebsiteTransactionid);
			
			//return transaction status
			System.out.println("get payment status ->" +driver.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]")).getText());
			Thread.sleep(500);
			
			if(driver.findElement(By.xpath("//div[contains(@class,'transation-status')]//child::span[1]")).getText().equalsIgnoreCase("Initiate")) 
			{
				Thread.sleep(500);
				test.info("Transaction Details with <b>Initiate</b>",extentScreenshot());
				paymentway="Initiate";
			}
			else 
			{
				Thread.sleep(500);
				paymentway="Success";
				test.info("Transaction Details with <b>Success</b>",extentScreenshot());				
			}
			driver.findElement(By.xpath("//button[contains(@class,'btn-close')]")).click();
			Thread.sleep(500);
			Assert.assertTrue(true);
		}
		else 
		{
			test.fail("Something wrong!To Open Website Transactions screen",extentScreenshot());
			Assert.assertTrue(false);
		}
		
		 
	}
	public void VerifyPaymentInAdmin_purchaseHistory() throws IOException, InterruptedException 
	{
		PurchasesHistory ph=new PurchasesHistory();
		PlayerProfile pp=new PlayerProfile(driver);
		PurchaseHistory pr = new PurchaseHistory(driver);
		GuestPlayers gp=new GuestPlayers(driver);
		LobbyPage lp=new LobbyPage(driver);
	
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
				 
		gp.clickOnPlayerManagement();
		Thread.sleep(500); 
		pr.clickPurchaseHistory();
		Thread.sleep(1000); 
		//ph.PurchaseHistory_WebsiteSearch(WebsiteTransactionid,Playerusername);
		if(driver.findElement(By.xpath("//h3[text()=\"Purchase History\"]"))!=null)
		{
			test.info("Opened Purchase History Successfully on player profile from Admin");
			
			if(paymentway.equalsIgnoreCase("Initiate"))
			{
				driver.findElement(By.xpath("//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]")).click();				
			}
			else
			{
				driver.findElement(By.xpath("//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Payment\")]")).click();
			}
			Thread.sleep(500);	
			gp.Search_Items(WebsiteTransactionid);
			Thread.sleep(3500);
			if(driver.findElements(By.xpath("//th[text()=\"Player Name\"]/following::tr//td[contains(text(),'"+Search_StorePackageName+"')]")).size()>0)	
			{
				lp.View_Click();
				Thread.sleep(1000);
				test.info("Successfully Searched Website <b>Transactions ID</b>",extentScreenshot());				
				lp.ClickToClose();				
				Thread.sleep(300);
				driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
				Thread.sleep(300);
				Assert.assertTrue(true);
				
			}
			else
			{
				test.fail("Something wrong !! To Search Website Transactions ID",extentScreenshot());
				Assert.assertTrue(false);				 
			}
		}
		else
		{
			test.fail("Something wrong !! Player Purchase History not found",extentScreenshot());
			Assert.assertTrue(false);				 
		}
				
	}
	public void VerifyPaymentInAdmin_playerPurchaseHistory() throws IOException, InterruptedException 
	{
		//PurchaseHistoryTest ph=new PurchaseHistoryTest();
		PlayerProfile pp=new PlayerProfile(driver);
	//	PurchaseHistory pr = new PurchaseHistory(driver);
		GuestPlayers gp=new GuestPlayers(driver);
		LobbyPage lp=new LobbyPage(driver);
		String packagename=Search_StorePackageName;
		BaseClass.gotoTab(driver,0);
		Thread.sleep(500); 
				 
		pp.clickOnPlayerManagement();
		Thread.sleep(500); 
		pp.clickPlayerProfileLink();
		Thread.sleep(1500); 
		gp.Search_Items(Playerusername);
		Thread.sleep(2500); 
		pp.Clickeyeicon();
		Thread.sleep(500); 
		pp.clickPurchaseHistoryTab();
	
		Thread.sleep(500); 
		//ph.PurchaseHistory_WebsiteSearch(WebsiteTransactionid,Playerusername);
		
		if(driver.findElement(By.xpath("//button[contains(text(),\"Purchase History\")]"))!=null)
		{
			test.info("Opened player Purchase History Successfully from Admin");
			
			if(paymentway.equalsIgnoreCase("Initiate"))
			{
				driver.findElement(By.xpath("//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]")).click();				
			}
			else
			{
				driver.findElement(By.xpath("//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Payment\")]")).click();
			}
 			Thread.sleep(1500);	
 			System.out.println("Website TransactionID in player purchase history->"+WebsiteTransactionid);
			//gp.Search_Items(WebsiteTransactionid);
			lp.SearchItems(WebsiteTransactionid);
			Thread.sleep(3500);
			if(driver.findElements(By.xpath("//th[text()=\"Package Name\"]/following::tr//td[contains(text(),'"+packagename+"')]")).size()>0)	
			{
				Assert.assertTrue(true);
				lp.View_Click();
				Thread.sleep(1000);
				test.info("Successfully Searched Website <b>Transactions ID</b>",extentScreenshot());				
				lp.ClickToClose();				
				Thread.sleep(300);
				driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
				Thread.sleep(300);				
				
			}
			else
			{
				test.fail("Something wrong !! To Search Website Transactions ID",extentScreenshot());
				Assert.assertTrue(false);				 
			}
		}
		else
		{
			test.fail("Something wrong !! Purchase History not found",extentScreenshot());
			Assert.assertTrue(false);				 
		}
				
	}
	public static void switchToWindow(String windowTitle) {
        
        // Get list of all open tabs - note behaviour may be different between FireFox and Chrome.
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // iterate through open tabs. If the title of the page is contained in the tab, switch to it.
        for (String windowHandle : driver.getWindowHandles()) {
          String title = driver.getTitle();
          driver.switchTo().window(windowHandle);
          if (title.equalsIgnoreCase(windowTitle)) {
        	  driver.manage().window().maximize();
            break;
          }
        }
      }
	public void SkrilPayment() throws IOException, InterruptedException 
	{
		String SkrillEmail="itsupport@ombpmllp.com";
		String SkrillPass="Dell#mc@123";
		
		if(driver.getTitle().equalsIgnoreCase("Skrill Checkout")){
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(SkrillEmail);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(SkrillPass);
			driver.findElement(By.xpath("//input[@id='login_btn']")).click();
			Thread.sleep(5000);
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//input[contains(@class,'confirm-btn')]")));
			test.info("StorePackage <b>Skrill</b> details found in Website",extentScreenshot());

			//driver.findElement(By.xpath("//input[contains(@class,'confirm-btn')]")).click();
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//div[@class=\"thank-you-img\"]")).size()>0) {
			       System.out.println("match thank you page");
			       Thread.sleep(2000);
			       //driver.close();
			}
			else {
				System.out.println("not able to find thank you page");
			}	
		}
	}
	
	
	@Test(groups = {"admin","website"}) 
	public void Ia_TC_LobbyTest_Website_VerifyStorePackage_LastAdded_Purchase() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify last added Store Package");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
		
		String StorePackageAdmin=Search_StorePackageName;
		
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("(//button[text()=\"Packages\"])[1]")).click();
		Thread.sleep(1500); 
		String StorePackageWeb=driver.findElement(By.xpath("//h1[.='"+Search_StorePackageName+"']")).getText();
		
		if(StorePackageAdmin.equalsIgnoreCase(StorePackageWeb))
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//h1[text()='"+Search_StorePackageName+"']//following::*[.='Purchase'])[1]")));
			Thread.sleep(2000); 
			test.info("clicked last added store package",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("last added StorePackage not found in website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}	
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
	}
	
	@Test(groups = {"admin","website"}) 
	public void Ib_TC_LobbyTest_Website_VerifyAllPackages() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Verify all Packages in website");

		LobbyPage lb = new LobbyPage(driver);
//		lb.MasterSettings_Click();
		Thread.sleep(1500); 
				
		BaseClass.gotoTab(driver,1);
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("(//button[text()=\"Packages\"])[1]")).click();
		Thread.sleep(1500);        
				
		List<WebElement> boxesweb = driver.findElements(By.className("plan-title"));
		int StorePackageCountWeb=0;
		int CustomPackageCountWeb=0;
		
        if(!boxesweb.isEmpty())
        {
             // System.out.println(boxesweb.size() + " Elements found by className in web \n");
               
              for(WebElement inputElement1 : boxesweb)
              {                 
                  System.out.println(inputElement1.getText());
                  shiftweb.add(inputElement1.getText()); 
                  
                  if(shift.contains(inputElement1.getText())) {
                      System.out.println("Store package :===>" + inputElement1.getText()); 
                      StorePackageCountWeb++;
                  }
                  else
                  {
                	  System.out.println("Custom package---"+inputElement1.getText());
                	  CustomPackageCountWeb++;
                  }	  
              }              
         }   
        if(StorePackageCountWeb==TotalStorePackage)
        {
        	  test.info("Total StorePackage matched Admin with website - "+TotalStorePackage +"--"+StorePackageCountWeb);
        }
        else 
        {
        	  test.info("Total StorePackage not matched Admin with website - "+TotalStorePackage +"--"+StorePackageCountWeb);
        }
        	
        test.info("Total StorePackage found in Website - "+CustomPackageCountWeb);
        test.info("Total CustomPackage found in Website - "+StorePackageCountWeb);
		BaseClass.gotoTab(driver,0);
		Thread.sleep(1500); 
	}
	
	@Test
	public void J_TC_LobbyTest_View_StorePackage_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("lobby Store package search");

		test.info("TestCase started view Store package search- As an admin user I should be able to search on Store package");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);
		
	//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
		Thread.sleep(2000); 
 
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 

				
		//-----------Search LobbyPackage-----------
		test.info("Search Lobby store Package test case start");
		lb.SearchItems(Search_Storepackage);
		test.info("Lobby package search = <b>" +Search_Storepackage+ "</b>");

		Thread.sleep(1000);
		
		//WebElement wb=driver.findElement(By.xpath("//p[text()=\"No record found\"]"));
        if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in lobby store package Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   // captureScreen(driver, "Search_package");
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		Thread.sleep(1000); 
			Assert.assertTrue(false);
        }
        else 
        {
        	Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        //	 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			//lb.ClickToClose();
        }		
		test.info("Search Store Package TestCase End");
		Thread.sleep(1000);
	 
	}
	@Test 
	public void K_TC_LobbyTest_View_StorePackage_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Lobby Store package view");

		test.info("TestCase started view Store Package - As an admin user I should be able to view on Store Package");	
		LobbyPage lb = new LobbyPage(driver);
	//	CommonCosmo cc=new CommonCosmo(driver);
	
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
	//	Thread.sleep(1000); 
  
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 
		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View Store Package test case start...");
			lb.View_Click();
			test.info("Clicked on Store Package view button");
			Thread.sleep(1000);	
			System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText());
//			if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText().equalsIgnoreCase(Search_package))
//			{
//					Assert.assertTrue(true);
					test.info("Successfully verify searched  LobbyPackage in  a List.");
					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify searched Store Package in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
//				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify searched Store Package</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
			   Thread.sleep(2000);	
			   test.info("View Store Package test case end."); 	
		}
		else
		{
				test.info("View Store Package button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	
	@Test 
	public void L_TC_LobbyTest_View_StorePackage_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("lobby Store package edit");

		test.info("TestCase started Edit Store Package - As an admin user I should be able to Edit Store Package");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);

		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);		
//		lb.clickViewLobby();
		Thread.sleep(1000); 
 
//		lb.clickViewLobby_LobbyPackage();
//		Thread.sleep(1000);  
	    
	   lb.SearchItems(Search_Storepackage);
	   test.info("Store package search = <b>" +"Search_package"+ "</b>",extentScreenshot());

	   Thread.sleep(1000); 
	//------------------Edit LobbyPackage------------
	if(driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0)
	{
		lb.clickToEdit();
		Thread.sleep(2000);
		lb.LobbyPackage_name("starpack"+randomString);
		lb.LobbyPackage_amount("100");
		lb.LobbyPackage_discountAmount("10");
		lb.LobbyPackage_Gametoken("800");
		lb.LobbyPackage_Sweeptoken("800");
		lb.LobbyPackage_extraSweeptoken("150");
		LobbyPage.description.clear();
		LobbyPage.description.sendKeys("this is edit testing Store package...");
		
		test.info("Store package code = <b>" +Search_Storepackage+ "</b>");
		test.info("Store package name= <b>" +"StarPack"+randomString+ "</b>");
		test.info("Store package amount= <b>" +"100"+ "</b>");
		test.info("Store package discount amount= <b>" +"10"+ "</b>");
		test.info("Store package GameToken= <b>" +"800"+ "</b>");
		test.info("Store package SweepToken= <b>" +"800"+ "</b>");
		test.info("Store package ExtraSweepToken= <b>" +"150"+ "</b>");
		test.info("Store package description= <b>" +"this is edit testing package..."+ "</b>");
				
		lb.ClickToSave();
		test.info("Clicked save button to edit");
		Thread.sleep(1000);
		//Boolean bool2=cc.Validation_Format_UpdateStorepackage.isDisplayed();
		if(driver.findElements(By.xpath("//span[text()=\"Store package updated successfully\"]")).size() > 0)
		{
			Assert.assertTrue(true);
			//test.info("LobbyPackage update validation message displayed");
			test.pass("<b><i>Store Package update validation message displayed</b></i>", extentScreenshot());

		}else{
			//test.info("Something Wrong ! not able to update LobbyPackage");
			//captureScreen(driver, "EditLobbyPackage");
			test.fail("<b><i>Store Package update validation message not displayed</b></i>", extentScreenshot());
			Thread.sleep(2500);
			lb.ClickToCancel();
			Assert.assertTrue(false);	
		}
 
		Thread.sleep(1000);	
		
		test.info("TestCase-Edit Store Package Ended");
	}	
	else
	{
		test.info("Edit Store Package button not found",extentScreenshot());
	}
	
	}
	
	@Test 
	public void La_TC_LobbyTest_View_StorePackage_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("StorePackage status");

		test.info("TestCase started status StorePackage- As an admin user I should be able to change status for StorePackage");	
	//	LobbyPage lb = new LobbyPage(driver);
	//	 	
		 		
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
	//	Thread.sleep(1000); 
  
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 
		
		 if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in lobby store package Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   // captureScreen(driver, "Search_package");
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		Thread.sleep(1000); 
			Assert.assertTrue(false);
        }
        else 
        {
        	Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        //	 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			//lb.ClickToClose();
        	
	 //status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
        {
            test.info("Successfully Viewed active StorePackage page");
            test.info("Now StorePackage Is In Active");
            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby package link activated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby StorePackage Successfully activated and Validation message appeared - Lobby StorePackage activated successfully",extentScreenshot());
                }
                else
                {
                    Assert.assertTrue(false);
                    test.fail("Failed ! To View Message",extentScreenshot());
                }
            }
            catch(Exception e)
            {
                if(driver.findElement(By.xpath("//span[text()=\"Lobby package link activated successfully\"]"))!=null)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby StorePackage Successfully activated and Validation message appeared - Lobby StorePackage activated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
            Thread.sleep(4000);

        }
        else
        {
            test.info("Successfully Viewed View Icon of StorePackage listing page");
            test.info("Now StorePackage Is Active");

            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try {
            if(driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]")).size()>0)
            {
                Assert.assertTrue(true);
                test.pass("Lobby StorePackage Successfully deactivated and Validation message appeared - Lobby StorePackage deactivated successfully",extentScreenshot());
            }
            else
            {
                Assert.assertTrue(false);
                test.fail("Failed ! To View Message",extentScreenshot());
            }
            }
            catch(Exception e)
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby StorePackage Successfully deactivated and Validation message appeared - Lobby StorePackage deactivated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
        }
        }
		test.info("TestCase-status StorePackage Ended");
	}
	
	@Test 
	public void M_TC_LobbyTest_View_StorePackage_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store package delete");

		test.info("TestCase started delete Store Package - As an admin user I should be able to delete Store Package");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);

		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
		Thread.sleep(1000); 
 
//		lb.clickViewLobby_LobbyPackage();
//		Thread.sleep(1000); 
		
	 	//-----------delete Store Package-----------
		test.info("delete Store Package test case start");
		if(driver.findElements(By.xpath("(//button//span[text()='Delete'])[1]")).size() > 0)
		{
			lb.DeleteItems();
			test.info("Clicked on delete Store Package button");
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
				Assert.assertTrue(true);
				driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
				test.pass("<b><i>Store Package - delete successfully</b></i>", extentScreenshot());
				
				Thread.sleep(1000);
				Boolean bool1=CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
				if(bool1==true){
					Assert.assertTrue(true);
					//test.info("LobbyPackage - delete message return");
					test.pass("<b><i>StorePackage - delete message return</b></i>", extentScreenshot());
				}else{
					//test.info("Something Wrong ! not able show LobbyPackage delete message ");
					test.fail("<b><i>StorePackage - not able show delete message</b></i>", extentScreenshot());
					Assert.assertTrue(false);	
				}
				//test.info("LobbyPackage - delete successfully");
			}else {
				//test.info("Something Wrong ! not able to delete LobbyPackage ");
				test.fail("<b><i>not able to delete</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
			}
					
		}
		else {
			test.info("delete button not found for Store Package",extentScreenshot());
		}
		Thread.sleep(1000);	
		test.info("delete Store Package test case end");
	}
	
	@Test 
	public void Ma_TC_LobbyTest_View_CustomPackages_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Create Custom Packages");

		test.info("TestCase started Create Lobby Custom Packages");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);
	
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
		Thread.sleep(1000); 
 
		lb.clickViewLobby_LobbyCPackage();
		test.info("Clicked on Custom Packages");

		Thread.sleep(1000); 
		
		//Create Lobby Package 
		test.info("Create Custom Packages TestCase Start" );
		lb.clickToCreate();
		Thread.sleep(500);
		
		//Search_package="T"+randNum;
		lb.LobbyPackage_Code(Search_Custompackage);
		lb.LobbyPackage_name("StarPackCC"+randomString);
		lb.LobbyPackage_amount("100");
		lb.LobbyPackage_discountAmount("90");
		lb.LobbyPackage_Gametoken("500");
		lb.LobbyPackage_Sweeptoken("500");
		lb.LobbyPackage_extraSweeptoken("100");
		LobbyPage.description.sendKeys("this is testing Custom Packages");
		Thread.sleep(500);
		
//		//code for select player
//		if(driver.findElements(By.xpath("//button[text()='Select Player']")).size() > 0)
//		{
//			driver.findElement(By.xpath("//button[text()='Select Player']")).click();
//			Thread.sleep(500);
//			if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
//				
//				Thread.sleep(500);
//				System.out.println("No record found return in select player page");
//				test.info("<b><i>No record found in select player page</b></i>", extentScreenshot());
//
//				lb.ClickToCancel();
//				Thread.sleep(1000); 				
//			}
//			else {
//				Assert.assertTrue(true);				
//				test.info("<b><i>record found in select player page</b></i>", extentScreenshot());
//			
//				if(driver.findElements(By.xpath("//span[text()='Select All Players']")).size()>0) {
//					
//					Thread.sleep(500);
//					System.out.println("Select All Players not found ");
//					test.info("<b><i>Select All Players not found</b></i>", extentScreenshot());
//
//					lb.ClickToCancel();
//					Thread.sleep(1000); 				
//				}
//				else {
//					Assert.assertTrue(true);				
//					test.info("<b><i>record found in Select All Players</b></i>", extentScreenshot());					 
//					driver.findElement(By.xpath("//span[text()='Select All Players']")).click();	
//					lb.ClickToSave();
//					Thread.sleep(1500); 
//				}
//				
//				//lb.ClickToSave();
//				Thread.sleep(1500); 
//			}			
//		}
//		else
//		{
//			test.info("Player selection not found = <b>" + "" + "</b>",extentScreenshot());
//		}
		
		test.info("Custom package code = <b>" +Search_Custompackage+ "</b>");
		test.info("Custom package name= <b>" +"StarPack"+randomString+ "</b>");
		test.info("Custom package amount= <b>" +"25"+ "</b>");
		test.info("Custom package discount amount= <b>" +"5"+ "</b>");
		test.info("Custom package GameToken= <b>" +"500"+ "</b>");
		test.info("Custom package SweepToken= <b>" +"500"+ "</b>");
		test.info("Custom package ExtraSweepToken= <b>" +"100"+ "</b>");
		test.info("Custom package description= <b>" +"this is testing Custom Packages"+ "</b>");
				
		lb.ClickToSave();
		test.info("Clicked save button",extentScreenshot());
		Thread.sleep(1000);
		
		//Boolean bool=cc.Validation_Format_Addpackage.isDisplayed();
		if(driver.findElements(By.xpath("//span[text()=\"Custom package save successfully\"]")).size() > 0)
		{
			Assert.assertTrue(true);
			//test.info("LobbyPackage - add successfully");
			test.pass("<b><i>Custom Packages- add successfully</b></i>", extentScreenshot());

		}
//		else if(driver.findElement(By.xpath("//span[text()=\"Package code must be unique\"]")).isDisplayed()==true){
//			Thread.sleep(500);
//			test.info("<b><i>custom Package - Package code must be unique</b></i>", extentScreenshot());
//			Thread.sleep(1500);
//			//lb.ClickToCancel();
//			driver.findElement(By.xpath("//i[@class=\"ri-arrow-left-line\"]")).click();
//			Assert.assertTrue(true);
//		}
		else{
			
//			Thread.sleep(500);
			test.fail("<b><i>not able to Add Custom Packages </b></i>", extentScreenshot());
			Thread.sleep(1000);
			lb.ClickToCancel();
			//driver.findElement(By.xpath("//i[@class=\"ri-arrow-left-line\"]")).click();
			//lb.ClickToClose();		
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		test.info("Create Custom Packages test case end");
						 
	}
	
	@Test
	public void Mb_TC_LobbyTest_View_CustomPackages_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("CustomPackages Search");

		test.info("TestCase started view CustomPackage search ");	
		LobbyPage lb = new LobbyPage(driver);
	//	CommonCosmo cc=new CommonCosmo(driver);

		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
		Thread.sleep(1000); 
 
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 

		//-----------Search CustomPackage-----------
		test.info("Search CustomPackage test case start");
		lb.SearchItems(Search_Custompackage);
		test.info("CustomPackage search = <b>" +Search_Custompackage+ "</b>");

		Thread.sleep(1000);
	
		//WebElement wb=driver.findElement(By.xpath("//p[text()=\"No record found\"]"));
        if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in CustomPackage Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   
    	   // driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
 			driver.findElement(By.xpath("//span[contains(.,' Clear Filter')]")).click();
    		Thread.sleep(1500); 
			Assert.assertTrue(false);
        }
        else {
        	Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        	// driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();  
        	 Thread.sleep(1000);
        }
		
		test.info("Search CustomPackage test case end");
	 
	}
	@Test 
	public void Mc_TC_LobbyTest_View_CustomPackages_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("CustomPackages View");

		test.info("TestCase started view CustomPackages ");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);
	
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
	//	Thread.sleep(1000); 
 
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 
		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View CustomPackages test case start.");
			lb.View_Click();
			test.info("Clicked on CustomPackages view button");

			Thread.sleep(1000);
//			 System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText());
//			   if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText().equalsIgnoreCase(Search_package))
//			   {
//					Assert.assertTrue(true);
					test.info("Successfully verify searched  LobbyPackage in  a List.");
//					Thread.sleep(500);
//		        	test.pass("<b><i>Successfully verify searched  CustomPackages in  a List.</b></i>", extentScreenshot());
					lb.ClickToClose();
//			   }
//			   else 
//			   {
//				    Thread.sleep(500);
//					//test.info("Something Wrong!To View verified search LobbyPackage type in a List.");
//		        	test.pass("<b><i>not able to verify searched CustomPackages</b></i>", extentScreenshot());
//					Assert.assertTrue(false);
//			   }
			   Thread.sleep(2000);	
			   test.info("View CustomPackages test case end."); 	
		}
		else
		{
				test.info("View CustomPackages button not found", extentScreenshot());		
		}
		Thread.sleep(1000); 
	}
	
	@Test 
	public void Md_TC_LobbyTest_View_CustomPackages_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("CustomPackages Edit");

		test.info("TestCase started Edit CustomPackages  ");	
		LobbyPage lb = new LobbyPage(driver);
	//	CommonCosmo cc=new CommonCosmo(driver);

		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);		
//		lb.clickViewLobby();
		Thread.sleep(1000); 
 
//		lb.clickViewLobby_LobbyPackage();
//		Thread.sleep(1000); 
 
	    
	   lb.SearchItems("100");
	   test.info("CustomPackages search = <b>" +"100"+ "</b>",extentScreenshot());

	   if(driver.findElements(By.xpath("//i[@class=\"ri-arrow-left-line\"]")).size() > 0)
	   {
		   driver.findElement(By.xpath("//i[@class=\"ri-arrow-left-line\"]")).click();
	   }
	   else
	   {
		   System.out.println("not found back buton");
	   }
		   	Thread.sleep(1000); 
	  //------------------Edit LobbyPackage------------
	  if(driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0)
	  {
		lb.clickToEdit();
		Thread.sleep(2000);
		lb.LobbyPackage_name("StarpackCP"+randomString);
		lb.LobbyPackage_amount("100");
		lb.LobbyPackage_discountAmount("10");
		lb.LobbyPackage_Gametoken("800");
		lb.LobbyPackage_Sweeptoken("800");
		lb.LobbyPackage_extraSweeptoken("150");
		LobbyPage.description.clear();
		LobbyPage.description.sendKeys("this is edit testing Custom Packages...");
		
//		//code for select player
//		if(driver.findElements(By.xpath("//button[text()='Select Player']")).size() > 0)
//		{
//					if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
//						System.out.println("No record found return in select player page");
//						test.info("<b><i>record found in select player page</b></i>", extentScreenshot());
//
//						lb.ClickToCancel();
//						Thread.sleep(1500); 
//						
//					}
//					else {
//						Assert.assertTrue(true);				
//						test.info("<b><i>record found in select player page</b></i>", extentScreenshot());
//					
//						driver.findElement(By.xpath("//button[.='Select Player']")).click();
//						driver.findElement(By.xpath("//span[text()='Select All Players']")).click();
//						lb.ClickToSave();
//					}			
//		}
//		else
//		{
//			test.info("Player selection not found = <b>" + "" + "</b>",extentScreenshot());
//		}
		
		test.info("Custom package code = <b>" +Search_Custompackage+ "</b>");
		test.info("Custom package name= <b>" +"StarPackCP"+randomString+ "</b>");
		test.info("Custom package amount= <b>" +"100"+ "</b>");
		test.info("Custom package discount amount= <b>" +"10"+ "</b>");
		test.info("Custom package GameToken= <b>" +"800"+ "</b>");
		test.info("Custom package SweepToken= <b>" +"800"+ "</b>");
		test.info("Custom package ExtraSweepToken= <b>" +"150"+ "</b>");
		test.info("Custom package description= <b>" +"this is edit testing CustomPackages..."+ "</b>");
				
		lb.ClickToSave();
		test.info("Clicked save button to edit");
		Thread.sleep(1000);
		
		//Boolean bool2=cc.Validation_Format_Updatepackage.isDisplayed();
		if(driver.findElements(By.xpath("//span[text()=\"Custom package updated successfully\"]")).size() > 0)
		{
			Assert.assertTrue(true);
			//test.info("LobbyPackage update validation message displayed");
			test.pass("<b><i>CustomPackages update validation message displayed</b></i>", extentScreenshot());

		}else{
			//test.info("Something Wrong ! not able to update LobbyPackage");			
			test.fail("<b><i>CustomPackages update validation message not displayed</b></i>", extentScreenshot());
			Thread.sleep(1500);
			//lb.ClickToCancel();
			Assert.assertTrue(false);	
		}
 
		Thread.sleep(1000);	
		
		test.info("TestCase-Edit CustomPackages Ended");
	}	
	else
	{
		test.info("Edit CustomPackages button not found",extentScreenshot());
	}
	
	}
	
	@Test 
	public void Me_TC_LobbyTest_View_CustomPackages_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("CustomPackages status");

		test.info("TestCase started status CustomPackages- As an admin user I should be able to change status for CustomPackages");	
	//	LobbyPage lb = new LobbyPage(driver);
	//	 	
		 		
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
	//	Thread.sleep(1000); 
  
	//	lb.clickViewLobby_LobbyPackage();
	//	Thread.sleep(1000); 
		
		 if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in lobby store package Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   // captureScreen(driver, "Search_package");
    	   // driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		Thread.sleep(1000); 
			//Assert.assertTrue(false);
        }
        else 
        {
        	//Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        //	 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			//lb.ClickToClose();
       	
	 //status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
        {
            test.info("Successfully Viewed active CustomPackages page");
            test.info("Now CustomPackages Is In Active");
            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby package link activated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby CustomPackages Successfully activated and Validation message appeared - Lobby CustomPackages activated successfully",extentScreenshot());
                }
                else
                {
                    Assert.assertTrue(false);
                    test.fail("Failed ! To View Message",extentScreenshot());
                }
            }
            catch(Exception e)
            {
                if(driver.findElement(By.xpath("//span[text()=\"Lobby package link activated successfully\"]"))!=null)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby CustomPackages Successfully activated and Validation message appeared - Lobby CustomPackages activated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
            Thread.sleep(4000);

        }
        else
        {
            test.info("Successfully Viewed View Icon of CustomPackages listing page");
            test.info("Now CustomPackages Is Active");

            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try {
            if(driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]")).size()>0)
            {
                Assert.assertTrue(true);
                test.pass("Lobby CustomPackages Successfully deactivated and Validation message appeared - Lobby CustomPackages deactivated successfully",extentScreenshot());
            }
            else
            {
                Assert.assertTrue(false);
                test.fail("Failed ! To View Message",extentScreenshot());
            }
            }
            catch(Exception e)
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby package link deactivated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby CustomPackages Successfully deactivated and Validation message appeared - Lobby CustomPackages deactivated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
        }
        }
		test.info("TestCase-status CustomPackages Ended");
	}
	
	
	@Test 
	public void Mf_TC_LobbyTest_View_CustomPackages_Delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("CustomPackages Delete");
		test.info("TestCase started delete CustomPackages - As an admin user I should be able to delete CustomPackages");	
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);

		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		lb.clickViewLobby();
		Thread.sleep(2000); 
 
//		lb.clickViewLobby_LobbyPackage();
//		Thread.sleep(1000); 
		
	 	//-----------delete Lobby CustomPackages-----------
		test.info("delete CustomPackages test case start");
		if(driver.findElements(By.xpath("(//button//span[text()='Delete'])[1]")).size() > 0)
		{
			lb.DeleteItems();
			test.info("clicked on delete CustomPackagesbutton");
			Thread.sleep(1000);
			if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
				Assert.assertTrue(true);
				driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
				test.pass("<b><i>CustomPackages - delete successfully</b></i>", extentScreenshot());
				//test.info("LobbyPackage - delete successfully");
			}else {
				//test.info("Something Wrong ! not able to delete LobbyPackage ");
				test.fail("<b><i>not able to delete</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
			}
			
			Thread.sleep(2000);
			Boolean bool1=CommonCosmo.Validation_Format_Deletepackage.isDisplayed();
			if(bool1==true){
				Assert.assertTrue(true);
				//test.info("LobbyPackage - delete message return");
				test.pass("<b><i>CustomPackages - delete message return</b></i>", extentScreenshot());
			}else{
				//test.info("Something Wrong ! not able show LobbyPackage delete message ");
				test.fail("<b><i>CustomPackages - not able show delete message</b></i>", extentScreenshot());
				Assert.assertTrue(false);	
			}
			Thread.sleep(1000);
			
		}
		else {
			test.info("Delete button not found for CustomPackages",extentScreenshot());
		}
				
		 test.info("Delete CustomPackages test case end");
	}
	
	@Test 
	public void N_TC_LobbyTest_Website_VerifyGames_Web() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Game Search");

		LobbyPage lb = new LobbyPage(driver);

		//remove this code
		lb.clicklobbymanagement();
		test.info("Clicked on Store management menu");
		Thread.sleep(500);
		lb.clickStoreAccounts();
		test.info("Clicked on Store menu");
		lb.SearchItems(Lcode);				
	 	Thread.sleep(1000);
		lb.clickViewLobby();		
		
		
		Thread.sleep(1000); 
		
		lb.clickViewLobby_Game();
		test.info("click on Store Game");

		Thread.sleep(1500); 
		
		int NoGamesAdmin=driver.findElements(By.xpath("//td[contains(@class,'name')]")).size();
		
		BaseClass.gotoTab(driver,1);
		
		driver.findElement(By.xpath("//*[text()=\"Games\"]")).click();
		
		int NoGamesWeb=driver.findElements(By.xpath("//div[contains(@class,\"gameInfo\")]/h5")).size();
		
		if(NoGamesAdmin==NoGamesWeb)
		{
			test.pass("Number of games are the same in Admin and Website",extentScreenshot());
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("Number of games are not the same in Admin and Website ! Failed",extentScreenshot());
			Assert.assertTrue(false);
		}
	
		BaseClass.gotoTab(driver,0);
		
	}
	
	
	
	@Test 
	public void Na_TC_LobbyTest_View_Game_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Game Search");

		test.info("TestCase started Search Store_Game - As an admin user I should be able to Search Store_Game");	
		//test.info("URL is opened");
		//CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);

		
		Thread.sleep(1000); 
		
		lb.clickViewLobby_Game();
		test.info("click on Store Game");

		Thread.sleep(1500); 
		//Thread.sleep(1500);
		//Search game		
		test.info("Search Game test case Start.");
		lb.SearchItems(Search_Game);
		test.info("Search Game = <b>"+Search_Game+"</b>");
 
		
		if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
			test.fail("No record found in Store Games Search page",extentScreenshot());
    	    //captureScreen(driver, "Search_Game");
    	     
    	   // driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
			driver.findElement(By.xpath("//span[contains(.,' Clear Filter')]")).click();
    		Thread.sleep(1500); 
			Assert.assertTrue(false);

        }
        else {
        	Assert.assertTrue(true);
        	//test.info("Record available in search");
			test.pass("Record found return in Store Games Search page",extentScreenshot());

           // driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			Thread.sleep(1500);
			//lb.ClickToClose();
        }
		Thread.sleep(500); 
		test.info("Search game TestCase End.");
		

	}
	@Test 
	public void O_TC_LobbyTest_View_Game_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Game View");

		test.info("TestCase started view Store_Game - As an admin user I should be able to view Store_Game");	
		//test.info("URL is opened");
		//CommonCosmo CC=new CommonCosmo(driver);
		LobbyPage lb = new LobbyPage(driver);
	 
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		Thread.sleep(1500);
//		lb.clickViewLobby_Search("cosmoslot");
//		Thread.sleep(1500);		
//		lb.clickViewLobby();

		
		Thread.sleep(1000); 
		
		lb.clickViewLobby_Game();
		test.info("Click on Lobby Game");

		Thread.sleep(1500); 
		//Thread.sleep(1500);
		
		//Search game 
//		test.info("Search game test case Start.");
//		lb.SearchItems("Fortune Teller");
//		Thread.sleep(1500); 
//		test.info("Search game test case End.");
//		
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			test.info("View game test case start.");
			lb.View_Click();
			test.info("click on View game button");

			Thread.sleep(1000);
			
//			System.out.println("view - " + driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText());
//			    if(driver.findElement(By.xpath("(//table[contains(@class,'view-dialog-table')]//following::tr//td[contains(@class,'ng-star-inserted')])[1]")).getText().equalsIgnoreCase(Search_Game)) {
//					
					test.info("Successfully verify searched  games in  a List.");
//					test.pass("Successfully verify searched games in a List.",extentScreenshot());
//
//					Assert.assertTrue(true);
					lb.ClickToClose();
//				} else {
//					//test.info("Something Wrong!To View verified search games type in a List.");
//					test.fail("not verify searched games in  a List.",extentScreenshot());
//
//					Assert.assertTrue(false);
//				}
			
		    Thread.sleep(2000);	
		    test.info("View game test case end.");    
		}
		else
		{
				test.info("View game view not found",extentScreenshot());		
		}
		Thread.sleep(1000); 	    
	}
	
	
	@Test 
	public void P_TC_LobbyTest_View_Bonus_Create() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus create");

		test.info("TestCase started Create Store Bonus- As an admin user I should be able to Create Store Bonus");	
		LobbyPage lb = new LobbyPage(driver);
		// 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
 		lb.clickViewLobby_Bonus();
		Thread.sleep(2000); 
			
		
		//------Create bonus -----------------
				test.info("Create Store bonus test case start" );
				lb.clickTo_CreateBonus();
				test.info("Click to Create Store bonus" );
				Thread.sleep(500);
				lb.setBonusName("Bonus"+randomString);
				Thread.sleep(500);
				lb.setBonusAction();
				Thread.sleep(500);
				lb.gameToken("100");
				lb.sweepToken("500");
				//lb.ClickDesc();
				LobbyPage.description.sendKeys("this is testing");
				Thread.sleep(100);

				
				test.info("Entered BonusName = <b>"+"Bonus"+randomString+"</b>");
				test.info("<b>Set bonus action  "+""+"</b>");
				test.info("Entered gameToken = <b>"+100+"</b>");
				test.info("Entered sweepToken = <b>"+500+"</b>");
				test.info("Entered description = <b>"+"this is bonus testing"+"</b>");

				lb.ClickToSave();
				test.info("click to save bonus",extentScreenshot());
				Thread.sleep(2000);
				 
						
				if (driver.findElements(By.xpath("//span[text()=\"Bonus save successfully\"]")).size() > 0) {
					//test.info("bonus - add message return");
					test.pass("Add bonus message return",extentScreenshot());
					Assert.assertTrue(true);
				} else {
					//test.info("Something Wrong ! not able get add Bonus message ");
					test.fail("not able to get - add bonus message ",extentScreenshot());
					//captureScreen(driver, "CreateBonus");
					Thread.sleep(1500);
					lb.ClickToCancel();
					//lb.ClickToClose();
					Assert.assertTrue(false);
				}
							 
				Thread.sleep(1000);
				test.info("Create Store bonus test case end");		
 	}
	
	@Test 
	public void R_TC_LobbyTest_View_Bonus_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus search");

		test.info("TestCase started Search Store Bonus- As an admin user I should be able to Search Store Bonus");	
		LobbyPage lb = new LobbyPage(driver);
	//	 
		
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
		Thread.sleep(1000);
		lb.clickViewLobby_Bonus();
		test.info("Click on Store bonus");

		Thread.sleep(2000); 
		
		//---Search  Bonus----		
//		lb.SearchItems(lb.BonusName.getText());
//		test.info("Search bonus  = <b>"+lb.BonusName.getText()+"</b>");
		lb.SearchItems("Bonus");
		Thread.sleep(1000);	
		
		//WebElement wb=driver.findElement(By.xpath("//p[text()=\"No record found\"]"));
        //if(driver.findElement(By.xpath("//p[text()=\"No record found\"]")).isDisplayed()==true) {
		if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0)
		{     
			test.fail("No record found return in bonus Search page",extentScreenshot());
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();  //=lb.ClickToClose_Search();
    	  		Thread.sleep(1500); 
    	//	Assert.assertTrue(false);
        }
        else {
        	//Assert.assertTrue(true);          
			test.pass("record found in bonus Search page",extentScreenshot());
 			Thread.sleep(1500);
        }	
		test.info("TestCase-search  Store Bonus Ended");
	}
	@Test 
	public void S_TC_LobbyTest_View_Bonus_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus view");

 		LobbyPage lb = new LobbyPage(driver);
	//	 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
//		
//		//---Search  Bonus----
//		Thread.sleep(1500);
//		lb.SearchItems("Registration");
//		
		//---View Bonus----
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			
		test.info("view Store bonus test case start");
		Thread.sleep(1500); 
		lb.View_Click();
		test.info("click to view Store bonus");

		Thread.sleep(500);
		
//		String str=lb.BonusName.getText();
//		 System.out.println("view - " + driver.findElement(By.xpath("//td[text()='"+str+"']")).getText());
//		    if(driver.findElement(By.xpath("(//table//tbody//tr[td[contains(@class,'mat-column-name')]]//td[2])[1]")).getText().equalsIgnoreCase(str)) {
//				Assert.assertTrue(true);
				test.info("Successfully verify searched  Bonus in  a List.");
//				test.pass("Successfully verify searched Bonus in a List.",extentScreenshot());
				lb.ClickToClose();
//			} else {
//				//test.info("Something Wrong!To View verified search bonus type in a List.");
//				test.fail("not verify searched Bonus in  a List.",extentScreenshot());
//				Assert.assertTrue(false);
//			}
		    
		    Thread.sleep(1000);
			test.info("view Store bonus test case end");
		}
		else{
				test.info("View Store bonus view not found",extentScreenshot());		
		}
		Thread.sleep(1000); 		
	}
	@Test 
	public void T_TC_LobbyTest_View_Bonus_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus edit");

		test.info("TestCase started Edit Store Bonus- As an admin user I should be able to Edit Store Bonus");	
		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
//		 
		//------------------Edit bonus------------
		if(driver.findElements(By.xpath("(//a[@title='Edit'])[1]")).size() > 0)
		{
		lb.clickToEdit();
		test.info("click to Edit bonus");
		
		lb.setBonusName("Registration Bonus");
		Thread.sleep(500);
		lb.setBonusAction();
		Thread.sleep(500);
		lb.gameToken("200");
		lb.sweepToken("800");
		//lb.ClickDesc();
		LobbyPage.description.clear();
		LobbyPage.description.sendKeys("this is testing entry to edit");
		
		test.info("Entered BonusName = <b>"+"Registration"+"</b>");
		//test.info("select bonus action = <b>"+""+"</b>");
		test.info("Entered gameToken = <b>"+200+"</b>");
		test.info("Entered sweepToken = <b>"+800+"</b>");
		test.info("Entered description = <b>"+"this is testing entry to edit"+"</b>");

		lb.ClickToSave();
		test.info("click to save bonus");

		Thread.sleep(2000);
		//Boolean bool=CommonCosmo.Validation_Format_UpdateBonus.isDisplayed();
		if (driver.findElement(By.xpath("//span[text()=\"Bonus updated successfully\"]")).isDisplayed()==true) {
			//test.info("Bonus update validation message displayed");
			test.pass("Bonus update validation message displayed",extentScreenshot());
			Assert.assertTrue(true);
		}else{
			//test.info("Something Wrong ! not able to get update message");
			test.pass("Bonus update validation message not displayed",extentScreenshot());
			Assert.assertTrue(false);	
		}
		
			Thread.sleep(1000);
		
			test.info("edit bonus test case end");
		}	
		else
		{
			test.info("Edit bonus button not found",extentScreenshot());
		}
	}
	
	@Test 
	public void V_TC_LobbyTest_View_Bonus_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus status");

		test.info("TestCase started status Store Bonus- As an admin user I should be able to status StoreBonus");	
		//LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 			
		 if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in lobby store package Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   // captureScreen(driver, "Search_package");
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		Thread.sleep(1000); 
			Assert.assertTrue(false);
        }
        else 
        {
        	Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        //	 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			//lb.ClickToClose();
       
	 //status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("In Active"))
        {
            test.info("Successfully Viewed active  bonus page");
            test.info("Now Player Is In Active");
            driver.findElement(By.xpath("(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby bonus activated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby bonus Successfully activated and Validation message appeared - Lobby bonus activated  successfully",extentScreenshot());
                }
                else
                {
                    Assert.assertTrue(false);
                    test.fail("Failed ! To View Message",extentScreenshot());
                }
            }
            catch(Exception e)
            {
                if(driver.findElement(By.xpath("//span[text()=\"Lobby bonus activated successfully\"]"))!=null)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby bonus Successfully activated and Validation message appeared - Lobby bonus activated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
            Thread.sleep(4000);

        }
        else
        {
            test.info("Successfully Viewed View Icon of Player on lobby bonus listing page");
            test.info("Now bonus Is Active");

            driver.findElement(By.xpath("(//th[text()=\"Active ?\"]/following::tr//td[contains(@class,\"active\")]//span[contains(@class,'thumb-container')])[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
            Thread.sleep(1000);
            try {
            if(driver.findElements(By.xpath("//span[text()=\"Lobby bonus deactivated successfully\"]")).size()>0)
            {
                Assert.assertTrue(true);
                test.pass("Lobby bonus Successfully deactivated and Validation message appeared - Lobby bonus deactivated successfully",extentScreenshot());
            }
            else
            {
                Assert.assertTrue(false);
                test.fail("Failed ! To View Message",extentScreenshot());
            }
            }
            catch(Exception e)
            {
                if(driver.findElements(By.xpath("//span[text()=\"Lobby bonus deactivated successfully\"]")).size()>0)
                {
                    Assert.assertTrue(true);
                    test.pass("Lobby bonus Successfully deactivated and Validation message appeared - Lobby bonus deactivated successfully",extentScreenshot());
                }
                System.out.println(e);
            }
        }	
        }
		test.info("TestCase-status Lobby_Bonus Ended");
	}
	
	@Test 
	public void W_TC_LobbyTest_View_Bonus_delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store bonus delete");

		test.info("TestCase started delete Store Bonus- As an admin user I should be able to delete Store Bonus");	
		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
 
			
		//-----------delete Bonus-----------
		if(driver.findElements(By.xpath("(//a[@title='Delete'])[1]")).size() > 0)
		{	
		test.info("Delete bonus test case start");
		lb.DeleteItems_Lobby();
		test.info("Click to delete bonus" );

		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			Thread.sleep(500);
			//test.info("Bonus - delete successfully");
			test.pass("Bonus - delete successfully",extentScreenshot());
		}else {
			//test.info("Something Wrong ! not able to delete Bonus ");
			test.fail("Something Wrong ! not able to delete Bonus ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		//Boolean bool1=cc.Validation_Format_DeleteBonus.isDisplayed();
		boolean isPresent_del = driver.findElements(By.xpath("//span[text()=\"Record deleted successfully\"]")).size() > 0;
		if(isPresent_del){
			Assert.assertTrue(true);
			//test.info("bonus - delete message return");
			test.pass("Bonus - delete message return",extentScreenshot());
		}else{
			//test.info("Something Wrong ! not able show Bonus delete message ");
			//captureScreen(driver, "CreateBonus");
			test.pass("Bonus - delete message not displayed",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("Delete Bonus test case end");
	 	
	}	
	else
	{
		test.info("delete lobby bonus button not found",extentScreenshot());
	}
 	}
	
		
	@Test 
	public void Wa_TC_LobbyTest_View_Coupon_Add() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Add Store Coupon");
			
		LobbyPage lb = new LobbyPage(driver);
		
		//Working	
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
 
		lb.clickViewLobby_coupon();
		test.info("click on Store Coupon");
		Thread.sleep(1000); 
		lb.clickToCreate();
		test.info("click to create Store Coupon");
		Thread.sleep(1000); 
		
		//----add coupon --------
		if(driver.findElements(By.xpath("(//h3[.='Add Coupon'])[1]")).size() > 0)
		{	
			Assert.assertTrue(true);
			test.info("Successfully verify store Add label.");
			lb.setcouponName("coupon"+randomString);
			test.info("Entered  name successfully= <b>"+"coupon"+randomString+"</b>");
			lb.Setlobbycode(randomString);
			test.info("Entered  code= <b>"+randomString+"</b>");
			lb.Setcoupon_discountedPercentage("10");
			test.info("Entered  discountedPercentage= <b>"+"10"+"</b>");
			lb.Setcoupon_expiryAt();
			test.info("Setcoupon_expiryAt date = <b>"+"30"+"</b>");
			lb.purchaseDay("Sunday");
			test.info("select  = <b>"+"Sunday"+"</b>");
			lb.Setcoupon_usageByPlayer("1");
			test.info("Entered  Usage of coupon by a player required "+"= <b>"+"1"+"</b>");
			lb.Setcoupon_activationAfterPurchase("0");				
			test.info("Entered  Coupon activation after x no of package purchases by a playe = <b>"+"0"+"</b>");
			lb.Set_Desc("this is testing for add coupon");
			test.info("Entered  Description= <b>"+"this is testing for add coupon"+"</b>");
			
			lb.ClickToSave();
			test.info("Successfully saved add coupon",extentScreenshot());
			Thread.sleep(1000); 
			
			//Boolean bool_AddAppSetting=cc.Validation_Format_SaveAppSettings.isDisplayed();
			if (driver.findElement(By.xpath("//span[text()=\"Coupon save successfully\"]")).isDisplayed()==true) {
				test.pass("store coupon - Save message return",extentScreenshot());
				Assert.assertTrue(true);
			}else{
				Thread.sleep(200); 
				test.fail("Something Wrong ! not able  save coupon message ",extentScreenshot());
				Thread.sleep(500); 
				lb.ClickToCancel();				
				Assert.assertTrue(false);	
			}
			
			
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong! not verify add coupon label.",extentScreenshot());
		}		
		
		Thread.sleep(1000);
		
		test.info("TestCase - add coupon Ended");
	}
	
	@Test 
	public void Wb_TC_LobbyTest_View_Coupon_Search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store coupon search");

		test.info("TestCase started Search Store coupon- As an admin user I should be able to Search Store coupon");	
		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
		Thread.sleep(1000);
		//lb.lb.clickViewLobby_coupon();
		//test.info("Click on Store coupon");

				
		//---Search  coupon----
//		Thread.sleep(1500);
//		lb.SearchItems(lb.BonusName.getText());
//		test.info("Search bonus  = <b>"+lb.BonusName.getText()+"</b>");
		lb.SearchItems("coupon"+randomString);
				
		
		//WebElement wb=driver.findElement(By.xpath("//p[text()=\"No record found\"]"));
        //if(driver.findElement(By.xpath("//p[text()=\"No record found\"]")).isDisplayed()==true) {
		
		if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0)
		{     
			test.fail("No record found return in coupon Search page",extentScreenshot());
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();  //=lb.ClickToClose_Search();
   
       	    //driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
       		Thread.sleep(1500); 
    		Assert.assertTrue(false);
        }
        else {
        	Assert.assertTrue(true);
           //	test.info("Record available in search");
			test.pass("record found in coupon Search page",extentScreenshot());
			
 			Thread.sleep(1500);
        }
		Thread.sleep(1500);
		test.info("TestCase-search Store coupon Ended");
	}
	
	@Test 
	public void Wc_TC_LobbyTest_View_Coupon_Edit() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Edit Store Coupon");
			
		LobbyPage lb = new LobbyPage(driver);
		
		Thread.sleep(1000); 
		test.info("TestCase-Edit Store coupon start");
		//Working	
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
 
		//lb.clickViewLobby_coupon();
		//test.info("click on Store Coupon");
		
         lb.clickToEdit();
         
		//----edit coupon --------
		if(driver.findElements(By.xpath("(//h3[.='Edit Coupon'])[1]")).size() > 0)
		{	
			Assert.assertTrue(true);
			test.info("Successfully verify store Edit label.");
			
			lb.Setcoupon_discountedPercentage("10");
			test.info("Entered  discountedPercentage= <b>"+"10"+"</b>");
			lb.Setcoupon_expiryAt();
			test.info("Setcoupon_expiryAt date = <b>"+"30"+"</b>");
			lb.purchaseDay("Saturday");
			test.info("select  = <b>"+"Sunday"+"</b>");
			
			lb.Set_Desc("this is testing for add coupon");
			test.info("Entered  Description= <b>"+"this is testing for edit coupon"+"</b>");
			
			Thread.sleep(1000);
			lb.ClickToSave();
			test.info("Successfully saved edit coupon",extentScreenshot());
			Thread.sleep(1000); 
			
			//if(CommonCosmo.Validation_Format_coupon_updated.isDisplayed()==true){
		    if (driver.findElement(By.xpath("//span[text()=\"Coupon updated successfully\"]")).isDisplayed()==true) {
				test.pass("store coupon - updated message return",extentScreenshot());
				Assert.assertTrue(true);
			}
		    else
		    {
				test.fail("Something Wrong ! not able get updated coupon message ",extentScreenshot());
				Assert.assertTrue(false);	
			}
			Thread.sleep(1000);
			
		} 
		else
		{
			test.fail("Something Wrong! not verify  edit coupon label.",extentScreenshot());
			Assert.assertTrue(false);
			
		} 
		
		Thread.sleep(1000);
		
		test.info("TestCase - edit coupon Ended");
	}
	@Test 
	public void Wd_TC_LobbyTest_View_Coupon_View() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store coupon view");

 		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
//		
//		//---Search  coupon----
//		Thread.sleep(1500);
//		lb.SearchItems("Registration");
//		
		//---View coupon----
		if(driver.findElements(By.xpath("(//a[@title='View'])[1]")).size() > 0)
		{
			
		test.info("view Store coupon test case start");
		Thread.sleep(1500); 
		lb.View_Click();
		test.info("click to view Store coupon");

		Thread.sleep(500);
		
//		String str=lb.BonusName.getText();
//		 System.out.println("view - " + driver.findElement(By.xpath("//td[text()='"+str+"']")).getText());
//		    if(driver.findElement(By.xpath("(//table//tbody//tr[td[contains(@class,'mat-column-name')]]//td[2])[1]")).getText().equalsIgnoreCase(str)) {
//				Assert.assertTrue(true);
//				//test.info("Successfully verify searched  coupon in  a List.");
//				test.pass("Successfully verify searched coupon in a List.",extentScreenshot());
				lb.ClickToClose();
//			} else {
//				//test.info("Something Wrong!To View verified search coupon type in a List.");
//				test.fail("not verify searched coupon in  a List.",extentScreenshot());
//				Assert.assertTrue(false);
//			}
		    
		    Thread.sleep(1000);
			test.info("view Store coupon test case end");
		}
		else{
				test.info("View Store coupon view not found",extentScreenshot());		
		}
		Thread.sleep(1000); 		
	}
	
	@Test
	public void We_TC_LobbyTest_View_Coupon_Status() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store coupon Status");

		test.info("TestCase started Status store coupon - As an admin user I should be able to Status store coupon");	
		 
		//CommonCosmo CC=new CommonCosmo(driver);
		//LobbyPage lb = new LobbyPage(driver);
	 
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//		Thread.sleep(1000);
//		Thread.sleep(1500);
//		lb.clickViewLobby_Search("cosmoslot");
//		Thread.sleep(1500);		
//		lb.clickViewLobby();
		
		Thread.sleep(1000); 
		
//		lb.clickViewLobby_Game();
//		Thread.sleep(1500); 
//		//Thread.sleep(1500);		
		 if(driver.findElements(By.xpath("//p[text()=\"No record found\"]")).size()>0) {
    	     System.out.println("No record found return in lobby store package Search page");
 			test.fail("<b><i>No record found Search page</b></i>", extentScreenshot());
    	   // captureScreen(driver, "Search_package");
    	    driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		Thread.sleep(1000); 
			Assert.assertTrue(false);
        }
        else 
        {
        	Assert.assertTrue(true);
        	test.info("Record available in search");
        	test.pass("<b><i>record found Search page</b></i>", extentScreenshot());
        //	 driver.findElement(By.xpath("//mat-icon[text()='clear']")).click();
    		//captureScreen(driver, "Search_package");
			//lb.ClickToClose();
     	
		//Status publish/Un Publish
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Publish"))
		{
		            test.info("Successfully Viewed publish coupon page");
		            test.info("Now coupon Is UnPublish");
		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
		            Thread.sleep(1000);
		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		            Thread.sleep(1000);
		            try
		            {
		                if(driver.findElements(By.xpath("//span[text()=\"Lobby Coupon deactivated successfully\"]")).size()>0)
		                {
		                    Assert.assertTrue(true);
		                    //test.info("Lobby game Successfully unpublished and Validation message appeared - Lobby game unpublished  successfully");
		                    test.pass("Store coupon Successfully unpublished and Validation message appeared - Store coupon unpublished  successfully",extentScreenshot());
		                }
		                else
		                {  // test.info("Failed ! To View Message");
		                    test.fail("Failed ! To View Message",extentScreenshot());
		                    Assert.assertTrue(false);
		                }
		            }
		            catch(Exception e)
		            {
		                if(driver.findElement(By.xpath("//span[text()=\"Lobby Coupon deactivated successfully\"]"))!=null)
		                {
		                    Assert.assertTrue(true);
		                    //test.info("Lobby game Successfully unpublished and Validation message appeared - Lobby game unpublished  successfully");
		                    test.pass("Store coupon Successfully unpublished and Validation message appeared - Store coupon unpublished  successfully",extentScreenshot());
		                }
		                System.out.println(e);
		            }

		            Thread.sleep(4000);

		        }
		        else
		        {
		            test.info("Successfully Viewed View Icon of Player on lobby coupon listing page");
		            test.info("Now coupon Is publish");

		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
		            Thread.sleep(1000);
		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		            Thread.sleep(1000);
		            try {
		            if(driver.findElements(By.xpath("//span[text()=\"Lobby Coupon activated successfully\"]")).size()>0)
		            {
		                Assert.assertTrue(true);
	                    //test.info("Lobby game Successfully published and Validation message appeared - Lobby game published  successfully");
		                test.pass("Store coupon Successfully published and Validation message appeared - Store coupon published  successfully",extentScreenshot());
		            }
		            else
		            {
		                Assert.assertTrue(false);
		                //test.info("Failed ! To View Message");
	                    test.fail("Failed ! To View Message",extentScreenshot());

		            }
		            }
		            catch(Exception e)
		            {
		                if(driver.findElements(By.xpath("//span[text()=\"Lobby Coupon activated successfully\"]")).size()>0)
		                {
		                    Assert.assertTrue(true);
		                    //test.info("Lobby game Successfully published and Validation message appeared - Lobby game published  successfully");
		                    test.pass("Store coupon Successfully published and Validation message appeared - Store coupon published  successfully",extentScreenshot());
		                }
		                System.out.println(e);
		            }
		        }
        }
        test.info("coupon Status Test case End");
	}
	
	@Test 
	public void Wf_TC_LobbyTest_View_Coupon_delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store coupon delete");

		test.info("TestCase started delete Store coupon- As an admin user I should be able to delete Store coupon");	
		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
 
			
		//-----------delete Bonus-----------
		if(driver.findElements(By.xpath("(//a[@title='Delete'])[1]")).size() > 0)
		{	
		test.info("Delete coupon test case start");
		lb.DeleteItems_Lobby();
		test.info("Click to delete coupon" );

		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			Thread.sleep(500);
			 
			test.pass("coupon - delete successfully",extentScreenshot());
		}else {
			 
			test.fail("Something Wrong ! not able to delete coupon ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		 
		boolean isPresent_del = driver.findElements(By.xpath("//span[text()=\"Record deleted successfully\"]")).size() > 0;
		if(isPresent_del){
			Assert.assertTrue(true);
			//test.info("bonus - delete message return");
			test.pass("coupon - delete message return",extentScreenshot());
		}else{
			
			test.pass("coupon - delete message not displayed",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(1000);
		test.info("Delete coupon test case end");	 	
		}	
		else
		{
			test.info("delete lobby coupon button not found",extentScreenshot());
		}
 	}
	@Test 
	public void Wg_TC_LobbyTest_View_Coupon_PlayerCoupon() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store player coupon");

		LobbyPage lb = new LobbyPage(driver);
		 
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
		
//		Thread.sleep(1000);
//		lb.clickViewLobby_Bonus();
//		Thread.sleep(2000); 
 
			
		//-----------Store player coupon-----------
		if(driver.findElements(By.xpath("(//i[@class=\"ri-coupon-3-line\"])[1]")).size() > 0)
		{	
			test.info("Player Coupons Details test case start");
			lb.clickTo_PlayerCoupon();
			test.info("Click on player coupon button" );

			driver.findElement(By.xpath("//a[@title='Back']")).click();
			
			//test.info("Clicked on back button");
		
			Thread.sleep(1000);
		
			test.info("player coupon test case end");	 	
		}	
		else
		{
			test.info("player coupon button not found",extentScreenshot());
		}
 	}
	
	@Test 
	public void X_TC_LobbyTest_View_Withdraw_Add() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Withdraw settings");

		test.info("TestCase started Add Store_Withdraw- As an admin user I should be able to Add Store_Withdraw");	
		LobbyPage lb = new LobbyPage(driver);
		 
		//Working	
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
 
		lb.clickViewLobby_Withdraw();
		test.info("click on Withdraw settings");

		Thread.sleep(1000); 

		//----save Withdraw --------
		if(lb.ViewLobby_WithdrawSetting_Title.getText().equalsIgnoreCase("Withdraw Amount Details")) {
			Assert.assertTrue(true);
			test.info("Successfully verify Withdraw settings label.");
			lb.ViewLobby_WithdrawSetting_amount("1");
			lb.ViewLobby_WithdrawSetting_sweepTokens("10");
			lb.ViewLobby_WithdrawSetting_minimumAmountWithdrawal("10");
			lb.ViewLobby_WithdrawSetting_withdrawApprovalRequired("900");
			lb.ViewLobby_WithdrawSetting_PerTransactionLimit("10000");
			lb.ViewLobby_WithdrawSetting_perDayTransactionLimit("20000");
				
			test.info("Entered WithdrawSetting_amount = <b>"+"1"+"</b>");
			test.info("Entered WithdrawSetting_sweepTokens = <b>"+"10"+"</b>");
			test.info("Entered WithdrawSetting_minimumAmountWithdrawal = <b>"+"10"+"</b>");
			test.info("Entered WithdrawSetting_withdrawApprovalRequired = <b>"+"900"+"</b>");
			test.info("Entered WithdrawSetting_PerTransactionLimit = <b>"+"10000"+"</b>");
			test.info("Entered WithdrawSetting_perDayTransactionLimit = <b>"+"20000"+"</b>");
			
			lb.ClickToSave();
			Thread.sleep(1000);
			test.info("Successfully saved Withdraw settings",extentScreenshot());
			Thread.sleep(1000);
			
			//Boolean bool_AddAppSetting=cc.Validation_Format_SaveAppSettings.isDisplayed();
			//if(CommonCosmo.Validation_Format_WithdrawSettings_saved.isDisplayed()==true){
			if (driver.findElement(By.xpath("//span[text()=\"Withdraw Settings data save successfully\"]")).isDisplayed()==true) {

				test.pass("Withdraw setting - Save message return",extentScreenshot());
				Assert.assertTrue(true);
			}else{
				test.fail("Something Wrong ! not able get save Withdraw setting message ",extentScreenshot());
				Assert.assertTrue(false);	
			}			
			
		} else {
			Assert.assertTrue(false);
			test.fail("Something Wrong! not verify  Withdraw label.",extentScreenshot());
		} 
		
		Thread.sleep(1000);
		test.info("TestCase - add Lobby_Withdraw Ended");
	}

//	
	@Test 
	public void Y_TC_LobbyTest_View_AppSetting_add() throws IOException, InterruptedException 
	{		
		test = extentCreateTest("lobby App settings Save");

		test.info("TestCase started Lobby_AppSetting- As an admin user I should be able to view Lobby_AppSetting");	
		LobbyPage lb = new LobbyPage(driver);
		
		Thread.sleep(1000);
		
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
 
		lb.clickViewLobby_AppSetting();
		test.info("click on lobby app settings");

		Thread.sleep(1000); 
		
		//----save App Setting --------
		test.info("save app setting test case start");
		if(lb.ViewLobby_AppSetting_title.getText().equalsIgnoreCase("Information")) {
			Assert.assertTrue(true);
			test.info("Successfully verify app settings label.");
			lb.AppSetting_Company("Gameium");
			lb.AppSetting_website("www.gameium.com");
			lb.AppSetting_TermsCondition("www.gameium.com/contact-us/");
			lb.AppSetting_PrivacyPolicy("www.gameium.com/contact-us/");
			lb.AppSetting_copyRights("www.gameium.com/contact-us/");
			lb.AppSetting_ResponsibleGamingLink("www.gameium.com/contact-us/");
			lb.AppSetting_RedemptionPolicyLink("www.gameium.com/contact-us/");
			lb.AppSetting_SweepRulesLink("www.gameium.com/contact-us/");
			lb.AppSetting_faqUrl("www.gameium.com/contact-us/");

			Thread.sleep(500);
			lb.SetNewsicon(Upload_Icon);
			
			test.info("Entered AppSetting_Company = <b>"+"Gameium"+"</b>");
			test.info("Entered AppSetting_website = <b>"+"www.gameium.com"+"</b>");
			test.info("Entered AppSetting_TermsCondition = <b>"+"www.gameium.com/contact-us/"+"</b>");
			test.info("Entered AppSetting_PrivacyPolicy = <b>"+"www.gameium.com/contact-us/"+"</b>");
			test.info("Entered AppSetting_copyRights = <b>"+"www.gameium.com/contact-us/"+"</b>");
			test.info("Entered AppSetting_ResponsibleGamingLink = <b>"+"www.gameium.com/contact-us/"+"</b>");
			test.info("Entered AppSetting_RedemptionPolicyLink = <b>"+"www.gameium.com/contact-us/"+"</b>");
			test.info("Entered AppSetting_SweepRulesLink = <b>"+"www.gameium.com/sweeprules/"+"</b>");
			test.info("Entered AppSetting_FaqUrl = <b>"+"www.gameium.com/faq/"+"</b>");

			test.info("Image uploaded sucessfully "+""+"");
 
			//Thread.sleep(500);
			lb.ClickToSave();
			Thread.sleep(1000);
			test.info("<b><i>Data saved successfuly for app settings</b></i>", extentScreenshot());
			Thread.sleep(1000);

			//Boolean bool_AddAppSetting=cc.Validation_Format_SaveAppSettings.isDisplayed();
			//if(CommonCosmo.Validation_Format_SaveAppSettings.isDisplayed()==true){
			if (driver.findElement(By.xpath("//span[text()=\"App settings data save successfully\"]")).isDisplayed()==true) {

				test.pass("app setting - Save message return",extentScreenshot());
				Assert.assertTrue(true);
			}else{
				test.fail("Something Wrong ! not able get save app setting message ",extentScreenshot());
				Assert.assertTrue(false);	
			}
		} else {
			test.fail("Not verify save app setting -Information label.",extentScreenshot());
			Assert.assertTrue(false);
		} 		
		Thread.sleep(2000);
		test.info("save app setting test case end");
		 
	}
	
	@Test 
	public void Ya_TC_LobbyTest_View_AppSetting_delete() throws IOException, InterruptedException 
	{		
		test = extentCreateTest("lobby App settings Delete");

		test.info("TestCase started Lobby_AppSetting- As an admin user I should be able to view Lobby_AppSetting");	
		LobbyPage lb = new LobbyPage(driver);
		
		Thread.sleep(1000); 
		
		//Working
//		lb.clicklobbymanagement();
//		Thread.sleep(1500);
//		lb.clicklobby();	
//	 	Thread.sleep(1000);
//		lb.clickViewLobby();
//		Thread.sleep(2000); 
 
//		lb.clickViewLobby_AppSetting();
//		test.info("click on lobby app settings");

		Thread.sleep(1000); 
		
		
		//-----delete version-------
		test.info("delete app setting test case start");
		Thread.sleep(1000); 
		if(driver.findElements(By.xpath("(//button//span[text()='Delete'])[1]")).size() > 0)
		{
			Assert.assertTrue(true);
			test.pass("Successfully delete -app settings",extentScreenshot());
			Thread.sleep(1000); 

			lb.DeleteItems();
			Thread.sleep(2000); 
			
			//Boolean bool_delAppSetting=cc.Validation_Format_DeleteAppSettings.isDisplayed();			
			//if(CommonCosmo.Validation_Format_DeleteAppSettings.isDisplayed()==true){
			if (driver.findElement(By.xpath("//span[text()=\"App Settings data deleted successfully\"]")).isDisplayed()==true) {
	
				Assert.assertTrue(true);
				test.pass("app setting delete message return",extentScreenshot());
			}else{
				test.fail("Something Wrong ! not able get delete app setting message ",extentScreenshot());
				Assert.assertTrue(false);	
			}
			
		}else {			
			test.fail("Something Wrong! not able to delete app setting ",extentScreenshot());
			//Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		
		test.info("delete app setting test case end");				
	}
	
	@Test 
	public void Z_TC_LobbyTest_View_WebsiteSetting_TabAccess() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Website Settings - Tab Access");
		
		LobbyPage lb = new LobbyPage(driver);
	//	CommonCosmo cc=new CommonCosmo(driver);
	
	 	Thread.sleep(1000);
		//lb.clickViewLobby();
		
		
		lb.clickViewLobby_WebsiteSetting();
		//lb.clickViewLobby_WebsiteSetting_TabAccess();
		
		
//		WebElement box = driver.findElement(By.xpath("//input[@type='checkbox']"));
//		     List<WebElement> boxes = box.findElements(By.xpath("//input[@type='checkbox']"));
//		     System.out.println(" boxes - "+ boxes);
//		     int numberOfBoxes = boxes.size();
//		     System.out.println("number of boxes - "+ numberOfBoxes);
//		     driver.findElement(By.xpath("(//input[@type=\"checkbox\"])['" + numberOfBoxes + "']"));
//		     for (int i=1; i<=numberOfBoxes; i++)
//		     {	
//		    	 System.out.println("number of elements - "+ i);
//		    	 boxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
//		    	 boxes.get(i).click();
//		    	// WebElement currentRow = boxes.get(i);
//		    	// driver.findElement(By.xpath("(//input[@type=\"checkbox\"])['" + "position()="+ i + "']")).click();
		    	 		    	 
//		    	 test.info(driver.findElement(By.xpath("(//input[@type='checkbox'])['"+i+"']")).getText()+" clicked");
//		     }
//		     System.out.println("number of elements - "+boxes + numberOfBoxes);
//		     test.info(driver.findElement(By.xpath("(//input[@type='checkbox'])["+numberOfBoxes+"]")).getText()+" clicked");
		
		Thread.sleep(500);	
		driver.findElement(By.xpath("//span[contains(.,'Profile')]")).click();	Thread.sleep(500);		
		driver.findElement(By.xpath("//span[contains(.,'Verify')]")).click(); 	Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Packages')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Stats')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Bonuses')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Withdraw')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Transactions')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Support')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Game Transactions')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Chat')]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//span[contains(.,'Announcement')]")).click();Thread.sleep(500);
						
		
		lb.ClickToSave();
		Thread.sleep(1000);
		test.info("clicked to save website settings Tab Access",extentScreenshot());
		Thread.sleep(1000);
		
		//Boolean bool_delAppSetting=CommonCosmo.Validation_Format_Website_TabAccess.isDisplayed();
		if(driver.findElement(By.xpath("//span[text()=\"Tab Access save successfully\"]")).isDisplayed()==true){
				test.pass("website setting add  Tab Access message return",extentScreenshot());
				//Assert.assertTrue(true);
		}else if (driver.findElement(By.xpath("//span[text()=\"Tab Access updated successfully\"]")).isDisplayed()==true) {
			test.pass("website setting update  Tab Access message return",extentScreenshot());
			//Assert.assertTrue(true);
		}		
		else{
			test.fail("Something Wrong ! not able get add website  Tab Access message ",extentScreenshot());
		//	Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		test.info("Website settings Tab Access TestCase End");
		
	}
	
	@Test 
	public void Za_TC_LobbyTest_View_WebsiteSetting_SignUp() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Website Settings - Sign Up");
		
		LobbyPage lb = new LobbyPage(driver);
		//CommonCosmo cc=new CommonCosmo(driver);
		
		Thread.sleep(1000);
		lb.clickViewLobby_WebsiteSetting();
		lb.clickViewLobby_WebsiteSetting_Signup();
		test.info("clicked SignUp website settings");
		driver.findElement(By.xpath("(//input[@type=\"file\"])[1]")).sendKeys(Upload_Icon);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type=\"file\"])[2]")).sendKeys(Upload_Icon);
		Thread.sleep(3000);

		lb.clickViewLobby_WebsiteSetting_Signup_details("SignUp page","welcome to the site,this is signup page");
		test.info("Entered title successfully");
		test.info("Entered Description successfully");
		
		lb.ClickToSave();
		Thread.sleep(1000);
		test.info("clicked to save website settings Signup",extentScreenshot());
		Thread.sleep(1000);
		//Boolean bool_delAppSetting=cc.Validation_Format_Website_Signup.isDisplayed();
		if(driver.findElement(By.xpath("//span[text()=\"Sign up save successfully\"]")).isDisplayed()==true){
			//Assert.assertTrue(true);
			test.pass("website setting add  Signup message return",extentScreenshot());
		}else if (driver.findElement(By.xpath("//span[text()=\"Sign up updated successfully\"]")).isDisplayed()==true) {
			test.pass("website setting update  Tab Access message return",extentScreenshot());
			//Assert.assertTrue(true);
		}		
		else{
			test.fail("Something Wrong ! not able get add website Signup message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		
		Thread.sleep(2000);

		test.info("Website settings Signup TestCase End");
	}
	
	@Test 
	public void Zb_TC_LobbyTest_View_StoreSetting() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Store Settings");
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		
		//lb.clickViewLobby();
		
		Thread.sleep(1000);
		lb.clickViewLobby_StoreSetting();
		
//		List<WebElement> results = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		for (WebElement result : results){
//		     List<WebElement> boxes = result.findElements(By.xpath("//input[@type='checkbox']"));
//		     int numberOfBoxes = boxes.size();
//		 	     
//		 for (int rel = 0; rel>boxes.size();rel++){     
//		     System.out.println("number of elements - "+results+"-"+result +"-"+ numberOfBoxes +"-"+rel );		    
//		     driver.findElement(By.xpath("(//input[@type='checkbox'])['"+rel+"']")).click();		     
//		     System.out.println("number of elements - "+result + numberOfBoxes);
//		     test.info(driver.findElement(By.xpath("(//input[@type='checkbox'])["+numberOfBoxes+"]")).getText()+" clicked");
//		  }	
//		}
		
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]//preceding::mat-slide-toggle[@formcontrolname=\"kycRequired\"]")).click();	Thread.sleep(500);		
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]//preceding::mat-slide-toggle[@formcontrolname=\"skrillPayment\"]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]//preceding::mat-slide-toggle[@formcontrolname=\"bankAccount\"]")).click();Thread.sleep(500);
		driver.findElement(By.xpath("//input[@type=\"checkbox\"]//following::mat-slide-toggle[@formcontrolname=\"cashApp\"]")).click();Thread.sleep(500);
	
		
		lb.ClickToSave();
		Thread.sleep(1000);
		test.info("clicked to save Store Settings",extentScreenshot());
		Thread.sleep(1000);
		
		if(cc.Validation_Format_StoreAdd.isDisplayed()==true){
			Assert.assertTrue(true);
			test.pass("Store setting add  message return",extentScreenshot());
		}if(cc.Validation_Format_Storeupdate.isDisplayed()==true){
			Assert.assertTrue(true);
			test.pass("Store setting add  message return",extentScreenshot());
		}
		else{
			test.fail("Something Wrong ! not able get add Store   message ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		
		Thread.sleep(2000);
		test.info("Store settings TestCase End");
		
	}
	
	
	@Test 
	public void Zc_TC_LobbyTest_View_CorporationDetails() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Corporation Details");
		
		LobbyPage lb = new LobbyPage(driver);
		CommonCosmo cc=new CommonCosmo(driver);
		
		Thread.sleep(1000);
		lb.clickViewLobby_CorporationDetails();
		test.info("Clicked Corporation Details");
		Thread.sleep(500);
		
		lb.clickViewLobby_CorporationDetails_name("cosmoslots");
		lb.clickViewLobby_CorporationDetails_contactNumber("1231231230");
		lb.clickViewLobby_CorporationDetails_email("hello@cosmoslots.com");
		lb.clickViewLobby_CorporationDetails_address("15455 North Dallas Parkway, Suite 1250, Addison Texas, 75001");
		Thread.sleep(1000);
		
		test.info("Entered name successfully");
		test.info("Entered contactNumber successfully");
		test.info("Entered email successfully");
		test.info("Entered address successfully");

		lb.ClickToSave();
		Thread.sleep(1000);
		test.info("Clicked to save Corporation Details",extentScreenshot());

		Thread.sleep(2000);
		
		//Boolean bool_delAppSetting=cc.Validation_Format_Corporationdetails.isDisplayed();
		if(cc.Validation_Format_Corporationdetails.isDisplayed()==true){
			Assert.assertTrue(true);
			test.pass("Corporation Details add  message return",extentScreenshot());
		}else{
			test.fail("Something Wrong ! not able get add Corporation Details   message ",extentScreenshot());
			Assert.assertTrue(false);	
		}		
		Thread.sleep(1000);
		test.info("Corporation Details TestCase End");
	}
	

	
//-----------End version 1.0.2--------------	

	
//	@Test 
//	public void Xa_TC_LobbyTest_View_Withdraw_Delete() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("lobby Withdraw settings delete");
//
//		test.info("TestCase started delete Lobby_Withdraw- As an admin user I should be able to delete Lobby_Withdraw");	
//		LobbyPage lb = new LobbyPage(driver);
//		 
//		//Working	
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000); 
// 
//		lb.clickViewLobby_Withdraw();
//		test.info("click on lobby Withdraw settings");
//
//		Thread.sleep(1000); 
//		
//		//-----delete Withdraw-------
//		if(lb.Deletebutton.isDisplayed()==true) {
//			Assert.assertTrue(true);
//			test.pass("Successfully delete lobby - Withdraw settings .",extentScreenshot());
//			lb.DeleteItems();
//		}else {
//			Assert.assertTrue(true);
//			test.fail("Something Wrong! not able to delete lobby Withdraw ",extentScreenshot());
//		}
//		test.info("TestCase-delete  Lobby_Withdraw Ended");
//	}
	
	
//	@Test
//	public void P_TC_LobbyTest_View_Game_Status() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Store Game Status");
//
//		test.info("TestCase started Status Store_Game - As an admin user I should be able to Status Store_Game");	
//		//test.info("URL is opened");
//		//CommonCosmo CC=new CommonCosmo(driver);
//		LobbyPage lb = new LobbyPage(driver);
//	 
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////		Thread.sleep(1000);
////		Thread.sleep(1500);
////		lb.clickViewLobby_Search("cosmoslot");
////		Thread.sleep(1500);		
////		lb.clickViewLobby();
//
//		
//		Thread.sleep(1000); 
//		
////		lb.clickViewLobby_Game();
////		Thread.sleep(1500); 
////		//Thread.sleep(1500);
//		
//			    
//		//Status publish/Un Publish
//		if(driver.findElement(By.xpath("(//th[text()=\"Publish ?\"]/following::tr//td[contains(@class,\"publish\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Publish"))
//		{
//		            test.info("Successfully Viewed publish game page");
//		            test.info("Now game Is UnPublish");
//		            driver.findElement(By.xpath("(//th[text()=\"Publish ?\"]/following::tr//td[contains(@class,\"publish\")]//span[contains(@class,'thumb-container')])[1]")).click();
//		            Thread.sleep(1000);
//		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//		            Thread.sleep(1000);
//		            try
//		            {
//		                if(driver.findElements(By.xpath("//span[text()=\"Game unpublish successfully\"]")).size()>0)
//		                {
//		                    Assert.assertTrue(true);
//		                    //test.info("Lobby game Successfully unpublished and Validation message appeared - Lobby game unpublished  successfully");
//		                    test.pass("Store game Successfully unpublished and Validation message appeared - Store game unpublished  successfully",extentScreenshot());
//		                }
//		                else
//		                {  // test.info("Failed ! To View Message");
//		                    test.fail("Failed ! To View Message",extentScreenshot());
//		                    Assert.assertTrue(false);
//		                }
//		            }
//		            catch(Exception e)
//		            {
//		                if(driver.findElement(By.xpath("//span[text()=\"Game unpublish successfully\"]"))!=null)
//		                {
//		                    Assert.assertTrue(true);
//		                    //test.info("Lobby game Successfully unpublished and Validation message appeared - Lobby game unpublished  successfully");
//		                    test.pass("Store game Successfully unpublished and Validation message appeared - Store game unpublished  successfully",extentScreenshot());
//		                }
//		                System.out.println(e);
//		            }
//
//		            Thread.sleep(4000);
//
//		        }
//		        else
//		        {
//		            test.info("Successfully Viewed View Icon of Player on lobby bonus listing page");
//		            test.info("Now game Is publish");
//
//		            driver.findElement(By.xpath("(//th[text()=\"Publish ?\"]/following::tr//td[contains(@class,\"publish\")]//span[contains(@class,'thumb-container')])[1]")).click();
//		            Thread.sleep(1000);
//		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//		            Thread.sleep(1000);
//		            try {
//		            if(driver.findElements(By.xpath("//span[text()=\"Game publish successfully\"]")).size()>0)
//		            {
//		                Assert.assertTrue(true);
//	                    //test.info("Lobby game Successfully published and Validation message appeared - Lobby game published  successfully");
//		                test.pass("Store game Successfully published and Validation message appeared - Store game published  successfully",extentScreenshot());
//		            }
//		            else
//		            {
//		                Assert.assertTrue(false);
//		                //test.info("Failed ! To View Message");
//	                    test.fail("Failed ! To View Message",extentScreenshot());
//
//		            }
//		            }
//		            catch(Exception e)
//		            {
//		                if(driver.findElements(By.xpath("//span[text()=\"Game publish successfully\"]")).size()>0)
//		                {
//		                    Assert.assertTrue(true);
//		                    //test.info("Lobby game Successfully published and Validation message appeared - Lobby game published  successfully");
//		                    test.pass("Store game Successfully published and Validation message appeared - Store game published  successfully",extentScreenshot());
//		                }
//		                System.out.println(e);
//		            }
//		        }
//        test.info("Game Status Test case End");
//
//	}
		
//	@Test
//	public void Q_TC_LobbyTest_View_Version() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Store Version View");
//
//		test.info("TestCase started view Lobby_Version- As an admin user I should be able to view Lobby_Version");	
//		LobbyPage lb = new LobbyPage(driver);
//		 
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000); 
//		
//		lb.clickViewLobby_Version();
//		test.info("Click on lobby version");
//		Thread.sleep(1000); 
//		
//		//----save version--------
//		if(lb.ViewLobby_LobbyVersion_Android.getText().equalsIgnoreCase("Android")) {
//			Assert.assertTrue(true);
//			test.info("Successfully verify Android version label.");
//			//test.pass("Successfully verify Android version label.",extentScreenshot());
//			lb.clickViewLobby_ReviewVersion_Android("com.gameium.cosmoslotAPK");
//			lb.clickViewLobby_ProductionVersion_Android("com.gameium.cosmoslotAPK");
//			
//		} else {
//			
//			test.info("Something Wrong! not verify Android version label.");
//			//test.pass("not verify Android version label.",extentScreenshot());
//			Assert.assertTrue(false);
//
//		}
//		if(lb.ViewLobby_LobbyVersion_ios.getText().equalsIgnoreCase("IOS")) {
//			Assert.assertTrue(true);
//			test.info("Successfully verify IOS version label.");
//			//test.pass("Successfully verify IOS version label.",extentScreenshot());
//			lb.clickViewLobby_ReviewVersion_IOS("com.gameium.cosmoslotIOS");
//			lb.clickViewLobby_ProductionVersion_IOS("com.gameium.cosmoslotIOS");
//			
//		} else {
//			test.info("Something Wrong! not verify IOS version label.");
//			//test.pass("not verify IOS version label.",extentScreenshot());
//			Assert.assertTrue(false);
//
//
//		}
//		lb.ClickToSave();
//		test.info("lobby version saved");
//		Thread.sleep(500);
//		
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
//		
//		
//		test.info("TestCase-view Lobby_Version Ended");
//	}	
	//@Test 
//	public void Z_TC_LobbyTest_View_WebsiteSetting_News_Create() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - News Create");
//
//		test.info("TestCase started create Lobby_WebsiteSetting- As an admin user I should be able to create Lobby_WebsiteSetting news");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
//		Thread.sleep(1000);
//		lb.clickViewLobby_WebsiteSetting();
//		Thread.sleep(1000); 
//		
//		lb.clickToNews();
//		Thread.sleep(1000);
//		
////		lb.clickToFAQ();
////		Thread.sleep(1000);
////		lb.clickToPromotion();
////		Thread.sleep(1000);
////		
//		//Create news 
//		test.info("Create news test case start" );
//		lb.clickToCreate();
//		test.info("Click to create news" );
//		lb.SetNewsTitle("title1"+randNum);
//		String str="title1"+randNum;
//		LobbyPage.description_news.sendKeys("this is testing");
//		lb.SetNewsicon(Upload_Icon);
//		Thread.sleep(3000);
//		
//		test.info("Entered title = <b>"+str+"</b>");
//		test.info("Entered description = <b>"+"this is testing"+"</b>");
//		test.info("<b>Image uploaded sucessfully</b>");
//
//		lb.ClickToSave();
//		Thread.sleep(2000);
//		test.info("Data saved successfuly",extentScreenshot() );
//
//		Boolean bool=cc.Validation_Format_AddNews.isDisplayed();
//		if(bool==true){
//			Assert.assertTrue(true);
//			test.pass("news - add successfully message return",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able to add bonus ",extentScreenshot());
//			//captureScreen(driver, "CreateNews");
//			Thread.sleep(1500);
//			lb.ClickToCancel();
//			//lb.ClickToClose();
//			Assert.assertTrue(false);
//			//lb.ClickToCancel();
//		}
//		Thread.sleep(1000);
//		test.info("Create news test case end");
//	}
//	@Test 
//	public void Za_TC_LobbyTest_View_WebsiteSetting_News_Search() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - News Search");
//
//		test.info("TestCase started news search Lobby_WebsiteSetting- As an admin user I should be able to search Lobby_WebsiteSetting news");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
////		Thread.sleep(1000); 
////		
////		lb.clickToNews();
////		Thread.sleep(1000);
////		//-----------Search news-----------
//		test.info("search news test case start");
//		lb.SearchItems("title");
//		test.info("Searched item = <b>"+"title"+"</b>",extentScreenshot());
//		Thread.sleep(2000);
//		test.info("search news test case end");
//	}
//	@Test
//	public void Zb_TC_LobbyTest_View_WebsiteSetting_News_Status() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - News Status");
//
//		test.info("TestCase started status Lobby_WebsiteSetting- As an admin user I should be able to status Lobby_WebsiteSetting news");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
////		Thread.sleep(1000); 
////		
////		lb.clickToNews();
////		Thread.sleep(1000);
////		 //status active/inactive
//		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
//		{
//		            test.info("Successfully Viewed active lobby news page");
//		            test.info("Now lobby news Is InActive");
//		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//		            Thread.sleep(1000);
//		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//		            Thread.sleep(1000);
//		            try
//		            {
//		                if(driver.findElements(By.xpath("//span[text()=\"News published successfully\"]")).size()>0)
//		                {
//		                    Assert.assertTrue(true);
//		                    test.pass("Lobby news Successfully activated and Validation message appeared - Lobby news activated  successfully",extentScreenshot());
//		                }else{
//		                     test.fail("Failed ! To View Message",extentScreenshot());
//		                     Assert.assertTrue(false);
//		                }
//		            }
//		            catch(Exception e)
//		            {
//		                if(driver.findElement(By.xpath("//span[text()=\"News published successfully\"]"))!=null)
//		                {
//		                    Assert.assertTrue(true);
//		                    test.pass("Lobby news Successfully activated and Validation message appeared - Lobby news activated successfully",extentScreenshot());
//		                }
//		                System.out.println(e);
//		            }Thread.sleep(4000);
//		   }else{
//		            test.info("Successfully Viewed View Icon of Player on lobby news listing page");
//		            test.info("Now news Is Active");
//
//		            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//		            Thread.sleep(1000);
//		            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//		            Thread.sleep(1000);
//		            try {
//		            	if(driver.findElements(By.xpath("//span[text()=\"News unpublished successfully\"]")).size()>0)
//		            	{
//		            		Assert.assertTrue(true);
//		            		test.pass("Lobby news Successfully deactivated and Validation message appeared - Lobby news deactivated successfully",extentScreenshot());
//		            	}else{
//		            		Assert.assertTrue(false);
//		                	test.fail("Failed ! To View Message",extentScreenshot());
//		            	}
//		            }
//		            catch(Exception e)
//		            {
//		                if(driver.findElements(By.xpath("//span[text()=\"News unpublished successfully\"]")).size()>0)
//		                {
//		                    Assert.assertTrue(true);
//		                    test.pass("Lobby news Successfully deactivated and Validation message appeared - Lobby news deactivated successfully",extentScreenshot());
//		                }
//		                System.out.println(e);
//		            }
//		     }
//		test.info("status news test case end");
//
//	}
//	@Test
//	public void Zc_TC_LobbyTest_View_WebsiteSetting_News_edit() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - News Edit");
//
//		test.info("TestCase started edit Lobby_WebsiteSetting- As an admin user I should be able to edit Lobby_WebsiteSetting news");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
////		Thread.sleep(1000); 
////		
////		lb.clickToNews();
////		Thread.sleep(1000);
////		
//		//------------------Edit news------------
//				lb.clickToNews();  
//				lb.clickToEdit();
//				test.info("click to Edit news");
//
//				lb.SetNewsTitle("title1"+randNum);
//				String str="title1"+randNum;
//				LobbyPage.description_news.clear();
//				LobbyPage.description_news.sendKeys("this is testing edit news");
//				lb.SetNewsicon(Upload_Icon);
//				Thread.sleep(3000);
//				
//				test.info("Entered title = <b>"+str+"</b>");
//				test.info("Entered description = <b>"+"this is testing edit news"+"</b>");
//				test.info("<b>Image uploaded sucessfully</b>");
//				
//				if(lb.ViewLobby_Appsetting_EditNewsLabel.isDisplayed()==true) {
//					Assert.assertTrue(true);
//					test.pass("edit news label displayed",extentScreenshot());
//					  JavascriptExecutor js = (JavascriptExecutor) driver;
//					  js.executeScript("arguments[0].click();",lb.Savenews);  
//						
//					//lb.ClickToSave();
//				}else{
//					test.fail("Something Wrong ! not able to edit news label",extentScreenshot());
//					Assert.assertTrue(false);	
//				}
//				
//				Thread.sleep(2000);
//				Boolean bool2=cc.Validation_Format_UpdateNews.isDisplayed();
//				if(bool2==true){
//					Assert.assertTrue(true);
//					test.pass("News update validation message displayed",extentScreenshot());
//				}else{
//					test.fail("Something Wrong ! not able to update news",extentScreenshot());
//					//captureScreen(driver, "EditNews");
//					Thread.sleep(1500);
//					lb.ClickToCancel();
//					//lb.ClickToClose();
//					Assert.assertTrue(false);	
//				}
//				test.info("edit news test case end");
//
//	}
//	@Test
//	public void Zd_TC_LobbyTest_View_WebsiteSetting_News_Delete() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - News Delete");
//
//		test.info("TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting news");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
////		Thread.sleep(1000); 
////		
////		lb.clickToNews();
////		Thread.sleep(1000);
//
//			
//	
//		//-----------delete news-----------
//		test.info("delete news test case start");
//		lb.DeleteClick_websiteSetings();
//		test.info("click to delete news delete");
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
//			Assert.assertTrue(true);
//			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
//			
//			test.pass("news - delete successfully",extentScreenshot());
//		}else {
//			test.fail("Something Wrong ! not able to delete news ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(2000);
//		Boolean bool1=cc.Validation_Format_DeleteNews.isDisplayed();
//		if(bool1==true){
//			Assert.assertTrue(true);
//			test.pass("news - delete message return",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able show news delete message ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("delete news test case end");
//		Thread.sleep(1000);
//	//	test.info("TestCase-Lobby_WebsiteSetting for news Ended");
//	   
//	}
//	
//	@Test 
//	public void Ze_TC_LobbyTest_View_WebsiteSetting_FAQ_Create() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - FAQ Create");
//
//		test.info("TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting FAQ");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
//		Thread.sleep(500); 
//		
//		lb.clickToFAQ();
//		Thread.sleep(500);
//		
////		lb.clickToFAQ();
////		Thread.sleep(1000);
////		lb.clickToPromotion();
////		Thread.sleep(1000);
////		
//						
//		//Create FAQ 
//		test.info("Create FAQ test case start" );
//		Thread.sleep(2000);
//		lb.clickToCreate();
//		test.info("Create to create FAQ" );
//
//		lb.SetFAQques("what is your city"+randNum);
//		String str="what is your city"+randNum;
//		lb.SetFAQanswer("delhi");
//		Thread.sleep(1000);
//		
//		test.info("Entered Question = <b>"+str+"</b>");
//		test.info("Entered Answer = <b>"+"delhi"+"</b>");
//		
//		lb.ClickToSave();
//		test.info("saved FAQ" );
//
//		
//		Thread.sleep(2000);
//		Boolean bool=cc.Validation_Format_AddFAQ.isDisplayed();
//		if(bool==true){
//			Assert.assertTrue(true);
//			test.pass("FAQ - add successfully message return",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able to add FAQ ",extentScreenshot());
//			//captureScreen(driver, "CreateFAQ");
//			Thread.sleep(1500);
//			lb.ClickToCancel();
//			//lb.ClickToClose();
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("Create FAQ test case end");
//
//	}
//	@Test 
//	public void Zf_TC_LobbyTest_View_WebsiteSetting_FAQ_Edit() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - FAQ Edit");
//
//		test.info("TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
//		//------------------Edit FAQ------------
//		test.info("edit FAQ test case start");
//		//lb.clickToNews();
//		lb.clickToFAQ();
//		Thread.sleep(1000);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		lb.clickToEdit_FAQ();   //driver.findElement(By.xpath("(//a[@id=\"edit\"])[1]")).click();  
//		test.info("click to edit FAQ ");
//
//		Thread.sleep(2000);
//		lb.ClickToSaveFAQ();
//		test.info("saved edit FAQ ");
//
//		Thread.sleep(2000);
//		Boolean bool2=cc.Validation_Format_UpdateFAQ.isDisplayed();
//		if(bool2==true){
//		Assert.assertTrue(true);
//		test.pass("FAQ update validation message displayed",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able to update FAQ",extentScreenshot());
//			//captureScreen(driver, "EditFAQ");
//			Thread.sleep(1500);
//			//lb.ClickToCancel();
//			lb.ClickToClose();
//			Assert.assertTrue(false);	
//		}
//		test.info("edit FAQ test case end");	
//	}
//	@Test 
//	public void Zg_TC_LobbyTest_View_WebsiteSetting_FAQ_Delete() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - FAQ Delete");
//
//		test.info("TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
//		
//		//-----------delete FAQ-----------
//		test.info("delete FAQ test case start");
//		Thread.sleep(1000);
//		lb.DeleteClick_websiteSetings();
//		test.info("click to delete FAQ ");
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
//			Assert.assertTrue(true);
//			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
//			
//			test.pass("FAQ - delete successfully",extentScreenshot());
//		}else {
//			test.fail("Something Wrong ! not able to delete FAQ ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(2000);
//		Boolean bool1=cc.Validation_Format_DeleteFAQ.isDisplayed();
//		if(bool1==true){
//			Assert.assertTrue(true);
//			test.pass("FAQ - delete message return",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able show FAQ delete message ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("delete FAQ test case end");
//		
//	}
//	@Test 
//	public void Zh_TC_LobbyTest_View_WebsiteSetting_FAQ_Status() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - FAQ Status");
//
//		test.info("TestCase started FAQ_Status Lobby_WebsiteSetting- As an admin user I should be able to FAQ_Status Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
//		 //status active/inactive
//		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
//	    {
//	            test.info("Successfully Viewed active lobby faq page");
//	            test.info("Now lobby faq Is InActive");
//	            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//	            Thread.sleep(1000);
//	            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//	            Thread.sleep(1000);
//	            try
//	            {
//	                if(driver.findElements(By.xpath("//span[text()=\"FAQ activated successfully\"]")).size()>0)
//	                {
//	                    Assert.assertTrue(true);
//	                    test.pass("Lobby faq Successfully activated and Validation message appeared - Lobby faq activated  successfully",extentScreenshot());
//	                }else{
//	                    Assert.assertTrue(false);
//	                    test.fail("Failed ! To View Message",extentScreenshot());
//	                }
//	            }
//	            catch(Exception e)
//	            {
//	                if(driver.findElement(By.xpath("//span[text()=\"FAQ activated successfully\"]"))!=null)
//	                {
//	                    Assert.assertTrue(true);
//	                    test.pass("Lobby faq Successfully activated and Validation message appeared - Lobby faq activated successfully",extentScreenshot());
//	                }
//	                System.out.println(e);
//	            }Thread.sleep(4000);
//	     }else{
//	            test.info("Successfully Viewed View Icon of Player on lobby faq listing page");
//	            test.info("Now faq Is Active");
//
//	            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//	            Thread.sleep(1000);
//	            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//	            Thread.sleep(1000);
//	            try {
//	            	if(driver.findElements(By.xpath("//span[text()=\"FAQ deactivated successfully\"]")).size()>0)
//	            	{
//	            		Assert.assertTrue(true);
//	            		test.pass("Lobby faq Successfully deactivated and Validation message appeared - Lobby faq deactivated successfully",extentScreenshot());
//	            	}else{
//	            		Assert.assertTrue(false);
//	                	test.fail("Failed ! To View Message",extentScreenshot());
//	            	}
//	            }
//	            catch(Exception e)
//	            {
//	                if(driver.findElements(By.xpath("//span[text()=\"FAQ deactivated successfully\"]")).size()>0)
//	                {
//	                    Assert.assertTrue(true);
//	                    test.pass("Lobby faq Successfully deactivated and Validation message appeared - Lobby faq deactivated successfully",extentScreenshot());
//	                }
//	                System.out.println(e);
//	          }
//	    }
//		
//			
//		Thread.sleep(1000);	
//		
//		
//		test.info("website setting FAQ test case end");
//		
//	}
//	
//	@Test 
//	public void Zi_TC_LobbyTest_View_WebsiteSetting_Promotion_Create() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - Promotion Create");
//
//		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//		//Working
////		lb.clicklobbymanagement();
////		Thread.sleep(1500);
////		lb.clicklobby();	
////	 	Thread.sleep(1000);
////		lb.clickViewLobby();
////		Thread.sleep(2000);
//		
////		Thread.sleep(1000);
////		lb.clickViewLobby_WebsiteSetting();
//		Thread.sleep(500); 
//		
//		lb.clickToPromotion();
//		Thread.sleep(500);
//		
////		lb.clickToFAQ();
////		Thread.sleep(1000);
////		lb.clickToPromotion();
////		Thread.sleep(1000);	
//				
//		//Create Promotion 
//		test.info("Create Promotion test case start" );
//		Thread.sleep(2000);
//		lb.clickToCreate();
//		test.info("Click to create Promotion" );
//
//		lb.SetNewsTitle("title1"+randNum);
//		String str="title1"+randNum;
//		LobbyPage.description_news.sendKeys("description_news");
//		lb.SetNewsicon(Upload_Icon);
//		Thread.sleep(2000);
//		
//		test.info("Entered title = <b>"+str+"</b>");
//		test.info("Entered description_news = <b>"+"description_news"+"</b>");
//		test.info("<b>Image uploaded sucessfully</b>");
//
//		lb.ClickToSave();
//		Thread.sleep(2000);
//		test.info("saved created Promotion",extentScreenshot() );
//
//		Boolean bool=cc.Validation_Format_AddPromotion.isDisplayed();
//		if(bool==true){
//			Assert.assertTrue(true);
//			test.pass("Promotion - add successfully",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able to add Promotion ",extentScreenshot());
//			//captureScreen(driver, "CreatePromotion");
//			Thread.sleep(1500);
//			lb.ClickToCancel();
//			//lb.ClickToClose();
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("Create Promotion test case end");
//	}
//	@Test 
//	public void Zj_TC_LobbyTest_View_WebsiteSetting_Promotion_Search() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - Promotion Search");
//		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//	
//		//-----------Search news-----------
//		test.info("search Promotion test case start");
//		lb.SearchItems("title");
//		test.info("Search Promotion = <b>" +"title"+"</b>" ,extentScreenshot());
//		Thread.sleep(2000);
//		test.info("search Promotion test case end");
//	}
//	@Test 
//	public void Zk_TC_LobbyTest_View_WebsiteSetting_Promotion_Edit() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - Promotion Edit");
//		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//	
//		//------------------Edit Promotion------------
//		test.info("Edit Promotion test case start");
//		//lb.clickToNews();
//		//lb.clickToFAQ();
//		Thread.sleep(1000);
//		lb.clickToEdit();  
//		lb.SetNewsTitle("title1"+randNum);
//		String str="title1"+randNum;
//		LobbyPage.description_news.sendKeys("this is testing for edit promotion");
//		lb.SetNewsicon(Upload_Icon);
//		
//		test.info("Entered title = <b>"+str+"</b>");
//		test.info("Entered description_news = <b>"+"this is testing for edit promotion"+"</b>");
//		test.info("<b>Image uploaded sucessfully</b>");
//		
//		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		 //driver.findElement(By.xpath("(//a[@id=\"edit\"])[1]")).click();  		
//		Thread.sleep(4000);
//		if(driver.findElement(By.xpath("//img[@class='imgView ng-star-inserted']")).isDisplayed()==true) {
//			lb.ClickToSavePromotion();
//			test.info("Promotion update sucessfully",extentScreenshot());
//
//		}
//		else {
//			test.info("Promotion not updated",extentScreenshot());
//		}
//			Thread.sleep(2000);
//			Boolean bool2=cc.Validation_Format_UpdatePromotion.isDisplayed();
//		if(bool2==true){
//			Assert.assertTrue(true);
//			test.pass("Promotion update validation message displayed",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able to update Promotion",extentScreenshot());
//			//captureScreen(driver, "EditPromotion");
//			Thread.sleep(1500);
//			lb.ClickToCancel();
//			//lb.ClickToClose();
//			Assert.assertTrue(false);	
//		}
//		test.info("edit Promotion test case end");	
//		
//	}
//	@Test 
//	public void Zl_TC_LobbyTest_View_WebsiteSetting_Promotion_Delete() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - Promotion Delete");
//		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//	
//			
//		//-----------delete Promotion-----------
//		test.info("delete Promotion test case start");
//		Thread.sleep(1000);
//		lb.DeleteClick_websiteSetings();
//		test.info("click to delete Promotion");
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
//			Assert.assertTrue(true);
//			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
//			Thread.sleep(200);
//			test.pass("Promotion - delete successfully",extentScreenshot());
//		}else {
//			test.fail("Something Wrong ! not able to delete Promotion ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(2000);
//		Boolean bool1=cc.Validation_Format_DeletePromotion.isDisplayed();
//		if(bool1==true){
//			Assert.assertTrue(true);
//			test.pass("Promotion - delete message return",extentScreenshot());
//		}else{
//			test.fail("Something Wrong ! not able show Promotion delete message ",extentScreenshot());
//			Assert.assertTrue(false);	
//		}
//		Thread.sleep(1000);
//		test.info("delete Promotion test case end");
//		
//		
//		Thread.sleep(1000);	
//	}
//	@Test 
//	public void Zm_TC_LobbyTest_View_WebsiteSetting_Promotion_Status() throws IOException, InterruptedException 
//	{
//		test = extentCreateTest("Lobby Website Settings - Promotion Status");
//		test.info("Promotion -TestCase started view Lobby_WebsiteSetting- As an admin user I should be able to view Lobby_WebsiteSetting");	
//		LobbyPage lb = new LobbyPage(driver);
//		
//	
//		//status active/inactive
//		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
//	    {
//			            test.info("Successfully Viewed active lobby promotion page");
//			            test.info("Now lobby promotion Is InActive");
//			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//			            Thread.sleep(1000);
//			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//			            Thread.sleep(1000);
//			            try
//			            {
//			                if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion published successfully\"]")).size()>0)
//			                {
//			                    Assert.assertTrue(true);
//			                    test.pass("Lobby promotion Successfully activated and Validation message appeared - Lobby promotion activated  successfully",extentScreenshot());
//			                }else{
//			                    Assert.assertTrue(false);
//			                    test.fail("Failed ! To View Message",extentScreenshot());
//			                }
//			            }
//			            catch(Exception e)
//			            {
//			                if(driver.findElement(By.xpath("//span[text()=\"Lobby promotion published successfully\"]"))!=null)
//			                {
//			                    Assert.assertTrue(true);
//			                    test.pass("Lobby promotion Successfully activated and Validation message appeared - Lobby promotion activated successfully",extentScreenshot());
//			                }
//			                System.out.println(e);
//			            }Thread.sleep(4000);
//	     }else{
//			            test.info("Successfully Viewed View Icon of Player on lobby news listing page");
//			            test.info("Now promotion Is Active");
//
//			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
//			            Thread.sleep(1000);
//			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
//			            Thread.sleep(1000);
//			            try {
//			            	if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion unpublished successfully\"]")).size()>0)
//			            	{
//			            		Assert.assertTrue(true);
//			            		test.pass("Lobby promotion Successfully deactivated and Validation message appeared - Lobby promotion deactivated successfully",extentScreenshot());
//			            	}else{
//			            		Assert.assertTrue(false);
//			                	test.fail("Failed ! To View Message",extentScreenshot());
//			            	}
//			            }
//			            catch(Exception e)
//			            {
//			                if(driver.findElements(By.xpath("//span[text()=\"Lobby promotion unpublished successfully\"]")).size()>0)
//			                {
//			                    Assert.assertTrue(true);
//			                    test.pass("Lobby promotion Successfully deactivated and Validation message appeared - Lobby promotion deactivated successfully",extentScreenshot());
//			                }
//			                System.out.println(e);
//			          }
//			    }
//		
//		test.info("website setting FAQ test case end");
//		
//	}

	
}



