package TestNG;

import org.testng.annotations.Test;

public class GetDataTest {

	@Test(dataProviderClass = DataproviderTest.class, dataProvider = "data")
	public void getData(String orgs, String loc, String course)
	{
		System.out.println("Organization------->"+orgs+" is located at------->"+loc+" Course is------->"+course);
	}
}
