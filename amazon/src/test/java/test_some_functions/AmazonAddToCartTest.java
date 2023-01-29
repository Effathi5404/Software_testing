package test_some_functions;

import org.junit.Test;
import org.openqa.selenium.By;

public class AmazonAddToCartTest extends  AmazonSearchTest {

	
	
	@Test
    public void testAddToCart() {
        // Configure the web driver
        

        // Locate the search bar and enter a search term
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("product name");

        // Locate the search button and click it
        driver.findElement(By.xpath("//input[@value='Go']")).click();

        // Locate the add to cart button and click it
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();

        // Locate the cart button and click it
        driver.findElement(By.xpath("//a[@id='nav-cart']")).click();

        // Locate the product name in the cart and get its text
        String productName = driver.findElement(By.xpath("//a[@class='a-link-normal sc-product-title a-text-normal']")).getText();

        // Assert that the product name in the cart is the expected product
        softAssert.assertEquals(productName, "product name", "Product name in cart is not the expected product.");
        softAssert.assertAll();
    }
}





