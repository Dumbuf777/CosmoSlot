package com.Cosmoslots.testCases;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.utilities.BaseClass;

//transaction history cancel click-action view

public class BlockList extends BaseClass
{
	private LobbyPage lb ;
	private CommonCosmo cc ;
	private GuestPlayers gp ;
	
	@Test
	public void A_TC_Block_PlayerData_Country() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc = new CommonCosmo(driver);
		 gp = new GuestPlayers(driver);
		
		test = extentCreateTest("Country- Block Player Data Page");	
		test.info("Country-Block Player Data Page test case start");
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) 
		{			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Blocked List']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"By User Data\"]")).click();
			Thread.sleep(500);
			if(driver.findElements(By.xpath("//h3[text()='Blocked Player Data']")).size()>0) 
			{	
				driver.findElement(By.xpath("//mat-select[@formcontrolname=\"selectListType\"]")).click();
				
				//for country
				driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Country']")).click();
				gp.setCountry_BlockList("Latvia");
				Thread.sleep(1000);
				 
				lb.ClickToSave();
				Thread.sleep(1000);

				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true){
					test.info("<b><i>Country- Blocked List Data saved successfully</b></i>", extentScreenshot());
				}
				else
				{ test.info("<b><i>Country- Blocked List Data saved successfully - message not displayed</b></i>", extentScreenshot());
					
				}
				
				Thread.sleep(500);
							
			}
			else
			{
				test.fail("Country- not able to find player management",extentScreenshot());
				Assert.assertTrue(false);
			}						
		}
		else
		{
			test.fail("Country- not able to find player management",extentScreenshot());
		}
	}
	@Test
	public void Ba_TC_Block_PlayerData_Email() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc=new CommonCosmo(driver);
		 gp=new GuestPlayers(driver);
		
		test = extentCreateTest("Email -Block Player Data Page");
		
		test.info("email-Block Player Data Page test case start");
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) 
		{			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Blocked List']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"By User Data\"]")).click();
			
			if(driver.findElements(By.xpath("//h3[text()='Blocked Player Data']")).size()>0) 
			{	
				Thread.sleep(500);
				//for email
				driver.findElement(By.xpath("//span[contains(@class,'mat-select-min-line')]")).click();
				driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Email']")).click();
				driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(Constant.randomString+"@yopmail.com");
				lb.ClickToSave();
				Thread.sleep(2000);
				
				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true){
					Assert.assertTrue(true);			
					test.pass("<b><i>email- Blocked List Data saved successfully</b></i>", extentScreenshot());
					
				}
				else
				{
					test.fail("<b><i>email- Blocked List Data saved successfully - message not displayed</b></i>", extentScreenshot());
					Assert.assertTrue(false);	
				
					//Thread.sleep(1500);
				}	
				
				Thread.sleep(500);
					
			}
			else
			{
				test.fail("email- not able to find player management",extentScreenshot());
				Assert.assertTrue(false);
			}						
		}
		else
		{
			test.fail("email- not able to find player management",extentScreenshot());
		}
	}

	@Test
	public void Bc_TC_Block_PlayerData_firstName() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc=new CommonCosmo(driver);
		
		test = extentCreateTest("firstName- Block Player Data Page");
		
		test.info("firstName-Block Player Data Page test case start");
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) 
		{			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Blocked List']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"By User Data\"]")).click();
			Thread.sleep(500);
			if(driver.findElements(By.xpath("//h3[text()='Blocked Player Data']")).size()>0) 
			{	
				Thread.sleep(500);
				//for first name
				driver.findElement(By.xpath("//mat-select[@formcontrolname=\"selectListType\"]")).click();
				driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='First Name']")).click();
				driver.findElement(By.xpath("//input[@formcontrolname=\"firstName\"]")).sendKeys(Constant.Firstnm);
				lb.ClickToSave();
				Thread.sleep(1000);

				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true)
				{
					Assert.assertTrue(true);			
					test.info("<b><i>firstName- Blocked List Data saved successfully</b></i>", extentScreenshot());
					 
			    }
				else
				{
					test.info("<b><i>firstName- Blocked List Data saved successfully - message not displayed</b></i>", extentScreenshot());
					Assert.assertTrue(false);	
				 	Thread.sleep(1500);
			    }	
				
				Thread.sleep(500);
						
			}
			else
			{
				test.fail("firstName- not able to find player management",extentScreenshot());
				Assert.assertTrue(false);
			}						
		}
		else
		{
			test.fail("firstName- not able to find player management",extentScreenshot());
		}
	}
	
	@Test
	public void Bd_TC_Block_PlayerData_lastName() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc=new CommonCosmo(driver);
		
		test = extentCreateTest("lastName-Block Player Data Page");
		
		test.info("lastName-Block Player Data Page test case start");
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) 
		{			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Blocked List']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"By User Data\"]")).click();
			Thread.sleep(500);
			if(driver.findElements(By.xpath("//h3[text()='Blocked Player Data']")).size()>0) 
			{	
				Thread.sleep(500);
				//for last name
				driver.findElement(By.xpath("//mat-select[@formcontrolname=\"selectListType\"]")).click();
				driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Last Name']")).click();
				driver.findElement(By.xpath("//input[@formcontrolname=\"lastName\"]")).sendKeys("last"+Constant.randomString);
				lb.ClickToSave();
				Thread.sleep(1000);

				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true)
				{
					Assert.assertTrue(true);			
					test.info("<b><i>lastName- Blocked List Data saved successfully</b></i>", extentScreenshot());
					 
				}
				else
				{
					test.info("<b><i>lastName- Blocked List Data saved successfully - message not displayed</b></i>", extentScreenshot());
					Assert.assertTrue(false);
					 
					Thread.sleep(1500);
			    }	

			}
			else
			{
				test.fail("lastName- not able to find player management",extentScreenshot());
				Assert.assertTrue(false);
			}						
		}
		else
		{
			test.fail("lastName- not able to find player management",extentScreenshot());
		}
	}
	
	@Test
	public void Be_TC_Block_PlayerData_phone() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc=new CommonCosmo(driver);
		
		test = extentCreateTest("phone-Block Player Data Page");
		
		test.info("phone-Block Player Data Page test case start");
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) 
		{			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Blocked List']")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()=\"By User Data\"]")).click();
			Thread.sleep(500);
			if(driver.findElements(By.xpath("//h3[text()='Blocked Player Data']")).size()>0) 
			{	
								
				//for Phone
				driver.findElement(By.xpath("//mat-select[@formcontrolname=\"selectListType\"]")).click();
				driver.findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='Phone']")).click();
				driver.findElement(By.xpath("//input[@formcontrolname=\"phone\"]")).sendKeys(Constant.randNum);
				lb.ClickToSave();
				
				Thread.sleep(1000);
				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true)
				{
					Thread.sleep(500);
					test.info("<b><i>phone - Blocked List Data saved successfully</b></i>", extentScreenshot());
					//Assert.assertTrue(true);	
					 
					Thread.sleep(500);
				}
				else
				{
					Thread.sleep(500);
					test.info("<b><i>Blocked List Data saved successfully - phone message not displayed</b></i>", extentScreenshot());
					Assert.assertTrue(false);	
					 
					Thread.sleep(1500);
			    }			
			}
			else
			{
				test.fail("phone - not able to find player management",extentScreenshot());
				Assert.assertTrue(false);
			}						
		}
		else
		{
			test.fail("not able to find player management with phone",extentScreenshot());
		}
		Thread.sleep(1500);
	}
	
	@Test
	public void C_TC_Block_ip_create() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc = new CommonCosmo(driver);
		
		test = extentCreateTest("Block Player Data Page by IP create new");
		
		test.info("create Block Player Data Page for IP test case start");
		
		if(driver.findElements(By.xpath("//span[contains(text(),\"Player Management\")]")).size()>0) {
			
			driver.findElement(By.xpath("//span[contains(text(),\"Player Management\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(),\"Blocked List\")]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[contains(text(),\"By IP\")]")).click();

			Thread.sleep(1000);
			if(driver.findElements(By.xpath("//h3[contains(text(),\"Blocked IP List\")]")).size()>0)
			{				
				Thread.sleep(1000);
				//lb.clickToCreate();
				driver.findElement(By.xpath("//button[@title=\"Create New\"]")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@formcontrolname=\"ipAddress\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"ipAddress\"]")).sendKeys("127.0.0.0");
				Thread.sleep(1000);
				lb.ClickToSave();
				Thread.sleep(1000);

				if(cc.Validation_Format_BlockList_saved.isDisplayed()==true){
					Assert.assertTrue(true);			
					test.pass("<b><i>Blocked List Data saved successfully</b></i>", extentScreenshot());
					 
			   }else{
					test.fail("<b><i>Blocked List Data saved successfully - message not displayed</b></i>", extentScreenshot());
					Assert.assertTrue(false);
					 
			  }
				
			}
			else {
				test.fail("Not able to find Blocked IP List label",extentScreenshot());
			}
			
		}
		else {
			test.fail("Not able to find player management",extentScreenshot());
		}		
		
		test.info("Block Player Data Page by IP test case End");
		Thread.sleep(1500);
	}
		
	@Test 
	public void D_TC_Block_IP_search() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Block Player Data Page by IP search");
		
		 lb = new LobbyPage(driver);
		 cc = new CommonCosmo(driver); 
		Thread.sleep(500);
		//-----------Search news-----------
		test.info("Block Player IP search test case start");
		lb.SearchItems("127.0.0.0");
		test.info("Search Promotion = <b>" +"127.0.0.0"+"</b>" ,extentScreenshot());
		Thread.sleep(2000);
		 
		test.info("Block Player IP search test case end");
	}
	
	@Test 
	public void E_TC_Block_IP_status() throws IOException, InterruptedException 
	{
		lb = new LobbyPage(driver);
		cc=new CommonCosmo(driver);
		gp=new GuestPlayers(driver);
		
		test = extentCreateTest("Block Player Data Page by IP status");
		
		test.info("Block Player IP status test case start");
		
		//status active/inactive
		if(driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[@title])[1]")).getAttribute("title").equalsIgnoreCase("Un Publish"))
	    {
			            test.info("Successfully Viewed active Blocked IP List page");
			            test.info("Now Blocked IP  Is InActive");
			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			            Thread.sleep(1000);
			            try
			            {
			                if(driver.findElements(By.xpath("//span[text()=\"IP unblocked successfully\"]")).size()>0)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("IP unblocked successfully activated and Validation message appeared - IP unblocked successfully",extentScreenshot());
			                }else{
			                    Assert.assertTrue(false);
			                    test.fail("Failed ! To View Message",extentScreenshot());
			                }
			            }
			            catch(Exception e)
			            {
			                if(driver.findElement(By.xpath("//span[text()=\"IP blocked successfully\"]"))!=null)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("ip Successfully activated and Validation message appeared - ip activated successfully",extentScreenshot());
			                }
			                System.out.println(e);
			            }Thread.sleep(4000);
	     }else{
			            test.info("Successfully Viewed IP blocked successfully listing page");
			            test.info("Now IP Is Active");

			            driver.findElement(By.xpath("(//th[text()=\"Status\"]/following::tr//td[contains(@class,\"status\")]//span[contains(@class,'thumb-container')])[1]")).click();
			            Thread.sleep(1000);
			            driver.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
			            Thread.sleep(1000);
			            try {
			            	if(driver.findElements(By.xpath("//span[text()=\"IP unblocked successfully\"]")).size()>0)
			            	{
			            		Assert.assertTrue(true);
			            		test.pass("ip Successfully deactivated and Validation message appeared - ip deactivated successfully",extentScreenshot());
			            	}else{
			            		Assert.assertTrue(false);
			                	test.fail("Failed ! To View Message",extentScreenshot());
			            	}
			            }
			            catch(Exception e)
			            {
			                if(driver.findElements(By.xpath("//span[text()=\"IP unblocked successfully\"]")).size()>0)
			                {
			                    Assert.assertTrue(true);
			                    test.pass("ip Successfully deactivated and Validation message appeared - ip deactivated successfully",extentScreenshot());
			                }
			                System.out.println(e);
			          }
			 }
		
		
		test.info("Block Player IP status test case end");
		
	}
	
	@Test
	public void F_TC_Block_IP_Edit() throws IOException, InterruptedException 
	{
		 lb = new LobbyPage(driver);
		 cc=new CommonCosmo(driver);
		
		test = extentCreateTest("Block Player Data Page by IP edit new");
		
		test.info("edit Block Player Data Page for IP test case start");
		
		lb.clickToEdit();
		
		if(driver.findElements(By.xpath("//h3[normalize-space()='Update blocked list IP']")).size()>0) {
			
			driver.findElement(By.xpath("//input[@formcontrolname=\"ipAddress\"]")).clear();
				driver.findElement(By.xpath("//input[@formcontrolname=\"ipAddress\"]")).sendKeys("127.0.0.1");
				lb.ClickToSave();
				if(cc.Validation_Format_BlockList_edit.isDisplayed()==true){
					test.pass("<b><i>Blocked List Data updated successfully</b></i>", extentScreenshot());
					 
			   }else{
					test.fail("<b><i>Blocked List Data updated successfully - message not displayed</b></i>", extentScreenshot());
				 
			  }				
			
		}
		else {
			test.fail("Not able to find Update blocked list IP label",extentScreenshot());
		}		
		
		test.info("edit Block Player Data Page by IP test case End");
	}
	
	@Test 
	public void G_TC_Block_IP_delete() throws IOException, InterruptedException 
	{
		test = extentCreateTest("Block Player Data Page by IP delete");
		lb = new LobbyPage(driver);
		cc = new CommonCosmo(driver); 
	
			
		//-----------delete Promotion-----------
		test.info("delete Block Player Data Page by IP test case start");
		Thread.sleep(1000);
		lb.DeleteClick_websiteSetings();
		test.info("click to delete Block Player Data Page by IP");
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).isDisplayed()==true) {
			Assert.assertTrue(true);
			driver.findElement(By.xpath("//button[text()='Yes, delete it!']")).click();
			Thread.sleep(200);
			test.pass("Block Player Data Page by IP - delete successfully",extentScreenshot());
		}else {
			test.fail("Something Wrong ! not able to delete Block Player Data Page by IP ",extentScreenshot());
			Assert.assertTrue(false);	
		}
		Thread.sleep(2000);
		Boolean bool1=cc.Validation_Format_DeletePromotion.isDisplayed();
		if(bool1==true){
			Assert.assertTrue(true);
			test.pass("IP  - delete message return",extentScreenshot());
			 
		}else{
			test.fail("Something Wrong ! not able show IP  delete message ",extentScreenshot());
			Assert.assertTrue(false);	
			 
		}
		Thread.sleep(1000);
		test.info("delete Block Player Data Page by IP test case End");
		
		
		Thread.sleep(1000);	
	}
	
	
}