package finalProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_1_ChangeRequest {

	public static void main(String[] args) throws InterruptedException {
		// URL of the project
		String baseUrl = "https://dev57671.service-now.com/";
		String userName = "admin";
		String password = "Guna@1994";
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
		WebElement loginFrame = driver.findElementById("gsft_main");
		driver.switchTo().frame(loginFrame);
		driver.findElementById("user_name").sendKeys(userName);
		driver.findElementById("user_password").sendKeys(password);
		// driver.switchTo().defaultContent();

		driver.findElementById("sysverb_login").click();

		Thread.sleep(300);
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * 
		 * wait.until(ExpectedConditions.textToBePresentInElement((WebElement)
		 * By.id("filter"),"filter"));
		 */ WebElement searchKey = driver.findElementById("filter");
		Thread.sleep(300);
//		searchKey.sendKeys("Change",Keys.ENTER);

		searchKey.sendKeys("Change");

		// create new ticket
		Thread.sleep(5000);
		/*
		 * Actions builder = new Actions(driver);
		 * builder.moveToElement(driver.findElementByXPath("//div[text()='Create New']")
		 * ).click().perform();
		 */

		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		Thread.sleep(3000);

		driver.switchTo().frame("gsft_main");

		driver.findElementByXPath("(//div[@class='container-fluid wizard-container'])[1]/a").click();

		WebElement ticketNumber = driver.findElementById("change_request.number");
		String tickvalue = ticketNumber.getAttribute("value");

/*		WebElement shrtDesc = driver.findElementById("problem.short_description");
		shrtDesc.sendKeys("Project case");
*/
		
		driver.findElementById("sysverb_insert_bottom").click();

		WebElement search = driver.findElementByXPath(
				"//span[contains(text(),'Press Enter from within the input to submit the search.')]//following-sibling::input");
		search.sendKeys(tickvalue, Keys.ENTER);

		WebElement resultvalueelement = driver.findElementByXPath("//a[@class='linked formlink']");	
		String resultvalue = resultvalueelement.getText();

		if (tickvalue.contains(resultvalue)) {
			System.out.println("Verified");
		}
	}

}
