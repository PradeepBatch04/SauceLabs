package pages.nopcommerence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver driver;
	Actions actions;
	@FindBy(how = How.NAME,using="SearchProductName") private WebElement productnamElement;
	@FindBy(how = How.ID,using="SearchCategoryId") private WebElement categoryElement;
	@FindBy(how = How.ID,using="SearchPublishedId") private WebElement publishedElement;
	@FindBy(how = How.NAME,using="GoDirectlyToSku") private WebElement skuElement;
	@FindBy(how = How.XPATH,using="//table[@id='products-grid']//child::tbody") private WebElement tbody;
	@FindBy(how = How.XPATH,using="//li[@id='products-grid_next']") private WebElement nextElement;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		actions=new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	/**Reusable method*/
	public void selectByVisibleText(WebElement element, String Text) {
		 Select select=new Select(element);
		 select.selectByVisibleText(Text);
	}
	public void selectByValue(WebElement element, String Value) {
		 Select select=new Select(element);
		 select.selectByValue(Value);
	}
	/**Reusable method*/
	public void fillFilterdeatis(String Productname, String Category, String Published, String SKU) {
	 try {
		 productnamElement.sendKeys(Productname);	
		 selectByVisibleText(categoryElement,Category);
		 selectByVisibleText(publishedElement,Published);
		 skuElement.sendKeys(SKU);
		 
		} catch (Exception e) {
			
		}
	}
	
	public void verifyProductRecord(String Productname, String SKU, String Price, String Stockquantity, String Published, String action) {
		
		if(Productname ==null)Productname="";
		if(SKU ==null)SKU="";
		if(Price ==null)Price="";
		if(Stockquantity ==null)Stockquantity="";
		if(Published !=null) {
			if(Published.equalsIgnoreCase("Published only"))Published="true";
			if(Published.equalsIgnoreCase("Unpublished only"))Published="false";
		}else if (Published==null) {
			Published="";
	     }
		ArrayList<String> array=new ArrayList<String>();
		Collections.addAll(array, "","",Productname,SKU,Price,Stockquantity,Published,"Edit");
		System.out.println(array.size());
		
		verifyTable(tbody, array, action);

	}
	private void verifyTable(WebElement tbody,ArrayList<String>array,String action) {
		try {
			boolean bool = true;		
			while(bool==true) {
				Thread.sleep(3000);
				List<WebElement> rows=tbody.findElements(By.xpath("child::tr"));		
			    for(WebElement row:rows) {
					int count=0;
					List<WebElement> columnsElements=row.findElements(By.xpath("child::td"));
					System.out.println(columnsElements.size());
					for(int i=0;i<array.size();i++) {	
						String actual=null;
						actual=columnsElements.get(i).getText();
						if(array.get(i).equals("true")||array.get(i).equals("false")){
							actual=columnsElements.get(i).findElement(By.xpath("child::i")).getAttribute("nop-value");
						}
						String expected=array.get(i);
						if(actual.contains(expected)) {
							count++;
						}
						
						if(count==array.size()&&action.equalsIgnoreCase("Filter")) {
							actions.scrollToElement(row).build().perform();
							bool=false;
							break;
						}
						if(count==array.size()&&action.equalsIgnoreCase("CheckBox")) {
							
							actions.scrollToElement(row).build().perform();
							WebElement element=row.findElement(By.xpath("child::td[1]/input"));
							Thread.sleep(2000);
							element.click();
							bool=false;
							break;
						}
						if(count==array.size()&&action.equalsIgnoreCase("Edit")) {
							Thread.sleep(2000);					
							actions.scrollToElement(row).build().perform();
							Thread.sleep(2000);
							row.findElement(By.xpath("child::td[8]/a")).click();
							bool=false;
							break;
						}
						
					}
					
					if(bool==false) break;
				}	    
			    if(bool==true) {
			    	String value=nextElement.getAttribute("class");
			    	if(!value.contains("disabled")) {
			    		nextElement.findElement(By.xpath("child::a")).click();;
			    	}
			    			
				}else {
					bool=false;
				}
			}	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
