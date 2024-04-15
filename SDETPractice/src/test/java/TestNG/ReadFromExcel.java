package TestNG;

import org.testng.annotations.Test;

public class ReadFromExcel {

	@Test(dataProviderClass = ExcelDataProvider.class, dataProvider = "readExcelData")
	public void getDataFromExcel(String orgs,String loc, String course)

	{
		System.out.println("Organization------->"+orgs+" is located at------->"+loc+" Course is------->"+course);
	}
}
