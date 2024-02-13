package com.Cosmoslots.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.utilities.BaseClass;

public class LoginPage {

	WebDriver ldriver;
	BaseClass bc = new BaseClass();
	
	public LoginPage(WebDriver rdriver)
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
	
	@FindBy(xpath="//span//a[text()=\" My Profile\"]")
	@CacheLookup
	private WebElement  UserMyProfile;
	
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
	
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement WebsiteSignIn;
	
	@FindBy(xpath="(//input[@formcontrolname='email'])[2]")
	@CacheLookup
	private WebElement WebsiteEmailId;

	@FindBy(xpath="//input[@formcontrolname='email']//following::div//input[@formcontrolname='password']")
	@CacheLookup
	private WebElement WebsitePassword;
	
	@FindBy(xpath="//div[@class='auth-form']//child::button[contains(text(),'Sign In')]")
	@CacheLookup
	private WebElement WebsiteSignInBtn;
	
	

	public LoginPage ClickonUserAdminProfile()
	{
		UserProfile.click();
		return this;
	}
	
	public LoginPage ClickonUserMyProfile() throws InterruptedException
	{

		UserMyProfile.click();
		return this;
	}
	
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
	
	public void clickforgetpwd()
	{
		forgetpwd.click();
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
		bc.explicitWait(ldriver, UserProfile, 30);
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
	
}









