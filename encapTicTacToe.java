import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class encapTicTacToe {

	Scanner keyboard = new Scanner(System.in);
	Random randomNumbers = new Random();

	char[][] PlaneEntry = { { ' ', '|', ' ', '|', ' ' },
			{ '-', '+', '-', '+', '-' },
			{ ' ', '|', ' ', '|', ' ' },
			{ '-', '+', '-', '+', '-' },
			{ ' ', '|', ' ', '|', ' ' } };

	public void startPrint() {

		while (true) {

			String userEntry = "null";
			System.out.println("Do you want to play a game of tic tac toe? If so type yes or no then enter.");
			userEntry = keyboard.nextLine();

			if (userEntry.toUpperCase().equals("YES")) {
				System.out.println("Ok");
				break;

			} else if (userEntry.toUpperCase().equals("NO")) {
				System.out.println("Okay?");
				break;

			} else {
				System.out.println("not a valid response, please try again.");
			}
		}
	} // end of method

	public void takeResponse() throws IOException {

		File file = new File("gameHistory.txt");
		FileWriter fw = new FileWriter(file, true);
		PrintWriter pw = new PrintWriter(fw);

		String winner = "null";
		System.out.println("Who won?");
		keyboard.nextLine();
		winner = keyboard.nextLine();
		pw.println("" + winner);

		pw.close();
	} // end of method

	public void printBoardAgain() {

		for (char[] row : PlaneEntry) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		} // end of iterator
	} // end of method

	private boolean isMoveValid(int move) {

		char checker = 0;

		switch (move) {
			case 1:
				checker = PlaneEntry[0][0];
				break;
			case 2:
				checker = PlaneEntry[0][2];
				break;
			case 3:
				checker = PlaneEntry[0][4];
				break;
			case 4:
				checker = PlaneEntry[2][0];
				break;
			case 5:
				checker = PlaneEntry[2][2];
				break;
			case 6:
				checker = PlaneEntry[2][4];
				break;
			case 7:
				checker = PlaneEntry[4][0];
				break;
			case 8:
				checker = PlaneEntry[4][2];
				break;
			case 9:
				checker = PlaneEntry[4][4];
				break;
			default:
				break;

		} // end of switch

		if (checker == ' ')
			return true;
		return false;
	} // end of method

	public int getCpu() {

		int move;
		while (true) {

			move = randomNumbers.nextInt(8) + 1;
			if (isMoveValid(move))
				return move;
		}
	} // end of method

	public int getPlayer() {

		int move;
		System.out.println("Enter an int between 1-9, row 1 L-R 1,2,3"
				+ "4-6, 7-9 for successive rows");

		while (true) {

			move = keyboard.nextInt();
			if (isMoveValid(move))
				return move;
			System.out.println("move was not valid, try again.");
		}
	} // end of method

	public void setPlaneEntry(int move, boolean isPlayer) {

		char myChar;

		if (isPlayer) {
			myChar = 'X';
		} else {
			myChar = 'O';
		}

		switch (move) {
			case 1:
				PlaneEntry[0][0] = myChar;
				break;
			case 2:
				PlaneEntry[0][2] = myChar;
				break;
			case 3:
				PlaneEntry[0][4] = myChar;
				break;
			case 4:
				PlaneEntry[2][0] = myChar;
				break;
			case 5:
				PlaneEntry[2][2] = myChar;
				break;
			case 6:
				PlaneEntry[2][4] = myChar;
				break;
			case 7:
				PlaneEntry[4][0] = myChar;
				break;
			case 8:
				PlaneEntry[4][2] = myChar;
				break;
			case 9:
				PlaneEntry[4][4] = myChar;
				break;
			default:
				break;

		} // end of switch
	} // end of method
} // end of class
