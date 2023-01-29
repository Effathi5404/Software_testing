package com.auto.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testbase {
	
	
	

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		
		
		
		if (driver == null) {
			
			
			
			//fis = new FileInputStream(System.getProperty("C:\\new\\data\\src\\test\\resources\\properties\\config.property"));
		    fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.property");
			config.load(fis);
			//fis = new FileInputStream(System.getProperty("C:\\new\\data\\src\\test\\resources\\properties\\or.property"));
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.property");
			OR.load(fis);

		}
		
		if (config.getProperty("browser").equals("chrome")) {

			// System.setProperty("webdriver.gecko.driver", "gecko.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.get(config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			
			

		}
		
		@AfterSuite
		public void tearDown() {

			if (driver != null) {
				driver.quit();
			}

		
	}
	



}
