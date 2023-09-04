
// Complexity : O(NLOGN) 

package com.Sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String[] args) {
		
//		int[] ans = merge(new int[] {0,2,5,7,20}, new int[] {1,4,6,9});
//		System.out.println(Arrays.toString(ans));
		
		int[] arr = {14,9,7,1,5,0,3,2,11,21,4,10};
		int[] ans = mergeSortKunal(arr);
		
		System.out.println(Arrays.toString(ans));
		System.out.println(Arrays.toString(arr));
		
		mergeSortInplace(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	static int[] mergeSort(int[] list){
		if(list.length <= 1) {
			return list;
		}
		int s = 0;
		int e = list.length-1;
		int mid = s + (e-s)/2;
		
		// split
		int[] left = mergeSort( Arrays.copyOfRange(list, s, mid+1)  ); // mid include
		int[] right = mergeSort( Arrays.copyOfRange(list, mid+1,e+1)   );
		
		return merge(left, right);
		
	}
	static int[] mergeSortKunal(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }
	
	static int[] merge(int[] left , int[] right) {
//		int i = left.length;
//		int j = right.length;
//		int k = i+j;
		
		int i=0 , j=0, k=0;
		
		int[] arr = new int[left.length+right.length];
		
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
			}else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < left.length) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while(j < right.length) {
			arr[k] = right[j];
			j++;
			k++;
		}
		return arr;
	}
	
	static void mergeSortInplace(int[] arr , int s , int e) {
		
		// when len is 1
		if(e-s == 0) {
			return;
		}
		
		int m = s + (e-s)/2;
		
		// left
		mergeSortInplace(arr,s,m);
		//right
		mergeSortInplace(arr,m+1,e);
		
		//replace items
		mergeInplace(arr,s,m,e);
	}
	
	static void mergeInplace(int[] arr , int s , int m , int e) {
		int i = s, j = m+1, k = 0;
		int len = (e-s)+1; //for [2,3] len = (1-0)+1 => 2
		int[] mix = new int [len];
		
		//arr1 => s till m
		// arr2 => m+1 till e
		
		//  s     m     e
		// [0,1,2,3,4,5,6]   
	//  j           0 1 2
		
		while(i <= m && j <= e) {
			if(arr[i] <= arr[j]) {
				mix[k] = arr[i];
				i++;
			}else {
				mix[k] = arr[j];
				j++;
			}
			k++;
		}
		while(i <= m) {
			mix[k] = arr[i];
			i++;
			k++;
		}
		while(j <= e) {
			mix[k] = arr[j];
			j++;
			k++;
		}
		
		// now change the original arr
		
			//          s m e    0 1 2
			// [0,1,2,3,4,5,6]  [4,5,6]   
		for(int pos = 0 ; pos < len ; pos++ ) {
			arr[s+pos] = mix[pos];
		}
	}
}
