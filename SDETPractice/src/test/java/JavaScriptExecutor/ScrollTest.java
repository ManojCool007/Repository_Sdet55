package JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		//Thread.sleep(2000);
		//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		WebElement aus = driver.findElement(By.linkText("Australia"));
		//js.executeScript("arguments[0].scrollIntoView()",aus);
		//js.executeScript("arguments[0].click()", aus);
		//WebElement ele = driver.findElement(By.id("twotabsearchtextbox"));
		//js.executeScript("arguments[0].value=arguments[1]", ele,"iphone");
		Point loc = aus.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		js.executeScript("window.scrollBy("+x+","+y+")");
	}

}
