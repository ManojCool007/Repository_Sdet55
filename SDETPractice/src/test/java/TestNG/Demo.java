package TestNG;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class Demo extends BaseClass {

	@Test
	public void script1()
	{
		System.out.println("Demo 1");
	}
	
	@Test
	public void script2()
	{
		System.out.println("Demo 2");
	}
	
	@Test(groups = "Smoke")
	public void script3()
	{
		System.out.println("Demo 3");
	}
}
