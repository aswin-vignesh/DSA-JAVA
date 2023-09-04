
public class Prime {
	public static void main(String[] args) {
		
		int n = 101;
		boolean[] arr = new boolean[n+1]; // from 0 to 101
		sieve(n, arr);
		
		int c = 0;
		for(boolean i : arr) {
			if(!i) {
				System.out.print(c++ + " ");
				continue;
			}
			c++;
		}
	}
	static void sieve(int num , boolean[] arr) {
		
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i=0 ; i < num ; i++) {
			if(!arr[i]) {
				for(int j= i*2 ; j < num ; j+= i) {
					arr[j] = true;
				}
			}
		}
	}
}
