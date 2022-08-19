package session7;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _3_ChromeOptions {

	WebDriver driver;

	@Before
	public void SetUp() {


		ChromeOptions opt = new  ChromeOptions();

		//opt.addArguments("headless");
		opt.addArguments("--incognito");
		//opt.addArguments("--disable-infobars");
		opt.setExperimentalOption("excludeSwitches", Arrays.asList(" disable-popup-blocking","enable-automation"));
		opt.setExperimentalOption ("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		//opt.addArguments("window-size=1920,1080");
		//opt.addArguments("window-size=800,600");
		//opt.addArguments("--ignore-certificate-errors");
		//opt.addArguments("--disable-extension");
		opt.addArguments("start-maximized");
		opt.addExtensions(new File("extension_3_9_4_0.crx"));

		driver =  new ChromeDriver(opt);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://google.co.in");
	}

	@Test
	public void ChromeOptions() {

		driver.get("https://www.google.co.in");
		System.out.println(driver.getTitle());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
