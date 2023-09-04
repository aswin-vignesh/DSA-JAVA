// LEET : 852


public class BSMountainArray {
	public static void main(String[] args) {
		int[] arr = {0,1,0,-1};
		
		System.out.println(peakIndexInMountainArray(arr));
	}
	public static int peakIndexInMountainArray(int[] arr) {
		int len = arr.length;
        int s =0;
        int e = len-1;
        
        while(s < e) {
        	int m = s + (e-s)/2;
        	
        	if(arr[m] > arr[m+1]) { // desc
        		e  = m;
        	}
        	if(arr[m]  > arr[m-1]) { // asc
        		s = m;
        	}
        }
        return s;
    }
//	 OR ----
	public static int peakIndexInMountainArray2(int[] arr) {
		int len = arr.length;
        int s =0;
        int e = len-1;
        
        while(s < e) {
        	int m = s + (e-s)/2;
        	
        	if(arr[m] > arr[m+1]) { // desc
        		e  = m;
        	}
        	if(arr[m]  < arr[m+1]) { // asc
        		s = m+1;
        	}
        }
        return s;
    }
}
