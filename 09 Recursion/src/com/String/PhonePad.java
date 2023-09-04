// LeetCode : 17

package com.String;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
	
	public static void main(String[] args) {
		
		System.out.println( letterCombinations("79") );
	}
	
	
	static void pad(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            pad(p + ch, up.substring(1));
        }

    }
	
	public static List<String> padRet(String p , String up, List<String> li){
		
		if(up.isEmpty()) {
			li.add(p);
			return li;
		}
		
		int digit = up.charAt(0) - '0';
		int bot = (digit-2)*3;
		int top = (digit-1)*3;
		
		if(digit == 7 || digit == 8 || digit == 9) {
			top = top+1;
			
			if(digit != 7) {
				bot += 1;
			}
			if(digit == 9) {
				top += 1;
			}
		}
		
		
		
		
		for(int i = bot ; i < top ; i++ ) {
			
			char ch = (char) ('a'+i);
			
			padRet(p+ch, up.substring(1),li);
		}
		
		return li;
	}
	
	public static List<String> letterCombinations(String digits) {
		
		return padRet("", digits,new ArrayList<String>());
        
    }
	
}
