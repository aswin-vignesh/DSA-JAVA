package com.Backtracking;

import java.util.ArrayList;

public class Maze {
	
	public static void main(String[] args) {
		
//		path("", 3, 3);
//		System.out.println(pathCount( 3, 3));
		
//		System.out.println(pathRetDia("", 3, 3));
		
		boolean[][] matrix = {
				{true, true, true},
				{true, true, true},
				{false, true, true}
		};
		
		pathRestrictions(matrix, "", 0, 0);
	}
	
	static void path(String p , int r , int c ) {
		
		if(r == 1 && c == 1) {
			System.out.print(p+", ");
			return;
		}
		
		// right
		if(c > 1) {
			path(p+"R", r, c-1);
		}
		// down
		if(r > 1) {
			path(p+"D", r-1, c);
		}
	}
	
	static int pathCount( int r , int c ) {
		
		if(r == 1 || c == 1) {
			return 1;
		}
		int count = 0;
		// right
		if(c > 1) {
			count += pathCount( r, c-1);
		}
		// down
		if(r > 1) {
			count += pathCount( r-1, c);
		}
		return count;
	}
	
	static ArrayList<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (r > 1) {
            list.addAll(pathRet(p + 'D', r-1, c));
        }

        if (c > 1) {
            list.addAll(pathRet(p + 'R', r, c-1));
        }

        return list;
    }
	
	// DIAGANOL
	
	static ArrayList<String> pathRetDia(String p , int r , int c){
		ArrayList<String> li = new ArrayList<String>();
		
		if(r == 1 && c == 1) {
			li.add(p);
			return li;
		}
		
		//right
		if(c > 1) {
			li.addAll( pathRetDia(p+"Ri", r, c-1) );
		}
		
		// Diagnol
		if(r > 1 && c > 1) {
			li.addAll( pathRetDia(p+"Dia", r-1, c-1) );
		}
		
		// down
		if(r > 1) {
			li.addAll( pathRetDia(p+"Dwn", r-1, c) );
		}
		
		return li;
	}
	
	// With Obstacle
	static void pathRestrictions(boolean[][] mat ,String p , int r , int c) {
		
		if(!mat[r][c]) {
			return;
		}
		
		if(r == mat.length-1 && c == mat.length-1) { // mat.length-1 = 2
			System.out.print(p+", ");
			return;
		}
		
		//right
		if(c  <  mat.length-1) {			
			pathRestrictions(mat, p+"R", r, c+1);
		}
		//down
		if(r < 2) {			
			pathRestrictions(mat, p+"D", r+1, c);
		}
	}
}

