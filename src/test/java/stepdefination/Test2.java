package stepdefination;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
 
	@Test(description = "Method1", priority  = 2)
	public void apple() {
		System.out.println("this is AppLe");
	}
	@Test(description = "Method2",priority = 1)
	public void Orange() {
		System.out.println("this is Orange");
		
	}
	
	@Test(dependsOnMethods = "Orange")
	public void Ball() {
		System.out.println("this is ball");
	}
}
