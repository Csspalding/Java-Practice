/**@author Cass November 30th 2018
 * This program reads a number in from a file, reverses the number adds it to the original, 
 * if the resulting sum is a palindrome then the result and count of iterations are printed to console 
 * otherwise the program uses that sum to run again
 * 
 * assumptions:
 * the iteration less than 1000 
 * the size of the result is less than a max integer in java 
 * data in the file only contains digits which are all positive numbers, with no white space or other characters. 
 */
//NB a StringBuilder class could be used instead of arrays to reverse the digits


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class PalindromeEx {

	static int reverse = 0;
	static int sum = 0;
	static String line = " ";
	static boolean isPal= false;

	//Helper methods

	/**Reverse number
	 * @param String -  digits from a file 
	 * split into an array, reversed
	 * @return integer reverse of digits
	 */
	public static int reverseNum(String l) {

		String rev = "";
		String tokens [] = l.split("");
		//FOR TESTING check the array: System.out.println(Arrays.toString(tokens));

		//reverse the array
		for (int i = 0; i<tokens.length /2; i++) {
			String temp = tokens[i];
			tokens[i] = tokens[tokens.length - i -1];
			tokens[tokens.length - i -1] = temp;
		}
		//build a string from each element of the reversed array 
		for (int j= 0; j<tokens.length; j++) {
			rev += tokens[j];
		}
		reverse = Integer.parseInt(rev);
		return reverse;
	}
	
	/**
	 * @return integer reverse 
	 */
	public static int getReverse() {
		return reverse;
	}
	
	/**
	 * @param String of digits
	 * @return integer number 
	 */
	public static int getNum(String l) {
		int number = Integer.parseInt(l);
		return number;
	}

	/**
	 * @param String of digits 
	 * @return sum of digits with it's reverse
	 */
	public static int sum(String l) {
		sum = getNum(l) + getReverse(); 
		return sum;	
	}
	
	/**
	 * @return integer sum 
	 */
	public static int getSum() {
		return sum;
	}

	/**
	 * @return boolean checking if sum is a palindrome
	 */
	public static boolean checkPal() {
		boolean isPal = false;
		String l = getSum()+ "";
		reverseNum(l);

		if(getSum() == getReverse()) {
			isPal = true;	
		}
		return isPal;
	}
	
	/**Calculate how many iterations for a number to become a Palindrome
	 * @param String of digits
	 * @return String result  
	 */
	public static String calculatePal(String l) {
		String result= "";
		//iterations count
		int count = 0;
		//set a limit for the iterations
		int MAXCOUNT = 1000;

		try {
			while (!isPal && (count<MAXCOUNT)) {	
				count++;
				reverseNum(l);
				sum(l);
				result = "Palindrome in "+count+ " iterations, sum is " + getSum();
				isPal = checkPal();

				if (isPal)
				{
					System.out.println(result);
					break;
				}

				l = ""+getSum();
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Sum is over the integer limit");
			nfe.printStackTrace();
		}
		if(count == MAXCOUNT) {
			result = "The number of iterations Count is over the 1000 limit";
			return result;
		}
		return result;
	}


	/**
		Main method tests the program
		Reads numbers from a file data2.txt, alter the data in the file for equivalence tests
		Test1 file data is 345 Expected result: Palindrome in  1 iteration sum is 888
		Test2 file data is 678 Expected result: Palindrome in 4 iterations, sum is 23232
		Test3 file data is 789 Expected result: Palindrome in 4 iterations, sum is 66066
		Test4 file data is 989 Expected result: Sum is over the integer limit
	 */
	public static void main(String[] args) throws IOException {

		InputStream iS = new FileInputStream ("data2.txt");

		InputStreamReader reader = new InputStreamReader(iS,StandardCharsets.UTF_8 );
		BufferedReader in = new BufferedReader(reader);

		String line;
		//flag for the end of the file
		boolean done= false;
		try {
			// read each line at a time
			while ((line = in.readLine()) != null) {
				
				//convert  string line to int
				int number = Integer.parseInt(line);
				System.out.println("Data from the file is: " + line);
				
				//check for the end of the file represented as -1
				if (number == -1 ) {
					done = true;
				}
				else {
				//helper methods to calculate palindrome and number of iterations.
					calculatePal(line);
				}
			}

		}catch  (NoSuchElementException nse){
			System.out.println("No integers above 0 in the file");
			nse.printStackTrace(); 

		}finally {//close the BufferedReader
			if(reader != null)
				reader.close();
			if(in != null)//close the InputSteamReader  (automatically also closes the InputStream)
				in.close();
		}
	}


}	

