//import java.util.Arrays;

public class Recursion {
	public static void main(String[] args) {
		
//		int[] arr = {1,2,3,4,5,6,7,8,9,10};
//		System.out.println(bs(arr, 11, 0, arr.length-1));
		
//		print(0);
//		System.out.println(fibo(47));
		System.out.println(fiboEqn(51));
//		System.out.println(fiboDP(47));
		
	}
	
	static void print(int num) {
		if(num == 5) {
			return;
		}
		System.out.println(num);
		print(num+1);
	}
	static int fibo(int n) {
		if(n < 2) {
			return n;
		}
		int a1 = fibo(n-1) ;
		int a2 = fibo(n-2);
		int ans= a1+a2;
		return ans;
	}
	
	static long fiboEqn(int n) {
		return (long) ( (Math.pow( (1+Math.sqrt(5))/2 , n) - Math.pow( (1-Math.sqrt(5))/2 , n))/Math.sqrt(5)  );
	}
	
	static int fiboDP(int n) {
		int[] memo = new int[n+1];
		memo[0] = 0;
		memo[1] = 1;
		
		return fiboHelper( n , memo);
		
		
		
	}
	
	static int fiboHelper(int n , int[] memo) {

		if(n < 2) {
			return n;
		}
		
		if(memo[n] != 0) {
			return memo[n];
		}else {
			int ans = fiboHelper(n-1,memo) + fiboHelper(n-2,memo);
			memo[n] = ans;
			return ans;
		}
	}
	
	static int bs(int[] arr, int tar , int s , int e) {
		if( s > e) {
			return -1;
		}
		
		int m = s+(e-s)/2;
		
		if(arr[m] == tar) {
			return m;
		}
		else if(tar > arr[m]) {
			return bs(arr, tar, m+1, e);
		}
		else {
			return bs(arr, tar, s, m-1);
		}
	}
}
