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

public class _3_AlertHandlingSendKeys {

	WebDriver driver;
	
	@Before
	public void setup() {
		
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void AlertHandlingSendKeys() throws InterruptedException {
		
		WebElement select = driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
		select.click();
		
		//WebElement button = driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box ')]"));
		//button.click();
		
		WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]"));
		alertButton.click();

		
		
		Alert alert = driver.switchTo().alert();
		
		
		
		alert.sendKeys("abtil");
		
		Thread.sleep(3000);
		
		alert.accept();
		
		Thread.sleep(3000);
		
		WebElement cfrnTxt = driver.findElement(By.xpath("//p[@id='demo']"));
	//	Assert.assertEquals(true, cfrnTxt.getText().contains("abtil"));
		
	}
	
	@After
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
}
