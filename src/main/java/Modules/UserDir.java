package Modules;

public class UserDir {

	public static void main(String[] args) {
		PropertyManager prop = new PropertyManager("execution.properties");
		System.out.println(System.getProperty("user.dir")+prop.getProperty("dataPath")+"\\"+"OrangeHRM.xlsx");

	}

}
