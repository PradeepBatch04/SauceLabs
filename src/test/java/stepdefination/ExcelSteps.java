package stepdefination;



import Modules.Common;
import Modules.ExcelRead;
import io.cucumber.java.en.Given;

public class ExcelSteps {

	
	static String value;
	@Given("read the test data {string} {string} {string}")
	public void read_the_test_data(String testcaseid, String filename, String sheetname) {
	   
		Common.data = ExcelRead.dataRead(testcaseid, filename, sheetname);
		

	}
}
