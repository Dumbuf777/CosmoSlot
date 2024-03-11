package com.Cosmoslots.testCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.pageObjects.CommonCosmo;

public class GuestPlayer extends BaseClass {
	private PlayerProfile pp ;
	private GuestPlayers gp ;
	private CommonCosmo cc ;
	
	@Test
	public void B_TC_GuestPlayersTest_GF1762() throws InterruptedException, IOException {
		test = extentCreateTest("Guest Player -> Redirect");
		test.info("TC - As an admin user I should able to view Add Player screen by clicking on the Add Player button");
		pp = new PlayerProfile(driver);		
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		pp.clickOnPlayerManagement();
		test.info("Clicked on Player Management");
		gp.ClickOnGuestPlayers();
		test.info("Clicked on Guest players");
		if (gp.GuestPlayers_Header!= null) {
			test.info("Opened Guest Player Successfully");
			Thread.sleep(3000);
			pp.ClickOnCreateNew();
			Thread.sleep(3000);
			if (gp.personalDetails_Header != null) {
				test.pass("User Successfully able to view Create New Player screen", extentScreenshot());			
			} else {
				test.fail("Something wrong!To Open Create New Player", extentScreenshot());
			}
		} else {
			test.info("Something wrong!To Open Guest Player");
		}
	}
	
	@Test
	public void C_TC_GuestPlayersTest_GF2190_AddPlayer() throws InterruptedException, IOException {
		test = extentCreateTest("Guest Player -> Add Player");
		test.info("TestCase started 2190 - As an admin user I should able to Add Player successfully by providing valid form data");
		gp = new GuestPlayers(driver);
		cc= new CommonCosmo(driver);
			test.info("Opened Guest Player Successfully");				
				if(gp.personalDetails_Header!= null) {
					gp.setFirstName(Constant.Firstnm);
					test.info("Entered FirstName successfully");
					gp.setLastName(Constant.Lastnm);
					test.info("Entered LastName successfully");
					gp.setDisplayName1(Constant.Usernm);
					test.info("Entered DisplayName successfully");
					gp.selectgender("Male");
					test.info("Selected Gender successfully");
					gp.selectreputation("High");
					test.info("Selected PlayerReputation successfully");
					gp.EnterTags();
					test.info("Entered Tags successfully");
					gp.selectGuestStore(Constant.store);
					test.info("Selected Store successfully");
					gp.selectparentuser(Constant.parentuser);
					test.info("Selected parent user successfully");
					gp.setEmail(Constant.email);
					test.info("Entered Email Successfully");
					gp.setPassword(Constant.Password);
					test.info("Entered Password Successfully");
					gp.setDialCode("+91");
					test.info("Entered DialCode Successfully");
					gp.setPhone(Constant.randNum);
					test.info("Entered Phone Successfully");
					gp.setCountry("India");
					test.info("Entered Country Successfully");
					Thread.sleep(300);
					gp.setState("Gujarat");
					test.info("Entered State Successfully");
					gp.setCity("Gandhinagar");
					test.info("Entered City Successfully");
					gp.setZipcode("382002");
					test.info("Entered Pincode Successfully");
					gp.setAddress("BIFC,Gift City");
					test.info("Entered Address Successfully");
					gp.ClickSave();
					Thread.sleep(500);
					cc.VerifyDataCheck(cc.Validation_Format_Playersavesuccessfully);
				} else {
					test.fail("Something wrong!To Open Create New Player",extentScreenshot());
				
				}
				Thread.sleep(3000);
	}
			
