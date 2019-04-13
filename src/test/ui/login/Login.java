package test.ui.login;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.ui.pagemodels.ILandingPage;
import test.ui.pagemodels.ILoginPage;
import test.ui.pagemodels.utils.NoLocatorDefined;

public class Login implements ILoginPage, ILandingPage{
	private WebDriver driver;

	
	@Parameters({"url"})
	@BeforeClass
	public void setup(String url) {
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get(url);
	}
	
	@Parameters({"user","password","landingPageUrl"})
	@Test(priority=1)
	public void login(String user, String password, String landingPageUrl) {	
		try {
			getUserField(driver).sendKeys(user);
			getPasswordField(driver).sendKeys(password);
			getSignUpBtn(driver).click();
		} catch (NoLocatorDefined e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(landingPageUrl,driver.getCurrentUrl());
	}
	
	@Parameters({"expectedText"})
	@Test(priority=2)
	public void testTextBalance(String expectedText) {
		try {
			assertTrue(getMyBalanceText(driver).getText().contains(expectedText));
		} catch (NoLocatorDefined e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=3)
	public void testAmount() {
		try {
			assertTrue(getMyBalanceAmount(driver).getText().substring(1).matches("\\d\\d\\.\\d\\d"));
		} catch (NoLocatorDefined e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
