package pages.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;

public class RecruitmentPage {

	WebDriver driver;
	WaitState objwait;
	
	@FindBy(how = How.XPATH, using = "//button[@type='button']") private WebElement addbuttonElement;
	@FindBy(how = How.CLASS_NAME, using = "firstName") private WebElement firstnameElement;
	@FindBy(how = How.CLASS_NAME, using = "lastName") private WebElement lastnameElement;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Type here']") private WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") private WebElement savebuttonElement;
	@FindBy(how = How.XPATH, using = "//h6[text()='Recruitment']") private WebElement pageheadingElement;
	
	
	
	
	public RecruitmentPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		
	}
	
	public void addButton() {
		addbuttonElement.click();
	}
	
	public void pageTitle() {
		pageheadingElement.click();
	}
	
}
