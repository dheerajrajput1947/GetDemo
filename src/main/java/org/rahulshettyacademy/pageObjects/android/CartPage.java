package org.rahulshettyacademy.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.rahulshettyacademy.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
AndroidDriver driver;
	
	public CartPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	    private List<WebElement> productList;

	    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	    private WebElement totalAmount;

	    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	    private WebElement terms;

	    @AndroidFindBy(id = "android:id/button1")
	    private WebElement acceptButton;

	    @AndroidFindBy(className = "android.widget.CheckBox")
	    private WebElement checkBox;

	    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	    private WebElement proceed;

	    // ---------- ACTIONS ----------
	    public List<WebElement>getProductList()
	    {
	    	return productList;
	    }
	    
	   public double getProductSum()
	   {
		   int count = productList.size();
		   double totalSum=0;
		   for(int i=0; i<count; i++)
		   {
			   String amountString = productList.get(i).getText();
			   Double price = getFormattedAmount(amountString);
			   totalSum = totalSum + price;
		   }
		   return totalSum;
	   }
	   
	   
	    public Double getTotalAmountDisplay()
	    {
	    	return getFormattedAmount(totalAmount.getText());
	    	
	    }
	    
	    public void acceptTermsCondition() {
	    	lognPressAction(terms);
	    	acceptButton.click();
	    }
	    
	    public void acceptTermsCondition1() {
	    	lognPressAction(terms);
	    	acceptButton.click();
	    }

	    
	    public Double getFormattedAmount(String amount)
	    {
	    	Double price = Double.parseDouble(amount.substring(1));
	    	return price;
	    }
	    
	    public void submitOrder()
	    {
	    	checkBox.click();
	    	proceed.click();
	    }
}
