package com.basic;

public class CircularQueue {
	
	protected int[] data;
	private static final int DEFAULT_SIZE = 10;
	
	int front = 0;
	int end = 0;
	int size = 0;
	
	
	public CircularQueue() {
		this.data = new int[DEFAULT_SIZE];
	}
	public CircularQueue(int size) {
		this.data = new int[size];
	}
	
	public boolean isFull() {
		return size == data.length;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean insert(int item) {
		if(isFull()) {
			System.out.println("Cannot Insert , QUEUE is Full");
			return false;
		}
		data[end++] = item;
		end = end%data.length;
		size++;
		return true;
	}
	
	
	public int remove() throws Exception{
		if(isEmpty()) {
			throw new Exception("Cannot Remove , QUEUE is empty");
		}
		int item = data[front++];
		front = (front)%data.length;
		size--;
		return item;		
	}
	
	public int front() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return data[front];
    }
	
	public void display2() {
		for(int i=0 ; i < size ; i++) {
			System.out.print("[ "+data[(front+i)%data.length]+" ] ,");
		}
		System.out.println();
	}
	
	public void display() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        } while (i != end);
        System.out.println("END");
    }
	
}
