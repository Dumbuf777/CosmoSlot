/**
 * 
 */
package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.MDBScheduller;
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
public class MDB_PlayerScenarios extends BaseClass {

	private CosmoWebsite cw;
	String emailId = "CS-1901";// AT3567-2788 CS-1400
	String Password = "Gameium@1234";
	String Pkg = "starpack4kTf";// PACKAGE01
	String gameSessionId1 = "";
	String PlayerToken = "";
	String playerRefreshToken = "";
	String id = "";
	int gameSpin = 10;
	int remspin = 5;
	int login = 5;

	/**
	 * Before the execution of this method 
	 * 1st-> register the player 
	 * 2nd-> add wallet
	 */

//	@Test
	public void A_MDB_Verify_Login_ReminderActionPopup() throws InterruptedException, IOException {
		test = extentCreateTest("MDB-> Login - Reminder  & action popup");
		test.info("As a player I should be able to verify MDB login reminder popup in website");
		cw = new CosmoWebsite(driver);
		PlayerReferralScenario2 prs = new PlayerReferralScenario2();

		Thread.sleep(3000);
		gotoTab(driver, 1);
		Thread.sleep(3000);
		A_POST_PlayerLogin();
		Aa_POST_PlayerLogout();
		A_POST_PlayerLogin();
		Aa_POST_PlayerLogout();
		cw.ClickOnPlayerLogout();
		WebsiteLogin(emailId, Password);
		if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
			test.pass("Successfully viewed reminder popup", extentScreenshot());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		}
		gotoTab(driver, 1);
		prs.PlayerLogout();
		A_POST_PlayerLogin();
		Aa_POST_PlayerLogout();
		A_POST_PlayerLogin();
		Aa_POST_PlayerLogout();
		TimeUnit.MINUTES.sleep(16);
		prs.PlayerProfile_ManageTokens(Pkg, emailId);//"PACKAGE01"
		WebsiteLogin(emailId, Password);
		if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
			test.pass("Successfully viewed action popup", extentScreenshot());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
////			Thread.sleep(3000);		
////			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		}
		A_POST_PlayerLogin();
		Ca_GET_PlayerBonus(PlayerToken);
		Cb_POST_PlayerClaimBonus(PlayerToken);
		Aa_POST_PlayerLogout();
	}
	
	
	public void Aa_MDB_Verify_Login_ReminderPopup() throws InterruptedException, IOException {
		test = extentCreateTest("MDB-> Login - Reminder  & action popup");
		test.info("As a player I should be able to verify MDB login reminder popup in website");
		
		checkTime();

		for (int i = 1; i <= login; i++) {
			cw = new CosmoWebsite(driver);
			PlayerReferralScenario2 prs = new PlayerReferralScenario2();
			gotoTab(driver, 1);
			cw.ClickOnPlayerLogout();
			WebsiteLogin(emailId, Password);
			if (i == 3) {
				if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
					test.pass("Successfully viewed reminder popup", extentScreenshot());
					Thread.sleep(3000);
					driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
				}
			}
		
			
		}

	}
	
	@Test
	public void B_MDB_VerifyPopupPlayerGameplay() throws InterruptedException, IOException {
		test = extentCreateTest("MDB-> Gameplay - Reminder  & action popup");
		test.info("As a player I should be able to verify MDB gameplay reminder and action popup in website");
		cw = new CosmoWebsite(driver);

		A_POST_PlayerLogin1();
		B_POST_SlotGameSession1();
		for (int i = 1; i <= gameSpin; i++) {
			B_POST_SlotGameSpin1();
			System.out.println(i);
			if (i == remspin) {
				TimeUnit.MINUTES.sleep(5);
				gotoTab(driver, 1);
				cw.ClickOnPlayerLogout();
				WebsiteLogin(emailId, Password);
				if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
					CosmoWebsite cw1 = new CosmoWebsite(driver);
					test.pass("Successfully viewed reminder popup", extentScreenshot());
					driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
					Thread.sleep(3000);
					cw1.ClickOnPlayerLogout();
				}
			}

			if (i == gameSpin) {
				PlayerReferralScenario2 prs = new PlayerReferralScenario2();
				CosmoWebsite cw2 = new CosmoWebsite(driver);
				TimeUnit.MINUTES.sleep(16);
				prs.PlayerProfile_ManageTokens(Pkg, emailId);
				gotoTab(driver, 1);
				// cw2.ClickOnPlayerLogout();
				WebsiteLogin(emailId, Password);
				if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
					test.pass("Successfully viewed action popup", extentScreenshot());
					driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
					Thread.sleep(3000);
					cw2.ClickOnPlayerLogout();
				}
				System.out.println("reminder popup verifyed");
				Ca_GET_PlayerBonus(PlayerToken);
				Cb_POST_PlayerClaimBonus(PlayerToken);

			}

		}

	}
	
