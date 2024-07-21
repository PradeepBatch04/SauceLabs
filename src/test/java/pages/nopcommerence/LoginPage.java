package pages.nopcommerence;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	 WebDriver driver;
	 
	@FindBy(how = How.XPATH, using="//input[@name='Email']") private WebElement userElement;
	@FindBy(how = How.XPATH, using="//input[@name='Password']") private WebElement passElement;
	@FindBy(how = How.XPATH, using="//button[text()='Log in']") private WebElement loginElement;

	
	//constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void loginNonComperence(String username, String password) {
		try {
			userElement.clear();
			userElement.sendKeys(username);
			passElement.clear();
			passElement.sendKeys(password);
			Thread.sleep(5000);
			loginElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
