package test.ui.pagemodels;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.ui.pagemodels.utils.IGetElement;
import test.ui.pagemodels.utils.NoLocatorDefined;

public interface ILoginPage extends IGetElement{

//	First locator option
	static final String userId = "ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_txtUsername_txtInput";
	static final String passwordId = "ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_txtPassword_txtInput";
	static final String signUpId = "ctl00_ctl00_cphParent_ResponsiveQuickLinks_ResponsiveLogin_btnLogin";

//	Second locator option
	static final String userCss = null;
	static final String passwordCss = null;
	static final String signUpCss = null;
	
	static final String pageName = "Login Page";
	
	public default WebElement getUserField(WebDriver driver) throws NoLocatorDefined {	
		return getGenericElement(driver, userId, userCss, pageName);
	};
	
	public default WebElement getPasswordField(WebDriver driver) throws NoLocatorDefined {

		return getGenericElement(driver, passwordId, passwordCss, pageName);
	};
	
	public default WebElement getSignUpBtn(WebDriver driver) throws NoLocatorDefined {
		return getGenericElement(driver, signUpId, signUpCss, pageName);
	};
	
}
