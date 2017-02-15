package mygraph;

public class BuildOrder {
	private MyGraph graph;
	
	public BuildOrder() {
		graph = new MyGraph();
	}
	
	public void addProject(String name) {
		graph.addNode(name);
	}
	
	public void addDependency(String project, String dependsOn) {
		graph.addEdge(dependsOn, project);
	}
	
	public String getBuildOrder() throws Exception {
		String[] orderedList = graph.topologicalSort();
		return commaSeparatedString(orderedList);
	}
	
	private String commaSeparatedString(String[] input) {
		if (input.length < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for (String s : input) {
			sb.append(s + ", ");
		}
		sb.delete(sb.length()-2, sb.length());
		return sb.toString();
	}
}
