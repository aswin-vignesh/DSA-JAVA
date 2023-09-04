package com.basic;

public class CustomStack {
	
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	int ptr = -1;
	
	public CustomStack() {
		this(DEFAULT_SIZE); // calls the below constructor
	}
	public CustomStack(int size) {
		this.data = new int [size];
	}
	
	public boolean push(int item) {
		
		if(isFull()) {
			System.out.println("Stack is full");
			return false;
		}
		data[++ptr] = item;
		return true;
	}
	
	public int pop() throws StackException{
		if(isEmpty()) {
			throw new StackException("Cannot pop Empty Stack");
		}
//      int removed = data[ptr];
//      ptr--;
//      return removed;
		return data[ptr--];
	}
	
	public int peek() throws StackException{
		if(isEmpty()) {
			throw new StackException("Cannot peek from empty Stack");
		}
		return data[ptr];
	}
	
	
	
	public boolean isFull() {
		return ptr == data.length-1;
	}
	public boolean isEmpty() {
		return ptr == -1;
	}
	
	
	
	
	
	public void print() {
		for(int i = 0 ; i <= ptr ; i++) {
			System.out.print("[ "+data[i]+" ] ,");
		}
		System.out.println();
	}

}
