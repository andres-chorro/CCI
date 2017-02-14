package mygraph;

import java.util.*;

public class MyGraph {

	public List<Node> nodes;
	public HashMap<Node, Node> parents;

	public MyGraph(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}

	public void dfs() {
		parents = new HashMap<>();
		for (Node n : nodes) {
			if (!parents.containsKey(n)) {
				parents.put(n, null);
				dfsVisit(n);
			}
		}
	}

	public void dfsVisit(Node n) {
		for (Node child : n.children) {
			if (!parents.containsKey(child)) {
				parents.put(child, n);
				dfsVisit(child);
			}
		}
	}

	public void bfs() {
		parents = new HashMap<>();
		for (Node n : nodes) {
			if (!parents.containsKey(n)) {
				parents.put(n, null);
				bfsVisit(n);
			}
		}
	}

	public void bfsVisit(Node root) {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node p = queue.pop();
			for (Node c : p.children) {
				if (!parents.containsKey(c)) {
					parents.put(c, p);
					queue.add(c);
				}
			}
		}
	}

	public boolean pathBetweenExists(Node a, Node b) {
		if (a == b) {
			return true;
		}
		LinkedList<Node> queue = new LinkedList<>();
		HashSet<Node> seen = new HashSet<>();
		queue.add(a);
		seen.add(a);
		while (queue.isEmpty() == false) {
			Node p = queue.pop();
			for (Node c : p.children) {
				if (c == b) {
					return true;
				}
				if (seen.contains(c) == false) {
					queue.add(c);
					seen.add(c);
				}
			}
		}
		return false;
	}
}

class Node {
	public String name;
	public LinkedList<Node> children;

	public Node(String name, LinkedList<Node> children) {
		this.name = name;
		this.children = children;
	}

	@Override
	public String toString() {
		return name;
	}
}