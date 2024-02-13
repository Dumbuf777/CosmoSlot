package com.Cosmoslots.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfiles {

	WebDriver ldriver;
	
	public MyProfiles(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()=\" My Profile\"]")
	@CacheLookup
	public static WebElement MyProfile;
	
	@FindBy(xpath="//mat-icon[text()=\"cloud_upload\"]")
	@CacheLookup
	public static WebElement ImgUpload;
	
	@FindBy(xpath="//span[@class=\"mat-button-wrapper\"]//span[contains(@class,\"user-name\")]//following-sibling::i")
	@CacheLookup
	public static WebElement UserProfile;
	
	@FindBy(xpath="//h3[text()=\"Update Profile\"]")
	@CacheLookup
	static	WebElement UpdateProfiletext;
	
	@FindBy(xpath="//img[@alt=\"Logo\"]")
	@CacheLookup
	public static WebElement CosmoLogo;
	
	@FindBy(xpath="//input[@formcontrolname=\"firstName\"]")
	@CacheLookup
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@formcontrolname=\"lastName\"]")
	@CacheLookup
	public static WebElement lastName;
	
	@FindBy(xpath="//input[@formcontrolname=\"username\"]")
	@CacheLookup
	public static WebElement userName;
	
	@FindBy(xpath="//input[@formcontrolname=\"email\"]")
	@CacheLookup
	public static WebElement email;
	
	@FindBy(xpath="//mat-select[@formcontrolname=\"dialCode\"]")
	@CacheLookup
	public static WebElement dialCode;
	
	@FindBy(xpath="//input[@formcontrolname=\"phone\"]")
	@CacheLookup
	public static WebElement phone;
	
	@FindBy(xpath="//input[@formcontrolname=\"city\"]")
	@CacheLookup
	public static WebElement city;
	
	@FindBy(xpath="//input[@formcontrolname=\"state\"]")
	@CacheLookup
	public static WebElement state;
	
	@FindBy(xpath="//input[@formcontrolname=\"country\"]")
	@CacheLookup
	public static WebElement country;
	
	
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
      
//    @FindBy(id = "mat-select-4")
//    @CacheLookup
//    private WebElement Lobby;
    
    //driver.findElement(By.id("")).click();
    //driver.findElement(By.xpath("//mat-option[@id='mat-option-35']/span")).click();
    
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
    
    @FindBy(xpath = "//mat-label[text()=\"Country\"]//preceding::span/span[contains(text(),\" \")]")
    @CacheLookup
    public static WebElement Country;
    
    @FindBy(id = "//mat-label[text()=\"Country\"]//following::span/span")
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
   
    @FindBy(xpath = "//input[@formcontrolname=\"city\"]")
    @CacheLookup
    private WebElement City;
    
    @FindBy(xpath = "//input[@formcontrolname=\"zipCode\"]")
    @CacheLookup
    private WebElement ZipCode;
    
    @FindBy(xpath = "//span[text()=\"Save\"]")
    @CacheLookup
    public static WebElement save;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Created At\")]")
	@CacheLookup
	public static WebElement CreatedAt;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Updated At\")]")
	@CacheLookup
	public static WebElement UpdatedAt;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Role\")]")
	@CacheLookup
	public static WebElement Role;
	
	@FindBy(xpath="//mat-label[contains(text(),\"User Type\")]")
	@CacheLookup
	public static WebElement Usertype;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Store Acount\")]")
	@CacheLookup
	public static WebElement StoreAccount;
	
	@FindBy(xpath="//mat-label[contains(text(),\"Parent User\")]")
	@CacheLookup
	public static WebElement ParentUser;
	
	@FindBy(xpath = "//button/span[text()=\"Search\"]")
    @CacheLookup
	private WebElement Search;
	
	@FindBy(xpath="//input[@type=\"file\"]")  ////mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement Create_icon;
	
	@FindBy(xpath="//mat-slide-toggle[@formcontrolname=\"chatNotification\"]")  ////mat-icon[text()=\"cloud_upload\"]
	@CacheLookup
	WebElement chatnotification;
	

	@FindBy(xpath = "//button[contains(text(),'Login Footprints')]")
    @CacheLookup
	private WebElement LoginFootprintsBtn;
	
	public MyProfiles clickOnLoginFootprints()
	{
		LoginFootprintsBtn.click();
		return this;
	}
	
	
	
	public static void clickMyprofile()
	{
		MyProfile.click();
	}
	
	public static void clickUserprofile()
	{
		UserProfile.click();
		
	}
	
	public static void clickHomePage()
	{
		CosmoLogo.click();
	}
	
	public void Updatefirstname(String fname)
	{
		firstName.sendKeys(fname);
	}
	
	public void Updatelastname(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void UploadImg(String Path)
	{
		ImgUpload.sendKeys(Path);
	}
    
    public MyProfiles setSearchTextField(String searchValue) {
        Search.sendKeys(searchValue);
        return this;
    }
    
    public MyProfiles setFirstName(String firstname) {
        FirstName.sendKeys(firstname);
        return this;
    }
    
    public MyProfiles setLastName(String lastname) {
        LastName.sendKeys(lastname);
        return this;
    }
    
    public MyProfiles setDisplayName(String displayname) {
        DisplayName.sendKeys(displayname);
        return this;
    }
    
    public MyProfiles setEmail(String email) {
        Email.sendKeys(email);
        return this;
    }
    
    public MyProfiles setPhone(String phone) {
        Phone.sendKeys(phone);
        return this;
    }
    
    public MyProfiles setCity(String city) {
        City.sendKeys(city);
        return this;
    }
    
    public MyProfiles Chatnotification() {
    	chatnotification.click();
        return this;
    }
    
    public MyProfiles setZipcode(String zipcode) {
    	ZipCode.sendKeys(zipcode);
        return this;
    }
	
	public MyProfiles setDialCode(String dialcode) {
    	DialCode.click();
        DialCodeinput.sendKeys(dialcode);
        ldriver.findElement(By.xpath("//mat-option//span[text()=\"+91\"]")).click();
        return this;
    }
    
    public MyProfiles setCountry(String country) throws InterruptedException {
    	Country.click();
    	//Country.sendKeys(country);
    	Thread.sleep(300);
    	SetCountry.sendKeys(country);
        //SetState.sendKeys(Keys.DOWN,Keys.ENTER);
        //ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"India\"]")).click();
        return this;
    }
    
    public MyProfiles setState(String state) throws InterruptedException {
    	State.click();
    	Thread.sleep(300);
        SetState.sendKeys(state);
        //Thread.sleep(300);
        //SetState.sendKeys(Keys.DOWN,Keys.ENTER);
        //ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
        ldriver.findElement(By.xpath("//mat-option/span/span[text()=\"Gujarat\"]")).click();
        return this;
    }
    
    
    
    public MyProfiles SetNewsicon(String name)
   	{
   		//((JavascriptExecutor) ldriver).executeScript(" return document.getElementsByName('//input[@name=\"fileHidden\"]').item(0).value = '';");
   		//String s=((JavascriptExecutor) ldriver).executeScript(" return document.getElementsByName('//input[@name=\"fileHidden\').value").toString(); 
   		//Create_icon.clear();
   		Create_icon.sendKeys(name);
   	//	Create_icon.click();
   		return this;
   	}
	
//	public String getPassword()
//	{
//		return txtPassword.getText();
//	}	
	
}









