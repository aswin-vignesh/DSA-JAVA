package com.basic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InBuiltExamples {

	public static void main(String[] args) {
		
		System.out.println("STACK\n");
		
		Stack<Integer>  stack = new Stack<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
	
		
		System.out.println(stack);
		
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
//		stack.pop(); EmptyStackException 
		
		System.out.println(stack);
		
		System.out.println("\nQUEUE\n");
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q);
		
		q.remove();
		
		System.out.println(q);
		
		System.out.println("\nDEQUEUE\n");
		
		Deque<Integer> deq = new ArrayDeque<Integer>();
		deq.add(0);
		deq.addFirst(-1);
		deq.addLast(1);
		
		System.out.println(deq);
		
		deq.removeFirst();
		deq.removeLast();
		
		System.out.println(deq);
	}
}
