package com.parctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class DBAutoTest {

	public static void main(String[] args) throws InterruptedException, SQLException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys("PROJ_Lucifer");
		driver.findElement(By.name("createdBy")).sendKeys("Manoj M");
		WebElement drop = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
		Select sel=new Select(drop);
		sel.selectByValue("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver d=new Driver();
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		Statement state = con.createStatement();
		String query="select * from project where lower(project_name)='PROJ_Lucifer';";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			String actual = result.getString(4);
			if(actual.equals("PROJ_Lucifer"))
			{
				System.out.println("Data is Present");
			}
			else
			{
				System.out.println("Data is not present");
			}
		}
	}
}
