package com.SDET8BDD.genericUtil;

import org.openqa.selenium.WebDriver;

import com.SDET8BDD.pagefactory.CreateOrganization;
import com.SDET8BDD.pagefactory.HomePage;
import com.SDET8BDD.pagefactory.LoginPage;
import com.SDET8BDD.pagefactory.OrganizationInfoPage;
import com.SDET8BDD.pagefactory.OrganizationPage;

public class BaseUtil {
	
	public WebDriver driver;
	public LoginPage lpage;
	public HomePage hpage;
	public OrganizationPage opage;
	public CreateOrganization cpage;
	public OrganizationInfoPage ipage;

}
