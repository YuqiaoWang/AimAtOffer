//question 28
public class SymmetricalBinaryTree {
    /**
     * 面试题28：对称的二叉树
     * 对称遍历，如果两次遍历相同，则为对称二叉树
     */
    public boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    public boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.value != root2.value) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}