package week2.day2;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2Day2WebElementsPractices {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/Link.html");

		// to store the list of WebElement
		List<WebElement> listOfLinks = driver.findElementsByTagName("a");

		// to store the the number of links in int
		int noOfLinks = listOfLinks.size();
		System.out.println("No of hyper links found in page" + noOfLinks);

		// to find the first matching href (link) and click it
		WebElement firstLink = listOfLinks.get(0);
		firstLink.click();
		System.out.println("the current page is" + driver.getCurrentUrl());

		driver.navigate().back();

		Thread.sleep(3000);

		// driver.navigate().forward();

		// 2. click on last link of the page
		List<WebElement> listOfLinkSecondTime = driver.findElementsByTagName("a");
		WebElement newLastLink = listOfLinkSecondTime.get(noOfLinks - 1);
		newLastLink.click();

		/* 3. to print the text near to the go to home page */

		// using sibling downwards xpath it is accessed
		String textOfLable = driver.findElementByXPath("(//a[text()='Go to Home Page'])[last()]/following-sibling::label").getText();
		System.out.println(textOfLable);

		System.out.println("class practice for the day done");
	}
}
