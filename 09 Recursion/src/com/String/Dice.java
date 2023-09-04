package com.String;

import java.util.ArrayList;

public class Dice {
	
	public static void main(String[] args) {
		//1 
		dice("", "4"); 						// all possiblities from digit 1 to 4
				System.out.println();
			
		//2
		System.out.println(diceRet("", 4));  // all possiblities from digit 1 to 4
				System.out.println();
			
		//3
		System.out.println(diceRet("", 6,2));  // possiblities from digit 1 to 4 with only two digits i.e [33] [24]
		
		//4
		diceFace("", 4, 3); 	// possiblities from digit 1 to 4 with nos only having 1,2,3  i.e [112] [13]
				System.out.println();
		//5	
		diceFace("", 6, 4,2);	// possiblities from digit 1 to 6  with nos only having 1,2,3,4 WHICH HAS only 2 digit output
	}
	
	static void dice(String p , String up) {
		
		if(up.equals("0")) {
			System.out.print(p+", ");
			return;
		}
		
		int digit = up.charAt(0)-'0';
		
		for(int i=1 ; i<=digit ; i++) {
			dice(p+i, (digit-i)+"");
		}
	}
	
	//kunals
	static ArrayList<String> diceRet(String p, int target) {
        if (target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i));
        }
        return list;
    }
	
	
	static ArrayList<String> diceRet(String p, int target , int len) {
		ArrayList<String> list = new ArrayList<>();

		if (target == 0) {
			if(p.length() == len) {
				list.add(p);
				return list;
			}
            return list;
        }
        for (int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRet(p + i, target - i,len));
        }
        return list;
    }
	
	static void diceFace(String p, int target, int face) {
        if (target == 0) {
            System.out.print(p+" ");
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face);
        }
    }
	
//	Finale
	static void diceFace(String p, int target, int face , int len) {
        if (target == 0) {
        	if(p.length() == len) {        		
        		System.out.print(p+", ");
        	}
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceFace(p + i, target - i, face,len);
        }
    }
}
