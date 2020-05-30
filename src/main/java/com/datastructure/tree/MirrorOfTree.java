package com.datastructure.tree;

public class MirrorOfTree {

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
		
//		new MirrorOfTree().mirrorOfTree_Type1(tree.root);
//		System.out.println("Level order traversal of Mirrored binary tree is ");
//		tree.printLevelOrder();
		
		Node n = new MirrorOfTree().mirrorOfTree_type2(tree.root);
		tree.root = n;
		System.out.println("Level order traversal of Mirrored binary tree is ");
		tree.printLevelOrder();
	}

	private void mirrorOfTree_Type1(Node node) {

		if(node == null) {
			return;
		}
		
		mirrorOfTree_Type1(node.left);
		mirrorOfTree_Type1(node.right);
		
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	private Node mirrorOfTree_type2(Node node) {

		if(node == null) {
			return null;
		}
		
		Node left =  mirrorOfTree_type2(node.left);
		Node right = mirrorOfTree_type2(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	
	
	
	

}
