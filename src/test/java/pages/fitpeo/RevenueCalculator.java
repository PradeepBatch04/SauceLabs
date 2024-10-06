package pages.fitpeo;


import static org.testng.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;




public class RevenueCalculator {
	WebDriver driver;
	Actions actions;
	
	@FindBy(how = How.XPATH,using = "//p[contains(text(),'State to State')]")//ancestor::div[1]
	private WebElement sateToSate;
	
	@FindBy(how = How.XPATH,using = "//input[@type='range']")
	private WebElement revenuSlider;
	
	@FindBy(how = How.XPATH,using = "//input[@type='number']")
	private WebElement revenuText;
	@FindAll(
			@FindBy(how = How.XPATH,using = "//p[contains(text(),'CPT')]//parent::div[contains(@class,'css-4o8pys')]//child::p[1]")
			) private List<WebElement> checkboxesElements;
	
	@FindBy(how = How.XPATH,using = "//*[contains(@class,'MuiPaper-elevation4')]")
	private WebElement headerElement;
	
	
	public RevenueCalculator(WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		this.driver=driver;
	}
	
	public void revenue_calculator_slider() {
		 JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		 jsExecutor.executeScript("arguments[0].scrollIntoView();", sateToSate);
		  
	}
	public void adjustSlider_auto(int value) {	
	 try {
			int num=value/100;
			actions.moveToElement(revenuSlider).dragAndDropBy(revenuSlider, num, 0).build().perform();
			 JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
			 jsExecutor.executeScript("arguments[0].scrollIntoView();", sateToSate);
			boolean bool = false;  
			  while (bool==false) {			  
				  revenuSlider.sendKeys(Keys.ARROW_UP);	
				  Integer actualValue =Integer.parseInt(revenuSlider.getAttribute("aria-valuenow"));	
				  if(actualValue==value) {
					  bool=true;
						break; 
				  }
			  } 
	 } catch (ElementClickInterceptedException e) {
		 revenuText.sendKeys(Keys.chord(Keys.CONTROL, "a"),Keys.DELETE);
		 boolean bool = false;  
		  while (bool==false) {			  
			  revenuSlider.sendKeys(Keys.ARROW_UP);	
			  Integer actualValue =Integer.parseInt(revenuSlider.getAttribute("aria-valuenow"));	
			  if(actualValue==value) {
				  bool=true;
					break; 
			  }
		  } 	 
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
	
	public void selectCheckBoxes(String checkValue) {
	  try {
		for(WebElement checkbox:checkboxesElements) {
			 JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
			 jsExecutor.executeScript("arguments[0].scrollIntoView();", checkbox);
			String actualCheck=checkbox.getText().trim();
			if(checkValue.equalsIgnoreCase(actualCheck)) {
				Assert.assertTrue(true);
				checkbox.findElement(By.xpath("following-sibling::label//span/input")).click();
			}
		}
	  } catch (Exception e) {
			Assert.assertFalse(false, "Unable to click on checkbox.");
	  }
		
	}
//	String actualamount1=geNodeText(element);
//	System.out.println(actualamount1);
//	 JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
	public void verifyHeaderandamount(String amount) {
	  try {
		Assert.assertTrue(headerElement.isDisplayed(), "Header Displayed");
		WebElement element=headerElement.findElement(By.xpath("descendant::p[7]"));
		String value=element.getText().trim();
		String actualamount= value.replaceAll("[\r\n]+", " ");
		System.out.println(actualamount);
		Assert.assertEquals(actualamount, amount,"Amount Matched");
	  } catch (Exception e) {
		e.printStackTrace();
	  }	
	}
	
	public static String geNodeText(WebElement element) {
        String text = element.getText();
        for (WebElement child : element.findElements(By.xpath("./*"))) {
          text = text.replaceFirst(child.getText(), "");
        }

        return text;
      }


}
