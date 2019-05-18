package org.home.prac.ds.tree;

public class BasicBinaryTree<T extends Comparable<T>> {

	private Node root;
	private int size;

	public int size() {
		return size;
	}
	
	public void add(T item) {
		Node node = new Node(item);
		if(root == null) {
			this.root = node;
			this.size++;
		} else {
			insert(this.root, node);
		}
	}
	
	/**
	 * Utitlity Function for adding a new Node to tree
	 * 
	 * @param parent node
	 * @param child node
	 */
	public void insert(Node parent, Node child) {
		if(child.getItem().compareTo(parent.getItem()) < 0) {
			if(parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			} else {
				insert(parent.getLeft(), child);
			}
		} else if (child.getItem().compareTo(parent.getItem()) > 0) {
			if(parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			} else {
				insert(parent.getRight(), child);
			}
		}
	}
	
	public boolean delete(T item) {
		//checking if the root is null
		if(this.root == null) {
			return false;
		}
		
		// find the node to delete
		Node currNode = getNode(item);
		if(currNode != null) {
			//if node does not have any children
			if(currNode.getLeft() == null && currNode.getRight() == null) {
				unlink(currNode, null);
				this.size --;
				return true;
			} else if (currNode.getLeft() == null && currNode.getRight() != null) {
				// the node has both the left and right children
				unlink(currNode, currNode.getRight());
				this.size --;
				return true;
			} else if (currNode.getLeft() != null && currNode.getRight() == null) {
				// the node has both the left and right children
				unlink(currNode, currNode.getLeft());
				this.size --;
				return true;
			} else {
				// the node has both the left and right children
				Node childNode = currNode.getLeft();
				while(childNode.getRight() != null) {
					childNode = childNode.getRight();
				}
				childNode.getParent().setRight(null);
				
				childNode.setLeft(currNode.getLeft());
				childNode.setLeft(currNode.getRight());
				
				unlink(currNode, childNode);
				this.size --;
				return true;
			}
		}
		return false;
	}
	
	private void unlink(Node currNode, Node newNode) {
		// seperate logic for root node.
		if(currNode == this.root) {
			newNode.setLeft(currNode.getLeft());
			newNode.setRight(currNode.getRight());
			this.root = newNode;
		} else if (currNode.getParent().getRight() == currNode) {
			currNode.getParent().setRight(newNode);
		} else {
			currNode.getParent().setLeft(newNode);
		}
	}
	
	public boolean contains(T item) {
		Node currNode = getNode(item);
		
		if(currNode == null) {
			return false;
		} else {
			return true;
		}
	}
	
	private Node getNode(T item) {
		Node currNode = this.root;
		
		while(currNode != null) {
			int val = item.compareTo(currNode.getItem());

			if(val == 0) {
				return currNode;
			} else if(val > 0) {
				currNode = currNode.getRight();
			} else {
				currNode = currNode.getLeft();
			}
		}
		return null;
	}
	
	private class Node {
		T item;
		private Node left;
		private Node right;
		private Node parent;
		
		public Node(T item) {
			super();
			this.item = item;
		}
		public T getItem() {
			return item;
		}
		public void setItem(T item) {
			this.item = item;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		
	}
}
