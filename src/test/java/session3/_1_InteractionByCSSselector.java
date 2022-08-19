package session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_InteractionByCSSselector {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		WebElement SearchBox = driver.findElement(By.cssSelector("input.gLFyf"));
		SearchBox.sendKeys("Automation testing");
		Thread.sleep(3000);

		WebElement searchButton = driver.findElement(By.cssSelector("input.gNO89b"));
		searchButton.click();
		System.out.println("title of the page is: "+driver.getTitle());

		//alternative code:

		// Entering text into the search box
		//		searchBox.sendKeys("Automation Testing" + Keys.ENTER);
		//
		//		// Waiting for the Google Search button to appear after entering the search keyword
		//		Thread.sleep(4000);
		//		
		//		
		//		// Waiting for next page to load 
		//		Thread.sleep(5000);
		//		
		//		// Fetching the page title & printing it
		//		System.out.println("The Page Title is after making search for a keyword is : " + driver.getTitle());

		// ------------------------------------------------------------------------------------------------------------------------------------


		driver.quit();
	}

}
