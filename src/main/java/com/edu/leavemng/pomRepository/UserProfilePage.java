package com.edu.leavemng.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edu.leavemng.genericlib.WebDriverUtility;

public class UserProfilePage
{
	WebDriverUtility wLib =new WebDriverUtility();
	WebDriver driver=null;
	public UserProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//a[text()=' User Profile']")
	private WebElement userProf;
	
	@FindBy(id = "userPersonalPhoneNumber")
	private WebElement userPhNum;
	
	@FindBy(id = "userPresentAddress")
	private WebElement userPreAdd;
	
	@FindBy(id = "userPassword")
	private WebElement userPass;
	
	@FindBy(name = "btnUserInfoUpdate")
	private WebElement updateBtn;

	@FindBy(xpath = "//h3[text()='Successfully Updated']")
	private WebElement result;
	
	public WebElement getUserProf() {
		return userProf;
	}

	public WebElement getUserPhNum() {
		return userPhNum;
	}

	public WebElement getUserPreAdd() {
		return userPreAdd;
	}

	public WebElement getUserPass() {
		return userPass;
	}

	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	
	public WebElement getresult() {
		return result;
	}
	
	public void userProfile(String ph, String add) {
		userProf.click();
		wLib.executeJavaScriptScroll(driver, "window.scrollBy(0,2000);");
		userPhNum.click();
		userPhNum.clear();
		userPhNum.sendKeys(ph);
		userPreAdd.click();
		userPreAdd.clear();
		userPreAdd.sendKeys(add);
		updateBtn.click();
		
	}

}
