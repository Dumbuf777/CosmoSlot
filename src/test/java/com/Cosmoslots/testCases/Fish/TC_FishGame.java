/**
 * 
 */
package com.Cosmoslots.testCases.Fish;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author shrikrushna.sonkar
 *
 */
public class TC_FishGame extends BaseClass {

	String emailId = "CS-1400";
	String Password = "Gameium@1234";
	String Playertoken = "";
	String fishGamesessionId = "";
	String totalWin = "";
	String gameTokens = "";
	String symbolCode = "";
	String PlayerToken = "";
	String fishGameSessionId = "";
	List<String> P_Token = new ArrayList<String>();
	List<String> GameSession = new ArrayList<String>();
	String fishGameinviteCode = "";
	public boolean configCheck = true;
	// Release 1.2.0

	@Test
	public void A_TC_ViewFishGameDashboard() throws InterruptedException {
		test = extentCreateTest("View Fish Game Details");
		test.info("TC - As an admin I should be able to view the fish game details like code, name, category and sub-category");

		LobbyPage_Old lp = new LobbyPage_Old(driver);

		lp.clicklobbymanagement();
		Thread.sleep(500);
		lp.clickStoreAccounts();
		Thread.sleep(1500);
		lp.SearchItems("CosmoSlot");
		Thread.sleep(3000);
		lp.View_Click();
		Thread.sleep(2000);
		driver.findElement(By.id("nav-games-tab")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=' Fish ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='ri-eye-line'])[1]")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[text()='View Game Details']")) != null) {
			test.pass("Successfully viewed fish game deatils like code, name, category and sub-category",
					extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to view fish game deatils like code, name, category and sub-category",
					extentScreenshot());
		}
		driver.findElement(By.xpath("//mat-icon[text()='close']")).click();
		// a[@title='View Dashboard']
	}

