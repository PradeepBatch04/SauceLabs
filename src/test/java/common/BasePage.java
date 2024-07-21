package common;

import org.openqa.selenium.devtools.v115.security.model.SecurityStateChanged;

import pages.CartPage;
import pages.LoginSaucePage;
import pages.ProductsPage;
import pages.checkoutpage;
import pages.nopcommerence.HomePage;
import pages.nopcommerence.LoginPage;
import pages.nopcommerence.ProductPage;

public class BasePage extends BaseClass{
 
	
	public static LoginSaucePage ObjLogin;
	public static ProductsPage objProductsPage;
	public static checkoutpage objCheckoutPage;
	public static CartPage objCartPage;
	
	/**Nop-commerence page*/
	
	public static LoginPage objNopLoginPage;
	public static HomePage objnopHomePage;
	public static ProductPage objnopProductPage;
	
	
	public static void PageObectInitialization() {
		ObjLogin = new LoginSaucePage(driver);
		objProductsPage= new ProductsPage(driver);
		objCartPage = new CartPage(driver);
		
		/**Nop-commerence page intialzation*/
		objNopLoginPage= new LoginPage(driver);
		objnopHomePage= new HomePage(driver);
		objnopProductPage= new ProductPage(driver);
		
	}

	public static void destroyPageObjects() {
		ObjLogin = null;
		objProductsPage= null;
		objCartPage = null;
		/**Nop-commerence page destory*/
		objNopLoginPage = null;
		objnopHomePage = null;
		objnopProductPage = null;
		
	}

}
