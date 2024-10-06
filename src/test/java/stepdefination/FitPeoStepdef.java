package stepdefination;

import java.util.*;

import common.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class FitPeoStepdef extends BasePage{

	
	@When("Navigate to the {string} Page")
	public void navigate_to_the_page(String screen) {
	 objpeoHomePage.selectMenuItem(screen); 
	}

	@Then("verify screen navigate to the Revenue Calculator page")
	public void verify_screen_navigate_to_the_revenue_calculator_page() {
	    
	}

	@Then("Scroll to revenue calculator slider")
	public void scroll_to_revenue_calculator_slider() {
		objRevenueCalculator.revenue_calculator_slider();
	}

	@Then("Adjust the slider to {int}")
	public void adjust_the_slider_to(int value) {
		
	objRevenueCalculator.adjustSlider_auto(value);
	}
	
	@Then("bottom text field value should be updated to {int}")
	public void bottom_text_field_value_should_be_updated_to(Integer value) {
	   objRevenueCalculator.bottom_text_field(value);
	}
	
	@When("Enter the value {int} in the text field")
	public void enter_the_value_in_the_text_field(Integer value) {
	    objRevenueCalculator.enter_value_text_field(value);
	}

	@Then("verify slider's position is updated to {int}.")
	public void verify_slider_s_position_is_updated_to(Integer value) {
		objRevenueCalculator.verifysliderpositionupdated(value);
	}
	
	@When("select the checkboxes")
	public void select_the_checkboxes(DataTable dt) {
		List<Map<String, String>> datatable =dt.asMaps();
		for(int i=0;i<datatable.size();i++) {
			String checkbox=datatable.get(i).get("Checkboxes").trim();
			objRevenueCalculator.selectCheckBoxes(checkbox);
		}
	  
	}

	@Then("Verify that the header displaying {string}")
	public void verify_that_the_header_displaying(String amount) {
	  objRevenueCalculator.verifyHeaderandamount(amount);
	}




}
