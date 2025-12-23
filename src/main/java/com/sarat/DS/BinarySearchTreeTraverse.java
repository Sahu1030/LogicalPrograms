package com.sarat.DS;

import java.util.ArrayList;
import java.util.Queue;

import com.sarat.DS.BinarySearchTreeTraverse.Node;

import java.util.LinkedList;

public class BinarySearchTreeTraverse {

	public BinarySearchTreeTraverse() {
		// TODO Auto-generated constructor stub
	}

	public Node root;

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		private Node(int value) {
			this.value = value;
		}
	}

	public boolean insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return true;
		}
		Node temp = root;
		while (true) {
			if (newNode.value == temp.value)
				return false;
			if (newNode.value < temp.value) {
				if (temp.left == null) {
					temp.left = newNode;
					return true;
				}
				temp = temp.left;
			} else {
				if (temp.right == null) {
					temp.right = newNode;
					return true;
				}
				temp = temp.right;
			}
		}
	}

	public boolean contains(int value) {
		if (root == null)
			return false;
		Node temp = root;
		while (temp != null) {
			if (value < temp.value) {
				temp = temp.left;
			} else if (value > temp.value) {
				temp = temp.right;
			} else {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Integer> BFS() {
		ArrayList<Integer> results = new ArrayList<>();
		if (root == null) return results;
		Node currentNode = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(currentNode);

//		while (queue.size() > 0) {
        while (!queue.isEmpty()) {
			currentNode = queue.remove();
			results.add(currentNode.value);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return results;
	}

	public ArrayList<Integer> DFSPreOrder() {
		ArrayList<Integer> results = new ArrayList<>();

		class Traverse {
			Traverse(Node currentNode) {
				results.add(currentNode.value);
				if (currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				if (currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}

		new Traverse(root);
		return results;
	}

	public ArrayList<Integer> DFSPostOrder() {
		ArrayList<Integer> results = new ArrayList<>();

		class Traverse {
			Traverse(Node currentNode) {
				if (currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				if (currentNode.right != null) {
					new Traverse(currentNode.right);
				}
				results.add(currentNode.value);
			}
		}

		new Traverse(root);
		return results;
	}

	public ArrayList<Integer> DFSInOrder() {
		ArrayList<Integer> results = new ArrayList<>();

		class Traverse {
			Traverse(Node currentNode) {
				if (currentNode.left != null) {
					new Traverse(currentNode.left);
				}
				results.add(currentNode.value);
				if (currentNode.right != null) {
					new Traverse(currentNode.right);
				}
			}
		}

		new Traverse(root);
		return results;
	}
	
	// Inorder: Left -> Root -> Right
    public void inorderTraversal(Node root) {
        if (root == null) return;
        inorderTraversal(root.left);
        System.out.print(root.value + " ");
        inorderTraversal(root.right);
    }

    // Preorder: Root -> Left -> Right
    public void preorderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Postorder: Left -> Right -> Root
    public void postorderTraversal(Node root) {
        if (root == null) return;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.value + " ");
    }
    
    public ArrayList<Integer> BFS1(Node root) {
		ArrayList<Integer> results = new ArrayList<>();
		if (root == null) return results;
		Node currentNode = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(currentNode);

//		while (queue.size() > 0) {
        while (!queue.isEmpty()) {
			currentNode = queue.remove();
			results.add(currentNode.value);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
		return results;
	}

	public static void main(String[] args) {

		BinarySearchTreeTraverse myBST = new BinarySearchTreeTraverse();

		myBST.insert(47);
		myBST.insert(21);
		myBST.insert(76);
		myBST.insert(18);
		myBST.insert(27);
		myBST.insert(52);
		myBST.insert(82);

		System.out.println("\nBFS InOrder:");
		System.out.println(myBST.BFS());
		System.out.println("\nDFS InOrder:");
		System.out.println(myBST.DFSInOrder());
		System.out.println("\nDFS PostOrder:");
		System.out.println(myBST.DFSPostOrder());
		System.out.println("\nDFS PreOrder:");
		System.out.println(myBST.DFSPreOrder());
		
		System.out.println("==================================");
		
		/*
        1
       / \
      2   3
     / \   \
    4   5   6
*/
		Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.print("Inorder: ");
        myBST.inorderTraversal(root);     // Output: 4 2 5 1 3 6
        System.out.println();

        System.out.print("Preorder: ");
        myBST.preorderTraversal(root);    // Output: 1 2 4 5 3 6
        System.out.println();

        System.out.print("Postorder: ");
        myBST.postorderTraversal(root);   // Output: 4 5 2 6 3 1
        System.out.println();
        
        System.out.println( myBST.BFS1(root));

		/*
		 * EXPECTED OUTPUT: ---------------- DFS InOrder: [18, 21, 27, 47, 52, 76, 82]
		 * 
		 */
		/*
		 * INORDER: Left → Root → Right
		 * 
		 * So the steps are:
		 * 
		 * Go left from 1 to 2
		 * 
		 * Go left from 2 to 4
		 * 
		 * 4 has no left → print 4
		 * 
		 * Go back to 2, print 2
		 * 
		 * Go right to 5, print 5
		 * 
		 * Go back to 1, print 1
		 * 
		 * Go right to 3
		 * 
		 * 3 has no left → print 3
		 * 
		 * Go right to 6, print 6
		 */

	}

}
