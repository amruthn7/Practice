package externalFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class Writing_Data_Into_Property_File {

	@Test
	public void writeTest() throws IOException {
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\commonData.properties", true );
		Properties p= new Properties();
		p.setProperty("email", "amruth@gmail.com");
		p.store(fos, "hi");
		fos.close();
	}
}
