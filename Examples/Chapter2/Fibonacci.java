public class Fibonacci {
    /**
     * 面试题10：斐波那契数列
     * 时间复杂度O(n)
     */
    static int fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int fibMinusTwo = 0;
        int fibMinusOne = 1;
        int fibN = 0;
        for(int i = 2; i <= n; i++) {
            fibN = fibMinusOne + fibMinusTwo;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibN;
        }
        return fibN;
    }
    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int n = 3;
        int result = fibonacci(n);
        System.out.println(result);
    }
}