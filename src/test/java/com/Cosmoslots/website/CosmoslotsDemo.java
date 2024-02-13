package com.Cosmoslots.website;


import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.Cosmoslots.utilities.ReadConfig;

public class CosmoslotsDemo {
	
	static ReadConfig readconfig=new ReadConfig();

	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Cosmoslots\\Drivers\\chromedriver.exe");
//	        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
//	        deviceMetrics.put("width", 1024);  // device width
//	        deviceMetrics.put("height", 768); // device height
//	        deviceMetrics.put("pixelRatio", 2.0);
//	        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
//	        mobileEmulation.put("deviceMetrics", deviceMetrics);
//	        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
//	        ChromeOptions options = new ChromeOptions();
//	        options.setExperimentalOption("mobileEmulation", mobileEmulation);
//	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	        WebDriver driver = new ChromeDriver(options);
	    
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ROTATABLE, true);
		capabilities.setCapability("deviceOrientation","landscape");
		WebDriver driver = new ChromeDriver(capabilities);
		
		
		
		
//		Calendar cal = Calendar.getInstance(); 
//        Date Date= new Date();
//        Date now = cal.getTime();
//        cal.add(Calendar.SECOND, 60);
//        Date later = cal.getTime();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm ");
//        String date1= dateFormat.format(Date);
//		System.out.println(date1);
//        System.out.println("Now: " + now);
//        
//        System.out.println("Later: " + later);
		
//   
//		Date Date1= new Date();
//		Calendar calendar = Calendar.getInstance();
//	    calendar.setTime(Date);
//	    calendar.add(Calendar.SECOND, 60);
//	     DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		String date11= dateFormat.format(Date1);
//		System.out.println(date1);

		//String username = readconfig.getUsername();
	//	String password = readconfig.getPassword();
//		String Status = "";
//		String actualStatus = "Success";
//			
		
		
//		driver.get(readconfig.getWebURL());
//		driver.manage().window().maximize();
//        Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//button[contains(text(),\"Sign In\")]")).click();
//        Thread.sleep(2000);
//   
//        driver.findElement(By.xpath("(//input[@formcontrolname=\"email\"])[2]")).sendKeys("shrikrushna.sonkar@gameium.com");
//        driver.findElement(By.xpath("//input[@formcontrolname=\"email\"]//following::div//input[@formcontrolname=\"password\"]")).sendKeys("mailto:Gameium@1234");
//   
//        driver.findElement(By.xpath("//div[@class='auth-form']//child::button[contains(text(),\"Sign In\")]")).click();
//        Thread.sleep(5000);
//		//Thread.sleep(1000);
//        //------------------------------------------------------------------------------------
//		driver.findElement(By.xpath("//a[@role=\"button\"]//span[@class=\"userName\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Profile']")).click();
//		Thread.sleep(3000);
//
//		driver.findElement(By.xpath("//div[@role='tablist']//button[text()='Withdraw']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[text()='Withdraw Amount']")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@formcontrolname='currentWithdrawalAmount']")).sendKeys("1");
//		driver.findElement(By.xpath("//div[@class='radioGroup']//label[text()=\" Skrill \"]")).click();
//		driver.findElement(By.xpath("//div[@class='withdraw-form-block']//button[text()='Withdraw']")).click();
//        Thread.sleep(2000);
//
//	////table[@class='table cs-table']//tbody//tr[1]//td[6]
//		String exceptedStatus = driver.findElement(By.xpath("//*[@id=\"nav-withdrawal\"]/app-withdrawal/div/div/div[2]/table/tbody/tr[1]/td[6]/span")).getText();
//		System.out.println(exceptedStatus);
//		//Assert.assertEquals(exceptedStatus, actualStatus,"Success Status is Not verified");
//		if(actualStatus.equals(exceptedStatus))
//		{
//			//System.out.println("Success Status is verified");
//			Status="Success";
//			
//		}else {
//			//System.out.println("Pending  Status is  verified");
//			Status="Pending";
//		}
//		
//		System.out.println("Withdraw Payment  Status is  "+Status);
//		//driver.close();
//		Thread.sleep(5000);
////--------Support
//		driver.findElement(By.xpath("//div[@role='tablist']//button[contains(text(),'Support')]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[contains(text(),'New Request')]")).click();
//		Thread.sleep(1000);
//	
//		String actualStatus1 = "Review";
//		
//		driver.findElement(By.xpath("//select[@formcontrolname='requestType']//child::option[contains(text(),'Review')]")).click();
////
////		WebElement newrequest = driver.findElement(By.xpath("//select[@formcontrolname='requestType']"));
////
////		Select s= new Select(newrequest);
//// 		s.selectByVisibleText("Review");
//
//		driver.findElement(By.xpath("//input[@formcontrolname='requestTitle']")).sendKeys("review");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//textarea[@formcontrolname='requestComment']")).sendKeys("review");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div[@class='supportrequest-form-block']//child::button[contains(text(),'Submit')]")).click();
//		Thread.sleep(1000);
//		String supporttype = driver.findElement(By.xpath("//*[@id=\"nav-support\"]/app-support/div/div/div[2]/table/tbody/tr[1]/td[3]")).getText();
//        System.out.println(supporttype);
//        String TickettId = driver.findElement(By.xpath("//*[@id=\"nav-support\"]/app-support/div/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
//        System.out.println(TickettId);
//       
//      //------Support Page-------  
//		Thread.sleep(2000);        
//        driver.findElement(By.xpath("//button[@id=\"nav-chat-tab\"]")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//i[@class='fa fa-eye']")).click();
//		Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//div//input[@placeholder='Enter a new message']")).sendKeys("Test");
//        
//		Thread.sleep(2000);
//
//		driver.findElement(By.xpath("//button[@type='button']//i[@class='fa fa-paper-plane']")).click();
		
		 //Navigate to admin page
        driver.navigate().to(readconfig.getAdminURL());
		driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(readconfig.getUsername());
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(readconfig.getPassword());
        driver.findElement(By.xpath("//button//span[text()='Login']")).click();
        driver.manage().window().maximize();
		Thread.sleep(3000);
		System.out.println(driver.manage().window().getSize());
		//Dimension d= new Dimension(0, 0);
		Thread.sleep(5000);
        driver.findElement(By.xpath("//span[normalize-space()='User Management']//i[@class='ri-arrow-down-s-line']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[normalize-space()='Access Control']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[@title='Edit'])[1]")).click();
        Thread.sleep(1000);
        WebElement ele = driver.findElement(By.xpath("(//h6[text()='Most Spent Tokens']//following::input[@aria-checked='true'])[1]"));
       System.out.println( ele.getSize());
