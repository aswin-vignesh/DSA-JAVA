// LEET : 34

import java.util.Arrays;

public class BSFirstLastOccurence {
	
	public static void main(String[] args) {
		
		int nums[] = {5,7,7,8,8,10};
		System.out.println(Arrays.toString(searchRange(nums, 3)));
	}
	
	public static int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0] = bs(nums, target, true);
        if(ans[0] != -1) {
        	ans[1] = bs(nums, target, false);
        }
        return ans;
    }
	
	public static int bs(int[] nums, int target , boolean left) {
		int len = nums.length;
		int s = 0;
		int e = len-1;
		int ans = -1;
		
		while(s <= e) {
			int m = s+(e-s)/2;
			
			if(nums[m] == target) {
				ans = m;
				if(left){
					e = m -1;
				}else {
					s = m + 1;
				}
			}
			else if( target > nums[m]) {
				s = m+1;
			}else {
				e = m-1;
			}
		}
		return ans;
	}
}
