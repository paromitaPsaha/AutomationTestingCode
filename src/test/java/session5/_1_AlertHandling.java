package session5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class _1_AlertHandling {
	
	WebDriver driver;

	@Before
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
	}
	
	@Test
	public void AlertHandling() throws InterruptedException {
		
		WebElement alertBox = driver.findElement(By.xpath("//button[contains(text(),'    click the button to display an  alert box:')]"));
		alertBox.click();
		
		Alert Alt = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		System.out.println("Alert text: "+Alt.getText());
		
		Assert.assertEquals("Alert text is not matching","I am an alert box!", Alt.getText());
		
		Thread.sleep(3000);
		
		Alt.accept();
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
	
}
