package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.utilities.BaseClass;

public class PlayerRefferalScenarioUsingStoreCoupon extends BaseClass {
	BaseClass bc = new BaseClass();
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String DisplayName = randomestring().toLowerCase();
	String Phone = randomNum(10);
	String Pkg = "starpack4kTf (Act Amt. $1)";
	String PlayerPkg = "starpack4kTf";
	String playerID2 = "";
	String player_Invite_code = "";
	List<Integer> numberOfReferrals = new ArrayList<Integer>();
	boolean[] specialCase = { true, false, false, false, true, false, false, false, true, false, false, false };

	@Test
	public void A_TC_PlayerRefferalScenarioUsingStoreCoupon() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Applying store coupon");
		CosmoWebsite cw= new CosmoWebsite(driver);
		PlayerReferralScenario2 prs = new PlayerReferralScenario2();
//		System.out.println("regitored pos user 1st player");
		prs.RedirectPlayerProfilesetting();
		prs.VerifyToggles(specialCase);	
		
		gotoTab(driver, 1);
		prs.PlayerLogout();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		prs.PlayerRegistration(Firstnm, Lastnm, DisplayName+randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		prs.PlayerProfile();
		//Thread.sleep(5000);
		bc.implicitWait(driver, 5);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		if (specialCase[8] == true) {
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID1, extentScreenshot());
		}
		if (specialCase[9] == true) {
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID1, extentScreenshot());

		}

		test.info("Registored first player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);
		
		//for(int i=0;i<=2;i++) {
			
		for (int i : numberOfReferrals) {
			
			for (int j = 0; j < i; j++) {
				CosmoWebsite cw1= new CosmoWebsite(driver);

				prs.PlayerLogout();
				//Thread.sleep(5000);
				bc.implicitWait(driver, 5);

				prs.PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
				Thread.sleep(5000);
				//bc.implicitWait(driver, 5);
				prs.PlayerProfile();
				playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
				System.out.println(playerID2);
				if (specialCase[0] == true) {
					cw1.PlayerEmailVerification();
					test.info("Email verification " + playerID2, extentScreenshot());

				}
				if (specialCase[1] == true) {
					cw1.PlayerPhoneNumberVerification();
					test.info("Phone verification " + playerID2, extentScreenshot());

				}
				// cw.PlayerpackagePurchase(Pkg);
				test.info("invited player under first player " + playerID2, extentScreenshot());
				prs.PlayerLogout();
				if (specialCase[0] == false) {
					prs.Playerverification(playerID2);// just for case first otherwise
				}
				Thread.sleep(2000);
				
			}
			
			prs.PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "Coupon50");
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			prs.PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			test.info("Next level not achieved by player due to applied" + playerID1, extentScreenshot());
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.info("Not eligible for referral bonus, Need to purchase pakage ", extentScreenshot());
			prs.PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "");
			gotoTab(driver, 1);
			// WebsiteLogin(playerID1, "Gameium@12345");
			prs.PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			test.info("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("level achieved ", extentScreenshot());
		}
	}
	
	
	
	
	
	
	
	
	
}
//		PlayerLogout();
		// Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
//		Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		PlayerProfile();
//		// Thread.sleep(5000);
//		bc.implicitWait(driver, 5);
//		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
//		System.out.println(player_Invite_code);
//		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
//		System.out.println(playerID1);
//		if (specialCase[8] == true) {
//			cw.PlayerEmailVerification();
//			test.info("Email verification " + playerID1, extentScreenshot());
//		}
//		if (specialCase[9] == true) {
//			cw.PlayerPhoneNumberVerification();
//			test.info("Phone verification " + playerID1, extentScreenshot());
//
//		}
//
//		test.info("Registored first player under POS " + playerID1, extentScreenshot());
//		Thread.sleep(5000);

//		for (int i : numberOfReferrals) {
// (int j = 0; j < i; j++) {
//				
//				CosmoWebsite cw1 = new CosmoWebsite(driver);
//				bc.implicitWait(driver, 5);
//				openNewTab(driver, super.WebURL);
//				gotoTab(driver, 2);
//				System.out.println("Player registored"+j);
//				PlayerLogout();
//				Thread.sleep(5000);
//				bc.implicitWait(driver, 5);
//				PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
//				Thread.sleep(5000);
//				// bc.implicitWait(driver, 5);
//				PlayerProfile();
//				playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
//				System.out.println(playerID2);
//				if (specialCase[0] == true) {
//					cw1.PlayerEmailVerification();
//					test.info("Email verification " + playerID2, extentScreenshot());
//
//				}
//				if (specialCase[1] == true) {
//					cw1.PlayerPhoneNumberVerification();
//					test.info("Phone verification " + playerID2, extentScreenshot());
//
//				}
//				// cw.PlayerpackagePurchase(Pkg);
//				test.info("invited player under first player " + playerID2, extentScreenshot());
//				// PlayerLogout();
//				if (specialCase[0] == false) {
//					Playerverification(playerID2);// just for case first otherwise
//				}
//				Thread.sleep(2000);
//				// PlayerProfileTest_ManageTokens(Pkg, playerID2);

//			}

//		}
//		PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "Coupon50");
//		gotoTab(driver, 1);
//		WebsiteLogin(playerID1, "Gameium@12345");
//		PlayerProfile();
//		cw.Click_PlayerlevelRefrashBtn();
//		test.info("Next level not achieved by player due to applied" + playerID1, extentScreenshot());
//		Thread.sleep(2000);
//		cw.ClickOnBonuses();
//		Thread.sleep(1000);
//		test.info("Not eligible for referral bonus, Need to purchase pakage ", extentScreenshot());
//		PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "");
//		gotoTab(driver, 1);
//		// WebsiteLogin(playerID1, "Gameium@12345");
//		PlayerProfile();
//		cw.Click_PlayerlevelRefrashBtn();
//		test.info("Next level achieved by player " + playerID1, extentScreenshot());
//		Thread.sleep(2000);
//		cw.ClickOnBonuses();
//		Thread.sleep(1000);
//		test.pass("level achieved ", extentScreenshot());

//	}

//}
