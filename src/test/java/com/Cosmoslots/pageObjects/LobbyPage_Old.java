package com.Cosmoslots.pageObjects;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cosmoslots.ENUM.PlayerEnum;

import groovyjarjarantlr4.v4.codegen.model.Action;

public class LobbyPage_Old {

	WebDriver ldriver;

	public LobbyPage_Old(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[text()=\" Store Management\"]")
	@CacheLookup
	public WebElement StoreManagement;

	@FindBy(xpath = "//div/button[text()=\"Store Accounts\"]")
	@CacheLookup
	public WebElement StoreAccounts;

	@FindBy(xpath = "//span[text()=\"Search Game\"]")
	@CacheLookup
	private WebElement Games;

	@FindBy(xpath = "//input[@placeholder='Search Game']")
	@CacheLookup
	public static WebElement SetGames;

	@FindBy(xpath = "//div[@id=\"kenoGameSelectBox\"]//following::span[text()=\"Search Game\"]")
	@CacheLookup
	private WebElement KenoGames;

	@FindBy(xpath = "//input[@placeholder=\"Search Game\"]")
	@CacheLookup
	public static WebElement KenoSetGames;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname=\"web\"]")
	@CacheLookup
	public static WebElement web;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname=\"android\"]")
	@CacheLookup
	private WebElement android;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname=\"ios\"]")
	@CacheLookup
	private WebElement ios;

	@FindBy(xpath = "//div[contains(text(),'News')]")
	@CacheLookup
	public WebElement news;

	@FindBy(xpath = "//div[contains(text(),'FAQ')]")
	@CacheLookup
	public WebElement faq;

	@FindBy(xpath = "//div[contains(text(),'Promotion')]")
	@CacheLookup
	public WebElement Promotion;

	@FindBy(xpath = "//span[text()=\"Search Country\"]")
	@CacheLookup
	private WebElement Country;

	@FindBy(xpath = "//input[@placeholder=\"Search Country\"]")
	@CacheLookup
	public static WebElement SetCountry;

	@FindBy(xpath = "//mat-select[@formcontrolname='faqCategory']//parent::span[contains(@class,'mat-select-min-line')]")
	@CacheLookup
	private WebElement faqCategory;

	@FindBy(xpath = "//span[.='Account']")
	@CacheLookup
	public static WebElement SelectFAQCategory;

	@FindBy(xpath = "//input[@formcontrolname=\"sortOrder\"]")
	@CacheLookup
	public static WebElement SetOrder;

	@FindBy(xpath = "//button[@title=\"Create New\"]")
	@CacheLookup
	public WebElement Create_Button;

	@FindBy(xpath = "//input[@formcontrolname=\"title\"]")
	@CacheLookup
	WebElement Create_title;

	@FindBy(xpath = "//input[@formcontrolname=\"question\"]")
	@CacheLookup
	WebElement Create_question;

	@FindBy(xpath = "//input[@formcontrolname=\"answer\"]")
	@CacheLookup
	WebElement Create_answer;

	@FindBy(xpath = "//input[@type=\"file\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Create_icon;

	@FindBy(xpath = "//input[@formcontrolname=\"name\"]")
	@CacheLookup
	public static WebElement Name;

	@FindBy(xpath = "//input[@formcontrolname=\"discountedPercentage\"]")
	@CacheLookup
	public static WebElement discountedPercentage;

	@FindBy(xpath = "//input[@formcontrolname=\"expiryAt\"]")
	@CacheLookup
	public static WebElement expiryAt;

	@FindBy(xpath = "//input[@formcontrolname=\"usageByPlayer\"]")
	@CacheLookup
	public static WebElement usageByPlayer;

	// @FindBy(xpath = "//input[@formcontrolname=\"activationAfterPurchase\"]")
	@FindBy(xpath = "//input[@formcontrolname=\"couponActivationAfterOrOn\"]")
	@CacheLookup
	public static WebElement activationAfterPurchase;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"action\"]")
	@CacheLookup
	public WebElement var_Action;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"actionUrl\"]")
	@CacheLookup
	public WebElement var_Actionurl;

	@FindBy(xpath = "//input[@formcontrolname=\"url\"]")
	@CacheLookup
	public WebElement Player_Registration_Link;

	@FindBy(xpath = "//span[contains(text(),\"Daily Login Bonus\")]") // mat-option//span[contains(.,"Player")]
	@CacheLookup
	public WebElement select_Action;

	@FindBy(xpath = "(//input[@formcontrolname='gameTokens'])[1]") // div[@formgroupname=\"token\"]/div[1]
	@CacheLookup
	public WebElement select_GameToken;

	@FindBy(xpath = "(//input[@formcontrolname='sweepTokens'])[1]") // div[@formgroupname=\"token\"]/div[1]
	@CacheLookup
	public WebElement select_SweepToken;

	@FindBy(xpath = "(//*[@title=\"Invited Players\"])[1]")
	@CacheLookup
	WebElement AddPlayerURL;

	@FindBy(xpath = "(//a[@title=\"Edit\"])[1]") // (//i[@class='ri-pencil-line'])[1] -> (//a[@id=\"edit\"])[1]
	@CacheLookup
	WebElement EditButton;

	@FindBy(xpath = "(//i[@class='ri-pencil-line'])[1]") // (//i[@class='ri-pencil-line'])[1] -> (//a[@id=\"edit\"])[1]
	@CacheLookup
	WebElement EditButton1;

	@FindBy(xpath = "//button//span[text()=\"Save\"]//parent::button") // (//i[@class='ri-pencil-line'])[1] ->
																		// (//a[@id=\"edit\"])[1]
	@CacheLookup
	public static WebElement Savenews;

	@FindBy(xpath = "//button[text()='Cancel']//preceding-sibling::button[text()='Yes']") // (//i[@class='ri-pencil-line'])[1]
																							// -> (//a[@id=\"edit\"])[1]
	@CacheLookup
	public static WebElement clickyes;

