/**
 * 
 */
package com.Cosmoslots.testCases;

import org.testng.annotations.Test;

import com.Cosmoslots.ENUM.MatErrorMsg;
import com.Cosmoslots.pageObjects.CommonCosmo;
import com.Cosmoslots.pageObjects.GuestPlayers;
import com.Cosmoslots.pageObjects.LobbyPage_Old;
import com.Cosmoslots.pageObjects.UserPage;
import com.Cosmoslots.utilities.BaseClass;

/**
 * @author shrikrushna.sonkar
 *
 */
public class CashOnlyStore extends BaseClass {
	private LobbyPage_Old lp;
	private CommonCosmo cc;
	private UserPage up;
	private GuestPlayers gp;

	@Test
	public void A_TC_CashOnly_Store() throws InterruptedException {
		test = extentCreateTest("Cash only store edit");
		test.info("As an Admin I should be able to verify the cash only store toggle is disable ");
		lp = new LobbyPage_Old(driver);
		gotoTab(driver, 0);
		lp.GoToStoreEdit("CASHONLY");
		if (lp.cashOnly_toggle.getAttribute("class").contains("disabled")) {
			test.pass("Successfully verified cash only store toggle is disabled", extentScreenshot());
		} else {
			test.fail("Something Wrong ! cash only store toggle is not disabled", extentScreenshot());
		}
		lp.ClickToSave();
	}

	@Test
	public void B_TC_CreateCashOnlyStore_Users() throws InterruptedException {
		createCashOnlyStoreUsers(new String[] { "Gameium Admin ", "Master " }, MatErrorMsg.Email_Error_msg);
	}

	@Test
	public void C_TC_CreateCashOnlyStore_Users() throws InterruptedException {
		createCashOnlyStoreUsers(new String[] { "Distributor ", "Sub Distributor ", "Store ", "POS " },
				MatErrorMsg.ParentUser_Error_msg);
	}

	private void createCashOnlyStoreUsers(String[] roles, Enum<?> errorMsg) throws InterruptedException {
		up = new UserPage(driver);
		gp = new GuestPlayers(driver);
		cc = new CommonCosmo(driver);
		up.clickUsermanagementButton();
		up.clickUserProfile();
		up.ClickOnBack();
		if (up.UserProfile_Header != null) {
			test.pass("Opened User Management->Users Profile Successfully");
			Thread.sleep(2000);
			gp.clickCreateNewButton();
//			Thread.sleep(2000);
			explicitWait(driver, up.CreateUserProfile_header, 10);
			gp.selectStore("CashOnly - (CASHONLY) ");
			for (String role : roles) {
				test = extentCreateTest("Create cash only store user -" + role);
				test.info("As an Admin I should be able to verify email field mandatory for dealer & dealer user");
				Thread.sleep(2000);
				gp.selectUserRole(role);
				up.clickToSave();
				cc.VerifyErrorMsg(((MatErrorMsg) errorMsg).getErrorValues());
			}
		}
	}
}
