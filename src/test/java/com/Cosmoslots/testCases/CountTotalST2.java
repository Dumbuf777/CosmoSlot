package com.Cosmoslots.testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.ColumnSelectors;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.pageObjects.WithdrawRequest;
import com.Cosmoslots.utilities.BaseClass;


public class CountTotalST2 extends BaseClass {
	private PlayerProfile pp;
	private WithdrawRequest wr;
	private LobbyPage_Old lp;
	private GuestPlayers gp;
	private UserPage up;
	
	public enum Page {
		ManageToken, Purchases, WithdrawRequest, PlayerLedger, GameTransaction, AppliedCoupons,};

	public enum Store {
		Packages, CustomPackages, Bonus, LobbyJackpot,};

	public enum User {
		TokenLedger, PlayerCustomPkgPurchase,};

	@Test
	public void A_TC_Count_Total_PlayerProfile() throws InterruptedException {
		test = extentCreateTest("Count total current tokens and redeemable tokens in player profile");
		test.info("TC -As an admin user,I should be able to count total current and redeemable token in player profile listing");

		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		pp.clickOnPlayerProfile();
		Count_TotalSweepToken(
				ColumnSelectors.CURRENT_TOKENS.getColumnValues(),
				ColumnSelectors.REDEEMABLE_TOKEN.getColumnValues(),
				ColumnSelectors.CURRENT_TOKENS.getColumnValues().substring(22, 36),
				ColumnSelectors.REDEEMABLE_TOKEN.getColumnValues().substring(22, 39));
	}

	@Test
	public void Ab_Count_Total_GuestPlayer() throws InterruptedException {
		test = extentCreateTest("Count total current tokens and redeemable tokens in guest player");
		test.info("TC -As an admin user, I should be able to count total current tokens and redeemable tokens in guest player");

		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		pp.clickGuestPlayersLink();
		Thread.sleep(3000);
		Count_TotalSweepToken(
				ColumnSelectors.CURRENT_TOKENS.getColumnValues(),
				ColumnSelectors.REDEEMABLE_TOKEN.getColumnValues(),
				ColumnSelectors.CURRENT_TOKENS.getColumnValues().substring(22, 36),
				ColumnSelectors.REDEEMABLE_TOKEN.getColumnValues().substring(22, 39));
	}

