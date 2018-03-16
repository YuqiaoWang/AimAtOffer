import java.util.Stack;

//question 30
public class MinInStack {
    /**
     * 面试题30：包含min的栈
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.size() == 0 || minStack.peek() > node) {
            minStack.push(node);
        }else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}