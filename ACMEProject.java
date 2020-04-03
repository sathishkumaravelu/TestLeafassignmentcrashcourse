package week1.day5;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ACMEProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login"); // to load the url of the acme application in the chrome browser

		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		
		driver.findElementById("password").sendKeys("leaf@12");
		
		driver.findElementById("buttonLogin").click();
		
		Thread.sleep(3000);
		WebElement eleVendor = driver.findElementByXPath("//button[text()[normalize-space()='Vendors']]");
		Actions builder = new Actions(driver);
		builder.moveToElement(eleVendor).perform();
		
		driver.findElementByLinkText("Search for Vendor").click();
		
		driver.findElementById("vendorName").sendKeys("Blue lagoon");
		
		driver.findElementById("buttonSearch").click();
		
	
		String countryName = driver.findElementByXPath("//td[text()='France']").getText();
		System.out.println("Blue lagoon is from the country" +countryName);
		
		driver.findElementByLinkText("Log Out").click();
		
		System.out.println("Project one done !!!");
		
		driver.close();
		
		
	}

}