	@Test
	public void Ab_TC_ViewFishGameRoomConfigration() throws InterruptedException {
		test = extentCreateTest("View Fish Game Room Configuration");
		test.info("TC - As an admin I should be able to view the fish room configration in fish game");

		LobbyPage_Old lp = new LobbyPage_Old(driver);

		driver.findElement(By.xpath("//a[@title='View Game Room Configuration']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[text()='Game Room Configuration']")) != null) {
			test.pass("Successfully viewed fish game room configuration", extentScreenshot());
			if (driver.findElements(By.xpath("//span[@title='Active']")) != null) {
				configCheck = true;
				//TC_Fish_RestAssuredRoomConfiguration room = new TC_Fish_RestAssuredRoomConfiguration();
//				Aa_POST_PlayerLogin();
//				Ba_POST_FishGameCreate();
//				Bb_POST_FishGameRoomJoin();
//				Bc_POST_FishGameSession();
//				Ca_POST_FishGameFire();
			} else {
				test.info(" fish game room configuration not added ", extentScreenshot());
				configCheck = false;
			}
		} else {
			test.fail("Something Wrong ! Not able to view fish game room configuration", extentScreenshot());
		}
		driver.findElement(By.xpath("(//a[@title='Back'])[2]")).click();
		Thread.sleep(3000);
	}

	@Test
	public void Ac_TC_ViewFishGamedashboard() throws InterruptedException {
		test = extentCreateTest("View Dashboard Icon");
		test.info("TC - As an admin I should be able to view the ocean bombard dashboard in fish game");
		LobbyPage_Old lp = new LobbyPage_Old(driver);

		// driver.findElement(By.xpath("//a[@title='Back']")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@title='View Dashboard']")).click();
//		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//a[@title='View Dashboard']")) != null) {
			test.pass("Successfully viewed fish Ocean Bombard Dashboard icon ", extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to view the fish Ocean bombard dashboard icon", extentScreenshot());
		}
		// driver.findElement(By.xpath("(//a[@title='Back'])[2]")).click();
	}

	@Test
	public void Ad_TC_OceanBombardDashboard() throws InterruptedException {
		test = extentCreateTest("Daily bets and Active five players in fish dashboard");
        test.info("TC - As an admin I should be able to view the daily beats and top five active players in ocean bombard dashboard fish game");
		driver.findElement(By.xpath("//a[@title='View Dashboard']")).click();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h4/span[text()='Daily Bets']")) != null) {
			test.pass("Successfully viewed overall graph of the dail bets and top five active players of fish Ocean Bombard Dashboard",extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to view the dail bets and top five active players of fish Ocean Bombard Dashboard",extentScreenshot());
		}

	}

	@Test
	public void Ad_TC_OceanBombardDashboard1() throws InterruptedException {
		test = extentCreateTest("Total bets and latest big wins in fish dashboard");
		test.info("TC - As an admin I should be able to view the total bets, latest big wins and latest mega win in ocean bombard dashboard fish game");

		WebElement TotalBets = driver.findElement(By.xpath("//h4/span[text()='Total Bets']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", TotalBets);
		Thread.sleep(1000);

		if (driver.findElements(By.xpath("//h4/span[text()='Total Bets']")) != null) {
			test.pass("Successfully viewed overall graph of the total beats, latest big wins and latest mega win of fish Ocean Bombard Dashboard",extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to view total beats, latest big wins and latest mega winof fish Ocean Bombard Dashboard",extentScreenshot());
		}

	}

	@Test
	public void Ae_TC_FishGameTransaction() throws InterruptedException {
		test = extentCreateTest("View Fish Game Transcation");
		test.info("TC - As an admin I should be able to view the fish game transction in player deatils ");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		A_POST_PlayerLogin();
		B_POST_FishGameSession();
		C_POST_FishGameFire();

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(emailId);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		pp.clickGameTransactionsTab();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@role='tablist']//child::button[@value='FISH']")).click();
		Thread.sleep(2000);
		String gameToken = driver
				.findElement(By.xpath(
						"(//th[text()='Game Token']//following::td[contains(@class,'cdk-column-gameToken')])[1]"))
				.getText();
		// String winningAmount = driver.findElement(By.xpath("(//th[text()='Game
		// Token']//following::td[contains(@class,'cdk-column-winningAmount')])[1]")).getText();
		gameToken = gameToken.replace(",", "");
		String answer = "";
		int index = gameToken.indexOf('.');
		if (index >= 0) {
			answer = gameToken.substring(0, index + 2);
		} else {
			answer = gameToken;
		}
		if (gameTokens.equals(answer)) {
			test.pass("Successfully verified game token, bet amount and winning amount in fish game transactions ",
					extentScreenshot());
		} else {
			test.fail(
					"Something Wrong ! Not able to verify game token, bet amount and winning amount in fish game transactions",
					extentScreenshot());
		}
	}

	@Test
	public void Af_TC_FishGameTranscation() throws InterruptedException {
		test = extentCreateTest("verify winning amount in the player profile fish game transctions");
		test.info("TC - As an admin I should be able to verify winning amount in the player profile fish game transctions");
		CosmoWebsite cw = new CosmoWebsite(driver);

		gotoTab(driver, 1);
//		cw.ClickOnPlayerLogout();
//		Thread.sleep(1000);
//		WebsiteLogin(emailId, Password);
//		Thread.sleep(3000);
		cw.ClickOnPlayerProfile();
		Thread.sleep(5000);
		cw.ClickOnGameTransactions();
		Thread.sleep(1000);
		cw.ClickOnFishGameTransactions();
		Thread.sleep(2000);
		String WinningAmount = driver.findElement(By.xpath("(//td[text()='Ocean Bombard']//following::td)[4]"))
				.getText(); // th[text()='Winning Amount']//following::tr[1]/td[7]
		String answer = "";
		int index = totalWin.indexOf('.');
		if (index >= 0) {
			answer = totalWin.substring(0, index);
		} else {
			answer = totalWin;
		}
		if (answer.equals(WinningAmount)) {
			test.pass("Successfully verified winning amount in fish game transactions ", extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to verify winning amount in fish game transactions",
					extentScreenshot());
		}
	}

	@Test
	public void Afa_TC_FishGameTranscation_Search() throws InterruptedException {
		String gameName="Ocean Bombard";
		test = extentCreateTest("Search Fish games");
		test.info("TC - As an admin I should be able to search game name in the player profile fish game transctions");
		GuestPlayers gp = new GuestPlayers(driver);
		
		gotoTab(driver, 0);
		Thread.sleep(1000);
		gp.Search_Items(gameName);
		Thread.sleep(1000);
		if(driver.findElements(By.xpath("(//th[text()='Game Name']//following::td/div[text()='Ocean Bombard'])[1]")).size()>0){
			test.pass("Successfully searched "+gameName+" in fish game transactions ", extentScreenshot());
		}else {
			test.fail("Something Wrong ! Not able to search game in fish game transactions",extentScreenshot());
		}
	
	}

	
	@Test
	public void B_TC_PlayerFishingPassCount() throws InterruptedException {
		extentCreateTest("Verify fishing pass count in player in token details token details");
		test.info("As an admin I should be able to verify the fishing passes counts of the player in token details");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);

		gotoTab(driver, 0);
		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(emailId);
		Thread.sleep(2000);
		pp.Clickeyeicon();
		Thread.sleep(2000);
		pp.clickTokenDetailsTab();
		String FishingPass = driver.findElement(By.xpath("//span[text()='Fish Game Room']//following::div[@class='tokenDetailsAmount']//span")).getText().replace(",", "");
		gotoTab(driver, 1);
		cw.ClickOnPlayerProfile();
		Thread.sleep(5000);
		cw.ClickOnStats();
		String Fishingpass = driver.findElement(By.xpath("//span[text()='Fishing Pass']//following::span[@class='token-amount']")).getText().replace(",", "");
		if (FishingPass.equals(Fishingpass)) {
			test.pass("Successfully verified the fishing passes count in player token details ans player profile stats",
					extentScreenshot());
		} else {
			test.fail(
					"Something Wrong ! Not able to verify the fishing passes count in player token details ans player profile stats",
					extentScreenshot());

		}

	}

