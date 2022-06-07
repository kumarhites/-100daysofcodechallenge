package Day1;

// import Day1.setZerosOptimized;
public class SetZeros {
    public static void setZeros(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    int index = i - 1;
                    while (index >= 0) {
                        if (matrix[index][j] != 0)
                            matrix[index][j] = -1;
                        index--;
                    }
                    index = i + 1;
                    while (index < rows) {
                        if (matrix[index][j] != 0)
                            matrix[index][j] = -1;
                        index++;
                    }
                    index = j - 1;
                    while (index >= 0) {
                        if (matrix[i][index] != 0)
                            matrix[i][index] = -1;
                        index--;
                    }
                    index = j + 1;
                    while (index < cols) {
                        if (matrix[i][index] != 0)
                            matrix[i][index] = -1;
                        index++;
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < 0)
                    matrix[i][j] = 0;
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
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 }
        };
        setZeros(matrix);
        print(matrix);
    }

}