package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.CoinMarketPage;
import Utility.Util;

public class UIStepDefinition {
	Util util;
	WebDriver driver; 
	CoinMarketPage coinMarketPage;
	private static Logger Log = Logger.getLogger(UIStepDefinition.class.getName());

	@Before
	public void setup() throws Throwable {
		util=new Util();
		System.setProperty("webdriver.chrome.driver",util.getChromePath()); 
		driver = new ChromeDriver();
		coinMarketPage=new CoinMarketPage(driver);
		DOMConfigurator.configure(util.getLog4jConfigure());
	}

	@Given("^User want to open the coinmarketcap url$")
	public void user_want_to_open_the_coinmarketcap_url() throws Throwable {
		Log.info("Execution of UIScenario Started");
		driver.get(util.getUrl());
		driver.manage().window().maximize();
	}

	@When("^User clicks on the element (\\d+)$")
	public void user_clicks_on_the_element(int arg1) throws Throwable {
		driver.navigate().refresh();
		coinMarketPage. selectValue();
	}

	@Then("^User capture the content of the page$")
	public void user_capture_the_content_of_the_page() throws Throwable {
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("scroll(0,1500)");
		List<WebElement> availableNameContent= coinMarketPage.availableNameContent();
		Log.info("Number of available names are: "+availableNameContent.size());
		Thread.sleep(3000);
		for(WebElement name:availableNameContent) { 
			String availableNameContentDetail=name.getText(); 
			Thread.sleep(3000);
			Log.info("Available names are :"+availableNameContentDetail); 
		} 
		List<WebElement> availablePriceContent= coinMarketPage.availablePriceContent();
		Log.info("Number of available prices are:"+availablePriceContent.size());
		for(WebElement price:availablePriceContent) { 
			Thread.sleep(2000);
			String availablePriceContentDetail=price.getText(); 
			Thread.sleep(3000);
			Log.info("Available prices are :"+availablePriceContentDetail); 
		}
	}

	@When("^User filter the Algoritham to POW$")
	public void user_filter_the_Algoritham_to_POW() throws Throwable {
		coinMarketPage.filtersToPow();
	}

	@When("^User clicks on ADDFilter$")
	public void user_clicks_on_ADDFilter() throws Throwable {
		coinMarketPage.addFilter();
	}

	@Then("^User Compare the page content with previous page content$")
	public void user_Compare_the_page_content_with_previous_page_content() throws Throwable {
		List<WebElement> filterNameContent= coinMarketPage.availableNameContent();
		Log.info("Number of Filter names are: "+filterNameContent.size());
		for(WebElement name:filterNameContent) {
			String filterNameContentDetail=name.getText();
			String availableNameContentDetail="Tether"; 
			if(filterNameContentDetail.contentEquals(availableNameContentDetail)) { 
				Log.info(filterNameContentDetail + " available from 20 row list");
			}
			else{
				Log.info(filterNameContentDetail+ " Does not available from the list of 20 rows");
			}
		}
		Log.info("Execution of UIScenario Stopped");
	}

	@After
	public void end() throws Exception{
		Thread.sleep(2000);
		driver.close();	
	}
}
