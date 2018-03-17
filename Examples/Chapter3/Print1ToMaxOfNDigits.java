 /**
  * 面试题17：打印从1到最大的n位数
 * Print1ToMaxOfNDigits
 */
public class Print1ToMaxOfNDigits {
    public static void  print1toMax(int n) {
        if(n <= 0) {
            return ;
        }
        char[] number = new char[n];
        for(int i = 0; i< 10; i++) {
            number[0] = (char)(i + '0');
            printRecursively(number, 0);
        }
    }

    public static void printRecursively(char[] number, int index) {
        if(index == number.length - 1) {
            System.out.println(String.valueOf(number));
            return ;
        }
        for(int i = 0; i< 10; i++) {
            number[index + 1] =(char) (i +'0');
            printRecursively(number, index + 1);
        }
    }

    public static void main(String[] args) {
        print1toMax(2);
    }
    
}