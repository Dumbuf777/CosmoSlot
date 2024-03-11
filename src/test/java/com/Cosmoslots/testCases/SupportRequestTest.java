package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.SupportManagement;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.utilities.BaseClass;


public class SupportRequestTest extends BaseClass
{
	BaseClass bc = new BaseClass();
	
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Usernm = Firstnm + Lastnm;
	String Email = bc.FakeEmail();
	String Phone = randomNum(10);
	String Upload_Icon = UploadImage;
	String packge = "NEW package";
	String SearchItemSupportRequest="GJTS-SR-1079";
	String SearchItemPlayerLedger="Deposit";
	String SearchItemTrancsationHistory="Bank";
	String SearchItemWithdrawRequest="GJTS-1105";
	String SearchItemPurchaseHistory="GJTS-1086";
	String SearchPlayer="Magritte";
	String Skrillid = "itsupport@ombpmllp.com";
	String cashappid = "itsupport@ombpmllp.com";
	
//	@Test
	public void A_loginTest_GF317_SupportRequest() throws IOException, InterruptedException 
	{
		test=extentCreateTest("Login TestCase started for Support Request");	
		test.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		//lp.ClickDontHaveZzure();
		lp.setUserName(username);
		test.info("Entered username = <b>"+username+"</b>");
		
		lp.setPassword(password);
		test.info("Entered password = <b>"+password+"</b>");
		
		Thread.sleep(1000);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if (driver.findElements(By.xpath("//span[text()=\"Player Management \"]")).size() > 0) {
			Assert.assertTrue(true);
			test.info("Login test passed for PlayerProfile");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			test.info("Login test failed for PlayerProfile");
		}
		test.info("Login TestCase Ended for PlayerProfile");	
	}
	
	@Test
	public void B_TC_SupportRequest_Search() throws InterruptedException, IOException 
	{
		String SearchItem="CS-1654";
		test=extentCreateTest("SupportRequest -> Search");
		test.info("TestCase started As an admin user I should be able to Search support request");
		GuestPlayers gp=new GuestPlayers(driver);
		PlayerProfile pp=new PlayerProfile(driver);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div//following::i[@class='ri-user-settings-line']")).click();
		//driver.findElement(By.xpath("//button[text()=\" Support Management\"]")).click();
		//driver.findElement(By.xpath("//button[text()=\"Support Request\"]")).click();
		
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//h3[text()=\"Support Management\"]"))!=null)
		{	
			test.info("Successfully redirect to Support Request Page");
			Thread.sleep(1000);
			//pp.clickSupportRequestTab();
			Thread.sleep(1000);
			//Assert.assertTrue(true);
			//test.info("Successfully Redirected to Support Request Tab");
			test.info("Started Search in SupportRequest");
			gp.Search_Items(SearchItem);
			Thread.sleep(1500);
			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			
			//if(SearchItem.equalsIgnoreCase(SearchItem))
			if(driver.findElements(By.xpath("//tr//td[contains(text(),'"+SearchItem+"')]")).size()>0)	
			{
				test.info("Successfully Searched Item viewed");
				Assert.assertTrue(true);
			}
			else
			{
				test.info("Something wrong !! To Search Item");
				captureScreen(driver,"FailedSearchInSupportRequestPage");
				Assert.assertTrue(false);
			}
			Thread.sleep(500);
			driver.findElement(By.xpath("//mat-icon[text()=\"clear \"]")).click();
		}
		else
		{
			Assert.assertTrue(false);
			captureScreen(driver,"SupportRequestPage");
		}
	}
//	@Test
//	public void C_TC_SupportRequestPDF() throws InterruptedException, IOException 
//	{
//		//String SearchItem="XYZY";
//		test=extentCreateTest("SupportRequest Download PDF");
//		test.info("TestCase started - As an admin user I should be able to Download PDF file in Support request");
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//		
//		//driver.findElement(By.xpath("//div[contains(@class,\"Active\")]")).click();
//		//driver.findElement(By.xpath("//button[text()=\" Support Management\"]")).click();
//		//driver.findElement(By.xpath("//button[text()=\"Support Request\"]")).click();
//		
//		//Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//h3[text()=\"Support Management\"]"))!=null)
//		{	
//			test.info("Successfully redirect to Support Request");
//			//pp.clickPurchaseHistoryTab();
//			//Thread.sleep(1000);
//			//test.info("Successfully Redirected to WithdrawRequestTab");
//			test.info("Testing PDF Download in SupportRequestTab");
//			pp.clickPdfButton();
//			Thread.sleep(1500);
//			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
//			
//			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//span[text()=\"File download successfully.\"]")).isDisplayed())	
//			{
//				test.info("Successfully PDF Downloaded");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				test.info("Something wrong !! To Download PDF");
//				captureScreen(driver,"FailedPDFDownloadSupportRequestPage");
//				Assert.assertTrue(false);
//			}	
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}
	
