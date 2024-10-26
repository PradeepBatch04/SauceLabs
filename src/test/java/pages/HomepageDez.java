package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;

public class HomepageDez {

	WebDriver driver;
	Actions actions;
	WaitState objwait;
	
	//@FindBy(how = How.XPATH, using="//button[@type='button']//descendant::span[text()='Main Menu']") private WebElement MenuElement;
	
	@FindBy(how = How.XPATH, using="//div[@class='main-navigation']//li[@id='menu-item-9634']") private WebElement TestpageElement;
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//li[@id='menu-item-9634']//ul[@class='sub-menu']//li//a")
			
			) private List<WebElement> menuItemsElements;
	
	
	
	public HomepageDez (WebDriver driver) {
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}
	
	public void selectmenu() {
		actions.moveToElement(TestpageElement).build().perform();
		objwait.elementToBeClickable(TestpageElement);
		//TestpageElement.click();
		System.out.println("successfully clicked");
	}
	
	
	public void selectMenuItem(String item) throws InterruptedException {
		
		for(WebElement menuItem:menuItemsElements) {
		   if(menuItem.isDisplayed()) {
			   String actualItem=menuItem.getText().trim();
				if(item.equalsIgnoreCase(actualItem)) {
					menuItem.click();
					Thread.sleep(5000);
					System.out.println("Clicked on "+item+" sucessfully.....");
					break;
				}
		   }
			
		}
	}
	
	
}
