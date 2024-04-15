package Practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColorsofMobileTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
        driver.findElement(By.id("nav-search-submit-button")).click();
        WebElement phone = driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Midnight']"));
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(phone));
        phone.click();
        String parent = driver.getWindowHandle();
        Set<String> allid = driver.getWindowHandles();
        for(String id:allid)
        {
        	if(parent.equals(id))
        	{
        		driver.close();
        	}
        	else
        	{
        		driver.switchTo().window(id);
        		 List<WebElement> color = driver.findElements(By.xpath("//img[@class='imgSwatch']"));
                for(WebElement col:color)
                {
                	String colo = col.getAttribute("alt");
                	System.out.println(colo);
                }
        	}
        }
       
	}

}
