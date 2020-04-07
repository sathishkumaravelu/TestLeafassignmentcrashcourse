package week2.day1;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2Day2WebElementsPractices {

	public static void main(String [] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://www.leafground.com/pages/Link.html");

		// to store the list of WebElement
		List<WebElement> listOfLinks = driver.findElementsByTagName("a");
		// to store the the number of links in int 
		
		int noOfLinks = listOfLinks.size();
		System.out.println("No of hyper links found in page" + noOfLinks);
		
		//to find the first matching href (link)
		WebElement firstLink = listOfLinks.get(0);
		firstLink.click();
	
		driver.navigate().back();
		driver.navigate().forward();
	
		
		List<WebElement> listOfLinkSecondTime = driver.findElementsByTagName("a");		
		WebElement newLastLink = listOfLinkSecondTime.get(noOfLinks-1);
		newLastLink.click();
		
		System.out.println("done");
	}
}
