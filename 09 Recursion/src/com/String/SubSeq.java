package com.String;

import java.util.ArrayList;

public class SubSeq {
	public static void main(String[] args) {
		
		subseq("", "abc");
		System.out.println(subseqRet("","abc"));
		
//		Ascii
		subseqAscii("", "ab");
		
	}
	
	static void subseq(String p , String up) {
		if(up.isEmpty()) {
			System.out.print(p+" , ");
			return;
		}
		
		char ch = up.charAt(0);
		
		//include
		subseq(p+ch, up.substring(1));
		
		// not include
		subseq(p, up.substring(1));
	}
	
	static ArrayList<String> subseqRet(String p , String up) {
		ArrayList<String> li = new ArrayList<String>();
		
		if(up.isEmpty()) {
			li.add(p);
			return li;
		}
		
		char ch = up.charAt(0);
		
		//include
		 li.addAll( subseqRet(p+ch, up.substring(1)) );
		
		// not include
		li.addAll( subseqRet(p, up.substring(1)) );
		
		return li;
	}
	
	static void subseqAscii(String p , String up) {
		if(up.isEmpty()) {
			System.out.print(p+" , ");
			return;
		}
		
		char ch = up.charAt(0);
		
		//include
		subseqAscii(p+ch, up.substring(1));
		
		//Ascii
//		subseqAscii(p+((int)(ch)), up.substring(1));
		subseqAscii(p+(ch + 0), up.substring(1));
		
		// not include
		subseqAscii(p, up.substring(1));
	}
}
