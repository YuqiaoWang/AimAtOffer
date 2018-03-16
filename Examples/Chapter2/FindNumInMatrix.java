public class FindNumInMatrix {
    //面试题4：二维数组中的查找
    static boolean find(int[][] matrix, int number) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;

        while(col >= 0 && row < rows) {
            if(matrix[row][col] == number) {
                return true;
            }else if(matrix[row][col] > number) {
                col--;
            }else{
                row++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result = find(matrix, 7);
        System.out.println(result);
    }
}