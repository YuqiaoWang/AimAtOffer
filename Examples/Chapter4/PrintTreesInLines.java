/**
     * 面试题32-2：分行从上到下打印二叉树
     */

public class PrintTreesInLines {
    public static void print(TreeNode root) {
        if(root == null) {
            return ;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.push(root);
        int nextLevel = 0;  //下一层节点的数目
        int toBePrinted = 1;    //本层还没有打印的节点的数目
        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.printf("%d", node.value);
            if(node.left != null) {
                queue.add(node.left);
                ++nextLevel;
            }
            if(node.right != null) {
                queue.add(node.right);
                ++nextLevel;
            }
            toBePrinted--;
            if(toBePrinted == 0) {
                System.out.print("\n");
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

    }
    
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}