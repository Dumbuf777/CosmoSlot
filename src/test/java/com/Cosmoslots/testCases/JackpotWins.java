package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.utilities.BaseClass;

public class JackpotWins extends BaseClass {
	private PlayerProfile pp;
	private CommonCosmo cc;
	private GuestPlayers gp;

	@Test
	public void A_TC_JackpotWins_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("Jackpotwins -> Views creen");
		test.info("TC - As an admin user I should able to view JackpotWins screen by clicking on jackpotwins");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		pp.clickOnPlayerManagement();
		test.info("Clicked on Jackpot Wins");
		driver.findElement(By.xpath("//button[text()='Jackpot Wins']")).click();
		Thread.sleep(1500);
		if (cc.JackpotWins_Header != null) {
			test.pass("Successfully Opened Jackpot Wins screen", extentScreenshot());
		} else {
			test.fail("Something wrong!To Open Jackpot Wins screen", extentScreenshot());
		}
	}

	@Test
	public void B_TC_JackpotWins_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("Jackpotwins -> View List");
		test.info("TC - As an admin user I should able to view list of the Jackpot Wins");
		cc = new CommonCosmo(driver);
		if (cc.JackpotWins_Header != null) {

			test.info("Already Opened Jackpot Wins screen");
			List<WebElement> ViewJackpotwinsHeaders = driver.findElements(By.xpath("//tr//th"));
			for (WebElement viewJackpotwinsDetails : ViewJackpotwinsHeaders) {
				String JackpotwinsTabs = viewJackpotwinsDetails.getText();
				test = extentCreateTest("Jackpot Wins -> View " + JackpotwinsTabs + " Field");
				if (driver.findElement(By.xpath("//th[text()='" + JackpotwinsTabs + "']")).isDisplayed() == true) {
					test.pass("Successfully Viewed <b>" + JackpotwinsTabs + "</b> on the jacpot win listing page",extentScreenshot());
				} else {
					test.fail("Something wrong !! To view jackpot win details", extentScreenshot());
				}
			}
		} else {
			test.fail("Something wrong!To open jackpot wins screen", extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void C_TC_JackpotWins_Search() throws InterruptedException, IOException {
		test = extentCreateTest("Jackpotwins -> Search");
		String SearchItem = "Major Jackpot";
		test.info("TestCase started As an admin user I should able to search in withdrawal request");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);

		if (cc.JackpotWins_Header != null) {
			test.info("Opened Jackpot Wins successfully");
			gp.Search_Items(SearchItem);
			Thread.sleep(2500);
			if (driver.findElements(By.xpath("//td[contains(text(),'" + SearchItem + "')]")).size() > 0) {
				test.pass("Successfully Searched Item viewed", extentScreenshot());
				Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Search Item",extentScreenshot());
			}
			gp.clearsearch();
		}

	}

	@Test
	public void D_TC_JackpotWins_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("Jackpotwins ->Action view");
		test.info("TestCase started As an admin user I should able to View (Actionview)(Eyeicon) ");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);

		Thread.sleep(2000);
		if (cc.JackpotWins_Header != null) {
			test.info("Opened jackpot wins view ");
			wr.clickActioneyeicon();
			Thread.sleep(1500);
			if (driver.findElements(By.xpath("//h3[contains(text(),'View Jackpot Wins Details')]")).size() > 0) {
				test.pass("Successfully Searched Item viewed", extentScreenshot());
				Assert.assertTrue(true);
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Search Item",extentScreenshot());
			}
			gp.clickCloseActionView();
			Thread.sleep(2000);
			gp.clearsearch();
			
		}

	}

	@Test
	public void E_TC_JackpotWins_ExcelDownload() throws InterruptedException {
		test = extentCreateTest("Jackpotwins -> XLSX download");

		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		Thread.sleep(2000);
		if (cc.JackpotWins_Header != null) {
			pp.clickXlsxButton();
			if (cc.Validation_XLSXDownload.isDisplayed() == true) {
				test.pass("" + cc.Validation_XLSXDownload, extentScreenshot());
			} else if (cc.Validation_XLSXDownload1.isDisplayed() == true) {
				test.pass("" + cc.Validation_XLSXDownload1, extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to download XLSX of jacpot wins", extentScreenshot());
			}
		}
	}

}
