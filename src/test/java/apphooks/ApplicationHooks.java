package apphooks;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverfactory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;

public class ApplicationHooks {

	private WebDriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void setConfig() {
		configReader = new ConfigReader();
		prop = configReader.setPropertiesFile("config");
	}

	@Before(order = 1)
	public void setUpBrowser() {
		String browserName = configReader.getPropertiesValue("browser");
		System.out.println("Browser Value == " + browserName);
		driverFactory = new WebDriverFactory();
		driver = driverFactory.init_Driver(browserName);
		WebDriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
	
}
