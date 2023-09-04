// LEET : 41


public class FirstMissingPositive {
	
	public static void main(String[] args) {
		
	}
	
	public static int firstMissingPositive(int[] nums) {
        
		int i= 0;
		int n = nums.length;
		
		while(i < n) {
			int pos = nums[i]-1;
			
			if(pos >= 0 && pos < n && nums[i] != nums[pos]) {
				swap(nums, i, pos);
			}else {
				i++;
			}
		}
		for( i = 0 ; i < n; i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		return -1;
			
    }
	public static void swap(int[] nums , int a , int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
}
