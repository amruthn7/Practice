package externalFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.sl.draw.geom.Path;
import org.testng.annotations.Test;

public class Read_TextFile {
	
	@Test
	public void readTest() throws IOException
	{

		// File path is passed as parameter
        File file = new File(".\\src\\test\\resources\\data.txt");
        
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br= new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        String line = br.readLine();
        while ((st = line) != null)
            // Print the string
            System.out.println(st);
		}
}
