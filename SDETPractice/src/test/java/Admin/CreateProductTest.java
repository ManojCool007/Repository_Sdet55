package Admin;

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

public class CreateProductTest {
	public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String UN = prop.getProperty("username");
		String PWD = prop.getProperty("password");
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
		driver.findElement(By.xpath("//span[text()='Product']")).click();
		driver.findElement(By.xpath("//h4[contains(text(),'Product')]/a")).click();
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Sheet3");
		String P_Code = sh.getRow(0).getCell(1).getStringCellValue();
		String name = sh.getRow(1).getCell(1).getStringCellValue();
		String desc = sh.getRow(2).getCell(1).getStringCellValue();
		String quantity = sh.getRow(3).getCell(1).getStringCellValue();
		String onhand = sh.getRow(4).getCell(1).toString();
		String price = sh.getRow(5).getCell(1).getStringCellValue();
		String sel_cat = sh.getRow(6).getCell(1).toString();
		String sel_sup = sh.getRow(7).getCell(1).getStringCellValue();
		String datestock = sh.getRow(8).getCell(1).toString();
		driver.findElement(By.name("prodcode")).sendKeys(P_Code);
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(desc);
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		driver.findElement(By.name("onhand")).sendKeys(onhand);
		driver.findElement(By.name("price")).sendKeys(price);
		WebElement selcat = driver.findElement(By.xpath("//option[text()='Select Category']/.."));
		Select sel=new Select(selcat);
		sel.selectByVisibleText(sel_cat);
		WebElement selsup = driver.findElement(By.xpath("//option[text()='Select Supplier']/.."));
		Select sel1=new Select(selsup);
		sel1.selectByVisibleText(sel_sup);
		WebElement date = driver.findElement(By.xpath("//input[@name='datestock']"));
		date.click();
		date.sendKeys(datestock);
		driver.findElement(By.xpath("(//button[@type='submit'])[5]")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(name);
		driver.findElement(By.xpath("//a[contains(text(),'...')]")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-warning bg-gradient-warning btn-block']")).click();
		WebElement price2 = driver.findElement(By.name("price"));
		price2.clear();
		price2.sendKeys("8000");
		WebElement selcat2 = driver.findElement(By.xpath("//option[text()='Select Category']/.."));
		Select sel2=new Select(selcat2);
		sel2.selectByVisibleText(sel_cat);
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
