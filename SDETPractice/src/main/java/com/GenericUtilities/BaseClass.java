package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.inventory.sales.objectrepository.HomePage;
import com.inventory.sales.objectrepository.LoginPage;

public class BaseClass {

	public DataBaseUtility dbutil = new DataBaseUtility();
	public ExcelUtility exutil = new ExcelUtility();
	public FileUtility fileutil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public WebdriverUtility webutil = new WebdriverUtility();
	
	public static WebDriver driver;
	
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void connectToDB() throws Throwable
	{
		dbutil.connectDB();
		Reporter.log("Connection Successfully Established", true);
	}
	
	//@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void openBrowser() throws Throwable
	{
		//String BROWSER = fileutil.readDataFromPropetyFile("browser");
		String BROWSER = System.getProperty("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			Reporter.log("--Invalid-Browser--");
			
		}
		sdriver = driver;
		webutil.maximizeWindow(driver);
		webutil.waitForPageLoad(driver, 10);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loginToApp() throws Throwable
	{
		//String URL = fileutil.readDataFromPropetyFile("url");
		String URL = System.getProperty("url");
		String Username = fileutil.readDataFromPropetyFile("username");
		String Password = fileutil.readDataFromPropetyFile("password");
	
		driver.get(URL);
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.loginToApp(Username, Password);
		webutil.confirmAlert(driver);
		Reporter.log("---Logged in to the app---", true);
	}
	
	@AfterMethod(alwaysRun = true)
	public void logoutFromApp() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAdminLogout();
		Reporter.log("---Logged out of the app---", true);
		Thread.sleep(3000);
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
		Reporter.log("---Browser is CLosed---", true);
	}
	
	@AfterSuite(alwaysRun = true)
	public void closeDB() throws Throwable
	{
		dbutil.closeDB();
		Reporter.log("---Database is CLosed---", true);
	}

}
