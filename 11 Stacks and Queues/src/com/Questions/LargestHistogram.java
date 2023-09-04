// Leet : 84
// Explanation https://leetcode.com/problems/largest-rectangle-in-histogram/solutions/1727776/java-c-explanation-going-from-brute-to-optimal-approach/

package com.Questions;

//import java.util.Arrays;
import java.util.Stack;

public class LargestHistogram {
	
	public static void main(String[] args) {
		
		
		int[] heights = {2,1,5,6,2,3};
		
		System.out.println(largestRectangleArea(heights));
	}
	
	public static int largestRectangleArea(int[] heights) {
	    Stack<Integer> stack = new Stack<>();
	    int max = 0;

	    stack.push(0);

	    for (int i = 1; i < heights.length; i++) {
	    	// when decreasing pop from stack
	      while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
	        max = getMax(heights, stack, max, i);
	      }
	      stack.push(i);
	    }

	    int i = heights.length;
	    while (!stack.isEmpty()) {
	      max = getMax(heights, stack, max, i);
	    }

	    return max;
	  }

	  private static int getMax(int[] arr, Stack<Integer> stack, int max, int i) {
	    int area;
	    int popped = stack.pop();
	    if (stack.isEmpty()) {
	      area = arr[popped] * i;
	    } else {
	    	// area = right - left - 1 ;
	    	//      =  i - peek - 1; // peek since it is smaller than popped
	      area = arr[popped] * (i - 1 - stack.peek());
	    }
	    return Math.max(max, area);
	  }
}
