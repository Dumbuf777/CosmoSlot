package com.Cosmoslots.utilities;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Cosmoslots.pageObjects.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ExtentManager{

	static ReadConfig readconfig=new ReadConfig();
	public String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	public String AdminURL=readconfig.getAdminURL();
	public String WebURL=readconfig.getWebURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public String GameiumUsername=readconfig.getGameiumUsername();
	public String MasterUsername=readconfig.getMasterUsername();
	public String DistributorUsername=readconfig.getDistributorUsername();
	public String SubdistributorUsername=readconfig.getSubdistributorUsername();
    public String StoreUsername=readconfig.getStoreUsername();
    public String POSUsername=readconfig.getPOSUsername();
	public String Playerid=readconfig.getPlayerId();
	public String Playerpass=readconfig.getPlayerPass();
	public static String UploadImage=readconfig.getImgUrl();
	public static String UploadImage1=readconfig.getImgUrl1();
	public String baseAPIURL=readconfig.getBaseAPIURL();
//	public static WebDriver driver;
//	public ExtentReports extent;
//	public static ExtentTest test;
//	public static Logger logger;

	@Parameters("browser")
	@BeforeSuite(groups = {"admin","website"})
	public void setup(String br) throws InterruptedException, IOException {
		Dimension si = new Dimension(4000, 1024);
		logger = Logger.getLogger("Cosmoslots");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("window-size=1920,1080");
            options.addArguments("-incognito");
//            options.addArguments("start-maximized");
//            options.addArguments("disable-infobars");
//            options.addArguments("--disable-extensions");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--no-sandbox");
			//System.setProperty("webdriver.chrome.driver", readconfig.getChromePath()); 
			driver = new ChromeDriver(options);

		} else if (br.equals("firefox")) {
			 WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			 WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}else if (br.equals("opera")) {
			 WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.opera.driver", readconfig.getOperaPath());
			driver = new OperaDriver();
		} else if (br.equals("edge")) {
			 WebDriverManager.edgedriver().setup();
			 //EdgeOptions options = new EdgeOptions();
			 //System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Maximize the screen
		driver.manage().window().maximize();
		//Delete all the cookies
		driver.manage().deleteAllCookies();		
		//PageLoad TimeOuts
		driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
		//Launching the URL
		driver.get(AdminURL);
		extentSetup();
		//cosmoslot
		Adminlogin(username);
		//boomwins
		//Admin_login(username, "Password@1234");
		openNewTab(driver, WebURL);
		gotoTab(driver, 1);

		WebsiteLogin(Playerid, Playerpass);
		gotoTab(driver, 0);

	}
	
    @BeforeClass
    public void extentsetup()
    {
	extentSetup();
    }
    
    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Scenario FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
           
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Scenario - PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Scenario SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
    
	@AfterClass
	public void reportflush() {
		extent.flush();
	}

	@AfterSuite()
	public void teardown() {
		driver.quit();	
	}
	
	public void Adminlogin(String user) throws InterruptedException, IOException
	{
		test=extentCreateTest("Login in Admin");	
		LoginPage lp=new LoginPage(driver);
	
		lp.setUserName(user);
		
		lp.setPassword(password);
		//test.info("Entered password = <b>"+password+"</b>");
		
		Thread.sleep(1000);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if (driver.findElements(By.xpath("//span[text()=\"Player Management \"]")).size() > 0) {
			test.pass("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			test.fail("Login test failed");
		}
	}
	
	public void Admin_login(String uname, String pass) throws InterruptedException, IOException
	{
		test=extentCreateTest("Login in GameiumAdmin");	
		test.info("URL is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(uname);
		test.info("Entered username = <b>"+uname+"</b>");
		
		lp.setPassword(pass);
		test.info("Entered password = <b>"+pass+"</b>");
		
		Thread.sleep(1000);
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		if (driver.findElements(By.xpath("//span[text()=\"Player Management \"]")).size() > 0) {
			test.pass("Login test passed",extentScreenshot());
		}
		else
		{
			test.fail("Login test failed",extentScreenshot());
		}
	}
	
	public static void WebsiteLogin(String username,String pass) throws InterruptedException {
		gotoTab(driver, 1);
        driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
        Thread.sleep(2000);
   
        driver.findElement(By.xpath("(//input[@formcontrolname=\"email\"])[2]")).sendKeys(username);
        driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]//following::div//input[@formcontrolname=\"password\"]")).sendKeys(pass);
   
        driver.findElement(By.xpath("//div[@class='auth-form']//child::button[contains(text(),\"Sign In\")]")).click();
        Thread.sleep(7000);
 
    }
	
//    public ExtentReports extentSetup() {
//
//			String repName=getClass().getSimpleName()+".html";
//			
//			extent = new ExtentReports();
//			String reportPath = ".//reports//"+repName;
//			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
//			reporter.config().setReportName("Cosmoslots");
//			reporter.config().setDocumentTitle("Cosmoslots Automation");
//			reporter.config().setTheme(Theme.DARK);
//
//			Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
//
//			extent.attachReporter(reporter);
//			extent.setSystemInfo("Automation Engineer", "Shrikrsuhna Sonkar");
//			extent.setSystemInfo("Operating System", System.getProperty("os.name"));
//			extent.setSystemInfo("Operating System Version", System.getProperty("os.version"));
//			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
//			extent.setSystemInfo("Browser", capabilities.getBrowserName());
//			extent.setSystemInfo("Browser Version", capabilities.getVersion());
//	       // extent.setReportUsesManualConfiguration(true);
//
//			return extent;
//		}
		
	
	public static void openNewTab(WebDriver driver,String url) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('"+url+"','_blank');");
        Thread.sleep(100);
    }

    public static void gotoTab(WebDriver driver, int tabIndex) throws InterruptedException {
        List<String> winHandles = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(500);
        driver.switchTo().window(winHandles.get(tabIndex));
    }
	
//	public ExtentTest extentCreateTest(String testName) {
//		test = extent.createTest(testName);
//		return test;
//	}
	
	


//	public void extentReportOpen() throws IOException {
//		Desktop.getDesktop().browse(new File(System.getProperty("user.dir") + "//reports//report.html").toURI());
//	}

//	public String takeScreenshot() {
//		String source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//		return source;
//	}
//	

//	public Media extentScreenshot() {
//		Media media = MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot()).build();
//		return media;
//	}
//	
	public void click(WebDriver driver,WebElement ele) {
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");	
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(6);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(1);
		return (generatedString2);
	}
	
	public static String randomNum(int num) {
		String generatedString2 = RandomStringUtils.randomNumeric(num);
		return (generatedString2);
	}
	
//	public void GetCurrentDate(String date) {
//		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//		Date Date= new Date();
//		String date1= dateFormat.format(Date);
//	}
	public static String generateOTP() {
		int randomPin   =(int)(Math.random()*9000)+1000;
		String otp  =String.valueOf(randomPin);
		return otp;
	}
	
	public String randomSpecial(int count)
	{
	    String characters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	    String generatedString = RandomStringUtils.random(count, characters);
	    return generatedString;
	}

	public String Fakefirstname()
	{
		Faker faker = new Faker();
		//String name = faker.name().fullName();
		//String firstName = faker.name().firstName();
		//String firstName =  faker.rickAndMorty().character();
		String firstName = faker.artist().name();
		return firstName.replaceAll("\\s.*", "");
	}
	
	public String Fakelastname()
	{
		Faker faker = new Faker();
		//String name = faker.name().fullName();
		//String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		return lastName;
	}
	
	public String FakeEmail()
	{
		Faker faker = new Faker();
		//String name = faker.name().fullName();
		//String firstName = faker.name().firstName();
		//String lastName = faker.name().lastName();
		String email = faker.internet().emailAddress();
		
		return email;
		
	}
	
	public String FakerandamNum() {
	Random rand = new Random(); 
    // Generate 3digit random integers in range 0 to 999 
    int rand1 = rand.nextInt(1000); 
    // Generate 2digit random integers in range 0 to 99 
    int rand2 = rand.nextInt(100); 
    String textfortexbox=Integer.toString(rand1)+"-"+Integer.toString(rand2);
    return textfortexbox;
	}
	
	public String Fakephonenumber()
	{
		Faker faker = new Faker();
		String phonenum = faker.phoneNumber().phoneNumber();
		return phonenum;
	}
	
	
	public void PageReload()
	{
		driver.navigate().refresh();
		//driver.get(driver.getWindowHandle().toString().);
	}
	
	public void CloseCurrentTab() {
		driver.close();
	}
	
	public void PageScrollToEnd() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)
	    driver; js.executeScript("window.scrollBy(25000,0)", "");
	    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
	    }
	
	public void explicitWait(WebDriver driver, WebElement element, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        //element.click();
	    }catch(Exception e) {
	    }
	}
	//sendkeys method
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value){
	new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
	}
	//clickable method declared explicitly
	public static void clickOn(WebDriver driver1, WebElement element, int timeout){
	new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));// Expectedcondition for the element to be clickable
	element.click();
	}
	public void implicitWait(WebDriver driver, int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	
	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("cosmo" + generatedString);
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("slot" + generatedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return ("User" + generatedString);
	}

	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return (generatedString + "@yopmail.com");
	}
	
	public static String getPhoneNumber() {
		String generatedPhoneNum = RandomStringUtils.randomNumeric(10);
		return (generatedPhoneNum);
	}


	public static String getPassword() {
		String generatedString = "Gameium@1234";
		return (generatedString);
	}
	
	
//	@BeforeSuite(alwaysRun = true)
//	public void globalSetup() {
//		//logger.info("************************** Test Execution Started ************************************");
//		//TestProperties.loadAllPropertie();
//	}

	
	
}
