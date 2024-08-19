/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
*/

class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        /*int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] a : dp)
            Arrays.fill(a, -1);*/
        return minTabulation(grid);
    }

  // Memoization
    private int min(int i, int j, int[][] grid, int[][] dp){
        if(i==0 && j==0)
            return grid[i][j];
        if(i<0 || j<0)
            return (int)Math.pow(10,9);
        if(dp[i][j] != -1)
            return dp[i][j];
        int up = grid[i][j] + min(i-1, j, grid, dp);
        int left = grid[i][j] + min(i, j-1, grid, dp);
        return dp[i][j] = Math.min(up, left);
    }

    public int minTabulation(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else{
                    int up = grid[i][j];
                    if(i > 0)
                        up += dp[i-1][j];
                    else
                        up += (int) Math.pow(10, 9);
                
                    int left = grid[i][j];
                    if(j > 0)
                        left += dp[i][j-1];
                    else
                        left += (int) Math.pow(10, 9);
               
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
