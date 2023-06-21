package com.eshop.tests;

import org.testng.annotations.Test;

import com.eshop.base.BaseClass;
import com.eshop.pages.AccountPage;
import com.eshop.pages.HomePage;
import com.eshop.pages.LoginPage;
import com.eshop.utils.ReadConfig;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_loginPage extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
    
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		initializeBrowser(browser);
	}

	@Test
	public void loginTest() {

		homePage = new HomePage(driver);
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLogin(ReadConfig.pro.getProperty("email"), ReadConfig.pro.getProperty("password"));
	}
	
	@Test
	void testToFail() {
		Assert.assertEquals(false, true);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}