package com.SDET8BDD.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET8BDD.genericUtil.WebdriverUtility;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(xpath = "//img[contains(@src,'/images/user.PNG')]")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}


	public WebElement getAdminImg() {
		return adminImg;
	}


	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	public void signout() {
		new WebdriverUtility().moveToElement(driver, adminImg);
		signoutlink.click();
	}
	
	

}
