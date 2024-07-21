package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.BaseClass;
import common.BasePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(
				features = {"src\\test\\resources\\Features\\Nopcommerce.feature"}, 	
				glue = {"stepdefination"}
				
                
				)
    
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	@BeforeClass
	public void beforeClass() {
		
		BasePage.launchBrowser("chrome");
		BasePage.getURL("https://admin-demo.nopcommerce.com/login");
		BasePage.PageObectInitialization();
		
	}
	
	@AfterClass
	public void afterClass() {
		BasePage.destroyPageObjects();
		BasePage.quitDriver();
		
	}
	
	
	   
	   
}