//	@Test
	public void C_VerifyActionPopupInLossMaking() throws InterruptedException, IOException {
		
		test = extentCreateTest("MDB-> Loss Making - Action popup");
		test.info("As a player I should be able to verify MDB loss making action popup in website");
		cw = new CosmoWebsite(driver);
		PlayerReferralScenario2 prs = new PlayerReferralScenario2();
		A_POST_PlayerLogin1();
		B_POST_SlotGameSession1();
		B_POST_SlotGameSpin1();
		B_POST_SlotGameSpin1();
		B_POST_SlotGameSpin1();
		B_POST_SlotGameSpin1();
		B_POST_SlotGameSpin1();
    	TimeUnit.MINUTES.sleep(7);
		prs.PlayerProfile_ManageTokens(Pkg, emailId);
		gotoTab(driver, 1);
		cw.ClickOnPlayerLogout();
		WebsiteLogin(emailId, Password);
		if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
			CosmoWebsite cw1 = new CosmoWebsite(driver);
			test.pass("Successfully viewed lossmaking action popup", extentScreenshot());
			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
			Thread.sleep(3000);
			//scw1.ClickOnPlayerLogout();
		}
		Ca_GET_PlayerBonus(PlayerToken);
		Cb_POST_PlayerClaimBonus(PlayerToken);
		
	}
	
