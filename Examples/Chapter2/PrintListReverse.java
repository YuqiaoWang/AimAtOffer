import java.util.Stack;

public class PrintListReverse {
    /**
     * 面试题6：从尾到头打印链表
     */
    static void printListReverse(LinkNode root) {
        if(root == null) {
            return ;
        }
        Stack<LinkNode> stack = new Stack<LinkNode>();
        while(root != null) {
            stack.push(root);
            root = root.next;
        }

        while(!stack.isEmpty()) {
            LinkNode node = stack.pop();
            System.out.println(node.val);
        }
    }

    
}

class LinkNode {
    LinkNode next;
    int val;
}