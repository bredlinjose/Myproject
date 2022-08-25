package com.updaterecommendedleave;

import org.testng.annotations.Test;

import com.edu.leavemng.genericlib.BaseClass;
import com.edu.leavemng.genericlib.ExcelUtility;
import com.edu.leavemng.genericlib.FileUtility;
import com.edu.leavemng.pomRepository.ApplicationsPage;
import com.edu.leavemng.pomRepository.HomePage;
import com.edu.leavemng.pomRepository.RecommendedApplicationsPage;

public class RecommendedApplicationsTest extends BaseClass {
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	@Test
	public void updateLeaveTest() throws Throwable {
		String alterEmpCode = eLib.getExcelDataStringType("Sheet1", 2, 3);
		String empLeaveReason = eLib.getExcelDataStringType("Sheet1", 2, 4);
		String fromDate = eLib.getExcelDataStringType("Sheet1", 2, 5);
		String toDate = eLib.getExcelDataStringType("Sheet1", 2, 6);
		String contactAddressDuringLeave = eLib.getExcelData("Sheet1", 2, 7);
		HomePage hm = new HomePage(driver);
		hm.applyLeavePage(alterEmpCode, empLeaveReason, fromDate, toDate, contactAddressDuringLeave);

		driver.navigate().back();

		// navigating application and recommend the application
		String user1 = fLib.getPropertyKeyValue("user1");
		ApplicationsPage app = new ApplicationsPage(driver);
		app.applications();
		app.selectuserapplication(user1);
		
		String modifyFromDate = eLib.getExcelDataStringType("Sheet1", 14, 3);
		String modifyToDate = eLib.getExcelDataStringType("Sheet1", 14, 4);
		
		// navigating recommended module and click on approve
		RecommendedApplicationsPage rec = new RecommendedApplicationsPage(driver);
		rec.recommendedApplications();
		rec.updateApp(user1, modifyFromDate, modifyToDate);

	}

}
