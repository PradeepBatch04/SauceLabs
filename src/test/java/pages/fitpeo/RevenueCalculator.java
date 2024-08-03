package pages.fitpeo;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class RevenueCalculator {
	WebDriver driver;
	Actions actions;
	
	@FindBy(how = How.XPATH,using = "//h5[contains(text(),'Revenue Per Year')]")//ancestor::div[1]
	private WebElement revenuElement;
	
	@FindBy(how = How.XPATH,using = "//input[@type='range']")
	private WebElement revenuSlider;
	
	@FindBy(how = How.XPATH,using = "//input[@type='number']")
	private WebElement revenuText;
	
	
	public RevenueCalculator(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		this.driver=driver;
	}
	
	public void revenue_calculator_slider() {
		 JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		 jsExecutor.executeScript("arguments[0].scrollIntoView();", revenuElement);
		  
	}
	
	public void adjustSlider(int value) {
	 try {
		
		  boolean bool = false;  
		  while (bool==false) {			  
			  revenuSlider.sendKeys(Keys.ARROW_UP);	
			  Integer actualValue =Integer.parseInt(revenuSlider.getAttribute("aria-valuenow"));
				
			  if(actualValue==value) {
				  bool=true;
					break; 
			  }
		  }  
		  
	 } catch (Exception e) {
		e.printStackTrace();
	 }	
	
	}
	
	public void bottom_text_field(int value) {
		int acutal = Integer.parseInt(revenuText.getAttribute("value").trim());
		Assert.assertEquals(acutal, value);
	}
	
	public void enter_value_text_field(int value) {
		revenuText.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.DELETE);
		revenuText.sendKeys(String.valueOf(value));
	}

	
	public void verifysliderpositionupdated(int value) {
		int actualValue =Integer.parseInt(revenuSlider.getAttribute("aria-valuenow"));
		Assert.assertEquals(actualValue, value);
	}


}
