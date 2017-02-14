package minimalTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimalTreeTest {
	int[] smallTestList = {1, 3, 5, 17, 23, 50};
	int[] emptyList = {};
	

	@Test
	public void testPrintNode() {
		Node c = new Node();
		c.data = 5;
		System.out.println(c);
		Node p = new Node();
		p.data = 10;
		p.left = c;
		System.out.println(p);
	}
	
	@Test
	public void testSmallList() {
		Node tree = MinimalTree.minTreeFromSortedArray(smallTestList);
		System.out.println(tree);
	}
	
	@Test
	public void testEmptyList() {
		Node tree = MinimalTree.minTreeFromSortedArray(emptyList);
		assertNull(tree);
	}
	
	 
}
