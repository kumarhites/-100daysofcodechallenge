/*Day1**
 *  Input: matrix=[ [1,1,1]    
 *                  [1,0,1]
 *                  [1,1,1]
 *                ]

    Output: [[1,0,1]
             [0,0,0]
             [1,0,1]]

    Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.
 
    Input: matrix=[ [0,1,2,0]
                    [3,4,5,2]
                    [1,3,1,5]]

    Output:[
            [0,0,0,0]
            [0,4,5,0]
            [0,3,1,0]]

    Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
 */
package Day1;

import java.util.Arrays;

public class SetZerosOptimized {
    static void setZerosOptimized(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dummyRows[] = new int[rows];
        int dummyCols[] = new int[cols];
        Arrays.fill(dummyRows, -1);
        Arrays.fill(dummyCols, -1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummyRows[i] = 0;
                    dummyCols[j] = 0;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummyRows[i] == 0 || dummyCols[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    public static void print(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
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
        setZerosOptimized(matrix);
        print(matrix);
    }
}
