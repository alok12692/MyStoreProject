package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	//not appearing in the application
	public void wishListTest() throws Throwable {
		Log.startTestCase("wishListTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryandDetailsTest() throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
	
}
