package com.userprofile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.edu.leavemng.genericlib.ExcelUtility;
import com.edu.leavemng.genericlib.FileUtility;
import com.edu.leavemng.genericlib.JavaUtility;
import com.edu.leavemng.genericlib.WebDriverUtility;
import com.edu.leavemng.pomRepository.LoginPage;
import com.edu.leavemng.pomRepository.LogoutPage;
import com.edu.leavemng.pomRepository.UserProfilePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UpdateUserProfilePOM {

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

		String personalNum = eLib.getExcelDataStringType("Sheet1", 8, 3);
		String presentAdd = eLib.getExcelDataStringType("Sheet1", 8, 4);

		// navigate user profile and update the user details
		UserProfilePage up = new UserProfilePage(driver);
		up.userProfile(personalNum, presentAdd);

		// validation
		wLib.executeJavaScriptScroll(driver, "window.scrollBy(0,2000);");
		String expResult = "Successfully Updated";
		String actResult = up.getresult().getText();

		if (expResult.equalsIgnoreCase(actResult)) {
			System.out.println("Test Case is Pass");
		} else {
			System.out.println("Test Case is Fail");
		}

		// logout application
		LogoutPage lt = new LogoutPage(driver);
		lt.logout();

		// close the browser
		driver.quit();

	}

}
