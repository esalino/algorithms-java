package trees;

// https://www.hackerrank.com/challenges/self-balancing-tree/problem
public class AvlTreeInsert {
	
	static Node insert(Node root, int val) {
		if (root == null) {
			Node n = new Node();
			n.ht = 0;
			n.val = val;
			return n;
		}
		insertAndBalanceSubtrees(root, val);
		// Still need to balance root;
		root = balanceSubtree(root);
		root.ht = getHeight(root) + 1;
		return root;
	
	}
	
	private static Node insertAndBalanceSubtrees(final Node node, int val) {
		if (node == null) {
			return null;
		}
		
		Node child = val < node.val ? node.left : node.right;
		Node newChild = insertAndBalanceSubtrees(child, val);
		
		if (newChild == null) {
			Node newNode = new Node();
			newNode.val = val;
			newNode.ht = 0;
			// If height is 0 it is now 1 otherwise same as it already was.
			if (node.ht == 0) {
				node.ht = 1;
			}
			if (val < node.val) {
				node.left = newNode;
			} else {
				node.right = newNode;
			} 
			return node;
		}
		
		if (val < node.val) {
			node.left = balanceSubtree(node.left);
		} else {
			node.right = balanceSubtree(node.right);
		} 
		node.ht = getHeight(node) + 1;
		return node;
	}
	
	private static Node balanceSubtree(Node node) {
		int balance = getBalance(node);
		if (balance > -2 && balance < 2) {
			return node;
		}
		if (balance == 2) {
			int childBalance = getBalance(node.left);
			if (childBalance < 0) {
				Node temp = node.left.right;
				node.left.right = node.left.right.left;
				temp.left = node.left;
				node.left = temp;
				
				node.left.left.ht = getHeight(node.left.left);
				node.left.ht = getHeight(node.left);
				node.ht = getHeight(node);
			}
			Node temp = node.left;
			node.left = node.left.right;
			temp.right = node;
			
			temp.left.ht = getHeight(temp.left) + 1;
			temp.right.ht = getHeight(temp.right) + 1;
			temp.ht = getHeight(temp) + 1;
			return temp;
		} else {
			int childBalance = getBalance(node.right);
			if (childBalance > 0) {
				Node temp = node.right.left;
				node.right.left = node.right.left.right;
				temp.right = node.right;
				node.right = temp;
				
				node.right.right.ht = getHeight(node.right.right);
				node.right.ht = getHeight(node.right);
				node.ht = getHeight(node);
			}
			Node temp = node.right;
			node.right = node.right.left;
			temp.left = node;
			
			temp.right.ht = getHeight(temp.right) + 1;
			temp.left.ht = getHeight(temp.left) + 1;
			temp.ht = getHeight(temp) + 1;
			return temp;
		}
	}
	
	private static int getBalance(Node node) {
		int leftHeight = node.left == null ? -1 : node.left.ht;
		int rightHeight = node.right == null ? -1 : node.right.ht;
		return leftHeight - rightHeight;
	}
	
	private static int getHeight(Node node) {
		int leftH = node.left == null ? -1 : node.left.ht;
		int rightH = node.right == null ? -1 : node.right.ht;
		return Math.max(leftH, rightH);
	}

}

class Node {
	int val; // Value
	int ht; // Height
	Node left; // Left child
	Node right; // Right child
}
