
public class BSRotatedSortedSearch {
	
	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		System.out.println(pivot(nums));
//		System.out.println(search(nums, 0));
	}
	
	public static int search(int[] nums, int target) {
       int pivot = pivot(nums);
       int ans = bs(nums, target, 0 , pivot-1);
       if(ans == -1) {
    	   ans = bs(nums, target, pivot , nums.length-1);
       }
       return ans;
    }
	public static int pivot(int[] nums) {
		int len = nums.length;
        int s = 0;
        int e = len-1;
        
        while( s <= e) {
        	int m = s+(e-s)/2;
        	
        	if(m+1 < len && nums[m] > nums[m+1] ) {
        		return m+1;
        	}
        	if( m-1 >= 0 && nums[m] < nums[m-1]) {
        		return m;
        	}
        	if(nums[s] >= nums[m]) {
        		e = m-1;
        	}else {
        		s = m+1;
        	}
        }
        return -1;
    }
	
	public static int bs(int[] nums,int target , int s , int e) {
		while(s <= e) {
			int m = s+(e-s)/2;
			
			if(nums[m] == target) {
				return m;
			}
			else if(target > nums[m]) {
				s = m+1;
			}else {
				e = m-1;
			}
		}
		return -1;
	}
	
}
