/*
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row. 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
*/

class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m=triangle.get(n-1).size();
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return min(0, 0, triangle, n-1, dp);
    }

    int min(int i, int j, List<List<Integer>> triangle, int n, int dp[][]){
        if(i == n)
            return triangle.get(i).get(j);
        if(dp[i][j] != -1)
            return dp[i][j];
        int down = triangle.get(i).get(j) + min(i+1, j, triangle, n, dp);
        int downRight = triangle.get(i).get(j) + min(i+1, j+1, triangle, n, dp);
        return dp[i][j] = Math.min(down, downRight);
    }
}
