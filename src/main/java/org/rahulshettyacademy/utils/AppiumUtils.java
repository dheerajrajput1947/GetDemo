package org.rahulshettyacademy.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import com.fasterxml.jackson.core.type.TypeReference;


public abstract class AppiumUtils {
	
	public AppiumDriverLocalService service;
	
//	AndroidDriver driver;
//	public AppiumUtils(AndroidDriver driver)
//	{
//		this.driver =driver;
//	}
	

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
		
		//convert JSON file content to JSON String.
		//System.getProperty("user.dir")+"\\src\\test\\java\\org\\rahulshettyacademy\\testData\\eCommerce.json"
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
		}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress, int port)
	{
		service = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C:\\Users\\admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				       .withIPAddress(ipAddress).usingPort(port).build(); //.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		return service;
	}
	
	
	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void waitForElementToAppear(WebElement ele, AppiumDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(
				ele, "text", "Cart"));
	}
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
