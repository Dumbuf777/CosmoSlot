package com.Cosmoslots.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.utilities.BaseClass;

public class PurchaseHistory {
	
	BaseClass bc = new BaseClass();
	
	WebDriver ldriver;
	
	public PurchaseHistory(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//img[@alt=\"Logo\"]")
	@CacheLookup
	WebElement CosmoLogo;
	
	@FindBy(xpath="//input[@formcontrolname=\"username\"]")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@name=\"userNameOrEmail\"]")
	@CacheLookup
	WebElement txtUserNameOrEmail;
	
	@FindBy(xpath="//input[@formcontrolname=\"password\"]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button//span[text()=\"Login\"]")
	@CacheLookup
	public WebElement btnLogin;

	@FindBy(xpath="//span[text()=\"Send Password Reset Link\"]")
	@CacheLookup
	WebElement btnResetLink;
	
	@FindBy(xpath="//span[@class=\"mat-button-wrapper\"]//span[contains(@class,\"user-name\")]//following-sibling::i")
	@CacheLookup
	WebElement UserProfile;
	
	@FindBy(xpath="//span//a[text()=\" Logout\"]")
	@CacheLookup
	WebElement lnkLogout;
	
	@FindBy(xpath="//span//mat-icon[text()=\"visibility\"]")
	@CacheLookup
	WebElement pwdvisibility;
	
	@FindBy(xpath="//span//mat-icon[text()=\"visibility_off\"]")
	@CacheLookup
	WebElement pwdhidden;
	
	@FindBy(xpath="//a[text()=\"Forgot password?\"]")
	@CacheLookup
	WebElement forgetpwd;
	
	@FindBy(xpath="//a[text()=\" Back to login\"]")
	@CacheLookup
	WebElement Backtologin;
	
	@FindBy(xpath = "//button[text()=\"Purchase History\"]")
    @CacheLookup
    public static WebElement purchasehistory;
	
	@FindBy(xpath = "//button[text()='Player Deletion History']")
    @CacheLookup
    public static WebElement PlayerDeletionHistory;
	
	@FindBy(xpath = "(//th[text()=\"Action\"]/following::tr//td[contains(@class,\"action\")]//i)[1]")
    @CacheLookup
    public static WebElement Actioneye;
	
	@FindBy(xpath = "//span[text()=\" PDF\"]")
    @CacheLookup
    public static WebElement PDFDownload;
	 
	@FindBy(xpath = " //span[text()=\" XLSX\"]")
    @CacheLookup
    public static WebElement XLSXDownload;
	
	@FindBy(xpath = "//h3[text()='View Purchased Details']")
	@CacheLookup
	public WebElement ViewPurchasedDetails_Header;
	
	
	public void setUserName(String uname)
	{	
		txtUserName.click();
		txtUserName.sendKeys(uname);
	}
	
	public void setUserNameOrEmail(String unameOrEmail)
	{	
		//txtUserNameOrEmail.click();
		txtUserNameOrEmail.sendKeys(unameOrEmail);
	}
	
	public PurchaseHistory clickPurchaseHistory() 
	{
		bc.explicitWait(ldriver, purchasehistory, 5);
		purchasehistory.click();
	//	bc.explicitWait(ldriver, cc.pu, 0);
		return this;
    }
	
	public PurchaseHistory clickOnPlayerDeletionHistory() 
	{
		PlayerDeletionHistory.click();
		return this;
    }
	public PurchaseHistory clickActioneyeicon() 
	{
		Actioneye.click();
		return this;
    }
	
	public void clickforgetpwd()
	{
		forgetpwd.click();
	}
	
	public void clickPDFdownload()
	{
		PDFDownload.click();
	}
	
	public void clickXLSXdownload()
	{
		XLSXDownload.click();
	}
	
	public void clickHomePage()
	{
		CosmoLogo.click();
	}
	
	public void clickBacktologin()
	{
		Backtologin.click();
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.click();
		txtPassword.sendKeys(pwd);
	}
	
	public void clearUserName()
	{
		txtUserName.clear();
	}
	
	public void clearPassword()
	{ 
		txtPassword.clear();
	}
	
	
	public void clickSubmit() 
	{
		btnLogin.click();	
	}
	
	public void clickResetLink()
	{
		btnResetLink.click();
	}
	
	public void clickLogout() throws InterruptedException
	{
		UserProfile.click();
		Thread.sleep(1000);
		lnkLogout.click();
	}
	
	public void clickpwdvisibility()
	{
		pwdvisibility.click();
	}
	public void clickpwdhidden()
	{
		pwdhidden.click();
	}
//	public String getPassword()
//	{
//		return txtPassword.getText();
//	}	
	
//--------------------------------Shree---------------------------
	@FindBy(xpath = "//mat-radio-button[@value='payment']//child::span[@class='mat-radio-container']")
	@CacheLookup
	private WebElement paymentRadioBtn;

	public  PurchaseHistory ClickonpaymentRadioBtn() {
		paymentRadioBtn.click();
		return this;
	}

	@FindBy(xpath = "//mat-radio-button[@value='skrill-initiated']//child::span[@class='mat-radio-container']")
	@CacheLookup
	private WebElement SkrillInitiatedRadioBtn;

	public  PurchaseHistory ClickonSkrillInitiatedRadioBtn() {
		SkrillInitiatedRadioBtn.click();
		return this;
	}
	
	@FindBy(xpath = "//mat-radio-button[@value='paysafe-initiated']//child::span[@class='mat-radio-container']")
	@CacheLookup
	private WebElement PaysafeInitiatedRadioBtn;

	public  PurchaseHistory ClickonPaysafeInitiatedRadioBtn() {
		PaysafeInitiatedRadioBtn.click();
		return this;
	}
	
	@FindBy(xpath = "//mat-radio-button[@value='zen-initiated']//child::span[@class='mat-radio-container']")
	@CacheLookup
	private WebElement BankcardInitiatedRadioBtn;

	public  PurchaseHistory ClickonBankcardInitiatedRadioBtn() {
		BankcardInitiatedRadioBtn.click();
		return this;
	}

}









