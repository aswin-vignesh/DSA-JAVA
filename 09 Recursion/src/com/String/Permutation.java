package com.String;

import java.util.ArrayList;

public class Permutation {
	public static void main(String[] args) {
		permutation("", "abc");
		
		System.out.println(permRet("", "abc"));
	}
	
	static void permutation(String p , String up) {
		
		if(up.isEmpty()) {
			System.out.print(p+", ");
			return;
		}
		
		char ch = up.charAt(0);
		
		for(int i=0 ; i <= p.length() ; i++) {
			
			String first = p.substring(0,i);
			String second = p.substring(i,p.length());
			
			permutation(first + ch + second ,up.substring(1));
		}
	}
	
	static ArrayList<String> permRet(String p ,String up){
		
		ArrayList<String> li = new ArrayList<String>();
		
		if(up.isEmpty()) {
			li.add(p);
			return li;
		}
		
		char ch = up.charAt(0);
		
		for(int i=0 ; i <= p.length() ; i++) {
			
			String f = p.substring(0,i);
			String s = p.substring(i,p.length());
			
			li.addAll( permRet( f + ch + s, up.substring(1)) );
		}
		return li;
	}
	
	static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCount(f + ch + s, up.substring(1));
        }
        return count;
    }
}
