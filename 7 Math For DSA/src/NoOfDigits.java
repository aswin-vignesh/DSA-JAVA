
public class NoOfDigits {
	public static void main(String[] args) {
		System.out.println("-----45-----");
		System.out.println(digits(45, 2)); // 1 0 1 1 0 1
		System.out.println(digits(45,10)); // 2digits
		System.out.println(digits(45, 8)); // 55
		
		System.out.println("-----50-----");
		System.out.println(digits(50, 2)); // 1 1 0  0 1 0
		System.out.println(digits(50,10)); // 2digits
		System.out.println(digits(50, 8)); // 62
		System.out.println(Integer.toOctalString(50));
	}
	static int digits(int no , int base) {
		return (int) (Math.log(no)/Math.log(base))+1;
	}
}
