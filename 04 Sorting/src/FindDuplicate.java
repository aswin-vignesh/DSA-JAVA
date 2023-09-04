// Leet : 287

import java.util.Arrays;

public class FindDuplicate {
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate1(nums));
		System.out.println(Arrays.toString(nums));
		
	}
	public static int findDuplicate(int[] nums) {
        
		int n = nums.length;
		int i=0;
		
		while(i < n) {
			int pos = nums[i]-1;
			if(nums[i] != nums[pos]) {
				swap(nums, i, pos);
			}else {
				i++;
			}
		}
		
		for(i = 0; i < n ; i++) {
			if(nums[i] != i+1) {
				return nums[i];
			}
		}
		return -1;
    }
	public static int findDuplicate1(int[] nums) {
        
		int n = nums.length;
		int i=0;
		
		while(i < n) {
			int pos = nums[i]-1;
			if(nums[i] != nums[pos]) { // nos are same but their pos and i not same for duplicates 
				swap(nums, i, pos);
			}
			else if(i != pos) { // when pos not same its a duplicate
				return nums[i];
			}
			else {
				i++;
			}
		}
		
		return -1;
    }
	
	public static void swap(int [] arr , int a ,int b) {
		int t = arr[a];
		arr[a]= arr[b];
		arr[b] = t;
	}
	
}
