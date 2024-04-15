package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		//driver.findElement(By.cssSelector("#name")).sendKeys("Hi");
		//driver.findElement(By.cssSelector("id=name")).sendKeys("Hi");
		driver.findElement(By.xpath("//p[contains(text(),'same attributes')]")).click();
		driver.findElement(By.xpath("//label[text()='Name']/following-sibling::input")).sendKeys("Lucifer");
		driver.findElement(By.xpath("//label[text()='Email Id']/following-sibling::input")).sendKeys("Lucifer.43@mail.com");
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::section/input")).sendKeys("lucifer");
		driver.findElement(By.xpath("//button[text()='Register']")).click();

	}

}
