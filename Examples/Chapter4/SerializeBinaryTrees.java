/**
 * 面试题37：序列化二叉树
 */
public class SerializeBinaryTrees {
    int index = -1;
    public String serialize(BinaryTreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.value + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public BinaryTreeNode deserialize(String str) {
        index++;
        int len = str.length();
        if(index >= len) {
            return null;
        }
        String[] strr = str.split(",");
        BinaryTreeNode node = null;
        if(!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }
}

class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;
}