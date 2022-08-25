package com.edu.leavemng.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplicationsPage {
	public WebDriver driver=null;
	public ApplicationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		
	}
	@FindBy(xpath = "//a[text()=' Applications ']")
	private WebElement appMod;
	
	public WebElement getAppMod() {
		return appMod;
	}
	public void applications() {
		appMod.click();
	}

	public void selectuserapplication(String user) {
		driver.findElement(By.xpath(
				"//table/tbody/tr/td[text()='"+user+"']/following-sibling::td/button[@class='btn btn-success']"))
				.click();
	}
	
	
}
