package com.Basic;

public class CountZeros {
	public static void main(String[] args) {
		
		int n = 3020400;
		System.out.println(n);
		
		System.out.println(zeros(n, 0));
		System.out.println(zeros1(n, 0));
	}
	
	static int zeros(int n, int c) {
		if(n == 0) {
			return c;
		}
		
		if(n%10 == 0) {
			c++;
		}
		return zeros(n/10, c);
	}
	static int zeros1(int n, int c) {
		if(n == 0) {
			return c;
		}
		
		if(n%10 == 0) {
			return zeros(n/10, c+1);
		}
		return zeros(n/10, c);
	}
}
