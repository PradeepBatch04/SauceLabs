package pages.nopcommerence;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CommonElementsPage {
	WebDriver driver;
	@FindBy(how = How.XPATH,using="//button[@id='search-products']") private WebElement searchElement;
	
	
	public CommonElementsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchClick() {
		searchElement.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}

}
