package week1.day3;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// to set the system path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// to load the url of the application to be loaded
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		WebElement USElement = driver.findElementById("username");
		USElement.sendKeys("DemoSalesManager");

		WebElement USPassword = driver.findElementByName("PASSWORD");
		USPassword.sendKeys("crmsfa");
		
		WebElement Button = driver.findElementByClassName("decorativeSubmit");
		Button.click();
		
		String titleoffield = driver.findElementByTagName("h2").getText();
		//System.out.println(titleoffield);
		String substring = titleoffield.substring(7, titleoffield.length());
		System.out.println(substring);
		
		
	}

}
