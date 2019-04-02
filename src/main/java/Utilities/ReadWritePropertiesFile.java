package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



	public class ReadWritePropertiesFile { 		
		static Properties properties;   

	public static void loadData()throws IOException {		
		properties = new Properties();
		//File f = new File(System.getProperty{"user.dir"}+"\\src/main/java\\Utilities\\gamailtrials.properties");
		File f = new File(System.getProperty("user.dir")+"\\src/main/java\\Utilities\\gmailtrial.properties");
		FileReader obj = new FileReader(f);
		properties.load(obj);		
	}		
	public static String getobj(String Data) throws IOException {
		loadData();
		String data = properties.getProperty(Data);
		return data;
		
	} 
}

