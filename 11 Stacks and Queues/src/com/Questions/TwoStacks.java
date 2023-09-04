package com.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoStacks {
	
	public static void main(String[] args) {
		
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		
		a.add(4);
		a.add(7);
		a.add(4);
		a.add(6);
		a.add(1);
		
		b.add(2);
		b.add(9);
		b.add(8);
		b.add(5);
		
		System.out.println(helper(10, a, b, 0,0));
		
	}
	
	
	/// my solutions works good for sample test case but not optimized
	public static int helper(int maxSum, List<Integer> a, List<Integer> b, int count , int nos) {
	    
		if(a.size() == 0 || b.size() == 0) {
			return nos;
		}
		
		int max = -1;
		int no1= a.get(0);
		
		// left
		if(count + no1 <= maxSum) {
			a.remove(0);
			max = Math.max(max,  helper(maxSum, a, b, count+no1 , nos+1)  );
			a.add(0, no1);
		}
		
		int no2 = b.get(0);
		// right
		if(count + no2 <= maxSum) {
			b.remove(0);
			max = Math.max(max ,  helper(maxSum, a, b, count+no2 , nos+1) );
			a.add(0, no2);
		}
		
		if(count + no1 > maxSum &&  count + no2 > maxSum) {
			return nos;
		}
		
		
		return max;
		
		
    }
	
	// kunals ans // which is not perfect too
	
	@SuppressWarnings("unused")
	private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {
	    if (sum > x) {
	      return count;
	    }

	    if (a.length == 0 || b.length == 0) {
	      return count;
	    }

	    int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
	    int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + a[0], count + 1);

	    return Math.max(ans1, ans2);
	  }
	
}
