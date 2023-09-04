// LEET : 448

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissing {
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers(nums));
		System.out.println(Arrays.toString(nums));
		
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> li = new ArrayList<Integer>();
		
		int i = 0;
		int n = nums.length;
		
		while(i < n) {
			int pos = nums[i]-1;
			
			if(nums[i] != nums[pos]) {
				swap(nums,i,pos);
			}else {
				i++;
			}
			
		}
		
		for(i=0 ; i < n ; i++) {
			if(nums[i]-1 != i) {
				li.add(i+1);
			}
		}
		
		return li;
		
		
	}
	public static void swap(int[]arr,int a,int b) {
		int t = arr[a];
		arr[a] = arr[b];
		arr[b] = t;
	}
}
