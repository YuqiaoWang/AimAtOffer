import java.util.Arrays;

//question 33
public class SquenceOfBST{
    /**
     * 面试题33：二叉搜索树后序遍历序列
     * 后序遍历最后一个数是root
     * 数组分为比root.value小的和比root.value大的
     * 然后递归
     */
    public boolean verifySequenceOfBST(int[] sequence) {
        if(sequence == null || sequence.length == 0) {
            return false;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int cut = 0;
        for(int i = 0; i < length - 1; i++) {
            if(sequence[i] > root) {
                cut = i;
                break;
            }
        }

        int j = cut;    //  找到两部分分割点
        for(; j < length - 1; j++) {
            if(sequence[j] < root) {
                return false;
            }
        }

        boolean left = true;
        if(cut > 0) {
            left = verifySequenceOfBST(Arrays.copyOfRange(sequence, 0, cut));
        }

        boolean right = true;
        if(cut < length -1) {
            right = verifySequenceOfBST(Arrays.copyOfRange(sequence, cut, length - 1));
        }
        return left && right;
    }
} 