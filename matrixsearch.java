public class matrixsearch {
    public static boolean searchMatrix(int[][] matrix, int target) {
        // Check if the matrix is null or empty, or if it has zero columns
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false; // If any of the conditions are true, return false
        }

        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize the left and right pointers for binary search
        int left = 0;
        int right = rows * cols - 1; // Calculate the total number of elements in the matrix

        // Perform binary search
        while (left <= right) {
            // Calculate the middle index
            int mid = left + (right - left) / 2;
            // Calculate the value at the middle index in the matrix
            int midValue = matrix[mid / cols][mid % cols];

            // If the middle value is equal to the target, return true
            if (midValue == target) {
                return true;
            }
            // If the middle value is less than the target, search in the right half
            else if (midValue < target) {
                left = mid + 1; // Update the left pointer
            }
            // If the middle value is greater than the target, search in the left half
            else {
                right = mid - 1; // Update the right pointer
            }
        }

        // If the target is not found, return false
        return false;
    }

    public static void main(String[] args) {
        // Define the matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        // Define the target value to search for
        int target = 3;
        // Call the searchMatrix function and print the result
        System.out.println(searchMatrix(matrix, target)); // Output: true
    }
}

//Time complexity-O(log(m*n))
//Space complexity-O(1)

