package Day1;

public class SerZerosBetterOptimized {

    public static void setZerosBetterOptimized(int[][] matrix) {
        // using the topmost row and leftmost col as dummy array
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        // traversing the matrix
        for (int i = 0; i < rows; i++) {
            // setting the [0,0] position value in avariable so that it doesn't mess with
            // row
            if (matrix[i][0] == 0)
                col0 = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][0] == 0)
                    col0 = 0;
            }
        }
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 1, 2, 2 },
                { 3, 2, 0, 2 },
                { 1, 3, 1, 5 }
        };
        setZerosBetterOptimized(matrix);
        print(matrix);
    }
}
