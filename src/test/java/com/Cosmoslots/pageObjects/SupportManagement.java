/**
 * 
 */
package com.Cosmoslots.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class SupportManagement {
	BaseClass bc = new BaseClass();
	
	
WebDriver ldriver;
	
	public SupportManagement (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//div[@role='tablist']//button[contains(text(),'Support')]")
	@CacheLookup
	WebElement Support_webTab;
	
	@FindBy(xpath="//button[contains(text(),'New Request')]")
	@CacheLookup
	WebElement newRequest_webTab;
	
	@FindBy(xpath="//select[@formcontrolname='requestType']")
	@CacheLookup
	WebElement supportTypeDropdown_webTab;
	
	@FindBy(xpath="//select[@formcontrolname='requestType']//child::option[contains(text(),'Feedback')]")
	@CacheLookup
	WebElement supportTypeFeedback_webTab;
	
	@FindBy(xpath="//select[@formcontrolname='requestType']//child::option[contains(text(),'Issue')]")
	@CacheLookup
	WebElement supportTypeIssue_webTab;
	
	@FindBy(xpath="//select[@formcontrolname='requestType']//child::option[contains(text(),'Review')]")
	@CacheLookup
	WebElement supportTypeReview_webTab;
	
	@FindBy(xpath="//select[@formcontrolname='requestType']//child::option[contains(text(),'Transaction')]")
	@CacheLookup
	WebElement supportTypeTransaction_webTab;
	
	@FindBy(xpath="//input[@formcontrolname='requestTitle']")
	@CacheLookup
	WebElement supportRequestTitle_webTab;
	
	@FindBy(xpath="//textarea[@formcontrolname='requestComment']")
	@CacheLookup
	WebElement supportComments_webTab;
	
	@FindBy(xpath="//div[@class='supportrequest-form-block']//child::button[contains(text(),'Submit')]")
	@CacheLookup
	WebElement supportReqSubmitBtn_webTab;
	
	@FindBy(xpath="//*[@id=\\\"nav-support\\\"]/app-support/div/div/div[2]/table/tbody/tr[1]/td[4]")
	@CacheLookup
	WebElement supportTitle_webTab;
	
	@FindBy(xpath="//*[@id=\\\"nav-support\\\"]/app-support/div/div/div[2]/table/tbody/tr[1]/td[2]")
	@CacheLookup
	WebElement supportTicketID_webTab;
	
	@FindBy(xpath="//*[@id=\\\"nav-support\\\"]/app-support/div/div/div[2]/table/tbody/tr[1]/td[3]")
	@CacheLookup
	WebElement supportType_webTab;
	
	@FindBy(xpath="(//i[@class='fa fa-eye'])[1]")
	@CacheLookup
	WebElement supportActionView_webTab;
	
	@FindBy(xpath="//div//input[@placeholder='Enter a new message']")
	@CacheLookup
	WebElement supportChatMsg;
	
	@FindBy(xpath="//button[@type='button']//i[@class='fa fa-paper-plane']")
	@CacheLookup
	WebElement btnSend;
	
	@FindBy(xpath="//button[contains(text(),' Support Management')]")
	@CacheLookup
	private WebElement SupportManagement;
	
	@FindBy(xpath="//button[text()='Support Request']")
	@CacheLookup
	private WebElement SupportRequest;
	
	@FindBy(xpath="//button[text()='Chat']")
	@CacheLookup
	private WebElement Chat;
	
	@FindBy(xpath="//button[text()='Help Player']")
	@CacheLookup
	private WebElement HelpPlayer;
	
	@FindBy(xpath="//div[@class=\"playerProfilePic\"]//following::a[1]")
	@CacheLookup
	private WebElement SupportRequestIcon;

	//-----------------------------------------------------------------------------------------------------------------------------------------------
	//Create Announcement And notifications POM
	@FindBy(xpath="//button[contains(text(),'Announcements')]")
	@CacheLookup
	private WebElement AnnouncementsBtn;
	
	@FindBy(xpath="//h3[contains(text(),'Announcement')]")
	@CacheLookup
	private WebElement AnnouncementsHeader;
	
	@FindBy(xpath="//button[contains(text(),'Notifications')]")
	@CacheLookup
	private WebElement NotificationsBtn;
	
	@FindBy(xpath="//h3[contains(text(),'Notifications')]")
	@CacheLookup
	private WebElement NotificationsHeader;
	
	@FindBy(xpath="//input[@formcontrolname='title']")
	@CacheLookup
	private WebElement Title;
	
	@FindBy(xpath="//mat-select[@formcontrolname='lobbyCode']")
	@CacheLookup
	private WebElement StoreAccountDd;
	
	@FindBy(xpath="//mat-select[@formcontrolname='announcementCategory']")
	@CacheLookup
	private WebElement announcementCategory;
	
	@FindBy(xpath="//textarea[@formcontrolname='description']")
	@CacheLookup
	private WebElement description;
	
	public SupportManagement ClickonAnnouncements()
	{
		AnnouncementsBtn.click();
		return this;
	}
	
	public SupportManagement ClickonTitle(String txt)
	{
		Title.clear();
		Title.click();
		Title.sendKeys(txt);
		return this;
	}
	
	public SupportManagement SelectStoreAcoount(String store)
	{
		StoreAccountDd.click();
		ldriver.findElement(By.xpath("//span[contains(text(),'"+store+"')]"));
		return this;
	}
	
	public SupportManagement SelectAnnouncementCategory(String Category)
	{
		announcementCategory.click();
		ldriver.findElement(By.xpath("//span[contains(text(),'"+Category+"')]"));
		return this;
	}
	
	public SupportManagement ClickonDescription(String txt)
	{
		description.clear();
		description.click();
		description.sendKeys(txt);
		return this;
	}
//-----------------------------------------------------------------------------------------------------------------------------------------------	
	public SupportManagement ClickonSupportRequestIcon()
	{
		SupportRequestIcon.click();
		return this;
	}
	
	public   SupportManagement ClickonSupportManagement()
    {
		Actions act = new Actions(ldriver);
		act.moveToElement(SupportManagement).build().perform();
    	return this;
    }
	
	public   SupportManagement ClickonSupportRequest()
    {
//		Actions act = new Actions(ldriver);
//		act.moveToElement(SupportManagement).build().perform();
		SupportManagement.click();
		SupportRequest.click();
    	return this;
    }
	
	public   SupportManagement ClickonChat()
    {
		bc.explicitWait(ldriver, SupportManagement, 5);
		SupportManagement.click();
		bc.explicitWait(ldriver, Chat, 5);
		Chat.click();
    	return this;
    }
	
	public   SupportManagement ClickonHelpPlayer()
    {
		bc.explicitWait(ldriver, SupportManagement, 5);
		SupportManagement.click();
		bc.explicitWait(ldriver, HelpPlayer, 5);
		HelpPlayer.click();
    	return this;
    }
	
	public void clickOnSupport_MainTab_web() throws InterruptedException
	{

		Support_webTab.click();
		Thread.sleep(2000);
		newRequest_webTab.click();
		
	}
	
	public void selectSupporttype() throws InterruptedException
	{
		supportTypeFeedback_webTab.click();
		String fb = supportTypeFeedback_webTab.getText();
		supportRequestTitle_webTab.sendKeys(fb);
		supportComments_webTab.sendKeys(fb);
		supportReqSubmitBtn_webTab.click();
		Thread.sleep(2000);
		
	}
	
	public void ckickOnActionView()
	{
		supportActionView_webTab.click();
	}
	
	public void enteringChatmsg(String msg) throws InterruptedException
	{
		Thread.sleep(2000);
		supportChatMsg.sendKeys(msg);
		Thread.sleep(3000);
		btnSend.click();
		
	}
	
	public void verifyNewTicketId()
	{
		if(supportType_webTab.equals(supportTitle_webTab))
		{
			System.out.println("Support type is verified");
		}else {
			System.out.println("Support type is not verified");

		}
		
		
	}

}
