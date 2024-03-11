package com.Cosmoslots.testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.FilterEnum;
import com.Cosmoslots.pageObjects.PlayerProfile;
import com.Cosmoslots.pageObjects.PurchaseHistory;
import com.Cosmoslots.utilities.BaseClass;
import com.aventstack.extentreports.Status;

public class AdvanceFilter extends BaseClass {
	BaseClass bc = new BaseClass();

	static int incementField = 1;
	static int checkrow = 1;
	public List<String> filterArray = new ArrayList<String>();

	@Test(priority = 1)
	public void A_advanceFilter_playerProfile() throws InterruptedException, IOException {

		test = extentCreateTest("AdvanceFilter -> PlayerProfile");
		test.info("Testcase Started for AdvanceFilter -> PlayerProfile");
		PlayerProfile pp = new PlayerProfile(driver);
		BaseClass.gotoTab(driver, 0);
		pp.clickOnPlayerManagement();
		pp.clickPlayerProfileLink();
		pp.clearfilter();
		pp.clickAdvanceFilter();

		boolean isDisplayed = pp.verifysearchPlayerLabel();
		String message = isDisplayed ? "<b><i>Successfully Opened advance filter screen</b></i>"
				: "<b><i>Something wrong!To Open advance filter  screen</b></i>";
		test.log(isDisplayed ? Status.PASS : Status.FAIL, message, extentScreenshot());
	}
	
	@Test(priority = 2)
	public void A_searchAdvanceFilter() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		pp.clickAdvanceFilter();
		test = extentCreateTest("AdvanceFilter Scenario 1");
		test.info("Testcase Started for AdvanceFilter with AND condition for all rule in single ruleset");
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		// scenario 1: check all filter working fine or not
		Ba_advanceFilter_FirstName("AND", FilterEnum.firstNameValueFilter.getValue(),
				FilterEnum.firstNameFilter.getValue(), "rule");
		Bb_advanceFilter_LastName("AND", FilterEnum.lastNameValueFilter.getValue(),
				FilterEnum.lastNameFilter.getValue(), "rule");
		Bf_advanceFilter_FullName("AND", FilterEnum.fullNameValueFilter.getValue(),
				FilterEnum.fullNameFilter.getValue(), "rule");
		Bg_advanceFilter_PlayerID("AND", FilterEnum.playerIDValueFilter.getValue(),
				FilterEnum.playerIDFilter.getValue(), "rule");
		Be_advanceFilter_DisplayName("AND", FilterEnum.displayNameValueFilter.getValue(),
				FilterEnum.displayNameFilter.getValue(), "rule");
		Bc_advanceFilter_User("AND", FilterEnum.userNameValueFilter.getValue(), FilterEnum.userNameFilter.getValue(),
				"rule");
		Bd_advanceFilter_Store("AND", FilterEnum.storeValueFilter.getValue(), FilterEnum.storeFilter.getValue(),
				"rule");
		Bh_advanceFilter_email("AND", FilterEnum.emailValueFilter.getValue(), FilterEnum.emailFilter.getValue(),
				"rule");
		Bi_advanceFilter_country("AND", FilterEnum.countryValueFilter.getValue(), FilterEnum.countryFilter.getValue(),
				"rule");
		Bj_advanceFilter_state("AND", FilterEnum.stateValueFilter.getValue(), FilterEnum.stateFilter.getValue(),
				"rule");
		Bk_advanceFilter_city("AND", FilterEnum.cityValueFilter.getValue(), FilterEnum.cityFilter.getValue(), "rule");
		Bl_advanceFilter_CurrentTokens("AND", FilterEnum.currentTokensValueFilter.getValue(),
				FilterEnum.currentTokensFilter.getValue(), "rule");
		Bla_advanceFilter_RedeemableTokens("AND", FilterEnum.redeemableTokensValueFilter.getValue(),
				FilterEnum.redeemableTokensFilter.getValue(), "rule");
		Bm_advanceFilter_TotalPurchaseAmount("AND", FilterEnum.totalPurchaseAmountValueFilter.getValue(),
				FilterEnum.totalPurchaseAmountFilter.getValue(), "rule");
		Bn_advanceFilter_CreatedAt("AND", FilterEnum.createdAtValueFilter.getValue(), "rule");
		Bo_advanceFilter_UpdatedAt("AND", FilterEnum.updatedAtValueFilter.getValue(), "rule");
		// Bp_advanceFilter_Tags("AND", tagsValueFilter, "rule");

