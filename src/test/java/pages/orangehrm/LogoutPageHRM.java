package pages.orangehrm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;

public class LogoutPageHRM {
	
	WebDriver driver;
	WaitState objwait;
	
	@FindBy(how = How.XPATH, using = "//p[@class='oxd-userdropdown-name']") private WebElement usericonElement;
	@FindAll({
		
		@FindBy(how = How.XPATH,using = "//ul[@role='menu']/li//a[@role='menuitem']")
	
	})private List<WebElement> menuItemsElements;
	
	
	public LogoutPageHRM(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		
	}
	
	public void clickOnUserIcon() {
		usericonElement.click();
	}
	
	
	public void selectMenuItems(String item) throws InterruptedException {
		
		for(WebElement menuItem:menuItemsElements) {
		   if(menuItem.isDisplayed()) {
			   String actualItem=menuItem.getText().trim();
				if(item.equalsIgnoreCase(actualItem)) {
					menuItem.click();
					Thread.sleep(8000);
					System.out.println("Clicked on "+item+" sucessfully.....");
					break;
				}
		   }
			
		}
	}
	

}
