import static org.junit.Assert.*;

import org.junit.Test;

public class SparceSearchTest {
	
	@Test
	public void simpleCase() {
		String[] list = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		assertEquals(4, SparceSearch.sparceBinarySearch("ball", list));
	}
	
	@Test
	public void simpleCase2() {
		String[] list = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		assertEquals(10, SparceSearch.sparceBinarySearch("dad", list));
	}

	@Test
	public void emptyList() {
		String[] emptyList = {};
		assertEquals(-1, SparceSearch.sparceBinarySearch("hello", emptyList));
	}

	@Test
	public void multipleMatches() {
		String[] list = { "at", "", "", "", "ball", "ball", "", "car", "", "", "dad", "", "" };
		assertEquals(5, SparceSearch.sparceBinarySearch("ball", list));
	}
	
	@Test
	public void noMatch() {
		String[] list = { "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "" };
		assertEquals(-1, SparceSearch.sparceBinarySearch("nope", list));
	}

}
