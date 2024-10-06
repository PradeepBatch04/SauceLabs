package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class checkoutpage {
	
	WebDriver driver;
	Actions actions;
	ProductsPage objProductsPage;
	List<Float> Productsprices;
	
	@FindBy(how = How.ID, using= "first-name") private WebElement nameElement;
	@FindBy(how = How.ID, using= "last-name") private WebElement lastnameElement;
	@FindBy(how = How.ID, using= "postal-code") private WebElement pinElement;
	@FindBy(how = How.ID, using= "continue") private WebElement continueElement;
	@FindBy(how = How.CLASS_NAME, using= "summary_subtotal_label") private WebElement totalElement;
	@FindBy(how = How.ID, using= "finish") private WebElement finishElement;
	@FindBy(how = How.ID, using= "back-to-products") private WebElement backElement;
	
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='inventory_item_price']")
			
			) private List<WebElement> pricevalueElement;
	
	public checkoutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void YourInformation(String Firstname, String Lastname, String PIN) { 
		nameElement.sendKeys(Firstname);
		lastnameElement.sendKeys(Lastname);
		pinElement.sendKeys(PIN);
		
		
	}
	
	public void ClickContinue() {
		continueElement.click();
	}
	
	public void Overview() {
		
		Productsprices = collectPrices(pricevalueElement);
		
	      float Total = 0;
	      for (int i = 0; i < Productsprices.size(); i++) { 
	         Total += Productsprices.get(i); // add the current element to the sum
	      }

	      System.out.println("Price Total " + Total); // print the sum
	      
	      String Totalprice = totalElement.getText();
	      String ReplaceCUrrency = Totalprice.replace("Item total: $","");
	      float ItemTotal=Float.parseFloat(ReplaceCUrrency);
	      
	      if(Total==ItemTotal) {
	    	  
	    	  System.out.println("Total Price is matched: " + ItemTotal);
	      }
	      else {
	    	  System.out.println("Total Price does not match: " + ItemTotal);
	      }
	   }
	
	
	public void Finish() {
		finishElement.click();
	}
	
	public void Complete() {
		backElement.click();
	}
	
	
	
////////////////////////
	/////////////////////////////////////////////////////////////////////
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
