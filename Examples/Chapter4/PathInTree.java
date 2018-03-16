import java.util.Stack;

//question 34
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
        if(root.left == null && root.right == null) {
            if(currentSum == sum) {
                System.out.println("find a valid path");
                for(int path : stack) {
                    System.out.print(path + " ");
                }
            }
            System.out.println();
        }
        if(root.left != null) {
            findPath(root.left, sum, stack, currentSum);
        }
        if(root.right != null) {
            findPath(root.right, sum, stack, currentSum);
        }
        stack.pop();
    }
}



class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}