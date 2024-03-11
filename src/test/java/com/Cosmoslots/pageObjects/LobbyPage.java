package com.Cosmoslots.pageObjects;

import java.io.IOException;
import java.time.LocalDate;
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
import org.testng.Assert;

import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.ENUM.PlayerEnum;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.Status;

import implementation.Seleniumimpl;


public class LobbyPage extends BaseClass {

	WebDriver ldriver;
	Seleniumimpl sel;
	JavascriptExecutor jse = (JavascriptExecutor) ldriver;
	CommonCosmo cc = new CommonCosmo(ldriver);
	// public static ExtentTest test;

	public LobbyPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

		sel = new Seleniumimpl();
	}

	@FindBy(xpath = "//span[contains(text(),'Store Management')]")
	@CacheLookup
	public WebElement StoreManagement;

	private By StoreManagement_header = By.xpath("//h3[text()='Store Management']");

	public boolean VerifyStoreManagement_header() {
		// return ldriver.findElement(StoreManagement_header).isDisplayed();
		return ldriver.findElements(StoreManagement_header).size() > 0;

	}

	private By AddCoupon = By.xpath("(//h3[.='Add Coupon'])[1]");

	public boolean VerifyAddCoupon() {
		// return ldriver.findElement(StoreManagement_header).isDisplayed();
		return ldriver.findElements(AddCoupon).size() > 0;

	}

	@FindBy(xpath = "//input[@formcontrolname='startsAtTime']")
	@CacheLookup
	public WebElement startsAtTime;

	@FindBy(xpath = "//input[@formcontrolname='expiryAtTime']")
	@CacheLookup
	public WebElement expiryAtTime;

	@FindBy(xpath = "//div/button[text()='Store Accounts']")
	@CacheLookup
	public WebElement StoreAccounts;

	@FindBy(xpath = "//span[text()='Search Game']")
	@CacheLookup
	private WebElement Games;

	@FindBy(xpath = "//input[@placeholder='Search Game']")
	@CacheLookup
	public static WebElement SetGames;

	@FindBy(xpath = "//div[@id='kenoGameSelectBox']//following::span[text()='Search Game']")
	@CacheLookup
	private WebElement KenoGames;

	@FindBy(xpath = "//input[@placeholder='Search Game']")
	@CacheLookup
	public static WebElement KenoSetGames;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname='web']")
	@CacheLookup
	public static WebElement web;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname='android']")
	@CacheLookup
	private WebElement android;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname='ADMIN_UNDER_MAINTENANCE']")
	@CacheLookup
	private WebElement adminMaintenanace;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname='COCOS']")
	@CacheLookup
	private WebElement cocos;

	@FindBy(xpath = "//input[@type='checkbox']//ancestor::mat-checkbox[@formcontrolname='ios']")
	@CacheLookup
	private WebElement ios;

	@FindBy(xpath = "//button[contains(text(),'News')]")
	@CacheLookup
	public WebElement news;

	@FindBy(xpath = "//button[contains(text(),'FAQ')]")
	@CacheLookup
	public WebElement faq;

	@FindBy(xpath = "//button[contains(text(),'Promotion')]")
	@CacheLookup
	public WebElement Promotion;

	@FindBy(xpath = "//span[text()='Search Country']")
	@CacheLookup
	private WebElement Country;

	@FindBy(xpath = "//input[@placeholder='Search Country']")
	@CacheLookup
	public static WebElement SetCountry;

	@FindBy(xpath = "//mat-select[@formcontrolname='faqCategory']//parent::span[contains(@class,'mat-select-min-line')]")
	@CacheLookup
	private WebElement faqCategory;

	@FindBy(xpath = "//span[.='Account']")
	@CacheLookup
	public static WebElement SelectFAQCategory;

	@FindBy(xpath = "//input[@formcontrolname='sortOrder']")
	@CacheLookup
	public static WebElement SetOrder;

	@FindBy(xpath = "//button[@title='Create New']")
	@CacheLookup
	public WebElement Create_Button;

	@FindBy(xpath = "//input[@formcontrolname='title']")
	@CacheLookup
	WebElement Create_title;

	@FindBy(xpath = "//input[@formcontrolname='question']")
	@CacheLookup
	WebElement Create_question;

	@FindBy(xpath = "//input[@formcontrolname='answer']")
	@CacheLookup
	WebElement Create_answer;

	@FindBy(xpath = "//input[@type='file']") //// mat-icon[text()='cloud_upload']
	@CacheLookup
	WebElement Create_icon;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	public static WebElement Name;

	@FindBy(xpath = "//input[@formcontrolname='discountedPercentage']")
	@CacheLookup
	public static WebElement discountedPercentage;

	@FindBy(xpath = "//input[@formcontrolname='expiryAt']")
	@CacheLookup
	public static WebElement expiryAt;

	@FindBy(xpath = "//input[@formcontrolname='usageByPlayer']")
	@CacheLookup
	public static WebElement usageByPlayer;

	// @FindBy(xpath = "//input[@formcontrolname='activationAfterPurchase']")
	@FindBy(xpath = "//input[@formcontrolname='couponActivationAfterOrOn']")
	@CacheLookup
	public static WebElement activationAfterPurchase;

	@FindBy(xpath = "//mat-select[@formcontrolname='action']")
	@CacheLookup
	public WebElement var_Action;

	@FindBy(xpath = "//mat-select[@formcontrolname='actionUrl']")
	@CacheLookup
	public WebElement var_Actionurl;

	@FindBy(xpath = "//input[@formcontrolname='url']")
	@CacheLookup
	public WebElement Player_Registration_Link;

	@FindBy(xpath = "//span[contains(text(),'Daily Login Bonus')]") // mat-option//span[contains(.,"Player")]
	@CacheLookup
	public WebElement select_Action;

	@FindBy(xpath = "(//div[@formgroupname='token']//following::input[contains(@class,'ng')])[1]") // div[@formgroupname='token']/div[1]
	@CacheLookup
	public WebElement select_GameToken;

	@FindBy(xpath = "(//div[@formgroupname='token']//following::input[contains(@class,'ng')])[2]") // div[@formgroupname='token']/div[1]
	@CacheLookup
	public WebElement select_SweepToken;

	@FindBy(xpath = "(//*[@title='Invited Players'])[1]")
	@CacheLookup
	WebElement AddPlayerURL;

	@FindBy(xpath = "(//a[@title='Edit'])[1]") // (//i[@class='ri-pencil-line'])[1] -> (//a[@id='edit'])[1]
	@CacheLookup
	public WebElement EditButton;

	public By editElement = By.xpath("(//a[@title='Edit'])[1]");

	public boolean VerifyeditElement() {
		return ldriver.findElements(editElement).size() > 0;
	}

	@FindBy(xpath = "(//i[@class='ri-pencil-line'])[1]") // (//i[@class='ri-pencil-line'])[1] -> (//a[@id='edit'])[1]
	@CacheLookup
	WebElement EditButton1;

	@FindBy(xpath = "//button//span[text()='Save']//parent::button") // (//i[@class='ri-pencil-line'])[1] ->
																		// (//a[@id='edit'])[1]
	@CacheLookup
	public WebElement Savenews;

	@FindBy(xpath = "//button[text()='Cancel']//preceding-sibling::button[text()='Yes']") // (//i[@class='ri-pencil-line'])[1]
																							// -> (//a[@id='edit'])[1]
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

	private By CustomPurchaseHistoryTitle = By.xpath("(//a[@title='Custom Package Purchase History'])[1]");

	public boolean VerifyCustomPurchaseHistoryTitle() {
		return ldriver.findElements(CustomPurchaseHistoryTitle).size() > 0;
	}

	private By CustomPurchaseHistoryHeader = By.xpath("//h3[contains(text(),\"Custom Package Purchase History\")]");

	public boolean VerifyCustomPurchaseHistoryHeader() {
		return ldriver.findElements(CustomPurchaseHistoryHeader).size() > 0;
	}

	@FindBy(xpath = "(//a[@title='Player Coupon'])[1]")
	@CacheLookup
	public WebElement ViewCouponAppliedHistory;

	@FindBy(xpath = "//button[contains(text(),'Fish')]")
	@CacheLookup
	public WebElement fishButton;

	public void clicktoFish() throws InterruptedException {
		sel.click(fishButton);
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//button[contains(text(),'Keno')]")
	@CacheLookup
	public WebElement kenoButton;

	public void clicktoKeno() throws InterruptedException {
		sel.click(kenoButton);
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//mat-icon[text()='clear ']")
	@CacheLookup
	public static WebElement ClearSearch;

	@FindBy(xpath = "(//a[@title='Store Account Maintenance Mode'])[1]")
	@CacheLookup
	WebElement View_Maintenance;

	@FindBy(xpath = "//i[@class='ri-file-copy-line']")
	@CacheLookup
	WebElement CopyLobby;

	// @FindBy(xpath="//span[text()='App Based
	// ']/preceding::span[contains(@class,'radio-inner')]")
	@FindBy(xpath = "//input[@value='APP_BASED']")
	@CacheLookup
	public static WebElement AppBasedradio;

	@FindBy(xpath = "//input[@value='OWNER_BASED']")
	@CacheLookup
	public static WebElement OwenerBasedradio;

	@FindBy(xpath = "//input[@formcontrolname='code']")
	@CacheLookup
	WebElement Lcode;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	WebElement Lname;

	@FindBy(xpath = "//i[@class='ri-coupon-3-line']")
	@CacheLookup
	WebElement PlayerCoupon;

	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	@CacheLookup
	public static WebElement description;

	@FindBy(xpath = "//*[@formcontrolname='description']/div/div/p[1]")
	@CacheLookup
	public static WebElement description_news;

	public String appliedCouponHistory() throws InterruptedException {
		String cpn = ldriver.findElement(By.xpath("(//h3[contains(.,'Coupon Applied History')])[1]")).getText();
		test.info("Entered  Coupon Applied History = <b>" + cpn + "</b>");
		Thread.sleep(2000);
		return cpn;
	}

	public LobbyPage SetDesc(String desc) throws InterruptedException {
		// description_news.clear();
		// description_news.click();
		description_news.sendKeys(desc);
		test.info("Entered  description = <b>" + desc + "</b>");
		Thread.sleep(500);
		return this;
	}

	public LobbyPage SetDesc_StorePackage(String desc) throws InterruptedException {
		// description_news.clear();
		// description_news.click();
		description.sendKeys(desc);
		test.info("Entered  description = <b>" + desc + "</b>");
		Thread.sleep(500);
		return this;
	}

	public LobbyPage EditSetDesc(String desc) throws InterruptedException {
		Create_title.sendKeys(Keys.TAB + desc);
		// description_news.sendKeys(desc);
		test.info("Edited description = <b>" + desc + "</b>");
		Thread.sleep(500);
		return this;
	}

	public void storeRedirect() throws InterruptedException {
		clicklobbymanagement();
		test.info("Clicked on store management");
		Thread.sleep(1000);
		clickStoreAccounts();
		Thread.sleep(2000);
		test.info("Clicked on Store menu");
	}

	@FindBy(xpath = "//span[text()='Save']") // div[4]/div/div/div[2]/button/span
	@CacheLookup
	WebElement Lobbysave;

	@FindBy(xpath = "//button/span[contains(text(),'Save')]") // ->(//button//span[text()='Save'])[1]
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

	@FindBy(xpath = "//button[contains(text(),'Profile')]")
	@CacheLookup
	WebElement ViewLobby_Profile;

	public LobbyPage verifyLobbyProfile(String lobby) throws InterruptedException {
		if (driver
				.findElements(
						By.xpath("//span[text()='Code']//following-sibling::span[contains(text(),'" + lobby + "')]"))
				.size() > 0) {
			test.info("profile verified with <b>'" + lobby + "'</b>  item", extentScreenshot());
			System.out.println("verified");
		} else {
			test.info("profile not verified with <b>'" + lobby + "'</b>   item", extentScreenshot());
			System.out.println(" not verified");

		}
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//button[text()=' Packages ']")
	@CacheLookup
	WebElement ViewLobby_storePackage;

	@FindBy(xpath = "//button[contains(text(),'Packages')]")
	@CacheLookup
	WebElement websitePackage;

	@FindBy(xpath = "//button[contains(text(),'Custom Packages')]")
	@CacheLookup
	WebElement ViewLobby_LobbyCPackage;

	@FindBy(xpath = "//input[@formcontrolname='amount']")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_amount;

	@FindBy(xpath = "//input[@formcontrolname='discountAmount']")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_discountAmount;

	@FindBy(xpath = "//input[@formcontrolname='sweepToken']")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_sweepToken;

	@FindBy(xpath = "//input[@formcontrolname='extraSweepToken']")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_extrasweepToken;

	@FindBy(xpath = "//input[@formcontrolname='gameToken']")
	@CacheLookup
	WebElement ViewLobby_LobbyPackage_gameToken;

	@FindBy(xpath = "//button[contains(text(),'Games')]")
	@CacheLookup
	WebElement ViewLobby_Game;

	@FindBy(xpath = "//button[contains(text(),'Lobby Versions')]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion;

	@FindBy(xpath = "//h4[@class='subTitle']/span[(text()='Android')]")
	@CacheLookup
	public WebElement ViewLobby_LobbyVersion_Android;

	@FindBy(xpath = "(//div[@formgroupname='android']//following::input[contains(@class,'ng')])[1]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_Android_ReviewVersion;

	@FindBy(xpath = "(//div[@formgroupname='android']//following::input[contains(@class,'ng')])[2]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_Android_ProductionVersion;

	@FindBy(xpath = "//h4[@class='subTitle']/span[(text()='IOS')]")
	@CacheLookup
	public WebElement ViewLobby_LobbyVersion_ios;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Cocos Settings\")]")
	@CacheLookup
	public static WebElement ViewLobby_CocosSettings;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"WebGL Settings\")]")
	@CacheLookup
	public static WebElement ViewLobby_WebGLSettings;

	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Linux\")]")
	@CacheLookup
	public static WebElement ViewLobby_LinuxSettings;
	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"Windows\")]")
	@CacheLookup
	public static WebElement ViewLobby_WindowsSettings;
	@FindBy(xpath = "//h4[@class=\"subTitle\"]/span[(text()=\"MAC\")]")
	@CacheLookup
	public static WebElement ViewLobby_MACSettings;

	@FindBy(xpath = "//div//input[@formcontrolname='cocosUrl']")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_cocosUrl;

	@FindBy(xpath = "//div//input[@formcontrolname='cocosVersion']")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_cocosVersion;

	public LobbyPage clickViewLobby_CocosURL(String text) {
		ViewLobby_LobbyVersion_cocosUrl.clear();
		ViewLobby_LobbyVersion_cocosUrl.sendKeys(text);
		return this;
	}

	public LobbyPage clickViewLobby_CocosVesion(String text) {
		ViewLobby_LobbyVersion_cocosVersion.clear();
		ViewLobby_LobbyVersion_cocosVersion.sendKeys(text);
		return this;
	}

	@FindBy(xpath = "//div//input[@formcontrolname='webGLUrl']")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_webGLUrl;

	@FindBy(xpath = "//div//input[@formcontrolname='webGLVersion']")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_webGLVersion;

	public LobbyPage clickViewLobby_websURL(String text) {
		ViewLobby_LobbyVersion_webGLUrl.clear();
		ViewLobby_LobbyVersion_webGLUrl.sendKeys(text);
		return this;
	}

	public LobbyPage clickViewLobby_webGLVersion(String text) {
		ViewLobby_LobbyVersion_webGLVersion.clear();
		ViewLobby_LobbyVersion_webGLVersion.sendKeys(text);
		return this;
	}

	@FindBy(xpath = "(//div[@formgroupname='ios']//following::input[contains(@class,'ng')])[1]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_ios_ReviewVersion;

	@FindBy(xpath = "(//div[@formgroupname='ios']//following::input[contains(@class,'ng')])[2]")
	@CacheLookup
	WebElement ViewLobby_LobbyVersion_ios_ProductionVersion;

	@FindBy(xpath = "(//button//span[contains(text(),'Delete')])[1]") // button[@type="button"]
	@CacheLookup
	public static WebElement DeleteVersion;

	@FindBy(xpath = "//button[contains(text(),'Bonus')]")
	@CacheLookup
	public WebElement ViewLobby_LobbyBonus;

	@FindBy(xpath = "//button[contains(text(),'Store Coupon')]")
	@CacheLookup
	WebElement ViewLobby_coupon;

	@FindBy(xpath = "//button[contains(text(),'Withdraw Settings')]")
	@CacheLookup
	WebElement ViewLobby_WithdrawSetting;

	@FindBy(xpath = "//h4[@class='subTitle']/span[(text()='Withdraw Amount Details')]")
	@CacheLookup
	public WebElement ViewLobby_WithdrawSetting_Title;

	@FindBy(xpath = "//input[@formcontrolname='amount']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_amount;

	@FindBy(xpath = "//input[@formcontrolname='sweepTokens']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_sweepTokens;

	@FindBy(xpath = "//input[@formcontrolname='minimumAmountWithdrawal']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_minimumAmountWithdrawal;

	@FindBy(xpath = "//input[@formcontrolname='withdrawApprovalRequired']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_withdrawApprovalRequired;

	@FindBy(xpath = "//input[@formcontrolname='perTransactionLimit']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_PerTransactionLimit;

	@FindBy(xpath = "//input[@formcontrolname='perDayTransactionLimit']")
	@CacheLookup
	public static WebElement ViewLobby_WithdrawSetting_perDayTransactionLimit;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='otherPurchase']")
	@CacheLookup
	public WebElement otherPurchase_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='payPerPurchase']")
	@CacheLookup
	public WebElement payPerPurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='contactUsWithdraw'][contains(@class,'mat-checked')]")
	@CacheLookup
	public static WebElement contactUsWithdraw;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='payPerWithdraw']")
	@CacheLookup
	public WebElement payPerWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='contactUsPurchase'][contains(@class,'mat-checked')]")
	@CacheLookup
	public static WebElement contactUsPurchase;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='cashAppPurchase']")
	@CacheLookup
	public WebElement cashAppPurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='paySafePurchase']")
	@CacheLookup
	public WebElement paySafePurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='zenPaymentPurchase']")
	@CacheLookup
	public WebElement zenPaymentPurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletPurchase']")
	@CacheLookup
	public WebElement walletPurchase_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletPayPerDeposit']")
	@CacheLookup
	public WebElement walletPayPerDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='seamlessChexPurchase']")
	@CacheLookup
	public WebElement seamlessChexPurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='skrillPurchase']")
	@CacheLookup
	public WebElement skrillPurchase_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='contactUsPurchase']")
	@CacheLookup
	public WebElement contactUsPurchase_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='seamlessChexWithdraw']")
	@CacheLookup
	public WebElement seamlessChexWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='skrillWithdraw']")
	@CacheLookup
	public WebElement skrillWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='bankAccountWithdraw']")
	@CacheLookup
	public WebElement bankAccountWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='paySafeWithdraw']")
	@CacheLookup
	public WebElement paySafeWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='tokenToWallet']")
	@CacheLookup
	public WebElement tokenToWallet_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='cashAppWithdraw']")
	@CacheLookup
	public WebElement cashAppWithdraw_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='contactUsWithdraw']")
	@CacheLookup
	public WebElement contactUsWithdraw_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='manualWithdraw']")
	@CacheLookup
	public WebElement manualWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='seamlessChexWalletDeposit']")
	@CacheLookup
	public WebElement seamlessChexWalletDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='otherWalletDeposit']")
	@CacheLookup
	public WebElement otherWalletDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletCashAppDeposit']")
	@CacheLookup
	public WebElement walletCashAppDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletPaySafeDeposit']")
	@CacheLookup
	public WebElement walletPaySafeDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletZenPaymentDeposit']")
	@CacheLookup
	public WebElement walletZenPaymentDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletSkrillDeposit']")
	@CacheLookup
	public WebElement walletSkrillDeposit_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletCashAppWithdraw']")
	@CacheLookup
	public WebElement walletCashAppWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletPaySafeWithdraw']")
	@CacheLookup
	public WebElement walletPaySafeWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletBankAccountWithdraw']")
	@CacheLookup
	public WebElement walletBankAccountWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='seamlessChexWalletWithdraw']")
	@CacheLookup
	public WebElement seamlessChexWalletWithdraw_click;
	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletPayPerWithdraw']")
	@CacheLookup
	public WebElement walletPayPerWithdraw_click;

	@FindBy(xpath = "//input[@type='checkbox']//preceding::mat-slide-toggle[@formcontrolname='walletSkrillWithdraw']")
	@CacheLookup
	public WebElement walletSkrillWithdraw_click;

	@FindBy(xpath = "//button[contains(text(),'App Settings')]")
	@CacheLookup
	WebElement ViewLobby_AppSetting;

	@FindBy(xpath = "//h3[text()='Edit News']")
	@CacheLookup
	public WebElement ViewLobby_Appsetting_EditNewsLabel;

	public boolean verifyViewLobby_Appsetting_EditNewsLabel() {

		return ViewLobby_Appsetting_EditNewsLabel.isDisplayed();
	}

	@FindBy(xpath = "//h3[text()='Add Meta Data']")
	@CacheLookup
	public WebElement AddMetaData;

	public boolean verifyAddMetaData() {

		return AddMetaData.isDisplayed();
	}

	@FindBy(xpath = "//td[contains(text(),'Name')]")
	@CacheLookup
	public WebElement viewName;

	public boolean verifyViewName() {

		return viewName.isDisplayed();
	}

	@FindBy(xpath = "//td[contains(text(),'Title')]")
	@CacheLookup
	public WebElement ViewTitle;

	@FindBy(xpath = "//th[contains(text(),'Title')]")
	@CacheLookup
	public WebElement ViewPromotionTitle;

	public boolean verifyViewTitle() {

		return ViewPromotionTitle.isDisplayed();
	}

	public boolean verifyViewPromotionTitle() {

		return ViewTitle.isDisplayed();
	}

	@FindBy(xpath = "//h4[@class='subTitle']/span[(text()='Information')]")
	@CacheLookup
	public WebElement ViewLobby_AppSetting_title;

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

	@FindBy(xpath = "//button[contains(text(),'Website Settings')]")
	@CacheLookup
	public static WebElement ViewLobby_WebsiteSetting;

	@FindBy(xpath = "//button[text()=' Settings ']")
	@CacheLookup
	public static WebElement ViewLobby_StoreSetting;

	@FindBy(xpath = "//div[contains(text(),'Tab Access')]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_TabAccess;

	@FindBy(xpath = "//div[contains(text(),'Sign Up')]")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup;

	@FindBy(xpath = "//input[@formcontrolname='signUpTitle']")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup_Title;

	@FindBy(xpath = "//textarea[@formcontrolname='signUpDescription']")
	@CacheLookup
	WebElement ViewLobby_WebsiteSetting_Signup_Desc;

	@FindBy(xpath = "//button[text()=' Corporation Details ']")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails;

	@FindBy(xpath = "//button[contains(text(),'App Marketing')]")
	@CacheLookup
	WebElement AppMarketinglabel;

	@FindBy(xpath = "//button[contains(text(),'Social Media Settings')]")
	@CacheLookup
	WebElement Socialmedia;

	@FindBy(xpath = "//input[@formcontrolname='name']")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_name;

	@FindBy(xpath = "//input[@formcontrolname='contactNumber']")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_contactNumber;

	@FindBy(xpath = "//input[@formcontrolname='email']")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_email;

	@FindBy(xpath = "//textarea[@formcontrolname='address']")
	@CacheLookup
	WebElement ViewLobby_CorporationDetails_address;

	// close games view popup
	@FindBy(xpath = "(//mat-icon[.='close'])[1]")
	@CacheLookup
	WebElement Popup_Close_Button;

	// close button for search
	@FindBy(xpath = "//mat-icon[text()='clear']")
	@CacheLookup
	WebElement Search_Clear_Button;

	// search bar
	@FindBy(xpath = "//mat-icon[text()='search']")
	@CacheLookup
	WebElement Search_Button;

	// Cancel button
	@FindBy(xpath = "//span[contains(.,'Cancel')]") // button[@type='button']//following::span[text()='Cancel']
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

	@FindBy(xpath = "//a[text()=' Settings']")
	@CacheLookup
	public WebElement MasterSettings;

	@FindBy(xpath = "//span[@class='mat-button-wrapper']//span[contains(@class,'user-name')]//following-sibling::i")
	@CacheLookup
	public static WebElement UserProfile;

	public LobbyPage MasterSettings_Click() throws InterruptedException {
		Thread.sleep(1000);
		sel.click(UserProfile);

		Thread.sleep(1500);
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", MasterSettings);
		test.info("Click on Master settings");
		Thread.sleep(2000);
		PageReload();
		// sel.click(MasterSettings);
		return this;
	}

	public By View_Click_label = By.xpath("(//i[@class='ri-eye-line'])[1]");

	public boolean verifyLobbyview() {
		return ldriver.findElements(View_Click_label).size() > 0;
	}

	public By LobbyMaintenance_label = By.xpath("//button[contains(text(),'Lobby Maintenance')]");

	public boolean LobbyMaintenanceLabel() {
		return ldriver.findElement(LobbyMaintenance_label).isDisplayed();
	}

	public LobbyPage LobbyMaintenance_Click() throws InterruptedException {
		ldriver.findElement(LobbyMaintenance_label).click();
		test.info("Redirect on Lobby Maintenance section");
		Thread.sleep(500);
		return this;
	}

	public By LevelWiseBonus = By.xpath("//h3[contains(text(),'Level Wise Bonus')]");

	public boolean verifyLevelWiseBonus() {
		return ldriver.findElements(LevelWiseBonus).size() > 0;

	}

	public By packageDeletebuttonElement = By.xpath("(//span[contains(@class,'deleteActionIcon')])[1]");

	public boolean packageDeletebuttonElement() {
		return ldriver.findElements(packageDeletebuttonElement).size() > 0;

	}

	@FindBy(xpath = "(//span[contains(@class,'deleteActionIcon')])[1]")
	@CacheLookup
	public static WebElement clickPackageDeletebuttonElement;

	public LobbyPage clickPackageDeletebuttonElement() throws InterruptedException {
		sel.click(clickPackageDeletebuttonElement);
		test.info("Click on delete button");
		Thread.sleep(2000);
		return this;
	}

	public By YesDeleteIt = By.xpath("//button[text()='Yes, delete it!']");

	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	@CacheLookup
	public static WebElement YesDeleteItelement;

	public boolean VerifyYesDeleteIt() {
		// return ldriver.findElement(YesDeleteIt).isDisplayed();
		return ldriver.findElements(YesDeleteIt).size() > 0;

	}

	public LobbyPage ClickYesDeleteIt() throws InterruptedException {
		sel.click(YesDeleteItelement);
		test.info("Click on delete it");
		Thread.sleep(1000);
		return this;
	}

	public By AddHomePage = By.xpath("//h3[.='Add Home Page']");

	public boolean VerifyAddHomePage() {
		return ldriver.findElement(AddHomePage).isDisplayed();
	}

	public By EditHomePage = By.xpath("//h3[.='Edit Home Page']");

	public boolean VerifyEditHomePage() {
		return ldriver.findElement(EditHomePage).isDisplayed();
	}

	// Lobby info
	@FindBy(xpath = "//button[contains(text(),'Lobby Info')]")
	@CacheLookup
	public WebElement LobbyInfo;

	public LobbyPage LobbyInfo_Click() throws InterruptedException {
		sel.click(LobbyInfo);
		test.info("Click on lobby info");
		Thread.sleep(2000);
		return this;
	}

	// general pages
	@FindBy(xpath = "//button[contains(text(),'General Pages')]")
	@CacheLookup
	public WebElement GeneralPages;

	public LobbyPage GeneralPages_Click() throws InterruptedException {
		sel.click(GeneralPages);
		test.info("Click on General Pages");
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "(//a[text()='About Us'])[1]")
	@CacheLookup
	public WebElement AboutUs;

	public LobbyPage AboutUs_Click() throws InterruptedException {
		sel.click(AboutUs);
		test.info("Click on AboutUs Pages");
		Thread.sleep(1500);
		return this;
	}

	public By iOsText = By.xpath("//span[text()='iOS']");

	public LobbyPage verifyiOsText() {
		if (ldriver.findElements(iOsText).size() > 0) {
			test.info("IOS Download Link found in Website", extentScreenshot());
		} else {
			test.info("IOS Download Link not found in Website", extentScreenshot());
		}
		return this;
	}

	public By AndroidText = By.xpath("//span[text()='Android']");

	public boolean verifyAndroidText() {
		return ldriver.findElements(FooterDescription).size() > 0;
	}

	public By FooterDescription = By.xpath("//h4//span[text()='Footer Description']");

	public boolean verifyFooterDescription() {
		return ldriver.findElements(FooterDescription).size() > 0;
	}

	public By iOSDownloadDetails = By.xpath("//span[contains(.,'iOS Download Details')]");

	public boolean verifyiOSDownloadDetails() {
		return ldriver.findElements(iOSDownloadDetails).size() > 0;
	}

	public By iOSDownloadDetailsDescription = By
			.xpath("//mat-label[text()='Description']//preceding::h4//span[normalize-space()='iOS Download Details']");

	public boolean verifyiOSDownloadDetailsDescription() {

		return ldriver.findElements(iOSDownloadDetailsDescription).size() > 0;
	}

	public By AndroidDownloadDetailsDescription = By.xpath(
			"//mat-label[text()='Description']//preceding::h4//span[normalize-space()='Android Download Details']");

	public boolean verifyAndroidDownloadDetailsDescription() {

		return ldriver.findElements(AndroidDownloadDetailsDescription).size() > 0;
	}

	public By AndroidDownloadDetails = By.xpath("//span[contains(.,'Android Download Details')]");

	public boolean verifyAndroidDownloadDetails() {
		return ldriver.findElements(AndroidDownloadDetails).size() > 0;
	}

	// Settings
	@FindBy(xpath = "//button[text()=' Settings ']")
	@CacheLookup
	public WebElement Settings;

	public LobbyPage Settings_Click() throws InterruptedException {
		sel.click(Settings);
		test.info("Click on Settings");
		Thread.sleep(1500);
		return this;
	}

	public By promotionpublished = By.xpath("//span[text()='Lobby promotion published successfully']");

	public boolean verifypromotionpublished() {
		return ldriver.findElements(promotionpublished).size() > 0;
	}

	public By promotionunpublished = By.xpath("//span[text()='Lobby promotion unpublished successfully']");

	public boolean verifypromotionunpublished() {
		return ldriver.findElements(promotionunpublished).size() > 0;
	}

	public By newspublished = By.xpath("//span[text()='News published successfully']");

	public boolean verifynewspublished() {
		return ldriver.findElements(newspublished).size() > 0;
	}

	public By newsunpublished = By.xpath("//span[text()='News unpublished successfully']");

	public boolean verifynewsunpublished() {
		return ldriver.findElements(newsunpublished).size() > 0;
	}

	public By FAQactivated = By.xpath("//span[text()='FAQ activated successfully']");

	public boolean verifyFAQactivated() {
		return ldriver.findElements(FAQactivated).size() > 0;
	}

	public By FAQDeactivated = By.xpath("//span[text()='FAQ deactivated successfully']");

	public boolean verifyFAQDeactivated() {
		return ldriver.findElements(FAQDeactivated).size() > 0;
	}

	public By viewbutton = By.xpath("(//a[@title='View'])[1]");

	public boolean verifyViewButton() {
		return ldriver.findElements(viewbutton).size() > 0;
	}

	public By addReleaseNoteLabel = By.xpath("//h3[text()='Add Release Note']");

	public boolean verifyaddReleaseNoteLabel() {
		return ldriver.findElements(addReleaseNoteLabel).size() > 0;
	}

	public By updateButton = By.xpath("(//button[.='Update'])[1]");

	public boolean verifyUpdateButton() {
		return ldriver.findElements(updateButton).size() > 0;
	}

	public LobbyPage clickUpdateButton() throws InterruptedException {
		sel.click(ldriver.findElement(By.xpath("(//button[.='Update'])[1]")));
		test.info("Clicked on update button");
		Thread.sleep(1000);
		return this;
	}

	public By releaseNote = By.xpath("//td[text()='Release Note']");

	public boolean verifyreleaseNote() {
		return ldriver.findElements(releaseNote).size() > 0;
	}

	public By Question = By.xpath("//td[text()='Question']");

	public boolean verifyQuestion() {
		return ldriver.findElements(Question).size() > 0;
	}

	public By Title = By.xpath("//td[text()='Title']");

	public boolean verifyTitle() {
		return ldriver.findElements(Title).size() > 0;
	}

	// Settings IosUrl
	@FindBy(xpath = "//input[@formcontrolname='iosurl']")
	@CacheLookup
	public static WebElement iosurl;

	// Settings ios description
	@FindBy(xpath = "(//div[contains(@class,'NgxEditor__Content')])[2]")
	@CacheLookup
	public static WebElement iosDesc;

	public LobbyPage Set_iosurl(String url) throws InterruptedException {
		iosurl.clear();
		Thread.sleep(500);
		iosurl.sendKeys(url);

		return this;
	}

	public LobbyPage Set_iosDesc(String Desc) {
		iosDesc.clear();
		iosDesc.sendKeys(Desc);
		return this;
	}

	// Settings androidUrl
	@FindBy(xpath = "//input[@formcontrolname='androidUrl']")
	@CacheLookup
	public static WebElement androidUrl;

	// Settings android description
	@FindBy(xpath = "(//div[contains(@class,'NgxEditor__Content')])[1]")
	@CacheLookup
	public static WebElement androidDesc;

	public LobbyPage Set_androidUrl(String url) throws InterruptedException {
		androidUrl.clear();
		Thread.sleep(1000);
		androidUrl.sendKeys(url);

		return this;
	}

	public LobbyPage Set_androidDesc(String Desc) {
		androidDesc.clear();
		androidDesc.sendKeys(Desc);
		return this;
	}

	// click to homep page

	@FindBy(xpath = "//button[contains(text(),'Home Page')]")
	@CacheLookup
	WebElement HomePage_icon;

	public LobbyPage Set_HomePage_icon() throws InterruptedException {
		sel.click(HomePage_icon);
		Thread.sleep(500);
		test.info("Click to create HomePage");
		return this;
	}

	// Settings HomePage icon
	@FindBy(xpath = "//input[@type='file' or @formcontrolname='changephotoId']")
	@CacheLookup
	WebElement HomePage_photo;

	public LobbyPage Set_HomePage_photo(String str) {
		HomePage_photo.clear();
		HomePage_photo.sendKeys(str);
		test.info("successfully upload  photo");

		return this;
	}

	@FindBy(xpath = "//input[@type='file']")
	@CacheLookup
	WebElement AddMarketing_photo;

	public LobbyPage setAddMarketing_photo(String str) throws InterruptedException {
		// AddMarketing_photo.clear();
		AddMarketing_photo.sendKeys(str);
		test.info("successfully upload  photo");
		Thread.sleep(2000);

		return this;
	}

	// Settings HomePage sub title
	@FindBy(xpath = "//input[@formcontrolname='subtitle']")
	@CacheLookup
	WebElement HomePage_subtitle;

	public LobbyPage Set_HomePage_subtitle(String name) {
		HomePage_subtitle.clear();
		HomePage_subtitle.sendKeys(name);
		test.info("homepage sub title = " + name);

		return this;

	}

	// Settings HomePage buttonText
	@FindBy(xpath = "//input[@formcontrolname='buttonText']")
	@CacheLookup
	WebElement HomePage_buttonText;

	public LobbyPage Set_HomePage_buttonText(String name) {
		HomePage_buttonText.clear();
		HomePage_buttonText.sendKeys(name);

		test.info("Entered Set sub Title = <b>" + "new sub title for homepage" + "</b>");

		return this;

	}

	// Settings HomePage buttonUrl
	@FindBy(xpath = "//input[@formcontrolname='buttonUrl']")
	@CacheLookup
	WebElement HomePage_buttonUrl;

	public LobbyPage Set_HomePage_buttonUrl(String name) {
		HomePage_buttonUrl.clear();
		HomePage_buttonUrl.sendKeys(name);

		test.info("Entered Set buttonUrl= <b>" + "www.comsmoslots.com" + "</b>");
		return this;
	}

	// Settings MetaData
	@FindBy(xpath = "//button[contains(text(),'Meta Data')]")
	@CacheLookup
	WebElement MetaData;

	public LobbyPage Set_MetaData() {
		sel.click(MetaData);
		return this;
	}

	// Settings MetaData tags
	@FindBy(xpath = "//input[contains(@placeholder,'Enter Tags')]")
	@CacheLookup
	WebElement MetaData_tags;

	public LobbyPage Set_MetaData_tags(String str) {
		MetaData_tags.clear();
		MetaData_tags.sendKeys(str + ",");
		test.info("Entered tags = <b>" + str + "</b>");
		return this;
	}

	@FindBy(xpath = "(//span[contains(text(),'Cocos Settings')])[1]") // span[.='FAQ']
	@CacheLookup
	public WebElement cocosSettings;

	@FindBy(xpath = "//mat-select[@formcontrolname='page']")
	@CacheLookup
	WebElement MetaData_Page;

	// settigns metadata select page
	@FindBy(xpath = "//mat-option//span[text()='Redemption Policy']") // span[.='FAQ']
	@CacheLookup
	public static WebElement select_page;

	public LobbyPage Set_MetaData_Page(String str) {
		sel.click(MetaData_Page);
		ldriver.findElement(By.xpath("//mat-option/span[text()='" + str + "']")).click();
		test.info("Page selected = <b>" + str + "</b>");
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='cocosUrl']") // span[.='FAQ']
	@CacheLookup
	public static WebElement cocosUrl;

	public LobbyPage Set_cocosUrl(String str) throws InterruptedException {
		cocosUrl.clear();
		cocosUrl.sendKeys(str);
		test.info("CocosUrl = <b>" + str + "</b>");
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='cocosVersion']") // span[.='FAQ']
	@CacheLookup
	public static WebElement cocosVersion;

	public LobbyPage Set_cocosVersion(String str) throws InterruptedException {
		cocosVersion.clear();
		cocosVersion.sendKeys(str);
		test.info("cocosVersion = <b>" + str + "</b>");
		return this;
	}

	// Settings Release Notes
	@FindBy(xpath = "//button[contains(text(),'Release Notes')]")
	@CacheLookup
	WebElement ReleaseNotes;

	public LobbyPage Set_ReleaseNotes() throws InterruptedException {
		sel.click(ReleaseNotes);
		Thread.sleep(1000);
		return this;
	}

	public By editReleaseNotesLabel = By.xpath("//h3[text()='Edit Release Note']");

	public boolean verifyEditReleaseNotesLabel() {
		return ldriver.findElements(editReleaseNotesLabel).size() > 0;
	}

	// Settings Release Notes(textfield)
	@FindBy(xpath = "//input[@formcontrolname='releaseNote']")
	@CacheLookup
	WebElement Release_input;

	public LobbyPage Set_Release_input(String str) throws InterruptedException {
		Release_input.clear();
		Release_input.sendKeys(str);
		test.info("Entered Release Notes = <b>" + str + "</b>");
		Thread.sleep(1000);
		return this;
	}

	// Settings MetaData Release url(textfield)
	@FindBy(xpath = "//input[@formcontrolname='url']")
	@CacheLookup
	WebElement Release_url;

	public LobbyPage Set_Release_url(String str) throws InterruptedException {
		Release_url.clear();
		Release_url.sendKeys(str);
		test.info("Entered Releaseurl = <b>" + str + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage Player_Registration_Link(String desc) throws InterruptedException {
		Player_Registration_Link.clear();
		Player_Registration_Link.sendKeys(desc);
		test.info("Player_Registration_Link= <b>" + desc + "</b>");
		Thread.sleep(500);
		return this;
	}

	public LobbyPage selectTabLCode() {
		Lname.sendKeys(Keys.TAB);
		return this;
	}

	public LobbyPage Enter_Lname() {
		Lname.sendKeys(Keys.ENTER);
		return this;
	}

	public LobbyPage SelectTabLanme() {
		Lname.sendKeys(Keys.TAB);
		return this;
	}

	public LobbyPage ClickDesc(String desc) throws InterruptedException {
		// description.clear();
		sel.click(description);
		sel.setText(description, desc);
		test.info("Add description with " + desc);
		Thread.sleep(1000);

		return this;
	}

	public LobbyPage Maintenance_Desc(String desc) throws InterruptedException {
		// description.clear();
		description.sendKeys(desc);
		test.info("Description added successfully");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ClickDesc_News() {
		sel.click(description_news);
		test.info("Clicked on description");
		return this;
	}

	public LobbyPage clicklobbymanagement() throws InterruptedException {
		sel.click(StoreManagement);
		test.info("Clicked on store management menu");
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage clickStoreAccounts() throws InterruptedException {
		sel.click(StoreAccounts);
		test.info("Clicked on Store accounts");
		Thread.sleep(2000);
		return this;
	}

	public void highlightElement(WebDriver driver, WebElement element) {
		// Change the border style of the element to yellow using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid yellow'", element);

		try {
			Thread.sleep(1000);
			sel.click(element);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Reset the border style to the original state using JavaScript
		js.executeScript("arguments[0].style.border=''", element);
	}

	public LobbyPage clickToCreate() throws InterruptedException {
		sel.click(Create_Button);
		// highlightElement(ldriver, Create_Button);
		test.info("Click to create");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickAddPlayerURL() {
		sel.click(AddPlayerURL);
		return this;
	}

	public LobbyPage clickToEdit() throws InterruptedException {
		System.out.println("click to edit  ");
		sel.click(EditButton);
		test.info("click to Edit ");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickToEdit_News() {
		System.out.println("click to edit news");
		sel.click(EditButton);
		test.info("click to Edit  news");
		return this;
	}

	public LobbyPage clickToEdit_FAQ() throws InterruptedException {
		System.out.println("click to edit FAQ");
		sel.click(EditButton1);
		test.info("click to Edit");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickCopyLobby() {
		sel.click(CopyLobby);
		return this;
	}

	public LobbyPage VerifyCopyLink() throws InterruptedException {

		if (driver.findElements(By.xpath("(//i[@class='ri-file-copy-line'])[1]")).size() > 0) {
			test.info("Successfully Viewed COPY store link icon");
			Thread.sleep(1000);
			clickCopyLobby();
			test.info("Successfully COPY store link link", extentScreenshot());
		} else {
			test.info("lobby COPY icon not found.", extentScreenshot());

		}
		Thread.sleep(2000);

		return this;
	}

	public LobbyPage clickViewLobby() throws InterruptedException {
		sel.click(View_Click);
		test.info("clicked on view lobby");
		Thread.sleep(1000);
		return this;
	}

	public static void waitForElement(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public LobbyPage fishGameConfiguration(String name, String code, String st, String mm, String ss, String descr)
			throws InterruptedException {
		ldriver.findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(name + "1");
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//input[@formcontrolname='code']")).sendKeys(code + "1");
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-select[@formcontrolname=\"betGroupIds\"]")).click();
		ldriver.findElement(By.xpath("//mat-option[@role='option']//following::span[contains(text(),'Junior')]"))
				.click();
		ldriver.findElement(By.xpath("//mat-option[@role='option']//following::span[contains(text(),'Expert')]"))
				.click();
		ldriver.findElement(By.xpath("//mat-option[@role='option']//following::span[contains(text(),'Medium')]"))
				.click();
		ldriver.findElement(By.xpath("//input[@placeholder=\"Search Bet Group\"]")).sendKeys(Keys.ESCAPE);

		ldriver.findElement(By.xpath("//span[text()='Sweep Tokens']")).click();
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).sendKeys(st);
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//input[@formcontrolname='mm']")).sendKeys(mm);
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//input[@formcontrolname='ss']")).sendKeys(ss);
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//textarea[@formcontrolname='description']")).sendKeys(descr);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewMaintenance() throws InterruptedException {
		sel.click(View_Maintenance);
		Thread.sleep(500);
		test.info("Store Account Maintenance Mode popup opened", extentScreenshot());
		Thread.sleep(500);
		return this;
	}

	public By StoreAccountMaintenanceMode_label = By.xpath("(//a[@title='Store Account Maintenance Mode'])[1]");

	public boolean VerifyStoreAccountMaintenanceMode_label() {
		return ldriver.findElements(StoreAccountMaintenanceMode_label).size() > 0;

	}

	public By StoreAccountMaintenanceMode_header = By.xpath("(//h3[text()='Store Account Maintenance Mode'])[1]");

	public boolean VerifyStoreAccountMaintenanceMode_header() {
		return ldriver.findElements(StoreAccountMaintenanceMode_header).size() > 0;
	}

	public LobbyPage clickViewLobby_Profile() throws InterruptedException {
		sel.click(ViewLobby_Profile);
		Thread.sleep(500);
		return this;

	}

	public LobbyPage clickView_LobbyStorePackage() throws InterruptedException {
		sel.click(ViewLobby_storePackage);
		test.info("Clicked on lobby  store package");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage websitePackage() throws InterruptedException {
		sel.click(websitePackage);
		test.info("Clicked on website package");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickViewLobby_LobbyCPackage() throws InterruptedException {
		sel.click(ViewLobby_LobbyCPackage);
		test.info("Clicked on Custom Packages");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickViewLobby_Game() throws InterruptedException {
		System.out.println(
				"games click = " + ldriver.findElement(By.xpath("//button[contains(text(),'Games')]")).getText());
		sel.click(ViewLobby_Game);
		test.info("click on Store Games");
		Thread.sleep(1500);

		return this;
	}

	public LobbyPage clickViewLobby_ReviewVersion_Android(String text) throws InterruptedException {
		ViewLobby_LobbyVersion_Android_ReviewVersion.clear();
		ViewLobby_LobbyVersion_Android_ReviewVersion.sendKeys(text);
		test.info("ReviewVersion_Android " + text);
		return this;
	}

	public LobbyPage clickViewLobby_ProductionVersion_Android(String text) throws InterruptedException {
		ViewLobby_LobbyVersion_Android_ProductionVersion.clear();
		ViewLobby_LobbyVersion_Android_ProductionVersion.sendKeys(text);
		test.info("ReviewVersion_Android " + text);
		return this;
	}

	public LobbyPage clickViewLobby_ReviewVersion_IOS(String text) throws InterruptedException {
		ViewLobby_LobbyVersion_ios_ReviewVersion.clear();
		ViewLobby_LobbyVersion_ios_ReviewVersion.sendKeys(text);
		test.info("ReviewVersion_ios " + text);
		return this;
	}

	public LobbyPage clickViewLobby_ProductionVersion_IOS(String text) throws InterruptedException {
		ViewLobby_LobbyVersion_ios_ProductionVersion.clear();
		ViewLobby_LobbyVersion_ios_ProductionVersion.sendKeys(text);
		test.info("ProductionVersion_ios " + text);
		return this;
	}

	public LobbyPage clickViewLobby_Version() throws InterruptedException {
		sel.click(ViewLobby_LobbyVersion);
		test.info("Click on lobby version");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage DeleteVersion() {
		sel.click(DeleteVersion);
		return this;
	}

	public LobbyPage clickViewLobby_Bonus() throws InterruptedException {
		sel.click(ViewLobby_LobbyBonus);
		test.info("Clicked on Store bonus ");
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage clickViewLobby_coupon() throws InterruptedException {
		sel.click(ViewLobby_coupon);
		test.info("click on Store Coupon");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_Withdraw() throws InterruptedException {
		sel.click(ViewLobby_WithdrawSetting);
		test.info("Click on Withdraw settings");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_amount(String s) {
		ViewLobby_WithdrawSetting_amount.clear();
		ViewLobby_WithdrawSetting_amount.sendKeys(s);
		test.info("Entered WithdrawSetting amount = <b>" + "1" + "</b>");

		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_sweepTokens(String s) {
		ViewLobby_WithdrawSetting_sweepTokens.clear();
		ViewLobby_WithdrawSetting_sweepTokens.sendKeys(s);
		test.info("Entered WithdrawSetting sweepTokens = <b>" + "10" + "</b>");

		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_minimumAmountWithdrawal(String s) throws InterruptedException {
		ViewLobby_WithdrawSetting_minimumAmountWithdrawal.clear();
		ViewLobby_WithdrawSetting_minimumAmountWithdrawal.sendKeys(s);
		test.info("Entered WithdrawSetting minimumAmountWithdrawal = <b>" + "10" + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_withdrawApprovalRequired(String s) throws InterruptedException {
		ViewLobby_WithdrawSetting_withdrawApprovalRequired.clear();
		ViewLobby_WithdrawSetting_withdrawApprovalRequired.sendKeys(s);
		test.info("Entered WithdrawSetting withdrawApprovalRequired = <b>" + "100" + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_PerTransactionLimit(String s) throws InterruptedException {
		ViewLobby_WithdrawSetting_PerTransactionLimit.clear();
		ViewLobby_WithdrawSetting_PerTransactionLimit.sendKeys(s);
		test.info("Entered WithdrawSetting PerTransactionLimit = <b>" + "10000" + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ViewLobby_WithdrawSetting_perDayTransactionLimit(String s) throws InterruptedException {
		ViewLobby_WithdrawSetting_perDayTransactionLimit.clear();
		ViewLobby_WithdrawSetting_perDayTransactionLimit.sendKeys(s);
		test.info("Entered WithdrawSetting perDay TransactionLimit = <b>" + "20000" + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_AppSetting() throws InterruptedException {
		sel.click(ViewLobby_AppSetting);
		test.info("click on lobby app settings");
		Thread.sleep(1000);

		return this;
	}

	public LobbyPage clickViewLobby_WebsiteSetting() throws InterruptedException {
		sel.click(ViewLobby_WebsiteSetting);
		test.info("click on Website settings");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_StoreSetting() throws InterruptedException {
		sel.click(ViewLobby_StoreSetting);
		test.info("click on Store settings", extentScreenshot());
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath = "//button[text()=' Player Setting ']")
	@CacheLookup
	WebElement ViewLobby_PlayerSetting;

	public LobbyPage clickViewLobby_PlayerSetting() throws InterruptedException {
		sel.click(ViewLobby_PlayerSetting);
		test.info("click on player settings");
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "(//span[text()='Sign Up Options']//following::mat-slide-toggle[@formcontrolname='email'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsSignupEmail;

	@FindBy(xpath = "(//span[text()='Sign Up Options']//following::mat-slide-toggle[@formcontrolname='phoneNumber'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsSignupphoneNumber;

	@FindBy(xpath = "(//span[text()='Player Profile Options']//following::mat-slide-toggle[@formcontrolname='email'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsProfileOptionsEmail;

	@FindBy(xpath = "(//span[text()='Player Profile Options']//following::mat-slide-toggle[@formcontrolname='phoneNumber'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsProfileOptionsNumber;

	@FindBy(xpath = "(//span[text()='Guest to Player']//following::mat-slide-toggle[@formcontrolname='emailVerified'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsGuesttoPlayerEmail;

	@FindBy(xpath = "(//span[text()='Guest to Player']//following::mat-slide-toggle[@formcontrolname='phoneVerified'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsGuesttoPlayerphoneNumber;

	@FindBy(xpath = "(//span[text()='Guest to Player']//following::mat-slide-toggle[@formcontrolname='kycVerified'])[1]")
	@CacheLookup
	public WebElement PlayerSettingsGuesttoPlayerkyc;

	public LobbyPage clickViewLobby_WebsiteSetting_TabAccess() throws InterruptedException {
		sel.click(ViewLobby_WebsiteSetting_TabAccess);
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickViewLobby_WebsiteSetting_Signup() {
		sel.click(ViewLobby_WebsiteSetting_Signup);
		return this;
	}

	public LobbyPage clickViewLobby_WebsiteSetting_Signup_details(String title, String desc) {
		ViewLobby_WebsiteSetting_Signup_Title.clear();
		ViewLobby_WebsiteSetting_Signup_Desc.clear();
		ViewLobby_WebsiteSetting_Signup_Title.sendKeys(title);
		ViewLobby_WebsiteSetting_Signup_Desc.sendKeys(desc);
		return this;
	}

	public LobbyPage clickViewLobby_CorporationDetails() throws InterruptedException {
		sel.click(ViewLobby_CorporationDetails);
		test.info("Clicked Corporation Details");
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//h3[text()='Update Marketing Template']")
	@CacheLookup
	public WebElement UpdateMarketinglabel;

	public LobbyPage clickViewLobby_AppMarketing() throws InterruptedException {
		sel.click(AppMarketinglabel);
		test.info("Clicked App Marketing", extentScreenshot());
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//h3[text()=\"Add Social Media Settings\"]")
	@CacheLookup
	public WebElement AddSocialMediaSettingsHeading;

	@FindBy(xpath = "//h3[text()=\"Update Social Media Settings\"]")
	@CacheLookup
	public WebElement updateSocialMediaSettingsHeading;

	public LobbyPage clickViewLobby_Socialmedia() throws InterruptedException {
		sel.click(Socialmedia);
		test.info("Clicked SocialMediaSettings", extentScreenshot());
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clickViewLobby_CorporationDetails_name(String name) throws InterruptedException {
		ViewLobby_CorporationDetails_name.clear();
		ViewLobby_CorporationDetails_name.sendKeys(name);
		test.info("Entered name successfully");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_CorporationDetails_contactNumber(String contactNumber) throws InterruptedException {
		ViewLobby_CorporationDetails_contactNumber.clear();
		ViewLobby_CorporationDetails_contactNumber.sendKeys(contactNumber);
		test.info("Entered contactNumber successfully");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_CorporationDetails_email(String email) throws InterruptedException {
		ViewLobby_CorporationDetails_email.clear();
		ViewLobby_CorporationDetails_email.sendKeys(email);
		test.info("Entered email successfully");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickViewLobby_CorporationDetails_address(String address) throws InterruptedException {
		ViewLobby_CorporationDetails_address.clear();
		ViewLobby_CorporationDetails_address.sendKeys(address);
		test.info("Entered address successfully");
		Thread.sleep(500);
		return this;
	}

	public LobbyPage ClickToSave() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", Save_Button);
		js.executeScript("window.scrollBy(0,50)", "");
		sel.click(Save_Button);
		test.info("Data saved successfully", extentScreenshot());
		return this;
	}

	public LobbyPage ClickToSavePlayer() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		test.info("Player saved successfully", extentScreenshot());
		Thread.sleep(1000);
		pageScroll("up");
		sel.VerifyData(ldriver, YesDeleteIt);
		return this;
	}

	public LobbyPage ClickToSaveSettings() throws InterruptedException, IOException {
		PageScrollToEnd();
		sel.click(Save_Button);
		Thread.sleep(1000);
		test.info("Data saved successfully", extentScreenshot());
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage selectStoreType(String lobby) throws InterruptedException {

		if (lobby.equalsIgnoreCase("owner")) {
			WebElement ele = driver.findElement(By.xpath("//span[text()='Owner Based ']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", ele);
			test.info("<b>" + "OWNER " + "</b>" + "" + "based option selected");
		} else {
			WebElement ele = driver.findElement(By.xpath("//span[text()='App Based ']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()", ele);
			test.info("<b>" + "APP " + "</b>" + "" + "based option selected");
		}
		return this;
	}

	public LobbyPage ClickToSaveMaintainace() throws InterruptedException {
		sel.click(Save_Button);
		test.info("Clicked on Maintainace save button");
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "(//*[text()='Promotions'])[1]") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	WebElement Promotions_Button;

	public LobbyPage ClickToPromotionWebsite() throws InterruptedException {
		sel.click(Promotions_Button);
		test.info("Clicked on saved button");
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage ClickToSave_GeneralPages() throws InterruptedException {
		sel.click(Save_Button_GeneralPages);
		// Thread.sleep(2000);
		return this;
	}

	public LobbyPage ClickToYes() throws InterruptedException {
		sel.click(clickyes);
		test.info("Clicked on yes button");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage ClickToSavePromotion() {
		sel.click(Save_Button_Promotion);
		test.info("saved promotion");
		return this;
	}

	public LobbyPage ClickToSaveFAQ() throws InterruptedException {
		sel.click(Save_Button1);
		test.info("saved FAQ");
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage clickAppBased() {
		sel.click(AppBasedradio);
		return this;
	}

	public void clickOwnerBased() {
		sel.click(OwenerBasedradio);
	}

	public LobbyPage Setlobbycode(String code) {
		Lcode.clear();
		Lcode.sendKeys(code);
		test.info("Lobby code = <b>" + code + "</b>");
		System.out.println("Lobby code- " + code);
		return this;
	}

	public LobbyPage Set_Desc(String desc) throws InterruptedException {
		// description.clear();
		description.sendKeys(desc);
		test.info("Entered  description = <b>" + desc + "</b>");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage clicklobbysave() {
		sel.click(Lobbysave);
		test.info("successfully saved lobby details");
		return this;
	}

	public LobbyPage Setlobbyname(String name) {
		Lname.clear();
		Lname.sendKeys(name);
		test.info("Lobby name = <b>" + name + "</b>");
		return this;

	}

	public LobbyPage clickTo_PlayerCoupon() {

		sel.click(PlayerCoupon);
		return this;

	}

	public void LobbySave() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", Lobbysave);
		test.info("Click on Save button");
		Thread.sleep(2000);
	}

	public By aboutFooter = By.xpath("//div[@class='aboutFooter']");

	@FindBy(xpath = "//div[@class='aboutFooter']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement aboutFooterElement;

	public boolean verifyaboutFooter() {

		return ldriver.findElements(aboutFooter).size() > 0;
	}

	public By TermsNConditions = By.xpath("//a[text()='Terms & Conditions']");

	@FindBy(xpath = "//a[text()='Terms & Conditions']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement TermsNConditionsElement;

	public boolean verifyTermsNConditions() {

		return ldriver.findElements(TermsNConditions).size() > 0;
	}

	public By ResponsibleGaming = By.xpath("//a[text()='Responsible Gaming']");

	@FindBy(xpath = "//a[text()='Responsible Gaming']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement ResponsibleGamingElement;

	public boolean verifyResponsibleGaming() {

		return ldriver.findElements(ResponsibleGaming).size() > 0;
	}

	public By PrivacyPolicy = By.xpath("//a[text()='Privacy Policy']");

	@FindBy(xpath = "//a[text()='Privacy Policy']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement PrivacyPolicyElement;

	public boolean verifyPrivacyPolicy() {

		return ldriver.findElements(PrivacyPolicy).size() > 0;
	}

	public By SweepRules = By.xpath("//a[text()='Sweep Rules']");

	@FindBy(xpath = "//a[text()='Sweep Rules']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement SweepRulesElement;

	public boolean verifySweepRules() {

		return ldriver.findElements(SweepRules).size() > 0;
	}

	public By RedemptionPolicy = By.xpath("//a[text()='Redemption Policy']");

	@FindBy(xpath = "//a[text()='Redemption Policy']") // ->(//button//span[text()='Save'])[1]
	@CacheLookup
	public WebElement RedemptionPolicyElement;

	public boolean verifyRedemptionPolicy() {

		return ldriver.findElements(RedemptionPolicy).size() > 0;
	}

	public LobbyPage clickViewLobby_Search(String key) {
		try {
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.clear();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.click();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(key);
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			// System.out.println("search 'FOT'- games");
		} catch (Exception e) {
			System.out.println("error in search");

		}
		return this;
	}

	public LobbyPage SearchItems(String key) throws InterruptedException {
		try {
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.clear();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.click();
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(key);
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			// System.out.println("search 'FOT'- games");

//			if ((driver.findElements(By.xpath("//td[text()='" + key + "']")).size() > 0) or 
//				(driver.findElements(By.xpath("//div/span[text()='" + key + "']")).size() > 0)) {
//				test.info("Searched item = <b>" + key + "</b>", extentScreenshot());
//			} else {
//				SearchItems(key);
//			}
		} catch (Exception e) {
			System.out.println("error in search");

		}
		Thread.sleep(2000);

		return this;
	}

	public LobbyPage VerifySearch(String Lobbycode) throws IOException, InterruptedException {
		if (driver.findElement(By.xpath("//tbody//tr//td[contains(text(),'" + Lobbycode + "')]")) != null) {
			test.pass("successfuly search item  -> " + Lobbycode, extentScreenshot());
		} else {
			test.fail("Something Wrong!To search item in a List.", extentScreenshot());
		}
		Thread.sleep(2000);

		return this;
	}

	public LobbyPage Searchjackpot(String key) {
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
		} catch (Exception e) {
			System.out.println("error in search");

		}
		return this;
	}

	public LobbyPage clickToViewPurchaseHistory() throws InterruptedException {
		sel.click(ViewPurchaseHistory);
		test.info("Clicked on Store Package Package Purchase History button", extentScreenshot());
		Thread.sleep(1000);

		return this;
	}

	public LobbyPage clickToViewCustomPurchaseHistory() throws InterruptedException {
		sel.click(ViewCustomPurchaseHistory);
		test.info("Clicked on Custom  Package Purchase History button");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickToViewCouponAppliedHistory() throws InterruptedException {
		sel.click(ViewCouponAppliedHistory);
		test.info("Clicked on Coupon Applied History button");
		Thread.sleep(1000);

		return this;
	}

	public By CouponAppliedHistory = By.xpath("//h3[contains(text(),\"Coupon Applied History\")]");

	public boolean verifywCouponAppliedHistory() throws InterruptedException {
		return ldriver.findElements(CouponAppliedHistory).size() > 0;
	}

	public LobbyPage clickClearSearch() {
		sel.click(ClearSearch);
		return this;
	}

	public LobbyPage View_Click() throws InterruptedException {
		Thread.sleep(1000);
		sel.click(View_Click);
		Thread.sleep(2000);
		test.info("Clicked on view button", extentScreenshot());
		return this;
	}

	// close withdraw close popup
	@FindBy(xpath = "(//button[contains(@class,'btn-close')])[1]")
	@CacheLookup

	WebElement withdrawPopup_Close_Button;

	public LobbyPage withdrawPopupClose() {
		sel.click(withdrawPopup_Close_Button);
		return this;
	}

	public LobbyPage ClickToClose() throws InterruptedException {
		sel.click(Popup_Close_Button);
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage ClickToClear_Search() {
		sel.click(Search_Clear_Button);
		return this;
	}

	public LobbyPage ClickToCancel() throws InterruptedException {
		if (CancelButton.isDisplayed() == true)
			;
		{
			sel.click(CancelButton);
		}
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickTo_CreateBonus() throws InterruptedException {
		sel.click(Create_Button);
		test.info("Click to Create Store bonus");
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage setBonusName(String name) throws InterruptedException {
		Name.clear();
		Name.sendKeys(name);
		test.info("Entered  name successfully= <b>" + name + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage setcouponName(String name) {
		Name.clear();
		Name.sendKeys(name);
		test.info("Entered coupon name successfully= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage Setcoupon_discountedPercentage(String percentage) throws InterruptedException {
		discountedPercentage.clear();
		Thread.sleep(1000);
		discountedPercentage.sendKeys(percentage);
		test.info("Entered  discountedPercentage= <b>" + percentage + "</b>");
		System.out.println("Last added coupon is ->" + percentage);

		return this;
	}

	public LobbyPage Setcoupon_expiryAt(String date) throws InterruptedException {
		sel.click(expiryAt);
		ldriver.findElement(By.xpath("//div[contains(text(),'" + date + "')]")).click();
		test.info("Setcoupon_expiryAt date = <b>" + date + "</b>");

		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='startsAt']")
	@CacheLookup
	public static WebElement StartDate;

	public LobbyPage Setcoupon_startDate(String date) throws InterruptedException {
		sel.click(StartDate);
		Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", ldriver.findElement(By.xpath("//div[text()=' " + date + " ']")));
		test.info("Setcoupon_start date = <b>" + "todays date - " + date + "</b>");
		Thread.sleep(1000);

		return this;
	}

	public LobbyPage Setpkg_expiryAt(String str) throws InterruptedException {
		String[] monthNames = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
		String[] parts = str.split("/");
		String day = parts[0]; // store the first part as year
		// String month = parts[1]; // store the second part as month
		int month = Integer.valueOf(parts[1]);
		System.out.println("selected MONTH ->" + monthNames[month - 1]);
		String year = parts[2]; // store the third part as day

		if (ldriver
				.findElements(By.xpath(
						"//input[@formcontrolname='expiryAt']//following-sibling::mat-icon[contains(text(),'clear')]"))
				.size() > 0) {
			ldriver.findElement(By.xpath(
					"//input[@formcontrolname='expiryAt']//following-sibling::mat-icon[contains(text(),'clear')]"))
					.click();
		}
		sel.click(expiryAt);
		ldriver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();

		ldriver.findElement(
				By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]//div[text()=' " + year + " ']"))
				.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]//div[text()=' "
				+ monthNames[month - 1] + " ']")).click();
		Thread.sleep(1000);
		ldriver.findElement(
				By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]//div[text()=' " + day + " ']"))
				.click();
		test.info("Set package expiryAt date = <b>" + str + "</b>");

		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='startsAt']")
	@CacheLookup
	public static WebElement startsAt;

	public LobbyPage Setpkg_startsAt(String date) {
		sel.click(startsAt);
		ldriver.findElement(By.xpath("//div[contains(text(),'" + date + "')]")).click();
		test.info("Set package start date = <b>" + "todays date - " + date + "</b>");
		return this;
	}

	public LobbyPage purchaseDay(String day) {
		// ldriver.findElement(By.xpath("//input[@type='checkbox']//preceding::div[contains(text(),'"+day+"')]")).click();
		// ldriver.findElement(By.xpath("//input[@type='checkbox']//ancestor::mat-checkbox[@name='"+day+"']")).click();
		return this;
	}

	public LobbyPage Setcoupon_usageByPlayer(String coupon) {
		usageByPlayer.clear();
		usageByPlayer.sendKeys(coupon);
		test.info("Entered  Usage of coupon by a player required " + "= <b>" + coupon + "</b>");

		return this;

	}

	public LobbyPage Setcoupon_activationAfterPurchase(String coupon) {
		activationAfterPurchase.clear();
		activationAfterPurchase.sendKeys(coupon);
		test.info("Entered  Coupon activation after x no of package purchases by a player = <b>" + coupon + "</b>");

		return this;

	}

	public void levelBonus(String bonusLevelName, int noOfReferral, int recharge, int bonusGL, int bonusSL, String desc)
			throws InterruptedException {
		setBonusName(bonusLevelName + 1);
		driver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='numberOfReferrals']"))
				.sendKeys(String.valueOf(noOfReferral));
		driver.findElement(By.xpath("//input[@formcontrolname='rechargeAmount']")).sendKeys(String.valueOf(recharge));
		Thread.sleep(500);
		gameToken(String.valueOf(bonusGL));
		sweepToken(String.valueOf(bonusSL));
		ClickDesc(desc);

		test.info("Entered BonusName = <b>" + bonusLevelName + 1 + "</b>");
		test.info("Entered number of referral is => <b>" + noOfReferral + "</b>");
		test.info("Entered number of recharge amount is => <b>" + recharge + "</b>");
		test.info("Entered gameToken = <b>" + bonusGL + "</b>");
		test.info("Entered sweepToken = <b>" + bonusSL + "</b>");
		test.info("Entered description = <b>" + "This is testing entry on Level Wise Bonus" + "</b>");

	}

	public LobbyPage setBonusAction(String Action) throws InterruptedException {
		sel.click(var_Action);
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//span[contains(text(),'" + Action + "')]")).click();
		// sel.click(select_Action);
		Thread.sleep(500);
		return this;
	}

	public LobbyPage setactionUrl(String Action) throws InterruptedException {
		sel.click(var_Actionurl);
		Thread.sleep(1000);

		ldriver.findElement(By.xpath("//span[contains(text(),'" + Action + "')]")).click();
		test.info("Action URL = <b>" + Action + "</b>");
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage gameToken(String token) {
		select_GameToken.clear();
		select_GameToken.sendKeys(token);
		return this;
	}

	public LobbyPage sweepToken(String token) {
		select_SweepToken.clear();
		select_SweepToken.sendKeys(token);
		return this;
	}

	public String gameTokenvalue(String token) {
		select_GameToken.clear();
		select_GameToken.sendKeys(token);
		return token;

	}

	public String sweepTokenvalue(String token) {
		select_SweepToken.clear();
		select_SweepToken.sendKeys(token);
		return token;

	}

	public LobbyPage clickToNews() throws InterruptedException {
		sel.click(news);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage clickToFAQ() throws InterruptedException {
		sel.click(faq);
		Thread.sleep(500);
		return this;
	}

	public LobbyPage clickToPromotion() throws InterruptedException {
		sel.click(Promotion);
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage SetNewsTitle(String name) {
		Create_title.clear();
		Create_title.sendKeys(name);
		test.info("Entered Title = <b>" + name + "</b>");
		return this;
	}

	public LobbyPage SetFAQques(String name) {
		Create_question.clear();
		Create_question.sendKeys(name);
		test.info("Entered Question = <b>" + name + "</b>");
		return this;

	}

	public LobbyPage SetFAQanswer(String name) {
		Create_answer.clear();
		Create_answer.sendKeys(name);
		test.info("Entered Answer = <b>" + name + "</b>");
		return this;

	}

	public LobbyPage SetCategory(String name) throws InterruptedException {

		sel.click(faqCategory);

		ldriver.findElement(By.xpath("//mat-option/span[text()='" + name + "']")).click();
		test.info("Select Category = <b>" + name + "</b>");
		Thread.sleep(1000);
		return this;

	}

	public LobbyPage SetOrder(String order) throws InterruptedException {
		SetOrder.sendKeys(order);
		test.info("Select order = <b>" + order + "</b>");
		Thread.sleep(500);
		return this;

	}

	public LobbyPage SetNewsicon(String name) throws InterruptedException {

		Create_icon.sendKeys(name);
		test.info(" image upload successfully");
		Thread.sleep(3000);
		return this;

	}

	public LobbyPage packageDeleteItems() throws InterruptedException {
		sel.click(packageDeletebutton);
		test.info("Clicked on delete  button");
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage Deleteappsetings() throws InterruptedException {
		sel.click(Deleteappsetings);
		test.info("Clicked on delete  app settings");
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//button[text()='Yes']") // ->(//a[@title="Delete"])[1]
	@CacheLookup
	public WebElement clickToYes;

	public LobbyPage clickToYesButton() throws InterruptedException {
		sel.click(clickToYes);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage DeleteItems_Lobby() throws InterruptedException {
		sel.click(Deletebutton_Lbonus);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage DeleteClick_websiteSetings() throws InterruptedException {
		sel.click(Deletebutton_websiteSetings);
		Thread.sleep(1000);
		test.info("click on delete button");
		return this;
	}

	public void searchlist(String searchKey, String expectedresult, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement searchlist = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")));
		searchlist.clear();
		searchlist.sendKeys(searchKey);
		searchlist.sendKeys(Keys.RETURN);
		java.util.List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//table//tbody//tr[td[contains(.,'" + expectedresult + "')]]")));
		if (elements.size() > 0) {
			System.out.println("Search is passed");
		} else {
			System.out.println("Search is failed");
		}
	}

	public LobbyPage AppSetting_Company(String name) throws InterruptedException {
		ViewLobby_AppSetting_Company.clear();
		ViewLobby_AppSetting_Company.sendKeys(name);
		test.info("Entered AppSetting_Company = <b>" + "Gameium" + "</b>");
		Thread.sleep(1000);
		return this;

	}

	public LobbyPage AppSetting_website(String name) throws InterruptedException {
		ViewLobby_AppSetting_website.clear();
		ViewLobby_AppSetting_website.sendKeys(name);
		test.info("Entered AppSetting_website = <b>" + "www.gameium.com" + "</b>");
		Thread.sleep(1000);
		return this;

	}

	public LobbyPage AppSetting_TermsCondition(String name) throws InterruptedException {
		ViewLobby_AppSetting_TermsCondition.clear();
		ViewLobby_AppSetting_TermsCondition.sendKeys(name);
		test.info("Entered AppSetting_TermsCondition = <b>" + "www.gameium.com/contact-us/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_PrivacyPolicy(String name) throws InterruptedException {
		ViewLobby_AppSetting_PrivacyPolicy.clear();
		ViewLobby_AppSetting_PrivacyPolicy.sendKeys(name);
		test.info("Entered AppSetting_PrivacyPolicy = <b>" + "www.gameium.com/contact-us/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_copyRights(String name) throws InterruptedException {
		ViewLobby_AppSetting_copyRights.clear();
		ViewLobby_AppSetting_copyRights.sendKeys(name);
		test.info("Entered AppSetting_copyRights = <b>" + "www.gameium.com/contact-us/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_ResponsibleGamingLink(String name) throws InterruptedException {
		ViewLobby_AppSetting_ResponsibleGamingLink.clear();
		ViewLobby_AppSetting_ResponsibleGamingLink.sendKeys(name);
		test.info("Entered AppSetting_ResponsibleGamingLink = <b>" + "www.gameium.com/contact-us/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_RedemptionPolicyLink(String name) throws InterruptedException {
		ViewLobby_AppSetting_RedemptionPolicyLink.clear();
		ViewLobby_AppSetting_RedemptionPolicyLink.sendKeys(name);
		test.info("Entered AppSetting_RedemptionPolicyLink = <b>" + "www.gameium.com/contact-us/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_SweepRulesLink(String name) throws InterruptedException {
		ViewLobby_AppSetting_SweepRulesLink.clear();
		ViewLobby_AppSetting_SweepRulesLink.sendKeys(name);
		test.info("Entered AppSetting_SweepRulesLink = <b>" + "www.gameium.com/sweeprules/" + "</b>");

		Thread.sleep(1000);

		return this;

	}

	public LobbyPage AppSetting_faqUrl(String name) throws InterruptedException {
		ViewLobby_AppSetting_faqUrl.clear();
		ViewLobby_AppSetting_faqUrl.sendKeys(name);
		test.info("Entered AppSetting_FaqUrl = <b>" + "www.gameium.com/faq/" + "</b>");
		Thread.sleep(1000);
		return this;

	}

	public LobbyPage LobbyPackage_Code(String name) {
		Lcode.clear();
		Lcode.sendKeys(name);
		test.info(" package code= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_name(String name) {
		Lname.clear();
		Lname.sendKeys(name);
		test.info(" package name= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_amount(String name) {
		ViewLobby_LobbyPackage_amount.clear();
		ViewLobby_LobbyPackage_amount.sendKeys(name);
		test.info(" package  amount= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_Sweeptoken(String name) {
		ViewLobby_LobbyPackage_sweepToken.clear();
		ViewLobby_LobbyPackage_sweepToken.sendKeys(name);
		test.info(" package ST= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_extraSweeptoken(String name) {
		ViewLobby_LobbyPackage_extrasweepToken.clear();
		ViewLobby_LobbyPackage_extrasweepToken.sendKeys(name);
		test.info(" package Extra SweepToken= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_Gametoken(String name) {
		ViewLobby_LobbyPackage_gameToken.clear();
		ViewLobby_LobbyPackage_gameToken.sendKeys(name);
		test.info(" package GameToken= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage LobbyPackage_discountAmount(String name) {
		ViewLobby_LobbyPackage_discountAmount.clear();
		ViewLobby_LobbyPackage_discountAmount.sendKeys(name);
		test.info("store package discount amount= <b>" + name + "</b>");
		return this;
	}

	public LobbyPage setCountry() throws InterruptedException {
		sel.click(Country);
		// SetCountry.sendKeys(country);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()='India']")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='India']")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='United States']")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='Canada']")).click();
		SetCountry.sendKeys(Keys.ESCAPE);
		test.info("Lobby Country selected <b>" + "" + "</b>");
		Thread.sleep(1000);
		return this;
	}

	// announcement code
	@FindBy(xpath = "//mat-select[@formcontrolname='announcementCategory']")
	@CacheLookup
	private WebElement AnnouncementCategory;

	@FindBy(xpath = "//span[contains(text(),'Game Update')]")
	@CacheLookup
	public static WebElement Select_AnnouncementCategory;

	public LobbyPage Select_AnnouncementCategory_Announcement(String category) throws InterruptedException {
		sel.click(AnnouncementCategory);
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + category + "')]")).click();
		Thread.sleep(300);
		// Select_AnnouncementCategory.sendKeys(Keys.ESCAPE);
		return this;
	}

	@FindBy(xpath = "//mat-select[@formcontrolname='lobbyCode']")
	@CacheLookup
	private WebElement StoreAccount;

	@FindBy(xpath = "//span[contains(text(),'CosmoSlot')]")
	@CacheLookup
	public static WebElement Select_StoreAccount;

	public LobbyPage SelectStoreAccount_Announcement(String code) throws InterruptedException {
		sel.click(StoreAccount);
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + code + "')]")).click();
		Thread.sleep(300);
		// Select_StoreAccount.sendKeys(Keys.ESCAPE);
		return this;
	}

	public LobbyPage setGames(String str) throws InterruptedException {

		sel.click(Games);
		Thread.sleep(200);
		sel.click(SetGames);
		Thread.sleep(200);

		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));

		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				sel.click(inputElement);
				test.info("Selected slot Games = <b>" + inputElement.getText() + "</b>");
			}
			System.out.println(boxes.size() + " Games found by className \n");
		}
		Thread.sleep(2000);
		SetGames.sendKeys(Keys.TAB);
		Thread.sleep(1500);
		return this;
	}

	public LobbyPage DeleteGamesonEdit(String str) throws InterruptedException {

		ldriver.findElement(
				By.xpath("(//span[normalize-space()='" + str + "']//following::i[@class='ri-close-fill'])[1]")).click();
		return this;
	}

	public LobbyPage setKenoGames(String str) throws InterruptedException {

		sel.click(KenoGames);
		Thread.sleep(200);
		sel.click(KenoSetGames);
		Thread.sleep(200);

		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));

		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				sel.click(inputElement);
				test.info("Selected keno Games = <b>" + inputElement.getText() + "</b>");
			}
			System.out.println(boxes.size() + " Keno Games found by className \n");
		}
		Thread.sleep(2000);
		KenoSetGames.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath = "(//div[@id='fishGameSelectBox']//following::span[text()='Search Game'])[1]")
	@CacheLookup
	private WebElement FishGames;

	@FindBy(xpath = "//input[@placeholder='Search Game']")
	@CacheLookup
	public static WebElement FishSetGames;

	public LobbyPage setFishGames(String str) throws InterruptedException {

		sel.click(FishGames);
		Thread.sleep(200);
		sel.click(FishSetGames);
		Thread.sleep(200);

		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				sel.click(inputElement);
				test.info("Selected Fish Games = <b>" + inputElement.getText() + "</b>");
			}
			System.out.println(boxes.size() + " Fish Games found by className \n");
		}
		Thread.sleep(2000);
		FishSetGames.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage Click_Maintenance_platform() throws InterruptedException {

		// input[@type='checkbox']//ancestor::mat-slide-toggle[@formcontrolname='isMaintenance']
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", ldriver.findElement(By.xpath("(//input[@type='checkbox'])[1]")));
		Thread.sleep(200);
		sel.click(web);
		Thread.sleep(200);
		sel.click(android);
		Thread.sleep(200);
		sel.click(ios);
		Thread.sleep(200);
		sel.click(web);
		Thread.sleep(200);
		sel.click(android);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage SocialMediaSettings_Create(String fb, String insta, String tw, String wa)
			throws InterruptedException {

		// input[@type='checkbox']//ancestor::mat-slide-toggle[@formcontrolname='isMaintenance']
		driver.findElement(By.xpath("//input[@formcontrolname='fbPage']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='fbPage']")).sendKeys(fb);
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@formcontrolname='instagramAccount']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='instagramAccount']")).sendKeys(insta);
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@formcontrolname='twitterHandler']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='twitterHandler']")).sendKeys(tw);
		Thread.sleep(300);
		driver.findElement(By.xpath("//input[@formcontrolname='whatsAppNumber']")).clear();
		driver.findElement(By.xpath("//input[@formcontrolname='whatsAppNumber']")).sendKeys(wa);
		Thread.sleep(1000);
		return this;
	}

	public LobbyPage Click_Maintenance_platform_Settings() throws InterruptedException {

		// input[@type='checkbox']//ancestor::mat-slide-toggle[@formcontrolname='isMaintenance']
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", ldriver.findElement(By.xpath("(//input[@type='checkbox'])[1]")));
		Thread.sleep(200);
		sel.click(web);
		Thread.sleep(200);
		sel.click(adminMaintenanace);
		Thread.sleep(200);
		sel.click(android);
		Thread.sleep(200);
		sel.click(ios);
		Thread.sleep(200);
		sel.click(web);
		Thread.sleep(200);
		sel.click(adminMaintenanace);
		Thread.sleep(200);
		sel.click(cocos);
		Thread.sleep(200); // release 1.2.3
		test.info("Clicked on Lobby under Maintenance mode");
		return this;
	}

	public LobbyPage pageScroll(String state) {

		if (state.equalsIgnoreCase("up")) {
			ldriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		} else {
			ldriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		}

		return this;
	}

	public void ApplyCouponCode(String Code) throws IOException, InterruptedException {
		ldriver.findElement(By.xpath("//input[@placeholder='coupon code']")).sendKeys(Code);
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(2000);
	}

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname='userRole']")
	@CacheLookup
	public WebElement role;

	@FindBy(xpath = "//mat-select[@formcontrolname='userRole']//following::mat-option[2]")
	@CacheLookup
	public static WebElement RoleSelect;

	public LobbyPage selectRole(String str) throws InterruptedException {

		Thread.sleep(500);
		sel.click(role);
		// RoleSelect.sendKeys(str);
		Thread.sleep(500);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname='userRole']//following::span[text()='" + str + "']")).click();
		Thread.sleep(500);
		test.info("selected role is = " + str);
		System.out.println("selected role is = " + str);
		Thread.sleep(2000);
		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname='userId']")
	@CacheLookup
	public WebElement userid;

	@FindBy(xpath = "//mat-select[@formcontrolname='userId']//following::mat-option[2]")
	@CacheLookup
	public static WebElement userSelect;

	public LobbyPage selectUsername(String str) throws InterruptedException {

		sel.click(userid);
		// RoleSelect.sendKeys(str);
		Thread.sleep(2000);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname='userId']//following::span[contains(text(),'" + str + "')]"))
				.click();
		test.info("selected username is = " + str);
		System.out.println("selected username is = " + str);
		Thread.sleep(1000);
		return this;
	}

	public void selectplayer(String player) throws InterruptedException, IOException {
		GuestPlayers gp = new GuestPlayers(driver);
		driver.findElement(By.xpath("//button//span[text()='Select Player']")).click();
		Thread.sleep(3000);
		gp.Search_Items(player);
		Thread.sleep(1500);
		// driver.findElement(By.xpath("(//mat-checkbox[contains(@class,'pristine')])[1]")).click()
		// //uncomment id needed
		Thread.sleep(1000);
//		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click(); 
		ClickToSave();
	}

	public LobbyPage selectpos(String str) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='posId']")).click();
		// RoleSelect.sendKeys(str);
		Thread.sleep(1000);
		ldriver.findElement(
				By.xpath("//mat-select[@formcontrolname='posId']//following::span[contains(text(),'" + str + "')]"))
				.click();
		Thread.sleep(1000);
		test.info("SElected POS is = " + str);
		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//mat-select[@formcontrolname='couponActivation']")
	@CacheLookup
	public WebElement coupontype;

	public LobbyPage selectCouponType(String str) throws InterruptedException {
		sel.click(coupontype);
		// RoleSelect.sendKeys(str);
		Thread.sleep(1000);
		ldriver.findElement(By.xpath(
				"//mat-select[@formcontrolname='couponActivation']//following::span[contains(text(),'" + str + "')]"))
				.click();
		Thread.sleep(1000);
		return this;
	}

	// release 1.1.1
	@FindBy(xpath = "//button[contains(text(),'Lobby Jackpot')]")
	@CacheLookup
	WebElement ClickOnJackpotHeader;

	public LobbyPage ClickOnJackpot() throws InterruptedException {
		sel.click(ClickOnJackpotHeader);
		test.info("Clicked on Lobby Jackpot'");
		Thread.sleep(2000);
		return this;
	}

	public By createNew = By.xpath("//button[@title='Create New']");

	public boolean verifyCreateNew() throws InterruptedException {
		return ldriver.findElements(createNew).size() > 0;
	}

	@FindBy(xpath = "//input[@value='GAME_TOKEN']")
	@CacheLookup
	public static WebElement GAME_TOKEN_Radio;

	@FindBy(xpath = "//input[@value='SWEEP_TOKEN']")
	@CacheLookup
	public static WebElement SWEEP_TOKEN_Radio;

	public LobbyPage selectGTST(String str) throws InterruptedException {
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + str + "')]")).click();
		Thread.sleep(500);
		Thread.sleep(1000);
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='jackpotInitialValue']")
	@CacheLookup
	WebElement jackpotInitialValue;

	public LobbyPage Jackpot_InitialValue(String val) {
		jackpotInitialValue.clear();
		jackpotInitialValue.sendKeys(val);
		test.info("Jackpot  InitialValue= <b>" + val + "</b>");
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname='rewardPercentage']")
	@CacheLookup
	WebElement jackpotrewardPercentage;

	public LobbyPage Jackpot_rewardPercentage(String pr) {
		jackpotrewardPercentage.clear();
		jackpotrewardPercentage.sendKeys(pr);
		test.info("Jackpot reward percentage = <b>" + pr + "</b>");
		return this;
	}

	@FindBy(xpath = "//h3[text()='Package Purchase History']//preceding::a[@title='Back'][1]")
	@CacheLookup
	public WebElement BackBtn;

	public LobbyPage ClickOnBack(String modules) {
		ldriver.findElement(By.xpath("//h3[text()='" + modules + "']//preceding::a[@title='Back'][1]")).click();
		// sel.click(BackBtn);
		return this;
	}

	public LobbyPage VerifyDelete(String name) throws InterruptedException {
		if (VerifyYesDeleteIt() == true) {
			Assert.assertTrue(true);
			Thread.sleep(1000);
			ClickYesDeleteIt();
			test.pass(" " + name + " - delete successfully", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able to delete " + name + " ", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage VerifyDeleteMessage(String name) throws InterruptedException {
		if (cc.verifyValidation_Format_UserDelete() == true) {
			Assert.assertTrue(true);
			test.pass(" " + name + " - delete message return", extentScreenshot());
		} else {
			test.fail("Something Wrong ! not able show " + name + " delete message ", extentScreenshot());
			Assert.assertTrue(false);
		}
		return this;
	}

	public void verifyDataOnSearch(String Lobbycode) throws IOException, InterruptedException {
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//tbody//tr//td//div[contains(text(),'" + Lobbycode + "')]")) != null) {

			test.pass("Successfuly found Store in a List. with Store CODE  -> " + Lobbycode, extentScreenshot());
		} else {
			test.fail("Something Wrong!To View Addded store in a List.", extentScreenshot());
		}
		Thread.sleep(1000);

	}

	///////////// krishna///////////
	public void explicitWait(WebDriver ldriver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public LobbyPage CreateBonusLevel(String bonusName, String numRefferal, String rechargeAmount, String st, String gt)
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

	public LobbyPage GoToStoreView(String storeName) throws InterruptedException {
		PlayerProfile pp = new PlayerProfile(ldriver);

		StoreManagement.click();
		explicitWait(ldriver, StoreAccounts, 3000);
		StoreAccounts.click();
		explicitWait(ldriver, pp.Searchbox, 3000);
		SearchItems(storeName);
		Thread.sleep(5000);
		ldriver.findElement(By.xpath("(//*[contains(text(),'" + storeName + "')]//following::a[@title='View'])[1]"))
				.click();
		// EyeIcon.click();
		Thread.sleep(3000);
		return this;

	}

	public void clickToViewData() throws InterruptedException {

		boolean isDisplayed = verifyViewName();
		String message = isDisplayed ? "<b><i>successfully found data</b></i>" : "<b><i>not found data</b></i>";
		test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
		Thread.sleep(1500);
	}

	public void verifyRecordInAppMarketing(String str) {
		if (driver.findElement(By.xpath("//tbody//tr[1]//td[contains(text(),'" + str + "')]")) != null) {
			test.pass("successfuly found record  -> " + str, extentScreenshot());
		} else {
			test.fail("not found record in app marketing", extentScreenshot());
		}
	}

	public void verifyRecordOnListing(String str) {
		if (driver.findElements(By.xpath("//th[text()=\"Name\"]/following::tr//td[contains(@class,'" + str + "')]"))
				.size() > 0) {
			test.pass("Successfully Viewed record on page", extentScreenshot());
		} else {
			test.fail("Something wrong !! not found record on page", extentScreenshot());
		}
	}

	public void verifyRecordOnView(String str) {
		if (driver.findElements(By.xpath("(//td[text()='Name']//following::td[contains(text(),'" + str + "')])[1]"))
				.size() > 0) {
			test.pass(" view details found with ->" + LobbyEnum.nameBonusLevel.getValue(), extentScreenshot());
		} else {
			test.fail(" view details not found with ->" + LobbyEnum.nameBonusLevel.getValue(), extentScreenshot());
		}
	}

	// MDB

	@FindBy(xpath = "//span[text()='Multiple Deposit Bonus']") // input[@value='MULTIPLE_DEPOSIT_BONUS']
	private WebElement RadioBtn_MULTIPLE_DEPOSIT_BONUS;

	public LobbyPage SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS() throws InterruptedException {
		RadioBtn_MULTIPLE_DEPOSIT_BONUS.click();
		Thread.sleep(2000);
		return this;

	}

	@FindBy(xpath = "//span[text()='Multiple']")
	private WebElement RadioBtn_MULTIPLE_BONUS;

	public LobbyPage SelectRadioBtn_MULTIPLE_BONUS() throws InterruptedException {
		RadioBtn_MULTIPLE_BONUS.click();
		Thread.sleep(2000);
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

	public LobbyPage ClickonStartDateCalendar() {
		startDateCalendar.click();
		return this;
	}

	public LobbyPage ClickonExpiryDateCalendar() {
		expiryDateCalendar.click();
		return this;
	}

	public LobbyPage ClickonCustomStartDateCalendar() {
		customStartDateCalendar.click();
		return this;
	}

	public LobbyPage ClickonCustomExpiryDateCalendar() {
		customEexpiryDateCalendar.click();
		return this;
	}

	@FindBy(xpath = "//mat-select[@formcontrolname='event']")
	@CacheLookup
	private WebElement event;

	public LobbyPage selectEventType(String eventType) throws InterruptedException {
		event.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath(
				"//mat-select[@formcontrolname='event']//following::mat-option[contains(.,'" + eventType + "')]"))
				.click();

		return this;

	}

	@FindBy(xpath = "//mat-select[@formcontrolname='traceType']")
	@CacheLookup
	private WebElement traceType;

	public LobbyPage selectTraceType(String trace_Type) throws InterruptedException {
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

	public LobbyPage set_SpinEventConfiguration(String GT_SpinsValue, String ST_SpinsValue)
			throws InterruptedException {

		games.click();
		Thread.sleep(200);
		SetGames.click();
		Thread.sleep(200);
		List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
		if (!boxes.isEmpty()) {
			for (WebElement inputElement : boxes) {
				inputElement.click();
			}
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

	public LobbyPage set_LoginEventConfigration(String numofLogin) {
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

	public LobbyPage set_LossMakingEventConfiguration(String GT, String ST) {
		LossMaking_GameToken.clear();
		LossMaking_GameToken.sendKeys(GT);
		LossMaking_SweepToken.clear();
		LossMaking_SweepToken.sendKeys(ST);
		return this;

	}

	public LobbyPage set_LossMaking_ActionSection() throws InterruptedException {
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

	public LobbyPage set_Login_ReminderSection() throws InterruptedException {
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

	public LobbyPage set_Login_CustomDateReminderSection() throws InterruptedException {
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

	public LobbyPage set_GamePlay_ActionSection() throws InterruptedException {
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

	public LobbyPage set_GamePlay_ReminderSection() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		Actions act = new Actions(ldriver);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ReminderSection_header);
		// js.executeScript("arguments[0].click()", ReminderSection_header);
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

	public LobbyPage set_GamePlay_ReminderSectionWithCustomDate() throws InterruptedException {
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

	public LobbyPage set_PurchaseEventConfiguration(String depositType, String nthDeposit, String depositAmount)
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
		} else if (PURCHASE_PACKAGE_Toggle.getAttribute("tabindex").equalsIgnoreCase("0")) {
			if (depositType == "On Purchase Package") {
				triggerType.click();
				Thread.sleep(100);
				ldriver.findElement(By.xpath("//span[text()='On Purchase Package']")).click();
				bonusActivationOn.clear();
				bonusActivationOn.sendKeys(nthDeposit);
				selectPackages_MDB.click();
				Thread.sleep(1000);
				List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
				if (!boxes.isEmpty()) {
					for (WebElement inputElement : boxes) {
						inputElement.click();
						Thread.sleep(100);
					}
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
						inputElement.click();
						Thread.sleep(100);
					}
				}
				Thread.sleep(2000);
				selectPackages_MDB.sendKeys(Keys.TAB);
			}
		} else {
			System.out.println("The element is not Selected");
		}
		return this;
	}

	public LobbyPage set_Purchase_DepositAmount_ActionSection() throws InterruptedException {
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
		Thread.sleep(2000);
		upload_ActionImg2.sendKeys(PlayerEnum.Upload_Icon.getValue());
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage set_Purchase_DepositAmount_ReminderSection(String remDepositAmount, String remindertitle,
			String reminderdesc) throws InterruptedException {
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
//		reminder_Title.sendKeys("After Lobby Load On Deposit reminder");
//		reminder_Description.sendKeys("After Lobby Load On Deposit reminder");
		reminder_Title.sendKeys(remindertitle);
		reminder_Description.sendKeys(reminderdesc);
		reminderDepositAmount.sendKeys(remDepositAmount);
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());

		return this;
	}

	public LobbyPage set_Purchase_PackagePurchase_ReminderSection(String numPkgPurchase, String remindertitle,
			String reminderdesc) throws InterruptedException {
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
//		reminder_Title.sendKeys("After Lobby Load On Purchase pkg reminder");
//		reminder_Description.sendKeys("After Lobby Load On purchase pkg reminder");
		reminder_Title.sendKeys(remindertitle);
		reminder_Description.sendKeys(reminderdesc);
		remindernumberOfPackagePurchase.sendKeys(numPkgPurchase);
		Thread.sleep(500);
		upload_ActionImg3.sendKeys(PlayerEnum.Upload_Icon.getValue());
		Thread.sleep(2000);
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		Thread.sleep(2000);
		return this;
	}

	public LobbyPage set_Purchase_PackagePurchase_ReminderSectionWithCustomDate() throws InterruptedException {
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
		Thread.sleep(2000);
		upload_ActionImg4.sendKeys(PlayerEnum.Upload_Icon.getValue());
		Thread.sleep(2000);
		return this;
	}

	@FindBy(xpath = "//span[text()='Deposit Amount']")
	@CacheLookup
	private WebElement DepositAmount_Toggle;

	public LobbyPage selectDepositAmountToggle() {
		DepositAmount_Toggle.click();
		return this;

	}

	@FindBy(xpath = "//span[text()='Purchase Package']")
	@CacheLookup
	private WebElement PurchasePackage_Toggle;

	public LobbyPage selectPurchasePackageToggle() {
		PurchasePackage_Toggle.click();
		return this;

	}

	@FindBy(xpath = "//span[text()='Custom Date']")
	@CacheLookup
	private WebElement CustomDate_Toggle;

	public LobbyPage selectCustomDateToggle() {
		CustomDate_Toggle.click();
		return this;

	}

	public LobbyPage selectCustomStartDate() throws InterruptedException {
		LocalDate todayDate = LocalDate.now();
		LocalDate CustomDate = todayDate.plusDays(5);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = CustomDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[contains(text(),'" + currentDateString + "')]")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='startsAtTime'])[2]")).sendKeys("0000");
		return this;

	}

	public LobbyPage selectCustomExpiryDate() throws InterruptedException {
		LocalDate todayDate = LocalDate.now();
		LocalDate targetDate = todayDate.plusMonths(2);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = todayDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		// System.out.println(currentDateString);
		String targetDateString = targetDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		// System.out.println(targetDateString);
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[contains(text(),'" + currentDateString + "')]")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='expiresAtTime'])[2]")).sendKeys("1900");

		return this;

	}

	public LobbyPage MDBgameToken(String token) {
		ldriver.findElement(By.xpath("//input[@formcontrolname='gameTokens']")).sendKeys(token);
		return this;
	}

	public LobbyPage MDBsweepToken(String st) {
		ldriver.findElement(By.xpath("//input[@formcontrolname='sweepTokens']")).sendKeys(st);
		return this;
	}
}
