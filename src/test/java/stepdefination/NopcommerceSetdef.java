package stepdefination;

import common.BasePage;
import io.cucumber.java.en.*;


public class NopcommerceSetdef extends BasePage {

	
	@When("do login using {string} and {string} credentials")
	public void do_login_using_and_credentials(String username, String password) {
		objNopLoginPage.loginNonComperence(username, password);
	}

	@Then("verify the dashboard displayed")
	public void verify_the_dashboard_displayed() {
	 objnopHomePage.verifyDashboard();
	  
	}
	
	@When("Click the {string} from the menu")
	public void click_the_from_the_menu(String item) throws InterruptedException {
		objnopHomePage.selectMenuItem(item);
	}

	@When("Click on the {string} in Catalog")
	public void click_on_the_in_catalog(String subItem) throws InterruptedException {
	   objnopHomePage.subMenuItem(subItem, null);
	}
	
//	And Click on the "Attributes" and subItem "Product attributes" in Catalog
	@When("Click on the subItem {string} and subsubItem {string} in Catalog")
	public void click_on_the_in_catalog1(String subItem1, String subItem2) throws InterruptedException {
	   objnopHomePage.subMenuItem(subItem1, subItem2);
	}
	
	@When("fill the filter details of Product {string} {string} {string} {string}")
	public void fill_the_filter_details_of_product(String Productname, String Category, String Published, String SKU) {
		objnopProductPage.fillFilterdeatis(Productname, Category, Published, SKU);
	}

	@Then("Verify the record in Products table {string} {string} {string} {string} {string} {string}")
	public void verify_the_record_in_products_table(String Productname, String SKU, String Price, String Stockquantity, String Published, String action) {
		objnopProductPage.verifyProductRecord(Productname, SKU, Price, Stockquantity, Published, action);
	}
	@Then("Click on Logout")
	public void click_on_logout() throws Exception {
		objnopHomePage.clickOnLogOut();
	}
}
