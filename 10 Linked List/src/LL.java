/*
 
 1 --
 	Objects don't default, references do and 
 	they default to null as described in the the documentation on Data Types.
 	
 	only reference default to null not the object
 	
 2 --
 	Class members don't need initialization
 	but main members need initialization		https://stackoverflow.com/questions/19131336/default-values-and-initialization-in-java
 	
 	*/




public class LL {
	
	Node head;   // already null
	Node tail;
	int size;
	
	public LL() {
		this.size = 0 ;
	}	
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		node.next = head;
		head = node;
		
		if(tail == null) {// for 1st element
			tail = head;
		}
		size +=1;
	}
	
	public void display() {
		Node temp = head;
		
		while(temp != null) {	// temp null on exit
			System.out.print("[ "+temp.value + " ] -> ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void insertLast(int val) {
		if(tail == null) {
			insertFirst(val);
			return;
		}
		
		Node node = new Node(val);
		tail.next = node;
		tail = node;
		size++;
	}
	
	// insert @ index
	public void insertMine(int val , int index) {
		
		if(index == 0) {
			insertFirst(val);
			return;
		}
		if(index >= size) {
			insertLast(val);
			return;
		}
		
		Node node = new Node(val);
		Node first = head;
		for(int i = 1 ; i < index ; i++) {
			first = first.next;
		}
		Node second = first.next;
		
		first.next = node;
		node.next = second;
	}
	
	public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }
	
	public void insertRec(int val , int index) {
		head = insertRec(val, index, head);
	}
	
	// here we calling the next of each ele and altering the next when index is zero and return back them so that this becomes new next of previous element
	public  Node insertRec(int val , int index , Node node) {
		
		if(index == 0) {
			Node temp = new Node(val, node);
			size++;
			return temp; // this temp is prev.next = temp ,  temp.next = (current) node 
		}
		
		// traverse
        node.next = insertRec(val, index-1, node.next);
        return node;
	}
	
	
	//delete first
	public int deleteFirst() {
		
		int val = head.value;
		head = head.next;
		if(head == null) {
			tail = null;
		}
		
		size--;
		return val;
	}
	
	// delete last
	public int deleteLast() {
		
		if (size <= 1) {
            return deleteFirst();
        }
		
		Node temp = head;
		Node prev = temp;
		
		// or use get or refer github
//		while(temp.next != null) { // gets the last element
//			
//			prev = temp;
//			temp = temp.next;  // similar if temp = 10 temp.next = 20 , after ->  prev = 10 , temp = 20 
//		}
		
		// or
		prev = get(size-2);  // last before
		temp = get(size-1); //last
		
		int val = temp.value;
		prev.next = null;
		tail = prev;
		size--;
		
		return val;
	}
	
	// get an node using index
	public Node get(int index) {
		
		Node temp = head;
		for(int i= 1; i <= index ; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	// get an node using value
	public Node find(int val) {
		
		Node temp = head;
		
		while(temp != null) {
			if(temp.value == val) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
		
	}
	
	// delete using index (delete mid)
	public int delete(int index) {
		if(index == 0) {
			return deleteFirst();
		}
		if(index == size-1) {
			return deleteLast();
		}
		
		Node prev = get(index-1);
		int val = prev.next.value;
		
		prev.next = prev.next.next;
		
		size--;
		return val;
	}
	
	
	
	public void getHeadTail() {
		System.out.println();
		System.out.println("Head : "+head.value +" tail : "+tail.value);
	}
	
	private class Node{
		
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		public Node(int value , Node next) {
			this.value = value;
			this.next = next;
		}
	
	}
	
	
	// --------------------- Problems ----------------------------------
	
	
	
	// https://leetcode.com/problems/remove-duplicates-from-sorted-list
    public void duplicates() {
        Node node = head;

        while (node.next != null) {
            if (node.value == node.next.value) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
    
 // https://leetcode.com/problems/merge-two-sorted-lists/submissions/
    public static LL merge(LL first, LL second) {
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }
    
    
    // ------------- Refer Interview Questions from now and come back
    
    
    // bubble sort
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }
    
    // recursive reversal of linked list
    
    // 5 4 3 2 1
    
    public void reverse(Node node) {
    	
    	if(node == tail) {
    		head = tail;
    		return;
    	}
    	reverse(node.next);
    	
    	tail.next = node ; // tail.next = current node   1.next = 2
    	
//    	tail = node; //  2 = tail  1-> <- 2 = tail 
//     	tail.next = null;  // 2.next = null     1 -> 2 -> null
     	
     	// or
     	node.next = null;
     	tail = node;
    	
    }
    
 // in place reversal of linked list
    // google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
    
//   pre     cur   nxt
//    null -> 5  ->  4  -> 3 ->  1
    public void reverse() {
    	if(size < 2) {
    		return ;
    	}
    	
    	Node prev = null;
    	Node present = head;
    	Node nxt = present.next;
    	
    	while( present != null) {
    		present.next = prev;   // 5 -> null ,  4 -> 5 -> null , 
    		
    		// move ahead
    		prev = present;
    		present = nxt;
    		
    		if(nxt != null) { // nxt is null when 1 no is there so this step is ignored , leading to present getting null at next iteration and thus exit loop
    			nxt = nxt.next;
    		}
    	}
    }
    
    
    // LEET : 143
    
 // https://leetcode.com/problems/reorder-list/
 // Google, Facebook
public void reorderList(ListNode head) {
        
        if (head == null || head.next == null) {
            return;
        }

        ListNode fir = head; 
        ListNode sec =  getMid(head); 
        sec = rev(sec);

        while ( fir != null && sec != null){
            ListNode temp = fir.next;
            fir.next = sec;
            fir = temp;

            temp = sec.next;
            sec.next = fir;
            sec = temp;
        }
        if(fir != null){
            fir.next = null;
        }

    }


    public ListNode getMid(ListNode head){ // dont split

        ListNode f = head , s = f;

        while( f != null && f.next != null ){
            s = s.next;
            f = f.next.next;
        }
     
        return s; 
    }
    public ListNode rev(ListNode head){

        ListNode prev = null;
        ListNode cur = head;
        ListNode nxt = head.next;

        while(cur != null){
            cur.next = prev;

            prev = cur;
            cur = nxt;
            if(nxt != null){
                nxt = nxt.next;
            }
        }

        return prev;  // this is new head that is on other side
    }
    
// or
    public void reorderListNiceSolution(ListNode head) {
    	if(head==null || head.next==null || head.next.next==null) return;
    	ListNode firstPart = head;
    	ListNode mid = getMid(head);
    	ListNode secondPart = mid.next;
    	mid.next=null;
    	secondPart = rev(secondPart);
    	ListNode dummy = new ListNode();
    	ListNode curr = dummy;
    	while(firstPart!=null){
    		curr.next=firstPart;
    		curr=curr.next;
    		firstPart=firstPart.next;
    		if(secondPart!=null){
    			curr.next=secondPart;
    			curr=curr.next;
    			secondPart=secondPart.next;
    		}
    	}
    	head=dummy.next;
    	return;
    }
    
    // ------------------ Reverse K node
    
 // google, amazon, facebook, microsoft: https://leetcode.com/problems/reverse-nodes-in-k-group/
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

		int length = getLength(head);
		int count = length / k;
        while (count > 0) {
            ListNode last = prev;
            ListNode newEnd = current;

            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
			count--;
        }
        return head;
    }

	public int getLength(ListNode head) {
		ListNode node = head;
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}
    
	// https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
    public ListNode reverseAlternateKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        // skip the first left-1 nodes
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode last = prev;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            // skip the k nodes
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }
    
    // LEET : 61
    // rotate LL
    public ListNode rotateRight(ListNode head, int k) {
        if( k  < 1 || head == null || head.next == null){
            return head;
        }

        ListNode last = head;
        int len = 1;
        while(last.next != null){
            last = last.next;
            len++;
        }

        last.next = head ; // now head <-> last (in cycle)


        // calc rotate count
        int rotate = k%len;
        // go ahead by
        int skip = len - rotate; 

        // skipping
        ListNode node = head; // last node
        for(int i= 0 ; i < skip-1 ; i++){
            node = node.next;
        }

        // altering
        head = node.next ;
        node.next = null;

        return head;
    }
    
    
    
    public static void main(String[] args) {
		
    	LL l = new LL();
    	
    	l.insertLast(5);
    	l.insertLast(4);
    	l.insertLast(3);
    	l.insertLast(2);
    	l.insertLast(1);
    	
    	l.display();
    	
//    	l.bubbleSort();
//    	l.reverse(l.head);
    	
    	l.display();
	}
}
