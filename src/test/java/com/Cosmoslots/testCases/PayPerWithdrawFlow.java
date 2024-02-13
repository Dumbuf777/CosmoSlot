/**
 * 
 */
package com.Cosmoslots.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.ColumnSelectors;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class PayPerWithdrawFlow extends BaseClass {
	
	BaseClass bc = new BaseClass();
	private PlayerProfile pp;
	private WithdrawRequest wr;
	private CommonCosmo cc;
	private GuestPlayers gp;
	private CosmoWebsite cw;

	
	@Test
	public void A_TC_PlayerWithdarwRequestStatus() throws InterruptedException {
		test = extentCreateTest("withdarw request status");
		test.info("As admin I should be able to verify withdraw request status in player profile details");
		
		pp = new PlayerProfile(driver);
		pp.GoToPlayerProfileView(bc.Playerid);
		pp.clickWithdrawRequestTab();
		if(driver.findElement(By.xpath(ColumnSelectors.PaperTransactionStatus.getColumnValues())).isDisplayed()) {
			test.pass("Successfully verified withdarw request status in player profile details",extentScreenshot());
		}else{
			test.fail("Something wrong !! To verify withdraw request status in player profile details", extentScreenshot());
		}
		
	}
	
	@Test
	public void B_TC_PlayerViewWithdrawRequestDetails() throws InterruptedException {
		test = extentCreateTest("View Withdraw Request Details");
		test.info("As admin I should be able to verify payement method and status in view withdraw request details in player profile details");
		gp = new GuestPlayers(driver);
		wr = new WithdrawRequest(driver);
		cc = new CommonCosmo(driver);
		if (cc.WithdrawRequests_Header != null) {
			test.info("Opened Withdraw Request");
			wr.clickActioneyeicon();
			Thread.sleep(1500);
			if (wr.ViewWithdrawRequestDetails_Header != null) {
				test.info("Already Opened withdraw Listing screen");
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
	public void C_TC_PlayerWalletWithdrawRequestDetails() {
		
		test = extentCreateTest("Wallet withdarw request status");
		test.info("As admin I should be able to verify wallet withdraw request status in player profile details");
		
		pp = new PlayerProfile(driver);
		pp.clickonWallet();
		if(driver.findElement(By.xpath("(//td[text()='PayPer']//following::td[contains(.,'Success')])[1]")).isDisplayed()) {
			test.pass("Successfully verified withdarw request status in player profile details",extentScreenshot());
		}else{
			test.fail("Something wrong !! To verify withdraw request status in player profile details", extentScreenshot());
		}
	}
	
	@Test
	public void D_TC_PlayerViewWithdrawRequestDetails() throws InterruptedException {
		
		test = extentCreateTest("View Wallet withdarw details");
		test.info("As admin I should be able to verify wallet status in view withdraw request details in player profile details");
		wr = new WithdrawRequest(driver);
		wr.clickActioneyeicon();
		Thread.sleep(1500);
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
		
	}
	
}
