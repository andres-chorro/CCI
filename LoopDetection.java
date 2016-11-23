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

        Node loopHead = loopHead(head);
        System.out.println("loop head is: " + loopHead.data);
        System.out.println("Loop head (no set) is: " + startNode(head).data);

    }

    public static Node loopHead(Node n) {
        HashSet<Node> set = new HashSet<>();
        Node curr = n;
        while (n.next != null && !set.contains(curr)) {
            set.add(curr);
            curr = curr.next;
        }
        return curr;
    }

    public static Node startNode(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null)
            return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}