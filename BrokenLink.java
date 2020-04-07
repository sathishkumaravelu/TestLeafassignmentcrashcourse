package week1.day4;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// to load the url of the application to be loaded
		driver.get("http://www.leafground.com/pages/Link.html");
		
		String Value = driver.findElementByPartialLinkText("Find where").getAttribute("href");
		
		System.out.println("this the link it will take us if we click " +Value);
		
	}

}
