package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {
	private WebDriver driver;
	
	// change this to return all url buttons
	private By urlsLinksXpath = By.xpath("//div[contains(@class, 'row')][2]/div/div/div[2]/a");
	private By buttonBackXpath = By.xpath("//body/div/a");
	
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pressUrl() {
		// change this to select one url to click
		driver.findElement(urlsLinksXpath).click();
	}
	
	public void pressBackButton() {
		// change this to select one url to click
		WebElement buttonBack = driver.findElement(buttonBackXpath);
		buttonBack.click();
	}
	
}
