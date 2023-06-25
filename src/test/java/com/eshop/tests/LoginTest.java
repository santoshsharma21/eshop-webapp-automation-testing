package com.eshop.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.eshop.base.BaseClass;
import com.eshop.dataprovider.DataProviders;
import com.eshop.pages.AccountPage;
import com.eshop.pages.HomePage;
import com.eshop.pages.LoginPage;
import com.eshop.pages.LogoutPage;

public class LoginTest extends BaseClass {

	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	LogoutPage logoutPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeMethod(String browser) {
		initializeBrowser(browser);
		homePage = new HomePage(driver);
	}

	@Test(dataProvider = "loginCredentials", dataProviderClass = DataProviders.class, description = "Positive and Negative Login Testing")
	public void testLogin(String email, String password) {
		
		homePage.clickMyAccount();
		loginPage = homePage.selectLogin();
		accountPage = loginPage.performLogin(email, password);
		log.info("Entered Email - " + email + "," + "Password - " + password);
		boolean status = accountPage.validateLogin();
		
		if(status == true) {
			Assert.assertTrue(true);
			log.info("passed");
		} else {
			log.error("failed");
			Assert.assertTrue(false);
		}
		
		logoutPage = accountPage.clickLogout();
		homePage = logoutPage.clickContinue();

	}

	@AfterClass
	public void afterMethod() {
		driver.quit();
	}
}