		pp.clickSearch();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath(
				"//th[text()=\"Player Name\"]/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 1;
		checkrow = 1;
	}

	@Test(priority = 3)
	public void B_searchAdvanceFilter() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		pp.clickAdvanceFilter();
		test = extentCreateTest("AdvanceFilter Scenario 2");
		test.info(
				"Testcase Started for AdvanceFilter with AND condition for 1 rule in single ruleset and 2 rule in 2nd ruleset");
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		// scenario 2: check one ruleset combination with another filter working fine or
		// not
		Ba_advanceFilter_FirstName("AND", FilterEnum.firstNameValueFilter.getValue(),
				FilterEnum.firstNameFilter.getValue(), "rule");
		Bb_advanceFilter_LastName("AND", FilterEnum.lastNameValueFilter.getValue(),
				FilterEnum.lastNameFilter.getValue(), "ruleset");
		Bf_advanceFilter_FullName("AND", FilterEnum.fullNameValueFilter.getValue(),
				FilterEnum.fullNameFilter.getValue(), "rule");

		pp.clickSearch();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath(
				"//th[text()=\"Player Name\"]/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 1;
		checkrow = 1;
	}

	@Test(priority = 4)
	public void C_searchAdvanceFilter() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		pp.clickAdvanceFilter();

		test = extentCreateTest("AdvanceFilter Scenario 3");
		test.info(
				"Testcase Started for AdvanceFilter with condition OR with 1st ruleset and 1 rule,, condition AND with 2nd ruleset and 1 rule, condition OR with 3rd ruleset and 1 rule, ");
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		// scenario 3: check one ruleset combination with another filter working fine or
		// not
		Ba_advanceFilter_FirstName("OR", FilterEnum.firstNameValueFilter.getValue(),
				FilterEnum.firstNameFilter.getValue(), "rule");
		Bb_advanceFilter_LastName("AND", FilterEnum.lastNameValueFilter.getValue(),
				FilterEnum.lastNameFilter.getValue(), "ruleset");
		Bf_advanceFilter_FullName("OR", FilterEnum.fullNameValueFilter.getValue(), FilterEnum.fullNameFilter.getValue(),
				"ruleset");

		pp.clickSearch();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath(
				"//th[text()=\"Player Name\"]/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 1;
		checkrow = 1;
	}

	@Test(priority = 5)
	public void D_searchAdvanceFilter() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		pp.clickAdvanceFilter();

		test = extentCreateTest("AdvanceFilter Scenario 4");
		test.info("Testcase Started for AdvanceFilter with 1st ruleset and condition OR with 2 rule,"
				+ " condition AND with 2nd ruleset and condition OR with 1 rule, condition AND with 3rd ruleset and condition OR with 3 rule, ");
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		String firstName = "pankaj";
		String lastName = "patel";
		String fullName = "shrikrushna sonkar";
		String playerID = "CS-1400";
		String displayName = "CGJ1025";
		String userName = "Cosmopos";
		String store = "CosmoSlot";

		// scenario 4: check one ruleset combination with another filter working fine
		// check 2nd ruleset and match with another rule
		// add 3rd ruleset and match with another rule
		// combine above scenario and check result
		Ba_advanceFilter_FirstName("OR", FilterEnum.firstNameValueFilter.getValue(),
				FilterEnum.firstNameFilter.getValue(), "rule");
		Bd_advanceFilter_Store("OR", FilterEnum.storeValueFilter.getValue(), FilterEnum.storeFilter.getValue(), "rule");
		Bf_advanceFilter_FullName("AND", FilterEnum.fullNameValueFilter.getValue(),
				FilterEnum.fullNameFilter.getValue(), "ruleset");
		Bg_advanceFilter_PlayerID("OR", FilterEnum.playerIDValueFilter.getValue(),
				FilterEnum.playerIDValueFilter.getValue(), "rule");
		Be_advanceFilter_DisplayName("AND", FilterEnum.displayNameValueFilter.getValue(),
				FilterEnum.displayNameFilter.getValue(), "ruleset");
		Bc_advanceFilter_User("OR", FilterEnum.userNameValueFilter.getValue(), FilterEnum.userNameFilter.getValue(),
				"rule");
		Bb_advanceFilter_LastName("OR", FilterEnum.lastNameValueFilter.getValue(), FilterEnum.lastNameFilter.getValue(),
				"rule");

