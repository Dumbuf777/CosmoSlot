package com.Cosmoslots.pageObjects;

import java.time.Duration;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.aventstack.extentreports.ExtentTest;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayerProfile {

	WebDriver ldriver;
	private WebDriver driver;
	private int timeout = 15;
	public static ExtentTest test;

	public PlayerProfile(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//mat-icon[text()=\"close\"]")
	@CacheLookup
	public static WebElement CloseActionView;

	@FindBy(xpath = "(//i[contains(@class,\"ri-file-pdf-line\")])[1]")
	@CacheLookup
	public static WebElement DownloadReceiptView;

	@FindBy(xpath = "//span[text()=\" Create New\"]//parent::button")
	@CacheLookup
	private WebElement createNewSupportRequest;

	@FindBy(xpath = "//mat-icon[text()=\"cloud_upload\"]")
	@CacheLookup
	public static WebElement UploadImage;

	@FindBy(xpath = "//button[text()=\"Guest Players\"]")
	@CacheLookup
	private WebElement guestPlayers;

	private final String pageLoadedText = "06/10/2022 12:09 PM";

	private final String pageUrl = "/#/signup-request/list";

	@FindBy(xpath = "//button[text()=\"Player Profile\"]")
	@CacheLookup
	private WebElement playerProfile;

	@FindBy(xpath = "//button[@title='Export XLSX']")
	@CacheLookup
	private WebElement xlsx;

	@FindBy(xpath = "//input[@formcontrolname=\"firstName\"]")
	@CacheLookup
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@formcontrolname=\"lastName\"]")
	@CacheLookup
	public static WebElement LastName;

	@FindBy(xpath = "//input[@formcontrolname=\"displayName\"]")
	@CacheLookup
	private WebElement DisplayName;

	@FindBy(xpath = "(//mat-select[@formcontrolname=\"gender\"]//child::div//following::span)[2]")
	@CacheLookup
	private WebElement gender;

	@FindBy(xpath = "//div[@id='mat-select-value-3']/span")
	@CacheLookup
	private WebElement PlayerReputation;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"playerReputations\"]")
	@CacheLookup
	private WebElement Reputation;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"lobbyCode\"]")
	@CacheLookup
	private WebElement Lobby;

	@FindBy(xpath = "//input[@type=\"file\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Create_icon;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"package\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Selectpackage;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"action\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Action;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"paymentMethod\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Selectpaymentmethod;

//    @FindBy(id = "mat-select-4")
//    @CacheLookup
//    private WebElement Lobby;

	// driver.findElement(By.id("")).click();
	// driver.findElement(By.xpath("//mat-option[@id='mat-option-35']/span")).click();

	@FindBy(xpath = "//mat-option//span[text()=\"Male\"]")
	@CacheLookup
	private WebElement SelectMale;

	@FindBy(xpath = "//mat-option//span[text()=\"Cosmoslots \"]")
	@CacheLookup
	private WebElement SelectCosmoslotslobby;

	@FindBy(xpath = "//mat-option//span[text()=\"Female\"]")
	@CacheLookup
	private WebElement SelectFemale;

	@FindBy(xpath = "//mat-option//span[text()=\"Low\"]")
	@CacheLookup
	private WebElement SelectLow;

	@FindBy(xpath = "//mat-option//span[text()=\"High\"]")
	@CacheLookup
	private WebElement SelectHigh;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"playerReputations\"]")
	@CacheLookup
	private WebElement playerReputations;

	@FindBy(xpath = "//input[@formcontrolname=\"email\"]")
	@CacheLookup
	private WebElement Email;

	@FindBy(xpath = "//input[@formcontrolname=\"phone\"]")
	@CacheLookup
	private WebElement Phone;

	@FindBy(xpath = "//span[text()=\"Search Country\"]")
	@CacheLookup
	private WebElement Country;

	@FindBy(id = "mat-select-10")
	@CacheLookup
	private WebElement State;

	@FindBy(xpath = "//input[@placeholder=\"Search Country\"]")
	@CacheLookup
	private WebElement SetCountry;

	@FindBy(xpath = "//input[@placeholder=\"Search State\"]")
	@CacheLookup
	private WebElement SetState;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"dialCode\"]")
	@CacheLookup
	private WebElement DialCode;

	@FindBy(xpath = "//input[@placeholder=\"Search DialCode\"]")
	@CacheLookup
	private WebElement DialCodeinput;

	@FindBy(xpath = "//button[normalize-space(text())=\"Token Details\"]")
	@CacheLookup
	private WebElement TokenDetails;

