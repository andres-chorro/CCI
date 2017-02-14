package mygraph;
import java.util.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MyGraphTest {
	
	MyGraph graph;
	@Before
	public void setup() {
		Node a = new Node("a", new LinkedList<Node>());
		Node b = new Node("b", new LinkedList<Node>());
		Node c = new Node("c", new LinkedList<Node>());
		Node d = new Node("d", new LinkedList<Node>());
		Node e = new Node("e", new LinkedList<Node>());
		Node f = new Node("f", new LinkedList<Node>());
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

}
