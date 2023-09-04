
public class BinarySearchSQRT {

	public static void main(String[] args) {
		
		System.out.println(sqrt(102,10));
		System.out.println(Math.sqrt(102));
	}
	
	static double sqrt(int n, int p) { // p = precision
		
		
		int s = 0;
		int e = n;
		
		double root = 0.0;
		
		while(s <= e) {
			int m = s+(e-s)/2;
			
			if(m*m == n) {
				return m;
			}
			else if(m*m > n){
				e = m-1;
			}else {
				s = m+1;
				root = m;
			}
		}
		
		double incr = 0.1;
		
		for(int i=0 ; i < p ; i++) {
			
			while(root * root <= n) {
				root += incr;
			}
			root -= incr;
			incr = incr/10;
		}
		
		return root;		
	}
}
