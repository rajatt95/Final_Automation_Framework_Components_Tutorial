package _11_YT_LKI_2_ExtentReports_V4_0_9_Rajat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*https://www.youtube.com/watch?v=Iden9bb6H8g&list=PLE9KxZsdDp31NbB6OB3LByNwyTjS0qAeQ&index=2&ab_channel=Let%27sKodeIt
*/
public class TestClassUsingListeners {

	public WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://google.com/");
	}

	@Test
	public void Test_PASS() {
		System.out.println("Executing the Successful test method");
	}

	@Test
	public void Test_FAIL() {
		System.out.println("Executing the Failed test method");
		Assert.fail("Intentionally Failing");
	}

	@Test
	public void Test_SKIP() {
		System.out.println("Executing the Skipped test method");
		throw new SkipException("Intentionally Skipped");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
