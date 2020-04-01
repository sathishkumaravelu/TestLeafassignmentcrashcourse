package week1.day3;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// to set the system path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		// to load the url of the application to be loaded
		driver.get("http://leaftaps.com/opentaps/control/main");
		// to navigate back
		//driver.navigate().back();
		//driver.navigate().back();
		String title = driver.getTitle();
		System.out.println(title);
		
		String browserName = driver.getCapabilities().getBrowserName();
		System.out.println(browserName);
		
		Platform platform = driver.getCapabilities().getPlatform();
		System.out.println(platform);
		
		String version = driver.getCapabilities().getVersion();
		System.out.println(version);
		
		WebElement USElement = driver.findElementById("username");
		//USElement.clear();
		USElement.sendKeys("DemoSalesManager");

		WebElement USPassword = driver.findElementByName("PASSWORD");
			//ClassName("PASSWORD");
		USPassword.sendKeys("crmsfa");
		
		WebElement Button = driver.findElementByClassName("decorativeSubmit");
		Button.click();
		
		
		WebElement CRMButton = driver.findElementByLinkText("CRM/SFA");
		CRMButton.click();
		

	}

}
