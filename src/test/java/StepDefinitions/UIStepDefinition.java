package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
	@Given("^User opens the coinmarketcap application$")
	public void user_opens_the_coinmarketcap_application() throws Throwable {
		Log.info("Execution of UIScenario Started");
		driver.get(util.getUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		util.captureScreenshot(driver, "user_opens_the_coinmarketcap_application");
	}
	@When("^User selects (\\d+) rows$")
	public void user_selects_rows(int arg1) throws Throwable {
		driver.navigate().refresh();
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("scroll(0,200)");
		coinMarketPage.controlOnRow();
		coinMarketPage. selectValue();
		util.captureScreenshot(driver, "user_selects_rows");
	}
	@Then("^User capture the content of the page$")
	public void user_capture_the_content_of_the_page() throws Throwable 
	{
		JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
		javascriptExecutor.executeScript("scroll(0,1000)");
		List<WebElement> availableNameContent= coinMarketPage.availableNameContent();
		Log.info("Number of available names are: "+availableNameContent.size());
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);

		for(WebElement name:availableNameContent) { 
			String availableNameContentDetail=name.getText(); 
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			Log.info("Available names are :"+availableNameContentDetail); 
		} 

		List<WebElement> availablePriceContent= coinMarketPage.availablePriceContent();
		Log.info("Number of available prices are:"+availablePriceContent.size());
		for(WebElement price:availablePriceContent) { 
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			String availablePriceContentDetail=price.getText(); 
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			Log.info("Available prices are :"+availablePriceContentDetail); 
		}
	}
	@When("^User applies filter on Algorithm as PoW$")
	public void user_applies_filter_on_Algorithm_as_PoW() throws Throwable {
		coinMarketPage.filtersToPow();
	}
	@When("^User clicks on ADDFilter$")
	public void user_clicks_on_ADDFilter() throws Throwable {
		coinMarketPage.addFilter();
	}
	@Then("^User compares the filtered page content with previously captured page content$")
	public void user_compares_the_filtered_page_content_with_previously_captured_page_content() throws Throwable {

		List<WebElement> filterNameContent= coinMarketPage.availableNameContent();
		Log.info("Number of Filter names are: "+filterNameContent.size());
		for(WebElement name:filterNameContent) {
			String filterNameContentDetail=name.getText();
			String availableNameContentDetail="Tether"; 

			if(filterNameContentDetail.contentEquals(availableNameContentDetail)) 
			{ 
				Log.info(filterNameContentDetail + " available from 20 row list");
			}
			else
			{
				Log.info(filterNameContentDetail+ " Does not available from the list of 20 rows");
			}
		}
		Log.info("Execution of UIScenario Stopped");
	}
	@After
	public void end() throws Exception{
		driver.close();
	}


}
