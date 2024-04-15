package TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.GenericUtilities.IPathConstant;

public class ExcelDataProvider {

	@DataProvider(name="readExcelData")
	public Object[][] loginData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IPathConstant.ExcelPath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet6");
		int rowcount = sheet.getLastRowNum()+1;
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[rowcount][cellcount];
		for (int i = 0; i < rowcount; i++) 
		{
			for (int j = 0; j < cellcount; j++) 
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return obj;
		
	}
	
}
