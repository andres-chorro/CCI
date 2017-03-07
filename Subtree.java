class Subtree {
	public boolean isSubtree(Node t1, Node t2) {
		if (treeEquals(t1, t2)) {
			return true;
		}
		return isSubtree(t1.lelft, t2) || isSubtree(t1.right, t2);
	}

	public boolean treeEquals(Node t1, Node t2) {
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
}