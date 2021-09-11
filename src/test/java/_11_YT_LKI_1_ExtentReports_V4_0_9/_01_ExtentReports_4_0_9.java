package _11_YT_LKI_1_ExtentReports_V4_0_9;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

/*https://www.youtube.com/watch?v=Iden9bb6H8g&list=PLE9KxZsdDp31NbB6OB3LByNwyTjS0qAeQ&index=2&ab_channel=Let%27sKodeIt
*/
public class _01_ExtentReports_4_0_9 {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		htmlReporter = new ExtentHtmlReporter(".//extent_Reports//extent_4_0_9.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Nagarro");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com/");
	}

	@Test
	public void Test_PASS() {

		// Name of the Test case
		extentTest = extent.createTest("Successful Test");

		// Printed as a Test step
		// extentTest.log(Status.PASS, "Test Method PASSED");
	}

	@Test
	public void Test_FAIL() {
		extentTest = extent.createTest("Failed Test");
		// extentTest.log(Status.FAIL, "Test Method FAILED");
		Assert.fail("Intentionally Failing");
	}

	@Test
	public void Test_SKIP() {
		extentTest = extent.createTest("Skipped Test");
		// extentTest.log(Status.SKIP, "Test Method SKIPPED");
		throw new SkipException("Intentionally Skipped");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			extentTest.fail("<details><summary><b><font color=red> Exception occured, click to see details: </font></b>"
					+ "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
			String path = takeScreenshot(result.getMethod().getMethodName());
			try {
				extentTest.fail("<b><font color=red>" + "Screenshot of Failure" + "</font></b>",
						MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				extentTest.fail("Test failed, can not attach Screenshot");
			}
			String logText = "<b>Test Method " + methodname + " is Failed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			extentTest.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			String logText = "<b>Test Method " + methodname + " is Passed</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			extentTest.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String logText = "<b>Test Method " + methodname + "is Skipped</b>";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			extentTest.log(Status.SKIP, m);
		}

	}

	public String takeScreenshot(String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;

		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("******************************************");
			System.out.println("Screenshot stored at: " + path);
			System.out.println("******************************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();
	}
}
