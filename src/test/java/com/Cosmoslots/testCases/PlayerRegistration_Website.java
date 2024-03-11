package com.Cosmoslots.testCases;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.ENUM.Constant;
import com.Cosmoslots.ENUM.LobbyEnum;
import com.Cosmoslots.ENUM.PlayerEnum;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.utilities.BaseClass;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

public class PlayerRegistration_Website extends BaseClass {

	BaseClass bc = new BaseClass();
	Random random = new Random();


	public void AddBonusOnAdmin(int levelnumber) throws InterruptedException, IOException {
		LobbyManagement lt = new LobbyManagement();
		LobbyPage lb = new LobbyPage(driver);

		lt.LobbyManagement_Bonus_Redirect(LobbyEnum.Lcode.getValue());
		Thread.sleep(1000);
		lb.SearchItems("Level Wise Referral Bonus");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
		Thread.sleep(1000);

		for (int i = 2; i <= levelnumber; i++) { // numberOfLevel
			lt.Add_LevelWiseBonus("Level" + i, 1, 1, Constant.BonusGL * i, Constant.BonusSL * i,
					"This is testing entry on Level Wise Bonus");
		}
	}

	@Test
	public void Player_Register() throws InterruptedException, IOException {
		test = extentCreateTest("Player Register in Website -> Get Invite Code ");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		PlayersProfile pt = new PlayersProfile();
		LobbyManagement lt = new LobbyManagement();
//		lobbycode = LobbyEnum.Lcode.getValue();
		PlayerEnum.lobbycode.setValue(LobbyEnum.Lcode.getValue());
		// SearchPlayerID="AT131-1533";
		String CustomPackageAdmin = LobbyEnum.search_CustomPackageName.getValue();
		String storecouponName = LobbyEnum.storecouponName.getValue();

		if (Constant.emailArray != null && !Constant.emailArray.isEmpty()) {
			//SearchPlayerID = Constant.emailArray.get(Constant.emailArray.size() - 1);
			PlayerEnum.SearchPlayerID.setValue(Constant.emailArray.get(Constant.emailArray.size() - 1));
		} else {
			//SearchPlayerID = LobbyEnum.Playerusername.getValue();
			PlayerEnum.SearchPlayerID.setValue( LobbyEnum.Playerusername.getValue());
		}

		System.out.println("player id->" + PlayerEnum.SearchPlayerID.getValue());
		gp.clickOnPlayerManagement();
		Thread.sleep(1000);
		pp.clickPlayerProfileLink();


		Thread.sleep(6000);
		if (driver.findElement(By.xpath("//h3[text()=\"Player Management\"]")) != null) {
			test.info("Opened Player Successfully");
			gp.Search_Items(PlayerEnum.SearchPlayerID.getValue());
			test.info("Searched Player Successfully", extentScreenshot());
			Thread.sleep(4000);
			pp.Clickeyeicon();
			Thread.sleep(1000);

			if (driver.findElement(By.xpath("//h3[text()=\"View Player Details\"]")) != null) {
				test.pass("Clicked Action Eye Icon and redirected to View Player Details", extentScreenshot());
				test.info("Verified User Details - OK");
				String playerCode = driver
						.findElement(By.xpath("//span[text()='Invite Code']//following-sibling::span[@class='ppTxt']"))
						.getText();
				//refcode = playerCode;
				PlayerEnum.refcode.setValue(playerCode);
				System.out.print("Invite code->" + PlayerEnum.refcode.getValue()); // prints PlayerId
				Assert.assertTrue(true);
			} else {
				test.fail("Verified User Details - FAIL", extentScreenshot());
				Assert.assertTrue(false);
			}
		}
		Thread.sleep(1000);
		BaseClass.gotoTab(driver, 1);
		PlayerLogout();

		/*
		 * scenario 1 : 1 player created verify email and check level up or not and get
		 * bonus or not scenario 2: scenario 1 and verify phone and check check level up
		 * or not and get bonus or not scenario 3: scenario 1 and scenario 2 and check
		 * level 5 cross or not
		 * 
		 */
		BaseClass.gotoTab(driver, 0);
		AddBonusOnAdmin(PlayerEnum.numberOfLevel.toInt()+1);
		BaseClass.gotoTab(driver, 1);

		for (int i = 1; i <= PlayerEnum.PlayersRegisration.toInt(); i++) {
			//First = BaseClass.Fakefirstname();
			PlayerEnum.First.setValue(Fakefirstname());
		//	Last = BaseClass.Fakelastname();
			PlayerEnum.Last.setValue(Fakelastname());
		//	pEmail = First + Last + i + "@yopmail.com";
			PlayerEnum.pEmail.setValue(PlayerEnum.First.getValue() + PlayerEnum.Last.getValue() + i + "@yopmail.com");
			String displayname = PlayerEnum.First.getValue() + Constant.randNum;
			System.out.println("\n player Email->" + PlayerEnum.pEmail.getValue());
			System.out.println("\n player displayname->" + displayname);

			// register new player
			PlayerRegister(PlayerEnum.First.getValue(), PlayerEnum.Last.getValue(), displayname, password, PlayerEnum.refcode.getValue());
			test.info("Player created successfully with <b> " + displayname + "</b>", extentScreenshot());
			// WebsiteLogin(email,Playerpass);
			// Thread.sleep(1000);
			BaseClass.gotoTab(driver, 0);

			// verify invite player in parent or not
			pt.PlayerProfile_InvitePlayer(PlayerEnum.SearchPlayerID.getValue(), PlayerEnum.pEmail.getValue());
			BaseClass.gotoTab(driver, 1);

			// email verification
			PlayerVarificaitonEmail(PlayerEnum.pEmail.getValue());

			// package purchase
			// PlayerPackagePurchase(CustomPackageAdmin,storecouponName);
			lt.VerifyPaymentFromAdmin(CustomPackageAdmin, "", PlayerEnum.pEmail.getValue());

			BaseClass.gotoTab(driver, 1);
			// check level up or not
			PlayerLogout();
			PlayerLogin(Integer.valueOf(i), PlayerEnum.SearchPlayerID.getValue());

			// new register player logout
			PlayerLogout();
			WebsiteLogin( PlayerEnum.pEmail.getValue(), Playerpass);

			// phone verification
			int random_int = (int) Math.floor(Math.random() * (PlayerEnum.max.toInt() - PlayerEnum.min.toInt() + i) + PlayerEnum.min.toInt());
			PlayerVarificaitonPhone(random_int);

//	        int phone=Integer.valueOf(BaseClass.Fakephone());
//	    	PlayerVarificaitonPhone(phone);       
			Thread.sleep(1000);
			PlayerLogout();
			// check level up or not
			PlayerLogin(Integer.valueOf(i + 1), PlayerEnum.SearchPlayerID.getValue());
			// Bonuses verification
			PlayerBonuses_Verify();
			BaseClass.gotoTab(driver, 0);
		}

//		Thread.sleep(2000);
//		lt.LobbyManagement_Bonus_Redirect(lt.Lcode);
//		Thread.sleep(1000);
//		lb.SearchItems("Level Wise Referral Bonus");	
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
//		Thread.sleep(1000); 
//		
//			for(int i=2; i<=numberOfLevel; i++) { //numberOfLevel
//				lt.Add_LevelWiseBonus("Level"+i, 1, 1, lt.BonusGL*i, lt.BonusSL*i, "This is testing entry on Level Wise Bonus");
//			}
//			
// 		BaseClass.gotoTab(driver, 1);
//		PlayerLogout();
//		PlayerLogin(Integer.valueOf(numberOfLevel));

		/*
		 * scenario 4 : level 1 present ,run script to register 3 player + add 2 & 3
		 * level and check level 3 cross or not?
		 * 
		 * 
		 * for(int i=1; i<=PlayersRegisration; i++) { First = BaseClass.Fakefirstname(); Last =
		 * BaseClass.Fakelastname(); pEmail=First+Last+i+"@yopmail.com";
		 * System.out.println("\n player Email->"+pEmail);
		 * 
		 * //register new player PlayerRegister(First,Last, pEmail, password, refcode);
		 * test.info("Player created successfully with <b> "+pEmail+"</b>",
		 * extentScreenshot()); //WebsiteLogin(email,Playerpass); //Thread.sleep(1000);
		 * // BaseClass.gotoTab(driver, 0);
		 * 
		 * //verify invite player in parent or not //
		 * pt.PlayerProfile_InvitePlayer(SearchPlayerID,pEmail); // BaseClass.gotoTab(driver,
		 * 1);
		 * 
		 * //email verification PlayerVarificaitonEmail();
		 * 
		 * 
		 * //package purchase PlayerPackagePurchase();
		 * 
		 * //Email verification //int phone=Integer.valueOf(BaseClass.Fakephone()); int
		 * random_int = (int)Math.floor(Math.random()*(max-min+i)+min);
		 * PlayerVarificaitonPhone(random_int);
		 * 
		 * //check level up or not // PlayerLogin(Integer.valueOf(i));
		 * 
		 * //new register player logout PlayerLogout();
		 * //WebsiteLogin(pEmail,Playerpass);
		 * 
		 * //check level up or not PlayerLogin(Integer.valueOf(i+1)); //Bonuses
		 * verification PlayerBonuses_Verify(); BaseClass.gotoTab(driver, 0); }
		 * 
		 * 
		 * Thread.sleep(2000); lt.LobbyManagement_Bonus_Redirect(lt.Lcode);
		 * Thread.sleep(1000); lb.SearchItems("Level Wise Referral Bonus");
		 * Thread.sleep(2000);
		 * driver.findElement(By.xpath("//a[@title='View Bonus Level']")).click();
		 * Thread.sleep(1000);
		 * 
		 * for(int i=2; i<=numberOfLevel; i++) { //numberOfLevel
		 * lt.Add_LevelWiseBonus("Level"+i, 1, 1, lt.BonusGL*i, lt.BonusSL*i,
		 * "This is testing entry on Level Wise Bonus"); }
		 * 
		 * BaseClass.gotoTab(driver, 1); PlayerLogout();
		 * PlayerLogin(Integer.valueOf(numberOfLevel));
		 * 
		 */

		/*
		 * scenario 5 : Disable bonus level from admin , run script to add 5 player and
		 * check next level cross or not it should displayed level 2 scenario 6 : now
		 * Enable bonus level from admin and check level 2 displayed or not?
		 * 
		 * 
		 * BaseClass.gotoTab(driver, 1); for(int i=1; i<=PlayersRegisration; i++) { First =
		 * BaseClass.Fakefirstname(); Last = BaseClass.Fakelastname();
		 * pEmail=First+Last+i+"@yopmail.com";
		 * System.out.println("\n player Email->"+pEmail);
		 * 
		 * //register new player PlayerRegister(First,Last, pEmail, password, refcode);
		 * test.info("Player created successfully with <b> "+pEmail+"</b>",
		 * extentScreenshot());
		 * 
		 * //email verification PlayerVarificaitonEmail();
		 * 
		 * //package purchase PlayerPackagePurchase();
		 * 
		 * //Email verification //int phone=Integer.valueOf(BaseClass.Fakephone()); int
		 * random_int = (int)Math.floor(Math.random()*(max-min+i)+min);
		 * PlayerVarificaitonPhone(random_int);
		 * 
		 * PlayerLogout(); }
		 * 
		 * //check level up or not //PlayerLogin(Integer.valueOf(5)); //Bonuses
		 * verification // PlayerBonuses_Verify(); // BaseClass.gotoTab(driver, 0);
		 * 
		 */

	}

