package com.Cosmoslots.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.ENUM.ColumnSelectors;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.ExtentManager;

public class WithdrawRequest extends ExtentManager {
	BaseClass bc = new BaseClass();
	WebDriver ldriver;

	public WithdrawRequest(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//img[@alt=\"Logo\"]")
	@CacheLookup
	WebElement CosmoLogo;

	@FindBy(xpath = "//input[@formcontrolname=\"username\"]")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(xpath = "//input[@name=\"userNameOrEmail\"]")
	@CacheLookup
	WebElement txtUserNameOrEmail;

	@FindBy(xpath = "//input[@formcontrolname=\"password\"]")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(xpath = "//button//span[text()=\"Login\"]")
	@CacheLookup
	public WebElement btnLogin;

	@FindBy(xpath = "//span[text()=\"Send Password Reset Link\"]")
	@CacheLookup
	WebElement btnResetLink;

	@FindBy(xpath = "//span[@class=\"mat-button-wrapper\"]//span[contains(@class,\"user-name\")]//following-sibling::i")
	@CacheLookup
	WebElement UserProfile;

	@FindBy(xpath = "//span//a[text()=\" Logout\"]")
	@CacheLookup
	WebElement lnkLogout;

	@FindBy(xpath = "//span//mat-icon[text()=\"visibility\"]")
	@CacheLookup
	WebElement pwdvisibility;

	@FindBy(xpath = "//span//mat-icon[text()=\"visibility_off\"]")
	@CacheLookup
	WebElement pwdhidden;

	@FindBy(xpath = "//a[text()=\"Forgot password?\"]")
	@CacheLookup
	WebElement forgetpwd;

	@FindBy(xpath = "//a[text()=\" Back to login\"]")
	@CacheLookup
	WebElement Backtologin;

	@FindBy(xpath = "//button[text()=\"Withdraw Amount\"]")
	@CacheLookup
	public static WebElement withdrawAmount;

	@FindBy(xpath = "//button[text()=\"Withdraw Requests\"]")
	@CacheLookup
	public static WebElement withdrawRequest;

	@FindBy(xpath = "(//th[text()=\"Action\"]/following::tr//td[contains(@class,\"action\")]//i)[1]")
	@CacheLookup
	public static WebElement Actioneye;

	@FindBy(xpath = "//span[text()=\" PDF\"]")
	@CacheLookup
	public static WebElement PDFDownload;

	@FindBy(xpath = " //span[text()=\" XLSX\"]")
	@CacheLookup
	public static WebElement XLSXDownload;

	@FindBy(xpath = "//label[contains(text(),\"CashApp\")]")
	@CacheLookup
	public WebElement CashApp_PaymentMode_web;

	@FindBy(xpath = "//label[contains(text(),\"Bank Account\")]")
	@CacheLookup
	public WebElement BankAcocunt_PaymentMode_web;

//-----------------------krishna Website Code---------------------------//
	@FindBy(xpath = "//a[@role=\"button\"]//span[@class=\"userName\"]")
	@CacheLookup
	WebElement username_web;

	@FindBy(xpath = "//a[text()='Profile']")
	@CacheLookup
	WebElement profile_web;

	@FindBy(xpath = "//div[@role='tablist']//button[text()='Withdraw']")
	@CacheLookup
	WebElement Withdraw_MainTab_web;

	@FindBy(xpath = "//button[text()='Withdraw Amount']")
	@CacheLookup
	WebElement WithdrawAmount_Tab_web;

	@FindBy(xpath = "//input[@formcontrolname='currentWithdrawalAmount']")
	@CacheLookup
	public WebElement CurrentWithdrawAmount_web;

	@FindBy(xpath = "//input[@value='SKRILL']//following::span[1]")
	@CacheLookup
	public WebElement Skrill_PaymentMode_web;

	@FindBy(xpath = "//div[@class='withdraw-form-block']//button[text()='Withdraw']")
	@CacheLookup
	public WebElement WithdrawBtn;

	@FindBy(xpath = "//li//a[text()=\"Logout\"]")
	@CacheLookup
	WebElement logoutBtn;

	@FindBy(xpath = "//h3[text()='View Withdraw Request Details']")
	@CacheLookup
	public WebElement ViewWithdrawRequestDetails_Header;

	public WithdrawRequest clickonUser() {
		UserProfile.click();
		return this;
	}

	public void clickOnUser() throws InterruptedException {
		username_web.click();
		Thread.sleep(1000);
		profile_web.click();
	}

	public void clickOnUserprofile() throws InterruptedException {
		username_web.click();
	}

	public void clickOnWithdraw_MainTab_web() throws InterruptedException {
		Withdraw_MainTab_web.click();
		WithdrawAmount_Tab_web.click();

	}

	public void SendWithrawAmount() throws InterruptedException {
		Thread.sleep(2000);
		CurrentWithdrawAmount_web.sendKeys("1");
		Thread.sleep(1000);
		Skrill_PaymentMode_web.click();
		Thread.sleep(3000);
		WithdrawBtn.click();

	}

	public void clickOnUserprofileLogout() throws InterruptedException {
		logoutBtn.click();
	}

	public WithdrawRequest clickwithdrawAmount() {
		withdrawAmount.click();
		return this;
	}

//-------------------------------------------------------

	@FindBy(xpath = "//button[text()=\"Withdraw Requests\"]")
	@CacheLookup
	public static WebElement withdrawrequest;

	public void setUserName(String uname) {
		txtUserName.click();
		txtUserName.sendKeys(uname);
	}

	public void setUserNameOrEmail(String unameOrEmail) {
		// txtUserNameOrEmail.click();
		txtUserNameOrEmail.sendKeys(unameOrEmail);
	}

	public WithdrawRequest clickwithdrawrequest() {
		bc.explicitWait(ldriver, withdrawrequest, 10);
		withdrawrequest.click();
		return this;
	}

	public WithdrawRequest clickActioneyeicon() {
		bc.explicitWait(ldriver, Actioneye, 5);
		Actioneye.click();
		return this;
	}

	public void clickforgetpwd() {
		forgetpwd.click();
	}

	public void clickPDFdownload() {
		PDFDownload.click();
	}

	public void clickXLSXdownload() {
		XLSXDownload.click();
	}

	public void clickHomePage() {
		CosmoLogo.click();
	}

	public void clickBacktologin() {
		Backtologin.click();
	}

	public void setPassword(String pwd) {
		txtPassword.click();
		txtPassword.sendKeys(pwd);
	}

	public void clearUserName() {
		txtUserName.clear();
	}

	public void clearPassword() {
		txtPassword.clear();
	}

	public void clickSubmit() {
		btnLogin.click();
	}

	public void clickResetLink() {
		btnResetLink.click();
	}

	public void clickLogout() throws InterruptedException {
		UserProfile.click();
		Thread.sleep(1000);
		lnkLogout.click();
	}

	public void ClickOnLogoutBtn() {
		lnkLogout.click();
	}

	public void clickpwdvisibility() {
		pwdvisibility.click();
	}

	public void clickpwdhidden() {
		pwdhidden.click();
	}
	
	@FindBy(xpath = "//button[text()='Select Player']")
	@CacheLookup
	private WebElement Select_Player;
	
	@FindBy(xpath = "(//mat-checkbox[contains(@class,'pristine')])[1]")
	@CacheLookup
	private WebElement Select_Checkbox;
	
	@FindBy(xpath = "//input[@formcontrolname='currentWithdrawalAmount']")
	@CacheLookup
	private WebElement currentWithdrawalAmount;
	
	@FindBy(xpath = "//input[@formcontrolname='tipTokens']")
	@CacheLookup
	private WebElement Withdraw_tipTokens;
	
	public  WithdrawRequest slectPlayer() {
		bc.explicitWait(ldriver, Select_Player, 10);
		Select_Player.click();
		return this;
	}
	
	public  WithdrawRequest slectCheckBox() {
		bc.explicitWait(ldriver, Select_Checkbox, 10);
		Select_Checkbox.click();
		return this;
	}
	
	public WithdrawRequest setCurrentWithdrawalAmount(String amount) {
		//currentWithdrawalAmount.clear();
		bc.fluentWait(ldriver, currentWithdrawalAmount, 10);
		currentWithdrawalAmount.click();
		currentWithdrawalAmount.sendKeys(amount);
		return this;		
	}
	
	public WithdrawRequest setWithdraw_tipTokens(String tipTokens) {
		bc.explicitWait(ldriver, Withdraw_tipTokens, 10);
		Withdraw_tipTokens.clear();
		Withdraw_tipTokens.click();
		Withdraw_tipTokens.sendKeys(tipTokens);
		return this;		
	}
	
	public WithdrawRequest clickOnWithdrawRequest_CreateNew() {
		bc.explicitWait(ldriver, Create_New, 50);
		Create_New.click();
		return this;		
	}

	@FindBy(xpath="//button[@title='Create New']")
	@CacheLookup
	private WebElement Create_New;
	
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
	
	@FindBy(xpath="//input[@formcontrolname='playerSkrillAccountEmail']")
	@CacheLookup
	public WebElement playerSkrillAccountEmail;
	
	@FindBy(xpath="//input[@formcontrolname='cashAppId']")
	@CacheLookup
	public WebElement cashAppId;
	
	@FindBy(xpath="//input[@formcontrolname='seamlessChexEmailId']")
	@CacheLookup
	public WebElement seamlessChexEmailId;

	@FindBy(xpath = "//span[text()=\"Save\"]")
	@CacheLookup
	private WebElement save;
	
	@FindBy(xpath = "(//button[@title='Description'])[1]")
	@CacheLookup
	private WebElement Description;
	 @FindBy(xpath="//mat-select[@formcontrolname=\"action\"]")  
	 @CacheLookup
	 private WebElement Action;
	 
	public WithdrawRequest approveWithdrawRequest() throws InterruptedException {
		Description.click();
		bc.explicitWait(ldriver, Action, 10);
		selectwithrawrequest(" Approve ");
		ldriver.findElement(By.xpath("//textarea[@formcontrolname=\"updatedNotes\"]")).sendKeys("By Auto");
		ldriver.findElement(By.xpath("//span[text()=\"Update\"]")).click();
		Thread.sleep(500);
		ldriver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		Thread.sleep(1500);
		if (ColumnSelectors.Status_Success.getColumnValues() != null) {
			test.pass("Successfully approved withraw request",extentScreenshot());}
		else {
			test.fail("Something wrong to create withdraw request", extentScreenshot());
		}
		Thread.sleep(2000);
		return this;	
	}
	
	public WithdrawRequest selectwithrawrequest(String pkg) throws InterruptedException 
   	{
    	Action.click();
    	Thread.sleep(300);
    	ldriver.findElement(By.xpath("//span[text()='"+pkg+"']")).click();
    	Thread.sleep(200);
   		return this;
     }
	
	public WithdrawRequest AdminWithdrawRequestUsing_PaymentMethod(String paymentMethod) throws InterruptedException {
		Actions act = new Actions(ldriver);

		if (paymentMethod == "skrill") {
			act.moveToElement(paymentProvider_Skrill).click().build().perform();
			Thread.sleep(500);
			playerSkrillAccountEmail.clear();
			playerSkrillAccountEmail.click();
			playerSkrillAccountEmail.sendKeys("itsupport@ombpmllp.com");
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "paysafe") {
			act.moveToElement(paymentProvider_paysafe).click().build().perform();
			Thread.sleep(500);
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "cashapp") {
			act.moveToElement(paymentProvider_cashapp).click().build().perform();
			Thread.sleep(500);
			cashAppId.clear();
			cashAppId.click();
			cashAppId.sendKeys("itsupport@ombpmllp.com");
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "bank_account") {
			act.moveToElement(paymentProvider_bank_account).click().build().perform();
			Thread.sleep(500);
			accountHolderName.sendKeys("HDFC Bank");
			accountNumber.sendKeys("4887464648");
			routingNumber.sendKeys("312");
			bankName.sendKeys("Test Bank");
			Thread.sleep(500);
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "seamless_chex") {
			act.moveToElement(paymentProvider_seamless_chex).click().build().perform();
			Thread.sleep(500);
			seamlessChexEmailId.clear();
			seamlessChexEmailId.click();
			seamlessChexEmailId.sendKeys("itsupport@ombpmllp.com");
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "manual") {
			act.moveToElement(paymentProvider_manual).click().build().perform();
			Thread.sleep(500);
			save.click();
			// WithdrawBtn.click();
		} else if (paymentMethod == "wallet") {
			act.moveToElement(paymentProvider_wallet).click().build().perform();
			Thread.sleep(500);
			save.click();
		} else if (paymentMethod == "PAYPER") {
			Thread.sleep(500);
			act.moveToElement(paymentProvider_PAYPER).click().build().perform();
			Thread.sleep(1000);
			save.click();
		}
		return this;

	}
}
