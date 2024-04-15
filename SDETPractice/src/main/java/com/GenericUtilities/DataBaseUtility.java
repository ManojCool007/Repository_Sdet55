package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

		/**
		 * Step 1: Register Driver
		 * Step 2: Get connection for Database
		 * Step 3: Create Statement
		 * Step 4: Execute Query
		 * Step 5: Close Database Connection
		 * @throws SQLException 
		 */
	Connection con=null;
	public void connectDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstant.DBPath, IPathConstant.DBUserName, IPathConstant.DBPassword);
	}
	
	public void executeData(String query, int colIndex, String expData) throws SQLException
	{
		Statement state = con.createStatement();
		
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String actual = result.getString(colIndex);
			if(actual.contains(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("---Data is Validated---");
		}
		else
		{
			System.out.println("---Data is not Validated---");
		}	
	}
	public void closeDB() throws SQLException
	{
		con.close();
	}
}

