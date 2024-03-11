/**
 * 
 */
package com.Cosmoslots.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author shrikrushna.sonkar
 *
 */
public class AgentScenario extends BaseClass {
	BaseClass bc = new BaseClass();
	String r = RandomStringUtils.randomAlphabetic(2);
	String regCode = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
	String randomNum = RandomStringUtils.randomNumeric(4);
	String Firstnm ="";
	String Lastnm = "";
	String Usernm = Firstnm +" "+ Lastnm;
	String Email = Firstnm.toLowerCase() +RandomStringUtils.randomNumeric(5) + "@yopmail.com";
	String country = "India";
	String Store ="Store-7777 - (CT7777) ";
	String state = "Goa";
	String PTSTL = "1000000";
	String PDTSTL = "1000000";
	String userrole[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };
	String parentRole[] = { "Gameium Admin", "Master", "Distributor", "Sub Distributor", "Store", "POS" };
	String acceslevel[] = { "GameiumAdmin", "Master", "Distributor", "SubDistributor", "Store", "POS" };

	@Test
	public void C_TC_UserHierarchy_CreateNewUser() throws InterruptedException {
		
		CreateNewUsers("Gameium Admin ",Store, " System Admin ");
		CreateNewUsers("Master ",Store, Usernm);
		CreateNewUsers("Distributor ",Store, Usernm);
		CreateNewUsers("Agent ",Store, "Munch Flatley");
		for (int i=1; i<=40;i++) {
			CreateNewUsers("Agent ",Store, Usernm);
			if(i==9) {
				CreateNewUsers("Store ",Store, Usernm);
				CreateNewUsers("POS ",Store, Usernm);
				}
			}

		CreateNewUsers("Store ",Store, "Manet Mohr");
		CreateNewUsers("POS ",Store, "Kandinsky Doyle");
		
		
	}
	
	
//	@Test
	public void Ca_TC_UserHierarchy_CreateNewUser() throws InterruptedException {
		
		for (int i=1; i<=20;i++) {
		CreateNewUsers("Agent ",Store, Usernm);
		if(i==10) {
		CreateNewUsers("Store ",Store, Usernm);
		CreateNewUsers("POS ",Store, Usernm);
		}
		}
		
	}
	
	
//	@DataProvider()
	public Object[][] userAgentName() {
		return new Object[][] { { "" },
				// { "" },
				// { "" },
				{ "" } };
	}

//	@Test(dataProvider = "userAgentName")
	public void Cd_TC_UserHierarchy_CreateNewUser() throws InterruptedException {
		CreateNewUsers("Agent ",Store, Usernm);
		for (int i=1; i<=3;i++) {
		CreateNewUsers("Agent ",Store, Usernm);
//		if(i==10) {
//		CreateNewUsers("Store ",Store, Usernm);
//		CreateNewUsers("POS ",Store, Usernm);
//		}
		}
		
	}
	
	
		

	public void CreateNewUsers(String roles, String stores, String parentuser) throws InterruptedException {
		test = extentCreateTest("TC - As an super admin I should be able to create new users-> "+roles);
		String Firstnm = bc.Fakefirstname();
		String Lastnm = bc.Fakelastname();
		String Usernm = Firstnm + Lastnm;
		String Email = Firstnm + RandomStringUtils.randomNumeric(5) + "@yopmail.com".toLowerCase();
		
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);

		up.ClickOnUserProfile();
		Thread.sleep(2000);
		up.ClickOnBack();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"User Profile\"]")) != null) {
			test.info("Opened User Profile Successfully");
			gp.clickCreateNewButton();

			if (driver.findElement(By.xpath("//h3[text()=\"Create User Profile\"]")) != null) {
				Thread.sleep(2000);
				gp.setFirstName(Firstnm);
				gp.setLastName(Lastnm);
//				gp.selectgender("Male");
				gp.setDisplayName(Usernm);
				gp.Designation.sendKeys(roles);
				gp.setEmail(Email);
				gp.setCountry(country);
				gp.setState(state);
				gp.setsingleTransactionSweepTokenLimit(PTSTL);
				gp.setdailySweepTokenLimit(PDTSTL);
				gp.selectUserRole(roles);
				if(driver.findElements(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).size()>0) {
					driver.findElement(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).click();
					driver.findElement(By.xpath("//input[@formcontrolname=\"registrationCode\"]")).sendKeys(regCode);
					test.info("Succesfully entered POS registration code",extentScreenshot());
				}
				Thread.sleep(2000);
				gp.selectStore(stores);
				Thread.sleep(2000);
				gp.selectparentuser(parentuser);
				Thread.sleep(2000);
				up.clickToSave();
				Thread.sleep(500);
//				if (driver.findElement(By.xpath("//span[text()=\"User save successfully\"]")) != null) {
//					//Assert.assertTrue(true);
//					test.info("Successfully Added  New User in User Management->Users List.", extentScreenshot());
//				} else {
//					//Assert.assertTrue(false);
//					test.info("Something Wrong!To View Added User Management->Users List.", extentScreenshot());
//				}
				Thread.sleep(5000);
			}
		}
	}
	
	public void playerRegistrationUnderPOS(String inviteCode) {
		test = extentCreateTest("Player Registration");

		RestAssured.baseURI = "https://qaautomation-api.cosmoslots.tech";
		RequestSpecification httpRequest = RestAssured.given();

		// request payload sending along with post
		JSONObject requestParams = new JSONObject();

		requestParams.put("confirmPassword", "Gameium@1234");
		requestParams.put("firstName", bc.Fakefirstname());
		requestParams.put("lastName", bc.Fakelastname());
		requestParams.put("email", bc.Fakefirstname()+RandomStringUtils.randomNumeric(5) + "@yopmail.com".toLowerCase());
		requestParams.put("inviteCode", "EDLCYG");
		requestParams.put("phone", "9874632500");
		requestParams.put("dialCode", "+91");
		requestParams.put("password", "Gameium@1234");
		requestParams.put("playerRegistrationType", "APP_REGISTRATION");
		requestParams.put("address", "address");
//		requestParams.put("dob", "665137177000");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());
//			httpRequest.body(requestParams.toString());

		Response response = httpRequest.request(Method.POST, "/player/v1/registration");
		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :" + responseBody + "\r\n");
		test.pass(responseBody); 
		
	}
}
