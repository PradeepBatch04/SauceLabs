package pages.nopcommerence;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using="//h1[normalize-space()='Dashboard']") private WebElement dashboardElement;
	
	@FindBy(how = How.XPATH, using="//a[text()='Logout']") private WebElement logoutElement;
	
	@FindAll({
		
		@FindBy(how = How.XPATH,using = "//ul[@role='menu' and contains(@class,'nav-legacy')]//child::li[starts-with(@class,'nav-item')]/a")
	
	})private List<WebElement> menuItemsElements;
	
	@FindAll({		
		@FindBy(how = How.XPATH,using = "//li[contains(@class,'menu-open')]//child::ul//child::li[contains(@class,'nav-item')]")
		
	})private List<WebElement> submenuItemsElements;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyDashboard() {
		 if(dashboardElement.isDisplayed()) {
			  System.out.println("Sucessfully  loged in homepage");
		  }else {
			  System.out.println("Failed to login");
		  }
	}	
	
	public void clickOnLogOut() throws InterruptedException {
		Thread.sleep(3000);
		logoutElement.click();
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
	
	public void subMenuItem(String subItem1, String subItem2) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		for(WebElement subItem:submenuItemsElements) {
			String classvalue=subItem.getAttribute("class").trim();
			if(classvalue.equals("nav-item")) {
				   String actualSubItem=subItem.getText().trim();	
				   if(subItem1.equalsIgnoreCase(actualSubItem)) {
					   subItem.findElement(By.xpath("child::a")).click();
					   Thread.sleep(5000);
					   System.out.println("Clicked on "+subItem1+" SubItem sucessfully.....");
					   break;
					}
		     }else if (classvalue.contains("has-treeview")) {
		    	 String actualSubItem=subItem.findElement(By.xpath("child::a")).getText().trim();	
				 if(subItem1.equalsIgnoreCase(actualSubItem)) {	 
					 subItem.findElement(By.xpath("child::a")).click();
					 System.out.println("Clicked on "+subItem1+" SubItem sucessfully.....");
					 
					 List<WebElement> subsubIteams=subItem.findElements(By.xpath("child::ul/li/a"));					
						System.out.println(subsubIteams.size());
						for(int i=0;i<subsubIteams.size();i++) {
							String actualSubSubvalue=subsubIteams.get(i).getText().trim();
							if(subItem2!=null) {
								if(subItem2.contains(actualSubSubvalue)) {
									subsubIteams.get(i).click();
									  System.out.println("Clicked on "+subItem2+" SubSubItem sucessfully.....");
									  Thread.sleep(5000);
									break;
								}
							}
					    }	
				 }	
				 break;
			  }
				   
			}
		}
	
}
