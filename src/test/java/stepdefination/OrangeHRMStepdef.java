package stepdefination;
import common.BasePage;
import io.cucumber.java.en.*;

public class OrangeHRMStepdef extends BasePage{
	
	
	@When("login using username as {string} and password {string}")
	public void Login_using_username_password(String Username, String Password) {
		objhrmLoginPage.login_Page(Username, Password);
	}
	
    @Then("Verify that Dashboard is dispalyed")
    public void verify_that_dashbord() {
    	objhrmHomePage.dashboard_isdisplayed();
    }
    
    @When("Click on the {string} from the menu")
    public void click_on_menuitems(String items) throws InterruptedException {
    	objhrmHomePage.selectMenuItem(items);
    }
    
    @Then("Verify Username, User Role, Employee Name, Status fields are displayed")
    public void Field_display() {
    	objhrmAdminPage.fields_aredisplayed();
    }
    
    @And("fill {string} field")
    public void Field_fill(String Username) {
    	objhrmAdminPage.enter_data_into_field(Username);
    }
    
    @Then("click on the search")
    public void Search_click() {
    	objhrmAdminPage.searchbtn();
    }
    
    @When("click on the {string}")
    public void Logoutpage(String item) throws InterruptedException {
    	objhrmLogoutPage.clickOnUserIcon();
    	objhrmLogoutPage.selectMenuItems(item);
    }
    
    @Then("Loginpage should be redisplayed")
    public void Redisplay_loginpage() {
    	System.out.println("Redisplayed to Login Page" + driver.getTitle());
    }
    
    @Then("click on the Add button to add user")
    public void click_on_the_add_button_to_add_user() {
    	objhrmRecruitmentPage.addButton();
    }

    @Then("Verify that Recruitment page is dispalyed")
    public void verify_that_Recruitment_page_is_dispalyed() {
    	objhrmRecruitmentPage.pageTitle();
    }

    @When("Fill mandatory fields {string}, {string}, {string}")
    public void fill_mandatory_fields(String FirstName, String LastName, String Email) {
        
    }

    @Then("click on the {string} button")
    public void click_on_the_button(String Save) {
        
    }

    @Then("Fill {string} field")
    public void fill_field(String CandidateName) {
        
    }

    @Then("Click on {string}")
    public void click_on(String Search) {
        
    }
    @Then("Verify the record")
    public void verify_the_record() {
    	
    }
    
    
}
