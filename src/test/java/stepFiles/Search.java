package stepFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;
import pages.SearchResultPage;

import org.junit.Assert;

public class Search {
	WebDriver driver = DriverFactory.getDriver();
	JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
	private MainPage mainPage = new MainPage(DriverFactory.getDriver()); 
	private SearchResultPage searchResultPage = new SearchResultPage(DriverFactory.getDriver());

	

	@Given("Open browser in http:\\/\\/localhost:{int}\\/shows")
	public void open_browser_in_http_localhost_shows(Integer int1) {
		DriverFactory.getDriver().get("http://localhost:3000/shows"); // search for localhost webpage in browser
	}

	@Given("Enter a text in search box with text {string}")
	public void enter_a_text_in_search_box_with_text_batman(String searchTerm){
		mainPage.enterSearchTerm(searchTerm);
	}

	@Given("Press button search")
	public void press_button_search() {
		mainPage.pressSearchButton();
	}

	@Given("Navigate to the url that is show in second card of results")
	public void navigate_to_the_url_that_is_show_in_second_card_of_results(){
		searchResultPage.pressUrl(); // press on the second url button
	}

	@Given("Navigate back using browser features")
	public void navigate_back_using_browser_features() {
		DriverFactory.getDriver().navigate().back(); // use back/return browser functionality
	}

	@Given("Change css background color to #4a148c to card with title Batman Unlimited")
	public void change_css_background_color_to_4a148c_to_card_with_title_batman_unlimited() throws InterruptedException {
		js.executeScript("window.scrollBy(0,3000);"); // scroll page down 3000 pixels
		js.executeScript(
				"document.evaluate('/html/body/div/div[8]/div/div/div[1]',"
				+ " document).iterateNext().style.backgroundColor = '#4a148c';"); // change color of selected card
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Using this kind of wait is not recommended, but for color change demonstration purpose i will use it
		Thread.sleep(2000);
	}

	@When("Press back button")
	public void press_back_button() {
		searchResultPage.pressBackButton();
	}

	@Then("Make sure that input for search is empty")
	public void make_sure_that_input_for_search_is_empty() {
		Assert.assertEquals(true, mainPage.isSearchBoxEmpty());
		System.out.println("Is search text box empty? " + mainPage.isSearchBoxEmpty());
	}
}
