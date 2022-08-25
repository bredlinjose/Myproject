package com.approveleave;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.leavemng.genericlib.BaseClass;
import com.edu.leavemng.genericlib.FileUtility;
import com.edu.leavemng.pomRepository.ApplicationsPage;
import com.edu.leavemng.pomRepository.RecommendedApplicationsPage;

@Listeners(com.edu.leavemng.genericlib.LisImpClass.class)
public class ApplicationTest extends BaseClass {

	FileUtility fLib = new FileUtility();

	@Test
	public void approveLeaveTest() throws Throwable {

		// navigating application and recommend the application
		String user1 = fLib.getPropertyKeyValue("user1");
		ApplicationsPage app = new ApplicationsPage(driver);
		app.applications();

		app.selectuserapplication(user1);

		// navigating recommended module and click on approve
		RecommendedApplicationsPage rec = new RecommendedApplicationsPage(driver);
		rec.recommendedApplications();

		int actSize = rec.getRowsize().size();
		rec.selectuserreccapplication(user1);
		driver.navigate().back();
		System.out.println(actSize);
/*
		// validation
		int expSize = rec.getRowsize().size();
		System.out.println(expSize);
		Assert.assertEquals(actSize, expSize+1);
*/
	}

}