//        driver.findElement(By.xpath("(//div//following::i[@class='ri-user-settings-line'])[1]")).click();
//		Thread.sleep(5000);
//        WebElement searchId = driver.findElement(By.xpath("//input[@id='mat-input-2']"));
//        searchId.click();
//        searchId.sendKeys(TickettId);
//        
//        driver.findElement(By.xpath("//span[contains(text(),'Player Management ')]//span[@class='menuArrowDown']")).click();
//		Thread.sleep(1000);
//        driver.findElement(By.xpath("//div//button[contains(text(),'Player Profile')]")).click();
//		Thread.sleep(3000);
//        driver.findElement(By.xpath("(//a[@title='View'])[1]")).click();
//        Thread.sleep(1000);
//        WebElement emailVerification = driver.findElement(By.xpath("//i[@class='ri-check-double-line']"));
//        System.out.println(emailVerification);

  // Pagination of guest player
        
//		 driver.findElement(By.xpath("//span[contains(text(),'Player Management ')]//span[@class='menuArrowDown']")).click();
//		 Thread.sleep(1000);
//		 driver.findElement(By.xpath("//button[normalize-space()='Guest Players']")).click();
//		 Thread.sleep(5000);
//		 
//		 
//		
//        int paginationSize=	 driver.findElements(By.xpath("//div[@class='mat-paginator-range-label']")).size();
//        System.out.println(paginationSize);
//
//		 String pages = driver.findElement(By.xpath("//div[@class='mat-paginator-range-label']")).getText().split(" ")[4];
//		 System.out.println(pages);
//		 
//			List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='mat-paginator-range-label']"));
//
//				for (int i = 0; i < paginationSize; i++) {
//					for (WebElement name : pagination) {
//						System.out.println(name);
//						
//					}
//					driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();
//					
//				}
		
//		driver.findElement(By.xpath("//span[text()='Game Configurator']//i[@class='ri-arrow-down-s-line']")).click();
//		 Thread.sleep(500);
//		 driver.findElement(By.xpath("//button[text()='Slot Game Tools']")).click();
//		 Thread.sleep(500);
//		 driver.findElement(By.xpath("//button[text()='Symbol Type']")).click();
//		 Thread.sleep(500);
//		 
//		 for(int i=0;i<=4;i++ ) {
//			 String head = driver.findElement(By.xpath("//thead[@role=\"rowgroup\"]//th["+i+"]")).getText();
//
//			 System.out.println(head);
//		 }
		
		
			} 

	}


