package org.home.prac.ds.queue;

public class BasicQueue<T> {

	private T[] data;
	
	private int front;
	
	private int rear;
	
	public BasicQueue() {
		this(100);
	}
	
	public BasicQueue(int size) {
		data = (T[]) new Object[100];
		front = -1;
		rear = -1;
	}
	
	public int size() {
		// if queue is empty then return 0
		if (front == -1 && rear == -1) {
			return 0;
		} else {
			return rear - front + 1;
		}
	}
	
	public void enQueue(T item) {
		// Checking if the queue is full
		if( (rear+1) % data.length == front) {
			throw new IllegalStateException("The Queue is full");
		} else if (size() == 0) {
			front++;
		}
		data[rear++] = item;
	}
	
	public T deQueue() {
		T item = null;
		if(size() == 0) {
			throw new IllegalStateException("The Queue is Empty");
		} else if (front == rear) {
			item = data[front];
			data[front] = null;// for garbage collection
			front = -1;
			rear = -1;
		} else {
			item = data[front];
			data[front] = null;// for garbage collection
			front++;
		}
		return item;
	}
	
	public T access(int position) {
		if(size() == 0 || position > size()) {
			throw new IllegalStateException("Queue is Empty");
		}
		int trueIndex = 0; // Because front pointer is not necessarily at start
		for(int i = front; i < rear; i++) {
			if(position == trueIndex) {
				return data[i];
			}
		}
		return null;
	}
	
	public boolean contains(T item) {
		if(size() == 0) {
			return false;
		}
		for(int i = front; i < rear; i++) {
			if(data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
	
}
