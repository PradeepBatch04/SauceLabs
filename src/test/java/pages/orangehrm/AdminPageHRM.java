package pages.orangehrm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
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
	
	/**Pradeep- Xpath for div_rows***/
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='oxd-table-body']//descendant::div[@role='row']")
			) private List<WebElement> rowsElements;
	
	@FindAll(
			@FindBy(how = How.XPATH,using = "//div[@class='oxd-table-body']//div[@role='row']")
			) private List<WebElement> tablerowsElements;
	
	/**vineesha**/
	@FindBy(how = How.XPATH, using = "//button[text()=' Add ']") private WebElement addbuttonElement;
	@FindBy(how = How.XPATH, using = "(//input[@type='password'])[1]") private WebElement PasswordElement;
	@FindBy(how = How.XPATH, using = "(//input[@type='password'])[2]") private WebElement ConfirmPasswordElement;
	
	
	
	public AdminPageHRM(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		this.driver=driver;
		
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
	
	public void verifyRecord(String Username, String User_Role, String Employee_Name, String Status,String action) throws InterruptedException {
		ArrayList<String> cellsValues= new ArrayList<String>(); //add the filter values according to row.
	    Collections.addAll(cellsValues, "",Username,User_Role,Employee_Name,Status,""); // added values according to row
		divtable_VerifyRecord(rowsElements, cellsValues,action);	
	}
	
	public void addButton() {
		addbuttonElement.click();
	}
	
	
	public void add_user(String UserRole, String EmployeeName, String Status, String Username, String Password, String ConfirmPassword) throws InterruptedException {
		//username
				objwait.elementToBeClickable(UsernameElement);
				UsernameElement.isDisplayed();
				System.out.println("username fied is dispalyed");
				UsernameElement.sendKeys(Username);
				
				//userrole
				objwait.elementToBeClickable(UserRoleElement);
				UserRoleElement.isDisplayed();
				UserRoleElement.click();
				divSelectByText(UserRole);
				System.out.println("UserRole fied is dispalyed");
				
				
				//employeename
				objwait.elementToBeClickable(EmployeeElement);
				EmployeeElement.isDisplayed();
				System.out.println("Employee Name fied is dispalyed");
				EmployeeElement.sendKeys(EmployeeName);
				Thread.sleep(2000);
				EmployeeElement.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
				
				//status
				objwait.elementToBeClickable(StatusElement);
				StatusElement.isDisplayed();
				System.out.println("Status fied is dispalyed");
				StatusElement.click();
				Thread.sleep(5000);
				divSelectByText(Status);
				
				//password
				objwait.elementToBeClickable(PasswordElement);
				UsernameElement.isDisplayed();
				System.out.println("password fied is dispalyed");
				UsernameElement.sendKeys(Password);
				
				//confirmpassword
				objwait.elementToBeClickable(ConfirmPasswordElement);
				UsernameElement.isDisplayed();
				System.out.println("ConfirmPassword fied is dispalyed");
				UsernameElement.sendKeys(ConfirmPassword);
				
				
	}
	
	/****************DIV Dropdown*******************/
	private void divSelectByText(String text) {
		for(WebElement element:valuesElements) {
			String value=element.getText().trim();
			if(value.equalsIgnoreCase(text)) {
				element.click();
				break;
			}
		}
	}
	
	/****************DIV TABLE*******************
	 * 1. Collection of rows
	 * 2. collection of values
	 * */
    private void divtable_VerifyRecord(List<WebElement> rows,ArrayList<String> cellsValues,String action) {
     try {
    	  int count = 0;
    	   JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;
		  for(WebElement row:rows) {
			  count=0;
			  jsExecutor.executeScript("arguments[0].scrollIntoView();", row);
			  List<WebElement> cellsElements = row.findElements(By.xpath("child::div[@role='cell']"));
			  for(int i=0;i<cellsElements.size();i++) {
				  String actual=cellsElements.get(i).getText();
				  String expected=cellsValues.get(i);
				  if(actual.contains(expected)) {
					 count++; 
				  }
				  if(count==cellsValues.size()&&action.equalsIgnoreCase("filter")) {
					  System.out.println("Record Matched");
					  Assert.assertTrue(true);
					  break;
				  }
				  if(count==cellsValues.size()&&action.equalsIgnoreCase("checkbox")) {
//					  cellsElements.get(0).findElement(By.xpath("descendant::input")).click();
					  WebElement element=cellsElements.get(0).findElement(By.xpath("descendant::input"));
					  JavascriptExecutor executor = (JavascriptExecutor)driver;
					  executor.executeScript("arguments[0].click();", element);
					  System.out.println("Click on CheckBox");
					  Assert.assertTrue(true);
					  break;
				  }
				  if(count==cellsValues.size()&&action.equalsIgnoreCase("delete")) {
					  cellsElements.get(5).findElement(By.xpath("descendant::button[1]")).click();
					  System.out.println("Click on DeleteIcon");
					  Assert.assertTrue(true);
					  break;
					  
				  }
				  if(count==cellsValues.size()&&action.equalsIgnoreCase("EditIcon")) {
					  cellsElements.get(5).findElement(By.xpath("descendant::button[2]")).click();
					  System.out.println("Click on EditIcon");
					  Thread.sleep(5000);
					  Assert.assertTrue(true);
					  break;
			
				  }
				  
			  }
		  }	
		  if(count<6) {
			  Assert.fail("Record not Matched");
		  }
		} catch (Exception e) {
			e.printStackTrace();
	  }
    }
}
	


