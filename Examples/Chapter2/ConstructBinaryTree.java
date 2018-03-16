/**
 * 面试题7：重建二叉树
 */

public class ConstructBinaryTree {
    static TreeNode construct(int[] preOrder, int[] inOrder) {
        TreeNode root = constructCore(preOrder, 0, preOrder.length - 1, 
            inOrder, 0, inOrder.length - 1);
        return root;
    }

    static TreeNode constructCore(int[] preOrder, int preStart, int preEnd,
        int[] inOrder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        for(int i = 0; i < inOrder.length; i++) {
            if(preOrder[0] == inOrder[i]) {
                root.left = constructCore(preOrder, preStart + 1, preStart + i - inStart, inOrder, inStart, i - 1);
                root.right = constructCore(preOrder, i - inStart + preStart + 1, preEnd, inOrder, i + 1, inEnd);
            }
        }
        return root;
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};

        TreeNode root = construct(preOrder, inOrder);
        traverse(root);

    }

    /**
     * 测试用例方法
     */
    static void traverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode() {

    }
    public TreeNode(int val) {
        this.val = val;
    }

}