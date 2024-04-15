package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticeNG {

	@Test
	public void execute()
	{
		System.out.println("Execute First");
	}
	
	@Test
	public void execute_Again()
	{
		System.out.println("Execute again");
	}
	
	@BeforeSuite
	public void connectDB()
	{
		System.out.println("Connect DB");
	}
	
	@BeforeSuite
	public void connectDB2()
	{
		System.out.println("Connect DB2");
	}
	
	@AfterSuite
	public void closeDB()
	{
		System.out.println("close DB");
	}
	
	@AfterSuite
	public void closeDB2()
	{
		System.out.println("close DB2");
	}
	
	@BeforeMethod
	public void launchBrowser()
	{
		System.out.println("Browser Launched");
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		System.out.println("Browser closed");
	}
	
}
