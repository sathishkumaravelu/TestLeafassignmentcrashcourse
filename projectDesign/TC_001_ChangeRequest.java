package finalProject;

import org.openqa.selenium.WebElement;

import projectDesign.ImplementationClass;

public class TC_001_ChangeRequest extends ImplementationClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC_001_ChangeRequest obj = new TC_001_ChangeRequest();
			obj.StartNow();
	}

	public void StartNow() {
		
		launchApplication("Chrome","https://dev57671.service-now.com/");
		getTitle();
		WebElement frameElement = locateElementID("gsft_main");
		frameByWebElement(frameElement);
		WebElement userNameEle = locateElementID("user_name");
		enterData(userNameEle, "admin");
		WebElement passwordEle = locateElementID("user_password");
		enterData(passwordEle, "Guna@1994");
		click(locateElementID("sysverb_login"));
		
	}
}
