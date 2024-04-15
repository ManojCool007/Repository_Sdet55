package PopUps;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class IrctcFlightBusTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[text()=' BUSES ']")).click();
		Thread.sleep(2000);
		WeddriverUtility util=new WeddriverUtility();
		util.switchwindow(driver, "Online Bus Ticket Booking");
		driver.findElement(By.xpath("//input[@id='goingTo']")).sendKeys("mysuru");
		util.switchwindow(driver, "train-search");
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();

}
}
