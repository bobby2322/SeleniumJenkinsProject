package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBrowser extends TestBase{

	@Test
	public void launchBrowser(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hi");

	}
	@Test
	public void launchBrowser2(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hiii");
//		Assert.fail();
	}
}
