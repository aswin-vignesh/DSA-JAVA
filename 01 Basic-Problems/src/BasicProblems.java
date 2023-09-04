import java.util.LinkedList;

public class BasicProblems {
	// Refer Patterns in amuls python coding problem
	
	public static void main(String[] args) {
//		armstrong(153);
//		pattb(4);
//		patt1(4);
//		pattHRT(4);
//		fact1(5);
//		fact2(5);
//		System.out.println(factRec(5));
//		pattRHT(5);
//		pattFloydTri(5);
//		pattStrTri("Python");
//		fibo1(10);
//		fiboRec(9);
//		patt2(5);
		
//		isPrimeBasic(101);    // o(n^2)
//		System.out.println();
//		isPrimeBetter(101);   // o(n*n/2)
//		System.out.println(); 
//		prime1(101);		  // o(nlog(n)) // not sure
//		System.out.println();
//		prime2(101); 		  // O(n/6 * root(n) )    -> O(n * root(n))
//		System.out.println();
//		sieve(101);
		
//		perfectNo1(11000);
//		perfectNo2(11000);
//		swap(7, 20);
		
//		pattWhileRT(5);
		
//		stringRev("12345");
//		stringRevRec("","12345");
		
//		factors(6);
		lcm(6, 8);
		
//		System.out.println(gcd(36,18));
	}

	public static boolean armstrong(int n) {
//		153 = 1^3 + 5^3 + 3^3
		// no of digits
		// reminder
		int digits = (int)(Math.log(n)/Math.log(10)+1) ;
		int tot = 0 ,  x = n;
		
		while(x > 0) {
			int rem = x%10;
			x /= 10;
			
			tot += Math.pow(rem, digits);
		}
		if(tot == n) {
			System.out.println(n+" is armstrong");
			return true;
		}
		return false;
	}
	
