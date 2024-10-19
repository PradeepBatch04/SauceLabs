package common;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumGrid {

	public static void main(String[] args) throws MalformedURLException {
		/*This URL will be an IP address for HUb machine+Hub Port+wd/hub
		http://192.168.1.35:4444/wd/hub or http://localhost/wd/hub*/
		String hubURl = "http://192.168.1.35:4444/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN11);
		cap.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL(hubURl),cap);
		
		driver.get("https://www.netflix.com/in");
		System.out.println(driver.getTitle());
		driver.close();
	}

}
