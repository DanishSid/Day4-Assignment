public class rotateimage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length; // Get the size of the matrix (assuming it's a square matrix)

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of the transposed matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap elements symmetrically across the middle column
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // Define matrices to be rotated
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        // Rotate both matrices
        rotate(matrix1);
        rotate(matrix2);

        // Output the rotated matrices
        System.out.println("Rotated Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Rotated Matrix 2:");
        printMatrix(matrix2);
    }

    // Helper method to print the matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

//Time complexity-O(n*n)
//Space complexity-O(1)