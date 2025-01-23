package co.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.AdminPage;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class AdminPageTest {
	LoginPage lp; // dont declare here itsel

	DashboardPage dp;
	AdminPage ap;

	@BeforeMethod
	public void getSetup() {
		lp = new LoginPage();
		lp.Initialization();
	}

//	@AfterMethod
//	public void closeSetup() {
//		lp.tearDown();
//	}
	@Test
	public void validateAdminLabel() {
		dp = lp.getPageLogin();
		ap = dp.adminClick();
		boolean status = ap.getAdminLabel();
		Assert.assertTrue(status);
	}

	@Test
	public void validateAddUserClick() throws InterruptedException {
		dp = lp.getPageLogin();
		ap = dp.adminClick();
		ap.AddUserClick();
		ap.AdduserRole();
		try {
			ap.selectEmployeeName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ap.selectStatus();
		ap.AddUserName();
		ap.setPassword();
		ap.confirmPassword();
		ap.clickSaveButton();
		ap.searchUser();
		ap.UserEntry();
		String expectedRecord = ap.UserEntry();

		Assert.assertEquals(expectedRecord, "(1) Record Found");
		
		ap.deleteUser();
			String expectedDeleteRecord = ap.UserEntry();

			Assert.assertEquals(expectedDeleteRecord, "No Records Found"); 
		} 

}