package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.ENUM.ColumnSelectors;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.model.Report;

public class WithdrawRequests extends BaseClass {
	BaseClass bc = new BaseClass();
	private PlayerProfile pp;
	private WithdrawRequest wr;
	private CommonCosmo cc;
	private GuestPlayers gp;
	private CosmoWebsite cw;
	String SearchPlayer = "CS-2830";
	String[] paymentMethod = { "skrill", "bank_account", "cashapp", "wallet", "seamless_chex", "manual", "PAYPER",};// "PAYPER",


	
	
	@Test
	public void A_TC_WithdrawRequest_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> Redirect");
		test.info("TC - As an admin user I should able to redirect on withdraw requests page");
		pp = new PlayerProfile(driver);
		wr = new WithdrawRequest(driver);
		cc = new CommonCosmo(driver);

		pp.clickOnPlayerManagement();
		wr.clickwithdrawrequest();
		cc.VerifyDataCheck(cc.WithdrawRequests_Header);
	}

	@Test
	public void B_TC_WithdrawRequest_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> ViewList");
		test.info("TC - As an admin user I should able to view list of the Withdraw Requests");

		cc = new CommonCosmo(driver);
		if (cc.WithdrawRequests_Header != null) {
			test.info("Already Opened Players Listing screen");
			List<WebElement> ViewWithdrawRequestsHeaders = driver.findElements(By.xpath("//tr//th"));
			for (WebElement viewWithdrawRequestsHeaders : ViewWithdrawRequestsHeaders) {
				String WithdrawRequestsHeaders = viewWithdrawRequestsHeaders.getText();
				test.info("Withdraw request  -> View list " + WithdrawRequestsHeaders + " Field");
				if (driver.findElement(By.xpath("//th[text()='" + WithdrawRequestsHeaders + "']"))
						.isDisplayed() == true) {
					test.pass("Successfully Viewed <b>" + WithdrawRequestsHeaders
							+ "</b> on the withdraw request listing page", extentScreenshot());

				} else {
					test.fail("Something wrong !! To Withdraw Requests view details", extentScreenshot());

				}
			}
		} else {
			test.fail("Something wrong!To Open Withdraw Requests", extentScreenshot());
		}

	}

	@Test
	public void C_TC_WithdrawRequest_Search() throws InterruptedException, IOException {
		String SearchItem = "Skrill";
		test = extentCreateTest("WithdrawRequest -> Search");
		test.info("TC - As an admin user I should able to search in withdrawal request");
		gp = new GuestPlayers(driver);

		if (cc.WithdrawRequests_Header != null) {
			test.info("Opened Withdraw Request Successfully");
			gp.Search_Items(SearchItem);
			Thread.sleep(2000);
			if (driver
					.findElements(By.xpath(
							"//th[text()=\"Player Name\"]/following::tr//td[contains(text(),'" + SearchItem + "')]"))
					.size() > 0) {
				test.pass("Successfully Searched Item viewed", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search Item", extentScreenshot());
			}
			driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
		}
	}

	@Test
	public void D_TC_WithdrawRequest_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> ActionView");
		test.info("TestCase started As an admin user I should able to View (Actionview)(Eyeicon) ");
		gp = new GuestPlayers(driver);
		wr = new WithdrawRequest(driver);
		if (cc.WithdrawRequests_Header != null) {
			test.info("Opened Withdraw Request");
			wr.clickActioneyeicon();
			Thread.sleep(1500);
			if (wr.ViewWithdrawRequestDetails_Header != null) {
				test.info("Already Opened Players Listing screen");
				List<WebElement> ViewWithdrawRequestDetails = driver
						.findElements(By.xpath("//div[@class='table-wrapper']//tr//td[1]"));
				for (WebElement viewWithdrawRequestsHeaders : ViewWithdrawRequestDetails) {
					String WithdrawRequestsHeaders = viewWithdrawRequestsHeaders.getText();
					test.info("Withdraw request  -> View Withdraw Request Details <b> " + WithdrawRequestsHeaders
							+ "</b> ");
					if (driver.findElement(By.xpath("//td[text()='" + WithdrawRequestsHeaders + "']"))
							.isDisplayed() == true) {
						test.pass("Successfully Viewed <b>" + WithdrawRequestsHeaders
								+ "</b> on the view withdraw request details listing page", extentScreenshot());

					} else {
						test.fail("Something wrong !! To Withdraw Requests view details", extentScreenshot());
					}
				}
			} else {
				test.fail("Something wrong!To Open Withdraw Requests", extentScreenshot());
			}

			Thread.sleep(500);
			gp.clickCloseActionView();
		}
	}

	@Test
	public void E_TC_WithdrawRequestCreateNew() throws InterruptedException, IOException {
		for (String pm : paymentMethod) {
			test = extentCreateTest("Admin Withdraw Request -> using " + pm);
			test.info("TC - As an admin user I should be able to Create New Withraw Request -> " + pm);
			gp = new GuestPlayers(driver);
			wr = new WithdrawRequest(driver);
			cc = new CommonCosmo(driver);
			if (cc.WithdrawRequests_Header != null) {
				test.info("Successfully Redirected to Withdraw Request");
				test.info("Testing Action View in WithdrawRequestTab CreateNew");
				wr.clickOnWithdrawRequest_CreateNew();
				if (cc.CreateWithdrawRequest_Header.isDisplayed()) {
					wr.slectPlayer();
					Thread.sleep(3000);
					gp.Search_Items(SearchPlayer);
					Thread.sleep(2000);
					wr.slectCheckBox();
					Thread.sleep(3000);
					wr.setCurrentWithdrawalAmount("1");
					wr.setWithdraw_tipTokens("0");
					wr.AdminWithdrawRequestUsing_PaymentMethod(pm);
					Thread.sleep(4000);
					if (ColumnSelectors.Status_Pending.getColumnValues() != null
							|| ColumnSelectors.Status_Success.getColumnValues() != null) {
						test.pass("Successfully Created Withdraw Request with showing - \"Success\" status",
								extentScreenshot());
						wr.approveWithdrawRequest();
					} else {
						test.fail("Something wrong to create withdraw request", extentScreenshot());
					}
				}
			}
		}
	}

	@Test
	public void F_WithdrawRequest_Excel() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> Download Excel");
		test.info("TC - As an admin user I should be able to Download EXCEL in Withdraw Requests");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		if (cc.WithdrawRequests_Header != null) {
			test.info("Successfully Redirected to WithdrawRequest");
			test.info("Testing XLSX Download in WithdrawRequest");
			pp.clickXlsxButton();
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else if (cc.Validation_XLSXDownload1.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else if (driver
					.findElements(By
							.xpath("//span[text()=\"Multiple request. Please wait while we process your requests\"])"))
					.size() > 0) {
				test.pass("Successfully XLSX Requested");
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}
		}
	}

	@Test
	public void G_TC_PlayerWithdrawAmount_UsingPaymentMethod() throws InterruptedException {
		//String[] paymentMethod = { "skrill", "bank_account", "cashapp", "wallet", "seamless_chex", "manual", };// "PAYPER",
		for (String pm : paymentMethod) {
			test = extentCreateTest("Website Withdraw Amount -> using " + pm);
			test.info("TC- As a player I should able to  the withdraw Amount in website " + pm);
			wr = new WithdrawRequest(driver);
			cc = new CommonCosmo(driver);
			cw = new CosmoWebsite(driver);
			bc.gotoTab(driver, 1);
			cw.ClickOnPlayerProfile();
			cw.ClickOnWithdraw();
			cw.ClickOnWithdrawAmount();
			wr.setCurrentWithdrawalAmount("1");
			wr.setWithdraw_tipTokens("0");
			cw.PlayerWithdrawAmountUsingPaymentMethod(pm);
			if (ColumnSelectors.Status_Pending.getColumnValues() != null
					|| ColumnSelectors.Status_Success.getColumnValues() != null) {
				test.pass("Successfully created withdraw amount request in website using " + pm, extentScreenshot());
			} else {
				test.fail("Something wrong to create withdraw request", extentScreenshot());
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
	public void F_TC_WithdrawRequestApprove() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> Request Approve/Decline");
		test.info("TC - As an admin user I should be able to Approve / Decline  Withraw Request WithdrawRequest");
		pp = new PlayerProfile(driver);
		cc = new CommonCosmo(driver);

		if (cc.WithdrawRequests_Header != null) {
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//tr/td[contains(text(),'" + SearchPlayer
					+ "')]/following-sibling::td/span[text()=\" Pending\"]/parent::td/following-sibling::td//button[@title=\"Description\"])[1]"))
					.click();

			if (driver.findElement(By.xpath("//span[text()=\"Player Name\"]/following-sibling::span[contains(text(),'"
					+ SearchPlayer + "')]")) != null) {
				pp.selectwithrawrequest(" Approve ");
				driver.findElement(By.xpath("//textarea[@formcontrolname=\"updatedNotes\"]")).sendKeys("By Auto");
				driver.findElement(By.xpath("//span[text()=\"Update\"]")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
				test.pass("Successfully approved withraw request", extentScreenshot());
			} else {
				test.fail("Something wrong to select withraw request");
				// Assert.assertTrue(false);
			}
			Thread.sleep(2000);
		} else {
			// Assert.assertTrue(false);
		}
	}

//	@Test
	public void G_TC_WithdrawRequestCreateNewAdminSkrill() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> Create New -> Skrill");
		test.info("TC - As an admin user I should be able to Create New Withraw Request -> Skrill");
		gp = new GuestPlayers(driver);
		wr = new WithdrawRequest(driver);

		if (cc.WithdrawRequests_Header != null) {
			Thread.sleep(3000);

			test.info("Successfully Redirected to Withdraw Request");
			test.info("Testing Action View in WithdrawRequestTab CreateNew");
			wr.clickOnWithdrawRequest_CreateNew();
			if (cc.CreateWithdrawRequest_Header.isDisplayed()) {
				wr.slectPlayer();
				Thread.sleep(4000);
				gp.Search_Items(SearchPlayer);
				Thread.sleep(2000);
				wr.slectCheckBox();
				Thread.sleep(3000);
				wr.setCurrentWithdrawalAmount("1");
				wr.setWithdraw_tipTokens("0");
				wr.AdminWithdrawRequestUsing_PaymentMethod("skrill");

				Thread.sleep(4000);
				if (ColumnSelectors.Status_Pending.getColumnValues() != null
						|| ColumnSelectors.Status_Success.getColumnValues() != null) {
					test.pass("Successfully Created Withdraw Request with showing - \"Success\" status",
							extentScreenshot());
				} else {
					test.fail("Something wrong to create withdraw request", extentScreenshot());
				}
			}
		}
	}
	

	public void J_TC_WithdrawRequestCreateNewAdminCashApp() throws InterruptedException, IOException {
		String cashappid = "itsupport@ombpmllp.com";
		test = extentCreateTest("WithdrawRequest -> Create New -> CashApp");
		String SearchItemWithdrawRequest = "Bank Account";
		test.info(
				"TestCase started As an admin user I should be able to Create New Withraw Request in WithdrawRequest");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		if (cc.WithdrawRequests_Header != null) {
			Thread.sleep(6000);
			// pp.clickPurchaseHistoryTab();
			// Thread.sleep(1000);
			// Assert.assertTrue(true);
			test.info("Successfully Redirected to WithdrawRequestTab");
			test.info("Testing Action View in WithdrawRequestTab CreateNew");
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			driver.findElement(By.xpath("//button[@title='Create New']")).click();
			Thread.sleep(1000);
			// if(SearchItem.equalsIgnoreCase(SearchItem))
			if (driver.findElement(By.xpath("//h3[text()=\"Create Withdraw Request\"]")).isDisplayed()) {
				driver.findElement(By.xpath("//button[text()=\"Select Player\"]")).click();
				Thread.sleep(4000);
				gp.Search_Items(SearchPlayer);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//mat-checkbox[contains(@class,\"pristine\")])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@formcontrolname=\"currentWithdrawalAmount\"]")).sendKeys("1");
				driver.findElement(By.xpath("//input[@formcontrolname=\"tipTokens\"]")).sendKeys("0");

				driver.findElement(By.xpath("//span[text()=\" Cash App \"]")).click();
				driver.findElement(By.xpath("//input[@formcontrolname=\"cashAppId\"]")).sendKeys(cashappid);
				Thread.sleep(300);
				pp.ClickSave();
				Thread.sleep(4000);

				if (driver.findElement(By.xpath("(//span[contains(text(),' Pending')])[1]")) != null
						&& driver.findElement(By.xpath("(//td[contains(text(),'" + SearchPlayer + "')])[1]")) != null
						&& driver.findElement(By.xpath("(//td[contains(text(),' Cash App')])[1]")) != null) {
					// pp.clickCloseActionView();
					test.pass("Successfully Created Withdraw Request with CashAppId - Status \"Pending\" Details");
					Assert.assertTrue(true);
				} else {
					test.fail("Something wrong to create withdraw request");
					Assert.assertTrue(false);
				}
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To Viewed Withdraw Request Details !! Taking Too Much Time");
				captureScreen(driver, "FailedViewedWithdrawRequestDetails");
			}

			Thread.sleep(1000);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void Ka_TC_withdrawPlayer_skrill() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);
		test = extentCreateTest("Website - WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the withdraw Amount in website");
		String status = "";
		String actualStatus = "Success";
		bc.gotoTab(driver, 1);
		wr.clickOnUser();
		Thread.sleep(2000);
		cw.ClickOnWithdraw();
		Thread.sleep(2000);
		cw.ClickOnWithdrawAmount();
		Thread.sleep(2000);
		wr.CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		wr.Skrill_PaymentMode_web.click();
		Thread.sleep(1000);
		wr.WithdrawBtn.click();
		Thread.sleep(5000);
		// wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Success\")])[1]"));
		String es = exceptedStatus.getText();
		if (exceptedStatus.isDisplayed()) {
			test.pass("Successfully showing - success status in withdraw request by player" + es, extentScreenshot());
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("success status not showing in withdraw request by player", extentScreenshot());
		}
	}


	public void Kb_TC_withdrawPlayer_Bank() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website - WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the withdraw Amount in website");

		String status = "";
		String actualStatus = "Success";
		// test = extentCreateTest("WithdrawRequest -> Request Status");
		// bc.gotoTab(driver, 1);
		// wr.clickOnUser();
		// wr.clickOnWithdraw_MainTab_web();
		Thread.sleep(2000);
		wr.clickwithdrawAmount();
		Thread.sleep(2000);
		wr.CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		wr.BankAcocunt_PaymentMode_web.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"accountHolderName\"]")).sendKeys("Samrat Patil");
		driver.findElement(By.xpath("//input[@formcontrolname=\"accountNumber\"]")).sendKeys("4887464648");
		driver.findElement(By.xpath("//input[@formcontrolname=\"routingNumber\"]")).sendKeys("312");
		driver.findElement(By.xpath("//input[@formcontrolname=\"bankName\"]")).sendKeys("DenaBank");
		Thread.sleep(300);
		wr.WithdrawBtn.click();
		Thread.sleep(3000);
		// wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();

		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}
	}


	public void Kc_TC_withdrawPlayer_CashApp() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website - WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the withdraw Amount in website");
		String status = "";
		String actualStatus = "Success";
		// test = extentCreateTest("WithdrawRequest -> Request Status");
		// bc.gotoTab(driver, 1);
		// wr.clickOnUser();
		wr.clickOnWithdraw_MainTab_web();
		Thread.sleep(2000);
		wr.clickwithdrawAmount();
		Thread.sleep(2000);
		wr.CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		wr.CashApp_PaymentMode_web.click();
		Thread.sleep(1000);
		wr.WithdrawBtn.click();
		// wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();
		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}

	}


	public void Kd_TC_withdrawPlayer_seamless() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website -  Withdraw Request");
		test.info("TestCase started - As an player I should able to  the withdraw Amount in website");
		String status = "";
		String actualStatus = "Success";

		wr.clickOnWithdraw_MainTab_web();
		Thread.sleep(2000);
		wr.clickwithdrawAmount();
		Thread.sleep(2000);
		wr.CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='seamless_chex']")).click();
		Thread.sleep(1000);
		wr.WithdrawBtn.click();

		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();
		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}

	}


	public void Ke_TC_withdrawPlayer_wallet() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website -  Withdraw Request");
		test.info("TestCase started - As an player I should able to  the withdraw Amount in website");
		String status = "";
		String actualStatus = "Success";

		wr.clickOnWithdraw_MainTab_web();
		Thread.sleep(2000);
		wr.clickwithdrawAmount();
		Thread.sleep(2000);
		wr.CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='wallet']")).click();
		Thread.sleep(1000);
		wr.WithdrawBtn.click();

		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();
		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}

	}

//	@Test
	public void Ha_TC_withdraw() throws InterruptedException, IOException {

		test = extentCreateTest("WithdrawRequest view");
		test.info("TestCase started - As an  user I should able to  the withdraw Amount");

		String status = "";
		String actualStatus = "Success";
		test = extentCreateTest("WithdrawRequest -> Request Status");

		bc.gotoTab(driver, 1);
		WithdrawRequest wr = new WithdrawRequest(driver);
		wr.clickOnUser();
		Thread.sleep(2000);
		wr.clickOnWithdraw_MainTab_web();
		Thread.sleep(2000);
		wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(
				By.xpath("//*[@id=\"nav-withdrawal\"]/app-withdrawal/div/div/div[2]/table/tbody/tr[1]/td[6]/span"));
		String es = exceptedStatus.getText();

		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			// Assert.assertTrue(true);
		} else {
			// Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}
		// Assert.assertEquals(actualStatus, exceptedStatus);
		// Reporter.log("Withdraw payment status is verified successfully");
	}
}
