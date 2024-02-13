package com.Cosmoslots.website;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.*;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.utilities.BaseClass;
import com.Cosmoslots.utilities.ReadConfig;


public class MultipleWindow {
	
//	static ReadConfig readconfig=new ReadConfig();
	public static void main(String[] args) throws ClassNotFoundException   {
		
	
		 try {
			 String path = "D:\\Automation\\Cosmo_automation\\Configuration\\userCredentials.xlsx";
				FileInputStream fis = new FileInputStream(path);
				Workbook workbook = new XSSFWorkbook(fis);
				 Sheet sheet = workbook.getSheetAt(0);
				int lastRow = sheet.getLastRowNum();
				System.out.println("Last row- "+lastRow);
				for(int i=0; i<=lastRow; i++){
				 Row row = sheet.getRow(i);
				int lastCell = row.getLastCellNum();
				for(int j=0; j<lastCell; j++){
				 Cell cell = row.getCell(j);
				String value = cell.getStringCellValue();
				System.out.println(value);
				}
				System.out.println();
				}
	        } catch (Exception e) {
	            System.out.println("Error: Unable to connect to the database!");
	            e.printStackTrace();
	        }
	
//	public static void main(String[] args) throws InterruptedException, AWTException {
//       // WebDriverManager.chromedriver().setup();
//		String username=readconfig.getUsername();
//		  String password=readconfig.getPassword();
//		
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\pankaj.kachhadiya\\Downloads\\cosmoslots-automation--6-10\\cosmoslots-automation\\Drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//      //  driver.get("https://www.amazon.co.uk/");
//        driver.get("https://qa-casino-admin.cosmoslots.tech");
//        driver.manage().window().maximize();
//        
//        Thread.sleep(3000);
//
//       // WebElement element = driver.findElement(By.xpath("//a[.='Kindle Books']"));
//        //Actions act = new Actions(driver);
////        act.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
//  
//        
//        LoginPage lp=new LoginPage(driver);
//		//lp.ClickDontHaveZzure();
//		lp.setUserName(username);
////		test.info("Entered username = <b>"+username+"</b>");
//		
//		lp.setPassword(password);
////		test.info("Entered password = <b>"+password+"</b>");
//		
//		Thread.sleep(1000);
//		lp.clickSubmit();
//		
//		Thread.sleep(5000);
//		 driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
//		 Thread.sleep(300);
//		 driver.findElement(By.xpath("//button[contains(text(),\"Player Profile\")]")).click();
//        
//        // driver.get("http://google.com");
//        Thread.sleep(5000);
//        Thread.sleep(5000);
//          
//        driver.findElement(By.xpath("(//span[contains(@class,'copyActionIcon')])[1]")).click();
//        
////        WebElement element = driver.findElement(By.xpath("(//span[contains(@class,'copyActionIcon')])[1]"));
////        Actions act = new Actions(driver);
////        act.keyDown(Keys.CONTROL).click(element).keyUp(Keys.CONTROL).build().perform();
//       // String str=Keys.chord(Keys.CONTROL,"v");
//       
//        String url="https://qa-cpweb-admin.cosmoslots.tech/public/register?code=U2FsdGVkX18M3CVwnYuTOZZY9SE4qDJlxVG1kFMS0tZOH2CkGQwONzi5172CWAKtKtrr4OZT5pBOToGPqOysbWq/JNpwF0GSfqKMqpbO3L7/8INxItj5CuZWyf1i5aLDoQ3V5IwzlmbON9v2/dEurw==";
//        openNewTab(driver,url);
//        gotoTab(driver, 1);
//        
////        Actions actions = new Actions(driver);
////        actions.sendKeys(Keys.CONTROL, "v").sendKeys(Keys.ENTER).build().perform(); //sending the paste command 
//       
////        Robot rob = new Robot();
////        rob.keyPress(KeyEvent.VK_CONTROL);
////        rob.keyPress(KeyEvent.VK_V);
//        
////        Thread.sleep(2000);
////        System.out.println(driver.getCurrentUrl());
//
//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        System.out.println(driver.getTitle());
//        Thread.sleep(3000);
//      
//        secondtab t = new secondtab(driver);
//        t.searchGoogle();
//        
//        Thread.sleep(3000);
//        driver.switchTo().window(tabs2.get(0));
//        
//    }
//	
//	public static void openNewTab(WebDriver driver,String url) throws InterruptedException {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        //js.executeScript("window.open()");
//        js.executeScript("window.open('"+url+"','_blank');");
//        //driver.get("https://qa-cpweb-admin.cosmoslots.tech/public/register?code=U2FsdGVkX18M3CVwnYuTOZZY9SE4qDJlxVG1kFMS0tZOH2CkGQwONzi5172CWAKtKtrr4OZT5pBOToGPqOysbWq/JNpwF0GSfqKMqpbO3L7/8INxItj5CuZWyf1i5aLDoQ3V5IwzlmbON9v2/dEurw==");
//        Thread.sleep(100);
//    }
//
//    public static void gotoTab(WebDriver driver, int tabIndex) throws InterruptedException {
//        List<String> winHandles = new ArrayList<String>(driver.getWindowHandles());
//        Thread.sleep(500);
//        driver.switchTo().window(winHandles.get(tabIndex));
//    }
		
		
	}
	
}