//    @Test
	public void D_VerifyActionPopup_PurchaseOnDeposit() throws InterruptedException, IOException {
		test = extentCreateTest("MDB->Purchase on deposit - Action popup");
		test.info("As a player I should be able to verify MDB purchase on deposit reminder and action popup in website");
		cw = new CosmoWebsite(driver);
		PlayerReferralScenario2 prs = new PlayerReferralScenario2();
		prs.PlayerProfile_ManageTokens(Pkg, emailId);
		gotoTab(driver, 1);
		cw.ClickOnPlayerLogout();
		WebsiteLogin(emailId, Password);
		if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
			test.pass("Successfully viewed MDB purchase on deposit reminder popup", extentScreenshot());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		}
		Thread.sleep(3000);
		prs.PlayerProfile_ManageTokens(Pkg, emailId);
		gotoTab(driver, 1);
		prs.PlayerLogout();
		WebsiteLogin(emailId, Password);
		if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
			test.pass("Successfully viewed MDB purchase on deposit action popup", extentScreenshot());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
		}
		A_POST_PlayerLogin1();
		Ca_GET_PlayerBonus(PlayerToken);
		Cb_POST_PlayerClaimBonus(PlayerToken);
	}
	
	public void A_POST_PlayerLogin() {
		// test = extentCreateTest("TC - Player Login");
		test.info("Player Login");
		System.out.println("***************** TC -  Player  Login ************************");
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", emailId);
		requestParams.put("password", Password);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/player/v1/login");
		String responseBody = response.getBody().asString();
		// System.out.println("Response body is :" + responseBody);
		test.info(responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		PlayerToken = jsonpath.getString("authorization.accessToken.token");
		playerRefreshToken = jsonpath.getString("authorization.refreshToken.token");
		System.out.println("Player aut is " + PlayerToken);
		System.out.println("Player playerRefreshToken is " + playerRefreshToken);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("**********************************************************************");
	}
	

	public void Aa_POST_PlayerLogout() {
		// test = extentCreateTest("TC - Player logout");
		test.info("Player logout");
		System.out.println("*****************TC -  Player  logout ************************");
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(PlayerToken);
		JSONObject requestParams = new JSONObject();
		requestParams.put("token", PlayerToken);
		requestParams.put("refreshToken", playerRefreshToken);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/player/v1/logout");
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 204);

		System.out.println("**********************************************************************");
	}

	public void A_POST_PlayerLogin1() {
		test.info("Player Login using REST API");
		System.out.println("*****************TC - Registored Player  Login ************************");
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", emailId);
		requestBody.put("password", Password);
		Response response = sendPostRequestWithAuthorization("/player/v1/login", requestBody);

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		PlayerToken = jsonpath.getString("authorization.accessToken.token");
		System.out.println("Player aut is " + PlayerToken);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		test.info("Player login api response code = " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void B_POST_SlotGameSession1() {
		// test = extentCreateTest("Slot game session");
		test.info("Player slot game session");
		System.out.println("*****************TC - Slot game session ************************");
		JSONObject requestBody = new JSONObject();
		requestBody.put("gameId", "62da952487a883647b781977");
		requestBody.put("gameTokenType", "GAME_TOKEN");
		Response response = sendPostRequestWithAuthorization("/engine/v1/game/session", requestBody, PlayerToken);

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		gameSessionId1 = jsonpath.getString("id");
		System.out.println("Game Session Id is " + gameSessionId1);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		test.info("Player slot game session api response code = " + statusResponseCode);
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void B_POST_SlotGameSpin1() {
		// test = extentCreateTest("Slot game spin");
		test.info("Player slot game spin");
		System.out.println("*****************TC - Slot game spin ************************");
		JSONObject requestBody = new JSONObject();
		requestBody.put("betToken", "12.5");
		requestBody.put("gameSessionId", gameSessionId1);
		Response response = sendPostRequestWithAuthorization("/engine/v1/spin", requestBody, PlayerToken);

		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();

		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		test.info("Player slot game spin api response code = " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void Ca_GET_PlayerBonus(String token) {
		test = extentCreateTest("Get list of bonus");
		System.out.println("*****************TC -Get player bonus************************");

		Response response = sendGetRequestWithAuthorization("/player/v1/player/get-player-bonus-list", token);

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);
		test.info(responseBody);

		//JsonPath jsonpath = response.jsonPath().prettyPeek();
		id = response.jsonPath().getString("[0].id");
		System.out.println("Player bounusID is " + id);

		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void Cb_POST_PlayerClaimBonus(String token) {
		test = extentCreateTest("Player claim bonus");
		System.out.println("*****************Player claim bonus************************");
		JSONObject requestBody = new JSONObject();
		requestBody.put("multipleDepositBonusId", id);
		requestBody.put("action", "MULTIPLE_DEPOSIT_BONUS");
		System.out.println(requestBody);
		Response response = sendPostRequestWithAuthorization("/player/v1/player/bonus", requestBody, token);

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);
		test.info(responseBody);
		JsonPath jsonpath = response.jsonPath().prettyPeek();
		String message = response.jsonPath().getString("message");
		Assert.assertEquals(message, "Bonus added successfully");
		test.info(message);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		test.info("Player claim bonus api response code = " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);

	}
	

	public Response sendPostRequestWithAuthorization(String path, JSONObject requestBody, String authToken) {
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(authToken); // Set the authorization header
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestBody.toJSONString());
		return httpRequest.request(Method.POST, path);
	}
	
	public Response sendPostRequestWithAuthorization(String path, JSONObject requestBody) {
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestBody.toJSONString());
		return httpRequest.request(Method.POST, path);
	}

	public Response sendGetRequestWithAuthorization(String path, String authToken) {
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(authToken);
		httpRequest.header("Content-Type", "application/json");
		return httpRequest.request(Method.GET, path);
	}

	void checkTime() throws InterruptedException {

        String cDate = MDBScheduller.currentdatetime(0);
        String cTime = cDate.substring(11, 16).replace(":", "");
        System.out.println("current time - " + cTime);

        
        int lastDigit = MDBScheduller.lasttwo(cTime);
        if (lastDigit != -1) {
            // System.out.println("Last digit: " + lastDigit);

            int valueToAdd = MDBScheduller.addmoreTime(lastDigit);
            System.out.println("Value to add: " + valueToAdd);

            // Ensure digi is a 3-digit number
            String digiStr = String.format("%04d", valueToAdd);
            // int hold=Integer.valueOf("60000"+String.valueOf(incre));
            int hold = 60000 * MDBScheduller.incre;
            Thread.sleep(hold);
            System.out.println("new time: " + digiStr);
        }
       }
	}
