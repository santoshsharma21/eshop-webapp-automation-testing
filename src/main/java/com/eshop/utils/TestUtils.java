/**
 * 
 */
package com.eshop.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Santosh Sharma
 *
 */
public class TestUtils {
	
	public static void selectByVisibleTxt(List<WebElement> elements, String txt) {
		for(WebElement element:elements) {
			if(element.getText().equalsIgnoreCase(txt)) {
				element.click();
				break;
			}
		}
	}
	
	public static String captureScreen(WebDriver driver, String fname) {
		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String filename = fname + "_ " + dt + ".png";
		String fullpath = System.getProperty("user.dir") + "/screenshots/" + filename;
		
		TakesScreenshot scrshot = (TakesScreenshot) driver;
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		String dest = fullpath;
		
		try {
			FileUtils.copyFile(source, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dest;
	}

}
