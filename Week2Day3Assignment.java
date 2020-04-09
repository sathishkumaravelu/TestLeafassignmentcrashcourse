package week2.day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Week2Day3Assignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.leafground.com/pages/table.html");

		// table stored in webelement
		WebElement table = driver.findElementById("table_id");

		/* To print the total no of row and columns */

		// to get all the rows and store in a list of webements

		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int rowSize = allRows.size();
		System.out.println(rowSize);

		// to get all the rows and store in a list of webements
		List<WebElement> allColumn = table.findElements(By.tagName("td"));
		int rowColumn = allColumn.size();
		System.out.println(rowColumn);

		/* Get the progress value of 'Learn to interact with Elements' */

		// element located in the second row so we store the webElement
		WebElement secondRow = allRows.get(2);
		List<WebElement> eleSRSC = secondRow.findElements(By.tagName("td"));
		WebElement SRSC = eleSRSC.get(1);
		String valueOfSRSC = SRSC.getText();
		System.out.println(valueOfSRSC);

		/* Find the vital task for the least completed progress */

		WebElement thirdRow = allRows.get(3);
		List<WebElement> eleTRSC = thirdRow.findElements(By.tagName("td"));
		WebElement TRSC = eleTRSC.get(1);
		String value = TRSC.getText();
		System.out.println("Min value: " + value);

		/* checkbox for the specific value */

		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();

	}

}
