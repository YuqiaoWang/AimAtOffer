public class MinNumberInRotatedArray {
    //面试题11：旋转数组中的最小数字
    static int min(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int front = 0;
        int end = nums.length - 1;
        int middle = 0;
        while(nums[front] >= nums[end]) {
            if(end - front == 1) {
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

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int result = min(nums);
        System.out.println(result);
    }
}