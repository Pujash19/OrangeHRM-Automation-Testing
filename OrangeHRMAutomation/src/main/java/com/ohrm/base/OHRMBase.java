package com.ohrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputFilter.Config;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class OHRMBase {
	
	 protected static WebDriver driver;
	 public static Properties prop;
	 public static ExtentReports extent;
	 public static ExtentSparkReporter reporter;
	 
	 
	 private void loadProperties() {
		 String configFilePath= "./src/main/java/com/ohrm/base/config.properties";
		 try {
			FileInputStream fis = new FileInputStream(configFilePath);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	
	public void Initialization() {
	loadProperties();
       String browserName= prop.getProperty("browser");
       if(browserName.equalsIgnoreCase("chrome")) {
    	   driver= new ChromeDriver();
       }
       else if(browserName.equalsIgnoreCase("ie")) {
    	   driver= new InternetExplorerDriver();
       }
       else if(browserName.equalsIgnoreCase("fire-dox")) {
    	   driver= new FirefoxDriver();
       }
       else if(browserName.equalsIgnoreCase("edge driver")) {
    	   driver= new EdgeDriver();
       }
       else
    	   throw new RuntimeException("Browser not supported: " + browserName);
       
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("baseurl"));
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	
	public static void configureExtentReports() {
		String ReportPath= "./Reports";
		extent = new ExtentReports();
		reporter= new ExtentSparkReporter(ReportPath);
		extent.attachReporter(reporter);
	}
	
	public static void generateReports() {
		extent.flush();
	}

	
	public static void captureScreenshot(WebDriver driver, String fileName ) {
		String path = "./Screenshot/"+fileName+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(screenshot, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
