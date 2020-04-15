package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// URL of the project
		String baseUrl = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert";

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// to handle browser notifications
		ChromeOptions options = new ChromeOptions();
		ChromeOptions browserArguments = options.addArguments("--disable-notificatins", "--start-maximized");

		// Initiallizing chromeDriver
		ChromeDriver driver = new ChromeDriver(browserArguments);

		// implicitly wait for 30 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// maximze the window
		driver.manage().window().maximize();
		// url
		driver.get(baseUrl);

		driver.switchTo().frame("iframeResult");
		driver.findElementByXPath("//button[text()='Try it']").click();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.findElementByXPath("//button[text()='Run »']").click();

	}

}
