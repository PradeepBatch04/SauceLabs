package stepdefination;
import org.testng.annotations.Test;

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
    
    
    @Then("Enter {string}, {string}, {string} and {string} filter fields")
    public void Field_display(String Username, String User_Role, String Employee_Name, String Status) throws InterruptedException {
    	objhrmAdminPage.fields_aredisplayed(Username, User_Role, Employee_Name, Status);
    }
    
    @Then("click on the search")
    public void Search_click() {
    	objhrmAdminPage.searchbtn();
    }
 
    @And("Verify record {string}, {string}, {string}, {string} and {string}")
    public void verify_record(String Username, String User_Role, String Employee_Name, String Status,String action) throws InterruptedException{
    	objhrmAdminPage.verifyRecord(Username, User_Role, Employee_Name, Status,action);
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
    	
    }

    
    @When("Fill mandatory fields {string} {string} {string} {string} {string} {string}")
    public void fill_mandatory_fields(String UserRole, String EmployeeName, String Status, String Username, String Password, String ConfirmPassword) {
    	
    	
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
    @Then("Verify the record {string}, {string}, {string} and {string}")
    public void verify_the_record(String Username, String User_Role, String Employee_Name, String Status) {
    	
    }
    
    
}
