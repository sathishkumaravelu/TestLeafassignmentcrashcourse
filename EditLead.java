package weekEndAssignment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedTitle = "View Lead";
		String companyNameExpected = "Novac Technology Solutions";

		System.setProperty("webdriver.chrome.driver", "./Chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to("http://leaftaps.com/opentaps/control/main");

		/* Entering data in login page */
		driver.findElementById("username").sendKeys("demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		/* clicking on crm/sfa link */
		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByLinkText("Find Leads").click();

		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Sathish");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();

		String verifyTitle = driver.getTitle();
		System.out.println(verifyTitle);
		if (verifyTitle.contains(expectedTitle)) {
			System.out.println("currently we are in view leads page");
		} else {
			System.out.println(" we are not landed on view lead page");
		}

		driver.findElementByLinkText("Edit").click();

		/* to move the edit lead page */

		WebElement eleCompanyName = driver.findElementById("updateLeadForm_companyName");
		eleCompanyName.clear();
		eleCompanyName.sendKeys(companyNameExpected);

		driver.findElementByXPath("(//input[@class='smallSubmit'])[1]").click();

		WebElement eleViewCompanyName = driver.findElementById("viewLead_companyName_sp");
		String displayedCompanyName = eleViewCompanyName.getText();

		System.out.println(displayedCompanyName);
		if (displayedCompanyName.contains(companyNameExpected)) {
			System.out.println("Company Name update successfully is " + displayedCompanyName);
		} else {
			System.out.println("Company Name not updated correctly");
		}

		driver.close();

	}

}
