package queue_stack;

import java.util.Stack;

public class PopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        for (Integer i : popA) {
            if (!stack.empty() && i == stack.peek()) {
                stack.pop();
            } else {
                while (count < pushA.length && i != pushA[count]) {
                    stack.push(pushA[count]);
                    count++;
                    if (count == pushA.length) {
                        return false;
                    }
                }
                if (i != pushA[count]) {
                    return false;

                }
                stack.push(i);
                count++;
            }
        }
        return true;
    }
}
