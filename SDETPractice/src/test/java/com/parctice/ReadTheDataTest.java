package com.parctice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataScript.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	 Sheet sheet = book.getSheet("Sheet1");
	 int rowcount = sheet.getLastRowNum();
	 int cellcount = sheet.getRow(0).getLastCellNum();
	 for (int i = 0; i <= rowcount; i++) 
	 {
		 for (int j = 0; j < cellcount; j++)
		 {
			 String value = sheet.getRow(i).getCell(j).getStringCellValue();
			 System.out.print(value+" ");
		}
		 System.out.println();
	}
}
}
