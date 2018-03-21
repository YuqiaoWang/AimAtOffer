/**
 * 面试题46：把数字翻译成字符串
 * 
 * 动态规划
 * f(i) = f(i+1) + g(i, i+1) * f(i + 2)
 * 从后往前递归
 * g(i, i+1) :当i,i+1组成的数字在10~25之间时，值为1；否则为0
 */
public class TranslateNumbersToStrings {
    public static int getTranslationCount(int n ) {
        if(n < 0) {
            return 0;
        }
        String ns = String.valueOf(n);
        return translation(ns);
    }

    public static int translation(String ns) {
        int len = ns.length();
        int[] sum = new int[ns.length];
        int count = 0;
        //从后往前递归查找
        for(int i = ns.length() - 1; i >= 0; i--) {
            count = 0;
            //如果当前处理的不是最后一位
            if(i < ns.length() - 1) {
                count = sum[i+1];
            }else {
                //最后一个
                count = 1;
            }
            //两位数可以合并
            if(i < ns.length() - 1) {
                //合并
                int first = ns.charAt(i) - '0';
                int second = ns.charAt(i+1) - '0';
                int combine = first * 10 + second;

                if(combine >= 10 && combine <= 25) {    //判断合并后的数字
                    if(i < ns.length() -2) {            //位于倒数第二位左边
                        count += sum[i+2];
                    }else {
                        count ++;
                    }
                }
            }
            sum[i] = count;
        }
        return sum[0];
    }
    
    
}