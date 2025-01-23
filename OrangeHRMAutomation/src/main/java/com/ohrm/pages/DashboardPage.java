package com.ohrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ohrm.base.OHRMBase;

public class DashboardPage extends OHRMBase {
	
	public boolean getDashboardLabel() {
		return driver.findElement(By.xpath("//h6[text()= 'Dashboard']")).isDisplayed();
	}
	
	public boolean getTimeWorkSectionLabel() {
		return driver.findElement(By.xpath("//p[text()='Time at Work']")).isDisplayed();
	}
	
	public boolean getMYActionLabel() {
		return driver.findElement(By.xpath("//p[text()= 'My Actions']")).isDisplayed();
	}
	
	public boolean getQuickLaunchLabel() {
		return driver.findElement(By.xpath("//p[text()= 'Quick Launch']")).isDisplayed();
	}
	
	public boolean getBuzzLatestPostsLabel() {
		return driver.findElement(By.xpath("//p[text()= 'Buzz Latest Posts']")).isDisplayed();
	}
	
	public boolean getEmployeesonLeaveTodayLabel() {
		return driver.findElement(By.xpath("//p[text()= 'Employees on Leave Today']")).isDisplayed();
	}
	
	public boolean getEmployeeDistributionbySubUnitLabel() {
		return driver.findElement(By.xpath("//p[text()= 'Employee Distribution by Sub Unit']")).isDisplayed();
	}
	
	public boolean getEmployeeDistributionbyLocationLabel() {
		return driver.findElement(By.xpath("//p[text()= 'Employee Distribution by Location']")).isDisplayed();
	}
	
	public AdminPage adminClick() {
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
		return new AdminPage();
	}
	

}
