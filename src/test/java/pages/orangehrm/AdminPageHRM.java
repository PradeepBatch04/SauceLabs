package pages.orangehrm;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
			@FindBy(how = How.XPATH,using = "//div[@role='listbox']//child::div")
			) private List<WebElement> valuesElements;
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='oxd-table-body']//div[@class='oxd-table-card']//following-sibling::div[@role='cell']")
			) private List<WebElement> tablevaluesElements;
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='oxd-table-body']//div[@role='row']")
			) private List<WebElement> tablerowsElements;
	
	
	
	public AdminPageHRM(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		
	}
	
	public void fields_aredisplayed(String Username, String User_Role, String Employee_Name, String Status) throws InterruptedException {
		//username
		objwait.elementToBeClickable(UsernameElement);
		UsernameElement.isDisplayed();
		System.out.println("username fied is dispalyed");
		UsernameElement.sendKeys(Username);
		
		//userrole
		objwait.elementToBeClickable(UserRoleElement);
		UserRoleElement.isDisplayed();
		UserRoleElement.click();
		divSelectByText(User_Role);
		System.out.println("UserRole fied is dispalyed");
		
		
		//employeename
		objwait.elementToBeClickable(EmployeeElement);
		EmployeeElement.isDisplayed();
		System.out.println("Employee Name fied is dispalyed");
		EmployeeElement.sendKeys(Employee_Name);
		Thread.sleep(2000);
		EmployeeElement.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
		//status
		objwait.elementToBeClickable(StatusElement);
		StatusElement.isDisplayed();
		System.out.println("Status fied is dispalyed");
		StatusElement.click();
		Thread.sleep(5000);
		divSelectByText(Status);
		
	}
	
//	public void enter_data_into_field(String Username) {
//		objwait.elementToBeClickable(UsernameElement);
//		UsernameElement.sendKeys(Username);
//	}
	
	public void searchbtn() {
		objwait.elementToBeClickable(searchElement);
		searchElement.click();
	}
	
	public void rowsinTable(String Username, String User_Role, String Employee_Name, String Status) throws InterruptedException {
		System.out.println("No.of rows in table "+tablerowsElements.size());
		int row = tablevaluesElements.size();
		System.out.println("No of rows in this table : " + row);
		Thread.sleep(5000);
		tablerowusernamevalue(Username);
		
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
	
	private void tablerowusernamevalue(String text) {
		for(WebElement element:tablevaluesElements) {
			String value=element.getText().trim();
			Assert.assertEquals(text, value);
			}
		}
	}


