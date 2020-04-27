/**
 * 
 */
package projectDesign;

import org.openqa.selenium.WebElement;

/**
 * @author sathish - Tester 
 *
 */

public interface ProjectInterfaceDesign {

	
	/**
	 * LaunchApplication method used to launch for the specific browser as user shared and 
	 * @param browserName - browser need to execute
	 * @param Url - application end point that need to execute
	 */
	public void launchApplication(String browserName, String Url);
	
	
	/**
	 * This method is used to find the webelement 
	 * which will store in webelement and return
	 * @param locator - type of locator u want to access from the DOM
	 * @param LocatorValue - value for the specific locator 
	 * @return - WebElement
	 */
	public  WebElement locateElementBy(String locator, String LocatorValue);
	
	
	/**
	 * This method is used to find the webelement using ID
	 * @param ID - value of the locator using id 
	 * @return - it returns the WebElement 
	 */
	public WebElement locateElementID(String ID);
	
	/**
	 * This method is used to find the webelement using ID
	 * @param XPath - value of the locator using XPath
	 * @return - it returns the WebElement 
	 */	
	
	public WebElement locateElementXPath(String XPath);
	
/*	
	public WebElement locateElementsIdByIndex(String ID);
	public WebElement locateElementsIdByIndexFirst(String ID);	
	public WebElement locateElementsIdByIndexLast(String ID);


	public WebElement locateElementsXPathByIndex(String XPath);
	public WebElement locateElementsXPathByIndexFirst(String XPath);	
	public WebElement locateElementsXPathByIndexLast(String XPath);
	
*/	
	

	/**
	 * This Method is used to enter the data in a WebElement
	 * @param inputElement - element in which data need to be entered
	 * @param sendkeysData - User input for the field
	 * 
	 */
	public void enterData(WebElement inputElement,String sendkeysData);
	
	/**
	 * This Method is used to click the WebElement
	 * @param clickElement - element in which click action need to be performed
	 * 
	 */
	public void click(WebElement clickElement);
	
	/**
	 * This  method is used to siwth to a specific frame by using the WebElement
	 * @param frameElement
	 */
	public void frameByWebElement(WebElement frameElement);
	public void frameByName(String Name);	
	public void parentFrame();
	public void defaultFrame();
	
	public void alert();
	public void acceptAlert();
	public void dismissAlert();
	public String AlertText();
	
	public void getTitle();
	
	public String getText(WebElement ele);
	
}
