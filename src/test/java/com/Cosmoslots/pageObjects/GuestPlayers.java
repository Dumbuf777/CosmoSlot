package com.Cosmoslots.pageObjects;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import com.Cosmoslots.utilities.BaseClass;
import com.paulhammant.ngwebdriver.NgWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GuestPlayers {

	BaseClass bc = new BaseClass();

	WebDriver ldriver;
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	public GuestPlayers(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[text()=\" Create New\"]")
	@CacheLookup
	private WebElement createNew;

	@FindBy(xpath = "//input[@type=\"file\"]")
	@CacheLookup
	public static WebElement UploadImage;

	@FindBy(xpath = "//span[text()=\"Player Management \"]")
	@CacheLookup
	private WebElement playerManagement;

	@FindBy(xpath = "//button[contains(text(),\"Player Profile\")]")
	@CacheLookup
	private WebElement playerProfile;

	@FindBy(xpath = "//button[@title='Export XLSX']")
	@CacheLookup
	private WebElement xlsx;

	@FindBy(xpath = "//span//a[text()=\" Logout\"]")
	@CacheLookup
	WebElement lnkLogout;

	@FindBy(xpath = "//input[@formcontrolname=\"firstName\"]")
	@CacheLookup
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@formcontrolname=\"lastName\"]")
	@CacheLookup
	public static WebElement LastName;

	@FindBy(xpath = "//input[@formcontrolname=\"username\"]")
	@CacheLookup
	public static WebElement DisplayName;

	@FindBy(xpath = "//input[@formcontrolname='displayName']")
	@CacheLookup
	public static WebElement DisplayName1;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"gender\"]")
	@CacheLookup
	public static WebElement gender;

	@FindBy(xpath = "//div[@id=\"mat-select-value-3\"]/span")
	@CacheLookup
	public static WebElement PlayerReputation;
	// (//mat-label[contains(text(),\"State\")]//preceding::mat-select)[2]
	// (//div[contains(@class,\"trigger\")]//parent::mat-select)[2]
	// (//div[contains(@class,\"select-arrow-wrapper\")])[2]

	@FindBy(xpath = "//mat-select[@formcontrolname=\"playerReputations\"]")
	@CacheLookup
	public static WebElement Reputation;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"roleCode\"]")
	@CacheLookup
	public static WebElement Role;

	@FindBy(xpath = "//mat-select[@formcontrolname='primaryLobbyId']")
	@CacheLookup
	public static WebElement Store;

	@FindBy(xpath = "//mat-select[@formcontrolname='lobbyCode']")
	@CacheLookup
	public static WebElement selectStore;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"lobbyid\"]")
	@CacheLookup
	public static WebElement storeAc;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"parentId\"]")
	@CacheLookup
	public static WebElement ParentUser;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"userType\"]")
	@CacheLookup
	public static WebElement UserType;

	@FindBy(xpath = "//input[@formcontrolname=\"designation\"]")
	@CacheLookup
	public static WebElement Designation;

	@FindBy(xpath = "//mat-label[text()=\"Tags\"]/parent::label")
	@CacheLookup
	public static WebElement Tags;

	@FindBy(xpath = "//div[text()=\"Token Details\"]")
	@CacheLookup
	public static WebElement TokenDetails;

	@FindBy(xpath = "//span/span[normalize-space()=\"Male\"]")
	@CacheLookup
	private WebElement SelectMale;

	@FindBy(xpath = "//mat-option//span[text()=\"GjTechSol \"]")
	@CacheLookup
	private WebElement SelectStore;

	@FindBy(xpath = "//span/span[normalize-space()=\"Female\"]")
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
	public static WebElement Email;

	@FindBy(xpath = "//input[@formcontrolname=\"password\"]")
	@CacheLookup
	public static WebElement Password;

	@FindBy(xpath = "//mat-icon[text()=\"close\"]")
	@CacheLookup
	public static WebElement CloseActionView;

	@FindBy(xpath = "//input[@formcontrolname=\"phone\"]")
	@CacheLookup
	public static WebElement Phone;

	@FindBy(xpath = "//span[text()=\"Search Country\"]")
	@CacheLookup
	public static WebElement Country;

	// @FindBy(xpath =
	// "(//mat-label[contains(text(),\"State\")]//preceding::mat-select)[6]")
	@FindBy(xpath = "//span[text()='Search State']") // span[text()=\"'user.search-state' | translate\"]
	@CacheLookup
	private WebElement State;

	@FindBy(xpath = "(//mat-label[contains(text(),\"State\")]//preceding::mat-select)[5]")
	@CacheLookup
	public static WebElement UsersState;

	@FindBy(xpath = "//input[@placeholder=\"Search Country\"]")
	@CacheLookup
	private WebElement SetCountry;

	@FindBy(xpath = "//input[@placeholder=\"Search State\"]")
	@CacheLookup
	private WebElement SetState;

	@FindBy(xpath = "//input[@placeholder=\"Search TimeZone\"]")
	@CacheLookup
	private WebElement SetTimezone;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"timeZone\"]")
	@CacheLookup
	public WebElement Timezone;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"perPageRecord\"]")
	@CacheLookup
	public WebElement RPP;

	@FindBy(xpath = "//mat-select[@formcontrolname=\"dialCode\"]")
	@CacheLookup
	private WebElement DialCode;

	@FindBy(xpath = "//select[@formcontrolname='dialCode']")
	@CacheLookup
	public static WebElement DialCode_web;

	@FindBy(xpath = "//input[@placeholder=\"Search DialCode\"]")
	@CacheLookup
	private WebElement DialCodeinput;

	@FindBy(xpath = "//input[@formcontrolname=\"city\"]")
	@CacheLookup
	public static WebElement City;

	@FindBy(xpath = "//textarea[@formcontrolname=\"address\"]")
	@CacheLookup
	public static WebElement Address;

	@FindBy(xpath = "//input[@formcontrolname=\"zipCode\"]")
	@CacheLookup
	public static WebElement ZipCode;

	@FindBy(xpath = "//input[@formcontrolname=\"singleTransactionSweepTokenLimit\"]")
	@CacheLookup
	public static WebElement PTSTL;

	@FindBy(xpath = "//input[@formcontrolname=\"dailySweepTokenLimit\"]")
	@CacheLookup
	public static WebElement PDTSTL;

	@FindBy(xpath = "//mat-slide-toggle[@formcontrolname=\"isPromoted\"]")
	@CacheLookup
	public static WebElement SpecialOffer;

	@FindBy(xpath = "//span[text()=\"Save\"]")
	@CacheLookup
	private WebElement save;

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

	@FindBy(xpath = "(//td//span[contains(@class,\"viewActionIcon\")])[1]")
	@CacheLookup
	private WebElement EyeIcon;

	@FindBy(xpath = "//div[@class=\"formGroupBlock tokenDetailsCard purchasedToken\"]//span[text()=\"Total Purchased\"]")
	@CacheLookup
	public static WebElement TotalPurchased;

	@FindBy(xpath = "//span[text()=\"Current\"]")
	@CacheLookup
	public static WebElement Current;

	@FindBy(xpath = "//span[text()=\"Per Transaction Sweep Tokens Limit\"]")
	@CacheLookup
	public static WebElement PerTransaction;

	@FindBy(xpath = "//span[text()=\"Per Day Transaction Sweep Tokens Limit\"]")
	@CacheLookup
	public static WebElement PerDayTransaction;

	@FindBy(xpath = "//span[text()=\"Average Daily Purchase\"]")
	@CacheLookup
	public static WebElement AverageDailyPurchase;

	@FindBy(xpath = "//span[text()=\"Accumulated\"]")
	@CacheLookup
	public static WebElement Accumulated;

	@FindBy(xpath = "//span[text()=\"Winnings\"]")
	@CacheLookup
	public static WebElement Winnings;

	@FindBy(xpath = "//div[@class='gmuSearchBlock']//following::input[contains(@class,'ng')]")
	@CacheLookup
	public static WebElement Searchbox;

	@FindBy(xpath = "//mat-icon[contains(text(),'clear')]")
	@CacheLookup
	public static WebElement ClearSearchbox;

	@FindBy(xpath = "//span[@class=\"mat-button-wrapper\"]//span[contains(@class,\"user-name\")]//following-sibling::i")
	@CacheLookup
	WebElement UserProfile;

	@FindBy(xpath = "//button[contains (text(),'Footprints ')]")
	@CacheLookup
	WebElement LoginFootprints;

	@FindBy(xpath = "//button[contains(text(),'Guest Players')]")
	@CacheLookup
	WebElement GuestPlayers;

	// --------SS---------
	@FindBy(xpath = "//input[@formcontrolname='skrillEmailId']")
	@CacheLookup
	private WebElement SkrillId;

	@FindBy(xpath = "//input[@formcontrolname='cashAppId']")
	@CacheLookup
	private WebElement CashAppId;

	@FindBy(xpath = "//input[@formcontrolname='seamlessChexId']")
	@CacheLookup
	private WebElement seamlessChexId;
	@FindBy(xpath = "//input[@id='flexCheckDefault']")
	@CacheLookup
	private WebElement SpecialOfferCheckBox;

	@FindBy(xpath = "//input[@id='termsOfUser']")
	@CacheLookup
	private WebElement TermsOfUserCheckBox;

	@FindBy(xpath = "//div[@class=\"modal-body\"]//input[@formcontrolname=\"firstName\"]")
	@CacheLookup
	private WebElement FirstNameofRegWeb;

	@FindBy(xpath = "//div[@class=\"modal-body\"]//input[@formcontrolname=\"lastName\"]")
	@CacheLookup
	private WebElement LastNameofRegWeb;

	@FindBy(xpath = "//div[@class=\"modal-body\"]//input[@formcontrolname=\"email\"]")
	@CacheLookup
	private WebElement EmailofRegWeb;

	@FindBy(xpath = "//div[@class=\"modal-body\"]//input[@formcontrolname=\"password\"]")
	@CacheLookup
	private WebElement PwdofRegWeb;

	@FindBy(xpath = "//button[text()='Sign Up']")
	@CacheLookup
	private WebElement SignUpBtn;

	@FindBy(xpath = "//li//a[text()=\"Logout\"]")
	@CacheLookup
	private WebElement LogoutBtn;

	@FindBy(xpath = "//button//span[text()=\"Player\"]")
	@CacheLookup
	private WebElement PlayerRegistrationButton;

	@FindBy(xpath = "//button[contains(text(),'Profile')]")
	@CacheLookup
	private WebElement GuestPlayerProfileButton;

	@FindBy(xpath = "//button[contains(text(),'Support Request')]")
	@CacheLookup
	private WebElement GuestPlayerSupportRequestButton;

	@FindBy(xpath = "//span[@class='mat-checkbox-inner-container']") // input[@type='checkbox']
	@CacheLookup
	private WebElement ReadOnlyCheckBox;

	@FindBy(xpath = "//h4[text()='Personal Details']")
	@CacheLookup
	public static WebElement personalDetails_Header;

	@FindBy(xpath = "//h3[text()='Guest Players']")
	@CacheLookup
	public static WebElement GuestPlayers_Header;

	public void SendFirstName(String Fname) {
		FirstNameofRegWeb.click();
		FirstNameofRegWeb.clear();
		FirstNameofRegWeb.sendKeys(Fname);
	}

	public void SendLastName(String Lname) {
		LastNameofRegWeb.click();
		LastNameofRegWeb.clear();
		LastNameofRegWeb.sendKeys(Lname);
	}

	public void SendEmail(String Email) {
		EmailofRegWeb.click();
		EmailofRegWeb.clear();
		EmailofRegWeb.sendKeys(Email);
	}

	public void SendPassword(String pass) {
		PwdofRegWeb.click();
		PwdofRegWeb.clear();
		PwdofRegWeb.sendKeys(pass);
	}

	public GuestPlayers ClickOnSpecialOfferCheckBox() {
		SpecialOfferCheckBox.click();
		return this;
	}

	public GuestPlayers ClickOnTermsOfUserCheckBox() {
		TermsOfUserCheckBox.click();
		return this;
	}

	public GuestPlayers ClickOnSignUP() {
		SignUpBtn.click();
		return this;
	}

	public void clickOnNewPlayerRegistration() throws InterruptedException {
		PlayerRegistrationButton.click();
	}

	public GuestPlayers ClickOnLogout() {
		LogoutBtn.click();
		return this;
	}

	public GuestPlayers ClickOnGuestPlayers() throws InterruptedException {
		GuestPlayers.click();
		Thread.sleep(600);
		return this;
	}

	public GuestPlayers ClickOnGuestPlayerLoginFootprints() {
		LoginFootprints.click();
		return this;
	}

	public GuestPlayers ClickOnGuestPlayerProfile() {
		GuestPlayerProfileButton.click();
		return this;
	}

	public GuestPlayers ClickOnSupportRequest() {
		GuestPlayerSupportRequestButton.click();
		return this;
	}

	public GuestPlayers setSkrillID(String str) {
		SkrillId.clear();
		SkrillId.click();
		SkrillId.sendKeys(str);
		return this;
	}

	public GuestPlayers setCashAppID(String str) {
		CashAppId.clear();
		CashAppId.click();
		CashAppId.sendKeys(str);
		return this;
	}

	public GuestPlayers setSeamlessChexD(String str) {
		seamlessChexId.clear();
		seamlessChexId.click();
		seamlessChexId.sendKeys(str);
		return this;
	}
	// ------SS----------------------------------------------------------------------------------------------------------

	public GuestPlayers selectTab() {
		DisplayName.sendKeys(Keys.TAB);
		return this;
	}

	public GuestPlayers Search_Items(String key) {
		try {
			Searchbox.clear();
			Searchbox.click();
			Searchbox.sendKeys(key);
		} catch (Exception e) {
			System.out.println("error in search");
		}
		return this;
	}

	public GuestPlayers clearsearch() {
		Searchbox.clear();
		return this;
	}

	public GuestPlayers ClickOnclearsearch() {
		ClearSearchbox.clear();
		return this;
	}

	public GuestPlayers selectgender(String val) throws InterruptedException {
		gender.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//mat-option//span[contains(text(),'" + val + "')]")).click();
		return this;
	}

	public GuestPlayers editgender(String val) throws InterruptedException {
		// gender.click();
		Thread.sleep(500);
		// gender.sendKeys();
		ldriver.findElement(By.xpath("//mat-option//span[text()='" + val + "']")).click();
		return this;
	}

	public GuestPlayers EnterTags() {
		ldriver.findElement(By.xpath("//input[@placeholder='Enter Tags']")).click();
		ldriver.findElement(By.xpath("//input[@placeholder='Enter Tags']")).sendKeys("Topper" + Keys.TAB);
		return this;
	}

	public GuestPlayers selectStore(String select) throws InterruptedException {
		Thread.sleep(1000);
		Store.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//span[contains(.,'" + select + "')]")).click();
		return this;
	}

	public GuestPlayers selectGuestStore(String select) throws InterruptedException {
		selectStore.click();
		Thread.sleep(600);
		ldriver.findElement(By.xpath("//span[contains(.,'" + select + "')]")).click();
		return this;
	}

	public GuestPlayers selectStoreAccount(String select) throws InterruptedException {
		bc.explicitWait(driver, storeAc, 5);
		storeAc.click();
		Thread.sleep(600);
		ldriver.findElement(By.xpath("//span[contains(.,'" + select + "')]")).click();
		return this;
	}

	public GuestPlayers selectparentuser(String select) throws InterruptedException {

		ParentUser.click();
		Thread.sleep(2000);
		ldriver.findElement(
				By.xpath("//input[@placeholder='Search Parent User']//following::span[contains(.,'" + select + "')]"))
				.click();
		Thread.sleep(1000);
		// ldriver.findElement(By.xpath("//input[@placeholder='Search Parent
		// User']//following::span[1]")).click();
		return this;
	}
	
	public GuestPlayers selectparentuser1(String select) throws InterruptedException {

		ParentUser.click();
		Thread.sleep(2000);
		//ldriver.findElement(By.xpath("//input[@placeholder='Search Parent User']//following::span[contains(.,'" + select + "')]")).click();
		
		ldriver.findElement(By.xpath("//input[@placeholder='Search Parent User']//following::span[1]")).click();
		Thread.sleep(1000);
		return this;
	}

	public GuestPlayers selectUserType(String type) throws InterruptedException {
		UserType.click();
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//span[text()='" + type + "']")).click();
		return this;
	}

	public GuestPlayers selectPlayerreputation() throws InterruptedException {

		PlayerReputation.click();
		Thread.sleep(500);
		SelectHigh.click();
		return this;
	}

	public GuestPlayers selectreputation(String reputation) throws InterruptedException {
		Reputation.click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//mat-option//span[text()='" + reputation + "']")).click();
		return this;
	}

	public GuestPlayers selectUserRole(String role) throws InterruptedException {
		Role.click();
		Thread.sleep(1000);
		ldriver.findElement(By.xpath("//mat-option//span[text()='" + role + "']")).click();
		return this;
	}

	public GuestPlayers selectReadOnlyUser() throws InterruptedException {
		ReadOnlyCheckBox.click();
		return this;
	}

	public void clickLogout() throws InterruptedException {
		UserProfile.click();
		Thread.sleep(1000);
		lnkLogout.click();
	}

	public GuestPlayers editUserRole(String role) throws InterruptedException {
		// Select reputation=new Select(playerReputations);
		// Role.click();
		Thread.sleep(500);
		// SelectHigh.click();
		ldriver.findElement(By.xpath("//mat-option//span[text()='" + role + "']")).click();
		// reputation.selectByVisibleText(value);
		return this;
	}

	public GuestPlayers clickCloseActionView() {
		CloseActionView.click();
		return this;
	}

	/**
	 * Click on Player Management Link.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public GuestPlayers clickOnPlayerManagement() {
		playerManagement.click();
		return this;
	}

	/**
	 * Click on Player Profile Link.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public GuestPlayers clickPlayerProfileLink() {
		playerProfile.click();
		return this;
	}

	/**
	 * Click on Xlsx Button.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public GuestPlayers clickXlsxButton() {
		xlsx.click();
		return this;
	}

	public GuestPlayers setFirstName(String firstname) {
		FirstName.clear();
		FirstName.click();
		FirstName.sendKeys(firstname);
		return this;
	}

	public GuestPlayers setLastName(String lastname) {
		LastName.clear();
		LastName.click();
		LastName.sendKeys(lastname);
		return this;
	}

	public GuestPlayers setDisplayName(String displayname) {
		DisplayName.sendKeys(displayname);
		return this;
	}

	public GuestPlayers setDisplayName1(String displayname) {
		DisplayName1.clear();
		DisplayName1.click();
		DisplayName1.sendKeys(displayname);
		return this;
	}

	public GuestPlayers setEmail(String email) {
		Email.clear();
		Email.click();
		Email.sendKeys(email);
		return this;
	}

	public GuestPlayers setPassword(String password) {
		Password.clear();
		Password.click();
		Password.sendKeys(password);
		return this;
	}

	public GuestPlayers setPhone(String phone) {
		Phone.clear();
		Phone.click();
		Phone.sendKeys(phone);
		return this;
	}

	public GuestPlayers setCity(String city) {
		City.clear();
		City.sendKeys(city);
		return this;
	}

	public GuestPlayers setZipcode(String zipcode) {
		ZipCode.clear();
		ZipCode.sendKeys(zipcode);
		return this;
	}

	public GuestPlayers setsingleTransactionSweepTokenLimit(String zipcode) {
		PTSTL.clear();
		PTSTL.sendKeys(zipcode);
		return this;
	}

	public GuestPlayers setdailySweepTokenLimit(String zipcode) {
		PDTSTL.clear();
		PDTSTL.sendKeys(zipcode);
		return this;
	}

	public GuestPlayers setAddress(String add) {
		Address.sendKeys(add);
		return this;
	}

	public GuestPlayers Clickeyeicon() {
		EyeIcon.click();
		return this;
	}

	public GuestPlayers ClickUploadImage(String path) {
		UploadImage.click();
		UploadImage.sendKeys(path);
		return this;
	}

	public GuestPlayers ClickSave() {
		JavascriptExecutor jse = (JavascriptExecutor) ldriver;
		jse.executeScript("arguments[0].click()", save);
		// save.click();
		return this;
	}

	public GuestPlayers setDialCode(String dialcode) {
		DialCode.click();
		DialCodeinput.sendKeys(dialcode);
		ldriver.findElement(By.xpath("//mat-option//span[text()=\"+91\"]")).click();
		return this;
	}

	public GuestPlayers setCountry(String country) throws InterruptedException {
		Country.click();
		SetCountry.sendKeys(country);
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + country + "']")).click();
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()='"+country+"']")).click();
		return this;
	}

	public GuestPlayers setCountry_BlockList(String country) throws InterruptedException {
		Country.click();
		// SetCountry.sendKeys(country);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + country + "']")).click();
		// Country.click();
		// Thread.sleep(500);
		SetCountry.sendKeys(Keys.ESCAPE);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()='"+country+"']")).click();
		return this;
	}

	public GuestPlayers editCountry(String country) throws InterruptedException {
		// Country.click();
		SetCountry.sendKeys(country);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + country + "']")).click();
		return this;
	}

	public GuestPlayers setState(String state) throws InterruptedException {
		State.click();
		SetState.sendKeys(state);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + state + "']")).click();
		return this;
	}

	public GuestPlayers editState(String state) throws InterruptedException {
		// State.click();
		SetState.sendKeys(state);
		Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + state + "']")).click();
		return this;
	}

	public GuestPlayers editTimezone(String zone) throws InterruptedException {
		SetTimezone.click();
		SetTimezone.sendKeys(zone);
		Thread.sleep(300);
		ldriver.findElement(By.xpath("//mat-option/span[contains(.,'" + zone + "')]")).click();
		return this;
	}

	public GuestPlayers editRPP(String rpp) throws InterruptedException {
		// State.click();
		RPP.sendKeys(rpp);
		Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span[contains(text(),'" + rpp + "')]")).click();
		return this;
	}

	public GuestPlayers setUsersState(String state) throws InterruptedException {
		UsersState.click();
		SetState.sendKeys(state);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + state + "']")).click();
		return this;
	}

	public GuestPlayers editUsersState(String state) throws InterruptedException {
		// UsersState.click();
		SetState.sendKeys(state);
		// Thread.sleep(300);
		// SetState.sendKeys(Keys.DOWN,Keys.ENTER);
		// ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		ldriver.findElement(By.xpath("//mat-option/span/span[text()='" + state + "']")).click();
		return this;
	}

	/**
	 * Search Player - Filter
	 */
	public GuestPlayers clickFilter() {
		Filter.click();
		return this;
	}

	public GuestPlayers clickSearch() {
		Search.click();
		return this;
	}

	public GuestPlayers setPlayerId(String playerid) {
		Playerid.sendKeys(playerid);
		return this;
	}

	public GuestPlayers searchLobby(String lobby) {
		Searchlobby.click();
		testlobby.click();
		return this;
	}

	public GuestPlayers searchState(String state) {
		Selectsearchstate.click();
		SetState.sendKeys(state);
		ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
		return this;
	}

	public GuestPlayers searchCreatedFrom() throws InterruptedException {
		CreatedAtFrom.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label=\"June 30, 2022\"]")).click();
		return this;
	}

	public GuestPlayers searchCreatedTo() {
		CreatedAtTo.click();
		NextMonth.click();
		driver.findElement(By.xpath("//button[@aria-label=\"July 30, 2022\"]")).click();
		return this;
	}

	public GuestPlayers SortBy(String sort) {
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

	public GuestPlayers Sortbydirection(String direction) {
		sortByDirection.click();
		if (direction == "Ascending") {
			Ascending.click();
		}
		if (direction == "Descending") {
			Descending.click();
		}
		return this;
	}

	public GuestPlayers clearfilter() {
		ClearFilter.click();
		return this;
	}

	// Release 1.2.4
	@FindBy(xpath = "//div[text()='Profile Footprints']")
	@CacheLookup
	private WebElement ProfileFootprints;

	public GuestPlayers clickOnProfileFootprints() {
		ProfileFootprints.click();
		return this;
	}

	@FindBy(xpath = "//div[text()='Login Footprints']")
	@CacheLookup
	private WebElement LoginFootprint;

	public GuestPlayers clickOnLoginFootprints() {
		LoginFootprint.click();
		return this;
	}

	/**
	 * Click on Create New Button.
	 *
	 * @return the GuestPlayers class instance.
	 */
	public GuestPlayers clickCreateNewButton() {
		createNew.click();
		return this;
	}

	@FindBy(xpath = "//input[@formcontrolname=\"displayName\"]")
	@CacheLookup
	public WebElement displayNameofRegWeb;

	public void SenddisplayName(String Fname) {

		displayNameofRegWeb.clear();
		displayNameofRegWeb.sendKeys(Fname);
	}
	
	public GuestPlayers ClickOnSignup() {
        SignUpBtn.click();
        return this;
    }
	

}