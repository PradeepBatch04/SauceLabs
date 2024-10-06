package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	Actions actions;
	
	
	@FindBy(how = How.CLASS_NAME, using= "shopping_cart_link") private WebElement cartElement;
	@FindBy(how = How.XPATH, using= "//span[@data-test='shopping-cart-badge']") private WebElement totalproductsincartElement;
	@FindBy(how = How.ID, using= "checkout") private WebElement checkoutElement;
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='inventory_item_price']")
			
			) private List<WebElement> pricevalueElement;
	
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	
	
	public void ProductAddToCartVisibility() {
		String NoOfProducts = totalproductsincartElement.getText();
		
		System.out.println("Products in cart visibility: " + NoOfProducts);
		
	}
	

	public void ClickonCart() {
		cartElement.click();
	}
	
	
	public void ProductsInCart() {
		int productsincart = pricevalueElement.size();
		System.out.println("Total products in the cart " + productsincart);
		
	} 
    	
    public void checkout() {
    	checkoutElement.click();
    }

}
