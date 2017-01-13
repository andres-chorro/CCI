public class MyGraph {

    public Node[] nodes;

    public MyGraph(Node[] nodes) {
        this.nodes = nodes;
    }

    class Node {
        public String name;
        public Node[] children;

        public Node(String name, Node[] children) {
            this.name = name;
            this.children = children;
        }
    }

    public static void main(String[] args) {
        System.out.println("Running MyGraph Tests");
    }
}