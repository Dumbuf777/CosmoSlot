/**
 * 
 */
package com.Cosmoslots.testCases.Old_View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.MatErrorMsg;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.OldViewPOM;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.DateManager;

/**
 * @author shrikrushna.sonkar
 *
 */
public class Old_View extends BaseClass {
	private UserPage up;
	private GuestPlayers gp;
	private LoginPage lp;
	private OldViewPOM old;
	private CommonCosmo cc;

	@Test
	private void A_TC_Old_View_Access() throws InterruptedException, IOException {
		test = extentCreateTest("Access old view");
		test.info("As an admin user I should be able to provide old view access to specific user");
		up = new UserPage(driver);
		lp = new LoginPage(driver);
		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		if (up.UserProfile_Header != null) {
			up.Search_Items("cosmoslotstore");
			up.clickOnSearchEdit("cosmoslotstore");
			Thread.sleep(2000);
			up.selectCheckBox_OldView();
			up.clickToSave();
			Thread.sleep(3000);
			// openNewTab(driver, AdminURL);
			// gotoTab(driver, 1);
			lp.clickLogout();
			Thread.sleep(2000);
			Adminlogin("cosmoslotstore");
			Thread.sleep(2000);
			for (int i = 0; i <= up.ls.size() - 1; i++) {
				viewSection(up.ls.get(i));
			}
		} else {
			test.fail("Something wrong!To Open User Management->Users", extentScreenshot());

		}

	}

//	@Test
	private void B_TC_Old_View_Access() throws InterruptedException {
		test = extentCreateTest("Create user in old view ");
		test.info("TC- As a store user I should be able to create user in old view  ");
		gp = new GuestPlayers(driver);
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		old.ClickOnUserManagement();
		old.ClickOnCreateAccount();
		Thread.sleep(1500);
		test.info("Successfully opened create user page ");
		if (old.CreateUser_Header != null) {
			gp.setFirstName(Constant.Firstnm);
			test.info("Entered FirstName successfully");
			gp.setLastName(Constant.Lastnm);
			test.info("Entered LastName successfully");
			gp.setDisplayName1(Constant.Usernm);
			test.info("Entered DisplayName successfully");
			gp.selectgender("Male");
			test.info("Selected Gender successfully");
			gp.selectreputation("High");
			test.info("Selected PlayerReputation successfully");
			gp.EnterTags();
			test.info("Entered Tags successfully");
			gp.selectGuestStore(Constant.store);
			test.info("Selected Store successfully");
			gp.selectparentuser(Constant.parentuser);
			test.info("Selected parent user successfully");
			gp.setEmail(Constant.email);
			test.info("Entered Email Successfully");
			gp.setPassword(Constant.Password);
			test.info("Entered Password Successfully");
			gp.setDialCode("+91");
			test.info("Entered DialCode Successfully");
			gp.setPhone(Constant.randNum);
			test.info("Entered Phone Successfully");
			gp.setCountry("India");
			test.info("Entered Country Successfully");
			Thread.sleep(300);
			gp.setState("Gujarat");
			test.info("Entered State Successfully");
			gp.setCity("Gandhinagar");
			test.info("Entered City Successfully");
			gp.setZipcode("382002");
			test.info("Entered Pincode Successfully");
			gp.setAddress("BIFC,Gift City");
			test.info("Entered Address Successfully");
			gp.ClickSave();
			Thread.sleep(500);
			cc.VerifyDataCheck(CommonCosmo.Validation_Format_Playersavesuccessfully);
		} else {
			test.fail("Something wrong!To Open Create New Player", extentScreenshot());

		}
		Thread.sleep(3000);

	}

	@Test
	private void C_TC_Old_View_Access() throws InterruptedException {
		String[] str = { "Recharge", "Redeem", "Change Password", "Transaction Record", "Create Account",
				"Announcement", "Game Record", "JP Record" };
		test = extentCreateTest("Access old view button");
		test.info("TC- As an admin I should be able to view access button to all users");
		old = new OldViewPOM(driver);
		old.ClickOnUserManagement();
		old.ClickOnUpdate();
		Thread.sleep(2000);
		for (String st : str) {
			viewButtonAccess(st);
		}

	}

