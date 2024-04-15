package Assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void script()
	{
		String exptData = "Sales And nventory";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String actData = driver.getTitle();
		assertEquals(exptData, actData);
		System.out.println(actData);
		driver.quit();
	}
	
	@Test
	public void script2()
	{
		String exptData = "Sales And nventory";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String actData = driver.getTitle();
		assertNotEquals(exptData, actData);
		System.out.println(actData);
		driver.quit();
	}
	
	@Test
	public void script3()
	{
		int a=10;
		assertNull(a);
		System.out.println(a);
	}
	
	@Test
	public void script4()
	{
		int a=10;
		assertNotNull(a);
		System.out.println(a);
	}
	
	@Test
	public void script5()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		boolean user = driver.findElement(By.name("user")).isEnabled();
		assertTrue(user);
		driver.quit();
	}
	
	@Test
	public void script6()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		boolean user = driver.findElement(By.name("user")).isEnabled();
		assertFalse(user);
		driver.quit();
	}
}
