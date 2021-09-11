package _02_Log4J;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _01_Log4J {

	private static final String LOG4J_PROPERTIES = ".//src//test//resources//log4j_config//log4j.properties";

	public static void main(String[] args) {

		// We need to create a Logger instance, so we need to pass Class name
		// for which, we want to create Log file
		Logger logger = Logger.getLogger(_01_Log4J.class);
		// Logger logger = Logger.getLogger("_01_Log4J");

		// Configure log4j.properties file
		PropertyConfigurator.configure(LOG4J_PROPERTIES);

		// Open Chrome Browser Instance
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		logger.info("Chrome Browser opened");

		// Maximize the Window
		driver.manage().window().maximize();
		logger.info("Browser Window maximized");

		// Set Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Impicit Wait given");

		// Open URL
		driver.get("https://en-gb.facebook.com/");
		logger.info("Application launched");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Quit Driver
		driver.quit();
		logger.info("Application closed");

	}
}