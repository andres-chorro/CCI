package mygraph;

import java.util.*;

public class MyGraph {

	public List<Node> nodes;
	public HashMap<Node, Node> parents;
	private HashSet<Node> tempMark;
	private HashSet<Node> permMark;
	

	public MyGraph(LinkedList<Node> nodes) {
		this.nodes = nodes;
	}
	
	public MyGraph() {
		this.nodes = new LinkedList<>();
	}
	
	public void addNode(String s) {
		nodes.add(new Node(s));
	}
	
	public void addEdge(String parent, String child) {
		Node parentNode = null;
		Node childNode = null;
		for (Node n : nodes) {
			if (n.name.equals(parent))
				parentNode = n;
			if (n.name.equals(child))
				childNode = n;
		}
		parentNode.children.add(childNode);
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
	
	public String[] topologicalSort() throws Exception {
		LinkedList<String> result = new LinkedList<>();
		permMark = new HashSet<>();
		tempMark = new HashSet<>();
		for (Node n : nodes) {
			if (permMark.contains(n) == false) {
				topSortVisit(n, result);
			}
		}
		return result.toArray(new String[0]);
	}
	
	private void topSortVisit(Node n, List<String> result) throws Exception {
		if (tempMark.contains(n)) {
			throw new Exception("Not a DAG");
		}
		if (permMark.contains(n) == false) {
			tempMark.add(n);
			for (Node c : n.children) {
				topSortVisit(c, result);
			}
			permMark.add(n);
			tempMark.remove(n);
			result.add(0, n.name);
		}
	}
}

class Node {
	public String name;
	public LinkedList<Node> children;

	public Node(String name, LinkedList<Node> children) {
		this.name = name;
		this.children = children;
	}
	
	public Node(String name) {
		this.name = name;
		this.children = new LinkedList<>();
	}

	@Override
	public String toString() {
		return name;
	}
}