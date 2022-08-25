package com.edu.leavemng.genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LisImpClass implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
		int number=JavaUtility.getRanDomNumber();
		String testName = result.getMethod().getMethodName();
		System.out.println(testName + "Execute & I am Listnening");

		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("./ screenshot/" + testName+number + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
