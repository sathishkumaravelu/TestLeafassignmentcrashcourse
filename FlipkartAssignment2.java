package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartAssignment2 {

	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// chromeDriver
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// url
		driver.get("https://www.flipkart.com/");

		// reference web element
		driver.findElementByXPath("//button[text()='✕']").click();

		WebElement eleMobile = driver.findElementByXPath("//span[text()='Electronics']");

		// actions class object
		Actions builder = new Actions(driver);
		builder.moveToElement(eleMobile).perform();

		Thread.sleep(3000);

		driver.findElementByLinkText("Mi").click();

		Thread.sleep(5000);
		
		String titleOfCurrentPage = driver.getTitle();

		boolean containsMi = titleOfCurrentPage.contains("Mi");
		
		System.out.println(titleOfCurrentPage);
		
		if(containsMi) {
			System.out.println("page title verifed and title of the page is " +titleOfCurrentPage);			
		}else {
			System.out.println("page title not contains mi");
		}
		

	}

}
