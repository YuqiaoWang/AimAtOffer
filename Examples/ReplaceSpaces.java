
public class ReplaceSpaces {
    public static char[] replaceBlank(char[] s, int length) {
        if(s == null || length <= 0) {
            return null;
        }
        int originLength = 0;
        int numberOfBlank = 0;
        int i = 0;
        while(i < s.length) {
            originLength++;
            if(s[i] == ' ') {
                numberOfBlank++;
            }
            i++;
        }
        int newLength = originLength + numberOfBlank * 2;
        if(newLength > length) {
            return null;
        }

        int indexOfOriginal = originLength;
        int indexOfNew = newLength;
        while(indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
            if(s[indexOfOriginal] == ' ') {
                s[indexOfNew--] = '0';
                s[indexOfNew--] = '2';
                s[indexOfNew--] = '%';
            }else {
                s[indexOfNew--] = s[indexOfOriginal];
            }
            indexOfOriginal--;
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        char[] charArray = s.toCharArray();
        char[] newCharArray = new char[charArray.length + 4];
        for(int i = 0; i < charArray.length; i++) {
            newCharArray[i] = charArray[i];
        }

        newCharArray = replaceBlank(newCharArray, newCharArray.length);
        for(int i = 0; i < newCharArray.length; i++) {
            System.out.print(newCharArray[i]);
        }
        
    }
}