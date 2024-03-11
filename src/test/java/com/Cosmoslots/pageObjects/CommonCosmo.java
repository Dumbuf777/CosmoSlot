package com.Cosmoslots.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.ENUM.MatErrorMsg;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

public class CommonCosmo extends ExtentManager {
	WebDriver ldriver;

	public CommonCosmo(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//mat-error[text()=\" First name should contain only alphabets\"]")
	@CacheLookup
	public static WebElement Validation_alphabets_Firstname;

	@FindBy(xpath = "//mat-error[text()=\" Last name should contain only alphabets\"]")
	@CacheLookup
	public static WebElement Validation_alphabets_Lastname;

	@FindBy(xpath = "//mat-error[text()=\" Phone number contains only the numeric characters\"]")
	@CacheLookup
	public static WebElement Validation_numeric_PhoneNo;

	@FindBy(xpath = "//mat-error[text()=\" Only alphanumeric and some special characters(-#$_&) are allowed in this field\"]")
	@CacheLookup
	public static WebElement Validation_Special_Lastname;

	@FindBy(xpath = "//mat-error[text()=\" Please enter valid email\"]")
	@CacheLookup
	public static WebElement Validation_Format_Email;

	@FindBy(xpath = "//span[text()=\"PDF downloaded successfully\"]")
	@CacheLookup
	public static WebElement Validation_PDF_Download;

	@FindBy(xpath = "//span[text()=\"XLSX downloaded successfully\"]")
	@CacheLookup
	public static WebElement Validation_XLSX_Download;

	@FindBy(xpath = "//span[text()=\"Request initiated. You will get an email once the data is ready. The export is limited to 50000 records. Please contact administrator for more records.\"]")
	@CacheLookup
	public static WebElement Validation_Withdraw_XLSX_Download;

	@FindBy(xpath = "//span[text()=\"Request initiated. You will get an email once the data is ready. The export is limited to 5000 records. Please contact administrator for more records.\"]")
	@CacheLookup
	public static WebElement Validation_Purchase_XLSX_Download;

	@FindBy(xpath = "//span[text()=\"Name must be unique\"]")
	@CacheLookup
	public static WebElement Validation_message_Lobby_Name;

	@FindBy(xpath = "//span[text()=\"Code must be unique\"]")
	@CacheLookup
	public static WebElement Validation_message_Lobby_Code;

	@FindBy(xpath = "//mat-error[text()=\" Code is required\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_Code;

	@FindBy(xpath = "//mat-error[text()=\" Name is required\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_Name;

	@FindBy(xpath = "//span[text()=\"Lobby updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_Update;

	@FindBy(xpath = "//span[text()=\"Access Control Profile data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AccessControl;

	@FindBy(xpath = "//span[text()=\"You don't have access rights, Contact to the administrator\"]")
	@CacheLookup
	public static WebElement Validation_Format_DonotAccessControl;

	@FindBy(xpath = "//span[text()=\"Role data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UserRole_Add;

	@FindBy(xpath = "//span[text()=\"Code already exists\"]")
	@CacheLookup
	public static WebElement Validation_Format_UserRole_Exists;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UserDelete;

	@FindBy(xpath = "//span[text()=\"Lobby version data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AddVersion;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeleteVersion;

	@FindBy(xpath = "//span[text()=\"Bonus save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AddBonus;

	@FindBy(xpath = "//span[text()=\"Bonus updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UpdateBonus;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeleteBonus;

	@FindBy(xpath = "//span[text()=\"News save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AddNews;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeleteNews;

	@FindBy(xpath = "//span[text()=\"News updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UpdateNews;

	@FindBy(xpath = "//span[text()=\"FAQ save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AddFAQ;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeleteFAQ;

	@FindBy(xpath = "//span[text()=\"FAQ updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UpdateFAQ;

	@FindBy(xpath = "//span[text()=\"Promotion save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_AddPromotion;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeletePromotion;

	@FindBy(xpath = "//span[text()=\"Promotion updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UpdatePromotion;

	@FindBy(xpath = "//span[text()=\"App settings data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_SaveAppSettings;

	@FindBy(xpath = "//span[text()=\"App Settings data deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_DeleteAppSettings;

	@FindBy(xpath = "//span[text()=\"Package save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Addpackage;

	@FindBy(xpath = "//span[text()=\"Record deleted successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Deletepackage;

	@FindBy(xpath = "//span[text()=\"Blocked List Data saved successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_BlockList_saved;

	@FindBy(xpath = "//span[text()=\"Blocked List Data update successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_BlockList_edit;

	@FindBy(xpath = "//span[text()=\"Coupon save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_coupon_saved;

	@FindBy(xpath = "//span[text()=\"Coupon updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_coupon_updated;

	@FindBy(xpath = "//span[text()=\"Lobby maintenance data saved successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_Maintenance_saved;

	@FindBy(xpath = "//span[text()=\"General Pages save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_General_Pages;

	@FindBy(xpath = "//span[text()=\"Settings save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Lobby_ApplicationDownloadLink;

	@FindBy(xpath = "//span[text()=\"Home page update successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_edit;

	@FindBy(xpath = "//span[text()=\"Home page save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_add;

	@FindBy(xpath = "//span[text()=\"Meta Data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_metadata_save;

	@FindBy(xpath = "//span[text()=\"Meta Data updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_metadata_update;

	@FindBy(xpath = "//span[text()=\"Release Note save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_metadata_releasesaved;

	@FindBy(xpath = "//span[text()=\"Release Note updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Settings_Homepage_metadata_releaseUpdate;

	@FindBy(xpath = "//span[text()=\"Tab Access save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Website_TabAccess;

	@FindBy(xpath = "//span[text()=\"Tab Access updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Website_TabAccess_update;

	@FindBy(xpath = "//span[text()=\"Sign up save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Website_Signup;

	@FindBy(xpath = "//span[text()=\"Corporation details save successfully\"]")
	@CacheLookup
	public WebElement Validation_Format_Corporationdetails;

	@FindBy(xpath = "//span[text()=\"Store maintenance data saved successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_StoreMaintenance;

	@FindBy(xpath = "//span[text()=\"Store maintenance data update successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_StoreMaintenance_update;

	@FindBy(xpath = "//span[text()=\"package updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Updatepackage;

	@FindBy(xpath = "//span[text()=\"Store package updated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UpdateStorepackage;

	@FindBy(xpath = "//span[text()=\"Store Settings save successfully\"]")
	@CacheLookup
	public WebElement Validation_Format_StoreAdd;

	@FindBy(xpath = "//span[text()=\"Store Settings update successfully\"]")
	@CacheLookup
	public WebElement Validation_Format_Storeupdate;

	@FindBy(xpath = "//span[text()=\"Withdraw Settings data save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_WithdrawSettings_saved;

	@FindBy(xpath = "//span[text()=\"Token save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_ManageTokens_saved;

	@FindBy(xpath = "//span[text()=\"User does not have sufficient game token\"]")
	@CacheLookup
	public static WebElement Validation_Format_UnsafficientTokens;

	@FindBy(xpath = "//span[text()=\"Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.\"]")
	@CacheLookup
	public static WebElement Validation_XLSXDownload;

	@FindBy(xpath = "//span[text()=\"Request initiated. Navigate to Download section to track your requests. The export is limited to 5,000 records. Please contact administrator for more records.\"]")
	@CacheLookup
	public static WebElement Validation_XLSXDownload1;

	@FindBy(xpath = "//span[text()=\"User Profile activated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UserProfileActivated;

	@FindBy(xpath = "//span[text()=\"User Profile deactivated successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_UserProfiledeactivated;

	@FindBy(xpath = "//span[text()=\"You are not allowed to login. Please contact administrator\"]")
	@CacheLookup
	public static WebElement Validation_Format_Usernotallowedtologin;

	@FindBy(xpath = "//span[text()=\"Tips are not found\"]")
	@CacheLookup
	public static WebElement Validation_Format_Tipsarenotfound;

	@FindBy(xpath = "//span[text()=\"Profile save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Profilesavesuccessfully;

	@FindBy(xpath = "//span[text()=\"Player save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Playersavesuccessfully;

	@FindBy(xpath = "//span[text()=\"User save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Format_Usersavesuccessfully;

	@FindBy(xpath = "//span[text()=\"Email Id is already in use.\"]")
	@CacheLookup
	public static WebElement Validation_EmailIdisalreadyinuse;

	@FindBy(xpath = "//span[text()=\"Chat request save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Chatrequestsavesuccessfully;

	@FindBy(xpath = "//span[text()=\"Notes save successfully\"]")
	@CacheLookup
	public static WebElement Validation_Notessavesuccessfull;

	@FindBy(xpath = "//div[contains(text(),'KYC')]")
	@CacheLookup
	public static WebElement Validation_KYC_Verificatin_Required;

	@FindBy(xpath = "//button[text()='Yes']")
	@CacheLookup
	public static WebElement Yes;

	@FindBy(xpath = "//button[text()='Cancel']")
	@CacheLookup
	public static WebElement Cancel;

	@FindBy(xpath = "//span[text()='Announcement data save successfully']")
	public static WebElement Validation_AnnouncementDataSaveSuccessfully;
	// ------Paras Changes----
	private By Announcement_saved = By.xpath("//span[text()=\"Announcement data save successfully\"]");

	public boolean AnnouncementSaved() {
		return ldriver.findElement(Announcement_saved).isDisplayed();
	}

	// -------krishna------
	public boolean Webelement_isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		// flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed " + ele);
				test.pass("<b><i>Successfully displayed " + ele.getText() + " </b></i>", extentScreenshot());
			} else {
				System.out.println("The element is not Displayed " + ele);
				test.fail(ele + " Not displayed ", extentScreenshot());
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	public CommonCosmo VerifyDataCheck(WebElement ele) {
		if (ele.isDisplayed() == true) {
			test.pass("<b><i> " + ele.getText() + " </b></i>", extentScreenshot());
//			test.pass("Successfully Opened <b><i> " + ele.getText() + " </b></i> screen", extentScreenshot());

		} else {
			test.fail("Not Found verify message", extentScreenshot());
//			test.fail("Something wrong!To Open <b><i> " + ele.getText() + " </b></i> screen", extentScreenshot());
		}
		return this;

	}

	public CommonCosmo VerifyErrorMsg(String str) throws InterruptedException {
		WebElement error = driver.findElement(By.xpath(str));
		Thread.sleep(700);
		try {
			if (error.isDisplayed() == true) {
				test.pass("<b><i>Successfully view error msg ->  " + error.getText() + " </b></i>", extentScreenshot());
			} else {
				test.fail("Not Found error message", extentScreenshot());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return this;

	}

	// --------All Cosmo Headers-------
	@FindBy(xpath = "//h3[text()='Contact Us']")
	@CacheLookup
	public WebElement ContactUs_Header;

	@FindBy(xpath = "//h3[text()='Player Management']")
	@CacheLookup
	public WebElement PlayerManagement_Header;

	@FindBy(xpath = "//h3[text()='Player Deletion History']")
	@CacheLookup
	public WebElement PlayerDeletionHistory_Header;

	@FindBy(xpath = "//h3[text()='Withdraw Requests']")
	@CacheLookup
	public WebElement WithdrawRequests_Header;

	@FindBy(xpath = "//h3[text()='Create Withdraw Request']")
	@CacheLookup
	public WebElement CreateWithdrawRequest_Header;

	@FindBy(xpath = "//h3[text()='Purchase History']")
	@CacheLookup
	public WebElement PurchaseHistory_Header;

	@FindBy(xpath = "//h3[text()='User Management']")
	@CacheLookup
	public WebElement UserManagement_Header;

	@FindBy(xpath = "//h3[text()='Store Management']")
	@CacheLookup
	public WebElement StoreManagement_Header;

	@FindBy(xpath = "//h3[text()='Chat Management']")
	@CacheLookup
	public WebElement ChatManagement_Header;

	@FindBy(xpath = "//h3[text()='Jackpot Wins']")
	@CacheLookup
	public WebElement JackpotWins_Header;

	@FindBy(xpath = "//h2[contains(.,'Are you sure, ')]")
	public WebElement toggleVerification_Header;

	@FindBy(xpath = "//span[text()=\"Password has successfully changed\"]")
	@CacheLookup
	public static WebElement Validation_Passwordhassuccessfullychanged;

	public static boolean verifyValidation_Format_UserDelete() {

		return Validation_Format_UserDelete.isDisplayed();
	}

	public By StoreSaved = By.xpath("//span[text()='Store save successfully']");

	public boolean verifyStoreSaved() {

		return ldriver.findElements(StoreSaved).size() > 0;
	}

	public boolean check(By ele) {
		return ldriver.findElements(ele).size() > 0;
	}

	public By StoreUpdatedSuccessfully = By.xpath("//span[text()='Store updated successfully']");

	public CommonCosmo VerifyStoreUpdated(By ele) {
		if (check(ele)) {
			test.pass("<b><i>store update validation message</b></i>", extentScreenshot());
		} else {
			test.fail("<b><i>store update validation message not displayed</b></i>", extentScreenshot());
		}
		return this;
	}

	@FindBy(xpath = "//span[text()=\"Game Room Configuration save successfully\"]")
	@CacheLookup
	public static WebElement Room_Configuration_save;
	public By jackpotSaved = By.xpath("//span[text()='Jackpot save successfully']");

	public boolean verifyjackpotSaved() {
        return ldriver.findElements(jackpotSaved).size() > 0;
	}
	
	public By SocialMediaSettingssave = By.xpath("//span[text()=\"Social Media Settings save successfully\"]");
	
	public By couponSave = By.xpath("//span[text()='Coupon save successfully']");
	 
	
	public CommonCosmo VerifyData(By ele) {
        if (check(ele)) {
            test.pass("<b><i>Data saved successfully message Found</b></i>", extentScreenshot());
        } else {
            test.fail("Not Found saved successfully message", extentScreenshot());
        }
        return this;
    }
	

    public CommonCosmo VerifyDataCheck1(WebElement ele) {
        if (ele.isDisplayed() == true) {
            // test.pass("<b><i>Data saved successfully message Found</b></i>",
            // extentScreenshot());
            test.pass("<b><i> " + ele.getText() + " </b></i>", extentScreenshot());
        } else {
            test.fail("Not Found verify message", extentScreenshot());
        }
        return this;
    }
    
    public By jackpotupdated = By.xpath("//span[text()='Jackpot updated successfully']");

    public boolean verifyjackpotupdated() {
        return ldriver.findElements(jackpotupdated).size() > 0;
    }
    
    @FindBy(xpath = "//span[text()=\"Bonus level updated successfully\"]")
    @CacheLookup
    public static WebElement Validation_UpdateLevelBonus;
    
    public By Marketingsave = By.xpath("//span[text()='Marketing save successfully']");
	public By Marketingupdated = By.xpath("//span[text()='Marketing updated successfully']");
	public By addMarketing = By.xpath("//span[text()='Add Marketing Template']");
	public By addMarketingHeader = By.xpath("//h3[text()='Add Marketing Template']");
}
