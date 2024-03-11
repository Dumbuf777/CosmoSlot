/**
 * 
 */
package com.Cosmoslots.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.ExtentManager;

/**
 * @author shrikrushna.sonkar
 *
 */
public class OldViewPOM extends ExtentManager {
	WebDriver ldriver;
	BaseClass bc = new BaseClass();
	/**
	 * 
	 */
	public OldViewPOM(WebDriver rdriver) {
		// TODO Auto-generated constructor stub
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='User Management']")
	private WebElement UserManagement;
	
	@FindBy(xpath = "//a[normalize-space()='User Transaction Records']")
	private WebElement UserTransactionRecords;
	
	@FindBy(xpath = "//h4[contains(.,'User Transaction Records')]")
	public WebElement UserTransactionRecords_header;
	
	@FindBy(xpath = "//a[normalize-space()='Game Records']")
	private WebElement GameRecords;
	
	@FindBy(xpath = "//a[normalize-space()='Jackpot Records']")
	private WebElement JackpotRecords;
	
		
	@FindBy(xpath = "//a[normalize-space()='Admin Structure']")
	private WebElement AdminStructure;
	
	@FindBy(xpath = "//a[normalize-space()='Admin Transaction Records']")
	private WebElement AdminTransactionRecords;
	
	@FindBy(xpath = "//a[normalize-space()='Reports']")
	private WebElement Reports;
	
	@FindBy(xpath = "//a[normalize-space()='Settings']")
	private WebElement Settings;
	
	@FindBy(xpath = "//a[normalize-space()='Downloads']")
	private WebElement Downloads;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	private WebElement Logout;
	
	@FindBy(xpath = "//button[@title='Create Account']")
	private WebElement CreateAccount;
	
	@FindBy(xpath = "//button[@title='Announcement']")
	private WebElement Announcement;
	
	@FindBy(xpath = "//span[normalize-space()='Transaction Record']")
	private WebElement Transaction_Record;
	
	@FindBy(xpath = "//span[normalize-space()='Game Record']")
	private WebElement Game_Record;
	
	@FindBy(xpath = "//span[normalize-space()='JP Record']")
	private WebElement JP_Record;
	
	@FindBy(xpath = "//span[normalize-space()='Recharge']")
	private WebElement Recharge;
	
	@FindBy(xpath = "//span[normalize-space()='Redeem']")
	private WebElement Redeem;
	
	@FindBy(xpath = "//span[normalize-space()='Change Password']")
	private WebElement ChangePassword;
	
	@FindBy(xpath = "//button[@title='Active']")
	private WebElement Active;
	
	@FindBy(xpath = "//button[@title='Search']")
	private WebElement Search;
	
	@FindBy(xpath = "(//button[@title='Update'])[1]")
	private WebElement Update;
	
	@FindBy(xpath = "//h3[normalize-space()='Create User']")
	public WebElement CreateUser_Header;
	
	@FindBy(xpath = "//label[normalize-space()='Customer:']//following::input[1]")
	private WebElement CustomerID;
	
	@FindBy(xpath = " //mat-form-field[contains(@class,'gmuSearch ')]//child::input[1]")
	private WebElement Account_Search;
	
	@FindBy(xpath = "(//span[normalize-space()='Excel'])[1]")
	public WebElement ExportExcel;
	
	@FindBy(xpath = "(//button[@title='Select'])[1]")
	public WebElement Select;
	
