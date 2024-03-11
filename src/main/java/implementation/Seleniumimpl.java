package implementation;

import org.apache.tools.ant.launch.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniuminterface.seleniumInterface;

public class Seleniumimpl implements seleniumInterface {

	@Override
	public void click(WebElement ele) {
		
		// wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	@Override
	public void setText(WebElement ele, String tx) {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(ele));
		ele.sendKeys(tx);

	}

	@Override
	public String getTitle(WebDriver d) {
		return d.getTitle();
	}

	@Override
	public boolean VerifyData(WebDriver d, By ele) {
		
		return !d.findElements(ele).isEmpty();
	}

	 
	 

}
