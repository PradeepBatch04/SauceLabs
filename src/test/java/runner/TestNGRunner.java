package runner;

import org.testng.annotations.AfterClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(
				features = {"src\\test\\resources\\Features\\Saucedemo.feature"}, 
				glue = {"stepdefination"}
                
				)
    
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
	
	   
	   
}