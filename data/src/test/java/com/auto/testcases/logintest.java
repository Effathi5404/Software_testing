package com.auto.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.auto.base.testbase;

public class logintest extends testbase {
	
	 @Test
	 public void loginmanager() throws InterruptedException {
		 
		 
		 driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		 Thread.sleep(3000);
	 }
	
	
	

}
