package _03_SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class _01_Remote_Test_Execution {
	private static final String Application_URL = "https://www.google.com/";
	private static final String HUB_URL = "http://192.168.29.11:4444/wd/hub";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities caps = setCapabilityForNode();
		// LOCAL
		// WebDriver driver = new ChromeDriver();

		// REMOTE
		RemoteWebDriver driver = new RemoteWebDriver(new URL(HUB_URL), caps);
		getBrowserInfo(driver);
		System.out.println("Navigating to: " + Application_URL);
		driver.get(Application_URL);

		System.out.println("driver.getCurrentUrl(): " + driver.getCurrentUrl());
		System.out.println("driver.getTitle(): " + driver.getTitle());

		do_Zoom(driver);
		System.out.println("Success");
		driver.quit();

	}

	private static void do_Zoom(RemoteWebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		System.out.println("Set Zoom level - 80%");
		js.executeScript("document.body.style.transform='scale(0.8)';");
		Thread.sleep(2000);

		System.out.println("Set Zoom level - 50%");
		js.executeScript("document.body.style.transform='scale(0.5)';");
		Thread.sleep(2000);

		System.out.println("Set Zoom level - 120%");
		js.executeScript("document.body.style.transform='scale(1.2)';");

		Thread.sleep(2000);
	}

	private static DesiredCapabilities setCapabilityForNode() {
		System.out.println("Setting capability for execution over Node");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName(BrowserType.CHROME);
		// caps.setBrowserName(BrowserType.EDGE);
		// caps.setBrowserName(BrowserType.FIREFOX);
		caps.setPlatform(Platform.WINDOWS);
		return caps;
	}

	protected static void getBrowserInfo(WebDriver driver) throws InterruptedException {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String os = cap.getPlatform().toString();
		String version = cap.getVersion().toString();

		System.out.println("===============================");
		System.out.println("Operating System: " + os);
		System.out.println("Browser: " + browserName.toUpperCase() + " - " + version);
		System.out.println("===============================");
		Thread.sleep(2000);
	}
}
