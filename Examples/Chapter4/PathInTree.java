import java.util.Stack;

/**
 * 面试题34：二叉树中的和为某一值的路径
 */
public class PathInTree {
    public void findPath(BinaryTreeNode root, int sum) {
        if(root == null) {
            return ;
        }
        Stack<Integer> stack = new Stack<>();
        int currentSum = 0;
        findPath(root, sum, stack, currentSum);
    }

    public void findPath(BinaryTreeNode root, int sum, 
        Stack<Integer> stack, int currentSum) {
        currentSum += root.value;
        stack.push(root.value);
        if(root.left == null && root.right == null) {   //如果是叶子节点
            if(currentSum == sum) {         //且该路径上节点的值之和等于输入的值
                System.out.println("find a valid path");    //打印路径
                for(int path : stack) {
                    System.out.print(path + " ");
                }
            }
            System.out.println();
        }
        if(root.left != null) {     //如果不是叶子节点，则遍历它的子节点
            findPath(root.left, sum, stack, currentSum);
        }
        if(root.right != null) {
            findPath(root.right, sum, stack, currentSum);
        }
        //在返回父系欸但前，在路径上删除当前节点
        stack.pop();
    }
}



class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}