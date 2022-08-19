package session2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_LocateByName {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdeiver.chrome.driver", System.getProperty("user.dir")+ "/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Selenium");
		Thread.sleep(3000);
		
		WebElement button = driver.findElement(By.name("btnK"));
		button.click();
		Thread.sleep(2000);
		
		System.out.println("The page tiltle is: "+driver.getTitle());
		
				
		driver.quit();
	}
}
