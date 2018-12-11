/**Main class is TestNoughtsGame
 * @author Cass Sept 2018
 *Noughts & Crosses game, sometimes known as TicTacToe
 */
import java.util.Scanner;

public class NXGame {

	public static void main (String []args) {
		NXBoard game1 = new NXBoard();
		game1.printBoard();
		
		int count = 0;
		Scanner s = new Scanner(System.in);
		while (true && count<10) {
			//Player One Crosses
			System.out.println("Player 1:You are Crosses. Type row number SPACE column number ENTER ");
			String input = s.nextLine();
			Scanner numX = new Scanner(input);
			int row = numX.nextInt();
			int col = numX.nextInt();
			row = row -1;
			col = col -1;
			if (game1.getBoard()[row][col].equals(game1.empty))
				{
				game1.getBoard()[row][col]= " X ";
				game1.printBoard();
				count++;
				}
			else {
			System.out.println("That position is taken try again");
			}
			
			// Player Two Noughts
			System.out.println("Player 2:You are Noughts. Type row number SPACE column number ENTER ");
			String input2 = s.nextLine();
			Scanner numO = new Scanner(input2);
			row =numO.nextInt();
			col = numO.nextInt();
			row = row -1;
			col = col -1;
			if(game1.getBoard()[row][col].equals(game1.empty))
				{
				game1.getBoard()[row][col]= " O ";
				game1.printBoard();
				count++;
				}
		}
	}	
	
}
