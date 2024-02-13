package com.Cosmoslots.testCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.MyProfiles;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

public class MyProfile extends BaseClass {

	String Upload_Icon = UploadImage;
	String Firstname = "System";
	String Lastname = "ADMIN";
	String Dialcode = "+91";
	String Phone = "8745458885";
	String Country = "India";
	String State = "Gujarat";
	String City = "Ahmedabad";
	String Timezone = "Asia/Colombo";
	String RPP = "50";// record per page
	String ChatNotification = "On";
	String SearchPlayer = "cosmoW";
	String GT = "100";
	String ST = "100";
	String Note = "By auto";
	
	private MyProfiles mp;
	private GuestPlayers gp;


	@Test
	public void B_TC_MyProfile_GF1134_Redirect() throws IOException, InterruptedException {
		mp = new MyProfiles(driver);
		test = extentCreateTest("MyProfile -> Redirect");
		test.info("As an admin user I should able to click on 'My Profile' menu so that I can redirect to My Profile page");
		Thread.sleep(3000);
		MyProfiles.clickUserprofile();
		test.info("Clicked on admin user profile icon");
		Thread.sleep(1000);
		MyProfiles.clickMyprofile();
		test.info("Clicked on admin my profile link");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			test.pass("Successfully Displayed MyProfile Page",extentScreenshot());
		} else {
			test.fail("Something Wrong to Display MyProfile Page",extentScreenshot());
		}
	}

	@Test
	public void C_TC_MyProfile_GF1147_Details() throws IOException, InterruptedException {
		test = extentCreateTest("MyProfile -> Verify MyProfile Details");
		test.info("TestCase started 1147 - As an admin user I should able to view my profile details");

		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			try {
				test.info("Successfully Displayed MyProfile Page");
				if (MyProfiles.firstName != null) {
					test.pass("Successfully Displayed FirstName in MyProfile Page");
				} else {
					test.fail("Not Displayed FirstName in MyProfile Page");
				}
				if (MyProfiles.lastName != null) {
					test.pass("Successfully Displayed lastName in MyProfile Page");
				} else {
					test.fail("Not Displayed lastName in MyProfile Page");
				}
				if (MyProfiles.userName != null) {
					test.pass("Successfully Displayed userName in MyProfile Page");
				} else {
					test.fail("Not Displayed userName in MyProfile Page");
				}
				if (MyProfiles.CreatedAt != null) {
					test.pass("Successfully Displayed CreatedAt in MyProfile Page");
				} else {
					test.fail("Not Displayed CreatedAt in MyProfile Page");
				}
				if (MyProfiles.UpdatedAt != null) {
					test.pass("Successfully Displayed UpdatedAt in MyProfile Page");
				} else {
					test.fail("Not Displayed UpdatedAt in MyProfile Page");
				}
				if (MyProfiles.Role != null) {
					test.pass("Successfully Displayed Role in MyProfile Page");
				} else {
					test.fail("Not Displayed Role in MyProfile Page");
				}
				if (MyProfiles.Usertype != null) {
					test.pass("Successfully Displayed Usertype in MyProfile Page");
				} else {
					test.fail("Not Displayed Usertype in MyProfile Page");
				}
				if (MyProfiles.StoreAccount != null) {
					test.pass("Successfully Displayed StoreAccount in MyProfile Page");
				} else {
					test.fail("Not Displayed StoreAccount in MyProfile Page");
				}
				if (MyProfiles.ParentUser != null) {
					test.pass("Successfully Displayed ParentUser in MyProfile Page");
				} else {
					test.fail("Not Displayed ParentUser in MyProfile Page");
				}

				if (MyProfiles.email != null) {
					test.pass("Successfully Displayed email in MyProfile Page");
				} else {
					test.fail("Not Displayed email in MyProfile Page");
				}
				if (MyProfiles.dialCode != null) {
					test.pass("Successfully Displayed dialCode in MyProfile Page");
				} else {
					test.fail("Not Displayed dialCode in MyProfile Page");
				}
				if (MyProfiles.phone != null) {
					test.pass("Successfully Displayed phone in MyProfile Page");
				} else {
					test.fail("Not Displayed phone in MyProfile Page");
				}
				if (MyProfiles.country != null) {
					test.pass("Successfully Displayed country in MyProfile Page");
				} else {
					test.fail("Not Displayed country in MyProfile Page");
				}
				if (MyProfiles.state != null) {
					test.pass("Successfully Displayed state in MyProfile Page");
				} else {
					test.fail("Not Displayed state in MyProfile Page");
				}
				if (MyProfiles.city != null) {
					test.pass("Successfully Displayed city in MyProfile Page");
				} else {
					test.fail("Not Displayed city in MyProfile Page");
				}
				// Assert.assertTrue(true);
			} catch (Exception e) {
				Assert.assertTrue(false);
				test.info("Something Wrong to Display MyProfile Page");
			}
		} else {
			Assert.assertTrue(false);
			test.info("Something Wrong to Display MyProfile Page");
		}
	}

