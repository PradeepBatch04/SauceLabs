package common;

import java.time.Duration;


import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitState {
	
	/**
	 * 1. implict wait --- it will wait till the element is present
	 * 2. Explicity wait (WebDriverWait)--- it will try to automate before and after mentioned time 
	 * 3. FluentWait-- It try to automate for every polling period until mentioned time.
	 * 
	 * 
	 * **/
	
	WebDriver driver;

	 FluentWait<WebDriver> wait1;
	
	public WaitState(WebDriver driver) {
		this.driver=driver;
		wait1= new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))	
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class)
				.ignoring(ElementClickInterceptedException.class);
	}
	
	public  void elementToBeClickable(WebElement element) {
		
		wait1.until(ExpectedConditions.elementToBeClickable(element));
	}

}
