package externalFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Fetching_Data_From_Property_File {

	@Test
	public void fetch() throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
	Properties p= new Properties();
	p.load(fis);
	String Name = p.getProperty("Name");
	System.out.println(Name);
	
	String Phno = p.getProperty("Phno");
	System.out.println(Phno);
	
	String Address = p.getProperty("Address");
	System.out.println(Address);
	}
}
