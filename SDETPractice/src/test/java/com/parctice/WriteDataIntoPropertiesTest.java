package com.parctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataIntoPropertiesTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties prop=new Properties();
		prop.setProperty("browser", "chrome");
		prop.setProperty("url", "http://rmgtestingserver/domain/Sales_And_Inventory_System/pages/login.php");
		prop.setProperty("username", "unguardable");
		prop.setProperty("password", "admin");
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		prop.store(fout, "Data Created");

	}

}
