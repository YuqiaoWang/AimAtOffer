


public class MoreThanHalfNumber {
    public static int morethanHalfNum(int[] data) {
        if(data == null || data.length == 0) {
            return 0;
        }
        
        int length = data.length;
        int middle = length >> 1;
        int start = 0;
        int end = length - 1;
        int index = partition(data, start, end);    //拿到第一次快排的基准下标
        while(index != middle) {
            if(index > middle) {
                end = index - 1;
                index = partition(data, start, end);
            }else {
                start = index + 1;
                index = partition(data, start, end);
            }
        }
        int result = data[middle];
        //此处应检测输入的数组是否是有个数字长度大于一半的
        //if(checkMoreThanHalf(data, result)) {
        //    result = 0;    
        //}
        return result;

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

    public static void main(String[] args) {
        int[] data = {1,2,3,2,2,2,5,4,2};
        int result = morethanHalfNum(data);
        System.out.println(result);
    }

    /*
    //方法二
    public int morethanHalfNum(int[] numbers, int length) {
        if(numbers.length <= 0) {
            return 0;
        }
        int res = numbers[0];
        int times = 1;
        for(int i = 1; i < numbers.length; i++) {
            if(times == 0) {
                res = numbers[i];
                times = 1;
            }else if(numbers[i] == res) {
                times++;
            }else {
                times--;
            }
        }
        times = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(res == numbers[i]) {
                times++;
            }
        }
        if(times * 2 > numbers.length) {
            return res;
        }else {
            return 0;
        }
    }*/
}