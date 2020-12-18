package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef{
	WebDriver driver;
	@Given("I want to launch the browser")
	public void i_want_to_launch_the_browser() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	

	@When("Login page is displayed enter the username and password and click on login")
	public void login_page_is_displayed_enter_the_username_and_password_and_click_on_login() {
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("manager");
	    driver.findElement(By.id("submitButton")).click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
	  String homeTitle=driver.getTitle();
	  Assert.assertEquals(homeTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
	  driver.close();
	}
	@Then("Home page should be not be displayed and error messege should be displayed")
	public void home_page_should_be_not_be_displayed_and_error_messege_should_be_displayed() {
	   String errmsg=driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	   Assert.assertEquals(errmsg, "You must specify a valid username and password.");
	   driver.close();
	}
	@When("Login page is displayed enter the username {string} and password {string} and click on login")
	public void login_page_is_displayed_enter_the_username_and_password_and_click_on_login(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	}
	@Given("I enter the url {string}")
	public void i_enter_the_url(String url) {
	    driver.get(url);
	}
	@When("login page is diplayed enter {string} and {string} and click on login button")
	public void login_page_is_diplayed_enter_and_and_click_on_login_button(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
	    driver.findElement(By.name("user_password")).sendKeys(password);
	    driver.findElement(By.id("submitButton")).click();
	}
}
