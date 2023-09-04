// LEET : 20

package com.Questions;

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String[] args) {
		
		String s = "()[]{}";
		System.out.println(isValid(s));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> st = new Stack<>();
		
		char[] cArr = s.toCharArray();
		
		for(char ch : cArr ) {
			if(ch == '{' || ch == '(' || ch == '[') {
				st.push(ch);
			}else {
				if(ch == ')') {
					if(st.isEmpty() || st.pop() != '(') {
						return false;
					}
				}
				if(ch == '}') {
					if(st.isEmpty() || st.pop() != '{') {
						return false;
					}
				}
				if(ch == ']') {
					if(st.isEmpty() || st.pop() != '[') {
						return false;
					}
				}
				
			}
		}
		return st.isEmpty();
    }
	
}
