package mygraph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuildOrderTest {

	BuildOrder b = new BuildOrder();

	@Before
	public void setup() {
		b.addProject("a");
		b.addProject("b");
		b.addProject("c");
		b.addProject("d");
		b.addProject("e");
		b.addProject("f");
		b.addDependency("d", "a");
		b.addDependency("b", "f");
		b.addDependency("d", "b");
		b.addDependency("a", "f");
		b.addDependency("c", "d");
	}

	@Test
	public void testSimpleExample() {
		try {
			System.out.println(b.getBuildOrder());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNonDAG() {
		try {
			b.addDependency("f", "c");
			b.getBuildOrder();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
