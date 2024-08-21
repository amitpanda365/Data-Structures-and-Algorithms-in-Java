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

   public int tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m=triangle.get(n-1).size();
        int dp[][]=new int[n][m];
        for(int i=n-1; i>=0; i--){
            for(int j=--m; j>=0; j--){
                if(i==n-1){
                    dp[i][j] = triangle.get(i).get(j);
                }
                else{
                    int x = triangle.get(i).get(j);
                    int down = x + dp[i+1][j];
                    int downRight = x + dp[i+1][j+1];
                    dp[i][j] = Math.min(down, downRight);
                }
            }
        }
        return dp[0][0];
    }

   public int spaceOptimization(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m=triangle.get(n-1).size();
        int dp[]=new int[n];
        int temp[]=new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n-1).get(j);
        }
        temp = dp.clone();
        for(int i=n-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int x = triangle.get(i).get(j);
                int down = x + temp[j];
                int downRight = x + temp[j+1];
                dp[j] = Math.min(down, downRight);
            }
            temp = dp.clone();
        }
        return dp[0];
    }
}
