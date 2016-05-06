package Receive;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperties {

	public static String getProperty(String propertyName){
		Properties prop = new Properties();
		try {
			InputStream input =  MyProperties.class.getResourceAsStream("configuration.properties");
			// load a properties file
			prop.load(input);
			return prop.getProperty(propertyName);
		} catch (IOException ex) {
				ex.printStackTrace();
		}
		return "";
	}
}

