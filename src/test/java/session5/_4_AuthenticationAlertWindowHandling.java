package session5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_AuthenticationAlertWindowHandling {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void authenticationWindowHandling() {
		
		String uname = "admin";
		String pass  = "admin";
		
		String URL = "https://" + uname + ":" + pass + "@" + "the-internet.herokuapp.com/digest_auth";
		
		driver.get(URL);
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText().contains("Congratulations!"));

	}
	
	@After
	public void tearDown() {
		
		driver.quit();
		
		
	}
	

}
