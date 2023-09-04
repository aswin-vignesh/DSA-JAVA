package com.Backtracking;

public class NKnights {
	
	public static void main(String[] args) {
		
		int n = 3;
        boolean[][] board = new boolean[n][n];
        System.out.println(knight(board, 0, 0, 3));
	}
	
	static int knight( boolean[][] board , int row , int col , int knights) {
		int count = 0;
		if(knights == 0) {
			display(board);
			System.out.println();
			return 1;
		}
		
		if(row == board.length) {
			return 0;
		}
		if(col == board[row].length) {
			return knight(board, row+1 , 0, knights);
		}
		
		
		if(isSafe(board, row, col)) {
			board[row][col] = true;
			count += knight(board, row, col+1, knights-1);
			board[row][col] = false;
		}
		
//		After the 1st ans we go for next
		count += knight(board, row, col + 1, knights);
		
		return count;
	}
	
	static boolean isSafe( boolean[][] board , int row , int col ) {
		
		// up left
		if(row > 1 && col > 0 && board[row-2][col-1]) {
			return false;
		}
		// up right
		if(row > 1 && col < board[row].length-1 && board[row-2][col+1]) {
			return false;
		}
		
		// bottom left
		if(row > 0 && col > 1 && board[row-1][col-2]) {
			return false;
		}
		
		//bottom right
		if(row > 0 && col < board[row].length-2 && board[row-1][col+2]) {
			return false;
		}
		return true;
	}
	
	static void display(boolean[][] arr) {
		for(boolean[] li : arr) {
			System.out.println("-----------------");
			System.out.print("|");
			for(boolean i: li) {
				if(i) {					
					System.out.printf(" X |");
				}else {
					System.out.printf(" O |");
				}
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
	
	
	// ----------------------------- KUNALS CHECK ---------------------------
	@SuppressWarnings("unused")
	private  static boolean isSafeKunal(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }
}
