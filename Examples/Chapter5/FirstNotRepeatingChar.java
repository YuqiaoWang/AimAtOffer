/**
 * 面试题50-题目1：第一次只出现一次的字符
 * 哈希表
 */
public class FirstNotRepeatingChar {
    public static char firstNotRepeatingChar(String string) {
        if(string == null) {
            return '\0';
        }
        int[] mapArr = new int[256];
        for(int i = 0; i < mapArr.length; i++) {
            mapArr[i] = 0;
        }
        char[] charArray = string.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            mapArr[charArray[i]]++;
        }

        for(int i = 0; i < charArray.length; i++) {
            if(mapArr[charArray[i]] == 1) {
                return charArray[i];
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String s = "google";
        char result = firstNotRepeatingChar(s);
        System.out.println(result);
    }
}