	@Test
	public void PlayerPackagePurchase(String pack, String cpn) throws InterruptedException, IOException {
		LobbyManagement lm = new LobbyManagement();
		LobbyPage lb = new LobbyPage(driver);

		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.HOME);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//button[text()=\"Packages\"]"));
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", ele);

		driver.findElement(By.xpath("//button[text()=\"Packages\"]")).click();
		Thread.sleep(1500);

		driver.findElement(By.xpath("(//h1[.='" + pack + "']//following::a[text()='Purchase'])[1]")).click();
		Thread.sleep(2000);
		// apply coupon code
		lb.ApplyCouponCode(cpn);
		driver.findElement(By.xpath("(//h1[.='" + pack + "']//following::button[.='Purchase'])[1]")).click();
		Thread.sleep(3000);
		Thread.sleep(1500);
		LobbyManagement.switchToWindow("Skrill");
		lm.SkrilPayment();
		BaseClass.gotoTab(driver, 1);
		Thread.sleep(1500);
	}

	@Test
	public void PlayerLogout() throws InterruptedException, IOException {
		Thread.sleep(1000);

		// wr.clickOnUserprofile();
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]//following::span[@class='userName']"))
				.click();
		test.info("click on player profile in Website");
		Thread.sleep(1000);
		// pp.clickOnLogoutBtn();
		driver.findElement(By.xpath("//a[contains(text(),\"Logout\")]")).click();
		test.info("player logout in Website");
		PageReload();
	}

	@Test
	public void PlayerLogin(int level, String Player) throws InterruptedException, IOException {
		test = extentCreateTest("Player login -> " + PlayerEnum.SearchPlayerID.getValue());

		// level=level+1;
		// verify with player login
		// PlayerLogout();
		Thread.sleep(4000);
		WebsiteLogin( Player, Playerpass);
		test.info("player <b> " + Player + "</b> login in Website");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		Thread.sleep(1000);
		test.info("click on player profile in Website");
		Thread.sleep(1000);

		// verify bonus
		// test.info("<b>Level Wise Referral Bonus </b> displayed on
		// Website",extentScreenshot());

		if (driver.findElements(By.xpath("//h4[text()='Level " + level + "']")).size() > 0) {
			test.pass("Level ->" + level + " increased on Website", extentScreenshot());

			if (driver
					.findElements(By
							.xpath("(//h5[text()=\"No of Referral\"]/following::span[contains(text(),\"0 / 1\")])[1]"))
					.size() > 0) {
				test.pass("No of Referral = 0/1", extentScreenshot());
			} else {
				test.fail("No of Referral = 0/1", extentScreenshot());
			}
			if (driver
					.findElements(By.xpath(
							"(//h5[text()=\"Amount of recharge\"]/following::span[contains(text(),\"0 / 1\")])[1]"))
					.size() > 0) {
				test.pass("Amount of recharge = 0/1", extentScreenshot());

			} else {
				test.fail("Amount of recharge = 0/1", extentScreenshot());
			}
		} else {
			test.fail("Level ->" + level + " not increase on Website", extentScreenshot());
		}
		Thread.sleep(5000);
	}

	@Test
	public void PlayerBonuses_Verify() throws InterruptedException, IOException {
		Thread.sleep(1000);
		if (driver.findElements(By.xpath("(//button[text()='Bonuses'])[1]")).size() > 0) {
			// test.pass("<b>Level Wise Referral Bonus </b> displayed on
			// Website",extentScreenshot());
			driver.findElement(By.xpath("(//button[text()='Bonuses'])[1]")).click();
			Thread.sleep(2000);

			if (driver.findElements(By.xpath(
					"//th[text()=\"Bonus Type\"]/following::tr//td[contains(text(),\"Level Wise Referral Bonus\")]"))
					.size() > 0) {
				test.pass("<b>Level Wise Referral Bonus </b> displayed on Website", extentScreenshot());
			} else {
				test.fail("<b>Level Wise Referral Bonus </b>not displayed on Website", extentScreenshot());
			}
		} else {
			test.fail("<b>Level Wise Referral Bonus </b>not displayed on Website", extentScreenshot());
		}
		Thread.sleep(3000);
	}

	@Test
	public void PlayerVarificaitonEmail(String email) throws InterruptedException, IOException {
		test = extentCreateTest("Player Email & OTP verification on invited player");

//		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
//		test.info("click on player username in Website");
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//a[text()='Profile']")).click();
//		test.info("click on player proflie in Website");
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
//		driver.findElement(By.xpath("//button[text()=\"Profile\"]")).click();
		driver.get(WebURL + "/profile");
		test.info("redirect on player profile section in Website");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys(email);
//		PlayerEmailOTP("email",otp);
		// PlayerEmailOTP("phone",otp);
		Thread.sleep(2000);
	}

	@Test
	public void PlayerVarificaitonPhone(int random_int) throws InterruptedException, IOException {
		test = extentCreateTest("Player phone verification on invited player");
		GuestPlayers gp = new GuestPlayers(driver);

		gp.setDialCode("+91");
		// dail.selectByVisibleText("+91");

		test.info("player Dial code selected", extentScreenshot());
		Thread.sleep(1500);
		driver.findElement(By.xpath("//input[@formcontrolname=\"phone\"]")).sendKeys(String.valueOf(random_int));
		Thread.sleep(1500);
		test.info("player phone number added", extentScreenshot());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[text()='Save']")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(1000);
		test.info("save player profile details in Website");

		PlayerEmailOTP("email", PlayerEnum.otp.getValue());
		PlayerEmailOTP("phone", PlayerEnum.otp.getValue());
		Thread.sleep(1500);

	}

	@Test
	public void PlayerEmailOTP(String str, String otp) throws InterruptedException, IOException {

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		if (driver
				.findElements(By.xpath(
						"(//input[@formcontrolname='" + str + "']//following::button[text()=\"Verification\"])[1]"))
				.size() > 0)
		// ||
		// driver.findElements(By.xpath("//span[contains(@class,'verify')]")).size()>0 )
		{
			Thread.sleep(1000);
			driver.findElement(By
					.xpath("(//input[@formcontrolname='" + str + "']//following::button[text()=\"Verification\"])[1]"))
					.click();
			test.info("click on varification button to verify ->" + str, extentScreenshot());
			Thread.sleep(1000);

			if (driver.findElements(By.xpath("//h2[text()=\"Enter OTP\"]")).size() > 0) {
				// Thread.sleep(10000);
				driver.findElement(By.xpath("(//h2[text()=\"Enter OTP\"]//following::input[@type='text'])[1]"))
						.sendKeys(otp);
				test.info("OTP screen open to enter otp on ->" + str, extentScreenshot());
				Thread.sleep(1000);
				// driver.findElement(By.xpath("//h2[text()=\"Enter OTP\"]")).sendKeys("0");
				driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
				Thread.sleep(1000);
				// if(driver.findElements(By.xpath("//div[contains(text(),\"Email has been
				// verified\")]")).size()>0)
				// {
				// Thread.sleep(3000);
				if (driver.findElements(By.xpath(
						"(//input[@formcontrolname='" + str + "']//following::span[contains(@class,'verify')])[1]"))
						.size() > 0) {
					test.pass(str + " Varification Done on Website", extentScreenshot());
				} else {
					test.fail(str + " not found on Website", extentScreenshot());
				}
//					 }
//					 else
//					 {
//						 test.fail(str+" not found on Website",extentScreenshot());
//					 }

			} else {
				test.fail("Email verified message not found on Website", extentScreenshot());
			}
		} else {
			test.info(str + " Varification Already Done on Website", extentScreenshot());
		}

	}

	 
	@Test
	public void PlayerRegister(String fnm, String lnm, String playeremail, String playerpass, String playercode)
			throws InterruptedException, IOException {
		test = extentCreateTest("New Player Register on Website");

		GuestPlayers gp = new GuestPlayers(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);

		BaseClass.gotoTab(driver, 1);
		PageReload();Thread.sleep(2000);
		test.info("Testcase started for Player Registration");

		if (driver.findElements(By.xpath("//div[contains(@class,'dropdown userDropDownBlock')]")).size() > 0) {
			wr.clickOnUserprofile();
			Thread.sleep(3000);
			gp.ClickOnLogout();
			Thread.sleep(2000);
			PageReload();
			Thread.sleep(2000);
			gp.clickOnNewPlayerRegistration();
		} else {
			PageReload();
			gp.clickOnNewPlayerRegistration();
		}

		Thread.sleep(500);
		if (driver.findElement(By.xpath("//h2[text()='Sign Up']")) != null) {
			test.pass("Opened player registration", extentScreenshot());
			Assert.assertTrue(true);

			gp.SendFirstName(fnm);
			Thread.sleep(1000);
			gp.SendLastName(lnm);
			Thread.sleep(1000);
			// gp.SendEmail(playeremail);
			gp.setDisplayName1(playeremail);
			Thread.sleep(1000);
			gp.SendPassword(playerpass);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@formcontrolname='inviteCode']")).sendKeys(playercode);
//	            gp.ClickOnSpecialOfferCheckBox();
			Thread.sleep(1000);
			gp.ClickOnTermsOfUserCheckBox();
			gp.ClickOnSignup();
			// Account has been Successfully Created
			Thread.sleep(2000);

			// Firstnm,Lastnm,Email,Playerpass
			test.info("Player created successfully with <b> " + playeremail + "</b>", extentScreenshot());
			System.out.println("\n player Email->" + playeremail);
			System.out.println("invite code for " + playeremail + " is -> " + playercode);
		} else {
			test.fail("Something wrong!To Open player registration", extentScreenshot());
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
	}
}