	@Test
	public void D_TC_GuestPlayersTest_GF2190_AddDuplicatePlayer() throws InterruptedException, IOException {
		test = extentCreateTest("Guest Player -> Add Duplicate Player");
		test.info("TC - GF2190 - As an admin user I should not be able to Add duplicate Email Player ");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		pp = new PlayerProfile(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"Guest Players\"]")) != null) 
		{
			Thread.sleep(1500);
			test.info("Opened Guest Player Successfully");
			pp.ClickOnCreateNew();

				if(driver.findElement(By.xpath("//h4[text()=\"Personal Details\"]")) != null) {
					gp.FirstName.clear();
					gp.setFirstName(Constant.Firstnm);
					test.info("Entered FirstName successfully");
					gp.LastName.clear();
					gp.setLastName(Constant.Lastnm);
					test.info("Entered LastName successfully");
					gp.DisplayName1.clear();
					gp.setDisplayName1(Constant.Usernm);
					test.info("Entered DisplayName successfully");
					//gp.selectTab();
					//gp.selectTab();
					//gp.selectgender();
					Thread.sleep(500);
					//test.info("Selected Gender successfully");
					gp.selectreputation("High");
					//gp.selectreputation("High");
					test.info("Selected PlayerReputation successfully");
					//gp.EnterTags();
					//test.info("Entered Tags successfully");
					Thread.sleep(500);
					gp.selectGuestStore(Constant.store);
					test.info("Selected Store successfully");
					Thread.sleep(500);
					gp.selectparentuser(Constant.parentuser);
					gp.Email.clear();
					gp.setEmail(Constant.DuplicateEmail);
					test.info("Entered Email Successfully");
					gp.Password.clear();
					gp.setPassword(Constant.Password);
					test.info("Entered Password Successfully");
					gp.setDialCode("+91");
					test.info("Entered DialCode Successfully");
					gp.setPhone("9899092344");
					test.info("Entered Phone Successfully");
					gp.setCountry("India");
					test.info("Entered Country Successfully");
					Thread.sleep(300);
					gp.setState("Gujarat");
					test.info("Entered State Successfully");
					gp.setCity("Surat");
					test.info("Entered City Successfully");
					gp.setZipcode("395007");
					test.info("Entered Pincode Successfully");
					gp.setAddress("Test212,Testing,QAA");
					test.info("Entered Address Successfully");
					String m="Male";
					String f="Female";
					gp.selectgender(m);
					test.info("Selected "+m+" successfully");
					gp.ClickSave();
					Thread.sleep(500);
					if(cc.Validation_EmailIdisalreadyinuse.isDisplayed()==true) {
						test.pass("Successfully checked ! We couldn't add player by duplicate email",extentScreenshot());
						driver.findElement(By.xpath("//span[text()=\"Cancel\"]")).click();
					} 
					else 
					{	test.fail("Successfully Added  New Player with duplicate email in guest Player List.",extentScreenshot());
						//Assert.assertTrue(true);
					}
				} else 
				{
					test.info("Something wrong!To Open Create New Player",extentScreenshot());
					//Assert.assertTrue(false);
				}
			
		}
		//gp.clickDashboardButton();
	}
	
	@Test
	public void F_TC_GuestPlayersTest_XLSX() throws InterruptedException, IOException 
	{
		test = extentCreateTest("GuestPlayer -> XLSX");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);

		gp.clickOnPlayerManagement();
		test.info("Clicked on Player Management");
		gp.ClickOnGuestPlayers();
		if (driver.findElement(By.xpath("//h3[text()=\"Guest Players\"]")) != null) {
			pp.clickXlsxButton();
			Thread.sleep(300);
			if (CommonCosmo.Validation_XLSXDownload.isDisplayed() == true) {
				test.pass("" + CommonCosmo.Validation_XLSXDownload, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
			}

		}
	}
		
	@Test
	public void Ea_TC_GuestPlayerTest_EditGuestPlayer() throws InterruptedException {
		test = extentCreateTest("Guest Player -> Edit");
		test.info("As an admin user I should be able to edit guest player details");
		gp= new GuestPlayers(driver);
		
		test.info("Opened Guest Player Successfully");
		//gp.clickCreateNewButton();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		test.pass("Successfuly viewd edit icon in action guest player listing ",extentScreenshot());
		Thread.sleep(1500);
			if(driver.findElement(By.xpath("//h3[text()=\"Edit Player\"]")) != null) {
				gp.setFirstName(Constant.Firstnm+"a");
				test.info("Entered FirstName successfully");
				gp.setLastName(Constant.Lastnm+"a");
				test.info("Entered LastName successfully");
				gp.setDisplayName1(Constant.Usernm+"a");
				test.info("Entered DisplayName successfully");
				gp.selectgender("Female");
				test.info("Selected Gender successfully");
				gp.selectreputation("High");
				test.info("Selected PlayerReputation successfully");
				gp.EnterTags();
				test.info("Entered Tags successfully");
//				gp.selectGuestStore(Constant.store);
//				test.info("Selected Store successfully");
//				gp.selectparentuser(Constant.parentuser);
//				test.info("Selected parent user successfully");
//				gp.setEmail(Constant.email);
//				test.info("Entered Email Successfully");
//				gp.setPassword(Constant.Password);
//				test.info("Entered Password Successfully");
				gp.setDialCode("+91");
				test.info("Entered DialCode Successfully");
				gp.setPhone(Constant.randNum);
				test.info("Entered Phone Successfully");
				gp.editCountry("United States");
//				test.info("Entered Country Successfully");
//				Thread.sleep(300);
//				gp.setState("California");
//				test.info("Entered State Successfully");
//				gp.setCity("San jose");
//				test.info("Entered City Successfully");
//				gp.setZipcode("92627");
//				test.info("Entered Pincode Successfully");
//				gp.setAddress("kern");
//				test.info("Entered Address Successfully");
				gp.setSkrillID("itsupport@ombpmllpa.com");
				test.info("Entered Skrill ID Successfully");
				gp.setCashAppID("itsupport@ombpmllpa.com");
				test.info("Entered cash app ID Successfully");
				gp.setSeamlessChexD("itsupport@ombpmllpa.com");
				test.info("Entered seamless chex ID Successfully");
				gp.ClickSave();
				Thread.sleep(500);
				if (driver.findElement(By.xpath("//span[contains(text(),\"Player save successfully\")]")) != null) {
					
					test.pass("Successfully edited guest Player in guest Player List.", extentScreenshot());
					
				} else {
					
					test.fail("Something Wrong!not able to edit guest player in guest Player List.",extentScreenshot());
				}
				
			} else {
				test.fail("Something wrong!To Open Create New Player",extentScreenshot());
			
			}
			Thread.sleep(3000);
		
	}
	
	@Test
    public void Eb_TC_GuestPlayersTest_LoginFootPrints() throws InterruptedException {
		test = extentCreateTest("Guest player-> login footprint");
		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		gp.ClickOnGuestPlayers();
		Thread.sleep(3000);
//		gp.Search_Items(Constant.PlayerId);
//		Thread.sleep(3000);
		pp.clickOnPlayerProfileActionEye();
		gp.ClickOnGuestPlayerLoginFootprints();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//p[contains(.,\"No record found\")]"))==null)
       {		
    	   if(driver.findElements(By.xpath("//th[text()=\"Date & Time\"]/following::tr//td[contains(@class,\"createdAt\")]"))
               .size() > 0) {
           test.pass("Successfully Viewed Date & Time of Player on the player login footprints page",extentScreenshot());
    	   } else {
           test.fail("Something wrong !! To View Date & Time of Player on the player login footprints page");
    	   }
    	   if (driver.findElements(By.xpath("//th[text()=\"Device\"]/following::tr//td[contains(@class,\"device \")]")).size() > 0) {
           test.pass("Successfully Viewed device of Player on the player login footprints page");
    	   } else {
           test.fail("Something wrong !! To View device of Player on the  player login footprints page");
    	   }
    	   if (driver.findElements(By.xpath("//th[text()=\"IP Address\"]/following::tr//td[contains(@class,\"ip \")]")).size() > 0) {
           test.pass("Successfully View ip of Player on the player login footprints page");
    	   } 
    	   else 
    	   {
           test.fail("Something wrong !! To View ip of Player on the  player login footprints page");
    	   }
       }
       else
       {
    	   test.pass("No Record Found",extentScreenshot());
       }  
   }
		
	@Test
	public void Ec_TC_GuestPlayer_UpdatesGuestPlayerFootprints() throws InterruptedException {
		test = extentCreateTest("Guest player -> Profile footprints");
		test.info("TC : GF33001 - As a Admin I must be able to view the Players footprints so that I can have record of the updates made to any player profile");
		pp = new PlayerProfile(driver);
		gp = new GuestPlayers(driver);
		
//		pp.clickOnPlayerManagement();
//		gp.clickGuestPlayersLink();
//		gp.Search_Items("CS-2727");
//		pp.clickOnPlayerProfileActionEye();
//		gp.ClickOnGuestPlayerLoginFootprints();
		Thread.sleep(3000);
		
		gp.clickOnProfileFootprints();
		if(driver.findElement(By.xpath("//td[contains(.,'Last Name')]")).isDisplayed()==true) {
			test.pass("Successfully viewd updated guest player filed type in profile footprints listing",extentScreenshot());
			
		}else {
			test.fail("Something wrong !! To view filed type of guest player profile footprints page");
		}
	
	}
	
	@Test
	public void Z_TC_GuestPlayersTest_SearchGuestplayer() throws InterruptedException, IOException 
	{
		test = extentCreateTest("Guest Player -> Search");
		test.info("TC - As an admin user I should be able to Search Guest Player By Email");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h3[text()=\"Guest Players\"]"))!=null)
		{
			test.info("Opened Player Successfully");
			gp.Search_Items(Constant.Usernm);
			Thread.sleep(1500);
			String Searched=driver.findElement(By.xpath("//span[contains(text(),'"+Constant.email+"')]")).getText();
			if(Searched.equalsIgnoreCase(Constant.email))
			{
				test.pass("Successfully Searched Item viewed",extentScreenshot());
			}
			else
			{
				test.fail("Something wrong !! To Search Item",extentScreenshot());
			}	
		}
	}
	
	@Test
	public void Za_TC_GuestPlayer_ViewOnlineGuestPlayer() throws InterruptedException {
		test = extentCreateTest("Guest Player -> online player");
		test.info("TC - As an admin user I should be able to view online Guest Player");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h3[text()=\"Guest Players\"]"))!=null) {
			driver.findElement(By.xpath("//span[@class='mat-checkbox-inner-container']")).click();
			if(driver.findElement(By.xpath("//tbody//tr[1]")).isDisplayed()== true) {
				test.pass("Successfully viewed online guest player",extentScreenshot());
			}else {
				test.pass("No ",extentScreenshot());

			}
			
		}
	}
	
}
