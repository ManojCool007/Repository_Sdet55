package Assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void Script1()
	{
		String exptData = "Sales And Inventory";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String actData = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertSame(actData, exptData);
		System.out.println(actData);
		driver.quit();
		sa.assertAll();
	}
	
	@Test
	public void Script2()
	{
		String exptData = "Sales";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		String actData = driver.getTitle();
		SoftAssert sa = new SoftAssert();
		sa.assertNotSame(actData, exptData);
		System.out.println(actData);
		driver.quit();
		sa.assertAll();
	}
}
