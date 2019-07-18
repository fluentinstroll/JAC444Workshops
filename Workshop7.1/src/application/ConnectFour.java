package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConnectFour {
	// ArrayLists are for the board display, trueGame is for keeping track of
	// the game in a way that allows for more easily checking the winner
	private List<String> rowOne;
	private List<String> rowTwo;
	private List<String> rowThree;
	private List<String> rowFour;
	private List<String> rowFive;
	private List<String> rowSix;
	private List<String> rowSeven;
	private int columnNum = 7;
	private int trueGame[][] = new int[6][columnNum];
	private boolean winner = false;
	private int turnCount = 1;
	private Scanner input;
	private int winningPlayer;

	public ConnectFour() {
		rowOne = new ArrayList<String>();
		rowTwo = new ArrayList<String>();
		rowThree = new ArrayList<String>();
		rowFour = new ArrayList<String>();
		rowFive = new ArrayList<String>();
		rowSix = new ArrayList<String>();
		rowSeven = new ArrayList<String>();
		input = new Scanner(System.in);
	}

	public void playGame() {
		this.initializeBoard();

		System.out.println(
				"This is Connect Four! To play, player 1 first drops a red disk, then player 2 drops a yellow disk.");
		System.out.println("Whoever gets 4 disks of their colour in a row or column wins!");
		int chosenColumn = -1;
		while (!winner) {
			this.showBoard();
			if (turnCount % 2 != 0) {
				System.out.println("Player 1, choose a column to place a red disk (0-6): ");
				try {
					if (input.hasNextLine())
						chosenColumn = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("You entered a character that was not a number between 0 and 6.");
					input.next();
				}
				if (chosenColumn >= 0 && chosenColumn <= 6)
					this.dropDisk("R", chosenColumn, 1);
				else
					System.out.println("Please enter a number between 0-6.");
			} else {
				System.out.print("Player 2, choose a column to place a yellow disk (0-6): ");
				try {
					if (input.hasNextLine())
						chosenColumn = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("You entered a character that was not a number between 0 and 6.");
					input.next();
				}

				if (chosenColumn >= 0 && chosenColumn <= 6)
					this.dropDisk("Y", chosenColumn, 2);
				else
					System.out.println("Please enter a number between 0 and 6.");
			}
			if (turnCount >= 8) {
				if (this.findWinner(1))
					winner = true;
				else if (this.findWinner(2))
					winner = true;
			}
		}

		if (winningPlayer == 1)
			System.out.println("The red player (1) has won the game.");
		else if (winningPlayer == 2)
			System.out.println("The yellow player (2) has won the game.");
	}

	public void showBoard() {
		for (int i = 0; i < rowOne.size(); i++) {
			if(i+1 == rowOne.size())
				System.out.println(rowOne.get(i));
			else
				System.out.print(rowOne.get(i));
		}
		for (int i = 0; i < rowTwo.size(); i++) {
			if(i+1 == rowTwo.size())
				System.out.println(rowTwo.get(i));
			else
				System.out.print(rowTwo.get(i));
		}
		for (int i = 0; i < rowThree.size(); i++) {
			if(i+1 == rowThree.size())
				System.out.println(rowThree.get(i));
			else
				System.out.print(rowThree.get(i));
		}
		for (int i = 0; i < rowFour.size(); i++) {
			if(i+1 == rowFour.size())
				System.out.println(rowFour.get(i));
			else
				System.out.print(rowFour.get(i));
		}
		for (int i = 0; i < rowFive.size(); i++) {
			if(i+1 == rowFive.size())
				System.out.println(rowFive.get(i));
			else
				System.out.print(rowFive.get(i));
		}
		for (int i = 0; i < rowSix.size(); i++) {
			if(i+1 == rowSix.size())
				System.out.println(rowSix.get(i));
			else
				System.out.print(rowSix.get(i));
		}
		for (int i = 0; i < rowSeven.size(); i++) {
			if(i+1 == rowSeven.size())
				System.out.println(rowSeven.get(i));
			else
				System.out.print(rowSeven.get(i));
		}
	}

	public void initializeBoard() {
		for (int i = 0; i <= columnNum; i++) {
			rowOne.add("| ");
			rowTwo.add("| ");
			rowThree.add("| ");
			rowFour.add("| ");
			rowFive.add("| ");
			rowSix.add("| ");

			if (i < columnNum)
				rowSeven.add("--");
		}
	}

	public void dropDisk(String colour, int column, int player) {
		if (rowSix.get(column) == "| ") {
			trueGame[5][column] = player;
			turnCount++;
			rowSix.set(column, "|" + colour);
		} else if (rowFive.get(column) == "| ") {
			rowFive.set(column, "|" + colour);
			trueGame[4][column] = player;
			turnCount++;
		} else if (rowFour.get(column) == "| ") {
			rowFour.set(column, "|" + colour);
			trueGame[3][column] = player;
			turnCount++;
		} else if (rowThree.get(column) == "| ") {
			rowThree.set(column, "|" + colour);
			trueGame[2][column] = player;
			turnCount++;
		} else if (rowTwo.get(column) == "| ") {
			rowTwo.set(column, "|" + colour);
			trueGame[1][column] = player;
			turnCount++;
		} else if (rowOne.get(column) == "| ") {
			rowOne.set(column, "|" + colour);
			trueGame[0][column] = player;
			turnCount++;
		} else {
			System.out.println("Please enter a disk into a column that's not full.");
		}

		
	}
	//no diagonal winner, fix
	public boolean findWinner(int player) {
		int disksInARow = 0;
		int disksInAColumn = 0;
		for (int[] innerArray : trueGame) {
			for (int cell : innerArray) {
				if (cell == player)
					disksInARow++;
				else
					disksInARow = 0;
				if (disksInARow == 4) {
					winningPlayer = player;
					return true;
				}
			}
		}
		for (int b = 0; b < columnNum; b++) {
			for (int a = 0; a < trueGame.length; a++) {
				if (trueGame[a][b] == player)
					disksInAColumn++;
				else
					disksInAColumn = 0;
				if (disksInAColumn == 4) {
					winningPlayer = player;
					return true;
				}
			}
		}
		return false;
	}
}
