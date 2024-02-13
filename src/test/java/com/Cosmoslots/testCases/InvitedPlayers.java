/**
 * 
 */
package com.Cosmoslots.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class InvitedPlayers extends BaseClass {
	BaseClass bc = new BaseClass();
	
//	@Test
	public void A_TC_PlayerProfile_PlayerIdLogin() throws InterruptedException {
		test = extentCreateTest("Player login by using player ID ");
		test.info("TC - As an admin user I should be able to player login with player ID");

		bc.gotoTab(driver, 1);
		WithdrawRequest wr = new WithdrawRequest(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		
		wr.clickOnUser();
		Thread.sleep(1000);
		String playerID = driver.findElement(By.xpath("//span[@class='mys-player-id']")).getText();
		// playerID.lastIndexOf(playerID);
		String s = playerID.substring(11, 18);
		System.out.println(s);
		wr.clickOnUserprofile();
		Thread.sleep(500);
		pp.clickOnLogoutBtn();
		test.info("Player Logging with PlayerId");
		Thread.sleep(1000);
		bc.WebsiteLogin(s, Playerpass);
		if (s.equalsIgnoreCase(s)) {
			Assert.assertTrue(true);
			test.pass("Successfully login with Player ID :-" + s, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to user logged with userId", extentScreenshot());
			Assert.assertTrue(false);
		}
	}

//	@Test
	public void B_TC_PlayerProfile_Donthaveaninvitecode() throws InterruptedException {

		test = extentCreateTest("Player dont have invite code ");
		test.info("TC - As a player, I should be able to contact the administrator if I don't have an invite code to register myself");

		CosmoWebsite cw = new CosmoWebsite(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);


		gotoTab(driver, 1);
		cw.ClickOnPlayerLogout();
		Thread.sleep(2000);
		cw.ClickOnPlayerRegistration();
		Thread.sleep(1000);
		cw.ClickOnDonthaveanInviteCode();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h2[text()='Request an Invite Code']")).isDisplayed()) {
			test.info("Required invite code");
			cw.EnterPlayerFirstname(Constant.Firstnm);
			Thread.sleep(500);
			cw.EnterPlayerLastname(Constant.Lastnm);
			Thread.sleep(500);
			cw.EnterPlayerEmail(Constant.Email);
			Thread.sleep(500);
			cw.EnterPlayerPhoneNo("+"+Constant.randNum);
			Thread.sleep(500);
			cw.EnterPlayerMessage("Required invite code");
			Thread.sleep(500);
			cw.ClickOnSendMessageBtn();

		} else {
			test.fail("Something Wrong ! not able to Required invite code", extentScreenshot());
		}

		gotoTab(driver, 0);
		up.ClickDotButton();
		Thread.sleep(500);
		up.ClickOnSupportManagement();
		Thread.sleep(1000);
		up.ClickOnContactDetails();
		Thread.sleep(3000);
		up.ClickonInviteCodeRadioBtn();
		Thread.sleep(1000);
		gp.Search_Items(Constant.Firstnm);
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[text()='Contact Details']")) != null) {
			test.info("Opened Contact Details -> Invite code screen");
			
			if (driver.findElements(By.xpath("//th[text()='First Name']/following::tr//td[contains(@class,'firstname')]")).size() > 0) {
				test.pass("Successfully Viewed first name of player on the Contact Details->Invite Code page");
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To View first name of player on the Contact Details->Invite Code page");
				Assert.assertTrue(false);
			}
			if (driver.findElements(By.xpath("//th[text()='Last Name']/following::tr//td[contains(@class,'lastname')]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed last name of player on the Contact Details->Invite Code page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View last name of player on the Contact Details->Invite Code page");
			}
			if (driver.findElements(By.xpath("//th[text()='Email']/following::tr//td[contains(@class,'email')]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed email of player on the Contact Details->Invite Code page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View email of player on the Contact Details->Invite Code page");
			}
			if (driver.findElements(By.xpath("//th[text()='Contact Number']/following::tr//td[contains(@class,'contactnumber ')]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Contact Number of player on the Contact Details->Invite Code page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View Contact Number of player on the Contact Details->Invite Code page");
			}
			if (driver.findElements(By.xpath("//th[text()='Message']/following::tr//td[contains(@class,'message')]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Message of player on the Contact Details->Invite Code page",extentScreenshot());
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View Message of player on the Contact Details->Invite Code page",extentScreenshot());
			}
		}

	}

	@Test
	public void C_TC_PlayerProfile_GameRTP() throws InterruptedException {
		test = extentCreateTest("Player Exclusive Analytics - GAME RTP");
		test.info("As an admin I should be able to view the Exclusive tab so that I can view the Game wise RTP");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up= new UserPage(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("CS-1400");
		Thread.sleep(3000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
//		pp.GoToPlayerProfileView("CS-1400");
		pp.clickonExclusiveAnalytics();
		Thread.sleep(2000);
		pp.SelectGameCategory("Slot", "Leprechaun");
		Thread.sleep(1000);
		test.info("Selected Game category :- Slot");
		test.info("Selected Game :- Leprechaun ");
		//pp.Selectmonthandyear("2023", month[2], "1", endDate[2]);
		up.ClickonCalendarBtn();
		Thread.sleep(500);
		up.SelectFromToDate();
		Thread.sleep(1000);
		pp.clickSearch();
		Thread.sleep(5000);

		if (driver.findElements(By.xpath("//th[text()='Game Code']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Game Name']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Bet Values']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Paylines / Spots']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Spins / Rounds']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Bet']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Feature Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='RTP']")).size() > 0) {
			test.pass("Successfully viewed the Exclusive Analytics tab in player profile view", extentScreenshot());
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Exclusive Analytics tab in player profile and game RTP",
					extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Da_TC_PlayerProfile_PlayerLedger() throws InterruptedException {
		test = extentCreateTest("Player ledger");
		test.info("TC - As a player I should be able to view the player ledger");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items("CS-1400");
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
//		pp.GoToPlayerProfileView("CS-1400");

		if (driver.findElements(By.xpath("//h3[text()=\"Manage Tokens\"]")).size() < 1) {
			pp.clickManageTokens();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@title='Create New']")).click();
			Thread.sleep(2000);
		
		pp.selectPackage(" Cosmo10 (Act Amt. $1) ");
		Thread.sleep(500);
		pp.selectPaymentMethod("Others ");
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys("Test");
		pp.ClickSave();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		Thread.sleep(500);
		if (cc.Validation_Format_ManageTokens_saved.isDisplayed()) {
		//	Assert.assertTrue(true);
			test.pass("Successfully added tokens ", extentScreenshot());
		} else {
			//Assert.assertTrue(false);
			test.fail("Something wrong!To add token", extentScreenshot());
		}
		}
		Thread.sleep(1000);
		pp.clickPlayerLedgerTab();
		Thread.sleep(2000);
		
		if (driver.findElements(By.xpath("(//td[text()='Sweep Token'])[1]//following::td[contains(@class,'deposit')][1]")).size()>0) {
		
			test.pass("Successfully added tokens ", extentScreenshot());
		} else {
			
			test.fail("Something wrong!To add token", extentScreenshot());
		}
		
		String SweepToken = driver.findElement(By.xpath("(//td[text()='Game purchased'])[1]//following::td[contains(@class,'deposit ')][1]")).getText();
		Thread.sleep(2000);
		if(SweepToken.equals("0.00")) {
			test.pass("Successfully viewed game purchased transaction in player ledger ", extentScreenshot());
		}else {
			test.fail("Something wrong!To view in game purchase transaction in player ledger", extentScreenshot());
		}

    }
			
	@Test
	public void Db_TC_PlayerProfile_ChargeBackReport() throws InterruptedException {
	    test = extentCreateTest("TC- As an admin I should be able to access the player charge back report, so that I can have a detailed view of the report");
	    driver.findElement(By.id("nav-chargeback-tab")).click();
	    Thread.sleep(1000);

	    if (driver.findElements(By.xpath("//h4[text()='Charge Back Report']")).size() > 0) {
	        test.info("Successfully opened charge back report page", extentScreenshot());

	        enterSearchCriteria();
	        verifyPlayerDetails();
//	        enterCoverLetter();	        
	        viewFootprints();
	        viewTransactionDetails();
	        viewPurchaseReceipt();
	    } else {
	        test.fail("Something wrong !! Not able to open charge back report", extentScreenshot());
	    }
	}

	private void enterSearchCriteria() throws InterruptedException {
	    driver.findElement(By.xpath("//input[@formcontrolname='startsAtTime']")).sendKeys("1000");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@formcontrolname='expiryAtTime']")).sendKeys("1000");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//button[@title='Search']")).click();
	}

	private void verifyPlayerDetails() {
	    if (driver.findElements(By.xpath("//span[text()='Player Name']")).size() > 0) {
	        test.pass("Successfully Viewed player name, player Id, display name and registration date on the player charge back report page", extentScreenshot());
	    } else {
	        test.fail("Something wrong !! Not able to Viewed player name, player Id, display name and registration date on the player charge back report page", extentScreenshot());
	    }
	}

//  private void enterCoverLetter() { /* Your implementation here */ }

	private void viewFootprints() {
	    viewSection("Footprints");
	}

	private void viewTransactionDetails() {
	    viewSection("Transaction Details");
	}

	private void viewPurchaseReceipt() {
	    viewSection("Purchase Receipt");
	}

	private void viewSection(String sectionHeader) {
	    test = extentCreateTest("TC- As an admin I should be able to view " + sectionHeader + " in the player charge back report");
	    try {
	        WebElement sectionElement = driver.findElement(By.xpath("//h4[text()='" + sectionHeader + "']"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView();", sectionElement);
	        Thread.sleep(3000);
	        if (sectionElement != null) {
	            test.pass("Successfully viewed " + sectionHeader + " in the player charge back report", extentScreenshot());
	        } else {
	            test.pass("Something Wrong ! Not able to view " + sectionHeader + " in the player charge back report", extentScreenshot());
	        }
	    } catch (Exception e) {
	        System.out.println("Internal Server Error");
	    }
	}

		
	@Test
	public void Dc_TC_PlayerProfile_PlayerTransactionGraph() throws InterruptedException {
			test = extentCreateTest("TC - As an Admin I must be able to view the player transaction graph of only the current month");
			UserPage up = new UserPage(driver);
			LobbyPage lp= new  LobbyPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			gotoTab(driver, 0);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Dashboard']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]")).click();
//			up.ClickonCalendarBtn();
			Thread.sleep(500);
			up.SelectFromToDate();
			Thread.sleep(1000);
			if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
				test.pass("Successfully viewed the player transaction graph in dashboard", extentScreenshot());
			} else {
				test.fail("Something Wrong ! not able to view the player transaction graph in dashboard", extentScreenshot());
			}
			
			Thread.sleep(2000);	
			lp.clicklobbymanagement();
			Thread.sleep(500);
			lp.clickStoreAccounts();
			Thread.sleep(3000);
			lp.SearchItems("CosmoSlot");
			Thread.sleep(1500);
			lp.View_Click();
			Thread.sleep(2000);		
			try {
				WebElement PlayerTransaction = driver.findElement(By.xpath("//span[text()='Player Transaction']"));
				js.executeScript("arguments[0].scrollIntoView();", PlayerTransaction);
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[4]")).click();
				Thread.sleep(500);
				up.SelectFromToDate();
				Thread.sleep(1000);
				if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
					test.pass("Successfully viewed the player transaction graph in store dashboard", extentScreenshot());
				} else {
					test.fail("Something Wrong ! not able to view the player transaction graph in store  dashboard", extentScreenshot());
				}

				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
		   
	   }
	
	@Test
	public void E_TC_PlayerProfile_ViewNetReportof_InvitedPlayers() throws InterruptedException {
		test = extentCreateTest("TC - As an admin user I should be able to view net report of invited players");
		PlayerProfile pp = new PlayerProfile(driver);
		UserPage up = new UserPage(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(2000);
		pp.clickOnPlayerProfile();
        Thread.sleep(2000);
		gp.Search_Items(Constant.Player_Id);
		Thread.sleep(2000);
		pp.clickOnplayerinvited();
		Thread.sleep(2000);
//		pp.GoToPlayerProfileInvitedView("CS-1400");
		test.info("<b><i>Successfully viewed dashboard of invited players </b></i>", extentScreenshot());

		driver.findElement(By.xpath("//div[text()='Net Report']")).click();
		Thread.sleep(2000);
		//pp.Selectmonthandyear("2023", month[2], "1", endDate[2]);
		up.ClickonCalendarBtn();
		Thread.sleep(500);
		up.SelectFromToDate();
		Thread.sleep(1000);
		up.ClickonGenerateNetIncomeReports();
		if (driver.findElements(By.xpath("//th[text()='From Date']//following::tr//td[1]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='To Date']//following::tr//td[2]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Daily Extra (ST)']//following::tr//td[3]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Promotional (ST)']//following::tr//td[4]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Purchase (in $)']/following::tr//td[5]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Redeem (in $)']//following::tr//td[6]")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Net Income (in $)']//following::tr//td[7]")).size() > 0) {
			//Assert.assertTrue(true);
			test.pass("<b><i>Successfully viewed net report of invited players and net income of referred players</b></i>", extentScreenshot());
		} else {
			test.fail("Something wrong!To view net report of invited players and net income of referred players", extentScreenshot());
			//Assert.assertTrue(false);
		}

		String dailyExtra = driver.findElement(By.xpath("//th[text()='Daily Extra (ST)']//following::tr//td[3]")).getText().replaceAll(",", "");
		String promotional = driver.findElement(By.xpath("//th[text()='Promotional (ST)']//following::tr//td[4]")).getText().replaceAll(",", "");
		String totalPurchase = driver.findElement(By.xpath("//th[text()='Total Purchase (in $)']/following::tr//td[5]")).getText().replaceAll(",", "");
		String totalRedeem = driver.findElement(By.xpath("//th[text()='Total Redeem (in $)']//following::tr//td[6]")).getText().replaceAll(",", "");
		String netIncome = driver.findElement(By.xpath("//th[text()='Net Income (in $)']//following::tr//td[7]")).getText().replaceAll(",", "");

		double DailyExtra = Double.valueOf(dailyExtra);
		System.out.println("Daily extra ST = " + DailyExtra);
		double Promotional = Double.valueOf(promotional);
		System.out.println("Promotional ST = " + Promotional);
		double TotalPurchase = Double.valueOf(totalPurchase);
		System.out.println("Total Purchase ST = " + TotalPurchase);
		double TotalRedeem = Double.valueOf(totalRedeem);
		System.out.println("Total Redeem ST = " + TotalRedeem);
		double NetIncome = Double.valueOf(netIncome);
		// System.out.println(NetIncome);

		double TotalNetIncome = DailyExtra + Promotional + TotalPurchase - TotalRedeem;
		System.out.println("Total Net Income = " + TotalNetIncome);
		test.pass("Total Net Income = " + TotalNetIncome, extentScreenshot());		

		Thread.sleep(1000);
		//pp.clickXlsxButton();
		driver.findElement(By.xpath("(//button[@title='Export XLSX'])[1]")).click();
		Thread.sleep(500);
		if (cc.Validation_XLSXDownload.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_XLSXDownload.getText(), extentScreenshot());
		} else if (cc.Validation_XLSXDownload1.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_XLSXDownload1.getText(), extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
			Assert.assertTrue(false);
		}

	}

	@Test
	public void Ea_TC_PlayerProfile__ViewNetReportof_InvitedPlayers() throws InterruptedException {
		
		test = extentCreateTest("TC - As an admin, I should be able to download the XLSX sheet net income report of particular invited players ");
		CommonCosmo cc = new CommonCosmo(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		
		driver.findElement(By.xpath("(//button[@title='Export XLSX'])[2]")).click();
		Thread.sleep(500);
		if (cc.Validation_XLSXDownload.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_XLSXDownload1, extentScreenshot());
		} else if (cc.Validation_XLSXDownload1.isDisplayed() == true) {
			Assert.assertTrue(true);
			test.pass("" + cc.Validation_XLSXDownload, extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to download XLSX of net income report of refferal players", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		pp.clickOnDownloadIcon();
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//h3[text()='Downloads']")).size() > 0) {
			test.pass("Successfully downloaded net report of invited players", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to download XLSX of net income report", extentScreenshot());
		}
	}
	
	@Test
	public void Eb_TC_PlayerProfile_ViewPieChartof_InvitedPlayers() throws InterruptedException {
		test = extentCreateTest("TC - As an admin user I should be able to view the dashboard of invited players");
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		UserPage up = new UserPage(driver);
		Actions act = new Actions(driver);

		pp.clickOnPlayerManagement();
		Thread.sleep(2000);
		pp.clickOnPlayerProfile();
		Thread.sleep(2000);
		gp.Search_Items("CS-1400");
		Thread.sleep(2000);
		pp.clickOnplayerinvited();
		Thread.sleep(2000);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//div[text()='Dashboard']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//button[@aria-label=\"Open calendar\"])[3]")).click();
////		up.ClickonCalendarBtn();
//		Thread.sleep(500);
//		up.SelectFromToDate();
//		Thread.sleep(1000);
//		if (driver.findElements(By.xpath("//h4[text()='Player Transaction']")).size() > 0) {
//			test.pass("Successfully viewed the player transaction graph in dashboard", extentScreenshot());
//		} else {
//			test.fail("Something Wrong ! not able to view the player transaction graph in dashboard", extentScreenshot());
//		}
//		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//h4[text()='Most Active Game']")));
		Thread.sleep(2000);
		List<WebElement> gamesName = driver.findElements(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='apexcharts-series apexcharts-pie-series']"));
		List<WebElement> games = driver.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-series apexcharts-pie-series'])//*[name()='path']"));
		System.out.println("Number of active games of invited players " + games.size());
		for (WebElement ActiveGame : games) {
			act.moveToElement(ActiveGame).build().perform();
			System.out.println(ActiveGame.getAttribute("data:value"));
			Thread.sleep(2000);
			// driver.findElement(By.xpath("//div[@class='apexcharts-tooltip-y-group']//child::span[@class='apexcharts-tooltip-text-y-label']")).
		}

	}
	
	@Test //Release 1.2.3 - GF-30283
	public void Ec_TC_PlayerProfile_ViewVerified_In_InvitedPlayers() throws InterruptedException {
		
		test = extentCreateTest("TC - As a admin I should be able to view player verified info in invited players listing");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement TotalRegisteredPlayers = driver.findElement(By.xpath("//h6[text()='Total Registered Players(via Link) - ']"));
		js.executeScript("arguments[0].scrollIntoView();", TotalRegisteredPlayers);
		Thread.sleep(2000);
		
		if (driver.findElements(By.xpath("//th[text()='Verified ?']")).size() > 0) {
			test.pass("Successfully viewed player verified info in invited players listing",extentScreenshot());
			} else {
			test.fail("Something wrong !! Not able to View view player verified info in invited players listing",extentScreenshot());
		}


	}

}
