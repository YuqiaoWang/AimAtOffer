/**
 * 面试题32-3：之字形上到下打印二叉树
 * 使用2个栈
 * 奇数层，先保存左孩子再保存右孩子
 * 偶数层，先保存右孩子再保存左孩子
 */

public class PrintTreesInZigzag {
    public static void print(BinaryTreeNode root) {
        if(root == null) {
            return ;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();   //存奇数层
        Stack<BinaryTreeNode> stack2 = new Stack<>();   //存偶数层
        int current = 0;    //标识当前奇偶层数
        //int next = 1;
        stack2.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if(current & 1 == 1) {
                BinaryTreeNode node = stack2.pop();
            }else {
                BinaryTreeNode node = stack1.pop();
            }
            System.out.printf("%d", node.value);
            if(current == 0) {
                if(node.left != null) {
                    stack1.push(node.left);
                }
                if(node.right != null) {
                    stack1.push(node.right);
                }
            }else {
                if(node.right != null) {
                    stack2.push(node.right);
                }
                if(node.left != null) {
                    stack2.push(node.left);
                }
            }

            if(current == 0 && stack2.isEmpty()) {
                System.out.print("\n");
                current= 1 - current;
                //next = 1 - next;
            }
            
        }

    }
    
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}