//____________  Manage Tokens Page ________________________________________________

	@FindBy(xpath = "//button[text()=\" Manage Tokens \"]")
	@CacheLookup
	private WebElement ManageTokens;

	@FindBy(xpath = "//button[text()=\" Purchases \"]")
	@CacheLookup
	private WebElement Purchases;

	@FindBy(xpath = "//button[text()=\"Purchase History\"]")
	@CacheLookup
	private WebElement PurchaseHistoryTab;

	@FindBy(xpath = "//button[normalize-space(text())=\"Withdraw Request\"]")
	@CacheLookup
	private WebElement WithdrawRequestTab;

	@FindBy(xpath = "//button[normalize-space(text())=\"Transaction History\"]")
	@CacheLookup
	private WebElement TransactionHistoryTab;

	@FindBy(xpath = "//button[normalize-space(text())=\"Player Ledger\"]")
	@CacheLookup
	private WebElement PlayerLedgerTab;

	@FindBy(xpath = "//button[normalize-space(text())=\"Support Request\"]")
	@CacheLookup
	private WebElement SupportRequestTab;

	@FindBy(xpath = "//button[contains(.,'Applied Coupons')]")
	@CacheLookup
	private WebElement AppliedCoupons;

	@FindBy(xpath = "//button[normalize-space(text())=\"Game Transactions\"]")
	@CacheLookup
	private WebElement GameTransactions;

	@FindBy(xpath = "//input[@formcontrolname=\"city\"]")
	@CacheLookup
	private WebElement City;

	@FindBy(xpath = "//input[@formcontrolname=\"zipCode\"]")
	@CacheLookup
	private WebElement ZipCode;

	@FindBy(xpath = "//span[text()=\"Save\"]")
	@CacheLookup
	private WebElement save;

	@FindBy(xpath = "(//th[text()=\"Action\"]/following::tr//td//a[@title=\"Edit\"])[1]")
	@CacheLookup
	private WebElement PlayerEdit;

	@FindBy(xpath = "//mat-select[@formcontrolname='lobbyPackage']")
	@CacheLookup
	private WebElement SelectPackage1;

