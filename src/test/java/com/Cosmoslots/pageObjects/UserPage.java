package com.Cosmoslots.pageObjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

import com.Cosmoslots.utilities.BaseClass;

import implementation.Seleniumimpl;

/**
 * @author shrikrushna.sonkar
 *
 */
public class UserPage {
	
	Seleniumimpl sel;

	BaseClass bc = new BaseClass();
	public WebDriver ldriver;
	public WebDriverWait wait;
	public List<String> ls = new ArrayList<String>();


	// Actions Act = new Actions(ldriver);

	public UserPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		sel = new Seleniumimpl();
	}

	@FindBy(xpath = "//span[contains(text(),'User Management')]")
	@CacheLookup
	private WebElement UserManagement_Button;
		
	@FindBy(xpath = "//h3[text()='User Profile']")
	@CacheLookup
	public WebElement UserProfile_Header;

	@FindBy(xpath = "//button[contains(text(),\"Dashboard\")]")
	@CacheLookup
	private WebElement Dashboard;

	@FindBy(xpath = "//button[contains(text(),\"Access Control\")]")
	@CacheLookup
	private WebElement AccessControl;

	@FindBy(xpath = "//button[contains(text(),\"Role\")]")
	@CacheLookup
	private WebElement UserRole;

	@FindBy(xpath = "//button[contains(text(),'User Profile')]")
	@CacheLookup
	private WebElement UserProfileBtn;

	@FindBy(xpath = "//button[@title=\"Create New\"]") // i[@class='ri-add-line me-1']
	@CacheLookup
	private WebElement CreateNew;

	@FindBy(xpath = "//a[@title=\"Edit\"]") // ->(//a[@title=\"Edit\"])[1]
	@CacheLookup
	private WebElement Edit_AC;

	@FindBy(xpath = "//a[@title=\"View\"]") // i[@class='ri-eye-line']
	@CacheLookup
	private WebElement View_AC;

	// close view popup
	@FindBy(xpath = "//a[@class=\"dialog-close\"]")
	@CacheLookup
	private WebElement CloseView_AC;

	@FindBy(xpath = "//span[text()=\"App Based \"]/preceding::span[contains(@class,\"radio-inner\")]")
	@CacheLookup
	private WebElement AppBasedradio;

	@FindBy(xpath = "//input[@value=\"OWNER_BASED\"]")
	@CacheLookup
	public static WebElement OwenerBasedradio;

	@FindBy(xpath = "//input[@formcontrolname=\"code\"]")
	@CacheLookup
	private WebElement ACcode;

	@FindBy(xpath = "//input[@formcontrolname=\"name\"]")
	@CacheLookup
	private WebElement ACname;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"accessProfileCode\"]")
	@CacheLookup
	public WebElement var_Action;

	@FindBy(xpath = "//mat-option//span[text()=\"ABCDEF\"]") // ->(//mat-option[@role="option"])[2]
	@CacheLookup
	public WebElement select_Action;

	@FindBy(xpath = "//textarea[@formcontrolname=\"description\"]")
	@CacheLookup
	private WebElement Ldescription;

	@FindBy(xpath = "//span[.='Save']") // div//button//span[contains(text(),'Save')]
	@CacheLookup
	private WebElement AC_save;

	@FindBy(xpath = "(//h3[text()=\"Access Control\"])[2]") // div//button//span[contains(text(),'Save')]
	@CacheLookup
	public static WebElement AC_TitleView;

	@FindBy(xpath = "//h3[text()=\"View Role Details\"]") // div//button//span[contains(text(),'Save')]
	@CacheLookup
	public static WebElement UserRole_TitleView;

	@FindBy(xpath = "//a[@title=\"Delete\"]")
	@CacheLookup
	public WebElement DeleteButton;

	@FindBy(xpath = "//button[contains (text(),'Footprints')]")
	@CacheLookup
	private WebElement LoginFootprints;

	@FindBy(xpath = "//i[@class='ri-more-fill']")
	@CacheLookup
	private WebElement AlertsDotButton;

	@FindBy(xpath = "//button[contains(text(),'Alerts')]")
	@CacheLookup
	private WebElement AlertsTabButton;

	@FindBy(xpath = "//button[contains(text(),'Reports')]")
	@CacheLookup
	private WebElement ReportsTabButton;

	@FindBy(xpath = "//div[contains(text(),'Net Income')]")
	@CacheLookup
	private WebElement NetIncomeTabButton;

	@FindBy(xpath = "//div[contains(text(),'Tips Report')]")
	@CacheLookup
	private WebElement TipsReportTabButton;

	@FindBy(xpath = "//button[contains(text(),'Notifications')]")
	@CacheLookup
	private WebElement NotificationsTabButton;

	@FindBy(xpath = "//button[contains(text(),'Announcements')]")
	@CacheLookup
	private WebElement AnnouncementsTabButton;

	@FindBy(xpath = "//button[contains(text(),'Jackpot Wins')]")
	@CacheLookup
	private WebElement JackpotWinsTabButton;

	@FindBy(xpath = "//button[contains(text(),'Blocked List')]")
	@CacheLookup
	private WebElement BlockedListTabButton;

	@FindBy(xpath = "//button[contains(text(),'By User Data')]")
	@CacheLookup
	private WebElement BlockedListByUserTabButton;

	@FindBy(xpath = "//button[contains(text(),'By IP')]")
	@CacheLookup
	private WebElement BlockedListByIPTabButton;

	@FindBy(xpath = "(//a[contains(text(),'Settings')])[2]") // a[@class='alink //
																// navlinkIcon']//i[@class='ri-settings-2-line']
																// //i[@class='ri-settings-2-line']
	@CacheLookup
	private WebElement Settings;

	@FindBy(xpath = "//button[text()=\" System Analytics \"]")
	@CacheLookup
	private WebElement SystemAnalytics;

	@FindBy(xpath = "//div[text()=\"App Analytics\"]") // button[text()=\" App Analytics \"]
	@CacheLookup
	private WebElement AppAnalytics;

	@FindBy(xpath = "//div[contains(text(),'Game RTP')]")
	@CacheLookup
	private WebElement GameRTP;

	@FindBy(xpath = "//button[text()=\"Manage Store\"]")
	@CacheLookup
	private WebElement ManageStore;

	// _________Manage Tokens___________________________________________
	@FindBy(xpath = "//i[@class='ri-coins-line']")
	@CacheLookup
	private WebElement ManageTokensSymbol;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"lobbyPackage\"]")
	@CacheLookup
	private WebElement SelectPackageDd;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"paymentMethod\"]")
	@CacheLookup
	private WebElement SelectPaymentMethodDd;

	@FindBy(xpath = "//input[@formcontrolname=\"amount\"]")
	@CacheLookup
	private WebElement Amount;

	@FindBy(xpath = "//input[@formcontrolname=\"couponCode\"]")
	@CacheLookup
	private WebElement ApplyCouponCode;

	@FindBy(xpath = "//input[@formcontrolname=\"gameTokens\"]")
	@CacheLookup
	private WebElement GameTokens;

	@FindBy(xpath = "//input[@formcontrolname=\"sweepTokens\"]")
	@CacheLookup
	private WebElement SweepTokens;

	@FindBy(xpath = "//input[@formcontrolname=\"extraSweepToken\"]")
	@CacheLookup
	private WebElement ExtraSweepToken;

	@FindBy(xpath = "//textarea[@formcontrolname=\"notes\"]")
	@CacheLookup
	private WebElement Notes;

	@FindBy(xpath = "//span[text()='Add Token']/preceding::span[contains(@class,\"radio-inner\")][1]")
	@CacheLookup
	private WebElement AddTokenRadioBtn;

	@FindBy(xpath = "//span[text()=\"Withdraw Tokens\"]/preceding::span[contains(@class,\"radio-inner\")][1]")
	@CacheLookup
	private WebElement WithdrawTokensRadioBtn;

	@FindBy(xpath = "//th[text()='Status']//following::mat-slide-toggle")
	@CacheLookup
	private WebElement StatusToggleBtn;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	@CacheLookup
	private WebElement CalendarBtn;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	@CacheLookup
	private WebElement Choosemonthandyear;

	@FindBy(xpath = "//button[@aria-label='Previous month']")
	@CacheLookup
	private WebElement PreviousmonthBtn;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	@CacheLookup
	private WebElement NextmonthBtn;

	@FindBy(xpath = "//span[text()='Generate Net Income']") // button[@title='Generate Net Income']
	@CacheLookup
	private WebElement GenerateNetIncomeBtn;

	@FindBy(xpath = "//span[text()='Generate Tip Report']")
	@CacheLookup
	private WebElement GenerateTipReportBtn;

	@FindBy(xpath = "//a[@title='Back']")
	@CacheLookup
	private WebElement BackBtn;

	@FindBy(xpath = "//button[contains(text(),'Support Management')]")
	@CacheLookup
	private WebElement SupportManagement;

	@FindBy(xpath = "//button[text()='Support Request']")
	@CacheLookup
	private WebElement SupportRequest;

	@FindBy(xpath = "//button[text()='Contact Details']")
	@CacheLookup
	private WebElement ContactDetails;

	@FindBy(xpath = "//input[@value='CONTACT']")
	@CacheLookup
	private WebElement ContactUsRadioBtn;

	@FindBy(xpath = "//input[@value='FREE_SPIN_REQUEST']")
	@CacheLookup
	private WebElement EarnFreeSpinsRadioBtn;

	@FindBy(xpath = "//input[@value='INVITE_CODE']")
	@CacheLookup
	private WebElement InviteCodeRadioBtn;

	@FindBy(xpath = "//input[@value='FORGOT_PASSWORD']")
	@CacheLookup
	private WebElement FORGOT_PASSWORDRadioBtn;

	@FindBy(xpath = "//span[text()='Chat']")
	@CacheLookup
	private WebElement ChatBtn;

	@FindBy(xpath = "//span[text()='Help Player']")
	@CacheLookup
	private WebElement HelpPlayer;

	@FindBy(xpath = "//input[@formcontrolname='cashAppId']")
	@CacheLookup
	private WebElement cashAppId;

	@FindBy(xpath = "//input[@formcontrolname='qrCodeImageId']")
	@CacheLookup
	private WebElement qrCodeImageId;

	@FindBy(xpath = "//button/span[text()='Game Configurator']")
	@CacheLookup
	private WebElement GameConfigurator;

	@FindBy(xpath = "//button[text()='Game Tools']")
	@CacheLookup
	private WebElement GameTools;

	@FindBy(xpath = "//button[text()='Slot Game Tools']")
	@CacheLookup
	private WebElement SlotGameTools;

	@FindBy(xpath = "//button[text()='Symbol Type']")
	@CacheLookup
	private WebElement SlotGameTools_SymbolType;

	@FindBy(xpath = "//button[text()='Pay Lines']")
	@CacheLookup
	private WebElement SlotGameTools_PayLines;

	@FindBy(xpath = "//button[text()='Keno Game Tools']")
	@CacheLookup
	private WebElement KenoGameTools;

	@FindBy(xpath = "//button[text()='Colours']")
	@CacheLookup
	private WebElement KenoGameTools_Colours;

	@FindBy(xpath = "//button[text()='Game Settings']")
	@CacheLookup
	private WebElement GameSettings;

	@FindBy(xpath = "//button[text()='Slot Game Settings']")
	@CacheLookup
	private WebElement SlotGameSettings;

	@FindBy(xpath = "//button[text()='Keno Game Settings']")
	@CacheLookup
	private WebElement KenoGameSettings;

	@FindBy(xpath = "//span[contains(text(),'Search')]") // span[text()=' Search ']
	@CacheLookup
	private WebElement Search;

	@FindBy(xpath = "//button[contains(text(),'Token Ledger')]")
	@CacheLookup
	private WebElement TokenLedger;

	@FindBy(xpath = "//mat-select[@formcontrolname='parentRole']")
	@CacheLookup
	private WebElement ParentRole;

	@FindBy(xpath = "//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")
	@CacheLookup
	public static WebElement Searchbox;

	@FindBy(xpath = "//button[contains(text(),' Player Custom Package Purchase ')]")
	@CacheLookup
	private WebElement PlayerCustomPackagePurchase;
		

	public UserPage ClickonPlayerCustomPackagePurchase() {
		PlayerCustomPackagePurchase.click();
		return this;
	}

	public UserPage ClickonGameConfigrator() {
		GameConfigurator.click();
		return this;
	}

	public UserPage ClickonGameTools() {
		GameTools.click();
		return this;
	}

	public UserPage ClickonSlotGameTools() {
		SlotGameTools.click();
		return this;
	}

	public UserPage ClickonKenoGameTools() {
		KenoGameTools.click();
		return this;
	}

	public UserPage ClickonGameSettins() {
		GameSettings.click();
		return this;
	}

	public UserPage ClickonSlotGameSettings() {
		SlotGameSettings.click();
		return this;
	}

	public UserPage ClickonKenoGameSettings() {
		KenoGameSettings.click();
		return this;
	}

	public UserPage ClickonTokenLedger() {
		bc.explicitWait(ldriver, TokenLedger, 10);
		TokenLedger.click();
		return this;
	}

	public UserPage ClickonSymbolType() throws InterruptedException {
//		GameConfigurator.click();
//		Thread.sleep(500);
		GameTools.click();
		Thread.sleep(500);
		SlotGameTools.click();
		Thread.sleep(500);
		SlotGameTools_SymbolType.click();
		return this;
	}

	public UserPage Search_Items(String key) {
		Searchbox.clear();
		Searchbox.click();
		Searchbox.sendKeys(key);
		return this;
	}

	public UserPage ClickonPaylines() throws InterruptedException {
//		GameConfigurator.click();
//		Thread.sleep(500);
		GameTools.click();
		Thread.sleep(500);
		SlotGameTools.click();
		Thread.sleep(500);
		SlotGameTools_PayLines.click();
		return this;
	}

	public UserPage ClickonCalendarBtn() {
		bc.explicitWait(ldriver, CalendarBtn, 30);
		CalendarBtn.click();
		return this;
	}

	public UserPage Selectmonthandyear(String year, String month, String startdate, String EndDate)
			throws InterruptedException {

		Choosemonthandyear.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//div[text()=' " + year + " ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[text()=' " + month + " ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[text()=' " + startdate + " ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//div[text()=' " + EndDate + " ']")).click();
		Thread.sleep(500);
		return this;
	}

	@FindBy(xpath = "//button[@aria-label='Previous month']")
	@CacheLookup
	public static WebElement Previousmonth;
	@FindBy(xpath = "//button[@aria-label='Next month']")
	@CacheLookup
	public static WebElement Nextmonth;
	
	public UserPage SelectFromToDate() throws InterruptedException {
		LocalDate currentDate = LocalDate.now();
		// Calculate the target date (current date - 35 days)
		LocalDate targetDate = currentDate.minusDays(35);
		// Format the dates as strings
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = currentDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		String targetDateString = targetDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		// System.out.println(currentDateString);System.out.println(targetDateString);
		// CalendarBtn.click();
		Thread.sleep(1000);
		if (!Previousmonth.getAttribute("class").contains("disabled")) {
			Previousmonth.click();
			Thread.sleep(500);
			Previousmonth.click();
			Thread.sleep(500);
			ldriver.findElement(By.xpath("//div[contains(text(),'" + targetDateString + "')]")).click();
			Thread.sleep(500);
		}else {
			Previousmonth.click();
			Thread.sleep(500);
			ldriver.findElement(By.xpath("//div[contains(text(),'" + targetDateString + "')]")).click();
			Thread.sleep(500);
		}
		if (!Nextmonth.getAttribute("class").contains("disabled")) {
			Nextmonth.click();
			Thread.sleep(500);
			Nextmonth.click();
			Thread.sleep(500);
			ldriver.findElement(By.xpath("//div[contains(text(),'" + currentDateString + "')]")).click();
			Thread.sleep(500);
		}else {
			Nextmonth.click();
			Thread.sleep(500);
			ldriver.findElement(By.xpath("//div[contains(text(),'" + currentDateString + "')]")).click();
			Thread.sleep(500);
		}
		
//		ldriver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
//		Thread.sleep(500);
//		ldriver.findElement(By.xpath("//div[contains(text(),'" + currentDateString + "')]")).click();
//		Thread.sleep(500);
		return this;
	}
	
	public UserPage selectStartDate() throws InterruptedException {
		LocalDate todayDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String currentDateString = todayDate.format(formatter).substring(8, 10).replaceAll("^0", "");
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//div[text()=' " + currentDateString + " ']")).click();
		Thread.sleep(900);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='startsAtTime'])[1]")).sendKeys("1900");
		
		return this;
		
	}
	
	public UserPage selectTiming() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the desired date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        
        // Format the current date and time using the formatter
        String formattedDateTime = currentDateTime.format(formatter);
		
		return this;
	}
	
	public UserPage selectExpiryDate() throws InterruptedException {
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
		ldriver.findElement(By.xpath("//div[text()=' "+currentDateString+" ']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("(//input[@formcontrolname='expiresAtTime'])[1]")).sendKeys("1900");
		
		return this;
		
	}
	
	
	

	public UserPage SelectPreviousmonth() {
		PreviousmonthBtn.click();
		return this;
	}

	public UserPage SelectNextmonth() {
		NextmonthBtn.click();
		return this;
	}

	public UserPage ClickonGenerateNetIncomeReports() {
		GenerateNetIncomeBtn.click();
//		if (NetIncomeTabButton != null) {
//			Actions act= new Actions(ldriver);
///      	act.moveToElement(GenerateNetIncomeBtn).click().build().perform();
//			GenerateNetIncomeBtn.click();
//		} else if (TipsReportTabButton != null) {
//			GenerateTipReportBtn.click();
//		}
		return this;
	}

	public UserPage ClickonGenerateTipsReports() {
		GenerateTipReportBtn.click();
		return this;
	}

	public UserPage ClickonAddTokenRadioBtn() {
		AddTokenRadioBtn.click();
		return this;
	}

	public UserPage ClickonWithdrawTokensRadioBtn() {
		WithdrawTokensRadioBtn.click();
		return this;
	}

	public UserPage SelectAmount(String amount) {
		Amount.click();
		Amount.sendKeys(amount);
		return this;
	}

	public UserPage SelectGameTokens(String gt) {
		GameTokens.click();
		GameTokens.sendKeys(gt);
		return this;
	}

	public UserPage SelectSweepTokens(String st) {
		SweepTokens.click();
		SweepTokens.sendKeys(st);
		return this;
	}

	public UserPage ClickonNote(String note) {
		Notes.click();
		Notes.sendKeys(note);
		return this;
	}

	public UserPage ClickonStatusToggle() {
		StatusToggleBtn.click();
		return this;
	}

	// User Active-Deactive confirmation buttons

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement YesBtn;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement CancelBtn;

	public UserPage ClickonYesBtn() {
		YesBtn.click();
		return this;
	}

	public UserPage ClickonCancelBtn() {
		CancelBtn.click();
		return this;
	}

	// ^ _________Manage Tokens___________________________________________

	public UserPage ClickOnGuestPlayerLoginFootprints() {
		bc.explicitWait(ldriver, LoginFootprints, 10);
		LoginFootprints.click();
		return this;
	}

	public UserPage ClickonSettings() {
		bc.explicitWait(ldriver, Settings, 10);
		Settings.click();
		return this;
	}

	public UserPage ClickonSystemAnalytics() {
		bc.explicitWait(ldriver, SystemAnalytics, 10);
		SystemAnalytics.click();
		return this;
	}

	public UserPage ClickonAppAnalytics() {
		bc.explicitWait(ldriver, AppAnalytics, 10);
		AppAnalytics.click();
		return this;
	}

	public UserPage ClickonGameRTP() {
		bc.explicitWait(ldriver, GameRTP, 10);
		GameRTP.click();
		return this;
	}

	public UserPage ClickOnDashboard() {
		bc.explicitWait(ldriver, Dashboard, 10);
		Dashboard.click();
		return this;
	}

	public UserPage ClickDotButton() {
		bc.explicitWait(ldriver, AlertsDotButton, 10);
		AlertsDotButton.click();
		return this;
	}

	public UserPage ClickByUserButton() {
		BlockedListByUserTabButton.click();
		return this;
	}

	public UserPage ClickByIPTabButton() {
		BlockedListByIPTabButton.click();
		return this;
	}

	public UserPage ClickonNetIncomeButton() {
		NetIncomeTabButton.click();
		return this;
	}

	public UserPage ClickonTipsReportButton() {
		TipsReportTabButton.click();

//		Actions act = new Actions(ldriver);
//		act.moveToElement(TipsReportTabButton).click().build().perform();
		return this;
	}

	public UserPage ClickonReportsButton() {
		ReportsTabButton.click();

//		Actions act = new Actions(ldriver);
//		act.moveToElement(ReportsTabButton).click().build().perform();
		return this;
	}

	public UserPage ClickonManageTokensSymbol() {
		bc.explicitWait(ldriver, ManageTokensSymbol, 10);
		ManageTokensSymbol.click();
		return this;
	}

	public UserPage ClickJackpotWinsButton() {
		JackpotWinsTabButton.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(JackpotWinsTabButton).click().build().perform();
		return this;
	}

	public UserPage ClickBlockedListButton() {
		BlockedListTabButton.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(BlockedListTabButton).click().build().perform();
		return this;
	}

	public UserPage ClickAlertsButton() {
		AlertsTabButton.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(AlertsTabButton).build().perform();
		return this;
	}

	public UserPage ClickNotificationsButton() {
		NotificationsTabButton.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(NotificationsTabButton).click().build().perform();
		return this;
	}

	public UserPage ClickAnnouncementsButton() {
		AnnouncementsTabButton.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(AnnouncementsTabButton).click().build().perform();
		return this;
	}

	public UserPage selectTabLCode() {
		ACname.sendKeys(Keys.TAB);
		return this;
	}

	public UserPage Enter_Lanme() {
		ACname.sendKeys(Keys.ENTER);
		return this;
	}

	public UserPage SelectTabLanme() {
		ACname.sendKeys(Keys.TAB);
		return this;
	}

	public UserPage ClickDesc() {
		Ldescription.click();
		return this;
	}

	public UserPage clickUsermanagementButton() {
		bc.explicitWait(ldriver, UserManagement_Button, 5);
		UserManagement_Button.click();

		return this;

	}

	public void clickUserManagement() {
		// System.out.println("user management click");
		UserManagement_Button.click();
	}

	public UserPage clickAccessControl() {
		// System.out.println("Access control click");
		AccessControl.click();
//		Actions act = new Actions(ldriver);
//		act.moveToElement(AccessControl).click().build().perform();
		return this;
	}

	public void clickUserRole() {
		// System.out.println("user Role click");
		UserRole.click();
		// act.click(ldriver, UserRole);
	}

	public void clickUserProfile() {
		// System.out.println("user profile click");
		bc.explicitWait(ldriver, UserProfileBtn, 5);
		UserProfileBtn.click();
	}

	public void clickCreate_AccessControl() {
		// System.out.println("Access control add button");
		CreateNew.click();
	}

	public void clickCreate_UserRole() {
		// System.out.println("user Role add button");
		CreateNew.click();
		// act.click(ldriver, CreateNew);

	}

	public void ClickOnUserProfile() throws InterruptedException {
		bc.explicitWait(ldriver, UserManagement_Button, 5);
		UserManagement_Button.click();
		bc.explicitWait(ldriver, UserProfileBtn, 5);
		UserProfileBtn.click();
	}

	public UserPage ClickonCreateNewBtn() {
		bc.explicitWait(ldriver, CreateNew, 10);
		bc.implicitWait(ldriver, 10);
		CreateNew.click();
		return this;
	}

	public void clickAppBased() {
		AppBasedradio.click();
	}

	public static void clickOwnerBased() {
		OwenerBasedradio.click();
	}

	public void SetAC_code(String code) {
		ACcode.clear();
		ACcode.click();
		ACcode.sendKeys(code);

	}

	public void clickToEdit() {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='Edit'])[1]")));
		Edit_AC.click();

	}
	
	public void clickOnSearchEdit(String str) {
		WebDriverWait wait = new WebDriverWait(ldriver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+str+"')]//following::a[@title='Edit'][1]")));
		Edit_AC.click();

	}

	public void clickToView() {
		View_AC.click();
	}

	public void Setlobbydesc(String desc) {
		Ldescription.clear();
		Ldescription.sendKeys(desc);
	}

	public void clickToSave() {
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", AC_save);
		
		// AC_save.click();
	}
	
	

	public void SetAC_name(String name) {
		ACname.clear();
		ACname.sendKeys(name);

	}

	public UserPage setAssignProfile(String parentRole) throws InterruptedException {
		var_Action.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//span[text()='" + parentRole + "']")).click();
		// select_Action.click();
		return this;
	}

	public void ClicktoClose() {
		CloseView_AC.click();

	}

	public void AC_Save() {
		// act.scrollByVisibilityOfElement(ldriver, AC_save);
		// WebElement ele =
		// driver.findElement(By.xpath("//div[4]/div/div/div[2]/button/span"));
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", AC_save);

	}

	public UserPage ClickonManageStore() {
		bc.explicitWait(ldriver, ManageStore, 10);
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", ManageStore);
		return this;
	}

	public UserPage SearchItems(String value) {

		try {
			// ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")).click();

			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(value);
			ldriver.findElement(By.xpath("//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]"))
					.sendKeys(Keys.ENTER);
			// System.out.println("search \"FOT\"- games");
		} catch (Exception e) {
			System.out.println("Error in search");

		}
		return this;
	}

	public UserPage clickToSearch(String key) {
		try {
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

	public UserPage ClickToDelete() {
		DeleteButton.click();
		return this;
	}

	public UserPage ClickonPlayerProfileButton(String s) {
		WebElement ele = ldriver.findElement(By.xpath("//button[contains(text(),'" + s + "')]"));
		ele.click();
//		Actions act = new Actions(ldriver);
//		act.moveToElement(ele).click().build().perform();
		return this;
	}

	public UserPage AccessControlToggle(String name, String flag) throws InterruptedException {
		WebElement ele = ldriver.findElement(
				By.xpath("(//h6[text()='" + name + "']//following::input[@aria-checked='" + flag + "'])[1]"));
		// WebElement ele
		// =ldriver.findElement(By.xpath("(//h6[text()='"+name+"']//following::mat-slide-toggle[@formcontrolname='is"+flag+"Enable'])[1]"));
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		if (flag.equals("true")) {
			// js.executeScript("arguments[0].scrollIntoView();", ele);
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
			js.executeScript("arguments[0].click()", ele);

		} else if (flag.equals("false")) {
			// js.executeScript("arguments[0].scrollIntoView();", ele);
			js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
			js.executeScript("arguments[0].click()", ele);
		}

		return this;
	}

	public UserPage AccessControlToggleViewFull(String name) throws InterruptedException {
		WebElement ele = ldriver
				.findElement(By.xpath("(//h6[text()='" + name + "']//following::input[@tabindex='0'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// js.executeScript("arguments[0].scrollIntoView();", ele);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", ele);
		Thread.sleep(500);
		return this;

	}

	public UserPage AccessControlToggleFull(String name) throws InterruptedException {
		// WebElement ele = ldriver.findElement(By.xpath("(//h6[text()='" + name +
		// "']//following::input[@tabindex='0'])[1]"));
		WebElement ele = ldriver.findElement(By.xpath(
				"(//h6[text()='" + name + "']//following::mat-slide-toggle[@formcontrolname='isFullEnable'])[1]"));

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		// js.executeScript("arguments[0].scrollIntoView();", ele);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click()", ele);
		Thread.sleep(500);
		return this;

	}

	public UserPage StoreDashboardButton(String sd) {
		WebElement ele = ldriver.findElement(By.xpath("(//button[contains(text(),'" + sd + "')])[1]"));
		ele.click();
		// Actions act = new Actions(ldriver);
		// act.moveToElement(ele).click().build().perform();
		return this;
	}

	public UserPage ClickonUserManagementview(String str) {
		WebElement ele = ldriver.findElement(By.xpath("//button[contains(text(),'" + str + "')]"));
		Actions act = new Actions(ldriver);
		act.moveToElement(ele).click().build().perform();
		return this;
	}

	public UserPage ClickonGameconfigrator(String str) {
		WebElement ele = ldriver.findElement(By.xpath("//button[(text()='" + str + "')]"));
		// ele.click();
		Actions act = new Actions(ldriver);
		act.moveToElement(ele).click().build().perform();
		return this;
	}

	public UserPage ClickOnBack() {
		bc.explicitWait(ldriver, BackBtn, 10);
		BackBtn.click();
		return this;
	}

	public UserPage EnterCashAppID(String cashappid) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", cashAppId);
		Thread.sleep(1000);
		cashAppId.clear();
		cashAppId.click();
		cashAppId.sendKeys(cashappid);
		return this;
	}

	public UserPage clickonUploadQRCode(String name) throws InterruptedException {

		// qrCodeImageId.click();
		// Thread.sleep(300);
		qrCodeImageId.sendKeys(name);
//		WebElement frame =ldriver.switchTo().activeElement();
//		 frame.sendKeys("D:\\Automation\\QR Code\\download1.png");
		return this;
	}

	public UserPage ClickOnContactDetails() {
		ContactDetails.click();
//		Actions act = new Actions(ldriver);
//		act.moveToElement(SupportManagement).click(ContactDetails).build().perform();
		return this;
	}

	public UserPage ClickOnSupportManagement() {
		bc.explicitWait(ldriver, SupportManagement, 10);
		SupportManagement.click();
		return this;
	}

	public UserPage ClickonContactUsRadioBtn() {
		ContactUsRadioBtn.click();
		return this;
	}

	public UserPage ClickonEarnFreeSpinsRadioBtn() {
		EarnFreeSpinsRadioBtn.click();
		return this;
	}

	public UserPage ClickonFORGOT_PASSWORDRadioBtn() {
		// FORGOT_PASSWORDRadioBtn.click();
		Actions act = new Actions(ldriver);
		act.moveToElement(FORGOT_PASSWORDRadioBtn).click().build().perform();
		return this;
	}

	public UserPage ClickonInviteCodeRadioBtn() {
		// InviteCodeRadioBtn.click();
		Actions act = new Actions(ldriver);
		act.moveToElement(InviteCodeRadioBtn).click().build().perform();
		return this;
	}

	public UserPage SelectStoreRoleUserforAppAnalytics(String store, String role, String user)
			throws InterruptedException {

		// ldriver.findElement(By.xpath("//mat-select[@formcontrolname='lobbyId']")).clear();
		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='lobbyId']")).click();
		Thread.sleep(500);
		// ldriver.findElement(By.xpath("//span[contains(text(),'"+method+"')]")).click();
		ldriver.findElement(By.xpath("//span[text()='" + store + "']")).click();

		// ldriver.findElement(By.xpath("//mat-select[@formcontrolname='userRole']")).clear();
		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='userRole']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='" + role + "']")).click();

