/**
 * 
 */
package com.eshop.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eshop.utils.TestUtils;

/**
 * @author Santosh Sharma
 *
 */
public class HomePage {

	WebDriver driver;

	// page objects
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccountLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']/li")
	List<WebElement> accountOptions;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMyAccount() {
		myAccountLink.click();
	}

	public LoginPage selectLogin() {
		TestUtils.selectByVisibleTxt(accountOptions, "Login");
		return new LoginPage(driver);
	}

	public RegisterPage selectRegister() {
		TestUtils.selectByVisibleTxt(accountOptions, "Register");
		return new RegisterPage(driver);
	}
}
