package utility;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import constants.SourcePath;

public class PropUtility {
	
	public static String getBaseUri(String key) throws IOException {
		FileInputStream fs = new FileInputStream (new File(SourcePath.CONFIG_PROPERTIES));
		Properties ob = new Properties();
		ob.load(fs);
		String value = ob.getProperty(key);
		return value ;
		
	}

}
