package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day2Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// to set the system path of the webdrive.chrome.driver for specific
		// Chromedriver.exe

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/"); // to load the url in the chrome browser

		WebElement EleUserName = driver.findElementById("email");
		EleUserName.sendKeys("testmail@gmail.com");

		WebElement ElePassword = driver.findElementById("pass");
		ElePassword.sendKeys("123ssd");

		WebElement EleSubmitButton = driver.findElementById("loginbutton");
		EleSubmitButton.click();

		/* facebook after logged in show notification arises not able to click logout */

		driver.findElementById("logoutMenu").click();
		Thread.sleep(10000);
		driver.findElementByLinkText("Log Out").click();

	}

}
