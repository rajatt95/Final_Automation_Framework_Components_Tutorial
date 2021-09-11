package _21_YT_Tech_Aut_Parallel_Run;

import org.testng.annotations.Test;

//https://www.youtube.com/watch?v=Ov08vT8UTqY&ab_channel=TheTechieAutomationLabs
public class ParallelExecution_ThreadLocal extends BaseTest {

	@Test
	public void TC_01() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_01 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_01 completed**********************");
	}

	@Test
	public void TC_02() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_02 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_02 completed**********************");
	}

	@Test
	public void TC_03() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_03 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_03 completed**********************");
	}

	@Test
	public void TC_04() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_04 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_04 completed**********************");
	}

	@Test
	public void TC_05() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_05 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_05 completed**********************");
	}

	@Test
	public void TC_06() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_06 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_06 completed**********************");
	}

	@Test
	public void TC_07() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_07 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_07 completed**********************");
	}

	@Test
	public void TC_08() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_08 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_08 completed**********************");
	}

	@Test
	public void TC_09() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_09 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_09 completed**********************");
	}

	@Test
	public void TC_10() {
		getDriver().get("https://www.google.com/");
		System.out.println("TC_10 Thread ID is: " + Thread.currentThread().getId());
		System.out.println("Title: " + getDriver().getTitle());
		System.out.println("Current URL: " + getDriver().getCurrentUrl());
		System.out.println("TC_10 completed**********************");
	}

}