		pp.clickSearch();
		Thread.sleep(2000);
		if (driver.findElements(By.xpath(
				"//th[text()=\"Player Name\"]/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 1;
		checkrow = 1;
	}

	@Test(priority = 6)
	public void E_searchAdvanceFilter() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		pp.clickAdvanceFilter();
		test = extentCreateTest("AdvanceFilter Scenario 5");
		test.info(
				"Testcase Started for AdvanceFilter with common OR conditon among all ruleset and condition OR with all rule ");
		String con = "OR";
		driver.findElement(By.xpath("(//input[@value='" + con.toLowerCase() + "']//following::label[text()='" + con + "'])[1]")).click();
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		// scenario 4: check one ruleset combination with another filter working fine
		// check 2nd ruleset and match with another rule
		// add 3rd ruleset and match with another rule
		// combine above scenario and check result

		Ba_advanceFilter_FirstName("AND", FilterEnum.firstNameValueFilter.getValue(),
				FilterEnum.firstNameFilter.getValue(), "rule");
		Bd_advanceFilter_Store("AND", FilterEnum.storeValueFilter.getValue(), FilterEnum.storeFilter.getValue(),
				"rule");
		Bf_advanceFilter_FullName("AND", FilterEnum.fullNameValueFilter.getValue(),
				FilterEnum.fullNameFilter.getValue(), "ruleset");
		Bg_advanceFilter_PlayerID("AND", FilterEnum.playerIDValueFilter.getValue(),
				FilterEnum.playerIDFilter.getValue(), "rule");
		Be_advanceFilter_DisplayName("AND", FilterEnum.displayNameValueFilter.getValue(),
				FilterEnum.displayNameFilter.getValue(), "ruleset");
		Bc_advanceFilter_User("AND", FilterEnum.userNameValueFilter.getValue(), FilterEnum.userNameFilter.getValue(),
				"rule");
		Bb_advanceFilter_LastName("AND", FilterEnum.lastNameValueFilter.getValue(),
				FilterEnum.lastNameFilter.getValue(), "rule");

		pp.clickSearch();
		Thread.sleep(2000);

		if (driver.findElements(By.xpath(
				"//th[text()='Player Name']/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 0;
		checkrow = 0;
	}

//	@Test(priority = 7)
	public void F_advanceFilter_playerDeletionHistory() throws InterruptedException, IOException {

		test = extentCreateTest("AdvanceFilter -> Player Deletion History");
		test.info("Testcase Started for AdvanceFilter -> Player Deletion History");
		PlayerProfile pp = new PlayerProfile(driver);
		PurchaseHistory ph = new PurchaseHistory(driver);

		pp.clickOnPlayerManagement();
		ph.clickOnPlayerDeletionHistory();
		pp.clearfilter();
		pp.clickAdvanceFilter();

//		if (pp.verifySearchPlayerDeletionHistoryLabel() == true) {
//			test.pass("Successfully Opened advance filter screen");
//			Assert.assertTrue(true);
//			// advanceFilter();
//		} else {
//			test.fail("Something wrong!To Open advance filter  screen");
//			Assert.assertTrue(false);
//		}
	}

	@Test(priority = 8)
	public void G_searchAdvanceFilterPlayerDeletionHistory() throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);

		PageReload();
		// driver.findElement(By.xpath("//button[text()='Player Deletion
		// History']")).click();
		Thread.sleep(1500);
		pp.clickAdvanceFilter();
		test = extentCreateTest("player deletion history - AdvanceFilter Scenario 5");
		test.info(
				"Testcase Started for AdvanceFilter with common OR conditon among all ruleset and condition OR with all rule ");
		String con = "OR";
//		driver.findElement(
//				By.xpath("(//input[@value='" + con.toLowerCase() + "']//following::label[text()='" + con + "'])[1]"))
//				.click();
		driver.findElement(By.xpath("(//button[contains(@class,\"q-remove-button\")])[last()]")).click();
		Thread.sleep(2000);

		String DeletionfirstName = "Hardik";
		String DeletionlastName = "Kher";
		String DeletionfullName = "Hardik Kher";
		String DeletionplayerID = "CS-1234";
		String DeletiondisplayName = "Hardik_CS-1238";
		String DeletionuserName = "Cosmopos";
		String Deletionstore = "CosmoSlot";

		Ba_advanceFilter_FirstName("AND", FilterEnum.firstNameValueFilter.getValue(), DeletionfirstName, "rule");
		// Bd_advanceFilter_Store("AND", storeValueFilter, Deletionstore, "rule");
		Bb_advanceFilter_LastName("AND", FilterEnum.lastNameValueFilter.getValue(), DeletionlastName, "rule");
		Bf_advanceFilter_FullName("AND", FilterEnum.fullNameValueFilter.getValue(), DeletionfullName, "ruleset");
		Bg_advanceFilter_PlayerID("AND", FilterEnum.playerIDValueFilter.getValue(), DeletionplayerID, "rule");
		Be_advanceFilter_DisplayName("AND", FilterEnum.displayNameValueFilter.getValue(), DeletiondisplayName, "ruleset");
		Bc_advanceFilter_User("AND", FilterEnum.userNameValueFilter.getValue(), DeletionuserName, "rule");

		pp.clickSearch();
		if (driver.findElements(By.xpath(
				"//th[text()='Player Name']/following::tr//td[contains(@class,'mat-column-firstName-lastName')]"))
				.size() > 0) {
			System.out.println("pass");
			test.pass("Successfully found record", extentScreenshot());
		} else {
			test.fail("Not found record", extentScreenshot());
		}
		incementField = 0;
		checkrow = 0;
	}


	public void Ba_advanceFilter_FirstName(String con, String fname, String fnameValue, String rule)
			throws InterruptedException, IOException {

		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, fname, "");
		inputSearchValue(driver, fname, fnameValue);
	}

	public void Bb_advanceFilter_LastName(String con, String lname, String lnameValue, String rule)
			throws InterruptedException, IOException {

		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, lname, "");
		inputSearchValue(driver, lname, lnameValue);
	}

