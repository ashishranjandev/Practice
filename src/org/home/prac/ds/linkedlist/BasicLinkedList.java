package org.home.prac.ds.linkedlist;

public class BasicLinkedList<T> {

	private Node first;
	private Node last;
	private int nodeCount;
	
	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}
	
	public void add(T item) {
		if(item == null) {
			first = new Node(item);
			last = first;
		} else {
			Node newLastNode = new Node(item);
			last.nextNode = newLastNode;
			this.last = newLastNode;
		}
		this.nodeCount++;
	}
	
	public T remove() {
		if(first == null) {
			throw new IllegalStateException("No deletion allowed on empty linkedList");
		} else {
			T nodeItem = first.getNodeItem();
			first = first.getNextNode();
			nodeCount--;
			return nodeItem;
		}
	}
	
	public T removeAt(int postion) {
		if(first == null) {
			throw new IllegalStateException("No deletion allowed on empty linkedList");
		} else {
			Node currNode = first;
			Node prevNode = null;
			for(int i = 1; i < postion; i++) {
				if(currNode == null) {
					return null;
				}
				prevNode = currNode;
				currNode = currNode.nextNode;
			}
			T nodeItem = currNode.getNodeItem();
			prevNode.setNextNode(currNode.nextNode);
			nodeCount--;
			return nodeItem;
		}
	}
	
	public T get(int position) {
		if(first == null) {
			throw new IllegalStateException("List is Empty");
		}
		Node currNode = first;
		int idx = 0;
		while(currNode != null) {
			if(idx == position) {
				return currNode.getNodeItem();
			}
			currNode = currNode.getNextNode();
			idx++;
		}
		return null;
	}
	
	public int find(T item) {
		if(first == null) {
			throw new IllegalStateException("List is Empty");
		}
		Node currNode = first;
		int idx = 0;
		while(currNode != null) {
			if(currNode.getNodeItem().equals(item)) {
				return idx;
			}
			currNode = currNode.getNextNode();
			idx++;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node currNode = first;
		
		while(currNode != null) {
			sb.append(currNode.getNodeItem());
			currNode = currNode.getNextNode();
			
			if(currNode != null) {
				sb.append(",");
			}
		}
		
		return sb.toString();
	}

	
	private class Node {
		
		private Node nextNode;
		private T nodeItem;
		
		public Node(T item) {
			this.nodeItem = item;
			this.nextNode = null;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public T getNodeItem() {
			return nodeItem;
		}

	}
}
