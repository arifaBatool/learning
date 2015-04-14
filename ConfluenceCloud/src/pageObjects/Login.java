package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {

	private static WebDriver loginDriver = null;

	public Login(WebDriver driver) {
		Login.setLoginDriver(driver);
	}
	
	//Login to Confluence As Valid User
	public Dashboard LoginAsValidUser()
	{
		getLoginDriver().findElement(By.id("username")).sendKeys("aari309");
		getLoginDriver().findElement(By.id("password")).sendKeys("click12345");
		getLoginDriver().findElement(By.id("login")).click();
		return new Dashboard (loginDriver);
	}

	//Getter - LoginDriver
	public static WebDriver getLoginDriver() {
		return loginDriver;
	}
	
	//Setter - LoginDriver
	public static void setLoginDriver(WebDriver loginDriver) {
		Login.loginDriver = loginDriver;
	}
	
}
