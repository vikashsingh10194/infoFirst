package com.orbitz.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
	/*static InputStream input = null;
	static String value;*/
	static String filePath = "config.properties";
	
	public static String getFlightData(String data) {
		
			Properties properties = new Properties();
			try {
				properties.load(new FileInputStream(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}

			String value = properties.getProperty(data);
			System.out.println(value);
			return value;
		
		
	}

}
