package session2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_ElementSearchByID {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// set a maximum timeout for searching out the WebElements before throwing an exception

		// Invoking the browser with given URL
		driver.get("http://demo.automationtesting.in/Index.html");

		Thread.sleep(2000);

		// Finding the WebElement of SearchBox for user name field
		WebElement username = driver.findElement(By.id("email")); 

		// Entering Text into User Name field
		username.sendKeys("abc@gmail.com");
		Thread.sleep(2000);

		// Clicking on proceed button
		WebElement button = driver.findElement(By.id("enterimg"));
		button.click();
		Thread.sleep(3000);
		System.out.println("Title of the page : "+driver.getTitle());


		driver.quit();
	}

}
