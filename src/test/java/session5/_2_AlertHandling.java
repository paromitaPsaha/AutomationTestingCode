package session5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_AlertHandling {

	WebDriver driver;
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void alertHandling() throws InterruptedException {
		
		WebElement SelectText = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
		SelectText.click();
		
		Thread.sleep(3000);
		
		WebElement clkbtn = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		clkbtn.click();
		
		Alert alt = driver.switchTo().alert();
		
		Thread.sleep(3000);
		
		System.out.println("Alert text: "+alt.getText());
		
		//alt.accept();
		alt.dismiss();
		
		WebElement cancleText = driver.findElement(By.id("demo"));
		Assert.assertEquals("You Pressed Cancel", cancleText.getText());
		
	}
	
	@After
	public void tearDown() throws InterruptedException {
		
		driver.quit();
		Thread.sleep(3000);
	}
	
}
