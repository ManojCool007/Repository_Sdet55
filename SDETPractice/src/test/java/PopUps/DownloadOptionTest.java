package PopUps;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadOptionTest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		HashMap<String, Object> chromeprefs=new HashMap<String, Object>();
		chromeprefs.put("download.default_directory", "C:\\Users\\Dell\\Desktop\\Download\\");
		options.setExperimentalOption("prefs", chromeprefs);
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//p[text()=\"UI Testing Concepts\"]")).click();
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Download ']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("textarea")).sendKeys("Hello");
		driver.findElement(By.xpath("//button[text()='Download']")).click();

	}

}
