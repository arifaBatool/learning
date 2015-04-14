package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import pageObjects.Dashboard;
import pageObjects.Login;
import pageObjects.PageCreate;



public class TestCases {
	private static WebDriver driver = null;
	private String pt = "";
	
	//Run thsi method before testsuite
	@BeforeSuite
	public void SetUpBrowserInsatcne(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://QAexercise.atlassian.net");
		driver.manage().deleteAllCookies();
		pt = GetPageTitle();
	}
	
	//This function returns randomly generated page title.
	public String GetPageTitle(){
		Random rn = new Random(); 
		int randNum = rn.nextInt(25) + 200;
		String pageTitle = null;
		pageTitle = "Technical Exercises for QA " + randNum;
		return pageTitle;
	}
	
	//This method validates if you are  logged in successfully
	@Test (priority = 0)
	public void LoginToConfluence() {
		Login lp = new Login(driver);
	    Dashboard db = lp.LoginAsValidUser();
	    Assert.assertEquals(db.getPageTitle(), "Dashboard - Confluence");
		}
	
	//This test method validates if you have opened new page template
	@Test (priority = 1)
	public void OpenNewPage(){
		PageCreate pc = Dashboard.CreateNewPage();
		Assert.assertTrue(pc.getPageTitle().contains("Add Page"), "Assertion Failed");
	}

	//This test method validates if you have created a new page successfully
	@Test (priority = 2)
	public void PageContent(){
		PageCreate pageC = new PageCreate(driver);
		PageCreate.CreatePageContent(pt);
		Assert.assertTrue(pageC.getPageTitle().contains(pt), "Assertion Failed");
	}
	
	//This method validates if you are able to apply page restrictions.
	@Test (priority = 3)
	public void AddRestrictionsToPage(){
		PageCreate pageCreate = Dashboard.AddPageRestriction(pt);
		//Assert.assertTrue(pageCreate.isElementPresent());
		Assert.assertTrue(pageCreate.isElementPresent(), "Assertion failed");
				}
	
	
	@AfterSuite
	public void afterMethod() {
		//driver.quit();
  }
}
