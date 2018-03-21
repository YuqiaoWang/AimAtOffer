/**
 * 面试题45：把数组排成最小的数
 * 
 * 思路：先将整型数组转换成String数组，然后将String数组排序，
 * 最后将排好序的字符串数组拼接出来。
 * 关键就是制定排序规则。
 * 或使用比较和快排的思想，将前面的数和最后的数比较，
 * 若小则放到最前面，最后再递归调用
 */
import java.util.Arrays;
import java.util.Comparator;

public class SortArrayForMinNumber {
    public static String PrintMinNumber(int[] numbers) {
        if(numbers == null || numbers.length == 0) {
            return "";
        }
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });

        for(int i = 0; i < len; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
    
}