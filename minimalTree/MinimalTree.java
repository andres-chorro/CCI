package minimalTree;

public class MinimalTree {
	public static Node minTreeFromSortedArray(int[] array) {
		return minTreeHelper(array, 0, array.length - 1);
	}
	
	private static Node minTreeHelper(int[] arr, int i, int j) {
		if (i > j) {
			return null;
		}
		int mid = (i+j) / 2;
		Node node = new Node();
		node.data = arr[mid];
		node.left = minTreeHelper(arr, i, mid-1);
		node.right = minTreeHelper(arr, mid+1, j);
		return node;
	}
	
}

class Node {
	int data;
	Node left;
	Node right;
	
	@Override
	public String toString() {
		String leftS = (left == null) ? "" : left.toString();
		String rightS = (right==null) ? "" : right.toString();
		return "[" + leftS + " " + data + " " + rightS + "]"; 
	}
}