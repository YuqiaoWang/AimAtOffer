/**
 * 面试题36：二叉搜索树与双向链表
 */
public class ConvertBinarySearchTree {
    public BinaryTreeNode convert(BinaryTreeNode rootOfTree) {
        BinaryTreeNode lastNodeInList = null;
        convertNode(rootOfTree, lastNodeInList);

        BinaryTreeNode headOfList = lastNodeInList;
        while(headOfList != null && headOfList.left != null) {
            headOfList = headOfList.left;
        }
        return headOfList;
    }

    public void convertNode(BinaryTreeNode node, BinaryTreeNode lastNodeInList) {
        if(node == null) {
            return ;
        }
        BinaryTreeNode current = node;

        if(current.left != null) {
            convertNode(current.left, lastNodeInList);
        }
        current.left = lastNodeInList;
        if(lastNodeInList != null) {
            lastNodeInList.right = current;
        }
        lastNodeInList = current;
        if(current.right != null) {
            convertNode(current.right, lastNodeInList);
        }


    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}
