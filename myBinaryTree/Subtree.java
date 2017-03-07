package myBinaryTree;

class Subtree {
	public static boolean isSubtree(Node t1, Node t2) {
		if(t2 == null)
			return true;
		if(t1 == null)
			return false;
		if (treeEquals(t1, t2)) {
			return true;
		}
		return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
	}

	public static boolean treeEquals(Node t1, Node t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.data == t2.data)
			return treeEquals(t1.left, t2.left) && treeEquals(t1.right, t2.right);
		else
			return false;
	}
}

class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
	}
}