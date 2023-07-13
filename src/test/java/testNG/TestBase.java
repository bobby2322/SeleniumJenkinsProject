package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {	
	
	static WebDriver driver;
//	String browser = "Chrome";
	
	//coming from pom.xml
	@Parameters("Browser")
	@BeforeSuite
	public void getDriver(String browser) {
		
		if(browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
	}
	
	@AfterSuite
	void teardown() {
		driver.quit();
	}
}
