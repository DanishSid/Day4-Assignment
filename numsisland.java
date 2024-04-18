public class numsisland {
    public static int numIslands(char[][] grid) {
        // Check if the grid is null or empty
        if (grid == null || grid.length == 0) {
            return 0; // If so, return 0 islands
        }

        int numIslands = 0; // Initialize the count of islands
        int rows = grid.length; // Get the number of rows in the grid
        int cols = grid[0].length; // Get the number of columns in the grid

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current cell is part of an unvisited island ('1'), increment the count of islands
                if (grid[i][j] == '1') {
                    numIslands++; // Increment the count of islands
                    // Use depth-first search (DFS) to mark all connected cells of the current island as visited
                    dfs(grid, i, j);
                }
            }
        }

        return numIslands; // Return the total count of islands
    }

    // Depth-first search (DFS) function to explore connected cells of an island
    private static void dfs(char[][] grid, int row, int col) {
        int rows = grid.length; // Get the number of rows in the grid
        int cols = grid[0].length; // Get the number of columns in the grid

        // Base cases:
        // If the current cell is out of bounds or if it is water ('0'), return
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark the current cell as visited by changing '1' to '0'

        // Recursively explore adjacent cells (up, down, left, right)
        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }

    public static void main(String[] args) {
        // Define the input grids
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        // Print the number of islands in each grid
        System.out.println(numIslands(grid1)); // Output: 1
        System.out.println(numIslands(grid2)); // Output: 3
    }
}

//Time complexity O(M*N)
//Space complexity O(M*N)