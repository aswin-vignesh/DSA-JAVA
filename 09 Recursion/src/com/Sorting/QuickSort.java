//  COMPLEXITY
 /*
  	worst case = O(N2)
  	best case = O(NlogN)
  	
  */

package com.Sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		
		int[] arr = {14,9,7,1,5,0,3,2,11,21,4,10};
		quickSort(arr, 0, arr.length-1);
		
		System.out.println(Arrays.toString(arr));
	}
	
	static void  quickSort(int[] arr , int low, int high) {
		
		if(low >= high) {
			return;
		}
				
		int s = low;
		int e = high;
		int m = s+(e-s)/2;
		
		int pivot = arr[m];
		
		while(s <= e) {
			if(arr[s] < pivot) {
				s++;
				continue;
			}
			if(arr[e] > pivot) {
				e--;
				continue;
			}
			
			//swap
			if(s <= e) {
				int t = arr[s];
				arr[s] = arr[e];
				arr[e] = t;
				s++;
				e--;
 			}
		}
		
		// now my pivot is at correct index, please sort two halves now
		quickSort(arr,low,e);
		quickSort(arr,s,high);
		
	}
}
