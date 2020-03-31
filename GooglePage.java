package week1.day2;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// to load the url of the application to be loaded
		// driver.get("https://www.google.com/");
		driver.get("https://accounts.google.com/");
		// to navigate back

		// driver.navigate().back();

		String title = driver.getTitle();
		System.out.println(title);

		driver.navigate().refresh();

		// print the current url 
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

		// to print which browser and version - capabilities 
		
		String browserName = driver.getCapabilities().getBrowserName();
		System.out.println(browserName);
		
		Platform platform = driver.getCapabilities().getPlatform();
		System.out.println(platform);
		
		String version = driver.getCapabilities().getVersion();
		System.out.println(version);
		
		Thread.sleep(2000);
		driver.close();

	}

}
