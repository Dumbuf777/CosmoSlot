/**
 * 
 */
package com.Cosmoslots.testCases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;


/**
 * @author shrikrushna.sonkar
 *
 */
public class MDB_Scenarios extends BaseClass {
	
	private LobbyPage lp;
	private UserPage up;
	private CommonCosmo cc;
	String store="store-25179";
	String PlayerToken = "";
	String playerRefreshToken = "";
	
	@Test
	public void A_MDB_CreateBonus_Spin() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Gameplay");
		test.info("As an admin I should be able to create MBD when event type is spins");
		gotoTab(driver, 0);
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_Spin_"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickDesc("MDB_Spin"+Constant.randNum2);
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Gameplay.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.set_SpinEventConfiguration("10","0");
		lp.set_GamePlay_ActionSection();
		lp.set_GamePlay_ReminderSection();
		test.info("Successfully configured MDB event type spin",extentScreenshot());
		Thread.sleep(3000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void Aa_MDB_CreateBonus_Spin_WithCustomDate() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Gameplay with custom date");
		test.info("As an admin I should be able to create MBD when event type is game with custom date");
		gotoTab(driver, 0);
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_SpinCustomDate"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickDesc("MDB_SpinCustomDate"+Constant.randNum2);
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Gameplay.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.set_SpinEventConfiguration("10","0");
		lp.set_GamePlay_ActionSection();
		lp.set_GamePlay_ReminderSection();
		lp.selectCustomDateToggle();
		lp.ClickonCustomStartDateCalendar();
		lp.selectCustomStartDate();
		lp.ClickonCustomExpiryDateCalendar();
		lp.selectCustomExpiryDate();
		test.info("Successfully configured MDB event type spin",extentScreenshot());
		Thread.sleep(3000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void B_MDB_CreateBonus_Login() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Login");
		test.info("As an admin I should be able to create MBD when event type is login");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_Login_"+Constant.randNum2);
		lp.ClickDesc("MDB_Login_5"+Constant.randNum2);
		lp.gameToken("5");
		lp.sweepToken("5");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Login.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.set_LoginEventConfigration("5");
		lp.set_GamePlay_ActionSection();
		lp.set_Login_ReminderSection();
		test.info("Successfully configured MDB event type login",extentScreenshot());
		Thread.sleep(3000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);


	}
	
	@Test
	public void Ba_MDB_CreateBonus_Login_WithCustomDate() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Login");
		test.info("As an admin I should be able to create MBD when event type is login with custom date");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_LoginCustomDate"+Constant.randNum2);
		lp.ClickDesc("MDB_LoginCustomDate"+Constant.randNum2);
		lp.gameToken("5");
		lp.sweepToken("5");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Login.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.set_LoginEventConfigration("5");
		lp.set_GamePlay_ActionSection();
		lp.set_Login_ReminderSection();
		lp.selectCustomDateToggle();
		lp.ClickonCustomStartDateCalendar();
		lp.selectCustomStartDate();
		lp.ClickonCustomExpiryDateCalendar();
		lp.selectCustomExpiryDate();
		test.info("Successfully configured MDB event type login with custom date ",extentScreenshot());
		Thread.sleep(3000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

		
	}
	
	@Test
	public void C_MDB_CreateBonus_LossMaking() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> LossMaking");
		test.info("As an admin I should be able to create MBD when event type is LossMaking");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_LossMaking_"+Constant.randNum2);
		lp.ClickDesc("MDB_LossMaking_"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_LossMaking.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
        lp.set_LossMakingEventConfiguration("5", "0");
		lp.set_LossMaking_ActionSection();
		test.info("Successfully configured MDB event type lossmaking",extentScreenshot());
		Thread.sleep(1000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);
	}
	
	@Test
	public void D_MDB_CreateBonus_Purchase_DepositAmount() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Purchase - Deposit amount ");
		test.info("As an admin I should be able to create MBD when event type is purchase deposit amount");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_Purchase_"+Constant.randNum2);
		lp.ClickDesc("MDB_Purchase_"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Purchase.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.selectDepositAmountToggle();
		lp.set_PurchaseEventConfiguration("On Deposit", "1","2");
//		lp.selectPurchasePackageToggle();
//		lp.set_PurchaseEventConfiguration("After Deposit", "1");
		lp.set_Purchase_DepositAmount_ActionSection();
		lp.set_Purchase_DepositAmount_ReminderSection("1");
		test.info("Successfully configured MDB event type purchase deposit amount",extentScreenshot());
		Thread.sleep(1000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void Da_MDB_CreateBonus_Purchase_DepositAmount_WithCustomDate() throws InterruptedException {
		test= extentCreateTest("MBD -> Purchase - Deposit amount with custom date");
		test.info("As an admin I should be able to create MBD when event type is purchase deposit amount");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_Purchase_CD"+Constant.randNum2);
		lp.ClickDesc("MDB_Purchase_CD"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Purchase.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.selectDepositAmountToggle();
		lp.set_PurchaseEventConfiguration("On Deposit", "1","2");
//		lp.selectPurchasePackageToggle();
//		lp.set_PurchaseEventConfiguration("After Deposit", "1");
		lp.set_Purchase_DepositAmount_ActionSection();
		lp.set_Purchase_DepositAmount_ReminderSection("1");
		lp.selectCustomDateToggle();
		lp.ClickonCustomStartDateCalendar();
		lp.selectCustomStartDate();
		lp.ClickonCustomExpiryDateCalendar();
		lp.selectCustomExpiryDate();
		test.info("Successfully configured MDB event type purchase deposit amount with custom date",extentScreenshot());
		Thread.sleep(1000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void E_MDB_CreateBonus_Purchase_PackagePurchase() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> package purchase ");
		test.info("As an admin I should be able to create MBD when event type is purchase - package");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_PurchasePkg_"+Constant.randNum2);
		lp.ClickDesc("MDB_PurchasePkg_"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Purchase.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.selectPurchasePackageToggle();
		lp.set_PurchaseEventConfiguration("On Purchase Package", "2","");
		lp.set_Purchase_DepositAmount_ActionSection();
		lp.set_Purchase_PackagePurchase_ReminderSection("1");
		test.info("Successfully configured MDB event type purchase - package",extentScreenshot());
		Thread.sleep(1000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void Ea_MDB_CreateBonus_Purchase_PackagePurchase_WithCustomDate() throws InterruptedException {
		test= extentCreateTest("MBD -> Purchase - Package with custom date");
		test.info("As an admin I should be able to create MBD when event type is purchase package with custom date");
		
		lp = new LobbyPage(driver);
		up = new UserPage(driver);
		cc = new CommonCosmo(driver);
		
		lp.GoToStoreView(store);
		lp.clickViewLobby_Bonus();
		Thread.sleep(1000);
		lp.SelectRadioBtn_MULTIPLE_DEPOSIT_BONUS();
		lp.clickTo_CreateBonus();
		lp.selectRole(LobbyEnum.storerole.getValue());
		lp.selectUsername(LobbyEnum.storeusername.getValue());
		lp.setBonusName("MDB_PurchasePkg_CD"+Constant.randNum2);
		lp.ClickDesc("MDB_PurchasePkg_CD"+Constant.randNum2);
		lp.gameToken("1");
		lp.sweepToken("1");
		lp.ClickonStartDateCalendar();
		up.selectStartDate();
		lp.ClickonExpiryDateCalendar();
		up.selectExpiryDate();
		lp.selectEventType(LobbyEnum.EventType_Purchase.getValue());
		lp.selectTraceType(LobbyEnum.TraceType_Hourly.getValue());
		lp.selectPurchasePackageToggle();
		lp.set_PurchaseEventConfiguration("On Purchase Package", "2","");
		lp.set_Purchase_DepositAmount_ActionSection();
		lp.set_Purchase_PackagePurchase_ReminderSection("1");
		lp.selectCustomDateToggle();
		lp.ClickonCustomStartDateCalendar();
		lp.selectCustomStartDate();
		lp.ClickonCustomExpiryDateCalendar();
		lp.selectCustomExpiryDate();
		test.info("Successfully configured MDB event type purchase package with custom date",extentScreenshot());
		Thread.sleep(1000);
		up.clickToSave();
		cc.VerifyDataCheck(cc.Validation_Format_AddBonus);

	}
	
	@Test
	public void F_MDB_ActiveInactive() throws InterruptedException {
		test= extentCreateTest("Multiple Deposit Bonus -> Active and Inactive");
		test.info("As an admin I should be able to active and inactive multiple deposit bonus");
		
		cc = new CommonCosmo(driver);
		WebElement MDBToggle = driver.findElement(By.xpath("(//mat-slide-toggle)[1]//input"));
		Thread.sleep(2000);
		if (MDBToggle.getAttribute("aria-checked").contains("false")) {
			Actions act = new Actions(driver);
			act.moveToElement(MDBToggle).click().build().perform();
			Thread.sleep(1000);
			if (cc.toggleVerification_Header.isDisplayed()) {
				test.pass("Successfully activated multiple deposit bonus", extentScreenshot());
				cc.Cancel.click();
			} else {
				test.fail("Something wrong! To able active/inactive MDB", extentScreenshot());
			}
		}

		
	}
	
	
	

}
