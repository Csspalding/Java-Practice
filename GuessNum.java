/**Guess a random number game
 * 3 versions to the code using different loops
 * @author Cass Oct 2018
 */

import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.IOException;
import java.util.Random;

public class GuessNum{
	
	/**helper method first way of writing code
	* using a while(ture)loop
	*/
	public static void guessOne(){
		//create scanner for user input
				Scanner s = new Scanner (System.in);
				
				//generate random number
				Random r = new Random();
				int computerNum =  r.nextInt(100)+ 1;
				//check it works
				System.out.println(computerNum);
				//initialise a counter
				int count = 1;
				//start a loop
				while(true) {//same as for(;;) and infinite loop
					//get a guess
					System.out.println("Enter a guess for game "+ count +" :" );
					//check if the guess, have they won?
					int input = s.nextInt();
					if (input == computerNum) {
						System.out.println("You win!");
						break;
					}
				
					else if(input < computerNum) {
						 System.out.println("Too low!");
					}
					else {
						System.out.println("Too high!");
					}
					//increment counter
					count++;
					//end loop
					if (count==10) {
						System.out.println("You loose!");
						break;
						
					}
					
				}
			}
	
		/**
		 * helper method second way of writing the code
		 * using while(!done) loop
		 */
		public static void guessTwo() {
				//create scanner for user input
				Scanner s = new Scanner (System.in);
				
				//generate random number
				Random r = new Random();
				int computerNum =  r.nextInt(100)+ 1;
				//check it works
				System.out.println(computerNum);
				//initialise a counter
				int count = 1;
				//start a loop
				final int numOfguesses = 10;
				boolean done = false;
				while(!done) {
				for(int i = 0; i<numOfguesses; i++) { 
					if (done)
						break;
					//get a guess
					System.out.println("Enter a guess for game "+ count +" :" );
					//check if the guess, have they won?
					int input = s.nextInt();
					if (input == computerNum) {
						System.out.println("You win!");
						done = true;
					}
					else if(input < computerNum) {
						 System.out.println("Too low!");
					}
					else {
						System.out.println("Too high!");
					}
					if (count==10) {
						System.out.println("You loose!");
						done = true;
					}
						//increment counter
						count++;
					}
				}
			}
		
		
		/**third helper method for running the game
		 * uses a for loop
		 * returns a boolean each time you win a game, 
		 * this can be counted in main
		 * @return boolean
		 */
		public static boolean guessThree() {
			//create scanner for user input
			Scanner s = new Scanner (System.in);
			
			//generate random number
			Random r = new Random();
			int computerNum =  r.nextInt(100)+ 1;
			//check it works
			System.out.println(computerNum);
			//initialise a counter
			int count = 1;
			//set final number of guesses
			final int numOfguesses = 10;
			//set a flag for winning
			boolean youWin = false;
			//start a loop
			for(int i = 1; i<=numOfguesses; i++) { //start counting game 1, loop while less than or equal to 10 guesses
				//get a guess
				System.out.println("Enter a guess for game "+ count +" :" );
				//check if the guess, have they won?
				int input = s.nextInt();
				if (input == computerNum) {
					System.out.println("You win!");
					youWin = true;
					break;
				}
				if(input < computerNum) {
					 System.out.println("Too low!");
				}
				else {
					System.out.println("Too high!");
				}
				if (count==10) {
					System.out.println("You loose!");
					youWin = false;
				}
					//increment counter
					count++;
			}
			return youWin;
		}
		/**
		 * Method to play the game again 
		 * @return boolean
		 */
		public static boolean playAgain() {
			boolean playAgain = false;
			Scanner s = new Scanner(System.in);
			System.out.println("Play Again enter Y or N");
			String input = s.nextLine();
			if((input.equals("Y"))|| (input.equals("y"))){
				playAgain = true;}
			else {
				System.out.println("Quit the game");
				playAgain  = false;}
			return playAgain;
			
			
		}
	
		/**
		 * Main method to test the different helper methods, the different version of code
		 * to run the game
		 * @param args
		 */
	public static void main (String args[]) throws IOException {
		//guessOne();
		//guessTwo();
		
		//count the number of games the player wins
		int numberOfgamesYouWin = 0;
		//total played, this is set to 1 for the first game play in increments each time the player chooses to play again
		int totalGames = 1;
		
		for (int i = 0; i<totalGames; i++) { 
			//if guessThree method returns true YouWin 
			if (guessThree()){
			//increment if YouWin this game
			numberOfgamesYouWin++;
			}
			if (playAgain()) {
				//increment totalGames as the player has chosen to play again 
				totalGames++;
				}
		}
		System.out.println("You won "+ numberOfgamesYouWin +" games out of " + totalGames);
	}
}
