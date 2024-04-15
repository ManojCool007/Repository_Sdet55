package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	
	/**
	 * This Method is used to read data from Excel
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		String value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This Method is used to get total row count from Excel
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getTotalRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	/**
	 * This method is used to write data from excel
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataFromExcel(String sheetName,int rowNo,int cellNo,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		sheet.getRow(rowNo).getCell(cellNo).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IPathConstant.ExcelPath);
		book.write(fout);
		book.close();
	}
	
	/**
	 * This Method is to Read Multiple Data from Excel
	 * @param sheetName
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 * @throws IOException
	 */
	public HashMap<String, String> readMultipleData(String sheetName, int cellNo) throws Throwable, IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++)
		{
			String key = sheet.getRow(i).getCell(cellNo).getStringCellValue();
			String value = sheet.getRow(i).getCell(cellNo+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
	}
}
