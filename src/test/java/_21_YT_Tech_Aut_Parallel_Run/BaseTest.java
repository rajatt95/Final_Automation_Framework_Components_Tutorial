package _21_YT_Tech_Aut_Parallel_Run;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=Ov08vT8UTqY&ab_channel=TheTechieAutomationLabs
public class BaseTest {

	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	protected void beforeMethod() {
		/*
		 * WebDriverManager.chromedriver().setup(); driver.set(new ChromeDriver());
		 */

		WebDriverManager.edgedriver().setup();
		driver.set(new EdgeDriver());

		/*
		 * WebDriverManager.operadriver().setup(); driver.set(new OperaDriver());
		 */

		/*
		 * //WebDriverManager.firefoxdriver().setup();
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Softwares\\Selenium_Grid\\geckodriver.exe"); driver.set(new
		 * FirefoxDriver());
		 */ }

	protected WebDriver getDriver() {
		return (WebDriver) driver.get();
	}

	@AfterMethod
	protected void afterMethod() {
		getDriver().quit();
	}
}
