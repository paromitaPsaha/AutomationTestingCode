package session7;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _1_ToolTipHandling {

	WebDriver driver;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips/");


	}

	@Test
	public void ToolTipHandling() throws InterruptedException {

		WebElement hoverButton = driver.findElement(By.id("toolTipButton"));

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(6000);
		
		Actions act = new Actions(driver);
		act.moveToElement(hoverButton).build().perform();
		
		WebElement suggestionTextElement  = driver.findElement(By.className("tooltip-inner"));
		String SuggestionTxt = suggestionTextElement.getText();
		System.out.println("Suggestion text is: "+SuggestionTxt);
		
		Assert.assertEquals("You hovered over the Button", SuggestionTxt);
	}
	
	@Test
	public void ToolTipHandling2() throws InterruptedException{
		
		WebElement hoverSearchBox = driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		
		Thread.sleep(3000);
		
		Actions act = new Actions(driver);
		act.moveToElement(hoverSearchBox).build().perform();
		
		WebElement suggestionTextElement  = driver.findElement(By.xpath("//div[text()='You hovered over the text field']"));
		System.out.println("suggestion text is: "+suggestionTextElement.getText());
		
		Assert.assertEquals("You hovered over the text field", suggestionTextElement.getText());
		
	}

	@After
	public void TearDown() {

		driver.quit();
	}
}
