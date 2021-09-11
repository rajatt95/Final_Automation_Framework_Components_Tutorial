package _11_YT_LKI_2_ExtentReports_V4_0_9;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {

		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/extent_reports/";

		new File(directory).mkdirs();
		String path = directory + fileName;

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		// htmlReporter = new
		// ExtentHtmlReporter(".//extent_Reports//extent_4_0_9.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "Nagarro");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);

		return extent;

	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "Automation_Report" + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}

}
