/**
 * 面试题48：最长不含重复字符的子字符串
 * f(i) = f(i-1)+1  第i个字符未出现过
 * f(i) = d         第i个字符出现过，且d<=f(i-1)
 * f(i) = f(i-1)+1  第i个字符出现过，且d>f(i-1)
 */
public class LongestSubstringWithoutDup {
    public static int longestSubString(String str) {
        int max = 0;                    //目前为止最长字符串长度
        int count = 0;                  //当前子字符串长度
        int[] position = new int[26];   //每个字母上次在字符串中出现的位置
        for(int i = 0; i < 26; i++) {
            position[i] = -1;           //位置初始化
        }
        for(int i = 0; i< str.length(); i++) {
            int prevIndex = position[str.charAt(i) - 'a'];  //取出上次出现的位置
            if(prevIndex < 0 || i - prevIndex > count) {    //若字符未出现过，或d>f(i-1)
                count++;                                    //更新count
            }else {                                         //字符出现过，且d<=f(i-1)
                max = Math.max(max, count);
                count = i - prevIndex;                      //更新count
            }
            position[str.charAt(i) - 'a'] = i;              //更新上次出现的位置
        }
        return Math.max(max, count);
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        int result = longestSubString(str);
        System.out.println(result);
    }
    
}