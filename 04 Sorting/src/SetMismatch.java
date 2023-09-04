import java.util.Arrays;

public class SetMismatch {
	public static void main(String[] args) {
		int[] nums = {8,7,3,5,3,6,1,4};
		
		System.out.println(Arrays.toString(findErrorNums(nums)));
		System.out.println(Arrays.toString(nums));
	}
	
	
//	 not completely working so use for loop
	public static int[] findErrorNums(int[] nums) {
        
		int n = nums.length;
		int i = 0;
		
		while(i < n) {
			int pos = nums[i]-1;
			
			if(nums[i] != nums[pos]) {
				swap(nums, i, pos);
			}else if(i != pos) {
				return new int[] {nums[i],i+1};
			}else {
				i++;
			}
		}
		return new int[] {-1,-1};		
    }
	public static void swap(int[] nums , int a , int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
}
