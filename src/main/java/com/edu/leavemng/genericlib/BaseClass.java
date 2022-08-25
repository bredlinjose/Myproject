package com.edu.leavemng.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.edu.leavemng.pomRepository.LoginPage;
import com.edu.leavemng.pomRepository.LogoutPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	/* Object Creation for Lib */
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public static WebDriver sDriver;
	/* Initialization */
	String URL;
	String UN;
	String PWD;
	String BR;

	@BeforeSuite(groups="Smoke")
	public void configBS() {
		System.out.println("==================== Connect the DataBase ====================");	
	}

	@BeforeClass(groups="Smoke")
	public void configBC() throws Throwable {
		System.out.println("==================== Launch the Browser ====================");

		BR = fLib.getPropertyKeyValue("browser");

		if (BR.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BR.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("incorrect browser");
		}
		sDriver=driver;
		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);	
	}
	
	@BeforeMethod(groups="Smoke")
	public void configBM() throws Throwable {
		System.out.println("==================== Login the Application ====================");
		
		URL = fLib.getPropertyKeyValue("url");
		UN = fLib.getPropertyKeyValue("username");
		PWD = fLib.getPropertyKeyValue("password");
		driver.get(URL);
		LoginPage lg = new LoginPage(driver);
		lg.loginToApp(UN, PWD);
	}

	@AfterMethod(groups="Smoke")
	public void configAM() {
		System.out.println("==================== Logout the Application ====================");
		
		LogoutPage lt = new LogoutPage(driver);
		lt.logout();
	}

	@AfterClass(groups="Smoke")
	public void configAC() {
		System.out.println("==================== Close the Browser ====================");
		
		driver.quit();
	}

	@AfterSuite(groups="Smoke")
	public void configAS() {
		System.out.println("==================== Close the DataBase ====================");
	}

}
