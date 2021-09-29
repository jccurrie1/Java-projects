package battle;

public class Board {
		char[][] upperBoard; 		
		char[][] lowerBoard;
		int carrier = 5;
		int battleship = 4;
		int cruiser = 3;
		int submarine = 3;
		int destroyer = 2;
		
	
	public Board() {
		upperBoard = new char[10][10];
		lowerBoard = new char[10][10];
		for (int row=0; row < upperBoard.length; row++)
	         for (int col=0; col < upperBoard[row].length; col++)
	        	 upperBoard[row][col] = '.';
		for (int row=0; row < lowerBoard.length; row++)
	         for (int col=0; col < lowerBoard[row].length; col++)
	        	 lowerBoard[row][col] = '.';
	}
	
	public String toString() {
		String uBoard = "";
			for (int row=0; row < upperBoard.length; row++) {
				uBoard += "\n";
		         for (int col=0; col < upperBoard[row].length; col++)
		        	 	uBoard = uBoard + upperBoard[row][col] + " ";		
			}
		return uBoard;	
	}
	
	public String lowerToString() {
		String lBoard = "";
		for (int row=0; row < lowerBoard.length; row++) {
			lBoard += "\n";
	         for (int col=0; col < lowerBoard[row].length; col++)
	        	 	lBoard = lBoard + lowerBoard[row][col] + " ";	}
	return lBoard;	
	}
	
	public boolean shootAt(int row, int col) {
		char shotBoard = lowerBoard[row][col];
		if (shotBoard == '.') {
		return false;	
		}
		if (shotBoard == 'A') {
			carrier--;
			if (carrier == 0) {
				System.out.println("you sunk carrier.");	
				return true;
			}
				return true;	
		}
		if (shotBoard == 'B') {
			battleship--;
			if (battleship == 0) {
				System.out.println("you sunk battleship.");	
				return true;
			}
			return true;
		}
		if (shotBoard == 'C') {
			cruiser--;
			if (cruiser == 0) {
				System.out.println("you sunk cruiser.");	
				return true;
			}
			return true;
		}
		if (shotBoard == 'S') {
			submarine--;
			if (submarine == 0) {
				System.out.println("you sunk submarine.");
				return true;
			}
			return true;
		}
		if (shotBoard == 'P') {
			destroyer--;
			if (destroyer == 0) {
				System.out.println("you sunk destroyer.");	
				return true;
			}
			return true;
		}
		return false;
	}
	
	public void recordHit(int row, int col) {
		upperBoard[row][col] = '#';
	}
	
	public void recordMiss(int row, int col) {
		upperBoard[row][col] = 'o';
	}
	
	public boolean hasNoShips() {
		if (carrier == 0 && battleship == 0 && cruiser == 0 && submarine == 0 && destroyer == 0) {
			return true;
		}else {
			return false;
		}
			
		
	}
	
	public boolean canShipFit(int length, char orientation, int row, int col) {
		char shotBoard = lowerBoard[row][col];
		int count = length;
		while (count != 0) {
			if (shotBoard == '.') {
				if (shotBoard != '.') {
					return false;	
				}
				count--;
			}
			if (orientation == 'H') {
				if (col >= 10) {
					return false;
				}
				col++;
			}else{
				if (row >= 10) {
					return false;
				}
				row++;
			}
		}
		return true;
	}
	
	public void placeShip(int length, char shipLetter, char orientation, int row, int col) {
		int count = length;	
		if (orientation == 'H') {
				if(canShipFit(length, orientation, row, col) == true) {
					while(count != 0) {
						lowerBoard[row][col] = shipLetter;
						count--;
						col++;
					}
						
				}
			}
			
			if (orientation == 'V') {
				if(canShipFit(length, orientation, row, col) == true) {
					while(count != 0) {
						lowerBoard[row][col] = shipLetter;
						count--;
						row++;
					}
				}
			}
		}
}
