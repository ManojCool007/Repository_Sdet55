package myFirstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Check Box']")).click();
        driver.findElement(By.xpath("//input[@id='domain2']")).click();
        driver.findElement(By.id("mode3")).click();
        driver.findElement(By.id("mode6")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.quit();
	}

}
