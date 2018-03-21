/**
 * 面试题51：数组中的逆序对
 * 归并排序
 */
public class InversePairs {
    public static int inversePairs(int[] data) {
        if(data == null || data.length < 0) {
            return 0;
        }
        int length = data.length;
        int[] copy = new int[length];
        for(int i = 0; i < length; i++) {
            copy[i] = data[i];
        }
        int count = inversePairsCore(data, copy, 0, length - 1);
        return count;
    }

    public static int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if(start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;

        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        //i初始化为前半端最后一个数字的下标
        int i = start + length;
        //j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + length + 1) {
            if(data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start -length;         //不太清楚为什么每次迭代加这个值 //懂了，归并时，左边队尾若大于右边队尾，则左边队尾元素和右边每个元素均构成
            
            }else {
                copy[indexCopy--] = data[j--];
            }
        }
        for(; i >= start; i--) {
            copy[indexCopy--] = data[i];
        }
        for(; j >= start + length + 1; j--) {
            copy[indexCopy--] = data[j];
        }
        return left + right + count;
    }

    public static void main(String[] args) {
        int[] data = {7,5,6,4};
        int result = inversePairs(data);
        System.out.println(result);
    }
}