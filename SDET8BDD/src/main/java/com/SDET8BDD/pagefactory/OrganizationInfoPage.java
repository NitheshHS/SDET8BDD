package com.SDET8BDD.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationInfo;
	
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}
	
	
	
}
