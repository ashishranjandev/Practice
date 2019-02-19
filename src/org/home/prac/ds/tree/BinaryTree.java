package org.home.prac.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}

public class BinaryTree {
	Node root = null;

	void printPostorder(Node node) {
		if (node == null)
			return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.key + " ");
	}

	void printInorder(Node node) {
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.key + " ");
		printInorder(node.right);
	}

	void printPreorder(Node node) {
		if (node == null)
			return;
		System.out.print(node.key + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	int height(Node node) {
		if (node == null) {
			return 0;
		} else {
			int ldepth = height(node.left);
			int rdepth = height(node.right);
			if (ldepth > rdepth) {
				return ldepth + 1;
			} else {
				return rdepth + 1;
			}
		}
	}
	
	int diameter(Node node) {
		if(node == null) {
			return 0;
		}
		int ldepth = height(node.left);
		int rdepth = height(node.right);
		
		int ldiameter = diameter(node.left);
		int rdiameter= diameter(node.right);
		
		return Math.max(Math.max(ldiameter+1, rdiameter+1), ldepth+rdepth+1);
	}
	
	int maxWidth(Node node) {
		if(node == null) {
			return 0;
		}
		Queue<Node> queue = new ArrayBlockingQueue<>(10);
		int result = 0;
		
		queue.add(node);
		while(!queue.isEmpty()) {
			int count = queue.size();
			result = Math.max(queue.size(), result);
			
			while(count != 0) {
				count --;
				Node poppedNode = queue.poll();
				if(poppedNode.left != null) {
					queue.add(poppedNode.left);
				}
				if(poppedNode.right != null) {
					queue.add(poppedNode.right);
				}
			}
		}
		return result;
	}
	
	void printIterativeInorder(Node node) {
		Node currNode = null;
		Stack<Node> stack = new Stack<Node>();
		currNode = node;
		while (currNode != null || !stack.isEmpty()) {
			if (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			} else if (!stack.isEmpty()) {
				Node poppedNode = stack.pop();
				System.out.print(poppedNode.key + " ");
				currNode = poppedNode.right;
			}
		}
	}

	void printIterativePreorder(Node node) {
		if (node == null) {
			return;
		} else {
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);
			while (!stack.isEmpty()) {
				Node poppedNode = stack.pop();
				System.out.print(poppedNode.key + " ");

				if (poppedNode.right != null) {
					stack.push(poppedNode.right);
				}
				if (poppedNode.left != null) {
					stack.push(poppedNode.left);
				}
			}
		}
	}

	void printLevelOrder(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node topNode = queue.poll();
			if (topNode.left != null)
				queue.add(topNode.left);
			if (topNode.right != null)
				queue.add(topNode.right);
			System.out.print(topNode.key + " ");
		}
	}

	void printReverseLevelOrder(Node node) {
		if (node == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node topNode = queue.poll();
			if (topNode.left != null)
				queue.add(topNode.left);
			if (topNode.right != null)
				queue.add(topNode.right);
			stack.add(topNode);
		}

		while (!stack.isEmpty()) {
			Node topNode = stack.pop();
			System.out.print(topNode.key + " ");
		}
	}

	void printInorderMorris(Node node) {
		Node curr = node;
		Node pre = null;
		while (curr != null) {
			if (curr.left == null) {
				System.out.print(curr.key + " ");
				curr = curr.right;
			} else {
				// Find the inorder predecessor of curr
				pre = curr.left;
				while (pre.right != null && pre.right != curr) {
					pre = pre.right;
				}
				// Make curr as right child of its inorder predecessor
				if (pre.right == null) {
					pre.right = curr;
					curr = curr.left;
				} else {
					pre.right = null;
					System.out.print(curr.key + " ");
					curr = curr.right;
				}
			}
		}
	}

	void printPreorderMorris(Node node) {
		while (node != null) {
			// If left child is null, print the current node data. Move to right
			// child.
			if (node.left == null) {
				System.out.print(node.key + " ");
				node = node.right;
			} else {
				// Find inorder predecessor
				Node current = node.left;
				while (current.right != null && current.right != node) {
					current = current.right;
				}
				// If the right child of inorder predecessor already points to
				// this node
				if (current.right == node) {
					current.right = null;
					node = node.right;
				}
				// If right child doesn't point to this node, then print this
				// node and make right child point to this node
				else {
					System.out.print(node.key + " ");
					current.right = node;
					node = node.left;
				}
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder(tree.root);

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder(tree.root);

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder(tree.root);
		
		System.out.println("\nHeight of binary tree is : "+tree.height(tree.root));
		System.out.println("\nDiameter of binary tree is : "+tree.diameter(tree.root));
		System.out.println("\nMax width of binary tree is : "+tree.maxWidth(tree.root));

		System.out.println("\nInorder-Iterative traversal of binary tree is ");
		tree.printIterativeInorder(tree.root);

		System.out.println("\nPreorder-Iterative traversal of binary tree is ");
		tree.printIterativePreorder(tree.root);

		System.out.println("\nLevel-Order traversal of binary tree is ");
		tree.printLevelOrder(tree.root);

		System.out.println("\nReverse-Level-Order traversal of binary tree is ");
		tree.printReverseLevelOrder(tree.root);

		System.out.println("\nMorris-In-Order traversal of binary tree is ");
		tree.printInorderMorris(tree.root);

		System.out.println("\nMorris-Pre-Order traversal of binary tree is ");
		tree.printPreorderMorris(tree.root);
	}

}
