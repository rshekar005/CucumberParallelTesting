package com.base;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private static WebDriver driver;
	public static ThreadLocal<WebDriver> dr= new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver(){
		return dr.get();
	}
	
	public static void setWebdriver(){
		dr.set(driver);
	}
	
	protected static void startWebdriver(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		setWebdriver();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
	}
	
	protected static void enterUrl(String url)
	{
		getDriver().get(url);
	}
	
	protected static void stopWebDriver()
	{
		getDriver().close();
	}
	
	

}
