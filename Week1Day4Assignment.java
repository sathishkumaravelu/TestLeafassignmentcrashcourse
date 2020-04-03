package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week1Day4Assignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// to set the system path of the chrome driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// to load the url of the leaf taps application
		driver.get("http://leaftaps.com/opentaps/control/main");

		WebElement EleUserName = driver.findElementById("username");
		EleUserName.sendKeys("demosalesmanager");

		WebElement ElePassword = driver.findElementById("password");
		ElePassword.sendKeys("crmsfa");

		WebElement EleSubmitButton = driver.findElementByClassName("decorativeSubmit");
		EleSubmitButton.click();

		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByLinkText("Create Lead").click();

		driver.findElementByLinkText("Find Leads").click();

		driver.findElementByXPath("//span[text()='Email']").click();

		driver.findElementByXPath("//*[@name='emailAddress']").sendKeys("test");

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		WebElement firstName = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]");
		String firstNameDisplayed = firstName.getText();
		System.out.println("First displayed name is " + firstNameDisplayed);

		Thread.sleep(5000);

		/* state element not found not //firstName.click(); need to check */

		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a)[1]").click();

		driver.findElementByPartialLinkText("Duplicate").click();

		String titleDuplicatePage = driver.getTitle();

		boolean verifedTitle = titleDuplicatePage.contains("Duplicate");

		System.out.println("Current page is verify lead" + verifedTitle);

		if (!verifedTitle) {

			System.out.println("Current page is verify lead" + verifedTitle);

		}

		WebElement duplicateName = driver.findElementById("createLeadForm_firstName");
		String valueDuplicateName = duplicateName.getAttribute("value");

		if (valueDuplicateName.equalsIgnoreCase(firstNameDisplayed)) {

			System.out.println("duplicate Name are same");
			driver.close();
		} else {
			System.out.println("duplicate name are not same");

		}

	}

}
