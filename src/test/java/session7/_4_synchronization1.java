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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_synchronization1 {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);//wait 15 sec to load the page
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);//wait 12 sr=ec to load the webelements of the page
		wait = new WebDriverWait(driver,15);

		driver.get("https://www.amazon.in/");

	}

	@Test
	public void synchronization() {

		WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
		SearchBox.sendKeys("Nokia");

		List<WebElement> SearchList = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
		//need brush up on gettibg the xpath for list

		wait.until(ExpectedConditions.visibilityOfAllElements(SearchList));

		for (int i = 0; i < SearchList.size(); i++) {

			System.out.println(SearchList.get(i).getText());

		}

	}

	@After
	public void teardown() {

		driver.quit();
	}
}