//Search players - Filter

	@FindBy(xpath = "//button[@id=\"openSearch\"]")
	@CacheLookup
	private WebElement Filter;

	@FindBy(xpath = "//button/span[text()=\"Search\"]")
	@CacheLookup
	private WebElement Search;

	@FindBy(xpath = "//input[@formcontrolname=\"playerId\"]")
	@CacheLookup
	private WebElement Playerid;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"lobby\"]")
	@CacheLookup
	private WebElement Searchlobby;

	@FindBy(xpath = "//span[text()=\"TestLobby \"]")
	@CacheLookup
	private WebElement testlobby;

	@FindBy(xpath = "//span[text()=\"'user.search-state' | translate\"]")
	@CacheLookup
	private WebElement Selectsearchstate;

	@FindBy(xpath = "//div[@class=\"mat-form-field-infix ng-tns-c57-71\"]")
	@CacheLookup
	private WebElement CreatedAtFrom;

	@FindBy(xpath = "//input[@formcontrolname=\"createdAtTo\"]")
	@CacheLookup
	private WebElement CreatedAtTo;

	@FindBy(xpath = "//button[@aria-label=\"Next month\"]")
	@CacheLookup
	private WebElement NextMonth;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"sortBy\"]")
	@CacheLookup
	private WebElement Sortby;

	@FindBy(xpath = "//span//span[text()=\"Created At\"]")
	@CacheLookup
	private WebElement SortByCreatedAt;

	@FindBy(xpath = "//span[text()=\" PlayerId\"]")
	@CacheLookup
	private WebElement SortByPlayerId;

	@FindBy(xpath = "//span[text()=\" Email\"]")
	@CacheLookup
	private WebElement SortByEmail;

	@FindBy(xpath = "//span[text()=\" Last Name\"]")
	@CacheLookup
	private WebElement SortByLastName;

	@FindBy(xpath = "//span[text()=\" First Name\"]")
	@CacheLookup
	private WebElement SortByFirstName;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"sortByDirection\"]")
	@CacheLookup
	private WebElement sortByDirection;

	@FindBy(xpath = "//span//span[text()=\"Descending\"]")
	@CacheLookup
	private WebElement Descending;

	@FindBy(xpath = "//span[text()=\"Ascending\"]")
	@CacheLookup
	private WebElement Ascending;

	@FindBy(xpath = "//span[text()=\" Clear Filter\"]")
	@CacheLookup
	private WebElement ClearFilter;

	@FindBy(xpath = "//span[text()=\" Create New\"]")
	@CacheLookup
	WebElement CreateNewSupportticket;

	@FindBy(xpath = "//input[@formcontrolname=\"title\"]")
	@CacheLookup
	WebElement SupportRequestTitle;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"priority\"]")
	@CacheLookup
	WebElement SupportRequestPriority;

	@FindBy(xpath = "(//mat-label[text()=\"Status\"]//preceding::mat-select)[2]")
	@CacheLookup
	WebElement SupportRequestStatus;

	@FindBy(xpath = "(//mat-label[text()=\"Priority\"]//preceding::mat-select)[3]")
	@CacheLookup
	WebElement SupportRequestActionPriority;

	@FindBy(xpath = "//textarea[@formcontrolname=\"description\"]")
	@CacheLookup
	WebElement SupportRequestDescription;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"ticketType\"]")
	@CacheLookup
	WebElement SupportRequestTicketType;

	@FindBy(xpath = "//input[@placeholder=\"Search Player\"]")
	@CacheLookup
	WebElement SupportRequestSearchPlayer;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"playerId\"]")
	@CacheLookup
	WebElement SupportRequestPlayerName;

	@FindBy(xpath = "//mat-label[text()=\"Assigned To\"]//preceding::mat-select")
	@CacheLookup
	WebElement SupportRequestAssignTo;

	@FindBy(xpath = " (//td//span[contains(@class,\"viewActionIcon\")])[1]")
	@CacheLookup
	WebElement EyeIcon;

	@FindBy(xpath = "(//th[text()='Action']/following::tr//td[contains(@class,'action')]//i)[1]")
	@CacheLookup
	public static WebElement Actioneye;

	@FindBy(xpath = "(//th[text()=\"Action\"]/following::tr//td[contains(@class,\"\")]//i)[2]")
	@CacheLookup
	public static WebElement Description;

	@FindBy(xpath = "(//th[text()=\"View\"]/following::tr//td[contains(@class,\"view\")]//i)[1]")
	@CacheLookup
	public static WebElement SupportActioneye;

	@FindBy(xpath = "//mat-icon[contains(text(),'clear')]")
	@CacheLookup
	public static WebElement ClearSearch;

	@FindBy(xpath = "//mat-label[text()=\"AssignedTo\"]//preceding::mat-select")
	@CacheLookup
	public static WebElement ClickAssignedTo;

	// -----------------krishna-----------------------------------------------------------------------------------------------------------------
	@FindBy(xpath = "//span[contains(text(),'Player Management')]")
	@CacheLookup
	public static WebElement PlayerManagementDd;

	@FindBy(xpath = "//div//button[contains(text(),'Player Profile')]")
	@CacheLookup
	public static WebElement PlayerProfile;

	@FindBy(xpath = "//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")
	@CacheLookup
	public static WebElement Searchbox;

	@FindBy(xpath = "(//a[@title='View'])[1]")
	@CacheLookup
	public static WebElement PlayerProfileActionEye;

	@FindBy(xpath = "//i[@class='ri-arrow-left-circle-line']")
	@CacheLookup
	public static WebElement BackTOPlayerProfile;

	@FindBy(xpath = "//input[contains(@id,\"mat-input\")]")
	@CacheLookup
	public static WebElement Searchfield;

	@FindBy(xpath = "//button[contains(text(),'Footprints')]")
	@CacheLookup
	public static WebElement LoginFootprintsBtn_adm;

	@FindBy(xpath = "//button[contains(text(),'Exclusive Analytics')]")
	@CacheLookup
	public static WebElement ExclusiveAnalytics;

	@FindBy(xpath = "//mat-select[@formcontrolname='gameCategory']")
	@CacheLookup
	private WebElement gameCategory;

	@FindBy(xpath = "//mat-select[@formcontrolname='gameId']")
	@CacheLookup
	private WebElement gameId;

	@FindBy(id = "player-invited")
	@CacheLookup
	public static WebElement playerinvited;

	@FindBy(xpath = "//button[@aria-label='Open calendar']")
	@CacheLookup
	private WebElement Opencalendar;

	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	@CacheLookup
	private WebElement Choosemonthandyear;

	@FindBy(xpath = "(//a[@title='Downloads'])[1]")
	@CacheLookup
	private WebElement DownloadIcon;

	@FindBy(id = "nav-playerprofile-tab")
	@CacheLookup
	private WebElement playerprofile_tab;

	@FindBy(xpath = "//a[contains(text(),\"Logout\")]")
	@CacheLookup
	public static WebElement LogoutBtn_web;
