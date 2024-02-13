package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.SupportManagement;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.utilities.BaseClass;


public class ChatManagement extends BaseClass
{
	BaseClass bc = new BaseClass();
	
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Email = bc.FakeEmail();
	String Upload_Icon = UploadImage;
	String SearchItem="CS-CH-2577";
	private GuestPlayers gp ;
	private UserPage up ;
	private CommonCosmo cc ;
	private PlayerProfile pp ;
	private SupportManagement sm ;
	
	
	
	@Test
	public void A_TC_ChatManagement_Search() throws InterruptedException, IOException 
	{
		test=extentCreateTest("Chat Management -> Search");
		test.info("TC - As an admin user I should be able to Search in chat management");
		gp = new GuestPlayers(driver);
		up = new UserPage(driver);
		cc = new  CommonCosmo(driver);
		sm = new SupportManagement(driver);
		
		up.ClickDotButton();
		up.ClickOnSupportManagement();
		sm.ClickonChat();
		if(cc.ChatManagement_Header!=null)
		{	
			test.info("Successfully redirect to Chat Management Page");
			test.info("Started Search in Chat Management");
			gp.Search_Items(SearchItem);
			Thread.sleep(2000);
			if(driver.findElements(By.xpath("//td[contains(.,'"+SearchItem+"')]")).size()>0)	
			{
				test.info("Successfully Searched Item viewed",extentScreenshot());
			}
			else
			{
				test.info("Something wrong !! To Search Item",extentScreenshot());
			}
		}
		
	}

