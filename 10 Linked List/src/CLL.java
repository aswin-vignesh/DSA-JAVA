
public class CLL {
	
	Node head;
	Node tail;
	
	public CLL() {
		this.head = null;
        this.tail = null;
	}
	
	
	// always inserted at the tail
	public void insert(int val) {
		
		Node node = new Node(val);
		
		if(head == null) {
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		node.next = head;
		tail = node;
	}
	
	public void display() {
		Node temp = head;
		
		if(head != null) {
			do {
				
				System.out.print("[ "+temp.value + " ] -> ");
				temp = temp.next;
				
			}while(temp != head);
		}
		System.out.println();
	}
	
	public void delete(int val) {
		// get previous of the val
		
		Node temp = head;
		
		if (temp == null) {
            return;
        }

        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        
        if (temp.value == val) {
            head = head.next;
            tail.next = head;
            return;
        }
		
        Node prev = temp;
        
		if(head != null) {
			do {
				
				if(temp.value == val) {
					prev.next = temp.next;
					break;
				}
				prev = temp;
				temp = temp.next;
				
			}while(temp != head);
		}
		
	}
	
	public void getHeadTail() {
		System.out.println();
		System.out.println("Head : "+head.value +" tail : "+tail.value);
	}
	
	
	private class Node{
		
		int value;
		Node next;
		
		public Node(int val) {
			this.value = val;
		}
	}
}
