package pages.orangehrm;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;

public class AdminPageHRM {
	
	WebDriver driver;
	WaitState objwait;
	@FindBy(how = How.XPATH ,using="(//input[@class='oxd-input oxd-input--active'])[2]") private WebElement UsernameElement;
	@FindBy(how = How.XPATH ,using="(//div[@class='oxd-select-text oxd-select-text--active'])[1]") private WebElement UserRoleElement;
	@FindBy(how = How.XPATH ,using="//input[@placeholder='Type for hints...']") private WebElement EmployeeElement;
	@FindBy(how = How.XPATH ,using="(//div[@class='oxd-select-text oxd-select-text--active'])[2]") private WebElement StatusElement;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") private WebElement searchElement;
	
	/*Pradeep 27/07*/
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@role=\"listbox\"]//child::div")
			) private List<WebElement> valuesElements;
	
	
	
	public AdminPageHRM(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		
	}
	
	public void fields_aredisplayed(String userrole, String status) {
		objwait.elementToBeClickable(UsernameElement);
		UsernameElement.isDisplayed();
		System.out.println("username fied is dispalyed");
		objwait.elementToBeClickable(UserRoleElement);
		UserRoleElement.isDisplayed();
		UserRoleElement.click();
		divSelectByText(userrole);
		System.out.println("UserRole fied is dispalyed");
		
		objwait.elementToBeClickable(EmployeeElement);
		EmployeeElement.isDisplayed();
		System.out.println("Employee Name fied is dispalyed");
		objwait.elementToBeClickable(StatusElement);
		StatusElement.isDisplayed();
		StatusElement.click();
		divSelectByText(status);
		System.out.println("Status fied is dispalyed");
	}
	
	public void enter_data_into_field(String Username) {
		objwait.elementToBeClickable(UsernameElement);
		UsernameElement.sendKeys(Username);
	}
	
	public void searchbtn() {
		objwait.elementToBeClickable(searchElement);
		searchElement.click();
	}
	
	private void divSelectByText(String text) {
		for(WebElement element:valuesElements) {
			String value=element.getText().trim();
			if(value.equalsIgnoreCase(text)) {
				element.click();
				break;
			}
		}
	}


}
