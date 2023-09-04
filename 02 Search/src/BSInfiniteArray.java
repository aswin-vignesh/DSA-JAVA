// AMAZON QUESTION - INFINITE ARRAY


public class BSInfiniteArray {
	public static void main(String[] args) {
		int[] arr = {3,7,9,11,14,15,17,19,23,25,29,41,43,45,49,51};
		
		System.out.println(infiniteArray(arr, 49,0,1));
	}
	
	static int infiniteArray(int[] arr , int tar , int start , int end) {
//		int start = 0;
//		int end = start+1;
		
		if(end - start < 0) {
			return -1;
		}
//	    Did it !!!!!!!!!!!! 	
		try {
			while(tar > arr[end]) {
				int oldS = start;
				start = end+1;
				end += (end+1-oldS)*2;
			}			
		}catch(ArrayIndexOutOfBoundsException e) {
			end = end - (end-start)/2 - 1;
			return infiniteArray(arr, tar , start, end);
		}
		
		
		System.out.println("s :"+start +" end: "+end);
		
		return bs(arr, tar, start, end);
		
	}
	static int bs(int[] arr , int tar , int s , int e) {
		
		while(s <= e) {
			int m = s+(e-s)/2;
			
			if(arr[m] == tar) {
				return m;
			}else if(tar > arr[m]) {
				s = m+1;
			}else {
				e = m-1;
			}
		}
		return -1;
	}
	
}