//	@Test
	public void D_TC_MyProfile_GF1143_UpdateMyProfile() throws IOException, InterruptedException {
		MyProfiles mp = new MyProfiles(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		test = extentCreateTest("MyProfile -> Update Profile");
		test.info("TestCase started 1143 - As an admin user I should able to Update My-Profile");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			test.info("Successfully redirect to MyProfile Page");

			mp.firstName.clear();
			mp.setFirstName(Firstname);
			mp.lastName.clear();
			mp.setLastName(Lastname);

			//mp.setDialCode(Dialcode);
			mp.phone.clear();
			mp.setPhone(Phone);
			mp.Country.click();
			gp.editCountry(Country);
			// Thread.sleep(500);
			driver.findElement(By.xpath("(//div[contains(@class,\"value\")])[3]")).click();
			gp.editState(State);
			mp.city.clear();
			mp.setCity(City);
			gp.Timezone.click();
			gp.editTimezone(Timezone);
			gp.RPP.click();
			gp.editRPP(RPP);
			mp.Chatnotification();
			mp.save.click();
			Thread.sleep(7000);

			MyProfiles.clickUserprofile();
			Thread.sleep(1000);
			MyProfiles.clickMyprofile();
			Thread.sleep(6000);
		} else {
			Assert.assertTrue(false);
			test.info("Something Wrong to redirect MyProfile Page");
		}
	}

	@Test
	public void E_TC_MyProfile_UploadPhoto() throws IOException, InterruptedException {
		mp = new MyProfiles(driver);
		test = extentCreateTest("MyProfile -> Upload Icon");
		test.info("TestCase started  - As an admin user I should able to upload photo in  My-Profile");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			test.info("Successfully redirect to MyProfile Page");
			mp.SetNewsicon(Upload_Icon);
			Thread.sleep(3000);
			if (driver.findElement(By.xpath("//mat-icon[text()=\"delete\"]")) != null) {
				test.pass("Successfully photo uploaded in My Profile",extentScreenshot());
			} else {
				test.fail("Something Bad! Not Uploaded",extentScreenshot());
			}
		}
	}
	@Test
	public void F_TC_MyProfile_playerRegistrationSearch() throws IOException, InterruptedException {
		gp = new GuestPlayers(driver);
		test = extentCreateTest("MyProfile -> PlayerRegistrationTab -> Search");
		test.info(
				"TestCase started  - As an admin user I should be able to search in My-Profile -> Player Registration");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			test.info("Successfully redirect to MyProfile Page");

			driver.findElement(By.xpath("//button[contains(text(),\"Player Registration\")]")).click();
			Thread.sleep(500);
			gp.Search_Items(SearchPlayer);
			Thread.sleep(1500);
			if (driver.findElement(By.xpath("//td[contains(text(),'" + SearchPlayer + "')]")) != null) {
				test.pass("Successfully Searched Item viewed");
				//Assert.assertTrue(true);
			} else {
				//Assert.assertTrue(false);
				test.fail("Something wrong !! To Search Item");
				captureScreen(driver, "FailedSearchByPlayerEmail");
			}
		}
	}

	@Test
	public void G_TC_MyProfile_TokenDetailsTab() throws IOException, InterruptedException {
	    gp = new GuestPlayers(driver);
		test = extentCreateTest("MyProfile -> Token Detail Tab");
		test.info("TC - As an admin user I should be able to View Token details in My-Profile -> Token Details");
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size() > 0) {
			test.info("Successfully redirect to MyProfile Page");

			driver.findElement(By.xpath("//button[contains(text(),\"Player Registration\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(),\"Token Details\")]")).click();
			Thread.sleep(1000);

			if (gp.Current != null) {
				test.info("Successfully Clicked on Token Details in Player Profile Detail View.");
				test.pass("Player Profile Current Sweep tokens and game tokens are displayed");
			} else {
				test.fail("Player Profile Current Sweep tokens and game tokens are not displayed");
				captureScreen(driver, "FailedSearchByPlayerEmail");
			}
			if (gp.PerTransaction != null) {
				test.pass("Player Profile Current Sweep tokens with PerTransaction are displayed");
			} else {
				test.fail("Player Profile Current Sweep tokens with PerTransaction are not displayed");
			}
			if (gp.PerDayTransaction != null) {
				test.pass("Player Profile Current Sweep tokens with PerDayTransaction are displayed");
			} else {
				test.fail("Player Profile Current Sweep tokens with PerDayTransaction not displayed");
			}
		}
	}

