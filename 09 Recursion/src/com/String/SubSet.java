package com.String;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
	
	public static void main(String[] args) {
		
		
		// EXPLANATION of new Array
//		ArrayList<Integer> in = new ArrayList<Integer>();
//		in.add(1);in.add(2);in.add(3);
//		
//		ArrayList<Integer> out = new ArrayList<Integer>(in);
//		
//		System.out.println(out);
		
		System.out.println(subset(new int[] {1,2,3}));
		System.out.println(subsetDuplicate(new int[] {1,2,2}));
		
	}
	
	static List<List<Integer>> subset(int[] arr) {
       
		List<List<Integer>> outer = new ArrayList<List<Integer>>(); 
		
		outer.add(new ArrayList<Integer>());   // [ [] ] is initialized
		
		for(int num : arr ) {  // {1,2,3}
			
			// we are going to insert nums to existing inner array of the outer
			
			int n = outer.size();  
			
			for(int i=0 ; i < n ; i++) {
				
				List<Integer> inner = new ArrayList<Integer>(outer.get(i)); // [] initially   []            [1]
				inner.add(num); 											// [1] now        [2]           [1,2]
				outer.add(inner);											// [[],[1]]       [[],[1],[2]]  [[],[1],[2],[1,2]]
			}
			// next add 3 to them [[],[1],[2],[1,2]] -> [3],[1,3],[2,3],[1,2,3] to outter -> ans
		}
		return outer;
    }
	
	static List<List<Integer>> subsetDuplicate(int[] arr) {
        
		List<List<Integer>> outer = new ArrayList<List<Integer>>();
		
		// initialize an empty
		outer.add(new ArrayList<Integer>());
		
		int s = 0;
		int e = 0;  // end here is used to track the previous iterations length
		
		for(int i=0 ; i < arr.length ; i++) {
			
			s = 0; // normally s = 0
			
//			change start when we have duplicate -> skip the previous input list
			if(i > 0 && arr[i] == arr[i-1]) {  // duplicate check
				s = e + 1; // this e will hold the previous end value
			}
			
			e = outer.size()-1; // recording current input limit which might be used for the next
			int n = outer.size();
			for( int j=s ; j < n ; j++ ) {
				
				List<Integer> inner = new ArrayList<Integer>(outer.get(j));
				inner.add(arr[i]); // add num
				outer.add(inner);  // add to outer
				
			}
		}
		return outer;
    }
	
	
}
