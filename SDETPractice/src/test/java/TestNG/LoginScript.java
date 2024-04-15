package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.inventory.sales.objectrepository.LoginPage;

public class LoginScript {

	@Test(dataProviderClass = Logincred.class, dataProvider = "Login_cred")
	public void getcred(String username, String password)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApp(username, password);
	}
}
