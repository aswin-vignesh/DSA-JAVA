
public class DLL {
	
	Node head;
	
	public DLL() {
	}
	
	public void insertFirst(int val) {
		Node node = new Node(val);
		
		node.next = head;
		node.prev = null;
		
		if(head != null) {
			head.prev = node;			
		}
		
		head = node;
	}
	
	public void display( boolean forward) {
		Node temp = head;
		Node last = temp;
		
		while(temp != null) {
			System.out.print("[ "+temp.value + " ] <-> ");
			last = temp;
			temp = temp.next;
			
		}
		System.out.println(" End ");
		
		if(!forward) {
			temp = last;
			
			System.out.println(" --- Reverse ---");
			while(temp != null) {
				System.out.print("[ "+temp.value + " ] <-> ");
				temp = temp.prev;
			}
			System.out.println(" Start ");
			
		}
	}
	
	public void insertLast(int val) {
		if(head == null) {
			insertFirst(val);
			return;
		}
		
		Node node = new Node(val);
		Node last = head;
		
		while(last.next != null) {
			last = last.next;
		}
		
		node.prev = last;
//		node.next = null; // no need 
		last.next = node;
		
	}
	
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
	
	public void insert(int after, int val) {
		
		Node p = find(after);
		
		if( p == null ) {
			System.out.println("does not exist");
			return;
		}
		
		Node node = new Node(val ,p.next , p );
		
		if(p.next != null) {
			p.next.prev = node; 			
		}
		p.next = node;
		
	}
	
	public void getHead() {
		System.out.println();
		System.out.println("Head : "+head.value );
	}
	
	
	private class Node{
		
		private int value;
		private Node next;
		private Node prev;
		
		public Node(int val) {
			this.value = val;
		}
		
		public Node(int val, Node next , Node prev) {
			this.value = val;
			this.next = next;
			this.prev = prev;
		}
	}
}