/**
 * 面试题49：丑数
 * 空间换时间
 */
public class UglyNumber {
    public static int getUglyNumber(int index) {
        if(index <= 0) {
            return 0;
        }
        //辅助数组
        int[] uglyArray = new int[index];
        //第一个丑数1
        uglyArray[0] = 1;
        //下一个丑数的位置
        int nextUgly = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int ugly2 = uglyArray[index2];
        int ugly3 = uglyArray[index3];
        int ugly5 = uglyArray[index5];
        //找到的丑数还不满足要求
        while (nextUgly < index) {
            int min = min(ugly2 * 2, ugly3 * 3, ugly5 * 5);
            uglyArray[nextUgly] = min;

            while(uglyArray[index2] * 2 <= uglyArray[nextUgly]) {
                ugly2 = uglyArray[++index2];
            }

            while(uglyArray[index3] * 3 <= uglyArray[nextUgly]) {
                ugly3 = uglyArray[++index3];
            }

            while(uglyArray[index5] * 5 <= uglyArray[nextUgly]) {
                ugly5 = uglyArray[++index5];
            }

            ++nextUgly;
        }
        return uglyArray[nextUgly - 1];
    }


    public static int minInThree(int num1, int num2, int num3) {
        int min = (num1 < num2) ? num1 : num2;
        min = (min < num3) ? min : num3;
        return min;
    }
    
}