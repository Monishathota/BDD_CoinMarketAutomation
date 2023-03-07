package StepDefinitions;

import org.apache.log4j.Logger;

import org.apache.log4j.xml.DOMConfigurator;

import Utility.PriceCoversion;
import Utility.Util;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class APIStepDefination {

	Util util;
	private static Logger Log = Logger.getLogger(APIStepDefination.class.getName());
	String firstConversion;
	PriceCoversion priceCoversion;

	@Before
	public void setup() throws Exception{
		util=new Util();
		priceCoversion = new PriceCoversion();
		DOMConfigurator.configure(util.getLog4jConfigure());
	}

	@Given("^User wants the base URI$")
	public void user_wants_the_base_URI() throws Throwable {
		Log.info("Execution of ApiScenario Started");
		RestAssured.baseURI = util.getUri();
	}

	@When("^User convert the price of Guatemalan Quetzal to British Pound$")
	public void User_convert_the_price_of_Guatemalan_Quetzal_to_British_Pound() throws Throwable {
		double amountValue =util.amount();
		firstConversion = priceCoversion.priceCoversion(amountValue,util.guatemalanQuetzal(),util.britishPound());
		Log.info( "GTQ to GBP = " + firstConversion);	
	}
	@Then("^User convert Received British Pound to doge coin$")
	public void user_convert_Received_British_Pound_to_doge_coin() throws Throwable
	{
		double amountValue  = Double.parseDouble(firstConversion);
		String finalConversion = priceCoversion.priceCoversion(amountValue,util.britishPound(),util.dogeCoin());
		Log.info("GBP to DOGE = " +finalConversion);
	}

	
	@Then("^User validated the status code$")
	public void user_validated_the_status_code() throws Throwable {
		int code=priceCoversion.getResponseCode();
		Log.info("Response code value is " +code);
		Log.info("Execution of APIScenario Stopped");
	}
}
