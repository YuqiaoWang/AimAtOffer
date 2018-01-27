


public class MoreThanHalfNumber {
    public int morethanHalfNum(int[] numbers, int length) {
        if(numbers.length <= 0) {
            return 0;
        }
        int res = numbers[0];
        int times = 1;
        for(int i = 1; i < numbers.length; i++) {
            if(times == 0) {
                res = numbers[i];
                times = 1;
            }else if(numbers[i] == res) {
                times++;
            }else {
                times--;
            }
        }
        times = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(res == numbers[i]) {
                times++;
            }
        }
        if(times * 2 > numbers.length) {
            return res;
        }else {
            return 0;
        }
    }
}