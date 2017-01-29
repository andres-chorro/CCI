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
	
	@Test
	public void simpleNotInDiagonal() {
		int[][] matrix = {{1, 5, 7}, {3, 12, 20}, {5, 13, 25}, {12, 14, 30}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(13);
		assertEquals(2, found.row);
		assertEquals(1, found.col);
	}
	@Test
	public void simpleNotInDiagonal2() {
		int[][] matrix = {{1, 5, 7}, {3, 12, 20}, {5, 13, 25}, {12, 14, 30}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(3);
		assertEquals(1, found.row);
		assertEquals(0, found.col);
	}
	@Test
	public void simpleNotInDiagonal3() {
		int[][] matrix = {{1, 5, 7}, {3, 12, 20}, {5, 13, 25}, {12, 14, 30}};
		SortedMatrixSearch m = new SortedMatrixSearch(matrix);
		Coord found = m.search(1);
		assertEquals(0, found.row);
		assertEquals(0, found.col);
	}

}
