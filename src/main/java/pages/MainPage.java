package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	private WebDriver driver;
	
	private By searchBoxXpath = By.xpath("//input[contains(@name, 'search')]");
	private By searchButtonXpath = By.xpath("//button[contains(text(), 'Search')]");
	
//	private WebElement searchBox = driver.findElement(searchBoxXpath);
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void pressSearchButton() {
		driver.findElement(searchButtonXpath).click();
	}
	
	public void enterSearchTerm(String searchTerm) {
		driver.findElement(searchBoxXpath).sendKeys(searchTerm);
//		searchBox.sendKeys(searchTerm);
	}
	
	public boolean isSearchBoxEmpty() {
//		return searchBox.getText().equals("");
		return driver.findElement(searchBoxXpath).getText().equals("");
	}
}
