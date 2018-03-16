/**
     * 面试题12：矩阵中的路径
     * 回溯法
     */
import java.util.Arrays;
public class StringPathInMatrix {
    public static boolean hasPath(char[][] matrix, String str) {
        if(str == null || matrix == null || 
            matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int pathLength = 0;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(hasPathCore(matrix, row, col, 
                    str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static bool hasPathCore(char[][] matrix, int row, int col, 
            String str, int pathLength, boolean[][] visited) {
        if(str.charAt(pathLength) == '\0') {
            return true;
        }
        boolean hasPath = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(row >= 0 && row < rows && col >= 0 && col < cols && 
                matrix[row][col] == str.charAt(pathLength) && !visited[row][col]) {
            ++pathLength;
            visited[row][col] == true;

            hasPath = hasPathCore(matrix, row, col - 1, str, pathLength, visited) || 
            hasPathCore(matrix, row, col + 1, str, pathLength, visited) || 
            hasPathCore(matrix, row + 1, col, str, pathLength, visited) || 
            hasPathCore(matrix, row - 1, col, str, pathLength, visited);
            if(!hasPath) {
                --pathLength;
                visited[row][col] = false;
            }
        }
        return hasPath;
        
    }
}