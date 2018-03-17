/**
 * 面试题15：二进制中1的个数
 * 位运算
 */

public class NumberOf1InBinary {
    public static int numberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        int result = numberOf1(12);
        System.out.println(result);
    }
}