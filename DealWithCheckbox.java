package week1.day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DealWithCheckbox {

	public static void main(String[] args) throws InterruptedException {

		// add system property -> webdriver.chrome.driver
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// Open the chrome browser
		// ChromeDriver (C) -> Written by Selenium Team
		ChromeDriver driver = new ChromeDriver();

		// Wait (for the element to appear for the max time: 30)
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Load the URL :: get ->
		driver.get("http://www.leafground.com/pages/checkbox.html");
		
		WebElement javaCheckBox = driver.findElementByXPath("(//input[@type='checkbox'])[1]");
		boolean valueJavaCheckBox = javaCheckBox.isSelected();
		
		System.out.println(valueJavaCheckBox);
		
		if(!valueJavaCheckBox) {
			System.out.println("Check box is not enabled");
			javaCheckBox.click();
			System.out.println("Check box is now enabled");
		}
		
		
		WebElement EleSelCheckbox = driver.findElementByXPath("(//label[text()='Confirm Selenium is checked']/following::input)[1]");
		boolean ValueSelCheckbox = EleSelCheckbox.isSelected();
		System.out.println(ValueSelCheckbox);
		
		if(!valueJavaCheckBox) {
			
			EleSelCheckbox.click();
		}
		
		/*
		 * // Find the selenium checkbox
		WebElement eleCheckBox = driver.findElementByXPath("(//label[text()='Confirm Selenium is checked']/following::input)[1]");
		boolean checked = eleCheckBox.isSelected();
		System.out.println(checked);
		
		if(!checked) {
			eleCheckBox.click();
		}
		*/
		// isSelected -> radio button, checkbox and select.
		
		// isDisplayed -> Visible (true) 
		
	}

}
