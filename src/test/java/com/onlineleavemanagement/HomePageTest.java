package com.onlineleavemanagement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.leavemng.genericlib.BaseClass;
import com.edu.leavemng.genericlib.ExcelUtility;
import com.edu.leavemng.pomRepository.HomePage;

public class HomePageTest extends BaseClass {
	
	ExcelUtility eLib = new ExcelUtility();
	@Test(groups="Smoke")
	public void applyLeave() throws Throwable {
		
		String alterEmpCode = eLib.getExcelDataStringType("Sheet1", 2, 3);
		String empLeaveReason = eLib.getExcelDataStringType("Sheet1", 2, 4);
		String fromDate = eLib.getExcelDataStringType("Sheet1", 2, 5);
		String toDate = eLib.getExcelDataStringType("Sheet1", 2, 6);
		String contactAddressDuringLeave = eLib.getExcelData("Sheet1", 2, 7);

		HomePage hm = new HomePage(driver);
		hm.applyLeavePage(alterEmpCode, empLeaveReason, fromDate, toDate, contactAddressDuringLeave);
		driver.navigate().back();
/*
		// validation
		String expectedResult= "Your Application Is Successfully Placed";
		String actualResult= hm.getResult().getText();
		Assert.assertEquals(actualResult, expectedResult);
*/
		
	}
}
