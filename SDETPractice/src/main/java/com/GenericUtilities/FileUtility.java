package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This Method is used to read Data from Property File
	 * @author Manoj M
	 * @param Key
	 * @return 
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropetyFile(String Key) throws IOException
	{
		FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
}
