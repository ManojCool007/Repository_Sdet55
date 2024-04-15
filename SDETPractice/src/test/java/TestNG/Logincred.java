package TestNG;

import org.testng.annotations.DataProvider;

public class Logincred {
		
	@DataProvider(name = "Login_cred")
		public Object[][] cred()
		{
			Object[][] obj= new Object[2][2];
			obj[0][0]="admin";
			obj[0][1]="admin";
			
			obj[1][0]="unguardable";
			obj[1][1]="admin";
			
			return obj;
		}
	}

