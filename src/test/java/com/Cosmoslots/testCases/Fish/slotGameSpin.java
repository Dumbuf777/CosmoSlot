package com.Cosmoslots.testCases.Fish;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.testCases.PlayerReferralScenario2;
import com.Cosmoslots.utilities.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class slotGameSpin extends BaseClass {

	private CosmoWebsite cw;
	String emailID = "CS-1400";
	String Password = "Gameium@1234";
	String Pkg = "starpack4kTf (Act Amt. $1)";
	String gameSessionId1 = "";
	String PlayerToken = "";
	int gameSpin = 10;
	int remspin = 5;

//	@Test
	public void A_POST_PlayerLogin() {
		test = extentCreateTest("Registored Player  Login");
		System.out.println("*****************TC - Registored Player  Login ************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject jasonBody = new JSONObject();
		jasonBody.put("email", emailID);
		jasonBody.put("password", Password);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jasonBody.toJSONString());
		Response response = httpRequest.request(Method.POST, "/player/v1/login");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		PlayerToken = jsonpath.getString("authorization.accessToken.token");
		System.out.println("Player aut is " + PlayerToken);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
		System.out.println("**********************************************************************");
	}

//	@Test
	public void B_POST_SlotGameSession() {
		test = extentCreateTest("Slot game session");
		System.out.println("*****************TC - Slot game session ************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(PlayerToken);
		JSONObject jasonBody = new JSONObject();
		jasonBody.put("gameId", "62da952487a883647b781977");
		jasonBody.put("gameTokenType", "GAME_TOKEN");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jasonBody.toJSONString());
		Response response = httpRequest.request(Method.POST, "/engine/v1/game/session");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();
		gameSessionId1 = jsonpath.getString("id");
		System.out.println("Game Session Id is " + gameSessionId1);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
		System.out.println("**********************************************************************");
	}

//	@Test
	public void B_POST_SlotGameSpin() {
		test = extentCreateTest("Slot game spin");
		System.out.println("*****************TC - Slot game spin ************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.auth().oauth2(PlayerToken);
		JSONObject jasonBody = new JSONObject();
		jasonBody.put("betToken", "12.5");
		jasonBody.put("gameSessionId", gameSessionId1);
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jasonBody.toJSONString());
		Response response = httpRequest.request(Method.POST, "/engine/v1/spin");

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody);

		JsonPath jsonpath = response.jsonPath().prettyPeek();

		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
		System.out.println("**********************************************************************");
	}

	@Test
	public void VerifyPopupPlayerGameplay() throws InterruptedException, IOException {
		test = extentCreateTest("MDB-> Gameplay - Reminder  & action popup");
		test.info("As a player I should be able to verify MDB gameplay reminder and action popup in website");
		cw = new CosmoWebsite(driver);
		cw = new CosmoWebsite(driver);
		A_POST_PlayerLogin1();
		B_POST_SlotGameSession1();
		for (int i = 1; i <= gameSpin; i++) {
			B_POST_SlotGameSpin1();
			System.out.println(i);
			if (i == remspin) {
				gotoTab(driver, 1);
				cw.ClickOnPlayerLogout();
				WebsiteLogin(emailID, Password);
				if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
					test.pass("Successfully viewed reminder popup", extentScreenshot());
					driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
					Thread.sleep(3000);
					cw.ClickOnPlayerLogout();
				}
			}

			if (i == gameSpin) {
				PlayerReferralScenario2 prs = new PlayerReferralScenario2();
				prs.PlayerProfile_ManageTokens(Pkg, emailID);
				gotoTab(driver, 1);
				cw.ClickOnPlayerLogout();
				WebsiteLogin(emailID, Password);
				if (driver.findElement(By.xpath("(//p[contains(.,'MDB')])[1]")).isDisplayed()) {
					test.pass("Successfully viewed action popup", extentScreenshot());
					driver.findElement(By.xpath("//button[@aria-label='Close this dialog']")).click();
					Thread.sleep(3000);
				}
				System.out.println("reminder popup verifyed");
				cw.ClickOnPlayerLogout();

			}

		}

	}

	public void A_POST_PlayerLogin1() {
		test = extentCreateTest("Registored Player Login");
		System.out.println("*****************TC - Registored Player  Login ************************");
		JSONObject requestBody = new JSONObject();
		requestBody.put("email", emailID);
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
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void B_POST_SlotGameSession1() {
		// test = extentCreateTest("Slot game session");
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
		System.out.println("Status code is " + statusResponseCode);
		Assert.assertEquals(statusResponseCode, 200);
	}

	public void B_POST_SlotGameSpin1() {
		// test = extentCreateTest("Slot game spin");
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

}
