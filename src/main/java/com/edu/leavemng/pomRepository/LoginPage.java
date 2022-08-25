package com.edu.leavemng.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.leavemng.genericlib.WebDriverUtility;

public class LoginPage
{
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(id = "form-username")
	private WebElement codeEdt;
	
	@FindBy(id = "form-password")
	private WebElement passwordEdt;
	
	@FindBy(name = "btnSubmit")
	private WebElement buttonEdt;

	public WebElement getCodeEdt() {
		return codeEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getButtonEdt() {
		return buttonEdt;
	}

public void loginToApp(String username, String password) {
	
	codeEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	buttonEdt.click();
	}

}

