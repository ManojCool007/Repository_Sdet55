package Assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadDataStoreTest {

	@Test
    public void question8() throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone 13",Keys.ENTER);
	WebElement price = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Blue']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	String text = price.getText();
	System.out.println(text);
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet7");
	sh.createRow(0).createCell(0).setCellValue(text);
	FileOutputStream fOut= new FileOutputStream(".\\src\\test\\resources\\Data.xlsx");
	wb.write(fOut);
	wb.close();
	}
}
