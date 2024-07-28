package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import common.BasePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"src/test/resources/Features/NopFeat.feature"}, 	
		glue = {"stepdefination"},
		tags = "@Login"
                
				)
public class NopRunner extends AbstractTestNGCucumberTests {

		@BeforeClass
		public void beforeClass() {
			
			BasePage.launchBrowser("chrome");
			BasePage.getURL("");
			BasePage.PageObectInitialization();
			
		}
		
		@AfterClass
		public void afterClass() {
			BasePage.destroyPageObjects();
			BasePage.quitDriver();
			
		}
		
		   
}
