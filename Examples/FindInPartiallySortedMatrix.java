
public class FindInPartiallySortedMatrix {
    public static boolean find(int[][] matrix, int rows, int columns, int number) throws Exception{
        boolean found = false;
        if(rows <= 0 || columns <= 0) {
            throw new Exception("unvalid");
        }
        int row = 0;
        int column = columns - 1;
        while(row < rows && column >= 0) {
            if(matrix[row][column] == number) {
                return true;
            }else if(matrix[row][column] > number) {
                column--;
            }else {
                row++;
            }
        
        }
        return found;
    }

    public static void main(String[] args) throws Exception{
        int[][] maxtrix = {{1, 2, 8, 9}, 
                        {2, 4, 9, 12}, 
                        {4, 7, 10, 13}, 
                        {6, 8, 11, 15}};
        System.out.println(find(maxtrix, 4, 4, 7));

        /*
        int l = 1;
        String s1 = "hehe" + l;
        String s2 = "hehe" + l;
        System.out.println(s1 == s2);
        */
    }
}