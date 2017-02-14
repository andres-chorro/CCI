package mygraph;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyGraphTest {
	
	MyGraph graph;
	Node a, b, c, d, e, f;
	@Before
	public void setup() {
		a = new Node("a", new LinkedList<Node>());
		b = new Node("b", new LinkedList<Node>());
		c = new Node("c", new LinkedList<Node>());
		d = new Node("d", new LinkedList<Node>());
		e = new Node("e", new LinkedList<Node>());
		f = new Node("f", new LinkedList<Node>());
		a.children.add(b);
		a.children.add(d);
		b.children.add(e);
		c.children.add(e);
		c.children.add(f);
		d.children.add(b);
		e.children.add(d);
		f.children.add(f);
		LinkedList<Node> g = new LinkedList<Node>();
		g.add(a);
		g.add(b);
		g.add(c);
		g.add(d);
		g.add(e);
		g.add(f);
		graph = new MyGraph(g);
	}

	@Test
	public void testDFS() {
		graph.dfs();
		System.out.println("DFS: " + graph.parents);
	}
	
	@Test
	public void testBFS() {
		graph.bfs();
		System.out.println("BFS: " + graph.parents);
	}
	
	@Test
	public void testGoodPaths() {
		assertTrue(graph.pathBetweenExists(a, b));
		assertTrue(graph.pathBetweenExists(a, e));
		assertTrue(graph.pathBetweenExists(a, d));
		assertTrue(graph.pathBetweenExists(b, d));
		assertTrue(graph.pathBetweenExists(b, e));
		assertTrue(graph.pathBetweenExists(c, e));
		assertTrue(graph.pathBetweenExists(c, d));
		assertTrue(graph.pathBetweenExists(c, f));
	}
	
	@Test
	public void testSameNodeGoodPath() {
		assertTrue(graph.pathBetweenExists(a, a));
		assertTrue(graph.pathBetweenExists(f, f));
	}
	
	@Test
	public void testBadPaths() {
		assertFalse(graph.pathBetweenExists(a, f));
		assertFalse(graph.pathBetweenExists(b, a));
		assertFalse(graph.pathBetweenExists(f, b));
	}

}
