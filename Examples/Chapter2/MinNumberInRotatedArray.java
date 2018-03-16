public class MinNumberInRotatedArray {
    /**
     * 面试题11：旋转数组中的最小数字
     * 二分查找
     * 【变式】：在一个旋转数组中查找某个值 （LeetCode 33）
     */
    static int min(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int front = 0;
        int end = nums.length - 1;
        int middle = 0;
        while(nums[front] >= nums[end]) {   //front总指向前面递增数组元素，end总指向后面递增数组元素
            if(end - front == 1) {  //循环结束条件：两个指针指向相邻元素，end为最小元素
                middle = end;
                break;
            }
            middle = ((end - front) >> 1) + front;

            if(nums[middle] > nums[front]) {
                front = middle;
            }else if(nums[middle] < end) {
                end = middle;
            }
        }

        return nums[middle];
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int result = min(nums);
        System.out.println(result);
    }
}