//	@Test
//	public void D_TC_SupportRequestXLSX() throws InterruptedException, IOException 
//	{
//		//String SearchItem="XYZY";
//		test=extentCreateTest("SupportRequest Download XLSX");
//		test.info("TestCase started As an admin user I should be able to Download EXCEL file in Support request");
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		CommonCosmo cc=new CommonCosmo(driver);
//
//		if(driver.findElement(By.xpath("//h3[text()=\"Support Management\"]"))!=null)
//		{	
//			Thread.sleep(1000);
//			//pp.clickPurchaseHistoryTab();
//			//Thread.sleep(1000);
//			//test.info("Successfully Redirected to TrancsationHistoryTab");
//			test.info("Testing XLSX Download in TrancsationHistoryTab");
//			WebDriverWait wait=new WebDriverWait(driver, 20);
//			
//			//test.info("Opened Player Successfully");
//			WebElement DownloadExcel;
//			DownloadExcel= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Export XLSX']")));
//
//			//pp.clickXlsxButton();
//			
//			DownloadExcel.click();
////			Thread.sleep(10000);
//			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
//			
//			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//span[text()=\"File download successfully.\"]")).isDisplayed())	
//			{
//				test.info("Successfully XLSX Downloaded");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				test.info("Something wrong !! To Download XLSX");
//				captureScreen(driver,"FailedXLSXDownloadSupportRequestTab");
//				Assert.assertTrue(false);
//			}	
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//	}
	//changes
	@Test
	public void E_TC_PlayerProfileTest_ActionViewTabsSupportRequestCreateNew() throws InterruptedException, IOException 
	{
		//String SearchItem="XYZY";
		test=extentCreateTest("SupportRequest -> Create Support Request");
		GuestPlayers gp=new GuestPlayers(driver);
		PlayerProfile pp=new PlayerProfile(driver);
		CommonCosmo cc=new CommonCosmo(driver);

		if(driver.findElement(By.xpath("//h3[text()=\"Support Management\"]"))!=null)
		{	
			Thread.sleep(1000);
			//pp.clickPurchaseHistoryTab();
			//Thread.sleep(1000);
			//test.info("Successfully Redirected to TrancsationHistoryTab");
			pp.clickCreateNewSupportRequest();
			Thread.sleep(500);
			pp.SetSupportRequestTitle("High latensy");
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"Select Player\"]")).click();
			Thread.sleep(4000);
			gp.Search_Items(SearchPlayer);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//mat-checkbox[contains(@class,\"pristine\")])[1]")).click();
			Thread.sleep(2000);
