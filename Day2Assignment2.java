package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// to set the system path of the webdrive.chrome.driver for specific
		// Chromedriver.exe

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/"); // to load the url in the chrome browser

		WebElement EleUserName = driver.findElementById("email");
		EleUserName.sendKeys("testmal@gmail.com");

		WebElement ElePassword = driver.findElementById("pass");
		ElePassword.sendKeys("test@212");

		WebElement EleSubmitButton = driver.findElementById("loginbutton");
		EleSubmitButton.click();

		/* facebook after logged in show notification arises not able to click logout */

		driver.findElementById("logoutMenu").click();

		driver.findElementByLinkText("Log Out").click();

	}

}
