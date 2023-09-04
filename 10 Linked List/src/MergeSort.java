
// LEET : 148
public class MergeSort {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(30);
		ListNode run = head;
		
		run.next = new ListNode(15);
		run = run.next;
		
		run.next = new ListNode(21);
		run = run.next;
		
		run.next = new ListNode(7);
		run = run.next;
		
		run.next = new ListNode(3);
		run = run.next;
		
		run.next = new ListNode(1);
		run = run.next;
		
//		run.next = new ListNode(0);
//		run = run.next;
		
		ListNode nhead = sortList(head);
		
		ListNode temp = nhead;
		while(temp != null) {
			System.out.print(temp.val+", ");
			temp = temp.next;
		}
		
		
		System.out.println();
		
		
		// mid example
		ListNode middy = new ListNode(30);
		ListNode nxt = middy;
		
		nxt.next = new ListNode(1);
		nxt = nxt.next;
		
		nxt.next = new ListNode(2);
		nxt = nxt.next;
		
		nxt.next = new ListNode(3);
		nxt = nxt.next;
		
		nxt.next = new ListNode(4);
		nxt = nxt.next;
		
		nxt.next = new ListNode(5);
		nxt = nxt.next;
		
		nxt.next = new ListNode(6);
		nxt = nxt.next;
		
		
		System.out.println("s  : "+getMiddy(middy).next.val); // 6/2 = 3 => 4 
		System.out.println("prev : "+getMid(middy).val);	  // 5/2 = 2 => 3
	}
	
// sort Linked List
    
    // get mid
    // seperate 0 to mid and mid+1 to end 
    // merge left and right 
	
	public static ListNode sortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMid(head);
		
		ListNode left = sortList(head);
		ListNode right = sortList(mid);
		
		return merge(left , right);
	}
	
	// splits array
	
//  usual s is considered to be mid in linked list but its actually mid+1 . How ? 
	
	/*
	 for 6 elements (1,2,3,4,5,6)
	  	
	  	mid = 6/2 = 3rd ele => 4 (ans if s is taken )
	  	
	  	but actually
	  	mid = s+e/2 = 0+5/2 => 2nd => 3 (ans is prev)
	  	
	  	always in merge sort the prev or s+e/2 should be included in left array
	 
	 */
	public static ListNode getMid(ListNode head) { 
		ListNode f = head , s = head , prev = s;
		
		while(f != null && f.next != null) {
			prev = s;
			s = s.next;
			f = f.next.next;
		}
		prev.next = null;// split
		return s;
	}
	
	public static ListNode merge(ListNode left , ListNode right) {
		
		ListNode li = new ListNode();
		ListNode head = li;
		
		while(left != null && right != null) {
			
			if(left.val < right.val) {
				li.next = left;
				left = left.next;
			}else {
				li.next = right;
				right = right.next;
			}
			li = li.next;
		}
		while(left != null) {
			li.next = left;
			left = left.next;
			li = li.next;
		}
		while(right != null) {
			li.next = right;
			right = right.next;
			li = li.next;
		}
		return head.next;
	}
	
	
	// normal mid (mid+1) in linked list 
	public static ListNode getMiddy(ListNode head) { 
		ListNode f = head , s = head ;
		
		while(f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}
}
