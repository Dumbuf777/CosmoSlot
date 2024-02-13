package com.Cosmoslots.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;


public class FishGameScenario  {

	//BaseClass bclass=new BaseClass();
	public static int PlayerLogin=5;
	public static String websiteUrl="https://qa-cpweb-admin.cosmoslots.tech/";	
	public static String[] strArray = new String[] {"CS-1610","CS-1607","CS-1602","CS-1601","CS-1573","CS-1571","CS-1564","CS-1562","CS-1556","CS-1616",};
	static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	//public void A_Player_Login() throws InterruptedException, IOException 
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		//gotoTab(driver, 1);
		//PlayerLogout();
		  System.setProperty("webdriver.chrome.driver","./Drivers//chromedriver.exe");
		  ChromeOptions op = new ChromeOptions();
		  op.addArguments("--disable-notifications");		 
	      driver=new ChromeDriver(op);
//	     System.setProperty("webdriver.gecko.driver","./Drivers//geckodriver.exe");
//		 FirefoxOptions options = new FirefoxOptions();
//		 options.addArguments("--disable-notifications");
//		  driver = new FirefoxDriver();
	      driver.get(websiteUrl);
	      driver.manage().window().maximize();
	        
	      Thread.sleep(2000);
	        
		 for(int i=0; i<PlayerLogin; i++)
		 { 			 
			 System.out.println("player id->"+strArray[i]);
			 WebsiteLogin(strArray[i],"Gameium@1234");
			 WebsiteGame("Ocean Bombard");			 
			 openNewTab(driver);
			 gotoTab(driver, i+1,websiteUrl);			  		 
		 }	 
	  }
	
	 public static void WebsiteLogin(String username,String pass) throws InterruptedException {
	    
		 GuestPlayers gp=new GuestPlayers(driver);
	     WithdrawRequest wr=new WithdrawRequest(driver);
	     PlayerProfile pp = new PlayerProfile(driver);
	     
		 if(driver.findElements(By.xpath("//div[@class='dropdown userDropDownBlock']")).size()>0)
		    {
		        	wr.clickOnUserprofile();
		 	        Thread.sleep(2000);
		        	Thread.sleep(1000);
		        	gp.ClickOnLogout();	 
		        	Thread.sleep(3000);
		        	WebsiteLoginCheck(username, pass); 	       
	 	    }
		    else
		    {
		    	WebsiteLoginCheck(username, pass); 	    
	  	    } 
		 
		
        Thread.sleep(3000);
        driver.navigate().refresh();
 
    }
	 public static void WebsiteLoginCheck(String username,String pass) throws InterruptedException 
	 {
		 Thread.sleep(1000);
	        driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("(//input[@formcontrolname=\"email\"])[2]")).clear();
	        driver.findElement(By.xpath("(//input[@formcontrolname=\"email\"])[2]")).sendKeys(username);
	        driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]//following::div//input[@formcontrolname=\"password\"]")).clear();
	        driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]//following::div//input[@formcontrolname=\"password\"]")).sendKeys(pass);
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//input[@formcontrolname=\"rememberMe\"]")).click();
	        if(driver.findElements(By.xpath("//button[text()='Confirm']")).size()>0)
	        { 
	        	 Thread.sleep(5000);
	        	driver.findElement(By.xpath("//button[text()='Confirm']")).click(); }
	        driver.findElement(By.xpath("//div[@class='auth-form']//child::button[contains(text(),\"Sign In\")]")).click();
	 }
	 
	 public static void WebsiteGame(String gamename) throws InterruptedException 
		{
		    Actions action = new Actions(driver);
		   	 Thread.sleep(6000);
			driver.findElement(By.xpath("//a[text()='Games']")).click();
			Thread.sleep(3000);
			action.moveToElement(driver.findElement(By.xpath("//h6[text()=\"Get it now on your phone\"]"))).build().perform();
			Thread.sleep(500);
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			WebElement ele = driver.findElement(By.xpath("//h2[text()=\" Fish Game\"]"));
//			js.executeScript("arguments[0].scrollIntoView()", ele);
//			Thread.sleep(2000);
//			

//			action.moveToElement(driver.findElement(By.xpath("(//h5[normalize-space()='" + gamename + "']//preceding::img[@alt='User'])[1]"))).perform();
//			action.moveToElement(driver.findElement(By.xpath("(//h5[normalize-space()='" + gamename + "']//preceding::img[@alt='User'])[1]"))).perform();

		//	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//h5[normalize-space()='" + gamename + "']//preceding::img[@alt='User'])[1]")));
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
			driver.findElement(By.xpath("//h5[normalize-space()='" + gamename + "']//preceding::span[1]")).click();
//			Thread.sleep(3000);

		}
		  	 
	 public static void openNewTab(WebDriver driver) throws InterruptedException, AWTException {
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("window.open('','_blank');");
//	        Thread.sleep(100);
		 
		 String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
	      // open the link in new tab, Keys.Chord string passed to sendKeys
	      driver.findElement(By.xpath("(//a[text()='Games'])[1]")).sendKeys(clicklnk);
	      
		
	        
//			 Actions act = new Actions(driver);
//			 act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
//			 driver.get(websiteUrl);			 
			 
	    }
	 
	 public static void gotoTab(WebDriver driver, int tabIndex,String url) throws InterruptedException {
	        List<String> winHandles = new ArrayList<String>(driver.getWindowHandles());
	        Thread.sleep(500);
	        driver.switchTo().window(winHandles.get(tabIndex));
	        driver.get(url);
	    }
	 
	 public static void PlayerLogout() throws InterruptedException, IOException 
		{	
			WithdrawRequest wr=new WithdrawRequest(driver);
			PlayerProfile pp= new PlayerProfile(driver);
			Thread.sleep(1000); 
			//wr.clickOnUserprofile();
			driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']")).click();		
			Thread.sleep(1000); 
		    //pp.clickOnLogoutBtn();
			driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();	
		    
		    Thread.sleep(2000);
		}
}

