package week3.day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		// URL of the project
		String baseUrl = "http://leaftaps.com/opentaps/control/main";
		String userName = "demosalesmanager";
		String password = "crmsfa";
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
		WebElement EleUserName = driver.findElementById("username");
		EleUserName.sendKeys(userName);
		WebElement ElePassword = driver.findElementById("password");
		ElePassword.sendKeys(password);
		WebElement EleSubmitButton = driver.findElementByClassName("decorativeSubmit");
		EleSubmitButton.click();
		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByXPath("//a[text()='Leads']").click();
		driver.findElementByXPath("//a[text()='Merge Leads']").click();

		// click on from Lead icon
		driver.findElementByXPath("(//*[@alt='Lookup'])[1]").click();
		// storing all the windows values in set and order it in list ( set here
		// implemented in LinkedHashSet)
		Set<String> fromWindowHandles = driver.getWindowHandles();
		List<String> fromAllWindows = new ArrayList<>(fromWindowHandles);
		// swithching to second window
		driver.switchTo().window(fromAllWindows.get(1));
		// working with second window
		driver.findElementByName("firstName").sendKeys("s");
		driver.findElementByXPath("(//*[text()='Find Leads'])[last()]").click();
		Thread.sleep(3000);
		WebElement eleFirstResult = driver
				.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		String firstLead = eleFirstResult.getText();
		eleFirstResult.click();
		driver.switchTo().window(fromAllWindows.get(0));
		// String firstLead =
		// driver.findElementById("ComboBox_partyIdFrom").getAttribute("valuenow");
		System.out.println(firstLead);

		// click on To Lead
		driver.findElementByXPath("(//*[@alt='Lookup'])[2]").click();
		// storing all the windows values in set and order it in list ( set here
		// implemented in LinkedHashSet)
		Set<String> toWindowHandles = driver.getWindowHandles();
		List<String> toAllWindows = new ArrayList<>(toWindowHandles);
		// swithching to second window
		driver.switchTo().window(toAllWindows.get(1));
		// working with second window
		driver.findElementByName("firstName").sendKeys("k");
		driver.findElementByXPath("(//*[text()='Find Leads'])[last()]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		driver.switchTo().window(toAllWindows.get(0));
		// click on Merge Button
		driver.findElementByXPath("//a[text()='Merge']").click();
		Thread.sleep(3000);
		// switch to confirmation alert
		driver.switchTo().alert().accept();
		// click on find lead menu
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(firstLead);
		driver.findElementByXPath("(//*[text()='Find Leads'])[3]").click();
		Thread.sleep(3000);

		String finalResult = driver.findElementByXPath("//*[text()='No records to display']").getText();

		if (finalResult.equalsIgnoreCase("No records to display")) {
			System.out.println("Lead Merged successfully !!");
		}
		// SCREENSHOT
		File source = driver.getScreenshotAs(OutputType.FILE);
		File designation = new File("./Snaps/img.jpeg");
		FileUtils.copyFile(source, designation);
	}

}
