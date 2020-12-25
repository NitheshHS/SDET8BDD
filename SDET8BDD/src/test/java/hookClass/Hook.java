package hookClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.SDET8BDD.genericUtil.BaseUtil;
import com.SDET8BDD.genericUtil.FileLib;
import com.SDET8BDD.genericUtil.WebdriverUtility;
import com.SDET8BDD.pagefactory.HomePage;
import com.SDET8BDD.pagefactory.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends BaseUtil{
	BaseUtil base;
	FileLib fLib=new FileLib();
	WebdriverUtility wLib=new WebdriverUtility();
	public Hook(BaseUtil base) {
		this.base=base;
	}

	@Before(order = 0)
	public void setUp() throws Throwable {
		if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(fLib.getPropertyKeyValue("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		else
		{
			WebDriverManager.chromedriver().setup();
		base.driver=new ChromeDriver();
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Before(order = 1)
	public void before() throws Throwable {
		base.driver.get(fLib.getPropertyKeyValue("url"));
		lpage=new LoginPage(base.driver);
		lpage.login(fLib.getPropertyKeyValue("username"), fLib.getPropertyKeyValue("password"));
	}
	@After(order=1)
	public void tearDown(Scenario scenario) throws Throwable {
		if(scenario.isFailed()) {
			String scenarioName = scenario.getName().replaceAll(" ", "_");
			byte[] Screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(Screenshot, "image/png", scenarioName);
		}
	}

	@After(order=0)
	public void after() {
		hpage=new HomePage(base.driver);
		hpage.signout();
		base.driver.quit();
	}


}
