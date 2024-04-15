package com.GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
		public int getRandomNumber()
		{
			Random ran=new Random();
			int ranNum = ran.nextInt(10000);
			return ranNum;
		}
		
		public String getSystemDate()
		{
			Date dt=new Date();
			String date = dt.toString();
			return date;
		}
		
		public String getSystemDateInFormat()
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			Date dt=new Date();
			String sysDateInFormat = dateFormat.format(dt);
			return sysDateInFormat;
		}
}
