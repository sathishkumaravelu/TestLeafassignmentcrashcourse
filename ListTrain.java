package week3.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ListTrain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// URL of the project
		String baseUrl = "https://erail.in/trains-between-stations/mgr-chennai-ctr-MAS/ksr-bengaluru-SBC";

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		// to handle browser notifications
		ChromeOptions options = new ChromeOptions();
		ChromeOptions browserArguments = options.addArguments("--disable-notificatins", "--start-maximized");

		// Initiallizing chromeDriver
		ChromeDriver driver = new ChromeDriver(browserArguments);

		// implicitly wait for 30 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// maximze the window
		driver.manage().window().maximize();
		// url
		driver.get(baseUrl);

		driver.findElementById("chkSelectDateOnly").click();

		List<WebElement> eleTrainName = driver.findElementsByXPath("//div[@id='divTrainsList']//td[@class=''][2]");
		List<String> trainNames = new ArrayList<String>();

		// int sizeTrainName = eleTrainName.size();
		//to store the text of the webelement in an string and to add the string in arrayList
		for (WebElement eachTrainName : eleTrainName) {
			String train = eachTrainName.getText();
			trainNames.add(train);
		}
		// printing in seperate lines
		Collections.sort(trainNames);
		for (String sortedTrainNames : trainNames) {
			System.out.println(sortedTrainNames);
		}
	}

}
