/**@author Cass Sept 2018
 * For Noughts & Crosses Game
 * Class to construct the board
 */
//3 methods (1) clear the board, (2)printBoard (3) add a symbol
public class NXBoard {

	private final int THREE= 3;
	private String [][] a = new String [THREE][THREE];
	protected String empty =   "|__";
	//constructor
	public NXBoard() {
		clearBoard();
	}
	//method to clear the board
	public void  clearBoard() {
		
		for (int i = 0;i<a.length; i++) {
			for (int j = 0;j<a.length; j++) {	
			a[i][j] = empty;
			}	
		}
	}
	//Simons' toString method
	public String toString() {
		String output = "-------\n";
			for(int i=0;i<a.length;i++) {
				for(int j=0;j<a[i].length;j++) {
					output += "|" + a[i][j];
				}
				output += "|\n-------\n";
			}
			return output;	
		
	}
	//printBoard method
	public void printBoard() {
		//String board = "|__" ;
		for (int i = 0;i<a.length; i++) {
			for (int j = 0;j<a.length; j++) {
				 //a[i][j]= board;
				System.out.print(" " + a[i][j]);
			}
			System.out.println();	
		}
	}
	// add a symbol to the row and column
	public void addSymbol(int r, int c, String s) {
		if (a[r][c].equals("|__" )) {
			a[r][c] = s;
			
		}//otherwise
		System.out.println("Choose another space");
	}
	public String[][] getBoard(){
		return a;
	}
	//Test this class
	public static void main (String[]args) {
		NXBoard g = new NXBoard();
		System.out.println("Hello, are you ready to play?");
		g.printBoard();
	}
	
}
