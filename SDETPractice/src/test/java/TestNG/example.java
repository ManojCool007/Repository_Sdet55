package TestNG;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class example extends BaseClass {

	@Test
	public void example1()
	{
		System.out.println("example 1");
	}
	
	@Test(groups = "Smoke")
	public void example2()
	{
		System.out.println("example 2");
	}
	
	@Test
	public void example3()
	{
		System.out.println("example 3");
	}
}
