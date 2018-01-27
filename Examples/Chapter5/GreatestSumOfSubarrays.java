//question 42

public class GreatestSumOfSubarrays {
    public static int findGreatestSumOfSubarrays(int[] data) throws Exception{
        if(data == null || data.length == 0) {
            throw new Exception("invalid");
        }
        if(data.length == 1) {
            return data[0];
        }
        int length = data.length;
        int max = data[0];
        int sum = data[0];
        for(int i = 1; i < length; i++) {
            if(sum <= 0) {
                sum = data[i];
            }else {
                sum += data[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) throws Exception{
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int result = findGreatestSumOfSubarrays(data);
        System.out.println(result);
    }
}