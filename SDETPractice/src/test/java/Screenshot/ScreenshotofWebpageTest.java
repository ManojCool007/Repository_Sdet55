package Screenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotofWebpageTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://demoapps.qspiders.com/ui?scenario=1");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File temp_mem = ts.getScreenshotAs(OutputType.FILE);
        File perm_mem = new File("C:\\Users\\Dell\\Desktop\\Download\\demo.png");
        FileHandler.copy(temp_mem, perm_mem);
	}

}
