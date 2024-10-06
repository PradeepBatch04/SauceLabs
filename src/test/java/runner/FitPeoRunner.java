package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import common.BasePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features/FitPeo.feature"}, 	
		glue = {"stepdefination"}
                
		)
    
public class FitPeoRunner extends AbstractTestNGCucumberTests {
	@Parameters({"browser","URL"})
	@BeforeClass
	public void beforeClass(String browser,String url) {
		
		BasePage.launchBrowser(browser);
		BasePage.getURL(url);
		BasePage.PageObectInitialization();
		
	}
	
	@AfterClass
	public void afterClass() {
		BasePage.destroyPageObjects();
		BasePage.quitDriver();
		
	}
	
}
