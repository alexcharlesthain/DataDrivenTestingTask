package com.qa.alex.selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TheDemoSite {

	//Reports
	public ExtentReports report;
	public ExtentTest test;
	public WebDriver driver;

	//Add a User page
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")
	private WebElement addUser;

	//Click Username box
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
	private WebElement usernameField;

	//Click Password box
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
	private WebElement passwordField;

	//Login Page
	@FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
	private WebElement loginLink;

	//Username Box + Enter 'test'
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement enterUsername;

	//Password Box + Enter 'password'
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement enterPassword;

	//Submit
	@FindBy(name = "FormsButton2")
	private WebElement saveButton;
	
	//Successful Login Text
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")
	private WebElement elements;


	//Create a User
	public void createNewUser() {
		//Creation of Report
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\DemoSiteReport.html", true);
		test = report.startTest("Create User account & login");
		test.log(LogStatus.PASS, "Website opened");
		test.log(LogStatus.INFO, "Add user page opened");
		
		addUser.click();
		usernameField.sendKeys("test");
		//Report
		test.log(LogStatus.INFO, "Username entered");

		//Password
		passwordField.sendKeys("password");
		//Report
		test.log(LogStatus.INFO, "Password entered");
		saveButton.click();

		//Login
		loginLink.click();
		//Report
		test.log(LogStatus.INFO, "Login page opened");
		enterUsername.sendKeys("test");
		
		//Reporting
		test.log(LogStatus.INFO, "Username entered");
		//Reporting
		test.log(LogStatus.INFO, "Password entered");
		enterPassword.sendKeys("Password");
		saveButton.click();

		// Login unsuccessful
		String expected = "**Successful Login**";
		try {
				assertEquals(expected, elements.getText());
				test.log(LogStatus.PASS, "Login message = " + elements.getText());
		} catch (AssertionError e) {
				test.log(LogStatus.FAIL, "Login message = " + elements.getText());
		}		
		report.endTest(test);
		report.flush();
	}

}


