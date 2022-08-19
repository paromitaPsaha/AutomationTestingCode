package session3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_WebElementByXpath {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Register.html");

		// Finding the WebElement of First Name textbox field by using xpath
		WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

		if (firstNameTextBox.isDisplayed()) 
		{
			// Entering text into the search box
			firstNameTextBox.sendKeys("Tom");
		}
		else 
		{
			System.out.println("WebElement with name firstNameTextBox is not found");
		}

		// Finding the WebElement of Gender male radio buttton by using xpath
		WebElement genderMaleRadioButton = driver.findElement(By.xpath("//input[@value='Male']"));

		if (genderMaleRadioButton.isEnabled()) 
		{
			// Clicking on the radio button
			genderMaleRadioButton.click();
		}
		else 
		{
			System.out.println("WebElement with name genderMaleRadioButton is not found");
		}

		// So see the execution before closing the browser
		Thread.sleep(4000);

		// Closing the browser
		driver.quit();
	}
}
