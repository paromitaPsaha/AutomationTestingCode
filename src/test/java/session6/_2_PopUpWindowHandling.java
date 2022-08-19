package session6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class _2_PopUpWindowHandling {

	WebDriver driver;

	@Before
	public void Setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");

	}

	@Test
	public void PopUpWindowHandling_1_() {

		System.out.println("tabHandling_1_ By Using Set");

		WebElement newWindow = driver.findElement(By.id("windowButton"));
		newWindow.click();

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> itr = handle.iterator();

		String PatentId = itr.next();
		String ChildId  = itr.next();

		System.out.println("Parent window id is: "+PatentId);

		driver.switchTo().window(ChildId);

		System.out.println("Child wimdow id is: "+ChildId);
		System.out.println("Child window title is: "+driver.getTitle());
		WebElement ChildTabText = driver.findElement(By.id("sampleHeading"));

		System.out.println("Next tabtext is: "+ChildTabText.getText());
		driver.close();

		driver.switchTo().window(PatentId);

		System.out.println("parent window title: "+driver.getTitle());
		System.out.println("parent window id: "+PatentId);


	}

	@Test
	public void PopUpWindowHandling_2_() {

		WebElement newTab = driver.findElement(By.id("tabButton"));
		newTab.click();

		System.out.println("Current tab title"+driver.getTitle());

		ArrayList<String> ar = new ArrayList<String>(driver.getWindowHandles());

		String PatentId = ar.get(0);
		String ChildId  = ar.get(1);

		System.out.println("Parent window id is: "+PatentId);

		driver.switchTo().window(ChildId);

		System.out.println("Child wimdow id is: "+ChildId);
		System.out.println("Child window title is: "+driver.getTitle());
		WebElement ChildTabText = driver.findElement(By.id("sampleHeading"));

		System.out.println("Next tabtext is: "+ChildTabText.getText());

		Assert.assertEquals("This is a sample page", ChildTabText.getText());


		driver.switchTo().window(PatentId);

		System.out.println("parent window title: "+driver.getTitle());
		System.out.println("parent window id: "+PatentId);


	}

	@After
	public void TearDown() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}



}
