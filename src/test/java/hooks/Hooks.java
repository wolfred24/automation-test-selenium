package hooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import util.ConfigReader;

public class Hooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		System.setProperty("webdriver.gecko.driver",
				"/home/cesar/workspace/CucumberFramework/src/test/java/Resources/geckodriver");
//		this.driver = new FirefoxDriver();
//		this.driver.manage().window().maximize();
//		this.driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//		this.driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
	}
	
	@Before(order = 1)
	public void gerProperty() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
	}

	@After(order = 0)
	public void quitBrowser(){
//		Thread.sleep(3000);
//		this.driver.manage().deleteAllCookies();
		driver.quit();
//		driver = null;
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()) {
			// Take screenshot
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath,"image/png", screenshotName);
		}
	}

}
