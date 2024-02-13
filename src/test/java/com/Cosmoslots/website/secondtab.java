package com.Cosmoslots.website;


//import com.boots.thor.base.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class secondtab {
    private WebDriver driver;

    public secondtab(WebDriver driver){
        this.driver =  driver;
    }

    public void searchGoogle(){
       // driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
    	 driver.findElement(By.xpath("//button[contains(text(),\"Registration\")]")).click();
    }
}