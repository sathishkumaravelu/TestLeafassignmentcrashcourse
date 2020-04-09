package week2.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnDroppable {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// chromeDriver
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// url
		driver.get("http://www.leafground.com/");

		driver.findElementByXPath("//h5[text()='Droppable']").click();

		// reference web element

		WebElement drag = driver.findElementByXPath("//div[@id='draggable']");
		WebElement drop = driver.findElementByXPath("//div[@id='droppable']"); 
		
		// actions class object
		Actions builder = new Actions(driver);

		builder.dragAndDrop(drag, drop).perform();
		System.out.println(drop.getCssValue("background-color"));
		System.out.println(drop.getText());
		// driver.close();
	}

}
