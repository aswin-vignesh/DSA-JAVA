// LEET : 921

package com.Questions;

import java.util.Stack;

public class ValidMinAddParentheses {
	public static void main(String[] args) {
		
	}
	public static int minAddToMakeValid(String s) {
        
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && ch == ')' && st.peek() == '('){
                st.pop() ;
            }else{
                st.push(ch);
            }
        }
        return st.size();
    }
}
