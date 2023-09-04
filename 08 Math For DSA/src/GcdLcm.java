
public class GcdLcm {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 12;
		System.out.println("LCM  : "+lcm(a, b));
		System.out.println("HCF  : "+gcd(a, b));
	}
	
	static int gcd(int a ,int b) {
		if( b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}
	static int lcm(int a ,int b) {
		return  (a*b)/gcd(a, b);
	}
}
