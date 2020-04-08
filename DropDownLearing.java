package week2.day3;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownLearing {

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

		// source dropdown		
		WebElement sourceDD = driver.findElementById("createLeadForm_dataSourceId");
		//object for source dropdown where webelement of  the dropdown passed inside the select method
		Select ddSource = new Select(sourceDD);
		// select by text
		ddSource.selectByVisibleText("Conference");		

		// industry dropdown	
		WebElement industryDD = driver.findElementById("createLeadForm_industryEnumId");
		//object for industry dropdown
		Select ddIndustry = new Select(industryDD);
		
		/* to get the total size we use method .getOptions() 
		which returns us the list of webelements so we store it in List<WebElement>  
		*/
		List<WebElement> sizeOfIndustryDD = ddIndustry.getOptions();
		/*From the list of WebElement we are getting the size of the specific dropdown*/
		int size = sizeOfIndustryDD.size();
		/* Now using the size of the dropdown size-1 would help 
		us to interact the last value of dropdown using .selectByIndex
		*/
		ddIndustry.selectByIndex(size-1);
		
		
	}

}
