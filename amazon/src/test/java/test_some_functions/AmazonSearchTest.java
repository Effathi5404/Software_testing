package test_some_functions;

import java.time.Duration;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest {

	
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    
    @BeforeMethod
	   public void setup() {
    	  WebDriverManager.chromedriver().setup();
		    driver= new ChromeDriver();;
		   driver.get("https://www.amazon.in/");
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   }

    @Test
    public void testSearch() {
       

        // Locate the search bar and enter a search term
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("The Power of Your Subconscious Mind");

        // Locate the search button and click it
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        // Locate the first search result and get its text
        String firstResult = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText();

        // Assert that the first search result contains the expected text
        softAssert.assertTrue(firstResult.contains("Subconscious Mind"), "Search result did not contain the expected text.");
        
        softAssert.assertAll();
    }
    @AfterMethod
    public void teardown() {
 	   
 	   
 	  driver.quit(); 
 	   
 	   
    }

}
	
	

