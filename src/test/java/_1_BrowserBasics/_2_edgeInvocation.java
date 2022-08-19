package _1_BrowserBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _2_edgeInvocation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\eclipse-workspace\\Batch18WebDriver\\msedgedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.amazon.in/");
		String expTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actTitle = driver.getTitle();
		//System.out.println(actTitle);
		
		if(expTitle.equals(actTitle))
		{
			System.out.println("testcase passed");
		}
		else
		{
			System.out.println("testcase failed");
		}
		
		
		
		driver.quit();
	}
}
