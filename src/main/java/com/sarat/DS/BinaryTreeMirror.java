package com.sarat.DS;





class BinaryTreeMirror {
    Node root;

    // Function to create a mirror image of the binary tree
    void mirror(Node node) {
        if (node == null) {
            return;
        }

        // Swap the left and right children
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recursively call mirror on the left and right subtrees
        mirror(node.left);
        mirror(node.right);
    }

    // Function to print the tree in-order (for testing)
    void printInOrder(Node node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
    	BinaryTreeMirror tree = new BinaryTreeMirror();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Original In-Order Traversal of the Binary Tree:");
        tree.printInOrder(tree.root);

        // Create the mirror image of the binary tree
        tree.mirror(tree.root);

        System.out.println("\nIn-Order Traversal of the Mirrored Binary Tree:");
        tree.printInOrder(tree.root);
        
        
    }
}
