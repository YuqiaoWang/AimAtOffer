/**
 * 面试题47：礼物的最大价值
 * 动态规划
 * f(i，j) = max{f(i-1, j) ， f(i, j-1)} + gift[i, j]
 * 本例中构造的二维数组可以优化成一个一维数组
 * 
 */
public class MaxValueOfGifts {
    public static int getMaxValue(int[][] values) {
        if(values == null || values.length <= 0 || values[0].length <= 0) {
            return 0;
        }
        int rows = values.length;
        int cols = values[0].length;
        int[][] maxValues = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if(i > 0) {
                    up = maxValues[i - 1][j];
                }
                if(j > 0) {
                    left = maxValues[i][j - 1];
                }
                maxValues[i][j] = Math.max(left, up) + values[i][j];

            }
        }
        int maxValue = maxValues[rows - 1][cols - 1];
        return maxValue;
    }

    public static void main(String[] args) {
        int[][] values = {{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}};
        int result = getMaxValue(values);
        System.out.println(result);
    }
}