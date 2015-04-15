package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageCreate {
	private static WebElement element = null;
	private static WebDriver driver;
	
	public PageCreate (WebDriver loginDriver){
		PageCreate.setDriver(loginDriver);
	}
	
	private static void setDriver(WebDriver loginDriver) {
		PageCreate.driver = loginDriver;
		// TODO Auto-generated method stub
		
	}
	
	//Enter page date like title and content body.
	public static Dashboard CreatePageContent(String title){
		getDriver().findElement(By.id("content-title")).sendKeys(title);
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		element = driver.findElement(By.id("tinymce"));
		element.sendKeys("test blah blah");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"rte-button-publish\"]")).click();
		return new Dashboard(driver);
	}
	
	//This method checks if the element was present on the page
	public boolean isElementPresent (){
		 try {
			 getDriver().findElement(By.id("content-metadata-page-restrictions"));
		  return true;
		 }
		 catch (NoSuchElementException e) {
			 return false; 
			 }
	  }
	
	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	//Returns pageTitle
	public String getPageTitle() {
		String str = getDriver().getTitle();
		return str;
	}
}
