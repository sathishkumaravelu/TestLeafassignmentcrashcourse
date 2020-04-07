package week2.day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadXpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedMessage = "No records to display";

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		/* Entering data in login page */
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesManager", Keys.TAB); // attribute based
																										// xpath is used
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa"); // attribute based xpath is used
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click(); // attribute based xpath is used

		/* clicking on crm/sfa link */
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click(); // partial text based xpath is used

		driver.findElementByXPath("//a[(text()='Create Lead')]").click(); // text based xpath is used

		driver.findElementByXPath("//a[(text()='Find Leads')]").click(); // text based xpath is used

		driver.findElementByXPath(("//span[text()='Phone']")).click(); // text based xpath is used

		WebElement eleFindLeadButton = driver.findElementByXPath("//button[text()='Find Leads']");
		eleFindLeadButton.click();
		Thread.sleep(5000);

		// get the value of first displaying result and to store in string
		WebElement eleFirstLeadId = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		String firstLead = eleFirstLeadId.getText();
		eleFirstLeadId.click();

		// click on delete button
		driver.findElementByXPath("//a[(text()='Delete')]").click();
		Thread.sleep(5000);

		// click find lead button menu
		driver.findElementByXPath("//a[(text()='Find Leads')]").click();

		// type value in lead id input field
		driver.findElementByXPath("//input[@name='id']").sendKeys(firstLead);

		// click on bind lead button
		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(5000);

		String messageDisplayed = driver.findElementByXPath("//div[@class='x-paging-info']").getText();

		if (messageDisplayed.contains(expectedMessage)) {

			System.out.println("The lead is deleted successfully");
		} else {
			System.out.println(firstLead+  "The lead not deleted");
		}
	}
}
