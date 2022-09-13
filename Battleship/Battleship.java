package battle;

import java.util.Random;
import java.util.Scanner;

public class Battleship {
	public boolean go;
	Board computerBoard = new Board();
	Board playerBoard = new Board();
	public static final String[] namesOfBattleships = { "Carrier", "Battleship", "Destroyer", "Submarine", "Destroyer" };
	public static final int[] shipLength = { 5, 4, 3, 3, 2 };
	public static final char[] letters = { 'A', 'B', 'C', 'S', 'P' };

	public static void main(String[] args) {
		Battleship battleship = new Battleship();
		battleship.setup();
		battleship.play();
	}

	public void setup() {
		placePlayersShips();
		placeComputerShips();
	}

	public boolean gameOver() {
		boolean playerOver = playerBoard.hasNoShips();
		boolean computerOver = computerBoard.hasNoShips();

		if (playerOver == true || computerOver == true) {
			if (computerOver == true) {
				System.out.println("The last battleship has been sunk by player, Game Over YOU WON!");
				return true;
			}else {
				System.out.println("The last battleship has been sunk by computer, Game Over you LOST!");
				return true;
			}
		} else {
			return false;
		}
	}

	public void play() {
		while (!gameOver()) {
			playerTurn();
			computersTurn();
		}

	}

	public void playerTurn() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("it is your turn, which row would you like to hit? Ex. 1");
		int row = keyboard.nextInt();
		System.out.println("which column would you like to hit?");
		int col = keyboard.nextInt();
		boolean miss = computerBoard.shootAt(row, col);
		if (miss == false) {
			System.out.println("you missed");
			playerBoard.recordMiss(row, col);
			System.out.println(playerBoard.toString());
		} else {
			System.out.println("HIT!");
			playerBoard.recordHit(row, col);
			computerBoard.lowerBoard[row][col] = 'X';
			System.out.println(playerBoard.toString());
		}
	}

	public void computersTurn() {
		Random generator = new Random();
		int row = generator.nextInt(10);
		int col = generator.nextInt(10);
		boolean miss = playerBoard.shootAt(row, col);
		if (miss == false) {
			System.out.println("computer missed");
			computerBoard.recordMiss(row, col);
		} else {
			System.out.println("Computer with a HIT!");
			computerBoard.recordHit(row, col);
			playerBoard.lowerBoard[row][col] = 'X';
		}
	}

	public void placePlayersShips() {
		Scanner keyboard = new Scanner(System.in);
		for (int i = 0; i < 5;) {
			String name = namesOfBattleships[i];
			int length = shipLength[i];
			char shipLetter = letters[i];
			char orientation;
			int row;
			int col;
			System.out.println("Lets place the " + name + " ship, it has a length of " + length + ". would you like "
					+ "to place it 'H'orizontaly or 'V'erticaly?");
			orientation = keyboard.next().charAt(0);
			System.out.println("Which row?");
			row = keyboard.nextInt();
			System.out.println("which col?");
			col = keyboard.nextInt();
			if (playerBoard.canShipFit(length, orientation, row, col) == true) {
				playerBoard.placeShip(length, shipLetter, orientation, row, col);
				i++;
			} else {
				System.out.println("It did not fit. try with different coordinates.");
			}

		}

	}

	public void placeComputerShips() {
		Random generator = new Random();
		Random rnd = new Random();
		for (int i = 0; i < 5;) {
			String chars = "HV";
			char orientation = chars.charAt(rnd.nextInt(chars.length()));
			int row = generator.nextInt(9);
			int col = generator.nextInt(9);
			int length = shipLength[i];
			char shipLetter = letters[i];
			if (computerBoard.canShipFit(length, orientation, row, col) == true) {
				computerBoard.placeShip(length, shipLetter, orientation, row, col);
				i++;
			}
		}// Line underneath is for testing
		//System.out.println(computerBoard.lowerToString());
	}
}