//	@Test
	public void Ba_TC_FishRoomIviteCode() throws InterruptedException {
		test = extentCreateTest("view the player purchases of fishing pass for individual game room");
		test.info("TC - As admin I should be able to view the player purchases of fishing pass for individual game room, so that record should get recorded in the player ledger  ");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
//		TC_Fish_RestAssuredRoomConfiguration room = new TC_Fish_RestAssuredRoomConfiguration();
		
		Aa_POST_PlayerLogin();
		Ba_POST_FishGameCreate();
		Bb_POST_FishGameRoomJoin();
		Bc_POST_FishGameSession();
		Ca_POST_FishGameFire();
		
		gotoTab(driver, 0);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(emailId);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		pp.clickPlayerLedgerTab();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("(//td[text()='Fish Room Create'])[1]")) != null) {
			test.info("Successfully created fish room");
			driver.findElement(By.xpath("(//td[text()='Fish Room Create']//following::a[@title='View'])[1]")).click();
			Thread.sleep(1000);
			String RoomInviteCode = driver.findElement(By.xpath("//td[text()='Description']//following::span[1]")).getText().substring(21, 27);
			System.out.println(RoomInviteCode);
			//String FishGameinviteCode = room.fishGameinviteCode;
			System.out.println(fishGameinviteCode);
			if (fishGameinviteCode.equals(RoomInviteCode)) {
				test.pass(
						"Successfully viewd the entry of sweep token with description- Fish Room Purchased in the player ledger",
						extentScreenshot());
			} else {
				test.fail(
						"Something Wrong ! Not able to view the entry of sweep token with description- Fish Room Purchased in the player ledger",
						extentScreenshot());
				driver.findElement(By.xpath("//mat-icon[text()='close']")).click();
			}

		} else {
			test.fail("Something Wrong ! Not able to created fish game room");
		}
	}
	

	
	
	
	
	// Single player login and player ledger transctions 
	
	public void A_POST_PlayerLogin() {
	   test = extentCreateTest("TC - Registored Player Login");
		System.out.println("*****************TC - Registored Player  Login ************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", emailId);
		requestParams.put("password", Password);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/player/v1/login");

		// print response in console window
		String responseBody = response.getBody().asString();
		// System.out.println("Response body is :" + responseBody);
		test.info(responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		Playertoken = jsonpath.getString("authorization.accessToken.token");
		System.out.println("Player aut is " + Playertoken);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("**********************************************************************");
	}

	public void B_POST_FishGameSession() {
		 test = extentCreateTest("TC - Fish Game Session");
		System.out.println("*****************TC - Fish Game Session ************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(Playertoken);
		JSONObject requestParams = new JSONObject();
		requestParams.put("betGroupId", "64252c3601868603508ddb97");
		requestParams.put("fishGameId", "64252a3401868603508ddb8a");
		requestParams.put("gameTokenType", "GAME_TOKEN");
		requestParams.put("deviceType", "MOBILE");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/fish/v1/game/session");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);
		test.info(responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		fishGamesessionId = jsonpath.getString("id");
		System.out.println("FishGameSessionId is =" + fishGamesessionId);

		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("*****************************************");
	}

	public void C_POST_FishGameFire() {
		 test = extentCreateTest("TC - Fish Game Fire ");
		System.out.println("*****************TC - Fish Game Fire *******************************");
		// Specify base URI
		String[] GunProerty = { "NORMAL_GUN", }; // "LASER_GUN", "FIRE_GUN", "SINGLE_BARREL_GUN", "DOUBLE_BARREL_GUN" };
		for (String gp : GunProerty) {
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYW1lbGlmdHNlcnZlcnRva2VuIiwiZ2FtZWxpZnRHYW1lU2Vzc2lvbklkIjoiZ2FtZWxpZnRzZXJ2ZXJ0b2tlbmlkXzYxMzc3MiIsInVzZXJfdHlwZSI6ImdhbWVsaWZ0U2VydmVyIiwicmFuZG9tIjoiYzY4YTM2ODQtNWJhMy00YmJhLTkwODUtZGU4NjMxZDFlYWIyIiwiaWF0IjoxNjc4ODgxOTI1LCJleHAiOjQ4MzQ2MTg3NjV9.gAkGw0L7eLidAGhzBhl52k5LJNPvxrg_QCsxqHHVr_8");

			// passing the body payload in api
			JSONObject requestParams = new JSONObject();
			requestParams.put("betToken", "5.0");
			requestParams.put("fishGameId", "64252a3401868603508ddb8a");
			requestParams.put("fishGameSessionId", fishGamesessionId);
			requestParams.put("symbolCode", "L7");
			requestParams.put("gunProperty", gp);
			requestParams.put("freeBullet", "false");

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/fish/v1/gameplay/fire");

			// print response in console window
			String responseBody = response.getBody().asString();
			// System.out.println("Response body is :" + responseBody);
			test.info(responseBody);

			JsonPath jsonpath = response.jsonPath().prettyPeek();
			totalWin = jsonpath.getString("totalWin");
			gameTokens = jsonpath.getString("token.gameTokens");
			symbolCode = jsonpath.getString("symbolCode");

			// Status code verification
			int statusResponseCode = response.getStatusCode();
			System.out.println("Status code is " + statusResponseCode);
			System.out.println("Total win is " + totalWin);
			System.out.println("Game token is " + gameTokens);
			System.out.println("Symbol code is " + symbolCode);
			// Assert.assertEquals(statusResponseCode, 200);

			System.out.println("*******************************************************************");
		}
	}

	
	
	
	
	
	// Room invite multi-player login
	
	public void Aa_POST_PlayerLogin() {
		String[] PlayerId = { "CS-1400", "CS-1401", "CS-1402", "CS-1398" };// ,"CS-1382"};
		for (String gp : PlayerId) {
			// test = extentCreateTest("TC - Registored Player Login");
			System.out.println("*****************TC - Registored Player  Login ************************");
			// Specify base URI
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			JSONObject requestParams = new JSONObject();
			requestParams.put("email", gp);
			requestParams.put("password", Password);
			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/player/v1/login");

			// print response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is :" + responseBody);

			JsonPath jsonpath = response.jsonPath().prettyPeek();
			PlayerToken = jsonpath.getString("authorization.accessToken.token");
			System.out.println("Player aut is " + PlayerToken);
			P_Token.add(PlayerToken);
			// Status code verification
			int statusResponseCode = response.getStatusCode();
			System.out.println("Status code is " + statusResponseCode);
			// Assert.assertEquals(statusResponseCode, 200);
		}
		System.out.println("**********************************************************************");
	}

	public void Ba_POST_FishGameCreate() {
		// test = extentCreateTest("TC - Fish Game Session");

		System.out.println("*****************TC - Fish Game create invite code************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		String token = P_Token.get(0);
		httpRequest.auth().oauth2(token);
		JSONObject requestParams = new JSONObject();
		requestParams.put("betGroupId", "64252c3601868603508ddb97");
		requestParams.put("fishGameId", "64252a3401868603508ddb8a");
		requestParams.put("gameTokenType", "SWEEP_TOKEN");
		requestParams.put("deviceType", "MOBILE");
		requestParams.put("inviteTransactionType", "SWEEP_TOKEN");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/fish/v1/game/session/invite/code");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		fishGameinviteCode = jsonpath.getString("inviteCode");
		System.out.println("inviteCode is =" + fishGameinviteCode);

		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("*****************************************");

	}
	
	public void Bb_POST_FishGameRoomJoin() {
		// test = extentCreateTest("TC - Fish Game Session");
		for (String gp : P_Token) {
			System.out.println("*****************TC - Fish Game join ************************");
			// Specify base URI
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.auth().oauth2(gp);
			JSONObject requestParams = new JSONObject();

			requestParams.put("inviteCode", fishGameinviteCode);

			requestParams.put("deviceType", "MOBILE");

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/fish/v1/game/session/invite/join");

			// print response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is :" + responseBody);

//			 
			// Status code verification
			int statusResponseCode = response.getStatusCode();
			System.out.println("Status code is " + statusResponseCode);
			// Assert.assertEquals(statusResponseCode, 200);

			System.out.println("*****************************************");
		}
	}
	
	public void Bc_POST_FishGameSession() {
		// test = extentCreateTest("TC - Fish Game Session");
		for (String gp : P_Token) {
			System.out.println("*****************TC - Fish Game Session ************************");
			// Specify base URI
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.auth().oauth2(gp);
			JSONObject requestParams = new JSONObject();
			requestParams.put("betGroupId", "64252c3601868603508ddb97");
			requestParams.put("fishGameId", "64252a3401868603508ddb8a");
			requestParams.put("gameTokenType", "GAME_TOKEN");
			requestParams.put("deviceType", "MOBILE");

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/fish/v1/game/session");

			// print response in console window
			String responseBody = response.getBody().asString();
			System.out.println("Response body is :" + responseBody);

			JsonPath jsonpath = response.jsonPath().prettyPeek();
			fishGameSessionId = jsonpath.getString("id");
			System.out.println("FishGameSessionId is =" + fishGameSessionId);
			GameSession.add(fishGameSessionId);
			// Status code verification
			int statusResponseCode = response.getStatusCode();
			System.out.println("Status code is " + statusResponseCode);
			// Assert.assertEquals(statusResponseCode, 200);

			System.out.println("*****************************************");
		}
	}

	public void Ca_POST_FishGameFire() {
		// test = extentCreateTest("TC - Fish Game Fire ");
		System.out.println("*****************TC - Fish Game Fire *******************************");
		// Specify base URI
		// String[] GunProerty = { "NORMAL_GUN", "LASER_GUN", "FIRE_GUN",
		// "SINGLE_BARREL_GUN", "DOUBLE_BARREL_GUN" };

		for (String gp : GameSession) {
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.auth().oauth2(
					"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYW1lbGlmdHNlcnZlcnRva2VuIiwiZ2FtZWxpZnRHYW1lU2Vzc2lvbklkIjoiZ2FtZWxpZnRzZXJ2ZXJ0b2tlbmlkXzYxMzc3MiIsInVzZXJfdHlwZSI6ImdhbWVsaWZ0U2VydmVyIiwicmFuZG9tIjoiYzY4YTM2ODQtNWJhMy00YmJhLTkwODUtZGU4NjMxZDFlYWIyIiwiaWF0IjoxNjc4ODgxOTI1LCJleHAiOjQ4MzQ2MTg3NjV9.gAkGw0L7eLidAGhzBhl52k5LJNPvxrg_QCsxqHHVr_8");

			// passing the body payload in api
			JSONObject requestParams = new JSONObject();
			requestParams.put("betToken", "5.0");
			requestParams.put("fishGameId", "64252a3401868603508ddb8a");
			requestParams.put("fishGameSessionId", gp);
			requestParams.put("symbolCode", "L7");
			requestParams.put("gunProperty", "NORMAL_GUN");
			requestParams.put("freeBullet", "false");

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/fish/v1/gameplay/fire");

			// print response in console window
			String responseBody = response.getBody().asString();
			// System.out.println("Response body is :" + responseBody);

			JsonPath jsonpath = response.jsonPath().prettyPeek();
			String totalWin = jsonpath.getString("totalWin");
			String gameTokens = jsonpath.getString("token.gameTokens");
			String symbolCode = jsonpath.getString("symbolCode");

			// Status code verification
			int statusResponseCode = response.getStatusCode();
			System.out.println("Status code is " + statusResponseCode);
			System.out.println("Total win is " + totalWin);
			System.out.println("Game token is " + gameTokens);
			System.out.println("Symbol code is " + symbolCode);
			// Assert.assertEquals(statusResponseCode, 200);

			System.out.println("*******************************************************************");
		}
	}

}
