package com.edu.leavemng.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver=null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "livAltEmpCode")
	private WebElement altempcodename;

	@FindBy(xpath = "//label[text()='Unpaid Leave']")
	private WebElement leavetype;

	@FindBy(id = "livReason")
	private WebElement leavereason;

	@FindBy(id = "livEmplivFrom")
	private WebElement from;

	@FindBy(id = "livEmplivTo")
	private WebElement to;

	@FindBy(id = "livAddress")
	private WebElement contactaddressduringleave;

	@FindBy(xpath = "//button[text()='Apply']")
	private WebElement applybutton;

	@FindBy(xpath = "//label[text()='Unpaid Leave']")
	private WebElement leavetypenxt;

	@FindBy(name = "btnFinalSubmit")
	private WebElement finalapply;
	
	@FindBy(xpath="//h3[text()='Your Application Is Successfully Placed']")
	private WebElement result;

	public WebElement getResult() {
		return result;
	}

	public WebElement getAltempcodename() {
		return altempcodename;
	}

	public WebElement getLeavetype() {
		return leavetype;
	}

	public WebElement getLeavereason() {
		return leavereason;
	}

	public WebElement getFrom() {
		return from;
	}

	public WebElement getTo() {
		return to;
	}

	public WebElement getContactaddressduringleave() {
		return contactaddressduringleave;
	}

	public WebElement getApplybutton() {
		return applybutton;
	}

	public WebElement getleavetypenxt() {
		return leavetypenxt;
	}

	public WebElement getfinalapply() {
		return finalapply;
	}

	public void applyLeavePage(String alterEmpCodeName, String empLeaveReason, String fromDate,
			String toDate, String contactAddressDuringLeave) {
		altempcodename.sendKeys(alterEmpCodeName);
		leavetype.click();
		leavereason.sendKeys(empLeaveReason);
		from.sendKeys(fromDate);
		to.sendKeys(toDate);
		contactaddressduringleave.sendKeys(contactAddressDuringLeave);
		applybutton.click();
		leavetypenxt.click();
		finalapply.click();

	}
}
