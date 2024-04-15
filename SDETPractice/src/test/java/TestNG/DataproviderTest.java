package TestNG;

import org.testng.annotations.DataProvider;

public class DataproviderTest {

	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[3][3];
		obj[0][0]="qspiders";
		obj[0][1]="Bangaluru";
		obj[0][2]="Automation";
		
		obj[1][0]="jspiders";
		obj[1][1]="Mysore";
		obj[1][2]="Development";
		
		obj[2][0]="pyspiders";
		obj[2][1]="Bangaluru";
		obj[2][2]="Python";
		return obj;
	}

}
