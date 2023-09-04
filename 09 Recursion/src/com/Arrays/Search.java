package com.Arrays;

import java.util.ArrayList;

public class Search {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,4,5,12,12,14,15,25,33,45,45,45,51};
		
		System.out.println(linearSearch(arr, 46, 0));
		
		System.out.println(ls(arr, 45, 0));
		
		System.out.println(binarySearch(arr, 25, 0, arr.length-1));
	}
	
	static int linearSearch(int[] arr, int tar, int i) {
		if(i == arr.length) {
			return -1;
		}
		
		if( arr[i] == tar) {
			return i;
		}
		return linearSearch(arr, tar, i+1);
	}
	
	static ArrayList<Integer> ls(int[] arr , int tar , int i){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(i == arr.length) {
			return list;
		}
		
		if(arr[i] == tar) {
			list.add(i);
		}
		
		ArrayList<Integer> below = ls(arr, tar, i+1);
		
		list.addAll(below);
		
		return list;
	}
	
	
	static int binarySearch(int[] arr, int tar, int s, int e) {
		if(s > e) {
			return -1;
		}
		int m = s + (e-s)/2;
		
		if( arr[m] == tar) {
			return m;
		}
		else if( tar > arr[m]) {
			return binarySearch(arr, tar, m+1, e);
		}
		return binarySearch(arr, tar, s, m-1);
	}
}
