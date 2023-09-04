import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicates {
	
	public static void main(String[] args) {
		
		int[] nums = {4,3,2,7,8,2,3,1};
		
		System.out.println(findDuplicates(nums));
		System.out.println(Arrays.toString(nums));
	}
	
	
//	 time limi exceeds for this one // forloop is betters
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> li = new ArrayList<Integer>();
		
		int n= nums.length;
		int i=0;
		
		while ( i < n) {
			
			int pos = nums[i]-1;
			int val = nums[i];
			
			if( val != nums[pos]) {
				swap(nums, i, pos);
			}else if( i != pos) {
				if(!li.contains(val)) {					
					li.add(val);
				}
				i++;
			}else {
				i++;
			}
		}
		return li;
    }
	
	public static void swap(int[] nums , int a , int b) {
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
}
