package session9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_WebTableHandingPriceValidation {

	static WebDriver driver;

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


		// List for finding list of the prices from the table
		List<WebElement> priceList = driver.findElements(By.xpath("//th[text()='Price']//ancestor::table[@id='shopping']//tr/td[2]"));

		// finding final total price element
		WebElement finalTotalPrice = driver.findElement(By.xpath("//i[text()='Total']//ancestor::tfoot//td[2]/b"));

		int sum = 0;

		for(int i = 0; i < priceList.size(); i++ ) {

			sum = sum + Integer.parseInt(priceList.get(i).getText());
		}

		if (sum == Integer.parseInt(finalTotalPrice.getText())) {
			Assert.assertTrue(true);
			System.out.println("Total is matching");
		}
		else {
			Assert.assertFalse(false);
			System.out.println("Total is not matching");
		}

	}

	@After
	public void teardown() {

		driver.quit();
	}
}
