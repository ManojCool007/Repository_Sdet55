package DropDown;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDropMultipleTest {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		driver.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
		driver.findElement(By.xpath("//a[text()='Drag Multiple']")).click();
		Thread.sleep(2000);
		WebElement MC = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement LC = driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		WebElement MoC = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement LaC = driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		WebElement MA = driver.findElement(By.xpath("//div[text()='Mobile Accessories']"));
		WebElement LA = driver.findElement(By.xpath("//div[text()='Laptop Accessories']"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		Robot rbt=new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		act.click(MC).perform();
		act.click(MoC).perform();
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		act.dragAndDrop(MoC, MA).perform();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		act.click(LC).perform();
		act.click(LaC).perform();
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		act.dragAndDrop(LaC, LA).perform();
		Thread.sleep(2000);
		driver.quit();

	}

}
