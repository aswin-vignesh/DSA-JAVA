
public class Main {
	
	public static void main(String[] args) {
		
//		LL list = new LL();
//		
//		list.insertFirst(1);
//		list.insertFirst(2);
//		list.insertFirst(3);
//		list.insertFirst(4);
//		
//		list.display();
//		
//		list.insertLast(-1);
//		list.insertLast(-2);
//		list.insertLast(-3);
//		list.insertLast(-4);
//		
//		list.insert(0, 4);
//		list.insertRec(0, 4);
//		
//		list.display();
//		
//		list.deleteLast();
//		list.deleteFirst();
//		list.delete(4);
//		
//		list.display();
//		
//		list.getHeadTail();
//		System.out.println(list.size);
		
		
//		Doubly Linked List
//		DLL dlist = new DLL();
//		
//		dlist.insertFirst(1);
//		dlist.insertFirst(2);
//		dlist.insertFirst(3);
//		dlist.insertFirst(4);
//		
//		dlist.insertLast(-1);
//		dlist.insertLast(-2);
//		dlist.insertLast(-3);
//		dlist.insertLast(-4);
//		
//		dlist.display(false); 		System.out.println();
//		
//		dlist.insert(1, 0);
//		dlist.insert(-4, -5);
//		dlist.insert(-6, 0);
//		
//		dlist.display(false);
//		
//		dlist.getHead();
		
//		Circular Linked List
		
		CLL clist = new CLL();
		
		clist.insert(0);
		clist.insert(1);
		clist.insert(2);
		clist.insert(3);
		
		clist.display();
		
		clist.delete(2);
		clist.delete(0);
		clist.insert(100);
		
		clist.display();
	}
}
