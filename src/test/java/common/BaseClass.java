package common;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	
	public static void getURL(String url) {
	
		driver.get(url);
		
	}
	public static void launchBrowser(String brower) {
		
		switch (brower.toUpperCase()) {
		case "CHROME":
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "SAFARI":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
		default:
			System.out.println("Mention browser name properly like CHROME, EDGE,FIREFOX,SAFARI");
			System.exit(0);
			break;
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		
	}
	
	
	
	public static void quitDriver() {
		driver.quit();
	}

	
	

}
