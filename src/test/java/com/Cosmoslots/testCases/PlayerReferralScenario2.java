package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.utilities.BaseClass;

 


public class PlayerReferralScenario2 extends BaseClass
{
	BaseClass bc = new BaseClass();
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String DisplayName= randomestring().toLowerCase();
	String Phone = randomNum(10);
	String Pkg = "starpack4kTf (Act Amt. $1)";
	String PlayerPkg="starpack4kTf";
	String playerID2 = "";
	String	player_Invite_code="";
	List<Integer> numberOfReferrals	 = new ArrayList<Integer>();
	String couponCode = "Coupon50"; 
	
	boolean[] firstCase = { false, false, false, false, false, false, false, false, false, false, false, false };
	// Referral Bonus
	boolean[] secondCase = { true, false, false, false, false, false, false, false, false, false, false, false };
	boolean[] thirdCase = { true, true, false, false, false, false, false, false, false, false, false, false };
	boolean[] fourthCase = { true, true, false, true, false, false, false, false, false, false, false, false };
	// For Purchase
	boolean[] fifthCase = { true, true, false, true, true, false, false, false, false, false, false, false };
	boolean[] sixthCase = { true, true, false, true, true, true, false, false, false, false, false, false };
	boolean[] seventhCase = { true, true, false, true, true, true, false, true, false, false, false, false };
	// To Claim Bonus
	boolean[] eighthCase = { true, true, false, true, true, true, false, true, true, false, false, false };
	boolean[] ninethCase = { true, true, false, true, true, true, false, true, true, true, false, false };
	boolean[] tenthCase = { true, true, false, true, true, true, false, true, true, true, false, true };
	boolean[] specialCase = { true, false, false, false, true, false, false, false, true, false, false, false };

