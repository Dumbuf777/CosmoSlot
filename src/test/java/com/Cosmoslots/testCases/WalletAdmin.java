package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.LoginPage;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class WalletAdmin extends BaseClass {
	BaseClass bc = new BaseClass();
	// LobbyManagement lt=new LobbyManagement();

	String Firstnm = bc.Fakefirstname();
	String Lastnm = bc.Fakelastname();
	String Usernm = Firstnm + Lastnm;
	String Email = bc.FakeEmail();
	String Upload_Icon = UploadImage;
	String packge = "NEW package";
	String searchItemSupportRequest = "GJTS-SR-1079";
	String searchItemPlayerLedger = "Deposit";
	String searchItemTrancsationHistory = "Bank";
	String searchItemPurchaseHistory = "GJTS-1086";
	String searchPlayer = "CS-1400";
	String skrill_Id = "itsupport@ombpmllp.com";
	String cashapp_Id = "cashapp@yopmail.com";
	String checkStatus = "";
	double paymentValue;
	String paymentway = "Deposits";
	String paymentMethodFromWebsite = "Paysafe";
	String SearchItemWithdrawRequest = " Bank Account";
	String pass = "Gameium@1234";
	String Trans_Type = "";
	double amount = 1;

	public String[] strAr = { "CashApp ", "Manual ", "Others ", "Paysafe ", "Skrill ", "Bank Card " };
	// public String[] Player_PayementMethod = {"zen", "skrill", "paysafe","other"};
	public String[] Player_PayementMethod = { " Bank Card ", " Skrill ", " Paysafe ", " Other " };

	@Test
	public void B_TC_WalletDeposit_Status() throws InterruptedException, IOException {
		paymentway = "Deposits";
		paymentMethodFromWebsite = "Paysafe";
		Verify_WalletDeposit(paymentMethodFromWebsite, paymentway);
	}

	public void websiteMenu_Verify() throws IOException, InterruptedException {
		BaseClass.gotoTab(driver, 1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@class,'userDropDownBlock')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
	}

	@Test
	public void A_Website_WalletDeposit() throws InterruptedException, IOException {
		test = extentCreateTest("Website Wallet Deposit/Withdraw");
		test.info("TestCase started Website Wallet Deposit/Withdraw");
		paymentMethodFromWebsite = "";
		paymentway = "";
		BaseClass.gotoTab(driver, 1);
		Thread.sleep(1000);
		WebsiteLogin(searchPlayer, pass);
		Thread.sleep(2000);
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);

		// Website_AddAmounToWallet_ZenPayment();
		// Website_AddAmounToWallet_paysafePayment();
		// Website_AddAmounToWallet_SkrillPayment();
		// Website_AddAmounToWallet_OtherPayment();
	}

	@Test
	public void Aa_Website_AddAmounToWallet_ZenPayment() throws InterruptedException, IOException {
		test = extentCreateTest("Website Add Amount To Wallet -> ZenPayment");
		test.info("TestCase started Website Add Amount To Wallet -> ZenPayment");

		BaseClass.gotoTab(driver, 1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]")));
		Thread.sleep(2000);

		WebElement addAmountClick = driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]"));
		//clickon(driver, addAmountClick, 10);

		if (driver.findElement(By.xpath("(//h2[normalize-space()='Add Amount'])[1]")) != null) {
			Thread.sleep(5000);

			PlayerPurchase_Website(" Bank Card ", amount);
		}
	}

	@Test
	public void Ab_Website_AddAmounToWallet_paysafePayment() throws InterruptedException, IOException {
		test = extentCreateTest("Website Add Amount To Wallet -> paysafe");
		test.info("TestCase started Website Add Amount To Wallet -> paysafe");
		BaseClass.gotoTab(driver, 1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]")));
		WebElement addAmountClick = driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]"));
		//clickon(driver, addAmountClick, 10);

		if (driver.findElement(By.xpath("(//h2[normalize-space()='Add Amount'])[1]")) != null) {
			Thread.sleep(5000);
			PlayerPurchase_Website(" Paysafe ", amount);
		}
	}

	@Test
	public void Ac_Website_AddAmounToWallet_SkrillPayment() throws InterruptedException, IOException {
		test = extentCreateTest("Website Add Amount To Wallet -> skrill");
		test.info("TestCase started Website Add Amount To Wallet -> skrill");
		BaseClass.gotoTab(driver, 1);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]")));
		WebElement addAmountClick = driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]"));
		//clickon(driver, addAmountClick, 10);

		if (driver.findElement(By.xpath("(//h2[normalize-space()='Add Amount'])[1]")) != null) {
			Thread.sleep(5000);
			PlayerPurchase_Website(" Skrill ", amount);
		}
	}

	@Test
	public void Ad_Website_AddAmounToWallet_OtherPayment() throws InterruptedException, IOException {
		test = extentCreateTest("Website Add Amount To Wallet -> other");
		test.info("TestCase started Website Add Amount To Wallet -> other");

		BaseClass.gotoTab(driver, 1);
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]")));

		WebElement addAmountClick = driver.findElement(By.xpath("//button[contains(text(),'Add Amount')]"));
		//clickon(driver, addAmountClick, 10);

		if (driver.findElement(By.xpath("(//h2[normalize-space()='Add Amount'])[1]")) != null) {
			Thread.sleep(5000);
			PlayerPurchase_Website(" Other ", amount);
		}
	}

	public void PlayerPurchase_Website(String Skrillmethod, double val) throws IOException, InterruptedException {
		test = extentCreateTest(
				"Verify wallet added amount from Website by Player with -> " + Skrillmethod + " and amount is $" + val);
		test.info("Verify wallet added amount from Website by Player with -> " + Skrillmethod + "  and amount is $"
				+ val);

		try {
			// apply coupon code
			// lb.ApplyCouponCode(storecouponName);
			// driver.findElement(By.xpath("//input[@id='"+Skrillmethod+"']")).click();
			checkStatus = "deposit";
			System.out.println("-" + Skrillmethod + "-");
			Thread.sleep(2000);
			WebElement SkrillmethodClick = driver.findElement(By.xpath("//label[text()='" + Skrillmethod + "']"));
			//clickon(driver, SkrillmethodClick, 10);

			Thread.sleep(2000);
			if (Skrillmethod.equalsIgnoreCase(" Bank Card ")) {
				WebElement Amount_Sendkeys = driver.findElement(
						By.xpath("//h2[contains(text(),'Add Amount')]//following::input[@placeholder='Amount']"));
				//sendKeys(driver, Amount_Sendkeys, 10, String.valueOf(val));
				WebElement AddAmount_click = driver.findElement(By.xpath(
						"//h2[contains(text(),'Add Amount')]//following::button[contains(text(),'Add Amount')]"));
				//clickon(driver, AddAmount_click, 10);

				test.info("Opened Zen(Card payment) window", extentScreenshot());
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='add_payment']")));
				Thread.sleep(5000);

				if (driver.findElements(By.xpath("//iframe[@id='add_payment']")).size() > 0) {
					WebElement frameElement = driver.findElement(By.id("add_payment"));
					driver.switchTo().frame(frameElement);
					Thread.sleep(5000);
					WebElement cardNum = driver.findElement(By.xpath("//input[@id='cardNum']"));
					//sendKeys(driver, cardNum, 10, "4111111111111111");
					WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
					//sendKeys(driver, email, 10, "testing@yopmail.com");
					WebElement expiryDate = driver.findElement(By.xpath("//input[@id='expiryDate']"));
					//sendKeys(driver, expiryDate, 10, "1126");

					Thread.sleep(1000);
					WebElement cvv = driver.findElement(By.xpath("//input[@id='cvv']"));
					//sendKeys(driver, cvv, 10, "123");
					WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
					//sendKeys(driver, firstName, 10, "josh");
					WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
					//sendKeys(driver, lastName, 10, "Cena");
					WebElement zip = driver.findElement(By.xpath("//input[@name='zip']"));
					//sendKeys(driver, zip, 10, "ABC123123");
					WebElement address = driver.findElement(By.xpath("//input[@name='address']"));
					//sendKeys(driver, address, 10, "smith road,josn cena house, 101");
					WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
					//sendKeys(driver, city, 10, "dieogo");
					WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
					//sendKeys(driver, state, 10, "CA");
					WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
					//sendKeys(driver, phoneNumber, 10, "7894561232");
					WebElement payBtn_click = driver.findElement(By.xpath("//button[@id='payBtn']"));
					//clickon(driver, payBtn_click, 10);

					driver.switchTo().defaultContent();
					if (driver.findElements(By.xpath("//div[text()='Payment initiated and is under process!']"))
							.size() > 0) {
						test.pass("Payment initiated and is under process! in Website using zenpayment",
								extentScreenshot());
						WebElement OKBtn_click = driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
						//clickon(driver, OKBtn_click, 10);

						// driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
						Thread.sleep(500);
					} else {
						test.fail("zenpayment cancelled in Website", extentScreenshot());
					}

					VerifyWalletPaymentTransactions_Website();
					VerifyWalletBallance_Website();
					VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
					VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "deposit");
				}
			} else if (Skrillmethod.equalsIgnoreCase(" Paysafe ")) {
				Thread.sleep(2000);
				test.info("Opened Paysafe payment window", extentScreenshot());
				Thread.sleep(5000);

				System.out.println("-" + Skrillmethod + "-");
				Thread.sleep(2000);
				// driver.findElement(By.xpath("//input[@id='"+Skrillmethod+"']")).click();
				System.out.println(driver.findElement(By.xpath("//label[text()='" + Skrillmethod + "']")));

				if (driver.findElements(By.xpath("//label[text()='Country']")).size() > 0) {
					driver.findElement(By.xpath(
							"(//label[contains(text(),'Country')]//following::ng-select[contains(@class,'searchable')])[1]"))
							.click();
					driver.findElement(By.xpath(
							"//ng-dropdown-panel[@aria-label=\"Options list\"]//following::span[text()='India']"))
							.click();
					driver.findElement(By.xpath(
							"(//label[contains(text(),'State')]//following::ng-select[contains(@class,'searchable')])[1]"))
							.click();
					driver.findElement(By.xpath(
							"//ng-dropdown-panel[@aria-label=\"Options list\"]//following::span[text()='Assam']"))
							.click();
					driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Baroda");
					driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Address");
					driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("A1B2C3D4");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(String.valueOf(val));
					driver.findElement(By.xpath(
							"//h2[contains(text(),'Add Amount')]//following::button[contains(text(),'Add Amount')]"))
							.click();

					PaysafePayment("add");
					VerifyWalletPaymentTransactions_Website();
					VerifyWalletBallance_Website();
					VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
					VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "deposit");
				}
			} else if (Skrillmethod.equalsIgnoreCase(" Skrill ")) {

				System.out.println("-" + Skrillmethod + "-");
				Thread.sleep(2000);
				// driver.findElement(By.xpath("//input[@id='"+Skrillmethod+"']")).click();
				System.out.println(driver.findElement(By.xpath("//label[text()='" + Skrillmethod + "']")));

				driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(String.valueOf(val));
				driver.findElement(By
						.xpath("//h2[contains(text(),'Add Amount')]//following::button[contains(text(),'Add Amount')]"))
						.click();

				test.info("Opened Skrill window", extentScreenshot());
				Thread.sleep(5000);
				switchToWindow("Skrill");
				Thread.sleep(500);
				SkrilPayment();
				Thread.sleep(1000);
				BaseClass.gotoTab(driver, 1);

				VerifyWalletPaymentTransactions_Website();
				VerifyWalletBallance_Website();
				VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
				VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "deposit");
			} else {
				driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(String.valueOf(val));
				driver.findElement(By
						.xpath("//h2[contains(text(),'Add Amount')]//following::button[contains(text(),'Add Amount')]"))
						.click();
				test.info("Wallet details shared in support");
			}

		} catch (Exception e) {
			System.out.println("something went wrong - not able to match payment method " + e);
			test.info("something went wrong - not able to match payment method " + e);
		}
		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
	}

	public void VerifyPaymentInAdmin_WalletDeposit(String player, String str) throws IOException, InterruptedException {
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage_Old lp = new LobbyPage_Old(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		BaseClass.gotoTab(driver, 0);
		Thread.sleep(1500);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		test.info("Clicked on Player Management");
		pp.clickonWallet();
		Thread.sleep(300);

		if (str.equalsIgnoreCase("deposit")) {
			pp.clickonWallet_Deposits();
			Thread.sleep(2000);

			if (driver.findElement(By.xpath("//h3[contains(text(),\"Wallet Deposit\")]")) != null) {
				test.info("Opened Wallet Deposit Successfully on player profile from Admin");
				if (paymentway.equalsIgnoreCase("Initiate")) {
					if (paymentMethodFromWebsite.equalsIgnoreCase("Skrill")) {
						driver.findElement(By.xpath(
								"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]"))
								.click();
					} else if (paymentMethodFromWebsite.equalsIgnoreCase("Paysafe")) {
						driver.findElement(By.xpath(
								"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Paysafe Initiated\"]"))
								.click();
					} else {
						driver.findElement(By.xpath(
								"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Bank Card Initiated\")]"))
								.click();
					}
				} else {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),'Deposits')]"))
							.click();
				}
				Thread.sleep(500);
				gp.Search_Items(player);
				Thread.sleep(1500);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.findElements(By.xpath(
						"//th[text()=\"Player Id\"]/following::tr//td[contains(@class,'cdk-column-playerInfo-playerId')]"))
						.size() > 0) {
					lp.View_Click();
					Thread.sleep(1000);
					test.info("Successfully Searched Website <b>player ID</b>", extentScreenshot());
					lp.ClickToClose();
					Thread.sleep(300);
					// driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
					// Thread.sleep(2000);
				} else {
					test.fail("Something wrong !! To Search Website player ID", extentScreenshot());
				}
			} else {
				test.fail("Something wrong !! Player wallet deposit record not found", extentScreenshot());
			}
		} else if (str.equalsIgnoreCase("withdraw")) {

			pp.clickonWallet_WithdrawRequest();

			if (driver.findElement(By.xpath("//h3[contains(text(),\"Wallet Withdraw Request\")]")) != null) {
				test.info("Opened   Wallet Withdraw Request Successfully on player profile from Admin");

				Thread.sleep(500);
				gp.Search_Items(player);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if (driver.findElements(By.xpath(
						"//th[text()=\"Player Id\"]/following::tr//td[contains(@class,'cdk-column-playerInfo-playerId')]"))
						.size() > 0) {
					lp.View_Click();
					Thread.sleep(1000);
					test.info("Successfully Searched Website <b>player ID</b>", extentScreenshot());
					lp.ClickToClose();
					Thread.sleep(300);
				} else {
					test.fail("Something wrong !! To Search Website player ID", extentScreenshot());
				}
			} else {
				test.fail("Something wrong !! Player wallet Withdraw  record not found", extentScreenshot());
			}
		}
	}

	public static void switchToWindow(String windowTitle) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (String windowHandle : driver.getWindowHandles()) {
			String title = driver.getTitle();
			driver.switchTo().window(windowHandle);
			if (title.equalsIgnoreCase(windowTitle)) {
				driver.manage().window().maximize();
				break;
			}
		}
	}

	public void SkrilPayment() throws IOException, InterruptedException {
		String SkrillEmail = "itsupport@ombpmllp.com";
		String SkrillPass = "Dell#mc@123";

		if (driver.getTitle().equalsIgnoreCase("Skrill")) {
			Thread.sleep(3000);
			test.info("<b>Skrill</b> payment window found in Website", extentScreenshot());
			driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(SkrillEmail);
			driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(SkrillPass);
			driver.findElement(By.xpath("//button[contains(@class,'digital-wallet-login-form__submit-button')]"))
					.click();
			Thread.sleep(5000);
			// Thread.sleep(2000);
			driver.findElement(By.xpath("//button[contains(@class,'pay-with-balance-button')]")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			test.info("<b>Skrill</b> payment details found in Website", extentScreenshot());
			js.executeScript("arguments[0].click()",
					driver.findElement(By.xpath("//button//span[contains(text(),'CONFIRM')]")));
			Thread.sleep(4000);
			driver.findElement(By.xpath("//button[contains(@class,'return-button')]")).click();
			test.info("StorePackage <b>Skrill</b> details found in Website", extentScreenshot());

			Thread.sleep(5000);
			if (driver.findElements(By.xpath("//div[@class=\"thank-you-img\"]")).size() > 0) {
				System.out.println("match thank you page");
				Thread.sleep(2000);
			} else {
				System.out.println("not able to find thank you page");
			}
		} else {
			test.info("Skrill payment window not found in Website", extentScreenshot());
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
	}

	public void PaysafePayment(String check) throws IOException, InterruptedException {
		Thread.sleep(3000);
		WebElement frameElement = driver.findElement(By.id("paysafe-checkout"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(5000);
		Thread.sleep(2000);
		if (check == "add") {
			if (driver.findElements(By.xpath("//h1[contains(text(),'Make Your Payment')]")).size() > 0) {
				Thread.sleep(2000);
				test.info("<b>Paysafe</b> payment window found in Website", extentScreenshot());
				driver.findElement(
						By.xpath("//div[contains(@class,'pay-with-icon')]//preceding::li[@class='payment-methods']"))
						.click();

				if (driver.findElements(By.xpath("//h4[contains(text(),' Add New Card ')]")).size() > 0) {
					driver.findElement(By.xpath("//input[@formcontrolname='cardNumber']")).sendKeys("4111111111111111");
					driver.findElement(By.xpath("//input[@formcontrolname='cardHolderName']")).sendKeys("Smith torent");
					driver.findElement(By.xpath("//input[@id='cardExpiryMonth']")).sendKeys("11");
					driver.findElement(By.xpath("//input[@id='cardExpiryYear']")).sendKeys("2026");
					Thread.sleep(1000);
					// driver.findElement(By.xpath("//input[@id='cardExpiryYear']")).sendKeys(Keys.TAB);
					driver.findElement(By.xpath("//input[@id='cardSecurityCode']")).sendKeys("123");

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",
							driver.findElement(By.xpath("//span[text()='Pay']")));
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//span[text()='Pay']")).click();
					Thread.sleep(5000);
					// driver.switchTo().defaultContent();
					if (driver.findElements(By.xpath("//h2[text()='Payment Successful']")).size() > 0) {
						test.pass("<b>Payment Successful</b>   in Website", extentScreenshot());
					} else {
						test.fail("<b>Payment has not been Successful</b>  in Website", extentScreenshot());
					}
				}
			} else {
				test.info("paysafe-Skrill payment window not found in Website", extentScreenshot());
				Thread.sleep(2000);
			}
		} else if (check == "withdraw") {
			if (driver.findElements(By.xpath("//h1[contains(text(),'Secure Withdrawal')]")).size() > 0) {
				Thread.sleep(2000);
				test.info("<b>Paysafe</b> payment window found in Website", extentScreenshot());
				driver.findElement(
						By.xpath("//div[contains(@class,'pay-with-icon')]//preceding::li[@class='payment-methods']"))
						.click();

				if (driver.findElements(By.xpath("//h4[contains(text(),' Add New Card ')]")).size() > 0) {

					driver.findElement(By.xpath("//input[@formcontrolname='cardNumber']")).sendKeys("4900880000000008");
					driver.findElement(By.xpath("//input[@formcontrolname='cardHolderName']")).sendKeys("Smith torent");
					driver.findElement(By.xpath("//input[@id='cardExpiryMonth']")).sendKeys("11");
					driver.findElement(By.xpath("//input[@id='cardExpiryYear']")).sendKeys("2026");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//input[@id='cardSecurityCode']")).sendKeys("123");

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",
							driver.findElement(By.xpath("//span[text()='Withdraw']")));
					driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
					// Thread.sleep(1000);
					driver.findElement(By.xpath("//span[text()='Withdraw']")).click();
					Thread.sleep(5000);
					driver.navigate().refresh();
					Thread.sleep(5000);
					// driver.switchTo().defaultContent();
					if (driver.findElements(By.xpath("//h2[text()='Withdrawal Successful']")).size() > 0) {
						test.pass("<b>Withdraw Successful</b>   in Website", extentScreenshot());
					} else {
						test.fail("<b>Withdraw Payment has not been Successful</b>  in Website", extentScreenshot());
					}
				}
			} else {
				test.info("paysafe-Skrill payment window not found in Website", extentScreenshot());
				Thread.sleep(2000);
			}
		}

		Thread.sleep(2000);
	}

	public void VerifyPaymentInAdmin_Wallet(String status, String type, String method)
			throws InterruptedException, IOException {
		BaseClass.gotoTab(driver, 0);
		driver.navigate().refresh();
		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(500);
		pp.clickOnPlayerProfile();
		Thread.sleep(1000);
		gp.Search_Items(searchPlayer);
		Thread.sleep(1000);
		pp.Clickeyeicon();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space(text())=\"Manage Wallet\"]")).click();
		if (driver.findElements(By.xpath("//tbody//tr[1]//td//span[contains(text(),'" + status + "')]")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + type + "']")) != null
				&& driver.findElements(By.xpath("//tbody//tr[1]//td[normalize-space()='" + method + "']")) != null) {
			test.pass("Successfully found  record in mange wallet by player");
		} else {
			test.fail("not record found in wallet listing");
		}
	}

	public void VerifyWalletPaymentTransactions_Website() throws IOException, InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		Thread.sleep(500);
		if (driver.findElement(By.xpath("(//button[contains(.,'Wallet')])[1]")) != null) {
			test.pass("Successfully Opened Website Wallet screen");
			driver.findElement(By.xpath("//button[text()='Wallet']")).click();

			paymentMethodFromWebsite = driver
					.findElement(
							By.xpath("(//th[text()=\"Payment Method\"]/following::tr//td[contains(text(),\"\")])[4]"))
					.getText();
			Trans_Type = driver
					.findElement(
							By.xpath("(//th[text()=\"Transaction Type\"]/following::tr//td[contains(text(),\"\")])[3]"))
					.getText();
			Thread.sleep(1000);

			if (driver.findElement(By.xpath("(//th[text()='Status']/following::tr//td[contains(text(),'')])[6]"))
					.getText().equalsIgnoreCase("Initiate")) {
				Thread.sleep(500);
				test.info("wallet Transaction Details with <b>Initiate</b>", extentScreenshot());
				paymentway = "Initiate";
			} else if (driver.findElement(By.xpath("(//th[text()='Status']/following::tr//td[contains(text(),'')])[6]"))
					.getText().equalsIgnoreCase("Pending")) {
				Thread.sleep(500);
				test.info("wallet Transaction Details with <b>Pending</b>", extentScreenshot());
				paymentway = "Pending";
			} else if (driver.findElement(By.xpath("(//th[text()='Status']/following::tr//td[contains(text(),'')])[6]"))
					.getText().equalsIgnoreCase("Cancelled")) {
				Thread.sleep(500);
				test.info("wallet Transaction Details with <b>Cancelled</b>", extentScreenshot());
				paymentway = "Cancelled";
			} else if (driver.findElement(By.xpath("(//th[text()='Status']/following::tr//td[contains(text(),'')])[6]"))
					.getText().equalsIgnoreCase("Failed")) {
				Thread.sleep(500);
				test.info("wallet Transaction Details with <b>Failed</b>", extentScreenshot());
				paymentway = "Failed";
			} else {
				Thread.sleep(500);
				paymentway = "Success";
				test.info(" wallet Transaction Details with <b>Success</b>", extentScreenshot());
			}
			Thread.sleep(500);
		} else {
			test.fail("Something wrong!To Open Website wallet Transactions screen", extentScreenshot());
		}
		Thread.sleep(2500);
	}

	public void VerifyWalletBallance_Website() throws IOException, InterruptedException {
		test = extentCreateTest("Wallet My Balance ->  Verify");
		test.info("TestCase started - As a player I should able to verify Wallet My Balance");
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		String walletbalance = "";
		walletbalance = driver.findElement(By.xpath("(//span[text()='My Wallet Balance']//following::span)[1]"))
				.getText();
		walletbalance = walletbalance.substring(1, walletbalance.length());
		double wbalance = Double.valueOf(walletbalance);

		if (paymentway == "Success") {
			test.info("Last wallet balance is -> " + "$" + wbalance);
			if (checkStatus == "withdraw") {
				wbalance = wbalance - amount;
				test.info("<b> updated wallet balance is -> " + "$" + wbalance + "</b>");
			} else {
				wbalance = wbalance + amount;
				test.info("<b> updated wallet balance is -> " + "$" + wbalance + "</b>");
			}
		} else {
			test.info("Transaction is not success so wallet Balance not updated");
			test.info("Last wallet balance is -> " + "$" + wbalance, extentScreenshot());
		}
		test.info("TestCase End - As a player I should able to verify Wallet My Balance");
	}

	public void Verify_WalletDeposit(String method, String way) throws InterruptedException, IOException {
		test = extentCreateTest("Wallet Deposit -> Check payment status");

		PlayerProfile pp = new PlayerProfile(driver);
		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage_Old lp = new LobbyPage_Old(driver);

		BaseClass.gotoTab(driver, 0);
		driver.navigate().refresh();

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(300);
		test.info("Clicked on Player Management");
		pp.clickonWallet_WithdrawRequest();

		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//h3[contains(text(),\"Wallet Deposit\")]")) != null) {
			test.info("Opened Wallet  Deposit Successfully  from Admin");

			if (way.equalsIgnoreCase("Initiate")) {
				test.info("initiate Wallet  Deposit check");
				if (method.equalsIgnoreCase("Skrill")) {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Skrill Initiated\")]"))
							.click();
					Thread.sleep(1000);
					test.info("skrill initiate Payment check", extentScreenshot());
				} else if (method.equalsIgnoreCase("Paysafe")) {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Paysafe Initiated\")]"))
							.click();
					Thread.sleep(1000);
					test.info("Paysafe initiate Payment check", extentScreenshot());
				} else {
					driver.findElement(By.xpath(
							"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Bank Card Initiated\")]"))
							.click();
					Thread.sleep(1000);
					test.info("Bank card initiate Payment check", extentScreenshot());
				}
			} else {
				driver.findElement(By.xpath(
						"//div[@class=\"tokanFilterCheckboxBlock\"]//following::span[contains(text(),\"Deposits\")]"))
						.click();
				Thread.sleep(2000);
				test.info("check Deposits status", extentScreenshot());
			}
			Thread.sleep(2000);
			gp.Search_Items(method);
			Thread.sleep(3000);
			System.out.println("Payment method searched -" + method);
			test.info("Payment method searched -" + method);

			// paymentway=paymentway.toLowerCase();
			if (driver
					.findElements(By.xpath(
							"(//th[text()='Payment Method']//following::tr//td[contains(text(),'" + method + "')])[1]"))
					.size() > 0) {
				test.pass("Successfully Viewed " + method + " data on  Wallet Deposit page", extentScreenshot());
				lp.View_Click();
				Thread.sleep(1000);
				test.info("Successfully Searched Website <b>Transactions ID</b>", extentScreenshot());
				lp.ClickToClose();
				Thread.sleep(300);
				// driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
				// Thread.sleep(2000);
			} else {
				test.fail("Something wrong !! Player Wallet " + method + " not found", extentScreenshot());
			}
		} else {
			test.fail("Something wrong !! Player Wallet Deposit not found", extentScreenshot());
		}
	}

	@Test
	public void Bb_TC_WalletDeposit_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("WalletDeposit -> Redirect");
		test.info("TestCase started - As an admin user I should able to view WalletDeposit screen ");

		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		GuestPlayers gp = new GuestPlayers(driver);
		LobbyPage_Old lp = new LobbyPage_Old(driver);
		BaseClass.gotoTab(driver, 0);
		driver.navigate().refresh();

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(300);
		test.info("Clicked on Player Management");
		pp.clickonWallet_Deposits();
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Deposit\"]")) != null) {
			test.pass("Successfully Opened Wallet deposit screen");
			gp.Search_Items(paymentMethodFromWebsite);
			Thread.sleep(2000);

			if (driver
					.findElements(By.xpath(
							"//th[text()=\"Player Name\"]/following::tr//td[contains(text(),'" + searchPlayer + "')]"))
					.size() > 0) {
				test.pass("successfully found Player name record in Wallet view screen", extentScreenshot());
			} else {
				test.fail("Something wrong !! To Search wallet deposit", extentScreenshot());
			} // gp.clearsearch();
			if (driver.findElement(By.xpath("(//th[text()='Payment Method']//following::tr//td[contains(text(),'"
					+ paymentMethodFromWebsite + "')])[1]")) != null) {
				test.pass("successfully found payment method in Wallet view screen", extentScreenshot());
			} else {
				test.fail("not found record in Wallet view screen", extentScreenshot());
			}
		} else {
			test.fail("Something wrong!To Open Wallet deposit screen", extentScreenshot());
		}
	}

	@Test
	public void C_TC_WalletDeposit_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("WalletDeposit ->  Listing");
		test.info("TestCase started - As an admin user I should able to view list of the WalletDeposit");
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);
		BaseClass.gotoTab(driver, 0);
		driver.navigate().refresh();
		Thread.sleep(2000);

		pp.clickOnPlayerManagement();
		Thread.sleep(300);
		test.info("Clicked on Player Management");
		pp.clickonWallet_Deposits();
		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Deposit\"]")) != null) {
			test.info("Already Opened Wallet Deposit screen");
			if (driver
					.findElements(By
							.xpath("//th[text()=\"Payment ID\"]/following::tr//td[contains(@class,\"transactionId\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed Date of Payment ID on the Wallet History page");

			} else {
				test.info("Something wrong !! To Viewed Payment ID of Wallet on the Wallet History page");
			}
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Player Name\"]/following::tr//td[contains(@class,\"first\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed PlayerName of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed PlayerName of Wallet on the Wallet History page");
			}
			if (driver
					.findElements(By.xpath(
							"//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"playerInfo-playerId\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed Player Id of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed Player Id of Wallet on the Wallet History page");
			}
			if (driver
					.findElements(By.xpath(
							"//th[text()=\"Payment Method\"]/following::tr//td[contains(@class,\"paymentProvider\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed PaymentMethod of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed PaymentMethod of Wallet on the Wallet History page");
			}
			if (driver
					.findElements(By.xpath("//th[text()=\"Amount($)\"]/following::tr//td[contains(@class,\"amount\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed Amount of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed Amount of Wallet on the Wallet History page");
			}
			if (driver.findElements(By.xpath("//th[text()=\"Status\"]/following::tr//td[contains(@class,\"Status\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed Status of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed Status of Wallet on the Wallet History page");
			}
			if (driver
					.findElements(By.xpath("//th[text()=\"Action\"]/following::tr//td[contains(@class,\"action\")]//i"))
					.size() > 0) {
				test.pass("Successfully Viewed Action Eye Icon of Wallet on the Wallet History page");
			} else {
				test.info("Something wrong !! To Viewed Action Eye icon of Wallet on the Wallet History page");
			}
			test.pass("Verified Wallet History screen", extentScreenshot());
		} else {
			test.fail("Something wrong!To Open Wallet History screen", extentScreenshot());
		}
	}

	@Test
	public void E_TC_WalletDeposit_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("WalletDeposit ActionView");
		test.info("TestCase started As an admin user I should able to View (Actionview)(Eyeicon) in WalletDeposit");
		GuestPlayers gp = new GuestPlayers(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		BaseClass.gotoTab(driver, 0);
		driver.navigate().refresh();

		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Deposit\"]")) != null) {
			wr.clickActioneyeicon();
			Thread.sleep(1500);

			if (driver.findElement(By.xpath("//td[text()=\"Payment ID\"]//following-sibling::td")).getText() != null) {
				test.info("Successfully Showing Payment ID in View WalletDeposit Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Player Id\"]//following-sibling::td")) != null) {
				test.info("Successfully Showing Player ID in View WalletDeposit Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Display Name\"]//following-sibling::td")) != null) {
				test.info("Successfully Showing Display Name in View WalletDeposit Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Payment Method\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Payment Method in View WalletDeposit Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Player Name\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Player Name in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"User Name\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing User Name in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Amount ($)\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Amount($) in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Status\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Status in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Store\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Store in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Transaction Type\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Transaction Type in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Date\"]//following-sibling::td")) != null) {

				test.info("Successfully Showing Date in View Wallet History Details");
			} else {
				Assert.assertTrue(false);
			}

			gp.clickCloseActionView();
		}
	}

	@Test
	public void F_TC_WalletDeposit_Excel() throws InterruptedException, IOException {
		// String SearchItem="4250";
		test = extentCreateTest("WalletDeposit -> Excel");
		test.info("TestCase started EXCEL Download in WalletDeposit");
		GuestPlayers gp = new GuestPlayers(driver);
		PurchaseHistory Pr = new PurchaseHistory(driver);
		PlayerProfile pp = new PlayerProfile(driver);

		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Deposit\"]")) != null) {
			test.info("Opened Wallet Deposit Successfully");

			if (driver.findElement(By.xpath("//button[@title=\"Export XLSX\"]")) != null) {
				Thread.sleep(1000);

				test.info("Testing XLSX button in Wallet history");

				pp.clickXlsxButton();

				Thread.sleep(3000);
				String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";
				// String
				// Searched=driver.findElement(By.xpath("//th[text()=\"Email\"]/following::tr//td[contains(text(),'"+SearchItem+"')]")).getText();

				// if(SearchItem.equalsIgnoreCase(SearchItem))

				if (driver.findElement(By.xpath("//span[contains(text(),'" + msg + "')]")).isDisplayed()) {
					test.pass("Successfully XLSX Downloaded message return");
					Thread.sleep(3000);

					// this code is for download page comparsion
					String modulename = "Players "
							+ driver.findElement(By.xpath("//h3[text()=\"Wallet Deposit\"]")).getText();
					Thread.sleep(2000);

					driver.findElement(By.xpath("//i[contains(@class,\"ri-download-cloud-2-line\")]")).click();
					System.out.println("Download Excel button found");
					Thread.sleep(2000);

					String downloadString = driver.findElement(By.xpath(
							"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
							.getText();

					if (downloadString.equalsIgnoreCase(modulename)) {
						test.pass("Successfully Viewed Listing Type	->" + downloadString);
					} else {
						test.info("Something wrong !! To Viewed Listing Type	->" + downloadString);

					}
					driver.navigate().back();
				} else {
					test.fail("Something wrong !! To Download XLSX");

				}
			} else {
				test.fail("Something wrong !! To to found Wallet history");

			}
		}
	}

	public void G_ManageWallet_WithdrawRequest() throws InterruptedException, IOException {
		Website_WalletWithdrawAmount();
	}

	public void Website_WalletWithdrawAmount() throws InterruptedException, IOException {
		test = extentCreateTest("Website Wallet Withdraw Amount");
		test.info("TestCase started Website Wallet Withdraw Amount");
		BaseClass.gotoTab(driver, 1);
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();",
		// driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
	}

	@Test
	public void Gb_TC_withdrawPlayer_Bank() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website -Wallet bank WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the Wallet bank withdraw Amount in website");

		checkStatus = "withdraw";
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Bank Account')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='amount']")).sendKeys("1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname=\"accountHolderName\"]")).sendKeys("Samrat Patil");
		driver.findElement(By.xpath("//input[@formcontrolname=\"accountNumber\"]")).sendKeys("4887464648");
		driver.findElement(By.xpath("//input[@formcontrolname=\"routingNumber\"]")).sendKeys("312");
		driver.findElement(By.xpath("//input[@formcontrolname=\"bankName\"]")).sendKeys("DenaBank");
		Thread.sleep(300);
		driver.findElement(By.xpath("//h2[text()='Withdraw Amount']//following::button[text()='Withdraw Amount']"))
				.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();

		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}
		VerifyWalletPaymentTransactions_Website();
		VerifyWalletBallance_Website();
		VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
		VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "withdraw");

		test.info("TestCase end - As an player I should able to  the Wallet bank withdraw Amount in website");
	}

	@Test
	public void Gc_TC_withdrawPlayer_Paysafe() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Paysafe - Wallet Withdraw Request");
		test.info("TestCase started - As an player I should able to  the Wallet paysafe withdraw Amount in website");
		checkStatus = "withdraw";
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[contains(text(),'Paysafe')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='amount']")).sendKeys("1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@formcontrolname='countryId']")).click();
		driver.findElement(
				By.xpath("//select[@formcontrolname='countryId']//following::option[contains(text(),'Canada')]"))
				.click();
		driver.findElement(By.xpath("//select[@formcontrolname='stateId']")).click();
		driver.findElement(
				By.xpath("//select[@formcontrolname='stateId']//following::option[contains(text(),'Manitoba')]"))
				.click();

		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Baroda");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Address");
		driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys("A1B2C3D4");
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//input[@placeholder='Amount']")).sendKeys(val);
		driver.findElement(By.xpath(
				"//h2[contains(text(),'Withdraw Amount')]//following::button[contains(text(),'Withdraw Amount')]"))
				.click();
		Thread.sleep(5000);
		// wr.SendWithrawAmount();
		PaysafePayment("withdraw");

		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Success\")])[1]"));
		String es = exceptedStatus.getText();

		if (driver.findElements(By.xpath("(//span[contains(text(),\"Success\")])[1]")).size() > 0) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
			test.fail("Wallet withdraw amount Failed");
			captureScreen(driver, "WithdrawRequest");
		}
		VerifyWalletPaymentTransactions_Website();
		VerifyWalletBallance_Website();
		VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
		VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "withdraw");
		test.info("TestCase end - As an player I should able to  the Wallet paysafe withdraw Amount in website");

	}

	@Test
	public void Gd_TC_withdrawPlayer_Skrill() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website -Wallet skrill WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the Wallet skrill withdraw Amount in website");

		checkStatus = "withdraw";
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'Skrill')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='amount']")).sendKeys("1");
		Thread.sleep(1000);

		Thread.sleep(300);
		// js.executeScript ("arguments[0].scrollIntoView({block: 'center', inline:
		// 'nearest'})", driver.findElement(By.xpath("//h2[contains(text(),'Withdraw
		// Amount')]//following::button[contains(text(),'Withdraw Amount')]")));
		driver.findElement(By.xpath(
				"//h2[contains(text(),'Withdraw Amount')]//following::button[contains(text(),'Withdraw Amount')]"))
				.click();
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		// wr.SendWithrawAmount();
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Success\")])[1]"));
		String es = exceptedStatus.getText();

		if (exceptedStatus.isDisplayed()) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}
		VerifyWalletPaymentTransactions_Website();
		VerifyWalletBallance_Website();
		VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
		VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "withdraw");
		test.info("TestCase end - As an player I should able to  the Wallet skrill withdraw Amount in website");

	}

	@Test
	public void Ge_TC_withdrawPlayer_CashApp() throws InterruptedException, IOException {
		WithdrawRequest wr = new WithdrawRequest(driver);
		test = extentCreateTest("Website -Wallet cashapp WithdrawRequest");
		test.info("TestCase started - As an player I should able to  the Wallet cashapp withdraw Amount in website");
		checkStatus = "withdraw";
		websiteMenu_Verify();
		driver.findElement(By.xpath("(//button[contains(text(),'Wallet')])[1]")).click();
		driver.navigate().refresh();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath("(//div[@class=\"img-upload\"])[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'CashApp')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@formcontrolname='amount']")).sendKeys("1");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})",
				driver.findElement(By.xpath("//button[contains(text(),'Withdraw Amount')]")));
		// h2[contains(text(),'Withdraw
		// Amount')]//following::button[contains(text(),'Withdraw Amount')]
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement exceptedStatus = driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
		String es = exceptedStatus.getText();
		if (driver.findElements(By.xpath("(//span[contains(text(),\"Pending\")])[1]")).size() > 0) {
			test.pass("Withraw amount Requested" + es);
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
			test.fail("Something wrong to withdraw");
			captureScreen(driver, "WithdrawRequest");
		}

		VerifyWalletPaymentTransactions_Website();
		VerifyWalletBallance_Website();
		VerifyPaymentInAdmin_Wallet(paymentway, Trans_Type, paymentMethodFromWebsite);
		VerifyPaymentInAdmin_WalletDeposit(searchPlayer, "withdraw");
		test.info("TestCase end - As an player I should able to  the Wallet cashapp withdraw Amount in website");

	}

	// this is in 1.2.3
	/*
	 * public void Gg_TC_withdrawPlayer_seamless() throws InterruptedException,
	 * IOException { WithdrawRequest wr=new WithdrawRequest(driver);
	 * test=extentCreateTest("Website -  Withdraw Request"); test.
	 * info("TestCase started - As an player I should able to  the wallet withdraw Amount in website"
	 * ); String status=""; String actualStatus = "Success";
	 * 
	 * wr.clickOnWithdraw_MainTab_web(); Thread.sleep(2000);
	 * wr.clickwithdrawAmount(); Thread.sleep(2000);
	 * wr.CurrentWithdrawAmount_web.sendKeys(amount); Thread.sleep(1000);
	 * driver.findElement(By.xpath("//input[@id='seamless_chex']")).click();
	 * Thread.sleep(1000); wr.WithdrawBtn.click();
	 * 
	 * WebElement exceptedStatus =
	 * driver.findElement(By.xpath("(//span[contains(text(),\"Pending\")])[1]"));
	 * String es = exceptedStatus.getText(); if(exceptedStatus.isDisplayed()) {
	 * test.pass("Withraw amount Requested"+es); Assert.assertTrue(true); } else {
	 * Assert.assertTrue(false); test.fail("Something wrong to withdraw");
	 * captureScreen(driver,"WithdrawRequest"); } }
	 */

	public void Ga_TCWalletWithdrawRequest_ViewScreen() throws InterruptedException, IOException {
		test = extentCreateTest("Wallet WithdrawRequest -> Redirect");
		test.info(
				"TestCase started - As an admin user I should able to view Wallet WithdrawRequest screen by clicking on Players Management link");
		// test.pass("Create NewPlayer Testcase started");
		PlayerProfile pp = new PlayerProfile(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(300);
		;
		test.info("Clicked on Player Management");
		pp.clickonWallet_WithdrawRequest();
		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")) != null) {
			test.pass("Successfully Opened Wallet Withdraw Request screen");
			Assert.assertTrue(true);
		} else {
			test.fail("Something wrong!To Open Wallet Withdraw Request screen");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void H_TC_WalletWithdrawRequest_ViewList() throws InterruptedException, IOException {
		test = extentCreateTest("WithdrawRequest -> ViewList");
		test.info("TestCase started - As an admin user I should able to view list of the Withdraw Request");
		PlayerProfile pp = new PlayerProfile(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		Thread.sleep(2000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")) != null) {
			test.pass("Already Opened Withdraw Request screen");
			if (driver.findElements(By.xpath("//th[text()=\"Date\"]/following::tr//td[contains(@class,\"createdAt\")]"))
					.size() > 0) {
				test.pass("Successfully Viewed Date of Withdrawal request on the Withdraw Request page");
				Assert.assertTrue(true);
			} else {
				test.fail("Something wrong !! To Viewed Date of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "DateofWithdrawal");
			}
			if (driver.findElements(By.xpath(
					"//th[text()=\"Request ID\"]/following::tr//td[contains(@class,\"cdk-column-transactionId\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed RequestId of Withdrawal request on the Withdraw Request page");
			} else {
				// Assert.assertTrue(false);
				test.fail("Something wrong !! To Viewed RequestId of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "RequestIdofWithdrawal");
			}
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Player Name\"]/following::tr//td[contains(@class,\"fullName\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed PlayerName of Withdrawal request on the Withdraw Request page");
			} else {
				Assert.assertTrue(false);
				test.pass("Something wrong !! To Viewed PlayerName of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "PlayerNameofWithdrawal");
			}
			if (driver
					.findElements(By.xpath(
							"//th[text()=\"Payment Method\"]/following::tr//td[contains(@class,\"paymentProvider\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed PaymentMethod of Withdrawal request on the Withdraw Request page");
			} else {
				Assert.assertTrue(false);
				test.pass(
						"Something wrong !! To Viewed PaymentMethod of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "PaymentMethodofWithdrawal");
			}
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Player Id\"]/following::tr//td[contains(@class,\"playerId\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed playerId of Withdrawal request on the Withdraw Request page");
			} else {
				Assert.assertTrue(false);
				test.pass("Something wrong !! To Viewed playerId of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "playerIdsofWithdrawal");
			}
			if (driver
					.findElements(
							By.xpath("//th[text()=\"Amount ($)\"]/following::tr//td[contains(@class,\"amount\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Amount of Withdrawal request on the Withdraw Request page");
			} else {
				Assert.assertTrue(false);
				test.pass("Something wrong !! To Viewed Amount of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "AmountofWithdrawal");
			}
			if (driver.findElements(By.xpath("//th[text()=\"Status\"]/following::tr//td[contains(@class,\"Status\")]"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Status of Withdrawal request on the Withdraw Request page");
			} else {
				// Assert.assertTrue(false);
				test.pass("Something wrong !! To Viewed Status of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "StatusofWithdrawal");
			}
			if (driver
					.findElements(By.xpath("//th[text()=\"Action\"]/following::tr//td[contains(@class,\"action\")]//i"))
					.size() > 0) {
				Assert.assertTrue(true);
				test.pass("Successfully Viewed Action Eye Icon of Withdrawal request on the Withdraw Request page");
			} else {
				Assert.assertTrue(false);
				test.pass(
						"Something wrong !! To Viewed Action Eye icon of Withdrawal request on the Withdraw Request page");
				captureScreen(driver, "StatusofWithdrawal");
			}
		} else {
			test.pass("Something wrong!To Open Withdraw Request screen");
			Assert.assertTrue(false);
		}
	}

	@Test
	public void I_TC_WalletWithdrawRequest_Search() throws InterruptedException, IOException {
		WalletWithdrawRequest_Search(searchPlayer);
	}

	public void WalletWithdrawRequest_Search(String player) throws InterruptedException, IOException {
		// String SearchItem="CS-20788";
		test = extentCreateTest("Wallet  WithdrawRequest -> Search");
		test.info("TestCase started As an admin user I should able to search in Wallet  withdrawal request");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(300);
			test.info("Clicked on Player Management");
		pp.clickonWallet_WithdrawRequest();
		Thread.sleep(4000);

		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")) != null) {
			test.info("Opened Withdraw Request Successfully");
			gp.Search_Items(player);
			Thread.sleep(4000);
			// String
			// Searched=driver.findElement(By.xpath("//th[text()=\"Date\"]/following::tr//td[contains(text(),"+
			// SearchItem +")]")).getText();
			// if(Searched.equalsIgnoreCase(SearchItem))
			if (driver.findElements(By.xpath("(//td[contains(text(),'" + searchPlayer + "')])[1]")).size() > 0) {
				Thread.sleep(3000);
				test.pass("Successfully Searched Item viewed");
				Assert.assertTrue(true);
			} else {
				driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
				Assert.assertTrue(false);
				test.fail("Something wrong !! To Search Item");
				captureScreen(driver, "FailedSearchWithdrawal");
			}
			Thread.sleep(500);
			// driver.findElement(By.xpath("//mat-icon[text()=\"clear\"]")).click();
		}
	}

	@Test
	public void J_TC_WalletWithdrawRequest_ActionView() throws InterruptedException, IOException {
		test = extentCreateTest("Wallet WithdrawRequest -> ActionView");
		test.info("TestCase started As an admin user I should able to View (Actionview)(Eyeicon) ");
		GuestPlayers gp = new GuestPlayers(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);

		Thread.sleep(4000);
		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")) != null) {
			test.info("Opened Wallet Withdraw Request");
			gp.Search_Items(searchPlayer);
			Thread.sleep(4000);
			wr.clickActioneyeicon();
			Thread.sleep(1500);

			if (driver.findElement(By.xpath("//td[text()=\"Date\"]//following-sibling::td")).getText() != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Date in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Request ID\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Request ID in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Player Name\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Player Name in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Payment Method\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Payment Method in View  Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}

			if (driver.findElement(By.xpath("//td[text()=\"Amount ($)\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Amount($) in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Status\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Status in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}

			if (driver.findElement(By.xpath("//td[text()=\"User Name\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing User Name in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			if (driver.findElement(By.xpath("//td[text()=\"Store\"]//following-sibling::td")) != null) {
				Assert.assertTrue(true);
				test.pass("Successfully Showing Store in View Wallet Withdraw Request Details");
			} else {
				Assert.assertTrue(false);
			}
			Thread.sleep(500);
			gp.clickCloseActionView();
		}
	}

	@Test
	public void K_TC_WalletWithdrawRequest_Excel() throws InterruptedException, IOException {
		// String SearchItem="4250";
		test = extentCreateTest(" Wallet  Withdrawal request -> Excel");

		test.info("TestCase started EXCEL Download in Wallet  Withdrawal request");
		PlayerProfile pp = new PlayerProfile(driver);

		Thread.sleep(5000);
		if (driver.findElements(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")).size() > 0) {
			test.info("Opened Wallet  Withdraw Request Successfully");

			if (driver.findElements(By.xpath("//button[@title=\"Export XLSX\"]")).size() > 0) {
				Thread.sleep(1000);

				test.info("Testing XLSX button in Withdraw Request");
				pp.clickXlsxButton();

				Thread.sleep(2000);
				String msg = "Request initiated. Navigate to Download section to track your requests. The export is limited to 50,000 records. Please contact administrator for more records.";

				if (driver.findElements(By.xpath("//span[contains(text(),'" + msg + "')]")).size() > 0) {
					test.pass("Successfully XLSX Downloaded message return");

					Thread.sleep(2000);
					// this code is for download page comparsion
					String modulename = driver.findElement(By.xpath("//h3[contains(.,'Withdraw Request')]")).getText();
					Thread.sleep(2000);
					driver.findElement(By.xpath("(//i[contains(@class,\"ri-download-cloud-2-line\")])[1]")).click();
					Thread.sleep(2000);

					String downloadString = driver.findElement(By.xpath(
							"(//th[text()=\"Listing Type\"]/following::tr//td[contains(@class,\"cdk-column-listingType\")])[1]"))
							.getText();

					if (downloadString.equalsIgnoreCase(modulename)) {
						test.pass("Successfully Viewed Listing Type	->" + downloadString);
						Assert.assertTrue(true);
					} else {
						test.info("Something wrong !! To Viewed Listing Type	->" + downloadString);
						Assert.assertTrue(false);
					}
					driver.navigate().back();
				} else {
					test.fail("Something wrong !! To Download XLSX");
					Assert.assertTrue(false);
				}
			} else {
				test.fail("Something wrong !! To to found Withdraw Request");
				Assert.assertTrue(false);
			}
		}
	}

	@Test
	public void L_TC_WithdrawRequestApproveBank() throws InterruptedException, IOException {

		test = extentCreateTest("WithdrawRequest -> Request Approve/Decline - Bank");
		test.info("TestCase started As an admin user I should be able to Approve / Decline -  "
				+ SearchItemWithdrawRequest + " Withraw Request WithdrawRequest");
		GuestPlayers gp = new GuestPlayers(driver);
		PlayerProfile pp = new PlayerProfile(driver);
		CommonCosmo cc = new CommonCosmo(driver);
		WithdrawRequest wr = new WithdrawRequest(driver);

		if (driver.findElement(By.xpath("//h3[text()=\"Wallet Withdraw Request\"]")) != null) {
			Thread.sleep(1000);
			gp.Search_Items("Bank");
			Thread.sleep(4000);
			if (driver
					.findElements(By.xpath(
							"(//th[text()=\"Status\"]/following::tr//td//span[contains(text(),\"Pending\")])[1]"))
					.size() > 0) {
				driver.findElement(By.xpath("(//button[@title='Action'])[1]")).click();
				Thread.sleep(2500);

				if (driver.findElement(By.xpath(
						"(//span[contains(text(),'Pending')]//following::span[contains(text(),' Pending')])[1]")) != null
						&& driver.findElement(
								By.xpath("(//span[contains(text(),'Player Name')]//following::td[contains(text(),'"
										+ searchPlayer + "')])[1]")) != null
						&& driver.findElement(
								By.xpath("(//span[contains(text(),'Payment Provider')]//following::td[contains(text(),'"
										+ SearchItemWithdrawRequest + "')])[1]")) != null) {

					if (driver.findElement(
							By.xpath("//span[text()=\"Player Name\"]/following-sibling::span[contains(text(),'"
									+ searchPlayer + "')]")) != null) {
						pp.selectwithrawrequest(" Approve ");
						driver.findElement(By.xpath("//textarea[@formcontrolname=\"updatedNotes\"]"))
								.sendKeys("Wallet Withdraw request approved by Automation Script");
						driver.findElement(By.xpath("//span[text()='Update']")).click();
					} else {
						driver.findElement(By.xpath("//span[text()=\"Cancel\"]")).click();
						test.fail("Something wrong to select withraw request");
						Assert.assertTrue(false);
					}
				} else {
					Assert.assertTrue(false);
				}
			} else {
				test.fail("no pending request in withraw request", extentScreenshot());
				Assert.assertTrue(false);
			}
			Thread.sleep(1000);
		} else {
			Assert.assertTrue(false);
		}
	}

}
