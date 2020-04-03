package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RedBusProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		/*to disable the browser notification we are passing the argument to the chrome driver*/
		ChromeOptions options = new ChromeOptions();		
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		/*to maximize the browser */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/* to load the url of the rebus application in the chrome browser */
		driver.get("https://www.redbus.in/");

		/* webelement is used since multiple actions done on same element */

		WebElement eleSource = driver.findElementById("src");
		eleSource.sendKeys("Chennai");
		Thread.sleep(5000);
		eleSource.sendKeys(Keys.TAB);

		WebElement eleDesignation = driver.findElementById("dest");
		eleDesignation.sendKeys("Bangalore");
		Thread.sleep(5000);
		eleSource.sendKeys(Keys.TAB);

		driver.findElementByXPath("(//div[contains(@class,'fl search-box')]//span)[3]").click();
		driver.findElementByXPath("(//td[text()='30'])[2]").click();
		driver.findElementById("search_btn").click();

		driver.findElementByXPath("(//label[@for='dtAfter 6 pm'])[2]").click();
		driver.findElementByXPath("//label[@title='SLEEPER']").click();
		driver.findElementByLinkText("Seats Available").click();
		System.out.println("Project 2 is done !!");
	}

}
