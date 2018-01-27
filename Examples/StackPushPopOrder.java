import java.util.Stack;

//question 31
public class StackPushPopOrder {
    public boolean isPopOrder(int[] pushA, int[] popA) {
        if(pushA == null || popA == null || 
            pushA.length == 0|| popA.length == 0) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty()) {
                if(stack.peek() != popA[index]) {
                    break;
                }
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
