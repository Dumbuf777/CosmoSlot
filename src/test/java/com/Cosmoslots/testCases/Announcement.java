package com.Cosmoslots.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;

import com.Cosmoslots.utilities.BaseClass;

public class Announcement extends BaseClass {

	String Upload_Icon = UploadImage;
	String SearchItem = Constant.AnnouncementTitle;

	@Test
	public void A_TC_Announcement_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("Announcement -> Viewscreen");
		test.info("TestCase started - As an admin user I should able to view Announcement screen  ");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div//following::i[@class='ri-more-fill']")).click();
		test.info("Clicked on More link");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[normalize-space()='Alerts']")).click();
		test.info("Clicked on  Alerts");
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Announcements']")).click();
		test.info("Clicked on  Announcements");
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[text()=\"Announcements\"]")) != null) {
			test.info("Successfully Opened Announcement screen");
			// Assert.assertTrue(true);
		} else {
			test.info("Something wrong!To Open Announcement screen");
			// Assert.assertTrue(false);
		}
	}

	@Test(groups = "admin")
	public void B_TC_Announcement_Add() throws IOException, InterruptedException {
		LobbyPage_Old lb = new LobbyPage_Old(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		test = extentCreateTest("Add Announcement");

		test.info("TestCase started   - Add Announcement");

		Thread.sleep(1000);
		lb.clickToCreate();
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//h3[text()=\"Create Announcement\"]")) != null) {
			lb.SetNewsicon(Upload_Icon);
			Thread.sleep(1000);
			lb.description.sendKeys("This is Create announcement");
			driver.findElement(By.xpath("//input[@formcontrolname=\"title\"]")).sendKeys(Constant.AnnouncementTitle);
			lb.SelectStoreAccount_Announcement("CosmoSlot");
			test.info("Store account selected is ->" + "Cosmoslot");
			Thread.sleep(1000);
			lb.Select_AnnouncementCategory_Announcement("Game Update");
			up.AC_Save();
			test.info("Announcement Detail saved successfully", extentScreenshot());
			cc.VerifyDataCheck(cc.Validation_AnnouncementDataSaveSuccessfully);
			Thread.sleep(500);
			if (cc.Validation_AnnouncementDataSaveSuccessfully.isDisplayed()==true) {
				Thread.sleep(3000);
				gp.Search_Items(Constant.AnnouncementTitle);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//td[contains(text(),'" + Constant.AnnouncementTitle + "')]//following::mat-slide-toggle[1]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
				Thread.sleep(3000);
				test.pass("Announcement save message return", extentScreenshot());
				VerifyAnnouncement_Website(Constant.AnnouncementTitle);
				BaseClass.gotoTab(driver, 0);

			} else {
				test.fail("Something Wrong ! not able to Announcement fetch save message", extentScreenshot());
				// Assert.assertTrue(false);
			}
		} else {
			test.fail("Not able to find Create Announcement", extentScreenshot());
		}
		Thread.sleep(2000);

	}

	public void VerifyAnnouncement_WebsiteNotification(String announce) throws InterruptedException, IOException {
		BaseClass.gotoTab(driver, 1);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a//em[@class=\"fa fa-bell\"])[1]")).click();

		// this click event on announcement is not working ->BUG
		if (driver.findElement(By.xpath("//h6[contains(text(),'" + announce + "')]")) != null) {
			test.pass("Find last added Announcement on Website ->" + announce, extentScreenshot());

			// click on announcement from website
			driver.findElement(By.xpath("//h6[contains(text(),'" + announce + "')]")).click();
			// test.fail("Redirect on announcement section to search
			// -><b>"+announce+"</b>",extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to find last added Announcement on Website", extentScreenshot());
		}
		Thread.sleep(5000);
	}

	public void VerifyAnnouncement_Website(String announce) throws InterruptedException, IOException {
		CosmoWebsite cw = new CosmoWebsite(driver);
		BaseClass.gotoTab(driver, 1);
		cw.ClickOnPlayerProfile();
		Thread.sleep(1000);
		cw.ClickOnAnnouncement();
		Thread.sleep(1000);

		if (driver.findElement(By.xpath("//td[contains(text(),'" + announce + "')]")) != null) {
			test.pass("Find last added Announcement on Website ->" + announce, extentScreenshot());

			if (driver.findElement(By.xpath(
					"//td[contains(text(),'" + announce + "')]//following::a[@class=\"action-icon\"][1]")) != null) {
				driver.findElement(
						By.xpath("//td[contains(text(),'" + announce + "')]//following::a[@class=\"action-icon\"][1]"))
						.click();
				Thread.sleep(500);

				if (driver.findElement(By.xpath("//span[contains(text(),'" + announce + "')]")) != null) {
					test.pass("Announcement details found in Website which is added by Admin ->" + announce,
							extentScreenshot());
					Thread.sleep(1000);
					driver.findElement(By.xpath("//button[@class=\"btn-close\"]")).click();
				} else {
					test.fail("Something Wrong ! Announcement details found in Website which is added by Admin",
							extentScreenshot());
				}
			} else {
				test.fail("Something Wrong ! Announcement view button not found", extentScreenshot());
			}
		} else {
			test.fail("Something Wrong ! not able to find last added Announcement on Website", extentScreenshot());
		}

	}

	@Test
	public void C_TC_Announcement_Search() throws InterruptedException, IOException {
		LobbyPage_Old lb = new LobbyPage_Old(driver);

		test = extentCreateTest("Announcement -> Search");

		test.info("TestCase started As an admin user I should able to search in withdrawal request");
		GuestPlayers gp = new GuestPlayers(driver);

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"Announcements\"]")) != null) {
			test.info("Opened Announcement Successfully");
			gp.Search_Items(SearchItem);

			Thread.sleep(2500);

			if (driver
					.findElement(By.xpath(
							"(//th[text()=\"Title\"]/following::tr//td[contains(@class,\"cdk-column-title\")])[1]"))
					.getText().equalsIgnoreCase(SearchItem)) {
				test.pass("Searched Announcement ->" + SearchItem, extentScreenshot());
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To Search Announcement", extentScreenshot());
				Assert.assertTrue(false);
				// captureScreen(driver,"FailedSearchWithdrawal");
			}
			gp.clearsearch();

		}
	}

	@Test
	public void D_TC_Announcement_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("Announcement -> View List");
		test.info("TestCase started - As an admin user I should able to view Announcement");
		PlayerProfile pp = new PlayerProfile(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		LobbyPage_Old lb = new LobbyPage_Old(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"Announcements\"]")) != null) {

			test.info("Already Opened Announcement screen");
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Title\"]/following::tr//td[contains(@class,\"cdk-column-title\")]"))
					.size() > 0) {
				test.info("Successfully Viewed Title on the Announcement page", extentScreenshot());
				Assert.assertTrue(true);

			} else {
				test.info("Something wrong !! To Viewed Title on the Announcement page", extentScreenshot());
				Assert.assertTrue(false);
				// captureScreen(driver,"DateofWithdrawal");
			}

			if (driver.findElements(By.xpath("//th[text()=\"Code\"]/following::tr//td[contains(@class,\"lobbycode\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.info("Successfully Viewed Store Code of Announcement on the Announcement page",
						extentScreenshot());
			} else {

				test.info("Something wrong !! To Viewed Store Code of Announcement on the Announcement page",
						extentScreenshot());
				Assert.assertTrue(false);
				// captureScreen(driver,"RequestIdofWithdrawal");
			}

			if (driver
					.findElements(
							By.xpath("//th[text()=\"Category\"]/following::tr//td[contains(@class,\"category\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.info("Successfully Viewed category of Announcement on the Announcement page", extentScreenshot());
			} else {
				Assert.assertTrue(false);
				test.info("Something wrong !! To Viewed category of Announcement on the Announcement page",
						extentScreenshot());
				// captureScreen(driver,"PlayerNameofsWithdrawal");
			}

			if (driver
					.findElements(
							By.xpath("//th[text()=\"Created At\"]/following::tr//td[contains(@class,\"createdAt\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.info("Successfully Viewed createdAt of Announcement on the Announcement page", extentScreenshot());
			} else {
				Assert.assertTrue(false);
				test.info("Something wrong !! To Viewed createdAt of Announcement on the Announcement page",
						extentScreenshot());
				// captureScreen(driver,"PaymentMethodofWithdrawal");
			}

		} else {
			test.info("Something wrong!To Open Announcement screen");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void E_TC_Announcement_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("Announcement -> Action View");
		test.info("TestCase started As an admin user I should able to View details ");
		LobbyPage_Old lp = new LobbyPage_Old(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// gp.clickGuestPlayersLink();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"Announcements\"]")) != null) {
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Title\"]/following::tr//td[contains(@class,\"cdk-column-title\")]"))
					.size() > 0) {
				test.info("Successfully Viewed Title on the Announcement page");
				// Assert.assertTrue(true);
				// driver.findElement(By.xpath("(//i[contains(@class,\"ri-eye-line\")])[1]")).click();
				lp.View_Click();
				Thread.sleep(2000);
				if (driver.findElement(By.xpath("//td[text()=\"Title\"]//following-sibling::td[1]")).getText()
						.equalsIgnoreCase(Constant.AnnouncementTitle)) {
					Assert.assertTrue(true);
					test.pass("Successfully Viewed <B>Title of Announcement</B>->" + Constant.AnnouncementTitle,
							extentScreenshot());
					Thread.sleep(1000);
					lp.ClickToClose();
				} else {
					test.fail("Something wrong !! To Viewed Title of Announcement on the view page",
							extentScreenshot());
					Assert.assertTrue(false);
					// captureScreen(driver,"PaymentMethodofWithdrawal");
				}

			} else {
				test.info("Something wrong !! To Viewed Title on the Announcement page");
				Assert.assertTrue(false);
				// captureScreen(driver,"DateofWithdrawal");
			}

		}

	}

	
	
	
	
	
	
	
	
	
	
	
//	@Test(priority=5)
//	public void TC_Announcement_PdfExcel() throws InterruptedException, IOException 
//	{
//		//String SearchItem="4250";
//		test.info("TestCase started PDF/EXCEL Download in Withdrawal request");
//		GuestPlayers gp=new GuestPlayers(driver);
//		Announcement wr=new Announcement(driver);
//		//Thread.sleep(4000);
//		//gp.clickPlayerManagement1Link();
//		//gp.clickGuestPlayersLink();
//		Thread.sleep(2000);
//		if(driver.findElement(By.xpath("//h3[text()=\"Announcement\"]"))!=null)
//		{
//			test.info("Opened Announcement Successfully");
//			wr.clickPDFdownload();
//			Thread.sleep(1500);
//			if(driver.findElement(By.xpath("")).getText().equalsIgnoreCase(""))
//			{
//				test.info("Successfully Download PDF for Withdrawal Request");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				Assert.assertTrue(false);
//				test.info("Something wrong !! To Download PDF");
//				captureScreen(driver,"FailedPDFDownload");
//			}	
//		}
//	}

}