	@FindBy(xpath = "//mat-select[@formcontrolname=\"paymentMethod\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	private WebElement Selectpaymentmethod;

	@FindBy(xpath = "//input[@formcontrolname='amount']")
	private WebElement amount;

	@FindBy(xpath = "//input[@formcontrolname='gameTokens']")
	private WebElement gameTokens;

	@FindBy(xpath = "//input[@formcontrolname='sweepTokens']")
	private WebElement sweepTokens;
	
	@FindBy(xpath = "//textarea[@formcontrolname='notes']")
	private WebElement notes;
	
	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement Save;
	
	@FindBy(xpath = "//a[@type='button']")
	public WebElement Close;
	
	@FindBy(xpath = "//span[normalize-space()='Reports']")
	private WebElement AdminStructure_Reports;
	
//Header
	
	@FindBy(xpath = "//h4[contains(.,'Admin Reports')]")
	public WebElement Admin_Reports_header;
	
	@FindBy(xpath = "//h4[contains(.,'Reports Summary')]")
	public WebElement Reports_Summary_header;
	
	@FindBy(xpath = "//h4[contains(.,'Detail Reports')]")
	public WebElement Detail_Reports_header;
	
	@FindBy(xpath = "//h4[contains(.,'Admin Transaction Records')]")
	public WebElement Admin_Transaction_Records_header;
	
	@FindBy(xpath = "//h3[contains(.,'Reports')]")
	public WebElement Reports_header;
	
	@FindBy(xpath = "//h4[contains(.,'Game Records')]")
	public WebElement GameRecords_header;
	
	@FindBy(xpath = "//h4[contains(.,'JP Records')]")
	public WebElement JackpotRecords_header;
	
	/**
	 * Click on UserManagement.
	 *
	 * @return the OldViewPOM class instance.
	 */
	public OldViewPOM ClickOnUserManagement() {
		bc.explicitWait(ldriver, UserManagement, 10);
		UserManagement.click();
		return this;
	}

	public OldViewPOM ClickOnUserTransactionRecords() {
		bc.explicitWait(ldriver, UserTransactionRecords, 10);
		UserTransactionRecords.click();
		return this;
	}

	public OldViewPOM ClickOnGameRecords() {
		bc.explicitWait(ldriver, GameRecords, 10);
		GameRecords.click();
		return this;
	}

	public OldViewPOM ClickOnJackpotRecords() {
		bc.explicitWait(ldriver, JackpotRecords, 10);
		JackpotRecords.click();
		return this;
	}

	public OldViewPOM ClickOnAdminStructure() {
		bc.explicitWait(ldriver, AdminStructure, 10);
		AdminStructure.click();
		return this;
	}

	public OldViewPOM ClickOnAdminTransactionRecords() {
		bc.explicitWait(ldriver, AdminTransactionRecords, 10);
		AdminTransactionRecords.click();
		return this;
	}

	public OldViewPOM ClickOnReports() {
		bc.explicitWait(ldriver, Reports, 10);
		Reports.click();
		return this;
	}
	
	public OldViewPOM ClickOnAdminStructure_Reports() {
		bc.explicitWait(ldriver, AdminStructure_Reports, 10);
		AdminStructure_Reports.click();
		return this;
	}
	
	public OldViewPOM ClickOnSettings() {
		bc.explicitWait(ldriver, Settings, 10);
		Settings.click();
		return this;
	}
	
	public OldViewPOM ClickOnChangePassword() {
		bc.explicitWait(ldriver, ChangePassword, 30);
		ChangePassword.click();
		return this;
	}

	public OldViewPOM ClickOnDownloads() {
		bc.explicitWait(ldriver, Downloads, 10);
		Downloads.click();
		return this;
	}

	public OldViewPOM ClickOnLogout() {
		bc.explicitWait(ldriver, Logout, 10);
		Logout.click();
		return this;
	}
	
	public OldViewPOM ClickOnCreateAccount() {
		bc.explicitWait(ldriver, CreateAccount, 10);
		CreateAccount.click();
		return this;
	}
	
	public OldViewPOM ClickOnUpdate() {
		bc.explicitWait(ldriver, Update, 10);
		Update.click();
		return this;
	}
	
	public OldViewPOM ClickOnSearch() {
		bc.explicitWait(ldriver, Search, 20);
		Search.click();
		return this;
	}
	
	public OldViewPOM ClickOnExportExcel() {
		ExportExcel.click();
		return this;
	}
	
	public OldViewPOM Search_Customer(String str) {
		CustomerID.clear();
		CustomerID.sendKeys(str);
		Search.click();
		if(driver.findElement(By.xpath("(//td[contains(.,'"+str+"')])[1]")) != null) {
			test.info("Successfully searched "+str,extentScreenshot());
		}
		return this;
	}
	
	public OldViewPOM Search_Account(String str) {
		Account_Search.clear();
		Account_Search.sendKeys(str);
		Search.click();
		if(driver.findElement(By.xpath("(//td[contains(.,'"+str+"')])[1]")) != null) {
			test.info("Successfully searched "+str,extentScreenshot());
		}
		return this;
	}
	
	public OldViewPOM SelectCustomerAction() {
		bc.explicitWait(ldriver, Select, 10);
		Select.click();
		if(driver.findElement(By.xpath("//span[normalize-space()='Transaction Summary']")) != null) {
			test.info("Successfully view customer transaction summery in old view ",extentScreenshot());
		}
		return this;
	}
	
	public OldViewPOM Admin_Recharge() throws InterruptedException {
		CommonCosmo cc = new CommonCosmo(ldriver);
		Recharge.click();
		Thread.sleep(300);
		if(driver.findElement(By.xpath("//h3[contains(.,'Recharge')]")) != null) {
			test.info("Successfully recharge page in old view ",extentScreenshot());
			amount.sendKeys("1");
			gameTokens.sendKeys("1");
			sweepTokens.sendKeys("1");
			notes.sendKeys("Notes");
			selectPaymentMethod("Manual");
			Save.click();
			bc.explicitWait(ldriver, cc.Validation_Format_ManageTokens_saved, 20);
			cc.VerifyDataCheck(cc.Validation_Format_ManageTokens_saved);
		}
		
		return this;
	}
	
	public OldViewPOM Admin_Redeem() throws InterruptedException {
		CommonCosmo cc = new CommonCosmo(ldriver);
		Redeem.click();
		Thread.sleep(300);
		if(driver.findElement(By.xpath("//h3[contains(.,'Redeem')]")) != null) {
			test.info("Successfully redeem page in old view ",extentScreenshot());
			gameTokens.sendKeys("1");
			sweepTokens.sendKeys("1");
			notes.sendKeys("Notes");
			Save.click();
			bc.explicitWait(ldriver, cc.Validation_Format_ManageTokens_saved, 20);
			cc.VerifyDataCheck(cc.Validation_Format_ManageTokens_saved);
		}
		
		return this;
	}
	
	public OldViewPOM selectPaymentMethod(String method) throws InterruptedException {
		Thread.sleep(300);
		Selectpaymentmethod.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(.,'" + method + "')]")).click();
		Thread.sleep(300);
		return this;
	}
	
	
	
	public OldViewPOM CreateAnnouncement() throws InterruptedException {
		LobbyPage_Old lb = new LobbyPage_Old(ldriver);
		UserPage up = new UserPage(ldriver);
		CommonCosmo cc = new CommonCosmo(ldriver);
		
		Announcement.click();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h3[text()=\"Create Announcement\"]")) != null) {
			lb.SetNewsicon(BaseClass.UploadImage);
			Thread.sleep(1000);
			lb.description.sendKeys("This is Create announcement");
			driver.findElement(By.xpath("//input[@formcontrolname=\"title\"]")).sendKeys(Constant.AnnouncementTitle);
			lb.SelectStoreAccount_Announcement("CosmoSlot");
			test.info("Store account selected is ->" + "Cosmoslot");
			Thread.sleep(1000);
			lb.Select_AnnouncementCategory_Announcement("Game Update");
			up.AC_Save();
			test.info("Announcement Detail saved successfully", extentScreenshot());
			Thread.sleep(500);
			cc.VerifyDataCheck(cc.Validation_AnnouncementDataSaveSuccessfully);

		} else {
			test.fail("Not able to find Create Announcement", extentScreenshot());
		}

		return this;
	}
	

}
