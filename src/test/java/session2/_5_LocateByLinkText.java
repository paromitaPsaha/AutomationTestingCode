package session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_LocateByLinkText {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies

		// Invoking the browser with given URL
		driver.get("https://dzone.com/articles/find-elements-with-link-text-amp-partial-link-text");


		// Finding the WebElement having the Link for text as "ID locator in Selenium"
		WebElement IDlocatorInSeleniumLink = driver.findElement(By.linkText("ID locator in Selenium"));

		String textOfTheClickedLink = IDlocatorInSeleniumLink.getText();
		System.out.println("Text for the link over the page is " + textOfTheClickedLink);

		// Clicking on the link
		IDlocatorInSeleniumLink.click();
		
		Thread.sleep(3000);
		
		driver.quit();


	}
}
