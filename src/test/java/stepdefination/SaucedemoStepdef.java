package stepdefination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.*;
import pages.LoginSaucePage;
import pages.ProductsPage;


public class SaucedemoStepdef {
	
	WebDriver driver;
	LoginSaucePage ObjLogin;
	ProductsPage objProductsPage;
	
	@Given("Open {string} Browsers")
	public void Chromebrowser(String browser) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		ObjLogin = new LoginSaucePage(driver);
		objProductsPage= new ProductsPage(driver);
	}
	
    @And("launch site URL {string}")
    public void Siteurl(String URL) {
    	driver.get(URL);
    }
    
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
    
    
    
    @When("Select {string} in the product list which are required")
    public void List_products(String Products) {}
    
    @Then("verify number of products in the cart")
    public void No_of_products_incart() {}
    
    @And("click on the cart")
    public void Click_cart() {}
    
    @Then("verify the products in the cart which are added")
    public void Verify_products() {}
    
    @And("click on the checkout")
    public void CLick_checkout() {}
    
    @Then("fill the checkout information {string},{string}, {string}")
    public void Fill_Checkout_info(String fname, String Lname, String pin) {}
    
    @And("click on continue")
    public void Click_continue() {}
    
    @When("verify the item total in the Checkout: Overview page")
    public void verify_itemtotal() {}
    
    @Then("Click on the Finish")
    public void Click_finish() {}
    
    @And("click on the Back Home")
    public void click_back() {}

}
