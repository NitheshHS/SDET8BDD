package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.SDET8BDD.genericUtil.BaseUtil;
import com.SDET8BDD.genericUtil.WebdriverUtility;
import com.SDET8BDD.pagefactory.CreateOrganization;
import com.SDET8BDD.pagefactory.HomePage;
import com.SDET8BDD.pagefactory.OrganizationInfoPage;
import com.SDET8BDD.pagefactory.OrganizationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrganizationStepDef extends BaseUtil{
	BaseUtil base;
	List<Map<String, String>> data;
	public OrganizationStepDef(BaseUtil base) {
		this.base=base;
	}

	@When("I want to click on organization link in homepage")
	public void i_want_to_click_on_organization_link_in_homepage() {
		hpage=new HomePage(base.driver);
     hpage.getOrganizationLink().click();
	}

	@When("I will click on create oraganization link")
	public void i_will_click_on_create_oraganization_link() {
      opage=new OrganizationPage(base.driver);
      opage.getCreateOrgLink().click();
	}

	@When("I create an orgnaziation using mandatory fileds and click on save")
	public void i_create_an_orgnaziation_using_mandatory_fileds_and_click_on_save(io.cucumber.datatable.DataTable dataTable) {
    cpage=new CreateOrganization(base.driver);
    data = dataTable.asMaps(String.class, String.class);
    cpage.createOrganization(data.get(0).get("OrganizationName")+WebdriverUtility.randomInt());
	}

	@Then("I navigate to organization information and verify")
	public void i_navigate_to_organization_information_and_verify() {
		ipage=new OrganizationInfoPage(base.driver);
    String orgname = ipage.getOrganizationInfo().getText();
    Assert.assertEquals(orgname,data.get(0).get("OrganizationName") );
	}

	@Then("logout from the application")
	public void logout_from_the_application() {

	}
}