	public void Bf_advanceFilter_FullName(String con, String name, String fullnameValue, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, name, "");
		inputSearchValue(driver, name, fullnameValue);
		// ClickToAddNewRule(rule,con);
	}

	public void Bg_advanceFilter_PlayerID(String con, String id, String pid, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		Thread.sleep(1000);
		selectOptionFromDropdown(driver, id, "");
		inputSearchValue(driver, id, pid);
		// ClickToAddNewRule(rule,con);
	}

	public void Be_advanceFilter_DisplayName(String con, String dname, String display, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, dname, "");
		inputSearchValue(driver, dname, display);

	}

	public void Bc_advanceFilter_User(String con, String user, String username, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, user, username);
	}

	public void Bd_advanceFilter_Store(String con, String store, String storeValueFilter, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, store, storeValueFilter);
		Thread.sleep(2000);

	}

	public void Bh_advanceFilter_email(String con, String Email, String emailValueFilter, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);

		selectOptionFromDropdown(driver, Email, "");
		inputSearchValue(driver, Email, emailValueFilter);

	}

	public void Bi_advanceFilter_country(String con, String cntry, String countryValueFilter, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);

		selectOptionFromDropdown(driver, cntry, countryValueFilter);
		// ClickToAddNewRule(rule,con);
	}

	public void Bj_advanceFilter_state(String con, String stat, String stateValueFilter, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		Thread.sleep(1000);
		selectOptionFromDropdown(driver, stat, stateValueFilter);
		// ClickToAddNewRule(rule,con);
	}

	public void Bk_advanceFilter_city(String con, String ct, String cityvalue, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);

		selectOptionFromDropdown(driver, ct, "");
		inputSearchValue(driver, ct, cityvalue);
		// ClickToAddNewRule(rule,con);
	}

	public void Bl_advanceFilter_CurrentTokens(String con, String ct, String ctValue, String rule)
			throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, ct, "");
		pp.searchElementClick(ct, ">");
		inputSearchValue(driver, ct, ctValue);
		// ClickToAddNewRule(rule,con);
	}

	public void Bla_advanceFilter_RedeemableTokens(String con, String rt, String rtValue, String rule)
			throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, rt, "");
		pp.searchElementClick(rt, ">");
		inputSearchValue(driver, rt, rtValue);
		// ClickToAddNewRule(rule,con);
	}

	public void Bm_advanceFilter_TotalPurchaseAmount(String con, String tp, String tpValue, String rule)
			throws InterruptedException, IOException {
		PlayerProfile pp = new PlayerProfile(driver);
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, tp, "");
		pp.searchElementClick(tp, ">");
		inputSearchValue(driver, tp, tpValue);
		// ClickToAddNewRule(rule,con);
	}

	public void Bn_advanceFilter_CreatedAt(String con, String ca, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, ca, "");
		// ClickToAddNewRule(rule,con);
	}

	public void Bo_advanceFilter_UpdatedAt(String con, String ua, String rule)
			throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, ua, "");
		// ClickToAddNewRule(rule,con);
	}

	public void Bp_advanceFilter_Tags(String con, String tag, String rule) throws InterruptedException, IOException {
		ClickToAddNewRule(rule, con);
		selectOptionFromDropdown(driver, tag, "");
	}

	public void ClickToAddNewRule(String rule, String con) throws InterruptedException {
		// con=con.toLowerCase();
		PlayerProfile pp = new PlayerProfile(driver);
		WebElement ele;
		pp.pageScroll("up");
		if (rule.equalsIgnoreCase("rule")) {
			pp.ClickLastRule(con);
		} else if (rule.equalsIgnoreCase("ruleset")) {
			pp.ClickFirstRuleset(con);
		} else {
			System.out.println("no need to add rule/ruleset");
			test.info("This rule/ruleset is working fine");
		}
		pp.pageScroll("down");
	}

	public void operationSelected(String op) throws InterruptedException {
		PlayerProfile pp = new PlayerProfile(driver);
		if (op.equalsIgnoreCase("or")) {
			pp.searchOperationClick("or");
			test.info("OR operation selected");
		} else {
			pp.searchOperationClick("and");
			test.info("AND operation selected");
		}
	}

	public void selectOptionFromDropdown(WebDriver driver, String optionValue, String val) throws InterruptedException {

		PlayerProfile pp = new PlayerProfile(driver);

		System.out.println(incementField);
		WebElement ele = driver
				.findElement(By.xpath("(//mat-select[contains(@class,'mat-select')])[" + incementField + "]"));
		ele.click();
		WebElement dropdownElement = driver.findElement(By.xpath("//mat-option//span[text()='" + optionValue + "']"));
		Thread.sleep(1000);
		System.out.println("Search option selected -> " + dropdownElement.getText());
		test.info("Search option selected -> " + dropdownElement.getText());
		if (dropdownElement.getText().equalsIgnoreCase(optionValue)) {
			dropdownElement.click();
			Thread.sleep(1000);
			if (optionValue.equalsIgnoreCase("User")) {
				Thread.sleep(2000);
				pp.searchUser(val);
				incementField = incementField + 2;
				System.out.println("User " + incementField);
			}
			if (optionValue.equalsIgnoreCase("Store")) {
				Thread.sleep(2000);
				pp.searchStore(val);
				incementField = incementField + 1;
				System.out.println("Store " + incementField);
			}
			if (optionValue.equalsIgnoreCase("Country")) {
				pp.searchCountry(val);
				incementField = incementField + 1;
				System.out.println("Country " + incementField);
			}
			if (optionValue.equalsIgnoreCase("State")) {
				Thread.sleep(1000);
				pp.searchState(FilterEnum.countryFilter.getValue(), val);
				incementField = incementField + 2;
				System.out.println("State " + incementField);
			}
			if (optionValue.equalsIgnoreCase("Created At")) {
				pp.selectFilterDate("Created At", "2022");
			}
			if (optionValue.equalsIgnoreCase("Updated At")) {
				pp.selectFilterDate("Updated At", "2022");
			}
			if (optionValue.equalsIgnoreCase("Tags")) {
				pp.searchTags(val);
				System.out.println("tag " + incementField);
			}
		} else {
			test.info("dropdown value not matched");
		}
		incementField = incementField + 2;
		checkrow++;
		Thread.sleep(1000);
	}
	
	 public static void inputSearchValue(WebDriver driver, String optionValue, String searchValue)
				throws InterruptedException {
			WebElement searchField = driver.findElement(By.xpath("//mat-label[text()='" + optionValue + "']//preceding::input[1]"));

			searchField.sendKeys(searchValue);
//			test.info("Successfully added value in field ->" + optionValue, extentScreenshot());
			Thread.sleep(1000);
		}

//	public static void inputSearchValue(WebDriver driver, String optionValue, String searchValue)
//			throws InterruptedException {
//		WebElement searchField = driver
//				.findElement(By.xpath("//mat-label[text()='" + optionValue + "']//preceding::input[1]"));
//
//		searchField.sendKeys(searchValue);
//		test.info("Successfully added value in field ->" + optionValue, extentScreenshot());
//		Thread.sleep(1000);
//	}
}
