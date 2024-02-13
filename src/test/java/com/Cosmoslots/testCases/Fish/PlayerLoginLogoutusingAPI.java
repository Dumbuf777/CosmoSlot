package com.Cosmoslots.testCases.Fish;

import org.json.simple.JSONObject;
import org.testng.Assert;
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

public class PlayerLoginLogoutusingAPI extends BaseClass{
	

	String emailId = "AT3567-2782";
	String Password = "Gameium@1234";
	String PlayerToken = "";
	String playerRefreshToken = "";
	
    @Test
	public void A_POST_PlayerLogin() {
	   test = extentCreateTest("TC - Player Login");
		System.out.println("***************** TC -  Player  Login ************************");
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
		//test.info(responseBody);

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
    
    @Test
   	public void Aa_POST_PlayerLogout() {
   	   test = extentCreateTest("TC - Player logout");
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
   		 Assert.assertEquals(statusResponseCode, 200);

   		System.out.println("**********************************************************************");
   	}

}
