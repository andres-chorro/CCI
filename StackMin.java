import java.io.*;
import java.util.*;

public class StackMin {
    class Node {
        private int data;
        private Node next;
        private int min;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        Node t = new Node(item);
        if (top == null) 
            t.min = item;
        else
            t.min = Math.min(top.min, item);
        t.next = top;
        top = t;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public int min() {
        if (top == null) throw new EmptyStackException();
        return top.min;
    }

    public static void main(String[] args) {
        StackMin stack = new StackMin();
        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.push(50);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
        
    }
}