	@Test
	public void B_TC_PlayerProfileTest_ChatManagement_CreateRequestNewPlayer() throws InterruptedException, IOException 
	{
		String SearchItem="Shrikrushna Sonkar";
		String msg="Hi are you there ?";
		test=extentCreateTest("Chat Management -> Create New Chat -> Select confirmed player");
		gp = new GuestPlayers(driver);
		pp = new PlayerProfile(driver);
		if(cc.ChatManagement_Header!=null)
		{	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()=\" Create New\"]")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("//button[text()='Select Player']")).click();
			Thread.sleep(1000);
			gp.Search_Items(SearchItem);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//mat-checkbox[contains(@class,\"pristine\")])[1]")).click();
			Thread.sleep(500);
			pp.ClickSave();
		
			Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("//mat-chip[@color=\"secondary\"]//div[1]")).isDisplayed()== true)
			{
				driver.findElement(By.xpath("//textarea[@formcontrolname=\"description\"]")).sendKeys(msg);
				
				driver.findElement(By.xpath("//span[text()=\"Send\"]")).click();
				
				test.info("Player selected successfully and player name appeared");
				if(cc.Validation_Chatrequestsavesuccessfully.isDisplayed())
				{
					test.pass("successfully created chat request with validation message appeared ",extentScreenshot());
					Thread.sleep(5000);
				}
				else
				{
					test.info("successfully created chat request with no validation message",extentScreenshot());
					Assert.assertTrue(false);
				}
			}
			else
			{
				test.info("Player not appeared",extentScreenshot());
				Assert.assertTrue(false);
			}
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void C_TC_ChatManagement_CreateChatRequest_NewGuestPlayer() throws InterruptedException, IOException 
	{
		test=extentCreateTest("ChatManagement -> Create New Chat -> Select Guest Player");
		PlayerProfile pp=new PlayerProfile(driver);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div//following::i[@class='ri-message-2-line']")).click();
		Thread.sleep(2000);	
		
		if(driver.findElement(By.xpath("//h3[text()=\"Chat Management\"]"))!=null)
		{	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()=\" Create New\"]")).click();
			Thread.sleep(500);
			
			//select all guest player and sent 1.0.4
			driver.findElement(By.xpath("//button[text()=\"Select Guest Player\"]")).click();
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//span[contains(text(),'Select All Players')]")).click();
			test.info("selected all guest players");
			
			Thread.sleep(1000);
			pp.ClickSave();
			
			driver.findElement(By.xpath("//textarea[@formcontrolname=\"description\"]")).sendKeys("hi");
			Thread.sleep(300);
			
			driver.findElement(By.xpath("//span[text()=\"Send\"]")).click();
			//Thread.sleep(1000);
			
			if(driver.findElement(By.xpath("//span[text()=\"Chat request save successfully\"]")).isDisplayed())
			{
				test.pass("successfully created chat request with validation message appeared  ",extentScreenshot());
				Assert.assertTrue(true);
				Thread.sleep(5000);
			}
			else
			{
				test.fail("successfully created chat request with validation message not appeared ",extentScreenshot());
				Assert.assertTrue(false);
			}
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@Test
	public void D_TC_ChatManagement_ActionSingleChat() throws InterruptedException, IOException 
	{
		String SearchItem="CS-CH-1284";
		String msg="Hi are you there ?";
		test=extentCreateTest("ChatManagement Action view - single chat");
		test.info("TestCase started As an admin user, i should be able to view (Action) view -> Chat Management");
		GuestPlayers gp=new GuestPlayers(driver);
		PlayerProfile pp=new PlayerProfile(driver);

		if(driver.findElement(By.xpath("//h3[text()=\"Chat Management\"]"))!=null)
		{	
			Thread.sleep(1000);
			gp.Search_Items(SearchItem);
			Thread.sleep(1500);
			test.info("Testing Action View in ChatManagement Tab");
			pp.clickSupportActioneyeicon();
			Thread.sleep(1500);
			
			if(driver.findElement(By.xpath("//span[text()=\"Details\"]")).isDisplayed())
			{	
				driver.findElement(By.xpath("//input[@placeholder=\"Enter a new message\"]")).sendKeys(msg);
				Thread.sleep(500);
				driver.findElement(By.xpath("//button//i[contains(@class,\"send\")]")).click();
				Thread.sleep(500);
				if(driver.findElement(By.xpath("//span[contains(text(),'"+msg+"')]")) !=null)
				{
					test.pass("Message sent successfully by admin");
					//Assert.assertTrue(true);
				}
				else
				{
					test.fail("Message not sent");
				}
				
				//website code
				test.info("Verify message on website");
				bc.gotoTab(driver, 1);
				
				driver.findElement(By.xpath("//a[@id=\"dropdownUser\"]")).click();
				Thread.sleep(300);
				driver.findElement(By.xpath("//a[text()=\"Profile\"]")).click();
				Thread.sleep(500);
				driver.findElement(By.xpath("//button[@class='chatIcon']")).click();
				driver.findElement(By.xpath("//div[@class='chatUserName' and contains(.,'SA')]")).click();
				Thread.sleep(500);
				if(driver.findElement(By.xpath("//p[contains(@class,\"message\") and contains(.,'"+msg+"')]")) !=null)
				{
					test.pass("Message has been successfully viewed via the website.",extentScreenshot());
					//Assert.assertTrue(true);
				}
				else
				{
					
					test.fail("Failed - Message not viewed in the website");
				}
				
				test.info("Verify showing online in website");
				Thread.sleep(10000);
//				
//				if(driver.findElement(By.xpath("//div[@class=\"online-indicator\"]")) !=null)
//				{
//					test.pass("green indicator has been successfully viewed via the website.");
//					//Assert.assertTrue(true);
//				} 
//				else
//				{
//					BaseClass.gotoTab(driver, 0);
//					test.fail("Failed - green indicator not viewed in the website");
//				}
				
				BaseClass.gotoTab(driver, 0);
				
				driver.findElement(By.xpath("//input[@placeholder=\"Enter tag\"]")).sendKeys("Tags");
				
				driver.findElement(By.xpath("//textarea[@formcontrolname=\"note\"]")).sendKeys("By Auto");
				Thread.sleep(500);
				gp.ClickSave();
				if(cc.Validation_Notessavesuccessfull!=null)
				{
					test.pass("Message got - Notes Save Successfully");
					Thread.sleep(4000);
				}
				else
				{
					test.fail("Not working");
				}
			}
			else
			{
				test.info("Failed To Redirect Support Request Action");
			}
			Thread.sleep(500);
		}
		else
		{
			test.fail("Not working");
		}
	}		
	
	@Test
	public void E_TC_ChatManagement_PlayeronlineIndiaction(){
		
	}
}
	
