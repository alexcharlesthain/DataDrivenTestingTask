package com.qa.alex.selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReadFromExcelSheet {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	String LoginData = "";

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
		driver = new ChromeDriver();
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Documents\\DDT.html");
		test = report.startTest("StartingTest");
	}
	
	@Test
	public void excelTest() throws IOException, InterruptedException {
	
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\AUTOMATED_TESTING_WEEK_10\\TheDemoSiteTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			Cell username = sheet.getRow(i).getCell(0);
			Cell password = sheet.getRow(i).getCell(1);

			String user = username.getStringCellValue();
			String pass = password.getStringCellValue();
			
			driver.get("http://php.thedemosite.co.uk/");
			test.log(LogStatus.INFO, "navigate to demosite homepage");

			test.log(LogStatus.INFO, "inputting new username");
			
			
	}	
	}
	
	@After
	public void tearDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}	
}