	@Test
	public void Ac_Count_Total_WithdrawRequest() throws InterruptedException {
		test = extentCreateTest("Count total sweep tokens and amount($) in withdraw request listing");
		test.info("TC - As admin user, I Should be able to count total sweep tokens and amount($) in withdraw request listing	");

		pp = new PlayerProfile(driver);
		wr = new WithdrawRequest(driver);

		pp.clickOnPlayerManagement();
		wr.clickwithdrawrequest();
		Thread.sleep(2000);
		Count_TotalSweepToken(
				ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

	}
	
	@Test
	public void Aca_Count_Total_WalletWithrawRequest() throws InterruptedException {
		test = extentCreateTest("Count total amount in wallet withdraw request");
		test.info("TC - As an admin user, I should be able to count total amount in wallet withdraw request");
		pp = new PlayerProfile(driver);
		pp.clickOnPlayerManagement();
		pp.clickonWallet_WithdrawRequest();
		test.info("<i><b>Count total amount wallet withdraw request</i></b>");
		Count_Total_STGT(ColumnSelectors.Wallet_Amount.getColumnValues(), ColumnSelectors.Wallet_Amount.getColumnValues().substring(16, 27));
		
		pp.clickOnPlayerManagement();
		pp.clickonWallet_Deposits();
		test.info("<i><b>Count total amount wallet deposits</i></b>");
		Count_Total_STGT(ColumnSelectors.Wallet_Amount.getColumnValues(), ColumnSelectors.Wallet_Amount.getColumnValues().substring(16, 27));
		test.info("<i><b>Count total amount wallet deposits - Skrill-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='skrill-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGT(ColumnSelectors.Wallet_Amount.getColumnValues(), ColumnSelectors.Wallet_Amount.getColumnValues().substring(16, 27));
		test.info("<i><b>Count total amount wallet deposits - paysafe-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='paysafe-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGT(ColumnSelectors.Wallet_Amount.getColumnValues(), ColumnSelectors.Wallet_Amount.getColumnValues().substring(16, 27));
		test.info("<i><b>Count total amount wallet deposits - bank-card-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='bank-card-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGT(ColumnSelectors.Wallet_Amount.getColumnValues(), ColumnSelectors.Wallet_Amount.getColumnValues().substring(16, 27));
	}

	@Test
	public void Ad_Count_Total_PurchaseHistory() throws InterruptedException {
		test = extentCreateTest("Count total ST, GT and amount in purchase history");
		test.info("TC - As an admin user, I should be able to count total ST, GT and amount in purchase history");

		pp = new PlayerProfile(driver);

		pp.clickOnPlayerManagement();
		pp.clickPurchaseHistoryTab();
		Thread.sleep(2000);
		test.info("<i><b>Count total amount ST GT in purchases - Payment</i></b>");
		Count_Total_STGTAmount(
				ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.GAME_TOKEN.getColumnValues(),
				ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
		test.info("<i><b>Count total amount ST GT in purchases - Skrill-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='skrill-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
		test.info("<i><b>Count total amount ST GT in purchases - Paysafe-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='paysafe-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
		test.info("<i><b>Count total amount ST GT in purchases - bank-card-initiated</i></b>");
		driver.findElement(
				By.xpath("//mat-radio-button[@value='bank-card-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
		test.info("<i><b>Count total amount ST GT in purchases - seamless-chex-initiated</i></b>");
		driver.findElement(By.xpath(
				"//mat-radio-button[@value='seamless-chex-initiated']//child::span[@class='mat-radio-container']"))
				.click();
		Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
				ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
				ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
				ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
				ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
	}

	@Test
	public void Ae_Count_Total_JackpotWins() throws InterruptedException {
		test = extentCreateTest("Count total ST and GT in jackpot wins");
		test.info("TC - As an admin user, I should be able to count total ST and GT in jackpot wins");
		pp = new PlayerProfile(driver);

		Thread.sleep(2000);
		pp.clickOnPlayerManagement();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Jackpot Wins']")).click();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath("//th[text()='Jackpot Name']")).size() > 0) {
			Count_TotalSweepToken(
					ColumnSelectors.ST.getColumnValues(),
					ColumnSelectors.GT.getColumnValues(),
					ColumnSelectors.ST.getColumnValues().substring(22, 33),
					ColumnSelectors.GT.getColumnValues().substring(22, 33));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[text()='Keno']")).click();
			Count_TotalSweepToken(ColumnSelectors.ST.getColumnValues(), ColumnSelectors.GT.getColumnValues(),
					ColumnSelectors.ST.getColumnValues().substring(22, 33),
					ColumnSelectors.GT.getColumnValues().substring(22, 33));

		} else {
			test.fail("No record found", extentScreenshot());
		}
	}

	@Test
	public void Af_Count_Total_PlayerProfileView() throws InterruptedException {
		test = extentCreateTest("Count total ST, GT, amount bet amount, winning amount, package amount and package discount amount in player profile view");
		test.info("TC - As an admin user, I should be able to count total ST, GT, amount bet amount, winning amount, package amount and package discount amount in player profile view");

		pp = new PlayerProfile(driver);

		Thread.sleep(2000);
		pp.GoToPlayerProfileView("CS-1400");
		Thread.sleep(2000);
		{
			Page[] Playerview = Page.values();
			for (Page PlayerView : Playerview) {
				switch (PlayerView) {
				case ManageToken:
					test.info("<i><b>Count total amount received in manage tokens</i></b>");
					pp.clickManageTokens();
					Count_Total_STGT(ColumnSelectors.AMOUNT_RECEIVED.getColumnValues(),
							ColumnSelectors.AMOUNT_RECEIVED.getColumnValues().substring(22, 37));
					// System.out.println("Manage Tokens");
					break;
				case Purchases:
					test.info("<i><b>Count total amount ST GT in purchases - Payment</i></b>");
					pp.clickonPurchases();
					Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

					test.info("<i><b>Count total amount ST GT in purchases - Skrill-initiated</i></b>");
					driver.findElement(By.xpath(
							"//mat-radio-button[@value='skrill-initiated']//child::span[@class='mat-radio-container']"))
							.click();
					Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

					test.info("<i><b>Count total amount ST GT in purchases - Paysafe-initiated</i></b>");
					driver.findElement(By.xpath(
							"//mat-radio-button[@value='paysafe-initiated']//child::span[@class='mat-radio-container']"))
							.click();
					Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

					test.info("<i><b>Count total amount ST GT in purchases - Bank Card Initiated</i></b>");
					driver.findElement(By.xpath(
							"//mat-radio-button[@value='bank-card-initiated']//child::span[@class='mat-radio-container']"))
							.click();
					Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

					test.info("<i><b>Count total amount ST GT in purchases - seamless-chex-initiated</i></b>");
					driver.findElement(By.xpath(
							"//mat-radio-button[@value='seamless-chex-initiated']//child::span[@class='mat-radio-container']"))
							.click();
					Count_Total_STGTAmount(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.GAME_TOKEN.getColumnValues(), ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));
					// System.out.println("Purchases");
					break;
				case WithdrawRequest:
					test.info("<i><b>Count total amount in withdraw request</i></b>");
					pp.clickWithdrawRequestTab();
					Count_TotalSweepToken(ColumnSelectors.SWEEP_TOKEN.getColumnValues(),
							ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33),
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28));

					// System.out.println("Withdraw request");
					break;
				case PlayerLedger:
					test.info("<i><b>Count total bet amount in player ledger</i></b>");
					pp.clickPlayerLedgerTab();
					Count_TotalSweepToken(ColumnSelectors.DEPOSIT.getColumnValues(),
							ColumnSelectors.WITHDRAW.getColumnValues(),
							ColumnSelectors.DEPOSIT.getColumnValues().substring(22, 29),
							ColumnSelectors.WITHDRAW.getColumnValues().substring(22, 30));
					// System.out.println("Player ledger");
					break;
				case GameTransaction:
					test.info("<i><b>Count total bet amount and winning amount in slot game transactions</i></b>");
					pp.clickGameTransactionsTab();
					Count_TotalSweepToken(ColumnSelectors.BET_AMOUNT.getColumnValues(),
							ColumnSelectors.WINNING_AMOUNT.getColumnValues(),
							ColumnSelectors.BET_AMOUNT.getColumnValues().substring(22, 32),
							ColumnSelectors.WINNING_AMOUNT.getColumnValues().substring(22, 36));

//				test.info("<i><b>Count total bet amount and winning amount in keno game transactions</i></b>");
//				driver.findElement(By.xpath("//div[@role='tablist']//child::button[@value='KENO']")).click();
//				Count_TotalSweepToken(ColumnSelectors.BET_AMOUNT.getColumnValues(), ColumnSelectors.WINNING_AMOUNT.getColumnValues(), ColumnSelectors.BET_AMOUNT.getColumnValues().substring(22, 32), ColumnSelectors.WINNING_AMOUNT.getColumnValues().substring(22, 36));

//				test.info("<i><b>Count total bet amount and winning amount in fish game transactions</i></b>");
//	     		driver.findElement(By.xpath("//div[@role='tablist']//child::button[@value='FISH']")).click();
//				Count_TotalSweepToken(ColumnSelectors.BET_AMOUNT.getColumnValues(), ColumnSelectors.WINNING_AMOUNT.getColumnValues(), ColumnSelectors.BET_AMOUNT.getColumnValues().substring(22, 32), ColumnSelectors.WINNING_AMOUNT.getColumnValues().substring(22, 36));
//				//System.out.println("Game transactions");
					break;
				case AppliedCoupons:
					test.info("<i><b>Count total package amount in appiled coupons</i></b>");
					pp.clickAppliedCouponsTab();
					Count_TotalSweepToken(ColumnSelectors.PACKAGE_AMOUNT.getColumnValues(),
							ColumnSelectors.PKG_DISCOUNT_AMOUNT.getColumnValues(),
							ColumnSelectors.PACKAGE_AMOUNT.getColumnValues().substring(22, 36),
							ColumnSelectors.PKG_DISCOUNT_AMOUNT.getColumnValues().substring(22, 48));
					// System.out.println("Applied coupons");
					break;
				}
			}
		}

	}

	@Test
	public void Ag_Count_Total_StoreView() throws InterruptedException {
		String SweepToken = "//th[contains(text(),'Sweep Token')]//following::tbody//td[contains(@class,'sweepToken')]";
		String GameToken = "//th[contains(text(),'Game Token')]//following::tbody//td[contains(@class,'gameToken')]";

		test = extentCreateTest("Count total ST, GT, amount bet amount, winning amount, package amount and package discount amount in store accounts view");
		test.info("TC - As an admin user, I should be able to count total ST, GT, amount bet amount, winning amount, package amount and package discount amount in store accounts view");
		lp = new LobbyPage_Old(driver);

		Thread.sleep(1000);
		lp.GoToStoreView("CosmoSlot");
//		lp.clicklobbymanagement();
//		Thread.sleep(1000);
//		lp.clickStoreAccounts();
//		Thread.sleep(2000);
//		lp.SearchItems("CosmoSlot");
//		Thread.sleep(5000);
//		explicitWait(driver, lp.View_Click, 10);
//	    WebDriverWait wait = new WebDriverWait(driver,10);
//	    wait.until(ExpectedConditions.visibilityOf(lp.View_Click));
//		lp.View_Click();
//		Thread.sleep(1000);
		{
			Store[] StoreView = Store.values();
			for (Store Storeview : StoreView) {
				switch (Storeview) {
				case Packages:
					test.info("<i><b>Counted total amount received in packges</i></b>");
					lp.clickView_LobbyStorePackage();
					Thread.sleep(2000);
					Count_Total_STGTAmountEST(ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.DISCOUNTED_AMOUNT.getColumnValues(), SweepToken,
							ColumnSelectors.EXTRA_ST.getColumnValues(), GameToken,
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28),
							ColumnSelectors.DISCOUNTED_AMOUNT.getColumnValues().substring(22, 42),
							SweepToken.substring(22, 33), ColumnSelectors.EXTRA_ST.getColumnValues().substring(22, 40),
							GameToken.substring(22, 33));
					// System.out.println("Manage Tokens");
					break;
				case CustomPackages:
					test.info(
							"<i><b>Counted total amount ST, GT, EST, amount, and discounted amount in custom packages</i></b>");
					lp.clickViewLobby_LobbyCPackage();
					Thread.sleep(3000);
					Count_Total_STGTAmountEST(ColumnSelectors.AMOUNT.getColumnValues(),
							ColumnSelectors.DISCOUNTED_AMOUNT.getColumnValues(), SweepToken,
							ColumnSelectors.EXTRA_ST.getColumnValues(), GameToken,
							ColumnSelectors.AMOUNT.getColumnValues().substring(22, 28),
							ColumnSelectors.DISCOUNTED_AMOUNT.getColumnValues().substring(22, 42),
							SweepToken.substring(22, 33), ColumnSelectors.EXTRA_ST.getColumnValues().substring(22, 40),
							GameToken.substring(22, 33));
					// System.out.println("Purchases");
					break;
				case Bonus:
					test.info("<i><b>Counted total ST and GT in store bonus</i></b>");
					lp.clickViewLobby_Bonus();
					Thread.sleep(3000);
					Count_TotalSweepToken(GameToken, SweepToken, GameToken.substring(22, 32),
							SweepToken.substring(22, 33));
					// System.out.println("Withdraw request");
					break;
				case LobbyJackpot:
					test.info("<i><b>Counted total current piggy and jackpot initial value in lobby jackpot</i></b>");
					lp.ClickOnJackpot();
					Thread.sleep(3000);
					Count_TotalSweepToken(ColumnSelectors.CURRENT_PIGGY.getColumnValues(),
							ColumnSelectors.JACKPOT_INITIAL_VALUE.getColumnValues(),
							ColumnSelectors.CURRENT_PIGGY.getColumnValues().substring(22, 35),
							ColumnSelectors.JACKPOT_INITIAL_VALUE.getColumnValues().substring(22, 41));
					// System.out.println("Player ledger");
					break;
				}
			}
		}
	}

	@Test
	public void Ah_Count_Total_UserProfileview() throws InterruptedException {

		test = extentCreateTest(
				"Count total transaction amount GT, transaction amount ST and transaction tmount extra ST in user profile view ");
		test.info("TC - As an admin user, I should be able to count total transaction amount GT, transaction amount ST and transaction tmount extra ST in user profile view ");
		String Amount = "//th[contains(text(),'Amount')]//following::tbody//td[contains(@class,'amount')]";
		String TransAmountGT = "//th[contains(text(),'Transaction Amount GT')]//following::tbody//td[contains(@class,'transactionAmount-gameTokens')]";
		String TransAmountST = "//th[contains(text(),'Transaction Amount ST')]//following::tbody//td[contains(@class,'transactionAmount-sweepTokens')]";
		String TransAmountEST = "//th[contains(text(),'Transaction Amount Extra ST')]//following::tbody//td[contains(@class,'transactionAmountExtraSweepToken')]";

		gp = new GuestPlayers(driver);
		up = new UserPage(driver);
		pp = new PlayerProfile(driver);

		up.ClickOnUserProfile();
		up.ClickOnBack();
		gp.Search_Items("Cosmoslot_1@yopmail.com");
		Thread.sleep(3000);
		pp.Clickeyeicon();
		Thread.sleep(2000);
		{
			User[] UserView = User.values();
			for (User Userview : UserView) {
				switch (Userview) {
				case PlayerCustomPkgPurchase:
					test.info("<i><b>Counted total amount, game tokens & sweep tokens in user</i></b>");
					up.ClickonPlayerCustomPackagePurchase();
					Count_Total_STGTAmount(ColumnSelectors.GAME_TOKEN.getColumnValues(),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues(), Amount,
							ColumnSelectors.GAME_TOKEN.getColumnValues().substring(22, 32),
							ColumnSelectors.SWEEP_TOKEN.getColumnValues().substring(22, 33), Amount.substring(22, 28));
					break;
				case TokenLedger:
					test.info(
							"<i><b>Counted total amount ST, GT, EST, amount, and discounted amount in custom packages</i></b>");
					up.ClickonTokenLedger();
					Count_Total_STGTAmount(TransAmountGT, TransAmountST, TransAmountEST,
							TransAmountGT.substring(22, 43), TransAmountST.substring(22, 43),
							TransAmountEST.substring(22, 49));
					break;

				}
			}
		}

	}

	// ********** Common method for the count column*******
	public void Count_Total_STGT(String xpath, String s) {
		List<Double> list = new ArrayList<Double>();
//		String Actual_Total="(//span[contains(@class,'total-amount')])[1]//child::span";
		boolean flag = true;
		while (flag) {
			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
			if (!nextBtn.getAttribute("class").contains("disabled")) {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement element : list_WebElement) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list.add(doubleElement);
				}
				double sumOfList = 0.0;
				for (double value : list) {
				    sumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + sumOfList);
				test.info("Counted Total " + s + " : " + sumOfList, extentScreenshot());
				String actualTotalText = driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal = Double.parseDouble(actualTotalText);
				list.clear();
				nextBtn.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} else {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement element : list_WebElement) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list.add(doubleElement);
				}
				double sumOfList = 0.0;
				for (double value : list) {
				    sumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + sumOfList);
				test.info("Counted Total " + s + " : " + sumOfList, extentScreenshot());
				String actualTotalText = driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal = Double.parseDouble(actualTotalText);
				list.clear();
				break;
//				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
//				for (WebElement List_WebElement : list_WebElement) {
//					double Double_Element = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
//					list.add(Double_Element);
//				}
//				double SumOfList = list.stream().mapToDouble(Double::doubleValue).sum();
//				System.out.println("Counted Total " + s + " : " + SumOfList);
//				test.info("Counted Total " + s + " : " + SumOfList, extentScreenshot());
//				double actualTotal = Double.parseDouble(
//						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span"))
//								.getText().replaceAll(",", ""));
//				// Assert.assertEquals(SumOfList, actualTotal);
//				list.clear();
//				break;
			}
		}

	}

