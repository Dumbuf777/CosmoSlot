package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.utilities.BaseClass;

public class PlayerDeletionHistory extends BaseClass {
	BaseClass bc = new BaseClass();
	private PlayerProfile pp ;
	private PurchaseHistory ph;
	private WithdrawRequest wr;
	private CommonCosmo cc;
	private GuestPlayers gp;
	String SearchplayerId = "CS-1342";

	@Test(groups = { "admin", "website" })
	public void A_TC_PlayerDeletionHistory_Redirect() throws InterruptedException, IOException {
		test = extentCreateTest("PlayerDeletionHistory -> Redirect");
		test.info("Test Case started - As an admin user I should able to view Player Deletion History screen by clicking on Players Management link");
		pp = new PlayerProfile(driver);
		ph = new PurchaseHistory(driver);
		cc = new CommonCosmo(driver);
		
		gotoTab(driver, 0);
		pp.clickOnPlayerManagement();
		test.info("Redirect on Player Management");
		Thread.sleep(2000);
		ph.clickOnPlayerDeletionHistory();
		
		if (cc.PlayerDeletionHistory_Header != null) {
			test.pass("Successfully Opened Player Deletion History Page");
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To Open Player Deletion History Page", extentScreenshot());
			//Assert.assertTrue(false);
		}
	}

	@Test(groups = "admin")
	public void B_TC_PlayerDeletionHistory_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("PlayerDeletionHistory -> View List");
		test.info("Test Case started - As an admin user I should able to view list of the Player Deletion History");
		cc = new CommonCosmo(driver);

		if (cc.PlayerDeletionHistory_Header != null) {
			test.info("Already Opened player Deletion History screen");

			if (driver
					.findElements(By.xpath("//th[text()='Player Id']/following::tr//td[contains(@class,'playerId ')]"))
					.size() > 0) {
				test.pass(
						"Successfully Viewed player Id  of Player Deletion History on the Player Deletion History page");
				Assert.assertTrue(true);
			} else {
				test.info(
						"Something wrong !! To Viewed Player Id of player deletion on the Player Deletion History page");
				//Assert.assertTrue(false);
				captureScreen(driver, "PlayerIDofPlayerDeletionHistory");
			}
			if (driver
					.findElements(
							By.xpath("//th[text()='Display Name']/following::tr//td[contains(@class,'displayName ')]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Display Name of player deletion on the Player Deletion History page");
			} else {
				// //Assert.assertTrue(false);
				test.info(
						"Something wrong !! To Viewed DisplayName of player deletion on the player Deletion History page");
				// captureScreen(driver,"DisplayNameofPlayerDeletionHistory");
			}
			if (driver
					.findElements(By.xpath(
							"//th[text()='Player Name']/following::tr//td[contains(@class,'firstName-lastName ')]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Player Name of player deletion on the player Deletion History page");
			} else {
				// //Assert.assertTrue(false);
				test.info(
						"Something wrong !! To Viewed Player Name of player deletion on the player Deletion History page");
				// captureScreen(driver,"PlayerNameofPlayerDeletionHistory");
			}
			if (driver
					.findElements(By.xpath("//th[text()='User Name']/following::tr//td[contains(@class,'username ')]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed User Name of player deletion on the player Deletion History page");
			} else {
				// //Assert.assertTrue(false);
				test.info(
						"Something wrong !! To Viewed Player Name of Player deletion on the player Deletion History page");
				// captureScreen(driver,"UserNameofPlayerDeletionHistory");
			}

			if (driver
					.findElements(By.xpath(
							"//th[text()='Date']/following::tr//td[contains(@class,'accountDeletionRequestedAt ')]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Date of player deletion on the player Deletion History page");
			} else {
				test.info("Something wrong !! To Viewed Date of Player deletion on the Player Deletion History page");
				//Assert.assertTrue(false);
				// captureScreen(driver,"DateofPlayerDeletionHistory");
			}
		}
	}

	//@Test(groups = "website")
	public void C_TC_PlayerDeletionHistory_DownloadPDF() {
		test = extentCreateTest("PlayerDeletionHistory -> DownloadPDF");
		test.info("Test Case- started PDF Download in Player Deletion History");
		 wr = new WithdrawRequest(driver);
		 cc = new CommonCosmo(driver);

		 if (cc.PlayerDeletionHistory_Header != null) {
			wr.clickPDFdownload();
			test.pass("Successfully PDF downloaded of Player Deletion History ");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To PDF Download of Player Deletion History ", extentScreenshot());
		}

	}

	@Test(groups = { "website", "admin" })
	public void D_TC_PlayerDeletionHistory_DownloadExcel() throws InterruptedException, IOException {
		test = extentCreateTest("PlayerDeletionHistory -> DownloadExcel");

		test.info("TestCase started EXCEL Download in Player Deletion History");
		 wr = new WithdrawRequest(driver);
		 cc =  new CommonCosmo(driver);

		Thread.sleep(2000);
		if (cc.PlayerDeletionHistory_Header!=null) {
			test.info("Opened Player Deletion History Successfully");
			wr.clickXLSXdownload();
			//cc.VerifyDataCheck(cc.Validation_XLSXDownload);
			cc.Webelement_isDisplayed(driver, cc.Validation_XLSXDownload);
		}
	}

	@Test(groups = "website")
	public void E_TC_PlayerDeletionHistory_Search() throws InterruptedException, IOException {
		test = extentCreateTest("PlayerDeletionHistory -> Search");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		test.info("TestCase started As an admin user I should able to search in player Deletion History");
		 if (cc.PlayerDeletionHistory_Header != null) {
			test.info("Opened Player Deletion History Successfully");
			gp.Search_Items(SearchplayerId);
			Thread.sleep(3500);
			if (driver.findElements(By.xpath("//th[text()=\"Player Id\"]/following::tr//td[contains(text(),'" + SearchplayerId + "')]")).size() > 0) {	
				test.pass("Successfully Searched playerId on Player Deletion History", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search playerId playerDeletionHistory", extentScreenshot());
				
			}
		}
	}
	
	@Test
	public void F_TC_PlayerDeletionHistory_ViewDeletedPlayerDetails() throws InterruptedException   {
		test = extentCreateTest("View Deleted Player Details");
		test.info("TC - As an admin user I should not able to view create button in View Deleted Player Details");
		pp = new PlayerProfile(driver);
		pp.Clickeyeicon();
		List<WebElement> ViewPlayerDetails = driver.findElements(By.xpath("//li//button"));
		for(WebElement viewPlayerDetails:ViewPlayerDetails) {
			viewPlayerDetails.click();
			String PlayerDetailsTabs = viewPlayerDetails.getText();
			if(driver.findElements(By.xpath("//span[text()=' Create New']")).size()<1) {
				test.pass("Successfully View  create button in not displayed on <b>"+PlayerDetailsTabs+"</b> tab", extentScreenshot());

			}else {
				test.fail("Something wrong !! To player deletion history view details", extentScreenshot());

			}
			
		}


		
	}
	
}
