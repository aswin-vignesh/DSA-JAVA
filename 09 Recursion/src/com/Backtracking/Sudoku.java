//  My Awesome Code from scratch

package com.Backtracking;


public class Sudoku {
	public static void main(String[] args) {
		
		int[][] board = new int[][]{
		//	 0  1  2   3  4  5   6  7  8
            {3, 0, 6,  5, 0, 8,  4, 0, 0},  // 0
            {5, 2, 0,  0, 0, 0,  0, 0, 0},  // 1
            {0, 8, 7,  0, 0, 0,  0, 3, 1},  // 2
            
            {0, 0, 3,  0, 1, 0,  0, 8, 0},  // 3
            {9, 0, 0,  8, 6, 3,  0, 0, 5},  // 4
            {0, 5, 0,  0, 9, 0,  6, 0, 0},  // 5
            
            {1, 3, 0,  0, 0, 0,  2, 5, 0},  // 6
            {0, 0, 0,  0, 0, 0,  0, 7, 4},  // 7
            {0, 0, 5,  2, 0, 6,  3, 0, 0}   // 8
		};
//		display(board);
//		int r = 3 , c = 4;
//		System.out.println( isSafe(board, r, c, board[r][c]) );
		
		solve(board, 0, 0,false);
	}
	
	static void solve(int[][] board , int row , int col, boolean found) {
		
		if(row == board.length) {
			display(board);
			System.out.println();
			System.out.println("===================================");
			System.out.println();
			
			found = true;
			return;
		}
		
		// check for col full
		if(col == board.length) {
			solve(board, row+1, 0,found);
			return;
		}
		
		// check if no is already filled
		if(board[row][col] != 0) {
			solve(board, row, col+1,found);
			return;
		}
		
		
		// trying each nums from 1-9
		for(int num=1 ; num <= 9 ; num++ ) {
			if(isSafe(board, row, col, num)) {
				
				board[row][col] = num;
				
				solve(board, row, col+1,found);
				
				board[row][col] = 0;
			}
		}
		
		// go to next solution
		if(found) {			
			solve(board, row, col+1,false);
		}
	}
	
	
	// safety check
	static boolean isSafe(int[][] board , int row , int col, int num) {
		
		// vertical check
		for(int r = 0 ; r < 9 ; r++) {
			if( board[r][col] == num ) {
				return false;
			}
		}
		
		// Horizontal Check
		for(int c = 0 ; c < 9 ; c++) {
			if( board[row][c] == num ) {
				return false;
			}
		}
		
		// 3x3 check
		int rStart = (row/3)*3;
		int cStart = (col/3)*3;
		int rEnd = rStart+2;
		int cEnd = cStart+2;
		
		for(int i = rStart ; i <= rEnd ; i++) {
			for(int j = cStart ; j <= cEnd ; j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	// print
	static void display(int[][] arr) {
		for(int[] li : arr) {
			System.out.println("-------------------------------------");
			System.out.print("|");
			for(int i: li) {
				System.out.printf(" %d |",i);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
}
