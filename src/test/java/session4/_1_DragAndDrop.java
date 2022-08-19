package session4;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class _1_DragAndDrop {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void DragAndDrop() throws InterruptedException
	{

		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		

		//WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement element1 = driver.findElement(By.id("draggable"));

		WebElement droparea = driver.findElement(By.id("droppable"));

		Actions act = new Actions(driver);

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		act.dragAndDrop(element1, droparea).build().perform();//cause single method is there otherwise had to build() n perform()
		//act.clickAndHold(element1).moveToElement(droparea).release().build().perform();//another way 
		
		WebElement afterDropBox = driver.findElement(By.id("droppable"));
		
		if(afterDropBox.getText().equals("Dropped!")) {
			
			System.out.println("Test pass");
		}
		else {
			
			System.out.println("test failed");
		}


		//WebElement droppedTextElement = driver.findElement(By.xpath("//div[@id='droppable']/p[text()='Dropped!']"));
		
		//Assert.assertEquals("The action is not performed", "Dropped!!", afterDropBox.getText());
	}

	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
