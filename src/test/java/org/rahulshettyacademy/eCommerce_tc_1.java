package org.rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_1 extends AndroidBaseTest {

	@BeforeMethod
	public void preSetup()
	{
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			    "intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"
			   
			));
	}
	
	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
		String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}


	
	@Test
	public void FillForm_PositiveFlow() throws InterruptedException {
		driver.findElement(By.id("android:id/text1")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"))"));
		Thread.sleep(10);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
		
	}
	
}
