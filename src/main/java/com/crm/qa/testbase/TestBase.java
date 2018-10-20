package com.crm.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.UtilTest.UtilTest1;
import com.crm.qa.UtilTest.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;
public static EventFiringWebDriver edriver;
public static WebDriverEventListener eventListener;
	public TestBase() throws IOException
	{
		prop = new Properties();
		try {
			 ip = new FileInputStream("C://Users//admin//selenium-workspace//1.0//src//main"
			 							+"//java//com//crm//qa//env//config.properties");	
			 prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void Initilization()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C://Users//admin//selenium-workspace//200//driver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		edriver = new EventFiringWebDriver(driver);
		try {
			eventListener = new WebEventListner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		edriver.register(eventListener);
		
		driver=edriver;
			
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(7+0, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
	}