//	@Test
//	public void H_TC_MyProfileTest_SearchPlayerCustomPackagePurchase() throws IOException, InterruptedException 
//	{
//		MyProfileTest mp = new MyProfileTest(driver);
//		GuestPlayers gp=new GuestPlayers(driver);
//		PlayerProfile pp=new PlayerProfile(driver);
//		test = extentCreateTest("TestCase started  - As an admin user I should be able to Search in My-Profile -> Player Custom Package Purchase list");
//		Thread.sleep(2000);
//		if(driver.findElements(By.xpath("//h3[text()=\"My Profile\"]")).size()>0)
//		{
//			test.info("Successfully redirect to MyProfile Page");
//			
//			driver.findElement(By.xpath("//button[text()=\"Player Custom Package Purchase\"]")).click();
//			Thread.sleep(1000);
//			//driver.findElement(By.xpath("//button[text()=\"Player Registration\"]")).click();
//			Thread.sleep(500);
//			gp.Search_Items(Note);
//			Thread.sleep(1500);
//			if(driver.findElement(By.xpath("//td[contains(text(),'"+Note+"')]"))!=null)
//			{
//				test.pass("Successfully Searched Item viewed");
//				Assert.assertTrue(true);
//			}
//			else
//			{
//				Assert.assertTrue(false);
//				test.fail("Something wrong !! To Search Item");
//				captureScreen(driver,"FailedSearchByPlayerEmail");
//			}	
//			
//		}
//	}

	@Test
	public void I_TC_MyProfile_ManageTokens() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> ManageToken -> Create");
		test.info(
				"TestCase started As an admin user I should be able to (Create New Tokens) in My-Profile -> Manage tokens");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		LobbyPage lp = new LobbyPage(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");

		driver.findElement(By.xpath("//button[text()=\" Manage Tokens \"]")).click();
		

		// pp.clickAddTokens();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[text()=\" Create New\"]")).click();
		Thread.sleep(500);

		// pp.SetNewsicon(Upload_Icon);
		// Thread.sleep(3000);
		// pp.selectPackage(packge);
		driver.findElement(By.xpath("//input[@formcontrolname=\"amount\"]")).sendKeys("40");
		Thread.sleep(500);
		pp.selectPaymentMethod("Others ");

		driver.findElement(By.xpath("//input[@formcontrolname=\"gameTokens\"]")).sendKeys(GT);
		driver.findElement(By.xpath("//input[@formcontrolname=\"sweepTokens\"]")).sendKeys(ST);
		driver.findElement(By.xpath("//textarea[@formcontrolname=\"notes\"]")).sendKeys(Note);

		pp.ClickSave();
		Thread.sleep(1500);
		if (driver.findElements(By.xpath("//span[text()=\"Token save successfully\"]")).size() > 0) {
			test.pass("Successfully Add Token is Working fine");
			Assert.assertTrue(true);
		} else {
			Thread.sleep(500);
			test.fail("Not Added Token", extentScreenshot());
			// Thread.sleep(500);
			// String e =
			// driver.findElement(By.xpath("//span[contains(text(),\"augend\")]")).toString();
			lp.ClickToCancel();
			// test.fail("Error Displayed = "+e);
			Assert.assertTrue(false);
		}
	}

	@Test
	public void J_TC_MyProfileTest_SearchManageTokens() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> ManageToken -> Search");
		test.info("TestCase started As an admin user I should be able to Search in My-Profile -> Manage tokens");
		GuestPlayers gp = new GuestPlayers(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");

		Thread.sleep(500);
		gp.Search_Items(Note);
		Thread.sleep(1500);
		if (driver.findElement(By.xpath("//td[contains(text(),'" + Note + "')]")) != null) {
			test.pass("Successfully Searched Item viewed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong !! To Search Item");
			captureScreen(driver, "FailedSearchByPlayerEmail");
		}
	}

	@Test
	public void K_TC_MyProfile_ViewAllFieldManageTokens() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> ManageToken -> Verify All Fields");
		test.info(
				"TestCase started As an admin user I should be able to View all Fields in My-Profile -> Manage tokens");
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");

		if (driver.findElement(By.xpath("//td[contains(text(),'" + Note + "')]")) != null) {
			test.pass("Successfully Viewed All Items");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong !!");
			captureScreen(driver, "FailedManageTokensMyProfile");
		}
	}

	@Test
	public void L_TC_MyProfileTest_SearchTokenLedger() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> TokenLedger -> Search");
		test.info(
				"TestCase started As an admin user I should be able to Search all Fields in My-Profile -> Token Ledger");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");
		driver.findElement(By.xpath("//button[text()=\" Token Ledger \"]")).click();
		Thread.sleep(1000);

		Thread.sleep(500);
		gp.Search_Items("Transfer");
		Thread.sleep(1500);
		if (driver.findElements(By.xpath("//td[contains(text(),\"Trasnfer\")]")) != null) {
			test.pass("Successfully Searched Item viewed");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong !! To Search Item");
			captureScreen(driver, "FailedSearchByPlayerEmail");
		}

	}

	@Test
	public void M_TC_MyProfileTest_DownloadExcelTokenLedger() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> TokenLedger -> Excel");
		test.info("TestCase started As an admin user I should be able to download EXCEL in My-Profile -> Token Ledger");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// test.info("Opened Player Successfully");
		WebElement DownloadExcel;
		DownloadExcel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Export XLSX']")));

		// pp.clickXlsxButton();

		DownloadExcel.click();
		// BaseClass.ClickXlDownload();
		// Thread.sleep(8000);

		// String
		// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();
		// if(SearchItem.equalsIgnoreCase(SearchItem))
		if (cc.Validation_XLSXDownload.isDisplayed()) {
			test.pass("Successfully XLSX Downloaded");
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! To Download XLSX");
			captureScreen(driver, "FailedXLSXDownloadTokenLegderTab");
			//Assert.assertTrue(false);
		}

	}

	@Test
	public void N_TC_MyProfileTest_ActionViewTokenLedger() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> TokenLedger -> ActionView");
		test.info("TC - As an admin user I should be able to View Action(View) in My-Profile -> Token Ledger");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");

		pp.clickActioneyeicon();
		Thread.sleep(1500);
		// if(SearchItem.equalsIgnoreCase(SearchItem))
		if (driver.findElement(By.xpath("//h3[text()=\"View Token Ledger Details\"]")).isDisplayed()) {
			test.pass("Successfully Viewed Token Ledger Details");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! To Viewed Token Ledger Details !! Taking Too Much Time");
			captureScreen(driver, "FailedViewedTokenLegderDetailsTab");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
		pp.clickCloseActionView();
		Thread.sleep(1000);

	}

	@Test
	public void O_TC_MyProfileTest_NetIncomeReport() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> Report -> NetIncome ");
		test.info("TestCase started As an admin user I should able to view Net income Report in MyProfile -> Reports");
		CommonCosmo cc = new CommonCosmo(driver);
		UserPage up= new UserPage(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		test.info("Opened Player Successfully");

		driver.findElement(By.xpath("//button[text()=\" Reports \"]")).click();
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate(); 
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//button[@aria-label=\"Open calendar\"]")).click();
//		driver.findElement(By.xpath("//div[text()=\" 1 \"]")).click();
//		driver.findElement(By.xpath("//div[text()=\" 4 \"]")).click();
//		// span[text()="Generate Net Income"]
		driver.findElement(By.xpath("//span[text()=\"Generate Net Income\"]")).click();

		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//th[text()=\"Net Income (in $)\"]")) != null) {
			test.pass("Successfully Generated NetIncome Report");
			//Assert.assertTrue(true);
		} else {
			test.fail("Something Wrong To Download NetIncome Report");
		}

	}

	@Test
	public void P_TC_MyProfileTest_NetIncomeExcel() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> Report -> NetIncome -> Download Excel");
		test.info("TestCase started As an admin user I should able to view Net income Report in MyProfile -> Reports");
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		pp.clickXlsxButton();

		Thread.sleep(3000);
		if (cc.Validation_XLSXDownload.isDisplayed()) {
			test.pass("Successfully XLSX Downloaded");
			//Assert.assertTrue(true);
		} else if (driver.findElement(By.xpath("//span[contains(text(),\"Tips are not found\"])")) != null) {
			test.pass("Net Income are not found");
			//Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! To Download XLSX");
			captureScreen(driver, "FailedXLSXDownloadNetIncomeTab");
			//Assert.assertTrue(false);
		}
	}

	@Test
	public void Q_TC_MyProfileTest_TipReport() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> Report -> TipReport");
		test.info("TC - As an admin user I should able to view Tip Report in MyProfile -> Reports");
	
		UserPage up= new UserPage(driver);
	

		test.info("Opened Player Successfully");

		driver.findElement(By.xpath("//div[text()=\"Tips Report\"]")).click();
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate(); 
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=\"Generate Tip Report\"]")).click();
		if (driver.findElements(By.xpath("//th[text()=\"Total Tips\"]")).size() > 0) {
			test.pass("Successfully Generated Tip Report",extentScreenshot());
		} else if (driver.findElement(By.xpath("//span[text()=\"Tips are not found\"]")) != null) {
			test.pass("Tips are not found",extentScreenshot());
		} else {
			test.fail("Something Not Working", extentScreenshot());
		}

	}

