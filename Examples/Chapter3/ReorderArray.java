public class ReorderArray{
    /**
     * 面试题21：调整数组顺序使奇数位于偶数前面
     */
    static void reorder(int[] data) {
        if(data == null || data.length == 0) {
            return ;
        }
        int start = 0;
        int end = data.length - 1;
        while(start < end) {
            while(start < end && data[start] % 2 == 1) {
                start++;
            }
            while(start < end && data[end] % 2 == 0) {
                end--;
            }
            if(start < end) {
                int temp = data[start];
                data[start] = data[end];
                data[end] = temp;
            }
        }
    }
}