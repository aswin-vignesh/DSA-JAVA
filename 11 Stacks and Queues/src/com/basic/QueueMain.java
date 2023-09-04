package com.basic;

public class QueueMain {
	
	public static void main(String[] args) throws Exception{
		
//		CustomQueue queue = new CustomQueue();
//		
//		queue.insert(0);
//		queue.insert(1);
//		queue.insert(2);
//		queue.insert(3);
//		queue.insert(4);
//		
//		queue.display();
//		
//		queue.remove();
//		queue.remove();
//		queue.remove();
//		
//		queue.display();
		
		CircularQueue cq = new CircularQueue(5);
		
		cq.insert(0);
		cq.insert(1);
		cq.insert(2);
		cq.insert(3);
		cq.insert(4);
		
		//extra
		cq.insert(0);
		
		cq.display();
		
		cq.remove();
		cq.remove();
		cq.insert(6);
		cq.insert(7);
		
		cq.display();
		
		System.out.println(cq.front());
		
		DynamicQueue dq = new DynamicQueue(4);
		dq.insert(0);
		dq.insert(1);
		dq.insert(2);
		dq.insert(3);
		//extra
		dq.insert(4);
		dq.insert(5);
		dq.insert(6);
		
		dq.display();
		
	}
}
