package queue_stack;


import java.util.Stack;

public class ToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (stack2.size()<1) {
            stack1.push(node);
        }
        if (stack2.size()>0) {
            stack1.push(node);
        }
    }

    public int pop() {
        int val = 0;
        if (stack2.size() > 0) {
            val = stack2.pop();
            return val;
        }
        if (stack1.size() > 0) {
            while (stack1.size()>1) {
                stack2.push(stack1.pop());
            }
            val = stack1.pop();
        }
            return val;
    }
}
