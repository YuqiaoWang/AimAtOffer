//question 28
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    public boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 ==null || root2 == null) {
            return false;
        }
        if(root1.value != root2.value) {
            return false;
        }
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}