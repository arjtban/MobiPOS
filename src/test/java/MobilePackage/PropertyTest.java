package MobilePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyTest {
@Test	
public static String getORvalue(String key) throws IOException {
		
		File f1=new File("/home/arijit/Documents/LIVETEST/MobileProject/src/test/or.properties");
		FileInputStream fis=new FileInputStream(f1);
		Properties prop=new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		return data;
	}


}
