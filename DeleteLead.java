package weekEndAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedMessage = "No records to display";

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		/* Entering data in login page */
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		/* clicking on crm/sfa link */
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Create Lead").click();

		WebElement eleFindLeadMenu = driver.findElementByLinkText("Find Leads");
		eleFindLeadMenu.click();
		driver.findElementByXPath(("//span[text()='Phone']")).click();
		WebElement eleFindLeadButton = driver.findElementByXPath("//button[text()='Find Leads']");
		eleFindLeadButton.click();
		Thread.sleep(5000);

		WebElement eleFirstLeadId = driver.findElementByXPath("(//a[@class='linktext'])[4]");
		String firstLead = eleFirstLeadId.getText();
		eleFirstLeadId.click();

		driver.findElementByLinkText("Delete").click();
		Thread.sleep(5000);

		driver.findElementByLinkText("Find Leads").click();
		/*
		 * i have a doubt since webelement is method i have created elefindleadmenu in
		 * the top after certain operation i have performed the click operation using
		 * the reference element elefindleadmenu but i end up with 'stale element
		 * reference' exception why
		 */
		// eleFindLeadMenu.click();

		driver.findElementByName("id").sendKeys(firstLead);

		driver.findElementByXPath("//button[text()='Find Leads']").click();

		/*
		 * i have a doubt since webelement is method i have created elefindleadmenu in
		 * the top after certain operation i have performed the click operation using
		 * the reference element elefindleadmenu but i end up with 'stale element
		 * reference' exception why
		 */
		// eleFindLeadButton.click();

		//WebElement eleMessageDisp = driver.findElementByClassName("x-paging-info");
		
		/*WebElement eleMessageDisp = driver.findElementByXPath("//div[text()='No records to display']");
		String messageDisplayed = eleMessageDisp.getText();
*/
		Thread.sleep(5000);
		String messageDisplayed = driver.findElementByXPath("//div[text()='No records to display']").getText();
		
		if (messageDisplayed.contains(expectedMessage)) {

			System.out.println("The lead is deleted successfully");
			driver.close();
		} 
		 

	}

}
