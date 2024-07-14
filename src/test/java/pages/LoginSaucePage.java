package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginSaucePage {
	
	WebDriver driver;
	
	@FindBy(how = How.ID, using= "user-name") private WebElement usernameElement;
	@FindBy(how=How.NAME, using="password") private WebElement passwordELement;
	@FindBy(how=How.ID, using="login-button") private WebElement loginbuttonElement;
	
	
	////div[@class='inventory_item_price']
	
	public LoginSaucePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void login(String uname, String pword) {
		
		usernameElement.sendKeys(uname);
		passwordELement.sendKeys(pword);
		loginbuttonElement.click();
//		filterElement.click();
//		sortfilterElement.click();
	}
	
	
	
	public void valuessort() {
		
		List <WebElement> values = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		System.out.println(values);
	}
	
	
	
}
