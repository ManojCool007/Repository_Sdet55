package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LanguageTest {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--lang=kn");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		System.out.println(driver.getCurrentUrl());

	}

}
