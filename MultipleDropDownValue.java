package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleDropDownValue {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// firefox driver
		FirefoxDriver foxDriver = new FirefoxDriver();
		// chromeDriver
		// ChromeDriver driver = new ChromeDriver();

		// adding implicitlywait for chrome and firefox driver
		foxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		foxDriver.get("http://www.leafground.com/pages/Dropdown.html");

		/* Accessing the drop down using the index of dropdown */

		// step1: find the element and store in WebElement
		WebElement eleFirstDropDown = foxDriver.findElementById("dropdown1");
		// step2: create a object for select method for that specific webelement
		Select firstDD = new Select(eleFirstDropDown);
		// step3: using index value select the value
		firstDD.selectByIndex(1);

		/* Accessing the drop down using the text of dropdown */
		WebElement eleSecondDropDown = foxDriver.findElementByName("dropdown2");
		Select secondDD = new Select(eleSecondDropDown);
		secondDD.selectByVisibleText("UFT/QTP");

		/* Accessing the drop down using the value of dropdown */
		WebElement eleThirdDropDown = foxDriver.findElementById("dropdown3");
		Select thirdDD = new Select(eleThirdDropDown);
		thirdDD.selectByValue("4");

		WebElement eleFourthDropDown = foxDriver.findElementByXPath("//select[@class='dropdown']");
		Select fourthDD = new Select(eleFourthDropDown);
		/*
		 * to get the no of options in dropdown we use getOptions() since it returns
		 * list of WebElement store in List<WebElement>
		 */
		List<WebElement> fourthDDOptions = fourthDD.getOptions();
		int sizeOfFourthDD = fourthDDOptions.size();
		System.out.println("The no of options in fourth drop down is " + sizeOfFourthDD);

		// selecting through sendKeys
		foxDriver.findElementByXPath("//option[contains(text(),'sendKeys')]/..").sendKeys("Sel");

		WebElement eleLastDropDown = foxDriver.findElementByXPath("(//select)[last()]");
		Select lastDD = new Select(eleLastDropDown);

		/*
		 * boolean multiple = lastDD.isMultiple(); System.out.println(multiple);
		 */
		lastDD.selectByIndex(1);
		lastDD.selectByIndex(2);
		lastDD.selectByVisibleText("Loadrunner");

	}
}