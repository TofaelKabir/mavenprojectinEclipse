package com.officeDepot.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.officeDepot.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/mohammadsharkar/eclipse-workspace/OfficeDepotTestAutomation/src/main/java/com"
					+ "/officeDepot/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/mohammadsharkar/Downloads/chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/mohammadsharkar/Downloads/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		
//		e_driver = new EventFiringWebDriver(driver);
//		// Now create object of EventListerHandler to register it with EventFiringWebDriver
//		eventListener = new WebEventListener();
//		e_driver.register(eventListener);
//		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	
		
//		driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td/font/b/a[3]")).click();
//		
//		//Thread.sleep(2000);
//		
//		Set<String> handler = driver.getWindowHandles();
//		
//		Iterator<String> it = handler.iterator();
//		
//		String parentWindowId = it.next();
//		System.out.println("parent window id:"+ parentWindowId);
//		
//		
//		String childWindowId = it.next();
//		System.out.println("Child window id:"+childWindowId);
//		
//		driver.switchTo().window(childWindowId);
//		
//		//Thread.sleep(2000);
//		
//		System.out.println("child window pop up title"+driver.getTitle());
//		
//		driver.close();
//		
//		driver.switchTo().window(parentWindowId);
//		
//		//Thread.sleep(2000);
//		
//		System.out.println("parent window title"+driver.getTitle());
		}
}
