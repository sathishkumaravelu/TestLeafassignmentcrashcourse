package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDroppable2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// chromeDriver
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		 //url
		 driver.get("http://www.leafground.com/");

		 driver.findElementByXPath("//h5[text()='Sortable']").click();
		 
		 //reference web element
		 
		 WebElement eleOne = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		 WebElement eleFour = driver.findElementByXPath("//ul[@id='sortable']/li[4]");
		 //actions class object 
		 Actions builder = new Actions(driver);

		 int x = eleFour.getLocation().getX();
		 int y = eleFour.getLocation().getY();
		 int half=(y/2)-1;
		 
		 Thread.sleep(3000);
		 
		 builder.dragAndDropBy(eleOne,0,half).perform();
		 
		 
		//driver.close();
	}
	
}
