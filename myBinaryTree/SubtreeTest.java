package myBinaryTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubtreeTest {
	Node mainTree;
	Node goodSubTree;
	Node badSubTree;
	
	@Before
	public void setup() {
		mainTree = new Node(1);
		mainTree.left = new Node(2);
		mainTree.left.left = new Node(3);
		mainTree.left.right = new Node(4);
		mainTree.right = new Node(5);
		mainTree.right.left = new Node(6);
		mainTree.right.right = new Node(7);
		
		goodSubTree = new Node(5);
		goodSubTree.left = new Node(6);
		goodSubTree.right = new Node(7);
		
		badSubTree = new Node(2);
		badSubTree.left = new Node(3);
		
	}

	@Test
	public void test() {
		assertTrue(Subtree.isSubtree(mainTree, goodSubTree));
	}
	
	@Test
	public void testBad() {
		assertFalse(Subtree.isSubtree(mainTree, badSubTree));
	}

}
