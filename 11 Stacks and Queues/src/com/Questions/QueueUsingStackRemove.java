// O(1) removal
// O(2n) => O(n) insert

package com.Questions;

import java.util.Stack;

public class QueueUsingStackRemove  {
	
	public static void main(String[] args) throws Exception {
		QueueUsingStackRemove q = new QueueUsingStackRemove();
		
		q.add(10);
		q.add(20);
		q.add(30);
		
		q.display();
		
		System.out.println(q.peek());
		
		q.add(40);
		q.add(50);
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		q.display();
		
		
	}
	
	private Stack<Integer> first;
	private Stack<Integer> second;

	public QueueUsingStackRemove() {
	    first = new Stack<>();
	    second = new Stack<>();
	  }

	public void add(int item) {
		while(!second.isEmpty()) {
			first.push(second.pop());
		}
		first.push(item);
		while(!first.isEmpty()) {
			second.push(first.pop());
		}
	}

	public int remove() throws Exception {
		return second.pop();
	}

	public int peek() throws Exception {
		return second.peek();
	}

	public boolean isEmpty() {
		return second.isEmpty();
	}
	
	public void display() {
		System.out.println("first : "+first);
		System.out.println("second : "+second);
	}
}
