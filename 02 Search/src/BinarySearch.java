
public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {0,2,3,5,6,11,14,19,24,29,65};
//		int[] arr1 = {21,19,12,11,9,7,5,2,1};
		
//		System.out.println(oaBS(arr1, 19));
		System.out.println(bsFC(arr, 1, false));
		
	}
	
	static int bs(int[] arr , int tar) {
		int len = arr.length;
		int s = 0;
		int e = len-1;
		
		while(s <= e) {
			int mid = s + (e-s)/2;
			
			if(arr[mid] == tar) {
				return mid;
			}else if(tar > arr[mid]) {
				s = mid+1;
			}else {
				e = mid-1;
			}
		}
		return -1;
	}
	
	// order agnostic BS
	static int oaBS(int[] arr, int tar) {
		
		int s =0;
		int e = arr.length-1;
		
		boolean asc = arr[s] < arr[e];
		
		while(s <= e) {
			int m = s+ (e-s)/2;
			
			if(arr[m] == tar) {
				return m;
			}
			
			if(asc) {
				if (tar > arr[m]) {
					s = m+1;
				}else {
					e = m-1;
				}
			}else {
				if(tar < arr[m]) {
					s = m+1;
				}else {
					e = m-1;
				}
			}
		}
		return -1;
	}
	
	static int bsFC(int[] arr , int tar , boolean isFloor) {
		int s = 0 ;
		int e = arr.length-1;
		int len = arr.length;
		
		while(s <= e) {
			
			int m = s+(e-s)/2;
			
			if(arr[m] == tar) {
				return m;
			}
			else if(tar > arr[m]) {
				s = m+1;
			}else {
				e = m-1;
			}
		}
		if(isFloor) {
			int ans = e<0?len-1:e;
			return ans ; // floor
		}
		return s%len; // ceil
	}
}