//	@Test
	public void R_TC_MyProfileTest_TipReportExcel() throws InterruptedException, IOException {
		// String SearchItem="pawan.sharma@gameium.com";
		test = extentCreateTest("MyProfile -> Report -> TipReport -> Download Excel ");
		test.info("TestCase started As an admin user I should able to view Net income Report in MyProfile -> Reports");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		// Thread.sleep(4000);
		// gp.clickPlayerManagement1Link();
		// pp.clickPlayerProfileLink();

		pp.clickXlsxButton();

		Thread.sleep(3000);
		if (cc.Validation_XLSX_Download.isDisplayed()) {
			test.pass("Successfully XLSX Downloaded");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong !! To Download XLSX");
			captureScreen(driver, "FailedXLSXDownloadTipReportTab");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void S_TC_MyProfileTest_LoginFootprints() throws InterruptedException {

		MyProfiles mp = new MyProfiles(driver);
		//mp.clickUserprofile();
		//Thread.sleep(500);
		//mp.clickMyprofile();
		//mp.clickOnLoginFootprints();
		driver.findElement(By.xpath("//button[contains(text(),'Footprints')]")).click();
		Thread.sleep(2000);

		
			if (driver.findElements(By.xpath("//th[text()=\"Date & Time\"]/following::tr//td[contains(@class,\"createdAt\")]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Date & Time of Player on the player login footprints page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View Date & Time of Player on the player login footprints page");
			}
			if (driver.findElements(By.xpath("//th[text()=\"Device\"]/following::tr//td[contains(@class,\"device \")]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed device of Player on the player login footprints page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View device of Player on the  player login footprints page");
			}
			if (driver.findElements(By.xpath("//th[text()=\"IP Address\"]/following::tr//td[contains(@class,\"ip \")]")).size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully View ip of Player on the player login footprints page");
			} else {
				Assert.assertTrue(false);
				test.fail("Something wrong !! To View ip of Player on the  player login footprints page");
			}

		

	}
}
