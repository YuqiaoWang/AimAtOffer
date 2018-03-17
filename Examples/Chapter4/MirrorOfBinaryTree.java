//question 27
public class MirrorOfBinaryTree {
    /**
     * 面试题27：二叉树的镜像
     * 先遍历每个节点，如果节点有子节点，交换两个子节点
     * 当交换完所有非叶节点的左右孩子后，得到树的镜像
     */
    public void mirrorRecursively(BinaryTreeNode node) {
        if(node == null) {
            return ;
        }
        if(node.left == null && node.right == null) {
            return ;
        }
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if(node.left != null) {
            mirrorRecursively(node.left);
        }
        if(node.right != null) {
            mirrorRecursively(node.right);
        }
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}