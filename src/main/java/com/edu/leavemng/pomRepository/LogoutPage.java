package com.edu.leavemng.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	public void logout() {
		logoutBtn.click();
		
	}
	
}
