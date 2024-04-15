package com.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	/**
	 * This Method is used to maximize the window
	 * @author Manoj M
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This Method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to wait until he page get loaded
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver,int sec)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	public WebDriverWait explicitWait(WebDriver driver,int sec)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(sec));
		return wait;
	}
	
	public void waitUntilElementToBeVisible(WebDriver driver,int sec,WebElement element)
	{
		explicitWait(driver, sec).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementToBeClickable(WebDriver driver,int sec,WebElement element)
	{
		explicitWait(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilToGetTitle(WebDriver driver,int sec,String title)
	{
		explicitWait(driver, sec).until(ExpectedConditions.titleContains(title));
	}
	
	public void waitUntilElementToBePresent(WebDriver driver,int sec,String title)
	{
		explicitWait(driver, sec).until(ExpectedConditions.alertIsPresent());
	}
	
	public Actions performActions(WebDriver driver)
	{
		Actions act= new Actions(driver);
		return act;
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		performActions(driver).contextClick(element).perform();
	}
	
	public void rightClick(WebDriver driver)
	{
		performActions(driver).contextClick().perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		performActions(driver).doubleClick(element).perform();
	}
	
	public void doubleClick(WebDriver driver)
	{
		performActions(driver).doubleClick().perform();
	}
	
	public void enterKeyPress(WebDriver driver, WebElement element)
	{
		performActions(driver).sendKeys(Keys.ENTER).perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		performActions(driver).moveToElement(element).perform();
		performActions(driver).click().perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement dest)
	{
		performActions(driver).dragAndDrop(source,dest).perform();
	}
	
	public void dropAndDrop(WebDriver driver, WebElement element, int x, int y)
	{
		
		performActions(driver).dragAndDropBy(element, x, y);
	}
	
	public void sendData(WebDriver driver, WebElement element)
	{
		performActions(driver).sendKeys(element).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		performActions(driver).scrollToElement(element).perform();
	}
	
	
	public void switchToWindow(WebDriver driver,String expWind)
	{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String win = it.next();
			String currentTitle = driver.switchTo().window(win).getTitle();
			if(currentTitle.equals(expWind))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public Alert handleAlert(WebDriver driver)
	{
	    Alert alert = driver.switchTo().alert();
	    return alert;
	}
	
	public void confirmAlert(WebDriver driver)
	{
		handleAlert(driver).accept();
	}
	
	public void dismissAlert(WebDriver driver)
	{
		handleAlert(driver).dismiss();
	}
	
	public void sendKeysAlert(WebDriver driver, String data)
	{
		handleAlert(driver).sendKeys(data);
		handleAlert(driver).accept();
	}
	
	public void getTextAlert(WebDriver driver)
	{
		handleAlert(driver).getText();
		handleAlert(driver).accept();
	}
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException
	{
		JavaUtility jutil= new JavaUtility();
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path="./screenshot/"+screenShotName +" "+ jutil.getSystemDateInFormat()+".png";
		File dest=new File(path);
		String srcpath = dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		return srcpath;
	}
	
	public  void dropDown(WebElement element,Object data)
	{
		Select sel =new Select(element);
		if(data instanceof Integer)
		{
			sel.selectByIndex((Integer) data);
		}
		else if(data instanceof String)
		{
			try
			{
				sel.selectByValue((String) data);
			}
			catch(Exception e)
			{
				sel.selectByVisibleText((String) data);
			}
		}
	}
	
	public List<WebElement> get_option(WebElement element)
	{
		List<WebElement> options = new Select(element).getOptions();
		return options;
	}
	
	public JavascriptExecutor javaScriptExecutor(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		return js;
	}
	
	public void launchUrl(WebDriver driver, String url)
	{
		javaScriptExecutor(driver).executeScript("window.location=arguments[0]", url);
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,800)","");
	}
	
	public void scrollAction(WebDriver driver, WebElement element)
	{
		int y = element.getLocation().getY();
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public void scrollToBottom(WebDriver driver)
	{
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollBackTop(WebDriver driver)
	{
		javaScriptExecutor(driver).executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	public void scrollTillEleToBeVisisble(WebDriver driver, WebElement element)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].scrollIntoView()",element);
	}
	
	public void clickOnElement(WebDriver driver, WebElement element)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].click()", element);
	}
	
	public void sendData(WebDriver driver, WebElement element, String data)
	{
		javaScriptExecutor(driver).executeScript("arguments[0].value=arguments[1]", element, data);
	}
	
	public void scrollUpTillElementToBeVisisble(WebDriver driver, WebElement element)
	{
		Point loc = element.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		javaScriptExecutor(driver).executeScript("window.scrollBy("+x+","+y+")");
	}
		
	public Robot performRobotActions() throws AWTException
	{
		Robot rbt=new Robot();
		return rbt;
	}
	
	public void enterKey() throws AWTException
	{
		performRobotActions().keyPress(KeyEvent.VK_ENTER);
	}
	
	public void releaseKey() throws AWTException
	{
		performRobotActions().keyRelease(KeyEvent.VK_ENTER);
	}
	
}
