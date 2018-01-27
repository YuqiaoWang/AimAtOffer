import java.util.LinkedList;
import java.util.Queue;

//question 32
public class PrintTreeFromTopToBottom {
    public void printTreeFromTopToBottom(BinaryTreeNode root) {
        if(root == null) {
            return ;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value);
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}