//		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='userId']")).clear();
		ldriver.findElement(By.xpath("//mat-select[@formcontrolname='userId']")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[text()='" + user + "']")).click();

		return this;

	}

	public UserPage SelectParentRole(String parentrole) throws InterruptedException {
		ParentRole.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//span[text()='" + parentrole + "']")).click();
		return this;

	}

	public UserPage GoToUserProfileView(String user) throws InterruptedException {
		UserManagement_Button.click();
		explicitWait(ldriver, UserProfileBtn, 5000);
		UserProfileBtn.click();
		explicitWait(ldriver, BackBtn, 5000);
		BackBtn.click();
		explicitWait(ldriver, Searchbox, 5000);
		Search_Items(user);
		explicitWait(ldriver, View_AC, 5000);
		ldriver.findElement(By.xpath("(//*[contains(text(),'" + user + "')]//following::a[@title='View'])[1]")).click();
		return this;
	}
	
	public UserPage GoToUserProfileEdit(String user) throws InterruptedException {
		UserManagement_Button.click();
		explicitWait(ldriver, UserProfileBtn, 5000);
		UserProfileBtn.click();
		explicitWait(ldriver, BackBtn, 5000);
		BackBtn.click();
		explicitWait(ldriver, Searchbox, 5000);
		Search_Items(user);
		explicitWait(ldriver, Edit_AC, 5000);
		ldriver.findElement(By.xpath("(//*[contains(text(),'" + user + "')]//following::a[@title='Edit'])[1]")).click();
		return this;
	}

	public void explicitWait(WebDriver ldriver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public UserPage ClickonSearch() {
		Search.click();
		return this;
	}

	@FindBy(xpath = "//div[contains(text(),'My Skrill Balance')]")
	@CacheLookup
	private WebElement MySkrillBalance;

	public UserPage ClickonMySkrillBalance() {
		MySkrillBalance.click();
		return this;
	}

	@FindBy(xpath = "//div[text()='Online Player Analytics']")
	@CacheLookup
	private WebElement OnlinePlayerAnalytics;

	public UserPage ClickonOnlinePlayerAnalytics() {
		OnlinePlayerAnalytics.click();
		return this;
	}

	@FindBy(xpath = "//span[text()='Generate My Balance']")
	@CacheLookup
	private WebElement GenerateMyBalanceBtn;

	public UserPage ClickonGenerateMyBalance() {
		GenerateMyBalanceBtn.click();
		return this;
	}

	@FindBy(xpath = "//mat-select[@formcontrolname=\"userRole\"]")
	@CacheLookup
	private WebElement userRoleDropdown;

	public UserPage SelectUserRole(String userRole) throws InterruptedException {
		userRoleDropdown.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + userRole + "')]")).click();
		return this;
	}
	
	@FindBy(xpath = "//h3[normalize-space()='Create User Profile']")
	@CacheLookup
	public WebElement CreateUserProfile_header;
	
	@FindBy(xpath = "//mat-checkbox[@formcontrolname='oldView']")
	@CacheLookup
	public WebElement oldView_CheckBox;
	
	@FindBy(xpath = "//mat-select[@formcontrolname='accessControls']")
	@CacheLookup
	public WebElement oldView_AllowedPages;
	
	public UserPage selectCheckBox_OldView() throws InterruptedException {
		if(oldView_CheckBox.getAttribute("class").contains("mat-checkbox-checked")) {
			oldView_AllowedPages.click();
			Thread.sleep(200);
			List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
			if (!boxes.isEmpty()) {
				for (WebElement inputElement : boxes) {
					String s = inputElement.getText();
					System.out.println(s);
					ls.add(s);
//					inputElement.click();
				}

			}
			Thread.sleep(2000);
			oldView_AllowedPages.sendKeys(Keys.TAB);
			
		}else {
			oldView_CheckBox.click();
			Thread.sleep(200);
			oldView_AllowedPages.click();
			Thread.sleep(200);
			List<WebElement> boxes = ldriver.findElements(By.className("mat-option-text"));
			if (!boxes.isEmpty()) {
				for (WebElement inputElement : boxes) {
					String s = inputElement.getText();
					System.out.println(s);
					ls.add(s);
					inputElement.click();
				}

			}
			Thread.sleep(2000);
			oldView_AllowedPages.sendKeys(Keys.TAB);
		}
		return this;
	}
	
	private By userProfileHeader = By.xpath("//h3[text()='User Profile']");

    public boolean verifyUserProfileHeader() {
        return ldriver.findElements(userProfileHeader).size() > 0;
    }
    
    private By createUserProfileHeader = By.xpath("//h3[text()='Create User Profile']");

    public boolean verifycreateUserProfileHeader() {
        return ldriver.findElements(createUserProfileHeader).size() > 0;
    }
    @FindBy(xpath = "//input[@formcontrolname='registrationCode']")
    @CacheLookup
    public WebElement registrationCode;

    public void clickToRegistrationCode(String code) throws InterruptedException {
        // System.out.println("Access control add button");
    	
    	Seleniumimpl sel;
 //       test.info("registration code = " + code);
        Thread.sleep(1000);

    }
 

}