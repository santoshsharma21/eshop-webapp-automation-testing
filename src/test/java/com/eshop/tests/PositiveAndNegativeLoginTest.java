package com.eshop.tests;

import org.testng.annotations.Test;

import com.eshop.base.BaseClass;
import com.eshop.dataprovider.DataProviders;
import com.eshop.pages.AccountPage;
import com.eshop.pages.HomePage;
import com.eshop.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class PositiveAndNegativeLoginTest extends BaseClass {
	
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {
		initializeBrowser(browser);
		homePage = new HomePage(driver);
	}
	
	@Test(priority = 0, dataProvider = "data_true_true", dataProviderClass = DataProviders.class)
	public void loginWithTrueEmailAndTruePassword(String email, String password) {
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
	}

	@Test(priority = 1, dataProvider = "data_true_false", dataProviderClass = DataProviders.class)
	public void loginWithTrueEmailAndFalsePassword(String email, String password) {
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
	}

	@Test(priority = 2, dataProvider = "data_false_true", dataProviderClass = DataProviders.class)
	public void loginWithFalseEmailAndTruePassword(String email, String password) {
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
	}

	@Test(priority = 3, dataProvider = "data_false_false", dataProviderClass = DataProviders.class)
	public void loginWithFalseEmailAndFalsePassword(String email, String password) {
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
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
