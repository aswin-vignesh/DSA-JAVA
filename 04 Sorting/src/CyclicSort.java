import java.util.Arrays;

public class CyclicSort {
	
	public static void main(String[] args) {
		int[] arr = {3,5,2,1,4};
		cycle(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void cycle(int[] arr) {
		int len = arr.length;
		int i = 0;
		while(i < len) {
			int index = arr[i]-1;
			if(arr[i] != arr[index] ) {
				swap(arr, i , index);
			}else {
				i++;
			}
		}
	}
	
	static void swap (int[] arr,int a, int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
	
}
