package org.home.prac.ds.stack;

public class BasicStack<T> {

	private T[] data;
	
	private int stackPointer;
	
	public BasicStack() {
		data = (T[]) new Object[100];
		stackPointer = 0;
	}
	
	public void push(T newItem) {
		data[stackPointer++] = newItem;
		
	}
	
	public T pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("Stack is Empty.");
		}
		return data[--stackPointer];
	}
	
	public boolean contains(T item) {
		boolean found = false;
		
		for(int i = 0; i < stackPointer; i++) {
			if(data[i].equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public T access(T item) {
		while(stackPointer > 0) {
			T stackItem = pop();
			if(item.equals(stackItem)) {
				return stackItem;
			}
		}
		return null;
	}
	
	public int size() {
		return stackPointer;
	}
	
}