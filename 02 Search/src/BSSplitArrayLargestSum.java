// LEET : 410

public class BSSplitArrayLargestSum {
	public static void main(String[] args) {
		
//		int[] nums = {7,2,5,10,8};
		int[] nums = {1,2,3,4,5};
		int target = 2;
		
		System.out.println(splitArray(nums, target));
	}
	public static int splitArray(int[] nums, int k) {
	
		int len = nums.length;
        int min = 0;
        int max = 0;
        for(int i=0 ; i < len ; i++) {
        	int no = nums[i];
        	min = Math.max(no,min);
        	max += no;
        }
        
        int start = min , end = max;
        
        while(start < end) {
        	
        	int m = start + (end - start)/2;
        	
        	//get pieces
        	int tot = 0;
        	int pieces = 1;
        	for(int i=0 ; i < len ; i++) {
            	int no = nums[i];
            	tot += no;
            	if(tot > m) {
            		tot = no;
            		pieces++;
            	}
            }
        	
        	if(pieces <= k) {
        		end = m;
        	}else {
        		start = m+1;
        	}
        }
        
        return start;
    }
}

