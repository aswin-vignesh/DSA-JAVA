
public class PowerOfTwo {
	public static void main(String[] args) {
		
		System.out.println(powerOf2(64));
	}
	
	static boolean powerOf2(int n) {
		
		return (n&(n-1)) == 0;
	}
}
