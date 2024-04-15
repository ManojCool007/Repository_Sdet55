package TestNG;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class Sample extends BaseClass{
	
	@Test
	public void demo1() throws InterruptedException
	{
		System.out.println("Sample 1");
		Thread.sleep(2000);
	}
	
	@Test
	public void demo2()
	{
		System.out.println("Sample 2");
	}
	
	@Test
	public void demo3()
	{
		System.out.println("Sample 3");
	}
}
