
public class GetDuplication{
    /**
     * 面试题3-题目2：不修改数组找出重复数字
     */
    static int getDuplication(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while(end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = count(nums, start, middle);
            if(end == start) {
                if(count > 1) {
                    return start;
                }else {
                    break;
                }
            }
            if(count > (middle - start + 1)) {
                end = middle;
            }else {
                start = middle + 1;
            }
        }
        return -1;
    }

   static int count(int[] nums, int start, int end) {
        if(nums == null) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= end && nums[i] >= start){
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,4,3,2,6,7};
        int result = getDuplication(nums);
        System.out.println(result);
    }
}