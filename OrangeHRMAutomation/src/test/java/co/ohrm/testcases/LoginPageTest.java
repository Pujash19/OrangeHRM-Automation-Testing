package co.ohrm.testcases;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.annotations.VisibleForTesting;
import com.ohrm.base.OHRMBase;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class LoginPageTest {
	LoginPage lp; // dont declare here itself
	DashboardPage dp;
	
	
	@BeforeTest
	public void reportConfiguration() {
		OHRMBase.configureExtentReports();
	}

	
	@AfterTest
	public void publicReport() {
		OHRMBase.generateReports();
	}
	
	
	
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
	public void ValidateTitleTest() {
		ExtentTest test = lp.extent.createTest("Validating Title of page");
		String expTitle = "OrangeHRM";
		//lp = new LoginPage();
		String actTitle = lp.getPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		test.log(Status.PASS, "Title test case pass");
	}


	@Test
	public void ValidateLoginTest() {
		ExtentTest test = lp.extent.createTest("Validating Login of page");
	/*	String label= "dashboard";
		String currentURL= lp.getPageLogin();
		boolean status = currentURL.contains(label);
		Assert.assertTrue(status); */
		
		//Assert.assertTrue(lp.getPageLogin().contains("dashboard"));
		dp= lp.getPageLogin();
		Assert.assertTrue(dp.getDashboardLabel());
		test.log(Status.PASS, "Login test case pass");
	}
	

}
