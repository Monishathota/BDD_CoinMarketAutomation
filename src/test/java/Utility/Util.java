package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Util {

	Properties properties;

	public  Util() throws Exception
	{
		File sourceFile=new File("src\\test\\resources\\Property\\PropertyFile.property");
		FileInputStream fileInputStream=new FileInputStream(sourceFile);
		properties=new Properties();
		properties.load(fileInputStream);
	}

	public String getChromePath()
	{
		return properties.getProperty("ChromeDriver");
	}

	public String getUrl()
	{
		return properties.getProperty("URL");
	}

	public String getLog4jConfigure()
	{
		return properties.getProperty("Log4jConfigure");
	}

	public String guatemalanQuetzal()
	{
		return properties.getProperty("GuatemalanQuetzal");
	}

	public String britishPound()
	{
		return properties.getProperty("BritishPound");
	}

	public String dogeCoin()
	{
		return properties.getProperty("DogeCoin");
	}

	public String getUri()
	{
		return properties.getProperty("URI");
	}

	public double amount()
	{
		String amount=properties.getProperty("Amount");
		double doubleValue=Double.parseDouble(amount);
		return doubleValue;
	}
}
