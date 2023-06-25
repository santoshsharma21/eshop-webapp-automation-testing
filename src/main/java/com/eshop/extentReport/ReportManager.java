/**
 * 
 */
package com.eshop.extentreport;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.eshop.utils.ReadConfig;

/**
 * @author Santosh Sharma
 *
 */
public class ReportManager {

	public static ExtentSparkReporter spark;
	public static ExtentReports reports;
	public static ExtentTest test;

	public static void reportSetup() {

		String dt = new SimpleDateFormat("dd.MM.yyyy_hh.mm.ss").format(new Date());
		String filename = "Test-Report_ " + dt + ".html";
		String fullpath = System.getProperty("user.dir") + "/reports/" + filename;

		spark = new ExtentSparkReporter(fullpath);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Positive and Negative Test Execution Report");
		spark.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR,
				ViewName.CATEGORY, ViewName.DEVICE }).apply();

		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Project Name", "Ecommerce");
		reports.setSystemInfo("URL", ReadConfig.pro.getProperty("url"));
		reports.setSystemInfo("OS", System.getProperty("os.name"));
		reports.setSystemInfo("Java version", System.getProperty("java.version"));
	}
}
