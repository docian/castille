package test.ui.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.ui.pagemodels.utils.IGetElement;
import test.ui.pagemodels.utils.NoLocatorDefined;

public interface ILandingPage extends IGetElement{
	
	//First locator option
	static final String myBalanceTextId = null;
	static final String myBalanceAmountId = null;

	//Second option
	static final String myBalanceTextCss = "#content > div > div > div > div > div > div.landingPageTopContainer > div.w-50.floatTheDiv > div";
	static final String myBalanceAmountCss = "#content > div > div > div > div > div > div.landingPageTopContainer > div.w-50.floatTheDiv > div > p > span > strong";

	static final String pageName = "Landing Page";
	
	public default WebElement getMyBalanceText(WebDriver driver) throws NoLocatorDefined {
		return getGenericElement(driver, myBalanceTextId, myBalanceTextCss, pageName);		
	}
	
	public default WebElement getMyBalanceAmount(WebDriver driver) throws NoLocatorDefined {
		return getGenericElement(driver, myBalanceAmountId, myBalanceAmountCss, pageName);
	}


}