	public enum PlayerSettingToggleCase { FirstCase, SecondCase, ThirdCase, FourthCase, FifthCase, SixthCase,
		                                  SeventhCase, EighthCase, NinethCase, TenthCase,SpecialCase}; // 

		
// Advanced referral scenario                    
	@Test
	public void A_TC_PlayerReferralScenario() throws InterruptedException, IOException {
		PlayerSettingToggleCase[] Playerview = PlayerSettingToggleCase.values();
		for (PlayerSettingToggleCase PlayerView : Playerview) {
			switch (PlayerView) {
//			case FirstCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 1 condition");
//				B_TC_PlayerReferralScenario_Case(firstCase);
//				break;

//			case SecondCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 2 condition");
//				B_TC_PlayerReferralScenario_Case(secondCase);
//				break;

//			case ThirdCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 3 condition");
//				B_TC_PlayerReferralScenario_Case(thirdCase);
//				break;
//
//			case FourthCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 4 condition");
//				B_TC_PlayerReferralScenario_Case(fourthCase);
//				break;
//
//			case FifthCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 5 condition");
//				B_TC_PlayerReferralScenario_Case(fifthCase);
//				break;
//
//			case SixthCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 6 condition");
//				B_TC_PlayerReferralScenario_Case(sixthCase);
//				break;
//
//			case SeventhCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 7 condition");
//				B_TC_PlayerReferralScenario_Case(seventhCase);
//				break;
//
//			case EighthCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 8 condition");
//				B_TC_PlayerReferralScenario_Case(eighthCase);
//				break;
//
//			case NinethCase:
//				test = extentCreateTest("Referral Scenario : Referral Bonus Case 9 condition");
//				B_TC_PlayerReferralScenario_Case(ninethCase);
//				break;
//
			case TenthCase:
				test = extentCreateTest("Referral Scenario : Referral Bonus Case 10 condition");
				B_TC_PlayerReferralScenario_Case(tenthCase);
				break;
				
			case SpecialCase:
				test = extentCreateTest("Referral Scenario : Referral Bonus using store coupon code");
				B_TC_PlayerRefferalScenarioUsingStoreCoupon(specialCase);
				break;
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public void B_TC_PlayerRefferalScenarioUsingStoreCoupon(boolean[] condition) throws InterruptedException, IOException {
		
		CosmoWebsite cw= new CosmoWebsite(driver);
//		System.out.println("regitored pos user 1st player");
		RedirectPlayerProfilesetting();
		VerifyToggles(condition);	
		
		gotoTab(driver, 1);
		PlayerLogout();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		PlayerRegistration(Firstnm, Lastnm, DisplayName+randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		PlayerProfile();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		if (condition[8] == true) {
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID1, extentScreenshot());
		}
		if (condition[9] == true) {
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID1, extentScreenshot());

		}

		test.info("Registored first player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);
		
		//for(int i=0;i<=2;i++) {
			
		for (int i : numberOfReferrals) {
			for (int j = 0; j < i; j++) {
				CosmoWebsite cw1= new CosmoWebsite(driver);

				PlayerLogout();
				bc.implicitWait(driver, 5);
				PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
				Thread.sleep(5000);
				//bc.implicitWait(driver, 5);
				PlayerProfile();
				playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
				System.out.println(playerID2);
				if (condition[0] == true) {
					cw1.PlayerEmailVerification();
					test.info("Email verification " + playerID2, extentScreenshot());

				}
				if (condition[1] == true) {
					cw1.PlayerPhoneNumberVerification();
					test.info("Phone verification " + playerID2, extentScreenshot());

				}
				test.info("invited player under first player " + playerID2, extentScreenshot());
				PlayerLogout();
				if (specialCase[0] == false) {
					Playerverification(playerID2);// just for case first otherwise
				}
				Thread.sleep(2000);
				PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, couponCode);
				gotoTab(driver, 1);
				WebsiteLogin(playerID1, "Gameium@12345");
				PlayerProfile();
				cw1.Click_PlayerlevelRefrashBtn();
				test.info("Next level not achieved by player "+ playerID1+" due to applied coupon code: "+couponCode, extentScreenshot());
				Thread.sleep(2000);
				cw1.ClickOnBonuses();
				Thread.sleep(1000);
				test.info("Not eligible for referral bonus, Need to purchase pakage ", extentScreenshot());
				PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "");
				gotoTab(driver, 1);
				// WebsiteLogin(playerID1, "Gameium@12345");
				PlayerProfile();
				cw1.Click_PlayerlevelRefrashBtn();
				test.info("Next level achieved by player " + playerID1);
				Thread.sleep(2000);
				cw1.ClickOnBonuses();
				Thread.sleep(1000);
				test.pass("level achieved ", extentScreenshot());
			}
			

		}
	}
                      	                                  
	public void B_TC_PlayerReferralScenario_Case(boolean[] condition) throws InterruptedException, IOException  {
		
		CosmoWebsite cw= new CosmoWebsite(driver);
//		System.out.println("regitored pos user 1st player");
		RedirectPlayerProfilesetting();
		VerifyToggles(condition);	
		
		gotoTab(driver, 1);
		PlayerLogout();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		PlayerRegistration(Firstnm, Lastnm, DisplayName+randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		PlayerProfile();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		if (condition[8] == true) {
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID1, extentScreenshot());
		}
		if (condition[9] == true) {
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID1, extentScreenshot());

		}

		test.info("Registored first player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);
		
		//for(int i=0;i<=2;i++) {
			
		for (int i : numberOfReferrals) {
			for (int j = 0; j < i; j++) {
				CosmoWebsite cw1= new CosmoWebsite(driver);

				PlayerLogout();
				//Thread.sleep(5000);
				bc.implicitWait(driver, 5);

				PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
				Thread.sleep(5000);
				//bc.implicitWait(driver, 5);
				PlayerProfile();
				playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
				System.out.println(playerID2);
				if (condition[0] == true) {
					cw1.PlayerEmailVerification();
					test.info("Email verification " + playerID2, extentScreenshot());
				}
				if (condition[1] == true) {
					cw1.PlayerPhoneNumberVerification();
					test.info("Phone verification " + playerID2, extentScreenshot());
				}
				// cw.PlayerpackagePurchase(Pkg);
				test.info("invited player under first player " + playerID2, extentScreenshot());
				PlayerLogout();
				if (condition[0] == false) {
					Playerverification(playerID2);// just for case first otherwise
				}
				Thread.sleep(2000);
				PlayerProfile_ManageTokens(Pkg, playerID2);
				gotoTab(driver, 1);
				WebsiteLogin(playerID1, "Gameium@12345");
				PlayerProfile();
				cw1.Click_PlayerlevelRefrashBtn();
				test.info("Next level achieved by player " + playerID1, extentScreenshot());
				Thread.sleep(2000);
				cw1.ClickOnBonuses();
				Thread.sleep(1000);
				test.pass("level achieved ", extentScreenshot());
			}
		
		}
	}
	
	public void RedirectPlayerProfilesetting() throws InterruptedException
	{
		test.info("Check Number of Level Wise Referral Bonus");
		LobbyPage_Old lb = new LobbyPage_Old(driver);
		gotoTab(driver, 0);
//		lb.clicklobbymanagement();
//		Thread.sleep(500);
//		lb.clickStoreAccounts();
//		bc.implicitWait(driver, 5);
//		lb.SearchItems("CosmoSlot");
//		Thread.sleep(1500);
//		//lb.View_Click();
		lb.GoToStoreView("CosmoSlot");
		bc.implicitWait(driver, 10);
		driver.findElement(By.id("nav-bonus-tab")).click();
		bc.implicitWait(driver, 10);
		driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
		bc.implicitWait(driver, 10);
		numberOfReferrals.clear();
		List<WebElement> listNumberOfReferrals = driver.findElements(By.xpath("//th[text()='Number Of Referrals']//following::td[contains(@class,'numberOfReferrals ')]"));
		for (WebElement ListNumberOfReferrals : listNumberOfReferrals) {
			int Integer_Element = Integer.parseInt(ListNumberOfReferrals.getText().replaceAll(",", ""));
			numberOfReferrals.add(Integer_Element);
		}
		test.pass("Successfully viewed Number of Level Wise Referral Bonus : "+numberOfReferrals.size(),extentScreenshot());
		System.out.println("Number of Level Wise Referral Bonus : "+numberOfReferrals);
		driver.findElement(By.id("nav-playersettings-tab")).click();
		Thread.sleep(1000);
	}
	
	public void VerifyToggles(boolean[] Case) throws InterruptedException
	{
	    test.info("Set player setting condition in store ");
		List<WebElement> toggleButtons = driver.findElements(By.xpath("//mat-slide-toggle"));
//		System.out.println(toggleButtons.size());
		LobbyPage_Old lb = new LobbyPage_Old(driver);	
	    
		for (int i = 8; i < toggleButtons.size(); i++) {
			WebElement toggle = toggleButtons.get(i);
			// Check if the toggle button is ON or OFF
			boolean isOn = toggle.getAttribute("class").contains("mat-checked");

			if (isOn == Case[i - 8]) // if toggles are same then do nothing
			{
				// test.info("Conditions meet");
			} else {
				// Turn ON other toggle buttons
				toggle.click(); // Click the button to turn it ON
				Thread.sleep(500);
			}
		}
		lb.ClickToSave();
	    test.pass("Successfully changed player setting condition in store " , extentScreenshot());
	}
	
	public void Playerverification(String PlayerId) throws InterruptedException
	{
		gotoTab(driver, 0);
		GuestPlayers gp = new GuestPlayers(driver);
		Thread.sleep(1000);
		gp.clickOnPlayerManagement();
		test.info("successfully player verified by user admin ");
		gp.ClickOnGuestPlayers();
		Thread.sleep(2000);
		gp.Search_Items(PlayerId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[contains(text(),'"+PlayerId+"')]//following::span[@title='Player Verification'])[1]")).click();
		Thread.sleep(3000);
		
	}
	
	public void PlayerLogout() throws InterruptedException
	{	
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']")).click();		
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();		
	    Thread.sleep(2000);
	}

	public void PlayerProfile() throws InterruptedException
	{	
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']")).click();		
		//test.info("click on player profile in Website");
		Thread.sleep(1000); 
		driver.findElement(By.xpath("//a[contains(text(),\"Profile\")]")).click();		
	    //test.info("player logout in Website" );
	    Thread.sleep(2000);
	}
	
	public void PlayerpackagePurchase(String pkgPurchase) throws InterruptedException {

		driver.findElement(By.id("nav-packages-tab")).click();
		Thread.sleep(1500);
		WebElement ele = driver.findElement(By.xpath("(//h1[contains(text(),'" + pkgPurchase + "')]//following::button[text()='Purchase'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1500);
		ele.click();
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//label[text()=' Other ']"));
		other.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//h2[contains(text(),'Token Purchase')]//following::button[text()='Purchase'][1]")).click();
		Thread.sleep(1500);
		System.out.println("package purchased ");
		test.info("package purchased ",extentScreenshot());

	}

	public void PlayerProfile_ManageTokens(String pkg,String PlayerId) throws InterruptedException, IOException 
	{
		gotoTab(driver, 0);
	    PlayerProfile pp=new PlayerProfile(driver);

	    pp.GoToPlayerProfileView(PlayerId);
	        
	    test.info("Manage token : "+PlayerId);
	            
	    if(driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1)
	    {
	    	Thread.sleep(1000);
	        pp.clickManageTokens();
	    	Thread.sleep(1000);
	        driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
	        Thread.sleep(1000);
	     }
         Thread.sleep(2000);
         pp.selectPackage(pkg);
         Thread.sleep(1000);
         pp.selectPaymentMethod("Manual");
         driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("By Auto");
         pp.ClickSave();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
         Thread.sleep(2000);
   }
	
	public void PlayerProfileTest_ManageTokens_CouponCode(String pkg,String PlayerId, String couponCode) throws InterruptedException, IOException 
	{
		gotoTab(driver, 0);
	    PlayerProfile pp=new PlayerProfile(driver);

	    pp.GoToPlayerProfileView(PlayerId);
	        
	    test.info("Manage token : "+PlayerId);
	            
	    if(driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1)
	    {
	    	Thread.sleep(1000);
	        pp.clickManageTokens();
	    	Thread.sleep(1000);
	        driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
	        Thread.sleep(1000);
	     }
         Thread.sleep(2000);
         pp.selectPackage(pkg);
         Thread.sleep(1000);
         pp.selectPaymentMethod("Manual");
         pp.applyCouponCode(couponCode);
         driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("By Auto");
         pp.ClickSave();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
         Thread.sleep(2000);
   }
	
	public  void PlayerRegistration(String Fname,String Lname,String Dname, String password, String InviteCode) throws InterruptedException {
		CosmoWebsite  cw = new CosmoWebsite(driver);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		cw.ClickOnPlayerRegistration();
		driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode="+InviteCode);
		Thread.sleep(2000);
		cw.EnterPlayerFirstname(Fname);
		cw.EnterPlayerLastname(Lname);
		cw.EnterPlayerdisplayName(Dname);
		cw.EnterPlayerEmail(Dname+"@yopmail.com");
		cw.SelectPlayerDialCode();
		cw.EnterPlayerPhoneNo(getPhoneNumber());
		cw.EnterPlayerPassword(password);
//		cw.EnterPlayerinviteCode(InviteCode);
		driver.findElement(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='acceptTerms']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(3000);
	}
	

}


	
