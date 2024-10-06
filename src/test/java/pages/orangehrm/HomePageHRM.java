package pages.orangehrm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;

public class HomePageHRM {
	
	WebDriver driver;
	WaitState objwait;
	
	@FindBy(how =How.XPATH,using="//h6[text()='Dashboard']") private WebElement dashboardElement;
	@FindAll({
		
		@FindBy(how = How.XPATH,using = "//li[contains(@class,'oxd-main-')]//child::a[contains(@class,'oxd-main-')]/span")
	
	})private List<WebElement> menuItemsElements;
	
	
	public HomePageHRM(WebDriver driver) {
			
			PageFactory.initElements(driver,this);	
			objwait = new WaitState(driver);
			
		}
	
	public void dashboard_isdisplayed() {
		objwait.elementToBeClickable(dashboardElement);
		dashboardElement.isDisplayed();
		System.out.println("dashboard is dispalyed");
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
