package session9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class _2_ValidateFontSize {

	WebDriver driver;

	String url = "https://www.facebook.com/";
	final String fontSize = "20px";

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get(url);

	}
	
	@Test
	public void validateFontSize() {
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
		
		System.out.println("The font size for \"Login\" button is -> "+ loginBtn.getCssValue("font-size"));
		
		Assert.assertEquals("The colour for \"Login\" button is not matching with expected value.", fontSize, loginBtn.getCssValue("font-size"));
		System.out.println("Test for Font Size of Element is passed.");
		
	}
	
	@After
	public void teardown() {
		
		driver.quit();
	}

}
