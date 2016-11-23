import java.util.*;

class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void appendToTail(Node newNode) {
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = newNode;
    }
}

class LoopDetection {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        Node answer = new Node(5);
        head.appendToTail(answer);
        head.appendToTail(6);
        head.appendToTail(7);
        Node end = new Node(8);
        end.next = answer;
        head.appendToTail(end);
        
        Node curr = head;
        for (int i = 0; i < 17; i++) {
            System.out.println(curr.data);
            curr = curr.next;
        }

    }

    // public static Node loopHead(Node n) {

    // }
}