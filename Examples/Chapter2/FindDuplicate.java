
public class FindDuplicate {
    /**
     * 面试题3-题目1：找到数组中重复数字
     */
    static boolean dumplicate(int[] nums) {
        if(num == null || nums.length == 0) {
            return false;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > nums.length - 1 || nums[i] < 0) {
                return false;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != i) {

                if(nums[i] == nums[nums[i]]) {
                    //在此处可扩展：定位重复的位置
                    return true;
                }

                int m = nums[i];
                int temp = nums[m];
                nums[m] = nums[i];
                nums[i] = temp;

            }
        } 
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        boolean dumplicate = dumplicate(nums);
        if(dumplicate) {
            System.out.println("dumplicate");
        }
        
        
    }
}