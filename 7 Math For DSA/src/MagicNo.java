
public class MagicNo {
	
	public static void main(String[] args) {
		
		for(int i=0 ; i  <7 ; i++ ) {			
			System.out.println(magicNo(i));
		}
	}
	
	static int magicNo(int n) {
		
		int ans = 0;
		int base = 5;
		
		while(n > 0) {
			int last = n&1;
			n = n >> 1;
			ans += base*last;
			base = base * 5;
		}
		return ans;
	}
}
