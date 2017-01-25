import static org.junit.Assert.*;

import org.junit.Test;

public class SortedMatrixSearchTest {

	@Test
	public void oneByOneMatrix() {
		int[][] matrix = {{50}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(50);
		assertEquals(0, found.row);
		assertEquals(0, found.col);
	}
	
	@Test
	public void noMatch() {
		int[][] matrix = {{50}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(49);
		assertEquals(-1, found.row);
		assertEquals(-1, found.col);
	}
	
	@Test
	public void empty1() {
		int[][] matrix = {};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(15);
		assertEquals(-1, found.row);
		assertEquals(-1, found.col);
	}
	
	@Test
	public void empty2() {
		int[][] matrix = {{}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(15);
		assertEquals(-1, found.row);
		assertEquals(-1, found.col);
	}

}
