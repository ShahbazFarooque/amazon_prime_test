package pageComponent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driverfactory.WebDriverFactory;
import utilities.DynamicWait;
import utilities.LocatorSelector;

public class AmazonPrimeComponent {
	
	public void clickOnButton(String locatorName) {
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.waitForClick(locator);
		WebDriverFactory.getDriver().findElement(locator).click();
		//DynamicWait.waitUntil(5);
	}
	
	public void hoverAndClick(String locatorName) {
		By locator = LocatorSelector.select(locatorName);
		Actions action = new Actions(WebDriverFactory.getDriver());
		action.moveToElement(WebDriverFactory.getDriver().findElement(locator)).click().build().perform();
	}
	
	public void sendValueToTextbox(String locatorName, String value) {
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.waitForClick(locator);
		WebDriverFactory.getDriver().findElement(locator).clear();
		WebDriverFactory.getDriver().findElement(locator).sendKeys(value);
	}
	
	public void userDoLogin(String emailLocator, String emailId, String pwdLocator, String pwd, String signInButton) {
		sendValueToTextbox(emailLocator, emailId);
		sendValueToTextbox(pwdLocator, pwd);
		clickOnButton(signInButton);
	}
	
	public String getTextFromElement(String locatorName) {
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.visibilityOfElement(locator);
		String text = WebDriverFactory.getDriver().findElement(locator).getText();
		System.out.println("Text From Element ----------- "+text);
		return text;
	}
	
	public boolean getTextFromElement(String locatorName, String movieName) {
		boolean status = false;
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.visibilityOfElement(locator);
		List<WebElement> allMoviesName = WebDriverFactory.getDriver().findElements(locator);
		for(WebElement element : allMoviesName) {
			if (element.getText().equals(movieName)) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	public void searchAndClick(String locatorName, String movieName) {
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.visibilityOfElement(locator);
		List<WebElement> allMoviesName = WebDriverFactory.getDriver().findElements(locator);
		for(WebElement element : allMoviesName) {
			if (element.getText().equals(movieName)) {
				element.click();
				By locatorMovie = LocatorSelector.select("movie_img");
				DynamicWait.waitForClick(locatorMovie);
				WebDriverFactory.getDriver().findElement(locatorMovie).click();
				break;
			}
		}
	}
	
	public void pressEnter(String locatorName) {
		By locator = LocatorSelector.select(locatorName);
		DynamicWait.waitForClick(locator);
		WebDriverFactory.getDriver().findElement(locator).sendKeys(Keys.ENTER);
	}
	
	public void scrollUntilVisibleElement(String locatorName) {
		By locator = LocatorSelector.select(locatorName);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) WebDriverFactory.getDriver();
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", WebDriverFactory.getDriver().findElement(locator));
	}
	
}
