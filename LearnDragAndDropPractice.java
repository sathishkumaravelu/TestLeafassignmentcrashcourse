package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDragAndDropPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// firefox driver
		//FirefoxDriver foxDriver = new FirefoxDriver();
		// chromeDriver
		 ChromeDriver driver = new ChromeDriver();

		// adding implicitlywait for chrome and firefox driver
		//foxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 //url
		 driver.get("http://www.leafground.com/pages/selectable.html");

		 //reference web element
		 WebElement eleLast = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
		 WebElement eleFirst = driver.findElementByXPath("//ol[@id='selectable']/li[4]");

		 //actions class object 
		 Actions builder = new Actions(driver);
		 builder.clickAndHold(eleLast).click(eleFirst).perform();
	}
	
}
