package session2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_LocateByClassName {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("wendriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://zero.webappsecurity.com/");
		
		System.out.println("Title of the page before any action"+driver.getTitle());
		
		WebElement SignINBtn = driver.findElement(By.className("signin"));
		SignINBtn.click();
		Thread.sleep(3000);
		
		System.out.println("Title of the page after clicking signin: "+driver.getTitle());
		
		WebElement loginTxt = driver.findElement(By.id("user_login"));
		loginTxt.sendKeys("username");
		
		WebElement passwordTxt = driver.findElement(By.name("user_password"));
		passwordTxt.sendKeys("passward");
		
		WebElement btn = driver.findElement(By.className("btn-primary"));
		btn.click();
		Thread.sleep(3000);
		System.out.println("Title of the page after clicking signin: "+driver.getTitle());
		
		String ExpErrorMsg = "Login and/or password are wrong.";
		
		WebElement ErrorMsg = driver.findElement(By.className("alert-error"));
		String actErrorMsg = ErrorMsg.getText();
		
		if(ExpErrorMsg.equals(actErrorMsg)) {
			
			System.out.println("Test case passed");
		}
		else {
			
			System.out.println("test case failed");
		}
		driver.quit();
	
}
}
