package com.ohrm.pages;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ohrm.base.OHRMBase;

public class AdminPage extends OHRMBase{
	
	String name= prop.getProperty("name");
	 String newGeneratedName= name+RandomStringUtils.randomAlphanumeric(4).toUpperCase();
	
	 Actions act = new Actions(driver);
 public boolean getAdminLabel() {
	return driver.findElement(By.xpath("//h6[text()='Admin']")).isDisplayed();
 }
 
 public void AddUserClick(){
	 driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
	 
 }
 
 public void AdduserRole() {
	//WebElement target = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div"));
	  act.click(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div")))
	  .keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	 
 }
 
 public void selectEmployeeName() throws InterruptedException {
	 
	 act.click(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")))
	 .keyDown(Keys.ENTER).sendKeys("a").perform();
	Thread.sleep(6000);
	act.keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	 

 }
 
 public void selectStatus() {
	 act.click(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")))
	  .keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).perform();
	 
}
 
 public void AddUserName() {
	 driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")).sendKeys(newGeneratedName);
 }
 
 public void setPassword() {
	 driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")).sendKeys(prop.getProperty("password"));
 }
 
public void confirmPassword() {
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")).sendKeys(prop.getProperty("password"));
}

public void clickSaveButton() {
	driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
}

public void searchUser() throws InterruptedException {
 driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys(newGeneratedName);
 
 act.click(driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]"))).perform();
 Thread.sleep(2000);
}

public String UserEntry() {
	return driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
}

public String deleteUser() throws InterruptedException {
	driver.findElement(By.xpath("//button[@class= 'oxd-icon-button oxd-table-cell-action-space']")).click();
	driver.findElement(By.xpath("//Button[@class= 'oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
	Thread.sleep(3000);
	return driver.findElement(By.xpath("//span[@class= 'oxd-text oxd-text--span']")).getText();
	}




}
