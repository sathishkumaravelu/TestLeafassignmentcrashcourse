package week1.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class AmazonProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		/*
		 * to disable the browser notification we are passing the argument to the chrome
		 * driver
		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		/* to maximize the browser */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		/* to load the url of the rebus application in the chrome browser */
		driver.get("https://www.amazon.in/");

		driver.findElementByLinkText("Books").click();
		
		WebElement searchButton = driver.findElementById("twotabsearchtextbox");
		searchButton.sendKeys("the Monk who");
		//Thread.sleep(3000);
		Actions builder = new Actions (driver);
		builder.moveToElement(searchButton).perform();
		
		driver.findElementByXPath("(//div[@class='s-suggestion'])[1]").click();

		//driver.findElementByXPath("(//input[@type='submit'])[1]").click();
		
		String bookTitle = driver.findElementByXPath("//span[text()='The Monk Who Sold His Ferrari: A Fable About Fulfilling Your Dreams & Reaching Your Destiny']").getText();
		System.out.println("title of the book is "+bookTitle);
		
		
		String authorName = driver.findElementByXPath("(//a[@class='a-size-base a-link-normal'])[1]").getText();
		System.out.println("The author Name is " +authorName);
		
		String price = driver.findElementByXPath("//span[text()='49']").getText();
		System.out.println("The price of the book is "+price);
		
	}

}
