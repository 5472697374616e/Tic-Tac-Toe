import java.io.IOException;

/*
 * Author: Tristan Lea
 * Date last edited: 3/15/21
 * ____________________________________________________________________________________________
 * To summarize the goal is to build a tic-tac-toe game with 
 * randomly generated input as the computer opponent.
 */
public class MyTicTacToe {

	public static void main(String[] args) throws IOException {

		encapTicTacToe myMethods = new encapTicTacToe();

		int move;
		myMethods.startPrint();

		move = myMethods.getCpu();
		myMethods.setPlaneEntry(move, false);
		myMethods.printBoardAgain();

		for (int n = 0; n < 4; n++) {
			move = myMethods.getPlayer();
			myMethods.setPlaneEntry(move, true);

			move = myMethods.getCpu();
			myMethods.setPlaneEntry(move, false);
			myMethods.printBoardAgain();

		}
		myMethods.takeResponse();

	} // end of main
} // end of class
