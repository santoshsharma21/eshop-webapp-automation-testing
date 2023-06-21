/**
 * 
 */
package com.eshop.extentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.eshop.base.BaseClass;
import com.eshop.utils.TestUtils;

/**
 * @author Santosh Sharma
 *
 */
public class ListenerClass extends ReportManager implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		reportSetup();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getName());
		test.assignAuthor("SANTOSH");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - PASSED", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - FAILED", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable().getMessage() + " - FAILED", ExtentColor.RED));
		String screenShot = TestUtils.captureScreen(BaseClass.driver, result.getName());
		test.info(MarkupHelper.createLabel("Screenshot Attached", ExtentColor.GREY));
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - SKIPED", ExtentColor.YELLOW));
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
