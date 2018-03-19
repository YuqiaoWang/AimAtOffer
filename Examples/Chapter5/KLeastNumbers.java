/**
 * 面试题40：最小的k个数
 */
public class KLeastNumbers {

    //-------------------------方法1：快速排序--------------------------
    public void getLeastNumber(int[] input, int[] output, int k) {
        if(input == null || output == null || k > input.length || input.length <= 0 || k <= 0) {
            return ;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(intput, start, end);
        while(index != k - 1) {
            if(index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            }else {
                start = index + 1;
                index = partition(input, start, end);
            }
        }
        for(int i = 0; i < k; i++) {
            output[i] = input[i];
        }
    }

    /**
     * 快速排序的核心部分，先选一个数字，把比该数小的放左边，大的放右边
     * 本实现方法用了3个指针：基准，low,high
     * 基准选择开头数据
     */
    public static int partition(int[] data, int start, int end) {
        int flag = start;
        int middleValue = data[flag];  //选基准
        while(start < end) {
            while(data[end] >= middleValue && start < end) {
                end--;
            }
            while(data[start] <= middleValue && start < end) {
                start++;
            }
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
        }
        int temp = data[flag];
        data[flag] = data[start];
        data[start] = temp;

        return start;
    }

    //----------------------------------------------------------------

    //--------------------------方法2：堆排序--------------------------
    public static void buildMaxHeap(int[] data, int lastIndex) {
        for(int i =(lastIndex - 1)/2; i >= 0; i--) {
            int k = i;
            while(2 * k + 1 <= lastIndex) {
                int biggerIndex = 2 * k + 1；
                if(biggerIndex < lastIndex) {
                    if(data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                if(data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 对k个目前的最小数做堆排序
     */
    public static void heapSort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            buildMaxHeap(array, array.length - 1);
            swap(data, 0, array.length - 1);
        }
    }

    public static void getLeastNumbers(int[] data, int k) {
        if(data == null || k < 0 || k > data.length) {
            return ;
        }
        //根据输入数组前k个树建立最大堆
        //从k+1个数开始与根结点比较
        //大于根节点，舍去
        //小于，取代根节点，建立最大堆
        int[] kArray = Arrays.copyOfRange(data, 0, k);
        heapSort(kArray);
        for(int i = k; i < data.length; i++) {
            if(data[i] < kArray[k - 1]) {
                kArray[k - 1] = data[i];
                heapSort(kArray);
            }
        }
        for(int i : kArray) {
            System.out.println(i);
        }
    }
}