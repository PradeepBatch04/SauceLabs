package Modules;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	
	Properties prop;
	FileInputStream input;
	
	public PropertyManager(String filename) {
		 prop = new Properties();
		 String filepath=System.getProperty("user.dir")+"\\src\\test\\resources\\"+filename;
	try {
			 input = new FileInputStream(filepath);
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {

		return prop.getProperty(key);
	}


}
