package co.ohrm.testcases;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.AdminPage;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;


class dashboardPageTest {
	LoginPage lp; // dont declare here itself
	DashboardPage dp;
	AdminPage ap;
	
	
	@BeforeMethod
	public void getSetup() {
		lp = new LoginPage();
		lp.Initialization();
	}
	
	@AfterMethod
	public void closeSetup() {
		lp.tearDown();
	}
	
	@Test
	public void validateDashboardLabel() {
		dp= lp.getPageLogin();
		boolean status = dp.getDashboardLabel();
		Assert.assertTrue(status);
	}
	
	public void validateTimeWorkSelectionLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getTimeWorkSectionLabel());
	}
	
	@Test
	public void validateMYActionLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getMYActionLabel());
	}
	
	@Test
	public void validateQuickLaunchLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getQuickLaunchLabel());
	}
	
	@Test 
	public void validateBuzzLatestPostsLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getBuzzLatestPostsLabel());
	}
	
	@Test
	public void validateEmployeesonLeaveTodayLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getEmployeesonLeaveTodayLabel());
	}
	
	@Test
	public void validateEmployeeDistributionbySubUnitLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getEmployeeDistributionbySubUnitLabel());
	}
	
	@Test
	public void validateEmployeeDistributionbyLocationLabel() {
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getEmployeeDistributionbyLocationLabel());
	}
	@Test
	public void validateAdminClick() {
		ap= dp.adminClick();
		Assert.assertTrue(ap.getAdminLabel());
	}
	
	
	
	
}
