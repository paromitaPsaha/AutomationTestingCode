package session9;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;


public class _1_validateColorOfElement {

	WebDriver driver;

	String url = "https://www.facebook.com/";
	final String bgcolor = "#1877f2";

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.get(url);

	}

	@Test
	public void validateColorOfElement() {

		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));

		System.out.println("The color for \"Login\" button is -> " + loginButton.getCssValue("background-color"));

		String actualColor = loginButton.getCssValue("background-color");
		System.out.println("After converting RGB color value for \"Login\" button to the HEX Value Output is : " + rgbToHex(actualColor));

		Assert.assertEquals("The colour for \"Login\" button is not matching with expected value.",bgcolor, rgbToHex(actualColor));
		System.out.println("Test for Colour of Element is passed.");

	}
	/*
	 * This method converts the RGB value to its HEX code
	 * 
	 * @param rgbColor
	 * 
	 * @return String HEX value
	 */

	public static String rgbToHex(String rgbColor) {

		return Color.fromString(rgbColor).asHex();
	}


	@After
	public void teardown() {

		driver.quit();

	}

}
