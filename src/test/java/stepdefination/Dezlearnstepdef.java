package stepdefination;

import common.BasePage;
import io.cucumber.java.en.*;

public class Dezlearnstepdef  extends BasePage{

	@When("click on Test Sync Example")
	public void click_on_test_sync_example(String menuitem) throws InterruptedException {
		ObjHome.selectmenu();
		ObjHome.selectMenuItem(menuitem);
	}

	@Then("verify {string} displayed")
	public void verify_displayed() {
	    
	}

	@When("fill the details {string}, {string}, {string}")
	public void fill_the_details(String Firstname, String Lastname, String email) {
	    
	}

	@Then("click on Submit button")
	public void click_on_submit_button() {
	    
	}

	@Then("verify the ticket number")
	public void verify_the_ticket_number() {
	    
	}



}
