public class arrayelements {
    public static void printArray(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;

        // Initialize directions for clockwise and anti-clockwise traversals
        int[] clockwiseDirections = {0, 1, 1, 0, 0, -1, -1, 0};
        int[] anticlockwiseDirections = {0, -1, -1, 0, 0, 1, 1, 0};

        // Start position for both traversals
        int cwRow  = 0, cwCol  = 0;
        int acwRow = 0, acwCol = 0;

        // Variable to alternate between clockwise and anticlockwise-traversal
        boolean clockwise = true;

        // Loop until all elements are printed
        while (cwRow < rowCount || acwRow < rowCount) {
            // Print elements for clockwise traversal
            while (isValid(cwRow, cwCol, rowCount, colCount)) {
                System.out.print(arr[cwRow][cwCol] + " ");
                cwRow += clockwiseDirections[0];
                cwCol += clockwiseDirections[1];
            }

            // Print elements for anti-clockwise traversal
            while (isValid(acwRow, acwCol, rowCount, colCount)) {
                System.out.print(arr[acwRow][acwCol] + " ");
                acwRow += anticlockwiseDirections[0];
                acwCol += anticlockwiseDirections[1];
            }

            // Update starting position for next iteration
            cwRow += clockwiseDirections[2];
            cwCol += clockwiseDirections[3];
            acwRow += anticlockwiseDirections[2];
            acwCol += anticlockwiseDirections[3];

            // Toggle between clockwise and anti-clockwise traversals
            clockwise = !clockwise;
        }
    }

    private static boolean isValid(int row, int col, int rowCount, int colCount) {
        return row >=0  && row < rowCount && col >= 0 && col < colCount;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        printArray(arr);
    }
}




//Approach:
//The function printArray takes a 2D array as input and iterates over its elements in a spiral order.
//It initializes two sets of directions for clockwise and anticlockwise traversals.
//Starting from the top-left corner of the array, it iterates through the array elements in a spiral manner, printing them as it goes.
//It alternates between clockwise and anticlockwise traversals on each iteration until all elements are printed.

//Time Complexity- O(mn)
//Space Complexity-O(1)