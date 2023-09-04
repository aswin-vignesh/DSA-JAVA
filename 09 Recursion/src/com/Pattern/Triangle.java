package com.Pattern;

import java.util.Arrays;

public class Triangle {
	public static void main(String[] args) {
		
		triangle(5, 0);
		
		int[] arr = {5,1,6,7,2,4,9};
		int[] nums = {5,1,6,7,2,4,9,0};
		int[] nums1 = {5,1,6,7,2,4,9,0,11};
		
		bubble(arr , arr.length-1, 0);
		selection(nums, nums.length-1, 0, 0);
		selection1(nums1, nums1.length , 0, 0);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(nums1));
	}
	
	static void triangle(int r , int c) {
		if(r == 0) {
			return;
		}
		
		if(c < r) {
			System.out.print('*');
			triangle(r, c+1);
//			System.out.print('*');  //inverted
		}else {
			System.out.println();
			triangle(r-1, 0);
//			System.out.println(); // inverted
		}
	}
	
	static void bubble(int[] arr ,int r , int c) {
		if(r == 0) {
			return;
		}
		if(c < r) {
			if(arr[c] > arr[c+1] ) {
				int t = arr[c];
				arr[c] = arr[c+1];
				arr[c+1] = t;
			}
			bubble(arr, r, c+1);
		}
		else {
			bubble(arr, r-1, 0);
		}
				
	}
	
	static void selection(int[] arr , int r ,int c , int maxI) {
		if(r == 0) {
			return;
		}
		
		if(c < r) {
			if(arr[c+1] > arr[maxI]) {
				maxI = c+1;
			}
			selection(arr, r, c+1, maxI);
		}else {
			int t = arr[maxI];
			arr[maxI] = arr[r];
			arr[r] = t;
			selection(arr, r-1, 0, 0);
		}
	}
	static void selection1(int[] arr , int r ,int c , int maxI) {
		if(r == 0) {
			return;
		}
		if(c < r) {
			if(arr[c] > arr[maxI]) {
				maxI = c;
			}
			selection1(arr, r, c+1, maxI);
		}else {
			int t = arr[maxI];
			arr[maxI] = arr[r-1];
			arr[r-1] = t;
			selection1(arr, r-1, 0, 0);
		}
	}
}
