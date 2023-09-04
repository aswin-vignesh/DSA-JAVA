package com.String;

public class SkipChar {
	
	public static void main(String[] args) {
		
		System.out.println(skip("", "baccad"));
		System.out.println(skip("baabsds"));
		
		System.out.println(skipApple("anAppLeaDayKeeps"));
		System.out.println(skipAppNotApple("an apple a Day Keeps app doctor away"));
	}
	
	static String skip(String p, String up) {
		if(up.isEmpty()) {
			return p;
		}
		
		char c = up.charAt(0);
		
		if(c == 'a') {
			return skip(p, up.substring(1));
		}
		return skip(p+c, up.substring(1));
	}
	
	static String skip(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		
		if(ch == 'a') {
			return skip(up.substring(1));
		}
		return ch+skip(up.substring(1));
	}
	
	static String skipApple(String up) {
		if(up.isEmpty()) {
			return "";
		}
		
		char ch = up.charAt(0);
		if(up.toLowerCase().startsWith("apple")) {
			return skipApple( up.substring(5) );
		}
		return ch+ skipApple(up.substring(1));
	}
	
	static String skipAppNotApple(String up) {
		if(up.isEmpty()) {
			return  "";
		}
		
		char ch = up.charAt(0);
		
		if(up.toLowerCase().startsWith("app") && !up.toLowerCase().startsWith("apple")) {
			return skipAppNotApple(up.substring(3));
		}
		return ch + skipAppNotApple(up.substring(1));
	}
	
}
