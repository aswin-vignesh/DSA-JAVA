import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int[] arr = {78,77,34,23,11,5};
//		bubbleOpti(arr);
//		selection(arr);
		insertion(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void bubble(int[] arr) {
		int len = arr.length;
		
		for(int i=0 ; i < len ; i++) {
					
			for(int j=0 ; j < len-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
				System.out.println(Arrays.toString(arr));
			}
			System.out.println();
		}
	}
	
	static void bubbleOpti(int[] arr) {
		int len = arr.length;
		boolean swapped = false;
		
		for(int i=0 ; i < len-1 ; i++) {  // -1 to skip the 1st element check in last iteration
			swapped = false;
			
			for(int j=0 ; j < len-i-1 ; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
//				System.out.println(Arrays.toString(arr));
			}
//			System.out.println();
			if(swapped == false) {
				break;
			}
		}
	}
	
	static void selection(int[] arr) {
		int len = arr.length;
		
		for(int i=0 ; i < len-1 ; i++) { // -1 to skip the 1st element check in last iteration
			
			int maxI = -1;
			int max = Integer.MIN_VALUE;
			
			for(int j=0 ; j < len-i ; j++) {
				if(arr[j] > max) {
					max = arr[j];
					maxI = j;
				}
			}
			
			swap(arr, maxI, len-i-1);
		}
	}
	
	static void insertion(int[] arr) {
		int len = arr.length;
		
		for(int i=0 ; i < len-1 ; i++) {
			for(int j=i+1 ; j > 0 ; j--) {
				if(arr[j] < arr[j-1]) {
					swap(arr, j, j-1);
				}else {
					break;
				}
			}
		}
	}
	
	static void swap (int[] arr , int a ,int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