	@Test
	private void D_TC_Old_view_Access_CreateAnnouncement() throws InterruptedException {
		test = extentCreateTest("Access old view - Create Announcement");
		test.info("As an admin user I should be able to create announcement in old view store user");
		old = new OldViewPOM(driver);
		old.CreateAnnouncement();

	}

	@Test
	private void E_TC_Old_View_UserTrancationRecords_ExcelDownload() {

		test = extentCreateTest("Old view User Transaction Records - Download Excel");
		test.info("TC - EXCEL Download in Old view User Transaction Records");
		cc = new CommonCosmo(driver);
		old = new OldViewPOM(driver);
		old.ClickOnUserTransactionRecords();
		if (old.UserTransactionRecords_header != null) {
			test.info("Opened User Transaction Records Successfully");
			old.ClickOnExportExcel();
			explicitWait(driver, cc.Validation_XLSXDownload, 10);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}
		}
	}

	@Test
	private void Ea_TC_Old_View_UserTrancationRecords() {
		test = extentCreateTest("Old view - User Transaction Records");
		test.info("As an admin user I should be able to User Transaction Records in old view store user");
		old = new OldViewPOM(driver);
		old.ClickOnUserTransactionRecords();
		if (old.UserTransactionRecords_header != null) {
			test.info("Successfully redirected on User transaction records");
			old.Search_Customer("CS-1400");

		}

	}

	@Test
	private void F_TC_Old_View_JackpotRecords() throws InterruptedException {
		test = extentCreateTest("Old view - Jackpot Records");
		test.info("As an admin user I should be able to Jackpot Records in old view store user");
		old = new OldViewPOM(driver);
		up = new UserPage(driver);
		old.ClickOnJackpotRecords();
		if (old.JackpotRecords_header != null) {
			test.info("Successfully redirected on jackpot records");
			//old.Search_Customer("CS-1400");
			// old.SelectCustomerAction();
			up.ClickonCalendarBtn();
			up.SelectFromToDate();
			old.ClickOnSearch();
			
		}
	}
	
	@Test
	private void Fa_TC_Old_View_GameRecords() throws InterruptedException {
		test = extentCreateTest("Old view - Game Records");
		test.info("As an admin user I should be able to game records in old view store user");
		old = new OldViewPOM(driver);
		up = new UserPage(driver);
		old.ClickOnGameRecords();
		if (old.GameRecords_header != null) {
			test.info("Successfully redirected on game records");
			old.Search_Customer("CS-1400");
						
		}
	}

	@Test
	private void G_TC_Old_View_Settings() throws InterruptedException {
		test = extentCreateTest("Old view - Settings");
		test.info("As an admin user I should be able to change password in settings old view store user");
		old = new OldViewPOM(driver);
		old.ClickOnSettings();
		old.ClickOnChangePassword();
		cc.VerifyErrorMsg(MatErrorMsg.Newpassword_Error_msg.getErrorValues());
		cc.VerifyErrorMsg(MatErrorMsg.Confirmpassword_Error_msg.getErrorValues());

		
	}
	
	@Test
	private void H_TC_Old_View_Reports() throws InterruptedException {
		test = extentCreateTest("Old view - Reports");
		test.info("As an admin user I should be able to view reports in old view store user");
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		up = new UserPage(driver);
		old.ClickOnReports();
		if (old.Admin_Reports_header != null) {
			test.info("Successfully redirected on admin reports");
			up.ClickonCalendarBtn();
			up.SelectFromToDate();
			old.ClickOnSearch();
			cc.VerifyDataCheck(old.Reports_Summary_header);
			String startTime = driver.findElement(By.xpath("(//th[text()='Start Time']//following::tbody//td)[1]")).getText().substring(0, 10);
			String endTime = driver.findElement(By.xpath("(//th[text()='Start Time']//following::tbody//td)[2]")).getText().substring(0, 10);
			String dailyExtra = driver.findElement(By.xpath("(//th[text()='Daily Extra (ST)']//following::tbody//td)[4]")).getText().replaceAll(",", "");
			String promotional = driver.findElement(By.xpath("(//th[text()='Promotional (ST)']//following::tbody//td)[5]")).getText().replaceAll(",", "");
			String totalPurchase = driver.findElement(By.xpath("(//th[text()='Total Purchase (in $)']/following::tr//td)[6]")).getText().replaceAll(",", "");
			String totalRedeem = driver.findElement(By.xpath("(//th[text()='Total Redeem (in $)']//following::tr//td)[7]")).getText().replaceAll(",", "");
			String netIncome = driver.findElement(By.xpath("(//th[text()='Net Income (in $)']//following::tr//td)[8]")).getText().replaceAll(",", "");

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
			Assert.assertEquals(TotalNetIncome, NetIncome);
			test.pass("Total Net Income = " + TotalNetIncome, extentScreenshot());
			cc.VerifyDataCheck(old.Detail_Reports_header);

		}
	}

	@Test
	private void Hb_TC_Old_View_Reports_Today() throws InterruptedException {
	    test = extentCreateTest("Old view -Today Net Income Reports");
	    test.info("As an admin user I should be able to view reports in old view store user");
	    verifyReportData("//button[normalize-space()='Today']", DateManager.getDateRange().getToday(), DateManager.getDateRange().getToday());
	}

	@Test
	private void Hc_TC_Old_View_Reports_Yesterday() throws InterruptedException {
	    test = extentCreateTest("Old view -Yesterday Net Income Reports");
	    test.info("As an admin user I should be able to view reports in old view store user");
	    verifyReportData("//button[normalize-space()='Yesterday']", DateManager.getDateRange().getYesterday(), DateManager.getDateRange().getYesterday());
	}

	@Test
	private void Hd_TC_Old_View_Reports_ThisWeek() throws InterruptedException {
	    test = extentCreateTest("Old view -This Week Net Income Reports");
	    test.info("As an admin user I should be able to view reports in old view store user");
	    verifyReportData("//button[normalize-space()='This Week']", DateManager.getDateRange().getStartOfThisWeek(), DateManager.getDateRange().getToday());
	}

	@Test
	private void He_TC_Old_View_Reports_LastWeek() throws InterruptedException {
	    test = extentCreateTest("Old view -Last week Net Income Reports");
	    test.info("As an admin user I should be able to view reports in old view store user");
	    verifyReportData("//button[normalize-space()='Last Week']", DateManager.getDateRange().getStartOfLastWeek(), DateManager.getDateRange().getEndOfLastWeek());
	}
	
	@Test
	private void Ha_TC_Old_View_Reports_ExcelDownload() throws InterruptedException {
		test = extentCreateTest("Old view - Reports ExcelDownload");
		test.info("As an admin user I should be able to download excel reports in old view store user");
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		old.ClickOnReports();
		if (old.Admin_Reports_header != null) {
			test.info("Successfully redirected on admin reports");
			// old.ClickOnSearch();
			Thread.sleep(2000);
			old.ClickOnExportExcel();
			explicitWait(driver, cc.Validation_XLSXDownload, 10);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}

		}

	}
	
	@Test
	private void I_TC_Old_View_AdminTransactionRecords() throws InterruptedException {
		test = extentCreateTest("Old view - Admin Transaction Records");
		test.info("As an admin user I should be able to view admin transaction records in old view store user");
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		old.ClickOnAdminTransactionRecords();
		if (old.Admin_Transaction_Records_header != null) {
			test.info("Successfully redirected on admin transaction records");
			old.ClickOnSearch();
			Thread.sleep(5000);
			cc.VerifyDataCheck(old.Admin_Transaction_Records_header);

		}
	}

	@Test
	private void Ia_TC_Old_View_AdminTransactionRecords() throws InterruptedException {
		test = extentCreateTest("Old view - Admin Transaction Records Excel Download");
		test.info("As an admin user I should be able to download excel admin transaction records in old view store user");
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		if (old.Admin_Transaction_Records_header != null) {
			test.info("Successfully redirected on admin transaction records");
			// old.ClickOnSearch();
			old.ClickOnExportExcel();
			explicitWait(driver, CommonCosmo.Validation_XLSXDownload, 20);
			if (CommonCosmo.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}

		}

	}
	
	@Test
	private void J_TC_Old_View_AdminStructure() throws InterruptedException {
		String[] str = { "Recharge", "Redeem", "Change Password", "Transaction Record", "Create Account","Reports","Active" };

		test = extentCreateTest("Old view - Admin structure");
		test.info("As an admin user I should be able to download excel admin structure in old view store user");
		old = new OldViewPOM(driver);
		cc = new CommonCosmo(driver);
		test.info("TC- As an admin I should be able to view access button to admin structure user");
		old = new OldViewPOM(driver);
		old.ClickOnAdminStructure();
		old.Search_Account("Botticelli Reynolds");
		old.ClickOnUpdate();
		Thread.sleep(2000);
		for (String st : str) {
			viewButtonAccess(st);
		}
		
	}
	
	@Test
	private void Ja_TC_Old_View_AdminStructure() throws InterruptedException {
		old = new OldViewPOM(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		test = extentCreateTest("Old view - Admin structure Recharge");
		test.info("As an admin user I should be able to recharge in old view store user");
		old.Admin_Recharge();
		
		test = extentCreateTest("Old view - Admin structure Redeem");
		test.info("As an admin user I should be able to redeem in old view store user");
		old.Admin_Redeem();
	
		test = extentCreateTest("Old view - Admin structure Change Password");
		test.info("As an admin user I should be able to change password in admin structure old view store user");
		old.ClickOnChangePassword();Thread.sleep(1500);
		driver.findElement(By.xpath("(//span[normalize-space()='Change Password'])[2]")).click();
		Thread.sleep(500);
		cc.VerifyErrorMsg(MatErrorMsg.Newpassword_Error_msg.getErrorValues());
		cc.VerifyErrorMsg(MatErrorMsg.Confirmpassword_Error_msg.getErrorValues());
		old.Close.click();
		
		test = extentCreateTest("Old view -  Admin structure Reports");
		test.info("As an admin user I should be able to view admin structure reports in old view store user");
		old.ClickOnAdminStructure_Reports();
		if (old.Reports_header != null) {
			test.info("Successfully redirected on admin structure reports");
			up.ClickonCalendarBtn();
			up.SelectFromToDate();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@title='Search'])[2]")).click();
			Thread.sleep(2000);
			String dailyExtra = driver.findElement(By.xpath("(//th[text()='Daily Extra (ST)']//following::tbody//td)[4]")).getText().replaceAll(",", "");
			String promotional = driver.findElement(By.xpath("(//th[text()='Promotional (ST)']//following::tbody//td)[5]")).getText().replaceAll(",", "");
			String totalPurchase = driver.findElement(By.xpath("(//th[text()='Total Purchase (in $)']/following::tr//td)[6]")).getText().replaceAll(",", "");
			String totalRedeem = driver.findElement(By.xpath("(//th[text()='Total Redeem (in $)']//following::tr//td)[7]")).getText().replaceAll(",", "");
			String netIncome = driver.findElement(By.xpath("(//th[text()='Net Income (in $)']//following::tr//td)[8]")).getText().replaceAll(",", "");

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
			Assert.assertEquals(TotalNetIncome, NetIncome);
			test.pass("Total Net Income = " + TotalNetIncome, extentScreenshot());
			cc.VerifyDataCheck(old.Reports_Summary_header);

		}
		
		test = extentCreateTest("Old view - Admin structure Reports ExcelDownload");
		test.info("As an admin user I should be able to download excel reports in old view store user");
		
		if (old.Reports_header != null) {
			test.info("Successfully redirected on admin structure reports");
			
			Thread.sleep(2000);
			old.ClickOnExportExcel();
			explicitWait(driver, cc.Validation_XLSXDownload, 10);
			if (cc.Validation_XLSXDownload.isDisplayed()) {
				test.pass("Successfully XLSX Requested", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Download XLSX", extentScreenshot());
			}

		}
	
	}
	
	
	
	private void verifyReportData(String buttonXpath, LocalDate startDate, LocalDate endDate) throws InterruptedException {
	    old.ClickOnReports();
	    if (old.Admin_Reports_header != null) {
	        test.info("Successfully redirected on admin reports");
	        driver.findElement(By.xpath(buttonXpath)).click();
	        Thread.sleep(3000);
	        cc.VerifyDataCheck(old.Reports_Summary_header);
	        String startTime = driver.findElement(By.xpath("(//th[text()='Start Time']//following::tbody//td)[1]")).getText().substring(0, 10);
	        String endTime = driver.findElement(By.xpath("(//th[text()='Start Time']//following::tbody//td)[2]")).getText().substring(0, 10);
	        String dailyExtra = driver.findElement(By.xpath("(//th[text()='Daily Extra (ST)']//following::tbody//td)[4]")).getText().replaceAll(",", "");
	        String promotional = driver.findElement(By.xpath("(//th[text()='Promotional (ST)']//following::tbody//td)[5]")).getText().replaceAll(",", "");
	        String totalPurchase = driver.findElement(By.xpath("(//th[text()='Total Purchase (in $)']/following::tr//td)[6]")).getText().replaceAll(",", "");
	        String totalRedeem = driver.findElement(By.xpath("(//th[text()='Total Redeem (in $)']//following::tr//td)[7]")).getText().replaceAll(",", "");
	        String netIncome = driver.findElement(By.xpath("(//th[text()='Net Income (in $)']//following::tr//td)[8]")).getText().replaceAll(",", "");

	        double DailyExtra = Double.valueOf(dailyExtra);
	        //System.out.println("Daily extra ST = " + DailyExtra);
	        double Promotional = Double.valueOf(promotional);
	        //System.out.println("Promotional ST = " + Promotional);
	        double TotalPurchase = Double.valueOf(totalPurchase);
	        //System.out.println("Total Purchase ST = " + TotalPurchase);
	        double TotalRedeem = Double.valueOf(totalRedeem);
	        //System.out.println("Total Redeem ST = " + TotalRedeem);
	        double expectedNetIncome = Double.valueOf(netIncome);

	        double actualNetIncome = DailyExtra + Promotional + TotalPurchase - TotalRedeem;
	        //System.out.println("Total Net Income = " + actualNetIncome);
	        Assert.assertEquals(actualNetIncome, expectedNetIncome);
	        Assert.assertEquals(startTime, startDate.toString());
	        Assert.assertEquals(endTime, endDate.toString());
	        test.pass("Total Net Income = " + actualNetIncome, extentScreenshot());
	        cc.VerifyDataCheck(old.Detail_Reports_header);
	    }
	}

	private void viewSection(String sectionHeader) {
		test = extentCreateTest("Old view - " + sectionHeader);
		test.info("TC- As an admin I should be able to view " + sectionHeader + " in old view user");
		WebElement sectionElement = driver.findElement(By.xpath("//a[contains(.,'" + sectionHeader + "')]"));
		try {
			if (sectionElement.isDisplayed() == true) {
				test.pass("Successfully viewed <b>" + sectionHeader + "</b> in the  in old view user",
						extentScreenshot());
			} else {
				test.pass("Something Wrong ! Not able to view " + sectionHeader + " in the  in old view user",
						extentScreenshot());
			}
		} catch (Exception e) {
			System.out.println("Internal Server Error");
		}
	}

	private void viewButtonAccess(String sectionHeader) {
		test = extentCreateTest("Access Old view button - " + sectionHeader);
		test.info("TC- As an admin I should be able to view access " + sectionHeader + " button in old view user");
		WebElement sectionElement = driver.findElement(By.xpath("//span[normalize-space()='" + sectionHeader + "']"));
		try {
			if (sectionElement.isDisplayed() == true) {
				test.pass("Successfully viewed access <b>" + sectionHeader + "</b> button in the  in old view user",
						extentScreenshot());
			} else {
				test.pass("Something Wrong ! Not able to view access " + sectionHeader
						+ "button  in the  in old view user", extentScreenshot());
			}
		} catch (Exception e) {
			System.out.println("Internal Server Error");
		}
	}
}
