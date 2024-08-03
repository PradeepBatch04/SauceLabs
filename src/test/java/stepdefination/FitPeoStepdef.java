package stepdefination;

import common.BasePage;
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
	   objRevenueCalculator.adjustSlider(value);
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



}
