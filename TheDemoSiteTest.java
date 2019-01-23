package com.qa.alex.selenium;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TheDemoSiteTest {
	
		public ExtentReports report;
		public ExtentTest test;
	
		private WebDriver driver;
		  @SuppressWarnings("unused")
		private String baseUrl;
		  @SuppressWarnings("unused")
		private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @Before
		  public void setUp() throws InterruptedException  {
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
    
		  @Test
		  /*public void testTheDemoSiteTestCase() throws Exception {		    
			report = new ExtentReports("C:\\Users\\Admin\\Documents\\DemoSiteReport.html", true);
			test = report.startTest("Verify Site Title");
			driver.manage().window().maximize();
			driver.get("http://www.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "Browser Started"); 
			*/	
			public void clickLink() {
				driver.get("http://php.thedemosite.co.uk/");
				TheDemoSite page = PageFactory.initElements(driver, TheDemoSite.class);
				page.createNewUser();
			}  	
//}		
		  @After
			public void tearDown() throws Exception {
				Thread.sleep(8000);    
				driver.quit();
				    String verificationErrorString = verificationErrors.toString();
				    if (!"".equals(verificationErrorString)) {
				      fail(verificationErrorString);
				    }
}
}