//    public void clickOnPlayerManagement()
//    {
//    	PlayerManagementDd.click();
//    }

	public PlayerProfile clickOnDownloadIcon() {
		DownloadIcon.click();
		return this;
	}

	public PlayerProfile clickOnPlayerProfile() {
		explicitWait(ldriver, PlayerProfile, 10);
		PlayerProfile.click();
		// test.info("Clicked on Player Profile");
		return this;
	}

	public PlayerProfile clickOnPlayerManagement() {
		explicitWait(ldriver, PlayerManagementDd, 10);
		PlayerManagementDd.click();
		return this;
	}

	public PlayerProfile clickOnPlayerProfileActionEye() {
		explicitWait(ldriver, PlayerProfileActionEye, 10);
		PlayerProfileActionEye.click();
		return this;
	}

	public PlayerProfile clickOnBackToPlayerProfile() {
		explicitWait(ldriver, BackTOPlayerProfile, 10);
		BackTOPlayerProfile.click();
		return this;
	}

	public PlayerProfile clickOnLoginFootprints() {
		explicitWait(ldriver, LoginFootprintsBtn_adm, 10);
		LoginFootprintsBtn_adm.click();
		return this;
	}

	public PlayerProfile clickonExclusiveAnalytics() {
		explicitWait(ldriver, ExclusiveAnalytics, 10);
		ExclusiveAnalytics.click();
		return this;
	}

	public PlayerProfile clickOnplayerinvited() {
		explicitWait(ldriver, playerinvited, 10);
		playerinvited.click();
		return this;
	}

	public PlayerProfile clickOnLogoutBtn() {
		LogoutBtn_web.click();
		return this;
	}

	public PlayerProfile SelectGameCategory(String gamecategory, String gameid) throws InterruptedException {
		gameCategory.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + gamecategory + "')]")).click();
		gameId.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + gameid + "')]")).click();
		return this;

	}

	public PlayerProfile Selectmonthandyear(String year, String month, String startdate, String EndDate)
			throws InterruptedException {
		Opencalendar.click();
		Thread.sleep(500);
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

	public PlayerProfile Search_Items(String key) {
		try {
			Searchbox.clear();
			Searchbox.click();
			Searchbox.sendKeys(key);
		} catch (Exception e) {
			System.out.println("error in search");
		}
		return this;
	}

	public PlayerProfile GoToPlayerProfileView(String playerID) throws InterruptedException {

		PlayerManagementDd.click();
		explicitWait(ldriver, PlayerProfile, 3000);
		PlayerProfile.click();
		explicitWait(ldriver, Searchbox, 3000);
		Search_Items(playerID);
		Thread.sleep(5000);
		WebElement EyeIcon1 = ldriver
				.findElement(By.xpath("(//*[contains(text(),'" + playerID + "')]//following::a[@title=\"View\"])[1]"));
		explicitWait(ldriver, EyeIcon1, 5000);
		EyeIcon1.click();
		explicitWait(ldriver, playerprofile_tab, 3000);
		return this;

	}

	public PlayerProfile GoToPlayerProfileInvitedView(String playerID) throws InterruptedException {
		PlayerManagementDd.click();
		// Thread.sleep(500);
		fluentWait(ldriver, PlayerProfile, 10);
		PlayerProfile.click();
		fluentWait(ldriver, PlayerProfile, 10);
		Search_Items(playerID);
		fluentWait(ldriver, PlayerProfile, 10);
		ldriver.findElement(
				By.xpath("(//*[contains(text(),'" + playerID + "')]//following::a[@title=\"Invited Players\"])[1]"))
				.click();
		explicitWait(ldriver, ldriver.findElement(By.xpath("//div[contains(text(),'Dashboard')]")), 10);
		return this;

	}

	public PlayerProfile applyCouponCode(String couponCode) {
		ldriver.findElement(By.xpath("//input[@formcontrolname=\"couponCode\"]")).click();
		ldriver.findElement(By.xpath("//input[@formcontrolname=\"couponCode\"]")).sendKeys(couponCode);
		return this;
	}

	public void explicitWait(WebDriver ldriver, WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(ldriver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		Wait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		} catch (Exception e) {
		}
	}

	@FindBy(xpath = "//button[text()=' Wallet ']") // button[text()=' Wallet ']
	private WebElement ManageWallet;

	@FindBy(xpath = "//button[text()=' Wallet ']")
	private WebElement Wallet;

	@FindBy(xpath = "//button[text()='Withdraw Request']")
	private WebElement Wallet_WithdrawRequest;

	@FindBy(xpath = "//button[text()='Deposits']")
	private WebElement Wallet_Deposits;

	public PlayerProfile clickonWallet() {
		explicitWait(ldriver, ManageWallet, 10);
		ManageWallet.click();
		explicitWait(ldriver, ManageWallet, 10);
		return this;

	}

	public PlayerProfile clickonWallet_WithdrawRequest() {
		explicitWait(ldriver, Wallet, 10);
		Wallet.click();
		explicitWait(ldriver, Wallet_WithdrawRequest, 10);
		Wallet_WithdrawRequest.click();
		return this;

	}

	public PlayerProfile clickonWallet_Deposits() {
		explicitWait(ldriver, Wallet, 10);
		Wallet.click();
		explicitWait(ldriver, Wallet_Deposits, 10);
		Wallet_Deposits.click();
		return this;

	}

	// -----------------krishna---------------------------------------------------------------------------------------------------------------------------

//    public GuestPlayers() {
//    }
//
//    public GuestPlayers(WebDriver driver) {
//        this();
//        this.driver = driver;
//    }
//
//    public GuestPlayers(WebDriver driver, Map<String, String> data) {
//        this(driver);
//        this.data = data;
//    }
//
//    public GuestPlayers(WebDriver driver, Map<String, String> data, int timeout) {
//        this(driver, data);
//        this.timeout = timeout;
//    }

	public PlayerProfile selectTab() {
		DisplayName.sendKeys(Keys.TAB);
		return this;
	}

	public PlayerProfile selectgender() throws InterruptedException {
//    	Select gender=new Select(Gender);
//    	gender.selectByVisibleText(value);
		gender.click();
		// gender.sendKeys();
		SelectMale.click();
		// SelectMale.click();
		return this;
	}

	public PlayerProfile selectlobby() throws InterruptedException {
//    	Select gender=new Select(Gender);
//    	gender.selectByVisibleText(value);
		// Gender.click();
		Lobby.click();
		Thread.sleep(600);
		SelectCosmoslotslobby.click();
		// SelectHigh.click();
		// SelectMale.click();
		return this;
	}

	public PlayerProfile selectPlayerreputation() throws InterruptedException {
		// Select reputation=new Select(playerReputations);
		PlayerReputation.click();
		Thread.sleep(500);
		SelectHigh.click();
		// reputation.selectByVisibleText(value);
		return this;
	}

	public PlayerProfile selectreputation() throws InterruptedException {
		// Select reputation=new Select(playerReputations);
		Reputation.click();
		Thread.sleep(500);
		SelectHigh.click();
		// reputation.selectByVisibleText(value);
		return this;
	}

	public PlayerProfile clickPlayerEdit() {
		explicitWait(ldriver, PlayerEdit, 10);
		PlayerEdit.click();
		return this;
	}

	public PlayerProfile clickTokenDetailsTab() {
		TokenDetails.click();
		return this;
	}

	public PlayerProfile clickManageTokens() {
		ManageTokens.click();
		return this;
	}

//    public PlayerProfile SelectPackage(String s ) {   
//    	SelectPackage.click();
//    	SelectPackage.sendKeys(s);
//        return this;
//    }

	public PlayerProfile clickonPurchases() {
		Purchases.click();
		return this;
	}

	public PlayerProfile clickPurchaseHistoryTab() {
		explicitWait(ldriver, PurchaseHistoryTab, 10);
		PurchaseHistoryTab.click();
		return this;
	}

	public PlayerProfile clickWithdrawRequestTab() {
		WithdrawRequestTab.click();
		return this;
	}

	public PlayerProfile clickTansactionHistoryTab() {
		TransactionHistoryTab.click();
		return this;
	}

	public PlayerProfile clickPlayerLedgerTab() {
		PlayerLedgerTab.click();
		return this;
	}

	public PlayerProfile clickSupportRequestTab() {
		SupportRequestTab.click();
		return this;
	}

	public PlayerProfile clickGameTransactionsTab() {
		GameTransactions.click();
		return this;
	}

	public PlayerProfile clickAppliedCouponsTab() {
		AppliedCoupons.click();
		return this;
	}

	public PlayerProfile clickActioneyeicon() {
		Actioneye.click();
		return this;
	}

	public PlayerProfile clickDesription() {
		Description.click();
		return this;
	}

	public PlayerProfile clickSupportActioneyeicon() {
		SupportActioneye.click();
		return this;
	}

	public PlayerProfile SetNewsicon(String name) {
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

	public PlayerProfile selectPackage(String pkg) throws InterruptedException {
		Thread.sleep(1000);
		SelectPackage1.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(.,'" + pkg + "')]")).click();
		return this;
	}

	public PlayerProfile selectwithrawrequest(String pkg) throws InterruptedException {
		Action.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[text()='" + pkg + "']")).click();
		return this;
	}

	public PlayerProfile selectPaymentMethod(String method) throws InterruptedException {
		Thread.sleep(300);
		Selectpaymentmethod.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(.,'" + method + "')]")).click();
		return this;
	}

	// Paras
	@FindBy(xpath = "//mat-select[@formcontrolname=\"paymentProvider\"]") //// mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement SelectpaymentProvider;

	public PlayerProfile selectPaymentProvider(String method) throws InterruptedException {
		SelectpaymentProvider.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[contains(.,'" + method + "')]")).click();
		return this;
	}

	/**
	 * Click on Create New Button.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile clickCreateNewSupportRequest() {
		createNewSupportRequest.click();
		return this;
	}

	public PlayerProfile ClickOnCreateNew() {
		createNewSupportRequest.click();
		return this;
	}

	public PlayerProfile SetSupportRequestTitle(String title) {
		SupportRequestTitle.sendKeys(title);
		return this;
	}

	public PlayerProfile clickSupportRequestSupportType() {
		SupportRequestTicketType.click();
		return this;
	}

	public PlayerProfile SetSupportRequestSupportType(String Type) {
		ldriver.findElement(By.xpath("//span[text()='" + Type + "']")).click();
		return this;
	}

	public PlayerProfile clickSupportRequestPlayerName() {
		SupportRequestPlayerName.click();
		return this;
	}

	public PlayerProfile clickSupportRequestAssignTo() {
		SupportRequestAssignTo.click();
		return this;
	}

	public PlayerProfile setSupportRequestDescription(String description) {
		SupportRequestDescription.sendKeys(description);
		return this;
	}

	public PlayerProfile SetSupportRequestPlayerName(String player) throws InterruptedException {
		SupportRequestSearchPlayer.sendKeys(player);
		Thread.sleep(500);
		ldriver.findElement(
				By.xpath("//mat-option[contains(@class,\"option\")]//span[contains(text(),'" + player + "')]")).click();
		return this;
	}

	public PlayerProfile SetSupportRequestAssignTo(String Assigny) throws InterruptedException {
		// SupportRequestAssignTo.sendKeys(Assigny);
		// Thread.sleep(500);
		ldriver.findElement(
				By.xpath("//mat-option[contains(@class,\"option\")]//span[contains(text(),'" + Assigny + "')]"))
				.click();
		return this;
	}

	public PlayerProfile clickSupportRequestPriority() {
		SupportRequestPriority.click();
		return this;
	}

	public PlayerProfile clickSupportRequestActionPriority() {
		SupportRequestActionPriority.click();
		return this;
	}

	public PlayerProfile clickSupportRequestStatus() {
		SupportRequestStatus.click();
		return this;
	}

	public PlayerProfile SetSupportRequestStatus(String status) {
		ldriver.findElement(By.xpath("//span[contains(text(),'" + status + "')]")).click();
		return this;
	}

	public PlayerProfile SetSupportRequestPriority(String priority) {
		ldriver.findElement(By.xpath("//span[contains(text(),'" + priority + "')]")).click();
		return this;
	}

	public PlayerProfile SetSupportRequestActionPriority(String Actionpriority) {
		ldriver.findElement(By.xpath("//span[contains(text(),'" + Actionpriority + "')]")).click();
		return this;
	}

	/**
	 * Click on Guest Players Link.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile clickGuestPlayersLink() {
		guestPlayers.click();
		return this;
	}

	public PlayerProfile clickClearSearch() {
		ClearSearch.click();
		return this;
	}

	/**
	 * Click on Player Profile Link.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile clickPlayerProfileLink() {
		playerProfile.click();
		return this;
	}

	public PlayerProfile clickCloseActionView() {
		CloseActionView.click();
		return this;
	}

	/**
	 * Click on Xlsx Button.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile clickXlsxButton() {
		xlsx.click();
		return this;
	}

	public PlayerProfile setFirstName(String firstname) {
		FirstName.sendKeys(firstname);
		return this;
	}

	public PlayerProfile setLastName(String lastname) {
		LastName.sendKeys(lastname);
		return this;
	}

	public PlayerProfile setDisplayName(String displayname) {
		DisplayName.sendKeys(displayname);
		return this;
	}

	public PlayerProfile setEmail(String email) {
		Email.sendKeys(email);
		return this;
	}

	public PlayerProfile setPhone(String phone) {
		Phone.sendKeys(phone);
		return this;
	}

	public PlayerProfile setCity(String city) {
		City.sendKeys(city);
		return this;
	}

	public PlayerProfile setZipcode(String zipcode) {
		ZipCode.sendKeys(zipcode);
		return this;
	}

	public PlayerProfile Clickeyeicon() throws InterruptedException {
		EyeIcon.click();
		Thread.sleep(1000);
		// ldriver.findElement(By.xpath("(//*[contains(text(),'"+search+"')]//following::a[@title=\"View\"])[1]")).click();
		// new WebDriverWait(driver,
		// 5).until(ExpectedConditions.visibilityOf(EyeIcon)).click();
		return this;
	}

	public PlayerProfile ClickUploadImage(String path) {
		Actions actions = new Actions(driver);
		actions.moveToElement(UploadImage).perform();
		UploadImage.click();
		UploadImage.sendKeys(path);
		return this;
	}

	public PlayerProfile ClickSave() {
		save.click();
		return this;
	}

	public PlayerProfile setDialCode(String dialcode) {
		DialCode.click();
		DialCodeinput.sendKeys(dialcode);
		ldriver.findElement(By.xpath("//mat-option//span[text()=\"+91\"]")).click();
		return this;
	}

	public PlayerProfile setCountry(String country) throws InterruptedException {
		Country.click();
		SetCountry.sendKeys(country);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		return this;
	}

	public PlayerProfile setState(String state) throws InterruptedException {
		State.click();
		SetState.sendKeys(state);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		return this;
	}

	/**
	 * Search Player - Filter
	 */
	public PlayerProfile clickFilter() {
		Filter.click();
		return this;
	}

	public PlayerProfile clickSearch() {
		Search.click();
		return this;
	}

	public PlayerProfile setPlayerId(String playerid) {
		Playerid.sendKeys(playerid);
		return this;
	}

	public PlayerProfile searchLobby(String lobby) {
		Searchlobby.click();
		testlobby.click();
		return this;
	}

	public PlayerProfile searchState(String state) {
		Selectsearchstate.click();
		SetState.sendKeys(state);
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		return this;
	}

	public PlayerProfile searchCreatedFrom() throws InterruptedException {
		CreatedAtFrom.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label=\"June 30, 2022\"]")).click();
		return this;
	}

	public PlayerProfile searchCreatedTo() {
		CreatedAtTo.click();
		NextMonth.click();
		driver.findElement(By.xpath("//button[@aria-label=\"July 30, 2022\"]")).click();
		return this;
	}

	public PlayerProfile SortBy(String sort) {
		Sortby.click();
		if (sort == "CreatedAt") {
			SortByCreatedAt.click();
		}
		if (sort == "FirstName") {
			SortByFirstName.click();
		}
		if (sort == "LastName") {
			SortByLastName.click();
		}
		if (sort == "Email") {
			SortByEmail.click();
		}
		if (sort == "PlayerId") {
			SortByPlayerId.click();
		}

		return this;
	}

	public PlayerProfile Sortbydirection(String direction) {
		sortByDirection.click();
		if (direction == "Ascending") {
			Ascending.click();
		}
		if (direction == "Descending") {
			Descending.click();
		}
		return this;
	}
	
	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public PlayerProfile verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
