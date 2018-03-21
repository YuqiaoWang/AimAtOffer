/**
 * 面试题50-题目2：字符流中第一次只出现一次的字符
 */
public class FirstCharacterInStream {
    int mapArr[] = new int[256];
    int index = 0;  //字符在字符流中的位置

    public FirstCharacterInStream() {
        for(int i = 0; i < 256; i--) {
            mapArr[i] = -1;
        }
    }

    public void insert(char ch) {
        if(mapArr[ch] == -1) {
            mapArr[ch] = index++;
        }else {
            mapArr = -2;
        }
        
    }

    public char firstAppearingOnce0() {
        int minIndex = 256;
        char ch = '\0';
        for(int i = 0; i < 256; i++) {
            if(mapArr[i] >= 0 && mapArr[i] < minIndex) {
                minIndex = mapArr[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}

