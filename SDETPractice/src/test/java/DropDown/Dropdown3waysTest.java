package DropDown;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown3waysTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        WebElement day_dropdown = driver.findElement(By.xpath("//select[@aria-label='Day']"));
        Select sel=new Select(day_dropdown);
        sel.selectByIndex(11);
        WebElement month_dropdown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select sel_month=new Select(month_dropdown);
        sel_month.selectByValue("2");
        WebElement year_dropdown = driver.findElement(By.xpath("//select[@aria-label='Year']"));
        Select sel_year=new Select(year_dropdown);
        sel_year.selectByVisibleText("1998");
        Thread.sleep(2000);
        driver.quit();

	}

}
