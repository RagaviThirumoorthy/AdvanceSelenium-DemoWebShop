package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileDataEg {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\USER\\Documents\\Selenium TestData\\CommonData.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String url = prop.getProperty("url");
		System.out.println("URL: "+url);
		String email = prop.getProperty("email");
		System.out.println("Email: "+email);
		String password = prop.getProperty("password");
		System.out.println("Password: "+password);
		String value4 = prop.getProperty("abcde");
		System.out.println(value4);
		
		
		
		fis.close();

	}

}
