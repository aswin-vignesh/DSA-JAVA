package com.basic;

public class StackMain {
	
	public static void main(String[] args) throws StackException{
		
		DynamicStack stack  =  new DynamicStack(5);
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.print();
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.push(100);
		
		stack.print();
	}
}
