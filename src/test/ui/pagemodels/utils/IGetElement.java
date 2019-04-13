package test.ui.pagemodels.utils;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface IGetElement {

	public default WebElement getGenericElement(WebDriver driver, String idLoc, String cssLoc, String pageName) throws NoLocatorDefined {
		List<WebElement> users = null;
		if(idLoc != null) {
			users = driver.findElements(By.id(idLoc));
		} else if(cssLoc != null) {
			users = driver.findElements(By.cssSelector(cssLoc));
		}
		if(users == null) throw new NoLocatorDefined("no locator in "+pageName);
		if(users.isEmpty()) throw new NoSuchElementException("no locator defined for "+pageName);
		return users.get(0);
	}
}
