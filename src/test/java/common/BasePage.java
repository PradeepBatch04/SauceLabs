package common;



import pages.HomepageDez;




public class BasePage extends BaseClass{
 
	
	public static HomepageDez ObjHome;
	
	
	
	public static void PageObectInitialization() {
		
		ObjHome = new HomepageDez(driver);
		
	
		
	}

	public static void destroyPageObjects() {
		ObjHome = null;
		
	
	}

}
