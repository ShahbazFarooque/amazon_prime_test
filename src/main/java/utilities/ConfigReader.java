package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {

	private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

	private Properties prop;

	/**
	 * This method used to load properties files
	 * 
	 * @param propertyFileName
	 * @return
	 */
	public Properties setPropertiesFile(String propertyFileName) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/resources/propertiesfiles/" + propertyFileName + ".properties");
			prop = new Properties();
			prop.load(fileInputStream);
			logger.info("Properties File loaded Successfully and property file name ---- " + propertyFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		return prop;
	}

	/**
	 * This method return config file value against given key
	 * 
	 * @param key
	 * @return
	 */
	public String getPropertiesValue(String key) {
		String value = prop.getProperty(key);
		logger.info("Getting value " + value + "For the Key --" + key);
		return value;
	}

}
