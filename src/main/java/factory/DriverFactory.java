package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the ThreadLocal driver on the basis of given browser
	 * @param browser
	 * @return
	 */

	public WebDriver init_driver(String browser) {
		System.out.println("Browser values is: " + browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("safari")) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass a valid Browser value at config.propierties.\n "
					+ "Current value: broser = " + browser + 
					"\nValid values: chrome, firefox or safari");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	/** 
	 * This is used to get the driver with Thread local
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
}
