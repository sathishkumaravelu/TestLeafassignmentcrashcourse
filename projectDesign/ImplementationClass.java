package projectDesign;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplementationClass implements ProjectInterfaceDesign {

	public static RemoteWebDriver driver;

	public void launchApplication(String browserName, String Url) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
				System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
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
				driver.get(Url);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ".Drivers/geckodriver.exe");
				// to handle browser notifications
				FirefoxOptions options = new FirefoxOptions();
				FirefoxOptions browserArguments = options.addArguments("--disable-notificatins", "--start-maximized");
				// Initiallizing chromeDriver
				FirefoxDriver driver = new FirefoxDriver(browserArguments);
				// implicitly wait for 30 sec
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				// maximze the window
				driver.manage().window().maximize();
				// url
				driver.get(Url);
			}
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}

	}

	public WebElement locateElementBy(String locator, String LocatorValue) {
		try {
			switch (locator) {
			case "id":
				return driver.findElementById(LocatorValue);
			case "tagname":
				return driver.findElementByTagName(LocatorValue);
			case "name":
				return driver.findElementByName(LocatorValue);
			case "class":
				return driver.findElementByClassName(LocatorValue);
			case "xpath":
				return driver.findElementByXPath(LocatorValue);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element " + LocatorValue + "could not find using locator" + locator);
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
		return null;
	}

	public WebElement locateElementID(String ID) {
		try {
			return driver.findElementById(ID);
		} catch (NoSuchElementException e) {
			System.out.println("The element " + ID + "could not find using ID locator");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
		return null;
	}

	public WebElement locateElementXPath(String XPath) {
		try {
			return driver.findElementById(XPath);
		} catch (NoSuchElementException e) {
			System.out.println("The element " + XPath + "could not find using XPath");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
		return null;
	}

	public void enterData(WebElement inputElement, String sendkeysData) {
		try {
			inputElement.sendKeys(sendkeysData);
		} catch (IllegalArgumentException e) {
			System.out
					.println("the data" + sendkeysData + "could not enter into the webelement due to illegalAgrument");
		} catch (ElementNotInteractableException e) {
			System.out.println("the data" + sendkeysData
					+ "could not enter into the webelement due to not interactable due to element is not pointer or keyboad interactable");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
	}

	public void click(WebElement clickElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(clickElement));
			String text = clickElement.getText();
			clickElement.click();
			System.out.println("The Button " + text + "clicked sucessfully");
		} catch (StaleElementReferenceException e) {
			System.out.println("the element no longer appears on the DOM of the page.");
		} catch (ElementClickInterceptedException e) {
			System.out.println("the button was unable to click due to intersception");
		} catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}

	}

	
	public void frameByWebElement(WebElement frameElement) {
		try {
			driver.switchTo().frame(frameElement);
			System.out.println("currently switched to frame");
		} catch (NoSuchFrameException e) {
			System.out.println("No such frame found ");
		}catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
			}


	public void frameByName(String Name) {
		try {
			driver.switchTo().frame(Name);
			System.out.println("currently switched to frame");
		} catch (NoSuchFrameException e) {
			System.out.println("No such frame found ");
		}catch (WebDriverException e) {
			System.out.println("WebDriverException" + e + "occures please check the launchApplication method");
		}
		
	}

	@Override
	public void parentFrame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void defaultFrame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	@Override
	public String AlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void getTitle() {
		String title="";
		try {
			title = driver.getTitle();
			System.out.println("Login to the page"+title+"successfully");
		} catch (java.lang.NullPointerException e) {
			System.out.println("WebDriverException" + e + "occures ");		}
		
	}

}
