class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int d) {
        data = d;
    }

    public void insert(int d) {
        Node newNode = new Node(d);
        if (d < data) {
            if (left == null) {
                newNode.parent = this;
                left = newNode;
            } else {
                left.insert(d);
            }
        } else if (d > data) {
            if (right == null) {
                newNode.parent = this;
                right = newNode;
            } else {
                right.insert(d);
            }
        } else {
            return;
        }
    }

    public void insert(Node n) {
        if (n.data < data) {
            if (left == null) {
                n.parent = this;
                left = n;
            } else {
                left.insert(n);
            }
        } else if (n.data > data) {
            if (right == null) {
                n.parent = this;
                right = n;
            } else {
                right.insert(n);
            }
        } else {
            return;
        }
    }

    public void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printPreOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printPreOrder();
        }
    }

}
public class Successor {
    public static void main(String[] args) {
        System.out.println("hellow world");
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node root = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node ten = new Node(10);

        root.insert(three);
        root.insert(one);
        root.insert(two);
        root.insert(four);
        root.insert(eight);
        root.insert(seven);
        root.insert(six);
        root.insert(ten);
        root.printPreOrder();
        System.out.println("Successor of 1 is: " + getSuccessor(one));
        System.out.println("Successor of 2 is: " + getSuccessor(two));
        System.out.println("Successor of 3 is: " + getSuccessor(three));
        System.out.println("Successor of 4 is: " + getSuccessor(four));
        System.out.println("Successor of 5 is: " + getSuccessor(root));
        System.out.println("Successor of 6 is: " + getSuccessor(six));
        System.out.println("Successor of 7 is: " + getSuccessor(seven));
        System.out.println("Successor of 8 is: " + getSuccessor(eight));
        System.out.println("Successor of 10 is: " + getSuccessor(ten));

    }

    public static int getMin(Node n) {
        if (n.left == null)
            return n.data;
        return getMin(n.left);
    }

    public static int getSuccessor(Node n) {
        if (n.right != null) 
            return getMin(n.right);
        else {
            while (n.parent != null) {
                if (n.parent.left == n)
                    return n.parent.data;
                n = n.parent;
            }
            return Integer.MIN_VALUE;
        }
    }
}