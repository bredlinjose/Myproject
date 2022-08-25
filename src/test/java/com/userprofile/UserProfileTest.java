package com.userprofile;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.leavemng.genericlib.BaseClass;
import com.edu.leavemng.genericlib.ExcelUtility;
import com.edu.leavemng.genericlib.WebDriverUtility;
import com.edu.leavemng.pomRepository.UserProfilePage;

public class UserProfileTest extends BaseClass {
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	
	@Test(groups="Smoke")
	public void verifyUserProfileTest() throws Throwable {

		String personalNum = eLib.getExcelDataStringType("Sheet1", 8, 3);
		String presentAdd = eLib.getExcelDataStringType("Sheet1", 8, 4);

		// navigate user profile and update the user details
		UserProfilePage up = new UserProfilePage(driver);
		up.userProfile(personalNum, presentAdd);
/*		
		// validation
		wLib.executeJavaScriptScroll(driver, "window.scrollBy(0,2000);");
		String expResult = "Successfully Updated";
		String actResult = up.getresult().getText();
		Assert.assertEquals(expResult, actResult);
*/	

	}

}
