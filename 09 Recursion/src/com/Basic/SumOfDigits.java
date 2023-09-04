package com.Basic;

public class SumOfDigits {
	
	public static void main(String[] args) {
		
		System.out.println(sum(1342, 0));
		System.out.println(sum(1342));
	}
	
	static int sum(int num,int tot) {
		
		if(num == 0) {
			return tot;
		}
		
		int last = num%10;
		tot += last;
		
		return sum(num/10, tot);
	}
	
	static int sum(int n) {
		if(n/10 == 0) {
			return n;
		}
		int last = n%10;
		
		return last + sum(n/10);
	}
}