//	@FindBy(xpath="//i[@class='ri-eye-line']")
//	@CacheLookup
//	WebElement ViewLobby;

	@FindBy(xpath = "(//i[@class='ri-eye-line'])[1]")
	@CacheLookup
	public WebElement View_Click;

	@FindBy(xpath = "(//a[@title='Package Purchase History'])[1]")
	@CacheLookup
	public WebElement ViewPurchaseHistory;

	@FindBy(xpath = "(//a[@title='Custom Package Purchase History'])[1]")
	@CacheLookup
	public WebElement ViewCustomPurchaseHistory;

	@FindBy(xpath = "(//a[@title='Player Coupon'])[1]")
	@CacheLookup
	public WebElement ViewCouponAppliedHistory;

	@FindBy(xpath = "//mat-icon[text()=\"clear \"]")
	@CacheLookup
	public static WebElement ClearSearch;

	@FindBy(xpath = "(//a[@title=\"Store Account Maintenance Mode\"])[1]")
	@CacheLookup
	WebElement View_Maintenance;

	@FindBy(xpath = "//i[@class='ri-file-copy-line']")
	@CacheLookup
	WebElement CopyLobby;

	// @FindBy(xpath="//span[text()=\"App Based
	// \"]/preceding::span[contains(@class,\"radio-inner\")]")
	@FindBy(xpath = "//input[@value=\"APP_BASED\"]")
	@CacheLookup
	public static WebElement AppBasedradio;

	@FindBy(xpath = "//input[@value=\"OWNER_BASED\"]")
	@CacheLookup
	public static WebElement OwenerBasedradio;

	@FindBy(xpath = "//input[@formcontrolname=\"code\"]")
	@CacheLookup
	WebElement Lcode;

	@FindBy(xpath = "//input[@formcontrolname=\"name\"]")
	@CacheLookup
	WebElement Lname;

	@FindBy(xpath = "//i[@class=\"ri-coupon-3-line\"]")
	@CacheLookup
	WebElement PlayerCoupon;

	@FindBy(xpath = "//textarea[@formcontrolname=\"description\"]")
	@CacheLookup
	public static WebElement description;

	@FindBy(xpath = "//*[@formcontrolname=\"description\"]/div/div/p[1]") // p[@class='NgxEditor__Placeholder']
																			// //div[contains(@class,
																			// "NgxEditor__Content")]//p
																			// //ngx-editor[1]/div[1]/div[1]
	@CacheLookup
	public static WebElement description_news;

	@FindBy(xpath = "//span[text()='Save']") // div[4]/div/div/div[2]/button/span
	@CacheLookup
	WebElement Lobbysave;

	@FindBy(xpath = "//button/span[text()='Save']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	WebElement Save_Button;

	@FindBy(xpath = "//button/span[text()='Save']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public static WebElement Save_Button_GeneralPages;

	@FindBy(xpath = "(//button//span[text()='Save'])[1]") // span[text()=\'Save\']
	@CacheLookup
	WebElement Save_Button1;

	@FindBy(xpath = "(//button//span[text()='Save'])[1]")
	@CacheLookup
	WebElement Save_Button_Promotion;

	@FindBy(xpath = "//div[contains(text(),'Profile')]")
	@CacheLookup
	WebElement ViewLobby_Profile;

	// @FindBy(xpath="//div[contains(text(),'Store Packages')]")
	// @FindBy(xpath="//div[text()='Packages']")
	@FindBy(xpath = "//button[text()=' Packages ']")
	@CacheLookup
	WebElement ViewLobby_storePackage;

	@FindBy(xpath = "//button[contains(text(),'Custom Packages')]")
	@CacheLookup
	WebElement ViewLobby_LobbyCPackage;

	@FindBy(xpath = "//input[@formcontrolname=\"amount\"]")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_amount;

	@FindBy(xpath = "//input[@formcontrolname=\"discountAmount\"]")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_discountAmount;

	@FindBy(xpath = "//input[@formcontrolname=\"sweepToken\"]")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_sweepToken;

	@FindBy(xpath = "//input[@formcontrolname=\"extraSweepToken\"]")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_extrasweepToken;

	@FindBy(xpath = "//input[@formcontrolname=\"gameToken\"]")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_gameToken;

	@FindBy(xpath = "//div[contains(text(),'Games')]")
	@CacheLookup
	WebElement ViewLobby_Game;

	@FindBy(xpath = "//div[contains(text(),'Lobby Versions')]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Android\")]")
	@CacheLookup
	public static WebElement ViewLobby_LobbyVersion_Android;

	@FindBy(xpath = "(//div[@formgroupname=\"android\"]//following::input[contains(@class,'ng')])[1]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_Android_ReviewVersion;

	@FindBy(xpath = "(//div[@formgroupname=\"android\"]//following::input[contains(@class,'ng')])[2]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_Android_ProductionVersion;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"IOS\")]")
	@CacheLookup
	public static WebElement ViewLobby_LobbyVersion_ios;

	@FindBy(xpath = "(//div[@formgroupname=\"ios\"]//following::input[contains(@class,'ng')])[1]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_ios_ReviewVersion;

	@FindBy(xpath = "(//div[@formgroupname=\"ios\"]//following::input[contains(@class,'ng')])[2]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_ios_ProductionVersion;

	@FindBy(xpath = "(//button//span[contains(text(),'Delete')])[1]") // button[@type="button"]
	@CacheLookup
	public static WebElement DeleteVersion;

	// @FindBy(xpath="//div[contains(text(),'Store Bonus')]")
	@FindBy(xpath = "//button[contains(text(),'Bonus')]")
	@CacheLookup
	public WebElement ViewLobby_LobbyBonus;

	@FindBy(xpath = "//div[contains(text(),'Store Coupon')]")
	@CacheLookup
	WebElement ViewLobby_coupon;

	@FindBy(xpath = "//div[contains(text(),'Withdraw Settings')]")
	@CacheLookup
	WebElement ViewLobby_WithdrawSetting;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Withdraw Amount Details\")]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_Title;

	@FindBy(xpath = "//input[@formcontrolname=\"amount\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_amount;

	@FindBy(xpath = "//input[@formcontrolname=\"sweepTokens\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_sweepTokens;

	@FindBy(xpath = "//input[@formcontrolname=\"minimumAmountWithdrawal\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_minimumAmountWithdrawal;

	@FindBy(xpath = "//input[@formcontrolname=\"withdrawApprovalRequired\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_withdrawApprovalRequired;

	@FindBy(xpath = "//input[@formcontrolname=\"perTransactionLimit\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_PerTransactionLimit;

	@FindBy(xpath = "//input[@formcontrolname=\"perDayTransactionLimit\"]")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_perDayTransactionLimit;

	@FindBy(xpath = "//div[contains(text(),'App Settings')]")
	@CacheLookup
	WebElement ViewLobby_AppSetting;

	@FindBy(xpath = "//h3[text()='Edit News']")
	@CacheLookup
	public static WebElement ViewLobby_Appsetting_EditNewsLabel;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Information\")]")
	@CacheLookup
	public static WebElement ViewLobby_AppSetting_title;

	@FindBy(xpath = "//input[@formcontrolname='companyName']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_Company;

	@FindBy(xpath = "//input[@formcontrolname='website']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_website;

	@FindBy(xpath = "//input[@formcontrolname='termsCondition']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_TermsCondition;

	@FindBy(xpath = "//input[@formcontrolname='privacyPolicy']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_PrivacyPolicy;

	@FindBy(xpath = "//textarea[@formcontrolname='copyRights']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_copyRights;

	@FindBy(xpath = "//input[@formcontrolname='responsibleGamingLink']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_ResponsibleGamingLink;

	@FindBy(xpath = "//input[@formcontrolname='redemptionPolicyUrl']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_RedemptionPolicyLink;

	@FindBy(xpath = "//input[@formcontrolname='sweepRulesLink']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_SweepRulesLink;

	@FindBy(xpath = "//input[@formcontrolname='faqUrl']")
	@CacheLookup
	WebElement ViewLobby_AppSetting_faqUrl;

	@FindBy(xpath = "//div[contains(text(),'Website Settings')]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting;

	@FindBy(xpath = "//div[text()='Settings']")
	@CacheLookup
	WebElement ViewLobby_StoreSetting;

	@FindBy(xpath = "//div[contains(text(),'Tab Access')]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_TabAccess;

	@FindBy(xpath = "//div[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup;

	@FindBy(xpath = "//input[@formcontrolname=\"signUpTitle\"]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup_Title;

	@FindBy(xpath = "//textarea[@formcontrolname=\"signUpDescription\"]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup_Desc;

	@FindBy(xpath = "//div[text()=\"Corporation Details\"]")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails;

	@FindBy(xpath = "//div[contains(text(),'App Marketing')]")
	@CacheLookup
	WebElement AppMarketinglabel;

	@FindBy(xpath = "//input[@formcontrolname=\"name\"]")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_name;

	@FindBy(xpath = "//input[@formcontrolname=\"contactNumber\"]")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_contactNumber;

	@FindBy(xpath = "//input[@formcontrolname=\"email\"]")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_email;

	@FindBy(xpath = "//textarea[@formcontrolname=\"address\"]")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_address;

	// close games view popup
	@FindBy(xpath = "(//mat-icon[.='close'])[1]")
	@CacheLookup
	WebElement Popup_Close_Button;

	// close button for search
	@FindBy(xpath = "//mat-icon[text()='clear']")
	@CacheLookup
	WebElement Search_Close_Button;

	// search bar
	@FindBy(xpath = "//mat-icon[text()='search']")
	@CacheLookup
	WebElement Search_Button;

	// Cancel button
	@FindBy(xpath = "//span[contains(.,'Cancel')]") // button[@type='button']//following::span[text()=\"Cancel\"]
	@CacheLookup
	WebElement CancelButton;

	@FindBy(xpath = "(//button//span[text()='Delete'])[1]") // ->(//a[@title="Delete"])[1]
	@CacheLookup
	public WebElement Deletebutton;

	@FindBy(xpath = "(//span[contains(@class,'deleteActionIcon')])[1]") // ->(//a[@title="Delete"])[1]
	@CacheLookup
	public WebElement packageDeletebutton;

	@FindBy(xpath = "//button//span[text()='Delete']") // ->(//a[@title="Delete"])[1]
	@CacheLookup
	public WebElement Deleteappsetings;

	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	@CacheLookup
	public WebElement Deletebutton_websiteSetings;

	@FindBy(xpath = "(//table//tbody//tr[td[contains(@class,'mat-column-name')]]//td[2])[1]")
	@CacheLookup
	public static WebElement BonusName;

	@FindBy(xpath = "(//span[contains(@class,'deleteActionIcon')])[1]")
	@CacheLookup
	public WebElement Deletebutton_Lbonus;

	// master setting xpath
	// div[contains(@class,'notificationDropdown
	// ')]//child::a[contains(@href,'/setting/master-settings')]
	// a[contains(@href,'/setting/master-settings')]
	@FindBy(xpath = "//i[@class='ri-settings-2-line']")
	@CacheLookup
	public WebElement MasterSettings;

	@FindBy(xpath = "//span[@class=\"mat-button-wrapper\"]//span[contains(@class,\"user-name\")]//following-sibling::i")
	@CacheLookup
	public static WebElement UserProfile;

	public LobbyPage_Old MasterSettings_Click() throws InterruptedException {
		UserProfile.click();
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", MasterSettings);
		// MasterSettings.click();
		return this;
	}

	// Maintenance label
//	@FindBy(xpath="//div[contains(text(),'Lobby Maintenance')]")
//	@CacheLookup
//	public WebElement LobbyMaintenance_label;
//	
//	public LobbyPage LobbyMaintenance_Click()
//	 {
//		LobbyMaintenance_label.click();
//			return this;
//	 }

	public By LobbyMaintenance_label = By.xpath("//div[contains(text(),'Lobby Maintenance')]");

	public boolean LobbyMaintenanceLabel() {
		return ldriver.findElement(LobbyMaintenance_label).isDisplayed();
	}

	public LobbyPage_Old LobbyMaintenance_Click() {
		ldriver.findElement(LobbyMaintenance_label).click();
		return this;
	}

	// Lobby info
	@FindBy(xpath = "//div[contains(text(),'Lobby Info')]")
	@CacheLookup
	WebElement LobbyInfo;

	public LobbyPage_Old LobbyInfo_Click() {
		LobbyInfo.click();
		return this;
	}

	// general pages
	@FindBy(xpath = "//div[contains(text(),'General Pages')]")
	@CacheLookup
	WebElement GeneralPages;

	public LobbyPage_Old GeneralPages_Click() {
		GeneralPages.click();
		return this;
	}

	// Settings
	@FindBy(id = "nav-settings-tab")
	@CacheLookup
	WebElement Settings;

	public LobbyPage_Old Settings_Click() {
		Settings.click();
		return this;
	}

	// Settings IosUrl
	@FindBy(xpath = "//input[@formcontrolname=\"iosurl\"]")
	@CacheLookup
	public static WebElement iosurl;

	// Settings ios description
	@FindBy(xpath = "(//div[contains(@class,'NgxEditor__Content')])[2]")
	@CacheLookup
	public static WebElement iosDesc;

	public LobbyPage_Old Set_iosurl(String url) throws InterruptedException {
		iosurl.clear();
		Thread.sleep(500);
		iosurl.sendKeys(url);

		return this;
	}

	public LobbyPage_Old Set_iosDesc(String Desc) {
		iosDesc.clear();
		iosDesc.sendKeys(Desc);
		return this;
	}

	// Settings androidUrl
	@FindBy(xpath = "//input[@formcontrolname=\"androidUrl\"]")
	@CacheLookup
	public static WebElement androidUrl;

	// Settings android description
	@FindBy(xpath = "(//div[contains(@class,'NgxEditor__Content')])[1]")
	@CacheLookup
	public static WebElement androidDesc;

	public LobbyPage_Old Set_androidUrl(String url) throws InterruptedException {
		androidUrl.clear();
		Thread.sleep(1000);
		androidUrl.sendKeys(url);

		return this;
	}

	public LobbyPage_Old Set_androidDesc(String Desc) {
		androidDesc.clear();
		androidDesc.sendKeys(Desc);
		return this;
	}

	// click to homep page

	@FindBy(xpath = "//div[contains(text(),'Home Page')]")
	@CacheLookup
	WebElement HomePage_icon;

	public LobbyPage_Old Set_HomePage_icon() {
		HomePage_icon.click();
		return this;
	}

	// Settings HomePage icon
	@FindBy(xpath = "//input[@type=\"file\" or @formcontrolname=\"changephotoId\"]")
	@CacheLookup
	WebElement HomePage_photo;

	public LobbyPage_Old Set_HomePage_photo(String str) {
		HomePage_photo.clear();
		HomePage_photo.sendKeys(str);
		return this;
	}

	@FindBy(xpath = "//input[@type=\"file\"]")
	@CacheLookup
	WebElement AddMarketing_photo;

	public LobbyPage_Old setAddMarketing_photo(String str) {
		// AddMarketing_photo.clear();
		AddMarketing_photo.sendKeys(str);
		return this;
	}

	// Settings HomePage sub title
	@FindBy(xpath = "//input[@formcontrolname=\"subtitle\"]")
	@CacheLookup
	WebElement HomePage_subtitle;

	public LobbyPage_Old Set_HomePage_subtitle(String name) {
		HomePage_subtitle.clear();
		HomePage_subtitle.sendKeys(name);
		return this;

	}

	// Settings HomePage buttonText
	@FindBy(xpath = "//input[@formcontrolname=\"buttonText\"]")
	@CacheLookup
	WebElement HomePage_buttonText;

	public LobbyPage_Old Set_HomePage_buttonText(String name) {
		HomePage_buttonText.clear();
		HomePage_buttonText.sendKeys(name);
		return this;

	}

	// Settings HomePage buttonUrl
	@FindBy(xpath = "//input[@formcontrolname=\"buttonUrl\"]")
	@CacheLookup
	WebElement HomePage_buttonUrl;

	public LobbyPage_Old Set_HomePage_buttonUrl(String name) {
		HomePage_buttonUrl.clear();
		HomePage_buttonUrl.sendKeys(name);
		return this;
	}

	// Settings MetaData
	@FindBy(xpath = "//div[text()=\"Meta Data\"]")
	@CacheLookup
	WebElement MetaData;

	public LobbyPage_Old Set_MetaData() {
		MetaData.click();
		return this;
	}

	// Settings MetaData tags
	@FindBy(xpath = "//input[contains(@placeholder,\"Enter Tags\")]")
	@CacheLookup
	WebElement MetaData_tags;

	public LobbyPage_Old Set_MetaData_tags(String str) {
		MetaData_tags.clear();
		MetaData_tags.sendKeys(str);
		return this;
	}

	// Settings MetaData page selection
	@FindBy(xpath = "//mat-select[@formcontrolname='page']//parent::span[contains(@class,'mat-select-placeholder')]")
	@CacheLookup
	WebElement MetaData_Page;

	// settigns metadata select page
	@FindBy(xpath = "//mat-option//span[text()=\"Redemption Policy\"]") // span[.='FAQ']
	@CacheLookup
	public static WebElement select_page;

	public LobbyPage_Old Set_MetaData_Page(String str) {
//		MetaData_Page.click();
//		select_page.sendKeys(str);

		MetaData_Page.click();
		ldriver.findElement(By.xpath("//mat-option/span[text()='" + str + "']")).click();
		return this;
	}

	// Settings Release Notes
	@FindBy(xpath = "//div[text()=\"Release Notes\"]")
	@CacheLookup
	WebElement ReleaseNotes;

	public LobbyPage_Old Set_ReleaseNotes() {
		ReleaseNotes.click();
		return this;
	}

	// Settings Release Notes(textfield)
	@FindBy(xpath = "//input[@formcontrolname=\"releaseNote\"]")
	@CacheLookup
	WebElement Release_input;

	public LobbyPage_Old Set_Release_input(String str) {
		Release_input.clear();
		Release_input.sendKeys(str);
		return this;
	}

	// Settings MetaData Release url(textfield)
	@FindBy(xpath = "//input[@formcontrolname=\"url\"]")
	@CacheLookup
	WebElement Release_url;

	public LobbyPage_Old Set_Release_url(String str) {
		Release_url.clear();
		Release_url.sendKeys(str);
		return this;
	}

	public LobbyPage_Old Player_Registration_Link(String desc) {
		Player_Registration_Link.clear();
		Player_Registration_Link.sendKeys(desc);
		return this;
	}

	public LobbyPage_Old selectTabLCode() {
		Lname.sendKeys(Keys.TAB);
		return this;
	}

	public LobbyPage_Old Enter_Lname() {
		Lname.sendKeys(Keys.ENTER);
		return this;
	}

	public LobbyPage_Old SelectTabLanme() {
		Lname.sendKeys(Keys.TAB);
		return this;
	}

	public LobbyPage_Old ClickDesc(String desc) {
		description.clear();
		description.click();
		description.sendKeys(desc);
		return this;
	}

	public LobbyPage_Old Maintenance_Desc(String desc) {
		description.clear();
		description.sendKeys(desc);
		return this;
	}

	public LobbyPage_Old ClickDesc_News() {
		description_news.click();
		return this;
	}

	public LobbyPage_Old clicklobbymanagement() {
		StoreManagement.click();
		return this;
	}

	public LobbyPage_Old clickStoreAccounts() {
		StoreAccounts.click();
		return this;
	}

	public LobbyPage_Old clickToCreate() {
		Create_Button.click();
		return this;
	}

	public LobbyPage_Old clickAddPlayerURL() {
		AddPlayerURL.click();
		return this;
	}

	public LobbyPage_Old clickToEdit() {
		System.out.println("click to edit call");
		EditButton.click();
		return this;
	}

	public LobbyPage_Old clickToEdit_News() {
		System.out.println("click to edit call news");
		EditButton.click();
		return this;
	}

	public LobbyPage_Old clickToEdit_FAQ() {
		System.out.println("click to edit FAQ");
		EditButton1.click();
		return this;
	}

	public LobbyPage_Old clickCopyLobby() {
		CopyLobby.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby() {
		View_Click.click();
		return this;
	}

	public LobbyPage_Old clickViewMaintenance() {
		View_Maintenance.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_Profile() {
		// System.out.println(" click = " +
		// ldriver.findElement(By.xpath("//div[contains(text(),'Profile')]")).getText());
		ViewLobby_Profile.click();
		return this;

	}

	public LobbyPage_Old clickView_LobbyStorePackage() {
		ViewLobby_storePackage.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_LobbyCPackage() {
		ViewLobby_LobbyCPackage.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_Game() {
		System.out
				.println("games click = " + ldriver.findElement(By.xpath("//div[contains(text(),'Games')]")).getText());
		ViewLobby_Game.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_ReviewVersion_Android(String text) {
		ViewLobby_LobbyVersion_Android_ReviewVersion.clear();
		ViewLobby_LobbyVersion_Android_ReviewVersion.sendKeys(text);
		return this;
	}

	public LobbyPage_Old clickViewLobby_ProductionVersion_Android(String text) {
		ViewLobby_LobbyVersion_Android_ProductionVersion.clear();
		ViewLobby_LobbyVersion_Android_ProductionVersion.sendKeys(text);
		return this;
	}

	public LobbyPage_Old clickViewLobby_ReviewVersion_IOS(String text) {
		ViewLobby_LobbyVersion_ios_ReviewVersion.clear();
		ViewLobby_LobbyVersion_ios_ReviewVersion.sendKeys(text);
		return this;
	}

	public LobbyPage_Old clickViewLobby_ProductionVersion_IOS(String text) {
		ViewLobby_LobbyVersion_ios_ProductionVersion.clear();
		ViewLobby_LobbyVersion_ios_ProductionVersion.sendKeys(text);
		return this;
	}

	public LobbyPage_Old clickViewLobby_Version() {
		ViewLobby_LobbyVersion.click();
		return this;
	}

	public LobbyPage_Old DeleteVersion() {
		DeleteVersion.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_Bonus() {
		ViewLobby_LobbyBonus.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_coupon() {
		ViewLobby_coupon.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_Withdraw() {
		ViewLobby_WithdrawSetting.click();
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_amount(String s) {
		ViewLobby_WithdrawSetting_amount.clear();
		ViewLobby_WithdrawSetting_amount.sendKeys(s);
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_sweepTokens(String s) {
		ViewLobby_WithdrawSetting_sweepTokens.clear();
		ViewLobby_WithdrawSetting_sweepTokens.sendKeys(s);
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_minimumAmountWithdrawal(String s) {
		ViewLobby_WithdrawSetting_minimumAmountWithdrawal.clear();
		ViewLobby_WithdrawSetting_minimumAmountWithdrawal.sendKeys(s);
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_withdrawApprovalRequired(String s) {
		ViewLobby_WithdrawSetting_withdrawApprovalRequired.clear();
		ViewLobby_WithdrawSetting_withdrawApprovalRequired.sendKeys(s);
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_PerTransactionLimit(String s) {
		ViewLobby_WithdrawSetting_PerTransactionLimit.clear();
		ViewLobby_WithdrawSetting_PerTransactionLimit.sendKeys(s);
		return this;
	}

	public LobbyPage_Old ViewLobby_WithdrawSetting_perDayTransactionLimit(String s) {
		ViewLobby_WithdrawSetting_perDayTransactionLimit.clear();
		ViewLobby_WithdrawSetting_perDayTransactionLimit.sendKeys(s);
		return this;
	}

	public LobbyPage_Old clickViewLobby_AppSetting() {
		ViewLobby_AppSetting.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_WebsiteSetting() {
		ViewLobby_WebsiteSetting.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_StoreSetting() {
		ViewLobby_StoreSetting.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_WebsiteSetting_TabAccess() {
		ViewLobby_WebsiteSetting_TabAccess.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_WebsiteSetting_Signup() {
		ViewLobby_WebsiteSetting_Signup.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_WebsiteSetting_Signup_details(String title, String desc) {
		ViewLobby_WebsiteSetting_Signup_Title.clear();
		ViewLobby_WebsiteSetting_Signup_Desc.clear();
		ViewLobby_WebsiteSetting_Signup_Title.sendKeys(title);
		ViewLobby_WebsiteSetting_Signup_Desc.sendKeys(desc);
		return this;
	}

	public LobbyPage_Old clickViewLobby_CorporationDetails() {
		ViewLobby_CorporationDetails.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_AppMarketing() {
		AppMarketinglabel.click();
		return this;
	}

	public LobbyPage_Old clickViewLobby_CorporationDetails_name(String name) {
		ViewLobby_CorporationDetails_name.clear();
		ViewLobby_CorporationDetails_name.sendKeys(name);
		return this;
	}

	public LobbyPage_Old clickViewLobby_CorporationDetails_contactNumber(String contactNumber) {
		ViewLobby_CorporationDetails_contactNumber.clear();
		ViewLobby_CorporationDetails_contactNumber.sendKeys(contactNumber);
		return this;
	}

	public LobbyPage_Old clickViewLobby_CorporationDetails_email(String email) {
		ViewLobby_CorporationDetails_email.clear();
		ViewLobby_CorporationDetails_email.sendKeys(email);
		return this;
	}

	public LobbyPage_Old clickViewLobby_CorporationDetails_address(String address) {
		ViewLobby_CorporationDetails_address.clear();
		ViewLobby_CorporationDetails_address.sendKeys(address);
		return this;
	}

	public LobbyPage_Old ClickToSave() {
		Save_Button.click();
		return this;
	}

	public LobbyPage_Old ClickToSave_GeneralPages() {
		Save_Button_GeneralPages.click();
		return this;
	}

	public LobbyPage_Old ClickToYes() {
		clickyes.click();
		return this;
	}

	public LobbyPage_Old ClickToSavePromotion() {
		Save_Button_Promotion.click();
		return this;
	}

	public LobbyPage_Old ClickToSaveFAQ() {
		Save_Button1.click();
		return this;
	}

	public LobbyPage_Old clickAppBased() {
		AppBasedradio.click();
		return this;
	}

	public static void clickOwnerBased() {
		OwenerBasedradio.click();
	}

	public LobbyPage_Old Setlobbycode(String code) {
		Lcode.clear();
		Lcode.sendKeys(code);
		return this;
	}

	public LobbyPage_Old Set_Desc(String desc) {
		description.clear();
		description.sendKeys(desc);
		return this;
	}

	public LobbyPage_Old clicklobbysave() {
		Lobbysave.click();
		return this;
	}

	public LobbyPage_Old Setlobbyname(String name) {
		Lname.clear();
		Lname.sendKeys(name);
		return this;

	}

	public LobbyPage_Old clickTo_PlayerCoupon() {

		PlayerCoupon.click();
		return this;

	}

	public void LobbySave() {
		// WebElement ele =
		// driver.findElement(By.xpath("//div[4]/div/div/div[2]/button/span"));
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", Lobbysave);

	}

	public LobbyPage_Old clickViewLobby_Search(String key) {
		try {
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.clear();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.click();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(key);
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			// System.out.println("search \"FOT\"- games");
		} catch (Exception e) {
			System.out.println("error in search");

		}
		return this;
	}

	public LobbyPage_Old SearchItems(String key) {
		try {
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.clear();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.click();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(key);
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// System.out.println("search \"FOT\"- games");

		} catch (Exception e) {
			System.out.println("error in search");

		}
		return this;
	}

	public LobbyPage_Old Searchjackpot(String key) {
		try {
			ldriver.findElement(
					By.xpath("//div[contains(@class,'gmuSearchBlock')]//following::input[contains(@class,'ng')]"))
					.clear();
			ldriver.findElement(
					By.xpath("//div[contains(@class,'gmuSearchBlock')]//following::input[contains(@class,'ng')]"))
					.click();
			ldriver.findElement(
					By.xpath("//div[contains(@class,'gmuSearchBlock')]//following::input[contains(@class,'ng')]"))
					.sendKeys(key);
			ldriver.findElement(
					By.xpath("//div[contains(@class,'gmuSearchBlock')]//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			// System.out.println("search \"FOT\"- games");
			// div[contains(@class,'gmuSearchBlock')]//following::input[contains(@class,'ng')]
		} catch (Exception e) {
			System.out.println("error in search");

		}
		return this;
	}

	public LobbyPage_Old clickToViewPurchaseHistory() {
		ViewPurchaseHistory.click();
		return this;
	}

	public LobbyPage_Old clickToViewCustomPurchaseHistory() {
		ViewCustomPurchaseHistory.click();
		return this;
	}

	public LobbyPage_Old clickToViewCouponAppliedHistory() {
		ViewCouponAppliedHistory.click();
		return this;
	}

	public LobbyPage_Old clickClearSearch() {
		ClearSearch.click();
		return this;
	}

	public LobbyPage_Old View_Click() {
		View_Click.click();
		return this;
	}

	public LobbyPage_Old ClickToClose() {
		Popup_Close_Button.click();
		return this;
	}

	public LobbyPage_Old ClickToClose_Search() {
		Search_Close_Button.click();
		return this;
	}

	public LobbyPage_Old ClickToCancel() {
		CancelButton.click();
		return this;
	}

	public LobbyPage_Old clickTo_CreateBonus() {
		Create_Button.click();
		return this;
	}

	public LobbyPage_Old setBonusName(String name) {
		Name.clear();
		Name.sendKeys(name);
		return this;
	}

	public LobbyPage_Old setcouponName(String name) {
		Name.clear();
		Name.sendKeys(name);
		return this;
	}

	public LobbyPage_Old Setcoupon_discountedPercentage(String percentage) {
		discountedPercentage.clear();
		discountedPercentage.sendKeys(percentage);
		return this;

	}

	public LobbyPage_Old Setcoupon_expiryAt() {
		expiryAt.click();
		ldriver.findElement(By.xpath("//div[contains(text(),'28')]")).click();
		// ldriver.findElement(By.xpath("//div[contains(text(),' "+percentage+"
		// ')]")).click();
		// expiryAt.sendKeys(percentage);
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname=\"startsAt\"]")
	@CacheLookup
	public static WebElement StartDate;

	public LobbyPage_Old Setcoupon_startDate(String date) {
		StartDate.click();
		ldriver.findElement(By.xpath("//div[contains(text(),'" + date + "')]")).click();
		// ldriver.findElement(By.xpath("//div[contains(text(),' "+percentage+"
		// ')]")).click();
		// expiryAt.sendKeys(percentage);
		return this;
	}

	public LobbyPage_Old purchaseDay(String day) {
		// ldriver.findElement(By.xpath("//input[@type='checkbox']//preceding::div[contains(text(),'"+day+"')]")).click();

		// ldriver.findElement(By.xpath("//input[@type='checkbox']//ancestor::mat-checkbox[@name='"+day+"']")).click();
		return this;
	}

	public LobbyPage_Old Setcoupon_usageByPlayer(String coupon) {
		usageByPlayer.clear();
		usageByPlayer.sendKeys(coupon);
		return this;

	}

	public LobbyPage_Old Setcoupon_activationAfterPurchase(String coupon) {
		activationAfterPurchase.clear();
		activationAfterPurchase.sendKeys(coupon);
		return this;

	}

	public LobbyPage_Old setBonusAction(String Action) throws InterruptedException {
		var_Action.click();
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//span[contains(text(),'" + Action + "')]")).click();
		// select_Action.click();
		return this;
	}

	public LobbyPage_Old setactionUrl(String Action) throws InterruptedException {
		var_Actionurl.click();
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//span[contains(text(),'" + Action + "')]")).click();
		// select_Action.click();
		return this;
	}

	public LobbyPage_Old gameToken(String token) {
		select_GameToken.clear();
		select_GameToken.sendKeys(token);
		return this;
	}

	public LobbyPage_Old sweepToken(String token) {
		select_SweepToken.clear();
		select_SweepToken.sendKeys(token);
		return this;
	}

	public LobbyPage_Old clickToNews() {
		news.click();
		return this;
	}

	public LobbyPage_Old clickToFAQ() {
		faq.click();
		return this;
	}

	public LobbyPage_Old clickToPromotion() {
		Promotion.click();
		return this;
	}

	public LobbyPage_Old SetNewsTitle(String name) {
		Create_title.clear();
		Create_title.sendKeys(name);
		return this;

	}

	public LobbyPage_Old SetFAQques(String name) {
		Create_question.clear();
		Create_question.sendKeys(name);
		return this;

	}

	public LobbyPage_Old SetFAQanswer(String name) {
		Create_answer.clear();
		Create_answer.sendKeys(name);
		return this;

	}

	public LobbyPage_Old SetCategory() throws InterruptedException {

		faqCategory.click();

		ldriver.findElement(By.xpath("//mat-option/span[text()=\"Account\"]")).click();
		return this;

	}

	public LobbyPage_Old SetOrder(String order) {
		SetOrder.sendKeys(order);
		return this;

	}

	public LobbyPage_Old SetNewsicon(String name) {
		// ((JavascriptExecutor) ldriver).executeScript(" return
		// document.getElementsByName('//input[@name=\"fileHidden\"]').item(0).value =
		// '';");
		// String s=((JavascriptExecutor) ldriver).executeScript(" return
		// document.getElementsByName('//input[@name=\"fileHidden\').value").toString();
		// Create_icon.clear();
		Create_icon.sendKeys(name);
		// Create_icon.click();
		return this;

	}

	public LobbyPage_Old packageDeleteItems() {
		packageDeletebutton.click();
		return this;
	}

	public LobbyPage_Old Deleteappsetings() {
		Deleteappsetings.click();
		return this;
	}

	public LobbyPage_Old DeleteItems_Lobby() {
		Deletebutton_Lbonus.click();
		return this;
	}

	public LobbyPage_Old DeleteClick_websiteSetings() {
		Deletebutton_websiteSetings.click();
		return this;
	}

	public void searchlist(String searchKey, String expectedresult, WebDriver driver) {
		// Webdriver wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		// wait until the search box is displayed
		WebElement searchlist = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")));
		// clear and enter the search word
		searchlist.clear();
		searchlist.sendKeys(searchKey);
		// hit enter
		searchlist.sendKeys(Keys.RETURN);
		// wait until the search results is displayed with the expected result
		// //table//tbody//tr[td[contains(.,'Cosmoslots')]]
		java.util.List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//table//tbody//tr[td[contains(.,'" + expectedresult + "')]]")));
		// check if there is any matching elements
		if (elements.size() > 0) {
			System.out.println("Search is passed");
		} else {

			System.out.println("Search is failed");

		}
	}

	public LobbyPage_Old AppSetting_Company(String name) {
		ViewLobby_AppSetting_Company.clear();
		ViewLobby_AppSetting_Company.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_website(String name) {
		ViewLobby_AppSetting_website.clear();
		ViewLobby_AppSetting_website.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_TermsCondition(String name) {
		ViewLobby_AppSetting_TermsCondition.clear();
		ViewLobby_AppSetting_TermsCondition.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_PrivacyPolicy(String name) {
		ViewLobby_AppSetting_PrivacyPolicy.clear();
		ViewLobby_AppSetting_PrivacyPolicy.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_copyRights(String name) {
		ViewLobby_AppSetting_copyRights.clear();
		ViewLobby_AppSetting_copyRights.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_ResponsibleGamingLink(String name) {
		ViewLobby_AppSetting_ResponsibleGamingLink.clear();
		ViewLobby_AppSetting_ResponsibleGamingLink.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_RedemptionPolicyLink(String name) {
		ViewLobby_AppSetting_RedemptionPolicyLink.clear();
		ViewLobby_AppSetting_RedemptionPolicyLink.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_SweepRulesLink(String name) {
		ViewLobby_AppSetting_SweepRulesLink.clear();
		ViewLobby_AppSetting_SweepRulesLink.sendKeys(name);
		return this;

	}

	public LobbyPage_Old AppSetting_faqUrl(String name) {
		ViewLobby_AppSetting_faqUrl.clear();
		ViewLobby_AppSetting_faqUrl.sendKeys(name);
		return this;

	}

	public LobbyPage_Old LobbyPackage_Code(String name) {
		Lcode.clear();
		Lcode.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_name(String name) {
		Lname.clear();
		Lname.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_amount(String name) {
		ViewLobby_LobbyPackage_amount.clear();
		ViewLobby_LobbyPackage_amount.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_Sweeptoken(String name) {
		ViewLobby_LobbyPackage_sweepToken.clear();
		ViewLobby_LobbyPackage_sweepToken.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_extraSweeptoken(String name) {
		ViewLobby_LobbyPackage_extrasweepToken.clear();
		ViewLobby_LobbyPackage_extrasweepToken.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_Gametoken(String name) {
		ViewLobby_LobbyPackage_gameToken.clear();
		ViewLobby_LobbyPackage_gameToken.sendKeys(name);
		return this;
	}

	public LobbyPage_Old LobbyPackage_discountAmount(String name) {
		ViewLobby_LobbyPackage_discountAmount.clear();
		ViewLobby_LobbyPackage_discountAmount.sendKeys(name);
		return this;
	}

	public LobbyPage_Old setCountry() throws InterruptedException {
		Country.click();
		// SetCountry.sendKeys(country);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"United States\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Canada\"]")).click();
		SetCountry.sendKeys(Keys.ESCAPE);

		return this;
	}

	// announcement code
	@FindBy(xpath = "//mat-select[@formcontrolname=\"announcementCategory\"]")
	@CacheLookup
	private WebElement AnnouncementCategory;

	@FindBy(xpath = "//span[contains(text(),\"Game Update\")]")
	@CacheLookup
	public static WebElement Select_AnnouncementCategory;

	public LobbyPage_Old Select_AnnouncementCategory_Announcement(String category) throws InterruptedException {
		AnnouncementCategory.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + category + "')]")).click();
		Thread.sleep(300);
		// Select_AnnouncementCategory.sendKeys(Keys.ESCAPE);

		return this;
	}

	@FindBy(xpath = "//mat-select[@formcontrolname=\"lobbyCode\"]")
	@CacheLookup
	private WebElement StoreAccount;

	@FindBy(xpath = "//span[contains(text(),\"CosmoSlot\")]")
	@CacheLookup
	public static WebElement Select_StoreAccount;

	public LobbyPage_Old SelectStoreAccount_Announcement(String code) throws InterruptedException {
		StoreAccount.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + code + "')]")).click();
		Thread.sleep(300);
		// Select_StoreAccount.sendKeys(Keys.ESCAPE);

		return this;
	}

	public LobbyPage_Old setGames(String str) throws InterruptedException {

		Games.click();
		Thread.sleep(200);
		SetGames.click();
		Thread.sleep(200);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()='"+str+"']")).click();

//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Cash War\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Lucky Gems\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gladiator\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Machu Picchu\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Narcos\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Fortune Teller\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Buffalo Legion\"]")).click();

//        SetGames.sendKeys(Keys.RETURN);
// 		  SetGames.click();

		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));

		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				// print all store package from admin
				// System.out.println(inputElement.getText());
				// shift.add(inputElement.getText().toUpperCase());
				// TotalStorePackage++;
				inputElement.click();
			}

			System.out.println(boxes.size() + " Games found by className \n");
		}

		Thread.sleep(2000);

		SetGames.sendKeys(Keys.TAB);

		return this;
	}

	public LobbyPage_Old setKenoGames(String str) throws InterruptedException {

		KenoGames.click();
		Thread.sleep(200);
		KenoSetGames.click();
		Thread.sleep(200);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()='"+str+"']")).click();

//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Cash War\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Lucky Gems\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gladiator\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Machu Picchu\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Narcos\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Fortune Teller\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Buffalo Legion\"]")).click();

//        SetGames.sendKeys(Keys.RETURN);
// 		  SetGames.click();

		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));

		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				// print all store package from admin
				// System.out.println(inputElement.getText());
				// shift.add(inputElement.getText().toUpperCase());
				// TotalStorePackage++;
				inputElement.click();
			}

			System.out.println(boxes.size() + " Games found by className \n");
		}

		Thread.sleep(2000);

		KenoSetGames.sendKeys(Keys.TAB);

		return this;
	}

	public LobbyPage_Old Click_Maintenance_platform() throws InterruptedException {

		// input[@type='checkbox']//ancestor::mat-slide-toggle[@formcontrolname=\"isMaintenance\"]

		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", ldriver.findElement(By.xpath("(//input[@type='checkbox'])[1]")));

		Thread.sleep(200);
		// web.click(); Thread.sleep(200);
		android.click();
		Thread.sleep(200);
		ios.click();

		return this;
	}

	public void ApplyCouponCode(String Code) throws IOException, InterruptedException {
		ldriver.findElement(By.xpath("//input[@placeholder=\"coupon code\"]")).sendKeys(Code);
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(2000);
	}

//	public boolean verifyElementAbsent(String locator) throws Exception {
//
//        boolean visible = ldriver.findElement(By.xpath(locator)).isDisplayed();
//        boolean result = !visible;
//        System.out.println(result);
//        
//        return result;
//}
//	public String getPassword()
//	{
//		return txtPassword.getText();
//	}	
	// System.out.println("search \"FOT\"- games");

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname=\"userRole\"]")
	@CacheLookup
	public WebElement role;

	// @FindBy(xpath =
	// "//mat-select[@formcontrolname=\"userRole\"]//following::span[contains(text(),\"Store\")]")
	@FindBy(xpath = "//mat-select[@formcontrolname=\"userRole\"]//following::mat-option[2]")
	@CacheLookup
	public static WebElement RoleSelect;

	public LobbyPage_Old selectRole(String str) throws InterruptedException {

		Thread.sleep(1000);
		role.click();
		// RoleSelect.sendKeys(str);
		Thread.sleep(500);

		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname=\"userRole\"]//following::span[text()='" + str + "']")).click();
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"United States\"]")).click();
//        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Canada\"]")).click();
		// RoleSelect.sendKeys(Keys.ESCAPE);

		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname=\"userId\"]")
	@CacheLookup
	public WebElement userid;

	// @FindBy(xpath =
	// "//mat-select[@formcontrolname=\"userId\"]//following::span[text()=\"cosmoslotstore
	// \"]")
	@FindBy(xpath = "//mat-select[@formcontrolname=\"userId\"]//following::mat-option[2]")
	@CacheLookup
	public static WebElement userSelect;

	public LobbyPage_Old selectUsername(String str) throws InterruptedException {
		Thread.sleep(1000);
		userid.click();
		Thread.sleep(500);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname=\"userId\"]//following::span[contains(text(),'" + str + "')]"))
				.click();
		return this;
	}

	public LobbyPage_Old selectpos(String str) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@formcontrolname=\"posId\"]")).click();
		// RoleSelect.sendKeys(str);
		Thread.sleep(1000);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname=\"posId\"]//following::span[contains(text(),'" + str + "')]"))
				.click();
		// Thread.sleep(300);
		// RoleSelect.sendKeys(Keys.DOWN,Keys.ENTER);

		// userSelect.sendKeys(Keys.ESCAPE);
		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname=\"couponActivation\"]")
	@CacheLookup
	public WebElement coupontype;

	public LobbyPage_Old selectCouponType(String str) throws InterruptedException {
		coupontype.click();
		// RoleSelect.sendKeys(str);
		Thread.sleep(500);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname=\"couponActivation\"]//following::span[text()='" + str + "']"))
				.click();
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
//	        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
//	        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"United States\"]")).click();
//	        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Canada\"]")).click();
		// userSelect.sendKeys(Keys.ESCAPE);
		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//button[contains(text(),'Lobby Jackpot')]")
	@CacheLookup
	WebElement ClickOnJackpotHeader;

	public LobbyPage_Old ClickOnJackpot() {
		ClickOnJackpotHeader.click();
		return this;
	}

	@FindBy(xpath = "//input[@value=\"GAME_TOKEN\"]")
	@CacheLookup
	public static WebElement GAME_TOKEN_Radio;

	@FindBy(xpath = "//input[@value=\"SWEEP_TOKEN\"]")
	@CacheLookup
	public static WebElement SWEEP_TOKEN_Radio;

	public LobbyPage_Old selectGTST(String str) throws InterruptedException {
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='" + str + "']")).click();

		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname=\"jackpotInitialValue\"]")
	@CacheLookup
	WebElement jackpotInitialValue;

	public LobbyPage_Old Jackpot_InitialValue(String val) {
		jackpotInitialValue.clear();
		jackpotInitialValue.sendKeys(val);
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname=\"rewardPercentage\"]")
	@CacheLookup
	WebElement jackpotrewardPercentage;

	public LobbyPage_Old Jackpot_rewardPercentage(String pr) {
		jackpotrewardPercentage.clear();
		jackpotrewardPercentage.sendKeys(pr);
		return this;
	}

	@FindBy(xpath = "//h3[text()='Package Purchase History']//preceding::a[@title='Back'][1]")
	@CacheLookup
	public WebElement BackBtn;

	public LobbyPage_Old ClickOnBack(String modules) {
		ldriver.findElement(By.xpath("//h3[text()='" + modules + "']//preceding::a[@title='Back'][1]")).click();
		// BackBtn.click();
		return this;
	}

	public LobbyPage_Old DeleteItems() {
		Deletebutton.click();
		return this;
	}

	public LobbyPage_Old setBonusAction() throws InterruptedException {
		var_Action.click();
		Thread.sleep(1000);
		select_Action.click();
		return this;
	}

	public LobbyPage_Old GoToStoreView(String storeName) throws InterruptedException {
		PlayerProfile pp = new PlayerProfile(ldriver);
		CommonCosmo cc = new CommonCosmo(ldriver);

		StoreManagement.click();
		explicitWait(ldriver, StoreAccounts, 10);
		StoreAccounts.click();
		explicitWait(ldriver, cc.StoreManagement_Header, 10);
		SearchItems(storeName);
		Thread.sleep(3000);
		explicitWait(ldriver, pp.EyeIcon, 10);
		ldriver.findElement(By.xpath("(//*[contains(text(),'" + storeName + "')]//following::a[@title='View'])[1]"))
				.click();
		// EyeIcon.click();
		Thread.sleep(3000);
		return this;

	}

	@FindBy(xpath = "//h3[normalize-space()='Edit Store']")
	private WebElement EditStore_header;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname='cashOnly']")
	public WebElement cashOnly_toggle;
	
	public LobbyPage_Old GoToStoreEdit(String storeName) throws InterruptedException {
		CommonCosmo cc = new CommonCosmo(ldriver);

		StoreManagement.click();
		explicitWait(ldriver, StoreAccounts, 10);
		StoreAccounts.click();
		explicitWait(ldriver, cc.StoreManagement_Header, 10);
		SearchItems(storeName);
		explicitWait(ldriver, EditButton, 10);
		EditButton.click();
		explicitWait(ldriver, EditStore_header, 10);
		return this;

	}
	public LobbyPage_Old CreateBonusLevel(String bonusName, String numRefferal, String rechargeAmount, String st, String gt)
			throws InterruptedException {

		ldriver.findElement(By.xpath("//button[@title='Create New']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//input[@formcontrolname='name']")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(bonusName);
		ldriver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']")).sendKeys(numRefferal);
		ldriver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).sendKeys(rechargeAmount);
		ldriver.findElement(By.xpath("//input[@formcontrolname='gameTokens']")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname='gameTokens']")).sendKeys(gt);
		ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).sendKeys(st);
		ldriver.findElement(By.xpath("//textarea[@formcontrolname='description']")).click();
		ldriver.findElement(By.xpath("//textarea[@formcontrolname='description']")).sendKeys(bonusName);
		ldriver.findElement(By.xpath("//span[text()='Save']")).click();
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	public static WebElement levelName;

	public LobbyPage_Old CreateBonusLevel2(String bonusName, String numRefferal, String rechargeAmount, String st,
			String gt) throws InterruptedException {

		ldriver.findElement(By.xpath("//button[@title='Create New']")).click();
		Thread.sleep(1000);
		levelName.click();
		levelName.sendKeys(bonusName);
		levelName.sendKeys(Keys.TAB + numRefferal);
		levelName.sendKeys(Keys.TAB);
		levelName.sendKeys(Keys.TAB + rechargeAmount);
		levelName.sendKeys(Keys.TAB);
		levelName.sendKeys(Keys.TAB + gt);
		levelName.sendKeys(Keys.TAB);
		levelName.sendKeys(Keys.TAB + st);
		levelName.sendKeys(Keys.TAB);
		levelName.sendKeys(Keys.TAB + bonusName);

		// ldriver.findElement(By.xpath("//inp ut[@formcontrolname='name']")).click();
		// ldriver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(bonusName);
//			ldriver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']")).click();
//			ldriver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']")).sendKeys(numRefferal);
//			ldriver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).click();
//			ldriver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).sendKeys(rechargeAmount);
//			ldriver.findElement(By.xpath("//input[@formcontrolname='gameTokens']")).click();
//			ldriver.findElement(By.xpath("//input[@formcontrolname='gameTokens']")).sendKeys(gt);
//			ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).click();
//			ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).sendKeys(st);
//			ldriver.findElement(By.xpath("//textarea[@formcontrolname='description']")).click();
//			ldriver.findElement(By.xpath("//textarea[@formcontrolname='description']")).sendKeys(bonusName);
		ldriver.findElement(By.xpath("//span[text()='Save']")).click();
		return this;
	}

	public void explicitWait(WebDriver ldriver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	// MDB

	@FindBy(xpath = "//span[text()='Multiple Deposit Bonus']") // input[@value='MULTIPLE_DEPOSIT_BONUS']
	private WebElement RadioBtn_MULTIPLE_DEPOSIT_BONUS;

	public LobbyPage_Old SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS() {
		RadioBtn_MULTIPLE_DEPOSIT_BONUS.click();
		return this;

	}

	@FindBy(xpath = "//span[text()='Multiple']")
	private WebElement RadioBtn_MULTIPLE_BONUS;

	public LobbyPage_Old SelectRadioBtn_MULTIPLE_BONUS() {
		RadioBtn_MULTIPLE_BONUS.click();
		return this;

	}

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[1]")
	@CacheLookup
	private WebElement startDateCalendar;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[2]")
	@CacheLookup
	private WebElement expiryDateCalendar;
	
	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[3]")
	@CacheLookup
	private WebElement customStartDateCalendar;

	@FindBy(xpath = "(//button[@aria-label='Open calendar'])[4]")
	@CacheLookup
	private WebElement customEexpiryDateCalendar;

	public LobbyPage_Old ClickonStartDateCalendar() {
		startDateCalendar.click();
		return this;
	}

	public LobbyPage_Old ClickonExpiryDateCalendar() {
		expiryDateCalendar.click();
		return this;
	}
	
	public LobbyPage_Old ClickonCustomStartDateCalendar() {
		customStartDateCalendar.click();
		return this;
	}

	public LobbyPage_Old ClickonCustomExpiryDateCalendar() {
		customEexpiryDateCalendar.click();
		return this;
	}

	@FindBy(xpath = "//mat-select[@formcontrolname='event']")
	@CacheLookup
	private WebElement event;

	public LobbyPage_Old selectEventType(String eventType) throws InterruptedException {
		event.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='event']//following::mat-option[contains(.,'" + eventType + "')]")).click();

		return this;

	}

	@FindBy(xpath = "//mat-select[@formcontrolname='traceType']")
	@CacheLookup
	private WebElement traceType;

	public LobbyPage_Old selectTraceType(String trace_Type) throws InterruptedException {
		traceType.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath(
				"//mat-select[@formcontrolname='event']//following::mat-option[contains(.,'" + trace_Type + "')]"))
				.click();

		return this;

	}

	@FindBy(xpath = "//mat-select[@formcontrolname='games']")
	@CacheLookup
	private WebElement games;

	@FindBy(xpath = "(//input[@formcontrolname='gameTokenGameplayCount'])[1]")
	@CacheLookup
	private WebElement gameTokenGameplayCount;

	@FindBy(xpath = "(//input[@formcontrolname='sweepTokenGameplayCount'])[1]")
	@CacheLookup
	private WebElement sweepTokenGameplayCount;

	@FindBy(xpath = "//input[@placeholder='Search Game']")
	@CacheLookup
	private WebElement SearchGame;

//		public LobbyPage Set_SpintEventConfiguration(String Game, String GT_SpinsValue, String ST_SpinsValue) throws InterruptedException {
//			games.click();
//			Thread.sleep(500);
//			SearchGame.sendKeys(Game);
//			Thread.sleep(500);
//			ldriver.findElement(By.xpath("(//span[contains(.,'"+Game+"')])[1]")).click();
////			List<WebElement> gamesList = ldriver.findElements(By.xpath("//mat-option//mat-pseudo-checkbox"));
////			for(WebElement gl:gamesList) {
////				Thread.sleep(500);
////				gl.click();
////				Thread.sleep(500);
////			}
//			Thread.sleep(500);
//			gameTokenGameplayCount.clear();
//			gameTokenGameplayCount.click();
//			gameTokenGameplayCount.sendKeys(GT_SpinsValue);
//			sweepTokenGameplayCount.clear();
//			sweepTokenGameplayCount.click();
//			sweepTokenGameplayCount.sendKeys(ST_SpinsValue);
//			return this;
//		}

	public LobbyPage_Old set_SpinEventConfiguration( String GT_SpinsValue, String ST_SpinsValue) throws InterruptedException {

		games.click();
		Thread.sleep(200);
		SetGames.click();
		Thread.sleep(200);
		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
			inputElement.click();}
		}
		Thread.sleep(2000);
		SetGames.sendKeys(Keys.TAB);
		Thread.sleep(500);
		gameTokenGameplayCount.clear();
		gameTokenGameplayCount.click();
		gameTokenGameplayCount.sendKeys(GT_SpinsValue);
		sweepTokenGameplayCount.clear();
		sweepTokenGameplayCount.click();
		sweepTokenGameplayCount.sendKeys(ST_SpinsValue);

		return this;
	}

	
	@FindBy(xpath = "//input[@formcontrolname='numberOfLogins']")
	@CacheLookup
	private WebElement numberOfLogins;
	
	@FindBy(xpath = "//input[@formcontrolname='loginCount']")
	@CacheLookup
	private WebElement reminder_loginCount;
	
	
	public LobbyPage_Old set_LoginEventConfigration(String numofLogin) {
		numberOfLogins.clear();
		numberOfLogins.sendKeys(numofLogin);
		return this;
	}
	
	@FindBy(xpath = "(//input[@formcontrolname='gameTokens'])[2]") 
	@CacheLookup
	public WebElement LossMaking_GameToken;

	@FindBy(xpath = "(//input[@formcontrolname='sweepTokens'])[2]") 
	@CacheLookup
	public WebElement LossMaking_SweepToken;
	
	public LobbyPage_Old set_LossMakingEventConfiguration(String GT , String ST) {
		LossMaking_GameToken.clear();
		LossMaking_GameToken.sendKeys(GT);
		LossMaking_SweepToken.clear();
		LossMaking_SweepToken.sendKeys(ST);
		return this;
		
	}
	
	public LobbyPage_Old set_LossMaking_ActionSection() throws InterruptedException {
		action_CreateNew.click();
		action_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		action_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		action_Title.sendKeys("After Lobby Load LossMaking");
		action_Description.sendKeys("After Lobby Load LossMaking");
		upload_ActionImg.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg2.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
		
	}
	
	public LobbyPage_Old set_Login_ReminderSection() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(2000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load Login reminder");
		reminder_Description.sendKeys("After Lobby Load Login reminder");
		reminder_loginCount.clear();
		reminder_loginCount.sendKeys("3");
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
		
	}
	
	public LobbyPage_Old set_Login_CustomDateReminderSection() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(2000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load Login reminder");
		reminder_Description.sendKeys("After Lobby Load Login reminder");
		reminder_loginCount.clear();
		reminder_loginCount.sendKeys("3");
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		CustomDate_Toggle.click();
		return this;
		
	}
	
	
	@FindBy(xpath = "(//button[@title='Create New'])[2]")
	@CacheLookup
	private WebElement action_CreateNew;
	
	@FindBy(xpath = "//div[@class='addFeatureBtnBlock']")
	@CacheLookup
	private WebElement reminder_CreateNew;
	
	@FindBy(xpath = "(//mat-select[@formcontrolname='type'])[1]")
	@CacheLookup
	private WebElement action_popup;
	
	@FindBy(xpath = "(//mat-select[@formcontrolname='type'])[2]")
	@CacheLookup
	private WebElement reminder_popup;
	
	@FindBy(xpath = "(//input[@formcontrolname='title'])[1]")
	@CacheLookup
	private WebElement action_Title;
	
	@FindBy(xpath = "(//input[@formcontrolname='message'])[1]")
	@CacheLookup
	private WebElement action_Description;
	
	@FindBy(xpath = "(//input[@formcontrolname='title'])[2]")
	@CacheLookup
	private WebElement reminder_Title;
	
	@FindBy(xpath = "(//input[@formcontrolname='message'])[2]")
	@CacheLookup
	private WebElement reminder_Description;
	

	@FindBy(xpath = "(//mat-select[@formcontrolname='mobileUrl'])[1]")
	@CacheLookup
	private WebElement action_mobileUrl;
	
	@FindBy(xpath = "(//mat-select[@formcontrolname='mobileUrl'])[2]")
	@CacheLookup
	private WebElement reminder_mobileUrl;
	
	@FindBy(xpath = "//span[text()='Reminder Section']")
	@CacheLookup
	private WebElement ReminderSection_header;
	
	@FindBy(xpath = "(//input[@type='file'])[1]") 
	@CacheLookup
	WebElement upload_ActionImg;
	
	@FindBy(xpath = "(//input[@type='file'])[2]") 
	@CacheLookup
	WebElement upload_ActionImg2;
	
	@FindBy(xpath = "(//input[@type='file'])[3]") 
	@CacheLookup
	WebElement upload_ActionImg3;
	
	@FindBy(xpath = "(//input[@type='file'])[4]") 
	@CacheLookup
	WebElement upload_ActionImg4;
	
	@FindBy(xpath = "(//input[@formcontrolname='gameTokenGameplayCount'])[2]")
	@CacheLookup
	private WebElement reminder_gameTokenGameplayCount;

	@FindBy(xpath = "(//input[@formcontrolname='sweepTokenGameplayCount'])[2]")
	@CacheLookup
	private WebElement reminder_sweepTokenGameplayCount;

	public LobbyPage_Old set_GamePlay_ActionSection() throws InterruptedException {
		action_CreateNew.click();
		action_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		action_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		action_Title.sendKeys("After Lobby Load Spin");
		action_Description.sendKeys("After Lobby Load Spin");
		upload_ActionImg.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg2.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
		
	}
	
	public LobbyPage_Old set_GamePlay_ReminderSection() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		//js.executeScript("arguments[0].click()", ReminderSection_header);
		Thread.sleep(4000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load Spin reminder");
		reminder_Description.sendKeys("After Lobby Load Spin reminder");
		reminder_gameTokenGameplayCount.clear();
		reminder_gameTokenGameplayCount.click();
		reminder_gameTokenGameplayCount.sendKeys("5");
		reminder_sweepTokenGameplayCount.clear();
		reminder_sweepTokenGameplayCount.click();
		reminder_sweepTokenGameplayCount.sendKeys("0");
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
	}
	
	public LobbyPage_Old set_GamePlay_ReminderSectionWithCustomDate() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(4000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load Spin reminder");
		reminder_Description.sendKeys("After Lobby Load Spin reminder");
		
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
	}
	
	
	@FindBy(xpath = "//input[@value='DEPOSIT_AMOUNT']")
	@CacheLookup
	private WebElement DEPOSIT_AMOUNT_Toggle;

	@FindBy(xpath = "//input[@value='PURCHASE_PACKAGE']")
	@CacheLookup
	private WebElement PURCHASE_PACKAGE_Toggle;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='triggerType']")
	@CacheLookup
	private WebElement triggerType;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='operand']")
	@CacheLookup
	private WebElement operand;
	
	@FindBy(xpath = "//input[@formcontrolname='bonusActivationOn']")
	@CacheLookup
	private WebElement bonusActivationOn;
	
	@FindBy(xpath = "//input[@formcontrolname='amount']")
	@CacheLookup
	private WebElement DepositAmount;
	
	@FindBy(xpath = "//input[@formcontrolname='depositAmount']")
	@CacheLookup
	private WebElement reminderDepositAmount;
	
	@FindBy(xpath = "//input[@formcontrolname='numberOfPackagePurchase']")
	@CacheLookup
	private WebElement remindernumberOfPackagePurchase;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='lobbyPackages']")
	@CacheLookup
	private WebElement selectPackages_MDB;
	
	public LobbyPage_Old set_PurchaseEventConfiguration(String depositType, String nthDeposit, String depositAmount)
			throws InterruptedException {
		if (DEPOSIT_AMOUNT_Toggle.getAttribute("tabindex").equalsIgnoreCase("0")) {
			if (depositType == "On Deposit") {
				triggerType.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='On Deposit Amount']")).click();
				bonusActivationOn.clear();
				bonusActivationOn.sendKeys(nthDeposit);
				operand.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='= ']")).click();
				DepositAmount.sendKeys(depositAmount);
			} else if (depositType == "After Deposit") {
				triggerType.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='After Deposit Amount']")).click();
				bonusActivationOn.clear();
				bonusActivationOn.sendKeys(nthDeposit);
				operand.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='= ']")).click();
				DepositAmount.sendKeys(depositAmount);
			}
		}else if(PURCHASE_PACKAGE_Toggle.getAttribute("tabindex").equalsIgnoreCase("0")) {
			if (depositType == "On Purchase Package") {
				triggerType.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='On Purchase Package']")).click();
				bonusActivationOn.clear();
				bonusActivationOn.sendKeys(nthDeposit);
				selectPackages_MDB.click();
				Thread.sleep(200);
				List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
				if (!boxes.isEmpty()) {
					for (WebElement inputElement : boxes) {
					inputElement.click();}
				}
				Thread.sleep(2000);
				selectPackages_MDB.sendKeys(Keys.TAB);
				
			} else if (depositType == "After Purchase Package") {
				triggerType.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='After Purchase Package']")).click();
				bonusActivationOn.clear();
				bonusActivationOn.sendKeys(nthDeposit);
				selectPackages_MDB.click();
				Thread.sleep(200);
				List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
				if (!boxes.isEmpty()) {
					for (WebElement inputElement : boxes) {
					inputElement.click();}
				}
				Thread.sleep(2000);
				selectPackages_MDB.sendKeys(Keys.TAB);
			}
		}
			else {
		
			System.out.println("The element is not Selected");

		}

		return this;
	}
	
	public LobbyPage_Old set_Purchase_DepositAmount_ActionSection() throws InterruptedException {
		action_CreateNew.click();
		action_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		action_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		action_Title.sendKeys("After Lobby Load On Deposit");
		action_Description.sendKeys("After Lobby Load On Deposit");
		upload_ActionImg.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg2.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;	
	}
	
	public LobbyPage_Old set_Purchase_DepositAmount_ReminderSection(String remDepositAmount) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(2000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load On Deposit reminder");
		reminder_Description.sendKeys("After Lobby Load On Deposit reminder");
		reminderDepositAmount.sendKeys(remDepositAmount);
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
	}
	
	public LobbyPage_Old set_Purchase_PackagePurchase_ReminderSection(String numPkgPurchase) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(2000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load On Purchase pkg reminder");
		reminder_Description.sendKeys("After Lobby Load On purchase pkg reminder");
		remindernumberOfPackagePurchase.sendKeys(numPkgPurchase);
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
	}
	
	public LobbyPage_Old set_Purchase_PackagePurchase_ReminderSectionWithCustomDate() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		Thread.sleep(2000);
		act.moveToElement(reminder_CreateNew).click().build().perform();
		reminder_popup.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='After Lobby Load ']")).click();
		reminder_mobileUrl.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='Bonus ']")).click();
		reminder_Title.sendKeys("After Lobby Load On purchase pkg reminder");
		reminder_Description.sendKeys("After Lobby Load On purchase pkg reminder");
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		return this;
	}
	
	@FindBy(xpath = "//span[text()='Deposit Amount']")
	@CacheLookup
	private WebElement DepositAmount_Toggle;
	
	public LobbyPage_Old selectDepositAmountToggle() {
		DepositAmount_Toggle.click();
		return this;
		
	}
	
	@FindBy(xpath = "//span[text()='Purchase Package']")
	@CacheLookup
	private WebElement PurchasePackage_Toggle;
	
	public LobbyPage_Old selectPurchasePackageToggle() {
		PurchasePackage_Toggle.click();
		return this;
		
	}
	
	@FindBy(xpath = "//span[text()='Custom Date']")
	@CacheLookup
	private WebElement CustomDate_Toggle;
	
	public LobbyPage_Old selectCustomDateToggle() {
		CustomDate_Toggle.click();
		return this;
		
	}
	
	public LobbyPage_Old selectCustomStartDate() throws InterruptedException {
		LocalDate todayDate = LocalDate.now();
		LocalDate CustomDate = todayDate.plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = CustomDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[text()=' " + currentDateString +" ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='startsAtTime'])[2]")).sendKeys("0000");
		return this;
		
	}
	
	
	public LobbyPage_Old selectCustomExpiryDate() throws InterruptedException {
		LocalDate todayDate = LocalDate.now();
		LocalDate targetDate = todayDate.plusMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = todayDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		//System.out.println(currentDateString);
		String targetDateString = targetDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		//System.out.println(targetDateString);
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[text()=' " + currentDateString +" ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='expiresAtTime'])[2]")).sendKeys("1900");
		
		return this;
		
	}
}
