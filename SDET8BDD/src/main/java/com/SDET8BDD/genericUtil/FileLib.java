package com.SDET8BDD.genericUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Nitheesha
 *
 */
public class FileLib {
	/**
	 * Used to read the properties file and return the value by specifing the key
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstant.propertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
