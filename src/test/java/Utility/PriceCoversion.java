package Utility;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class PriceCoversion{
	Response response;
	public String priceCoversion(double amount, String symbol, String convert)
	{
		response = given().header("X-CMC_PRO_API_KEY", "71d3419d-9127-4d58-88c2-65fdcb31ee3e")
				.header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.header("Accept-Encoding", "deflate, gzip")
				.queryParam("amount", amount)
				.queryParam("symbol", symbol)
				.queryParam("convert", convert)
				.when().get("/v1/tools/price-conversion")
				.then().extract().response();
		String responseString=response.asString();
		JsonPath jsonPath = new JsonPath(responseString);
		String convertValue = convert;
		String t = "data."+"quote."+ convertValue +".price";
		String jsonString = jsonPath.getString(t);
		return jsonString;
	}
	public int getResponseCode()
	{
		int responseCode=response.getStatusCode();                   
		Assert.assertEquals(responseCode, 200);
		return responseCode;
	}
}
