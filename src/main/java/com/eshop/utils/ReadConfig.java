/**
 * 
 */
package com.eshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Santosh Sharma
 *
 */
public class ReadConfig {

	public static Properties pro;

	public ReadConfig() {
		File sourceFile = new File(System.getProperty("user.dir") + "/configurations/config.properties");
		try {
			FileInputStream f = new FileInputStream(sourceFile);
			pro = new Properties();
			pro.load(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return pro.getProperty("url");
	}
	
	public String getEmail() {
		return pro.getProperty("email");
	}
	
	public String getPassword() {
		return pro.getProperty("password");
	}

}
