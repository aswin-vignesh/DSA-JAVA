import java.util.ArrayList;

public class Patterns {
	public static void main(String[] args) {
		int n = 3;
//		patt1(n);
//		patt2(n);
//		patt3(n);
//		patt4(n);
//		patt5(n);
//		patt6(n);
//		patt7(n);
//		patt8(n);
//		patt9(n);
//		patt10(n);
//		patt11(n);
//		patt12(n);
//		patt13(n);
//		patt14(n);
//		patt15(n);
//		patt16(n);
//		patt16Ncr(n); //this is the right one based on question
//		patt16Amuls(n);
//		patt17(n);
//		patt18(n);
//		patt19(n);
//		patt20(n);
//		patt21(n);
//		patt22(n);
//		patt23(n);
//		patt23alt(n);
//		patt24(n);
//		patt25(n);
//		patt26(n);
//		patt27(n);
//		patt28(n);
//		patt29(n);
//		patt30(n);
//		patt32(n);
//		patt33(n);
//		patt34(n);
//		patt35(n);
//		patt36(n);  // diff
//		patt37(n);
		patt38(n);
		
	}
	
	static void patt1(int n) {
		for(int i= 0; i < n ; i++) {
			for(int j=0 ; j < n ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt2(int n) {
		
		for(int i= 0; i < n ; i++) {
			for(int j=0 ; j <= i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt3(int n) {
		for(int i= 0; i < n ; i++) {
			for(int j=0 ; j < n-i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt4(int n) {
		for(int i= 1; i <= n ; i++) {
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	static void patt5(int n) {
		for(int i= 0; i < 2*n-1 ; i++) {
			
			int limit = i < n? i+1 : (2*n-1)-i;
			for(int j=0 ; j < limit ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	static void patt6(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < n-i-1 ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j <= i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	
	static void patt7(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < i ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j < n-i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt8(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < n-i-1 ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j <= 2*i ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt9(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < i ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j <= (n-i-1)*2 ; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
	static void patt10(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < n-i-1 ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j <= i ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	static void patt11(int n) {
		for(int i= 0; i < n ; i++) {
			for(int space = 0 ; space < i ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j < n-i ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	static void patt12(int n) {
		for(int i= 0; i < 2*n ; i++) {
			int limit = i < n ? n-i : i+1-n;
			int sp = i < n ? i : 2*n-i-1 ; 
			for(int space = 0 ; space < sp ; space++) {
				System.out.print(" ");
			}
			for(int j=0 ; j < limit ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	static void patt13(int n) {
		for(int row= 0; row < n ; row++) {
			for(int col=0 ; col < 2*n-1 ; col++) {
				if(row + col == n-1 || col-row == n-1 || row == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	static void patt14(int n) {
		for(int row= 0; row < n ; row++) {
			for(int col=0 ; col < 2*n-1 ; col++) {
				if(row + col == 2*(n-1) || col-row == 0 || row == 0) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	static void patt15(int n) {
		for(int row= 0; row < 2*n-1 ; row++) {
			for(int col=0 ; col < 2*n-1 ; col++) {
				if(row + col == n-1 || col-row == n-1 || row-col == n-1 || (row + col) == (n-1)*3) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
//	Pascals triangle
	static void patt16(int n) {
		for(int row= 0; row < n ; row++) {
			
			for(int s = 0 ; s < n-row-1 ; s++) {
				System.out.print(" ");
			}
			
			int no = (int) Math.pow(11,row);
			String str = Integer.toString(no);
			int len = str.length();
			
			
			for(int col=0 ; col < len ; col++) {
				System.out.print(str.charAt(col)+" ");
			}
			System.out.println();
		}
	}
	static int fact(int n) {
		int sum = 1;
		for(int i=1 ; i <= n ; i++) {
			sum *= i;
		}
		return sum;
	}
	
	static void patt16Ncr(int limit) {
		for(int n= 0; n < limit ; n++) {
			
			for(int s = 0 ; s < limit-n-1 ; s++) {
				System.out.print(" ");
			}
			
			
			for(int r=0 ; r <= n ; r++) {
				int ncr =  fact(n)/(fact(n-r)* fact(r)); // n!/(n-r)!r!
				System.out.print(ncr + " ");
			}
			System.out.println();
		}
	}
	// amuls pascal triangle pattern
	static void patt16Amuls(int n) {
			
		ArrayList<ArrayList<Integer>> li = new ArrayList<>();
			
		for(int i = 0; i < n ; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
				
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0 || j==i) {
					temp.add(1);
				}
				else {
					if(i-1 >= 0) {
						temp.add(li.get(i-1).get(j-1) + li.get(i-1).get(j));
					}
				}
			}
			li.add(temp);
		}
		
		for( ArrayList t : li) {
			for(int i=0 ; i < t.size() ; i++) {
				System.out.print(t.get(i)+" ");
			}
			System.out.println();
		}
	}
	static void patt17(int n) {
		
		for(int r= 1; r < 2*n ; r++) {
			
			int space = r > n ? r-n : n-r ; 
			int col = r > n ? 2*n-r : r ;  
			
			for(int s = 1 ; s <= n-r ; s++) {
				System.out.print(" ");
			}
			
			
			
			for(int c=col ; c > 0 ; c--) {
				System.out.print(c+"");
			}
			for(int c=col ; c > 1 ; c--) {
				System.out.print(c+"");
			}
			
			System.out.println();
		}
	}
	static void patt18(int n) {
		
		for(int i=0 ; i < 2*n ; i++) {
			
			int col = i < n ? n-i : i+1-n;
			for(int c = 0 ; c < col ; c++) {
				System.out.print('*');
			}
			
			for(int s = 0 ; s < n-col ; s++) {
				System.out.print("  ");
			}
			
			for(int c = 0 ; c < col ; c++) {
				System.out.print('*');
			}
			
			System.out.println();
		}
	}
	
	static void patt19(int n) {
		
		for(int r = 0 ; r < 2*n-1 ; r++) {
			int col = r < n? r+1 : 2*n-r-1;
			
			for(int c = 0 ; c < col ; c++) {
				System.out.print("*");
			}
			for(int s = 0 ; s < n-col ; s++) {
				System.out.print("  ");
			}
			for(int c = 0 ; c < col ; c++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	
	static void patt20(int n) {
		
		for(int r = 0 ; r < n ; r++) {
			for(int c= 0 ; c < n ; c++) {
				if(r == 0 || r == n-1 || c == 0 || c == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
//	floyds triangle 
	static void patt21(int n) {
		int num = 1;
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c <= r ; c++) {
				System.out.printf("%-3d",num++);
			}
			System.out.println();
		}
	}
	
//	right 101 floyds triangle
	static void patt22(int n) {
		int num = 1;
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c <= r ; c++) {
				int sum = r+c;
				if(sum%2 == 0) {
					System.out.print('1'+" ");
				}else {
					System.out.print('0'+" ");
				}
			}
			System.out.println();
		}
	}
	static void patt23(int n) {
		
		for(int r = 0 ; r < n ; r++) {
			
			int limit = (n-1)*4;
			
			for(int c = 0 ; c <= limit ; c++) {
				if( (r+c == limit/4 ) || (c-r == limit/4) || c+r == (limit - limit/4) || c-r == (limit - limit/4)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	static void patt23alt(int n) {
		
		for(int r = 0 ; r < n ; r++) {
			
			for(int c = 0 ; c < n*2-1 ; c++) {
				if(r+c == n-1 || c-r == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			for(int c = 1 ; c < n*2-1 ; c++) {
				if(r+c == n-1 || c-r == n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
	
	static void patt24(int n) {
		
		for(int r= 0 ; r < 2*n ; r++) {
			
			for(int c = 0 ; c < 2*n ; c++) {
				if(c == 0 || c == 2*n-1 || r == c || r+c == 2*n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	static void patt25(int n) {
		
		for(int r = 0 ; r< n ; r++) {
			for(int s = 0 ; s < n-1-r ; s++) {
				System.out.print(" ");
			}
			for(int c = 0 ; c < n ; c++) {
				if(c == 0 || c == n-1 || r == 0 || r==n-1) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	static void patt26(int n) {
		
		for(int r= 0 ; r < n ; r++) {
			
			for(int c= 0 ; c <= n-r-1 ; c++) {
				System.out.print(r+1 + " ");
			}
			System.out.println();
		}
	}
//	 trapezium my own formula
	static void patt27(int n) {
		
		int left = 0;
//		int tot =  ((n*(n+1))/2) * 2 ;  // sum of nums formula n(n+1)/2  x2 for 2nd triangle
//		or
		int tot = (n*(n+1));
		// explanation
		// 4nos 
		// 3nos
		// 2nos
		// 1nos
		// total 10nos for 1 side so 20 for 2 sides (if n == 4)
		System.out.println(tot);
		
		for(int r = 0 ; r < n ; r++ ) {
			
			// space
			for(int s=0 ; s < r ; s++) {
				System.out.print("  ");
			}
			
			for(int c = 0 ; c < n-r ; c++) {
				System.out.printf("%2d",++left);  // pre increment
			} // now left is 4
			
			int right = (tot) - left ; //20-4 = 16
			
			for(int c = 0 ; c < n-r ; c++) {
				System.out.printf("%3d",++right);  // pre increment
			}
			System.out.println();
		}
	}
	static void patt28(int n) {
		for(int r = 0 ; r < 2*n-1 ; r++) {
			
			int col = r < n ? r+1 :2*n-r-1;
			
			for(int s = 0 ; s < n-col ; s++) {
				System.out.print(" ");
			}
			
			for(int c = 0 ; c < col ; c++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	static void patt29(int n) {
		for(int r = 0 ; r < 2*n-1 ; r++) {
			
			int col = r < n ? r+1 :2*n-r-1;
			
			
			for(int c = 0 ; c < col ; c++) {
				System.out.print("*");
			}
			for(int s = 0 ; s < n-col ; s++) {
				System.out.print("  ");
			}
			for(int c = 0 ; c < col ; c++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
	static void patt30(int n) {
		for(int r = 1 ; r <= n ; r++) {
			
			
			
			for(int s = 0 ; s <= n-r-1 ; s++) {
				System.out.print("  ");
			}
			for(int c = r ; c > 0 ; c--) {
				System.out.print(c+" ");
			}
			for(int c = r ; c > 1 ; c--) {
				System.out.print(c+" ");
			}
			
			System.out.println();
		}
	}
	
	static void patt32(int n) {
		for(int r = n ; r > 0 ; r--) {
			for(int c = r ; c <= n ; c++) {
				System.out.print((char)(c+64));
			}
			System.out.println();
		}
	}
	
	static void patt33(int n) {
		char letter = 'a';
		int num = 1;
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c <= r ; c++) {
				if(num == 1) {					
					System.out.print(letter++ + " ");
				}else {
					System.out.print((char)(letter-32) + " ");
					letter++;
				}
				num ^= 1;
			}
			System.out.println();
		}
	}
	static void patt34(int n) {
		
		for(int r = n ; r > 0 ; r--) {
			for(int c = r ; c > 0 ; c--) {
				System.out.print((char)(c+64) + " ");
			}
			System.out.println();
		}
	}
	static void patt35(int n) {
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0 ; c <= r ; c++) {
				System.out.print(c+1);
			}
			for(int s =0 ; s < n-r-1 ; s++) {
				System.out.print("  ");
			}
			for(int c = r ; c >= 0 ; c--) {
				System.out.print(c+1);
			}
			System.out.println();
		}
	}
	
//	----------------------- ADDITIONAL PATTERNS ----------------------------------
	
//	https://www.youtube.com/watch?v=hM8hn-ZHWyw&list=PLzgPDYo_3xuliFyI5dZKgYB99SMUscGyp&index=48
//	Right Triangle snake pattern
	static void patt36(int n) {
		
		for(int i=0 ; i < n ; i++) {
			
			for(int j=0 ; j <= i ; j++) {
				
				int x =0 ;
				for(int k =0 ; k < j ; k++) {
					x = x + n-k;
				}
				if(j%2 == 0) {
					System.out.print(x+(i+1)-j + " ");
				}else {
					System.out.print(x+n-i+ " ");
				}
			}
			System.out.println();
		}
	}
	
//	pattern
//	         1  2  3  4
//	      8  7  6  5
//	   9  10 11 12
//	16 15 14 13
	
	static void patt37(int n) {
//		 in single inner for loop
		
		for(int i = 0 ; i < n ; i++) {
//			space
			for(int s = 0 ; s < n-i-1 ;s++ ) {
				System.out.print(" ");
			}
			
			for(int j= 1 ; j <= n ; j++) {
				
				if(i%2 == 0) {
					System.out.printf( "%-3d" ,n*i+j );
				}else {
					System.out.printf("%-3d", (n*(i+1)+1)-j);
				}
//				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
//	https://www.youtube.com/watch?v=MQ_8iDZYPtM&list=PLzgPDYo_3xuliFyI5dZKgYB99SMUscGyp&index=47
//		pattern
//	    1
// 		2 6   
//		3 7 10  
//	    4 8 11 13 
//      5 9 12 14 15
	
	static void patt38(int n) {
		for(int row = 0 ; row < n ; row++) {
			
			int val = row+1;
			int dec = n-1;
			
			for(int col = 0 ; col <= row ; col++) {
				System.out.print(val + " ");
				val = val + dec;
				dec = dec-1;
			}
			System.out.println();
		}	
	}
}
