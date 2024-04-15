package User;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TransactionTest {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("User_name");
		String PWD = prop.getProperty("pass");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.get(Url);
		driver.findElement(By.name("user")).sendKeys(UN);
		driver.findElement(By.name("password")).sendKeys(PWD);
		driver.findElement(By.name("btnlogin")).click();
		Alert alt = driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.linkText("Others")).click();
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet5");
		String quantity = sh.getRow(0).getCell(1).getStringCellValue();
		WebElement quan = driver.findElement(By.xpath("//h6[text()='octane']/following-sibling::input[@name='quantity']"));
		quan.clear();
		quan.sendKeys(quantity);
		driver.findElement(By.xpath("//h6[text()='octane']/following-sibling::input[@name='addpos']")).click();
		String cust_name = sh.getRow(1).getCell(1).getStringCellValue();
		WebElement cust = driver.findElement(By.xpath("//option[text()='Select Customer']/.."));
		Select sel=new Select(cust);
		sel.selectByVisibleText(cust_name);
		driver.findElement(By.xpath("//button[text()='SUBMIT']")).click();
		Thread.sleep(5000);
		WebElement total = driver.findElement(By.xpath("//h5[text()='SUMMARY']/../following-sibling::div/div/div/h3[contains(text(),'GRAND TOTAL')]/following-sibling::h3"));
		String final_total = total.getText();
		driver.findElement(By.id("txtNumber")).sendKeys(final_total);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='PROCEED TO PAYMENT']")).click();
		Alert alt1 = driver.switchTo().alert();
		alt1.accept();
		driver.findElement(By.id("userDropdown")).click();
		driver.findElement(By.xpath("(//a[@data-toggle='modal'])[2]")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
