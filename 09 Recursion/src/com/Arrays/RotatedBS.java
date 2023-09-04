package com.Arrays;

public class RotatedBS {
	
	public static void main(String[] args) {
		int[] arr = {33,45,51,1,2,4,5,12,14,15,25};
		
		int ans = rbs(arr, 5, 0, arr.length-1);
		
		System.out.println(ans);
	}
	
	static int rbs(int[] arr,int tar,int s , int e) {
		
		if(s > e) {
			return -1;
		}
		
		int m = s + (e-s)/2;
		
		if(arr[m] == tar) {
			return m;
		}
		
		// asc
		if(arr[s] <= arr[m]) {
			
			if(arr[s] <= tar && arr[m] >= tar) {
//				e = m-1;
				return rbs(arr, tar, s, m-1);
			}else {
//				s = m+1;
				return rbs(arr, tar, m+1, e);
			}
		}
		// unsorted part
		if(tar >= arr[m] && tar <= arr[e]) {
//			s = m+1;
			return rbs(arr, tar, m+1, e);
		}
//		else
//		e = m-1;
		return rbs(arr, tar, s, m-1);
	}
}
