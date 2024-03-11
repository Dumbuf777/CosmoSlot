/**
 * 
 */
package com.Cosmoslots.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentTest;

/**
 * @author shrikrushna.sonkar
 *
 */
public class CosmoWebsite extends ExtentManager {

	// public static ExtentTest test;
	WebDriver ldriver;
	BaseClass bc = new BaseClass();

	public CosmoWebsite(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement SignIn;

	@FindBy(xpath = "//button[text()=' Registration']")
	@CacheLookup
	private WebElement PlayerRegistration;

	@FindBy(xpath = "//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']") // a[@id='dropdownUser']
	@CacheLookup
	private WebElement PlayerProfileDd;

	@FindBy(xpath = "//a[contains(@class,'userDropDown dropdown-toggle')]")
	@CacheLookup
	private WebElement Playerdropdown;

	@FindBy(xpath = "//a[contains(text(),'Profile')]")
	@CacheLookup
	private WebElement PlayerProfileBtn;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	@CacheLookup
	private WebElement PlayerChangePasswordBtn;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	private WebElement PlayerLogoutBtn;

	@FindBy(xpath = "(//input[@formcontrolname='firstName'])[2]") // h2[text()='Sign
																	// Up']//following::input[@formcontrolname='firstName']
	@CacheLookup
	private WebElement PlayerfirstName;

	@FindBy(xpath = "(//input[@formcontrolname='lastName'])[2]") // h2[text()='Sign
																	// Up']//following::input[@formcontrolname='lastName']
	@CacheLookup
	private WebElement PlayerlastName;

	@FindBy(xpath = "(//input[@formcontrolname='displayName'])[1]")
	@CacheLookup
	private WebElement PlayerdisplayName;

	@FindBy(xpath = "(//input[@formcontrolname='email'])[2]") // h2[text()='Sign
																// Up']//following::input[@formcontrolname='email']
	@CacheLookup
	private WebElement PlayerEmail;

	@FindBy(xpath = "(//select[@formcontrolname='dialCode'])[1]")
	@CacheLookup
	private WebElement PlayerdialCode;

	@FindBy(xpath = "(//input[@formcontrolname='phone'])[2]")
	@CacheLookup
	private WebElement PlayerPhone;

	@FindBy(xpath = "(//textarea[@formcontrolname='message'])[2]")
	@CacheLookup
	private WebElement Playermessage;

	@FindBy(xpath = "//input[@formcontrolname='email']//following::div//input[@formcontrolname='password']") // h2[text()='Sign
																												// Up']//following::input[@formcontrolname='password']
	@CacheLookup
	private WebElement PlayerPassword;

	@FindBy(xpath = "//h2[text()='Sign Up']//following::input[@formcontrolname='inviteCode']")
	@CacheLookup
	private WebElement PlayerInviteCode;

	@FindBy(xpath = "//input[@formcontrolname='acceptTerms']") // h2[text()='Sign
																// Up']//following::input[@formcontrolname='password']
	@CacheLookup
	private WebElement PlayeracceptTerms;

	@FindBy(xpath = "//input[@formcontrolname='inviteCode']//following::a[1]")
	@CacheLookup
	private WebElement DonthaveanInviteCode;

	@FindBy(xpath = "(//button[text()='Send Message'])[2]")
	@CacheLookup
	private WebElement SendMessageBtn;

	@FindBy(xpath = "(//a[@id='dropdownNotification'])[1]")
	@CacheLookup
	private WebElement NotificationIcon;

	@FindBy(xpath = "//em[@class='fa fa-ticket']")
	@CacheLookup
	private WebElement SupportIcon;

	@FindBy(id="nav-myprofile-tab")//xpath = "//button[text()='Profile']"
	@CacheLookup
	private WebElement PlayerProfileTab;

	@FindBy(id="nav-packages-tab")//button[text()=' Packages ']
	@CacheLookup
	private WebElement PlayerPackagesTab;

	@FindBy(xpath = "")//button[text()='Stats']
	@CacheLookup
	private WebElement PlayerStatsTab;

	@FindBy(id = "nav-mybonuses-tab") // xpath = "//button[text()='Bonuses']
	@CacheLookup
	private WebElement PlayerBonusesTab;

	@FindBy(id="nav-withdrawal-tab")//button[text()='Withdraw']
	@CacheLookup
	private WebElement PlayerWithdrawTab;

	@FindBy(id="nav-transactions-tab")//button[text()='Transactions']
	@CacheLookup
	private WebElement PlayerTransactionsTab;

	@FindBy(id="nav-support-tab")//button[text()='Support']
	@CacheLookup
	private WebElement PlayerSupportTab;

	@FindBy(id="nav-game-transaction-tab")//button[text()='Game Transactions']
	@CacheLookup
	private WebElement PlayerGameTransactionsTab;

	@FindBy(id = "SLOT']")
	@CacheLookup
	private WebElement PlayerSlotGameTransactionsTab;

	@FindBy(id = "KENO']")
	@CacheLookup
	private WebElement PlayerKenoGameTransactionsTab;

	@FindBy(id = "FISH")
	@CacheLookup
	private WebElement PlayerFishGameTransactionsTab;

	@FindBy(xpath = "//*[@id='nav-announcement-tab']")
	@CacheLookup
	private WebElement PlayerAnnouncementTab;

	@FindBy(id = "nav-verify-tab")
	@CacheLookup
	private WebElement PlayerKYCverification ;

	@FindBy(id = "nav-wallet-tab")
	@CacheLookup
	private WebElement PlayerWalletTab;

	@FindBy(xpath = "//button[text()='Send via Email']")
	@CacheLookup
	private WebElement SendviaEmail;

	@FindBy(xpath = "//button[text()='Send via Phone Number']")
	@CacheLookup
	private WebElement SendviaPhoneNumber;

	@FindBy(xpath = "//button[text()='Withdraw Amount']")
	@CacheLookup
	private WebElement WithdrawAmount;

	@FindBy(xpath = "//button[text()='New Request']")
	@CacheLookup
	private WebElement NewRequest;

	@FindBy(xpath = "//button[text()='Save']")
	@CacheLookup
	private WebElement Save;
	
	@FindBy(xpath = "(//button[@aria-label='Close']//child::span)[1]")
	@CacheLookup
	private  WebElement Close_X;

	@FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
	@CacheLookup
	private WebElement Forgotpassword;

	@FindBy(xpath = "//h2[contains(text(),'Forgot password?')]//following::input[@formcontrolname='email']")
	@CacheLookup
	private WebElement PlayerEnterEmailForresetPassword;

	@FindBy(xpath = "//button[contains(text(),'Reset Password')]")
	@CacheLookup
	private WebElement SendResetLink;

	@FindBy(xpath = "//button[contains(text(),'Add Amount')]")
	@CacheLookup
	private WebElement AddAmountInWallet;

	@FindBy(xpath = "//button[contains(text(),'Withdraw Amount')]")
	@CacheLookup
	private WebElement WithdrawAmountfromWallet;

	/**
	 * Click on Sign In Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnSignIn() {
		SignIn.click();
		bc.implicitWait(ldriver, 10);
		test.info("Player clicked on sign in");
		return this;
	}

	/**
	 * Click on Player RegistrationLink.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerRegistration() {
		PlayerRegistration.click();
		bc.implicitWait(ldriver, 10);
		test.info("Player clicked on player registration");
		return this;
	}

	/**
	 * Click on PlayerProfileDd Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerProfileDd() {
		// Actions ac = new Actions(ldriver);
		// ac.moveToElement(PlayerProfileDd).click().perform();
		PlayerProfileDd.click();
		bc.implicitWait(ldriver, 10);
		test.info("Player clicked on player profile icon");
		return this;
	}

	/**
	 * Click on PlayerProfileBtn Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerProfileBtn() {
		PlayerProfileBtn.click();
		bc.implicitWait(ldriver, 10);
		test.info("Player clicked on player profile icon");
		return this;
	}

	/**
	 * Click on Playerdropdown Link. Click on PlayerProfileBtn Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerProfile() throws InterruptedException {
		bc.explicitWait(driver, Playerdropdown, 10);
		Playerdropdown.click();
		test.info("Player clicked on player profile icon");
		bc.explicitWait(driver, PlayerProfileBtn, 10);
		PlayerProfileBtn.click();
		test.info("Player clicked on player profile button");
		return this;
	}

	/**
	 * Click on PlayerProfileDd and PlayerChangePasswordBtn Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerChangePasswordBtn() throws InterruptedException {
		PlayerProfileDd.click();
		bc.explicitWait(ldriver, PlayerChangePasswordBtn, 10);
		PlayerChangePasswordBtn.click();
		return this;
	}

	/**
	 * Click on PlayerLogoutBtn Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerLogoutBtn() {
		bc.explicitWait(ldriver, PlayerLogoutBtn, 10);
		PlayerLogoutBtn.click();
		test.info("Player clicked on player logout button");
		return this;
	}

	/**
	 * Click on Playerdropdown Link Click on PlayerLogoutBtn Link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPlayerLogout() throws InterruptedException {
		// PlayerProfileDd.click();
		bc.fluentWait(driver, Playerdropdown, 10);
		Playerdropdown.click();
		bc.explicitWait(ldriver, PlayerLogoutBtn, 10);
		PlayerLogoutBtn.click();
		return this;
	}

	/**
	 * clear PlayerfirstName text. Click PlayerfirstName text. entered
	 * PlayerfirstName using string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerFirstname(String fname) {
		PlayerfirstName.clear();
		PlayerfirstName.click();
		PlayerfirstName.sendKeys(fname);
		return this;
	}

	/**
	 * clear PlayerlastName text. Click PlayerlastName text. entered PlayerlastName
	 * using string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerLastname(String lname) {
		PlayerlastName.clear();
		PlayerlastName.click();
		PlayerlastName.sendKeys(lname);
		return this;
	}

	/**
	 * clear PlayerdisplayName text. Click PlayerdisplayName text. entered
	 * PlayerdisplayName using string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerdisplayName(String Dname) {
		PlayerdisplayName.clear();
		PlayerdisplayName.click();
		PlayerdisplayName.sendKeys(Dname);
		return this;
	}

	/**
	 * clear PlayerPassword text. Click PlayerPassword text. entered PlayerPassword
	 * using string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerPassword(String password) {
		PlayerPassword.clear();
		PlayerPassword.click();
		PlayerPassword.sendKeys(password);
		return this;
	}

	/**
	 * clear PlayerInviteCode text. Click PlayerInviteCode text. entered
	 * PlayerInviteCode using string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerinviteCode(String inviteCode) {
		PlayerInviteCode.clear();
		PlayerInviteCode.click();
		PlayerInviteCode.sendKeys(inviteCode);
		return this;
	}

	/**
	 * clear PlayerEmail text. Click PlayerEmail text. entered PlayerEmail using
	 * string value
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerEmail(String email) {
		PlayerEmail.clear();
		PlayerEmail.click();
		PlayerEmail.sendKeys(email);
		return this;
	}

	/**
	 * Click PlayerdialCode dropdown. select value from dropdown.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite SelectPlayerDialCode() {
		// PlayerdialCode.clear();
		PlayerdialCode.click();
		ldriver.findElement(By.xpath("//select[@formcontrolname='dialCode']//child::option[2]")).click();
		// PlayerEmail.sendKeys();
		return this;
	}

	/**
	 * Click PlayerPhone dropdown. entered PlayerPhone number.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerPhoneNo(String num) {
		PlayerPhone.click();
		PlayerPhone.sendKeys(num);
		return this;
	}

	/**
	 * Click Playermessage. entered Playermessage using string value.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite EnterPlayerMessage(String msg) {
		Playermessage.click();
		Playermessage.sendKeys(msg);
		return this;
	}

	/**
	 * Click DonthaveanInviteCode link.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnDonthaveanInviteCode() {
		DonthaveanInviteCode.click();
		return this;
	}

	/**
	 * Click on SendMessageBtn.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnSendMessageBtn() {
		SendMessageBtn.click();
		return this;
	}

	/**
	 * Click on NotificationIcon.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickonNotificationIcon() {
		NotificationIcon.click();
		return this;
	}

	/**
	 * Click on SupportIcon.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickonSupportIcon() {
		SupportIcon.click();
		return this;
	}
	
	/**
	 * Click on PlayerProfileTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnProfile() {
		PlayerProfileTab.click();
		return this;
	}
	
	/**
	 * Click on PlayerPackagesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnPackages() {
		PlayerPackagesTab.click();
		return this;
	}

	/**
	 * Click on PlayerStatsTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnStats() {
		PlayerStatsTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnBonuses() {
		PlayerBonusesTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnWithdraw() {
		bc.explicitWait(ldriver, PlayerAnnouncementTab, 10);
		PlayerWithdrawTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnTransactions() {
		PlayerTransactionsTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnSupport() {
		PlayerSupportTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnGameTransactions() {
		PlayerGameTransactionsTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnSlotGameTransactions() {
		PlayerSlotGameTransactionsTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnKenoGameTransactions() {
		PlayerKenoGameTransactionsTab.click();
		return this;
	}

	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnFishGameTransactions() {
		PlayerFishGameTransactionsTab.click();
		return this;
	}
	
	/**
	 * Click on PlayerAnnouncementTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnAnnouncement() {
		PlayerAnnouncementTab.click();
		return this;
	}
	
	/**
	 * Click on PlayerverifyTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnVerify() {
		PlayerKYCverification.click();
		return this;
	}
	
	/**
	 * Click on PlayerWalletTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnWallet() {
		PlayerWalletTab.click();
		return this;
	}
	
	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite AddAmountInWallet() {
		// ldriver.findElement(By.xpath("//button[text()='Add Amount']")).click();
		WebElement purchaseType = ldriver.findElement(By.name("purchaseType"));
		AddAmountInWallet.click();
		if (purchaseType.getAttribute("id").contains("zen")) {
			ldriver.findElement(By.id("zen")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("1");
			ldriver.findElement(By.xpath("(//button[text()='Add Amount'])[2]")).click();
		} else if (purchaseType.getAttribute("id").contains("skrill")) {
			ldriver.findElement(By.id("skrill")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("1");
			ldriver.findElement(By.xpath("(//button[text()='Add Amount'])[2]")).click();
		} else if (purchaseType.getAttribute("id").contains("paysafe")) {
//			Select s= new Select(purchaseType)
			ldriver.findElement(By.id("paysafe")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("1");
			ldriver.findElement(By.xpath("(//button[text()='Add Amount'])[2]")).click();
		} else if (purchaseType.getAttribute("id").contains("cashapp")) {
			ldriver.findElement(By.id("cashapp[@placeholder='Amount']")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("1");
			ldriver.findElement(By.xpath("(//button[text()='Add Amount'])[2]")).click();
		} else if (purchaseType.getAttribute("id").contains("other")) {
			ldriver.findElement(By.id("other")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).click();
			ldriver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys("1");
			ldriver.findElement(By.xpath("(//button[text()='Add Amount'])[2]")).click();
		}

		return this;
	}


	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite WithdrawAmountFromWallet() {

		return this;
	}
	
	/**
	 * Click on SendviaEmail.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnSendviaEmail() {
		SendviaEmail.click();
		return this;
	}
	
	/**
	 * Click on SendviaPhoneNumber.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnSendviaPhoneNumber() {
		SendviaPhoneNumber.click();
		return this;
	}
	
	/**
	 * Click on WithdrawAmount.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnWithdrawAmount() {
		bc.explicitWait(ldriver, WithdrawAmount, 30);
		WithdrawAmount.click();
		return this;
	}
	
	/**
	 * Click on Save.
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite ClickOnSave() {
		Save.click();
		return this;
	}
	
	/**
	 * Click on NewRequest.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnSupportNewRequest() {
		NewRequest.click();
		return this;
	}
	
	
	/**
	 * Click on Close_X.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnClose() {
		Close_X.click();
		return this;
	}

	public CosmoWebsite ClickonPackagePurchsae(String pkg) {
		WebElement purchase = ldriver
				.findElement(By.xpath("//h1[text()='" + pkg + "']//following::a[text()='Purchase'][1]"));
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", purchase);
		js.executeScript("arguments[0].click()", purchase);
//		purchase.click();
		return this;

	}
	
	/**
	 * Click on PlayerBonusesTab.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	

//	Support admin will contact you shortly!
	public CosmoWebsite ClickOnPlayerForgotPassword(String email) throws InterruptedException {
		Thread.sleep(2000);
		SignIn.click();
		Thread.sleep(2000);
		Forgotpassword.click();
		Thread.sleep(2000);
		PlayerEnterEmailForresetPassword.click();
		Thread.sleep(500);
		PlayerEnterEmailForresetPassword.sendKeys(email);
		Thread.sleep(500);
		SendResetLink.click();

		return this;

	}
	
	/**
	 * player sign up by invite code
	 *
	 * @return the CosmoWebsite class instance.
	 */

//  player sign up by invite code
	public CosmoWebsite SignUpByInviteCode(String firstName, String lastName, String phone, String password)
			throws InterruptedException {
		PlayerfirstName.clear();
		PlayerfirstName.click();
		PlayerfirstName.sendKeys(firstName);
		PlayerlastName.clear();
		PlayerlastName.click();
		PlayerlastName.sendKeys(lastName);
		PlayerdisplayName.clear();
		PlayerdisplayName.click();
		PlayerdisplayName.sendKeys(firstName+"an");
		PlayerEmail.clear();
		PlayerEmail.click();
		PlayerEmail.sendKeys(firstName + lastName + "@yopmail.com");
		ldriver.findElement(By.xpath("//select[@formcontrolname='dialCode']")).click();
		ldriver.findElement(By.xpath("//select[@formcontrolname='dialCode']//child::option[2]")).click();
		PlayerPhone.clear();
		PlayerPhone.click();
		PlayerPhone.sendKeys(phone);
		PlayerPassword.clear();
		PlayerPassword.click();
		PlayerPassword.sendKeys(password);
		PlayeracceptTerms.click();
		Thread.sleep(1500);
		ldriver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(2000);
		return this;

	}
	
	/**
	 * Click on player icon.
	 * Click on player profile.
	 * extract player invite code 
	 *
	 * @return the CosmoWebsite class instance.
	 */

	// Copy invite code
	public CosmoWebsite Copy_InviteCode() throws InterruptedException {
		ClickOnPlayerProfile();
		WebElement Player_Invite_code = ldriver.findElement(By.xpath("(//a[@title='Copy Invite Code'])[1]"));
		String player_Invite_code = ldriver.findElement(By.xpath("//span[text()='Invite Code ']//child::span/b"))
				.getText();
		System.out.println(player_Invite_code);
		Player_Invite_code.click();
		return this;
	}
	
	/**
	 * verify player level
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite Click_PlayerlevelRefrashBtn() {
		ldriver.findElement(By.xpath("//span[@class=\"levelRefrashBtn\"]//child::i")).click();
		if (ldriver.findElement(By.xpath("//span[@class=\"maUserLevelCount\"]")).isDisplayed()) {
			System.out.println("Successsfully viewed player level");

		} else {
			System.out.println("Somthing wrong! To view player level");
		}
		return this;
	}
	
	/**
	 * This method is used to player 
	 * email OTP verification
	 *
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite PlayerEmailVerification() throws InterruptedException {
		ldriver.findElement(By.xpath("//label[text()='Email']//following::button[text()='Verification'][1]")).click();
		Thread.sleep(1500);
		ldriver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
		ldriver.findElement(By.xpath("//button[text()='Submit ']")).click();
		Thread.sleep(2000);
		return this;

	}
	
	/**
	 * This method is used to player
	 * phone number OTP verification
	 * @return the CosmoWebsite class instance.
	 */

	public CosmoWebsite PlayerPhoneNumberVerification() throws InterruptedException {
		ldriver.findElement(By.xpath("//label[text()='Phone Number']//following::button[text()='Verification'][1]"))
				.click();
		Thread.sleep(1500);
		ldriver.findElement(By.xpath("//div[contains(@class,'otp-input')]//input[1]")).sendKeys("1234");
		ldriver.findElement(By.xpath("//button[text()='Submit ']")).click();
		Thread.sleep(2000);
		return this;

	}

	/**
	 * Click on ClickOnPackages.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite PlayerPackgePurchase() {
		ClickOnPackages();
		return this;
	}

	/**
	 * this method is used to player able to 
	 * purchase package with applying coupon
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite playerPackagePurchaseUsingCoupon(String pkgPurchase, String couponCode)
			throws InterruptedException {
		ClickOnPackages();
		Thread.sleep(1500);
		WebElement ele = ldriver.findElement(
				By.xpath("(//h1[contains(text(),'" + pkgPurchase + "')]//following::button[text()='Purchase'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1500);
		ele.click();
		Thread.sleep(2000);
		WebElement other = ldriver.findElement(By.xpath("//label[text()=' Other ']"));
		other.click();
		Thread.sleep(1500);
		ldriver.findElement(By.xpath("//input[@placeholder='coupon code']")).click();
		ldriver.findElement(By.xpath("//input[@placeholder='coupon code']")).sendKeys(couponCode);
		ldriver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(1500);
		ldriver.findElement(
				By.xpath("//h2[contains(text(),'Token Purchase')]//following::button[text()='Purchase'][1]")).click();
		Thread.sleep(1500);
		return this;
	}

	public static enum Playerprofile {
		Profile, Packages, Stats, Bonuses, Withdraw, Transactions, Support, GameTransactions, Announcement, Wallet
	};
	
	public CosmoWebsite PlayerProfileView() throws InterruptedException {
		for (Playerprofile Player_Profile : Playerprofile.values()) {
			switch (Player_Profile) {
			case Profile:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerProfileBtn.click();
				Thread.sleep(1000);
				break;
			case Packages:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerPackagesTab.click();
				Thread.sleep(1000);
				break;
			case Stats:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerPackagesTab.click();
				Thread.sleep(1000);
				break;
			case Bonuses:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerPackagesTab.click();
				Thread.sleep(1000);
				break;
			case Withdraw:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerPackagesTab.click();
				Thread.sleep(1000);
				break;
			case Transactions:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerPackagesTab.click();
				Thread.sleep(1000);
				break;
			case Support:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerSupportTab.click();
				Thread.sleep(1000);
				break;
			case GameTransactions:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerGameTransactionsTab.click();
				Thread.sleep(1000);
				break;
			case Announcement:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerAnnouncementTab.click();
				Thread.sleep(1000);
				break;
			case Wallet:
				PlayerProfileDd.click();
				Thread.sleep(500);
				PlayerWalletTab.click();
				Thread.sleep(1000);
				break;
			}
		}
		return this;
	}

	@FindBy(xpath = "//a[contains(.,'Contact Us')]")
	@CacheLookup
	private WebElement ContactUs_Button;

	
	/**
	 * Click on ContactUs_Button.
	 *
	 * @return the CosmoWebsite class instance.
	 */
	public CosmoWebsite ClickOnContactUs() {
		ContactUs_Button.click();
		return this;
	}
	
	@FindBy(xpath = "//tr//th")
	private List<WebElement> headers;
	
	@FindBy(xpath = "//tr[1]//td")
	private List<WebElement> rowData;
	
	public CosmoWebsite readData() {
		for (int i = 0; i < headers.size(); i++) {
			String headerText = headers.get(i).getText();
			String dataText = rowData.get(i).getText();
			if (driver.findElement(By.xpath("//th[text()='" + headerText + "']")).isDisplayed() == true) {
				test.info("Successfully Viewed <b>" + headerText + " = " + dataText
						+ "</b> on the page", extentScreenshot());
			} else {
				test.fail("Something wrong !! To open user footprint details", extentScreenshot());
			}
		}
		return this;
	}
	
	public CosmoWebsite PlayerpackagePurchase(String pkgPurchase) throws InterruptedException {

		driver.findElement(By.id("nav-packages-tab")).click();
		Thread.sleep(1500);
		WebElement ele = driver.findElement(By.xpath("(//h1[contains(text(),'" + pkgPurchase + "')]//following::button[text()='Purchase'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);
		Thread.sleep(1500);
		ele.click();
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//label[text()=' Other ']"));
		other.click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//h2[contains(text(),'Token Purchase')]//following::button[text()='Purchase'][1]")).click();
		System.out.println("package purchased ");
		//test.info("package purchased ",extentScreenshot());
		return this;

	}
	
	@FindBy(xpath="//input[@value='SKRILL']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_Skrill;
	
	@FindBy(xpath="//input[@value='PAYSAFE']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_paysafe;
	
	@FindBy(xpath="//input[@value='CASH_APP']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_cashapp;
	
	@FindBy(xpath="//input[@value='BANK_ACCOUNT']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_bank_account;
	
	@FindBy(xpath="//input[@value='SEAMLESS_CHEX']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_seamless_chex;
	
	@FindBy(xpath="//input[@value='MANUAL']")
	@CacheLookup
	private WebElement paymentProvider_manual;
	
	@FindBy(xpath="//input[@value='WALLET']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_wallet;
	
	@FindBy(xpath="//input[@value='PAYPER']//following::span[1]")
	@CacheLookup
	private WebElement paymentProvider_PAYPER;
	
	@FindBy(xpath="//div[@class='withdraw-form-block']//button[text()='Withdraw']")
	@CacheLookup
	public WebElement WithdrawBtn;
	
	@FindBy(xpath="//input[@formcontrolname='accountHolderName']")
	@CacheLookup
	public WebElement accountHolderName;
	
	@FindBy(xpath="//input[@formcontrolname='accountNumber']")
	@CacheLookup
	public WebElement accountNumber;
	@FindBy(xpath="//input[@formcontrolname='routingNumber']")
	@CacheLookup
	public WebElement routingNumber;
	@FindBy(xpath="//input[@formcontrolname='bankName']")
	@CacheLookup
	public WebElement bankName;
	
	public CosmoWebsite PlayerWithdrawAmountUsingPaymentMethod_Manual() throws InterruptedException {
		Actions actions = new Actions(ldriver);
		actions.moveToElement(paymentProvider_manual).click().build().perform();
		Thread.sleep(500);
		WithdrawBtn.click();
		return this;
	}
	
	
	public CosmoWebsite PlayerWithdrawAmountUsingPaymentMethod(String paymetMethod) throws InterruptedException {
		Actions act = new Actions(ldriver);

		if (paymetMethod == "skrill") {
			act.moveToElement(paymentProvider_Skrill).click().build().perform();
			Thread.sleep(500);
			WithdrawBtn.click();
		} else if (paymetMethod == "paysafe") {
			act.moveToElement(paymentProvider_paysafe).click().build().perform();
			Thread.sleep(500);
			WithdrawBtn.click();
		} else if (paymetMethod == "cashapp") {
			act.moveToElement(paymentProvider_cashapp).click().build().perform();
			Thread.sleep(500);
			WithdrawBtn.click();
		} else if (paymetMethod == "bank_account") {
			act.moveToElement(paymentProvider_bank_account).click().build().perform();
			Thread.sleep(500);
			accountHolderName.sendKeys("HDFC Bank");
			accountNumber.sendKeys("4887464648");
			routingNumber.sendKeys("312");
			bankName.sendKeys("Test Bank");
			WithdrawBtn.click();
		} else if (paymetMethod == "seamless_chex") {
			act.moveToElement(paymentProvider_seamless_chex).click().build().perform();
			Thread.sleep(500);
			WithdrawBtn.click();
		} else if (paymetMethod == "manual") {
			act.moveToElement(paymentProvider_manual).click().build().perform();
			Thread.sleep(500);
			WithdrawBtn.click();
		} else if (paymetMethod == "wallet") {
			act.moveToElement(paymentProvider_wallet).click().build().perform();
			Thread.sleep(500);
			act.moveToElement(WithdrawBtn).click().build().perform();
		}else if (paymetMethod == "PAYPER") {
			act.moveToElement(paymentProvider_PAYPER).click().build().perform();
			Thread.sleep(1000);
			act.moveToElement(WithdrawBtn).click().build().perform();
		}
		return  this;

	}
}