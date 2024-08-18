package dynamicProgramming;

import java.util.Arrays;

/*
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * 
 * 	Example 1:
	Input: m = 3, n = 7
	Output: 28
	
	Example 2:
	Input: m = 3, n = 2
	Output: 3
	Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	1. Right -> Down -> Down
	2. Down -> Down -> Right
	3. Down -> Right -> Down
 */

class UniquePath {

	public static void main(String[] args) {
		int x = 3, y = 7;
		int[][] dp = new int[x][y];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		System.out.println("Recursion "+uniquePath(x - 1, y - 1));
		System.out.println("Memoization "+uniquePathMemoization(x - 1, y - 1, dp));
		System.out.println("Tabulation "+uniquePathTabulation(x, y));
		System.out.println("Space Optimization "+uniquePathSpaceOptimized(x, y));
	}
	
	public static int uniquePath(int i, int j) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;

		int x = uniquePath(i, j - 1);
		int y = uniquePath(i - 1, j);

		return x + y;
	}

	public static int uniquePathMemoization(int i, int j, int[][] dp) {
		if (i == 0 && j == 0)
			return 1;
		if (i < 0 || j < 0)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int x = uniquePathMemoization(i, j - 1, dp);
		int y = uniquePathMemoization(i - 1, j, dp);

		return dp[i][j] = x + y;
	}

	public static int uniquePathTabulation(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else {
					int x = 0, y = 0;
					if (j - 1 >= 0)
						x = dp[i][j - 1];
					if (i - 1 >= 0)
						y = dp[i - 1][j];
					dp[i][j] = x + y;
				}
			}
		}
		return dp[m - 1][n - 1];
	}
	
	private static int uniquePathSpaceOptimized(int m, int n) {
		int[] dp = new int[n];
		int[] temp = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					dp[i] = 1;
				else {
					int x = 0, y = 0;
					if (j - 1 >= 0)
						x = dp[j - 1];
					if (i - 1 >= 0)
						y = temp[j];
					dp[j] = x + y;
				}
			}
			temp = dp;
		}
		return dp[n-1];
	}

}
