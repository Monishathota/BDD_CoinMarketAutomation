package PageObject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
public class CoinMarketPage {
	WebDriver driver;
	public CoinMarketPage(WebDriver driver) 
	{ 
		this.driver=driver; 
	}

	By value = By.xpath("//button[contains(text(),'20')]");
	By filters = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[2]/button[1]");
	By algorithm = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]");
	By pow = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]");
	By addFilter = By.xpath("//button[text()='Add Filter']");
	By mineable = By.xpath("//label[@id='mineable']");
	By allCryptoCurrencies = By.xpath("//button[text()='All Cryptocurrencies']");
	By coins = By.xpath("//button[text()='Coins']");
	By price = By.xpath("//button[text()='Price']");
	By priceRangeFrom = By.xpath("//*[@class='cmc-input-row']//input[1]");
	By priceRangeTo = By.xpath("//*[@class='cmc-input-row']//input[2]");
	By applyFilter = By.xpath("//button[text()='Apply Filter']");
	By showResults = By.xpath("//button[text()='Show results']");
	By selectValue = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]");
	By selectPow = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]");
	By nameContent= By.xpath("//p[contains(text(),'Name')]//following::p[@class='sc-e225a64a-0 ePTNty']");
	By priceContent = By.xpath("//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']");

	public void filtersToPow() throws InterruptedException
	{	
		
		driver.findElement(filters).click();
		driver.findElement(algorithm).click();
		Actions act=new Actions(driver);
		WebElement element=driver.findElement(selectPow);
		act.moveToElement(element).click().build().perform();
		driver.findElement(pow).click();
	}

	public void addFilter() throws InterruptedException
	{	
		driver.findElement(addFilter).click();
		driver.findElement(mineable).click();
		Thread.sleep(2000);
		driver.findElement(allCryptoCurrencies).click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(coins).click();
		driver.findElement(price).click();
		driver.findElement(priceRangeFrom).sendKeys("100");
		driver.findElement(priceRangeTo).sendKeys("10000");
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.findElement(applyFilter).click();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.findElement(showResults).click();
		Thread.sleep(2000);
	}

	public void selectValue() 
	{		
		WebElement valueElement=driver.findElement(value);
		String Actual= valueElement.getText();
		valueElement.click();	
		Assertion softAssert=new SoftAssert();
		softAssert.assertEquals(Actual, "20","element not selected");
	}
	public void controlOnRow()
	{
		WebElement element=driver.findElement(selectValue);
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
	}

	public List<WebElement> availableNameContent()
	{
		List<WebElement> nameContentElement=driver.findElements(nameContent);
		return nameContentElement;
	}
	

	public List<WebElement> availablePriceContent()
	{
		List<WebElement> priceContentElement=driver.findElements(priceContent);
		return priceContentElement;
	}
	
	
}
