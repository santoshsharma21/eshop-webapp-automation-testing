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
public class LogoutPage {

	WebDriver driver;

	// page objects
	@FindBy(xpath = "//a[normalize-space()='Continue']")
	WebElement continueBtn;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage clickContinue() {
		continueBtn.click();
		return new HomePage(driver);
	}
}
