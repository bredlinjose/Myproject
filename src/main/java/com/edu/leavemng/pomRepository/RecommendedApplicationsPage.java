package com.edu.leavemng.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecommendedApplicationsPage {
	public WebDriver driver =null;

	public RecommendedApplicationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;

	}

	@FindBy(xpath = "//a[text()=' Recommended Applications']")
	private WebElement recomappMod;
	
	@FindBy(xpath = "//label[text()='Sabbatical Leave']")
	private WebElement upLeave;
	
	@FindBy(xpath = "//input[@id='userLeaveFrom']")
	private WebElement modifyFrom;
	
	@FindBy(xpath = "//input[@id='userLeaveTo']")
	private WebElement modifyTo;

	@FindBy(name = "btnUserLeaveApplicationUpdate")
	private WebElement updateButton;
	
	@FindBy(xpath="//tr")
	private List<WebElement> rowsize;
	
	public WebElement getRecomappMod() {
		return recomappMod;
	}

	public WebElement getUpLeave() {
		return upLeave;
	}

	public WebElement getModifyFrom() {
		return modifyFrom;
	}

	public WebElement getModifyTo() {
		return modifyTo;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	public List<WebElement> getRowsize() {
		return rowsize;
	}

	public void recommendedApplications() {
		recomappMod.click();
	}

	public void selectuserreccapplication(String user) {
		driver.findElement(By.xpath(
				"//table/tbody/tr/td[text()='"+user+"']/following-sibling::td/button[@class='btn btn-success']"))
				.click();
	}
	public void updateApp(String user, String modifyFromDate, String modifyToDate) {
		driver.findElement(By.xpath(
				"//table/tbody/tr/td[text()='"+user+"']/following-sibling::td/button[@class='btn btn-info']"))
				.click();
		upLeave.click();
		modifyFrom.sendKeys(modifyFromDate);
		modifyTo.sendKeys(modifyToDate);
		updateButton.click();
		
		
	}

	
}