//Pankaj	
//Advance filter
	public PlayerProfile clearfilter() {
		ClearFilter.click();
		return this;
	}

	@FindBy(xpath = "//h3[text()='Search Player']")
	@CacheLookup
	public WebElement searchPlayerLabel;

	public boolean verifysearchPlayerLabel() {

		return searchPlayerLabel.isDisplayed();
	}
	
	@FindBy(xpath = "//button//span[contains(text(),\"Advance Filter\")]")
	@CacheLookup
	private WebElement advanceFilter;
    
    public PlayerProfile clickAdvanceFilter() throws InterruptedException {

    	advanceFilter.click();
		//test.info("Clicked on Advance Filter");
		Thread.sleep(2000);
		return this;
	}
      
    public PlayerProfile searchElementClick(String val, String sign) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-label[text()='" + val + "']//preceding::mat-select[1]")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'" + sign + "')]")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public PlayerProfile pageScroll(String state) throws InterruptedException {

		if (state.equalsIgnoreCase("up")) {
			ldriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
		} else {
			ldriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
		}
		Thread.sleep(2000);

		return this;
	}

	public PlayerProfile ClickLastRule(String c) throws InterruptedException {
		ldriver.findElement(By.xpath("(//button[@type='button'][text()=' Rule '])[last()]")).click();

		ldriver.findElement(
				By.xpath("(//input[@value='" + c.toLowerCase() + "']//following::label[text()='" + c + "'])[last()]"))
				.click();
		Thread.sleep(1000);
		return this;
	}
	
	public PlayerProfile ClickFirstRuleset(String c) throws InterruptedException {
		ldriver.findElement(By.xpath("(//button[@type='button'][text()=' Ruleset '])[1]")).click();
		ldriver.findElement(
				By.xpath("(//input[@value='" + c.toLowerCase() + "']//following::label[text()='" + c + "'])[last()]"))
				.click();
		Thread.sleep(2000);
		ldriver.findElement(By.xpath(
				"(//p[contains(text(),'ruleset')]//preceding-sibling::query-builder//button[text()=' Rule '])[last()]"))
				.click();
		Thread.sleep(1000);
		return this;
	}

	public PlayerProfile searchOperationClick(String val) throws InterruptedException {

		ldriver.findElement(By.xpath("(//input[@value='" + val + "'])[last()]")).click();
		Thread.sleep(1000);
		return this;
	}
	
	public PlayerProfile searchUser(String val) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@id='Role']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'POS')]")).click();
		Thread.sleep(2000);
		ldriver.findElement(By.xpath("//mat-select[@id='User']")).click();
		Thread.sleep(1000);
		WebElement w = ldriver.findElement(By.xpath("//span[contains(text(),'" + val + "')]"));
		w.click();
		Thread.sleep(1000);
		return this;
	}

	public PlayerProfile searchStore(String str) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@id='Store']")).click();
		Thread.sleep(1000);
