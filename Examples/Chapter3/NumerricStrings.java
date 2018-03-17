
/**
 * 面试题20：表示数值的字符串
 */
public class NumerricStrings {
    public static boolean isNumeric(char[] str) {
        if(str == null || str.length == 0) {
            return false;
        }
        int index = 0;
        int ecount = 0;
        int point = 0;
        if(str[0] == '-' || str[0] == '+') {
            index++;
        }
        for(int i = index; i < str.length; i++) {
            if(str[i] == '-' || str[i] == '+') {
                if(str[i-1] != 'e' || str[i-1] != 'E') {
                    return false;
                }
                continue;
            }
            if(str[i] == 'e' || str[i] == 'E') {
                ecount++;
                if(ecount > 1) {
                    return false;
                }
                if(i == 0 || str[i-1] < 48 || str[i-1] > 57 || i = str.length -1) {
                    return false;
                }
                point++;
                continue;
            }
            if(str[i] == '.') {
                point++;
                if(point > 1) {
                    return false;
                }
                continue;
            }
            if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E')) {
                return false;
            }

        }
        return true;
        
    }
    
}