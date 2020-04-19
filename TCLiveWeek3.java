package week3.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TCLiveWeek3 {

	public static void main(String[] args) throws InterruptedException {

		// URL of the project
		String baseUrl = "https://dev92474.service-now.com/";

		String userName = "admin";
		String password = "India@123";

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

		Thread.sleep(3000);
		WebElement searchKey = driver.findElementById("filter");
		searchKey.sendKeys("incident");
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Create New']").click();

		driver.switchTo().frame("gsft_main");
		String incidentNumber = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(incidentNumber);

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@id='lookup.incident.caller_id']//span").click();

		Set<String> allWindow = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<>(allWindow);
		String parentWindow = listWindow.get(0);
		driver.switchTo().window(listWindow.get(1));
		List<WebElement> names = driver.findElementsByXPath(
				"(//td[@class='list_decoration_cell col-small col-center '])//following-sibling::td[1]/a");

		WebElement firstName = names.get(0);
		firstName.click();
		driver.switchTo().window(parentWindow);

		driver.switchTo().frame("gsft_main");

		// dropdown
		WebElement catogoryDD = driver.findElementById("incident.category");
		Select catogory = new Select(catogoryDD);
		catogory.selectByValue("software");

		WebElement subCatogoryDD = driver.findElementById("incident.subcategory");
		Select subCatogory = new Select(subCatogoryDD);
		subCatogory.selectByValue("os");

		WebElement contactTypeDD = driver.findElementById("incident.contact_type");
		Select contactType = new Select(contactTypeDD);
		contactType.selectByValue("walk-in");

		WebElement stateDD = driver.findElementById("incident.state");
		Select state = new Select(stateDD);
		state.selectByValue("2");

		WebElement urgencyDD = driver.findElementById("incident.urgency");
		Select urgency = new Select(urgencyDD);
		urgency.selectByValue("1");

		Thread.sleep(3000);

		driver.findElementByXPath("//button[@id='lookup.incident.assignment_group']//span").click();

		Set<String> allAssignmentWindow = driver.getWindowHandles();
		List<String> listAssignmentWindow = new ArrayList<>(allAssignmentWindow);

		String parentAssignmentWindow = listAssignmentWindow.get(0);
		driver.switchTo().window(listAssignmentWindow.get(1));

		List<WebElement> residingValue = driver.findElementsByXPath("//a[@class='glide_ref_item_link']");
		int sizeResiding = residingValue.size();
		WebElement lastResiding = residingValue.get(sizeResiding - 1);
		lastResiding.click();
		driver.switchTo().window(parentAssignmentWindow);

		driver.switchTo().frame("gsft_main");
		driver.findElementById("incident.short_description")
				.sendKeys("Creating Incident For the Purpose of Management");
		driver.findElementByXPath("(//button[text()='Submit'])[last()]").click();

		Thread.sleep(3000);
		System.out.println(incidentNumber);

		driver.findElementById("incident_table_header_search_control").sendKeys(incidentNumber, Keys.ENTER);
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@class='list_decoration_cell col-small col-center ']//following-sibling::td/a")
				.click();

		String newIncidentNumber = driver.findElementById("incident.number").getAttribute("value");
		System.out.println(newIncidentNumber);
		if (newIncidentNumber.equalsIgnoreCase(incidentNumber)) {
			System.out.println("Verified !!");

			WebElement impactDD = driver.findElementById("incident.impact");
			Select impact = new Select(impactDD);
			impact.selectByValue("1");

			driver.findElementById("incident.description").sendKeys("Successfully Created an incident");
			driver.findElementById("activity-stream-textarea").sendKeys("Done Right");
			driver.findElementById("sysverb_update_bottom").click();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			// to logout the application
			driver.findElementByXPath("//span[text()='System Administrator']").click();
			driver.findElementByXPath("//a[text()='Logout']").click();
			driver.close();

			System.out.println("executed Successfully !!!");

		} else {
			System.out.println("incident number not found ");
		}

	}
}
