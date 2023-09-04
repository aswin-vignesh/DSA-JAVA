
public class SetBits {

	public static void main(String[] args) {

//		System.out.println(setBit(86, 4));
		
//		86 =  1 0 1 0 1 1 0 -> 4th bit ->  1 0 1 1 1 1 0  = 94(86+8)
		
//		System.out.println(resetBit(94, 4));
		
		int n = 32;
		System.out.println(Integer.toBinaryString(n));
		
		rightMostSetbit(n);
	}
	static int setBit(int num,int pos) {
		
//		ith bit = num & ( 1 << pos-1);
		
		num = num | (1 << pos-1);
		
		return num;
	}
	static int resetBit(int num,int pos) {
		
//		ith bit = num & ( 1 << pos-1);
		
		num = num ^ (1 << pos-1);
		
		return num;
	}
	
	static void rightMostSetbit(int n) {
		int ans =  n&-n;
		
		System.out.println("val = " +ans);
		System.out.println("pos = "+ (int) (Math.log(32)/Math.log(2)));
		/*
		 	2^x = 32
		 	x log(2) = log(32)
		 	x = log32/log2;
		 	x = pos of that set bit
		 	x starting from 0th pos
		 */
	}
//	 static int rightMostSetbit2(int n) {
//        int count = 0;
//
//
//        while (n > 0) {
//            count++;
//            n = n & (n-1);
//        }
//
//        return count;
//    }
}

