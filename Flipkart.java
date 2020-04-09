package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// firefox driver
		//FirefoxDriver foxDriver = new FirefoxDriver();
		// chromeDriver
		 ChromeDriver driver = new ChromeDriver();

		// adding implicitlywait for chrome and firefox driver
		//foxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 //url
		 driver.get("https://www.flipkart.com/");

		 //reference web element
		 driver.findElementByXPath("//button[text()='✕']").click();
		 
		 WebElement eleTV = driver.findElementByXPath("//span[text()='TVs & Appliances']");	 
		 
		 
	
		 //actions class object 
		 Actions builder = new Actions(driver);
		 builder.moveToElement(eleTV).perform();
		 
		 Thread.sleep(2000);
		 
		 driver.findElementByLinkText("LG").click();
		 
		 Thread.sleep(2000);
		 String tvName = driver.findElementByXPath("//div[contains(text(),'LG All-in-One 80cm ')]").getText();
		 
		 System.out.println(tvName);
	}
	
}
