package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DealWithButtons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		String bgColor = driver.findElementById("top").getCssValue("background");
		System.out.println(bgColor);
		
		
		String size = driver.findElementByTagName("label").getCssValue("font-size");
		System.out.println(size);
		
		int widthButton = driver.findElementByClassName("decorativeSubmit").getSize().getWidth();
		System.out.println(widthButton);

		
		WebElement eleUserName = driver.findElementByClassName("decorativeSubmit");
		
		int widthUse = eleUserName.getSize().getWidth();
		
		System.out.println(widthUse);
		//System.out.println(eleUserName);
		
		WebElement eleUserNameLoc = driver.findElementById("username");
		System.out.println("The x value is: "+eleUserNameLoc.getLocation().getX());
		
	}

}
