package com.Questions;

import java.util.Stack;


public class MinInsertionsParentheses {
	public static void main(String[] args) {
		
		String s = "))())";
		System.out.println(minInsertions(s));
	}
	
	// solutions isn't clear
	public static int minInsertions(String s) {
		int ans=0;       
        int cnt=0;
        for(char ch:s.toCharArray()){     
            if(ch=='(') {
                cnt+=2;  
                if(cnt%2!=0){
                    ans++;
                    cnt--;
                }
            }
            else{       
                cnt-=1;
                if(cnt<0){
                    ans++;
                    cnt+=2;
                } 
            }           
        }

        return ans+cnt;
    }
	
	// another solution
	public int minInsertions2(String s) {
        Stack<Character> stack=new Stack<>();
        int count=0;
        for(int i=0;i<s.length();i++){
        	// -Keep adding left brackets
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                if(i+1<s.length()&& s.charAt(i+1)==')'){
                    // -Skip it as two consecutives are present
                    i++;
                }else count++;
                
                if(!stack.isEmpty()){
                    stack.pop();
                }else count++ ;
            }
        }
        count+=2*stack.size();
        return count;
    }
}
