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
public class AccountPage {

	WebDriver driver;

	// page objects
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logoutLinkTxt;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateLogin() {
		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
		boolean status = false;
		if (expectedUrl.equals(driver.getCurrentUrl())) {
			status = true;
		}
		return status;
	}

	public LogoutPage clickLogout() {
		logoutLinkTxt.click();
		return new LogoutPage(driver);
	}
}