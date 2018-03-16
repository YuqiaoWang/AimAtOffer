import java.util.Stack;

public class QueueWithTwoStacks{
    /**
     * 面试题9：两个栈实现队列
     */
    static Stack<Character> stack1 = new Stack<Character>();    //stack1用来压入
    static Stack<Character> stack2 = new Stack<Character>();    //stack2用来弹出

    static void add(char c) {
        stack1.push(c);
    }

    static char delete() {
        if(!stack2.isEmpty()) {         //stack2非空，直接从stack2弹出元素
            char result = stack2.pop();
            return result;
        }else if(!stack1.isEmpty()){    //stack2空，先把stack1中的元素全部压入stack2中，再弹出栈顶
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
    /**
     * 测试用例
     */
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