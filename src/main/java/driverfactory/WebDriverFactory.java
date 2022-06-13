

package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);

	// public WebDriver driver;

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the thread local driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver init_Driver(String browser) {
		System.out.println("Driver to initialize = " + browser);
		logger.info("Driver to initialize = " + browser);

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			logger.info("Chrome Browser has been set.");
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			tldriver.set(driver);
			logger.info("Firefox Browser has been set.");
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());
			logger.info("Microsoft Edge has been set.");
		} else {
			System.out.println("Please provide a valid browser name " + browser);
			logger.info("Please provide a valid browser name " + browser);

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();

		// This line is written By Sudip Debnath
		// getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/* Page load wait */
		// getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return getDriver();
	}

	/**
	 * This is used to get the driver using thread local
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}

}
