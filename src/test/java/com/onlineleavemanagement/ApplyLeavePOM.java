package com.onlineleavemanagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.edu.leavemng.genericlib.ExcelUtility;
import com.edu.leavemng.genericlib.FileUtility;
import com.edu.leavemng.genericlib.JavaUtility;
import com.edu.leavemng.genericlib.WebDriverUtility;
import com.edu.leavemng.pomRepository.HomePage;
import com.edu.leavemng.pomRepository.LoginPage;
import com.edu.leavemng.pomRepository.LogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplyLeavePOM {

	public static void main(String[] args) throws Throwable {
		// Initialization
		WebDriver driver = null;
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();

		// get properties from common data
		String URL = fLib.getPropertyKeyValue("url");
		String UN = fLib.getPropertyKeyValue("username");
		String PWD = fLib.getPropertyKeyValue("password");
		String BR = fLib.getPropertyKeyValue("browser");

		// launch the browser
		if (BR.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BR.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("incorrect browser");
		}
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
		
		// login
		driver.get(URL);
		LoginPage lg = new LoginPage(driver);
		lg.loginToApp(UN, PWD);

		// get data from excel sheet
		String alterEmpCode = eLib.getExcelDataStringType("Sheet1", 2, 3);
		String empLeaveReason = eLib.getExcelDataStringType("Sheet1", 2, 4);
		String fromDate = eLib.getExcelDataStringType("Sheet1", 2, 5);
		String toDate = eLib.getExcelDataStringType("Sheet1", 2, 6);
		String contactAddressDuringLeave = eLib.getExcelData("Sheet1", 2, 7);
		HomePage hm = new HomePage(driver);
		hm.applyLeavePage(alterEmpCode, empLeaveReason, fromDate, toDate, contactAddressDuringLeave);

		// validation
		String currUrl = driver.getCurrentUrl();
		if (currUrl.contains("print")) {
			System.out.println("Test Pass");
		}
		driver.navigate().back();

		// logout application
		LogoutPage lt = new LogoutPage(driver);
		lt.logout();

		// close the browser
		driver.quit();

	}

}