//			pp.clickSupportRequestPlayerName();
//			Thread.sleep(500);
//			pp.SetSupportRequestPlayerName("Eyeholes Bailey");
//			Thread.sleep(300);
			pp.clickSupportRequestPriority();
			Thread.sleep(500);
			pp.SetSupportRequestPriority("Low");
			Thread.sleep(500);
			pp.clickSupportRequestSupportType();
			Thread.sleep(500);
			pp.SetSupportRequestSupportType(" Issue");
			Thread.sleep(500);
			pp.setSupportRequestDescription("game is continously lagging");
			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.ClickSave();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//span[text()=\"Support request save successfully\"]")).isDisplayed())
			{
				test.info("successfully createed support request with validation message appeared - supportrRequest.save-sucess");
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			//if(SearchItem.equalsIgnoreCase(SearchItem))
			//pp.clickCloseActionView();
			Thread.sleep(1000);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void F_TC_SupportRequestAction() throws InterruptedException, IOException 
	{
		//String SearchItem="XYZY";
		test=extentCreateTest("SupportRequest Action view");
		test.info("TestCase started As an admin user, i should be able to view (Action) view -> support request");
		GuestPlayers gp=new GuestPlayers(driver);
		PlayerProfile pp=new PlayerProfile(driver);
		CommonCosmo cc=new CommonCosmo(driver);

		if(driver.findElement(By.xpath("//h3[text()=\"Support Management\"]"))!=null)
		{	
			Thread.sleep(1000);
			//pp.clickPurchaseHistoryTab();
			//Thread.sleep(1000);
			
			//test.info("Successfully Redirected to TrancsationHistoryTab");
			test.info("Testing Action View in SupportRequestTab");
			//String Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
			pp.clickSupportActioneyeicon();
			Thread.sleep(1500);
			
			if(driver.findElement(By.xpath("//span[text()=\"Details\"]")).isDisplayed())
			{
				pp.clickSupportRequestAssignTo();
				Thread.sleep(500);
				pp.SetSupportRequestAssignTo(" System AdmiN");
				Thread.sleep(300);
				test.info("Support Request AssignTo Selected");
				pp.clickSupportRequestStatus();
				Thread.sleep(500);
				pp.SetSupportRequestStatus("In Progress");
				Thread.sleep(500);
				test.info("Support Request Status Selected");
				pp.clickSupportRequestActionPriority();
				Thread.sleep(500);
				pp.SetSupportRequestActionPriority("Medium");
				Thread.sleep(500);
				//test.info("Support Request Action Priority Selected");
				driver.findElement(By.xpath("//input[@placeholder=\"Enter tag\"]")).sendKeys("Tags");
				driver.findElement(By.xpath("//textarea[@formcontrolname=\"note\"]")).sendKeys("By Auto");
				Thread.sleep(1000);
				gp.ClickSave();
				Thread.sleep(2000);
				
				if(driver.findElement(By.xpath("//span[text()=\"Notes save successfully\"]"))!=null)
				{
					test.pass("Message got - Notes Save Successfully");
				}
				else
				{
					test.fail("Not working");
				}
			}
			else
			{
				Assert.assertTrue(false);
				test.info("Failed To Redirect Support Request Action");
			}
			
			
			//if(SearchItem.equalsIgnoreCase(SearchItem))
//			if(driver.findElement(By.xpath("//h3[text()=\"View Purchased Details\"]")).isDisplayed())	
//			{
//				test.info("Successfully Viewed Trancsation History Details");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				test.info("Something wrong !! To Viewed Support Request Details !! Taking Too Much Time");
//				captureScreen(driver,"FailedViewedSupportRequestDetailsTab");
//				Assert.assertTrue(false);
//			}
			//pp.clickCloseActionView();
			Thread.sleep(500);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
			
			
		}
	
	@Test
	public void Fa_TC_SupportRequestAction() throws InterruptedException, IOException
	{
		test = extentCreateTest("SupportRequest view");
		test.info("TestCase started - As an  user I should able to view list of the Support Request");

		bc.gotoTab(driver, 1);
		SupportManagement sp = new SupportManagement(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		wr.clickOnUser();
		Thread.sleep(1000);
		sp.clickOnSupport_MainTab_web();
		Thread.sleep(1000);
		sp.selectSupporttype();
		Thread.sleep(3000);
		// sp.verifyNewTicketId();

		if (driver.findElement(By.xpath("(//th[text()=\"Ticket ID\"]//following::tr//td[2])[1]")) != null) {
			Assert.assertTrue(true);
			test.pass("Support TicketID test passed for support request", extentScreenshot());
			String str = driver.findElement(By.xpath("(//th[text()=\"Ticket ID\"]//following::tr//td[2])[1]"))
					.getText();
			System.out.println("ticket ID ->" + str);
			test.info("Support TicketID ->" + str);
			sp.ckickOnActionView();
			sp.enteringChatmsg(str);

		} else {
			test.fail("SupportTicket test failed for support request", extentScreenshot());
			Assert.assertTrue(false);

		}
	}
	
	//Release 1.2.1
	@Test
	public void Zr_TC_SupportRequestTest_Forget_Password() throws InterruptedException {

		test = extentCreateTest("Support Request - Forget password");
		test.info("GF-28538 : TC - As an admin I should be able to view Forgot Password entries, so that I can take action on the reset password");

		CosmoWebsite cw = new CosmoWebsite(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);

		gotoTab(driver, 1);
		cw.ClickOnPlayerLogout();
		//Thread.sleep(2000);
		//cw.ClickOnSignIn();
		Thread.sleep(1000);
		cw.ClickOnPlayerForgotPassword("CS-1637");
		//Thread.sleep(1000);
         if(driver.findElement(By.xpath("//div[contains(text(),'Support admin will contact you shortly!')]")).isDisplayed()) {
			test.pass("Successfully sent forget password request ",extentScreenshot());
			gotoTab(driver, 0);
			up.ClickDotButton();
			Thread.sleep(500);
			up.ClickOnSupportManagement();
			Thread.sleep(500);
			up.ClickOnContactDetails();
			Thread.sleep(2000);
			up.ClickonFORGOT_PASSWORDRadioBtn();
			Thread.sleep(1000);
			gp.Search_Items("CS-1637");
			Thread.sleep(1000);
			if (driver.findElement(By.xpath("//h3[text()='Contact Details']")) != null) {
				test.info("Opened Contact Details ->Forgot Password screen");
				if (driver.findElements(By.xpath("//th[text()='Player Id']/following::tr//td[contains(@class,'playerId ')]")).size() > 0) {
					test.pass("Successfully Viewed player Id of player on the contact details->Forget Password page",extentScreenshot());
				} else {
					test.fail("Something wrong !! To View first name of player on the Contact Details->Forget Password page",extentScreenshot());
				}
				WebElement Action = driver.findElement(By.xpath("//span[@title='Not Marked']"));
				if (Action.getAttribute("title").contains("Not Marked")) {
					Action.click();
					test.pass("Successfully Viewed Message - â€œAre you sure, you want to mark this inquiry as Action taken ?â€�",extentScreenshot());
					Thread.sleep(500);
					driver.findElement(By.xpath("//button[text()='Yes']")).click();
				} else {
					test.fail("Something wrong !! To View first name of player on the Contact Details->Forget Password page",extentScreenshot());
				}
			}

		} else {
			test.fail("Something Wrong ! not able sent forget password request ", extentScreenshot());
		}

	}
	
}
