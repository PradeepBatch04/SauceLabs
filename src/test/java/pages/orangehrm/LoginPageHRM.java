package pages.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import common.WaitState;



public class LoginPageHRM {
	
	WebDriver driver;
	WaitState objwait;
	
	//@FindBy(how = How.CLASS_NAME ,using="") private WebElement Element;
	
	@FindBy(how = How.NAME ,using="username") private WebElement userElement;
	@FindBy(how = How.NAME, using = "password") private WebElement passElement;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']") private WebElement submitElement;
	
	
	public LoginPageHRM(WebDriver driver) {
		
		PageFactory.initElements(driver,this);	
		objwait = new WaitState(driver);
		
	}
	
	public void login_Page(String username,String password) {
		
		objwait.elementToBeClickable(userElement);
		userElement.sendKeys(username);
		objwait.elementToBeClickable(passElement);
		passElement.sendKeys(password);
		submitElement.click();
		
	}

}
