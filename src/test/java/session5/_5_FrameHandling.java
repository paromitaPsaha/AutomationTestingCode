package session5;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class _5_FrameHandling {

	WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void FrameHandling() throws InterruptedException {

		WebElement singleFrame = driver.findElement(By.xpath("//a[contains(text(),'Single Iframe')]"));//a[@class='analystic']"
		singleFrame.click();
		
		//Most importent step
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='singleframe']")));
		
		WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
		textBox.sendKeys("Automation");
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		
		WebElement header = driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site ')]"));
		System.out.println(header.getText());
		Assert.assertEquals("Header not found","Automation Demo Site", header.getText());

	}

	@After
	public void tearDown() {

		driver.quit();

	}

}
