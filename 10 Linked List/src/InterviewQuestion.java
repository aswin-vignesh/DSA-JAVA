
public class InterviewQuestion {
	public static void main(String[] args) {
	
		System.out.println(isHappy(2));
	}
	
	
	
	// https://leetcode.com/problems/linked-list-cycle - 141
    // Amazon and Microsoft
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
	
	
	// find length of the cycle
    public int lengthCycle(ListNode head) {
    	
    	//has cycle
    	ListNode fast = head;
    	ListNode slow = head;
    	
    	
    	while( fast != null && fast.next != null ) {
    		
    		slow = slow.next;
    		fast = fast.next.next;
    		
    		if(fast == slow) {
    			
    			int length = 0;
    			do {
    				length++;
    				fast = fast.next;
    			}
    			while(slow != fast);
    			return length;
    		}
    	}
    	return 0;
    }
    
    //-------------  start Node of cycle
    // https://leetcode.com/problems/linked-list-cycle-ii/  142
    public ListNode detectCycle(ListNode head) {
        int len = lengthCycle(head);
        
        if(len == 0){
            return null;
        }

         ListNode f = head;
         ListNode s = head;

        // go ahead by len
        for(int i=0 ; i < len ; i++){
            s = s.next;
        }

        while(s != f){
            s = s.next;
            f = f.next;
        }
        return s; // can return both
     }
    
    //---------------- Happy Number
 // Google: https://leetcode.com/problems/happy-number/
    public boolean isHappyKunal(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }
        return false;
    }
    private int findSquare(int number) {
        int ans = 0;
        while (number > 0) {
            int rem = number % 10 ;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
    
 // Happy Number my method
 	public static boolean isHappy(int n) {
         int s = n  , f = n ;

         do{
             s = sum(s);
             f = sum(sum(f));
             if(f == 1 || s == 1){
                 return true;
             }
         }
         while( s!=f );
         return false;
     }

     static int sum (int n){
         int sum = 0;
         int x = n;
         while(x > 0){
             sum += Math.pow(x%10,2);
             x /= 10;
         }
         return sum;
     }
     
     //happy Number recursion
     public boolean isHappyRec(int n) {
         int sum = 0;
         while(n>0){
             int rem = n%10;
             sum += rem*rem;
             n /= 10;
         }
         if(sum == 1){
             return true;
         }else if(sum == 4){ // !!! NOTE
             return false;
         }
         return isHappy(sum);
     }
     
     
     //--------------  middle-linked list
     
     // leet: 876
     public ListNode middleNode(ListNode head) {
         ListNode f = head , s = head;

         while(f != null && f.next != null){
             f = f.next.next;
             s = s.next;
         } 
         return s;
     }
     
//      ----------------------------------------------- Refer Merge Sort
     //---------------- refer LL Now from this
     
     
  // Google, Microsoft, Facebook: https://leetcode.com/problems/reverse-linked-list-ii/
     public ListNode reverseBetween(ListNode head, int left, int right) {
         if(right-left == 0){
             return head;
         }

         // go to left-1 pos for prev
         ListNode prev = null;
         ListNode cur = head;
         ListNode nxt = cur.next;

         for(int i=0 ;  cur != null && i < left-1 ; i++){
             // move
             prev = cur;
             cur = nxt;
             nxt = nxt.next;
         } 

         ListNode last = prev;
         ListNode newEnd = cur;
         // understanding
         // 1 connect 4 and 2 connect 5 or  
         //  at last prev connect 4 and cur connect 4.next

         //reversing len times = r-l+1
         for(int i=0 ;  cur != null && i < right-left+1 ; i++){

             cur.next = prev; // reverse
             // move
             prev = cur;
             cur = nxt;
             if(nxt != null){
                 nxt = nxt.next;
             }
         }
         //          last    nEnd          prev  cur  nxt
         // now       1   <-  2  <-  3  <-  4     5   null
         // but ans   1   ->  4  ->  3  ->  2 ->  5

         if(last != null){
             last.next = prev;
         }else{          // if start from 0th index
             head = prev;
         }
         newEnd.next = cur;

         return head;
     }


    
     
     // Palindrome leet 234
     public boolean isPalindrome(ListNode head) {

         if(head == null || head.next == null){
             return true;
         }

         ListNode fir = head;
         ListNode sec = getMid(head);

         sec = rev(sec);

         while(fir != null && sec != null){
             if(fir.val != sec.val){
                 return false;
             }
             fir = fir.next;
             sec = sec.next;
         }        
         return true;
     }

     public ListNode getMid(ListNode head){
         // also split array;
         ListNode  f = head , s = f ;

         while ( f != null && f.next != null){
             s = s==f ? head : s.next;
             f = f.next.next;
         }
         // s = mid - 1  6/2 = 3-1 => 2 or 0+5/2 => 2 
         // s= actual mid and mid-1 in ll
         ListNode nxt = s.next;
         s.next = null; // disconnecting l and r
         return nxt; // return r
     }

     public ListNode rev(ListNode head){

         ListNode prev = null;
         ListNode cur = head;
         ListNode nxt = head.next;

         while(cur != null){
             cur.next = prev ;  // dir change

             prev = cur;
             cur = nxt;
             if(nxt != null){
                 nxt = nxt.next;
             } 
         }

         return prev;
     }
}



// Leet code definition
//Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      
      public ListNode() {
	}
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
