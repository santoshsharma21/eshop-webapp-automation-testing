/**
 * 
 */
package com.eshop.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.eshop.utils.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Santosh Sharma
 *
 */
public class BaseClass {

	ReadConfig cfg = new ReadConfig();
	String url = cfg.getUrl();
	String email = cfg.getEmail();
	String password = cfg.getPassword();

	public static WebDriver driver;

	public void initializeBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		}

		driver.get(url);
		driver.manage().window().maximize();
	}

}
