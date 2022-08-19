package session7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _5_Synchronization2 {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;

	@Before
	public void setUp()
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");

		wait = new WebDriverWait(driver, 15);

		act = new Actions(driver);
	}

	@Test
	public void synchronization() {

		WebElement signin = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		act.moveToElement(signin).perform();

		List<WebElement> accList = driver.findElements(By.id("nav-al-your-account"));

		wait.until(ExpectedConditions.visibilityOfAllElements(accList));

		System.out.println("After mouse hover on Hello, \"Sign In\" Your Account List contains total of Options in number as - " + signin.getSize());
		System.out.println("And the List options available as below - ");
		for (int i = 0; i < accList.size(); i++) {
			System.out.println((i+1) + " " + accList.get(i).getText());
		}	
	}

	@After
	public void teardown() {

		driver.quit();
	}

}
