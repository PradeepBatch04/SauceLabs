package stepdefination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import common.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;



public class SaucedemoStepdef extends BasePage{
	
	    
  @When("do login using {string} and {string} Sauce Demo credentials")
  public void login_to_Site(String Username, String Password) {	
	    	ObjLogin.login(Username, Password);   	
	 }
	    
  @Then("Collect the Prices of all products before filter")
  public void verify_values_in_productlist() {  
			objProductsPage.collectPricesbeforefilter();
  }
	    
  @When("Select filter dropdown {string}")
   public void selectFilter(String dropdown) {
	    	objProductsPage.Filter(dropdown);
  }
	    
	    @Then("verify the Prices of the products after filter")
	    public void verfify_prices_after_filter() {
	    	
			objProductsPage.prices_after_filter();
	    	
	    }
	    @When("add products to cart")
	    public void add_products_to_cart(DataTable dt) {
	    	List<Map<String, String>> dataList=dt.asMaps();
	    	for(int i=0;i<dataList.size();i++) {
	    		
	    		objProductsPage.addProductsToCart(dataList.get(i).get("Products"));
	    	}
     
	    }
	    @Then("Click on Cart")
	    public void click_on_cart() {
	        
	    }
	    @Then("verify sum product price and total shoudl be matched")
	    public void verify_sum_product_price_and_total_shoudl_be_matched() {
	    
	    }
	    
	    @When("Select Add to cart in the product list which are required")
	    public void List_products() {
//	    	objCartPage.SelectAddTOCart();
	    }
	    
	    @Then("verify number of products in the cart")
	    public void No_of_products_incart() {
	    	objCartPage.ProductAddToCartVisibility();
	    }
	    
	    @And("click on the cart")
	    public void Click_cart() {
	    	objCartPage.ClickonCart();
	    }
	    
	    @Then("verify the products in the cart which are added")
	    public void Verify_products() {
	    	objCartPage.ProductsInCart();
	    }
	    
	    @And("click on the checkout")
	    public void CLick_checkout() {
	    	objCartPage.checkout();
	    }
	    
	    @Then("fill the checkout information {string},{string}, {string}")
	    public void Fill_Checkout_info(String fname, String Lname, String pin) {
	    	objCheckoutPage.YourInformation(fname, Lname, pin);
	    }
	    
	    @And("click on continue")
	    public void Click_continue() {
	    	objCheckoutPage.ClickContinue();
	    }
	    
	    @When("verify the item total in the Checkout: Overview page")
	    public void verify_itemtotal() {
	    	objCheckoutPage.Overview();
	    }
	    
	    @Then("Click on the Finish")
	    public void Click_finish() {
	    	objCheckoutPage.Finish();
	    }
	    
	    @And("click on the Back Home")
	    public void click_back() {
	    	objCheckoutPage.Complete();
	    }

}
