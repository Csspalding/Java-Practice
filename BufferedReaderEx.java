/**	
 * This file reads from a file using inputStream FileInputSteam object,which i set up with a data2.txt file
 * an InputStreamReader to read the file, BufferedReader // instead of a FileReader & Scanner  
 * NB as large blocks of code can read more efficiently this way 
 * @author Cass Nov 2018
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class BufferedReaderEx {

	/**
	 * @param args
	 * Iterate through each line of input from the data file.
	 * Convert the data digits into integers
	 * square each number and print to console
	 */
	public static void main(String[] args) throws IOException {
		
		InputStream iS = new FileInputStream ("data2.txt");
		
		InputStreamReader reader = new InputStreamReader(iS,StandardCharsets.UTF_8 );
		BufferedReader in = new BufferedReader(reader);
		int squared = 0;
		String line;
		boolean done= false;//flag for the end of the file
		
		try {
			while ((line = in.readLine()) != null) {// read each line at a time
				
				int number = Integer.parseInt(line);//convert the string line to an int
				
				if (number == -1 ) {//check for the end of the file represented as -1
					done = true;
				}
				else {
					//square the number read from the file
					squared = number * number;
					System.out.println(squared + " ");
				}
			}

		}
		catch  (NoSuchElementException nse){
			System.out.println("No integers above 0 in the file");
			nse.printStackTrace(); 
		}
		finally {
			//close the BufferedReader
			if(reader != null)
				reader.close();
			//close the InputSteamReader,automatically closes the InputStream
			if(in != null)
				in.close();
		}
	}


}	

