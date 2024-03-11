package seleniuminterface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface seleniumInterface {

	public static final WebDriver driver = null;
	public void click(WebElement ele);
	public void setText(WebElement ele,String tx);
	public String getTitle(WebDriver d);
	boolean VerifyData(WebDriver d, By ele);
	 
}
