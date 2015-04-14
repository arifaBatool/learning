package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
	
	private static WebDriver driver;

  public Dashboard(WebDriver loginDriver) {
	  Dashboard.setDriver(loginDriver);
	}
  
  public static PageCreate CreateNewPage()
  {
	  getDriver().findElement(By.id("create-page-button")).click();
	  getDriver().findElement(By.xpath("//*[@id=\"create-dialog\"]/div/div[1]/div/div[2]/div[2]/div[2]/ol/li[1]")).click();
	  getDriver().findElement(By.xpath("//*[@id=\"create-dialog\"]/div/div[2]/button")).click();
	return new PageCreate(driver);
	  }

  public static PageCreate AddPageRestriction(String title){
	  driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img")).click();
	  driver.findElement(By.linkText("All Updates")).click();
	  driver.findElement(By.linkText(title)).click();
	  driver.findElement(By.id("editPageLink")).click();
	  driver.findElement(By.id("rte-button-restrictions")).click();
	  driver.findElement(By.id("page-permissions-choose-me")).click();
	  driver.findElement(By.id("restrictEditRadio")).click();
	  driver.findElement(By.id("page-permissions-choose-me")).click();
	  driver.findElement(By.id("remove-permission-0"));
	  driver.findElement(By.xpath("//*[@id=\"update-page-restrictions-dialog\"]/div/div[2]/button")).click();
	  driver.findElement(By.cssSelector("#rte-button-publish > span")).click();
	return new PageCreate(driver);
	  }
  
  
public static WebDriver getDriver() {
	return driver;
}

public static void setDriver(WebDriver driver) {
	Dashboard.driver = driver;
}
//returns the page title 
public String getPageTitle() {
	String str = getDriver().getTitle();
	return str;
}

}
