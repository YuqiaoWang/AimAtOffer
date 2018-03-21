/**
 * 面试题53-1：数字在排序数组中出现的次数
 */
public class NumberOfK {
    public static int getNumberOfK(int[] data, int k) {
        int number = 0;
        if(data == null || data.length == 0) {
            return -1;
        }
        int first = getFirstK(data, k, 0, data.length - 1);
        int last = getLastK(data, k, 0, data.length - 1);
        System.out.println(first);
        System.out.println(last);
        if(first > -1 && last > -1) {
            number = last - first + 1;
        }
        return number;
    }

    public static int getFirstK(int[] data, int k, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middleIndex = ((end - start) >> 1) + start;
        if(data[middleIndex] == k) {    //中间数等于k
            if(middleIndex > 0 && data[middleIndex - 1] != k || middleIndex == 0) { //是否为数列首 或 是否为第一个k
                return middleIndex;
            }else {
                end = middleIndex - 1;
            }
        }else if(middleIndex > k) {
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getFirstK(data, k, start, end);
    }


    public static int getLastK(int[] data, int k, int start, int end) {
        if(start > end) {
            return -1;
        }
        int middleIndex = ((end - start) >> 1) + start;
        if(data[middleIndex] == k) {    //中间数等于k
            if(middleIndex < data.length - 1 && data[middleIndex + 1] != k || 
                middleIndex == data.length - 1) { //是否为数列尾 或 是否为最后一个k
                return middleIndex;
            }else {
                start = middleIndex + 1;
            }
        }else if(middleIndex > k) {
            end = middleIndex - 1;
        }else {
            start = middleIndex + 1;
        }
        return getFirstK(data, k, start, end);
    }
    

    public static void main(String[] args) {
        int[] data = {1,2,3,3,3,3,4,5};
        int result = getNumberOfK(data, 3);
        System.out.println(result);
    }
}