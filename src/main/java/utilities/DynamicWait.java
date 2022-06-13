package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverfactory.WebDriverFactory;

public class DynamicWait {

	private static final Logger logger = LoggerFactory.getLogger(DynamicWait.class);

	public static void visibilityOfElement(By locator) {

		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Waited for element to visible " + locator);

	}

	public static void waitForInvisiblityOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void waitForClick(By locator) {
		WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Waited for element to be clickable " + locator);
	}
	
	public static void waitUntil(int sec) {
		try {
			Thread.sleep(sec * 1000);
			logger.info("Waited for " + sec + " seconds");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
