package com.ohrm.pages;

import org.openqa.selenium.By;

import com.ohrm.base.OHRMBase;

public class LoginPage extends OHRMBase  {
	
	/*
	 * @FindBy(name= "username")
	WebElement txtUsername;
	@FindBy(name= "password")
	WebElement txtPassword;
	@FindBy(xpath= "//button[@type= 'submit']")
	WebElement btnLogin;

public LoginPage() {
		PageFactory.initElements(driver, LoginPage.class);
	}


public DashboardPage getPageLogin() {
		txtUsername.sendKeys("Admin");
		txtPassword.sendKeys("admin123");
		btnLogin.click();
		//boolean status = driver.findElement(By.xpath("//h6[text()= 'Dashboard']")).isDisplayed();
		return new DashboardPage();

	}
	 */


	public  String getPageTitle() {
		return driver.getTitle();
		

	}

	public DashboardPage getPageLogin() {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name= 'password']")).sendKeys("admin123");
		captureScreenshot(driver, "loginPage");
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		//boolean status = driver.findElement(By.xpath("//h6[text()= 'Dashboard']")).isDisplayed();
		return new DashboardPage();

	}


}
