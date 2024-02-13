package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PlayerReferralScenario extends BaseClass {
	BaseClass bc = new BaseClass();

	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String DisplayName = randomestring().toLowerCase();
	String Phone = randomNum(10);
	int levelWiseBonus = 4;
	String Pkg = "starpack4kTf (Act Amt. $1)";
	String PlayerPkg = "starpack4kTf";
	String playerID2 = "";
	String player_Invite_code = "";

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

	public enum PlayerSettingToggleCase {
		FirstCase, SecondCase, ThirdCase, FourthCase, FifthCase, SixthCase, SeventhCase, EighthCase, NinethCase,
		TenthCase
	};

//	@Test
	public void A_TC_PlayerRefferralScenario_Case1() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 1 condition");

		RedirectPlayerProfilesetting();
		VerifyToggles(firstCase);
		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(2), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);

		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(2), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under first player" + playerID2, extentScreenshot());
			PlayerLogout();
			Thread.sleep(5000);
			Playerverification(playerID2);// just for case first otherwise
			Thread.sleep(5000);
			// PlayerverificationEmail&Phone();
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());

		}

	}

	@Test
	public void Aa_TC_PlayerReferralScenario_Case2() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 2 condition");

		RedirectPlayerProfilesetting();
		VerifyToggles(secondCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);

		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());

		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under first player" + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			PlayerLogout();
			Thread.sleep(2000);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void Aa_TC_PlayerReferralScenario_Case3() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 3 condition");

		RedirectPlayerProfilesetting();
		VerifyToggles(thirdCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);

		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under first player" + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			// cw.PlayerpackagePurchase(PlayerPkg);
			PlayerLogout();
			Thread.sleep(2000);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void Aa_TC_PlayerReferralScenario_Case4() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 4 condition");
		RedirectPlayerProfilesetting();
		VerifyToggles(fourthCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			// cw.PlayerpackagePurchase(PlayerPkg);
			PlayerLogout();
			Thread.sleep(2000);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(5000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void B_TC_PlayerReferralScenario_Case5() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 5 condition");
		CosmoWebsite cw1 = new CosmoWebsite(driver);
		RedirectPlayerProfilesetting();
		VerifyToggles(fifthCase);
		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
//		cw1.PlayerEmailVerification();
//		cw1.PlayerPhoneNumberVerification();
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
//			cw.PlayerPhoneNumberVerification();
//			test.info("Phone verification "+playerID2, extentScreenshot());		
//			PlayerpackagePurchase(PlayerPkg);
			Thread.sleep(2000);
			PlayerLogout();
			Thread.sleep(2000);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			Thread.sleep(5000);
			cw.ClickOnBonuses();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(1000);
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
		}

	}

	@Test
	public void B_TC_PlayerReferralScenario_Case6() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 6 condition");

		RedirectPlayerProfilesetting();
		VerifyToggles(sixthCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);
			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			// PlayerpackagePurchase(PlayerPkg);
			Thread.sleep(2000);
			PlayerLogout();
			Thread.sleep(2000);
			// cw.PlayerpackagePurchase(PlayerPkg);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(5000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void B_TC_PlayerReferralScenario_Case7() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 7 condition");

		RedirectPlayerProfilesetting();
		VerifyToggles(seventhCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			PlayerLogout();

			Thread.sleep(2000);

			// cw.PlayerpackagePurchase(PlayerPkg);

			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(5000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void C_TC_PlayerReferralScenario_Case8() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 8 condition");
		CosmoWebsite cw = new CosmoWebsite(driver);

		RedirectPlayerProfilesetting();
		VerifyToggles(eighthCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		cw.PlayerEmailVerification();
		test.info("Email verification " + playerID1, extentScreenshot());
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw1 = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw1.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw1.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			PlayerLogout();

			Thread.sleep(2000);

			// cw.PlayerpackagePurchase(PlayerPkg);

			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw1.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(5000);
			cw1.ClickOnBonuses();
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void Ca_TC_PlayerReferralScenario_Case9() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 9 condition");
		CosmoWebsite cw = new CosmoWebsite(driver);

		RedirectPlayerProfilesetting();
		VerifyToggles(ninethCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		cw.PlayerEmailVerification();
		test.info("Email verification " + playerID1, extentScreenshot());
		cw.PlayerPhoneNumberVerification();
		test.info("Phone verification " + playerID1, extentScreenshot());
		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());
		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw1 = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under " + playerID1 + " : player ID " + playerID2, extentScreenshot());
			cw1.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			cw1.PlayerPhoneNumberVerification();
			test.info("Phone verification " + playerID2, extentScreenshot());
			PlayerLogout();
			Thread.sleep(2000);

			// cw.PlayerpackagePurchase(PlayerPkg);

			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw1.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(5000);
			cw1.ClickOnBonuses();
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void Cb_TC_PlayerReferralScenario_Case10() throws InterruptedException, IOException {

		test = extentCreateTest("Referral Scenario : Referral Bonus Case 10 condition");

		CosmoWebsite cw = new CosmoWebsite(driver);

		RedirectPlayerProfilesetting();
		VerifyToggles(tenthCase);
		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		cw.PlayerEmailVerification();
		cw.PlayerPhoneNumberVerification();
		test.info("First player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);

		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw1 = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(2), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			cw1.PlayerEmailVerification();
			cw1.PlayerPhoneNumberVerification();
			// cw.PlayerpackagePurchase(Pkg);
			test.info("invited player under first player " + playerID2, extentScreenshot());
			PlayerLogout();

			Thread.sleep(2000);

			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw1.Click_PlayerlevelRefrashBtn();
			test.pass("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(2000);
			cw1.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
		}

	}

	@Test
	public void D_TC_PlayerRefferalScenarioUsingStoreCoupon() throws InterruptedException, IOException {

		test = extentCreateTest("Referral Scenario : Referral Bonus Applying store coupon");

		CosmoWebsite cw = new CosmoWebsite(driver);

		RedirectPlayerProfilesetting();
		VerifyToggles(secondCase);
		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(3000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b")).getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);
		cw.PlayerEmailVerification();
		cw.PlayerPhoneNumberVerification();
		test.info("First player under POS " + playerID1, extentScreenshot());
		Thread.sleep(5000);

		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw1 = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(2), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			cw1.PlayerEmailVerification();
			cw1.PlayerPhoneNumberVerification();
			// cw.PlayerpackagePurchase(Pkg);
			test.info("invited player under first player " + playerID2, extentScreenshot());
			PlayerLogout();

			Thread.sleep(2000);

			// PlayerProfileTest_ManageTokens(Pkg, playerID2);
			PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "Coupon50");
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw1.Click_PlayerlevelRefrashBtn();
			test.info("Next level not achieved by player due to applied coupon" + playerID1, extentScreenshot());
			Thread.sleep(2000);
			cw1.ClickOnBonuses();
			Thread.sleep(1000);
			test.info("Not eligible for referral bonus, Player need to purchase package ", extentScreenshot());
			PlayerProfileTest_ManageTokens_CouponCode(Pkg, playerID2, "");
			gotoTab(driver, 1);
			// WebsiteLogin(playerID1, "Gameium@12345");
			PlayerProfile();
			cw1.Click_PlayerlevelRefrashBtn();
			// test.info("Next level achieved by player " + playerID1, extentScreenshot());
			Thread.sleep(2000);
			cw1.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("level achieved ", extentScreenshot());
		}

	}

	@Test
	public void E_TC_PlayerReferralScenario_AfterCreateLevel() throws InterruptedException, IOException {
		test = extentCreateTest("Referral Scenario : Referral Bonus Case 2 condition");
		LobbyPage lp = new LobbyPage(driver);
		CosmoWebsite cw1 = new CosmoWebsite(driver);

		RedirectPlayerProfilesetting();
		VerifyToggles(secondCase);

		gotoTab(driver, 1);
		PlayerLogout();
		Thread.sleep(5000);
		PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", "CS7777");
		Thread.sleep(5000);
		PlayerProfile();
		Thread.sleep(5000);
		String player_Invite_code = driver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		String playerID1 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
		System.out.println(playerID1);

		test.info("Registored 1st player under POS " + playerID1, extentScreenshot());

		for (int i = 1; i <= levelWiseBonus; i++) {
			CosmoWebsite cw = new CosmoWebsite(driver);

			PlayerLogout();
			Thread.sleep(5000);
			PlayerRegistration(Firstnm, Lastnm, DisplayName + randomNum(3), "Gameium@12345", player_Invite_code);
			Thread.sleep(5000);
			PlayerProfile();
			playerID2 = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText().substring(11, 18);
			System.out.println(playerID2);
			test.info("invited player under first player" + playerID2, extentScreenshot());
			cw.PlayerEmailVerification();
			test.info("Email verification " + playerID2, extentScreenshot());
			PlayerLogout();
			Thread.sleep(2000);
			PlayerProfileTest_ManageTokens(Pkg, playerID2);
			gotoTab(driver, 1);
			WebsiteLogin(playerID1, "Gameium@12345");
			Thread.sleep(2000);
			PlayerProfile();
			cw.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw.ClickOnBonuses();
			Thread.sleep(1000);
			test.pass("Successfully viewd levelwise  bonus ", extentScreenshot());
//		}
			gotoTab(driver, 0);
			Thread.sleep(5000);
			lp.GoToStoreView("CosmoSlot");
			Thread.sleep(5000);
			driver.findElement(By.id("nav-bonus-tab")).click();
			bc.implicitWait(driver, 10);
			driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
			bc.implicitWait(driver, 10);
			lp.CreateBonusLevel("Level3", "1", "1", "3", "3");
			test.info("Created new level3", extentScreenshot());
			Thread.sleep(2000);
			gotoTab(driver, 1);
			cw1.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw1.ClickOnBonuses();
			Thread.sleep(1000);
			test.info("Successfully viewd levelwise  bonus ", extentScreenshot());
			Thread.sleep(5000);
			gotoTab(driver, 0);
			lp.CreateBonusLevel("Level4", "1", "1", "4", "4");
			test.info("Created new level4 ", extentScreenshot());
			gotoTab(driver, 1);
			cw1.Click_PlayerlevelRefrashBtn();
			Thread.sleep(2000);
			cw1.ClickOnBonuses();
			Thread.sleep(1000);
			test.info("Successfully viewd levelwise  bonus ", extentScreenshot());
			Thread.sleep(1000);
			bc.PageReload();
			test.pass("Successfully viewd levelwise bonus after creating the level ", extentScreenshot());

		}
	}

	public void RedirectPlayerProfilesetting() throws InterruptedException {
//		test = extentCreateTest("Checking player setting condition in store");

		LobbyPage lb = new LobbyPage(driver);
		gotoTab(driver, 0);
		lb.clicklobbymanagement();
		Thread.sleep(500);
		lb.clickStoreAccounts();
		Thread.sleep(3000);
		lb.SearchItems("CosmoSlot");
		Thread.sleep(1500);
		lb.View_Click();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-playersettings-tab")).click();
		Thread.sleep(1000);
		test.info("Successfully redirect to player setting ");
	}

	public void VerifyToggles(boolean[] Case) throws InterruptedException {
		List<WebElement> toggleButtons = driver.findElements(By.xpath("//mat-slide-toggle"));
		System.out.println(toggleButtons.size());
		LobbyPage lb = new LobbyPage(driver);

		for (int i = 8; i < toggleButtons.size(); i++) {
			WebElement toggle = toggleButtons.get(i);
			// Check if the toggle button is ON or OFF
			boolean isOn = toggle.getAttribute("class").contains("mat-checked");
			if (isOn == Case[i - 8]) // if toggles are same then do nothing
			{
				// test.info("Conditions meet");
			} else { // Turn ON other toggle buttons
				toggle.click(); // Click the button to turn it ON
				// lb.ClickToSave();
				Thread.sleep(1000);
			}
		}
		lb.ClickToSave();
		test.pass("Successfully viewed player setting  condition in store ", extentScreenshot());

	}

	public void Playerverification(String PlayerId) throws InterruptedException {
		gotoTab(driver, 0);
		GuestPlayers gp = new GuestPlayers(driver);
		Thread.sleep(1000);
		gp.clickOnPlayerManagement();
		test.info("Successfully player verified by user admin ");
		gp.ClickOnGuestPlayers();
		Thread.sleep(1000);
		gp.Search_Items(PlayerId);
		Thread.sleep(3000);
		driver.findElement(By
				.xpath("(//*[contains(text(),'" + PlayerId + "')]//following::span[@title='Player Verification'])[1]"))
				.click();
		Thread.sleep(3000);

	}

	public void PlayerLogout() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		Thread.sleep(2000);
	}

	public void PlayerProfile() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),\"Profile\")]")).click();
		Thread.sleep(2000);
	}

	public void PlayerProfileTest_ManageTokens(String pkg, String PlayerId) throws InterruptedException, IOException {
		gotoTab(driver, 0);
		PlayerProfile pp = new PlayerProfile(driver);

		pp.GoToPlayerProfileView(PlayerId);
		test.info("Manage token");

		if (driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1) {
			Thread.sleep(1000);
			pp.clickManageTokens();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),\"Create New\")]")).click();
			Thread.sleep(1000);
		}
		Thread.sleep(4000);
		pp.selectPackage(pkg);
		Thread.sleep(1000);
		pp.selectPaymentMethod("Manual");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("By Auto");
		pp.ClickSave();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		Thread.sleep(2000);
	}

	public void PlayerProfileTest_ManageTokens_CouponCode(String pkg, String PlayerId, String couponCode)
			throws InterruptedException, IOException {
		gotoTab(driver, 0);
		PlayerProfile pp = new PlayerProfile(driver);

		pp.GoToPlayerProfileView(PlayerId);

		test.info("Manage token : " + PlayerId);

		if (driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1) {
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

	public void PlayerpackagePurchase(String pkgPurchase) throws InterruptedException {

		driver.findElement(By.id("nav-packages-tab")).click();
		Thread.sleep(1500);
		WebElement ele = driver.findElement(
				By.xpath("(//h1[contains(text(),'" + pkgPurchase + "')]//following::button[text()='Purchase'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1500);
		ele.click();
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//label[text()=' Other ']"));
		other.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//h2[contains(text(),'Token Purchase')]//following::button[text()='Purchase'][1]"))
				.click();
		Thread.sleep(1500);
		System.out.println("package purchased ");
		test.info("package purchased ", extentScreenshot());

	}

	public void PlayerRegistration(String Fname, String Lname, String Dname, String password, String InviteCode)
			throws InterruptedException {
		CosmoWebsite cw = new CosmoWebsite(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// cw.ClickOnPlayerRegistration();
		driver.navigate().to("https://qaautomation-cpweb-admin.cosmoslots.tech/?invitecode=" + InviteCode);
		Thread.sleep(2000);
		cw.EnterPlayerFirstname(Fname);
		cw.EnterPlayerLastname(Lname);
		cw.EnterPlayerdisplayName(Dname);
		cw.EnterPlayerEmail(Dname + "@yopmail.com");
		cw.SelectPlayerDialCode();
		cw.EnterPlayerPhoneNo(getPhoneNumber());
		cw.EnterPlayerPassword(password);
		// cw.EnterPlayerinviteCode(InviteCode);
		driver.findElement(By.xpath("//h2[text()='Sign Up']//following::input[@formcontrolname='acceptTerms']"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(3000);
	}

}
