package session2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_NavigationCmd {

	public static void main(String[] args) throws InterruptedException {

		//setting the path of browser
		System.setProperty("webbrowser.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // set a maximum timeout for searching out the WebElements before throwing an exception 

		// Invoking the browser with given URL
		driver.get("https://www.google.co.in");
		
		String title = driver.getTitle();
		System.out.println("the title is: "+title);
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.amazon.in/");
		System.out.println("the title is: "+driver.getTitle());
		Thread.sleep(2000);
		
		//to go back to the previous page i.e google
		driver.navigate().back();
		System.out.println("After navigation the title is: "+driver.getTitle());
		Thread.sleep(2000);
		
		//if you again wish to go on amazon page
		driver.navigate().forward();
		System.out.println("After 2nd navigation the title is: "+driver.getTitle());
		Thread.sleep(2000);
		
		//to refresh the page
		driver.navigate().refresh();
		System.out.println("After refreshing the title is: "+driver.getTitle());
		
		driver.quit();
	}

}
