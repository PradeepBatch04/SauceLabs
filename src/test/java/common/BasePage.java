package common;


import pages.CartPage;
import pages.LoginSaucePage;
import pages.ProductsPage;
import pages.checkoutpage;
import pages.fitpeo.HomePageFP;
import pages.fitpeo.RevenueCalculator;
import pages.nopcommerence.HomePage;
import pages.nopcommerence.LoginPage;
import pages.nopcommerence.ProductPage;
import pages.orangehrm.AdminPageHRM;
import pages.orangehrm.HomePageHRM;
import pages.orangehrm.LoginPageHRM;
import pages.orangehrm.LogoutPageHRM;
import pages.orangehrm.RecruitmentPage;



public class BasePage extends BaseClass{
 
	
	public static LoginSaucePage ObjLogin;
	public static ProductsPage objProductsPage;
	public static checkoutpage objCheckoutPage;
	public static CartPage objCartPage;
	
	/**Nop-commerence page*/
	
	public static LoginPage objNopLoginPage;
	public static HomePage objnopHomePage;
	public static ProductPage objnopProductPage;
	
	/**OrangeHRM page*/
	
	public static LoginPageHRM objhrmLoginPage;
	public static HomePageHRM objhrmHomePage;
	public static AdminPageHRM objhrmAdminPage;
	public static LogoutPageHRM objhrmLogoutPage;
	public static RecruitmentPage objhrmRecruitmentPage;
	
	
	/**FitPeo Page*/
	public static HomePageFP objpeoHomePage;
	public static RevenueCalculator objRevenueCalculator;
	
	
	
	public static void PageObectInitialization() {
		
		/**FitPep page intialzation**/
		objpeoHomePage=new HomePageFP(driver);
		objRevenueCalculator= new RevenueCalculator(driver);
		
		
		
		
		ObjLogin = new LoginSaucePage(driver);
		objProductsPage= new ProductsPage(driver);
		objCartPage = new CartPage(driver);
		objCheckoutPage = new checkoutpage(driver);
		
		/**Nop-commerence page intialzation*/
		objNopLoginPage= new LoginPage(driver);
		objnopHomePage= new HomePage(driver);
		objnopProductPage= new ProductPage(driver);
		
		/**OrangeHRM page intialzation*/
		objhrmLoginPage= new LoginPageHRM(driver);
		objhrmHomePage= new HomePageHRM(driver);
		objhrmAdminPage= new AdminPageHRM(driver);
		objhrmLogoutPage= new LogoutPageHRM(driver);
		objhrmRecruitmentPage= new RecruitmentPage(driver);
		
		
		
	}

	public static void destroyPageObjects() {
		ObjLogin = null;
		objProductsPage= null;
		objCartPage = null;
		objCheckoutPage =null;
		/**Nop-commerence page destory*/
		objNopLoginPage = null;
		objnopHomePage = null;
		objnopProductPage = null;
		
		/**OrangeHRM page destory*/
		objhrmLoginPage= null;
		objhrmHomePage= null;
		objhrmAdminPage= null;
		objhrmLogoutPage =null;
		objhrmRecruitmentPage = null;
		
	}

}
