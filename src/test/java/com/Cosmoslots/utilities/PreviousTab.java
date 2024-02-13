package com.Cosmoslots.utilities;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class PreviousTab {
		public static String generateOTP() {
			int randomPin   =(int)(Math.random()*9000)+1000;
			String otp  =String.valueOf(randomPin);
			return otp;
		}
	   
	
	          public static void main(String[] args) throws AWTException {
	        	  
	        	  int randomPin   =(int)(Math.random()*9000)+1000;
	  			  String otp  =String.valueOf(randomPin);
	    			System.out.println("OTP : "+otp);
		    		        	  
	        		String otpSting  =generateOTP();
	    			System.out.println("OTP : "+otpSting);
	    			
	    			String message = "the email otp is 25301 for 1 min";
	    	        // Define the regular expression pattern to match the OTP value
	    	        Pattern pattern = Pattern.compile("\\b\\d{5}\\b");
	    	        // Create a Matcher object to find the pattern in the message
	    	         Matcher matcher = pattern.matcher(message);
	    	        // Check if a match is found
	    	        if (matcher.find()) {
	    	            // Get the matched value (OTP) and convert it to an integer
	    	            String otpString = matcher.group();
	    	            int otp1 = Integer.parseInt(otpString);
	    	            // Print the OTP value
	    	            System.out.println("OTP: " + otp1);
	    	        } else {
	    	            // If no match is found, print an error message
	    	            System.out.println("OTP not found in the message.");
	    	        }

//	               // TODO Auto-generated method stub
//	              System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Cosmo_automation\\Drivers\\chromedriver.exe");
//	             WebDriver driver = new ChromeDriver();
//	             driver.manage().window().maximize();
//	             driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//	             driver.get("https://www.google.com");
//	             WebElement element1 = driver.findElement(By.name("q"));
//	             element1.sendKeys("software testing help");
//	             element1.sendKeys(Keys.ENTER);
//	             String a = Keys.chord(Keys.CONTROL,Keys.RETURN);
//	             driver.findElement(By.partialLinkText("Software Testing Help - A Must Visit Software Testing Portal")).sendKeys(a);
//	             Robot robot = new Robot(); // instantiated robot class
//	             robot.keyPress(KeyEvent.VK_CONTROL); // with robot class you can easily achieve anything if you know the shortcut keys
//	             robot.keyPress(KeyEvent.VK_2); // here, we have just pressed ctrl+2
//	             robot.keyRelease(KeyEvent.VK_CONTROL); // once we press and release ctrl+2, it will go to the second tab.
//	             robot.keyRelease(KeyEvent.VK_2); //if you again want to go back to first tab press and release vk_1
//	             }

//	        	     // Import excel sheet from a webdriver directory which is inside c drive.
//	        	     //DataSource is the name of the excel
//	        	     File src=new File("C:\\webdriver\\DataSource.xls");
//	        	      
//	        	     //This step is for loading the file. We have used FileInputStream as
//	        	     //we are reading the excel. In case you want to write into the file,
//	        	     //you need to use FileOutputStream. The path of the file is passed as an argument to FileInputStream
//	        	     FileInputStream finput = new FileInputStream(src);
//	        	      
//	        	     //This step is to load the workbook of the excel which is done by global HSSFWorkbook in which we have
//	        	     //passed finput as an argument.
//	        	    workbook = new HSSFWorkbook(finput);
//	        	      
//	        	     //This step is to load the sheet in which data is stored.
//	        	     sheet= workbook.getSheetAt(0);
//	        	      
//	        	     for(int i=1; i&lt;=sheet.getLastRowNum(); i++)
//	        	     {
//	        	         // Import data for Email.
//	        	         cell = sheet.getRow(i).getCell(1);
//	        	         cell.setCellType(Cell.CELL_TYPE_STRING);
//	        	         driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
//	        	          
//	        	         // Import data for the password.
//	        	         cell = sheet.getRow(i).getCell(2);
//	        	         cell.setCellType(Cell.CELL_TYPE_STRING);
//	        	         driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());
//	        	                 
//	        	        }

}
	}
