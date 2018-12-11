/**
@author Cass Sept 2018
Program to design patterns of numbers in a double array table
 */
import java.lang.ArrayIndexOutOfBoundsException;


public class DesignTable2DArray {
	/**
	 * Main class used to test various table designs
	 * @param args
	 */
	public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

		int[][]board1 = createBoardZeros(5);
		//printIDIntArray(board1[0]); // to print out one dimensional 1D array of ints: one row
		System.out.println("\n\n");
		//printTable(board1);
		int[][]board2 = createBoardDesign(5);
		//printIDIntArray(board2[0]);
		printTable(board2);


	}
	/** To create an 2D array square board with a given n number of row and columns
	 * populate the 2D array with zero's
	 * @param n - same number for row and columns
	 * @return int[][] of the board 
	 */

	public static int[][] createBoardZeros(int n) {
		//create the board
		int [][] board = new int[n][n];
		//populate the board with zeros
		for (int i = 0; i<n;i++){
			for (int j = 0; j< n;j++){
				board [i][j] = 0;
			}
		}
		return board;
	}

	/**
	 * To create a mirror image of board
	 * @param n
	 * @return
	 */
	public static int[][] createBoardDesignBackwards(int n){
		//create the board
		int [][] board = new int[n][n];

		//populate the board with design
		for (int i = board.length-1; i>=0;i--){	
			//loops through array backwards 
			for (int j = board.length-1; j>=0 ;j--){
				board [i][j] = i+j;
				if (board[i] [j] <= 0)
					board[i][j] = 0;
			}
		}
		return board;
	}
	
	/**Create board design with numbers lining along the diagonal
	 * @param n
	 * @return int[][]
	 * 
	1	2	3	4	5	
	0	1	2	3	4	
	0	0	1	2	3	
	0	0	0	1	2	
	0	0	0	0	1	
	*/

	public static int[][] createBoardDesign(int n){
		//create the board
		int [][] board = new int[n][n];
		//populate the board with design
		int i;
		int j;
		int num = 1; 
		for (i = 0; i<board.length;i++){
			for ( j = 0; j< board.length;j++){
				//loop until number gets to n-1 to prevent array out of bounds
				if (num <(n-1)) {
					board [i][j] = i+j + num;
					//Handles any negative numbers so they appear as zero
					if (board[i][j] < 0)     
					{
						board[i][j] = 0;
					}
				}
			}
			//num is zero in first loop
			num = num-1;
			//decrement num
			num--;		
		}
		return board;
	}
	/**helper method print the array rows
	 * @param a
	 */
	public static void printIDIntArray(int[] a) {

		for (int i=0;i<a.length;i++){
			System.out.print(a[i] + "\t");

		}
		System.out.println("");
	}
	
	/**method to print the board design, both table rows and columns
	 * uses helper print row method
	 * @param a
	 * @return int [][]
	 */
	public static String printTable(int [][]a) {
		String done = "table printed";
		int index = 0;
		while (index < a.length ) {
			printIDIntArray(a[index]);
			index++;//prints each row one after another
		}
		System.out.println("\n\n");
		return done;	
	}

}


