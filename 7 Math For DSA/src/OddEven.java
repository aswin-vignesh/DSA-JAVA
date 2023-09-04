
public class OddEven {
	public static void main(String[] args) {
		
		int num = 61;
		findOdd(num);
	}
	static void findOdd(int n) {
		
		if( (n&1) == 1) {
			System.out.println("Odd");
		}
		else {
			System.out.println("Even");
		}
	}
	
}
