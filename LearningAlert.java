package week3.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearningAlert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// URL of the project
		String baseURL = "http://www.leafground.com/home.html";

		// String emailID = "sathishkumaravelu@gmail.com";
		// String password="Guna@1994";
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// to handle browser notifications
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-notifications");
		ChromeOptions chromeOption = options.addArguments("--start-maximized", "--disable-notifications");
		// Initiallizing chromeDriver
		ChromeDriver driver = new ChromeDriver(chromeOption);

		// implicitly wait for 30 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// maximze the window
		// driver.manage().window().maximize();
		// url
		driver.get(baseURL);

		driver.findElementByXPath("//*[@alt='Alert']").click();
		driver.findElementByXPath("//*[text()='Alert Box']").click();
		Alert firstAlert = driver.switchTo().alert();
		String aletText = firstAlert.getText();
		System.out.println(aletText);
		firstAlert.accept();
		//firstAlert.dismiss();


		//confirm alert box
		driver.findElementByXPath("//*[text()='Confirm Box']").click();
		Alert confirmAlert = driver.switchTo().alert();
		String confirmAlertText = confirmAlert.getText();
		System.out.println(confirmAlertText);
/*		
		Class<? extends Alert> class1 = confirmAlert.getClass();
		System.out.println(class1);
		
*/		
		confirmAlert.accept();
		//confirmAlert.dismiss();
		String resultText = driver.findElementByXPath("//*[@id='result']").getText();
		System.out.println(resultText);

		//Prompt Alert
		driver.findElementByXPath("//*[text()='Prompt Box']").click();
		Alert promptAlert = driver.switchTo().alert();
		String promtText = promptAlert.getText();
		System.out.println(promtText);
		promptAlert.sendKeys("Test Sathish");
		promptAlert.accept();
		String resultOneText = driver.findElementByXPath("//*[@id='result1']").getText();
		System.out.println(resultOneText);
		
		
		//Line Breaks
		
		driver.findElementByXPath("//*[text()='Line Breaks?']").click();
		Alert lineBreakAlert = driver.switchTo().alert();
		String linkBreakText = lineBreakAlert.getText();
		System.out.println(linkBreakText);
		lineBreakAlert.accept();

		//Sweet Alert
		driver.findElementByXPath("//*[text()='Sweet Alert']").click();
		String sweetAlertText = driver.findElementByXPath("//*[@class='swal-modal']/div[1]").getText();	
		System.out.println(sweetAlertText);
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@class='swal-button-container']/button").click();

	
		driver.findElementByXPath("//*[@alt='logo Testleaf']").click();
	}

}
