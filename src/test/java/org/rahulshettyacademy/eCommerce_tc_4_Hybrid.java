package org.rahulshettyacademy;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.rahulshettyacademy.pageObjects.android.CartPage;
import org.rahulshettyacademy.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {
		
	//public void FillForm(String name, String gender, String country) throws InterruptedException {
	@Test(dataProvider = "getData", groups= {"Smoke"})
	public void FillForm(HashMap <String, String>input) throws InterruptedException {
		
		formPage.setNameField(input.get("name"));
		formPage.setGender(input.get("gender"));
		formPage.setCountrySelection(input.get("country"));
		
		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		double totalSum = cartPage.getProductSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplay();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsCondition();
		cartPage.submitOrder();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void resetApp() {
	    driver.terminateApp("com.androidsample.generalstore"); // or driver.resetApp();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchApp() {
	    driver.activateApp("com.androidsample.generalstore");
	}


//	@BeforeMethod(alwaysRun = true)
//	public void preSetup() {
//	    driver.context("NATIVE_APP");   // <— put the session back in native mode
//	    formPage.setActivity();
//	}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"Rahul Shetty","female","Argentina"},{"Dheeraj Kumar","male","Brazil"}};
//	
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\org\\rahulshettyacademy\\testData\\eCommerce.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
}


