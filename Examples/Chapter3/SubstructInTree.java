
public class SubstructInTree {
    /**
     * 面试题26：树的子结构
     */
    public boolean hasSubtree(BinaryTree root1, BinaryTree root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(equal(root1.value, root2.value)) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result) {
                result = hasSubtree(root1.left, root2);
            }
            if(!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HaveTree2(BinaryTree root1, BinaryTree root2) {
        if(root2 == null) {
            return true;
        }
        if(root1 == null) {
            return false;
        }
        if(!equal(root1.value, root2.value)) {
            return false;
        }

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }

    public boolean equal(double num1, double num2) {
        if(Math.abs(num1 - num2) < 0.00000001) {
            return true;
        }else {
            return false;
        }
    }
}

class BinaryTree {
    double value;
    BinaryTree left;
    BinaryTree right;
}