	static void pattb(int n) {
		for(int i=1 ; i <= n ; i++) {
			for(int j=1 ; j <= n ; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	static void patt1(int n) {
		for(int i=1 ; i <= n ; i++) {
			for(int j=1 ; j <= i ; j++) {
//				System.out.print(i);
				System.out.print(j);
			}
			System.out.println();
		}
	}
	static void pattHRT(int n) {
		for(int i=1 ; i <= n ; i++) {
			for(int j=1 ; j <= i ; j++) {
				if(i == j || j == 1 || i == n) {
					System.out.print('*');
				}else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
	
	// forward	
	static void fact1(int n) {
		int tot =1;
		for(int i=1 ; i <= n ; i++) {
			tot *= i;
		}
		System.out.println(tot);
	}
	
//	backward
	static void fact2(int n) {
		int tot =1;
		for(int i=n ; i > 0 ; i--) {
			tot *= i;
		}
		System.out.println(tot);
	}
//	recursion
	static int factRec(int n) {
		if(n == 0) {
			return 1;
		}
		return n*factRec(n-1);
	}
	
	static void pattRHT(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				
				if(i == j || i == 0 || j == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
				
			}
			System.out.println();
		}

	}
	
	static void pattFloydTri(int n) {
		int no = 1;
		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j <= i ; j++) {
				System.out.printf("%-3s",no++);
			}
			System.out.println();
		}
	}
	static void pattStrTri(String word) {
		int n = word.length();
		for(int i=0 ; i < n ; i++) {
			for(int j=0 ; j <= i ; j++) {
				System.out.printf(" %s ",word.charAt(j));
			}
			System.out.println();
		}
	}
	
//	------ FIBO
	static void fibo1(int n) {
		int f = 0;
		int s = 1;
		
		for(int i=0 ; i < n ; i++) {
			System.out.print(f+",");
			int t = f;
			f = s;
			s = f+t;
		}
	}
	static int fiboRec(int n) {
		if(n < 2) {
			return n;
		}
		int no = (fiboRec(n-1) + fiboRec(n-2));
		return no;
	}
	
	
	static void patt2(int n) {
		for (int i = n; i > 0 ; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	
//	O(n^2)
	static void isPrimeBasic(int n) {
		if(n < 2) {
			return;
		}
		for(int i=2 ; i <= n ; i++) {
			int no = i ,fl = 1;
			for(int j=2 ; j < no ; j++) {
				if(no%j == 0) {
					fl = 0;
					break;
				}
			}
			if(fl == 1) {
				System.out.print(i+",");
			}
		}
	}
	
//	O(n*n/2)
	static void isPrimeBetter(int n) {
		if(n < 2) {
			return;
		}
		for(int i=2 ; i <= n ; i++) {
			int no = i ,fl = 1;
			for(int j=2 ; j <= no/2 ; j++) {
				if(no%j == 0) {
					fl = 0;
					break;
				}
			}
			if(fl == 1) {
				System.out.print(i+",");
			}
		}
	}
//	o(nlog(n))
	static void prime1 (int n) {
		if(n < 2) {
			return;
		}
		for(int i=2 ; i <= n ; i++) {
			int no = i ,fl = 1;
			for(int j=2 ; j*j <= no ; j++) {
				if(no%j == 0) {
					fl = 0;
					break;
				}
			}
			if(fl == 1) {
				System.out.print(i+",");
			}
		}
	}
	
//	multiples of 6
//	O(n/6 * root(n) )    -> O(n * root(n))
	static void prime2 (int n) {
		
		if(n < 2) return;
		if(n >= 2) {
			System.out.print(2+",");
		}
		if(n >= 3) {
			System.out.print(3+",");
		}
		
		for(int i=5 ; i <= n ; i+=6) {
			int no = i , fl = 1 , sl = 1;
			
			for(int j = 3 ; j*j <= no || j*j <= no+2  ; j+=2) {
				if(no%j == 0) {
					fl = 0;
				}
				if((no+2)%j == 0) {
					sl = 0;
				}
			}
			if(fl == 1) {
				System.out.print(i+",");
			}
			if(sl == 1) {
				System.out.print((i+2)+",");
			}
		}
	}
	
//	multiples of 6 (other way)
//	O(n/6 * root(n) )    -> O(n * root(n))
	public static void prime2Other(int no,int x) {
		if(no < 2) {
			return;
		}
		if(no >= 2) {
			System.out.print(2+",");
		}
		if(no >= 3) {
			System.out.print(3+",");
		}
		for(int i=7 ; i <=  no ; i+=6) {
			boolean fl = true;
			boolean tl = true;
			for(int j=3 ; j*j <= i ; j+=2) {
				if(i%j == 0) {
					fl = false;
					break;
				}
				if((i-2) % j == 0) {
					tl = false;
				}
			}
			if(tl) {
				System.out.print((i-2)+",");
			}
			if(fl) {
				System.out.print(i+",");
			}
		}
	}
	
	static void sieve(int limit) {
		boolean []nos = new boolean[limit+1]; // default false 
		nos[0] = true ; nos[1] = true;
		for(int i=2 ; i < limit+1 ; i++) {
			if(nos[i] == false) {
				for(int j = i*2 ; j <= limit; j+=i) {
					nos[j] = true;
				}
			}
		}
		int ct = 0;
		for(boolean i : nos) {
			
			if(!i) {
				System.out.print(ct+",");
			}
			ct++;
		}
	}
	
//	perfect no
	static  void perfectNo1(int limit) {
		for(int i = 1 ; i < limit ; i++) {
			int no = i;
			
			int ct = 0;
			for(int j=1 ; j < no ; j++) {
				if(no%j == 0) {
					ct += j;
				}
			}
			if(ct == no) {
				System.out.print(no+",");
			}
		}
		System.out.println();
	}
	
	static  void perfectNo2(int limit) {
		for(int i = 2 ; i < limit ; i++) {
			int no = i;
			
			int ct = 1;
			for(int j=2 ; j*j <= no ; j++) {
				if(no%j == 0) {
					int fact2 = no/j;
					if(fact2 == j) {						
						ct -= fact2;
					}
					ct += j + fact2;
				}
			}
			if(ct == no) {
				System.out.print(no+",");
			}
		}
		System.out.println();
	}
	
	static void swap(int a , int b) {
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println(a+","+b);
	}
	
	static  void pattWhileRT(int n) {
		int row = 1;
		
		while(row <= n) {
			int star = row;
			while(star > 0) {
				System.out.print("*");
				star--;
			}
			System.out.println();
			row++;
		}
	}
	
	static void stringRev(String str) {
		int len = str.length();
		
		char[] cArr = str.toCharArray();
		
		for(int i=0 ; i < len/2 ; i++) {
			char t = cArr[i];
			cArr[i] = cArr[len-i-1];
			cArr[len-i-1] = t;
		}
		
		System.out.println(new String(cArr));
	}
	
	static void stringRevRec(String p , String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);
		stringRevRec(c+p,up.substring(1));
	}
	
	static int gcd(int a , int b) {
		
		if(b == 0) {
			return a;
		}
		
		return gcd(b,a%b);
	}
	
	static void factors(int n) {
		LinkedList<Integer> li = new LinkedList<>();
		
		for(int i=1 ; i*i <= n ; i++) {
			if(n%i == 0) {
				if(i != n/i) {
					li.add(n/i);
				}
				li.addFirst(i);
			}
		}
		System.out.println(li);
	}
	
	static void lcm(int a , int b) {
		
		int max = Math.max(a, b);
		int no = max;
		while(no%a != 0 || no%b != 0) {
			no += max;
		}
		System.out.println("Lcm : "+no);
	}
}
