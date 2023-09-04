package com.Backtracking;

public class NQueens {
	
	public static void main(String[] args) {
		int n = 4;
        boolean[][] board = new boolean[n][n]; //default false
        
        System.out.println(queens(board, 0));
	}
	
	static int queens(boolean[][] board , int row) {
		
		if(row == board.length) {
			display(board);
			System.out.println();
			return 1;
		}
		
		int count = 0;
		
		for(int col = 0; col < board[row].length ; col++) {
			
			if(isSafe(board, row, col)) {
				
				board[row][col] = true;
				
				count += queens(board, row+1);
				
				board[row][col] = false;
			}
			
		}
		return count;
	}
	
	static boolean isSafe(boolean[][] board , int row , int col) {
		
		// row up check 
		for(int i=row ; i>=0 ; i--) {
			if(board[i][col]) {
				return false;
			}
		}
		
		// left dia check
		int left = Math.min(row, col); 
		for(int i=0 ; i <= left ; i++) {
			if(board[row-i][col-i]) {
				return false;
			}
		}
		// right dia check
		int right = Math.min(row, board[row].length-1-col); 
		for(int i=0 ; i <= right ; i++) {
			if(board[row-i][col+i]) {
				return false;
			}
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
	
	
}
