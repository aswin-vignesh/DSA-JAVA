
public class Power {
	public static void main(String[] args) {
		System.out.println(power(3,6 ));
	}
	
	static int power(int no , int pow) {
		int ans = 1;
		int base = no;
		
		while(pow > 0) {
			if( (pow&1) == 1) {
				ans *= base;
			}
			pow = pow >> 1;
			base *= base;
		}
		return ans;
	}
}
