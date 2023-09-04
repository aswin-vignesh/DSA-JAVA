// LEET : 268

public class MissingNumber {

	public static void main(String[] args) {
		int[] nums = {0,2};
		
		System.out.println(missingNumber(nums));
		
	}
	
//	 can use actual sum - sum or Xor sum for faster execution
	public static int missingNumber(int[] nums) {
        
		int len = nums.length;
		int i=0;
		while(i < len) {
			int val = nums[i];
			int corPos = val;
			
			if(corPos < len && val != nums[corPos]) {
				swap(nums, i , corPos);
			}else {
				i++;
			}
		}
		
		for(int j=0 ; j < len ; j++) {
			if(nums[j] != j) {
				return j;
			}
		}
		return len;
    }
	public static void swap(int []nums , int a ,int b) {
		
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
}
