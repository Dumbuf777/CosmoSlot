package com.Cosmoslots.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestUtilities
{
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void waitUntilElementVisible(int waitTime,WebElement e)
	{
		try 
		{
			wait = new WebDriverWait(driver, waitTime);
		}
		catch (Exception e1) 
		{
			wait.until(ExpectedConditions.visibilityOf(e));
			e1.printStackTrace();
		}
	}
	
	public static void waitUntilElementInVisible(int waitTime,WebElement e)
	{
		try 
		{
			wait = new WebDriverWait(driver, waitTime);
		}
		catch (Exception e1) 
		{
			wait.until(ExpectedConditions.invisibilityOf(e));
			e1.printStackTrace();
		}
	}

	
}