
public class NoOccurOnce {
	public static void main(String[] args) {
		
		int[] arr = {2,3,4,1,2,1,3};
		noOccur(arr);
	}
	
	static void noOccur(int[] arr) {
		
		int sum = 0;
		for(int i : arr) {
			sum ^= i; 
		}
		System.out.println(sum);
	}
}
