package com.Cosmoslots.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.CosmoWebsite;
import com.Cosmoslots.utilities.BaseClass;

public class Contactus extends BaseClass {
	BaseClass bc = new BaseClass();
	String Upload_Icon = UploadImage;
	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Usernm = Firstnm + Lastnm;
	String Email = Firstnm + Lastnm + "@yopmail.com";
	String Message = "By Auto";
	String Phone = "+918745458885";

	@Test
	public void B_TC_Contactus_Redirect() throws IOException, InterruptedException {
		test = extentCreateTest("Contact Us -> Redirect");
		test.info("TestCase started - As an admin user I should able to click on 'Contact Us' menu so that I can redirect to Contact Us page");
		Thread.sleep(5000);
		CommonCosmo cc = new CommonCosmo(driver);
		CosmoWebsite cw = new CosmoWebsite(driver);
		bc.gotoTab(driver, 1);
		driver.findElement(By.xpath("//a[contains(text(),\"Contact Us\")]")).click();

		if (cc.ContactUs_Header.isDisplayed()==true) {
			test.pass("Successfully Displayed Contact Us Pageon", extentScreenshot());
		} else {
			test.fail("Something Wrong to Display Contact Us Page", extentScreenshot());
		}
	}

	@Test
	public void C_TC_Contactus_Request() throws IOException, InterruptedException {
		test = extentCreateTest("Contact Us -> Verify Contact Us Request");
		test.info("TestCase started - As an admin user I should able to view Contact Us details");
		CosmoWebsite cw = new CosmoWebsite(driver);
		CommonCosmo cc = new CommonCosmo(driver);

		cw.ClickOnPlayerLogout();
		Thread.sleep(3000);
		WebElement ContactUs = driver.findElement(By.xpath("//h3[text()=\"Contact Us\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ContactUs);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (cc.ContactUs_Header.isDisplayed()==true) {
			try {
				driver.findElement(By.xpath("//input[contains(@formcontrolname,\"firstName\")]")).sendKeys(Firstnm);
				driver.findElement(By.xpath("//input[contains(@formcontrolname,\"lastName\")]")).sendKeys(Lastnm);
				driver.findElement(By.xpath("//input[contains(@formcontrolname,\"email\")]")).sendKeys(Email);
				driver.findElement(By.xpath("//input[contains(@formcontrolname,\"phone\")]")).sendKeys(Phone);
				driver.findElement(By.xpath("//textarea[contains(@formcontrolname,\"message\")]")).sendKeys(Message);
				Thread.sleep(500);
				WebElement SendMessage = driver.findElement(By.xpath("//button[text()='Send Message']"));
				js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", SendMessage);
				SendMessage.click();
				if (driver.findElements(By.xpath("//div[contains(text(),\"Thanks for contacting us. We will get back to you soon \")]")).size() > 0) {
					test.pass("Successfully showing message with - \"Thanks for contacting us. We will get back to you soon\" ",extentScreenshot());
				} else {
					test.fail("Failed");
				}
				Thread.sleep(3000);
			} catch (Exception e) {
				// Assert.assertTrue(false);
				test.fail("Something Wrong to Display contact Us Page", extentScreenshot());
			}
		} else {
			// Assert.assertTrue(false);
			test.fail("Something Wrong to Display contact Us Page", extentScreenshot());
		}
	}

	@Test
	public void D_TC_Contactus_VerifyAdminside() throws IOException, InterruptedException {
		test = extentCreateTest("Contact Us -> Verifing last entry");
		Thread.sleep(3000);
		bc.gotoTab(driver, 0);
		Thread.sleep(500);
		// test.info("TestCase started 1143 - As an admin user I should able to Update
		// My-Profile");
		driver.findElement(By.xpath("//div//following::i[@class='ri-more-fill']")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"Support Management\")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"Contact Details\")]")).click();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//h3[text()=\"Contact Details\"]")).size() > 0) {
			test.info("Successfully redirect to MyProfile Page");

			if (driver.findElements(By.xpath("(//tbody//tr//td[contains(text(),'" + Email + "')])[1]")).size() > 0) {
				test.pass("Successfully Viewed data \" " + Email + " \" which is Entered by website contact Us,",extentScreenshot());
			} else {
				// Assert.assertTrue(false);
				test.fail("Something Wrong - Email \" " + Email + " \" missing", extentScreenshot());
			}
		} else {
			// Assert.assertTrue(false);
			test.fail("Something Wrong to redirect Admin -> ContactUs Page");
		}
	}

}
