package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/**
	 * This methos is used to load the properties from config.properties file 
	 * @return
	 */
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream propertiesFile = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}

}
