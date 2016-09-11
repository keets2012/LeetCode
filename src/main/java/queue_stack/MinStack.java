package queue_stack;


import java.util.Stack;

public class MinStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        int min = node;
        if (!stack2.empty()) {
            min = stack2.peek();
        }
        if (min>node) {
            stack2.push(min);
        } else
            stack2.push(node);
    }

    public void pop() {
        int val = stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
