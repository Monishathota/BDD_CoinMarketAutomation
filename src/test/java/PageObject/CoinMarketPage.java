package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	By  selectValue = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]");
	By selectPow = By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]");
	By nameContent= By.xpath("//p[contains(text(),'Name')]//following::p[@class='sc-e225a64a-0 ePTNty']");
	By priceContent = By.xpath("//p[contains(text(),'Price')]//following::div[@class='sc-8bda0120-0 dskdZn']");

	public void filtersToPow() throws InterruptedException
	{
		driver.findElement(filters).click();
		Thread.sleep(2000);
		driver.findElement(algorithm).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		Thread.sleep(2000);
		WebElement element=driver.findElement(selectPow);
		act.moveToElement(element).click().build().perform();
		Thread.sleep(2000);
		driver.findElement(pow).click();
		Thread.sleep(2000);
	}


	public void addFilter() throws InterruptedException
	{
		driver.findElement(addFilter).click();
		driver.findElement(mineable).click();
		Thread.sleep(2000);
		driver.findElement(allCryptoCurrencies).click();
		driver.findElement(coins).click();
		driver.findElement(price).click();
		driver.findElement(priceRangeFrom).sendKeys("100");
		driver.findElement(priceRangeTo).sendKeys("10000");
		driver.findElement(applyFilter).click();
		Thread.sleep(2000);
		driver.findElement(showResults).click();
	}

	public void selectValue() 
	{
		WebElement element=driver.findElement( selectValue);
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
		driver.findElement(value).click();
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
