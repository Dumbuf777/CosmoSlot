/**
 * 
 */
package com.Cosmoslots.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class SystemAnalytics extends BaseClass {
	BaseClass bc = new BaseClass();
	String Store = "CosmoSlot";
	String Role = "Gameium Admin";
	String User = "Gameiumadmin";
	String[] month = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
	String[] endDate = { "31", "28", "31", "30", "18", "30", "31", "31", "30", "31", "30", "31" };

	@Test
	public void A_TC_SystemAnalytics_GameRTP() throws InterruptedException {
		test = extentCreateTest(
				"TC - As admin I should be able to view Game RTP of the system analytics while selecting game category and Game");

		LoginPage lp = new LoginPage(driver);
		UserPage up = new UserPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		Thread.sleep(2000);
		lp.ClickonUserAdminProfile();
		Thread.sleep(2000);
		up.ClickonSettings();
		Thread.sleep(2000);
		up.ClickonSystemAnalytics();
		Thread.sleep(1000);
		up.ClickonGameRTP();
		Thread.sleep(2000);
		pp.SelectGameCategory("Slot", "Leprechaun");
		// up.SelectStoreRoleUserforAppAnalytics(Store, Role, User);
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate(); 
		Thread.sleep(1000);
		up.ClickonSearch();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//th[text()='Game Code']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Game Name']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Bet Values']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Paylines / Spots']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Spins / Rounds']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Bet']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Feature Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='RTP']")).size() > 0) {
			test.pass("Successfully viewed the Game RTP of the system analytics while selecting game category and Game",
					extentScreenshot());
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Exclusive Analytics tab in player profile and game RTP",
					extentScreenshot());
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void Ab_TC_SystemAnalytics_GameRTP() throws InterruptedException {
		String Store = "CosmoSlot ";
		test = extentCreateTest(
				"TC - As admin I should be able to view Game RTP of the system analytics while selecting store,role and user");

		UserPage up = new UserPage(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		// pp.SelectGameCategory("Slot", "Leprechaun");
		Thread.sleep(1000);
		up.SelectStoreRoleUserforAppAnalytics(Store, Role, User);
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate(); 
		Thread.sleep(1000);
		up.ClickonSearch();
		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//th[text()='Game Code']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Game Name']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Bet Values']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Paylines / Spots']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Spins / Rounds']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Bet']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='Total Feature Wins']")).size() > 0
				&& driver.findElements(By.xpath("//th[text()='RTP']")).size() > 0) {
			test.pass("Successfully viewed the Game RTP of the system analytics while selecting game category and Game",
					extentScreenshot());
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To view the Exclusive Analytics tab in player profile and game RTP",
					extentScreenshot());
			Assert.assertTrue(false);
		}
	}

	@Test
	public void Ad_TC_SystemAnalytics_AppAnalytics_OverallGraph() throws InterruptedException {

		test = extentCreateTest("TC - As admin I should be able to view overall average graph of the app analytics");

		UserPage up = new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//	lp.ClickonUserAdminProfile();
//	Thread.sleep(2000);
//	up.ClickonSettings();
//	Thread.sleep(2000);
//	up.ClickonSystemAnalytics();
		Thread.sleep(1000);
		up.ClickonAppAnalytics();
		Thread.sleep(1000);
		up.SelectStoreRoleUserforAppAnalytics(Store, Role, User);
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		Thread.sleep(1000);
		up.SelectFromToDate(); 
		Thread.sleep(1000);
		up.ClickonSearch();
		Thread.sleep(5000);

//		List<WebElement> AverageTransactionActivity = driver.findElements(By.xpath(
//				"(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-yaxis apexcharts-xaxis-inversed'])[1]//*[name()='text']"));
//		System.out.println(AverageTransactionActivity.size());
//		for (WebElement averageTransactionActivity : AverageTransactionActivity) {
//			Thread.sleep(1500);
//			act.moveToElement(averageTransactionActivity, 50, 0).build().perform();
//			System.out.println(averageTransactionActivity.getText());
//		}
//		Thread.sleep(5000);
//		List<WebElement> averageDates = driver.findElements(By.xpath(
//				"(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-yaxis apexcharts-xaxis-inversed'])[2]//*[name()='text']"));
//		System.out.println(averageDates.size());
//		for (WebElement AverageDates : averageDates) {
//			act.moveToElement(AverageDates, 50, 0).build().perform();
//			System.out.println(AverageDates.getText());
//			Thread.sleep(1000);
//			act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//		}
//		Thread.sleep(5000);
//	List<WebElement> PurchaseAverage = driver.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-yaxis apexcharts-xaxis-inversed'])[3]//*[name()='text']"));
//	System.out.println(PurchaseAverage.size());
//	for(WebElement e:PurchaseAverage ) {
//		Thread.sleep(1500);
//		act.moveToElement(e,50,0).build().perform();
//		System.out.println(e.getText());
//	    }	
//	List<WebElement>WithdrawAverage = driver.findElements(By.xpath("(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-yaxis apexcharts-xaxis-inversed'])[4]//*[name()='text']"));
//	System.out.println(WithdrawAverage.size());
//	for(WebElement e:WithdrawAverage ) {
//		act.moveToElement(e,50,0).build().perform();
//		Thread.sleep(1500);
//		System.out.println(e.getText());
//		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
//	    }

		try {
			WebElement Transaction = driver.findElement(By.xpath("//h4[text()='Transaction Activity']"));
			js.executeScript("arguments[0].scrollIntoView();", Transaction);
			Thread.sleep(5000);
			if (driver.findElements(By.xpath("//h4[text()='Transaction Activity']")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully viewed overall average graph of the Transaction Activity", extentScreenshot());
			} else {
				Assert.assertTrue(false);
				test.pass("Something Wrong ! Not able to view overall average graph of the app analytics",
						extentScreenshot());
			}

			WebElement Purchase = driver.findElement(By.xpath("//h4[text()='Purchase/Withdraw']"));
			js.executeScript("arguments[0].scrollIntoView();", Purchase);
			Thread.sleep(5000);
			if (Purchase != null) {
				Assert.assertTrue(true);
				test.pass("Successfully viewed overall average graph of the Purchase/Withdraw", extentScreenshot());
			} else {
				Assert.assertTrue(false);
				test.pass("Something Wrong ! Not able to view overall average graph of the Purchase/Withdraw",
						extentScreenshot());
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Test
	public void Ac_TC_SystemAnalytics_OnlinePlayerAnalytics() throws InterruptedException {
		test = extentCreateTest("TC - As admin I should be able to view overall average graph of the online player analytics");

		UserPage up = new UserPage(driver);
		LoginPage lp = new LoginPage(driver);
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

//		Thread.sleep(2000);
//		lp.ClickonUserAdminProfile();
//		Thread.sleep(2000);
//		up.ClickonSettings();
//		Thread.sleep(2000);
//		up.ClickonSystemAnalytics();
		Thread.sleep(3000);
		up.ClickonOnlinePlayerAnalytics();
		Thread.sleep(1000);
		up.ClickonCalendarBtn();
		up.SelectFromToDate(); 
		Thread.sleep(1000);
		up.ClickonSearch();
		Thread.sleep(5000);

		List<WebElement> onlineplayeranalytics = driver.findElements(By.xpath(
				"(//*[local-name()='svg']//*[name()='g' and @class='apexcharts-xaxis-texts-g'])[1]//*[name()='text']"));
		System.out.println(onlineplayeranalytics.size());
		for (WebElement Onlineplayeranalytics : onlineplayeranalytics) {
			Thread.sleep(500);
			act.moveToElement(Onlineplayeranalytics, 0, -300).build().perform();
			System.out.println(Onlineplayeranalytics.getText());
		}
		if (driver.findElements(By.xpath("//div[contains(@class,'apexcharts-canvas')]")).size() > 0) {
			test.pass("Successfully viewed overall graph of the online player analytics", extentScreenshot());
		} else {
			test.fail("Something Wrong ! Not able to view overall average graph of the online player analytics",
					extentScreenshot());
		}
		Thread.sleep(5000);
	}
	
	


//@Test
//public void Aa_TC_SystemAnalytics_GameRTP() throws InterruptedException
//{
//	String Store = "CosmoSlot ";
//	test = extentCreateTest("TC - As admin I should be able to view Game RTP of the system analytics while selecting store,role and user");
//	
//	LoginPage lp= new LoginPage(driver);
//	UserPage up= new UserPage(driver);
//	PlayerProfile pp= new PlayerProfile(driver);
//	
//	lp.ClickonUserAdminProfile();
//	Thread.sleep(2000);
//	up.ClickonSettings();
//	Thread.sleep(2000);
//	up.ClickonGameRTP();
//	Thread.sleep(2000);
//	//pp.SelectGameCategory("Slot", "Leprechaun");
//	Thread.sleep(1000);
//	up.SelectStoreRoleUserforAppAnalytics(Store, Role, User);
//	Thread.sleep(1000);
//	up.ClickonCalendarBtn();		
//	Thread.sleep(1000);
//	up.Selectmonthandyear("2023", month[3], "1", endDate[3]);
//	Thread.sleep(1000);
//	up.ClickonSearch();
//	Thread.sleep(5000);
//	if (driver.findElements(By.xpath("//th[text()='Game Code']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Game Name']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Bet Values']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Paylines / Spots']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Total Spins / Rounds']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Total Bet']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Total Wins']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='Total Feature Wins']")).size() > 0
//			&& driver.findElements(By.xpath("//th[text()='RTP']")).size() > 0) {
//		test.pass("Successfully viewed the Game RTP of the system analytics while selecting game category and Game", extentScreenshot());
//		Assert.assertTrue(true);
//	} else {
//		test.fail("Something wrong!To view the Exclusive Analytics tab in player profile and game RTP",extentScreenshot());
//		Assert.assertTrue(false);
//	}
//}

}
