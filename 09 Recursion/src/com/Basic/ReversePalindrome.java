package com.Basic;

public class ReversePalindrome {
	
	public static void main(String[] args) {
		
		int n = 12345;
		
		System.out.println(reverse(n));
		System.out.println(rev(n));
		System.out.println(rev1(n, 0));
		System.out.println(isPalin(n));
	}
	
	static int reverse(int n) {
		if(n/10 == 0) {
			return n;
		}
		
		int last = n%10;
		
		int digit = (int) (Math.log10(n)); // no need +1 since we are going to do 4 * 10^digits-1; 
		
		return (last * (int)Math.pow(10, digit)) + reverse(n/10);
	}
	
	static boolean isPalin(int n) {
		return reverse(n) == n;
	}
	
	static int sum = 0;
	static int rev(int n ) {
		if(n == 0) {
			return sum;
		}
		int last = n%10;
		sum = sum*10 + last;
		return rev(n/10);
	}
	static int rev1(int n , int sum) {
		if(n == 0) {
			return sum;
		}
		int last = n%10;
		sum = sum*10 + last;
		return rev1(n/10,sum);
	}
	
}
