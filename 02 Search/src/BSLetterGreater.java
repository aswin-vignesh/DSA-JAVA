// LEET : 744


public class BSLetterGreater {
	
	public static void main(String[] args) {
		char[] letters = {'c','f','j'};
		
		System.out.println(nextGreatestLetter(letters, 'c'));
	}
	public static char nextGreatestLetter(char[] letters, char target) {
		int len = letters.length;
        int s = 0;
        int e = len-1;
        
        while(s <= e) {
        	int m = s+(e-s)/2;
        	
        	if(target >= letters[m]) {
        		s = m+1;
        	}else {
        		e = m-1;
        	}
        }
        return letters[s%len];
    }
}
