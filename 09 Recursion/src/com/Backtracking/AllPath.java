package com.Backtracking;


public class AllPath {
	
	public static void main(String[] args) {
		
		boolean[][] board = {
				{true, true, true},
				{true, true, true},
				{true, true, true}
		};
//		allPathPrint("", board, 0, 0);
		
		int[][] path = new int[board.length][board[0].length];
		allPathPrint("", board, path, 0, 0, 1);
		
	}
	
	static void allPathPrint(String p, boolean[][] board , int r , int c) {
		
		if(r == board.length-1 && c == board[r].length-1 ) {
			System.out.print(p+", ");
			return;
		}
		if(!board[r][c]) {
			return;
		}
		
		// marking
		board[r][c] = false;
		
		//right
		if(c < board[r].length-1) {			
			allPathPrint(p+"R", board, r, c+1);
		}
		
		//down
		if(r < board.length-1) {			
			allPathPrint(p+"D", board, r+1, c);
		}
		
		//up
		if(r > 0) {			
			allPathPrint(p+"U", board, r-1, c);
		}
		
		//left
		if(c > 0) {			
			allPathPrint(p+"L", board, r, c-1);
		}
		
		// Unmark
		board[r][c] = true;
	}
	
	
	// printing paths
	static void allPathPrint(String p, boolean[][] board ,int[][] path, int r , int c,int count) {
		
		if(r == board.length-1 && c == board[r].length-1 ) {
			path[r][c] = count;
			System.out.println("-------------- path-------------");
			System.out.println(p);
			print(path);
			return;
		}
		if(!board[r][c]) {
			return;
		}
		
		// marking
		board[r][c] = false;
		path[r][c] = count;
		
		//right
		if(c < board[r].length-1) {			
			allPathPrint(p+"R", board, path, r, c+1,count+1);
		}
		
		//down
		if(r < board.length-1) {			
			allPathPrint(p+"D", board, path, r+1, c,count+1);
		}
		
		//up
		if(r > 0) {			
			allPathPrint(p+"U", board, path, r-1, c,count+1);
		}
		
		//left
		if(c > 0) {			
			allPathPrint(p+"L", board, path, r, c-1, count+1);
		}
		
		// Unmark
		board[r][c] = true;
		path[r][c] = 0;
	}
	
	static void print(int[][] arr) {
		
		for(int[] li : arr) {
			System.out.println("-------------");
			System.out.print("|");
			for(int i: li) {
				System.out.printf(" %d |",i);
			}
			System.out.println();
		}
		System.out.println("-------------");
	}
	
	
	
}
