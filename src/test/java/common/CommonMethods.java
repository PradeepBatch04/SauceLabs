package common;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonMethods {
	
	
	WebDriver driver;
	
	public CommonMethods(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public void switchWindow() {
		// It will return the parent window name as a String
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();
		
		if(s.size()>=1) {
			// Now iterate using Iterator
			Iterator<String> I1= s.iterator();
			while(I1.hasNext()){
			String child_window=I1.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println("Window switched sucessfully....!");
			}
		}
		
	  }
	}
	
	public String getTitle( ) {
		String obj = driver.getTitle();
		return obj;
		
		
		
	}

}
