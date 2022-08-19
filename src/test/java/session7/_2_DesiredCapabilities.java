package session7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class _2_DesiredCapabilities {

	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		DesiredCapabilities dCap = new DesiredCapabilities();
		dCap.setAcceptInsecureCerts(true);
		
		driver = new ChromeDriver(dCap);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://cacert.com");
	}
	
	@Test
	public void DesiredCapabilities() {     
		
		System.out.println(driver.getTitle());
	}
	
	@After
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
}