//		sel.click(ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'POS')]")));
//		Thread.sleep(2000);
//		sel.click(ldriver.findElement(By.xpath("//mat-select[@id='User']")));
//		Thread.sleep(1000);
//		sel.setText(ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'" + str + "')]")), str);
		ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'" + str + "')]")).click();
		return this;
	}

	public PlayerProfile searchCountry(String str) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@id='Country']")).click();
//		Thread.sleep(1000);
//		sel.click(ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'POS')]")));
//		Thread.sleep(2000);
//		sel.click(ldriver.findElement(By.xpath("//mat-select[@id='User']")));
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[text()=' " + str + " ']")).click();
		return this;
	}

	public PlayerProfile searchState(String c, String s) throws InterruptedException {
		ldriver.findElement(By.xpath("(//mat-select[@id='Country']//following::mat-select[@id='Country'])[1]")).click();
		ldriver.findElement(By.xpath("//mat-option//span[text()=' " + c + " ']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-select[@id='State']")).click();
		Thread.sleep(3000);
		ldriver.findElement(By.xpath("//span[contains(text(),'" + s + "')]")).click();
		Thread.sleep(1000);
		return this;
	}
	public PlayerProfile selectFilterDate(String date, String yr) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-label[text()='" + date + "']//preceding::mat-select[1]")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'>')]")).click();
		Thread.sleep(1000);
		ldriver.findElement(
				By.xpath("(//mat-label[text()='" + date + "']//following::button[@aria-label='Open calendar'])[1]"))
				.click();
		// driver.findElement(By.xpath("//mat-label[text()='" + date +
		// "']//preceding::input[1]")).click();

		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//button[contains(@class,\"mat-calendar-period-button\")]")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//div[text()=' " + yr + " ']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//div[text()=' JAN ']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//div[text()=' 1 ']")).click();
		Thread.sleep(1000);
		return this;
	}

	public PlayerProfile searchTags(String val) throws InterruptedException {

		ldriver.findElement(By.xpath("//mat-select[@id='Tags']")).click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[text()='" + val + "']")).click();
		return this;
	}

}