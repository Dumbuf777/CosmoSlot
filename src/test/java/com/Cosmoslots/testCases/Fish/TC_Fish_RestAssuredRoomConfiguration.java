/**
 * 
 */
package com.Cosmoslots.testCases.Fish;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

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
public class TC_Fish_RestAssuredRoomConfiguration //extends BaseClass
{
	// String[] emailId={"CS-1400"}
	 String Password="Gameium@1234";
	 String PlayerToken="";
	 String fishGameSessionId="";
	 List<String> P_Token = new ArrayList<String>();
	 List<String> GameSession = new ArrayList<String>();
	 public String fishGameinviteCode="";
	 
	@Test
	public void A_POST_PlayerLogin() {
		String[] PlayerId = { "CS-1400" ,"CS-1401","CS-1402","CS-1398"};//,"CS-1382"};
		for (String gp : PlayerId) {
		//test = extentCreateTest("TC - Registored Player  Login");
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
		System.out.println("Player aut is "+PlayerToken);
		P_Token.add(PlayerToken);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);
		}
		System.out.println("**********************************************************************");
	}
	
	@Test
	public void Ba_POST_FishGameCreate() {
		//test = extentCreateTest("TC - Fish Game Session");
		
		System.out.println("*****************TC - Fish Game create invite code************************");
		// Specify base URI
		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();
		String token=P_Token.get(0);
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
		System.out.println("inviteCode is ="+fishGameinviteCode);
	 
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("*****************************************");
		 
	}
	
	@Test
	public void Bb_POST_FishGameRoomJoin() {
		//test = extentCreateTest("TC - Fish Game Session");
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
	
	@Test
	public void Bc_POST_FishGameSession() {
		//test = extentCreateTest("TC - Fish Game Session");
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
		System.out.println("FishGameSessionId is ="+fishGameSessionId);
		GameSession.add(fishGameSessionId);
		// Status code verification
		int statusResponseCode = response.getStatusCode();
		System.out.println("Status code is " + statusResponseCode);
		// Assert.assertEquals(statusResponseCode, 200);

		System.out.println("*****************************************");
		}
	}
	
	@Test
	public void C_POST_FishGameFire() {
		//test = extentCreateTest("TC - Fish Game Fire ");		
		System.out.println("*****************TC - Fish Game Fire *******************************");
		// Specify base URI
		//String[] GunProerty = { "NORMAL_GUN", "LASER_GUN", "FIRE_GUN", "SINGLE_BARREL_GUN", "DOUBLE_BARREL_GUN" };
		
		for (String gp : GameSession) {
			RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
			RequestSpecification httpRequest = RestAssured.given();
			httpRequest.auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnYW1lbGlmdHNlcnZlcnRva2VuIiwiZ2FtZWxpZnRHYW1lU2Vzc2lvbklkIjoiZ2FtZWxpZnRzZXJ2ZXJ0b2tlbmlkXzYxMzc3MiIsInVzZXJfdHlwZSI6ImdhbWVsaWZ0U2VydmVyIiwicmFuZG9tIjoiYzY4YTM2ODQtNWJhMy00YmJhLTkwODUtZGU4NjMxZDFlYWIyIiwiaWF0IjoxNjc4ODgxOTI1LCJleHAiOjQ4MzQ2MTg3NjV9.gAkGw0L7eLidAGhzBhl52k5LJNPvxrg_QCsxqHHVr_8");
			 
			//passing the body payload in api
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
			//System.out.println("Response body is :" + responseBody);

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
