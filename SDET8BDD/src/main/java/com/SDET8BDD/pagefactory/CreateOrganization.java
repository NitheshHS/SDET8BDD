package com.SDET8BDD.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	WebDriver driver;
	public CreateOrganization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public OrganizationInfoPage createOrganization(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBtn.click();
		return new OrganizationInfoPage(driver);
	}
	

}
