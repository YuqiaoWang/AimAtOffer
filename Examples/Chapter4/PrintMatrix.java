//question 29
/**
 * 面试题29：顺时针打印矩阵
 */
public class PrintMatrix {
    public void printMatrixClockwisely(int[][] numbers, int columns, int rows) {
        if(numbers == null || columns <= 0 || rows <= 0) {
            return ;
        }

        int start = 0;

        while(columns > start * 2 || rows > start * 2) {
            printMatrixInCircle(numbers, columns, rows, start);
            start++;
        }
    }

    public void printMatrixInCircle(int[][] numbers, int columns, int rows, int start) {
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        for(int i = start; i <= endX; i++) {
            int number = numbers[start][i];
            System.out.print(number);
        }

        if(start < endY) {
            for(int i = start + 1; i <= endY; i++) {
                int number = numbers[i][endX];
                System.out.print(number);
            }
        }

        if(start < endX && start < endY) {
            for(int i = endX - 1; i >= start; i--) {
                int number = numbers[i][start];
                System.out.println(number);
            }
        }
    }
}