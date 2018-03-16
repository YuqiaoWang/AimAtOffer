import java.util.Stack;

public class QueueWithTwoStacks{
    /**
     * 面试题9：两个栈实现队列
     */
    static Stack<Character> stack1 = new Stack<Character>();
    static Stack<Character> stack2 = new Stack<Character>();

    static void add(char c) {
        stack1.push(c);
    }

    static char delete() {
        if(!stack2.isEmpty()) {
            char result = stack2.pop();
            return result;
        }else if(!stack1.isEmpty()){
            while(!stack1.isEmpty()) {
                Character c = stack1.pop();
                stack2.push(c);
            }
            char result = stack2.pop();
            return result;
        }else {
            throw new Exception("empty queue!");
        }
    }

    public static void main(String[] args) {
        char result = ' ';
        add('a');
        add('b');
        add('c');
        result = delete();
        System.out.println(result);
        result = delete();
        System.out.println(result);
        add('d');
        result = delete();
        System.out.println(result);
    }
}