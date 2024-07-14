package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductsPage {
	
	WebDriver driver;
	Actions actions;
	List<Float> pricesbefore;
	List<Float> pricesafter;
	
	@FindBy(how = How.ID, using= "user-name") private WebElement usernameElement;
	@FindBy(how = How.XPATH, using="//select[@data-test='product-sort-container']") private WebElement filterElement;
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='inventory_item_price']")
			
			) private List<WebElement> pricevalueElement;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	
	public void collectPricesbeforefilter() {	
  	
		pricesbefore=collectPrices(pricevalueElement);
		
    	System.out.println("values before sorting:" + " " +pricesbefore);;
    	Collections.sort(pricesbefore);
    	System.out.println("values After sorting in Ascending order:" + pricesbefore);
	}
	
	public void Filter(String value) {
		
		Select select = new Select(filterElement);
		select.selectByVisibleText(value);
	}
	
	public void prices_after_filter() {
		 pricesafter=collectPrices(pricevalueElement);
		 System.out.println("Prices After filter:" + pricesafter);
		 Assert.assertTrue(pricesbefore.equals(pricesafter));
		 
		 
		 
	}
	
	
///////////////////////////////////////////////////////////////////////////////	
	private List<Float> collectPrices(List<WebElement> element){
		List<Float> prices = new ArrayList<Float>();
    	for(int i=0; i<element.size(); i++) {
    		String a = element.get(i).getText();
    		String x = a.replace("$", "");
    		float f=Float.parseFloat(x); 
    		prices.add(f);
    		
    	}
    	
    	return prices;
    	
	}
	
}