	public void Count_TotalSweepToken(String xpath, String xpath1, String s, String s1) {
		List<Double> list = new ArrayList<Double>();
		List<Double> list1 = new ArrayList<Double>();
		boolean flag = true;
		while (flag) {
			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
			if (!nextBtn.getAttribute("class").contains("disabled")) {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement element : list_WebElement) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list.add(doubleElement);
				}
				double sumOfList = 0.0;
				for (double value : list) {
				    sumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + sumOfList);
				test.info("Counted Total " + s + " : " + sumOfList, extentScreenshot());
				String actualTotalText = driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal = Double.parseDouble(actualTotalText);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement element : list_WebElement1) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list1.add(doubleElement);
				}
				double sumOfList1 = 0.0;
				for (double value : list1) {
				    sumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + sumOfList1);
				test.info("Counted Total " + s1 + " : " + sumOfList1, extentScreenshot());
				String actualTotalText1 = driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal1 = Double.parseDouble(actualTotalText1);
				list1.clear();
				nextBtn.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} else {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement element : list_WebElement) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list.add(doubleElement);
				}
				double sumOfList = 0.0;
				for (double value : list) {
				    sumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + sumOfList);
				test.info("Counted Total " + s + " : " + sumOfList, extentScreenshot());
				String actualTotalText = driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal = Double.parseDouble(actualTotalText);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement element : list_WebElement1) {
				    String text = element.getText().replaceAll(",", "");
				    double doubleElement = Double.parseDouble(text);
				    list1.add(doubleElement);
				}
				double sumOfList1 = 0.0;
				for (double value : list1) {
				    sumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + sumOfList1);
				test.info("Counted Total " + s1 + " : " + sumOfList1, extentScreenshot());
				String actualTotalText1= driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", "");
				double actualTotal1 = Double.parseDouble(actualTotalText1);
				list1.clear();
				break;
			}
		}

	}

	public void Count_Total_STGTAmount(String xpath, String xpath1, String xpath2, String s, String s1, String s2) {
		List<Double> list = new ArrayList<Double>();
		List<Double> list1 = new ArrayList<Double>();
		List<Double> list2 = new ArrayList<Double>();
		boolean flag = true;
		while (flag) {
			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
			if (!nextBtn.getAttribute("class").contains("disabled")) {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement List_WebElement : list_WebElement) {
					double Double_Element = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list.add(Double_Element);
				}
				double sumOfList = 0.0;
				for (double value : list) {
				    sumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + sumOfList);
				test.info("Counted Total " + s + " : " + sumOfList);
				double actualTotal = Double.parseDouble(driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span")).getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList, actualTotal);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement List_WebElement : list_WebElement1) {
					double Double_Element1 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list1.add(Double_Element1);
				}
				double sumOfList1 = 0.0;
				for (double value : list1) {
				    sumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + sumOfList1);
				test.info("Counted Total " + s1 + " : " + sumOfList1);
				double actualTotal1 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[2]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList1, actualTotal1);
				list1.clear();

				List<WebElement> list_WebElement2 = driver.findElements(By.xpath(xpath2));
				for (WebElement List_WebElement2 : list_WebElement2) {
					double Double_Element2 = Double
							.parseDouble(List_WebElement2.getText().replaceAll(",", "").replaceAll("$", ""));
					list2.add(Double_Element2);
				}
				double SumOfList2 = 0.0;
				for (double value : list2) {
				    SumOfList2 += value;
				}
				System.out.println("Counted Total " + s2 + " : " + SumOfList2);
				test.info("Counted Total " + s2 + " : " + SumOfList2, extentScreenshot());
				double actualTotal2 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[3]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList2, actualTotal2);
				list2.clear();
				nextBtn.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} else {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement List_WebElement : list_WebElement) {
					double Double_Element = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list.add(Double_Element);
				}
				double SumOfList = 0.0;
				for (double value : list) {
				    SumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + SumOfList);
				test.info("Counted Total " + s + " : " + SumOfList);
				double actualTotal = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList, actualTotal);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement List_WebElement : list_WebElement1) {
					double Double_Element1 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list1.add(Double_Element1);
				}
				double SumOfList1 = 0.0;
				for (double value : list1) {
				    SumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + SumOfList1);
				test.info("Counted Total " + s1 + " : " + SumOfList1);
				double actualTotal1 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[2]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList1, actualTotal1);
				list1.clear();

				List<WebElement> list_WebElement2 = driver.findElements(By.xpath(xpath2));
				for (WebElement List_WebElement2 : list_WebElement2) {
					double Double_Element2 = Double.parseDouble(List_WebElement2.getText().replaceAll(",", ""));
					list2.add(Double_Element2);
				}
				double SumOfList2 = 0.0;
				for (double value : list2) {
				    SumOfList2 += value;
				}
				System.out.println("Counted Total " + s2 + " : " + SumOfList2);
				test.info("Counted Total " + s2 + " : " + SumOfList2, extentScreenshot());
				double actualTotal2 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[3]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList2, actualTotal2);
				list2.clear();
				break;
			}
		}

	}

	public void Count_Total_STGTAmountEST(String xpath, String xpath1, String xpath2, String xpath3, String xpath4,
			String s, String s1, String s2, String s3, String s4) {
		List<Double> list = new ArrayList<Double>();
		List<Double> list1 = new ArrayList<Double>();
		List<Double> list2 = new ArrayList<Double>();
		List<Double> list3 = new ArrayList<Double>();
		List<Double> list4 = new ArrayList<Double>();
		boolean flag = true;
		while (flag) {
			WebElement nextBtn = driver.findElement(By.xpath("//button[@aria-label='Next page']"));
			if (!nextBtn.getAttribute("class").contains("disabled")) {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement List_WebElement : list_WebElement) {
					double Double_Element = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list.add(Double_Element);
				}
				// System.out.println(list);
				double SumOfList = 0.0;
				for (double value : list) {
				    SumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + SumOfList);
				test.info("Counted Total " + s + " : " + SumOfList);
				double actualTotal = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList, actualTotal);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement List_WebElement : list_WebElement1) {
					double Double_Element1 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list1.add(Double_Element1);
				}
				// System.out.println(list1);
				double SumOfList1 = 0.0;
				for (double value : list1) {
				    SumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + SumOfList1);
				test.info("Counted Total " + s1 + " : " + SumOfList1);
				double actualTotal1 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[2]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList1, actualTotal1);
				list1.clear();

				List<WebElement> list_WebElement2 = driver.findElements(By.xpath(xpath2));
				for (WebElement List_WebElement : list_WebElement2) {
					double Double_Element2 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list2.add(Double_Element2);
				}
				// System.out.println(list2);
				double SumOfList2 = 0.0;
				for (double value : list2) {
				    SumOfList2 += value;
				}
				System.out.println("Counted Total " + s2 + " : " + SumOfList2);
				test.info("Counted Total " + s2 + " : " + SumOfList2);
				double actualTotal2 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[3]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList2, actualTotal2);
				list2.clear();

				List<WebElement> list_WebElement3 = driver.findElements(By.xpath(xpath3));
				for (WebElement List_WebElement : list_WebElement3) {
					double Double_Element3 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list3.add(Double_Element3);
				}
				// System.out.println(list3);
				double SumOfList3 = 0.0;
				for (double value : list3) {
				    SumOfList3 += value;
				}
				System.out.println("Counted Total " + s3 + " : " + SumOfList3);
				test.info("Counted Total " + s3 + " : " + SumOfList3);
				double actualTotal3 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[4]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList3, actualTotal3);
				list3.clear();

				List<WebElement> list_WebElement4 = driver.findElements(By.xpath(xpath4));
				for (WebElement List_WebElement : list_WebElement4) {
					double Double_Element4 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list4.add(Double_Element4);
				}
				// System.out.println(list4);
				double SumOfList4 = 0.0;
				for (double value : list4) {
				    SumOfList4 += value;
				}
				System.out.println("Counted Total " + s4 + " : " + SumOfList4);
				test.info("Counted Total " + s4 + " : " + SumOfList4, extentScreenshot());
				double actualTotal4 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[5]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList4, actualTotal4);
				list4.clear();
				nextBtn.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			} else {
				List<WebElement> list_WebElement = driver.findElements(By.xpath(xpath));
				for (WebElement List_WebElement : list_WebElement) {
					double Double_Element = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list.add(Double_Element);
				}
				// System.out.println(list);
				double SumOfList = 0.0;
				for (double value : list) {
				    SumOfList += value;
				}
				System.out.println("Counted Total " + s + " : " + SumOfList);
				test.info("Counted Total " + s + " : " + SumOfList);
				double actualTotal = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[1]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList, actualTotal);
				list.clear();

				List<WebElement> list_WebElement1 = driver.findElements(By.xpath(xpath1));
				for (WebElement List_WebElement : list_WebElement1) {
					double Double_Element1 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list1.add(Double_Element1);
				}
				// System.out.println(list1);
				double SumOfList1 = 0.0;
				for (double value : list1) {
				    SumOfList1 += value;
				}
				System.out.println("Counted Total " + s1 + " : " + SumOfList1);
				test.info("Counted Total " + s1 + " : " + SumOfList1);
				double actualTotal1 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[2]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList1, actualTotal1);
				list1.clear();

				List<WebElement> list_WebElement2 = driver.findElements(By.xpath(xpath2));
				for (WebElement List_WebElement : list_WebElement2) {
					double Double_Element2 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list2.add(Double_Element2);
				}
				// System.out.println(list2);
				double SumOfList2 = 0.0;
				for (double value : list2) {
				    SumOfList2 += value;
				}
				System.out.println("Counted Total " + s2 + " : " + SumOfList2);
				test.info("Counted Total " + s2 + " : " + SumOfList2);
				double actualTotal2 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[3]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList2, actualTotal2);
				list2.clear();

				List<WebElement> list_WebElement3 = driver.findElements(By.xpath(xpath3));
				for (WebElement List_WebElement : list_WebElement3) {
					double Double_Element3 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list3.add(Double_Element3);
				}
				// System.out.println(list3);
				double SumOfList3 = 0.0;
				for (double value : list3) {
				    SumOfList3 += value;
				}
				System.out.println("Counted Total " + s3 + " : " + SumOfList3);
				test.info("Counted Total " + s3 + " : " + SumOfList3);
				double actualTotal3 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[4]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList3, actualTotal3);
				list3.clear();

				List<WebElement> list_WebElement4 = driver.findElements(By.xpath(xpath4));
				for (WebElement List_WebElement : list_WebElement4) {
					double Double_Element4 = Double.parseDouble(List_WebElement.getText().replaceAll(",", ""));
					list4.add(Double_Element4);
				}
				// System.out.println(list4);
				double SumOfList4 = 0.0;
				for (double value : list4) {
				    SumOfList4 += value;
				}
				System.out.println("Counted Total " + s4 + " : " + SumOfList4);
				test.info("Counted Total " + s4 + " : " + SumOfList4, extentScreenshot());
				double actualTotal4 = Double.parseDouble(
						driver.findElement(By.xpath("(//span[contains(@class,'total-amount')])[5]//child::span"))
								.getText().replaceAll(",", ""));
				// Assert.assertEquals(SumOfList4, actualTotal4);
				list4.clear();
				break;
			}
		}
	}

}