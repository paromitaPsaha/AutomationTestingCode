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

public class _2_WebTableHandlingCheckBox {

	static WebDriver driver;
	String username = "Koushik";

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://letcode.in/table");
	}

	@Test
	public void _1_WebTableHandinPrice() {

		try {
			WebElement checkBoxUser = driver.findElement(By.xpath("//td[text()=' '"+username+"]/following-sibling::td[3]/input[@type='checkbox']"));
			checkBoxUser.click();
			
			Assert.assertTrue(checkBoxUser.isSelected());
			
			System.out.println("Checkbox for user \""+username+"\" is selected");

		} catch (Exception e) 
		{
			System.err.println("Unable to findout the username: " + username + " in the table");
			e.printStackTrace();
			e.getMessage();	
		}	
	}

	@After
	public void teardown() {

		driver.quit();
	}

}
