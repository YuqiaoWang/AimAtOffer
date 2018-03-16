/**
 * 面试题8：二叉树的下一个节点
 */

 public class NextNodeInBinaryTrees {
    public TreeLinkNode getNext(TreeLinkNode node) {
        if(node == null) {
            return null;
        }
        // 如果有右子树，则找右子树的最左节点
        if(node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 非根结点，并且没有右子树
        while(node.father != null) {
            //找到第一个节点是其父亲的左孩子
            if(node.father.left == node) {
                return node.father;
            }
            node = node.father;
        }
        // 是根结点且没有左子树
        return null;
    }
 }

 class TreeLinkNode {  
    int val;  
    TreeLinkNode left = null;  
    TreeLinkNode right = null;  
    // 父节点  
    TreeLinkNode father = null;  
  
    TreeLinkNode(int val) {  
        this.val = val;  
    }  
} 