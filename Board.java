import java.util.Arrays;

public class Board {
	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	public char[][] arr;

	public Board() {
		arr = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	}
	public void printBoard() { // Prints board
		for (char[] x : arr)
		{
			System.out.print("| ");
			for (char y : x)
			{
				System.out.print(y + " | ");
			}
			System.out.println();
		}
	}
	public boolean containsWin() { // checks board for a win
		char playerTwo; char playerOne;

		if (HumanPlayer.sym1 != 0) {
			playerOne = HumanPlayer.sym1;
			if (HumanPlayer.sym2 != 0) {
				playerTwo = HumanPlayer.sym2;
			} else {
				playerTwo = AIPlayer.sym1;
			}
		} else {
			playerOne = AIPlayer.sym1;
			playerTwo = AIPlayer.sym2;
		}

		int winOne;
		int winTwo;
		for (int z = 0; z <= 2;z++){
			// right diagonals
			for (int i = 0; i <=3; i++){
				winOne = 0;
				winTwo = 0;

				for (int x = 5-z, y = i ; x >= 2-z; x--, y++) {
					if (arr[x][y] == playerOne){
						winOne += 1;
					} else if (arr[x][y] == playerTwo) {
						winTwo += 1;
					}
				}

				if (winOne == 4 || winTwo == 4){
					return true;
				}
			}
			// left diagonals
			for (int i = 6; i >=3; i--){
				winOne = 0;
				winTwo = 0;

				for (int x = 5-z, y = i ; x >= 2-z; x--, y--) {
					if (arr[x][y] == playerOne){
						winOne += 1;
					} else if (arr[x][y] == playerTwo) {
						winTwo += 1;
					}
				}
				if (winOne == 4 || winTwo == 4){
					return true;
				}
			}
		}
		// Vertical
		for (int y = 0; y <= 6; y++){
			for (int i = 0; i <= 2; i++){
				winOne = 0;
				winTwo = 0;
				for (int x = 5-i; x >= 2-i; x--){
					if (arr[x][y] == playerOne){
						winOne += 1;
					} else if (arr[x][y] == playerTwo) {
						winTwo += 1;
					}
				}
				if (winOne == 4 || winTwo == 4){
					return true;
				}
			}
		}
		// Horizontal
		for (int x = 5; x >= 0; x--)
		{
			for (int i = 0; i <= 3; i++){
				winOne = 0;
				winTwo = 0;
				for (int y = 6-i; y >= 3-i; y--){
					if (arr[x][y] == playerOne){
						winOne += 1;
					} else if (arr[x][y] == playerTwo) {
						winTwo += 1;
					}
				}
				if (winOne == 4 || winTwo == 4){
					return true;
				}
			}
		}
		return false;
	}
	public boolean isTie() { // Checks board for a tie
		if (!containsWin()) {
			for (int x = 5; x >= 0; x--){
				for (int y = 6; y >= 0; y--){
					if (arr[x][y] == ' ') {
						return false;
					}
				}
			}
		}
		return true;
	}
	public void reset() { // Resets the board
		for (int x = 5; x >= 0; x--){
			for (int y = 6; y >= 0; y--){
				arr[x][y] = ' ';
			}
		}
	}
}
