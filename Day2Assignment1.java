package week1.day2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// to set the system path of the webdrive.chrome.driver for specific Chromedriver.exe

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main"); // to load the url in the chrome browser

		WebElement EleUserName = driver.findElementById("username");
		EleUserName.sendKeys("demosalesmanager");

		WebElement ElePassword = driver.findElementById("password");
		ElePassword.sendKeys("crmsfa");

		WebElement EleSubmitButton = driver.findElementByClassName("decorativeSubmit");
		EleSubmitButton.click();

		driver.findElementByLinkText("CRM/SFA").click();

		String CurrentTitle = driver.getTitle();
		System.out.println(CurrentTitle);

		driver.findElementByLinkText("Create Lead").click();

		WebElement EleCmpName = driver.findElementById("createLeadForm_companyName");
		EleCmpName.sendKeys("Novac Technologies Solutions");

		WebElement EleFirstName = driver.findElementById("createLeadForm_firstName");
		EleFirstName.sendKeys("Sathish");

		WebElement EleLastName = driver.findElementById("createLeadForm_lastName");
		EleLastName.sendKeys("Kumaravelu");

		/*
		 * 
		 * WebElement EleFirstName = driver.findElementById("createLeadForm_firstNameLocal");
		 * EleFirstName.sendKeys("Sathish");
		 * 
		 * WebElement EleLastName = driver.findElementById("createLeadForm_lastNameLocal");
		 * EleLastName.sendKeys("Kumaravelu");
		 * 
		 */

		driver.findElementByClassName("smallSubmit").click();

		String CurrentTitle1 = driver.getTitle();

		if (CurrentTitle1.contains("View")) {
			System.out.println("Lead is created successfully and we are in " + CurrentTitle1 + "Page");

			driver.close();
		} else {
			System.out.println("Lead not generated please enter the madatory data");
		}

	}

}
