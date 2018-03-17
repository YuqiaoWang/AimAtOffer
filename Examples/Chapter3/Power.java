/**
 * 面试题16：数值的整数次方
 * 位运算、递归
 * a^n = a^{n/2} * a^{n/2} (n为偶数)
 * a^n = a^{(n-1)/2} * a^{(n-1)/2} * a (n为基数)
 */
public class Power {
    public static double powerWithExponent(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }

        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        if((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        double result = powerWithExponent(2, 7);
        System.out.println(result);
    }
}
