package common;

import pages.CartPage;
import pages.LoginSaucePage;
import pages.ProductsPage;
import pages.checkoutpage;

public class BasePage extends BaseClass{
 
	
	public static LoginSaucePage ObjLogin;
	public static ProductsPage objProductsPage;
	public static checkoutpage objCheckoutPage;
	public static CartPage objCartPage;
	
	public static void PageObectInitialization() {
		ObjLogin = new LoginSaucePage(driver);
		objProductsPage= new ProductsPage(driver);
		objCartPage = new CartPage(driver);
	}

	public static void destroyPageObjects() {
		ObjLogin = null;
		objProductsPage= null;
		objCartPage = null;
	}

}
