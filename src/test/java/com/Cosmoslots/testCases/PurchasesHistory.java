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
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.utilities.BaseClass;

public class PurchasesHistory extends BaseClass {
	BaseClass bc = new BaseClass();
	String SearchItem = "shrikrushna sonkar";

	private PlayerProfile pp;
	private WithdrawRequest wr;
	private CommonCosmo cc;
	private GuestPlayers gp;
	private PurchaseHistory ph;

	@Test
	public void A_TC_PurchaseHistory_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("PurchaseHistory -> Redirect");
		test.info(
				"TC - As an admin user I should able to view Purchase History screen by clicking on Players Management link");
		pp = new PlayerProfile(driver);
		ph = new PurchaseHistory(driver);
		cc = new CommonCosmo(driver);
		pp.clickOnPlayerManagement();
		test.info("Clicked on Player Management");
		ph.clickPurchaseHistory();
		cc.VerifyDataCheck(cc.PurchaseHistory_Header);
	}

	@Test
	public void B_TC_PurchaseHistory_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("PurchaseHistory -> View List");
		test.info("TC - As an admin user I should able to view list of the Purchase History");
		cc = new CommonCosmo(driver);

		if (cc.PurchaseHistory_Header != null) {
			test.info("Already Opened Purchase History screen");
			List<WebElement> ViewPurchaseHistoryHeaders = driver.findElements(By.xpath("//tr//th"));
			for (WebElement viewPurchaseHistoryHeaders : ViewPurchaseHistoryHeaders) {
				String PurchaseHistoryHeaders = viewPurchaseHistoryHeaders.getText();
				test = extentCreateTest("Purchase History  -> View list " + PurchaseHistoryHeaders + " Field");
				if (driver.findElement(By.xpath("//th[text()='" + PurchaseHistoryHeaders + "']"))
						.isDisplayed() == true) {
					test.pass("Successfully Viewed <b>" + PurchaseHistoryHeaders
							+ "</b> on the purchase history listing page", extentScreenshot());
				} else {
					test.fail("Something wrong !! To Purchase History view list details", extentScreenshot());
				}
			}
		} else {
			test.fail("Something wrong!To Open urchase History", extentScreenshot());
		}

	}

	@Test
	public void C_TC_PurchaseHistory_Search() throws InterruptedException, IOException {
		test = extentCreateTest("PurchaseHistory Search");
		test.info("TestCase started As an admin user I should able to search in Purchase History");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);

		if (cc.PurchaseHistory_Header != null) {
			test.info("Opened Purchase History Successfully");
			gp.Search_Items(SearchItem);
			Thread.sleep(2000);
			List<WebElement> listOfToggle = driver.findElements(By.xpath("//span[@class='mat-radio-label-content']"));
			for (WebElement ListOfToggle : listOfToggle) {
				ListOfToggle.click();
				String paymentTypes = ListOfToggle.getText();
				if (driver.findElements(By.xpath("(//td[contains(.,'" + SearchItem + "')])[1]")).size() > 0) {
					test.pass("Successfully searched <b> " + paymentTypes + "</b> in purchase history",
							extentScreenshot());
				} else {
					test.fail("Something wrong !! To Search PurchaseHistory", extentScreenshot());
				}
			}
			gp.clearsearch();
		} else {
			test.fail("Something wrong!To Open urchase History", extentScreenshot());
		}
	}

	@Test
	public void D_TC_PurchaseHistory_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("PurchaseHistory ActionView");
		test.info("TC - As an admin user I should able to View (Actionview)(Eyeicon) in Purchase History");

		pp = new PlayerProfile(driver);
		ph = new PurchaseHistory(driver);
		cc = new CommonCosmo(driver);
		wr = new WithdrawRequest(driver);
		pp.clickOnPlayerManagement();
		ph.clickPurchaseHistory();
		ph.ClickonpaymentRadioBtn();
		if (cc.PurchaseHistory_Header != null) {
			test.info("Opened purchase history");
			wr.clickActioneyeicon();
			Thread.sleep(1500);
			if (ph.ViewPurchasedDetails_Header != null) {
				test.info("Already Opened purchase details");
				List<WebElement> ViewPurchasedDetails = driver
						.findElements(By.xpath("//div[@class='table-wrapper']//tr//td[1]"));
				for (WebElement viewPurchasedDetails : ViewPurchasedDetails) {
					String PurchasedDetailHeaders = viewPurchasedDetails.getText();
					test.info("Purchase History -> View Details <b> "
							+ PurchasedDetailHeaders + "</b> ");
					if (driver.findElement(By.xpath("//td[text()='" + PurchasedDetailHeaders + "']"))
							.isDisplayed() == true) {
						test.pass("Successfully Viewed <b>" + PurchasedDetailHeaders
								+ "</b> on the view purchased details listing page", extentScreenshot());

					} else {
						test.fail("Something wrong !! To view purchased details", extentScreenshot());
					}
				}
			} else {
				test.fail("Something wrong!To Open purchase history", extentScreenshot());
			}
			gp.clickCloseActionView();
		}
	}

	@Test
	public void E_TC_PurchaseHistoryDownloadReciept() throws InterruptedException, IOException {
		test = extentCreateTest("Purchase History -> Download Reciept");
		test.info("TC - As an admin user I should be able to Download Reciept in PurchaseHistory Tab");
		cc = new CommonCosmo(driver);
		gp = new GuestPlayers(driver);

		if (cc.PurchaseHistory_Header != null) {
			test.info("Successfully Redirected to PurchaseHistoryTab");
			test.info("Testing Download Reciept in PurchaseHistoryTab");
			driver.findElement(By.xpath("//button[@title=\"Download Receipt\"]")).click();
			Thread.sleep(1500);
			test.pass("Successfully Downloaded Reciept", extentScreenshot());
			driver.findElement(By.xpath("//span[text()=\" Download PDF\"]")).click();
			Thread.sleep(2200);
			gp.clickCloseActionView();
			Thread.sleep(800);
		} else {
			test.fail("not able to Downloaded Reciept", extentScreenshot());

		}
	}

	@Test()
	public void F_TC_PurchaseHistory_XLSXDownload() throws InterruptedException, IOException {
		test = extentCreateTest("Purchase History -> Download EXCEL");
		test.info("TC - EXCEL Download in Purchase History");
		cc = new CommonCosmo(driver);
		pp = new PlayerProfile(driver);
		Thread.sleep(2000);
		if (cc.PurchaseHistory_Header != null) {
			test.info("Opened Withdraw Request Successfully");
			pp.clickXlsxButton();
			if (cc.Validation_XLSXDownload.isDisplayed() || cc.Validation_XLSXDownload1.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else if (cc.Validation_XLSXDownload1.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}
		}
	}

	@Test
	private void Fa_TC_PurchaseHistory_AccessClaimedTransactions() throws InterruptedException {
		test = extentCreateTest("Purchase History -> Claimed Transactions");
		test.info("TC - As an Admin I must be able to access the claimed history records");
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		wr = new WithdrawRequest(driver);

		if (cc.PurchaseHistory_Header != null) {
			test.info("Opened Purchase History Successfully");
			gp.Search_Items("WA-730");
			Thread.sleep(2000);
			if (cc.PurchaseHistory_Header != null) {
				test.info("Opened purchase history");
				wr.clickActioneyeicon();
				Thread.sleep(1500);
				if (ph.ViewPurchasedDetails_Header != null) {
					test.info("Already Opened purchase details");
					List<WebElement> ViewPurchasedDetails = driver.findElements(By.xpath("//div[@class='table-responsive']//tr//th"));
					for (WebElement viewPurchasedDetails : ViewPurchasedDetails) {
						String PurchasedDetailHeaders = viewPurchasedDetails.getText();
						test = extentCreateTest("Purchase history  -> View claimed transaction  Details <b> "+ PurchasedDetailHeaders + "</b> ");
						if (driver.findElement(By.xpath("//th[text()='" + PurchasedDetailHeaders + "']"))
								.isDisplayed() == true) {
							test.pass("Successfully Viewed <b>" + PurchasedDetailHeaders+ "</b> on the claimed history records", extentScreenshot());

						} else {
							test.fail("Something wrong !! To view purchased details", extentScreenshot());
						}
					}
				} else {
					test.fail("Something wrong!To Open purchase history", extentScreenshot());
				}
				gp.clickCloseActionView();
			}

		}
	}

}
