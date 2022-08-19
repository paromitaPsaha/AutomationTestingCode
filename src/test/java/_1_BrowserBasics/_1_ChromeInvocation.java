package _1_BrowserBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_ChromeInvocation {

	public static void main(String[] args) {
		// Set the path of browser driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarang\\eclipse-workspace\\WebDriverTopics\\chromedriver.exe"); // if driver is in other location
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); // if driver file is in root folder of project
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		//No need to right this line if driver is in root folder

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\Batch18WebDriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();//to delete all cookies
		driver.manage().window().maximize();//to maximize browser

		driver.get("https://www.nykaa.com/");

		//steps for validation
		String expTitle = "Buy Cosmetics Products & Beauty Products Online in India at Best Price | Nykaa";
		String actTitle = driver.getTitle();

		if(expTitle.equals(driver.getTitle())) {

			System.out.println("Testcase passed");
		}
		else
		{
			System.out.println("Testcase failed");
			System.out.println("The expected title is: "+expTitle);
			System.out.println("The actual title is"+actTitle);
		}
		//closing the window
		driver.quit();
	}

}
