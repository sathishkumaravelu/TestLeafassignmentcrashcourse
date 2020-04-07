/*Week2.Day1 Assignment 1 - edit lead by using XPath*/

package week2.day1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLeadXPath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedTitle = "View Lead";
		String companyNameExpected = "Novac Technology Solutions";

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://leaftaps.com/opentaps/control/main");

		/* Entering data in login page */
		driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesManager", Keys.TAB); // attribute based
																										// xpath is used
		driver.findElementByXPath("//input[@id='password']").sendKeys("crmsfa"); // attribute based xpath is used
		driver.findElementByXPath("//input[@class='decorativeSubmit']").click(); // attribute based xpath is used

		/* clicking on crm/sfa link */
		driver.findElementByXPath("//a[contains(text(),'CRM/SFA')]").click(); // partial text based xpath is used

		driver.findElementByXPath("//a[(text()='Create Lead')]").click(); // text based xpath is used

		driver.findElementByXPath("//a[(text()='Find Leads')]").click(); // text based xpath is used

		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Sathish"); // index based xpath is used
		driver.findElementByXPath("//button[text()='Find Leads']").click(); // text based xpath is used
		Thread.sleep(5000);

		/*
		 * (//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first
		 * '])[1]/div/a -- GP-P-GC (//td[@class='x-grid3-col x-grid3-cell
		 * x-grid3-td-partyId x-grid3-cell-first '])[1]//a -- gp-gc
		 *
		 */

		driver.findElementByXPath("(//a[@class='linktext'])[4]").click(); // index based xpath

		String verifyTitle = driver.getTitle();
		System.out.println(verifyTitle);
		if (verifyTitle.contains(expectedTitle)) {
			System.out.println("currently we are in view leads page");
		} else {
			System.out.println(" we are not landed on view lead page");
		}

		driver.findElementByXPath("//a[text()='Edit']").click();

		/* to move the edit lead page */

		WebElement eleCompanyName = driver.findElementByXPath("//input[@id='updateLeadForm_companyName']"); // attribute
																											// based
																											// xpath
		eleCompanyName.clear();
		eleCompanyName.sendKeys(companyNameExpected);

		driver.findElementByXPath("(//input[@class='smallSubmit'])[1]").click(); // index based xpath based on attribute

		Thread.sleep(1000);

		WebElement eleViewCompanyName = driver.findElementByXPath("//span[@id='viewLead_companyName_sp']"); // attribute
																											// based
																											// xpath
		String displayedCompanyName = eleViewCompanyName.getText();

		System.out.println("Displayed company name in view lead page is " + displayedCompanyName);

		if (displayedCompanyName.contains(companyNameExpected)) {
			System.out.println("Company Name update successfully  as expected " + displayedCompanyName);
		} else {
			System.out.println("Company Name not updated correctly");
		}

		driver.close();

	}

}
