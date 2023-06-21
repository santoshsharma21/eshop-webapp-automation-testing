/**
 * 
 */
package com.eshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Santosh Sharma
 *
 */
public class LoginPage {

	WebDriver driver;
	
	// page objects
	@FindBy(id = "input-email")
	WebElement emailTextBox;
	
	@FindBy(id = "input-password")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;

	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public AccountPage performLogin(String email, String password) {
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
		loginBtn.click();
		return new AccountPage(driver);
	}

}
