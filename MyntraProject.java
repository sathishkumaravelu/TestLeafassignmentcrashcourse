package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MyntraProject {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// URL of the project
		String baseUrl = "https://www.myntra.com/";
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		// to handle browser notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Initiallizing chromeDriver
		ChromeDriver driver = new ChromeDriver(options);

		// implicitly wait for 30 sec
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// maximze the window
		driver.manage().window().maximize();
		// url
		driver.get(baseUrl);

		// Mouse over and keyboard actions class used - step 2 (women)
		Actions builder = new Actions(driver);
		// reference element for mouseOver
		WebElement eleWomen = driver.findElementByXPath("//a[text()='Women']");
		// passing the WE(women) to moveToElement method
		builder.moveToElement(eleWomen).perform();

		Thread.sleep(3000);
		//step 3 - click on jackets and waistcoats
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();	

		
		WebElement eleTitleCount = driver.findElementByXPath("//span[@class='title-count']");
		String stringTitleCount = eleTitleCount.getText();
		
		String stringIntTitleCount = stringTitleCount.replaceAll("\\D","");
		int TitleCount = Integer.parseInt(stringIntTitleCount);
		
		//printing the total title count
		System.out.println("Total title count displayed for jackets and coats is " +TitleCount);
		
		
		//Jackets count
		WebElement eleJacketsCount = driver.findElementByXPath("(//span[@class='categories-num'])[1]");
		String stringJacketsCount = eleJacketsCount.getText();
		
		String stringIntJacketsCount = stringJacketsCount.replaceAll("\\D","");
		int jacketsCount = Integer.parseInt(stringIntJacketsCount);
		
		System.out.println("total jackets found is " +jacketsCount);
		
		//coats count
		
		WebElement eleCoatsCount = driver.findElementByXPath("(//span[@class='categories-num'])[last()]");
		String stringCoatsCount = eleCoatsCount.getText();
		
		String stringIntCoatsCount = stringCoatsCount.replaceAll("\\D","");
		int coatsCount = Integer.parseInt(stringIntCoatsCount);
		
		System.out.println("total jackets found is " +coatsCount);
		
		//to find the sum of jacket and coat
		
		int resultCount=jacketsCount+coatsCount;
		
		//step 5
		if(resultCount == TitleCount) {
			
			System.out.println("Verified sum of catogories count matches the result is pass");
		}else {
			System.out.println("Verified sum of catogories count matches the result is failed");
		}
			
		
		Thread.sleep(3000);
		//step6
		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		
		//driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();

		//step 7 click on more button 
		driver.findElementByXPath("//div[@class='brand-more']").click();
		
		//type mango in search
		
		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("Mango");
		
		//click on mango checkbox
		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();
		
		//Click on close button in results
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();	
		
		//list of bands name stored in list 
		
		Thread.sleep(2000);
		//List<WebElement> eleListBrandName = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
		List<WebElement> eleListBrandName = driver.findElementsByXPath("//h3[@class='product-brand']");
		
		
		
		//WebElement test = eleListBrandName.get(0);
		//System.out.println(test.getText());
		
		//step 10 confirming the brand has only mango 
		for (WebElement brandName : eleListBrandName) {
			String eleBrandNameTitle = brandName.getText();
			
			
			if (!eleBrandNameTitle.equalsIgnoreCase("Mango")) {
				
				System.out.println("not contains mango");
				}
		}
		
		//sorting based on better discount
		
		WebElement eleSort = driver.findElementByXPath("//div[@class='sort-sortBy']");
		
		//since builder is for entier driver used the same builder object 
		builder.moveToElement(eleSort).perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@value='discount']/..").click();
		
		Thread.sleep(1000);
		// print the first rate
		
		List<WebElement> eleListPrice = driver.findElementsByXPath("(//span[@class='product-discountedPrice'])[1]");
		WebElement eleFirstPrice = eleListPrice.get(0);
		String stringFirstPrice = eleFirstPrice.getText();
		String stringIntFirstPrice = stringFirstPrice.replaceAll("\\D","");
		int firstProductPrice = Integer.parseInt(stringIntFirstPrice);
		
		System.out.println("First Product Price is " +firstProductPrice);
		
		
		//step 13
		Thread.sleep(3000);
		//WebElement eleSize = driver.findElementByXPath("(//h4[@class='product-sizes'])[1]");
		//builder.moveToElement(eleSize).perform();		
		
		builder.moveToElement(driver.findElementByXPath("(//h4[@class='product-sizes'])[1]")).build().perform();
		
		//wishlist
		driver.findElementByXPath("(//span[text()='wishlist now'])[1]").click();
		
		
		
	}

}
