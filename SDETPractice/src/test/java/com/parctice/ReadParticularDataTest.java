package com.parctice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadParticularDataTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestDataScript.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		for (int i = 0; i <= rowcount; i++) 
		{
			String value = sheet.getRow(i).getCell(0).toString();
			if(value.equalsIgnoreCase("Client"))
			{
				int cellcount = sheet.getRow(i).getLastCellNum();
				for (int j = 0; j < cellcount; j++) 
				{
					String value_cells = sheet.getRow(i).getCell(j).toString();
					System.out.print(value_cells+" ");
				}
				
			}
		}
	}
}
